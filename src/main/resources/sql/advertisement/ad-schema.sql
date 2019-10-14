SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS t_ad_group;
CREATE TABLE IF NOT EXISTS t_ad_group (
    id bigint(20) not null primary key auto_increment,
    name varchar(50) not null,
    `org_id` bigint(20) DEFAULT NULL COMMENT '组织(部门)ID',
    UNIQUE(name)
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS t_ad;
CREATE TABLE IF NOT EXISTS t_ad (
    id bigint not null primary key auto_increment,
    group_id bigint(20) default null,
    `name` varchar(100) default null,
    image varchar(200) default null,
    enabled smallint(5) not null default 1,
    target_url varchar(255) default null,
    `org_id` bigint(20) DEFAULT NULL COMMENT '组织(部门)ID',
    `strategy` varchar(100) DEFAULT NULL COMMENT '策略'
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS t_ad_link_definition;
CREATE TABLE IF NOT EXISTS t_ad_link_definition (
    id bigint(20) not null primary key auto_increment,
    `type` integer default 0, /*0 功能链接, 1 产品链接*/
    `name` varchar(100),
    `org_id` bigint(20) DEFAULT NULL COMMENT '组织(部门)ID',
    url varchar(200)
) ENGINE=InnoDB  DEFAULT CHARSET=UTF8;

SET FOREIGN_KEY_CHECKS=1;