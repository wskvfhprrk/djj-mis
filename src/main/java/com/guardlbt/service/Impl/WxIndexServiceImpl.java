package com.guardlbt.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guardlbt.common.util.Result;
import com.guardlbt.dao.*;
import com.guardlbt.dto.ReportSiteSaveDto;
import com.guardlbt.dto.UseCouponDto;
import com.guardlbt.entity.*;
import com.guardlbt.eum.OperationTypeEnum;
import com.guardlbt.https.HttpsUtil;
import com.guardlbt.service.WxIndexService;
import com.guardlbt.vo.*;
import com.guardlbt.wx.WxConfigurationProperties;
import com.guardlbt.wx.vo.Code2SessionVo;
import com.guardlbt.wx.vo.GetAccessTokenVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class WxIndexServiceImpl implements WxIndexService {

    public static final String ACCESS_TOKEN = "access_token";
    @Autowired
    private WxConfigurationProperties properties;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private CouponStockDao couponStockDao;
    @Autowired
    private MemberOperationHistoryDao memberOperationHistoryDao;
    @Autowired
    private ReportSiteDao reportSiteDao;
    @Autowired
    private IndexImagesDao indexImagesDao;
    @Autowired
    private IndexCouponDao indexCouponDao;
    @Autowired
    private IndexShopDao indexShopDao;
    @Autowired
    private ShopDao shopDao;
    @Autowired
    private CouponDao couponDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private CouponHistoryDao couponHistoryDao;

    @Override
    public Result<String> login(String code) {
        try {
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
            url = url.replace("APPID", properties.getAppID()).replace("SECRET", properties.getAppSecret()).replace("JSCODE", code);
            String s = HttpsUtil.send(url, HttpsUtil.get, null);
            Code2SessionVo vo = objectMapper.readValue(s, Code2SessionVo.class);
            if (vo.getErrcode() == null) {
                return Result.ok(vo.getOpenid());
            } else {
                return Result.error(vo.getErrcode(), vo.getErrmsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(500, "程序出错");
        }
    }

    @Override
    public GetAccessTokenVo getAccessToken() throws Exception {
        //先到缓存中取，如果没有再去微信后台换取
        Object o = redisTemplate.opsForValue().get(ACCESS_TOKEN);
        if (o != null) {
            GetAccessTokenVo accessTokenVo = (GetAccessTokenVo) o;
            accessTokenVo.setExpires_in(redisTemplate.opsForValue().getOperations().getExpire(ACCESS_TOKEN));
            return accessTokenVo;
        }
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
        url = url.replace("APPID", properties.getAppID()).replace("APPSECRET", properties.getAppSecret());
        String s = HttpsUtil.send(url, HttpsUtil.get, null);
        GetAccessTokenVo vo = objectMapper.readValue(s, GetAccessTokenVo.class);
        if (vo.getErrcode() == null) {
            redisTemplate.opsForValue().set(ACCESS_TOKEN, vo, vo.getExpires_in() - 10, TimeUnit.SECONDS);
        }
        return vo;
    }

    @Override
    public Result reportSite(ReportSiteSaveDto reportSiteSaveDto) {
        ReportSite reportSite = new ReportSite();
        BeanUtils.copyProperties(reportSiteSaveDto, reportSite);
        reportSiteDao.insert(reportSite);
        return Result.ok();
    }

    @Override
    public Result<IndexImagesPageVo> getIndexImage() {
        List<IndexImagesPageVo> list = indexImagesDao.selectIndexImagess(
                new IndexImages()).stream().map(indexImage -> {
            IndexImagesPageVo vo = new IndexImagesPageVo();
            BeanUtils.copyProperties(indexImage, vo);
            return vo;
        }).collect(Collectors.toList());
        return Result.ok(list);
    }

    @Override
    public Result<ShopPageVo> indexShop() {
        List<ShopPageVo> collect = indexShopDao.selectIndexShops(new IndexShop()).stream().sorted(Comparator.comparing(IndexShop::getSorting)).map(indexShop -> {
            ShopPageVo vo = new ShopPageVo();
            Shop shop = new Shop();
            shop.setShopId(indexShop.getShopId());
            List<Shop> shops = shopDao.selectShops(shop);
            if (!shops.isEmpty()) {
                BeanUtils.copyProperties(shops.get(0), vo);
                vo.setStartTime(shops.get(0).getStartTime().toString());
                vo.setStopTime(shops.get(0).getStopTime().toString());
            }
            return vo;
        }).collect(Collectors.toList());
        return Result.ok(collect);
    }

    @Override
    public Result<CouponPageVo> indexCoupon(String openid) {
        List<CouponPageVo> collect = indexCouponDao.selectIndexCoupons(new IndexCoupon()).stream()
                .sorted(Comparator.comparing(IndexCoupon::getSorting)).map(indexCoupon -> {
                    CouponPageVo vo = new CouponPageVo();
                    Coupon coupon = new Coupon();
                    coupon.setCouponId(indexCoupon.getCouponId());
                    List<Coupon> coupons = couponDao.selectCoupons(coupon);
                    if (!coupons.isEmpty()) {
                        BeanUtils.copyProperties(coupons.get(0), vo);
                    }
                    //查询代金券所属商铺
                    Shop shop = new Shop();
                    shop.setShopId(coupons.get(0).getShopId());
                    List<Shop> shops = shopDao.selectShops(shop);
                    if (!shops.isEmpty()) {
                        vo.setShopName(shops.get(0).getName());
                    }
                    //查询是否还有
                    CouponStock couponStock = new CouponStock();
                    couponStock.setCouponId(coupons.get(0).getCouponId());
                    List<CouponStock> couponStocks = couponStockDao.selectCouponStocks(couponStock);
                    long count = couponStocks.stream().filter(c -> c.getMemberId() == null).count();
                    if (count > 0) {
                        vo.setIsOver(true);
                    }
                    //查询是否已领
                    Member member = new Member();
                    member.setMemberId(openid);
                    List<Member> members = memberDao.selectMembers(member);
                    if (!members.isEmpty()) {
                        couponStock.setMemberId(members.get(0).getMemberId());
                        couponStocks = couponStockDao.selectCouponStocks(couponStock);
                        if (couponStocks.isEmpty()) {
                            vo.setIsReceive(true);
                        }
                    }
                    return vo;
                }).collect(Collectors.toList());
        return Result.ok(collect);
    }

    @Override
    public Result<ShopVo> shopInfo(String shopId) {
        Shop shop = new Shop();
        shop.setShopId(shopId);
        List<Shop> shops = shopDao.selectShops(shop);
        if (shops.isEmpty()) {
            return Result.ok();
        }
        ShopVo vo = new ShopVo();
        BeanUtils.copyProperties(shops.get(0), vo);
        return Result.ok(vo);
    }

    @Override
    public Result<ShopPageVo> shopCoupon(String shopId) {
        Coupon coupon = new Coupon();
        coupon.setShopId(shopId);
        List<ShopPageVo> collect = couponDao.selectCoupons(coupon).stream().map(coupon1 -> {
            ShopPageVo vo = new ShopPageVo();
            BeanUtils.copyProperties(coupon1, vo);
            return vo;
        }).collect(Collectors.toList());
        return Result.ok(collect);
    }

    @Override
    public Result<GoodsPageVo> shopGoods(String shopId) {
        Goods goods = new Goods();
        goods.setShopId(shopId);
        List<GoodsPageVo> collect = goodsDao.selectGoodss(goods).stream().map(goods1 -> {
            GoodsPageVo goodsPageVo = new GoodsPageVo();
            BeanUtils.copyProperties(goods1, goodsPageVo);
            return goodsPageVo;
        }).collect(Collectors.toList());
        return Result.ok(collect);
    }

    @Override
    @Transactional
    public Result useCoupon(UseCouponDto dto) {
        Member member = new Member();
        member.setOpenId(dto.getOpenId());
        List<Member> members = memberDao.selectMembers(member);
        if (!members.isEmpty()) {
            member.setMemberId(members.get(0).getMemberId());
        }

        //促销券减库存——如果分配完了不，告诉客户已经领完了
        CouponStock couponStock = new CouponStock();
        couponStock.setCouponId(dto.getCouponId());
        List<CouponStock> couponStocks = couponStockDao.selectCouponStocks(couponStock);
        long count = couponStocks.stream().filter(c -> StringUtils.isNotBlank(c.getMemberId())).count();
        if (count==0) {
            return Result.error(600, "手慢了,电子券已经领完");
        }
        //如果还有没有分配的代金券分配给客户一个
        CouponStock stock = couponStocks.stream().filter(c -> StringUtils.isNotBlank(c.getMemberId())).findFirst().orElse(null);
        if(stock==null){
            //todo 数据错误——程序完善后就不会有此错误
            return Result.error(500, "数据错误——程序完善后就不会有此错误");
        }
        BeanUtils.copyProperties(stock,couponStock);
        couponStock.setCreateTime(new Date());
        couponStock.setMemberId(member.getMemberId());
        couponStockDao.update(couponStock);
        //代金券历史
        CouponHistory c = new CouponHistory();
        c.setCouponNo(dto.getCouponId());
        List<CouponHistory> couponHistories = couponHistoryDao.selectCouponHistorys(c);
        String from = null;
        if (!couponHistories.isEmpty()) {
            Optional<CouponHistory> first = couponHistories.stream().sorted(Comparator.comparing(CouponHistory::getCreateTime).reversed()).findFirst();
            if (first.get() != null) {
                from = first.get().getToName();
            }
        }
        c.setFromName(from);
        c.setCouponNo(dto.getCouponId());
        c.setRemark(OperationTypeEnum.IMAGERECEIVE.getInfo());
        c.setCreateTime(new Date());
        c.setToName(dto.getOpenId() + "+" + members.get(0).getName());
        couponHistoryDao.insert(c);
        //会员操作记录表
        MemberOperationHistory m = new MemberOperationHistory();
        m.setCreateTime(new Date());
        m.setMemberId(member.getMemberId());
        m.setRelationInfo(OperationTypeEnum.IMAGERECEIVE.getInfo());
        m.setDetail(OperationTypeEnum.IMAGERECEIVE.getInfo());
        memberOperationHistoryDao.insert(m);
        return Result.ok();
    }
}
