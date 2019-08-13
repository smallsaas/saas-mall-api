SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Records of t_config_group
-- ----------------------------
INSERT INTO `t_config_group` VALUES (1, '商城配置',0,NULL);
INSERT INTO `t_config_group` VALUES (2, '微信配置',0,NULL);
INSERT INTO `t_config_group` VALUES (3, '其他配置',0,NULL);
INSERT INTO `t_config_group` VALUES (4, '商品配置',0,NULL);
INSERT INTO `t_config_group` VALUES (5, '支付宝配置',0,NULL);
INSERT INTO `t_config_group` VALUES (10, '优惠券配置',0,NULL);
INSERT INTO `t_config_group` VALUES (20, '商城链接配置',0,NULL);
INSERT INTO `t_config_group` VALUES (21, '商城链接小程序页面配置',0,NULL);
INSERT INTO `t_config_group` VALUES (30, '打印配置',0,NULL);
INSERT INTO `t_config_group` VALUES (100, '内部系统访问配置',0,NULL);
INSERT INTO `t_config_group` VALUES (400, '合作伙伴配置',0,NULL);
INSERT INTO `t_config_group` VALUES (500, '商家配置',0,NULL);

-- ----------------------------
-- Records of t_config
-- ----------------------------
INSERT INTO `t_config` VALUES (1, NULL, 1, '最迟可退货时间', 'mall.latest_return_time', 'int', '7', '', 1, '单位为天',0,NULL);
INSERT INTO `t_config` VALUES (2, NULL, 1, '分销商最低销售额度', 'mall.lowest_sales_quota', 'int', '1000', '', 0, '注册不满100天，额度放宽',0,NULL);
INSERT INTO `t_config` VALUES (3, NULL, 1, '返点级别', 'mall.rebates_level', 'int', '2', '', 0, '级别等级相关',0,NULL);
INSERT INTO `t_config` VALUES (4, NULL, 1, '积分兑换金额', 'mall.point_exchange_rate', 'int', '100', 'sys', 0, '1元等于多少积分',0,NULL);
INSERT INTO `t_config` VALUES (5, NULL, 1, '包邮最低额度', 'mall.free_mail_minimum_amount', 'int', '998', '', 0, '',0,NULL);
INSERT INTO `t_config` VALUES (6, NULL, 1, '分销商提款条件', 'mall.drawing_conditions', 'int', '10', '', 0, '拥金余额要不少于该数值',0,NULL);
INSERT INTO `t_config` VALUES (7, NULL, 1, '自动确认收货期限', 'mall.auto_validation_receiving_deadline', 'int', '7', '', 1, '如分销商不主动推迟日期',0,NULL);
INSERT INTO `t_config` VALUES (8, NULL, 1, '支付超时时间', 'mall.pay_order_timeout', 'int', '15', '', 1, '待支付的订单超过这个时间限制后自动关闭',0,NULL);
INSERT INTO `t_config` VALUES (9, NULL, 1, '分销商申请自动审核开关', 'mall.seller_apply_auto_approve', 'boolean', 'true', '', 0, '分销商申请自动审核开关',0,NULL);
INSERT INTO `t_config` VALUES (10, NULL, 1, '新用户注册自动成为分销商开关', 'mall.seller_auto_sellership', 'boolean', 'true', '', 1, '新用户注册自动成为分销商开关',0,NULL);
INSERT INTO `t_config` VALUES (11, NULL, 1, '分销商达到人数自动升级为合伙人开关', 'mall.seller_auto_promote_to_partner', 'boolean', 'true', '', 0, '分销商达到人数自动升级为合伙人开关',0,NULL);
INSERT INTO `t_config` VALUES (12, NULL, 1, '产品售罄自动下架开关', 'mall.auto_offsell', 'boolean', 'false', '', 1, '当产品售罄后,自动把该产品下架',0,NULL);
INSERT INTO `t_config` VALUES (13, NULL, 1, '首页推荐产品轮询时间', 'mall.promoted_product_carousel', 'int', '60', '', 1, '首页推荐产品轮询时间, 每过这个时间就轮换一批首页产品。单位分钟。最小30分钟。',0,NULL);
INSERT INTO `t_config` VALUES (14, NULL, 1, '新建订单开关', 'mall.order_created_enable', 'boolean', 'true', '', 1, '允许用户新建订单, 用于临时关闭下单功能。',0,NULL);
INSERT INTO `t_config` VALUES (15, NULL, 1, '下单默认选中优惠券开关', 'mall.auto_select_coupon', 'boolean', 'true', '', 1, '下单结算时, 如果用户有可用的优惠券, 默认选择一张优惠券进行结算。',0,NULL);
INSERT INTO `t_config` VALUES (16, NULL, 3, '默认角色', 'misc.customer_role_id', 'int', '4', '', 1, '用户注册时默认添加的角色号。',0,NULL);
INSERT INTO `t_config` VALUES (17, NULL, 3, 'API服务URL', 'misc.api_url', 'String', 'https://www.muaskin.com', 'sys', 1, 'API服务提供者的web service URL前缀。',0,NULL);
INSERT INTO `t_config` VALUES (18, NULL, 3, '快递100API查询公司编号', 'express.customer', 'String', 'C65586323A0FD12182A53C7BF0C1C828', '', 1, '使用快递100API查询物流信息使用的公司编号,当使用企业版时需要这个字段，详见www.kuaidi100.com',0,NULL);
INSERT INTO `t_config` VALUES (19, NULL, 3, '快递100API查询Key', 'express.key', 'String', 'fdhPBUDq7946', '', 1, '使用快递100API查询物流信息使用的密钥，详见www.kuaidi100.com',0,NULL);
INSERT INTO `t_config` VALUES (20, NULL, 3, '关注我们文章地址', 'follow.us.url', 'String', NULL, 'sys', 1, '首页关注我们功能跳转到的公众号文章的地址',0,NULL);
INSERT INTO `t_config` VALUES (21, NULL, 100, '用户名', 'sys.auth.username', 'String', 'sys', '', 1, 'BASIC验证的用户名',0,NULL);
INSERT INTO `t_config` VALUES (22, NULL, 100, '密码', 'sys.auth.password', 'String', 'sys', '', 1, 'BASIC验证的密码',0,NULL);
INSERT INTO `t_config` VALUES (23, NULL, 100, '允许访问IP列表', 'sys.auth.allowips', 'String', '', '', 1, '允许访问本系统的内部系统IP列表. 以逗号分隔，如192.168.0.1,192.168.0.2. 如果为空则不进行IP匹配判断。',0,NULL);
INSERT INTO `t_config` VALUES (24, NULL, 2, 'token令牌', 'wx.token', 'String', 'Muaskin2018', 'sys', 1, '微信公众号后台的token. 进入 mp.weixin.qq.com 下面的开发-基本配置可以查看和修改。',0,NULL);
INSERT INTO `t_config` VALUES (25, NULL, 2, '启用消息加密', 'wx.encrypt_message', 'boolean', 'false', '', 1, '启用消息加解密',0,NULL);
INSERT INTO `t_config` VALUES (26, NULL, 2, '消息加解密密钥', 'wx.encoding_aes_key', 'String', 'GHw46OOeHi9ydjCKRlsIdN9bJDeifn67udzx1vBmIoE', 'sys', 1, '消息加解密密钥',0,NULL);
INSERT INTO `t_config` VALUES (27, NULL, 2, '应用ID', 'wx.app_id', 'String', 'wx117676b671891683', 'sys', 1, '应用ID',0,NULL);
INSERT INTO `t_config` VALUES (28, NULL, 2, '应用密钥', 'wx.app_secret', 'String', '43efe172aa9f12632ece0e603a8b301a', 'sys', 1, '应用密钥',0,NULL);
INSERT INTO `t_config` VALUES (29, NULL, 2, '域名', 'wx.host', 'String', 'https://www.muaskin.com/wx', 'sys', 1, '微信应用部署的服务器域名',0,NULL);
INSERT INTO `t_config` VALUES (30, NULL, 2, '商户ID', 'wx.partner_id', 'String', '1504236991', 'sys', 1, '微信支付商户号',0,NULL);
INSERT INTO `t_config` VALUES (31, NULL, 2, '商户Key', 'wx.partner_key', 'String', '441ed2ea9e9b4e83a8bcc12df066b533', 'sys', 1, '微信支付商户密钥',0,NULL);
INSERT INTO `t_config` VALUES (32, NULL, 2, '证书路径', 'wx.cert_path', 'String', '/usr/local/tomcat/config/apiclient_cert2.p12', '', 1, '证书路径,请前往 微信配置管理菜单 进行上传更新', 1,NULL);
INSERT INTO `t_config` VALUES (33, NULL, 10, '分享链接有限时间', 'coupon.share_link_valid_days', 'int', '30', '', 0, '单位为天',0,NULL);
INSERT INTO `t_config` VALUES (34, NULL, 10, '获得红包时间', 'coupon.pocket_time', 'int', '24', '', 0, '单位为小时, 在这个时间内可以获得红包, 与 获得红包的订单数 配合使用',0,NULL);
INSERT INTO `t_config` VALUES (35, NULL, 10, '获得红包的订单数', 'coupon.pocket_order_count', 'int', '2', '', 0, '超过这个限制的订单不发红包, 与 获得红包时间 配合使用',0,NULL);
INSERT INTO `t_config` VALUES (36, NULL, 10, '分享红包标题', 'coupon.pocket_share_title', 'String', NULL, 'sys', 0, '分享红包到朋友圈或发给朋友时显示的标题',0,NULL);
INSERT INTO `t_config` VALUES (37, NULL, 10, '分享红包描述', 'coupon.pocket_share_desc', 'String', NULL, 'sys', 0, '分享红包到朋友圈或发给朋友时显示的描述',0,NULL);
INSERT INTO `t_config` VALUES (38, NULL, 10, '快过期优惠券通知时间', 'coupon.overdue_time_interval', 'int', '24', '', 1, '单位为小时，优惠券将要过期时，发送微信消息通知用户',0,NULL);
INSERT INTO `t_config` VALUES (39, NULL, 400, '线下经销商申请成为皇冠商开关', 'partner.can_apply_crown', 'boolean', 'false', 'sys', 0, '线下经销商申请成为皇冠商开关',0,NULL);
INSERT INTO `t_config` VALUES (40, NULL, 400, '线下经销商扫码申请成为皇冠商开关', 'partner.can_code_apply_crown', 'boolean', 'false', '', 0, '线下经销商扫码申请成为皇冠商开关',0,NULL);
INSERT INTO `t_config` VALUES (41, NULL, 400, '线下经销商申请成为皇冠商文本', 'partner.apply_crown_text', 'String', NULL, 'sys', 0, '线下经销商申请成为皇冠商的描述文本，可输入\\n表示换行',0,NULL);
INSERT INTO `t_config` VALUES (42, NULL, 400, '授权线下经销商文本', 'partner.create_physical_seller_text', 'String', NULL, 'sys', 0, '线下经销商申请成为皇冠商的描述文本，可输入\\n表示换行',0,NULL);
INSERT INTO `t_config` VALUES (43, NULL, 400, '新晋线下皇冠商进货时间', 'partner.new_physical_seller_wholesale_time', 'int', '4', '', 0, '线下经销商被批准成为线下皇冠商后，必须在规定小时内完成一定额的批发订单的时间，单位小时。',0,NULL);
INSERT INTO `t_config` VALUES (44, NULL, 400, '新晋线下皇冠商最小进货额', 'partner.new_physical_seller_wholesale_amount', 'int', '2000', '', 0, '线下经销商被批准成为线下皇冠商后，必须在规定小时内完成一定额的批发批发订单的最小额度，单位元。',0,NULL);
INSERT INTO `t_config` VALUES (45, NULL, 400, '线下皇冠商申请自动审核开关', 'partner.auto_audit_physical_crown', 'boolean', 'false', '', 0, '线下皇冠商申请自动审核开关',0,NULL);
INSERT INTO `t_config` VALUES (46, NULL, 400, '线下皇冠商申请自动审核次数', 'partner.auto_audit_physical_crown_times', 'int', '3', '', 0, '当自动审核次数达到指定次数后，需要转人工审核',0,NULL);
INSERT INTO `t_config` VALUES (47, NULL, 10, '分享链接拿红包开关', 'coupon.share_link_enabled', 'boolean', 'false', 'sys', 0, '一旦打开本开关，下单后会弹出分享链接拿红包',0,NULL);
INSERT INTO `t_config` VALUES (48, NULL, 1, '显示产品类别菜单开关', 'mall.show_product_category_menu', 'boolean', 'true', 'sys', 0, '显示产品类别菜单开关',0,NULL);
INSERT INTO `t_config` VALUES (49, NULL, 500, '是否允许平台零售', 'merchant.allow_platform_sale', 'boolean', 'true', 'sys', 0, '是否允许平台零售, 如果设为不允许，则只有进入指定的商家店铺才可以下单',0,NULL);
INSERT INTO `t_config` VALUES (50, NULL, 500, '是否需要营业执照', 'merchant.license_req', 'boolean', 'true', '', 0, '是否需要营业执照',0,NULL);
INSERT INTO `t_config` VALUES (51, NULL, 500, '是否需要身份证', 'merchant.idcard_req', 'boolean', 'true', '', 0, '是否需要身份证',0,NULL);
INSERT INTO `t_config` VALUES (52, NULL, 500, '是否需要保证金', 'merchant.deposit_req', 'boolean', 'true', '', 0, '是否需要保证金',0,NULL);
INSERT INTO `t_config` VALUES (53, NULL, 500, '是否允许自主申请', 'merchant.allow_apply', 'boolean', 'false', '', 0, '是否允许用户自主申请成为商家',0,NULL);
INSERT INTO `t_config` VALUES (54, NULL, 4, '分区1名称', 'product.partner_level_zone_1', 'String', '零元区', '', 1, '分区1名称',0,NULL);
INSERT INTO `t_config` VALUES (55, NULL, 4, '分区2名称', 'product.partner_level_zone_2', 'String', '精品区', '', 1, '分区1名称',0,NULL);
INSERT INTO `t_config` VALUES (56, NULL, 4, '分区3名称', 'product.partner_level_zone_3', 'String', '特价区', '', 1, '分区1名称',0,NULL);
INSERT INTO `t_config` VALUES (57, NULL, 4, '显示分成设置开关', 'product.show_settlement_setting', 'boolean', 'false', '', 1, '显示分成设置',0,NULL);
INSERT INTO `t_config` VALUES (58, NULL, 1, '自动发货开关', 'mall.auto_deliver_order', 'boolean', 'false', 'sys', 0, '支付的订单自动变成发货状态',0,NULL);
INSERT INTO `t_config` VALUES (59, NULL, 2, '小程序AppId', 'wx.wxa_appid', 'String', 'wx335c2191e370c14e', 'sys', 1, '微信小程序APP ID',0,NULL);
INSERT INTO `t_config` VALUES (60, NULL, 2, '小程序密钥', 'wx.wxa_app_secret', 'String', '7cd4fec03bb529625eb64a39b9560c4a', 'sys', 1, '微信小程序APP密钥',0,NULL);
INSERT INTO `t_config` VALUES (61, NULL, 2, '登录自动注册', 'wx.auto_reg', 'boolean', 'true', 'sys', 1, '微信登录后自动注册，如果设为false，则需要用户填手机号进行注册',0,NULL);
INSERT INTO `t_config` VALUES (62, NULL, 4, '显示规格设置开关', 'product.show_specification_setting', 'boolean', 'false', '', 1, '显示规格设置开关',0,NULL);
INSERT INTO `t_config` VALUES (63, NULL, 1, '极速送达运费', 'mall.flash_freight', 'int', '10', 'sys', 1, '单位为元',0,NULL);
INSERT INTO `t_config` VALUES (64, NULL, 20, '商城首页', 'mall.url.home', 'String', '', '', 1, '公众号前端商城首页链接地址',0,NULL);
INSERT INTO `t_config` VALUES (65, NULL, 20, '产品详情页', 'mall.url.product_detail', 'String', '/cosmetics/productDetails?id={0}', '', 1, '公众号前端产品详情页链接地址',0,NULL);
INSERT INTO `t_config` VALUES (66, NULL, 20, '我的订单页', 'mall.url.my_order', 'String', '/order/myOrders', '', 1, '公众号前端我的订单链接地址',0,NULL);
INSERT INTO `t_config` VALUES (67, NULL, 20, '订单详情页', 'mall.url.order_detail', 'String', '/order/myOrderDetail?id={0}', '', 1, '公众号前端订单详情页链接地址',0,NULL);
INSERT INTO `t_config` VALUES (68, NULL, 20, '个人中心页', 'mall.url.personal_center', 'String', '/personalCenter', '', 1, '公众号前端个人中心页链接地址',0,NULL);
INSERT INTO `t_config` VALUES (69, NULL, 20, '门店列表页', 'mall.url.store_list', 'String', '/skinHousekeeper/reservation', '', 1, '公众号前端门店列表页链接地址',0,NULL);
INSERT INTO `t_config` VALUES (70, NULL, 21, '商城首页', 'mall.wxa.url.home', 'String', '/pages/index/index', '', 1, '小程序首页页面路径',0,NULL);
INSERT INTO `t_config` VALUES (71, NULL, 30, '订单打印LOGO', 'print.order.logo', 'String', NULL, '', 1, '订单打印LOGO',0,NULL);
INSERT INTO `t_config` VALUES (72, NULL, 30, '订单打印标题', 'print.order.title', 'String', 'i-Softto智慧美妆', '', 1, '订单打印标题',0,NULL);
INSERT INTO `t_config` VALUES (73, NULL, 2, '移动应用AppId', 'wx.app_appid', 'String', 'wxf067e41e188997d1', '', 1, '开放平台移动应用APP ID',0,NULL);
INSERT INTO `t_config` VALUES (74, NULL, 2, '移动应用密钥', 'wx.app_app_secret', 'String', '310f532ef4d9de66021da9229589ade8', '', 1, '开放平台移动应用APP密钥',0,NULL);
INSERT INTO `t_config` VALUES (75, NULL, 2, '移动应用名称', 'wx.app_name', 'String', 'Muaskin', '', 1, '开放平台移动应用在应用市场上的APP名字',0,NULL);
INSERT INTO `t_config` VALUES (76, NULL, 2, '移动应用商家ID', 'wx.app_partner_id', 'String', '1517302691', '', 1, '开放平台移动应用商家ID',0,NULL);
INSERT INTO `t_config` VALUES (77, NULL, 2, '移动应用商家密钥', 'wx.app_partner_key', 'String', '441ed2ea9e9b4e83a8bcc12df066b533', '', 1, '开放平台移动应用商家密钥',0,NULL);
INSERT INTO `t_config` VALUES (78, NULL, 5, '应用ID', 'ali.app_id', 'String', '2018102361821326', '', 1, '应用ID',0,NULL);
INSERT INTO `t_config` VALUES (79, NULL, 5, '应用密钥', 'ali.app_secret', 'text', 'MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCXXed+1b9rEb0fY1l8zkfXhbn5Pfd76wHfzp0e30Ps3zym0gMfsWVXNyMBF3XFYTFPPt32MtpqNFlnKQXzkDt/EgWpd2kD5aK8Q18RTkNy+Yhp9A5dOv/4H6d+KijNe+3SKMamtg4Lx9GxkyvfiiFjpvHivtisd46YlU+e3RJpLkzv7wL0c21SjjYeI9DJEzEpi5K9I5CGqrDu4L+YUc1ZePbq3AhIfTZnTBB4YI8eCTpOHvreXWIVZw2R1mXfY3V5N+ESV3laE5Jbm82N23z8XiT9chitOjPK/lQcTNQiRkNR3Fe7mm2nXxEIe3WgKv9l/4yXll509EOI73YXWtylAgMBAAECggEAS6XJmRDYHnl6DCLJyV8KdoLFo/O9KLgVcrW+vnwUZWBX3oNcvk0Y+ZJ7swL3f9KIIzOnGHDnyWYqPC07ZTNzGJl4LO6ZlDICt5XwACUd/msJKvKm7x8aZ/Xh7mLBi5hhDcQFK7IWqPqPKPEFXy2YbEY14v1AKkmCAW21og6YMeoEPWy0KFnZOrc/2K+A6cLqo+O/gY52k0DLDPss3vRqEExBzM2gN2o2MwploR393Hbo3y7VKJK9zgumgz558zzuXCi4Ex/a4DW5kbsQGVhQhrfXfj/VdMscJ62/o7+Xh2pNZeYfP0oCMUbtY6sN7hma8k41x4Cl+fyjtjRPedoKAQKBgQDhsIoqtoxu+QJErptN2nUnp43r/QDP+TRAX462+oUCrANCjHD3WqQf/CqEG2W0X7Qqn2emvfagPo+M9Xd0egKrpQPlC2lHc3L/tVn+tpFIBakAoYxfRGQhagH1l+lsLylCmKq0HCyROZgY64KZMBNZyHyXw3QxUtaCGG7Ao9L8JQKBgQCrshBlLk8nZTpawAE94f7mDjlO8zzNV4dh8A7rDBMk4ptKk+Z7Wjzu4/6E6xRDw7om2z8jW9/tSFvlAljqTR4u09vJOUo8r8LxHmqf9vsX8z3/+XOInd0nT9yOJvn/Cs4d2jR3qXSGPxtCqIRTlb79IfIpsOcxQ1Rqcp7poVI2gQKBgQClcE0IHIL7QivIfxo3SsGAjRG7AN6clbgYzDOIrEHegItvOBYDLH2NOMNNzeuS+mjOqcVIdI4aT2HZWYL0bhARFMizGNdW2ildiunqjpgW7JdDcCi/GRoxaE0BZBdnB3c+az0PBGwjFM4KznEQrC4zLYUvlsZQ9cFq4lAlhLG/xQKBgCz61CK9tAzdDyGRJYIhv5ZjaY4OWQJuiNAWhMH9AtLp7sbl4j60kDwBTL9jmoZ6Mz1UuMC5o/tUtoZTTBntpBeedvjLYnBtl0N1tXc8y+ElXzu9DRBgUvymhmBTQ7EWEpNtg8tJgHZe9/RJk4kWNNe52egkKR0Vx3qvloQcOB6BAoGBANU9eOeJQW/jlMCAaAXa/zFAtLfsvO3aQ5jAddq/gG5QW7zVH5UAZCgC7wkuOT96f9fDeJN/fpURhrpu6dLN/3rIB8XlwQW2350Gg4M1WJzUrLpNwzn71b81de6SmXSrHQz+zaNmkz5YhZOHNVnbtzGBQMHl6+AoUllDWY1TO4++', '', 1, '应用密钥',0,NULL);
INSERT INTO `t_config` VALUES (80, NULL, 5, '支付宝公钥', 'ali.alipay_public_key', 'text', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkzj0Dx9wqBjQZninzD1nSUEgA10k0F7zuFEvhhfwTWYWEAk5KZNYrNt7bguOODnXaYn0Fp0llQM7CnM8zR0w/HarUZ1QPDnajxpCeJ5zhnZRMzk9e113wh/6vmyHzZM1mE3DNkZgtt//H9VQf4FFJ6FtqLsLsv8QF7IKLAEWwmweIoO1G3kQv+Hn4fwUA5Q+PlrJPuUda0nVF/XNhJ/nrNEy6VDKY4gN5ckuHcRALz80HiOA34e79OWqOAnxuDidk7kC8KsLgRe+4KTbPcVN0vBH774PohRfFBADDht+cZOosUaJ/IQPxk3WyMjxKBQ6NQjUN6FzHZTccNdE3imYCQIDAQAB', '', 1, '支付宝公钥，不配置则使用默认值，一旦配置就使用该值覆盖',0,NULL);
INSERT INTO `t_config` VALUES (81, NULL, 1, '邀请二维码信息图片', 'mall.qrcode.info_url', 'String', 'https://www.muaskin.com/wx/static/static/noTest.f3c8af24.png', '', 1, '邀请二维码信息图片',0,NULL);
INSERT INTO `t_config` VALUES (82, NULL, 1, '邀请二维码LOGO图片', 'mall.qrcode.logo_url', 'String', 'https://www.muaskin.com/images/avatar/72ef0f7992d3c41cf559eeed46d37f81.png', '', 1, '邀请二维码LOGO图片',0,NULL);
INSERT INTO `t_config` VALUES (83, NULL, 1, '邀请二维码跳转链接', 'mall.invitationqr.redirecturl', 'String', '', 'sys', 1, '邀请二维码扫码后跳转到的外部链接',0,NULL);

SET FOREIGN_KEY_CHECKS = 1;

