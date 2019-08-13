DROP TABLE IF EXISTS `t_term_config`;
CREATE TABLE `t_term_config` (
	id BIGINT (20) NOT NULL AUTO_INCREMENT,
	type VARCHAR (50) NOT NULL COMMENT '类型 ABOUT_US,NOTICE,CONNECT_US ...',
	title VARCHAR (50) DEFAULT NULL COMMENT '标题',
	content text COMMENT '内容',
	created_time DATETIME NULL COMMENT '创建时间',
	`org_id` bigint(20) DEFAULT NULL COMMENT '组织(部门)ID',
	previous_modified_time DATETIME NULL COMMENT '上次修改时间',
	last_modified_time DATETIME NULL COMMENT '最后修改时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = UTF8;
