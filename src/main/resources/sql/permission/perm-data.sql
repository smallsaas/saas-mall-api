

INSERT INTO sys_perm_group(`id`, `org_id`, `pid`, `identifier`, `name`)
VALUES ('100000000000000008', '100000000000000001', '100000000000000001', 'config.management', '配置管理');
INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000008001',  '100000000000000008', 'ConfigGroup.edit',  '操作-编辑配置组', '0');
INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000008002' , '100000000000000008', 'ConfigGroup.delete','操作-删除配置组', '0');
INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000008003' , '100000000000000008', 'ConfigGroup.view',  '操作-查看配置组', '0');
INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000008004' , '100000000000000008', 'ConfigGroup.new',   '操作-新增配置组', '0');
INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000008005' , '100000000000000008', 'Config.view',  '操作-查看配置', '0');
INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000008006' , '100000000000000008', 'Config.new',   '操作-新增配置', '0');

 INSERT INTO sys_perm_group(`id`, `org_id`, `pid`, `identifier`, `name`)
 VALUES('100000000000000009','100000000000000001','100000000000000001', 'product_management','产品管理');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009001', '100000000000000009', 'Product.edit',  '操作-编辑产品', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009002', '100000000000000009', 'Product.delete','操作-删除产品', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009003', '100000000000000009', 'Product.view',  '操作-查看产品 ', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009004', '100000000000000009', 'Product.new',   '操作-新增产品 ', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009005', '100000000000000009', 'ProductCategory.edit',  '操作-编辑产品类别', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009006', '100000000000000009', 'ProductCategory.delete','操作-删除产品类别', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009007', '100000000000000009', 'ProductCategory.view',  '操作-查看产品类别', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009008', '100000000000000009', 'ProductCategory.new',   '操作-新增产品类别', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009009', '100000000000000009', 'ProductTag.edit',  '操作-编辑产品标签', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009010', '100000000000000009', 'ProductTag.delete','操作-删除产品标签', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009011', '100000000000000009', 'ProductTag.view',  '操作-查看产品标签', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009012', '100000000000000009', 'ProductTag.new',   '操作-新增产品标签', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009013', '100000000000000009', 'FareTemplate.edit',  '操作-编辑运费模板', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009014', '100000000000000009', 'FareTemplate.delete','操作-删除运费模板', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009015', '100000000000000009', 'FareTemplate.view',  '操作-查看运费模板', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009016', '100000000000000009', 'FareTemplate.new',   '操作-新增运费模板', '0');



 INSERT INTO sys_perm_group(`id`, `org_id`, `pid`, `identifier`, `name`)
 VALUES('100000000000000010','100000000000000001','100000000000000001', 'front_user_management','微信用户管理');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000010001', '100000000000000010', 'FrontUser.view',  '操作-查看微信用户 ', '0');

 INSERT INTO sys_perm_group(`id`, `org_id`, `pid`, `identifier`, `name`)
 VALUES('100000000000000011','100000000000000001','100000000000000001', 'order_management','订单管理');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011001', '100000000000000011', 'Order.edit',  '操作-编辑订单', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011002', '100000000000000011', 'Order.delete','操作-删除订单', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011003', '100000000000000011', 'Order.view',  '操作-查看订单 ', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011004', '100000000000000011', 'Order.new',   '操作-新增订单 ', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011005', '100000000000000011', 'Express.edit',  '操作-编辑快递', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011006', '100000000000000011', 'Express.delete','操作-删除快递', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011007', '100000000000000011', 'Express.view',  '操作-查看快递', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011008', '100000000000000011', 'Express.new',   '操作-新增快递', '0');

/*  INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011009', '100000000000000011', 'Order.status',   '操作-修改订单状态 ', '0');*/



