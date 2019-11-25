DROP TABLE IF EXISTS `t_store`;
CREATE TABLE `t_store` (
	/*店铺表*/
	id BIGINT (20) NOT NULL AUTO_INCREMENT,
	warehouse_id BIGINT (20) DEFAULT NULL,
	type varchar(50) not null default 'Store' comment '小店或店铺，默认是店铺 Store/Muaskin/Mutiple',
	code VARCHAR (50) not NULL,
	name VARCHAR (50) DEFAULT NULL,
	avatar VARCHAR (255) not NULL,
	status varchar(26) DEFAULT NULL COMMENT '营业状态',
	director VARCHAR (255) DEFAULT NULL,
	longitude DECIMAL (10, 6) DEFAULT NULL,
	latitude DECIMAL (10, 6) DEFAULT NULL,
	address VARCHAR (50) DEFAULT NULL,
	pcd VARCHAR (255) DEFAULT NULL,
	province VARCHAR (50) DEFAULT NULL,
	city VARCHAR (50) DEFAULT NULL,
	district VARCHAR (50) DEFAULT NULL,
	introduce text DEFAULT NULL,
	telephone VARCHAR (20) DEFAULT NULL,
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`org_id` bigint(20) DEFAULT NULL COMMENT '组织(部门)ID',
	unique(`code`),
	PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `t_store_assistant`;

CREATE TABLE `t_store_assistant` (
	/*店员表*/
	id BIGINT (20) NOT NULL AUTO_INCREMENT,
	code VARCHAR (50) not NULL,
	name VARCHAR (50) DEFAULT NULL,
	username varchar(50) DEFAULT NULL,
	avatar VARCHAR (255) DEFAULT NULL,
	position VARCHAR (50) DEFAULT NULL,
	telephone VARCHAR (50) DEFAULT NULL,
	wechat VARCHAR (50) DEFAULT NULL,
	qq VARCHAR (50) DEFAULT NULL,
	status VARCHAR (50) DEFAULT NULL,
	is_director smallint(5) DEFAULT 0,
	director_id BIGINT (20) DEFAULT NULL,
	store_id BIGINT (20) DEFAULT NULL,
	user_id BIGINT (20) NOT NULL,
	`org_id` bigint(20) DEFAULT NULL COMMENT '组织(部门)ID',
	unique(`user_id`),
	unique(`code`),
	PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `t_store_assistant_relation`;
create table `t_store_assistant_relation`(
    `id` BIGINT (20) NOT NULL AUTO_INCREMENT,
    `store_id` BIGINT (20) NOT NULL comment'店铺Id',
    `assistant_id` BIGINT (20) NOT NULL comment'店员Id',
    `is_shopkeeper` smallint(5) default 0 comment '是否是店长',
    unique(`store_id`,`assistant_id`),
    PRIMARY key (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;



DROP TABLE IF EXISTS `t_store_shifting`;
CREATE TABLE `t_store_shifting` (
	/*交班表*/
	id BIGINT (20) NOT NULL AUTO_INCREMENT,
	store_id BIGINT (20) NOT NULL,
	cashier_client_id BIGINT (20) NOT NULL,
	assistant_id BIGINT (20) NOT NULL,
	cashier VARCHAR (50) DEFAULT NULL,
	next_assistant_id BIGINT (20) NOT NULL,
	next_cashier VARCHAR (50) DEFAULT NULL ,
	status VARCHAR (50) DEFAULT 'Working',
	on_duty_time DATETIME DEFAULT NULL,
	log_time DATETIME DEFAULT NULL,
	on_duty_amount DECIMAL (10, 2) DEFAULT NULL,
	log_amount DECIMAL (10, 2) DEFAULT NULL,
	apply_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	confirm_time date default null comment '确认时间',
	unique(`assistant_id`,`next_assistant_id`),
	`org_id` bigint(20) DEFAULT NULL COMMENT '组织(部门)ID',
	PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `t_cashier_client`;
CREATE TABLE `t_cashier_client` (
	/*收银机表*/
	id BIGINT (20) NOT NULL AUTO_INCREMENT,
	store_id BIGINT (20) NOT NULL,
	code VARCHAR (50) DEFAULT NULL,
	factory VARCHAR (50) DEFAULT NULL,
	model VARCHAR (50) DEFAULT NULL,
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`org_id` bigint(20) DEFAULT NULL COMMENT '组织(部门)ID',
	unique(`store_id`,`code`),
	PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `t_assistant_vip_relation`;
CREATE TABLE `t_assistant_vip_relation` (
	id BIGINT (20) NOT NULL AUTO_INCREMENT,
	assistant_id BIGINT (20) NOT NULL,
	vip_id BIGINT (20) NOT NULL,
	create_time  timestamp not null default current_timestamp,
	store_id BIGINT (20) default NULL,
	`org_id` bigint(20) DEFAULT NULL COMMENT '组织(部门)ID',
	unique(`assistant_id`,`vip_id`),
	PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;
