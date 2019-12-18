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

alter table   t_fare_template  add `addrids` varchar(150) DEFAULT NULL COMMENT '地址id';

alter table  t_express add  org_id bigint(20) default null comment 'org_id';
alter table t_product_brand add  org_id bigint(20) default null comment 'org_id';
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









SET FOREIGN_KEY_CHECKS=1;