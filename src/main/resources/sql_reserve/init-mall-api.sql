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




-- ----------------------------
-- Table structure for t_config
-- ----------------------------



-- ----------------------------
-- Table structure for system
-- ----------------------------

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(26) NOT NULL COMMENT '类型ID',
  `category_id` BIGINT(20) NOT NULL DEFAULT '0' COMMENT '类别ID',
  `user_id` BIGINT(20) NOT NULL COMMENT '用户ID',
  `title` VARCHAR(255) NOT NULL COMMENT '标题',
  `sub_title` VARCHAR(255) default NULL COMMENT '章节数',
  `sub_head` VARCHAR(255) default NULL COMMENT '原文',
  `summary` text default NULL COMMENT '内容摘要',
  `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `sticky` INT(11) NOT NULL DEFAULT '0' COMMENT '1置顶,0不置顶',
  `display` INT(11) NOT NULL DEFAULT '1' COMMENT '是否显示，1显示',
  `recommended` INT(11) NOT NULL DEFAULT '0' COMMENT '1精华帖,0普通帖',
  `visit_count` INT(11) NOT NULL DEFAULT '0' COMMENT '阅读量',
  `like_count` INT(11) NOT NULL DEFAULT '0' COMMENT '点赞数量',
  `favorite_count` INT(11) NOT NULL DEFAULT '0' COMMENT '收藏数量',
  `status` VARCHAR(50) NOT NULL DEFAULT 'Draft' COMMENT '状态:Draft-草稿，Published-发布',
   `author` VARCHAR(50)  not null COMMENT '作者',
   `cover` VARCHAR(255)  default null COMMENT '封面',
   `update_time` datetime default NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `article_product_relation`;
CREATE TABLE `article_product_relation` (
  `article_id` BIGINT(20) NOT NULL COMMENT '资讯ID',
  `target_id` BIGINT(20) NOT NULL COMMENT '产品ID',
  `target_type` varchar(26) NOT NULL COMMENT '类型',
  unique(`article_id`,`target_id`,`target_type`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
-- ----------------------------
-- Table structure for article_category
-- ----------------------------
DROP TABLE IF EXISTS `article_category`;
CREATE TABLE `article_category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `type_id` BIGINT(20) NOT NULL COMMENT '类别ID',
  `name` VARCHAR(255) NOT NULL COMMENT '类别名称',
  `cover` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '图片',
  `allow_image` INT(11) NOT NULL DEFAULT '1' COMMENT '允许上传图片',
  `fast_entry` INT(11) NOT NULL DEFAULT '0' COMMENT '快速入口标记',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for article_content
-- ----------------------------
DROP TABLE IF EXISTS `article_content`;
CREATE TABLE `article_content` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `article_id` BIGINT(20) NOT NULL COMMENT '文章ID',
  `content` TEXT NOT NULL COMMENT '内容',
  unique(`article_id`),
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for article_image
-- ----------------------------
DROP TABLE IF EXISTS `article_image`;
CREATE TABLE `article_image` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `article_id` BIGINT(20) NOT NULL COMMENT '文章ID',
  `url` VARCHAR(255) NOT NULL COMMENT '图片地址',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for article_type
-- ----------------------------
DROP TABLE IF EXISTS `article_type`;
CREATE TABLE `article_type` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `identifier` BIGINT(20) NOT NULL COMMENT '类别id',
  `name` VARCHAR(255) NOT NULL COMMENT '类别名称',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for t_stock_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_evaluation`;
CREATE TABLE `t_stock_evaluation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stock_id` bigint(20) NOT NULL COMMENT '评价对象ID',
  `member_id` bigint(20) NOT NULL COMMENT '用户id',
  `member_name` varchar(50) default null COMMENT '用户昵称',
  `stock_type` varchar(26) NOT NULL COMMENT '评价对象类型 评价为 商品/订单/其他',
  `origin_id` bigint(20) NOT NULL COMMENT '评价最上层父节点id',
  `origin_type` varchar(26) NOT NULL COMMENT '评价最上层节点type',
  `content` text default NULL COMMENT '评价信息',
  `is_display` smallint default '1' COMMENT '默认显示',
  `is_stick` smallint default '0' COMMENT '是否置顶 默认不置顶',
  `status` varchar(26) default null COMMENT '状态',
  `stock_tag` varchar(50) default null COMMENT '选填多层嵌套索引',
  `trade_number`  varchar(26) DEFAULT NULL COMMENT '订单编号',
  `trade_time`  datetime default null COMMENT '下单时间',
  `create_time` timestamp not null default current_timestamp COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for t_stock_evaluation_addition
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_evaluation_addition`;
CREATE TABLE `t_stock_evaluation_addition` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `evaluate_id` BIGINT(20) NOT NULL COMMENT '外键',
  `note` TEXT NOT NULL COMMENT '评价信息',
  `status` VARCHAR(26) DEFAULT NULL COMMENT '状态',
  `is_display` SMALLINT(6) DEFAULT '1' COMMENT '默认显示',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for t_stock_evaluation_image
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_evaluation_image`;
CREATE TABLE `t_stock_evaluation_image` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `evaluate_id` BIGINT(20) DEFAULT NULL COMMENT '外键',
  `url` VARCHAR(255) DEFAULT NULL COMMENT '图片',
  `status` VARCHAR(26) DEFAULT NULL COMMENT '状态',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `evaluation_addition_id` BIGINT(20) DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for t_stock_evaluation_star
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_evaluation_star`;
CREATE TABLE `t_stock_evaluation_star` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `evaluate_id` BIGINT(20) NOT NULL COMMENT '外键',
  `star_name` VARCHAR(255) DEFAULT NULL COMMENT '星级名称',
  `star_value` SMALLINT(6) DEFAULT NULL COMMENT '星级值',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for t_stock_favorite
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_favorite`;
CREATE TABLE `t_stock_favorite` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `member_id` BIGINT(20) NOT NULL COMMENT '用户ID',
  `member_name` BIGINT(20) NOT NULL COMMENT '用户ID',
  `stock_id` BIGINT(20) NOT NULL COMMENT '收藏对象ID',
  `stock_name` BIGINT(20) NOT NULL COMMENT '收藏对象',
  `stock_type` VARCHAR(20) NOT NULL COMMENT '收藏类型类型',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY(`member_id`,`stock_id`,`stock_type`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for t_stock_flower
-- ----------------------------
DROP TABLE IF EXISTS `t_stock_flower`;
CREATE TABLE `t_stock_flower` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `member_id` BIGINT(20) NOT NULL COMMENT '用户ID',
  `member_name` VARCHAR(20) NOT NULL COMMENT '点赞用户',
  `stock_id` BIGINT(20) NOT NULL COMMENT '点赞对象ID',
  `stock_name` BIGINT(20) NOT NULL COMMENT '点赞对象对象',
  `stock_type` VARCHAR(20) NOT NULL COMMENT '点赞对象类型',
  `flower_count` INT(11) DEFAULT '0' COMMENT '点赞次数',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY (`member_id`,`stock_id`,`stock_type`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- sys_org
DROP TABLE IF EXISTS `t_sys_org`;
CREATE TABLE `t_sys_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` bigint(20) default NULL COMMENT '父部门id',
  `name` varchar(60) NOT NULL COMMENT '部门名称',
  `org_code` varchar(50) DEFAULT NULL COMMENT '部门编号',
  `full_name` varchar(128) DEFAULT NULL COMMENT '部门全称',
  `node_level` int(11) NOT NULL DEFAULT 0 COMMENT '所在层级 (0,1,2)',
  `left_num` int(11) NOT NULL default 1 COMMENT '左下标',
  `right_num` int(11) NOT NULL default 2 COMMENT '右下标',
  `note` text DEFAULT NULL COMMENT '部门描述',
  `status` varchar(26) NOT NULL default 'NORMAL' COMMENT '状态',
  `org_type` smallint NOT NULL default 0 COMMENT '默认 org_type = 1 时信息为租户，非租户 org_type = 0 ,platform org_type = 2',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE(`pid`,`name`),
  UNIQUE(`org_code`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sys_position
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_position`;
CREATE TABLE `t_sys_position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '职位名称',
  `pos_code` varchar(20) NOT NULL COMMENT '职位代码',
  `org_id` bigint(20) NOT NULL COMMENT '职位所属部门id',
  `note` text COMMENT '职位描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for t_org_user_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_org_user_relation`;
CREATE TABLE `t_org_user_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) NOT NULL COMMENT '员工ID',
  `org_position` varchar(100) NOT NULL COMMENT '职位(职称)',
  `org_id` bigint(20) NOT NULL COMMENT '组织id',
  `position_id` bigint(20) NOT NULL COMMENT '职位id',
  `is_leader` smallint(6) NOT NULL DEFAULT '0' COMMENT '是否是管理员',
  `is_primary` smallint(6) NOT NULL DEFAULT '0' COMMENT '是否为主要的',
  PRIMARY KEY (`id`),
  UNIQUE KEY (`user_id`,`org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `ow_menu`;
CREATE TABLE `ow_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) DEFAULT NULL COMMENT '上级菜单',
  `name` varchar(50) NOT NULL COMMENT '菜单名',
	`page_id` bigint(20) DEFAULT NULL COMMENT '页面Id',
	`constant` smallint(6) DEFAULT 0 COMMENT '是否不可修改',
	`display` smallint(6) DEFAULT 1 COMMENT '是否显示',
	`seq` smallint(6) DEFAULT 0 NOT NULL COMMENT '排序号',
	`note` varchar(50) DEFAULT NULL COMMENT '备注',
	`lowest` smallint(6) DEFAULT 1 COMMENT '是否为最下级',
	`identifier` VARCHAR(50) DEFAULT NULL COMMENT '唯一标识(一级菜单)',
	`cover` varchar(255) DEFAULT NULL COMMENT '图片url',
	`html` varchar(50)  DEFAULT NULL COMMENT '基础页面关联的html名字',
    `ad_identifier` varchar(50)  DEFAULT NULL COMMENT '对应广告组identifier',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 collate utf8mb4_unicode_ci;


-- 富文本页面
DROP TABLE IF EXISTS `ow_page_text`;
CREATE TABLE `ow_page_text` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `page_id` bigint(20) DEFAULT NULL COMMENT '所属页id',
  `content` text DEFAULT NULL COMMENT '文本内容',
  PRIMARY KEY (`id`),
  UNIQUE KEY `page_id` (`page_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 collate utf8mb4_unicode_ci;

-- 页面
DROP TABLE IF EXISTS `ow_page`;
CREATE TABLE `ow_page` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '页面名称',
  `type` varchar(50) DEFAULT 'rtf' COMMENT '页面类型[HTML,RTF]',
	`url` varchar(255) DEFAULT NULL COMMENT '页面url',
	`constant` smallint(6) DEFAULT 0 COMMENT '页面是否不可修改',
	`identifier` VARCHAR(50) DEFAULT NULL COMMENT '唯一标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 collate utf8mb4_unicode_ci;




-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '内容',
  `type` varchar(255) DEFAULT NULL COMMENT '类型[系统System,内部Internal,外部External]',
  `status` varchar(255) DEFAULT 'Draft' COMMENT '状态',
  `enabled` smallint(5) NOT NULL default 1 COMMENT '是否启用 0-否 1-是',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `end_time` datetime DEFAULT NULL COMMENT '到期时间',
  `sort_num` int DEFAULT '1' COMMENT '排序号[Deprecated]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




INSERT INTO `t_notice` (`id`, `author`, `title`, `content`, `type`, `status`, `enabled`, `create_time`, `update_time`, `end_time`, `sort_num`) VALUES ('1196596850284810241', 'admin', '系统公告', '系统将于2019/12月3号进行维护，期间将不能使用部分功能', 'System', 'Draft', '1', '2019-05-01 09:11:35', NULL, '2019-11-19 09:06:48', '1');
INSERT INTO `t_notice` (`id`, `author`, `title`, `content`, `type`, `status`, `enabled`, `create_time`, `update_time`, `end_time`, `sort_num`) VALUES ('1196596948829982721', 'admin', '内部公告', '部分库存信息有误，各负责人请检查下数据', 'Internal', 'Draft', '1', '2019-09-01 09:11:59', NULL, '2019-10-01 09:06:48', '2');
INSERT INTO `t_notice` (`id`, `author`, `title`, `content`, `type`, `status`, `enabled`, `create_time`, `update_time`, `end_time`, `sort_num`) VALUES ('1196596986360614914', 'admin', '外部公告', '悠品6折大促销，欢迎选购', 'External', 'Draft', '1', '2019-09-01 09:12:08', NULL, '2019-12-01 09:06:48', '3');




-- ----------------------------
-- Records of t_notice
-- ----------------------------


INSERT INTO `sys_perm_group` (`id`, `pid`,`org_id`,`name`, `identifier`) VALUES
('100600000000000001' ,'100000000000000006', '100000000000000001','日志配置', 'contract.management');
INSERT INTO `sys_perm` (`id`, `group_id`, `name`, `identifier`) VALUES
('100000000000006001', '100600000000000001', '查看日志', 'OperationLog.view');





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





