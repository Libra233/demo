/*
 Navicat Premium Data Transfer

 Source Server         : lunix(main)
 Source Server Type    : MySQL
 Source Server Version : 50631
 Source Host           : 192.168.64.131:3306
 Source Schema         : test0

 Target Server Type    : MySQL
 Target Server Version : 50631
 File Encoding         : 65001

 Date: 15/01/2019 19:26:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user0
-- ----------------------------
DROP TABLE IF EXISTS `user0`;
CREATE TABLE `user0`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '登录的用户序号',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `age` int(11) NOT NULL COMMENT '用户年龄',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '这是案例用户测试表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user0
-- ----------------------------
INSERT INTO `user0` VALUES (1, 'root', '123456', 23);

SET FOREIGN_KEY_CHECKS = 1;
