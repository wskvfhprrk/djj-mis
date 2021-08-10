package com.guardlbt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.common.exception.ResultException;
import com.guardlbt.common.util.PageResult;
import com.guardlbt.common.util.RSAEncrypt;
import com.guardlbt.common.util.Result;
import com.guardlbt.dto.SelectCouponPageDto;
import com.guardlbt.dto.SelectWinningDto;
import com.guardlbt.dto.ValiteCodedto;
import com.guardlbt.entity.*;
import com.guardlbt.mapper.BlacklistMapper;
import com.guardlbt.mapper.CouponMapper;
import com.guardlbt.mapper.RecodMapper;
import com.guardlbt.mapper.WinningMapper;
import com.guardlbt.service.CouponService;
import com.guardlbt.vo.ResultVo;
import com.guardlbt.vo.SelectCouponPageVo;
import com.guardlbt.vo.SelectWinningPageVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.guardlbt.common.constant.Constants.BLICKLIST_PREFIX;
import static com.guardlbt.common.constant.Constants.TOKEN_V_PREFIX;

@Service
@Slf4j
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private BlacklistMapper blacklistMapper;
    @Autowired
    private WinningMapper winningMapper;
    @Autowired
    private RecodMapper recodMapper;

    @Override
    public Result<PageResult<List<SelectCouponPageVo>>> selectCouponPage(String token, SelectCouponPageDto dto) {
        PageHelper.startPage(dto.getPageNumber(), dto.getPageSize());
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        if (dto.getCouponId() != null) {
            criteria.andCouponIdEqualTo(dto.getCouponId());
        }
        if (dto.getCouponStatus() != null) {
            criteria.andCouponStatusEqualTo(dto.getCouponStatus());
        }
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        PageInfo<Coupon> pageInfo = new PageInfo<>(coupons);
        PageResult pageResult = new PageResult();
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        pageResult.setTotle(pageInfo.getTotal());
        List<SelectCouponPageVo> list = coupons.stream().map(coupon -> {
            SelectCouponPageVo vo = new SelectCouponPageVo();
            BeanUtils.copyProperties(coupon, vo);
            vo.setCouponId(String.valueOf(coupon.getCouponId()));
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(list);
        return Result.ok(pageResult);
    }

    @Override
    public Result selectWinning(SelectWinningDto dto) {
        PageHelper.startPage(dto.getPageNumber(), dto.getPageSize());
        WinningExample ex = new WinningExample();
        WinningExample.Criteria criteria = ex.createCriteria();
        if (StringUtils.isNotBlank(dto.getCodeId())) {
            criteria.andCodeIdEqualTo(dto.getCodeId());
        }
        if (StringUtils.isNotBlank(dto.getWinningCode())) {
            criteria.andWinningCodeEqualTo(dto.getWinningCode());
        }
        if (dto.getIsWinning() != null) {
            criteria.andIsWinningEqualTo(dto.getIsWinning());
        }
        List<Winning> winnings = winningMapper.selectByExample(ex);
        PageInfo<Winning> pageInfo = new PageInfo<>(winnings);
        PageResult pageResult = new PageResult();
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        pageResult.setTotle(pageInfo.getTotal());
        List<SelectWinningPageVo> list = winnings.stream().map(winning -> {
            SelectWinningPageVo vo = new SelectWinningPageVo();
            BeanUtils.copyProperties(winning, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(list);
        return Result.ok(pageResult);
    }

    @Override
    public Result getRecodById(String winningCode) {
        //code解密
        CouponExample ex=new CouponExample();
        ex.createCriteria().andCouponManualcodeEqualTo(winningCode);
        List<Coupon> coupons = couponMapper.selectByExample(ex);
        if(coupons.isEmpty()) return Result.error(500,"没有winningCode!");
        RecodExample recodExample = new RecodExample();
        recodExample.createCriteria().andCouponIdEqualTo(coupons.get(0).getCouponId());
        List<Recod> recods = recodMapper.selectByExample(recodExample);
        return Result.ok(recods);
    }

    @Override
    public Result updateIsWining(String winningCode) {
        WinningExample ex=new WinningExample();
        ex.createCriteria().andWinningCodeEqualTo(winningCode);
        List<Winning> winnings = winningMapper.selectByExample(ex);
        Winning winning=new Winning();
        if(!winnings.isEmpty()){
            winning=winnings.get(0);
        }
        if (winning.getIsWinning() == 0) {
            winning.setIsWinning(1);
        } else {
            winning.setIsWinning(0);
        }
        winning.setUpdateTime(new Date());
        winningMapper.updateByPrimaryKeySelective(winning);
        return Result.ok();
    }

    @Override
    public Result valiteCode(ValiteCodedto dto) {
        String tokenKey = TOKEN_V_PREFIX + dto.getToken();
        Object o = redisTemplate.opsForValue().get(tokenKey);
        if (o == null) {
            return Result.error(500, "token过期了，请重新登陆");
        }
        //code解密
        Long couponId = 0L;
        Admin admin = (Admin) o;
        String blackKey = BLICKLIST_PREFIX + admin.getPhone();
        try {
            String code = RSAEncrypt.decrypt(dto.getCode(), RSAEncrypt.private_key);
            couponId = Long.valueOf(code);
        } catch (Exception e) {
            log.error("解析不正确的二维码：{}"+dto.getCode());
            //错误码提示——不存在的二维码
            return blackList(dto, tokenKey, admin, blackKey);
        }
        Coupon coupon = couponMapper.selectByPrimaryKey(couponId);
        if (coupon == null) {
            return blackList(dto, tokenKey, admin, blackKey);
        }
        coupon.setRecyUser(admin.getPhone());
        coupon.setUpdateTime(new Date());
        coupon.setCouponStatus(2);
        couponMapper.updateByPrimaryKey(coupon);
        redisTemplate.delete(blackKey);
        Winning winning = winningMapper.selectByPrimaryKey(dto.getCode());
        Integer searchNumber = winning.getSearchNumber();
        if (searchNumber == null || searchNumber == 0) {
            searchNumber = 0;
            winning.setFistTime(new Date());
        }
        winning.setSearchNumber(searchNumber + 1);
        winning.setUpdateTime(new Date());
        winningMapper.updateByPrimaryKey(winning);
        ResultVo vo = new ResultVo();
        vo.setCode(winning.getCodeId());
        vo.setIswinning(winning.getIsWinning());
        vo.setFirstSearchTime(winning.getFistTime());
        vo.setSearchNumber(winning.getSearchNumber());
        vo.setWinningCode(winning.getWinningCode());
        //添加到记录中
        Recod recod = new Recod();
        recod.setCreateTime(new Date());
        recod.setPhone(admin.getPhone());
        recod.setCouponId(couponId);
        recodMapper.insert(recod);
        return Result.ok(vo);
    }

    private Result blackList(ValiteCodedto dto, String tokenKey, Admin admin, String blackKey) {
        //黑名单逻辑
        Object o1 = redisTemplate.opsForValue().get(blackKey);
        log.error("扫瞄不存在的票：扫描人：{}，票号：{}", admin.getPhone(), dto.getCode());
        if (o1 == null) {
            redisTemplate.opsForValue().set(blackKey, 1);
            return Result.error(500, "查不到相应电子券，连续输入10次查不到的电子券，将被拉黑");
        }
        Integer i = (Integer) o1;
        if (i >= 9) {
            //加入黑名单，并锁定
            Blacklist blacklist = new Blacklist();
            blacklist.setId(dto.getToken());
            blacklist.setName(admin.getPhone());
            blacklist.setCreateTime(new Date());
            blacklistMapper.insert(blacklist);
            //删除缓存
            redisTemplate.delete(blackKey);
            //删除token让其登陆
            redisTemplate.delete(tokenKey);
            return Result.error(500, "查不到相应电子券，将被拉黑");
        }
        i++;
        redisTemplate.opsForValue().set(blackKey, i);

        return Result.error(500, "查不到相应电子券，连续输入10次查不到的电子券，将被拉黑");
    }
}
