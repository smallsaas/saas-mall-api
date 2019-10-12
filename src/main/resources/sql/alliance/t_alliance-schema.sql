/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-10-12 16:27:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_alliance
-- ----------------------------
DROP TABLE IF EXISTS `t_alliance`;
CREATE TABLE `t_alliance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `invitor_alliance_id` int(11) DEFAULT NULL COMMENT '邀请人id',
  `alliance_ship` int(11) NOT NULL DEFAULT '0' COMMENT '是否为盟友 0:否，1:临时，2:正式',
  `stockholder_ship` int(11) NOT NULL DEFAULT '0' COMMENT '是否为股东 0:否，1:是',
  `creation_time` datetime DEFAULT NULL COMMENT 'creation_time',
  `alliance_ship_time` datetime DEFAULT NULL COMMENT '成为盟友的时间',
  `stockholder_ship_time` datetime DEFAULT NULL COMMENT '成为股东的时间',
  `temp_alliance_expiry_time` timestamp NULL DEFAULT NULL COMMENT '临时盟友过期时间',
  `alliance_status` int(11) NOT NULL DEFAULT '0' COMMENT '盟友状态，0:禁止，1:正常',
  `alliance_store_amount` decimal(10,4) NOT NULL DEFAULT '0' COMMENT '入库金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
