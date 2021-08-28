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
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (87, '商圈', '', 0, NULL, NULL, NULL, NULL, 87, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (88, '商圈', 'businessDistrict', 87, NULL, NULL, NULL, NULL, 88, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (89, '商圈分页查询', NULL, 88, NULL, 'businessDistrict_get', '/businessDistrict@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (90, '商圈添加', NULL, 88, NULL, 'businessDistrict_save', '/businessDistrict@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (91, '商圈修改', NULL, 88, NULL, 'businessDistrict_update', '/businessDistrict@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (92, '商圈根据id查询', NULL, 88, NULL, 'businessDistrict_*_get', '/businessDistrict/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (93, '商圈根据id删除', NULL, 88, NULL, 'businessDistrict_*_delete','/businessDistrict/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (94, '查询所有商圈', NULL, 88, NULL, 'businessDistrict_all_get','/businessDistrict/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (95, '商店', '', 0, NULL, NULL, NULL, NULL, 95, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (96, '商店', 'shop', 95, NULL, NULL, NULL, NULL, 96, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (97, '商店分页查询', NULL, 96, NULL, 'shop_get', '/shop@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (98, '商店添加', NULL, 96, NULL, 'shop_save', '/shop@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (99, '商店修改', NULL, 96, NULL, 'shop_update', '/shop@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (100, '商店根据id查询', NULL, 96, NULL, 'shop_*_get', '/shop/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (101, '商店根据id删除', NULL, 96, NULL, 'shop_*_delete','/shop/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (102, '查询所有商店', NULL, 96, NULL, 'shop_all_get','/shop/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (103, '商店管理员', '', 0, NULL, NULL, NULL, NULL, 103, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (104, '商店管理员', 'shopUser', 103, NULL, NULL, NULL, NULL, 104, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (105, '商店管理员分页查询', NULL, 104, NULL, 'shopUser_get', '/shopUser@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (106, '商店管理员添加', NULL, 104, NULL, 'shopUser_save', '/shopUser@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (107, '商店管理员修改', NULL, 104, NULL, 'shopUser_update', '/shopUser@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (108, '商店管理员根据id查询', NULL, 104, NULL, 'shopUser_*_get', '/shopUser/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (109, '商店管理员根据id删除', NULL, 104, NULL, 'shopUser_*_delete','/shopUser/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (110, '查询所有商店管理员', NULL, 104, NULL, 'shopUser_all_get','/shopUser/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (111, '商店部门管理', '', 0, NULL, NULL, NULL, NULL, 111, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (112, '商店部门管理', 'sysDept', 111, NULL, NULL, NULL, NULL, 112, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (113, '商店部门管理分页查询', NULL, 112, NULL, 'sysDept_get', '/sysDept@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (114, '商店部门管理添加', NULL, 112, NULL, 'sysDept_save', '/sysDept@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (115, '商店部门管理修改', NULL, 112, NULL, 'sysDept_update', '/sysDept@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (116, '商店部门管理根据id查询', NULL, 112, NULL, 'sysDept_*_get', '/sysDept/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (117, '商店部门管理根据id删除', NULL, 112, NULL, 'sysDept_*_delete','/sysDept/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (118, '查询所有商店部门管理', NULL, 112, NULL, 'sysDept_all_get','/sysDept/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (119, '代金券', '', 0, NULL, NULL, NULL, NULL, 119, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (120, '代金券', 'coupon', 119, NULL, NULL, NULL, NULL, 120, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (121, '代金券分页查询', NULL, 120, NULL, 'coupon_get', '/coupon@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (122, '代金券添加', NULL, 120, NULL, 'coupon_save', '/coupon@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (123, '代金券修改', NULL, 120, NULL, 'coupon_update', '/coupon@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (124, '代金券根据id查询', NULL, 120, NULL, 'coupon_*_get', '/coupon/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (125, '代金券根据id删除', NULL, 120, NULL, 'coupon_*_delete','/coupon/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (126, '查询所有代金券', NULL, 120, NULL, 'coupon_all_get','/coupon/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (127, '代金券历史', '', 0, NULL, NULL, NULL, NULL, 127, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (128, '代金券历史', 'couponHistory', 127, NULL, NULL, NULL, NULL, 128, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (129, '代金券历史分页查询', NULL, 128, NULL, 'couponHistory_get', '/couponHistory@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (130, '代金券历史添加', NULL, 128, NULL, 'couponHistory_save', '/couponHistory@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (131, '代金券历史修改', NULL, 128, NULL, 'couponHistory_update', '/couponHistory@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (132, '代金券历史根据id查询', NULL, 128, NULL, 'couponHistory_*_get', '/couponHistory/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (133, '代金券历史根据id删除', NULL, 128, NULL, 'couponHistory_*_delete','/couponHistory/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (134, '查询所有代金券历史', NULL, 128, NULL, 'couponHistory_all_get','/couponHistory/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (135, '代金券明细', '', 0, NULL, NULL, NULL, NULL, 135, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (136, '代金券明细', 'couponStock', 135, NULL, NULL, NULL, NULL, 136, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (137, '代金券明细分页查询', NULL, 136, NULL, 'couponStock_get', '/couponStock@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (138, '代金券明细添加', NULL, 136, NULL, 'couponStock_save', '/couponStock@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (139, '代金券明细修改', NULL, 136, NULL, 'couponStock_update', '/couponStock@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (140, '代金券明细根据id查询', NULL, 136, NULL, 'couponStock_*_get', '/couponStock/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (141, '代金券明细根据id删除', NULL, 136, NULL, 'couponStock_*_delete','/couponStock/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (142, '查询所有代金券明细', NULL, 136, NULL, 'couponStock_all_get','/couponStock/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (143, '商品', '', 0, NULL, NULL, NULL, NULL, 143, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (144, '商品', 'goods', 143, NULL, NULL, NULL, NULL, 144, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (145, '商品分页查询', NULL, 144, NULL, 'goods_get', '/goods@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (146, '商品添加', NULL, 144, NULL, 'goods_save', '/goods@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (147, '商品修改', NULL, 144, NULL, 'goods_update', '/goods@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (148, '商品根据id查询', NULL, 144, NULL, 'goods_*_get', '/goods/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (149, '商品根据id删除', NULL, 144, NULL, 'goods_*_delete','/goods/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (150, '查询所有商品', NULL, 144, NULL, 'goods_all_get','/goods/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (151, '首页促销代金券', '', 0, NULL, NULL, NULL, NULL, 151, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (152, '首页促销代金券', 'indexCoupon', 151, NULL, NULL, NULL, NULL, 152, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (153, '首页促销代金券分页查询', NULL, 152, NULL, 'indexCoupon_get', '/indexCoupon@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (154, '首页促销代金券添加', NULL, 152, NULL, 'indexCoupon_save', '/indexCoupon@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (155, '首页促销代金券修改', NULL, 152, NULL, 'indexCoupon_update', '/indexCoupon@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (156, '首页促销代金券根据id查询', NULL, 152, NULL, 'indexCoupon_*_get', '/indexCoupon/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (157, '首页促销代金券根据id删除', NULL, 152, NULL, 'indexCoupon_*_delete','/indexCoupon/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (158, '查询所有首页促销代金券', NULL, 152, NULL, 'indexCoupon_all_get','/indexCoupon/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (159, '轮播图', '', 0, NULL, NULL, NULL, NULL, 159, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (160, '轮播图', 'indexImages', 159, NULL, NULL, NULL, NULL, 160, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (161, '轮播图分页查询', NULL, 160, NULL, 'indexImages_get', '/indexImages@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (162, '轮播图添加', NULL, 160, NULL, 'indexImages_save', '/indexImages@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (163, '轮播图修改', NULL, 160, NULL, 'indexImages_update', '/indexImages@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (164, '轮播图根据id查询', NULL, 160, NULL, 'indexImages_*_get', '/indexImages/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (165, '轮播图根据id删除', NULL, 160, NULL, 'indexImages_*_delete','/indexImages/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (166, '查询所有轮播图', NULL, 160, NULL, 'indexImages_all_get','/indexImages/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (167, '首页促销店铺', '', 0, NULL, NULL, NULL, NULL, 167, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (168, '首页促销店铺', 'indexShop', 167, NULL, NULL, NULL, NULL, 168, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (169, '首页促销店铺分页查询', NULL, 168, NULL, 'indexShop_get', '/indexShop@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (170, '首页促销店铺添加', NULL, 168, NULL, 'indexShop_save', '/indexShop@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (171, '首页促销店铺修改', NULL, 168, NULL, 'indexShop_update', '/indexShop@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (172, '首页促销店铺根据id查询', NULL, 168, NULL, 'indexShop_*_get', '/indexShop/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (173, '首页促销店铺根据id删除', NULL, 168, NULL, 'indexShop_*_delete','/indexShop/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (174, '查询所有首页促销店铺', NULL, 168, NULL, 'indexShop_all_get','/indexShop/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (175, '会员', '', 0, NULL, NULL, NULL, NULL, 175, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (176, '会员', 'member', 175, NULL, NULL, NULL, NULL, 176, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (177, '会员分页查询', NULL, 176, NULL, 'member_get', '/member@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (178, '会员添加', NULL, 176, NULL, 'member_save', '/member@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (179, '会员修改', NULL, 176, NULL, 'member_update', '/member@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (180, '会员根据id查询', NULL, 176, NULL, 'member_*_get', '/member/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (181, '会员根据id删除', NULL, 176, NULL, 'member_*_delete','/member/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (182, '查询所有会员', NULL, 176, NULL, 'member_all_get','/member/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (183, '会员操作记录历史', '', 0, NULL, NULL, NULL, NULL, 183, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (184, '会员操作记录历史', 'memberOperationHistory', 183, NULL, NULL, NULL, NULL, 184, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (185, '会员操作记录历史分页查询', NULL, 184, NULL, 'memberOperationHistory_get', '/memberOperationHistory@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (186, '会员操作记录历史添加', NULL, 184, NULL, 'memberOperationHistory_save', '/memberOperationHistory@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (187, '会员操作记录历史修改', NULL, 184, NULL, 'memberOperationHistory_update', '/memberOperationHistory@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (188, '会员操作记录历史根据id查询', NULL, 184, NULL, 'memberOperationHistory_*_get', '/memberOperationHistory/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (189, '会员操作记录历史根据id删除', NULL, 184, NULL, 'memberOperationHistory_*_delete','/memberOperationHistory/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (190, '查询所有会员操作记录历史', NULL, 184, NULL, 'memberOperationHistory_all_get','/memberOperationHistory/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (191, '操作类型', '', 0, NULL, NULL, NULL, NULL, 191, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (192, '操作类型', 'operationType', 191, NULL, NULL, NULL, NULL, 192, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (193, '操作类型分页查询', NULL, 192, NULL, 'operationType_get', '/operationType@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (194, '操作类型添加', NULL, 192, NULL, 'operationType_save', '/operationType@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (195, '操作类型修改', NULL, 192, NULL, 'operationType_update', '/operationType@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (196, '操作类型根据id查询', NULL, 192, NULL, 'operationType_*_get', '/operationType/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (197, '操作类型根据id删除', NULL, 192, NULL, 'operationType_*_delete','/operationType/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (198, '查询所有操作类型', NULL, 192, NULL, 'operationType_all_get','/operationType/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (199, '定位信息上报', '', 0, NULL, NULL, NULL, NULL, 199, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (200, '定位信息上报', 'reportSite', 199, NULL, NULL, NULL, NULL, 200, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (201, '定位信息上报分页查询', NULL, 200, NULL, 'reportSite_get', '/reportSite@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (202, '定位信息上报添加', NULL, 200, NULL, 'reportSite_save', '/reportSite@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (203, '定位信息上报修改', NULL, 200, NULL, 'reportSite_update', '/reportSite@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (204, '定位信息上报根据id查询', NULL, 200, NULL, 'reportSite_*_get', '/reportSite/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (205, '定位信息上报根据id删除', NULL, 200, NULL, 'reportSite_*_delete','/reportSite/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (206, '查询所有定位信息上报', NULL, 200, NULL, 'reportSite_all_get','/reportSite/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (207, '定时任务', '', 0, NULL, NULL, NULL, NULL, 207, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (208, '定时任务', 'scheduleJob', 207, NULL, NULL, NULL, NULL, 208, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (209, '定时任务分页查询', NULL, 208, NULL, 'scheduleJob_get', '/scheduleJob@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (210, '定时任务添加', NULL, 208, NULL, 'scheduleJob_save', '/scheduleJob@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (211, '定时任务修改', NULL, 208, NULL, 'scheduleJob_update', '/scheduleJob@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (212, '定时任务根据id查询', NULL, 208, NULL, 'scheduleJob_*_get', '/scheduleJob/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (213, '定时任务根据id删除', NULL, 208, NULL, 'scheduleJob_*_delete','/scheduleJob/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (214, '查询所有定时任务', NULL, 208, NULL, 'scheduleJob_all_get','/scheduleJob/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (215, '定时任务日志', '', 0, NULL, NULL, NULL, NULL, 215, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (216, '定时任务日志', 'scheduleJobLog', 215, NULL, NULL, NULL, NULL, 216, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (217, '定时任务日志分页查询', NULL, 216, NULL, 'scheduleJobLog_get', '/scheduleJobLog@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (218, '定时任务日志添加', NULL, 216, NULL, 'scheduleJobLog_save', '/scheduleJobLog@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (219, '定时任务日志修改', NULL, 216, NULL, 'scheduleJobLog_update', '/scheduleJobLog@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (220, '定时任务日志根据id查询', NULL, 216, NULL, 'scheduleJobLog_*_get', '/scheduleJobLog/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (221, '定时任务日志根据id删除', NULL, 216, NULL, 'scheduleJobLog_*_delete','/scheduleJobLog/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (222, '查询所有定时任务日志', NULL, 216, NULL, 'scheduleJobLog_all_get','/scheduleJobLog/all@get', NULL, 6, 1);
-- 添加菜单识别
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (223, '图片管理', '', 0, NULL, NULL, NULL, NULL, 223, 0);
-- 添加菜单带名称
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (224, '图片管理', 'picture', 223, NULL, NULL, NULL, NULL, 224, 0);
-- 添加分页查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (225, '图片管理分页查询', NULL, 224, NULL, 'picture_get', '/picture@get', NULL, 1, 1);
-- 添加添加权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (226, '图片管理添加', NULL, 224, NULL, 'picture_save', '/picture@post', NULL, 2, 1);
-- 添加修改权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (227, '图片管理修改', NULL, 224, NULL, 'picture_update', '/picture@put', NULL, 3, 1);
-- 添加根据id查询权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (228, '图片管理根据id查询', NULL, 224, NULL, 'picture_*_get', '/picture/*@get', NULL, 4, 1);
-- 添加根据id删除权限
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (229, '图片管理根据id删除', NULL, 224, NULL, 'picture_*_delete','/picture/*@delete', NULL, 5, 1);
-- 查询所有
INSERT INTO `coupon`.`t_menu` (`menu_id`, `menu_name`, `url`, `m_pid`, `menu_code`, `permission_ui`, `permission`, `menu_describe`, `order_by`, `menu_type`) VALUES (230, '查询所有图片管理', NULL, 224, NULL, 'picture_all_get','/picture/all@get', NULL, 6, 1);

