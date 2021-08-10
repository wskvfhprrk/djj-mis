package guardlbt.service;

import guardlbt.common.util.PageResult;
import guardlbt.common.util.Result;
import guardlbt.dto.SaveUserDto;
import guardlbt.dto.SelectUserPageDto;
import guardlbt.dto.UpdateUserDto;
import guardlbt.vo.SelectAlluserByUserTypeVo;
import guardlbt.vo.SelectUserByUserIdVo;
import guardlbt.vo.SelectUserPageVo;

import java.util.List;

/**
 * 人员管理方法类接口
 *
 * Created by 代码自动生成.
 * 时间:2019-03-27 16:54:21
 */
public interface UserService {

    /**
    * 添加人员——添加人员
    */
    Result saveUser(SaveUserDto saveUserDto);

    /**
    * 修改人员——修改人员
    */
    Result updateUser( UpdateUserDto updateUserDto);

    /**
    * 删除人员——删除人员：由于使用外键，如果报错就是有人使用，不能强制删除
    */
    Result deleteUserByUserId( String userId);

    /**
    * 分页查询人员——查询人员：创建时间倒序排列
    */
    Result<PageResult<List<SelectUserPageVo>>> selectUserPage(String token, SelectUserPageDto selectUserPageDto);

    /**
    * 根据id查询人员——查询人员:路径参数
    */
    Result<SelectUserByUserIdVo> selectUserByUserId(String userId);

    /**
    * 查询所有人员——查询所有人员：为添加商家和回收渠道做准备的
    */
    Result<List<SelectAlluserByUserTypeVo>> selectAlluserByUserType(Integer userType);

}
