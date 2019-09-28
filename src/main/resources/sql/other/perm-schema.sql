/*
 Navicat Premium Data Transfer

 Source Server         : 120.79.49.72
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 120.79.49.72:3306
 Source Schema         : mall_product_order2

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 28/09/2019 13:49:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for perm
-- ----------------------------
DROP TABLE IF EXISTS `perm`;
CREATE TABLE `perm`  (
  `id` bigint(20) NOT NULL,
  `groupid` bigint(20) NULL DEFAULT NULL,
  `identifier` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `groupid`(`groupid`) USING BTREE,
  CONSTRAINT `perm_ibfk_1` FOREIGN KEY (`groupid`) REFERENCES `perm_group` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
