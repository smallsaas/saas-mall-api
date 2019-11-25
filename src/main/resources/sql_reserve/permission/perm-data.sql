

INSERT INTO sys_perm_group(`id`, `org_id`, `pid`, `identifier`, `name`)
VALUES ('100000000000000008', '100000000000000001', '100000000000000001', 'config.management', '配置管理');

INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000008005' , '100000000000000008', 'Config.view',  '查看配置', '0');
INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000008007' , '100000000000000008', 'Config.edit',  '修改配置', '0');

 INSERT INTO sys_perm_group(`id`, `org_id`, `pid`, `identifier`, `name`)
 VALUES('100000000000000009','100000000000000001','100000000000000001', 'product_management','产品管理');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009001', '100000000000000009', 'Product.edit',  '编辑产品', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009002', '100000000000000009', 'Product.delete','删除产品', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009003', '100000000000000009', 'Product.view',  '查看产品 ', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009004', '100000000000000009', 'Product.new',   '新增产品 ', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009017', '100000000000000009', 'Product.status','产品上下架 ', '0');


 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009005', '100000000000000009', 'ProductCategory.edit',  '编辑产品类别', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009006', '100000000000000009', 'ProductCategory.delete','删除产品类别', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009007', '100000000000000009', 'ProductCategory.view',  '查看产品类别', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009008', '100000000000000009', 'ProductCategory.new',   '新增产品类别', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009009', '100000000000000009', 'ProductTag.edit',  '编辑产品标签', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009010', '100000000000000009', 'ProductTag.delete','删除产品标签', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009011', '100000000000000009', 'ProductTag.view',  '查看产品标签', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009012', '100000000000000009', 'ProductTag.new',   '新增产品标签', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009013', '100000000000000009', 'FareTemplate.edit',  '编辑运费模板', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009014', '100000000000000009', 'FareTemplate.delete','删除运费模板', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009015', '100000000000000009', 'FareTemplate.view',  '查看运费模板', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009016', '100000000000000009', 'FareTemplate.new',   '新增运费模板', '0');

  INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009018', '100000000000000009', 'Brand.edit',  '编辑产品品牌', '0');
  INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009019', '100000000000000009', 'Brand.delete','删除产品品牌', '0');
  INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009020', '100000000000000009', 'Brand.view',  '查看产品品牌', '0');
  INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000009021', '100000000000000009', 'Brand.new',   '新增产品品牌', '0');

 INSERT INTO sys_perm_group(`id`, `org_id`, `pid`, `identifier`, `name`)
 VALUES('100000000000000010','100000000000000001','100000000000000001', 'front_user_management','微信用户管理');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000010001', '100000000000000010', 'FrontUser.view',  '查看微信用户 ', '0');

 INSERT INTO sys_perm_group(`id`, `org_id`, `pid`, `identifier`, `name`)
 VALUES('100000000000000011','100000000000000001','100000000000000001', 'order_management','订单管理');

 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011002', '100000000000000011', 'Order.delete','删除订单', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011003', '100000000000000011', 'Order.view',  '查看订单 ', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011004', '100000000000000011', 'Order.new',   '新增订单 ', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011005', '100000000000000011', 'Express.edit',  '编辑快递', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011006', '100000000000000011', 'Express.delete','删除快递', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011007', '100000000000000011', 'Express.view',  '查看快递', '0');
 INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011008', '100000000000000011', 'Express.new',   '新增快递', '0');

/*  INSERT INTO sys_perm(`id`, `group_id`, `identifier`, `name`,`tag`) VALUES('100000000000011009', '100000000000000011', 'Order.status',   '修改订单状态 ', '0');*/



