SET FOREIGN_KEY_CHECKS=0;

INSERT INTO `sys_perm_group` (`id`, `pid`,`org_id`,`name`, `identifier`) VALUES
('100600000000000001' ,'100000000000000006', '100000000000000001','日志配置', 'contract.management');
INSERT INTO `sys_perm` (`id`, `group_id`, `name`, `identifier`) VALUES
('100000000000006001', '100600000000000001', '查看日志', 'OperationLog.view');


SET FOREIGN_KEY_CHECKS=1;
