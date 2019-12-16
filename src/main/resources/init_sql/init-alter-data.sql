SET FOREIGN_KEY_CHECKS=0;


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

alter table  t_express add  org_id bigint(20) default null comment 'org_id';
alter table  t_ad add  `seq` smallint(6) DEFAULT 0 COMMENT '排序号';









SET FOREIGN_KEY_CHECKS=1;