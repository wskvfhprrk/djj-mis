-- 初始化数据库
-- 清除usre中除超级管理员外
DELETE FROM t_user WHERE user_id!=1;
-- 清除role中除超级管理员外
DELETE FROM t_role WHERE role_id!=1;
-- 清除中间表中menu_id大的值
DELETE FROM m_role_menu WHERE menu_id>86;
-- 清除菜单表中menu_id大的值
DELETE FROM t_menu WHERE menu_id>86;
-- 设置自增值
alter table t_menu AUTO_INCREMENT=87;
alter table t_user AUTO_INCREMENT=2;
alter table t_role AUTO_INCREMENT=2;
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (87, '商店管理员', '', 0, NULL, NULL, NULL, NULL, 87, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (88, '商店管理员', 'shopUser', 87, NULL, NULL, NULL, NULL, 88, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (89, '商店管理员分页查询', NULL, 88, NULL, 'shopUser_get', '/shopUser@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (90, '商店管理员添加', NULL, 88, NULL, 'shopUser_save', '/shopUser@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (91, '商店管理员修改', NULL, 88, NULL, 'shopUser_update', '/shopUser@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (92, '商店管理员根据id查询', NULL, 88, NULL, 'shopUser_*_get', '/shopUser/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (93, '商店管理员根据id删除', NULL, 88, NULL, 'shopUser_*_delete','/shopUser/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (94, '查询所有商店管理员', NULL, 88, NULL, 'shopUser_all_get','/shopUser/all@get', NULL, 6, 1);

