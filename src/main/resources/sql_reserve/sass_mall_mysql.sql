
SET FOREIGN_KEY_CHECKS=0;



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








SET FOREIGN_KEY_CHECKS=1;


SET FOREIGN_KEY_CHECKS=0;

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
