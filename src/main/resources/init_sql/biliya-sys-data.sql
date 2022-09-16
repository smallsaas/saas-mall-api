SET FOREIGN_KEY_CHECKS=0;

-- 系统用户相关
-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `description` varchar(255) DEFAULT NULL,
                          `name` varchar(150) DEFAULT NULL,
                          `system` int(11) NOT NULL DEFAULT '0',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', 'admin', '1');
INSERT INTO `t_role` VALUES ('2', '代理商', 'agent', '1');
INSERT INTO `t_role` VALUES ('3', '分销商', 'seller', '1');
INSERT INTO `t_role` VALUES ('4', '消费者', 'customer', '1');



-- ----------------------------
-- Table structure for st_statistics_record
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_record`;
CREATE TABLE `st_statistics_record` (
                                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                        `field` varchar(80) NOT NULL COMMENT '数据域标识符',
                                        `identifier` varchar(80) DEFAULT NULL COMMENT '统计归属标识',
                                        `seq` int(11) NOT NULL DEFAULT '0' COMMENT '记录排序号',
                                        `record_name` varchar(50) NOT NULL COMMENT '记录名称',
                                        `record_value` varchar(50) NOT NULL COMMENT '记录值',
                                        `record_tuple` varchar(30) DEFAULT NULL COMMENT '记录值所属行名称',
                                        `record_cluster` varchar(30) DEFAULT NULL COMMENT '记录值所属分类名称',
                                        `record_timeline` varchar(30) DEFAULT NULL COMMENT '记录值所属时间区间名称',
                                        `timeline` varchar(8) DEFAULT NULL COMMENT '统计时段说明[T,D,W,M,Y,LD3,LW1,LM1,LM3,Q1,Q2,Q3,Q4,TF]',
                                        `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
                                        `tmp_field_id` bigint(20) DEFAULT NULL COMMENT '临时标记数据域ID',
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `field` (`field`,`record_name`,`record_tuple`,`record_cluster`,`timeline`,`identifier`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_statistics_record
-- ----------------------------
INSERT INTO `st_statistics_record` VALUES ('1', 'all_alliance_totle', 'all_alliance_totle', '0', '所有盟友总额', '1086178.50', null, null, null, 'T', '2019-12-29 22:51:29', null);

-- ----------------------------
-- Table structure for sys_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm`;
CREATE TABLE `sys_perm` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                            `group_id` bigint(20) DEFAULT NULL COMMENT '权限所属组',
                            `identifier` varchar(50) NOT NULL COMMENT '权限值',
                            `name` varchar(50) DEFAULT NULL COMMENT '权限名',
                            `tag` smallint(6) DEFAULT '0' COMMENT '标签，0：普通权限，1：菜单',
                            PRIMARY KEY (`id`),
                            KEY `group_id` (`group_id`),
                            CONSTRAINT `sys_perm_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `sys_perm_group` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1012573379300782092 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_perm
-- ----------------------------
INSERT INTO `sys_perm` VALUES ('100000000000002001', '100200000000000002', 'Product.edit', '编辑产品', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002002', '100200000000000002', 'Product.delete', '删除产品', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002003', '100200000000000002', 'Product.view', '查看产品 ', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002004', '100200000000000002', 'Product.new', '新增产品 ', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002005', '100200000000000001', 'ProductCategory.edit', '编辑产品类别', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002006', '100200000000000001', 'ProductCategory.delete', '删除产品类别', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002007', '100200000000000001', 'ProductCategory.view', '查看产品类别', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002008', '100200000000000001', 'ProductCategory.new', '新增产品类别', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002009', '100200000000000003', 'ProductTag.edit', '编辑产品标签', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002010', '100200000000000003', 'ProductTag.delete', '删除产品标签', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002011', '100200000000000003', 'ProductTag.view', '查看产品标签', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002012', '100200000000000003', 'ProductTag.new', '新增产品标签', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002013', '100200000000000004', 'FareTemplate.edit', '编辑运费模板', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002014', '100200000000000004', 'FareTemplate.delete', '删除运费模板', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002015', '100200000000000004', 'FareTemplate.view', '查看运费模板', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002016', '100200000000000004', 'FareTemplate.new', '新增运费模板', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002017', '100200000000000002', 'Product.status', '产品上下架 ', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002018', '100200000000000005', 'Brand.edit', '编辑产品品牌', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002019', '100200000000000005', 'Brand.delete', '删除产品品牌', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002020', '100200000000000005', 'Brand.view', '查看产品品牌', '0');
INSERT INTO `sys_perm` VALUES ('100000000000002021', '100200000000000005', 'Brand.new', '新增产品品牌', '0');
INSERT INTO `sys_perm` VALUES ('100000000000004001', '100400000000000001', 'Alliance.edit', '编辑盟友', '0');
INSERT INTO `sys_perm` VALUES ('100000000000004002', '100400000000000001', 'Alliance.delete', '删除盟友', '0');
INSERT INTO `sys_perm` VALUES ('100000000000004003', '100400000000000001', 'Alliance.view', '查看盟友', '0');
INSERT INTO `sys_perm` VALUES ('100000000000004004', '100400000000000001', 'Alliance.new', '新增盟友', '0');
INSERT INTO `sys_perm` VALUES ('100000000000004005', '100400000000000001', 'Alliance.edit.state', '修改盟友支付状态', '0');
INSERT INTO `sys_perm` VALUES ('100000000000004006', '100400000000000001', 'Alliance.edit.state.up', '升级盟友', '0');
INSERT INTO `sys_perm` VALUES ('100000000000004007', '100400000000000002', 'Bonus.view', '产品销量', '0');
INSERT INTO `sys_perm` VALUES ('100000000000004008', '100400000000000003', 'Bonus.Dividend', '盟友分红信息', '0');
INSERT INTO `sys_perm` VALUES ('100000000000005005', '100500000000000001', 'Config.view', '查看配置', '0');
INSERT INTO `sys_perm` VALUES ('100000000000005007', '100500000000000001', 'Config.edit', '修改配置', '0');
INSERT INTO `sys_perm` VALUES ('100000000000006001', '100600000000000001', 'OperationLog.view', '查看日志', '0');
INSERT INTO `sys_perm` VALUES ('200000000000010001', '100500000000000002', 'FrontUser.view', '查看微信用户 ', '0');
INSERT INTO `sys_perm` VALUES ('200000000000011002', '100300000000000001', 'Order.delete', '删除订单', '0');
INSERT INTO `sys_perm` VALUES ('200000000000011003', '100300000000000001', 'Order.view', '查看订单 ', '0');
INSERT INTO `sys_perm` VALUES ('200000000000011004', '100300000000000001', 'Order.new', '新增订单 ', '0');
INSERT INTO `sys_perm` VALUES ('200000000000011005', '100300000000000002', 'Express.edit', '编辑快递', '0');
INSERT INTO `sys_perm` VALUES ('200000000000011006', '100300000000000002', 'Express.delete', '删除快递', '0');
INSERT INTO `sys_perm` VALUES ('200000000000011007', '100300000000000002', 'Express.view', '查看快递', '0');
INSERT INTO `sys_perm` VALUES ('200000000000011008', '100300000000000002', 'Express.new', '新增快递', '0');

-- ----------------------------
-- Table structure for sys_perm_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_perm_group`;
CREATE TABLE `sys_perm_group` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                  `org_id` bigint(20) NOT NULL COMMENT '资源隔离字段',
                                  `pid` bigint(20) DEFAULT NULL COMMENT '父部门id',
                                  `identifier` varchar(50) NOT NULL COMMENT '标识符',
                                  `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=876708082437197912 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_perm_group
-- ----------------------------
INSERT INTO `sys_perm_group` VALUES ('1', '1', null, 'root', '权限管理');
INSERT INTO `sys_perm_group` VALUES ('100000000000000002', '1', '1', 'product_management', '产品管理');
INSERT INTO `sys_perm_group` VALUES ('100000000000000003', '1', '1', 'order_management', '订单管理');
INSERT INTO `sys_perm_group` VALUES ('100000000000000004', '1', '1', 'Alliances.management', '盟友管理');
INSERT INTO `sys_perm_group` VALUES ('100000000000000005', '1', '1', 'config_management', '商城配置');
INSERT INTO `sys_perm_group` VALUES ('200000000000000006', '1', '1', 'sysConfig.management', '系统配置');
INSERT INTO `sys_perm_group` VALUES ('100200000000000001', '1', '100000000000000002', 'product_category_management', '产品类别');
INSERT INTO `sys_perm_group` VALUES ('100200000000000002', '1', '100000000000000002', 'product_product_management', '产品');
INSERT INTO `sys_perm_group` VALUES ('100200000000000003', '1', '100000000000000002', 'product_tag_management', '产品标签');
INSERT INTO `sys_perm_group` VALUES ('100200000000000004', '1', '100000000000000002', 'product_template_management', '运费模板');
INSERT INTO `sys_perm_group` VALUES ('100200000000000005', '1', '100000000000000002', 'product_crand_management', '品牌管理');
INSERT INTO `sys_perm_group` VALUES ('100300000000000001', '1', '100000000000000003', 'order_order_management', '订单管理');
INSERT INTO `sys_perm_group` VALUES ('100300000000000002', '1', '100000000000000003', 'order_Express_management', '快递管理');
INSERT INTO `sys_perm_group` VALUES ('100400000000000001', '1', '100000000000000004', 'Alliance.management', '盟友管理');
INSERT INTO `sys_perm_group` VALUES ('100400000000000002', '1', '100000000000000004', 'AllianceBonus.management', '产品销量');
INSERT INTO `sys_perm_group` VALUES ('100400000000000003', '1', '100000000000000004', 'AllianceDividend.management', '盟友分红信息');
INSERT INTO `sys_perm_group` VALUES ('100500000000000001', '1', '100000000000000002', 'configa_management', '配置管理');
INSERT INTO `sys_perm_group` VALUES ('100500000000000002', '1', '100000000000000002', 'front_user_management', '微信用户管理');
INSERT INTO `sys_perm_group` VALUES ('100600000000000001', '1', '100000000000000006', 'contract.management', '日志配置');

-- ---------------------------------------
-- 通用权限部分
-- ---------------------------------------
INSERT INTO `sys_perm_group` VALUES ('112573379300782085', '1', '100000000000000006', 'Org.management', '组织管理');
INSERT INTO `sys_perm_group` VALUES ('112573379300782088', '1', '100000000000000006', 'EAV.management', '自定义表单管理');
INSERT INTO `sys_perm_group` VALUES ('876708082437197910', '1', '100000000000000006', 'sysUser.management', '用户管理');
INSERT INTO `sys_perm_group` VALUES ('876708082437197911', '1', '100000000000000006', 'sysRole.management', '角色管理');


INSERT INTO `sys_perm` VALUES ('876708082437197920', '876708082437197910', 'sysUser.view', '查看用户', '0');
INSERT INTO `sys_perm` VALUES ('876708082437197921', '876708082437197910', 'sysUser.edit', '编辑用户', '0');
INSERT INTO `sys_perm` VALUES ('876708082437197922', '876708082437197910', 'sysUser.del', '删除用户', '0');
INSERT INTO `sys_perm` VALUES ('876708082437197923', '876708082437197911', 'sysRole.view', '查看角色', '0');
INSERT INTO `sys_perm` VALUES ('876708082437197924', '876708082437197911', 'sysRole.edit', '更新角色', '0');
INSERT INTO `sys_perm` VALUES ('876708082437197925', '876708082437197911', 'sysRole.del', '删除角色', '0');

INSERT INTO `sys_perm` VALUES ('1012573379300782088', '112573379300782088', 'EavEntity.view', '查看自定义表单', '0');
INSERT INTO `sys_perm` VALUES ('1012573379300782089', '112573379300782088', 'EavEntity.delete', '删除自定义表单', '0');
INSERT INTO `sys_perm` VALUES ('1012573379300782090', '112573379300782088', 'EavEntity.edit', '编辑自定义表单', '0');
INSERT INTO `sys_perm` VALUES ('1012573379300782091', '112573379300782088', 'EavEntity.new', '新建自定义表单', '0');

INSERT INTO `sys_perm` VALUES ('1012573379300782082', '112573379300782085', 'Org.view', '查看组织', '0');
INSERT INTO `sys_perm` VALUES ('1012573379300782083', '112573379300782085', 'Org.edit', '编辑组织', '0');
INSERT INTO `sys_perm` VALUES ('1012573379300782084', '112573379300782085', 'Org.del', '删除组织', '0');


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                            `org_id` bigint(20) NOT NULL,
                            `sort_order` int(11) NOT NULL DEFAULT '1' COMMENT '排序号',
                            `pid` bigint(20) DEFAULT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            `tips` varchar(255) DEFAULT NULL,
                            `version` int(11) DEFAULT NULL,
                            `delete_flag` int(11) NOT NULL DEFAULT '1',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `org_id` (`org_id`,`name`),
                            CONSTRAINT `sys_role_ibfk_1` FOREIGN KEY (`org_id`) REFERENCES `t_sys_org` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=876708082437197828 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('876708082437197826', '1', '1', '0', '超级管理员', 'administrator', '1', '1');
INSERT INTO `sys_role` VALUES ('876708082437197827', '1', '1', null, '十美创享', '十美创享运维服务', null, '1');

-- ----------------------------
-- Table structure for sys_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_perm`;
CREATE TABLE `sys_role_perm` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                 `perm_id` bigint(20) DEFAULT NULL,
                                 `role_id` bigint(20) DEFAULT NULL,
                                 PRIMARY KEY (`id`),
                                 KEY `role_id` (`role_id`),
                                 KEY `perm_id` (`perm_id`),
                                 CONSTRAINT `sys_role_perm_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE,
                                 CONSTRAINT `sys_role_perm_ibfk_2` FOREIGN KEY (`perm_id`) REFERENCES `sys_perm` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=876708082437205816 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_perm
-- ----------------------------
INSERT INTO `sys_role_perm` VALUES ('876708082437198641', '100000000000002005', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198642', '100000000000002006', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198643', '100000000000002007', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198644', '100000000000002008', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198645', '100000000000002001', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198646', '100000000000002002', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198647', '100000000000002003', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198648', '100000000000002004', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198649', '100000000000002017', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198650', '100000000000002009', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198651', '100000000000002010', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198652', '100000000000002011', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198653', '100000000000002012', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198654', '100000000000002013', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198655', '100000000000002014', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198656', '100000000000002015', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198657', '100000000000002016', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198658', '100000000000002018', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198659', '100000000000002019', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198660', '100000000000002020', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437198661', '100000000000002021', '876708082437197827');
INSERT INTO `sys_role_perm` VALUES ('876708082437205763', '100000000000002001', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205764', '100000000000002002', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205765', '100000000000002003', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205766', '100000000000002004', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205767', '100000000000002005', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205768', '100000000000002006', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205769', '100000000000002007', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205770', '100000000000002008', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205771', '100000000000002009', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205772', '100000000000002010', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205773', '100000000000002011', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205774', '100000000000002012', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205775', '100000000000002013', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205776', '100000000000002014', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205777', '100000000000002015', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205778', '100000000000002016', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205779', '100000000000002017', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205780', '100000000000002018', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205781', '100000000000002019', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205782', '100000000000002020', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205783', '100000000000002021', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205784', '100000000000004001', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205785', '100000000000004002', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205786', '100000000000004003', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205787', '100000000000004004', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205788', '100000000000004005', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205789', '100000000000004006', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205790', '100000000000004007', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205791', '100000000000004008', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205792', '100000000000005005', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205793', '100000000000005007', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205794', '100000000000006001', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205795', '100000000000010001', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205796', '100000000000011002', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205797', '100000000000011003', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205798', '100000000000011004', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205799', '100000000000011005', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205800', '100000000000011006', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205801', '100000000000011007', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205802', '100000000000011008', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205803', '876708082437197920', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205804', '876708082437197921', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205805', '876708082437197922', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205806', '876708082437197923', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205807', '876708082437197924', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205808', '876708082437197925', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205809', '1012573379300782082', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205810', '1012573379300782083', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205811', '1012573379300782084', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205812', '1012573379300782088', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205813', '1012573379300782089', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205814', '1012573379300782090', '876708082437197826');
INSERT INTO `sys_role_perm` VALUES ('876708082437205815', '1012573379300782091', '876708082437197826');

-- ----------------------------
-- Table structure for sys_role_perm_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_perm_group`;
CREATE TABLE `sys_role_perm_group` (
                                       `id` bigint(20) NOT NULL,
                                       `perm_group_id` bigint(20) NOT NULL,
                                       `role_id` bigint(20) NOT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `role_id` (`role_id`,`perm_group_id`),
                                       KEY `role_id_2` (`role_id`),
                                       KEY `perm_group_id` (`perm_group_id`),
                                       CONSTRAINT `sys_role_perm_group_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE,
                                       CONSTRAINT `sys_role_perm_group_ibfk_2` FOREIGN KEY (`perm_group_id`) REFERENCES `sys_perm_group` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_perm_group
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                 `user_id` bigint(20) NOT NULL,
                                 `role_id` bigint(20) NOT NULL,
                                 PRIMARY KEY (`id`),
                                 UNIQUE KEY `role_id` (`role_id`,`user_id`),
                                 KEY `user_id` (`user_id`),
                                 CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_sys_user` (`id`) ON DELETE CASCADE,
                                 CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=876708082437197835 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('876708082437197832', '876708082437197827', '876708082437197826');
INSERT INTO `sys_user_role` VALUES ('876708082437197834', '876708082437197832', '876708082437197826');


-- ----------------------------
-- Table structure for t_sys_org
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_org`;
CREATE TABLE `t_sys_org` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                             `pid` bigint(20) DEFAULT NULL COMMENT '父部门id',
                             `name` varchar(60) NOT NULL COMMENT '部门名称',
                             `org_code` varchar(50) DEFAULT NULL COMMENT '部门编号',
                             `full_name` varchar(128) DEFAULT NULL COMMENT '部门全称',
                             `node_level` int(11) NOT NULL DEFAULT '0' COMMENT '所在层级 (0,1,2)',
                             `left_num` int(11) NOT NULL DEFAULT '1' COMMENT '左下标',
                             `right_num` int(11) NOT NULL DEFAULT '2' COMMENT '右下标',
                             `note` text COMMENT '部门描述',
                             `status` varchar(26) NOT NULL DEFAULT 'NORMAL' COMMENT '状态',
                             `org_type` smallint(6) NOT NULL DEFAULT '0' COMMENT '默认 org_type = 1 时信息为租户，非租户 org_type = 0 ,platform org_type = 2',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `pid` (`pid`,`name`),
                             UNIQUE KEY `org_code` (`org_code`)
) ENGINE=InnoDB AUTO_INCREMENT=100000000000000009 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of t_sys_org
-- ----------------------------
INSERT INTO `t_sys_org` VALUES ('1', null, '可圈点科技有限公司', 'A1', '广州可圈点信息科技有限公司', '1', '1', '10', '总公司', 'NORMAL', '0', '2018-09-23 00:37:59', '2019-12-13 11:51:27');
INSERT INTO `t_sys_org` VALUES ('100000000000000002', '1', '十美创享集团', '1000', '十美创享之家平台', '2', '2', '9', '十美', 'NORMAL', '1', '2019-11-05 18:37:59', '2019-12-13 11:51:27');
INSERT INTO `t_sys_org` VALUES ('100000000000000003', '100000000000000002', '运营部', 'A001', '运营部', '3', '3', '4', '', 'NORMAL', '4', '2019-11-05 19:04:27', '2019-12-04 15:03:03');
INSERT INTO `t_sys_org` VALUES ('100000000000000005', '100000000000000002', '开发部', 'B001', '开发部', '3', '5', '8', null, 'NORMAL', '4', '2019-11-08 10:12:45', '2019-12-13 11:51:27');
INSERT INTO `t_sys_org` VALUES ('100000000000000008', '100000000000000005', '开发1组', 'Test001', '开发1组', '4', '6', '7', null, 'NORMAL', '5', '2019-12-13 11:51:27', '2019-12-13 11:51:28');



-- ----------------------------
-- Table structure for t_sys_user
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
                              `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
                              `email_validated` smallint(6) NOT NULL DEFAULT '0' COMMENT '邮箱是否验证，默认 0-未验证,1-验证',
                              `phone` varchar(45) DEFAULT NULL COMMENT '电话',
                              `status` int(11) DEFAULT '1' COMMENT '状态',
                              `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间，可理解为注册时间',
                              `version` int(11) DEFAULT NULL COMMENT '版本',
                              `delete_flag` int(11) NOT NULL DEFAULT '1' COMMENT '逻辑删除字段',
                              `is_app_user` int(11) NOT NULL DEFAULT '0' COMMENT '是否为APP 用户 ,已过时',
                              `password_reset` int(11) NOT NULL DEFAULT '0' COMMENT '重置密码',
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `email` (`email`),
                              UNIQUE KEY `phone` (`phone`),
                              UNIQUE KEY `account` (`account`,`org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=876708082437197833 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('876708082437197827', '', 'admin', '1', null, 'b5106d36993ba6afd2b5b99e3e46e1af', 'p683b', '管理员', '2019-11-09 08:00:00', '0', 'admin@kequandian.net', '0', '18200000000', '1', '2017-01-29 08:49:53', '1', '1', '0', '1');
INSERT INTO `t_sys_user` VALUES ('876708082437197828', null, 'smcx', null, null, null, null, '十美创享', null, '1', 'qq@qq.com', '0', '13800000000', '1', '2019-11-06 18:26:28', null, '1', '0', '0');
INSERT INTO `t_sys_user` VALUES ('876708082437197832', null, 'demo', null, null, '198f557c6c22d6116e659113b1668d1b', '7x1k2', '测试', null, '0', null, '0', null, '1', '2020-05-22 15:54:41', null, '1', '0', '0');



ALTER TABLE t_sys_user ADD `user_type` INT ( 11 ) DEFAULT '0' COMMENT '用户类型 0-默认-平台用户(传统用户，隔离在租户下) 1-组织管理人 2-个人用户 3-个人组织用户 100-管理员（租户管理员 自动跳过权限检查） 102-观察者用户-所有看的权限';
ALTER TABLE t_sys_user ADD `tenant_org_id` BIGINT ( 20 ) DEFAULT NULL COMMENT '租户id';
ALTER TABLE t_sys_user ADD `dev_user_type` INT ( 11 ) DEFAULT '0' COMMENT '可以有多种隔离方式的用户类型 1-测试用户（系统不可见，权限与普通用户一致） 2-开发者权限(自动具备所有权限) 3-运维人员(受限于系统权与运维权限)';
ALTER TABLE t_sys_user ADD `b_user_type` VARCHAR ( 30 ) DEFAULT 'SYSTEM' COMMENT '业务用户类型: 默认平台用户类型:SYSTEM, - 非平台用户-业务层用户';
ALTER TABLE t_sys_user ADD `registered_phone` INT ( 11 ) NOT NULL DEFAULT '0' COMMENT '注册-手机验证';
ALTER TABLE t_sys_user ADD `registered_email` INT ( 11 ) NOT NULL DEFAULT '0' COMMENT '注册-邮箱验证';
ALTER TABLE t_sys_user ADD `github_info` VARCHAR ( 255 ) DEFAULT NULL COMMENT 'github账户信息';
ALTER TABLE t_sys_user ADD `unionid` VARCHAR ( 100 ) DEFAULT NULL COMMENT '第三方授权ID';
ALTER TABLE t_sys_user ADD `domain` VARCHAR ( 100 ) DEFAULT NULL;


CREATE TABLE `t_saas_application` (
                                      `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                      `name` varchar(50) DEFAULT NULL COMMENT '应用名',
                                      `git_info` varchar(255) DEFAULT NULL COMMENT '应用代码地址',
                                      `command` varchar(255) DEFAULT NULL COMMENT '执行命令',
                                      `type` varchar(40) DEFAULT 'NORMAL' COMMENT '应用类型 NORMAL-普通APP SYS-租户主页',
                                      `note` text COMMENT '备注',
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='应用表';


CREATE TABLE `t_saas_application_example` (
                                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                              `application_id` bigint(20) NOT NULL,
                                              `contract_template_id` bigint(20) NOT NULL,
                                              `domain` varchar(255) DEFAULT NULL COMMENT '应用类型为租户主页时 此项为空',
                                              `type` varchar(40) DEFAULT 'NORMAL' COMMENT '应用类型 NORMAL-普通APP SYS-租户主页',
                                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='应用实例（应用-合约）表';


CREATE TABLE `t_saas_contract` (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                   `name` varchar(50) NOT NULL COMMENT '合约名',
                                   `contract_number` varchar(50) NOT NULL COMMENT '合约编号',
                                   `payment_id` bigint(20) DEFAULT NULL COMMENT '付款流水id',
                                   `org_id` bigint(20) DEFAULT '0' COMMENT '订阅 组织/部门id',
                                   `contract_template_id` bigint(20) DEFAULT NULL COMMENT '所属合约模板',
                                   `invalid` smallint(6) DEFAULT '0' COMMENT ' 是否有效 (0默认有效 1无效）',
                                   `created_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '合约创建时间',
                                   `start_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '合约开始时间',
                                   `last_valid_time` datetime DEFAULT NULL COMMENT '最后有效时间',
                                   `close_time` datetime DEFAULT NULL COMMENT '合约结束时间',
                                   `status` varchar(26) DEFAULT 'UNPAID' COMMENT '状态（未付款/UNPAID,已付款PAID,已关闭CLOSED）',
                                   `price` decimal(16,2) DEFAULT NULL COMMENT '价格',
                                   `total_ppd` decimal(16,2) DEFAULT '0.00' COMMENT '总折扣',
                                   `Discount` decimal(16,2) DEFAULT '0.00' COMMENT '优惠',
                                   `final_price` decimal(16,2) DEFAULT NULL COMMENT '最终价格',
                                   `long_term` smallint(6) DEFAULT NULL COMMENT '是否长期有效 0 到期结束   1 长期有效',
                                   `auto_renew` smallint(6) DEFAULT NULL COMMENT ' 是否自动续约 [0否,1是]',
                                   `prepay` smallint(6) DEFAULT NULL COMMENT '是否预付 {0非预付-1付款}',
                                   `note` text COMMENT '备注',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='合约表';


CREATE TABLE `t_saas_contract_template` (
                                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                            `name` varchar(50) NOT NULL COMMENT '模板名',
                                            `note` text COMMENT '备注',
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='合约模板表';


CREATE TABLE `t_saas_module` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                 `app_id` bigint(20) NOT NULL COMMENT '应用id',
                                 `name` varchar(50) NOT NULL COMMENT '模块名',
                                 `perm` varchar(50) DEFAULT NULL COMMENT '权限 如果为空 查询menu_id',
                                 `type` varchar(40) DEFAULT 'NORMAL' COMMENT 'NORMAL-普通模块',
                                 `note` text COMMENT '备注',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='模块表';

CREATE TABLE `t_saas_module_menu` (
                                      `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                      `menu_id` bigint(20) NOT NULL COMMENT '菜单id',
                                      `module_id` bigint(20) NOT NULL COMMENT '模块id',
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='模块-菜单 表';



CREATE TABLE `sys_menu` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
                            `menu_name` varchar(50) NOT NULL COMMENT '菜单名称',
                            `pid` bigint(20) DEFAULT NULL COMMENT '父菜单ID',
                            `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
                            `path` varchar(200) DEFAULT '' COMMENT '路由地址',
                            `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
                            `is_frame` int(1) DEFAULT '1' COMMENT '是否为外链（0是 1否）',
                            `is_cache` int(1) DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
                            `menu_type` char(1) DEFAULT '' COMMENT '菜单类型（C目录 M菜单 B按钮）',
                            `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
                            `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
                            `perm_id` bigint(20) DEFAULT NULL COMMENT '权限id',
                            `perm` varchar(50) DEFAULT NULL COMMENT '权限',
                            `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
                            `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                            `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                            `remark` varchar(500) DEFAULT '' COMMENT '备注',
                            `org_id` bigint(20) DEFAULT NULL COMMENT '隔离标识',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

CREATE TABLE `sys_perm` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                            `group_id` bigint(20) DEFAULT NULL COMMENT '权限所属组',
                            `identifier` varchar(50) NOT NULL COMMENT '权限值',
                            `name` varchar(50) DEFAULT NULL COMMENT '权限名',
                            `tag` smallint(6) DEFAULT '0' COMMENT '标签，0：普通权限，1：菜单',
                            PRIMARY KEY (`id`) USING BTREE,
                            KEY `group_id` (`group_id`) USING BTREE,
                            CONSTRAINT `sys_perm_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `sys_perm_group` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1531168757689380866 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `sys_perm_group` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                                  `org_id` bigint(20) NOT NULL COMMENT '资源隔离字段',
                                  `pid` bigint(20) DEFAULT NULL COMMENT '父部门id',
                                  `identifier` varchar(50) NOT NULL COMMENT '标识符',
                                  `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1531168755181187075 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

CREATE TABLE `t_supplier` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                              `name` varchar(120) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '供应商',
                              `note` text COLLATE utf8mb4_bin COMMENT '介绍',
                              `type` int(11) NOT NULL DEFAULT '1' COMMENT '类型 0-软装修 1-家居家电装饰品提供商',
                              `url` text COLLATE utf8mb4_bin COMMENT '供应商图片',
                              `address` varchar(150) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '供应商地址',
                              `org_id` bigint(20) DEFAULT NULL,
                              `phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
                              `user_id` bigint(20) DEFAULT NULL,
                              `end_user_id` bigint(20) DEFAULT NULL,
                              `link` text COLLATE utf8mb4_bin,
                              `snapshot` text COLLATE utf8mb4_bin,
                              `bind_key` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
                              `bind_type` int(11) DEFAULT '0' COMMENT '0-未绑定 1-绑定申请中 2-已绑定',
                              `bind_user_id` bigint(20) DEFAULT NULL COMMENT '申请绑定的用户id',
                              `vr_id` bigint(20) DEFAULT NULL,
                              PRIMARY KEY (`id`) USING BTREE,
                              UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='供应商（软装修/家居/家电/装饰品）';



INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (10, '系统管理', NULL, 12, '', '/sys', 1, 0, 'C', '0', '0', NULL, NULL, '#', 'admin', '2021-04-28 01:41:17', 'admin', '2022-06-27 18:35:27', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (11, '菜单管理', 10, 0, '', '/sys/menuManage', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2021-04-28 01:41:43', 'admin', '2022-03-16 17:14:28', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (12, '组织管理', 10, 2, '', '/sys/org', 1, 0, 'M', '0', '0', 100000000000030001, 'Org.view', '#', 'admin', '2021-04-28 01:56:03', 'admin', '2022-03-16 17:14:11', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (13, '用户管理', 10, 1, '', '/sys/user', 1, 0, 'M', '0', '0', 100000000000010001, 'sysUser.view', '#', 'admin', '2021-04-28 01:56:33', 'admin', '2022-06-30 16:51:12', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (14, '角色管理', 10, 2, '', '/sys/role', 1, 0, 'M', '0', '0', 100000000000020001, 'sysRole.view', '#', 'admin', '2021-04-28 01:58:52', 'admin', '2022-03-16 17:14:46', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (15, '表单设计', 10, 2, '', '/sys/activitiesCustom', 1, 0, 'M', '0', '0', 100000000000041001, 'virtualform.view', '#', 'admin', '2021-04-28 02:00:39', 'admin', '2022-04-26 17:39:28', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (16, '自定义字段', 10, 2, '', '/sys/fieldCustom', 1, 0, 'M', '0', '0', 1012573379300782088, 'eav.view', '#', 'admin', '2021-04-28 02:01:36', 'admin', '2022-03-16 17:14:56', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (17, '操作日志', 10, 4, '', '/sys/logs', 1, 0, 'M', '0', '0', 100000000000011001, 'OperationLog.view', '#', 'admin', '2021-04-28 02:04:38', 'admin', '2022-03-18 16:22:09', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (18, '报表管理', 10, 2, '', '/sys/dataReport', 1, 0, 'M', '0', '0', 1001001001, 'defaultReport.view', '#', 'admin', '2021-04-28 02:06:24', 'admin', '2021-04-28 02:35:15', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (19, '自定义字段测试', 10, 2, '', '/sys/testField', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2021-04-28 02:34:35', 'admin', '2022-03-16 17:15:52', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (20, '运维管理', NULL, 13, '', '/devops', 1, 0, 'C', '0', '0', 100000000000011002, 'Config.view', '#', 'admin', '2022-03-14 15:15:45', 'admin', '2022-06-28 09:39:29', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (21, '配置管理', 20, 1, '', '/devops/configManage', 1, 0, 'M', '0', '0', 100000000000011002, 'Config.view', '#', 'admin', '2022-03-14 15:17:19', 'admin', '2022-06-27 12:31:51', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (22, '权限管理', 20, 0, '', '/devops/permManage', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-03-14 15:17:42', 'admin', '2022-03-14 15:17:42', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (23, '开发用户', 20, 0, '', '/devops/developerManege', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-03-14 15:18:03', 'admin', '2022-03-14 15:18:03', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (24, '测试菜单组', NULL, 0, '', '/undefined_menu', 1, 0, 'C', '0', '1', NULL, NULL, '#', 'admin', '2022-03-15 17:08:30', 'admin', '2022-03-15 17:08:30', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (25, '测试菜单', 24, 0, '', '/test', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-03-15 17:09:03', 'admin', '2022-03-15 17:09:03', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (27, '租户管理', 10, 1, '', '/sys/tenantManage', 1, 0, 'M', '0', '1', NULL, NULL, '#', 'admin', '2022-03-16 17:05:42', 'admin', '2022-03-16 17:12:54', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (28, '动态页面', 20, 0, '', '/devops/dynamicPage', 1, 0, 'C', '0', '0', NULL, NULL, '#', 'admin', '2022-03-17 16:16:00', 'admin', '2022-06-28 10:37:57', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (29, '测试动态页面加载', 10, 2, '', '/sys/testPageFetch', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-03-18 16:21:08', 'admin', '2022-03-18 16:22:20', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (30, 'pageTitle', 62, 0, '', '/sys/testPageFetch?id=[id]', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-04-06 17:44:36', 'admin', '2022-04-06 17:44:36', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (31, 'pageTitle', 62, 0, '', '/sys/testPageFetch?id=[id]', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-04-06 17:44:49', 'admin', '2022-04-06 17:44:49', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (33, '1', 62, 0, '', '/sys/testPageFetch?id=[id]', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-04-11 16:11:30', 'admin', '2022-04-11 16:11:30', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (34, '标题', 62, 0, '', '/sys/testPageFetch?id=[id]', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-04-18 16:14:07', 'admin', '2022-04-18 16:14:07', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (35, '标题', 62, 0, '', '/sys/testPageFetch?id=[id]', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-04-18 16:14:54', 'admin', '2022-04-18 16:14:54', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (36, '测试页面标题23', 62, 0, '', '/sys/testPageFetch?id=[id]', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-04-21 14:13:48', 'admin', '2022-04-21 14:13:48', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (37, '测试页面标题23', 62, 0, '', '/sys/testPageFetch?id=[id]', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-04-22 11:10:28', 'admin', '2022-04-22 11:10:28', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (40, '数据服务', 10, 0, '', '/sys/dataService', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-04-27 12:03:51', 'admin', '2022-04-27 12:03:51', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (41, 'lowActionses', 62, 0, '', '/sys/testPageFetch?id=[id]', 1, 0, 'C', '0', '0', NULL, NULL, '#', 'admin', '2022-04-28 15:36:39', 'admin', '2022-04-28 15:36:39', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (42, '标题', 62, 0, '', '/sys/testPageFetch?id=[id]', 1, 0, 'C', '0', '0', NULL, NULL, '#', 'admin', '2022-04-28 15:37:31', 'admin', '2022-04-28 15:37:31', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (43, 'nav-ui', NULL, 0, '', '/navUI', 1, 0, 'C', '0', '1', NULL, NULL, '#', 'admin', '2022-05-10 14:20:41', 'admin', '2022-05-10 14:20:41', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (44, '导航分类', 43, 0, '', '/navUI/navCategory', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-05-10 14:22:05', 'admin', '2022-05-10 14:22:05', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (45, '导航管理', 43, 0, '', '/navUI/navList', 1, 0, 'M', '0', '1', NULL, NULL, '#', 'admin', '2022-05-10 16:16:16', 'admin', '2022-05-10 16:16:16', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (53, '商品分类', 52, 0, '', '/product/categroy', 1, 0, 'M', '0', '0', 100000000000002007, 'ProductCategory.view', '#', 'admin', '2022-05-16 17:21:59', 'admin', '2022-05-27 17:55:04', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (54, '商品管理', 52, 0, '', '/product/items', 1, 0, 'M', '0', '0', 100000000000002003, 'Product.view', '#', 'admin', '2022-05-16 17:23:17', 'admin', '2022-05-27 17:55:36', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (55, '配置管理', NULL, 2, '', '/setting', 1, 0, 'C', '0', '1', NULL, NULL, '#', 'admin', '2022-05-18 10:37:27', 'admin', '2022-06-27 12:06:25', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (56, '商城配置', 69, 1, '', '/setting/shopConfig', 1, 0, 'M', '0', '1', NULL, NULL, '#', 'admin', '2022-05-18 10:38:30', 'admin', '2022-06-27 18:36:30', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (57, '订单管理', NULL, 1, '', '/order', 1, 0, 'C', '0', '1', NULL, NULL, '#', 'admin', '2022-05-18 16:45:31', 'admin', '2022-06-27 12:06:13', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (58, '线上订单', 69, 1, '', '/mallManage/orderOnline', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-05-18 16:47:19', 'admin', '2022-06-28 10:14:30', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (59, '供应商', 73, 2, '', '/userManage/supplierManage', 1, 0, 'M', '0', '0', 1531168757064429570, 'supplier.view', '#', 'admin', '2022-05-21 17:33:34', 'admin', '2022-07-01 20:45:06', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (61, '线下管理', NULL, 0, '', '/offline', 1, 0, 'C', '0', '1', NULL, NULL, '#', 'admin', '2022-05-31 10:30:54', 'admin', '2022-05-31 10:32:37', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (62, '线下订单', 61, 0, '', '/offline/order', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-05-31 10:31:54', 'admin', '2022-05-31 10:31:54', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (63, '线下提现', 61, 0, '', '/offline/withdrawal', 1, 0, 'M', '0', '1', NULL, NULL, '#', 'admin', '2022-05-31 10:32:31', 'admin', '2022-05-31 10:32:31', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (64, '提现申请', 61, 0, '', '/offline/applyWithdrawal', 1, 0, 'M', '0', '1', NULL, NULL, '#', 'admin', '2022-05-31 10:35:05', 'admin', '2022-05-31 10:35:05', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (65, '合约模板管理', 46, 0, '', '/tenantManage/contractTemplateManage', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-06-14 11:20:43', 'admin', '2022-06-14 11:20:43', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (66, '数据字典', 55, 1, '', '/setting/dictionary', 1, 0, 'M', '0', '1', NULL, NULL, '#', 'admin', '2022-06-21 10:00:43', 'admin', '2022-06-23 14:41:50', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (67, '配置管理', 10, 1, '', '/sys/sysSetting', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-06-21 15:08:50', 'admin', '2022-06-28 10:24:38', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (68, '微信用户', 73, 1, '', '/userManage/user', 1, 0, 'M', '0', '1', NULL, NULL, '#', 'admin', '2022-06-23 14:40:51', 'admin', '2022-06-30 14:41:31', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (69, '商城管理', NULL, 0, '', '/mallManage', 1, 0, 'C', '0', '0', NULL, NULL, '#', 'admin', '2022-06-27 12:05:52', 'admin', '2022-06-27 12:05:52', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (70, '商品分类', 69, 0, '', '/mallManage/categroy', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-06-27 12:07:23', 'admin', '2022-06-27 12:07:23', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (71, '商品管理', 69, 0, '', '/mallManage/items', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-06-27 12:23:37', 'admin', '2022-06-27 12:23:37', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (72, '商城配置', 69, 0, '', '/mallManage/shopConfig', 1, 0, 'M', '0', '0', NULL, NULL, '#', 'admin', '2022-06-27 12:38:19', 'admin', '2022-06-27 12:38:19', '', NULL);
INSERT INTO `sys_menu`(`id`, `menu_name`, `pid`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perm_id`, `perm`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`, `org_id`) VALUES (73, '用户管理', NULL, 11, '', '/userManage', 1, 0, 'C', '0', '1', NULL, NULL, '#', 'admin', '2022-06-27 18:48:12', 'admin', '2022-07-01 20:44:45', '', NULL);