DROP TABLE IF EXISTS `t_term_config`;
CREATE TABLE `t_term_config` (
	id BIGINT (20) NOT NULL,
	type VARCHAR (50) NOT NULL COMMENT '类型 ABOUT_US,NOTICE,CONNECT_US ...',
	title VARCHAR (50) NOT NULL COMMENT '标题',
	content text COMMENT '内容',
	`org_id` bigint(20) DEFAULT NULL COMMENT '组织(部门)ID',
	created_time DATETIME NULL COMMENT '创建时间',
	previous_modified_time DATETIME NULL COMMENT '上次修改时间',
	last_modified_time DATETIME NULL COMMENT '最后修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = UTF8;







-- ----------------------------
-- Table structure for perm_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm_group`;
 CREATE TABLE `sys_perm_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `org_id` bigint(20) NOT NULL COMMENT '资源隔离字段',
  `pid` bigint(20) DEFAULT NULL COMMENT '父部门id',
  `identifier` varchar(50) NOT NULL COMMENT '标识符',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `group_id` bigint(20) DEFAULT NULL COMMENT '权限所属组',
  `identifier` varchar(50) NOT NULL COMMENT '权限值',
  `name` varchar(50) DEFAULT NULL COMMENT '权限名',
  `tag` smallint DEFAULT 0 COMMENT '标签，0：普通权限，1：菜单',
  PRIMARY KEY (`id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT FOREIGN KEY (`group_id`) REFERENCES `sys_perm_group` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sysRole
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `org_id` bigint(20) NOT NULL,
  `sort_order` int(11) not NULL default 1 COMMENT '排序号',
  `pid` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tips` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `delete_flag` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`org_id`,`name`),
  foreign key (`org_id`) references `t_sys_org` (`id`) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_perm`;
CREATE TABLE `sys_role_perm` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `perm_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  foreign key (`role_id`) references `sys_role` (`id`) on delete cascade,
  foreign key (`perm_id`) references `sys_perm` (`id`) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
 CREATE TABLE `t_sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(100) NOT NULL COMMENT '账号(登录账号)',
  `org_id` bigint(20) DEFAULT NULL COMMENT '部门 id ',
  `openid` varchar(100) DEFAULT NULL COMMENT '第三方授权ID',
  `password` varchar(100) DEFAULT NULL COMMENT '密码MD5值',
  `salt` varchar(45) DEFAULT NULL COMMENT '盐值',
  `name` varchar(45) DEFAULT NULL COMMENT '昵称',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `email` varchar(45) unique DEFAULT NULL COMMENT '邮箱',
  `email_validated` smallint not null default 0 COMMENT '邮箱是否验证，默认 0-未验证,1-验证',
  `phone` varchar(45) unique DEFAULT NULL COMMENT '电话',
  `status` int(11) DEFAULT 1 COMMENT '状态',
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间，可理解为注册时间',
  `version` int(11) DEFAULT NULL COMMENT '版本',
  `delete_flag` int(11) NOT NULL DEFAULT '1' COMMENT '逻辑删除字段',
  `is_app_user` int(11) NOT NULL DEFAULT '0' COMMENT '是否为APP 用户 ,已过时',
  `password_reset` int(11) NOT NULL DEFAULT '0' COMMENT '重置密码',
   CONSTRAINT  UNIQUE (account,org_id),

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`role_id`,`user_id`),
  foreign key (`user_id`) references `t_sys_user` (`id`) on delete cascade,
  foreign key (`role_id`) references `sys_role` (`id`) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_role_perm_group`;
 CREATE TABLE `sys_role_perm_group` (
  `id` bigint(20) NOT NULL,
  `perm_group_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`role_id`,`perm_group_id`),
  KEY (`role_id`),
  KEY (`perm_group_id`),
  CONSTRAINT FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE,
  CONSTRAINT FOREIGN KEY (`perm_group_id`) REFERENCES `sys_perm_group` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;












-- ----------------------------
-- Table structure for pcd
-- ----------------------------
DROP TABLE IF EXISTS `pcd`;
CREATE TABLE `pcd` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) not null,
  `type` varchar(50) not null,
  `pid` bigint(20),
  PRIMARY KEY (`id`),
  foreign key (`pid`) references `pcd` (`id`) on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `t_stock_images`;
CREATE TABLE `t_stock_images` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(255) NOT NULL COMMENT 'images address',
  `stock_id` BIGINT(20) NOT NULL COMMENT 'owner id',
  `stock_type` varchar(20) NOT NULL COMMENT 'owner type:like product/member and etc...',
  `name` varchar(100) DEFAULT NULL COMMENT 'owner type:like product/member and etc...',
  `image_note` varchar(255) DEFAULT NULL COMMENT 'owner type:like product/member and etc...',
  `is_primary` smallint(5) default 0 COMMENT 'is primary,0 means not ,1 means primary ',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'upload time',
  UNIQUE(`url`,`stock_id`,`stock_type`),
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;




INSERT INTO `pcd` (`id`, `name`, `type`, `pid`) VALUES (1,'北京','p',NULL),(2,'北京','c',1),(3,'东城区','d',2),(4,'西城区','d',2),(5,'崇文区','d',2),(6,'宣武区','d',2),(7,'朝阳区','d',2),(8,'丰台区','d',2),(9,'石景山区','d',2),(10,'海淀区','d',2),(11,'门头沟区','d',2),(12,'房山区','d',2),(13,'通州区','d',2),(14,'顺义区','d',2),(15,'昌平区','d',2),(16,'大兴区','d',2),(17,'平谷区','d',2),(18,'怀柔区','d',2),(19,'密云县','d',2),(20,'延庆县','d',2),(21,'天津','p',NULL),(22,'天津','c',21),(23,'和平区','d',22),(24,'河东区','d',22),(25,'河西区','d',22),(26,'南开区','d',22),(27,'河北区','d',22),(28,'红桥区','d',22),(29,'塘沽区','d',22),(30,'汉沽区','d',22),(31,'大港区','d',22),(32,'东丽区','d',22),(33,'西青区','d',22),(34,'津南区','d',22),(35,'北辰区','d',22),(36,'武清区','d',22),(37,'宝坻区','d',22),(38,'宁河县','d',22),(39,'静海县','d',22),(40,'蓟  县','d',22),(41,'河北','p',NULL),(42,'石家庄','c',41),(43,'长安区','d',42),(44,'桥东区','d',42),(45,'桥西区','d',42),(46,'新华区','d',42),(47,'郊  区','d',42),(48,'井陉矿区','d',42),(49,'井陉县','d',42),(50,'正定县','d',42),(51,'栾城县','d',42),(52,'行唐县','d',42),(53,'灵寿县','d',42),(54,'高邑县','d',42),(55,'深泽县','d',42),(56,'赞皇县','d',42),(57,'无极县','d',42),(58,'平山县','d',42),(59,'元氏县','d',42),(60,'赵  县','d',42),(61,'辛集市','d',42),(62,'藁','d',42),(63,'晋州市','d',42),(64,'新乐市','d',42),(65,'鹿泉市','d',42),(66,'唐山','c',41),(67,'路南区','d',66),(68,'路北区','d',66),(69,'古冶区','d',66),(70,'开平区','d',66),(71,'新  区','d',66),(72,'丰润县','d',66),(73,'滦  县','d',66),(74,'滦南县','d',66),(75,'乐亭县','d',66),(76,'迁西县','d',66),(77,'玉田县','d',66),(78,'唐海县','d',66),(79,'遵化市','d',66),(80,'丰南市','d',66),(81,'迁安市','d',66),(82,'秦皇岛','c',41),(83,'海港区','d',82),(84,'山海关区','d',82),(85,'北戴河区','d',82),(86,'青龙满族自治县','d',82),(87,'昌黎县','d',82),(88,'抚宁县','d',82),(89,'卢龙县','d',82),(90,'邯郸','c',41),(91,'邯山区','d',90),(92,'丛台区','d',90),(93,'复兴区','d',90),(94,'峰峰矿区','d',90),(95,'邯郸县','d',90),(96,'临漳县','d',90),(97,'成安县','d',90),(98,'大名县','d',90),(99,'涉  县','d',90),(100,'磁  县','d',90),(101,'肥乡县','d',90),(102,'永年县','d',90),(103,'邱  县','d',90),(104,'鸡泽县','d',90),(105,'广平县','d',90),(106,'馆陶县','d',90),(107,'魏  县','d',90),(108,'曲周县','d',90),(109,'武安市','d',90),(110,'邢台','c',41),(111,'桥东区','d',110),(112,'桥西区','d',110),(113,'邢台县','d',110),(114,'临城县','d',110),(115,'内丘县','d',110),(116,'柏乡县','d',110),(117,'隆尧县','d',110),(118,'任  县','d',110),(119,'南和县','d',110),(120,'宁晋县','d',110),(121,'巨鹿县','d',110),(122,'新河县','d',110),(123,'广宗县','d',110),(124,'平乡县','d',110),(125,'威  县','d',110),(126,'清河县','d',110),(127,'临西县','d',110),(128,'南宫市','d',110),(129,'沙河市','d',110),(130,'保定','c',41),(131,'新市区','d',130),(132,'北市区','d',130),(133,'南市区','d',130),(134,'满城县','d',130),(135,'清苑县','d',130),(136,'涞水县','d',130),(137,'阜平县','d',130),(138,'徐水县','d',130),(139,'定兴县','d',130),(140,'唐  县','d',130),(141,'高阳县','d',130),(142,'容城县','d',130),(143,'涞源县','d',130),(144,'望都县','d',130),(145,'安新县','d',130),(146,'易  县','d',130),(147,'曲阳县','d',130),(148,'蠡  县','d',130),(149,'顺平县','d',130),(150,'博野','d',130),(151,'雄县','d',130),(152,'涿州市','d',130),(153,'定州市','d',130),(154,'安国市','d',130),(155,'高碑店市','d',130),(156,'张家口','c',41),(157,'桥东区','d',156),(158,'桥西区','d',156),(159,'宣化区','d',156),(160,'下花园区','d',156),(161,'宣化县','d',156),(162,'张北县','d',156),(163,'康保县','d',156),(164,'沽源县','d',156),(165,'尚义县','d',156),(166,'蔚  县','d',156),(167,'阳原县','d',156),(168,'怀安县','d',156),(169,'万全县','d',156),(170,'怀来县','d',156),(171,'涿鹿县','d',156),(172,'赤城县','d',156),(173,'崇礼县','d',156),(174,'承德','c',41),(175,'双桥区','d',174),(176,'双滦区','d',174),(177,'鹰手营子矿区','d',174),(178,'承德县','d',174),(179,'兴隆县','d',174),(180,'平泉县','d',174),(181,'滦平县','d',174),(182,'隆化县','d',174),(183,'丰宁满族自治县','d',174),(184,'宽城满族自治县','d',174),(185,'围场满族蒙古族自治县','d',174),(186,'沧州','c',41),(187,'新华区','d',186),(188,'运河区','d',186),(189,'沧  县','d',186),(190,'青  县','d',186),(191,'东光县','d',186),(192,'海兴县','d',186),(193,'盐山县','d',186),(194,'肃宁县','d',186),(195,'南皮县','d',186),(196,'吴桥县','d',186),(197,'献  县','d',186),(198,'孟村回族自治县','d',186),(199,'泊头市','d',186),(200,'任丘市','d',186),(201,'黄骅市','d',186),(202,'河间市','d',186),(203,'廊坊','c',41),(204,'安次区','d',203),(205,'固安县','d',203),(206,'永清县','d',203),(207,'香河县','d',203),(208,'大城县','d',203),(209,'文安县','d',203),(210,'大厂回族自治县','d',203),(211,'霸州市','d',203),(212,'三河市','d',203),(213,'衡水','c',41),(214,'桃城区','d',213),(215,'枣强县','d',213),(216,'武邑县','d',213),(217,'武强县','d',213),(218,'饶阳县','d',213),(219,'安平县','d',213),(220,'故城县','d',213),(221,'景  县','d',213),(222,'阜城县','d',213),(223,'冀州市','d',213),(224,'深州市','d',213),(225,'山西','p',NULL),(226,'太原','c',225),(227,'小店区','d',226),(228,'迎泽区','d',226),(229,'杏花岭区','d',226),(230,'尖草坪区','d',226),(231,'万柏林区','d',226),(232,'晋源区','d',226),(233,'清徐县','d',226),(234,'阳曲县','d',226),(235,'娄烦县','d',226),(236,'古交市','d',226),(237,'大同','c',225),(238,'城  区','d',237),(239,'矿  区','d',237),(240,'南郊区','d',237),(241,'新荣区','d',237),(242,'阳高县','d',237),(243,'天镇县','d',237),(244,'广灵县','d',237),(245,'灵丘县','d',237),(246,'浑源县','d',237),(247,'左云县','d',237),(248,'大同县','d',237),(249,'阳泉','c',225),(250,'城  区','d',249),(251,'矿  区','d',249),(252,'郊  区','d',249),(253,'平定县','d',249),(254,'盂  县','d',249),(255,'长治','c',225),(256,'城  区','d',255),(257,'郊  区','d',255),(258,'长治县','d',255),(259,'襄垣县','d',255),(260,'屯留县','d',255),(261,'平顺县','d',255),(262,'黎城县','d',255),(263,'壶关县','d',255),(264,'长子县','d',255),(265,'武乡县','d',255),(266,'沁  县','d',255),(267,'沁源县','d',255),(268,'潞城市','d',255),(269,'晋城','c',225),(270,'城  区','d',269),(271,'沁水县','d',269),(272,'阳城县','d',269),(273,'陵川县','d',269),(274,'泽州县','d',269),(275,'高平市','d',269),(276,'朔州','c',225),(277,'朔城区','d',276),(278,'平鲁区','d',276),(279,'山阴县','d',276),(280,'应  县','d',276),(281,'右玉县','d',276),(282,'怀仁县','d',276),(283,'忻州','c',225),(284,'忻府区','d',283),(285,'原平市','d',283),(286,'定襄县','d',283),(287,'五台县','d',283),(288,'代  县','d',283),(289,'繁峙县','d',283),(290,'宁武县','d',283),(291,'静乐县','d',283),(292,'神池县','d',283),(293,'五寨县','d',283),(294,'岢岚县','d',283),(295,'河曲县','d',283),(296,'保德县','d',283),(297,'偏关县','d',283),(298,'吕梁','c',225),(299,'离石区','d',298),(300,'孝义市','d',298),(301,'汾阳市','d',298),(302,'文水县','d',298),(303,'交城县','d',298),(304,'兴  县','d',298),(305,'临  县','d',298),(306,'柳林县','d',298),(307,'石楼县','d',298),(308,'岚  县','d',298),(309,'方山县','d',298),(310,'中阳县','d',298),(311,'交口县','d',298),(312,'晋中','c',225),(313,'榆次市','d',312),(314,'介休市','d',312),(315,'榆社县','d',312),(316,'左权县','d',312),(317,'和顺县','d',312),(318,'昔阳县','d',312),(319,'寿阳县','d',312),(320,'太谷县','d',312),(321,'祁  县','d',312),(322,'平遥县','d',312),(323,'灵石县','d',312),(324,'临汾','c',225),(325,'临汾市','d',324),(326,'侯马市','d',324),(327,'霍州市','d',324),(328,'曲沃县','d',324),(329,'翼城县','d',324),(330,'襄汾县','d',324),(331,'洪洞县','d',324),(332,'古  县','d',324),(333,'安泽县','d',324),(334,'浮山县','d',324),(335,'吉  县','d',324),(336,'乡宁县','d',324),(337,'蒲  县','d',324),(338,'大宁县','d',324),(339,'永和县','d',324),(340,'隰  县','d',324),(341,'汾西县','d',324),(342,'运城','c',225),(343,'运城市','d',342),(344,'永济市','d',342),(345,'河津市','d',342),(346,'芮城县','d',342),(347,'临猗县','d',342),(348,'万荣县','d',342),(349,'新绛县','d',342),(350,'稷山县','d',342),(351,'闻喜县','d',342),(352,'夏  县','d',342),(353,'绛  县','d',342),(354,'平陆县','d',342),(355,'垣曲县','d',342),(356,'内蒙古','p',NULL),(357,'呼和浩特','c',356),(358,'新城区','d',357),(359,'回民区','d',357),(360,'玉泉区','d',357),(361,'郊  区','d',357),(362,'土默特左旗','d',357),(363,'托克托县','d',357),(364,'和林格尔县','d',357),(365,'清水河县','d',357),(366,'武川县','d',357),(367,'包头','c',356),(368,'东河区','d',367),(369,'昆都伦区','d',367),(370,'青山区','d',367),(371,'石拐矿区','d',367),(372,'白云矿区','d',367),(373,'郊  区','d',367),(374,'土默特右旗','d',367),(375,'固阳县','d',367),(376,'达尔罕茂明安联合旗','d',367),(377,'乌海','c',356),(378,'海勃湾区','d',377),(379,'海南区','d',377),(380,'乌达区','d',377),(381,'赤峰','c',356),(382,'红山区','d',381),(383,'元宝山区','d',381),(384,'松山区','d',381),(385,'阿鲁科尔沁旗','d',381),(386,'巴林左旗','d',381),(387,'巴林右旗','d',381),(388,'林西县','d',381),(389,'克什克腾旗','d',381),(390,'翁牛特旗','d',381),(391,'喀喇沁旗','d',381),(392,'宁城县','d',381),(393,'敖汉旗','d',381),(394,'呼伦贝尔','c',356),(395,'海拉尔市','d',394),(396,'满洲里市','d',394),(397,'扎兰屯市','d',394),(398,'牙克石市','d',394),(399,'根河市','d',394),(400,'额尔古纳市','d',394),(401,'阿荣旗','d',394),(402,'莫力达瓦达斡尔族自治旗','d',394),(403,'鄂伦春自治旗','d',394),(404,'鄂温克族自治旗','d',394),(405,'新巴尔虎右旗','d',394),(406,'新巴尔虎左旗','d',394),(407,'陈巴尔虎旗','d',394),(408,'兴安盟','c',356),(409,'乌兰浩特市','d',408),(410,'阿尔山市','d',408),(411,'科尔沁右翼前旗','d',408),(412,'科尔沁右翼中旗','d',408),(413,'扎赉特旗','d',408),(414,'突泉县','d',408),(415,'通辽','c',356),(416,'科尔沁区','d',415),(417,'霍林郭勒市','d',415),(418,'科尔沁左翼中旗','d',415),(419,'科尔沁左翼后旗','d',415),(420,'开鲁县','d',415),(421,'库伦旗','d',415),(422,'奈曼旗','d',415),(423,'扎鲁特旗','d',415),(424,'锡林郭勒盟','c',356),(425,'二连浩特市','d',424),(426,'锡林浩特市','d',424),(427,'阿巴嘎旗','d',424),(428,'苏尼特左旗','d',424),(429,'苏尼特右旗','d',424),(430,'东乌珠穆沁旗','d',424),(431,'西乌珠穆沁旗','d',424),(432,'太仆寺旗','d',424),(433,'镶黄旗','d',424),(434,'正镶白旗','d',424),(435,'正蓝旗','d',424),(436,'多伦县','d',424),(437,'乌兰察布盟','c',356),(438,'集宁市','d',437),(439,'丰镇市','d',437),(440,'卓资县','d',437),(441,'化德县','d',437),(442,'商都县','d',437),(443,'兴和县','d',437),(444,'凉城县','d',437),(445,'察哈尔右翼前旗','d',437),(446,'察哈尔右翼中旗','d',437),(447,'察哈尔右翼后旗','d',437),(448,'四子王旗','d',437),(449,'伊克昭盟','c',356),(450,'东胜市','d',449),(451,'达拉特旗','d',449),(452,'准格尔旗','d',449),(453,'鄂托克前旗','d',449),(454,'鄂托克旗','d',449),(455,'杭锦旗','d',449),(456,'乌审旗','d',449),(457,'伊金霍洛旗','d',449),(458,'巴彦淖尔盟','c',356),(459,'临河市','d',458),(460,'五原县','d',458),(461,'磴口县','d',458),(462,'乌拉特前旗','d',458),(463,'乌拉特中旗','d',458),(464,'乌拉特后旗','d',458),(465,'杭锦后旗','d',458),(466,'阿拉善盟','c',356),(467,'阿拉善左旗','d',466),(468,'阿拉善右旗','d',466),(469,'额济纳旗','d',466),(470,'辽宁','p',NULL),(471,'沈阳','c',470),(472,'沈河区','d',471),(473,'皇姑区','d',471),(474,'和平区','d',471),(475,'大东区','d',471),(476,'铁西区','d',471),(477,'苏家屯区','d',471),(478,'东陵区','d',471),(479,'于洪区','d',471),(480,'新民市','d',471),(481,'法库县','d',471),(482,'辽中县','d',471),(483,'康平县','d',471),(484,'新城子区','d',471),(485,'其他','d',471),(486,'大连','c',470),(487,'西岗区','d',486),(488,'中山区','d',486),(489,'沙河口区','d',486),(490,'甘井子区','d',486),(491,'旅顺口区','d',486),(492,'金州区','d',486),(493,'瓦房店市','d',486),(494,'普兰店市','d',486),(495,'庄河市','d',486),(496,'长海县','d',486),(497,'其他','d',486),(498,'鞍山','c',470),(499,'铁东区','d',498),(500,'铁西区','d',498),(501,'立山区','d',498),(502,'千山区','d',498),(503,'海城市','d',498),(504,'台安县','d',498),(505,'岫岩满族自治县','d',498),(506,'其他','d',498),(507,'抚顺','c',470),(508,'顺城区','d',507),(509,'新抚区','d',507),(510,'东洲区','d',507),(511,'望花区','d',507),(512,'抚顺县','d',507),(513,'清原满族自治县','d',507),(514,'新宾满族自治县','d',507),(515,'其他','d',507),(516,'本溪','c',470),(517,'平山区','d',516),(518,'明山区','d',516),(519,'溪湖区','d',516),(520,'南芬区','d',516),(521,'本溪满族自治县','d',516),(522,'桓仁满族自治县','d',516),(523,'其他','d',516),(524,'丹东','c',470),(525,'振兴区','d',524),(526,'元宝区','d',524),(527,'振安区','d',524),(528,'东港市','d',524),(529,'凤城市','d',524),(530,'宽甸满族自治县','d',524),(531,'其他','d',524),(532,'锦州','c',470),(533,'太和区','d',532),(534,'古塔区','d',532),(535,'凌河区','d',532),(536,'凌海市','d',532),(537,'黑山县','d',532),(538,'义县','d',532),(539,'北宁市','d',532),(540,'其他','d',532),(541,'营口','c',470),(542,'站前区','d',541),(543,'西市区','d',541),(544,'鲅鱼圈区','d',541),(545,'老边区','d',541),(546,'大石桥市','d',541),(547,'盖州市','d',541),(548,'其他','d',541),(549,'阜新','c',470),(550,'海州区','d',549),(551,'新邱区','d',549),(552,'太平区','d',549),(553,'清河门区','d',549),(554,'细河区','d',549),(555,'彰武县','d',549),(556,'阜新蒙古族自治县','d',549),(557,'其他','d',549),(558,'辽阳','c',470),(559,'白塔区','d',558),(560,'文圣区','d',558),(561,'宏伟区','d',558),(562,'太子河区','d',558),(563,'弓长岭区','d',558),(564,'灯塔市','d',558),(565,'辽阳县','d',558),(566,'其他','d',558),(567,'盘锦','c',470),(568,'双台子区','d',567),(569,'兴隆台区','d',567),(570,'盘山县','d',567),(571,'大洼县','d',567),(572,'其他','d',567),(573,'铁岭','c',470),(574,'银州区','d',573),(575,'清河区','d',573),(576,'调兵山市','d',573),(577,'开原市','d',573),(578,'铁岭县','d',573),(579,'昌图县','d',573),(580,'西丰县','d',573),(581,'其他','d',573),(582,'朝阳','c',470),(583,'双塔区','d',582),(584,'龙城区','d',582),(585,'凌源市','d',582),(586,'北票市','d',582),(587,'朝阳县','d',582),(588,'建平县','d',582),(589,'喀喇沁左翼蒙古族自治县','d',582),(590,'其他','d',582),(591,'葫芦岛','c',470),(592,'龙港区','d',591),(593,'南票区','d',591),(594,'连山区','d',591),(595,'兴城市','d',591),(596,'绥中县','d',591),(597,'建昌县','d',591),(598,'其他','d',591),(599,'其他','c',470),(600,'其他','d',599),(601,'吉林','p',NULL),(602,'长春','c',601),(603,'朝阳区','d',602),(604,'宽城区','d',602),(605,'二道区','d',602),(606,'南关区','d',602),(607,'绿园区','d',602),(608,'双阳区','d',602),(609,'九台市','d',602),(610,'榆树市','d',602),(611,'德惠市','d',602),(612,'农安县','d',602),(613,'其他','d',602),(614,'吉林','c',601),(615,'船营区','d',614),(616,'昌邑区','d',614),(617,'龙潭区','d',614),(618,'丰满区','d',614),(619,'舒兰市','d',614),(620,'桦甸市','d',614),(621,'蛟河市','d',614),(622,'磐石市','d',614),(623,'永吉县','d',614),(624,'其他','d',614),(625,'四平','c',601),(626,'铁西区','d',625),(627,'铁东区','d',625),(628,'公主岭市','d',625),(629,'双辽市','d',625),(630,'梨树县','d',625),(631,'伊通满族自治县','d',625),(632,'其他','d',625),(633,'辽源','c',601),(634,'龙山区','d',633),(635,'西安区','d',633),(636,'东辽县','d',633),(637,'东丰县','d',633),(638,'其他','d',633),(639,'通化','c',601),(640,'东昌区','d',639),(641,'二道江区','d',639),(642,'梅河口市','d',639),(643,'集安市','d',639),(644,'通化县','d',639),(645,'辉南县','d',639),(646,'柳河县','d',639),(647,'其他','d',639),(648,'白山','c',601),(649,'八道江区','d',648),(650,'江源区','d',648),(651,'临江市','d',648),(652,'靖宇县','d',648),(653,'抚松县','d',648),(654,'长白朝鲜族自治县','d',648),(655,'其他','d',648),(656,'松原','c',601),(657,'宁江区','d',656),(658,'乾安县','d',656),(659,'长岭县','d',656),(660,'扶余县','d',656),(661,'前郭尔罗斯蒙古族自治县','d',656),(662,'其他','d',656),(663,'白城','c',601),(664,'洮北区','d',663),(665,'大安市','d',663),(666,'洮南市','d',663),(667,'镇赉县','d',663),(668,'通榆县','d',663),(669,'其他','d',663),(670,'延边朝鲜族自治州','c',601),(671,'延吉市','d',670),(672,'图们市','d',670),(673,'敦化市','d',670),(674,'龙井市','d',670),(675,'珲春市','d',670),(676,'和龙市','d',670),(677,'安图县','d',670),(678,'汪清县','d',670),(679,'其他','d',670),(680,'其他','c',601),(681,'其他','d',680),(682,'黑龙江','p',NULL),(683,'哈尔滨','c',682),(684,'松北区','d',683),(685,'道里区','d',683),(686,'南岗区','d',683),(687,'平房区','d',683),(688,'香坊区','d',683),(689,'道外区','d',683),(690,'呼兰区','d',683),(691,'阿城区','d',683),(692,'双城市','d',683),(693,'尚志市','d',683),(694,'五常市','d',683),(695,'宾县','d',683),(696,'方正县','d',683),(697,'通河县','d',683),(698,'巴彦县','d',683),(699,'延寿县','d',683),(700,'木兰县','d',683),(701,'依兰县','d',683),(702,'其他','d',683),(703,'齐齐哈尔','c',682),(704,'龙沙区','d',703),(705,'昂昂溪区','d',703),(706,'铁锋区','d',703),(707,'建华区','d',703),(708,'富拉尔基区','d',703),(709,'碾子山区','d',703),(710,'梅里斯达斡尔族区','d',703),(711,'讷河市','d',703),(712,'富裕县','d',703),(713,'拜泉县','d',703),(714,'甘南县','d',703),(715,'依安县','d',703),(716,'克山县','d',703),(717,'泰来县','d',703),(718,'克东县','d',703),(719,'龙江县','d',703),(720,'其他','d',703),(721,'鹤岗','c',682),(722,'兴山区','d',721),(723,'工农区','d',721),(724,'南山区','d',721),(725,'兴安区','d',721),(726,'向阳区','d',721),(727,'东山区','d',721),(728,'萝北县','d',721),(729,'绥滨县','d',721),(730,'其他','d',721),(731,'双鸭山','c',682),(732,'尖山区','d',731),(733,'岭东区','d',731),(734,'四方台区','d',731),(735,'宝山区','d',731),(736,'集贤县','d',731),(737,'宝清县','d',731),(738,'友谊县','d',731),(739,'饶河县','d',731),(740,'其他','d',731),(741,'鸡西','c',682),(742,'鸡冠区','d',741),(743,'恒山区','d',741),(744,'城子河区','d',741),(745,'滴道区','d',741),(746,'梨树区','d',741),(747,'麻山区','d',741),(748,'密山市','d',741),(749,'虎林市','d',741),(750,'鸡东县','d',741),(751,'其他','d',741),(752,'大庆','c',682),(753,'萨尔图区','d',752),(754,'红岗区','d',752),(755,'龙凤区','d',752),(756,'让胡路区','d',752),(757,'大同区','d',752),(758,'林甸县','d',752),(759,'肇州县','d',752),(760,'肇源县','d',752),(761,'杜尔伯特蒙古族自治县','d',752),(762,'其他','d',752),(763,'伊春','c',682),(764,'伊春区','d',763),(765,'带岭区','d',763),(766,'南岔区','d',763),(767,'金山屯区','d',763),(768,'西林区','d',763),(769,'美溪区','d',763),(770,'乌马河区','d',763),(771,'翠峦区','d',763),(772,'友好区','d',763),(773,'上甘岭区','d',763),(774,'五营区','d',763),(775,'红星区','d',763),(776,'新青区','d',763),(777,'汤旺河区','d',763),(778,'乌伊岭区','d',763),(779,'铁力市','d',763),(780,'嘉荫县','d',763),(781,'其他','d',763),(782,'牡丹江','c',682),(783,'爱民区','d',782),(784,'东安区','d',782),(785,'阳明区','d',782),(786,'西安区','d',782),(787,'绥芬河市','d',782),(788,'宁安市','d',782),(789,'海林市','d',782),(790,'穆棱市','d',782),(791,'林口县','d',782),(792,'东宁县','d',782),(793,'其他','d',782),(794,'佳木斯','c',682),(795,'向阳区','d',794),(796,'前进区','d',794),(797,'东风区','d',794),(798,'郊区','d',794),(799,'同江市','d',794),(800,'富锦市','d',794),(801,'桦川县','d',794),(802,'抚远县','d',794),(803,'桦南县','d',794),(804,'汤原县','d',794),(805,'其他','d',794),(806,'七台河','c',682),(807,'桃山区','d',806),(808,'新兴区','d',806),(809,'茄子河区','d',806),(810,'勃利县','d',806),(811,'其他','d',806),(812,'黑河','c',682),(813,'爱辉区','d',812),(814,'北安市','d',812),(815,'五大连池市','d',812),(816,'逊克县','d',812),(817,'嫩江县','d',812),(818,'孙吴县','d',812),(819,'其他','d',812),(820,'绥化','c',682),(821,'北林区','d',820),(822,'安达市','d',820),(823,'肇东市','d',820),(824,'海伦市','d',820),(825,'绥棱县','d',820),(826,'兰西县','d',820),(827,'明水县','d',820),(828,'青冈县','d',820),(829,'庆安县','d',820),(830,'望奎县','d',820),(831,'其他','d',820),(832,'大兴安岭地区','c',682),(833,'呼玛县','d',832),(834,'塔河县','d',832),(835,'漠河县','d',832),(836,'大兴安岭辖区','d',832),(837,'其他','d',832),(838,'其他','c',682),(839,'其他','d',838),(840,'上海','p',NULL),(841,'上海','c',840),(842,'黄浦区','d',841),(843,'卢湾区','d',841),(844,'徐汇区','d',841),(845,'长宁区','d',841),(846,'静安区','d',841),(847,'普陀区','d',841),(848,'闸北区','d',841),(849,'虹口区','d',841),(850,'杨浦区','d',841),(851,'宝山区','d',841),(852,'闵行区','d',841),(853,'嘉定区','d',841),(854,'松江区','d',841),(855,'金山区','d',841),(856,'青浦区','d',841),(857,'南汇区','d',841),(858,'奉贤区','d',841),(859,'浦东新区','d',841),(860,'崇明县','d',841),(861,'其他','d',841),(862,'江苏','p',NULL),(863,'南京','c',862),(864,'玄武区','d',863),(865,'白下区','d',863),(866,'秦淮区','d',863),(867,'建邺区','d',863),(868,'鼓楼区','d',863),(869,'下关区','d',863),(870,'栖霞区','d',863),(871,'雨花台区','d',863),(872,'浦口区','d',863),(873,'江宁区','d',863),(874,'六合区','d',863),(875,'溧水县','d',863),(876,'高淳县','d',863),(877,'其他','d',863),(878,'苏州','c',862),(879,'金阊区','d',878),(880,'平江区','d',878),(881,'沧浪区','d',878),(882,'虎丘区','d',878),(883,'吴中区','d',878),(884,'相城区','d',878),(885,'常熟市','d',878),(886,'张家港市','d',878),(887,'昆山市','d',878),(888,'吴江市','d',878),(889,'太仓市','d',878),(890,'其他','d',878),(891,'无锡','c',862),(892,'崇安区','d',891),(893,'南长区','d',891),(894,'北塘区','d',891),(895,'滨湖区','d',891),(896,'锡山区','d',891),(897,'惠山区','d',891),(898,'江阴市','d',891),(899,'宜兴市','d',891),(900,'其他','d',891),(901,'常州','c',862),(902,'钟楼区','d',901),(903,'天宁区','d',901),(904,'戚墅堰区','d',901),(905,'新北区','d',901),(906,'武进区','d',901),(907,'金坛市','d',901),(908,'溧阳市','d',901),(909,'其他','d',901),(910,'镇江','c',862),(911,'京口区','d',910),(912,'润州区','d',910),(913,'丹徒区','d',910),(914,'丹阳市','d',910),(915,'扬中市','d',910),(916,'句容市','d',910),(917,'其他','d',910),(918,'南通','c',862),(919,'崇川区','d',918),(920,'港闸区','d',918),(921,'通州市','d',918),(922,'如皋市','d',918),(923,'海门市','d',918),(924,'启东市','d',918),(925,'海安县','d',918),(926,'如东县','d',918),(927,'其他','d',918),(928,'泰州','c',862),(929,'海陵区','d',928),(930,'高港区','d',928),(931,'姜堰市','d',928),(932,'泰兴市','d',928),(933,'靖江市','d',928),(934,'兴化市','d',928),(935,'其他','d',928),(936,'扬州','c',862),(937,'广陵区','d',936),(938,'维扬区','d',936),(939,'邗江区','d',936),(940,'江都市','d',936),(941,'仪征市','d',936),(942,'高邮市','d',936),(943,'宝应县','d',936),(944,'其他','d',936),(945,'盐城','c',862),(946,'亭湖区','d',945),(947,'盐都区','d',945),(948,'大丰市','d',945),(949,'东台市','d',945),(950,'建湖县','d',945),(951,'射阳县','d',945),(952,'阜宁县','d',945),(953,'滨海县','d',945),(954,'响水县','d',945),(955,'其他','d',945),(956,'连云港','c',862),(957,'新浦区','d',956),(958,'海州区','d',956),(959,'连云区','d',956),(960,'东海县','d',956),(961,'灌云县','d',956),(962,'赣榆县','d',956),(963,'灌南县','d',956),(964,'其他','d',956),(965,'徐州','c',862),(966,'云龙区','d',965),(967,'鼓楼区','d',965),(968,'九里区','d',965),(969,'泉山区','d',965),(970,'贾汪区','d',965),(971,'邳州市','d',965),(972,'新沂市','d',965),(973,'铜山县','d',965),(974,'睢宁县','d',965),(975,'沛县','d',965),(976,'丰县','d',965),(977,'其他','d',965),(978,'淮安','c',862),(979,'清河区','d',978),(980,'清浦区','d',978),(981,'楚州区','d',978),(982,'淮阴区','d',978),(983,'涟水县','d',978),(984,'洪泽县','d',978),(985,'金湖县','d',978),(986,'盱眙县','d',978),(987,'其他','d',978),(988,'宿迁','c',862),(989,'宿城区','d',988),(990,'宿豫区','d',988),(991,'沭阳县','d',988),(992,'泗阳县','d',988),(993,'泗洪县','d',988),(994,'其他','d',988),(995,'其他','c',862),(996,'其他','d',995),(997,'浙江','p',NULL),(998,'杭州','c',997),(999,'拱墅区','d',998),(1000,'西湖区','d',998),(1001,'上城区','d',998),(1002,'下城区','d',998),(1003,'江干区','d',998),(1004,'滨江区','d',998),(1005,'余杭区','d',998),(1006,'萧山区','d',998),(1007,'建德市','d',998),(1008,'富阳市','d',998),(1009,'临安市','d',998),(1010,'桐庐县','d',998),(1011,'淳安县','d',998),(1012,'其他','d',998),(1013,'宁波','c',997),(1014,'海曙区','d',1013),(1015,'江东区','d',1013),(1016,'江北区','d',1013),(1017,'镇海区','d',1013),(1018,'北仑区','d',1013),(1019,'鄞州区','d',1013),(1020,'余姚市','d',1013),(1021,'慈溪市','d',1013),(1022,'奉化市','d',1013),(1023,'宁海县','d',1013),(1024,'象山县','d',1013),(1025,'其他','d',1013),(1026,'温州','c',997),(1027,'鹿城区','d',1026),(1028,'龙湾区','d',1026),(1029,'瓯海区','d',1026),(1030,'瑞安市','d',1026),(1031,'乐清市','d',1026),(1032,'永嘉县','d',1026),(1033,'洞头县','d',1026),(1034,'平阳县','d',1026),(1035,'苍南县','d',1026),(1036,'文成县','d',1026),(1037,'泰顺县','d',1026),(1038,'其他','d',1026),(1039,'嘉兴','c',997),(1040,'秀城区','d',1039),(1041,'秀洲区','d',1039),(1042,'海宁市','d',1039),(1043,'平湖市','d',1039),(1044,'桐乡市','d',1039),(1045,'嘉善县','d',1039),(1046,'海盐县','d',1039),(1047,'其他','d',1039),(1048,'湖州','c',997),(1049,'吴兴区','d',1048),(1050,'南浔区','d',1048),(1051,'长兴县','d',1048),(1052,'德清县','d',1048),(1053,'安吉县','d',1048),(1054,'其他','d',1048),(1055,'绍兴','c',997),(1056,'越城区','d',1055),(1057,'诸暨市','d',1055),(1058,'上虞市','d',1055),(1059,'嵊州市','d',1055),(1060,'绍兴县','d',1055),(1061,'新昌县','d',1055),(1062,'其他','d',1055),(1063,'金华','c',997),(1064,'婺城区','d',1063),(1065,'金东区','d',1063),(1066,'兰溪市','d',1063),(1067,'义乌市','d',1063),(1068,'东阳市','d',1063),(1069,'永康市','d',1063),(1070,'武义县','d',1063),(1071,'浦江县','d',1063),(1072,'磐安县','d',1063),(1073,'其他','d',1063),(1074,'衢州','c',997),(1075,'柯城区','d',1074),(1076,'衢江区','d',1074),(1077,'江山市','d',1074),(1078,'龙游县','d',1074),(1079,'常山县','d',1074),(1080,'开化县','d',1074),(1081,'其他','d',1074),(1082,'舟山','c',997),(1083,'定海区','d',1082),(1084,'普陀区','d',1082),(1085,'岱山县','d',1082),(1086,'嵊泗县','d',1082),(1087,'其他','d',1082),(1088,'台州','c',997),(1089,'椒江区','d',1088),(1090,'黄岩区','d',1088),(1091,'路桥区','d',1088),(1092,'临海市','d',1088),(1093,'温岭市','d',1088),(1094,'玉环县','d',1088),(1095,'天台县','d',1088),(1096,'仙居县','d',1088),(1097,'三门县','d',1088),(1098,'其他','d',1088),(1099,'丽水','c',997),(1100,'莲都区','d',1099),(1101,'龙泉市','d',1099),(1102,'缙云县','d',1099),(1103,'青田县','d',1099),(1104,'云和县','d',1099),(1105,'遂昌县','d',1099),(1106,'松阳县','d',1099),(1107,'庆元县','d',1099),(1108,'景宁畲族自治县','d',1099),(1109,'其他','d',1099),(1110,'其他','c',997),(1111,'其他','d',1110),(1112,'安徽','p',NULL),(1113,'合肥','c',1112),(1114,'庐阳区','d',1113),(1115,'瑶海区','d',1113),(1116,'蜀山区','d',1113),(1117,'包河区','d',1113),(1118,'长丰县','d',1113),(1119,'肥东县','d',1113),(1120,'肥西县','d',1113),(1121,'其他','d',1113),(1122,'芜湖','c',1112),(1123,'镜湖区','d',1122),(1124,'弋江区','d',1122),(1125,'鸠江区','d',1122),(1126,'三山区','d',1122),(1127,'芜湖县','d',1122),(1128,'南陵县','d',1122),(1129,'繁昌县','d',1122),(1130,'其他','d',1122),(1131,'蚌埠','c',1112),(1132,'蚌山区','d',1131),(1133,'龙子湖区','d',1131),(1134,'禹会区','d',1131),(1135,'淮上区','d',1131),(1136,'怀远县','d',1131),(1137,'固镇县','d',1131),(1138,'五河县','d',1131),(1139,'其他','d',1131),(1140,'淮南','c',1112),(1141,'田家庵区','d',1140),(1142,'大通区','d',1140),(1143,'谢家集区','d',1140),(1144,'八公山区','d',1140),(1145,'潘集区','d',1140),(1146,'凤台县','d',1140),(1147,'其他','d',1140),(1148,'马鞍山','c',1112),(1149,'雨山区','d',1148),(1150,'花山区','d',1148),(1151,'金家庄区','d',1148),(1152,'当涂县','d',1148),(1153,'其他','d',1148),(1154,'淮北','c',1112),(1155,'相山区','d',1154),(1156,'杜集区','d',1154),(1157,'烈山区','d',1154),(1158,'濉溪县','d',1154),(1159,'其他','d',1154),(1160,'铜陵','c',1112),(1161,'铜官山区','d',1160),(1162,'狮子山区','d',1160),(1163,'郊区','d',1160),(1164,'铜陵县','d',1160),(1165,'其他','d',1160),(1166,'安庆','c',1112),(1167,'迎江区','d',1166),(1168,'大观区','d',1166),(1169,'宜秀区','d',1166),(1170,'桐城市','d',1166),(1171,'宿松县','d',1166),(1172,'枞阳县','d',1166),(1173,'太湖县','d',1166),(1174,'怀宁县','d',1166),(1175,'岳西县','d',1166),(1176,'望江县','d',1166),(1177,'潜山县','d',1166),(1178,'其他','d',1166),(1179,'黄山','c',1112),(1180,'屯溪区','d',1179),(1181,'黄山区','d',1179),(1182,'徽州区','d',1179),(1183,'休宁县','d',1179),(1184,'歙县','d',1179),(1185,'祁门县','d',1179),(1186,'黟县','d',1179),(1187,'其他','d',1179),(1188,'滁州','c',1112),(1189,'琅琊区','d',1188),(1190,'南谯区','d',1188),(1191,'天长市','d',1188),(1192,'明光市','d',1188),(1193,'全椒县','d',1188),(1194,'来安县','d',1188),(1195,'定远县','d',1188),(1196,'凤阳县','d',1188),(1197,'其他','d',1188),(1198,'阜阳','c',1112),(1199,'颍州区','d',1198),(1200,'颍东区','d',1198),(1201,'颍泉区','d',1198),(1202,'界首市','d',1198),(1203,'临泉县','d',1198),(1204,'颍上县','d',1198),(1205,'阜南县','d',1198),(1206,'太和县','d',1198),(1207,'其他','d',1198),(1208,'宿州','c',1112),(1209,'埇桥区','d',1208),(1210,'萧县','d',1208),(1211,'泗县','d',1208),(1212,'砀山县','d',1208),(1213,'灵璧县','d',1208),(1214,'其他','d',1208),(1215,'巢湖','c',1112),(1216,'居巢区','d',1215),(1217,'含山县','d',1215),(1218,'无为县','d',1215),(1219,'庐江县','d',1215),(1220,'和县','d',1215),(1221,'其他','d',1215),(1222,'六安','c',1112),(1223,'金安区','d',1222),(1224,'裕安区','d',1222),(1225,'寿县','d',1222),(1226,'霍山县','d',1222),(1227,'霍邱县','d',1222),(1228,'舒城县','d',1222),(1229,'金寨县','d',1222),(1230,'其他','d',1222),(1231,'亳州','c',1112),(1232,'谯城区','d',1231),(1233,'利辛县','d',1231),(1234,'涡阳县','d',1231),(1235,'蒙城县','d',1231),(1236,'其他','d',1231),(1237,'池州','c',1112),(1238,'贵池区','d',1237),(1239,'东至县','d',1237),(1240,'石台县','d',1237),(1241,'青阳县','d',1237),(1242,'其他','d',1237),(1243,'宣城','c',1112),(1244,'宣州区','d',1243),(1245,'宁国市','d',1243),(1246,'广德县','d',1243),(1247,'郎溪县','d',1243),(1248,'泾县','d',1243),(1249,'旌德县','d',1243),(1250,'绩溪县','d',1243),(1251,'其他','d',1243),(1252,'其他','c',1112),(1253,'其他','d',1252),(1254,'福建','p',NULL),(1255,'福州','c',1254),(1256,'鼓楼区','d',1255),(1257,'台江区','d',1255),(1258,'仓山区','d',1255),(1259,'马尾区','d',1255),(1260,'晋安区','d',1255),(1261,'福清市','d',1255),(1262,'长乐市','d',1255),(1263,'闽侯县','d',1255),(1264,'闽清县','d',1255),(1265,'永泰县','d',1255),(1266,'连江县','d',1255),(1267,'罗源县','d',1255),(1268,'平潭县','d',1255),(1269,'其他','d',1255),(1270,'厦门','c',1254),(1271,'思明区','d',1270),(1272,'海沧区','d',1270),(1273,'湖里区','d',1270),(1274,'集美区','d',1270),(1275,'同安区','d',1270),(1276,'翔安区','d',1270),(1277,'其他','d',1270),(1278,'莆田','c',1254),(1279,'城厢区','d',1278),(1280,'涵江区','d',1278),(1281,'荔城区','d',1278),(1282,'秀屿区','d',1278),(1283,'仙游县','d',1278),(1284,'其他','d',1278),(1285,'三明','c',1254),(1286,'梅列区','d',1285),(1287,'三元区','d',1285),(1288,'永安市','d',1285),(1289,'明溪县','d',1285),(1290,'将乐县','d',1285),(1291,'大田县','d',1285),(1292,'宁化县','d',1285),(1293,'建宁县','d',1285),(1294,'沙县','d',1285),(1295,'尤溪县','d',1285),(1296,'清流县','d',1285),(1297,'泰宁县','d',1285),(1298,'其他','d',1285),(1299,'泉州','c',1254),(1300,'鲤城区','d',1299),(1301,'丰泽区','d',1299),(1302,'洛江区','d',1299),(1303,'泉港区','d',1299),(1304,'石狮市','d',1299),(1305,'晋江市','d',1299),(1306,'南安市','d',1299),(1307,'惠安县','d',1299),(1308,'永春县','d',1299),(1309,'安溪县','d',1299),(1310,'德化县','d',1299),(1311,'金门县','d',1299),(1312,'其他','d',1299),(1313,'漳州','c',1254),(1314,'芗城区','d',1313),(1315,'龙文区','d',1313),(1316,'龙海市','d',1313),(1317,'平和县','d',1313),(1318,'南靖县','d',1313),(1319,'诏安县','d',1313),(1320,'漳浦县','d',1313),(1321,'华安县','d',1313),(1322,'东山县','d',1313),(1323,'长泰县','d',1313),(1324,'云霄县','d',1313),(1325,'其他','d',1313),(1326,'南平','c',1254),(1327,'延平区','d',1326),(1328,'建瓯市','d',1326),(1329,'邵武市','d',1326),(1330,'武夷山市','d',1326),(1331,'建阳市','d',1326),(1332,'松溪县','d',1326),(1333,'光泽县','d',1326),(1334,'顺昌县','d',1326),(1335,'浦城县','d',1326),(1336,'政和县','d',1326),(1337,'其他','d',1326),(1338,'龙岩','c',1254),(1339,'新罗区','d',1338),(1340,'漳平市','d',1338),(1341,'长汀县','d',1338),(1342,'武平县','d',1338),(1343,'上杭县','d',1338),(1344,'永定县','d',1338),(1345,'连城县','d',1338),(1346,'其他','d',1338),(1347,'宁德','c',1254),(1348,'蕉城区','d',1347),(1349,'福安市','d',1347),(1350,'福鼎市','d',1347),(1351,'寿宁县','d',1347),(1352,'霞浦县','d',1347),(1353,'柘荣县','d',1347),(1354,'屏南县','d',1347),(1355,'古田县','d',1347),(1356,'周宁县','d',1347),(1357,'其他','d',1347),(1358,'其他','c',1254),(1359,'其他','d',1358),(1360,'江西','p',NULL),(1361,'南昌','c',1360),(1362,'东湖区','d',1361),(1363,'西湖区','d',1361),(1364,'青云谱区','d',1361),(1365,'湾里区','d',1361),(1366,'青山湖区','d',1361),(1367,'新建县','d',1361),(1368,'南昌县','d',1361),(1369,'进贤县','d',1361),(1370,'安义县','d',1361),(1371,'其他','d',1361),(1372,'景德镇','c',1360),(1373,'珠山区','d',1372),(1374,'昌江区','d',1372),(1375,'乐平市','d',1372),(1376,'浮梁县','d',1372),(1377,'其他','d',1372),(1378,'萍乡','c',1360),(1379,'安源区','d',1378),(1380,'湘东区','d',1378),(1381,'莲花县','d',1378),(1382,'上栗县','d',1378),(1383,'芦溪县','d',1378),(1384,'其他','d',1378),(1385,'九江','c',1360),(1386,'浔阳区','d',1385),(1387,'庐山区','d',1385),(1388,'瑞昌市','d',1385),(1389,'九江县','d',1385),(1390,'星子县','d',1385),(1391,'武宁县','d',1385),(1392,'彭泽县','d',1385),(1393,'永修县','d',1385),(1394,'修水县','d',1385),(1395,'湖口县','d',1385),(1396,'德安县','d',1385),(1397,'都昌县','d',1385),(1398,'其他','d',1385),(1399,'新余','c',1360),(1400,'渝水区','d',1399),(1401,'分宜县','d',1399),(1402,'其他','d',1399),(1403,'鹰潭','c',1360),(1404,'月湖区','d',1403),(1405,'贵溪市','d',1403),(1406,'余江县','d',1403),(1407,'其他','d',1403),(1408,'赣州','c',1360),(1409,'章贡区','d',1408),(1410,'瑞金市','d',1408),(1411,'南康市','d',1408),(1412,'石城县','d',1408),(1413,'安远县','d',1408),(1414,'赣县','d',1408),(1415,'宁都县','d',1408),(1416,'寻乌县','d',1408),(1417,'兴国县','d',1408),(1418,'定南县','d',1408),(1419,'上犹县','d',1408),(1420,'于都县','d',1408),(1421,'龙南县','d',1408),(1422,'崇义县','d',1408),(1423,'信丰县','d',1408),(1424,'全南县','d',1408),(1425,'大余县','d',1408),(1426,'会昌县','d',1408),(1427,'其他','d',1408),(1428,'吉安','c',1360),(1429,'吉州区','d',1428),(1430,'青原区','d',1428),(1431,'井冈山市','d',1428),(1432,'吉安县','d',1428),(1433,'永丰县','d',1428),(1434,'永新县','d',1428),(1435,'新干县','d',1428),(1436,'泰和县','d',1428),(1437,'峡江县','d',1428),(1438,'遂川县','d',1428),(1439,'安福县','d',1428),(1440,'吉水县','d',1428),(1441,'万安县','d',1428),(1442,'其他','d',1428),(1443,'宜春','c',1360),(1444,'袁州区','d',1443),(1445,'丰城市','d',1443),(1446,'樟树市','d',1443),(1447,'高安市','d',1443),(1448,'铜鼓县','d',1443),(1449,'靖安县','d',1443),(1450,'宜丰县','d',1443),(1451,'奉新县','d',1443),(1452,'万载县','d',1443),(1453,'上高县','d',1443),(1454,'其他','d',1443),(1455,'抚州','c',1360),(1456,'临川区','d',1455),(1457,'南丰县','d',1455),(1458,'乐安县','d',1455),(1459,'金溪县','d',1455),(1460,'南城县','d',1455),(1461,'东乡县','d',1455),(1462,'资溪县','d',1455),(1463,'宜黄县','d',1455),(1464,'广昌县','d',1455),(1465,'黎川县','d',1455),(1466,'崇仁县','d',1455),(1467,'其他','d',1455),(1468,'上饶','c',1360),(1469,'信州区','d',1468),(1470,'德兴市','d',1468),(1471,'上饶县','d',1468),(1472,'广丰县','d',1468),(1473,'鄱阳县','d',1468),(1474,'婺源县','d',1468),(1475,'铅山县','d',1468),(1476,'余干县','d',1468),(1477,'横峰县','d',1468),(1478,'弋阳县','d',1468),(1479,'玉山县','d',1468),(1480,'万年县','d',1468),(1481,'其他','d',1468),(1482,'其他','c',1360),(1483,'其他','d',1482),(1484,'山东','p',NULL),(1485,'济南','c',1484),(1486,'市中区','d',1485),(1487,'历下区','d',1485),(1488,'天桥区','d',1485),(1489,'槐荫区','d',1485),(1490,'历城区','d',1485),(1491,'长清区','d',1485),(1492,'章丘市','d',1485),(1493,'平阴县','d',1485),(1494,'济阳县','d',1485),(1495,'商河县','d',1485),(1496,'其他','d',1485),(1497,'青岛','c',1484),(1498,'市南区','d',1497),(1499,'市北区','d',1497),(1500,'城阳区','d',1497),(1501,'四方区','d',1497),(1502,'李沧区','d',1497),(1503,'黄岛区','d',1497),(1504,'崂山区','d',1497),(1505,'胶南市','d',1497),(1506,'胶州市','d',1497),(1507,'平度市','d',1497),(1508,'莱西市','d',1497),(1509,'即墨市','d',1497),(1510,'其他','d',1497),(1511,'淄博','c',1484),(1512,'张店区','d',1511),(1513,'临淄区','d',1511),(1514,'淄川区','d',1511),(1515,'博山区','d',1511),(1516,'周村区','d',1511),(1517,'桓台县','d',1511),(1518,'高青县','d',1511),(1519,'沂源县','d',1511),(1520,'其他','d',1511),(1521,'枣庄','c',1484),(1522,'市中区','d',1521),(1523,'山亭区','d',1521),(1524,'峄城区','d',1521),(1525,'台儿庄区','d',1521),(1526,'薛城区','d',1521),(1527,'滕州市','d',1521),(1528,'其他','d',1521),(1529,'东营','c',1484),(1530,'东营区','d',1529),(1531,'河口区','d',1529),(1532,'垦利县','d',1529),(1533,'广饶县','d',1529),(1534,'利津县','d',1529),(1535,'其他','d',1529),(1536,'烟台','c',1484),(1537,'芝罘区','d',1536),(1538,'福山区','d',1536),(1539,'牟平区','d',1536),(1540,'莱山区','d',1536),(1541,'龙口市','d',1536),(1542,'莱阳市','d',1536),(1543,'莱州市','d',1536),(1544,'招远市','d',1536),(1545,'蓬莱市','d',1536),(1546,'栖霞市','d',1536),(1547,'海阳市','d',1536),(1548,'长岛县','d',1536),(1549,'其他','d',1536),(1550,'潍坊','c',1484),(1551,'潍城区','d',1550),(1552,'寒亭区','d',1550),(1553,'坊子区','d',1550),(1554,'奎文区','d',1550),(1555,'青州市','d',1550),(1556,'诸城市','d',1550),(1557,'寿光市','d',1550),(1558,'安丘市','d',1550),(1559,'高密市','d',1550),(1560,'昌邑市','d',1550),(1561,'昌乐县','d',1550),(1562,'临朐县','d',1550),(1563,'其他','d',1550),(1564,'济宁','c',1484),(1565,'市中区','d',1564),(1566,'任城区','d',1564),(1567,'曲阜市','d',1564),(1568,'兖州市','d',1564),(1569,'邹城市','d',1564),(1570,'鱼台县','d',1564),(1571,'金乡县','d',1564),(1572,'嘉祥县','d',1564),(1573,'微山县','d',1564),(1574,'汶上县','d',1564),(1575,'泗水县','d',1564),(1576,'梁山县','d',1564),(1577,'其他','d',1564),(1578,'泰安','c',1484),(1579,'泰山区','d',1578),(1580,'岱岳区','d',1578),(1581,'新泰市','d',1578),(1582,'肥城市','d',1578),(1583,'宁阳县','d',1578),(1584,'东平县','d',1578),(1585,'其他','d',1578),(1586,'威海','c',1484),(1587,'环翠区','d',1586),(1588,'乳山市','d',1586),(1589,'文登市','d',1586),(1590,'荣成市','d',1586),(1591,'其他','d',1586),(1592,'日照','c',1484),(1593,'东港区','d',1592),(1594,'岚山区','d',1592),(1595,'五莲县','d',1592),(1596,'莒县','d',1592),(1597,'其他','d',1592),(1598,'莱芜','c',1484),(1599,'莱城区','d',1598),(1600,'钢城区','d',1598),(1601,'其他','d',1598),(1602,'临沂','c',1484),(1603,'兰山区','d',1602),(1604,'罗庄区','d',1602),(1605,'河东区','d',1602),(1606,'沂南县','d',1602),(1607,'郯城县','d',1602),(1608,'沂水县','d',1602),(1609,'苍山县','d',1602),(1610,'费县','d',1602),(1611,'平邑县','d',1602),(1612,'莒南县','d',1602),(1613,'蒙阴县','d',1602),(1614,'临沭县','d',1602),(1615,'其他','d',1602),(1616,'德州','c',1484),(1617,'德城区','d',1616),(1618,'乐陵市','d',1616),(1619,'禹城市','d',1616),(1620,'陵县','d',1616),(1621,'宁津县','d',1616),(1622,'齐河县','d',1616),(1623,'武城县','d',1616),(1624,'庆云县','d',1616),(1625,'平原县','d',1616),(1626,'夏津县','d',1616),(1627,'临邑县','d',1616),(1628,'其他','d',1616),(1629,'聊城','c',1484),(1630,'东昌府区','d',1629),(1631,'临清市','d',1629),(1632,'高唐县','d',1629),(1633,'阳谷县','d',1629),(1634,'茌平县','d',1629),(1635,'莘县','d',1629),(1636,'东阿县','d',1629),(1637,'冠县','d',1629),(1638,'其他','d',1629),(1639,'滨州','c',1484),(1640,'滨城区','d',1639),(1641,'邹平县','d',1639),(1642,'沾化县','d',1639),(1643,'惠民县','d',1639),(1644,'博兴县','d',1639),(1645,'阳信县','d',1639),(1646,'无棣县','d',1639),(1647,'其他','d',1639),(1648,'菏泽','c',1484),(1649,'牡丹区','d',1648),(1650,'鄄城县','d',1648),(1651,'单县','d',1648),(1652,'郓城县','d',1648),(1653,'曹县','d',1648),(1654,'定陶县','d',1648),(1655,'巨野县','d',1648),(1656,'东明县','d',1648),(1657,'成武县','d',1648),(1658,'其他','d',1648),(1659,'其他','c',1484),(1660,'其他','d',1659),(1661,'河南','p',NULL),(1662,'郑州','c',1661),(1663,'中原区','d',1662),(1664,'金水区','d',1662),(1665,'二七区','d',1662),(1666,'管城回族区','d',1662),(1667,'上街区','d',1662),(1668,'惠济区','d',1662),(1669,'巩义市','d',1662),(1670,'新郑市','d',1662),(1671,'新密市','d',1662),(1672,'登封市','d',1662),(1673,'荥阳市','d',1662),(1674,'中牟县','d',1662),(1675,'其他','d',1662),(1676,'开封','c',1661),(1677,'鼓楼区','d',1676),(1678,'龙亭区','d',1676),(1679,'顺河回族区','d',1676),(1680,'禹王台区','d',1676),(1681,'金明区','d',1676),(1682,'开封县','d',1676),(1683,'尉氏县','d',1676),(1684,'兰考县','d',1676),(1685,'杞县','d',1676),(1686,'通许县','d',1676),(1687,'其他','d',1676),(1688,'洛阳','c',1661),(1689,'西工区','d',1688),(1690,'老城区','d',1688),(1691,'涧西区','d',1688),(1692,'瀍河回族区','d',1688),(1693,'洛龙区','d',1688),(1694,'吉利区','d',1688),(1695,'偃师市','d',1688),(1696,'孟津县','d',1688),(1697,'汝阳县','d',1688),(1698,'伊川县','d',1688),(1699,'洛宁县','d',1688),(1700,'嵩县','d',1688),(1701,'宜阳县','d',1688),(1702,'新安县','d',1688),(1703,'栾川县','d',1688),(1704,'其他','d',1688),(1705,'平顶山','c',1661),(1706,'新华区','d',1705),(1707,'卫东区','d',1705),(1708,'湛河区','d',1705),(1709,'石龙区','d',1705),(1710,'汝州市','d',1705),(1711,'舞钢市','d',1705),(1712,'宝丰县','d',1705),(1713,'叶县','d',1705),(1714,'郏县','d',1705),(1715,'鲁山县','d',1705),(1716,'其他','d',1705),(1717,'安阳','c',1661),(1718,'北关区','d',1717),(1719,'文峰区','d',1717),(1720,'殷都区','d',1717),(1721,'龙安区','d',1717),(1722,'林州市','d',1717),(1723,'安阳县','d',1717),(1724,'滑县','d',1717),(1725,'内黄县','d',1717),(1726,'汤阴县','d',1717),(1727,'其他','d',1717),(1728,'鹤壁','c',1661),(1729,'淇滨区','d',1728),(1730,'山城区','d',1728),(1731,'鹤山区','d',1728),(1732,'浚县','d',1728),(1733,'淇县','d',1728),(1734,'其他','d',1728),(1735,'新乡','c',1661),(1736,'卫滨区','d',1735),(1737,'红旗区','d',1735),(1738,'凤泉区','d',1735),(1739,'牧野区','d',1735),(1740,'卫辉市','d',1735),(1741,'辉县市','d',1735),(1742,'新乡县','d',1735),(1743,'获嘉县','d',1735),(1744,'原阳县','d',1735),(1745,'长垣县','d',1735),(1746,'封丘县','d',1735),(1747,'延津县','d',1735),(1748,'其他','d',1735),(1749,'焦作','c',1661),(1750,'解放区','d',1749),(1751,'中站区','d',1749),(1752,'马村区','d',1749),(1753,'山阳区','d',1749),(1754,'沁阳市','d',1749),(1755,'孟州市','d',1749),(1756,'修武县','d',1749),(1757,'温县','d',1749),(1758,'武陟县','d',1749),(1759,'博爱县','d',1749),(1760,'其他','d',1749),(1761,'濮阳','c',1661),(1762,'华龙区','d',1761),(1763,'濮阳县','d',1761),(1764,'南乐县','d',1761),(1765,'台前县','d',1761),(1766,'清丰县','d',1761),(1767,'范县','d',1761),(1768,'其他','d',1761),(1769,'许昌','c',1661),(1770,'魏都区','d',1769),(1771,'禹州市','d',1769),(1772,'长葛市','d',1769),(1773,'许昌县','d',1769),(1774,'鄢陵县','d',1769),(1775,'襄城县','d',1769),(1776,'其他','d',1769),(1777,'漯河','c',1661),(1778,'源汇区','d',1777),(1779,'郾城区','d',1777),(1780,'召陵区','d',1777),(1781,'临颍县','d',1777),(1782,'舞阳县','d',1777),(1783,'其他','d',1777),(1784,'三门峡','c',1661),(1785,'湖滨区','d',1784),(1786,'义马市','d',1784),(1787,'灵宝市','d',1784),(1788,'渑池县','d',1784),(1789,'卢氏县','d',1784),(1790,'陕县','d',1784),(1791,'其他','d',1784),(1792,'南阳','c',1661),(1793,'卧龙区','d',1792),(1794,'宛城区','d',1792),(1795,'邓州市','d',1792),(1796,'桐柏县','d',1792),(1797,'方城县','d',1792),(1798,'淅川县','d',1792),(1799,'镇平县','d',1792),(1800,'唐河县','d',1792),(1801,'南召县','d',1792),(1802,'内乡县','d',1792),(1803,'新野县','d',1792),(1804,'社旗县','d',1792),(1805,'西峡县','d',1792),(1806,'其他','d',1792),(1807,'商丘','c',1661),(1808,'梁园区','d',1807),(1809,'睢阳区','d',1807),(1810,'永城市','d',1807),(1811,'宁陵县','d',1807),(1812,'虞城县','d',1807),(1813,'民权县','d',1807),(1814,'夏邑县','d',1807),(1815,'柘城县','d',1807),(1816,'睢县','d',1807),(1817,'其他','d',1807),(1818,'信阳','c',1661),(1819,'浉河区','d',1818),(1820,'平桥区','d',1818),(1821,'潢川县','d',1818),(1822,'淮滨县','d',1818),(1823,'息县','d',1818),(1824,'新县','d',1818),(1825,'商城县','d',1818),(1826,'固始县','d',1818),(1827,'罗山县','d',1818),(1828,'光山县','d',1818),(1829,'其他','d',1818),(1830,'周口','c',1661),(1831,'川汇区','d',1830),(1832,'项城市','d',1830),(1833,'商水县','d',1830),(1834,'淮阳县','d',1830),(1835,'太康县','d',1830),(1836,'鹿邑县','d',1830),(1837,'西华县','d',1830),(1838,'扶沟县','d',1830),(1839,'沈丘县','d',1830),(1840,'郸城县','d',1830),(1841,'其他','d',1830),(1842,'驻马店','c',1661),(1843,'驿城区','d',1842),(1844,'确山县','d',1842),(1845,'新蔡县','d',1842),(1846,'上蔡县','d',1842),(1847,'西平县','d',1842),(1848,'泌阳县','d',1842),(1849,'平舆县','d',1842),(1850,'汝南县','d',1842),(1851,'遂平县','d',1842),(1852,'正阳县','d',1842),(1853,'其他','d',1842),(1855,'济源市','d',1854),(1856,'其他','d',1854),(1857,'其他','c',1661),(1858,'其他','d',1857),(1859,'湖北','p',NULL),(1860,'武汉','c',1859),(1861,'江岸区','d',1860),(1862,'武昌区','d',1860),(1863,'江汉区','d',1860),(1864,'硚口区','d',1860),(1865,'汉阳区','d',1860),(1866,'青山区','d',1860),(1867,'洪山区','d',1860),(1868,'东西湖区','d',1860),(1869,'汉南区','d',1860),(1870,'蔡甸区','d',1860),(1871,'江夏区','d',1860),(1872,'黄陂区','d',1860),(1873,'新洲区','d',1860),(1874,'其他','d',1860),(1875,'黄石','c',1859),(1876,'黄石港区','d',1875),(1877,'西塞山区','d',1875),(1878,'下陆区','d',1875),(1879,'铁山区','d',1875),(1880,'大冶市','d',1875),(1881,'阳新县','d',1875),(1882,'其他','d',1875),(1883,'十堰','c',1859),(1884,'张湾区','d',1883),(1885,'茅箭区','d',1883),(1886,'丹江口市','d',1883),(1887,'郧县','d',1883),(1888,'竹山县','d',1883),(1889,'房县','d',1883),(1890,'郧西县','d',1883),(1891,'竹溪县','d',1883),(1892,'其他','d',1883),(1893,'荆州','c',1859),(1894,'沙市区','d',1893),(1895,'荆州区','d',1893),(1896,'洪湖市','d',1893),(1897,'石首市','d',1893),(1898,'松滋市','d',1893),(1899,'监利县','d',1893),(1900,'公安县','d',1893),(1901,'江陵县','d',1893),(1902,'其他','d',1893),(1903,'宜昌','c',1859),(1904,'西陵区','d',1903),(1905,'伍家岗区','d',1903),(1906,'点军区','d',1903),(1907,'猇亭区','d',1903),(1908,'夷陵区','d',1903),(1909,'宜都市','d',1903),(1910,'当阳市','d',1903),(1911,'枝江市','d',1903),(1912,'秭归县','d',1903),(1913,'远安县','d',1903),(1914,'兴山县','d',1903),(1915,'五峰土家族自治县','d',1903),(1916,'长阳土家族自治县','d',1903),(1917,'其他','d',1903),(1918,'襄樊','c',1859),(1919,'襄城区','d',1918),(1920,'樊城区','d',1918),(1921,'襄阳区','d',1918),(1922,'老河口市','d',1918),(1923,'枣阳市','d',1918),(1924,'宜城市','d',1918),(1925,'南漳县','d',1918),(1926,'谷城县','d',1918),(1927,'保康县','d',1918),(1928,'其他','d',1918),(1929,'鄂州','c',1859),(1930,'鄂城区','d',1929),(1931,'华容区','d',1929),(1932,'梁子湖区','d',1929),(1933,'其他','d',1929),(1934,'荆门','c',1859),(1935,'东宝区','d',1934),(1936,'掇刀区','d',1934),(1937,'钟祥市','d',1934),(1938,'京山县','d',1934),(1939,'沙洋县','d',1934),(1940,'其他','d',1934),(1941,'孝感','c',1859),(1942,'孝南区','d',1941),(1943,'应城市','d',1941),(1944,'安陆市','d',1941),(1945,'汉川市','d',1941),(1946,'云梦县','d',1941),(1947,'大悟县','d',1941),(1948,'孝昌县','d',1941),(1949,'其他','d',1941),(1950,'黄冈','c',1859),(1951,'黄州区','d',1950),(1952,'麻城市','d',1950),(1953,'武穴市','d',1950),(1954,'红安县','d',1950),(1955,'罗田县','d',1950),(1956,'浠水县','d',1950),(1957,'蕲春县','d',1950),(1958,'黄梅县','d',1950),(1959,'英山县','d',1950),(1960,'团风县','d',1950),(1961,'其他','d',1950),(1962,'咸宁','c',1859),(1963,'咸安区','d',1962),(1964,'赤壁市','d',1962),(1965,'嘉鱼县','d',1962),(1966,'通山县','d',1962),(1967,'崇阳县','d',1962),(1968,'通城县','d',1962),(1969,'其他','d',1962),(1970,'随州','c',1859),(1971,'曾都区','d',1970),(1972,'广水市','d',1970),(1973,'其他','d',1970),(1974,'恩施土家族苗族自治州','c',1859),(1975,'恩施市','d',1974),(1976,'利川市','d',1974),(1977,'建始县','d',1974),(1978,'来凤县','d',1974),(1979,'巴东县','d',1974),(1980,'鹤峰县','d',1974),(1981,'宣恩县','d',1974),(1982,'咸丰县','d',1974),(1983,'其他','d',1974),(1984,'仙桃','c',1859),(1985,'仙桃','d',1984),(1986,'天门','c',1859),(1987,'天门','d',1986),(1988,'潜江','c',1859),(1989,'潜江','d',1988),(1990,'神农架林区','c',1859),(1991,'神农架林区','d',1990),(1992,'其他','c',1859),(1993,'其他','d',1992),(1994,'湖南','p',NULL),(1995,'长沙','c',1994),(1996,'岳麓区','d',1995),(1997,'芙蓉区','d',1995),(1998,'天心区','d',1995),(1999,'开福区','d',1995),(2000,'雨花区','d',1995),(2001,'浏阳市','d',1995),(2002,'长沙县','d',1995),(2003,'望城县','d',1995),(2004,'宁乡县','d',1995),(2005,'其他','d',1995),(2006,'株洲','c',1994),(2007,'天元区','d',2006),(2008,'荷塘区','d',2006),(2009,'芦淞区','d',2006),(2010,'石峰区','d',2006),(2011,'醴陵市','d',2006),(2012,'株洲县','d',2006),(2013,'炎陵县','d',2006),(2014,'茶陵县','d',2006),(2015,'攸县','d',2006),(2016,'其他','d',2006),(2017,'湘潭','c',1994),(2018,'岳塘区','d',2017),(2019,'雨湖区','d',2017),(2020,'湘乡市','d',2017),(2021,'韶山市','d',2017),(2022,'湘潭县','d',2017),(2023,'其他','d',2017),(2024,'衡阳','c',1994),(2025,'雁峰区','d',2024),(2026,'珠晖区','d',2024),(2027,'石鼓区','d',2024),(2028,'蒸湘区','d',2024),(2029,'南岳区','d',2024),(2030,'耒阳市','d',2024),(2031,'常宁市','d',2024),(2032,'衡阳县','d',2024),(2033,'衡东县','d',2024),(2034,'衡山县','d',2024),(2035,'衡南县','d',2024),(2036,'祁东县','d',2024),(2037,'其他','d',2024),(2038,'邵阳','c',1994),(2039,'双清区','d',2038),(2040,'大祥区','d',2038),(2041,'北塔区','d',2038),(2042,'武冈市','d',2038),(2043,'邵东县','d',2038),(2044,'洞口县','d',2038),(2045,'新邵县','d',2038),(2046,'绥宁县','d',2038),(2047,'新宁县','d',2038),(2048,'邵阳县','d',2038),(2049,'隆回县','d',2038),(2050,'城步苗族自治县','d',2038),(2051,'其他','d',2038),(2052,'岳阳','c',1994),(2053,'岳阳楼区','d',2052),(2054,'云溪区','d',2052),(2055,'君山区','d',2052),(2056,'临湘市','d',2052),(2057,'汨罗市','d',2052),(2058,'岳阳县','d',2052),(2059,'湘阴县','d',2052),(2060,'平江县','d',2052),(2061,'华容县','d',2052),(2062,'其他','d',2052),(2063,'常德','c',1994),(2064,'武陵区','d',2063),(2065,'鼎城区','d',2063),(2066,'津市市','d',2063),(2067,'澧县','d',2063),(2068,'临澧县','d',2063),(2069,'桃源县','d',2063),(2070,'汉寿县','d',2063),(2071,'安乡县','d',2063),(2072,'石门县','d',2063),(2073,'其他','d',2063),(2074,'张家界','c',1994),(2075,'永定区','d',2074),(2076,'武陵源区','d',2074),(2077,'慈利县','d',2074),(2078,'桑植县','d',2074),(2079,'其他','d',2074),(2080,'益阳','c',1994),(2081,'赫山区','d',2080),(2082,'资阳区','d',2080),(2083,'沅江市','d',2080),(2084,'桃江县','d',2080),(2085,'南县','d',2080),(2086,'安化县','d',2080),(2087,'其他','d',2080),(2088,'郴州','c',1994),(2089,'北湖区','d',2088),(2090,'苏仙区','d',2088),(2091,'资兴市','d',2088),(2092,'宜章县','d',2088),(2093,'汝城县','d',2088),(2094,'安仁县','d',2088),(2095,'嘉禾县','d',2088),(2096,'临武县','d',2088),(2097,'桂东县','d',2088),(2098,'永兴县','d',2088),(2099,'桂阳县','d',2088),(2100,'其他','d',2088),(2101,'永州','c',1994),(2102,'冷水滩区','d',2101),(2103,'零陵区','d',2101),(2104,'祁阳县','d',2101),(2105,'蓝山县','d',2101),(2106,'宁远县','d',2101),(2107,'新田县','d',2101),(2108,'东安县','d',2101),(2109,'江永县','d',2101),(2110,'道县','d',2101),(2111,'双牌县','d',2101),(2112,'江华瑶族自治县','d',2101),(2113,'其他','d',2101),(2114,'怀化','c',1994),(2115,'鹤城区','d',2114),(2116,'洪江市','d',2114),(2117,'会同县','d',2114),(2118,'沅陵县','d',2114),(2119,'辰溪县','d',2114),(2120,'溆浦县','d',2114),(2121,'中方县','d',2114),(2122,'新晃侗族自治县','d',2114),(2123,'芷江侗族自治县','d',2114),(2124,'通道侗族自治县','d',2114),(2125,'靖州苗族侗族自治县','d',2114),(2126,'麻阳苗族自治县','d',2114),(2127,'其他','d',2114),(2128,'娄底','c',1994),(2129,'娄星区','d',2128),(2130,'冷水江市','d',2128),(2131,'涟源市','d',2128),(2132,'新化县','d',2128),(2133,'双峰县','d',2128),(2134,'其他','d',2128),(2135,'湘西土家族苗族自治州','c',1994),(2136,'吉首市','d',2135),(2137,'古丈县','d',2135),(2138,'龙山县','d',2135),(2139,'永顺县','d',2135),(2140,'凤凰县','d',2135),(2141,'泸溪县','d',2135),(2142,'保靖县','d',2135),(2143,'花垣县','d',2135),(2144,'其他','d',2135),(2145,'其他','c',1994),(2146,'其他','d',2145),(2147,'广东','p',NULL),(2148,'广州','c',2147),(2149,'越秀区','d',2148),(2150,'荔湾区','d',2148),(2151,'海珠区','d',2148),(2152,'天河区','d',2148),(2153,'白云区','d',2148),(2154,'黄埔区','d',2148),(2155,'番禺区','d',2148),(2156,'花都区','d',2148),(2157,'南沙区','d',2148),(2158,'萝岗区','d',2148),(2159,'增城市','d',2148),(2160,'从化市','d',2148),(2161,'其他','d',2148),(2162,'深圳','c',2147),(2163,'福田区','d',2162),(2164,'罗湖区','d',2162),(2165,'南山区','d',2162),(2166,'宝安区','d',2162),(2167,'龙岗区','d',2162),(2168,'盐田区','d',2162),(2169,'其他','d',2162),(2170,'东莞','c',2147),(2171,'莞城','d',2170),(2172,'常平','d',2170),(2173,'塘厦','d',2170),(2176,'其他','d',2170),(2177,'中山','c',2147),(2178,'中山','d',2177),(2179,'潮州','c',2147),(2180,'湘桥区','d',2179),(2181,'潮安县','d',2179),(2182,'饶平县','d',2179),(2183,'其他','d',2179),(2184,'揭阳','c',2147),(2185,'榕城区','d',2184),(2186,'揭东县','d',2184),(2187,'揭西县','d',2184),(2188,'惠来县','d',2184),(2189,'普宁市','d',2184),(2190,'其他','d',2184),(2191,'云浮','c',2147),(2192,'云城区','d',2191),(2193,'新兴县','d',2191),(2194,'郁南县','d',2191),(2195,'云安县','d',2191),(2196,'罗定市','d',2191),(2197,'其他','d',2191),(2198,'珠海','c',2147),(2199,'香洲区','d',2198),(2200,'斗门区','d',2198),(2201,'金湾区','d',2198),(2202,'其他','d',2198),(2203,'汕头','c',2147),(2204,'金平区','d',2203),(2205,'濠江区','d',2203),(2206,'龙湖区','d',2203),(2207,'潮阳区','d',2203),(2208,'潮南区','d',2203),(2209,'澄海区','d',2203),(2210,'南澳县','d',2203),(2211,'其他','d',2203),(2212,'韶关','c',2147),(2213,'浈江区','d',2212),(2214,'武江区','d',2212),(2215,'曲江区','d',2212),(2216,'乐昌市','d',2212),(2217,'南雄市','d',2212),(2218,'始兴县','d',2212),(2219,'仁化县','d',2212),(2220,'翁源县','d',2212),(2221,'新丰县','d',2212),(2222,'乳源瑶族自治县','d',2212),(2223,'其他','d',2212),(2224,'佛山','c',2147),(2225,'禅城区','d',2224),(2226,'南海区','d',2224),(2227,'顺德区','d',2224),(2228,'三水区','d',2224),(2229,'高明区','d',2224),(2230,'其他','d',2224),(2231,'江门','c',2147),(2232,'蓬江区','d',2231),(2233,'江海区','d',2231),(2234,'新会区','d',2231),(2235,'恩平市','d',2231),(2236,'台山市','d',2231),(2237,'开平市','d',2231),(2238,'鹤山市','d',2231),(2239,'其他','d',2231),(2240,'湛江','c',2147),(2241,'赤坎区','d',2240),(2242,'霞山区','d',2240),(2243,'坡头区','d',2240),(2244,'麻章区','d',2240),(2245,'吴川市','d',2240),(2246,'廉江市','d',2240),(2247,'雷州市','d',2240),(2248,'遂溪县','d',2240),(2249,'徐闻县','d',2240),(2250,'其他','d',2240),(2251,'茂名','c',2147),(2252,'茂南区','d',2251),(2253,'茂港区','d',2251),(2254,'化州市','d',2251),(2255,'信宜市','d',2251),(2256,'高州市','d',2251),(2257,'电白县','d',2251),(2258,'其他','d',2251),(2259,'肇庆','c',2147),(2260,'端州区','d',2259),(2261,'鼎湖区','d',2259),(2262,'高要市','d',2259),(2263,'四会市','d',2259),(2264,'广宁县','d',2259),(2265,'怀集县','d',2259),(2266,'封开县','d',2259),(2267,'德庆县','d',2259),(2268,'其他','d',2259),(2269,'惠州','c',2147),(2270,'惠城区','d',2269),(2271,'惠阳区','d',2269),(2272,'博罗县','d',2269),(2273,'惠东县','d',2269),(2274,'龙门县','d',2269),(2275,'其他','d',2269),(2276,'梅州','c',2147),(2277,'梅江区','d',2276),(2278,'兴宁市','d',2276),(2279,'梅县','d',2276),(2280,'大埔县','d',2276),(2281,'丰顺县','d',2276),(2282,'五华县','d',2276),(2283,'平远县','d',2276),(2284,'蕉岭县','d',2276),(2285,'其他','d',2276),(2286,'汕尾','c',2147),(2287,'城区','d',2286),(2288,'陆丰市','d',2286),(2289,'海丰县','d',2286),(2290,'陆河县','d',2286),(2291,'其他','d',2286),(2292,'河源','c',2147),(2293,'源城区','d',2292),(2294,'紫金县','d',2292),(2295,'龙川县','d',2292),(2296,'连平县','d',2292),(2297,'和平县','d',2292),(2298,'东源县','d',2292),(2299,'其他','d',2292),(2300,'阳江','c',2147),(2301,'江城区','d',2300),(2302,'阳春市','d',2300),(2303,'阳西县','d',2300),(2304,'阳东县','d',2300),(2305,'其他','d',2300),(2306,'清远','c',2147),(2307,'清城区','d',2306),(2308,'英德市','d',2306),(2309,'连州市','d',2306),(2310,'佛冈县','d',2306),(2311,'阳山县','d',2306),(2312,'清新县','d',2306),(2313,'连山壮族瑶族自治县','d',2306),(2314,'连南瑶族自治县','d',2306),(2315,'其他','d',2306),(2316,'广西','p',NULL),(2317,'南宁','c',2316),(2318,'青秀区','d',2317),(2319,'兴宁区','d',2317),(2320,'西乡塘区','d',2317),(2321,'良庆区','d',2317),(2322,'江南区','d',2317),(2323,'邕宁区','d',2317),(2324,'武鸣县','d',2317),(2325,'隆安县','d',2317),(2326,'马山县','d',2317),(2327,'上林县','d',2317),(2328,'宾阳县','d',2317),(2329,'横县','d',2317),(2330,'其他','d',2317),(2331,'柳州','c',2316),(2332,'城中区','d',2331),(2333,'鱼峰区','d',2331),(2334,'柳北区','d',2331),(2335,'柳南区','d',2331),(2336,'柳江县','d',2331),(2337,'柳城县','d',2331),(2338,'鹿寨县','d',2331),(2339,'融安县','d',2331),(2340,'融水苗族自治县','d',2331),(2341,'三江侗族自治县','d',2331),(2342,'其他','d',2331),(2343,'桂林','c',2316),(2344,'象山区','d',2343),(2345,'秀峰区','d',2343),(2346,'叠彩区','d',2343),(2347,'七星区','d',2343),(2348,'雁山区','d',2343),(2349,'阳朔县','d',2343),(2350,'临桂县','d',2343),(2351,'灵川县','d',2343),(2352,'全州县','d',2343),(2353,'平乐县','d',2343),(2354,'兴安县','d',2343),(2355,'灌阳县','d',2343),(2356,'荔浦县','d',2343),(2357,'资源县','d',2343),(2358,'永福县','d',2343),(2359,'龙胜各族自治县','d',2343),(2360,'恭城瑶族自治县','d',2343),(2361,'其他','d',2343),(2362,'梧州','c',2316),(2363,'万秀区','d',2362),(2364,'蝶山区','d',2362),(2365,'长洲区','d',2362),(2366,'岑溪市','d',2362),(2367,'苍梧县','d',2362),(2368,'藤县','d',2362),(2369,'蒙山县','d',2362),(2370,'其他','d',2362),(2371,'北海','c',2316),(2372,'海城区','d',2371),(2373,'银海区','d',2371),(2374,'铁山港区','d',2371),(2375,'合浦县','d',2371),(2376,'其他','d',2371),(2377,'防城港','c',2316),(2378,'港口区','d',2377),(2379,'防城区','d',2377),(2380,'东兴市','d',2377),(2381,'上思县','d',2377),(2382,'其他','d',2377),(2383,'钦州','c',2316),(2384,'钦南区','d',2383),(2385,'钦北区','d',2383),(2386,'灵山县','d',2383),(2387,'浦北县','d',2383),(2388,'其他','d',2383),(2389,'贵港','c',2316),(2390,'港北区','d',2389),(2391,'港南区','d',2389),(2392,'覃塘区','d',2389),(2393,'桂平市','d',2389),(2394,'平南县','d',2389),(2395,'其他','d',2389),(2396,'玉林','c',2316),(2397,'玉州区','d',2396),(2398,'北流市','d',2396),(2399,'容县','d',2396),(2400,'陆川县','d',2396),(2401,'博白县','d',2396),(2402,'兴业县','d',2396),(2403,'其他','d',2396),(2404,'百色','c',2316),(2405,'右江区','d',2404),(2406,'凌云县','d',2404),(2407,'平果县','d',2404),(2408,'西林县','d',2404),(2409,'乐业县','d',2404),(2410,'德保县','d',2404),(2411,'田林县','d',2404),(2412,'田阳县','d',2404),(2413,'靖西县','d',2404),(2414,'田东县','d',2404),(2415,'那坡县','d',2404),(2416,'隆林各族自治县','d',2404),(2417,'其他','d',2404),(2418,'贺州','c',2316),(2419,'八步区','d',2418),(2420,'钟山县','d',2418),(2421,'昭平县','d',2418),(2422,'富川瑶族自治县','d',2418),(2423,'其他','d',2418),(2424,'河池','c',2316),(2425,'金城江区','d',2424),(2426,'宜州市','d',2424),(2427,'天峨县','d',2424),(2428,'凤山县','d',2424),(2429,'南丹县','d',2424),(2430,'东兰县','d',2424),(2431,'都安瑶族自治县','d',2424),(2432,'罗城仫佬族自治县','d',2424),(2433,'巴马瑶族自治县','d',2424),(2434,'环江毛南族自治县','d',2424),(2435,'大化瑶族自治县','d',2424),(2436,'其他','d',2424),(2437,'来宾','c',2316),(2438,'兴宾区','d',2437),(2439,'合山市','d',2437),(2440,'象州县','d',2437),(2441,'武宣县','d',2437),(2442,'忻城县','d',2437),(2443,'金秀瑶族自治县','d',2437),(2444,'其他','d',2437),(2445,'崇左','c',2316),(2446,'江州区','d',2445),(2447,'凭祥市','d',2445),(2448,'宁明县','d',2445),(2449,'扶绥县','d',2445),(2450,'龙州县','d',2445),(2451,'大新县','d',2445),(2452,'天等县','d',2445),(2453,'其他','d',2445),(2454,'其他','c',2316),(2455,'其他','d',2454),(2456,'海南','p',NULL),(2457,'海口','c',2456),(2458,'龙华区','d',2457),(2459,'秀英区','d',2457),(2460,'琼山区','d',2457),(2461,'美兰区','d',2457),(2462,'其他','d',2457),(2463,'三亚','c',2456),(2464,'三亚市','d',2463),(2465,'其他','d',2463),(2466,'五指山','c',2456),(2467,'五指山','d',2466),(2468,'琼海','c',2456),(2469,'琼海','d',2468),(2470,'儋州','c',2456),(2471,'儋州','d',2470),(2472,'文昌','c',2456),(2473,'文昌','d',2472),(2474,'万宁','c',2456),(2475,'万宁','d',2474),(2476,'东方','c',2456),(2477,'东方','d',2476),(2478,'澄迈县','c',2456),(2479,'澄迈县','d',2478),(2480,'定安县','c',2456),(2481,'定安县','d',2480),(2482,'屯昌县','c',2456),(2483,'屯昌县','d',2482),(2484,'临高县','c',2456),(2485,'临高县','d',2484),(2486,'白沙黎族自治县','c',2456),(2487,'白沙黎族自治县','d',2486),(2488,'昌江黎族自治县','c',2456),(2489,'昌江黎族自治县','d',2488),(2490,'乐东黎族自治县','c',2456),(2491,'乐东黎族自治县','d',2490),(2492,'陵水黎族自治县','c',2456),(2493,'陵水黎族自治县','d',2492),(2494,'保亭黎族苗族自治县','c',2456),(2495,'保亭黎族苗族自治县','d',2494),(2496,'琼中黎族苗族自治县','c',2456),(2497,'琼中黎族苗族自治县','d',2496),(2498,'其他','c',2456),(2499,'其他','d',2498),(2500,'重庆','p',NULL),(2501,'重庆','c',2500),(2502,'渝中区','d',2501),(2503,'大渡口区','d',2501),(2504,'江北区','d',2501),(2505,'南岸区','d',2501),(2506,'北碚区','d',2501),(2507,'渝北区','d',2501),(2508,'巴南区','d',2501),(2509,'长寿区','d',2501),(2510,'双桥区','d',2501),(2511,'沙坪坝区','d',2501),(2512,'万盛区','d',2501),(2513,'万州区','d',2501),(2514,'涪陵区','d',2501),(2515,'黔江区','d',2501),(2516,'永川区','d',2501),(2517,'合川区','d',2501),(2518,'江津区','d',2501),(2519,'九龙坡区','d',2501),(2520,'南川区','d',2501),(2521,'綦江县','d',2501),(2522,'潼南县','d',2501),(2523,'荣昌县','d',2501),(2524,'璧山县','d',2501),(2525,'大足县','d',2501),(2526,'铜梁县','d',2501),(2527,'梁平县','d',2501),(2528,'开县','d',2501),(2529,'忠县','d',2501),(2530,'城口县','d',2501),(2531,'垫江县','d',2501),(2532,'武隆县','d',2501),(2533,'丰都县','d',2501),(2534,'奉节县','d',2501),(2535,'云阳县','d',2501),(2536,'巫溪县','d',2501),(2537,'巫山县','d',2501),(2538,'石柱土家族自治县','d',2501),(2539,'秀山土家族苗族自治县','d',2501),(2540,'酉阳土家族苗族自治县','d',2501),(2541,'彭水苗族土家族自治县','d',2501),(2542,'其他','d',2501),(2543,'四川','p',NULL),(2544,'成都','c',2543),(2545,'青羊区','d',2544),(2546,'锦江区','d',2544),(2547,'金牛区','d',2544),(2548,'武侯区','d',2544),(2549,'成华区','d',2544),(2550,'龙泉驿区','d',2544),(2551,'青白江区','d',2544),(2552,'新都区','d',2544),(2553,'温江区','d',2544),(2554,'都江堰市','d',2544),(2555,'彭州市','d',2544),(2556,'邛崃市','d',2544),(2557,'崇州市','d',2544),(2558,'金堂县','d',2544),(2559,'郫县','d',2544),(2560,'新津县','d',2544),(2561,'双流县','d',2544),(2562,'蒲江县','d',2544),(2563,'大邑县','d',2544),(2564,'其他','d',2544),(2565,'自贡','c',2543),(2566,'大安区','d',2565),(2567,'自流井区','d',2565),(2568,'贡井区','d',2565),(2569,'沿滩区','d',2565),(2570,'荣县','d',2565),(2571,'富顺县','d',2565),(2572,'其他','d',2565),(2573,'攀枝花','c',2543),(2574,'仁和区','d',2573),(2575,'米易县','d',2573),(2576,'盐边县','d',2573),(2577,'东区','d',2573),(2578,'西区','d',2573),(2579,'其他','d',2573),(2580,'泸州','c',2543),(2581,'江阳区','d',2580),(2582,'纳溪区','d',2580),(2583,'龙马潭区','d',2580),(2584,'泸县','d',2580),(2585,'合江县','d',2580),(2586,'叙永县','d',2580),(2587,'古蔺县','d',2580),(2588,'其他','d',2580),(2589,'德阳','c',2543),(2590,'旌阳区','d',2589),(2591,'广汉市','d',2589),(2592,'什邡市','d',2589),(2593,'绵竹市','d',2589),(2594,'罗江县','d',2589),(2595,'中江县','d',2589),(2596,'其他','d',2589),(2597,'绵阳','c',2543),(2598,'涪城区','d',2597),(2599,'游仙区','d',2597),(2600,'江油市','d',2597),(2601,'盐亭县','d',2597),(2602,'三台县','d',2597),(2603,'平武县','d',2597),(2604,'安县','d',2597),(2605,'梓潼县','d',2597),(2606,'北川羌族自治县','d',2597),(2607,'其他','d',2597),(2608,'广元','c',2543),(2609,'元坝区','d',2608),(2610,'朝天区','d',2608),(2611,'青川县','d',2608),(2612,'旺苍县','d',2608),(2613,'剑阁县','d',2608),(2614,'苍溪县','d',2608),(2615,'市中区','d',2608),(2616,'其他','d',2608),(2617,'遂宁','c',2543),(2618,'船山区','d',2617),(2619,'安居区','d',2617),(2620,'射洪县','d',2617),(2621,'蓬溪县','d',2617),(2622,'大英县','d',2617),(2623,'其他','d',2617),(2624,'内江','c',2543),(2625,'市中区','d',2624),(2626,'东兴区','d',2624),(2627,'资中县','d',2624),(2628,'隆昌县','d',2624),(2629,'威远县','d',2624),(2630,'其他','d',2624),(2631,'乐山','c',2543),(2632,'市中区','d',2631),(2633,'五通桥区','d',2631),(2634,'沙湾区','d',2631),(2635,'金口河区','d',2631),(2636,'峨眉山市','d',2631),(2637,'夹江县','d',2631),(2638,'井研县','d',2631),(2639,'犍为县','d',2631),(2640,'沐川县','d',2631),(2641,'马边彝族自治县','d',2631),(2642,'峨边彝族自治县','d',2631),(2643,'其他','d',2631),(2644,'南充','c',2543),(2645,'顺庆区','d',2644),(2646,'高坪区','d',2644),(2647,'嘉陵区','d',2644),(2648,'阆中市','d',2644),(2649,'营山县','d',2644),(2650,'蓬安县','d',2644),(2651,'仪陇县','d',2644),(2652,'南部县','d',2644),(2653,'西充县','d',2644),(2654,'其他','d',2644),(2655,'眉山','c',2543),(2656,'东坡区','d',2655),(2657,'仁寿县','d',2655),(2658,'彭山县','d',2655),(2659,'洪雅县','d',2655),(2660,'丹棱县','d',2655),(2661,'青神县','d',2655),(2662,'其他','d',2655),(2663,'宜宾','c',2543),(2664,'翠屏区','d',2663),(2665,'宜宾县','d',2663),(2666,'兴文县','d',2663),(2667,'南溪县','d',2663),(2668,'珙县','d',2663),(2669,'长宁县','d',2663),(2670,'高县','d',2663),(2671,'江安县','d',2663),(2672,'筠连县','d',2663),(2673,'屏山县','d',2663),(2674,'其他','d',2663),(2675,'广安','c',2543),(2676,'广安区','d',2675),(2677,'华蓥市','d',2675),(2678,'岳池县','d',2675),(2679,'邻水县','d',2675),(2680,'武胜县','d',2675),(2681,'其他','d',2675),(2682,'达州','c',2543),(2683,'通川区','d',2682),(2684,'万源市','d',2682),(2685,'达县','d',2682),(2686,'渠县','d',2682),(2687,'宣汉县','d',2682),(2688,'开江县','d',2682),(2689,'大竹县','d',2682),(2690,'其他','d',2682),(2691,'雅安','c',2543),(2692,'雨城区','d',2691),(2693,'芦山县','d',2691),(2694,'石棉县','d',2691),(2695,'名山县','d',2691),(2696,'天全县','d',2691),(2697,'荥经县','d',2691),(2698,'宝兴县','d',2691),(2699,'汉源县','d',2691),(2700,'其他','d',2691),(2701,'巴中','c',2543),(2702,'巴州区','d',2701),(2703,'南江县','d',2701),(2704,'平昌县','d',2701),(2705,'通江县','d',2701),(2706,'其他','d',2701),(2707,'资阳','c',2543),(2708,'雁江区','d',2707),(2709,'简阳市','d',2707),(2710,'安岳县','d',2707),(2711,'乐至县','d',2707),(2712,'其他','d',2707),(2713,'阿坝藏族羌族自治州','c',2543),(2714,'马尔康县','d',2713),(2715,'九寨沟县','d',2713),(2716,'红原县','d',2713),(2717,'汶川县','d',2713),(2718,'阿坝县','d',2713),(2719,'理县','d',2713),(2720,'若尔盖县','d',2713),(2721,'小金县','d',2713),(2722,'黑水县','d',2713),(2723,'金川县','d',2713),(2724,'松潘县','d',2713),(2725,'壤塘县','d',2713),(2726,'茂县','d',2713),(2727,'其他','d',2713),(2728,'甘孜藏族自治州','c',2543),(2729,'康定县','d',2728),(2730,'丹巴县','d',2728),(2731,'炉霍县','d',2728),(2732,'九龙县','d',2728),(2733,'甘孜县','d',2728),(2734,'雅江县','d',2728),(2735,'新龙县','d',2728),(2736,'道孚县','d',2728),(2737,'白玉县','d',2728),(2738,'理塘县','d',2728),(2739,'德格县','d',2728),(2740,'乡城县','d',2728),(2741,'石渠县','d',2728),(2742,'稻城县','d',2728),(2743,'色达县','d',2728),(2744,'巴塘县','d',2728),(2745,'泸定县','d',2728),(2746,'得荣县','d',2728),(2747,'其他','d',2728),(2748,'凉山彝族自治州','c',2543),(2749,'西昌市','d',2748),(2750,'美姑县','d',2748),(2751,'昭觉县','d',2748),(2752,'金阳县','d',2748),(2753,'甘洛县','d',2748),(2754,'布拖县','d',2748),(2755,'雷波县','d',2748),(2756,'普格县','d',2748),(2757,'宁南县','d',2748),(2758,'喜德县','d',2748),(2759,'会东县','d',2748),(2760,'越西县','d',2748),(2761,'会理县','d',2748),(2762,'盐源县','d',2748),(2763,'德昌县','d',2748),(2764,'冕宁县','d',2748),(2765,'木里藏族自治县','d',2748),(2766,'其他','d',2748),(2767,'其他','c',2543),(2768,'其他','d',2767),(2769,'贵州','p',NULL),(2770,'贵阳','c',2769),(2771,'南明区','d',2770),(2772,'云岩区','d',2770),(2773,'花溪区','d',2770),(2774,'乌当区','d',2770),(2775,'白云区','d',2770),(2776,'小河区','d',2770),(2777,'清镇市','d',2770),(2778,'开阳县','d',2770),(2779,'修文县','d',2770),(2780,'息烽县','d',2770),(2781,'其他','d',2770),(2782,'六盘水','c',2769),(2783,'钟山区','d',2782),(2784,'水城县','d',2782),(2785,'盘县','d',2782),(2786,'六枝特区','d',2782),(2787,'其他','d',2782),(2788,'遵义','c',2769),(2789,'红花岗区','d',2788),(2790,'汇川区','d',2788),(2791,'赤水市','d',2788),(2792,'仁怀市','d',2788),(2793,'遵义县','d',2788),(2794,'绥阳县','d',2788),(2795,'桐梓县','d',2788),(2796,'习水县','d',2788),(2797,'凤冈县','d',2788),(2798,'正安县','d',2788),(2799,'余庆县','d',2788),(2800,'湄潭县','d',2788),(2801,'道真仡佬族苗族自治县','d',2788),(2802,'务川仡佬族苗族自治县','d',2788),(2803,'其他','d',2788),(2804,'安顺','c',2769),(2805,'西秀区','d',2804),(2806,'普定县','d',2804),(2807,'平坝县','d',2804),(2808,'镇宁布依族苗族自治县','d',2804),(2809,'紫云苗族布依族自治县','d',2804),(2810,'关岭布依族苗族自治县','d',2804),(2811,'其他','d',2804),(2812,'铜仁地区','c',2769),(2813,'铜仁市','d',2812),(2814,'德江县','d',2812),(2815,'江口县','d',2812),(2816,'思南县','d',2812),(2817,'石阡县','d',2812),(2818,'玉屏侗族自治县','d',2812),(2819,'松桃苗族自治县','d',2812),(2820,'印江土家族苗族自治县','d',2812),(2821,'沿河土家族自治县','d',2812),(2822,'万山特区','d',2812),(2823,'其他','d',2812),(2824,'毕节地区','c',2769),(2825,'毕节市','d',2824),(2826,'黔西县','d',2824),(2827,'大方县','d',2824),(2828,'织金县','d',2824),(2829,'金沙县','d',2824),(2830,'赫章县','d',2824),(2831,'纳雍县','d',2824),(2832,'威宁彝族回族苗族自治县','d',2824),(2833,'其他','d',2824),(2834,'黔西南布依族苗族自治州','c',2769),(2835,'兴义市','d',2834),(2836,'望谟县','d',2834),(2837,'兴仁县','d',2834),(2838,'普安县','d',2834),(2839,'册亨县','d',2834),(2840,'晴隆县','d',2834),(2841,'贞丰县','d',2834),(2842,'安龙县','d',2834),(2843,'其他','d',2834),(2844,'黔东南苗族侗族自治州','c',2769),(2845,'凯里市','d',2844),(2846,'施秉县','d',2844),(2847,'从江县','d',2844),(2848,'锦屏县','d',2844),(2849,'镇远县','d',2844),(2850,'麻江县','d',2844),(2851,'台江县','d',2844),(2852,'天柱县','d',2844),(2853,'黄平县','d',2844),(2854,'榕江县','d',2844),(2855,'剑河县','d',2844),(2856,'三穗县','d',2844),(2857,'雷山县','d',2844),(2858,'黎平县','d',2844),(2859,'岑巩县','d',2844),(2860,'丹寨县','d',2844),(2861,'其他','d',2844),(2862,'黔南布依族苗族自治州','c',2769),(2863,'都匀市','d',2862),(2864,'福泉市','d',2862),(2865,'贵定县','d',2862),(2866,'惠水县','d',2862),(2867,'罗甸县','d',2862),(2868,'瓮安县','d',2862),(2869,'荔波县','d',2862),(2870,'龙里县','d',2862),(2871,'平塘县','d',2862),(2872,'长顺县','d',2862),(2873,'独山县','d',2862),(2874,'三都水族自治县','d',2862),(2875,'其他','d',2862),(2876,'其他','c',2769),(2877,'其他','d',2876),(2878,'云南','p',NULL),(2879,'昆明','c',2878),(2880,'盘龙区','d',2879),(2881,'五华区','d',2879),(2882,'官渡区','d',2879),(2883,'西山区','d',2879),(2884,'东川区','d',2879),(2885,'安宁市','d',2879),(2886,'呈贡县','d',2879),(2887,'晋宁县','d',2879),(2888,'富民县','d',2879),(2889,'宜良县','d',2879),(2890,'嵩明县','d',2879),(2891,'石林彝族自治县','d',2879),(2892,'禄劝彝族苗族自治县','d',2879),(2893,'寻甸回族彝族自治县','d',2879),(2894,'其他','d',2879),(2895,'曲靖','c',2878),(2896,'麒麟区','d',2895),(2897,'宣威市','d',2895),(2898,'马龙县','d',2895),(2899,'沾益县','d',2895),(2900,'富源县','d',2895),(2901,'罗平县','d',2895),(2902,'师宗县','d',2895),(2903,'陆良县','d',2895),(2904,'会泽县','d',2895),(2905,'其他','d',2895),(2906,'玉溪','c',2878),(2907,'红塔区','d',2906),(2908,'江川县','d',2906),(2909,'澄江县','d',2906),(2910,'通海县','d',2906),(2911,'华宁县','d',2906),(2912,'易门县','d',2906),(2913,'峨山彝族自治县','d',2906),(2914,'新平彝族傣族自治县','d',2906),(2915,'元江哈尼族彝族傣族自治县','d',2906),(2916,'其他','d',2906),(2917,'保山','c',2878),(2918,'隆阳区','d',2917),(2919,'施甸县','d',2917),(2920,'腾冲县','d',2917),(2921,'龙陵县','d',2917),(2922,'昌宁县','d',2917),(2923,'其他','d',2917),(2924,'昭通','c',2878),(2925,'昭阳区','d',2924),(2926,'鲁甸县','d',2924),(2927,'巧家县','d',2924),(2928,'盐津县','d',2924),(2929,'大关县','d',2924),(2930,'永善县','d',2924),(2931,'绥江县','d',2924),(2932,'镇雄县','d',2924),(2933,'彝良县','d',2924),(2934,'威信县','d',2924),(2935,'水富县','d',2924),(2936,'其他','d',2924),(2937,'丽江','c',2878),(2938,'古城区','d',2937),(2939,'永胜县','d',2937),(2940,'华坪县','d',2937),(2941,'玉龙纳西族自治县','d',2937),(2942,'宁蒗彝族自治县','d',2937),(2943,'其他','d',2937),(2944,'普洱','c',2878),(2945,'思茅区','d',2944),(2946,'普洱哈尼族彝族自治县','d',2944),(2947,'墨江哈尼族自治县','d',2944),(2948,'景东彝族自治县','d',2944),(2949,'景谷傣族彝族自治县','d',2944),(2950,'镇沅彝族哈尼族拉祜族自治县','d',2944),(2951,'江城哈尼族彝族自治县','d',2944),(2952,'孟连傣族拉祜族佤族自治县','d',2944),(2953,'澜沧拉祜族自治县','d',2944),(2954,'西盟佤族自治县','d',2944),(2955,'其他','d',2944),(2956,'临沧','c',2878),(2957,'临翔区','d',2956),(2958,'凤庆县','d',2956),(2959,'云县','d',2956),(2960,'永德县','d',2956),(2961,'镇康县','d',2956),(2962,'双江拉祜族佤族布朗族傣族自治县','d',2956),(2963,'耿马傣族佤族自治县','d',2956),(2964,'沧源佤族自治县','d',2956),(2965,'其他','d',2956),(2966,'德宏傣族景颇族自治州','c',2878),(2967,'潞西市','d',2966),(2968,'瑞丽市','d',2966),(2969,'梁河县','d',2966),(2970,'盈江县','d',2966),(2971,'陇川县','d',2966),(2972,'其他','d',2966),(2973,'怒江傈僳族自治州','c',2878),(2974,'泸水县','d',2973),(2975,'福贡县','d',2973),(2976,'贡山独龙族怒族自治县','d',2973),(2977,'兰坪白族普米族自治县','d',2973),(2978,'其他','d',2973),(2979,'迪庆藏族自治州','c',2878),(2980,'香格里拉县','d',2979),(2981,'德钦县','d',2979),(2982,'维西傈僳族自治县','d',2979),(2983,'其他','d',2979),(2984,'大理白族自治州','c',2878),(2985,'大理市','d',2984),(2986,'祥云县','d',2984),(2987,'宾川县','d',2984),(2988,'弥渡县','d',2984),(2989,'永平县','d',2984),(2990,'云龙县','d',2984),(2991,'洱源县','d',2984),(2992,'剑川县','d',2984),(2993,'鹤庆县','d',2984),(2994,'漾濞彝族自治县','d',2984),(2995,'南涧彝族自治县','d',2984),(2996,'巍山彝族回族自治县','d',2984),(2997,'其他','d',2984),(2998,'楚雄彝族自治州','c',2878),(2999,'楚雄市','d',2998),(3000,'双柏县','d',2998),(3001,'牟定县','d',2998),(3002,'南华县','d',2998),(3003,'姚安县','d',2998),(3004,'大姚县','d',2998),(3005,'永仁县','d',2998),(3006,'元谋县','d',2998),(3007,'武定县','d',2998),(3008,'禄丰县','d',2998),(3009,'其他','d',2998),(3010,'红河哈尼族彝族自治州','c',2878),(3011,'蒙自县','d',3010),(3012,'个旧市','d',3010),(3013,'开远市','d',3010),(3014,'绿春县','d',3010),(3015,'建水县','d',3010),(3016,'石屏县','d',3010),(3017,'弥勒县','d',3010),(3018,'泸西县','d',3010),(3019,'元阳县','d',3010),(3020,'红河县','d',3010),(3021,'金平苗族瑶族傣族自治县','d',3010),(3022,'河口瑶族自治县','d',3010),(3023,'屏边苗族自治县','d',3010),(3024,'其他','d',3010),(3025,'文山壮族苗族自治州','c',2878),(3026,'文山县','d',3025),(3027,'砚山县','d',3025),(3028,'西畴县','d',3025),(3029,'麻栗坡县','d',3025),(3030,'马关县','d',3025),(3031,'丘北县','d',3025),(3032,'广南县','d',3025),(3033,'富宁县','d',3025),(3034,'其他','d',3025),(3035,'西双版纳傣族自治州','c',2878),(3036,'景洪市','d',3035),(3037,'勐海县','d',3035),(3038,'勐腊县','d',3035),(3039,'其他','d',3035),(3040,'其他','c',2878),(3041,'其他','d',3040),(3042,'西藏','p',NULL),(3043,'拉萨','c',3042),(3044,'城关区','d',3043),(3045,'林周县','d',3043),(3046,'当雄县','d',3043),(3047,'尼木县','d',3043),(3048,'曲水县','d',3043),(3049,'堆龙德庆县','d',3043),(3050,'达孜县','d',3043),(3051,'墨竹工卡县','d',3043),(3052,'其他','d',3043),(3053,'那曲地区','c',3042),(3054,'那曲县','d',3053),(3055,'嘉黎县','d',3053),(3056,'比如县','d',3053),(3057,'聂荣县','d',3053),(3058,'安多县','d',3053),(3059,'申扎县','d',3053),(3060,'索县','d',3053),(3061,'班戈县','d',3053),(3062,'巴青县','d',3053),(3063,'尼玛县','d',3053),(3064,'其他','d',3053),(3065,'昌都地区','c',3042),(3066,'昌都县','d',3065),(3067,'江达县','d',3065),(3068,'贡觉县','d',3065),(3069,'类乌齐县','d',3065),(3070,'丁青县','d',3065),(3071,'察雅县','d',3065),(3072,'八宿县','d',3065),(3073,'左贡县','d',3065),(3074,'芒康县','d',3065),(3075,'洛隆县','d',3065),(3076,'边坝县','d',3065),(3077,'其他','d',3065),(3078,'林芝地区','c',3042),(3079,'林芝县','d',3078),(3080,'工布江达县','d',3078),(3081,'米林县','d',3078),(3082,'墨脱县','d',3078),(3083,'波密县','d',3078),(3084,'察隅县','d',3078),(3085,'朗县','d',3078),(3086,'其他','d',3078),(3087,'山南地区','c',3042),(3088,'乃东县','d',3087),(3089,'扎囊县','d',3087),(3090,'贡嘎县','d',3087),(3091,'桑日县','d',3087),(3092,'琼结县','d',3087),(3093,'曲松县','d',3087),(3094,'措美县','d',3087),(3095,'洛扎县','d',3087),(3096,'加查县','d',3087),(3097,'隆子县','d',3087),(3098,'错那县','d',3087),(3099,'浪卡子县','d',3087),(3100,'其他','d',3087),(3101,'日喀则地区','c',3042),(3102,'日喀则市','d',3101),(3103,'南木林县','d',3101),(3104,'江孜县','d',3101),(3105,'定日县','d',3101),(3106,'萨迦县','d',3101),(3107,'拉孜县','d',3101),(3108,'昂仁县','d',3101),(3109,'谢通门县','d',3101),(3110,'白朗县','d',3101),(3111,'仁布县','d',3101),(3112,'康马县','d',3101),(3113,'定结县','d',3101),(3114,'仲巴县','d',3101),(3115,'亚东县','d',3101),(3116,'吉隆县','d',3101),(3117,'聂拉木县','d',3101),(3118,'萨嘎县','d',3101),(3119,'岗巴县','d',3101),(3120,'其他','d',3101),(3121,'阿里地区','c',3042),(3122,'噶尔县','d',3121),(3123,'普兰县','d',3121),(3124,'札达县','d',3121),(3125,'日土县','d',3121),(3126,'革吉县','d',3121),(3127,'改则县','d',3121),(3128,'措勤县','d',3121),(3129,'其他','d',3121),(3130,'其他','c',3042),(3131,'其他','d',3130),(3132,'陕西','p',NULL),(3133,'西安','c',3132),(3134,'莲湖区','d',3133),(3135,'新城区','d',3133),(3136,'碑林区','d',3133),(3137,'雁塔区','d',3133),(3138,'灞桥区','d',3133),(3139,'未央区','d',3133),(3140,'阎良区','d',3133),(3141,'临潼区','d',3133),(3142,'长安区','d',3133),(3143,'高陵县','d',3133),(3144,'蓝田县','d',3133),(3145,'户县','d',3133),(3146,'周至县','d',3133),(3147,'其他','d',3133),(3148,'铜川','c',3132),(3149,'耀州区','d',3148),(3150,'王益区','d',3148),(3151,'印台区','d',3148),(3152,'宜君县','d',3148),(3153,'其他','d',3148),(3154,'宝鸡','c',3132),(3155,'渭滨区','d',3154),(3156,'金台区','d',3154),(3157,'陈仓区','d',3154),(3158,'岐山县','d',3154),(3159,'凤翔县','d',3154),(3160,'陇县','d',3154),(3161,'太白县','d',3154),(3162,'麟游县','d',3154),(3163,'扶风县','d',3154),(3164,'千阳县','d',3154),(3165,'眉县','d',3154),(3166,'凤县','d',3154),(3167,'其他','d',3154),(3168,'咸阳','c',3132),(3169,'秦都区','d',3168),(3170,'渭城区','d',3168),(3171,'杨陵区','d',3168),(3172,'兴平市','d',3168),(3173,'礼泉县','d',3168),(3174,'泾阳县','d',3168),(3175,'永寿县','d',3168),(3176,'三原县','d',3168),(3177,'彬县','d',3168),(3178,'旬邑县','d',3168),(3179,'长武县','d',3168),(3180,'乾县','d',3168),(3181,'武功县','d',3168),(3182,'淳化县','d',3168),(3183,'其他','d',3168),(3184,'渭南','c',3132),(3185,'临渭区','d',3184),(3186,'韩城市','d',3184),(3187,'华阴市','d',3184),(3188,'蒲城县','d',3184),(3189,'潼关县','d',3184),(3190,'白水县','d',3184),(3191,'澄城县','d',3184),(3192,'华县','d',3184),(3193,'合阳县','d',3184),(3194,'富平县','d',3184),(3195,'大荔县','d',3184),(3196,'其他','d',3184),(3197,'延安','c',3132),(3198,'宝塔区','d',3197),(3199,'安塞县','d',3197),(3200,'洛川县','d',3197),(3201,'子长县','d',3197),(3202,'黄陵县','d',3197),(3203,'延川县','d',3197),(3204,'富县','d',3197),(3205,'延长县','d',3197),(3206,'甘泉县','d',3197),(3207,'宜川县','d',3197),(3208,'志丹县','d',3197),(3209,'黄龙县','d',3197),(3210,'吴起县','d',3197),(3211,'其他','d',3197),(3212,'汉中','c',3132),(3213,'汉台区','d',3212),(3214,'留坝县','d',3212),(3215,'镇巴县','d',3212),(3216,'城固县','d',3212),(3217,'南郑县','d',3212),(3218,'洋县','d',3212),(3219,'宁强县','d',3212),(3220,'佛坪县','d',3212),(3221,'勉县','d',3212),(3222,'西乡县','d',3212),(3223,'略阳县','d',3212),(3224,'其他','d',3212),(3225,'榆林','c',3132),(3226,'榆阳区','d',3225),(3227,'清涧县','d',3225),(3228,'绥德县','d',3225),(3229,'神木县','d',3225),(3230,'佳县','d',3225),(3231,'府谷县','d',3225),(3232,'子洲县','d',3225),(3233,'靖边县','d',3225),(3234,'横山县','d',3225),(3235,'米脂县','d',3225),(3236,'吴堡县','d',3225),(3237,'定边县','d',3225),(3238,'其他','d',3225),(3239,'安康','c',3132),(3240,'汉滨区','d',3239),(3241,'紫阳县','d',3239),(3242,'岚皋县','d',3239),(3243,'旬阳县','d',3239),(3244,'镇坪县','d',3239),(3245,'平利县','d',3239),(3246,'石泉县','d',3239),(3247,'宁陕县','d',3239),(3248,'白河县','d',3239),(3249,'汉阴县','d',3239),(3250,'其他','d',3239),(3251,'商洛','c',3132),(3252,'商州区','d',3251),(3253,'镇安县','d',3251),(3254,'山阳县','d',3251),(3255,'洛南县','d',3251),(3256,'商南县','d',3251),(3257,'丹凤县','d',3251),(3258,'柞水县','d',3251),(3259,'其他','d',3251),(3260,'其他','c',3132),(3261,'其他','d',3260),(3262,'甘肃','p',NULL),(3263,'兰州','c',3262),(3264,'城关区','d',3263),(3265,'七里河区','d',3263),(3266,'西固区','d',3263),(3267,'安宁区','d',3263),(3268,'红古区','d',3263),(3269,'永登县','d',3263),(3270,'皋兰县','d',3263),(3271,'榆中县','d',3263),(3272,'其他','d',3263),(3273,'嘉峪关','c',3262),(3274,'嘉峪关市','d',3273),(3275,'其他','d',3273),(3276,'金昌','c',3262),(3277,'金川区','d',3276),(3278,'永昌县','d',3276),(3279,'其他','d',3276),(3280,'白银','c',3262),(3281,'白银区','d',3280),(3282,'平川区','d',3280),(3283,'靖远县','d',3280),(3284,'会宁县','d',3280),(3285,'景泰县','d',3280),(3286,'其他','d',3280),(3287,'天水','c',3262),(3288,'清水县','d',3287),(3289,'秦安县','d',3287),(3290,'甘谷县','d',3287),(3291,'武山县','d',3287),(3292,'张家川回族自治县','d',3287),(3293,'北道区','d',3287),(3294,'秦城区','d',3287),(3295,'其他','d',3287),(3296,'武威','c',3262),(3297,'凉州区','d',3296),(3298,'民勤县','d',3296),(3299,'古浪县','d',3296),(3300,'天祝藏族自治县','d',3296),(3301,'其他','d',3296),(3302,'酒泉','c',3262),(3303,'肃州区','d',3302),(3304,'玉门市','d',3302),(3305,'敦煌市','d',3302),(3306,'金塔县','d',3302),(3307,'肃北蒙古族自治县','d',3302),(3308,'阿克塞哈萨克族自治县','d',3302),(3309,'安西县','d',3302),(3310,'其他','d',3302),(3311,'张掖','c',3262),(3312,'甘州区','d',3311),(3313,'民乐县','d',3311),(3314,'临泽县','d',3311),(3315,'高台县','d',3311),(3316,'山丹县','d',3311),(3317,'肃南裕固族自治县','d',3311),(3318,'其他','d',3311),(3319,'庆阳','c',3262),(3320,'西峰区','d',3319),(3321,'庆城县','d',3319),(3322,'环县','d',3319),(3323,'华池县','d',3319),(3324,'合水县','d',3319),(3325,'正宁县','d',3319),(3326,'宁县','d',3319),(3327,'镇原县','d',3319),(3328,'其他','d',3319),(3329,'平凉','c',3262),(3330,'崆峒区','d',3329),(3331,'泾川县','d',3329),(3332,'灵台县','d',3329),(3333,'崇信县','d',3329),(3334,'华亭县','d',3329),(3335,'庄浪县','d',3329),(3336,'静宁县','d',3329),(3337,'其他','d',3329),(3338,'定西','c',3262),(3339,'安定区','d',3338),(3340,'通渭县','d',3338),(3341,'临洮县','d',3338),(3342,'漳县','d',3338),(3343,'岷县','d',3338),(3344,'渭源县','d',3338),(3345,'陇西县','d',3338),(3346,'其他','d',3338),(3347,'陇南','c',3262),(3348,'武都区','d',3347),(3349,'成县','d',3347),(3350,'宕昌县','d',3347),(3351,'康县','d',3347),(3352,'文县','d',3347),(3353,'西和县','d',3347),(3354,'礼县','d',3347),(3355,'两当县','d',3347),(3356,'徽县','d',3347),(3357,'其他','d',3347),(3358,'临夏回族自治州','c',3262),(3359,'临夏市','d',3358),(3360,'临夏县','d',3358),(3361,'康乐县','d',3358),(3362,'永靖县','d',3358),(3363,'广河县','d',3358),(3364,'和政县','d',3358),(3365,'东乡族自治县','d',3358),(3366,'积石山保安族东乡族撒拉族自治县','d',3358),(3367,'其他','d',3358),(3368,'甘南藏族自治州','c',3262),(3369,'合作市','d',3368),(3370,'临潭县','d',3368),(3371,'卓尼县','d',3368),(3372,'舟曲县','d',3368),(3373,'迭部县','d',3368),(3374,'玛曲县','d',3368),(3375,'碌曲县','d',3368),(3376,'夏河县','d',3368),(3377,'其他','d',3368),(3378,'其他','c',3262),(3379,'其他','d',3378),(3380,'青海','p',NULL),(3381,'西宁','c',3380),(3382,'城中区','d',3381),(3383,'城东区','d',3381),(3384,'城西区','d',3381),(3385,'城北区','d',3381),(3386,'湟源县','d',3381),(3387,'湟中县','d',3381),(3388,'大通回族土族自治县','d',3381),(3389,'其他','d',3381),(3390,'海东地区','c',3380),(3391,'平安县','d',3390),(3392,'乐都县','d',3390),(3393,'民和回族土族自治县','d',3390),(3394,'互助土族自治县','d',3390),(3395,'化隆回族自治县','d',3390),(3396,'循化撒拉族自治县','d',3390),(3397,'其他','d',3390),(3398,'海北藏族自治州','c',3380),(3399,'海晏县','d',3398),(3400,'祁连县','d',3398),(3401,'刚察县','d',3398),(3402,'门源回族自治县','d',3398),(3403,'其他','d',3398),(3404,'海南藏族自治州','c',3380),(3405,'共和县','d',3404),(3406,'同德县','d',3404),(3407,'贵德县','d',3404),(3408,'兴海县','d',3404),(3409,'贵南县','d',3404),(3410,'其他','d',3404),(3411,'黄南藏族自治州','c',3380),(3412,'同仁县','d',3411),(3413,'尖扎县','d',3411),(3414,'泽库县','d',3411),(3415,'河南蒙古族自治县','d',3411),(3416,'其他','d',3411),(3417,'果洛藏族自治州','c',3380),(3418,'玛沁县','d',3417),(3419,'班玛县','d',3417),(3420,'甘德县','d',3417),(3421,'达日县','d',3417),(3422,'久治县','d',3417),(3423,'玛多县','d',3417),(3424,'其他','d',3417),(3425,'玉树藏族自治州','c',3380),(3426,'玉树县','d',3425),(3427,'杂多县','d',3425),(3428,'称多县','d',3425),(3429,'治多县','d',3425),(3430,'囊谦县','d',3425),(3431,'曲麻莱县','d',3425),(3432,'其他','d',3425),(3433,'海西蒙古族藏族自治州','c',3380),(3434,'德令哈市','d',3433),(3435,'格尔木市','d',3433),(3436,'乌兰县','d',3433),(3437,'都兰县','d',3433),(3438,'天峻县','d',3433),(3439,'其他','d',3433),(3440,'其他','c',3380),(3441,'其他','d',3440),(3442,'宁夏','p',NULL),(3443,'银川','c',3442),(3444,'兴庆区','d',3443),(3445,'西夏区','d',3443),(3446,'金凤区','d',3443),(3447,'灵武市','d',3443),(3448,'永宁县','d',3443),(3449,'贺兰县','d',3443),(3450,'其他','d',3443),(3451,'石嘴山','c',3442),(3452,'大武口区','d',3451),(3453,'惠农区','d',3451),(3454,'平罗县','d',3451),(3455,'其他','d',3451),(3456,'吴忠','c',3442),(3457,'利通区','d',3456),(3458,'青铜峡市','d',3456),(3459,'盐池县','d',3456),(3460,'同心县','d',3456),(3461,'其他','d',3456),(3462,'固原','c',3442),(3463,'原州区','d',3462),(3464,'西吉县','d',3462),(3465,'隆德县','d',3462),(3466,'泾源县','d',3462),(3467,'彭阳县','d',3462),(3468,'其他','d',3462),(3469,'中卫','c',3442),(3470,'沙坡头区','d',3469),(3471,'中宁县','d',3469),(3472,'海原县','d',3469),(3473,'其他','d',3469),(3474,'其他','c',3442),(3475,'其他','d',3474),(3476,'新疆','p',NULL),(3477,'乌鲁木齐','c',3476),(3478,'天山区','d',3477),(3479,'沙依巴克区','d',3477),(3480,'新市区','d',3477),(3481,'水磨沟区','d',3477),(3482,'头屯河区','d',3477),(3483,'达坂城区','d',3477),(3484,'东山区','d',3477),(3485,'乌鲁木齐县','d',3477),(3486,'其他','d',3477),(3487,'克拉玛依','c',3476),(3488,'克拉玛依区','d',3487),(3489,'独山子区','d',3487),(3490,'白碱滩区','d',3487),(3491,'乌尔禾区','d',3487),(3492,'其他','d',3487),(3493,'吐鲁番地区','c',3476),(3494,'吐鲁番市','d',3493),(3495,'托克逊县','d',3493),(3496,'鄯善县','d',3493),(3497,'其他','d',3493),(3498,'哈密地区','c',3476),(3499,'哈密市','d',3498),(3500,'伊吾县','d',3498),(3501,'巴里坤哈萨克自治县','d',3498),(3502,'其他','d',3498),(3503,'和田地区','c',3476),(3504,'和田市','d',3503),(3505,'和田县','d',3503),(3506,'洛浦县','d',3503),(3507,'民丰县','d',3503),(3508,'皮山县','d',3503),(3509,'策勒县','d',3503),(3510,'于田县','d',3503),(3511,'墨玉县','d',3503),(3512,'其他','d',3503),(3513,'阿克苏地区','c',3476),(3514,'阿克苏市','d',3513),(3515,'温宿县','d',3513),(3516,'沙雅县','d',3513),(3517,'拜城县','d',3513),(3518,'阿瓦提县','d',3513),(3519,'库车县','d',3513),(3520,'柯坪县','d',3513),(3521,'新和县','d',3513),(3522,'乌什县','d',3513),(3523,'其他','d',3513),(3524,'喀什地区','c',3476),(3525,'喀什市','d',3524),(3526,'巴楚县','d',3524),(3527,'泽普县','d',3524),(3528,'伽师县','d',3524),(3529,'叶城县','d',3524),(3530,'岳普湖县','d',3524),(3531,'疏勒县','d',3524),(3532,'麦盖提县','d',3524),(3533,'英吉沙县','d',3524),(3534,'莎车县','d',3524),(3535,'疏附县','d',3524),(3536,'塔什库尔干塔吉克自治县','d',3524),(3537,'其他','d',3524),(3538,'克孜勒苏柯尔克孜自治州','c',3476),(3539,'阿图什市','d',3538),(3540,'阿合奇县','d',3538),(3541,'乌恰县','d',3538),(3542,'阿克陶县','d',3538),(3543,'其他','d',3538),(3544,'巴音郭楞蒙古自治州','c',3476),(3545,'库尔勒市','d',3544),(3546,'和静县','d',3544),(3547,'尉犁县','d',3544),(3548,'和硕县','d',3544),(3549,'且末县','d',3544),(3550,'博湖县','d',3544),(3551,'轮台县','d',3544),(3552,'若羌县','d',3544),(3553,'焉耆回族自治县','d',3544),(3554,'其他','d',3544),(3555,'昌吉回族自治州','c',3476),(3556,'昌吉市','d',3555),(3557,'阜康市','d',3555),(3558,'奇台县','d',3555),(3559,'玛纳斯县','d',3555),(3560,'吉木萨尔县','d',3555),(3561,'呼图壁县','d',3555),(3562,'木垒哈萨克自治县','d',3555),(3563,'米泉市','d',3555),(3564,'其他','d',3555),(3565,'博尔塔拉蒙古自治州','c',3476),(3566,'博乐市','d',3565),(3567,'精河县','d',3565),(3568,'温泉县','d',3565),(3569,'其他','d',3565),(3570,'石河子','c',3476),(3571,'石河子','d',3570),(3572,'阿拉尔','c',3476),(3573,'阿拉尔','d',3572),(3574,'图木舒克','c',3476),(3575,'图木舒克','d',3574),(3576,'五家渠','c',3476),(3577,'五家渠','d',3576),(3578,'伊犁哈萨克自治州','c',3476),(3579,'伊宁市','d',3578),(3580,'奎屯市','d',3578),(3581,'伊宁县','d',3578),(3582,'特克斯县','d',3578),(3583,'尼勒克县','d',3578),(3584,'昭苏县','d',3578),(3585,'新源县','d',3578),(3586,'霍城县','d',3578),(3587,'巩留县','d',3578),(3588,'察布查尔锡伯自治县','d',3578),(3589,'塔城地区','d',3578),(3590,'阿勒泰地区','d',3578),(3591,'其他','d',3578),(3592,'其他','c',3476),(3593,'其他','d',3592),(3594,'台湾','p',NULL),(3595,'台湾','c',3594),(3596,'台北市','d',3595),(3597,'高雄市','d',3595),(3598,'台北县','d',3595),(3599,'桃园县','d',3595),(3600,'新竹县','d',3595),(3601,'苗栗县','d',3595),(3602,'台中县','d',3595),(3603,'彰化县','d',3595),(3604,'南投县','d',3595),(3605,'云林县','d',3595),(3606,'嘉义县','d',3595),(3607,'台南县','d',3595),(3608,'高雄县','d',3595),(3609,'屏东县','d',3595),(3610,'宜兰县','d',3595),(3611,'花莲县','d',3595),(3612,'台东县','d',3595),(3613,'澎湖县','d',3595),(3614,'基隆市','d',3595),(3615,'新竹市','d',3595),(3616,'台中市','d',3595),(3617,'嘉义市','d',3595),(3618,'台南市','d',3595),(3619,'其他','d',3595),(3620,'其他','c',3594),(3621,'其他','d',3620),(3622,'澳门','p',NULL),(3623,'澳门','c',3622),(3624,'花地玛堂区','d',3623),(3625,'圣安多尼堂区','d',3623),(3626,'大堂区','d',3623),(3627,'望德堂区','d',3623),(3628,'风顺堂区','d',3623),(3629,'嘉模堂区','d',3623),(3630,'圣方济各堂区','d',3623),(3631,'路凼','d',3623),(3632,'其他','d',3623),(3633,'香港','p',NULL),(3634,'香港','c',3633),(3635,'中西区','d',3634),(3636,'湾仔区','d',3634),(3637,'东区','d',3634),(3638,'南区','d',3634),(3639,'深水埗区','d',3634),(3640,'油尖旺区','d',3634),(3641,'九龙城区','d',3634),(3642,'黄大仙区','d',3634),(3643,'观塘区','d',3634),(3644,'北区','d',3634),(3645,'大埔区','d',3634),(3646,'沙田区','d',3634),(3647,'西贡区','d',3634),(3648,'元朗区','d',3634),(3649,'屯门区','d',3634),(3650,'荃湾区','d',3634),(3651,'葵青区','d',3634),(3652,'离岛区','d',3634),(3653,'其他','d',3634);




INSERT INTO `t_config_global` (`id`, `lang`, `selected`) VALUES ('1', 'zh', '1');
INSERT INTO `t_config_global` (`id`, `lang`, `selected`) VALUES ('2', 'en', '0');




/*
INSERT INTO `t_term_config` (`id`, `type`, `title`, `content`, `created_time`, `previous_modified_time`, `last_modified_time`) VALUES ('1195215989266153474', 'ABOUT_US', '关于我们', '我们是一个富有活力软件开发团队', '2019-11-15 13:42:18', '2019-11-15 13:44:33', '2019-11-15 13:47:04');
INSERT INTO `t_term_config` (`id`, `type`, `title`, `content`, `created_time`, `previous_modified_time`, `last_modified_time`) VALUES ('1196642269345865729', 'NOTICE', '公告', '您好，欢迎来到这里。', '2019-11-19 12:12:04', '2019-11-19 12:12:04', '2019-11-19 12:12:04');
INSERT INTO `t_term_config` (`id`, `type`, `title`, `content`, `created_time`, `previous_modified_time`, `last_modified_time`) VALUES ('1196642322106015746', 'CONNECT_US', '联系我们', '欢迎联系我们', '2019-11-19 12:12:17', '2019-11-19 12:12:17', '2019-11-19 12:12:17');
*/


INSERT INTO `t_term_config` (`id`, `type`, `title`, `content`, `created_time`, `previous_modified_time`, `last_modified_time`) VALUES ('1195215989266153474', 'MEMBER_RULE', '会员规则', '<blockquote>会员规则---</blockquote>', '2019-11-15 13:42:18', '2019-11-19 16:17:00', '2019-11-19 16:29:06');
INSERT INTO `t_term_config` (`id`, `type`, `title`, `content`, `created_time`, `previous_modified_time`, `last_modified_time`) VALUES ('1196642269345865729', 'INTEGRAL_RULE', '积分规则', '积分规则---', '2019-11-19 12:12:04', '2019-11-19 12:12:04', '2019-11-19 12:12:04');
INSERT INTO `t_term_config` (`id`, `type`, `title`, `content`, `created_time`, `previous_modified_time`, `last_modified_time`) VALUES ('1196642322106015746', 'BRAND_STORY', '品牌故事', '<p><span style=\"color:#07a9fe\">欢迎联系我们</span></p>', '2019-11-19 12:12:17', '2019-11-19 12:12:17', '2019-11-19 16:32:53');
INSERT INTO `t_term_config` (`id`, `type`, `title`, `content`, `created_time`, `previous_modified_time`, `last_modified_time`) VALUES ('1196642322106015777', 'PRIVACY_POLICY', '隐私策略', '<p>隐私策略1</p><p>2</p><p>3</p>', '2019-11-19 12:12:17', '2019-11-19 16:20:21', '2019-11-19 16:22:26');


/*
INSERT INTO `perm_group` (`id`, `name`, `identifier`) VALUES
('939349783914717189', 'TermConfig模块', 'TermConfig.management');

INSERT INTO `perm` (`id`, `groupid`, `name`, `identifier`) VALUES
('939349783914717186', '939349783914717189', '查看TermConfig', 'TermConfig.view'),
('939349783914717187', '939349783914717189', '更新TermConfig', 'TermConfig.update'),
('939349783914717188', '939349783914717189', '删除TermConfig', 'TermConfig.delete');*/





alter table t_ad_group add  `identifier` varchar(50) DEFAULT NULL COMMENT '广告组标识';
ALTER table t_product_description MODIFY    description text;
ALTER TABLE t_user add last_modified_time datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间';
ALTER TABLE t_user add org_id bigint(20) NULL DEFAULT NULL COMMENT '组织(部门)ID';
alter table  t_product_category add  org_id bigint(20) default null comment 'org_id';
alter table  t_product_image add  `name` varchar(100) DEFAULT NULL COMMENT '图片名';
alter table  t_product add  org_id bigint(20) default null comment 'org_id';
alter table  t_product_tag add  org_id bigint(20) default null comment 'org_id';
alter table  t_fare_template add  org_id bigint(20) default null comment 'org_id';
alter table  t_order add  org_id bigint(20) default null comment 'org_id';
alter table  t_order add  `settlement_status` int(1) DEFAULT '0' COMMENT '结算状态';
alter table t_product_brand add  org_id bigint(20) default null comment 'org_id';
alter table  t_express add  org_id bigint(20) default null comment 'org_id';
alter table  t_ad add  `seq` smallint(6) DEFAULT 0 COMMENT '排序号';


alter table  t_config add  org_id bigint(20) default null comment 'org_id';
insert into t_config_group value("1001"," 商城配置 ",0);
update t_config set group_id="1001" where key_name = "mall.latest_return_time";
update t_config set group_id="1001" where key_name = "mall.drawing_conditions";
update t_config set group_id="1001" where key_name = "mall.auto_validation_receiving_deadline";
update t_config set group_id="1001" where key_name = "mall.pay_order_timeout";
update t_config set group_id="1001" where key_name = "mall.auto_offsell";
update t_config set group_id="1001" where key_name = "mall.order_created_enable";
update t_config set group_id="1001" where key_name = "mall.auto_deliver_order";
insert into t_config_group value("1002"," 微信配置 ",0);
update t_config set group_id="1002" where key_name = "wx.token";
update t_config set group_id="1002" where key_name = "wx.encrypt_message";
update t_config set group_id="1002" where key_name = "wx.encoding_aes_key";
update t_config set group_id="1002" where key_name = "wx.app_id";
update t_config set group_id="1002" where key_name = "wx.app_secret";
update t_config set group_id="1002" where key_name = "wx.host";
update t_config set group_id="1002" where key_name = "wx.partner_id";
update t_config set group_id="1002" where key_name = "wx.partner_key";
update t_config set group_id="1002" where key_name = "wx.cert_path";
update t_config set group_id="1002" where key_name = "wx.wxa_appid";
update t_config set group_id="1002" where key_name = "wx.auto_reg";
update t_config set group_id="1002" where key_name = "wx.app_appid";
update t_config set group_id="1002" where key_name = "wx.app_app_secret";
update t_config set group_id="1002" where key_name = "appName";
update t_config set group_id="1002" where key_name = "appPartnerId";
update t_config set group_id="1002" where key_name = "appPartnerKey";
 insert into t_config_group value("1003"," 微信物流助手配置 ",0);
update t_config set group_id="1003" where group_id = "40";





-- 菜单项
INSERT INTO `ow_menu` VALUES ('1', null, '首页', '1', '1', '1', '0', null, '1', 'portal', null, 'index.html', 'portal');
INSERT INTO `ow_menu` VALUES ('2', null, '关于i-softto', '2', '1', '1', '1', null, '0', 'about', null, 'about.html', 'about');
INSERT INTO `ow_menu` VALUES ('3', null, '体验中心', '3', '1', '1', '3', null, '0', 'trial', null, 'test.html', 'trial');
INSERT INTO `ow_menu` VALUES ('4', null, '产品中心', '4', '1', '1', '2', null, '1', 'product', null, 'product.html', 'product');
INSERT INTO `ow_menu` VALUES ('5', null, '成分党', '5', '1', '1', '4', null, '0', 'element', null, 'ingredient.html', 'element');
INSERT INTO `ow_menu` VALUES ('6', null, '会员中心', '6', '1', '1', '5', null, '0', 'account', null, 'vipCenter.html', 'account');
INSERT INTO `ow_menu` VALUES ('7', null, '美丽课堂', '7', '1', '1', '6', null, '0', 'course', null, 'beautyClass.html', 'course');
INSERT INTO `ow_menu` VALUES ('8', '2', '品牌介绍', '8', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('9', '2', '品牌故事', '9', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('10', '2', '品牌特色', '10', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('19', '5', '成分党:乳木果', '12', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('27', '6', '加入会员', '15', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('28', '6', '会员臻享', '19', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('29', '6', '在线测试', '18', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('30', '6', '检测报告', '20', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('36', '5', '成分党: 六胜肽', '13', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('37', '5', '成分党: 337', '14', '0', '1', '0', null, '1', null, null, null, null);





-- 页面
INSERT INTO `ow_page` VALUES ('1', '首页', 'html', null, '1', 'portal');
INSERT INTO `ow_page` VALUES ('2', '关于i-softto', 'html', null, '1', 'about');
INSERT INTO `ow_page` VALUES ('3', '体验中心', 'html', null, '1', 'trial');
INSERT INTO `ow_page` VALUES ('4', '产品中心', 'html', null, '1', 'product');
INSERT INTO `ow_page` VALUES ('5', '成分党', 'html', null, '1', 'element');
INSERT INTO `ow_page` VALUES ('6', '会员中心', 'html', null, '1', 'account');
INSERT INTO `ow_page` VALUES ('7', '美丽课堂', 'html', null, '1', 'course');
INSERT INTO `ow_page` VALUES ('8', '品牌介绍', 'rtf', null, '1', 'course_introduce');
INSERT INTO `ow_page` VALUES ('9', '品牌故事', 'rtf', null, '1', 'course_story');
INSERT INTO `ow_page` VALUES ('10', '品牌特色', 'rtf', null, '1', 'course_feature');
INSERT INTO `ow_page` VALUES ('11', '页脚', 'footer', null, '1', 'footer');
INSERT INTO `ow_page` VALUES ('12', '成分党: 乳木果', 'rtf', null, '1', '');
INSERT INTO `ow_page` VALUES ('13', '成分党: 六胜肽', 'rtf', null, '0', '');
INSERT INTO `ow_page` VALUES ('14', '成分党: 337', 'rtf', null, '0', '');
INSERT INTO `ow_page` VALUES ('15', '加入会员', 'rtf', null, '0', null);
INSERT INTO `ow_page` VALUES ('18', '在线测试', 'rtf', null, '0', null);
INSERT INTO `ow_page` VALUES ('19', '会员臻享', 'rtf', null, '0', null);
INSERT INTO `ow_page` VALUES ('20', '检测报告', 'rtf', null, '0', null);
INSERT INTO `ow_page` VALUES ('21', '我的美肤方案', 'rtf', null, '0', null);

INSERT INTO `ow_page_text` VALUES ('1', '2', '<div class=\"media-wrap video-wrap\"><video controls=\"\" src=\"https://www.muaskin.com/images/null/31d23d77-0522-4344-b5b1-26d369062460.mp4\"></video></div>');
INSERT INTO `ow_page_text` VALUES ('2', '6', '<div class=\"media-wrap image-wrap\"><img src=\"https://www.muaskin.com/images/null/81187115-8f8f-4202-b2fa-23a931221fdb.jpg\"/></div><p></p>');
INSERT INTO `ow_page_text` VALUES ('5', '12', '<div class=\"media-wrap image-wrap align-center\" style=\"text-align:center\"><img src=\"https://www.muaskin.com/images/null/b0b3eec6-f482-4885-a3e8-c9416ae39af1.jpg\"/></div><p></p>');
INSERT INTO `ow_page_text` VALUES ('8', '13', '<div class=\"media-wrap image-wrap align-center\" style=\"text-align:center\"><img src=\"https://www.muaskin.com/images/null/6504f9d5-7c12-4b72-9601-571cfb976239.jpg\"/></div><p></p>');
INSERT INTO `ow_page_text` VALUES ('9', '10', '<div class=\"media-wrap image-wrap\"><img src=\"https://www.muaskin.com/images/null/c80c1f88-eb24-4c27-b5f7-b047a4499010.png\"/></div><p></p>');
INSERT INTO `ow_page_text` VALUES ('10', '9', '<p style=\"text-align:left;text-indent:2em;\">2004年12月1日，中国最具成长性的上市企业之一一一广西红日股份有限公司，正式更名为索芙特股份有限公司。这标志着索芙特这一驰名的中国化妆品品牌，正以一种全新的姿态展现在世人面前。并以其稳重高速的发展态势，展示着一个时尚化妆品领先者的强大魅力。</p><p style=\"text-align:left;text-indent:2em;\">26年间，索芙特凭借差异化的营销理念在中国日化行业创造了无数的销售奇迹，从畅销中外的海藻减肥香皂到红遍天下的木瓜白肤洗面奶，从畅销十多年的防脱育发香波到众多明星代言的祛斑、瘦身系列。索芙特通过自身的努力在中国日化行业中走出了一条属于自己的路。也奠定了索芙特&quot;中国功能性化妆品第一品牌&quot;的地位。与此同时，索芙特其良好的产品品质得到了广大消费者的认同， &quot;中国驰名商标&quot;、 &quot;中国名牌&quot;、&quot;中国保护消费者权益315信用品牌&quot;等一系列的荣誉纷纷踏至而来。</p>');
INSERT INTO `ow_page_text` VALUES ('11', '14', '<div class=\"media-wrap image-wrap align-center\" style=\"text-align:center\"><img src=\"https://www.muaskin.com/images/null/f3f58533-0ba7-4600-ada4-04800059a046.jpg\"/></div><p></p>');
INSERT INTO `ow_page_text` VALUES ('12', '15', null);
INSERT INTO `ow_page_text` VALUES ('15', '18', '<div class=\"media-wrap image-wrap align-center\" style=\"text-align:center\"><img src=\"https://www.muaskin.com/images/null/4f759eb4-cbfe-47d6-838c-417f27b09827.png\"/></div><div class=\"media-wrap image-wrap\"><img src=\"https://www.muaskin.com/images/null/0e2fd8d6-6a4e-4eab-9d87-50d8cd1d02fd.png\"/></div><p> </p>');
INSERT INTO `ow_page_text` VALUES ('16', '19', null);
INSERT INTO `ow_page_text` VALUES ('17', '20', null);
INSERT INTO `ow_page_text` VALUES ('18', '21', null);
INSERT INTO `ow_page_text` VALUES ('19', '8', '<p>品牌介绍</p>');
INSERT INTO `ow_page_text` VALUES ('20', '1', '<p></p>');
INSERT INTO `ow_page_text` VALUES ('21', '3', '<p>体验中心</p>');
INSERT INTO `ow_page_text` VALUES ('22', '4', '<p></p>');
INSERT INTO `ow_page_text` VALUES ('23', '11', '<p><span style=\"font-size:48px\">-------------------页脚内容展示--------------</span></p>');




INSERT INTO `t_sys_user` (id, org_id,avatar,account,password,salt,name,birthday,sex,email,phone,status,createtime,version) VALUES
('876708082437197827', '100000000000000001', '', 'admin', 'b5106d36993ba6afd2b5b99e3e46e1af', 'p683b', '管理员', '1997-05-05 00:00:00', '2', 'admin@kequandian.net', '18200000000', '1', '2017-01-29 08:49:53', '1');


INSERT INTO `t_sys_org` (`id`, `pid`, `org_type`,`org_code`,`name`, `full_name`, `node_level`, `left_num`, `right_num`, `note`, `status`, `create_time`, `update_time`)
VALUES ('100000000000000001', null, 0,'A1','可圈点科技有限公司', '广州可圈点信息科技有限公司', '1', '1', '2', '总公司','NORMAL','2018-09-23 00:37:59', '2018-09-23 00:37:59');

-- ----------------------------
-- Records of perm_group
-- ----------------------------
INSERT INTO `sys_perm_group` (`id`, `pid`,`org_id`,`name`, `identifier`) VALUES
('100000000000000001',null,100000000000000001, '权限管理', 'root'),
('876708082437197910',100000000000000001, 100000000000000001,'用户管理', 'sysUser.management'),
('876708082437197911',100000000000000001, 100000000000000001,'角色管理', 'sysRole.management'),
('112573379300782085', 100000000000000001,100000000000000001,'组织管理', 'Org.management'),
('112573379300782088', 100000000000000001,100000000000000001,'自定义表单管理', 'EAV.management');


-- ----------------------------
-- Records of perm
-- ----------------------------
INSERT INTO `sys_perm` (`id`, `group_id`, `name`, `identifier`) VALUES
('876708082437197920', '876708082437197910', '查看用户', 'sysUser.view'),
('876708082437197921', '876708082437197910', '编辑用户', 'sysUser.edit'),
('876708082437197922', '876708082437197910', '删除用户', 'sysUser.del'),

('876708082437197923', '876708082437197911', '查看角色', 'sysRole.view'),
('876708082437197924', '876708082437197911', '更新角色', 'sysRole.edit'),
('876708082437197925', '876708082437197911', '删除角色', 'sysRole.del'),

('1012573379300782082', '112573379300782085', '查看组织', 'Org.view'),
('1012573379300782083', '112573379300782085', '编辑组织', 'Org.edit'),
('1012573379300782084', '112573379300782085', '删除组织', 'Org.del'),


('1012573379300782088', '112573379300782088', '新建自定义表单', 'eav.view'),
('1012573379300782089', '112573379300782088', '删除自定义表单', 'eav.del'),
('1012573379300782090', '112573379300782088', '编辑自定义表单', 'eav.edit');


-- ----------------------------
-- Records of sysRole
-- ----------------------------
INSERT INTO `sys_role` (id, org_id, sort_order, pid, name, tips, version,delete_flag) VALUES
('876708082437197826', '100000000000000001', '1', '0', '超级管理员', 'administrator', '1','1');

-- ----------------------------
-- Records of role_perm
-- ----------------------------
INSERT INTO `sys_role_perm` (`id`, `role_id`, `perm_id`) VALUES
('876708082437197820', '876708082437197826', '876708082437197920'),
('876708082437197821', '876708082437197826', '876708082437197921'),
('876708082437197822', '876708082437197826', '876708082437197922'),
('876708082437197823', '876708082437197826', '876708082437197923');

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`) VALUES
('876708082437197830', '876708082437197827', '876708082437197826');


INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('2', 'product', 'product');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('3', 'element', 'element');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('4', 'banner', 'banner');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('5', 'portal', 'portal');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('6', 'about', 'about');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('7', 'trial', 'trial');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('8', 'account', 'account');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('9', 'course', 'course');

INSERT INTO `t_ad` (`id`, `group_id`, `name`, `image`, `type`, `enabled`, `target_url`, `strategy`, `seq`) VALUES ('3', '5', '三步直达美肤', '/portal/images/100000000000000001/0e2ff29d-ecf7-4dd8-b25b-18f23b51995e.jpg', NULL, '1', NULL, NULL, '0');
INSERT INTO `t_ad` (`id`, `group_id`, `name`, `image`, `type`, `enabled`, `target_url`, `strategy`, `seq`) VALUES ('4', '5', '首页轮播-为新生代成分党而生', '/portal/images/100000000000000001/0fe9d859-190a-488c-8aaa-a2fa363da4b9.gif', NULL, '1', NULL, NULL, '0');
INSERT INTO `t_ad` (`id`, `group_id`, `name`, `image`, `type`, `enabled`, `target_url`, `strategy`, `seq`) VALUES ('5', '5', '首页轮播-肌肤管理定制时代', '/portal/images/100000000000000001/738c8dc2-e9b4-41a6-b639-542da8c52967.jpg', NULL, '1', NULL, NULL, '0');
INSERT INTO `t_ad` (`id`, `group_id`, `name`, `image`, `type`, `enabled`, `target_url`, `strategy`, `seq`) VALUES ('6', '2', '产品轮播-产品', '/portal/images/100000000000000001/7d0ce01a-30d8-410c-8f6c-82913ba4e588.png', NULL, '1', NULL, NULL, '0');
INSERT INTO `t_ad` (`id`, `group_id`, `name`, `image`, `type`, `enabled`, `target_url`, `strategy`, `seq`) VALUES ('7', '3', '成分党', '/portal/images/100000000000000001/97c606be-4f94-42ce-a1f0-c0546df78e2c.jpg', NULL, '1', NULL, NULL, '0');




-- ----------------------------
-- Table structure for t_ad_library
-- ----------------------------
DROP TABLE IF EXISTS `t_ad_library`;
CREATE TABLE `t_ad_library` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `url` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ad_library
-- ----------------------------
INSERT INTO `t_ad_library` VALUES ('2', 'https://api.cloud.biliya.cn/images/alliance/ad/6a380e37cdcfbc7cebb2eca341d2084a.jpg');
INSERT INTO `t_ad_library` VALUES ('4', 'https://api.cloud.biliya.cn/images/alliance/ad/86f39a7d8725ede85b6cf852fdff7a93.jpg');
INSERT INTO `t_ad_library` VALUES ('1', 'https://api.cloud.biliya.cn/images/alliance/ad/db6da63c268e5097252a37f974a595d7.jpg');
INSERT INTO `t_ad_library` VALUES ('3', 'https://api.cloud.biliya.cn/images/alliance/ad/f2c016c23aaefcf12d9bd284b3b1b9ea.jpg');

DROP TABLE IF EXISTS `meta_entity_patch_machine`;

CREATE TABLE `meta_entity_patch_machine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `entity` varchar(64) NOT NULL COMMENT '实体',
  `entity_table_name` varchar(64) NOT NULL COMMENT '实体对应表名',
  `entity_field_name` varchar(64) NOT NULL COMMENT '实体字段名',
  `entity_field_type` varchar(16) NOT NULL DEFAULT 'STRING' COMMENT '实体字段类型',
  `number_range_min` bigint(20) DEFAULT NULL COMMENT '数字类型字段的范围下限',
  `number_range_max` bigint(20) DEFAULT NULL COMMENT '数字类型字段的范围上限',
  `permission` varchar(64) DEFAULT NULL COMMENT '操作权限控制',
  PRIMARY KEY (`id`),
  UNIQUE KEY `entity` (`entity`,`entity_field_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `meta_entity_patch_machine` (`id`, `entity`, `entity_table_name`, `entity_field_name`, `entity_field_type`, `number_range_min`, `number_range_max`, `permission`) VALUES ('2', 'notice', 't_notice', 'sort_num', 'NUMBER', '1', '10000', NULL);


SET FOREIGN_KEY_CHECKS=1;

