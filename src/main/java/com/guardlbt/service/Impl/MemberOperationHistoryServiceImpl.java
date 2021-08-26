package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.MemberOperationHistoryDao;
import com.guardlbt.entity.MemberOperationHistory;
import com.guardlbt.service.MemberOperationHistoryService;
import com.guardlbt.util.*;
import com.guardlbt.common.util.*;
import com.guardlbt.dto.*;
import com.guardlbt.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


/**
* 会员操作记录历史方法实现类
* Created by 代码自动生成.
* 时间:2021-08-25 18:06:24
*/
@Service
@Transactional
public class MemberOperationHistoryServiceImpl implements MemberOperationHistoryService {

    @Autowired
    private MemberOperationHistoryDao dao;

    @Override
    public Result findPageMemberOperationHistory(MemberOperationHistoryPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        MemberOperationHistory memberOperationHistory=new MemberOperationHistory();
        BeanUtils.copyProperties(dto,memberOperationHistory);
        List<MemberOperationHistory> list = dao.selectMemberOperationHistorys(memberOperationHistory);
        PageInfo<MemberOperationHistory> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<MemberOperationHistoryPageVo> vos = info.getList().stream().map(l -> {
            MemberOperationHistoryPageVo vo = new MemberOperationHistoryPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<MemberOperationHistory> memberOperationHistorys = dao.selectMemberOperationHistorys(null);
        return Result.ok(memberOperationHistorys);
    }
        
    @Override
    public Result findAllByMemberOperationHistory(MemberOperationHistory memberOperationHistory) {
        List<MemberOperationHistory> memberOperationHistorys = dao.selectMemberOperationHistorys(memberOperationHistory);
        //转换vo出去
        List<MemberOperationHistoryPageVo> vos = memberOperationHistorys.stream().map(l -> {
        MemberOperationHistoryPageVo vo = new MemberOperationHistoryPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public MemberOperationHistory findMemberOperationHistory(MemberOperationHistory memberOperationHistory) {
        List<MemberOperationHistory> list = dao.selectMemberOperationHistorys(memberOperationHistory);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(MemberOperationHistorySaveDto dto) {
        MemberOperationHistory memberOperationHistory=new MemberOperationHistory();
        BeanUtils.copyProperties(dto,memberOperationHistory);
        
        try{
            dao.insert(memberOperationHistory);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(MemberOperationHistoryUpdateDto dto) {
        MemberOperationHistory memberOperationHistory=new MemberOperationHistory();
        BeanUtils.copyProperties(dto,memberOperationHistory);
        try{
            dao.update(memberOperationHistory);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(MemberOperationHistory memberOperationHistory) {
        try{
            dao.delete(memberOperationHistory);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result deleteAll(String ids) {
        try{
            String[] strings = ids.split(",");
            List<String> list=new ArrayList<>();
            for (int i = 0; i <strings.length ; i++) {
                list.add(strings[i]);
            }
            dao.deleteAll(list);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result getById(Long id) {
        MemberOperationHistory memberOperationHistory=new MemberOperationHistory();
        memberOperationHistory.setId(id);
        List<MemberOperationHistory> memberOperationHistorys = dao.selectMemberOperationHistorys(memberOperationHistory);
        if(memberOperationHistorys.isEmpty()){
            return Result.ok();
        }
        return Result.ok(memberOperationHistorys.get(0));
    }
}
