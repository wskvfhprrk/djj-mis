/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.5.170
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 192.168.5.170:3306
 Source Schema         : lotmall

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 04/06/2021 14:02:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blacklist
-- ----------------------------
DROP TABLE IF EXISTS `blacklist`;
CREATE TABLE `blacklist`  (
  `id` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '站点编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '名称',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '黑名单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(10) UNSIGNED NOT NULL COMMENT '商品编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品名称',
  `price` decimal(10, 2) NOT NULL COMMENT '单价（元）',
  `discount_price` decimal(10, 2) NOT NULL COMMENT '折扣单价（元）',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '开始时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods_inventory
-- ----------------------------
DROP TABLE IF EXISTS `goods_inventory`;
CREATE TABLE `goods_inventory`  (
  `goods_id` int(10) UNSIGNED NOT NULL,
  `quantity` int(10) UNSIGNED NOT NULL COMMENT '库存数量',
  `frozen_quantity` int(10) UNSIGNED NOT NULL COMMENT '冻结数量',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`goods_id`) USING BTREE,
  UNIQUE INDEX `goods_id_UNIQUE`(`goods_id`) USING BTREE,
  CONSTRAINT `fk_goods_inventory_goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '商品库存表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for m_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `m_role_menu`;
CREATE TABLE `m_role_menu`  (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`menu_id`, `role_id`) USING BTREE,
  INDEX `FK_m_role_menu`(`role_id`) USING BTREE,
  CONSTRAINT `FK_m_role_menu` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单按纽中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_role_menu
-- ----------------------------
INSERT INTO `m_role_menu` VALUES (1, 1);
INSERT INTO `m_role_menu` VALUES (1, 2);
INSERT INTO `m_role_menu` VALUES (1, 3);
INSERT INTO `m_role_menu` VALUES (1, 4);
INSERT INTO `m_role_menu` VALUES (1, 6);
INSERT INTO `m_role_menu` VALUES (1, 7);
INSERT INTO `m_role_menu` VALUES (1, 8);
INSERT INTO `m_role_menu` VALUES (1, 9);
INSERT INTO `m_role_menu` VALUES (1, 10);
INSERT INTO `m_role_menu` VALUES (1, 12);
INSERT INTO `m_role_menu` VALUES (1, 13);
INSERT INTO `m_role_menu` VALUES (1, 14);
INSERT INTO `m_role_menu` VALUES (1, 15);
INSERT INTO `m_role_menu` VALUES (1, 16);
INSERT INTO `m_role_menu` VALUES (1, 17);
INSERT INTO `m_role_menu` VALUES (1, 18);
INSERT INTO `m_role_menu` VALUES (1, 19);
INSERT INTO `m_role_menu` VALUES (1, 20);
INSERT INTO `m_role_menu` VALUES (1, 36);
INSERT INTO `m_role_menu` VALUES (1, 73);
INSERT INTO `m_role_menu` VALUES (1, 74);
INSERT INTO `m_role_menu` VALUES (1, 77);
INSERT INTO `m_role_menu` VALUES (1, 78);
INSERT INTO `m_role_menu` VALUES (1, 79);
INSERT INTO `m_role_menu` VALUES (1, 80);
INSERT INTO `m_role_menu` VALUES (1, 82);
INSERT INTO `m_role_menu` VALUES (1, 86);
INSERT INTO `m_role_menu` VALUES (1, 90);
INSERT INTO `m_role_menu` VALUES (1, 92);
INSERT INTO `m_role_menu` VALUES (1, 93);
INSERT INTO `m_role_menu` VALUES (1, 94);
INSERT INTO `m_role_menu` VALUES (1, 95);
INSERT INTO `m_role_menu` VALUES (1, 96);
INSERT INTO `m_role_menu` VALUES (1, 97);
INSERT INTO `m_role_menu` VALUES (1, 98);
INSERT INTO `m_role_menu` VALUES (1, 99);
INSERT INTO `m_role_menu` VALUES (1, 100);
INSERT INTO `m_role_menu` VALUES (1, 101);
INSERT INTO `m_role_menu` VALUES (1, 102);
INSERT INTO `m_role_menu` VALUES (1, 103);
INSERT INTO `m_role_menu` VALUES (1, 104);
INSERT INTO `m_role_menu` VALUES (1, 105);
INSERT INTO `m_role_menu` VALUES (1, 106);
INSERT INTO `m_role_menu` VALUES (1, 107);
INSERT INTO `m_role_menu` VALUES (1, 108);
INSERT INTO `m_role_menu` VALUES (1, 109);
INSERT INTO `m_role_menu` VALUES (1, 110);
INSERT INTO `m_role_menu` VALUES (1, 111);
INSERT INTO `m_role_menu` VALUES (1, 112);
INSERT INTO `m_role_menu` VALUES (1, 113);
INSERT INTO `m_role_menu` VALUES (1, 116);
INSERT INTO `m_role_menu` VALUES (1, 118);
INSERT INTO `m_role_menu` VALUES (1, 119);
INSERT INTO `m_role_menu` VALUES (1, 120);
INSERT INTO `m_role_menu` VALUES (1, 121);
INSERT INTO `m_role_menu` VALUES (1, 125);
INSERT INTO `m_role_menu` VALUES (1, 126);
INSERT INTO `m_role_menu` VALUES (1, 127);
INSERT INTO `m_role_menu` VALUES (1, 128);
INSERT INTO `m_role_menu` VALUES (1, 129);
INSERT INTO `m_role_menu` VALUES (1, 130);
INSERT INTO `m_role_menu` VALUES (1, 135);
INSERT INTO `m_role_menu` VALUES (1, 138);
INSERT INTO `m_role_menu` VALUES (1, 139);
INSERT INTO `m_role_menu` VALUES (1, 140);
INSERT INTO `m_role_menu` VALUES (1, 141);
INSERT INTO `m_role_menu` VALUES (1, 142);
INSERT INTO `m_role_menu` VALUES (16, 90);
INSERT INTO `m_role_menu` VALUES (16, 92);
INSERT INTO `m_role_menu` VALUES (16, 93);
INSERT INTO `m_role_menu` VALUES (16, 94);
INSERT INTO `m_role_menu` VALUES (16, 95);
INSERT INTO `m_role_menu` VALUES (16, 96);
INSERT INTO `m_role_menu` VALUES (16, 97);
INSERT INTO `m_role_menu` VALUES (16, 98);
INSERT INTO `m_role_menu` VALUES (16, 99);
INSERT INTO `m_role_menu` VALUES (16, 100);
INSERT INTO `m_role_menu` VALUES (16, 101);
INSERT INTO `m_role_menu` VALUES (16, 102);
INSERT INTO `m_role_menu` VALUES (16, 103);
INSERT INTO `m_role_menu` VALUES (16, 104);
INSERT INTO `m_role_menu` VALUES (16, 105);
INSERT INTO `m_role_menu` VALUES (16, 106);
INSERT INTO `m_role_menu` VALUES (16, 107);
INSERT INTO `m_role_menu` VALUES (16, 108);
INSERT INTO `m_role_menu` VALUES (16, 109);
INSERT INTO `m_role_menu` VALUES (16, 110);
INSERT INTO `m_role_menu` VALUES (16, 111);
INSERT INTO `m_role_menu` VALUES (16, 112);
INSERT INTO `m_role_menu` VALUES (16, 113);
INSERT INTO `m_role_menu` VALUES (16, 116);
INSERT INTO `m_role_menu` VALUES (16, 118);
INSERT INTO `m_role_menu` VALUES (16, 119);
INSERT INTO `m_role_menu` VALUES (16, 120);
INSERT INTO `m_role_menu` VALUES (16, 121);
INSERT INTO `m_role_menu` VALUES (16, 125);
INSERT INTO `m_role_menu` VALUES (16, 126);
INSERT INTO `m_role_menu` VALUES (16, 127);
INSERT INTO `m_role_menu` VALUES (16, 128);
INSERT INTO `m_role_menu` VALUES (16, 129);
INSERT INTO `m_role_menu` VALUES (16, 130);
INSERT INTO `m_role_menu` VALUES (16, 135);
INSERT INTO `m_role_menu` VALUES (16, 138);
INSERT INTO `m_role_menu` VALUES (16, 139);
INSERT INTO `m_role_menu` VALUES (16, 140);
INSERT INTO `m_role_menu` VALUES (16, 141);
INSERT INTO `m_role_menu` VALUES (16, 142);
INSERT INTO `m_role_menu` VALUES (17, 111);
INSERT INTO `m_role_menu` VALUES (17, 112);
INSERT INTO `m_role_menu` VALUES (17, 113);
INSERT INTO `m_role_menu` VALUES (17, 116);
INSERT INTO `m_role_menu` VALUES (17, 118);
INSERT INTO `m_role_menu` VALUES (17, 119);
INSERT INTO `m_role_menu` VALUES (17, 120);
INSERT INTO `m_role_menu` VALUES (17, 121);
INSERT INTO `m_role_menu` VALUES (17, 125);
INSERT INTO `m_role_menu` VALUES (17, 126);
INSERT INTO `m_role_menu` VALUES (17, 127);
INSERT INTO `m_role_menu` VALUES (17, 128);
INSERT INTO `m_role_menu` VALUES (17, 129);
INSERT INTO `m_role_menu` VALUES (17, 135);
INSERT INTO `m_role_menu` VALUES (17, 138);
INSERT INTO `m_role_menu` VALUES (17, 140);
INSERT INTO `m_role_menu` VALUES (17, 141);
INSERT INTO `m_role_menu` VALUES (17, 142);

-- ----------------------------
-- Table structure for m_user_role
-- ----------------------------
DROP TABLE IF EXISTS `m_user_role`;
CREATE TABLE `m_user_role`  (
  `user_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'user_id',
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `FK_m_user_role2`(`role_id`) USING BTREE,
  CONSTRAINT `FK_m_user_role` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `FK_m_user_role2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '人员角色中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_user_role
-- ----------------------------
INSERT INTO `m_user_role` VALUES ('1', 1);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '订单编号',
  `store_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '商品名称',
  `goods_id` int(10) UNSIGNED NOT NULL,
  `quantity` int(10) UNSIGNED NOT NULL COMMENT '总数量',
  `amount` decimal(10, 2) NOT NULL COMMENT '总金额',
  `price` decimal(10, 2) NOT NULL COMMENT '单价（元）',
  `discount_price` decimal(10, 2) NOT NULL COMMENT '折扣单价（元）',
  `status` int(10) UNSIGNED NOT NULL COMMENT '状态（0-新建 1-确认 2-出库 3-签收 4-取消）',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '收件地址',
  `recipient` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '收件人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '联系电话',
  `delivery_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '出库批次',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '开始时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`id`) USING BTREE,
  INDEX `fk_order_store_id_idx`(`store_id`) USING BTREE,
  INDEX `fk_order_goods_id_idx`(`goods_id`) USING BTREE,
  CONSTRAINT `fk_order_goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_store_id` FOREIGN KEY (`store_id`) REFERENCES `store` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for orders_history
-- ----------------------------
DROP TABLE IF EXISTS `orders_history`;
CREATE TABLE `orders_history`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增编号',
  `order_id` bigint(20) UNSIGNED NOT NULL COMMENT '订单编号',
  `user` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `info` varchar(1024) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '操作内容',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 222 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '订单更新历史' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `id` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '站点编号',
  `clerk_id` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '工号',
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名称',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '地址',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '开始时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '站点信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menu_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `url` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url',
  `m_pid` int(11) NOT NULL COMMENT '菜单父id',
  `menu_code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单code',
  `permission_ui` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前台权限识别',
  `permission` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后台权限识别',
  `menu_describe` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `order_by` int(11) NOT NULL COMMENT '排序',
  `menu_type` int(1) NOT NULL COMMENT '类别：菜单为0；按纽为1',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 143 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, '系统管理', '', 0, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `t_menu` VALUES (2, '人员管理', 'user', 1, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `t_menu` VALUES (3, '角色管理', 'role', 1, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `t_menu` VALUES (4, '菜单管理', 'menu', 1, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `t_menu` VALUES (6, '人员修改', NULL, 2, NULL, 'user_update', '/user@put', NULL, 1, 1);
INSERT INTO `t_menu` VALUES (7, '人员添加', '', 2, NULL, 'user_save', '/user@post', NULL, 1, 1);
INSERT INTO `t_menu` VALUES (8, '人员查询', NULL, 2, NULL, 'user_search', '/user@get', NULL, 3, 1);
INSERT INTO `t_menu` VALUES (9, '人员删除', NULL, 2, NULL, 'user_delete', '/user/*@delete', NULL, 4, 1);
INSERT INTO `t_menu` VALUES (10, '人员明细', NULL, 2, NULL, 'user_search_info', '/user/*@get', NULL, 5, 1);
INSERT INTO `t_menu` VALUES (12, '角色修改', NULL, 3, NULL, 'role_update', '/role@put', NULL, 2, 1);
INSERT INTO `t_menu` VALUES (13, '角色查询', NULL, 3, NULL, 'role_search', '/role@get', NULL, 3, 1);
INSERT INTO `t_menu` VALUES (14, '角色删除', NULL, 3, NULL, 'role_delete', '/role/*@delete', NULL, 4, 1);
INSERT INTO `t_menu` VALUES (15, '角色明细', NULL, 3, NULL, 'role_search_info', '/role/*@get', NULL, 5, 1);
INSERT INTO `t_menu` VALUES (16, '菜单添加', NULL, 4, NULL, 'menu_save', '/menu@post', NULL, 1, 1);
INSERT INTO `t_menu` VALUES (17, '菜单修改', NULL, 4, NULL, 'menu_update', '/menu@put', NULL, 2, 1);
INSERT INTO `t_menu` VALUES (18, '登陆菜单查询', NULL, 4, NULL, 'menu_search', '/menus@get', NULL, 3, 1);
INSERT INTO `t_menu` VALUES (19, '菜单删除', NULL, 4, NULL, 'menu_delete', '/menu/*@delete', NULL, 4, 1);
INSERT INTO `t_menu` VALUES (20, '菜单明细', NULL, 4, NULL, 'menu_search_info', '/menu/*@get', NULL, 5, 1);
INSERT INTO `t_menu` VALUES (36, '重置密码', NULL, 2, NULL, NULL, '/resetPassword@post', NULL, 6, 1);
INSERT INTO `t_menu` VALUES (73, '添加角色', NULL, 3, NULL, NULL, '/role@post', NULL, 1, 1);
INSERT INTO `t_menu` VALUES (74, '角色授权', '', 3, NULL, NULL, '/userRole@post', NULL, 6, 1);
INSERT INTO `t_menu` VALUES (77, '所有菜单', NULL, 4, NULL, NULL, '/menu@get', NULL, 3, 1);
INSERT INTO `t_menu` VALUES (78, '人员角色', NULL, 3, NULL, NULL, '/allMenu/*@get', NULL, 6, 1);
INSERT INTO `t_menu` VALUES (79, '角色权限绑定', NULL, 3, NULL, NULL, '/roleMenu@post', NULL, 7, 1);
INSERT INTO `t_menu` VALUES (80, '所有父级菜单', NULL, 4, NULL, NULL, '/parentMenu@get', NULL, 7, 1);
INSERT INTO `t_menu` VALUES (82, '根据用户类型查询', NULL, 2, NULL, NULL, '/alluser/*@get', NULL, 8, 1);
INSERT INTO `t_menu` VALUES (86, '查看所有角色', NULL, 2, NULL, NULL, '/allRole@get', NULL, 0, 1);
INSERT INTO `t_menu` VALUES (90, '促销票管理', NULL, 0, NULL, NULL, NULL, NULL, 2, 0);
INSERT INTO `t_menu` VALUES (92, '促销票', 'goods', 90, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `t_menu` VALUES (93, '列表', NULL, 92, NULL, NULL, '/goods@get', NULL, 1, 1);
INSERT INTO `t_menu` VALUES (94, '添加促销票', NULL, 92, NULL, NULL, '/goods@post', NULL, 2, 1);
INSERT INTO `t_menu` VALUES (95, '修改促销票', NULL, 92, NULL, NULL, '/goods@put', NULL, 3, 1);
INSERT INTO `t_menu` VALUES (96, '删除促销票', NULL, 92, NULL, NULL, '/goods/*@delete', NULL, 0, 1);
INSERT INTO `t_menu` VALUES (97, '根据id查询', NULL, 92, NULL, NULL, '/goods/*@get', NULL, 5, 1);
INSERT INTO `t_menu` VALUES (98, '促销票库存管理', 'goodsInventory', 90, NULL, NULL, NULL, NULL, 2, 0);
INSERT INTO `t_menu` VALUES (99, '库存列表', NULL, 98, NULL, NULL, '/goodsInventory@get', NULL, 1, 1);
INSERT INTO `t_menu` VALUES (100, '根据id查询', NULL, 98, NULL, NULL, '/goodsInventory/*@get', NULL, 2, 1);
INSERT INTO `t_menu` VALUES (101, '修改', NULL, 98, NULL, NULL, '/goodsInventory@put', NULL, 3, 1);
INSERT INTO `t_menu` VALUES (102, '删除', NULL, 98, NULL, NULL, '/goodsInventory/*@delete', NULL, 4, 1);
INSERT INTO `t_menu` VALUES (103, '添加', NULL, 98, NULL, NULL, '/goodsInventory@post', NULL, 5, 1);
INSERT INTO `t_menu` VALUES (104, '站点管理', NULL, 0, NULL, NULL, NULL, NULL, 3, 0);
INSERT INTO `t_menu` VALUES (105, '站点列表', 'store', 104, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `t_menu` VALUES (106, '查询', NULL, 105, NULL, NULL, '/store@get', NULL, 0, 1);
INSERT INTO `t_menu` VALUES (107, '根据id查询', NULL, 105, NULL, NULL, '/store/*@get', NULL, 2, 1);
INSERT INTO `t_menu` VALUES (108, '添加站点', NULL, 105, NULL, NULL, '/store@post', NULL, 3, 1);
INSERT INTO `t_menu` VALUES (109, '修改站点', NULL, 105, NULL, NULL, '/store@put', NULL, 4, 1);
INSERT INTO `t_menu` VALUES (110, '删除站点', NULL, 105, NULL, NULL, '/store/*@delete', NULL, 2, 1);
INSERT INTO `t_menu` VALUES (111, '订单管理', NULL, 0, NULL, NULL, NULL, NULL, 4, 0);
INSERT INTO `t_menu` VALUES (112, '订单管理', 'orders', 111, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `t_menu` VALUES (113, '订单查询', NULL, 112, NULL, NULL, '/orders@get', NULL, 1, 1);
INSERT INTO `t_menu` VALUES (116, '删除订单', NULL, 112, NULL, NULL, '/orders/*@delete', NULL, 5, 1);
INSERT INTO `t_menu` VALUES (118, '取消订单', NULL, 112, NULL, NULL, '/canalOrder@put', NULL, 0, 1);
INSERT INTO `t_menu` VALUES (119, '批量取消订单', NULL, 112, NULL, NULL, '/batchCanalOrder@put', NULL, 0, 1);
INSERT INTO `t_menu` VALUES (120, '批量确认订单', NULL, 112, NULL, NULL, '/batchAffirmOrder/*@put', NULL, 7, 1);
INSERT INTO `t_menu` VALUES (121, '批量出库', NULL, 112, NULL, NULL, '/batchDeliveryStroe@put', NULL, 9, 1);
INSERT INTO `t_menu` VALUES (125, '导出excel', NULL, 112, NULL, NULL, '/downloadExcel@get', NULL, 8, 1);
INSERT INTO `t_menu` VALUES (126, '黑名单管理', NULL, 0, NULL, NULL, NULL, NULL, 6, 0);
INSERT INTO `t_menu` VALUES (127, '黑名单管理', 'blacklist', 126, NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `t_menu` VALUES (128, '列表', NULL, 126, NULL, NULL, '/blacklist@get', NULL, 1, 1);
INSERT INTO `t_menu` VALUES (129, '删除黑名单', NULL, 126, NULL, NULL, '/blacklist/*@delete', NULL, 2, 1);
INSERT INTO `t_menu` VALUES (130, '校验站点编号', NULL, 105, NULL, NULL, '/validId/*@get', NULL, 6, 1);
INSERT INTO `t_menu` VALUES (133, '测试子菜单1', '5656', 132, NULL, NULL, NULL, NULL, 0, 0);
INSERT INTO `t_menu` VALUES (134, '测试菜单子菜单2', NULL, 132, NULL, NULL, '343', NULL, 454, 1);
INSERT INTO `t_menu` VALUES (135, '每日订单', 'getOrderByDay', 111, NULL, NULL, NULL, NULL, 2, 0);
INSERT INTO `t_menu` VALUES (138, '批量签收', NULL, 112, NULL, NULL, '/batchSign/*@put', NULL, 7, 1);
INSERT INTO `t_menu` VALUES (139, '上传站点列表', NULL, 105, NULL, NULL, '/loadStore@post', NULL, 6, 1);
INSERT INTO `t_menu` VALUES (140, '历史记录', NULL, 112, NULL, NULL, '/ordersHistory@get', NULL, 0, 1);
INSERT INTO `t_menu` VALUES (141, '查询每日订单', NULL, 135, NULL, NULL, '/getOrderByDay@get', NULL, 1, 1);
INSERT INTO `t_menu` VALUES (142, '查询所有的站点', NULL, 112, NULL, NULL, '/storeAll@get', NULL, 8, 1);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_describe` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '超级管理员', '超级管理员');
INSERT INTO `t_role` VALUES (16, '企业管理员', '除系统管理外的一切权限');
INSERT INTO `t_role` VALUES (17, '业务员', '仅管理订单和黑名单管理');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'user_id',
  `username` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '随机加密数',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮件地址',
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址（给商家使用）',
  `user_type` int(11) NOT NULL COMMENT '账户类别：1_公司；2_商家；4回收渠道',
  `status` int(11) NOT NULL COMMENT '账户状态：0_正常;1_异常:2_锁定',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  `remark` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `token` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'token不记录数据',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '人员信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'AAA42296669B958C3CEE6C0475C8093E', '1', '超级管理员', 'admin@email.com', '13800000000', '地址', 1, 0, '2019-03-26 00:00:00', '2019-03-28 00:00:00', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
