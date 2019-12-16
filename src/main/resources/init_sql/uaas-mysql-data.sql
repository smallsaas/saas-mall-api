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


SET FOREIGN_KEY_CHECKS=1;