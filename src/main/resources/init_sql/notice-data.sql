SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS=0;
INSERT INTO `t_notice` (`id`, `author`, `title`, `content`, `type`, `status`, `enabled`, `create_time`, `update_time`, `end_time`, `sort_num`) VALUES ('1196596850284810241', 'admin', '系统公告', '系统将于2019/12月3号进行维护，期间将不能使用部分功能', 'System', 'Draft', '1', '2019-05-01 09:11:35', NULL, '2019-11-19 09:06:48', '1');
INSERT INTO `t_notice` (`id`, `author`, `title`, `content`, `type`, `status`, `enabled`, `create_time`, `update_time`, `end_time`, `sort_num`) VALUES ('1196596948829982721', 'admin', '内部公告', '部分库存信息有误，各负责人请检查下数据', 'Internal', 'Draft', '1', '2019-09-01 09:11:59', NULL, '2019-10-01 09:06:48', '2');
INSERT INTO `t_notice` (`id`, `author`, `title`, `content`, `type`, `status`, `enabled`, `create_time`, `update_time`, `end_time`, `sort_num`) VALUES ('1196596986360614914', 'admin', '外部公告', '悠品6折大促销，欢迎选购', 'External', 'Draft', '1', '2019-09-01 09:12:08', NULL, '2019-12-01 09:06:48', '3');


SET FOREIGN_KEY_CHECKS=1;