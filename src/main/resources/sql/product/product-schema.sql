/*
 Navicat Premium Data Transfer

 Source Server         : 120.79.49.72
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 120.79.49.72:3306
 Source Schema         : muaskin_MallWebapp

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 25/07/2019 15:53:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) NOT NULL DEFAULT '0',
  `brand_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `short_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `cover` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `stock_balance` int(11) NULL DEFAULT 0,
  `sales` int(11) NOT NULL DEFAULT 0,
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_date` datetime(0) NULL DEFAULT NULL,
  `last_modified_date` datetime(0) NULL DEFAULT NULL,
  `unit` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `cost_price` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `suggested_price` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `distribution_price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '分销价',
  `promoted` int(11) NOT NULL DEFAULT 0,
  `freight` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `free_shipping` int(11) NOT NULL DEFAULT 0,
  `sort_num` int(11) NULL DEFAULT 100,
  `partner_level_zone` int(11) NULL DEFAULT NULL,
  `view_count` bigint(20) NULL DEFAULT 0,
  `fare_id` bigint(20) NULL DEFAULT NULL,
  `barcode` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `store_location` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `weight` int(11) NULL DEFAULT 0,
  `bulk` int(11) NULL DEFAULT 0,
  `sku_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sku_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sku_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `bar_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `mid` int(11) NULL DEFAULT NULL COMMENT '商家id',
  `allow_coupon` int(11) NULL DEFAULT 0 COMMENT '优惠活动-优惠券',
  `credit` int(11) NULL DEFAULT 0 COMMENT '优惠活动-可用积分',
  `is_virtual` int(11) NULL DEFAULT 0 COMMENT '是否虚拟产品',
  `required_participate_exam` int(11) NULL DEFAULT 0 COMMENT '是否需要做了检测才可以购买',
  `org_id` bigint(20) default null COMMENT '组织部门',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  INDEX `fare_id`(`fare_id`) USING BTREE,
  INDEX `brand_id`(`brand_id`) USING BTREE,
  CONSTRAINT `t_product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `t_product_category` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `t_product_ibfk_2` FOREIGN KEY (`fare_id`) REFERENCES `t_fare_template` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT,
  CONSTRAINT `t_product_ibfk_3` FOREIGN KEY (`brand_id`) REFERENCES `t_product_brand` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_product_brand`;
CREATE TABLE `t_product_brand`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `org_id` bigint(20) NOT NULL COMMENT '组织(部门)ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_category
-- ----------------------------
DROP TABLE IF EXISTS `t_product_category`;
CREATE TABLE `t_product_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `cover` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sort_num` int(11) NULL DEFAULT 100,
  `promoted` int(11) NULL DEFAULT 1,
  `visible` int(11) NULL DEFAULT 1,
  `promoted_product_count` int(11) NULL DEFAULT 3,
  `wholesale` int(11) NULL DEFAULT 0,
  `is_show_products` int(11) NULL DEFAULT 1,
  `org_id` bigint(20) default null comment '组织(部门)ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parent_id`(`parent_id`) USING BTREE,
  CONSTRAINT `t_product_category_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `t_product_category` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_category_property
-- ----------------------------
DROP TABLE IF EXISTS `t_product_category_property`;
CREATE TABLE `t_product_category_property`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) NOT NULL,
  `display_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `value_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `input_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `candidate_values` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `default_value` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `is_required` int(11) NULL DEFAULT 0,
  `sort_num` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  CONSTRAINT `t_product_category_property_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `t_product_category` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_description
-- ----------------------------
DROP TABLE IF EXISTS `t_product_description`;
CREATE TABLE `t_product_description`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `t_product_description_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_favorite
-- ----------------------------
DROP TABLE IF EXISTS `t_product_favorite`;
CREATE TABLE `t_product_favorite`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `collect_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `t_product_favorite_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `t_product_favorite_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_hit_word
-- ----------------------------
DROP TABLE IF EXISTS `t_product_hit_word`;
CREATE TABLE `t_product_hit_word`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `hit` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_image
-- ----------------------------
DROP TABLE IF EXISTS `t_product_image`;
CREATE TABLE `t_product_image`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `type` int(11) NOT NULL DEFAULT 0,
  `name` varchar(100) DEFAULT NULL COMMENT '图片名',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `sort_num` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `t_product_image_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_property
-- ----------------------------
DROP TABLE IF EXISTS `t_product_property`;
CREATE TABLE `t_product_property`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `property_id` bigint(20) NOT NULL,
  `property_value` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  INDEX `property_id`(`property_id`) USING BTREE,
  CONSTRAINT `t_product_property_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `t_product_property_ibfk_2` FOREIGN KEY (`property_id`) REFERENCES `t_product_category_property` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_purchase_strategy
-- ----------------------------
DROP TABLE IF EXISTS `t_product_purchase_strategy`;
CREATE TABLE `t_product_purchase_strategy`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_purchase_strategy_item
-- ----------------------------
DROP TABLE IF EXISTS `t_product_purchase_strategy_item`;
CREATE TABLE `t_product_purchase_strategy_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `strategy_id` bigint(20) NOT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `operator` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `sort_num` int(11) NULL DEFAULT NULL,
  `param` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `strategy_id`(`strategy_id`) USING BTREE,
  CONSTRAINT `t_product_purchase_strategy_item_ibfk_1` FOREIGN KEY (`strategy_id`) REFERENCES `t_product_purchase_strategy` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_purchase_strategy_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_product_purchase_strategy_relation`;
CREATE TABLE `t_product_purchase_strategy_relation`  (
  `product_id` bigint(20) NOT NULL,
  `strategy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`product_id`, `strategy_id`) USING BTREE,
  INDEX `strategy_id`(`strategy_id`) USING BTREE,
  CONSTRAINT `t_product_purchase_strategy_relation_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `t_product_purchase_strategy_relation_ibfk_2` FOREIGN KEY (`strategy_id`) REFERENCES `t_product_purchase_strategy` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_settlement_proportion
-- ----------------------------
DROP TABLE IF EXISTS `t_product_settlement_proportion`;
CREATE TABLE `t_product_settlement_proportion`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `proportion` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `level` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `t_product_settlement_proportion_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 330 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_specification
-- ----------------------------
DROP TABLE IF EXISTS `t_product_specification`;
CREATE TABLE `t_product_specification`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `stock_balance` int(11) NULL DEFAULT 0,
  `price` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `cost_price` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `suggested_price` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `weight` int(11) NULL DEFAULT 0,
  `bulk` int(11) NULL DEFAULT 0,
  `sku_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sku_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sku_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `bar_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `t_product_specification_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_product_tag`;
CREATE TABLE `t_product_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identifier` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标签标识',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标签名称',
  `sort_num` int(11) NULL DEFAULT 1 COMMENT '排序号',
  `org_id` bigint(20) NOT NULL COMMENT '组织(部门)ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `identifier`(`identifier`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_product_tag_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_product_tag_relation`;
CREATE TABLE `t_product_tag_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tag_id`(`tag_id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `t_product_tag_relation_ibfk_1` FOREIGN KEY (`tag_id`) REFERENCES `t_product_tag` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `t_product_tag_relation_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_fare_template
-- ----------------------------
DROP TABLE IF EXISTS `t_fare_template`;
CREATE TABLE `t_fare_template`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `shop_addr` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `dispatch_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `is_incl_postage` int(11) NULL DEFAULT 1,
  `valuation_model` int(11) NOT NULL,
  `is_incl_postage_by_if` int(11) NULL DEFAULT 0,
  `last_modified_date` datetime(0) NULL DEFAULT NULL,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `message_format` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `org_id` bigint(20) NOT NULL COMMENT '组织(部门)ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_incl_postage_proviso
-- ----------------------------
DROP TABLE IF EXISTS `t_incl_postage_proviso`;
CREATE TABLE `t_incl_postage_proviso`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fare_id` bigint(20) NOT NULL,
  `region` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `piece_no` int(11) NULL DEFAULT NULL,
  `weight_no` int(11) NULL DEFAULT NULL,
  `bulk_no` int(11) NULL DEFAULT NULL,
  `amount` decimal(18, 2) NULL DEFAULT NULL,
  `carry_way` int(11) NULL DEFAULT 0,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fare_id`(`fare_id`) USING BTREE,
  CONSTRAINT `t_incl_postage_proviso_ibfk_1` FOREIGN KEY (`fare_id`) REFERENCES `t_fare_template` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_carry_mode
-- ----------------------------
DROP TABLE IF EXISTS `t_carry_mode`;
CREATE TABLE `t_carry_mode`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fare_id` bigint(20) NOT NULL,
  `region` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `first_piece` int(11) NULL DEFAULT NULL,
  `first_weight` int(11) NULL DEFAULT NULL,
  `first_bulk` int(11) NULL DEFAULT NULL,
  `first_amount` decimal(18, 2) NOT NULL,
  `second_piece` int(11) NULL DEFAULT NULL,
  `second_weight` int(11) NULL DEFAULT NULL,
  `second_bulk` int(11) NULL DEFAULT NULL,
  `second_amount` decimal(18, 2) NOT NULL,
  `carry_way` int(11) NULL DEFAULT 0,
  `is_default` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fare_id`(`fare_id`) USING BTREE,
  CONSTRAINT `t_carry_mode_ibfk_1` FOREIGN KEY (`fare_id`) REFERENCES `t_fare_template` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_trial
-- ----------------------------
DROP TABLE IF EXISTS `t_trial`;
CREATE TABLE `t_trial`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL COMMENT '产品id',
  `price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '价格',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '试用装名称',
  `short_note` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '简短描述',
  `enabled` int(11) NULL DEFAULT 0 COMMENT '是否启用',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '有效申请时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '试用装封面',
  `note` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '描述',
  `sort_num` int(11) NULL DEFAULT 100 COMMENT '排序号',
  `shipping_type` int(11) NULL DEFAULT 0 COMMENT '运费支付 0 商家 1 顾客',
  `payment_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付方式',
  `version` int(11) NULL DEFAULT 1 COMMENT '版本号',
  `org_id` bigint(20) NOT NULL COMMENT '组织(部门)ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_trial_image
-- ----------------------------
DROP TABLE IF EXISTS `t_trial_image`;
CREATE TABLE `t_trial_image`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trial_id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '图片名',
  `url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `sort_num` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `trial_id`(`trial_id`) USING BTREE,
  CONSTRAINT `t_trial_image_ibfk_1` FOREIGN KEY (`trial_id`) REFERENCES `t_trial` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;


SET FOREIGN_KEY_CHECKS = 1;
