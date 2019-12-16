SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `t_operation_log`;
CREATE TABLE `t_operation_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `org_id` bigint(20) DEFAULT '0' COMMENT '组织id',
  `log_type` varchar(50) DEFAULT NULL COMMENT '日志类型',
  `log_name` varchar(200) DEFAULT NULL COMMENT '日志名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '操作用户ID',
  `user_name` varchar(200) DEFAULT NULL COMMENT '操作用户名称',
  `target_id` bigint(20) DEFAULT NULL COMMENT '[未知]',
  `target_type` varchar(50) DEFAULT NULL COMMENT '[未知]',
  `class_name` varchar(200) DEFAULT NULL COMMENT '操作类名称',
  `method` varchar(200) DEFAULT NULL COMMENT '操作方法名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '日志创建时间',
  `result` varchar(200) DEFAULT NULL COMMENT '操作结果',
  `message` text COMMENT '附带信息',
  `module` VARCHAR(100) DEFAULT NULL COMMENT '模块',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS=1;