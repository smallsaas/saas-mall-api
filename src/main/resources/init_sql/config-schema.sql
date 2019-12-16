SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `t_config_global`;
CREATE TABLE `t_config_global` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lang` varchar(8) NOT NULL COMMENT '选定的语言',
  `selected` smallint DEFAULT 0 COMMENT '选定的语言',
  UNIQUE(lang),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- field config --

DROP TABLE IF EXISTS `t_config_field_group`;
CREATE TABLE `t_config_field_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '上级分组id',
  `lang` varchar(8) DEFAULT NULL COMMENT '区分语言',
  `name` varchar(26) NOT NULL COMMENT '分组名称',
  `comment` text DEFAULT NULL COMMENT '分组描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `type` varchar(26) DEFAULT NULL COMMENT '类型(区分不同分组)',
  UNIQUE(lang,name,type),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_config_field`;
CREATE TABLE `t_config_field` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `field` varchar(100) NOT NULL COMMENT '领域',
  `group_id` bigint(20) NOT NULL COMMENT '所属分组',
  `lang` varchar(8) DEFAULT NULL COMMENT '区分语言',
  `name` varchar(26) NOT NULL COMMENT '配置名称',
  `value` text DEFAULT NULL COMMENT '值',
  `data_type` varchar(26) DEFAULT NULL COMMENT '值类型',
  `description` text DEFAULT NULL COMMENT '配置描述',
  UNIQUE(field,lang),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_config_field_item`;
CREATE TABLE `t_config_field_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `field` varchar(100) NOT NULL COMMENT '领域',
  `lang` varchar(8) DEFAULT NULL COMMENT '区分语言',
  `name` varchar(26) DEFAULT NULL COMMENT '独立语言名称',
  `value` text DEFAULT NULL COMMENT '值',
  UNIQUE(lang,name),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `t_config_global` (`id`, `lang`, `selected`) VALUES ('1', 'zh', '1');
INSERT INTO `t_config_global` (`id`, `lang`, `selected`) VALUES ('2', 'en', '0');


SET FOREIGN_KEY_CHECKS=1;
