-- 统计
-- ----------------------------
-- Table structure for st_statistics_field
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_field`;
CREATE TABLE `st_statistics_field` (
                                       `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                       `field` varchar(80) NOT NULL COMMENT '数据域唯一标识符',
                                       `group_id` bigint(20) DEFAULT NULL COMMENT '所属分组ID',
                                       `group_name` varchar(50) NOT NULL COMMENT '所属分组名称',
                                       `name` varchar(50) NOT NULL COMMENT '数据域名称',
                                       `pattern` varchar(26) NOT NULL COMMENT '统计数据类型[Count,Rate,Tuple [Timeline,Cluster]]',
                                       `chart` varchar(26) NOT NULL COMMENT '标准组件图表名称',
                                       `attr_invisible` smallint(6) DEFAULT '0' COMMENT '[属性]是否不可见',
                                       `attr_runtime` smallint(6) DEFAULT '0' COMMENT '是否实时查询[via meta]',
                                       `attr_span` smallint(6) DEFAULT '1' COMMENT '[属性]所占布局跨列数',
                                       `attr_index` smallint(6) DEFAULT '0' COMMENT '[属性]排序号',
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `field` (`field`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_statistics_field
-- ----------------------------
INSERT INTO `st_statistics_field` VALUES ('1', 'all_alliance_totle', '1', 'alliance', '所有盟友总额', 'Count', 'allAllianceTotle', '1', '0', '1', '0');

-- ----------------------------
-- Table structure for st_statistics_group
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_group`;
CREATE TABLE `st_statistics_group` (
                                       `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                       `pid` bigint(20) DEFAULT NULL COMMENT '上级分组',
                                       `name` varchar(50) NOT NULL COMMENT '组名[唯一标记]',
                                       `layout` varchar(26) DEFAULT NULL COMMENT '布局名称',
                                       `title` varchar(26) DEFAULT NULL COMMENT '组标题',
                                       `span` smallint(6) DEFAULT '1' COMMENT '子分组占父分组的列跨度',
                                       `index` smallint(6) DEFAULT '0' COMMENT '分组排序号',
                                       `note` text COMMENT '分组描述',
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_statistics_group
-- ----------------------------
INSERT INTO `st_statistics_group` VALUES ('1', null, '盟友', null, null, '1', '0', null);

-- ----------------------------
-- Table structure for st_statistics_meta
-- ----------------------------
DROP TABLE IF EXISTS `st_statistics_meta`;
CREATE TABLE `st_statistics_meta` (
                                      `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                      `field` varchar(80) NOT NULL COMMENT '数据指标唯一标识符',
                                      `query_sql` text COMMENT '实时查询sql',
                                      `percent` smallint(6) DEFAULT '0' COMMENT '是否显示为百分比',
                                      `icon` varchar(255) DEFAULT NULL COMMENT '图标路径',
                                      `title` varchar(30) DEFAULT NULL COMMENT '图表标题',
                                      `type` varchar(50) DEFAULT NULL COMMENT '字段类型',
                                      `search` varchar(255) DEFAULT NULL COMMENT '搜索字段',
                                      `permission` varchar(50) DEFAULT NULL COMMENT '权限',
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of st_statistics_meta
-- ----------------------------
INSERT INTO `st_statistics_meta` VALUES ('3', 'bonus', 'select c.`盟友`,c.`个人订单总额`,c.`团队订单总额`,c.`所有盟友总额`,c.`平台总利润`,c.`占比`,c.`动态分红`,c.`平均分红`,IFNULL(c.`动态分红`,0)+IFNULL(c.`平均分红`,0) as \'总分红\' \n,c.`分红开始时间`,c.`分红结束时间`,c.`结算状态`\nfrom (\nSELECT a.alliance_name as \'盟友\',IFNULL(pon_sum,0)  as \'个人订单总额\', \nbonus_settlement,\n( case a.bonus_settlement \nwhen 0 then \'未结算\' \nwhen 1 then \'已结算\'\nelse \'结算失败\' end) \nas \'结算状态\',\n( IFNULL(pon_sum,0) + IFNULL(other_sum,0) ) as \'团队订单总额\',\n(select record_value from st_statistics_record) as \'所有盟友总额\',\n(select\n ROUND(sum((item.price-item.cost_price)*item.quantity*JSON_EXTRACT(psp.proportion,\'$.value\')/100.0),2) \nfrom t_order_item item\n     inner JOIN t_order o on item.order_id=o.id and \n            o.created_date>STR_TO_DATE(\n           (select value from t_config_field\n            where field=\'starting_time\'),\'%Y-%m-%d\') \n            and o.status=\'CLOSED_CONFIRMED\'\n     LEFT JOIN t_product_settlement_proportion psp on psp.product_id=item.product_id and psp.type=\'STOCKHOLDER\')\nas \'平台总利润\',\n\nIFNULL(\n format(( IFNULL(pon_sum,0) + IFNULL(other_sum,0) )/(select record_value from st_statistics_record),3) ,\n format(( IFNULL(pon_sum,0) )/(select record_value from st_statistics_record),3) )\n as \'占比\',\n\nROUND((select\n sum((item.price-item.cost_price)*item.quantity*JSON_EXTRACT(psp.proportion,\'$.value\')/100.0)\nfrom t_order_item item\n     inner JOIN t_order o on item.order_id=o.id and \n            o.created_date>STR_TO_DATE(\n           (select value from t_config_field\n            where field=\'starting_time\'),\'%Y-%m-%d\') \n            and o.status=\'CLOSED_CONFIRMED\'\n     LEFT JOIN t_product_settlement_proportion psp on psp.product_id=item.product_id and psp.type=\'STOCKHOLDER\') \n * IFNULL(\n format(( IFNULL(pon_sum,0) + IFNULL(other_sum,0) )/(select record_value from st_statistics_record),4) ,\n format(( IFNULL(pon_sum,0) )/(select record_value from st_statistics_record),4) ),2) \n as \'动态分红\',\n\n (select\n ROUND(sum((item.price-item.cost_price)*item.quantity*JSON_EXTRACT(psp.proportion,\'$.value\')/100.0)*\n   (\n     select\n     value/100.0 \n     from t_config_field \n     where field=\'fixed_proportion\')/\n  (  select count(id) \n     from t_alliance \n     where\n       alliance_type=1 and alliance_ship=0)\n   ,2) \nfrom t_order_item item\n     inner JOIN t_order o on item.order_id=o.id and \n            o.created_date>STR_TO_DATE(\n           (select value from t_config_field\n            where field=\'starting_time\'),\'%Y-%m-%d\') \n            and o.status=\'CLOSED_CONFIRMED\'\n     LEFT JOIN t_product_settlement_proportion psp on psp.product_id=item.product_id and psp.type=\'STOCKHOLDER\')\nas \'平均分红\',\n\n\n (select `value` from t_config_field where field=\'starting_time\')as \'分红开始时间\' ,\n DATE_ADD((SELECT STR_TO_DATE(VALUE, \'%Y-%m-%d\')FROM	t_config_field WHERE field = \'starting_time\'),\n INTERVAL (SELECT VALUE FROM t_config_field	WHERE field = \'settlement_cycle\') MONTH) as \'分红结束时间\' \n\n from \n t_alliance a\n left JOIN\n -- 查询个人\n (\n  SELECT sum(total_price) as pon_sum ,a.id as id,a.invitor_alliance_id as invitor_id\n     FROM t_alliance a \n     LEFT JOIN t_user u on u.id= a.user_id \n     left JOIN t_order o on o.user_id=u.id\n  where\n  o.`status`=\'CLOSED_CONFIRMED\'\n  AND o.created_date>STR_TO_DATE((SELECT value FROM t_config_field WHERE field=\'starting_time\'),\'%Y-%m-%d\')\n  AND o.created_date<DATE_ADD(STR_TO_DATE((SELECT value FROM t_config_field WHERE field=\'starting_time\'),\'%Y-%m-%d\') ,\n interval (SELECT value FROM t_config_field WHERE field=\'settlement_cycle\') MONTH)\n GROUP BY a.id\n ) pon on  a.id=pon.id\nleft JOIN\n-- 查询除个人外团队\n(\n SELECT sum(total) as other_sum,id FROM \n(SELECT a.id, IFNULL(sum(o.total_price), 0) as total \n        FROM t_alliance a  \n        LEFT JOIN t_alliance kid on kid.invitor_alliance_id=a.id\n        LEFT JOIN  t_user u on kid.user_id=u.id\n        LEFT JOIN t_order o on u.id=o.user_id \n        where (o.user_id=kid.user_id or o.user_id=a.user_id)  \n        AND o.`status`=\'CLOSED_CONFIRMED\'\n        AND o.created_date>STR_TO_DATE((SELECT `value` FROM t_config_field WHERE field=\'starting_time\'),\'%Y-%m-%d\')\n        AND o.created_date<DATE_ADD(STR_TO_DATE((SELECT `value` FROM t_config_field WHERE field=\'starting_time\'),\'%Y-%m-%d\') \n        , interval (SELECT `value` FROM t_config_field WHERE field=\'settlement_cycle\') MONTH)\n        GROUP BY a.id\n ) t \nGROUP BY t.id\n)other on  pon.id=other.id\n) c order by `团队订单总额` desc', '0', '', '', 'S,D,D,D,D,P,D,D,D,T,T,S', '盟友', null);
INSERT INTO `st_statistics_meta` VALUES ('5', 'reward', 'select\n        fa.alliance_name as \'收益盟友\',a.alliance_name as \'下单盟友\',so.number as \'订单号\',sum(so.`订单额`) as `订单额`,sum(so.`团队奖励`) as `订单奖励` , so.ct as \'订单时间\'\n        from t_alliance a \n        left join t_alliance fa on fa.id=a.invitor_alliance_id\n        right JOIN \n                 (select o.created_date as ct,o.id as oId,o.order_number as number ,\n												 IFNULL(o.user_id,0) user_id,\n                         IFNULL(ROUND(sum(((item.price-item.cost_price)*item.quantity*JSON_EXTRACT(psp.proportion,\'$.value\')/100)),2),0) as \'团队奖励\',\n                         IFNULL(o.total_price,0) \'订单额\'       \n                  from t_order o \n                  LEFT JOIN t_user u on u.id=o.user_id\n									LEFT JOIN  t_order_item item on item.order_id=o.id\n                  LEFT JOIN t_product_settlement_proportion psp on psp.product_id=item.product_id and psp.type=\'ALLIANCE\' \n                  \n									where \n                     o.`status`=\'CLOSED_CONFIRMED\' \n                   GROUP BY o.id)\n        as so on so.user_id=a.user_id  \n        left JOIN t_user u on u.id=a.user_id\n      \n\n where a.alliance_ship=0 and !ISNULL(fa.alliance_name)\n        group by so.oId\n        ORDER BY fa.alliance_name,so.ct desc ', '0', '', '', 'S,S,S,D,D,T', '收益盟友,订单时间', null);
INSERT INTO `st_statistics_meta` VALUES ('6', 'productReport', 'select t_product.`name` as \'产品\',\nt_alliance.alliance_name as \'下单盟友\',\nt_order.contact_user as \'收货人\',\nt_order.order_number as \'订单号\' ,\nt_order_item.price as \'单价\',\nt_order_item.quantity as \'数量\',\nt_order_item.final_price as \'金额\',\nt_order.freight as \'运费\',\n(\ncase t_order.`status` \nwhen \'CREATED_PAY_PENDING\' then \'待支付\'\nwhen \'CLOSED_PAY_TIMEOUT\'then \'支付超时\'\nwhen \'CLOSED_CANCELED\'then \'已取消\'\nwhen \'PAID_CONFIRM_PENDING\'then \'已支付\'\nwhen \'CONFIRMED_DELIVER_PENDING\'then \'待发货\'\nwhen \'DELIVERING\'then \'发货中\'\nwhen \'DELIVERED_CONFIRM_PENDING\'then \'已发货\'\nwhen \'CANCELED_RETURN_PENDING\'then \'待退货\'\nwhen \'CLOSED_CONFIRMED\'then \'已收货\'\nwhen \'CANCELED_REFUND_PENDING\'then \'待退款\'\nwhen \'CLOSED_REFUNDED\'then \'已退款\'\nwhen \'CONFIRMED_PICK_PENDING\'then \'待取货\'\nend )as \'订单状态\',\n(case payment_type\nwhen  \'WECHAT\' then \'微信支付\'\nwhen \'ALIPAY\'then \'支付宝\'\nwhen \'POINT\'then \'积分支付\'\nwhen \'STORE\'then \'线下支付\'\nwhen \'WALLET\'then \'零钱钱包\'\nwhen \'CASH\'then \'现金\'\nwhen \'CARD\'then \'银行卡\'\nend\n)as \'支付方式\',\nt_order.created_date as \'下单时间\'\nfrom \nt_order_item \nLeft JOIN t_product on t_product.id=t_order_item.product_id\nLEFT JOIN t_order on t_order.id=t_order_item.order_id\nLEFT JOIN t_alliance on t_alliance.user_id=t_order.user_id\nwhere t_order.`status` != \'CLOSED_CANCELED\' and t_order.`status` != \'CLOSED_REFUNDED\' and t_order.`status` != \'CLOSED_PAY_TIMEOUT\'\nORDER BY t_order.created_date desc\n;\n\n', '0', '', '', 'S,S,S,C,D,C,D,D,S,S,T', '产品,下单时间', null);
INSERT INTO `st_statistics_meta` VALUES ('7', 'alliance', '  \nselect wechatNick as \'微信昵称\',t.alliance_name as \'盟友姓名\',\n(case t.alliance_type\n WHEN \"1\" then \"分红盟友\"\nWHEN \"2\" then \"普通盟友\"\n END)   as \'盟友类型\',  \n(case t.alliance_ship \n  WHEN  \"0\" then \"正式盟友\"\n  WHEN  \"1\" then \"非盟友\"\n  WHEN  \"2\" then \"待支付\"\n  WHEN  \"3\" then \"待绑定\"\n  WHEN  \"4\" then \"支付超时\"\n  WHEN  \"5\" then \"状态错误\"\n  WHEN  \"6\" then \"已支付\"\n  WHEN  \"7\" then \"已注销\"\nend)\nas \'状态\',\n\nt.alliance_phone as \'电话\',invitor.alliance_name as \'邀请人\',t.team_count as\'团队人数\',\nt.alliance_ship_time as \'成为盟友时间\',cutOffTime\'周期结束时间\',t.balance as \'库存金额\' from(\nselect (case when t_alliance.alliance_ship=0 or t_alliance.alliance_ship=3 or t_alliance.alliance_ship=2 or t_alliance.alliance_ship=6 then ((case when t_wallet.balance is\n        NULL  then t_alliance.alliance_inventory_amount else t_wallet.balance end) ) else (0 ) end\n        ) as balance\n        ,if(t_alliance.alliance_ship=0,datediff(DATE_ADD(t_alliance.alliance_ship_time,INTERVAL (select value from t_config_field where field=\'experience_time\') MONTH),now()) ,0) as experienceTime,\n        DATE_ADD((select STR_TO_DATE(VALUE,\'%Y-%m-%d\') from t_config_field where field=\'starting_time\')\n        ,INTERVAL (select value from t_config_field where field=\'settlement_cycle\' ) MONTH) as cutOffTime,\n        t_alliance.*,COUNT(children.id)+1 as team_count,kid.alliance_name as invitorName,kid.alliance_phone as\n        invitorPhone,\n        t_user.avatar as wechatAvatar,\n        t_user.name as wechatNick\n        from t_alliance\n        left JOIN t_alliance as children on t_alliance.id=children.invitor_alliance_id\n        LEFT JOIN t_alliance kid ON t_alliance.invitor_alliance_id=kid.id\n        LEFT JOIN t_user ON t_alliance.user_id = t_user.id\n        LEFT JOIN t_wallet on t_wallet.user_id=t_alliance.user_id\n\n GROUP BY t_alliance.id\n      order by t_alliance.creation_time desc\n)\nt\nleft JOIN t_alliance invitor on invitor.id=t.invitor_alliance_id\n\n\n', '0', '', '', 'S,S,S,S,C,S,C,T,T,C', '', null);
INSERT INTO `st_statistics_meta` VALUES ('8', 'teamReward', 'select t.`收益盟友` as \'盟友\',chi.`团队人数`,SUM(`订单额`) as \'团队订单总额\',SUM(`订单奖励`)as 团队订单奖励 from (\r\nselect\r\n        fa.alliance_name as \'收益盟友\',a.alliance_name as \'下单盟友\',so.number as \'订单号\',sum(so.`订单额`) as `订单额`,sum(so.`团队奖励`) as `订单奖励` , so.ct as \'订单时间\',\r\n        a.invitor_alliance_id,a.id\r\n        from t_alliance a \r\n        left join t_alliance fa on fa.id=a.invitor_alliance_id\r\n        right JOIN \r\n                 (select o.created_date as ct,o.id as oId,o.order_number as number ,\r\n												 IFNULL(o.user_id,0) user_id,\r\n                         IFNULL(ROUND(sum(((item.price-item.cost_price)*item.quantity*JSON_EXTRACT(psp.proportion,\'$.value\')/100)),2),0) as \'团队奖励\',\r\n                         IFNULL(o.total_price,0) \'订单额\'       \r\n                  from t_order o \r\n                  LEFT JOIN t_user u on u.id=o.user_id\r\n									LEFT JOIN  t_order_item item on item.order_id=o.id\r\n                  LEFT JOIN t_product_settlement_proportion psp on psp.product_id=item.product_id and psp.type=\'ALLIANCE\' \r\n                  \r\n									where \r\n                     o.`status`=\'CLOSED_CONFIRMED\' \r\n\r\n                      @if[时间$left!=null&& 时间$right!=null] \r\n											\r\n												 and o.created_date > #{时间$left}\r\n                         and o.created_date < #{时间$right}\r\n											@end\r\n                     \r\n                   GROUP BY o.id)\r\n        as so on so.user_id=a.user_id  \r\n        left JOIN t_user u on u.id=a.user_id\r\n where a.alliance_ship=0 and !ISNULL(fa.alliance_name)\r\n        group by so.oId\r\n        ORDER BY fa.alliance_name,so.ct desc \r\n) t \r\nleft join (select count(chi.id)+1 as `团队人数`,a.id from t_alliance a LEFT JOIN t_alliance as  chi on chi.invitor_alliance_id=a.id\r\n     GROUP BY a.user_id ) chi on chi.id=IFNULL(t.invitor_alliance_id,t.id)\r\nGROUP BY `收益盟友`\r\n     \r\n;', '0', null, null, 'S,C,D,D', '时间-T,团队订单奖励', null);