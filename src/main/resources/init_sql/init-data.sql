SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;





-- 菜单项
INSERT INTO `ow_menu` VALUES ('1', null, '首页', '1', '1', '1', '0', null, '1', 'portal', null, 'index.html', 'portal');
INSERT INTO `ow_menu` VALUES ('2', null, '关于i-softto', '2', '1', '1', '1', null, '0', 'about', null, 'about.html', 'about');
INSERT INTO `ow_menu` VALUES ('3', null, '体验中心', '3', '1', '1', '3', null, '0', 'trial', null, 'test.html', 'trial');
INSERT INTO `ow_menu` VALUES ('4', null, '产品中心', '4', '1', '1', '2', null, '1', 'product', null, 'product.html', 'product');
INSERT INTO `ow_menu` VALUES ('5', null, '成分党', '5', '1', '1', '4', null, '0', 'element', null, 'ingredient.html', 'element');
INSERT INTO `ow_menu` VALUES ('6', null, '会员中心', '6', '1', '1', '5', null, '0', 'account', null, 'vipCenter.html', 'account');
INSERT INTO `ow_menu` VALUES ('7', null, '美丽课堂', '7', '1', '1', '6', null, '0', 'course', null, 'beautyClass.html', 'course');
INSERT INTO `ow_menu` VALUES ('8', '2', '品牌介绍', '8', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('9', '2', '品牌故事', '9', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('10', '2', '品牌特色', '10', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('19', '5', '成分党:乳木果', '12', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('27', '6', '加入会员', '15', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('28', '6', '会员臻享', '19', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('29', '6', '在线测试', '18', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('30', '6', '检测报告', '20', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('36', '5', '成分党: 六胜肽', '13', '0', '1', '0', null, '1', null, null, null, null);
INSERT INTO `ow_menu` VALUES ('37', '5', '成分党: 337', '14', '0', '1', '0', null, '1', null, null, null, null);





-- 页面
INSERT INTO `ow_page` VALUES ('1', '首页', 'html', null, '1', 'portal');
INSERT INTO `ow_page` VALUES ('2', '关于i-softto', 'html', null, '1', 'about');
INSERT INTO `ow_page` VALUES ('3', '体验中心', 'html', null, '1', 'trial');
INSERT INTO `ow_page` VALUES ('4', '产品中心', 'html', null, '1', 'product');
INSERT INTO `ow_page` VALUES ('5', '成分党', 'html', null, '1', 'element');
INSERT INTO `ow_page` VALUES ('6', '会员中心', 'html', null, '1', 'account');
INSERT INTO `ow_page` VALUES ('7', '美丽课堂', 'html', null, '1', 'course');
INSERT INTO `ow_page` VALUES ('8', '品牌介绍', 'rtf', null, '1', 'course_introduce');
INSERT INTO `ow_page` VALUES ('9', '品牌故事', 'rtf', null, '1', 'course_story');
INSERT INTO `ow_page` VALUES ('10', '品牌特色', 'rtf', null, '1', 'course_feature');
INSERT INTO `ow_page` VALUES ('11', '页脚', 'footer', null, '1', 'footer');
INSERT INTO `ow_page` VALUES ('12', '成分党: 乳木果', 'rtf', null, '1', '');
INSERT INTO `ow_page` VALUES ('13', '成分党: 六胜肽', 'rtf', null, '0', '');
INSERT INTO `ow_page` VALUES ('14', '成分党: 337', 'rtf', null, '0', '');
INSERT INTO `ow_page` VALUES ('15', '加入会员', 'rtf', null, '0', null);
INSERT INTO `ow_page` VALUES ('18', '在线测试', 'rtf', null, '0', null);
INSERT INTO `ow_page` VALUES ('19', '会员臻享', 'rtf', null, '0', null);
INSERT INTO `ow_page` VALUES ('20', '检测报告', 'rtf', null, '0', null);
INSERT INTO `ow_page` VALUES ('21', '我的美肤方案', 'rtf', null, '0', null);

INSERT INTO `ow_page_text` VALUES ('1', '2', '<div class=\"media-wrap video-wrap\"><video controls=\"\" src=\"https://www.muaskin.com/images/null/31d23d77-0522-4344-b5b1-26d369062460.mp4\"></video></div>');
INSERT INTO `ow_page_text` VALUES ('2', '6', '<div class=\"media-wrap image-wrap\"><img src=\"https://www.muaskin.com/images/null/81187115-8f8f-4202-b2fa-23a931221fdb.jpg\"/></div><p></p>');
INSERT INTO `ow_page_text` VALUES ('5', '12', '<div class=\"media-wrap image-wrap align-center\" style=\"text-align:center\"><img src=\"https://www.muaskin.com/images/null/b0b3eec6-f482-4885-a3e8-c9416ae39af1.jpg\"/></div><p></p>');
INSERT INTO `ow_page_text` VALUES ('8', '13', '<div class=\"media-wrap image-wrap align-center\" style=\"text-align:center\"><img src=\"https://www.muaskin.com/images/null/6504f9d5-7c12-4b72-9601-571cfb976239.jpg\"/></div><p></p>');
INSERT INTO `ow_page_text` VALUES ('9', '10', '<div class=\"media-wrap image-wrap\"><img src=\"https://www.muaskin.com/images/null/c80c1f88-eb24-4c27-b5f7-b047a4499010.png\"/></div><p></p>');
INSERT INTO `ow_page_text` VALUES ('10', '9', '<p style=\"text-align:left;text-indent:2em;\">2004年12月1日，中国最具成长性的上市企业之一一一广西红日股份有限公司，正式更名为索芙特股份有限公司。这标志着索芙特这一驰名的中国化妆品品牌，正以一种全新的姿态展现在世人面前。并以其稳重高速的发展态势，展示着一个时尚化妆品领先者的强大魅力。</p><p style=\"text-align:left;text-indent:2em;\">26年间，索芙特凭借差异化的营销理念在中国日化行业创造了无数的销售奇迹，从畅销中外的海藻减肥香皂到红遍天下的木瓜白肤洗面奶，从畅销十多年的防脱育发香波到众多明星代言的祛斑、瘦身系列。索芙特通过自身的努力在中国日化行业中走出了一条属于自己的路。也奠定了索芙特&quot;中国功能性化妆品第一品牌&quot;的地位。与此同时，索芙特其良好的产品品质得到了广大消费者的认同， &quot;中国驰名商标&quot;、 &quot;中国名牌&quot;、&quot;中国保护消费者权益315信用品牌&quot;等一系列的荣誉纷纷踏至而来。</p>');
INSERT INTO `ow_page_text` VALUES ('11', '14', '<div class=\"media-wrap image-wrap align-center\" style=\"text-align:center\"><img src=\"https://www.muaskin.com/images/null/f3f58533-0ba7-4600-ada4-04800059a046.jpg\"/></div><p></p>');
INSERT INTO `ow_page_text` VALUES ('12', '15', null);
INSERT INTO `ow_page_text` VALUES ('15', '18', '<div class=\"media-wrap image-wrap align-center\" style=\"text-align:center\"><img src=\"https://www.muaskin.com/images/null/4f759eb4-cbfe-47d6-838c-417f27b09827.png\"/></div><div class=\"media-wrap image-wrap\"><img src=\"https://www.muaskin.com/images/null/0e2fd8d6-6a4e-4eab-9d87-50d8cd1d02fd.png\"/></div><p> </p>');
INSERT INTO `ow_page_text` VALUES ('16', '19', null);
INSERT INTO `ow_page_text` VALUES ('17', '20', null);
INSERT INTO `ow_page_text` VALUES ('18', '21', null);
INSERT INTO `ow_page_text` VALUES ('19', '8', '<p>品牌介绍</p>');
INSERT INTO `ow_page_text` VALUES ('20', '1', '<p></p>');
INSERT INTO `ow_page_text` VALUES ('21', '3', '<p>体验中心</p>');
INSERT INTO `ow_page_text` VALUES ('22', '4', '<p></p>');
INSERT INTO `ow_page_text` VALUES ('23', '11', '<p><span style=\"font-size:48px\">-------------------页脚内容展示--------------</span></p>');


-- ----------------------------
-- Table structure for t_config
-- ----------------------------

INSERT INTO `t_config_field_group` (`id`, `pid`, `lang`, `name`, `comment`, `sort`, `type`) VALUES ('2', NULL, 'zh', '数据字典', NULL, '1', 'OPTION');


INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('2', 'product', 'product');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('3', 'element', 'element');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('4', 'banner', 'banner');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('5', 'portal', 'portal');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('6', 'about', 'about');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('7', 'trial', 'trial');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('8', 'account', 'account');
INSERT INTO `t_ad_group` (`id`, `name`, `identifier`) VALUES ('9', 'course', 'course');

INSERT INTO `t_ad` (`id`, `group_id`, `name`, `image`, `type`, `enabled`, `target_url`, `strategy`, `seq`) VALUES ('3', '5', '三步直达美肤', '/portal/images/100000000000000001/0e2ff29d-ecf7-4dd8-b25b-18f23b51995e.jpg', NULL, '1', NULL, NULL, '0');
INSERT INTO `t_ad` (`id`, `group_id`, `name`, `image`, `type`, `enabled`, `target_url`, `strategy`, `seq`) VALUES ('4', '5', '首页轮播-为新生代成分党而生', '/portal/images/100000000000000001/0fe9d859-190a-488c-8aaa-a2fa363da4b9.gif', NULL, '1', NULL, NULL, '0');
INSERT INTO `t_ad` (`id`, `group_id`, `name`, `image`, `type`, `enabled`, `target_url`, `strategy`, `seq`) VALUES ('5', '5', '首页轮播-肌肤管理定制时代', '/portal/images/100000000000000001/738c8dc2-e9b4-41a6-b639-542da8c52967.jpg', NULL, '1', NULL, NULL, '0');
INSERT INTO `t_ad` (`id`, `group_id`, `name`, `image`, `type`, `enabled`, `target_url`, `strategy`, `seq`) VALUES ('6', '2', '产品轮播-产品', '/portal/images/100000000000000001/7d0ce01a-30d8-410c-8f6c-82913ba4e588.png', NULL, '1', NULL, NULL, '0');
INSERT INTO `t_ad` (`id`, `group_id`, `name`, `image`, `type`, `enabled`, `target_url`, `strategy`, `seq`) VALUES ('7', '3', '成分党', '/portal/images/100000000000000001/97c606be-4f94-42ce-a1f0-c0546df78e2c.jpg', NULL, '1', NULL, NULL, '0');

INSERT INTO `meta_entity_patch_machine` (`id`, `entity`, `entity_table_name`, `entity_field_name`, `entity_field_type`, `number_range_min`, `number_range_max`, `permission`) VALUES ('2', 'notice', 't_notice', 'sort_num', 'NUMBER', '1', '10000', NULL);

SET FOREIGN_KEY_CHECKS=1;