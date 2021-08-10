package guardlbt.service.impl;

import guardlbt.common.constant.Constants;
import guardlbt.common.util.*;
import guardlbt.dto.LoginDto;
import guardlbt.dto.SaveResetPasswordDto;
import guardlbt.dto.SaveSetPasswordDto;
import guardlbt.entity.*;
import guardlbt.mapper.MenuMapper;
import guardlbt.mapper.RoleMenuMapper;
import guardlbt.mapper.UserMapper;
import guardlbt.mapper.UserRoleMapper;
import guardlbt.service.BaseService;
import guardlbt.vo.CheckPictureVo;
import guardlbt.vo.LoginVo;
import guardlbt.vo.SaveLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.MINUTES;

@Service
@Slf4j
public class BaseServiceImpl implements BaseService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Value("${token_time}")
    private int tokenTime;
    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public Result<CheckPictureVo> checkPicture(String token) {
        ValidateCodeUtil.Validate randomCode = ValidateCodeUtil.getRandomCode();
        String codeValue = randomCode.getValue();
        //设置验证码有效期5分钟
        redisTemplate.opsForValue().set(Constants.TOKEN_V_PREFIX + codeValue.toLowerCase(), codeValue, Duration.of(2, MINUTES));
        String base64Str = randomCode.getBase64Str();
        CheckPictureVo vo = new CheckPictureVo();
        vo.setPicStr(base64Str);
        return Result.ok(vo);
    }

    @Override
    public Result login(LoginDto loginDto, HttpServletResponse response) {
        /**
         * 1、验证验证码
         * 2、验证用户名和密码
         * 3、发给token
         */
        //  验证码
        Object o1 = redisTemplate.opsForValue().get(Constants.TOKEN_V_PREFIX + loginDto.getCheckCode().toLowerCase());
        if (o1 == null) {
            return Result.error(ResultErrorCode.VALIDATECODE_ERROR);
        }
        if (!o1.toString().equalsIgnoreCase(loginDto.getCheckCode().trim())) {
            return Result.error(ResultErrorCode.VALIDATECODE_ERROR);
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(loginDto.getUsername().trim());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.isEmpty()) {
            log.error("用户名和密码错误：{}", loginDto);
            return Result.error(ResultErrorCode.USER_PASSWORD_ERROR);
        }
        String string = MD5Util.getMD5String(loginDto.getPassword().trim() + users.get(0).getSalt());
        if (!string.equals(users.get(0).getPassword())) {
            log.error("用户名和密码错误：{}", loginDto);
            return Result.error(ResultErrorCode.USER_PASSWORD_ERROR);
        }
        //认证通过后--清除之前登陆人信息
        String token = UUID.randomUUID().toString().replace("-", "");
        User user = users.get(0);
        Object o = redisTemplate.opsForValue().get(Constants.USER_TOKEN + user.getUserId());
        if (null != o) {
            redisTemplate.delete(Constants.TOKEN_P_PREFIX + o);
            redisTemplate.delete(Constants.TOKEN_U_PREFIX + o);
        }
        //添加用户信息
        redisTemplate.opsForValue().set(Constants.USER_TOKEN + user.getUserId(), token, Duration.of(tokenTime, MINUTES));
        redisTemplate.opsForValue().set(Constants.TOKEN_U_PREFIX + token, user, Duration.of(tokenTime, MINUTES));
        //权限放置缓存中
        List<RoleMenuKey> roleMenuKeys = getMenuIdsByToken(token);
        if (roleMenuKeys != null && !roleMenuKeys.isEmpty()) {
            MenuExample ex = new MenuExample();
            ex.createCriteria().andMenuTypeEqualTo(1).andMenuIdIn(roleMenuKeys.stream().map(RoleMenuKey::getMenuId).collect(Collectors.toList()));
            List<Menu> menus = menuMapper.selectByExample(ex);
            List<String> permissions = menus.stream().map(Menu::getPermission).distinct().collect(Collectors.toList());
            redisTemplate.opsForValue().set(Constants.TOKEN_P_PREFIX + token, permissions, Duration.of(tokenTime, MINUTES));
        }
        LoginVo vo = new LoginVo();
        BeanUtils.copyProperties(user, vo);
        vo.setToken(token);
        //  swagger操作cookie
        Cookie cookie = new Cookie("session", token);
        response.addCookie(cookie);
        return Result.ok(vo);
    }

    @Override
    public Result<SaveLoginVo> menus(String token) {
        List<RoleMenuKey> roleMenuButtons = getMenuIdsByToken(token);
        if (roleMenuButtons == null || roleMenuButtons.isEmpty()) {
            return Result.ok();
        }
        List<Integer> list = roleMenuButtons.stream().distinct().map(RoleMenuKey::getMenuId).collect(Collectors.toList());
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andMenuIdIn(list);
        List<Menu> menus = menuMapper.selectByExample(menuExample);
        List<Menu> menus2 = menus;
        while (true) {
            List<Integer> pids = menus2.stream().filter(m -> m.getmPid() != 0).map(Menu::getmPid).distinct().collect(Collectors.toList());
            if (pids.isEmpty()) {
                break;
            }
            MenuExample ex = new MenuExample();
            ex.createCriteria().andMenuIdIn(pids);
            List<Menu> menus1 = menuMapper.selectByExample(ex);
            menus.addAll(menus1);
//            menus2 = new ArrayList<>();
            menus2 = menus1;
        }
        Stream<Menu> menuStream = menus.stream().distinct().sorted(Comparator.comparing(Menu::getOrderBy));
        List<SaveLoginVo.Menus> vos = new ArrayList<>();
        List<SaveLoginVo.Menus> finalVos = vos;
        List<Integer> menuIds = new ArrayList<>();
        menuStream.filter(menu -> menu.getMenuType() == 0 && !menuIds.contains(menu.getMenuId())).forEach(c -> {
            SaveLoginVo.Menus menu = new SaveLoginVo.Menus();
            BeanUtils.copyProperties(c, menu);
            menu.setParentId(c.getmPid());
            menu.setName(c.getMenuName());
            finalVos.add(menu);
            menuIds.add(c.getMenuId());
        });
        vos = vos.stream().sorted(Comparator.comparing(SaveLoginVo.Menus::getOrderBy)).collect(Collectors.toList());
        List<String> strings = menus.stream().distinct().filter(m -> m.getMenuType() == 1).map(Menu::getPermission).collect(Collectors.toList());
        SaveLoginVo saveLoginVo = new SaveLoginVo();
        List<String> stringList = strings.stream().map(s -> {
            String s1 = s.substring(1).replaceAll("/", "_").replaceAll("@", "_");
            return s1;
        }).collect(Collectors.toList());
        saveLoginVo.setPermissions(stringList);
        saveLoginVo.setMenuList(vos);
        return Result.ok(saveLoginVo);
    }

    private List<RoleMenuKey> getMenuIdsByToken(String token) {
        User user = tokenUtil.getUserByToken(token);
        if (user == null) {
            return new ArrayList<>();
        }
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(user.getUserId());
        List<UserRoleKey> userRoles = userRoleMapper.selectByExample(userRoleExample);
        if (userRoles.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> list = userRoles.stream().map(UserRoleKey::getRoleId).collect(Collectors.toList());
        RoleMenuExample ex = new RoleMenuExample();
        ex.createCriteria().andRoleIdIn(list);
        List<RoleMenuKey> roleMenuKeys = roleMenuMapper.selectByExample(ex);
        if (roleMenuKeys.isEmpty()) {
            return new ArrayList<>();
        }
        return roleMenuKeys;
    }

    @Override
    public Result logout(String token) {
        //清除缓存
        redisTemplate.delete(Constants.TOKEN_P_PREFIX + token);
        redisTemplate.delete(Constants.TOKEN_U_PREFIX + token);
        return Result.ok();
    }

    @Override
    public Result saveSetPassword(String token, SaveSetPasswordDto saveSetPasswordDto) {
        Object o = redisTemplate.opsForValue().get(Constants.TOKEN_U_PREFIX + token);
        if (null == o) {
            return Result.error(ResultErrorCode.TOKEN_ERROR);
        }
        User user = (User) o;
        if (!MD5Util.getMD5String(saveSetPasswordDto.getOldPassword() + user.getSalt()).equals(user.getPassword())) {
            log.error("原密码不正确");
            return Result.error(ResultErrorCode.OLD_PASSWORD_ERROR);
        }
        user.setPassword(MD5Util.getMD5String(saveSetPasswordDto.getNewPassword() + user.getSalt()));
        userMapper.updateByPrimaryKeySelective(user);
        return Result.ok();
    }

    @Override
    public Result saveResetPassword(String token, SaveResetPasswordDto saveResetPasswordDto) {
        User user = userMapper.selectByPrimaryKey(saveResetPasswordDto.getUserId());
        if (user == null) {
            log.error("用户不存在");
            return Result.error(ResultErrorCode.USER_NOT_EXIST);
        }
        user.setPassword(MD5Util.getMD5String("888888" + user.getSalt()));
        userMapper.updateByPrimaryKey(user);
        return Result.ok();
    }

}
