package com.guardlbt.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guardlbt.dao.MemberDao;
import com.guardlbt.entity.Member;
import com.guardlbt.service.MemberService;
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
* 会员方法实现类
* Created by 代码自动生成.
* 时间:2021-08-27 13:42:56
*/
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao dao;

    @Override
    public Result findPageMember(MemberPageDto dto) {
        PageResult pageResult=new PageResult();
        PageHelper.startPage(dto.getPageNumber(),dto.getPageSize());
        Member member=new Member();
        BeanUtils.copyProperties(dto,member);
        List<Member> list = dao.selectMembers(member);
        PageInfo<Member> info=new PageInfo<>(list);
        pageResult.setTotle(info.getTotal());
        pageResult.setPageSize(dto.getPageSize());
        pageResult.setPageNumber(dto.getPageNumber());
        //转换vo出去
        List<MemberPageVo> vos = info.getList().stream().map(l -> {
            MemberPageVo vo = new MemberPageVo();
            BeanUtils.copyProperties(l, vo);
            return vo;
        }).collect(Collectors.toList());
        pageResult.setPages(vos);
        return Result.ok(pageResult);
    }

    @Override
    public Result getAll() {
        List<Member> members = dao.selectMembers(null);
        return Result.ok(members);
    }
        
    @Override
    public Result findAllByMember(Member member) {
        List<Member> members = dao.selectMembers(member);
        //转换vo出去
        List<MemberPageVo> vos = members.stream().map(l -> {
        MemberPageVo vo = new MemberPageVo();
        BeanUtils.copyProperties(l, vo);
        return vo;
        }).collect(Collectors.toList());
        return Result.ok(vos);
    }

    @Override
    public Member findMember(Member member) {
        List<Member> list = dao.selectMembers(member);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Result insert(MemberSaveDto dto) {
        Member member=new Member();
        BeanUtils.copyProperties(dto,member);
        member.setMemberId(UuidUtild.getUUID());
        try{
            dao.insert(member);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result update(MemberUpdateDto dto) {
        Member member=new Member();
        BeanUtils.copyProperties(dto,member);
        try{
            dao.update(member);
            return Result.ok();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(500,e.getCause().getMessage());
        }
    }

    @Override
    public Result delete(Member member) {
        try{
            dao.delete(member);
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
    public Result getById(String memberId) {
        Member member=new Member();
        member.setMemberId(memberId);
        List<Member> members = dao.selectMembers(member);
        if(members.isEmpty()){
            return Result.ok();
        }
        return Result.ok(members.get(0));
    }
}
