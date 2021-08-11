package com.guardlbt.mapper;

import com.guardlbt.dto.SelectUserPageDto;
import com.guardlbt.entity.User;
import com.guardlbt.entity.UserExample;
import java.util.List;
import java.util.Map;

import com.guardlbt.vo.SelectUserByUserIdVo;
import com.guardlbt.vo.SelectUserPageVo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<SelectUserPageVo> selectUserPage(SelectUserPageDto selectUserPageDto);

    Long listRow(SelectUserPageDto dto);

    SelectUserByUserIdVo info(String userId);

    List<Map<String, Object>> userDown(Map<String, Object> params);
}