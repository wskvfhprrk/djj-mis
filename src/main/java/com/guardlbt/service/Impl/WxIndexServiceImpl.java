package com.guardlbt.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guardlbt.common.util.Result;
import com.guardlbt.dao.*;
import com.guardlbt.dto.MemberSaveDto;
import com.guardlbt.dto.ReportSiteSaveDto;
import com.guardlbt.dto.UseCouponDto;
import com.guardlbt.entity.*;
import com.guardlbt.eum.OperationType;
import com.guardlbt.https.HttpsUtil;
import com.guardlbt.service.WxIndexService;
import com.guardlbt.vo.*;
import com.guardlbt.wx.WxConfigurationProperties;
import com.guardlbt.wx.vo.Code2SessionVo;
import com.guardlbt.wx.vo.GetAccessTokenVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
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
    private ShopUserDao shopUserDao;
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
    @Transactional
    public Result getUserInfo(MemberSaveDto memberSaveDto) {
        //要判断一下是身份，如果不是管理员就写入会员数据库，如果已经写入数据库的不要再记录了
        ShopUser shopUser = new ShopUser();
        shopUser.setOpenId(memberSaveDto.getOpenId());
        List<ShopUser> shopUsers = shopUserDao.selectShopUsers(shopUser);
        Member member = new Member();
        member.setOpenId(memberSaveDto.getOpenId());
        List<Member> members = memberDao.selectMembers(member);
        if (shopUsers.isEmpty() && members.isEmpty()) {
            Member member1 = new Member();
            BeanUtils.copyProperties(memberSaveDto, member1);
            memberDao.insert(member1);
        }
        // 记录会员操作记录表
        if (!members.isEmpty()) {
            MemberOperationHistory m = new MemberOperationHistory();
            m.setMemberId(memberSaveDto.getOpenId());
            m.setCreateTime(new Date());
            m.setDetail(OperationType.LOGIN.getInfo());
            m.setRelationInfo(OperationType.LOGIN.getInfo());
            m.setOperationId(String.valueOf(OperationType.LOGIN.getState()));
            memberOperationHistoryDao.insert(m);
        }
        //如果是店员记录不用记录
        return Result.ok();
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
            if(!shops.isEmpty()){
                BeanUtils.copyProperties(shops.get(0),vo);
                vo.setStartTime(shops.get(0).getStartTime().toString());
                vo.setStopTime(shops.get(0).getStopTime().toString());
            }
            return vo;
        }).collect(Collectors.toList());
        return Result.ok(collect);
    }

    @Override
    public Result<CouponPageVo> indexCoupon() {
        List<CouponPageVo> collect = indexCouponDao.selectIndexCoupons(new IndexCoupon()).stream().sorted(Comparator.comparing(IndexCoupon::getSorting)).map(indexCoupon -> {
            CouponPageVo vo = new CouponPageVo();
            Coupon coupon=new Coupon();
            coupon.setCouponId(indexCoupon.getCouponId());
            List<Coupon> coupons = couponDao.selectCoupons(coupon);
            if(!coupons.isEmpty()){
                BeanUtils.copyProperties(coupons.get(0),vo);
            }
            return vo;
        }).collect(Collectors.toList());
        return Result.ok(collect);
    }

    @Override
    public Result<ShopVo> shopInfo(String shopId) {
        Shop shop=new Shop();
        shop.setShopId(shopId);
        List<Shop> shops = shopDao.selectShops(shop);
        if(shops.isEmpty()){
            return Result.ok();
        }
        ShopVo vo=new ShopVo();
        BeanUtils.copyProperties(shops.get(0),vo);
        return Result.ok(vo);
    }

    @Override
    public Result<ShopPageVo> shopCoupon(String shopId) {
        Coupon coupon=new Coupon();
        coupon.setShopId(shopId);
        List<ShopPageVo> collect = couponDao.selectCoupons(coupon).stream().map(coupon1 -> {
            ShopPageVo vo = new ShopPageVo();
            BeanUtils.copyProperties(coupon1,vo);
            return vo;
        }).collect(Collectors.toList());
        return Result.ok(collect);
    }

    @Override
    public Result<GoodsPageVo> shopGoods(String shopId) {
        Goods goods=new Goods();
        goods.setShopId(shopId);
        List<GoodsPageVo> collect = goodsDao.selectGoodss(goods).stream().map(goods1 -> {
            GoodsPageVo goodsPageVo = new GoodsPageVo();
            BeanUtils.copyProperties(goods1, goodsPageVo);
            return goodsPageVo;
        }).collect(Collectors.toList());
        return Result.ok(collect);
    }

    @Override
    public Result useCoupon(UseCouponDto useCouponDto) {
        //会员操作记录表
        //促销券库存
        //代金券历史
        return Result.ok();
    }
}
