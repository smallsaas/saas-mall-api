-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: malldb
-- ------------------------------------------------------
-- Server version	5.7.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `schema_version`
--

DROP TABLE IF EXISTS `schema_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schema_version` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `script` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `schema_version_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schema_version`
--

LOCK TABLES `schema_version` WRITE;
/*!40000 ALTER TABLE `schema_version` DISABLE KEYS */;
INSERT INTO `schema_version` VALUES (1,'20141210233500','createMenuTable','SQL','V20141210233500__createMenuTable.sql',-66738022,'root','2019-12-16 02:39:27',59,1),(2,'20150421172100','createWidgetTable','SQL','V20150421172100__createWidgetTable.sql',-869868948,'root','2019-12-16 02:39:27',44,1),(3,'20160307105500','initIdentityTable','SQL','V20160307105500__initIdentityTable.sql',-1982794176,'root','2019-12-16 02:39:28',383,1),(4,'20160307124300','IdentityDomainPermission','SQL','V20160307124300__IdentityDomainPermission.sql',-44224589,'root','2019-12-16 02:39:28',3,1),(5,'20160307150000','IdentityApplicationPermission','SQL','V20160307150000__IdentityApplicationPermission.sql',-2006834582,'root','2019-12-16 02:39:28',36,1),(6,'20160308135000','IdentityApplicationMenu','SQL','V20160308135000__IdentityApplicationMenu.sql',1216914737,'root','2019-12-16 02:39:28',9,1),(7,'20160309150000','CreateProductTables','SQL','V20160309150000__CreateProductTables.sql',318330009,'root','2019-12-16 02:39:29',1059,1),(8,'20160309160000','ProductApplicationMenu','SQL','V20160309160000__ProductApplicationMenu.sql',303975842,'root','2019-12-16 02:39:29',36,1),(9,'20160309163000','ProductApplicationPermission','SQL','V20160309163000__ProductApplicationPermission.sql',283637799,'root','2019-12-16 02:39:29',70,1),(10,'20160310090000','PcdDomainCreateTable','SQL','V20160310090000__PcdDomainCreateTable.sql',1205648385,'root','2019-12-16 02:39:29',66,1),(11,'20160310091000','PcdData','SQL','V20160310091000__PcdData.sql',1544322398,'root','2019-12-16 02:39:29',203,1),(12,'20160310110000','CreateOrderDomainTables','SQL','V20160310110000__CreateOrderDomainTables.sql',-94578014,'root','2019-12-16 02:39:30',568,1),(13,'20160311090000','OrderApplicationPermission','SQL','V20160311090000__OrderApplicationPermission.sql',590108874,'root','2019-12-16 02:39:30',22,1),(14,'20160311091000','OrderApplicationMenu','SQL','V20160311091000__OrderApplicationMenu.sql',-1745802654,'root','2019-12-16 02:39:30',17,1),(15,'20160311110000','Partner','SQL','V20160311110000__Partner.sql',-1992206207,'root','2019-12-16 02:39:31',1100,1),(16,'20160312120000','MemberDomainTable','SQL','V20160312120000__MemberDomainTable.sql',-1663293419,'root','2019-12-16 02:39:32',983,1),(17,'20160314105000','PartnerApplicationMenu','SQL','V20160314105000__PartnerApplicationMenu.sql',-720383816,'root','2019-12-16 02:39:32',14,1),(18,'20160316100000','CooperativePartnerApplicationPermission','SQL','V20160316100000__CooperativePartnerApplicationPermission.sql',716509651,'root','2019-12-16 02:39:32',15,1),(19,'20160317170000','SettlementDomain','SQL','V20160317170000__SettlementDomain.sql',-1568368533,'root','2019-12-16 02:39:33',402,1),(20,'20160318114000','SettlementApplicationMenu','SQL','V20160318114000__SettlementApplicationMenu.sql',-3660304,'root','2019-12-16 02:39:33',43,1),(21,'20160318122000','SettlementApplicationPermission','SQL','V20160318122000__SettlementApplicationPermission.sql',1567142296,'root','2019-12-16 02:39:33',10,1),(22,'20160322140000','initRoles','SQL','V20160322140000__initRoles.sql',725129435,'root','2019-12-16 02:39:33',3,1),(23,'20160401170000','MemberApplicationPermission','SQL','V20160401170000__MemberApplicationPermission.sql',658382909,'root','2019-12-16 02:39:33',5,1),(24,'20160401180000','ConfigApplicationPermission','SQL','V20160401180000__ConfigApplicationPermission.sql',435061979,'root','2019-12-16 02:39:33',13,1),(25,'20160402121000','ConfigDomain','SQL','V20160402121000__ConfigDomain.sql',-569435707,'root','2019-12-16 02:39:33',138,1),(26,'20160408152600','EventLogDomainTables','SQL','V20160408152600__EventLogDomainTables.sql',1802942390,'root','2019-12-16 02:39:33',92,1),(27,'20160409115000','addEventLogMenu','SQL','V20160409115000__addEventLogMenu.sql',210550928,'root','2019-12-16 02:39:33',7,1),(28,'20160409120000','addEventLogPermission','SQL','V20160409120000__addEventLogPermission.sql',1806562501,'root','2019-12-16 02:39:33',11,1),(29,'20160421170000','mallMenu','SQL','V20160421170000__mallMenu.sql',-1100912868,'root','2019-12-16 02:39:33',15,1),(30,'20160421193000','productWidget','SQL','V20160421193000__productWidget.sql',397979428,'root','2019-12-16 02:39:33',3,1),(31,'20160422093000','defaultConfig','SQL','V20160422093000__defaultConfig.sql',-1958197544,'root','2019-12-16 02:39:33',7,1),(32,'20160422120000','memberMenu','SQL','V20160422120000__memberMenu.sql',206763337,'root','2019-12-16 02:39:33',11,1),(33,'20160425160000','partnerWidget','SQL','V20160425160000__partnerWidget.sql',397362348,'root','2019-12-16 02:39:33',11,1),(34,'20160503150000','sysAuthConfig','SQL','V20160503150000__sysAuthConfig.sql',704862260,'root','2019-12-16 02:39:33',36,1),(35,'20160511160000','Misc','SQL','V20160511160000__Misc.sql',1142754211,'root','2019-12-16 02:39:34',525,1),(36,'20160511165800','MiscApplicationMenu','SQL','V20160511165800__MiscApplicationMenu.sql',-2113423528,'root','2019-12-16 02:39:34',16,1),(37,'20160511174500','MiscApplicationPermission','SQL','V20160511174500__MiscApplicationPermission.sql',-22862671,'root','2019-12-16 02:39:34',10,1),(38,'20160629171900','orderWidget','SQL','V20160629171900__orderWidget.sql',376760961,'root','2019-12-16 02:39:34',15,1),(39,'20160826144200','WechatMenu','SQL','V20160826144200__WechatMenu.sql',-1435878164,'root','2019-12-16 02:39:34',12,1),(40,'20160826164400','WechatMenuApplication','SQL','V20160826164400__WechatMenuApplication.sql',-2064084043,'root','2019-12-16 02:39:34',12,1),(41,'20160901113000','wechatConfig','SQL','V20160901113000__wechatConfig.sql',-165196803,'root','2019-12-16 02:39:34',14,1),(42,'20161102153000','createNotificationTable','SQL','V20161102153000__createNotificationTable.sql',225102049,'root','2019-12-16 02:39:34',18,1),(43,'20161102190000','SettlementNotification','SQL','V20161102190000__SettlementNotification.sql',-940281511,'root','2019-12-16 02:39:34',6,1),(44,'20161103100000','OrderNotification','SQL','V20161103100000__OrderNotification.sql',-768496943,'root','2019-12-16 02:39:34',10,1),(45,'20161129093000','CouponConfigData','SQL','V20161129093000__CouponConfigData.sql',1261709724,'root','2019-12-16 02:39:34',3,1),(46,'20170111170400','sellerApplyNotification','SQL','V20170111170400__sellerApplyNotification.sql',-585076289,'root','2019-12-16 02:39:34',3,1),(47,'20170113120000','PartnerConfig','SQL','V20170113120000__PartnerConfig.sql',378195199,'root','2019-12-16 02:39:34',17,1),(48,'20170116105000','Physical','SQL','V20170116105000__Physical.sql',-494245422,'root','2019-12-16 02:39:35',343,1),(49,'20170204160000','addVisibleColumnToMenu','SQL','V20170204160000__addVisibleColumnToMenu.sql',1933094634,'root','2019-12-16 02:39:35',229,1),(50,'20170206152800','WechatTemplateMessage','SQL','V20170206152800__WechatTemplateMessage.sql',-1169437038,'root','2019-12-16 02:39:35',220,1),(51,'20170210130000','updateSysConfigFlag','SQL','V20170210130000__updateSysConfigFlag.sql',-494159035,'root','2019-12-16 02:39:35',9,1),(52,'20170210133500','updateMenuIcon','SQL','V20170210133500__updateMenuIcon.sql',764509465,'root','2019-12-16 02:39:35',29,1),(53,'20170214200000','createWeixinTemplateMessage','SQL','V20170214200000__createWeixinTemplateMessage.sql',918115623,'root','2019-12-16 02:39:35',41,1),(54,'20170222122100','createSettlementMessage','SQL','V20170222122100__createSettlementMessage.sql',1024467442,'root','2019-12-16 02:39:35',12,1),(55,'20170223110000','createWeixinTemplateMessage','SQL','V20170223110000__createWeixinTemplateMessage.sql',524551583,'root','2019-12-16 02:39:35',11,1),(56,'20170306170400','feedbackNotification','SQL','V20170306170400__feedbackNotification.sql',-621301022,'root','2019-12-16 02:39:35',6,1),(57,'20170414103000','addVisibleColumnToWidget','SQL','V20170414103000__addVisibleColumnToWidget.sql',-1902130560,'root','2019-12-16 02:39:35',116,1),(58,'20170418190000','orderWidgetAddDisplayName','SQL','V20170418190000__orderWidgetAddDisplayName.sql',686636450,'root','2019-12-16 02:39:35',2,1),(59,'20170418190100','productWidgetAddDisplayName','SQL','V20170418190100__productWidgetAddDisplayName.sql',-215489913,'root','2019-12-16 02:39:35',8,1),(60,'20170418190200','partnerWidgetAddDisplayName','SQL','V20170418190200__partnerWidgetAddDisplayName.sql',-96292666,'root','2019-12-16 02:39:35',2,1),(61,'20170427144400','wechatAutoreply','SQL','V20170427144400__wechatAutoreply.sql',662371760,'root','2019-12-16 02:39:36',98,1),(62,'20170427175500','wechatAutoreplyData','SQL','V20170427175500__wechatAutoreplyData.sql',-1909311234,'root','2019-12-16 02:39:36',8,1),(63,'20170508120000','addPieceGroupCouponTemplate','SQL','V20170508120000__addPieceGroupCouponTemplate.sql',-1146018,'root','2019-12-16 02:39:36',5,1),(64,'20170509191000','CreateMarketingTables','SQL','V20170509191000__CreateMarketingTables.sql',-1467915409,'root','2019-12-16 02:39:36',431,1),(65,'20170510103000','MarketingApplicationMenu','SQL','V20170510103000__MarketingApplicationMenu.sql',-1377402888,'root','2019-12-16 02:39:36',2,1),(66,'20170510104000','MarketingApplicationPermission','SQL','V20170510104000__MarketingApplicationPermission.sql',836769533,'root','2019-12-16 02:39:36',19,1),(67,'20170602140000','registerAdLink','SQL','V20170602140000__registerAdLink.sql',590510926,'root','2019-12-16 02:39:36',5,1),(68,'20170603164000','marketingConfig','SQL','V20170603164000__marketingConfig.sql',2102199440,'root','2019-12-16 02:39:36',2,1),(69,'20170626180000','createWeixinTemplateMessage','SQL','V20170626180000__createWeixinTemplateMessage.sql',167159857,'root','2019-12-16 02:39:36',3,1),(70,'20170830123000','addPocketSwitch','SQL','V20170830123000__addPocketSwitch.sql',-1934369807,'root','2019-12-16 02:39:36',2,1),(71,'20170915105100','CreateProductSettlementProportionTables','SQL','V20170915105100__CreateProductSettlementProportionTables.sql',-1413133914,'root','2019-12-16 02:39:36',25,1),(72,'20170916143900','InserIntoSettlementProportion','SQL','V20170916143900__InserIntoSettlementProportion.sql',-796685156,'root','2019-12-16 02:39:36',2,1),(73,'20170926141600','modifyPhysicalPurchaseSummary','SQL','V20170926141600__modifyPhysicalPurchaseSummary.sql',481452886,'root','2019-12-16 02:39:36',196,1),(74,'20170929180000','createAgentPurchaseJournal','SQL','V20170929180000__createAgentPurchaseJournal.sql',-526052659,'root','2019-12-16 02:39:36',15,1),(75,'20171212103500','addProductCategoryVisible','SQL','V20171212103500__addProductCategoryVisible.sql',1473086485,'root','2019-12-16 02:39:36',2,1),(76,'20171212110000','updateDongguan','SQL','V20171212110000__updateDongguan.sql',224858826,'root','2019-12-16 02:39:36',3,1),(77,'20171226150000','addMerchant','SQL','V20171226150000__addMerchant.sql',-595315458,'root','2019-12-16 02:39:37',52,1),(78,'20171227103000','CreateMerchantDomainTables','SQL','V20171227103000__CreateMerchantDomainTables.sql',928671683,'root','2019-12-16 02:39:37',177,1),(79,'20171227103100','MerchantApplicationDefaultData','SQL','V20171227103100__MerchantApplicationDefaultData.sql',1773064255,'root','2019-12-16 02:39:37',8,1),(80,'20171227111000','MerchantApplicationPermission','SQL','V20171227111000__MerchantApplicationPermission.sql',648743434,'root','2019-12-16 02:39:37',4,1),(81,'20171227111100','MerchantApplicationMenu','SQL','V20171227111100__MerchantApplicationMenu.sql',-1172085454,'root','2019-12-16 02:39:37',10,1),(82,'20171227111200','MerchantWidget','SQL','V20171227111200__MerchantWidget.sql',637027907,'root','2019-12-16 02:39:37',5,1),(83,'20171227111300','changeAdminToMerchant','SQL','V20171227111300__changeAdminToMerchant.sql',-592051671,'root','2019-12-16 02:39:37',11,1),(84,'20180108164000','addProductConfig','SQL','V20180108164000__addProductConfig.sql',-772492569,'root','2019-12-16 02:39:37',10,1),(85,'20180115100000','addPriceUnitToWholesale','SQL','V20180115100000__addPriceUnitToWholesale.sql',1253700351,'root','2019-12-16 02:39:37',138,1),(86,'20180115163000','autoDeliverOrderConfig','SQL','V20180115163000__autoDeliverOrderConfig.sql',1088156508,'root','2019-12-16 02:39:37',27,1),(87,'20180115174000','addMerchantSettlement','SQL','V20180115174000__addMerchantSettlement.sql',1632168720,'root','2019-12-16 02:39:37',84,1),(88,'20180119160000','addPrimaryIdAndCreateTimeToAgentPcdQualify','SQL','V20180119160000__addPrimaryIdAndCreateTimeToAgentPcdQualify.sql',-1639484318,'root','2019-12-16 02:39:37',138,1),(89,'20180518095000','AddWxaConfig','SQL','V20180518095000__AddWxaConfig.sql',-1796742762,'root','2019-12-16 02:39:37',19,1),(90,'20180523163000','addUnionid','SQL','V20180523163000__addUnionid.sql',2044625363,'root','2019-12-16 02:39:39',1909,1),(91,'20180524163000','updateUserTokenSalt','SQL','V20180524163000__updateUserTokenSalt.sql',-750894369,'root','2019-12-16 02:39:39',12,1),(92,'20180604140000','TrialMenu','SQL','V20180604140000__TrialMenu.sql',-972905073,'root','2019-12-16 02:39:39',2,1),(93,'20180604155400','trial','SQL','V20180604155400__trial.sql',643809291,'root','2019-12-16 02:39:39',133,1),(94,'20180604163800','TrialPermission','SQL','V20180604163800__TrialPermission.sql',155987992,'root','2019-12-16 02:39:40',11,1),(95,'20180625120000','AlterProductTables','SQL','V20180625120000__AlterProductTables.sql',579801867,'root','2019-12-16 02:39:40',488,1),(96,'20180626104000','addStoreInfo','SQL','V20180626104000__addStoreInfo.sql',-532066349,'root','2019-12-16 02:39:41',1080,1),(97,'20180629123400','addMarketingConfigData','SQL','V20180629123400__addMarketingConfigData.sql',1798895310,'root','2019-12-16 02:39:41',2,1),(98,'20180704105700','addMenu','SQL','V20180704105700__addMenu.sql',-965404719,'root','2019-12-16 02:39:41',2,1),(99,'20180706115500','addMenu','SQL','V20180706115500__addMenu.sql',1258759133,'root','2019-12-16 02:39:41',2,1),(100,'20180718143800','addOrderCustomerServiceItem','SQL','V20180718143800__addOrderCustomerServiceItem.sql',-1453922406,'root','2019-12-16 02:39:42',388,1),(101,'20180807120000','addWallet','SQL','V20180807120000__addWallet.sql',1267519646,'root','2019-12-16 02:39:42',101,1),(102,'20180815115000','updateCouponStrategyTarget','SQL','V20180815115000__updateCouponStrategyTarget.sql',-632015770,'root','2019-12-16 02:39:42',480,1),(103,'20180821230000','addCoPartner','SQL','V20180821230000__addCoPartner.sql',-1999408214,'root','2019-12-16 02:39:42',197,1),(104,'20180822150000','addCopartnerMenu','SQL','V20180822150000__addCopartnerMenu.sql',754962762,'root','2019-12-16 02:39:42',14,1),(105,'20180824123000','addUserJoinNotifyTable','SQL','V20180824123000__addUserJoinNotifyTable.sql',1338257342,'root','2019-12-16 02:39:43',633,1),(106,'20180824153000','userJoinNotifyMenu','SQL','V20180824153000__userJoinNotifyMenu.sql',1367932694,'root','2019-12-16 02:39:43',2,1),(107,'20180927103000','addFlashDelivery','SQL','V20180927103000__addFlashDelivery.sql',588277183,'root','2019-12-16 02:39:43',8,1),(108,'20180929110000','addMallUrlConfig','SQL','V20180929110000__addMallUrlConfig.sql',1354570894,'root','2019-12-16 02:39:43',3,1),(109,'20181022120500','addVisibleToSettlementProportion','SQL','V20181022120500__addVisibleToSettlementProportion.sql',-898756584,'root','2019-12-16 02:39:43',53,1),(110,'20181023105000','addVisibleToPermissionGroup','SQL','V20181023105000__addVisibleToPermissionGroup.sql',359988392,'root','2019-12-16 02:39:43',48,1),(111,'20181023180000','addMemberCreditFields','SQL','V20181023180000__addMemberCreditFields.sql',-2121088506,'root','2019-12-16 02:39:44',465,1),(112,'20181024185000','addPrintPreviewConfig','SQL','V20181024185000__addPrintPreviewConfig.sql',-1386803445,'root','2019-12-16 02:39:44',2,1),(113,'20181025110000','addAppConfig','SQL','V20181025110000__addAppConfig.sql',101636408,'root','2019-12-16 02:39:44',6,1),(114,'20181027130000','addGroupIdToPermissionDefinition','SQL','V20181027130000__addGroupIdToPermissionDefinition.sql',674013791,'root','2019-12-16 02:39:44',48,1),(115,'20181027133000','updatePermName','SQL','V20181027133000__updatePermName.sql',1548961776,'root','2019-12-16 02:39:44',25,1),(116,'20181029120000','addPaidOrderNotification','SQL','V20181029120000__addPaidOrderNotification.sql',1530359267,'root','2019-12-16 02:39:44',2,1),(117,'20181105120000','modifyConfigValueTypeToText','SQL','V20181105120000__modifyConfigValueTypeToText.sql',672595290,'root','2019-12-16 02:39:44',40,1),(118,'20181105160000','createAlipayConfig','SQL','V20181105160000__createAlipayConfig.sql',388994853,'root','2019-12-16 02:39:44',22,1),(119,'20181107180000','addQrcodeUrlConfig','SQL','V20181107180000__addQrcodeUrlConfig.sql',1448988560,'root','2019-12-16 02:39:44',9,1),(120,'20181113104000','addProductTag','SQL','V20181113104000__addProductTag.sql',-213865646,'root','2019-12-16 02:39:44',32,1),(121,'20181113120000','addProductTagMenu','SQL','V20181113120000__addProductTagMenu.sql',1159676333,'root','2019-12-16 02:39:44',4,1),(122,'20181205150000','addRefundWay','SQL','V20181205150000__addRefundWay.sql',-511658797,'root','2019-12-16 02:39:44',31,1),(123,'20190116220000','addSkuId','SQL','V20190116220000__addSkuId.sql',226536980,'root','2019-12-16 02:39:44',52,1),(124,'20190611220000','addExtCoupon','SQL','V20190611220000__addExtCoupon.sql',-1962051480,'root','2019-12-16 02:39:44',141,1),(125,'20190622110000','addInvitationqrRedirecturl','SQL','V20190622110000__addInvitationqrRedirecturl.sql',1122973946,'root','2019-12-16 02:39:44',3,1),(126,'20190727150000','addAppCertConfig','SQL','V20190727150000__addAppCertConfig.sql',1675233961,'root','2019-12-16 02:39:44',3,1),(127,'20190926095000','addAlliance','SQL','V20190926095000__addAlliance.sql',323002002,'root','2019-12-16 02:39:44',30,1),(128,'20191007170000','addProductDistrictionPrice','SQL','V20191007170000__addProductDistrictionPrice.sql',-213167216,'root','2019-12-16 02:39:44',58,1),(129,'20191014220000','addWxaQrcode','SQL','V20191014220000__addWxaQrcode.sql',-1579960942,'root','2019-12-16 02:39:44',86,1),(130,'20191109160000','addWxExpress','SQL','V20191109160000__addWxExpress.sql',-1740775012,'root','2019-12-16 02:39:44',2,1),(131,'20191120210000','addProductBanner','SQL','V20191120210000__addProductBanner.sql',-1752350371,'root','2019-12-16 02:39:45',145,1);
/*!40000 ALTER TABLE `schema_version` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_about_mall`
--

DROP TABLE IF EXISTS `t_about_mall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_about_mall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image` varchar(50) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_about_mall`
--

LOCK TABLES `t_about_mall` WRITE;
/*!40000 ALTER TABLE `t_about_mall` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_about_mall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_ad`
--

DROP TABLE IF EXISTS `t_ad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `enabled` int(11) NOT NULL DEFAULT '1',
  `target_url` varchar(200) DEFAULT NULL,
  `strategy` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT `t_ad_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `t_ad_group` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_ad`
--

LOCK TABLES `t_ad` WRITE;
/*!40000 ALTER TABLE `t_ad` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_ad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_ad_group`
--

DROP TABLE IF EXISTS `t_ad_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ad_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_ad_group`
--

LOCK TABLES `t_ad_group` WRITE;
/*!40000 ALTER TABLE `t_ad_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_ad_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_ad_link_definition`
--

DROP TABLE IF EXISTS `t_ad_link_definition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ad_link_definition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT '0',
  `name` varchar(100) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_ad_link_definition`
--

LOCK TABLES `t_ad_link_definition` WRITE;
/*!40000 ALTER TABLE `t_ad_link_definition` DISABLE KEYS */;
INSERT INTO `t_ad_link_definition` VALUES (1,0,'首页','#/home/homePage'),(2,0,'购物车','#/home/cart'),(3,0,'分类','#/home/category'),(4,0,'个人中心','#/home/my'),(5,0,'销售中心','#/home/sellerPage'),(6,0,'订单中心','#/order/all'),(7,0,'10元区','#/goodsList/10'),(8,1,'产品','#/details/'),(9,2,'类别','#/home/category/'),(10,0,'拼团活动','#/home/category/-1/pieceGroup');
/*!40000 ALTER TABLE `t_ad_link_definition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_agent`
--

DROP TABLE IF EXISTS `t_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_agent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_agent_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_agent`
--

LOCK TABLES `t_agent` WRITE;
/*!40000 ALTER TABLE `t_agent` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_agent_pcd_qualify`
--

DROP TABLE IF EXISTS `t_agent_pcd_qualify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_agent_pcd_qualify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agent_id` int(11) NOT NULL,
  `pcd_qualify_id` int(11) NOT NULL,
  `physical_settlement_percentage` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `agent_id` (`agent_id`),
  KEY `pcd_qualify_id` (`pcd_qualify_id`),
  CONSTRAINT `t_agent_pcd_qualify_ibfk_1` FOREIGN KEY (`agent_id`) REFERENCES `t_agent` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_agent_pcd_qualify_ibfk_2` FOREIGN KEY (`pcd_qualify_id`) REFERENCES `t_pcd_qualify` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_agent_pcd_qualify`
--

LOCK TABLES `t_agent_pcd_qualify` WRITE;
/*!40000 ALTER TABLE `t_agent_pcd_qualify` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_agent_pcd_qualify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_agent_purchase_journal`
--

DROP TABLE IF EXISTS `t_agent_purchase_journal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_agent_purchase_journal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` int(11) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `pcd_id` int(11) NOT NULL,
  `pcd_name` varchar(50) DEFAULT NULL,
  `order_item_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `product_specification_name` varchar(50) DEFAULT NULL,
  `product_cover` varchar(200) DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `final_price` decimal(15,2) DEFAULT NULL,
  `marketing_id` int(11) NOT NULL,
  `marketing_name` varchar(50) DEFAULT NULL,
  `percentage` decimal(15,2) DEFAULT NULL,
  `agent_proportion` decimal(15,2) DEFAULT NULL,
  `settled_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `order_user_id` int(11) DEFAULT NULL,
  `order_user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_agent_purchase_journal`
--

LOCK TABLES `t_agent_purchase_journal` WRITE;
/*!40000 ALTER TABLE `t_agent_purchase_journal` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_agent_purchase_journal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_agent_summary`
--

DROP TABLE IF EXISTS `t_agent_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_agent_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` int(11) NOT NULL,
  `statistic_month` date DEFAULT NULL,
  `end_month` date DEFAULT NULL,
  `pcd_id` int(11) NOT NULL,
  `amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `year_statistic_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `settled_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `settlement_proportion` decimal(5,2) NOT NULL DEFAULT '0.00',
  `transferred` int(11) NOT NULL DEFAULT '0',
  `transferred_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`),
  KEY `seller_id` (`seller_id`),
  CONSTRAINT `t_agent_summary_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `t_seller` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_agent_summary`
--

LOCK TABLES `t_agent_summary` WRITE;
/*!40000 ALTER TABLE `t_agent_summary` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_agent_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_alliance`
--

DROP TABLE IF EXISTS `t_alliance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_alliance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `invitor_alliance_id` int(11) DEFAULT NULL COMMENT '邀请人',
  `alliance_ship` int(11) NOT NULL DEFAULT '0' COMMENT '是否为盟友 0:否，1:临时，2:正式',
  `stockholder_ship` int(11) NOT NULL DEFAULT '0' COMMENT '是否为股东 0:否，1:是',
  `creation_time` timestamp NULL DEFAULT NULL,
  `alliance_ship_time` timestamp NULL DEFAULT NULL COMMENT '成为盟友的时间',
  `stockholder_ship_time` timestamp NULL DEFAULT NULL COMMENT '成为股东的时间',
  `temp_alliance_expiry_time` timestamp NULL DEFAULT NULL COMMENT '临时盟友过期时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_alliance_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_alliance`
--

LOCK TABLES `t_alliance` WRITE;
/*!40000 ALTER TABLE `t_alliance` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_alliance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_apply`
--

DROP TABLE IF EXISTS `t_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `properties` varchar(225) DEFAULT NULL,
  `apply_date` timestamp NULL DEFAULT NULL,
  `approve_date` timestamp NULL DEFAULT NULL,
  `reject_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_apply_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_apply`
--

LOCK TABLES `t_apply` WRITE;
/*!40000 ALTER TABLE `t_apply` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_carry_mode`
--

DROP TABLE IF EXISTS `t_carry_mode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_carry_mode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fare_id` int(11) NOT NULL,
  `region` varchar(200) DEFAULT NULL,
  `first_piece` int(11) DEFAULT NULL,
  `first_weight` int(11) DEFAULT NULL,
  `first_bulk` int(11) DEFAULT NULL,
  `first_amount` decimal(18,2) NOT NULL,
  `second_piece` int(11) DEFAULT NULL,
  `second_weight` int(11) DEFAULT NULL,
  `second_bulk` int(11) DEFAULT NULL,
  `second_amount` decimal(18,2) NOT NULL,
  `carry_way` int(11) DEFAULT '0',
  `is_default` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fare_id` (`fare_id`),
  CONSTRAINT `t_carry_mode_ibfk_1` FOREIGN KEY (`fare_id`) REFERENCES `t_fare_template` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_carry_mode`
--

LOCK TABLES `t_carry_mode` WRITE;
/*!40000 ALTER TABLE `t_carry_mode` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_carry_mode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_config`
--

DROP TABLE IF EXISTS `t_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `key_name` varchar(50) DEFAULT NULL,
  `value_type` varchar(50) DEFAULT NULL,
  `value` text,
  `type` varchar(50) DEFAULT NULL,
  `visible` int(11) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `readonly` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT `t_config_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `t_config_group` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_config`
--

LOCK TABLES `t_config` WRITE;
/*!40000 ALTER TABLE `t_config` DISABLE KEYS */;
INSERT INTO `t_config` VALUES (1,NULL,1,'最迟可退货时间','mall.latest_return_time','int','30','',1,'单位为天',0),(2,NULL,1,'分销商最低销售额度','mall.lowest_sales_quota','int','1000','',0,'注册不满100天，额度放宽',0),(3,NULL,1,'返点级别','mall.rebates_level','int','2','',0,'级别等级相关',0),(4,NULL,1,'积分兑换金额','mall.point_exchange_rate','int','100','sys',1,'1元等于多少积分',0),(5,NULL,1,'包邮最低额度','mall.free_mail_minimum_amount','int','998','',1,'',0),(6,NULL,1,'分销商提款条件','mall.drawing_conditions','int','100','',1,'拥金余额要不少于该数值',0),(7,NULL,1,'自动确认收货期限','mall.auto_validation_receiving_deadline','int','15','',1,'如分销商不主动推迟日期',0),(8,NULL,1,'支付超时时间','mall.pay_order_timeout','int','12','',1,'待支付的订单超过这个时间限制后自动关闭',0),(9,NULL,1,'分销商申请自动审核开关','mall.seller_apply_auto_approve','boolean','true','',1,'分销商申请自动审核开关',0),(10,NULL,1,'新用户注册自动成为分销商开关','mall.seller_auto_sellership','boolean','true','',1,'新用户注册自动成为分销商开关',0),(11,NULL,1,'分销商达到人数自动升级为合伙人开关','mall.seller_auto_promote_to_partner','boolean','true','',1,'分销商达到人数自动升级为合伙人开关',0),(12,NULL,1,'产品售罄自动下架开关','mall.auto_offsell','boolean','false','',1,'当产品售罄后,自动把该产品下架',0),(13,NULL,1,'首页推荐产品轮询时间','mall.promoted_product_carousel','int','60','',1,'首页推荐产品轮询时间, 每过这个时间就轮换一批首页产品。单位分钟。最小30分钟。',0),(14,NULL,1,'新建订单开关','mall.order_created_enable','boolean','true','',1,'允许用户新建订单, 用于临时关闭下单功能。',0),(15,NULL,1,'下单默认选中优惠券开关','mall.auto_select_coupon','boolean','true','',1,'下单结算时, 如果用户有可用的优惠券, 默认选择一张优惠券进行结算。',0),(16,NULL,3,'默认角色','misc.customer_role_id','int','4','',1,'用户注册时默认添加的角色号。',0),(17,NULL,3,'API服务URL','misc.api_url','String','http://localhost:10080','sys',1,'API服务提供者的web service URL前缀。',0),(18,NULL,3,'快递100API查询公司编号','express.customer','String','','',1,'使用快递100API查询物流信息使用的公司编号,当使用企业版时需要这个字段，详见www.kuaidi100.com',0),(19,NULL,3,'快递100API查询Key','express.key','String','','',1,'使用快递100API查询物流信息使用的密钥，详见www.kuaidi100.com',0),(20,NULL,3,'关注我们文章地址','follow.us.url','String','','sys',1,'首页关注我们功能跳转到的公众号文章的地址',0),(21,NULL,100,'用户名','sys.auth.username','String','sys','',1,'BASIC验证的用户名',0),(22,NULL,100,'密码','sys.auth.password','String','sys','',1,'BASIC验证的密码',0),(23,NULL,100,'允许访问IP列表','sys.auth.allowips','String','','',1,'允许访问本系统的内部系统IP列表. 以逗号分隔，如192.168.0.1,192.168.0.2. 如果为空则不进行IP匹配判断。',0),(24,NULL,2,'token令牌','wx.token','String','mrt','sys',1,'微信公众号后台的token. 进入 mp.weixin.qq.com 下面的开发-基本配置可以查看和修改。',0),(25,NULL,2,'启用消息加密','wx.encrypt_message','boolean','false','',1,'启用消息加解密',0),(26,NULL,2,'消息加解密密钥','wx.encoding_aes_key','String','mrt','sys',1,'消息加解密密钥',0),(27,NULL,2,'应用ID','wx.app_id','String','wx8f8c1951673749b8','sys',1,'应用ID',0),(28,NULL,2,'应用密钥','wx.app_secret','String','f15766d5f937d339b6e30a79f9da3b20','sys',1,'应用密钥',0),(29,NULL,2,'域名','wx.host','String','http://mall.smallsaas.cn/app','sys',1,'微信应用部署的服务器域名',0),(30,NULL,2,'商户ID','wx.partner_id','String',NULL,'sys',1,'微信支付商户号',0),(31,NULL,2,'商户Key','wx.partner_key','String',NULL,'sys',1,'微信支付商户密钥',0),(32,NULL,2,'证书路径','wx.cert_path','String',NULL,'',1,'证书路径,请前往 微信配置管理菜单 进行上传更新',1),(33,NULL,10,'分享链接有限时间','coupon.share_link_valid_days','int','30','',1,'单位为天',0),(34,NULL,10,'获得红包时间','coupon.pocket_time','int','24','',1,'单位为小时, 在这个时间内可以获得红包, 与 获得红包的订单数 配合使用',0),(35,NULL,10,'获得红包的订单数','coupon.pocket_order_count','int','2','',1,'超过这个限制的订单不发红包, 与 获得红包时间 配合使用',0),(36,NULL,10,'分享红包标题','coupon.pocket_share_title','String','快来领取十美优品专享红包','sys',1,'分享红包到朋友圈或发给朋友时显示的标题',0),(37,NULL,10,'分享红包描述','coupon.pocket_share_desc','String','快来领取十美优品专享红包','sys',1,'分享红包到朋友圈或发给朋友时显示的描述',0),(38,NULL,10,'快过期优惠券通知时间','coupon.overdue_time_interval','int','24','',1,'单位为小时，优惠券将要过期时，发送微信消息通知用户',0),(39,NULL,400,'线下经销商申请成为皇冠商开关','partner.can_apply_crown','boolean','false','sys',1,'线下经销商申请成为皇冠商开关',0),(40,NULL,400,'线下经销商扫码申请成为皇冠商开关','partner.can_code_apply_crown','boolean','false','',1,'线下经销商扫码申请成为皇冠商开关',0),(41,NULL,400,'线下经销商申请成为皇冠商文本','partner.apply_crown_text','String','','sys',1,'线下经销商申请成为皇冠商的描述文本，可输入\\n表示换行',0),(42,NULL,400,'授权线下经销商文本','partner.create_physical_seller_text','String','','sys',1,'线下经销商申请成为皇冠商的描述文本，可输入\\n表示换行',0),(43,NULL,400,'新晋线下皇冠商进货时间','partner.new_physical_seller_wholesale_time','int','4','',1,'线下经销商被批准成为线下皇冠商后，必须在规定小时内完成一定额的批发订单的时间，单位小时。',0),(44,NULL,400,'新晋线下皇冠商最小进货额','partner.new_physical_seller_wholesale_amount','int','2000','',1,'线下经销商被批准成为线下皇冠商后，必须在规定小时内完成一定额的批发批发订单的最小额度，单位元。',0),(45,NULL,400,'线下皇冠商申请自动审核开关','partner.auto_audit_physical_crown','boolean','true','',1,'线下皇冠商申请自动审核开关',0),(46,NULL,400,'线下皇冠商申请自动审核次数','partner.auto_audit_physical_crown_times','int','3','',1,'当自动审核次数达到指定次数后，需要转人工审核',0),(47,NULL,10,'分享链接拿红包开关','coupon.share_link_enabled','boolean','false','sys',1,'一旦打开本开关，下单后会弹出分享链接拿红包',0),(48,NULL,1,'显示产品类别菜单开关','mall.show_product_category_menu','boolean','true','sys',1,'显示产品类别菜单开关',0),(49,NULL,500,'是否允许平台零售','merchant.allow_platform_sale','boolean','true','sys',1,'是否允许平台零售, 如果设为不允许，则只有进入指定的商家店铺才可以下单',0),(50,NULL,500,'是否需要营业执照','merchant.license_req','boolean','true','',1,'是否需要营业执照',0),(51,NULL,500,'是否需要身份证','merchant.idcard_req','boolean','true','',1,'是否需要身份证',0),(52,NULL,500,'是否需要保证金','merchant.deposit_req','boolean','true','',1,'是否需要保证金',0),(53,NULL,500,'是否允许自主申请','merchant.allow_apply','boolean','false','',1,'是否允许用户自主申请成为商家',0),(54,NULL,4,'分区1名称','product.partner_level_zone_1','String','零元区','',1,'分区1名称',0),(55,NULL,4,'分区2名称','product.partner_level_zone_2','String','精品区','',1,'分区1名称',0),(56,NULL,4,'分区3名称','product.partner_level_zone_3','String','特价区','',1,'分区1名称',0),(57,NULL,4,'显示分成设置开关','product.show_settlement_setting','boolean','true','',1,'显示分成设置',0),(58,NULL,4,'显示规格设置开关','product.show_specification_setting','boolean','true','',1,'显示规格设置开关',0),(59,NULL,1,'自动发货开关','mall.auto_deliver_order','boolean','true','sys',1,'支付的订单自动变成发货状态',0),(60,NULL,2,'小程序AppId','wx.wxa_appid','String',NULL,'sys',1,'微信小程序APP ID',0),(61,NULL,2,'小程序密钥','wx.wxa_app_secret','String',NULL,'sys',1,'微信小程序APP密钥',0),(62,NULL,2,'登录自动注册','wx.auto_reg','boolean','true','sys',1,'微信登录后自动注册，如果设为false，则需要用户填手机号进行注册',0),(63,NULL,1,'极速送达运费','mall.flash_freight','int','10','sys',1,'单位为元',0),(64,NULL,20,'商城首页','mall.url.home','String','','',1,'公众号前端商城首页链接地址',0),(65,NULL,20,'产品详情页','mall.url.product_detail','String','/cosmetics/productDetails?id={0}','',1,'公众号前端产品详情页链接地址',0),(66,NULL,20,'我的订单页','mall.url.my_order','String','/order/myOrders','',1,'公众号前端我的订单链接地址',0),(67,NULL,20,'订单详情页','mall.url.order_detail','String','/order/myOrderDetail?id={0}','',1,'公众号前端订单详情页链接地址',0),(68,NULL,20,'个人中心页','mall.url.personal_center','String','/personalCenter','',1,'公众号前端个人中心页链接地址',0),(69,NULL,20,'门店列表页','mall.url.store_list','String','/skinHousekeeper/reservation','',1,'公众号前端门店列表页链接地址',0),(70,NULL,21,'商城首页','mall.wxa.url.home','String','/pages/index/index','',1,'小程序首页页面路径',0),(71,NULL,30,'订单打印LOGO','print.order.logo','String','','',1,'订单打印LOGO',0),(72,NULL,30,'订单打印标题','print.order.title','String','商城','',1,'订单打印标题',0),(73,NULL,2,'移动应用名称','wx.app_name','String',NULL,'',1,'开放平台移动应用在应用市场上的APP名字',0),(74,NULL,2,'移动应用AppId','wx.app_appid','String',NULL,'',1,'开放平台移动应用APP ID',0),(75,NULL,2,'移动应用密钥','wx.app_app_secret','String',NULL,'',1,'开放平台移动应用APP密钥',0),(76,NULL,2,'移动应用商家ID','wx.app_partner_id','String',NULL,'',1,'开放平台移动应用商家ID',0),(77,NULL,2,'移动应用商家密钥','wx.app_partner_key','String',NULL,'',1,'开放平台移动应用商家密钥',0),(78,NULL,5,'应用ID','ali.app_id','String','','',1,'应用ID',0),(79,NULL,5,'应用密钥','ali.app_secret','text','','',1,'应用密钥',0),(80,NULL,5,'支付宝公钥','ali.alipay_public_key','text','','',1,'支付宝公钥，不配置则使用默认值，一旦配置就使用该值覆盖',0),(81,NULL,1,'邀请二维码信息图片','mall.qrcode.info_url','String','','',1,'邀请二维码信息图片',0),(82,NULL,1,'邀请二维码LOGO图片','mall.qrcode.logo_url','String','','',1,'邀请二维码LOGO图片',0),(83,NULL,1,'邀请二维码跳转链接','mall.invitationqr.redirecturl','String','','sys',1,'邀请二维码扫码后跳转到的外部链接',0),(84,NULL,2,'移动应用证书路径','wx.app_cert_path','String',NULL,'',1,'开放平台移动应用证书路径,请前往 微信配置管理菜单 进行上传更新',1),(85,NULL,40,'启用小程序物流助手','wx.express.enabled','boolean','false','',1,'启用小程序物流助手',0),(86,NULL,40,'快递公司ID','wx.express.delivery_id','String','BEST','',1,'快递公司ID,如百世快递为BEST,请查看微信小程序文档',0),(87,NULL,40,'快递公司名称','wx.express.delivery_name','String','百世快递','',1,'快递公司ID,如百世快递为BEST,请查看微信小程序文档',0),(88,NULL,40,'快递客户编码','wx.express.biz_id','String','','',1,'快递客户编码,小程序后台绑定快递时使用的biz_id, 请查看微信小程序文档',0),(89,NULL,40,'服务类型ID','wx.express.service_type','int','1','',1,'服务类型ID, 查看微信小程序文档',0),(90,NULL,40,'服务类型名称','wx.express.service_name','String','普通快递','',1,'服务类型名称, 查看微信小程序文档',0),(91,NULL,40,'默认快递发送公司名','wx.express.sender_company','String','百世快递','',1,'默认快递发送公司名',0),(92,NULL,40,'默认快递发送联系人','wx.express.sender_name','String','小二','',1,'默认快递发送联系人',0),(93,NULL,40,'默认快递发送手机','wx.express.sender_mobile','String','13800000001','',1,'默认快递发送手机',0),(94,NULL,40,'默认快递发送省','wx.express.sender_province','String','广东省','',1,'默认快递发送省',0),(95,NULL,40,'默认快递发送市','wx.express.sender_city','String','广州市','',1,'默认快递发送市',0),(96,NULL,40,'默认快递发送区','wx.express.sender_area','String','天河区','',1,'默认快递发送区',0),(97,NULL,40,'默认快递发送地址','wx.express.sender_address','String','天河路','',1,'默认快递发送地址',0);
/*!40000 ALTER TABLE `t_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_config_group`
--

DROP TABLE IF EXISTS `t_config_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_config_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `protected` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_config_group`
--

LOCK TABLES `t_config_group` WRITE;
/*!40000 ALTER TABLE `t_config_group` DISABLE KEYS */;
INSERT INTO `t_config_group` VALUES (1,'商城配置',0),(2,'微信配置',0),(3,'其他配置',0),(4,'商品配置',0),(5,'支付宝配置',0),(10,'优惠券配置',0),(20,'商城链接配置',0),(21,'商城链接小程序页面配置',0),(30,'打印配置',0),(40,'微信物流助手配置',0),(100,'内部系统访问配置',0),(400,'合作伙伴配置',0),(500,'商家配置',0);
/*!40000 ALTER TABLE `t_config_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_contact`
--

DROP TABLE IF EXISTS `t_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `zip` char(6) DEFAULT NULL,
  `contact_user` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `street_number` varchar(50) DEFAULT NULL,
  `detail` varchar(200) DEFAULT NULL,
  `is_default` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_contact_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_contact`
--

LOCK TABLES `t_contact` WRITE;
/*!40000 ALTER TABLE `t_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cooperative_statistic`
--

DROP TABLE IF EXISTS `t_cooperative_statistic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cooperative_statistic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `statistic_date` timestamp NULL DEFAULT NULL,
  `real_date` timestamp NULL DEFAULT NULL,
  `seller_count` int(11) DEFAULT '0',
  `agent_count` int(11) DEFAULT '0',
  `partner_count` int(11) DEFAULT '0',
  `crown_count` int(11) DEFAULT '0',
  `physical_count` int(11) DEFAULT '0',
  `customer_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cooperative_statistic`
--

LOCK TABLES `t_cooperative_statistic` WRITE;
/*!40000 ALTER TABLE `t_cooperative_statistic` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_cooperative_statistic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_copartner`
--

DROP TABLE IF EXISTS `t_copartner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_copartner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `seller_id` (`seller_id`),
  CONSTRAINT `t_copartner_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `t_seller` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_copartner`
--

LOCK TABLES `t_copartner` WRITE;
/*!40000 ALTER TABLE `t_copartner` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_copartner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_copartner_relation`
--

DROP TABLE IF EXISTS `t_copartner_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_copartner_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `copartner_id` int(11) DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `seller_id` (`seller_id`),
  KEY `copartner_id` (`copartner_id`),
  CONSTRAINT `t_copartner_relation_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `t_seller` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_copartner_relation_ibfk_2` FOREIGN KEY (`copartner_id`) REFERENCES `t_copartner` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_copartner_relation`
--

LOCK TABLES `t_copartner_relation` WRITE;
/*!40000 ALTER TABLE `t_copartner_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_copartner_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_copartner_settlement`
--

DROP TABLE IF EXISTS `t_copartner_settlement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_copartner_settlement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `copartner_id` int(11) DEFAULT NULL,
  `statistic_month` date DEFAULT NULL,
  `settled_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `settlement_proportion` decimal(5,2) NOT NULL DEFAULT '0.00',
  `transferred` int(11) NOT NULL DEFAULT '0',
  `transferred_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`),
  KEY `copartner_id` (`copartner_id`),
  CONSTRAINT `t_copartner_settlement_ibfk_1` FOREIGN KEY (`copartner_id`) REFERENCES `t_copartner` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_copartner_settlement`
--

LOCK TABLES `t_copartner_settlement` WRITE;
/*!40000 ALTER TABLE `t_copartner_settlement` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_copartner_settlement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_coupon`
--

DROP TABLE IF EXISTS `t_coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(200) NOT NULL,
  `auto_give` int(11) DEFAULT '0',
  `type` varchar(50) DEFAULT NULL,
  `code` varchar(200) DEFAULT NULL,
  `display_name` varchar(200) DEFAULT NULL,
  `money` int(11) DEFAULT '0',
  `discount` int(11) DEFAULT '0',
  `description` text,
  `cond` text,
  `created_date` datetime DEFAULT NULL,
  `valid_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `attribute` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_coupon_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_coupon`
--

LOCK TABLES `t_coupon` WRITE;
/*!40000 ALTER TABLE `t_coupon` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_coupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_coupon_overdue`
--

DROP TABLE IF EXISTS `t_coupon_overdue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_coupon_overdue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `coupon_id` int(11) NOT NULL,
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `coupon_id` (`coupon_id`),
  CONSTRAINT `t_coupon_overdue_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_coupon_overdue_ibfk_2` FOREIGN KEY (`coupon_id`) REFERENCES `t_coupon` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_coupon_overdue`
--

LOCK TABLES `t_coupon_overdue` WRITE;
/*!40000 ALTER TABLE `t_coupon_overdue` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_coupon_overdue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_coupon_share`
--

DROP TABLE IF EXISTS `t_coupon_share`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_coupon_share` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `code` varchar(200) NOT NULL,
  `order_number` varchar(200) DEFAULT NULL,
  `type` varchar(50) NOT NULL DEFAULT 'ORDER',
  `share_date` datetime DEFAULT NULL,
  `valid_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`),
  UNIQUE KEY `order_number` (`order_number`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_coupon_share_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_coupon_share`
--

LOCK TABLES `t_coupon_share` WRITE;
/*!40000 ALTER TABLE `t_coupon_share` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_coupon_share` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_coupon_statistic`
--

DROP TABLE IF EXISTS `t_coupon_statistic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_coupon_statistic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `statistic_date` timestamp NULL DEFAULT NULL,
  `real_date` timestamp NULL DEFAULT NULL,
  `grant_count` int(11) DEFAULT '0',
  `used_count` int(11) DEFAULT '0',
  `overdue_count` int(11) DEFAULT '0',
  `given_by_register_count` int(11) DEFAULT '0',
  `taken_by_link_count` int(11) DEFAULT '0',
  `system_given_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_coupon_statistic`
--

LOCK TABLES `t_coupon_statistic` WRITE;
/*!40000 ALTER TABLE `t_coupon_statistic` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_coupon_statistic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_coupon_strategy`
--

DROP TABLE IF EXISTS `t_coupon_strategy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_coupon_strategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `random_number` int(11) DEFAULT '0',
  `target_type` int(11) DEFAULT '0',
  `status` varchar(50) DEFAULT 'DRAFT',
  `description` text,
  `target_condition` text,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_coupon_strategy`
--

LOCK TABLES `t_coupon_strategy` WRITE;
/*!40000 ALTER TABLE `t_coupon_strategy` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_coupon_strategy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_coupon_strategy_item`
--

DROP TABLE IF EXISTS `t_coupon_strategy_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_coupon_strategy_item` (
  `strategy_id` int(11) NOT NULL,
  `coupon_type_id` int(11) NOT NULL,
  PRIMARY KEY (`strategy_id`,`coupon_type_id`),
  KEY `coupon_type_id` (`coupon_type_id`),
  CONSTRAINT `t_coupon_strategy_item_ibfk_1` FOREIGN KEY (`strategy_id`) REFERENCES `t_coupon_strategy` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_coupon_strategy_item_ibfk_2` FOREIGN KEY (`coupon_type_id`) REFERENCES `t_coupon_type` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_coupon_strategy_item`
--

LOCK TABLES `t_coupon_strategy_item` WRITE;
/*!40000 ALTER TABLE `t_coupon_strategy_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_coupon_strategy_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_coupon_strategy_taken_record`
--

DROP TABLE IF EXISTS `t_coupon_strategy_taken_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_coupon_strategy_taken_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `strategy_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `version` int(11) DEFAULT '0',
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `strategy_id` (`strategy_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_coupon_strategy_taken_record_ibfk_1` FOREIGN KEY (`strategy_id`) REFERENCES `t_coupon_strategy` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_coupon_strategy_taken_record_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_coupon_strategy_taken_record`
--

LOCK TABLES `t_coupon_strategy_taken_record` WRITE;
/*!40000 ALTER TABLE `t_coupon_strategy_taken_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_coupon_strategy_taken_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_coupon_taken_record`
--

DROP TABLE IF EXISTS `t_coupon_taken_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_coupon_taken_record` (
  `share_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `coupon_value` int(11) DEFAULT '0',
  `message` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`share_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_coupon_taken_record_ibfk_1` FOREIGN KEY (`share_id`) REFERENCES `t_coupon_share` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_coupon_taken_record_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_coupon_taken_record`
--

LOCK TABLES `t_coupon_taken_record` WRITE;
/*!40000 ALTER TABLE `t_coupon_taken_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_coupon_taken_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_coupon_template`
--

DROP TABLE IF EXISTS `t_coupon_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_coupon_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `is_limited` int(11) DEFAULT NULL,
  `is_discount` int(11) DEFAULT NULL,
  `cond` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_coupon_template`
--

LOCK TABLES `t_coupon_template` WRITE;
/*!40000 ALTER TABLE `t_coupon_template` DISABLE KEYS */;
INSERT INTO `t_coupon_template` VALUES (1,'限制型产品代金券','PRODUCT',1,0,'\n<rule-set name=\"getFinalPrice\" >\n    <mvel-rule id=\"step1\" multipleTimes=\"false\" exclusive=\"true\" valid=\"true\">\n        <condition><![CDATA[productId==#id#&&totalPrice>=#totalPrice#]]></condition>\n        <action><![CDATA[finalPrice=totalPrice-#money#]]></action>\n    </mvel-rule>\n</rule-set>\n'),(2,'无限制型产品代金券','PRODUCT',0,0,'\n<rule-set name=\"getFinalPrice\" >\n    <mvel-rule id=\"step1\" multipleTimes=\"false\" exclusive=\"true\" valid=\"true\">\n        <condition><![CDATA[productId==#id#]]></condition>\n        <action><![CDATA[finalPrice=totalPrice-#money#]]></action>\n    </mvel-rule>\n</rule-set>\n'),(3,'限制型产品折扣券','PRODUCT',1,1,'\n<rule-set name=\"getFinalPrice\" >\n    <mvel-rule id=\"step1\" multipleTimes=\"false\" exclusive=\"true\" valid=\"true\">\n        <condition><![CDATA[productId==#id#&&totalPrice>=#totalPrice#]]></condition>\n        <action><![CDATA[finalPrice=totalPrice*#discount#/100]]></action>\n    </mvel-rule>\n</rule-set>\n'),(4,'无限制型产品折扣券','PRODUCT',0,1,'\n<rule-set name=\"getFinalPrice\" >\n    <mvel-rule id=\"step1\" multipleTimes=\"false\" exclusive=\"true\" valid=\"true\">\n        <condition><![CDATA[productId==#id#]]></condition>\n        <action><![CDATA[finalPrice=totalPrice*#discount#/100]]></action>\n    </mvel-rule>\n</rule-set>\n'),(5,'限制型订单代金券','ORDER',1,0,'\n<rule-set name=\"getFinalPrice\" >\n    <mvel-rule id=\"step1\" multipleTimes=\"false\" exclusive=\"true\" valid=\"true\">\n        <condition><![CDATA[totalPrice>=#totalPrice#]]></condition>\n        <action><![CDATA[finalPrice=totalPrice-#money#]]></action>\n    </mvel-rule>\n</rule-set>\n'),(6,'无限制型订单代金券','ORDER',0,0,'\n<rule-set name=\"getFinalPrice\" >\n    <mvel-rule id=\"step1\" multipleTimes=\"false\" exclusive=\"true\" valid=\"true\">\n        <condition><![CDATA[true]]></condition>\n        <action><![CDATA[finalPrice=totalPrice-#money#]]></action>\n    </mvel-rule>\n</rule-set>\n'),(7,'限制型订单折扣券','ORDER',1,1,'\n<rule-set name=\"getFinalPrice\" >\n    <mvel-rule id=\"step1\" multipleTimes=\"false\" exclusive=\"true\" valid=\"true\">\n        <condition><![CDATA[totalPrice>=#totalPrice#]]></condition>\n        <action><![CDATA[finalPrice=totalPrice*#discount#/100]]></action>\n    </mvel-rule>\n</rule-set>\n'),(8,'无限制型订单折扣券','ORDER',0,1,'\n<rule-set name=\"getFinalPrice\" >\n    <mvel-rule id=\"step1\" multipleTimes=\"false\" exclusive=\"true\" valid=\"true\">\n        <condition><![CDATA[true]]></condition>\n        <action><![CDATA[finalPrice=totalPrice*#discount#/100]]></action>\n    </mvel-rule>\n</rule-set>\n'),(9,'拼团活动免单券','MARKETING_PIECE_GROUP',0,2,'\n<rule-set name=\"getFinalPrice\" >\n    <mvel-rule id=\"step1\" multipleTimes=\"false\" exclusive=\"true\" valid=\"true\">\n        <condition><![CDATA[\"MARKETING_PIECE_GROUP\".equals(type)]]></condition>\n        <action><![CDATA[finalPrice=0.0]]></action>\n    </mvel-rule>\n</rule-set>\n');
/*!40000 ALTER TABLE `t_coupon_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_coupon_type`
--

DROP TABLE IF EXISTS `t_coupon_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_coupon_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `name` varchar(200) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `is_limited` int(11) DEFAULT NULL,
  `auto_give` int(11) DEFAULT '0',
  `up_to` int(11) DEFAULT NULL,
  `display_name` varchar(200) DEFAULT NULL,
  `money` int(11) DEFAULT '0',
  `discount` int(11) DEFAULT '0',
  `description` text,
  `cond` text,
  `valid_days` int(11) DEFAULT NULL,
  `template` text,
  `code` varchar(200) DEFAULT NULL,
  `enabled` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_coupon_type`
--

LOCK TABLES `t_coupon_type` WRITE;
/*!40000 ALTER TABLE `t_coupon_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_coupon_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_customer_service_type`
--

DROP TABLE IF EXISTS `t_customer_service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_customer_service_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer_service_type`
--

LOCK TABLES `t_customer_service_type` WRITE;
/*!40000 ALTER TABLE `t_customer_service_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_customer_service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_event_log`
--

DROP TABLE IF EXISTS `t_event_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_event_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `user_agent` varchar(255) DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `event_type` varchar(100) DEFAULT NULL,
  `data` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_event_log`
--

LOCK TABLES `t_event_log` WRITE;
/*!40000 ALTER TABLE `t_event_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_event_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_express`
--

DROP TABLE IF EXISTS `t_express`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_express` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `name` varchar(200) NOT NULL,
  `enabled` int(11) NOT NULL DEFAULT '1',
  `is_default` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_express`
--

LOCK TABLES `t_express` WRITE;
/*!40000 ALTER TABLE `t_express` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_express` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_faq`
--

DROP TABLE IF EXISTS `t_faq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_faq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `created_date` timestamp NULL DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_faq_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_faq_type` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_faq`
--

LOCK TABLES `t_faq` WRITE;
/*!40000 ALTER TABLE `t_faq` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_faq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_faq_type`
--

DROP TABLE IF EXISTS `t_faq_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_faq_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_faq_type`
--

LOCK TABLES `t_faq_type` WRITE;
/*!40000 ALTER TABLE `t_faq_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_faq_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_fare_template`
--

DROP TABLE IF EXISTS `t_fare_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_fare_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `shop_addr` varchar(100) DEFAULT NULL,
  `dispatch_time` varchar(20) DEFAULT NULL,
  `is_incl_postage` int(11) DEFAULT '1',
  `valuation_model` int(11) NOT NULL,
  `is_incl_postage_by_if` int(11) DEFAULT '0',
  `last_modified_date` datetime DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `message_format` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_fare_template`
--

LOCK TABLES `t_fare_template` WRITE;
/*!40000 ALTER TABLE `t_fare_template` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_fare_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_feedback`
--

DROP TABLE IF EXISTS `t_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `content` text,
  `created_date` timestamp NULL DEFAULT NULL,
  `unread` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_feedback_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_feedback`
--

LOCK TABLES `t_feedback` WRITE;
/*!40000 ALTER TABLE `t_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_feedback_image`
--

DROP TABLE IF EXISTS `t_feedback_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_feedback_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `feedback_id` int(11) NOT NULL,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_feedback_image`
--

LOCK TABLES `t_feedback_image` WRITE;
/*!40000 ALTER TABLE `t_feedback_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_feedback_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_incl_postage_proviso`
--

DROP TABLE IF EXISTS `t_incl_postage_proviso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_incl_postage_proviso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fare_id` int(11) NOT NULL,
  `region` varchar(200) DEFAULT NULL,
  `piece_no` int(11) DEFAULT NULL,
  `weight_no` int(11) DEFAULT NULL,
  `bulk_no` int(11) DEFAULT NULL,
  `amount` decimal(18,2) DEFAULT NULL,
  `carry_way` int(11) DEFAULT '0',
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fare_id` (`fare_id`),
  CONSTRAINT `t_incl_postage_proviso_ibfk_1` FOREIGN KEY (`fare_id`) REFERENCES `t_fare_template` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_incl_postage_proviso`
--

LOCK TABLES `t_incl_postage_proviso` WRITE;
/*!40000 ALTER TABLE `t_incl_postage_proviso` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_incl_postage_proviso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_kf_qq`
--

DROP TABLE IF EXISTS `t_kf_qq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_kf_qq` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `number` varchar(100) DEFAULT NULL,
  `enabled` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_kf_qq`
--

LOCK TABLES `t_kf_qq` WRITE;
/*!40000 ALTER TABLE `t_kf_qq` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_kf_qq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_marketing_config`
--

DROP TABLE IF EXISTS `t_marketing_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_marketing_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `enabled` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_marketing_config`
--

LOCK TABLES `t_marketing_config` WRITE;
/*!40000 ALTER TABLE `t_marketing_config` DISABLE KEYS */;
INSERT INTO `t_marketing_config` VALUES (1,'PIECEGROUP',1),(2,'WHOLESALE',1),(3,'TRIAL',1);
/*!40000 ALTER TABLE `t_marketing_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_ext`
--

DROP TABLE IF EXISTS `t_member_ext`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member_ext` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `level_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `point` int(11) NOT NULL DEFAULT '0',
  `total_credit` int(11) DEFAULT '0' COMMENT '累计积分',
  `credit` int(11) DEFAULT '0' COMMENT '可用积分',
  `be_member_time` datetime DEFAULT NULL COMMENT '成为会员时间',
  `consume_amount` int(11) DEFAULT '0' COMMENT '累计消费金额',
  `consume_count` int(11) DEFAULT '0' COMMENT '累计消费次数',
  `last_consume_time` datetime DEFAULT NULL COMMENT '最后消费时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `level_id` (`level_id`),
  CONSTRAINT `t_member_ext_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_member_ext_ibfk_2` FOREIGN KEY (`level_id`) REFERENCES `t_member_level` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_ext`
--

LOCK TABLES `t_member_ext` WRITE;
/*!40000 ALTER TABLE `t_member_ext` DISABLE KEYS */;
INSERT INTO `t_member_ext` VALUES (1,1,1,'admin',NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,0,0,NULL),(2,2,1,'Derek',NULL,NULL,NULL,NULL,NULL,0,0,0,NULL,0,0,NULL);
/*!40000 ALTER TABLE `t_member_ext` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_level`
--

DROP TABLE IF EXISTS `t_member_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `point` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_level`
--

LOCK TABLES `t_member_level` WRITE;
/*!40000 ALTER TABLE `t_member_level` DISABLE KEYS */;
INSERT INTO `t_member_level` VALUES (1,'Level 1',NULL,1000),(2,'Level 2',NULL,2000),(3,'Level 3',NULL,5000),(4,'Level 4',NULL,10000);
/*!40000 ALTER TABLE `t_member_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_point_history`
--

DROP TABLE IF EXISTS `t_member_point_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member_point_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_ext_id` int(11) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `point` int(11) NOT NULL,
  `changed_point` int(11) NOT NULL,
  `changed_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `member_ext_id` (`member_ext_id`),
  CONSTRAINT `t_member_point_history_ibfk_1` FOREIGN KEY (`member_ext_id`) REFERENCES `t_member_ext` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_point_history`
--

LOCK TABLES `t_member_point_history` WRITE;
/*!40000 ALTER TABLE `t_member_point_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_member_point_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_menu`
--

DROP TABLE IF EXISTS `t_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `sort_order` int(11) NOT NULL DEFAULT '1',
  `parent_id` int(11) DEFAULT NULL,
  `visible` int(11) DEFAULT '1',
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `t_menu_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `t_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1207 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_menu`
--

LOCK TABLES `t_menu` WRITE;
/*!40000 ALTER TABLE `t_menu` DISABLE KEYS */;
INSERT INTO `t_menu` VALUES (1,'menu.home','',1,NULL,1,'<i class=\"fa fa-home fa-fw\" aria-hidden=\"true\"></i>'),(100,'menu.identity',NULL,2,NULL,1,'<i class=\"fa fa-id-badge fa-fw\" aria-hidden=\"true\"></i>'),(101,'menu.user','user',1,100,1,NULL),(102,'menu.role','role',2,100,1,NULL),(103,'menu.user_join_notify','user_join_notify',3,100,1,NULL),(111,'menu.staff','staff',3,100,1,NULL),(200,'menu.product_mgmt',NULL,3,NULL,1,'<i class=\"fa fa-shopping-bag fa-fw\" aria-hidden=\"true\"></i>'),(201,'menu.product_category','product_category',1,200,1,NULL),(202,'menu.product','product',2,200,1,NULL),(203,'menu.fare_template','fare_template',3,200,1,NULL),(204,'menu.purchase_strategy','purchase_strategy',4,200,1,NULL),(205,'menu.product_hit_word','product_hit_word',5,200,1,NULL),(206,'menu.product_brand','product_brand',6,200,1,NULL),(210,'menu.product_tag','product_tag',7,200,1,NULL),(300,'menu.order_mgmt',NULL,4,NULL,1,'<i class=\"fa fa-cubes fa-fw\" aria-hidden=\"true\"></i>'),(301,'menu.order','order',1,300,1,NULL),(302,'menu.express','express',3,300,1,NULL),(303,'menu.return','return_refund_order',2,300,1,NULL),(304,'menu.order_statistic','order_statistic',3,300,1,NULL),(305,'menu.store_order','store_order',1,300,1,NULL),(310,'menu.trial_application','trial_application',4,300,1,NULL),(400,'menu.cooperative-partner',NULL,4,NULL,1,'<i class=\"fa fa-handshake-o fa-fw\" aria-hidden=\"true\"></i>'),(401,'menu.seller','seller',1,400,1,NULL),(402,'menu.agent','agent',2,400,1,NULL),(403,'menu.partner','partner',3,400,1,NULL),(404,'menu.settings','settings',5,400,1,NULL),(405,'menu.sellerApply','seller_apply',6,400,1,NULL),(406,'menu.crown','crown',4,400,1,NULL),(407,'menu.physicalSeller','physical_seller',7,400,1,NULL),(408,'menu.cooperativeStatistic','cooperative_statistic',8,400,1,NULL),(409,'menu.copartner','copartner',7,400,1,NULL),(500,'menu.settlement',NULL,3,NULL,1,'<i class=\"fa fa-jpy fa-fw\" aria-hidden=\"true\"></i>'),(501,'menu.orderItemReward','order_item_reward',1,500,1,NULL),(502,'menu.rewardCash','reward_cash',2,500,1,NULL),(503,'menu.ownerBalance','owner_balance',3,500,1,NULL),(504,'menu.withdraw_account','withdraw_account',4,500,1,NULL),(600,'menu.config','config',7,NULL,1,'<i class=\"fa fa-wrench fa-fw\" aria-hidden=\"true\"></i>'),(700,'menu.event_log','event_log',8,NULL,1,'<i class=\"fa fa-info-circle fa-fw\" aria-hidden=\"true\"></i>'),(800,'menu.member_mgmt',NULL,9,NULL,1,'<i class=\"fa fa-user-circle-o fa-fw\" aria-hidden=\"true\"></i>'),(801,'menu.member_level','member_level',1,800,1,NULL),(802,'menu.member','member',2,800,1,NULL),(803,'menu.coupon_type','coupon_type',3,800,1,NULL),(804,'menu.coupon','coupon',4,800,1,NULL),(805,'menu.coupon_strategy','coupon_strategy',5,800,1,NULL),(806,'menu.coupon_statistic','coupon_statistic',6,800,1,NULL),(900,'menu.misc-config',NULL,3,NULL,1,'<i class=\"fa fa-cogs fa-fw\" aria-hidden=\"true\"></i>'),(901,'menu.feedback','feedback',1,900,1,NULL),(902,'menu.faq','faq',2,900,1,NULL),(903,'menu.aboutMall','about_mall',3,900,1,NULL),(904,'menu.ad','ad',3,900,1,NULL),(905,'menu.customer_service_type','customer_service_type',4,900,1,NULL),(906,'menu.kf_qq','kf_qq',5,900,1,NULL),(907,'menu.system_announcement','system_announcement',6,900,1,NULL),(1000,'menu.wechat_mgmt',NULL,6,NULL,1,'<i class=\"fa fa-weixin fa-fw\" aria-hidden=\"true\"></i>'),(1001,'menu.wechat_menu','wechat_menu',1,1000,1,NULL),(1002,'menu.wechat_cert','wechat_cert',2,1000,1,NULL),(1004,'menu.wechat_template_message','wechat_template_message',3,1000,1,NULL),(1005,'menu.wechat_customer_service','wechat_customer_service',4,1000,1,NULL),(1006,'menu.wechat_autoreply','wechat_autoreply',5,1000,1,NULL),(1100,'menu.marketing_mgmt',NULL,11,NULL,1,'<i class=\"fa fa-plane fa-fw\" aria-hidden=\"true\"></i>'),(1101,'menu.piece_group_purchase','piece_group_purchase',1,1100,1,NULL),(1102,'menu.wholesale','wholesale',2,1100,1,NULL),(1103,'menu.trial','trial',3,1100,1,NULL),(1200,'menu.merchant_mgmt',NULL,11,NULL,1,'<i class=\"fa fa-car\" aria-hidden=\"true\"></i>'),(1201,'menu.merchant_config','merchant_config',1,1200,1,NULL),(1202,'menu.settled_merchant','settled_merchant',2,1200,1,NULL),(1203,'menu.settled_merchant_info','settled_merchant_info',3,1200,1,NULL),(1204,'menu.settled_merchant_coupon','settled_merchant_coupon',4,1200,1,NULL),(1205,'menu.settled_merchant_settlement','settled_merchant_settlement',5,1200,1,NULL),(1206,'menu.settled_merchant_product','settled_merchant_product',3,1200,1,NULL);
/*!40000 ALTER TABLE `t_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_merchant_message`
--

DROP TABLE IF EXISTS `t_merchant_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_merchant_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_id` int(11) NOT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `unread` int(11) NOT NULL DEFAULT '1',
  `title` varchar(100) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`),
  KEY `merchant_id` (`merchant_id`),
  CONSTRAINT `t_merchant_message_ibfk_1` FOREIGN KEY (`merchant_id`) REFERENCES `t_settled_merchant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_merchant_message`
--

LOCK TABLES `t_merchant_message` WRITE;
/*!40000 ALTER TABLE `t_merchant_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_merchant_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_merchant_options`
--

DROP TABLE IF EXISTS `t_merchant_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_merchant_options` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `max_level` int(11) NOT NULL,
  `pool_priority` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_merchant_options`
--

LOCK TABLES `t_merchant_options` WRITE;
/*!40000 ALTER TABLE `t_merchant_options` DISABLE KEYS */;
INSERT INTO `t_merchant_options` VALUES (1,3,1);
/*!40000 ALTER TABLE `t_merchant_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_merchant_product_category`
--

DROP TABLE IF EXISTS `t_merchant_product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_merchant_product_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `visible` int(11) NOT NULL DEFAULT '0',
  `sort_order` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `merchant_id` (`merchant_id`),
  CONSTRAINT `t_merchant_product_category_ibfk_1` FOREIGN KEY (`merchant_id`) REFERENCES `t_settled_merchant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_merchant_product_category`
--

LOCK TABLES `t_merchant_product_category` WRITE;
/*!40000 ALTER TABLE `t_merchant_product_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_merchant_product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_notification`
--

DROP TABLE IF EXISTS `t_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifier` varchar(100) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `display_mode` int(11) DEFAULT '0',
  `badge_url` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `timeout` int(11) DEFAULT '60',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_notification`
--

LOCK TABLES `t_notification` WRITE;
/*!40000 ALTER TABLE `t_notification` DISABLE KEYS */;
INSERT INTO `t_notification` VALUES (1,'notification.withdraw_apply','提现申请','有新的提现申请,等待处理','<i class=\"fa fa-ticket fa-lg\" aria-hidden=\"true\"></i>',1,'/reward_cash/countApplying','/reward_cash?status=APPLYING',90),(2,'notification.return_order','退款退货订单','退款退货订单','<i class=\"fa fa-tree fa-lg\" aria-hidden=\"true\"></i>',1,'/order/returnRefundOrderCount','/return_refund_order',60),(3,'notification.seller_apply','合作伙伴申请','合作伙伴申请','<i class=\"fa fa-street-view fa-lg\" aria-hidden=\"true\"></i>',1,'/seller_apply/applyCount','/seller_apply?status=INIT',300),(4,'notification.feedback','意见反馈','意见反馈','<i class=\"fa fa-envelope\" aria-hidden=\"true\"></i>',1,'/feedback/feedbackCount','/feedback',300),(5,'notification.user_notify_unread_count','新用户通知','新用户通知','<i class=\"fa fa-id-badge fa-lg\" aria-hidden=\"true\"></i>',1,'/user_join_notify/unreadCount','/user_join_notify?isRead=0',60),(6,'notification.new_order','新订单','新订单','<i class=\"fa fa-sun-o fa-lg\" aria-hidden=\"true\"></i>',1,'/order/newOrderCount','/order?statuses=PAID_CONFIRM_PENDING&statuses=CONFIRMED_DELIVER_PENDING',60);
/*!40000 ALTER TABLE `t_notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `order_number` varchar(50) DEFAULT NULL,
  `trade_number` varchar(50) DEFAULT NULL,
  `payment_type` varchar(50) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `pay_date` datetime DEFAULT NULL,
  `confirm_date` datetime DEFAULT NULL,
  `deliver_date` datetime DEFAULT NULL,
  `delivered_date` datetime DEFAULT NULL,
  `deal_date` datetime DEFAULT NULL,
  `deliver_order_number` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `total_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `freight` decimal(10,2) NOT NULL DEFAULT '0.00',
  `description` text,
  `remark` varchar(250) DEFAULT NULL,
  `invoice` int(11) DEFAULT '0',
  `invoice_title` varchar(200) DEFAULT NULL,
  `receiving_time` varchar(100) DEFAULT NULL,
  `zip` char(6) DEFAULT NULL,
  `contact_user` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `detail` varchar(200) DEFAULT NULL,
  `cover` varchar(200) DEFAULT NULL,
  `express_number` varchar(100) DEFAULT NULL,
  `express_company` varchar(100) DEFAULT NULL,
  `express_code` varchar(100) DEFAULT NULL,
  `settled` int(11) DEFAULT '0',
  `previous_status` varchar(50) DEFAULT NULL,
  `is_deliver_reminder` int(11) DEFAULT '0',
  `is_deleted` int(11) DEFAULT '0',
  `point_exchange_rate` int(11) DEFAULT '100',
  `coupon_info` varchar(250) DEFAULT NULL,
  `marketing` varchar(50) DEFAULT NULL,
  `marketing_id` int(11) DEFAULT NULL,
  `marketing_description` varchar(250) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  `mname` varchar(50) DEFAULT NULL,
  `store_id` varchar(50) DEFAULT NULL,
  `store_code` varchar(50) DEFAULT NULL,
  `store_name` varchar(50) DEFAULT NULL,
  `store_cover` varchar(250) DEFAULT NULL,
  `store_address` varchar(250) DEFAULT NULL,
  `followed_store_id` varchar(50) DEFAULT NULL,
  `followed_store_code` varchar(50) DEFAULT NULL,
  `followed_store_name` varchar(50) DEFAULT NULL,
  `followed_store_cover` varchar(250) DEFAULT NULL,
  `binding_store_id` varchar(50) DEFAULT NULL,
  `binding_store_code` varchar(50) DEFAULT NULL,
  `binding_store_name` varchar(50) DEFAULT NULL,
  `binding_store_cover` varchar(250) DEFAULT NULL,
  `store_guide_user_id` varchar(50) DEFAULT NULL,
  `store_guide_user_code` varchar(50) DEFAULT NULL,
  `store_guide_user_name` varchar(50) DEFAULT NULL,
  `store_user_id` varchar(50) DEFAULT NULL,
  `store_user_code` varchar(50) DEFAULT NULL,
  `store_user_name` varchar(50) DEFAULT NULL,
  `inviter_user_id` varchar(50) DEFAULT NULL,
  `inviter_user_name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT 'ORDER',
  `pay_credit` int(11) DEFAULT '0',
  `delivery_type` varchar(50) DEFAULT 'EXPRESS',
  `origin` varchar(50) DEFAULT NULL,
  `comment_id` varchar(50) DEFAULT NULL COMMENT '评价ID',
  `refund_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '退货款金额',
  `supplementary_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '换货补差价金额',
  `origin_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '原价',
  `coupon_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠券价钱',
  `credit_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '积分抵扣价钱',
  `ext_coupon_id` varchar(50) DEFAULT NULL COMMENT '第三方优惠券的优惠券ID',
  `ext_user_type` varchar(50) DEFAULT NULL COMMENT '第三方优惠券的用户类型',
  `ext_coupon_type` varchar(50) DEFAULT NULL COMMENT '第三方优惠券的优惠券类型',
  `ext_discount` int(11) DEFAULT NULL COMMENT '第三方优惠券的折扣率',
  `ext_cuts` int(11) DEFAULT NULL COMMENT '第三方优惠券的优惠',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_customer_service`
--

DROP TABLE IF EXISTS `t_order_customer_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_customer_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `express_number` varchar(100) DEFAULT NULL,
  `express_company` varchar(100) DEFAULT NULL,
  `express_code` varchar(100) DEFAULT NULL,
  `reason` varchar(200) DEFAULT NULL,
  `service_type` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `log` text,
  `images` text,
  `refund_fee` decimal(10,2) DEFAULT NULL,
  `supplementary_fee` decimal(10,2) DEFAULT NULL COMMENT '补款金额(用于换货单)',
  `store_id` varchar(50) DEFAULT NULL,
  `store_name` varchar(50) DEFAULT NULL,
  `store_user_id` varchar(50) DEFAULT NULL,
  `store_user_name` varchar(50) DEFAULT NULL,
  `service_number` varchar(50) DEFAULT NULL COMMENT '售后单号',
  `result` varchar(250) DEFAULT NULL COMMENT '处理结果',
  `refund_way` varchar(50) DEFAULT 'ORIGINAL_PATH',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `t_order_customer_service_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_customer_service`
--

LOCK TABLES `t_order_customer_service` WRITE;
/*!40000 ALTER TABLE `t_order_customer_service` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_order_customer_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_customer_service_item`
--

DROP TABLE IF EXISTS `t_order_customer_service_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_customer_service_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_customer_service_id` int(11) NOT NULL COMMENT '售后单id',
  `refund_fee` decimal(10,2) DEFAULT NULL COMMENT '退款金额(仅退回项使用)',
  `type` varchar(50) NOT NULL DEFAULT 'RETURN' COMMENT '项类型(RETURN 退回项 EXCHANGE 置换项)',
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `product_name` varchar(100) DEFAULT NULL COMMENT '产品名称',
  `quantity` int(11) NOT NULL DEFAULT '1' COMMENT '退回项：退回数量/件 置换项：置换数量/件',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '单价',
  `final_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '退回项：原支付金额 置换项：置换项金额',
  `cost_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '成本价',
  `cover` varchar(200) DEFAULT NULL COMMENT '产品封面',
  `product_specification_name` varchar(200) DEFAULT NULL COMMENT '产品规格名',
  `product_specification_id` int(11) DEFAULT NULL COMMENT '产品规格id',
  `weight` int(11) DEFAULT '0' COMMENT '重量',
  `marketing` varchar(50) DEFAULT NULL COMMENT '营销活动记录',
  `marketing_id` int(11) DEFAULT NULL COMMENT '营销活动id',
  `marketing_description` varchar(250) DEFAULT NULL COMMENT '营销活动描述',
  PRIMARY KEY (`id`),
  KEY `order_customer_service_id` (`order_customer_service_id`),
  CONSTRAINT `t_order_customer_service_item_ibfk_1` FOREIGN KEY (`order_customer_service_id`) REFERENCES `t_order_customer_service` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_customer_service_item`
--

LOCK TABLES `t_order_customer_service_item` WRITE;
/*!40000 ALTER TABLE `t_order_customer_service_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_order_customer_service_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_item`
--

DROP TABLE IF EXISTS `t_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `quantity` int(11) NOT NULL DEFAULT '1',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `final_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `status` varchar(50) DEFAULT NULL,
  `cost_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `cover` varchar(200) DEFAULT NULL,
  `partner_level_zone` int(11) DEFAULT NULL,
  `product_specification_name` varchar(200) DEFAULT NULL,
  `product_specification_id` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT '0',
  `bulk` int(11) DEFAULT '0',
  `barcode` varchar(100) DEFAULT NULL,
  `store_location` varchar(200) DEFAULT NULL,
  `marketing` varchar(50) DEFAULT NULL,
  `marketing_id` int(11) DEFAULT NULL,
  `marketing_description` varchar(250) DEFAULT NULL,
  `sku_id` varchar(50) DEFAULT NULL COMMENT 'SKU ID',
  `warehouse_id` varchar(50) DEFAULT NULL COMMENT 'WAERHOUSE ID',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_item`
--

LOCK TABLES `t_order_item` WRITE;
/*!40000 ALTER TABLE `t_order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_item_reward`
--

DROP TABLE IF EXISTS `t_order_item_reward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_item_reward` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `order_number` varchar(200) DEFAULT NULL,
  `order_total_price` decimal(10,2) DEFAULT NULL,
  `order_created_time` datetime DEFAULT NULL,
  `order_paid_time` datetime DEFAULT NULL,
  `order_item_id` int(11) DEFAULT NULL,
  `order_profit` decimal(10,2) DEFAULT '0.00',
  `percent` int(11) DEFAULT NULL,
  `reward` decimal(10,2) NOT NULL DEFAULT '0.00',
  `owner_id` int(11) NOT NULL,
  `level` int(11) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `settled_time` datetime DEFAULT NULL,
  `withdrawn_time` datetime DEFAULT NULL,
  `order_user_name` varchar(100) DEFAULT NULL,
  `payment_type` varchar(50) DEFAULT NULL,
  `point_exchange_rate` int(11) DEFAULT '100',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `owner_id` (`owner_id`),
  KEY `order_item_id` (`order_item_id`),
  CONSTRAINT `t_order_item_reward_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`) ON DELETE SET NULL,
  CONSTRAINT `t_order_item_reward_ibfk_2` FOREIGN KEY (`owner_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_order_item_reward_ibfk_3` FOREIGN KEY (`order_item_id`) REFERENCES `t_order_item` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_item_reward`
--

LOCK TABLES `t_order_item_reward` WRITE;
/*!40000 ALTER TABLE `t_order_item_reward` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_order_item_reward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_process_log`
--

DROP TABLE IF EXISTS `t_order_process_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_process_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `process_date` timestamp NULL DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `t_order_process_log_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_process_log`
--

LOCK TABLES `t_order_process_log` WRITE;
/*!40000 ALTER TABLE `t_order_process_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_order_process_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_statistic`
--

DROP TABLE IF EXISTS `t_order_statistic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_statistic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `sales_amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_statistic`
--

LOCK TABLES `t_order_statistic` WRITE;
/*!40000 ALTER TABLE `t_order_statistic` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_order_statistic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_owner_balance`
--

DROP TABLE IF EXISTS `t_owner_balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_owner_balance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `balance` decimal(10,2) NOT NULL DEFAULT '0.00',
  `version` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_owner_balance_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_owner_balance`
--

LOCK TABLES `t_owner_balance` WRITE;
/*!40000 ALTER TABLE `t_owner_balance` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_owner_balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_partner_level`
--

DROP TABLE IF EXISTS `t_partner_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_partner_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `headcount_quota` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_partner_level`
--

LOCK TABLES `t_partner_level` WRITE;
/*!40000 ALTER TABLE `t_partner_level` DISABLE KEYS */;
INSERT INTO `t_partner_level` VALUES (1,'一星经销商',1,500),(2,'二星经销商',2,1000),(3,'三星经销商',3,3000),(4,'四星经销商',4,900),(5,'五星经销商',5,27000),(6,'六星经销商',6,NULL);
/*!40000 ALTER TABLE `t_partner_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pcd`
--

DROP TABLE IF EXISTS `t_pcd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pcd` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `t_pcd_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `t_pcd` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3657 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pcd`
--

LOCK TABLES `t_pcd` WRITE;
/*!40000 ALTER TABLE `t_pcd` DISABLE KEYS */;
INSERT INTO `t_pcd` VALUES (1,'北京','p',NULL),(2,'北京','c',1),(3,'东城区','d',2),(4,'西城区','d',2),(5,'崇文区','d',2),(6,'宣武区','d',2),(7,'朝阳区','d',2),(8,'丰台区','d',2),(9,'石景山区','d',2),(10,'海淀区','d',2),(11,'门头沟区','d',2),(12,'房山区','d',2),(13,'通州区','d',2),(14,'顺义区','d',2),(15,'昌平区','d',2),(16,'大兴区','d',2),(17,'平谷区','d',2),(18,'怀柔区','d',2),(19,'密云县','d',2),(20,'延庆县','d',2),(21,'天津','p',NULL),(22,'天津','c',21),(23,'和平区','d',22),(24,'河东区','d',22),(25,'河西区','d',22),(26,'南开区','d',22),(27,'河北区','d',22),(28,'红桥区','d',22),(29,'塘沽区','d',22),(30,'汉沽区','d',22),(31,'大港区','d',22),(32,'东丽区','d',22),(33,'西青区','d',22),(34,'津南区','d',22),(35,'北辰区','d',22),(36,'武清区','d',22),(37,'宝坻区','d',22),(38,'宁河县','d',22),(39,'静海县','d',22),(40,'蓟  县','d',22),(41,'河北','p',NULL),(42,'石家庄','c',41),(43,'长安区','d',42),(44,'桥东区','d',42),(45,'桥西区','d',42),(46,'新华区','d',42),(47,'郊  区','d',42),(48,'井陉矿区','d',42),(49,'井陉县','d',42),(50,'正定县','d',42),(51,'栾城县','d',42),(52,'行唐县','d',42),(53,'灵寿县','d',42),(54,'高邑县','d',42),(55,'深泽县','d',42),(56,'赞皇县','d',42),(57,'无极县','d',42),(58,'平山县','d',42),(59,'元氏县','d',42),(60,'赵  县','d',42),(61,'辛集市','d',42),(62,'藁','d',42),(63,'晋州市','d',42),(64,'新乐市','d',42),(65,'鹿泉市','d',42),(66,'唐山','c',41),(67,'路南区','d',66),(68,'路北区','d',66),(69,'古冶区','d',66),(70,'开平区','d',66),(71,'新  区','d',66),(72,'丰润县','d',66),(73,'滦  县','d',66),(74,'滦南县','d',66),(75,'乐亭县','d',66),(76,'迁西县','d',66),(77,'玉田县','d',66),(78,'唐海县','d',66),(79,'遵化市','d',66),(80,'丰南市','d',66),(81,'迁安市','d',66),(82,'秦皇岛','c',41),(83,'海港区','d',82),(84,'山海关区','d',82),(85,'北戴河区','d',82),(86,'青龙满族自治县','d',82),(87,'昌黎县','d',82),(88,'抚宁县','d',82),(89,'卢龙县','d',82),(90,'邯郸','c',41),(91,'邯山区','d',90),(92,'丛台区','d',90),(93,'复兴区','d',90),(94,'峰峰矿区','d',90),(95,'邯郸县','d',90),(96,'临漳县','d',90),(97,'成安县','d',90),(98,'大名县','d',90),(99,'涉  县','d',90),(100,'磁  县','d',90),(101,'肥乡县','d',90),(102,'永年县','d',90),(103,'邱  县','d',90),(104,'鸡泽县','d',90),(105,'广平县','d',90),(106,'馆陶县','d',90),(107,'魏  县','d',90),(108,'曲周县','d',90),(109,'武安市','d',90),(110,'邢台','c',41),(111,'桥东区','d',110),(112,'桥西区','d',110),(113,'邢台县','d',110),(114,'临城县','d',110),(115,'内丘县','d',110),(116,'柏乡县','d',110),(117,'隆尧县','d',110),(118,'任  县','d',110),(119,'南和县','d',110),(120,'宁晋县','d',110),(121,'巨鹿县','d',110),(122,'新河县','d',110),(123,'广宗县','d',110),(124,'平乡县','d',110),(125,'威  县','d',110),(126,'清河县','d',110),(127,'临西县','d',110),(128,'南宫市','d',110),(129,'沙河市','d',110),(130,'保定','c',41),(131,'新市区','d',130),(132,'北市区','d',130),(133,'南市区','d',130),(134,'满城县','d',130),(135,'清苑县','d',130),(136,'涞水县','d',130),(137,'阜平县','d',130),(138,'徐水县','d',130),(139,'定兴县','d',130),(140,'唐  县','d',130),(141,'高阳县','d',130),(142,'容城县','d',130),(143,'涞源县','d',130),(144,'望都县','d',130),(145,'安新县','d',130),(146,'易  县','d',130),(147,'曲阳县','d',130),(148,'蠡  县','d',130),(149,'顺平县','d',130),(150,'博野','d',130),(151,'雄县','d',130),(152,'涿州市','d',130),(153,'定州市','d',130),(154,'安国市','d',130),(155,'高碑店市','d',130),(156,'张家口','c',41),(157,'桥东区','d',156),(158,'桥西区','d',156),(159,'宣化区','d',156),(160,'下花园区','d',156),(161,'宣化县','d',156),(162,'张北县','d',156),(163,'康保县','d',156),(164,'沽源县','d',156),(165,'尚义县','d',156),(166,'蔚  县','d',156),(167,'阳原县','d',156),(168,'怀安县','d',156),(169,'万全县','d',156),(170,'怀来县','d',156),(171,'涿鹿县','d',156),(172,'赤城县','d',156),(173,'崇礼县','d',156),(174,'承德','c',41),(175,'双桥区','d',174),(176,'双滦区','d',174),(177,'鹰手营子矿区','d',174),(178,'承德县','d',174),(179,'兴隆县','d',174),(180,'平泉县','d',174),(181,'滦平县','d',174),(182,'隆化县','d',174),(183,'丰宁满族自治县','d',174),(184,'宽城满族自治县','d',174),(185,'围场满族蒙古族自治县','d',174),(186,'沧州','c',41),(187,'新华区','d',186),(188,'运河区','d',186),(189,'沧  县','d',186),(190,'青  县','d',186),(191,'东光县','d',186),(192,'海兴县','d',186),(193,'盐山县','d',186),(194,'肃宁县','d',186),(195,'南皮县','d',186),(196,'吴桥县','d',186),(197,'献  县','d',186),(198,'孟村回族自治县','d',186),(199,'泊头市','d',186),(200,'任丘市','d',186),(201,'黄骅市','d',186),(202,'河间市','d',186),(203,'廊坊','c',41),(204,'安次区','d',203),(205,'固安县','d',203),(206,'永清县','d',203),(207,'香河县','d',203),(208,'大城县','d',203),(209,'文安县','d',203),(210,'大厂回族自治县','d',203),(211,'霸州市','d',203),(212,'三河市','d',203),(213,'衡水','c',41),(214,'桃城区','d',213),(215,'枣强县','d',213),(216,'武邑县','d',213),(217,'武强县','d',213),(218,'饶阳县','d',213),(219,'安平县','d',213),(220,'故城县','d',213),(221,'景  县','d',213),(222,'阜城县','d',213),(223,'冀州市','d',213),(224,'深州市','d',213),(225,'山西','p',NULL),(226,'太原','c',225),(227,'小店区','d',226),(228,'迎泽区','d',226),(229,'杏花岭区','d',226),(230,'尖草坪区','d',226),(231,'万柏林区','d',226),(232,'晋源区','d',226),(233,'清徐县','d',226),(234,'阳曲县','d',226),(235,'娄烦县','d',226),(236,'古交市','d',226),(237,'大同','c',225),(238,'城  区','d',237),(239,'矿  区','d',237),(240,'南郊区','d',237),(241,'新荣区','d',237),(242,'阳高县','d',237),(243,'天镇县','d',237),(244,'广灵县','d',237),(245,'灵丘县','d',237),(246,'浑源县','d',237),(247,'左云县','d',237),(248,'大同县','d',237),(249,'阳泉','c',225),(250,'城  区','d',249),(251,'矿  区','d',249),(252,'郊  区','d',249),(253,'平定县','d',249),(254,'盂  县','d',249),(255,'长治','c',225),(256,'城  区','d',255),(257,'郊  区','d',255),(258,'长治县','d',255),(259,'襄垣县','d',255),(260,'屯留县','d',255),(261,'平顺县','d',255),(262,'黎城县','d',255),(263,'壶关县','d',255),(264,'长子县','d',255),(265,'武乡县','d',255),(266,'沁  县','d',255),(267,'沁源县','d',255),(268,'潞城市','d',255),(269,'晋城','c',225),(270,'城  区','d',269),(271,'沁水县','d',269),(272,'阳城县','d',269),(273,'陵川县','d',269),(274,'泽州县','d',269),(275,'高平市','d',269),(276,'朔州','c',225),(277,'朔城区','d',276),(278,'平鲁区','d',276),(279,'山阴县','d',276),(280,'应  县','d',276),(281,'右玉县','d',276),(282,'怀仁县','d',276),(283,'忻州','c',225),(284,'忻府区','d',283),(285,'原平市','d',283),(286,'定襄县','d',283),(287,'五台县','d',283),(288,'代  县','d',283),(289,'繁峙县','d',283),(290,'宁武县','d',283),(291,'静乐县','d',283),(292,'神池县','d',283),(293,'五寨县','d',283),(294,'岢岚县','d',283),(295,'河曲县','d',283),(296,'保德县','d',283),(297,'偏关县','d',283),(298,'吕梁','c',225),(299,'离石区','d',298),(300,'孝义市','d',298),(301,'汾阳市','d',298),(302,'文水县','d',298),(303,'交城县','d',298),(304,'兴  县','d',298),(305,'临  县','d',298),(306,'柳林县','d',298),(307,'石楼县','d',298),(308,'岚  县','d',298),(309,'方山县','d',298),(310,'中阳县','d',298),(311,'交口县','d',298),(312,'晋中','c',225),(313,'榆次市','d',312),(314,'介休市','d',312),(315,'榆社县','d',312),(316,'左权县','d',312),(317,'和顺县','d',312),(318,'昔阳县','d',312),(319,'寿阳县','d',312),(320,'太谷县','d',312),(321,'祁  县','d',312),(322,'平遥县','d',312),(323,'灵石县','d',312),(324,'临汾','c',225),(325,'临汾市','d',324),(326,'侯马市','d',324),(327,'霍州市','d',324),(328,'曲沃县','d',324),(329,'翼城县','d',324),(330,'襄汾县','d',324),(331,'洪洞县','d',324),(332,'古  县','d',324),(333,'安泽县','d',324),(334,'浮山县','d',324),(335,'吉  县','d',324),(336,'乡宁县','d',324),(337,'蒲  县','d',324),(338,'大宁县','d',324),(339,'永和县','d',324),(340,'隰  县','d',324),(341,'汾西县','d',324),(342,'运城','c',225),(343,'运城市','d',342),(344,'永济市','d',342),(345,'河津市','d',342),(346,'芮城县','d',342),(347,'临猗县','d',342),(348,'万荣县','d',342),(349,'新绛县','d',342),(350,'稷山县','d',342),(351,'闻喜县','d',342),(352,'夏  县','d',342),(353,'绛  县','d',342),(354,'平陆县','d',342),(355,'垣曲县','d',342),(356,'内蒙古','p',NULL),(357,'呼和浩特','c',356),(358,'新城区','d',357),(359,'回民区','d',357),(360,'玉泉区','d',357),(361,'郊  区','d',357),(362,'土默特左旗','d',357),(363,'托克托县','d',357),(364,'和林格尔县','d',357),(365,'清水河县','d',357),(366,'武川县','d',357),(367,'包头','c',356),(368,'东河区','d',367),(369,'昆都伦区','d',367),(370,'青山区','d',367),(371,'石拐矿区','d',367),(372,'白云矿区','d',367),(373,'郊  区','d',367),(374,'土默特右旗','d',367),(375,'固阳县','d',367),(376,'达尔罕茂明安联合旗','d',367),(377,'乌海','c',356),(378,'海勃湾区','d',377),(379,'海南区','d',377),(380,'乌达区','d',377),(381,'赤峰','c',356),(382,'红山区','d',381),(383,'元宝山区','d',381),(384,'松山区','d',381),(385,'阿鲁科尔沁旗','d',381),(386,'巴林左旗','d',381),(387,'巴林右旗','d',381),(388,'林西县','d',381),(389,'克什克腾旗','d',381),(390,'翁牛特旗','d',381),(391,'喀喇沁旗','d',381),(392,'宁城县','d',381),(393,'敖汉旗','d',381),(394,'呼伦贝尔','c',356),(395,'海拉尔市','d',394),(396,'满洲里市','d',394),(397,'扎兰屯市','d',394),(398,'牙克石市','d',394),(399,'根河市','d',394),(400,'额尔古纳市','d',394),(401,'阿荣旗','d',394),(402,'莫力达瓦达斡尔族自治旗','d',394),(403,'鄂伦春自治旗','d',394),(404,'鄂温克族自治旗','d',394),(405,'新巴尔虎右旗','d',394),(406,'新巴尔虎左旗','d',394),(407,'陈巴尔虎旗','d',394),(408,'兴安盟','c',356),(409,'乌兰浩特市','d',408),(410,'阿尔山市','d',408),(411,'科尔沁右翼前旗','d',408),(412,'科尔沁右翼中旗','d',408),(413,'扎赉特旗','d',408),(414,'突泉县','d',408),(415,'通辽','c',356),(416,'科尔沁区','d',415),(417,'霍林郭勒市','d',415),(418,'科尔沁左翼中旗','d',415),(419,'科尔沁左翼后旗','d',415),(420,'开鲁县','d',415),(421,'库伦旗','d',415),(422,'奈曼旗','d',415),(423,'扎鲁特旗','d',415),(424,'锡林郭勒盟','c',356),(425,'二连浩特市','d',424),(426,'锡林浩特市','d',424),(427,'阿巴嘎旗','d',424),(428,'苏尼特左旗','d',424),(429,'苏尼特右旗','d',424),(430,'东乌珠穆沁旗','d',424),(431,'西乌珠穆沁旗','d',424),(432,'太仆寺旗','d',424),(433,'镶黄旗','d',424),(434,'正镶白旗','d',424),(435,'正蓝旗','d',424),(436,'多伦县','d',424),(437,'乌兰察布盟','c',356),(438,'集宁市','d',437),(439,'丰镇市','d',437),(440,'卓资县','d',437),(441,'化德县','d',437),(442,'商都县','d',437),(443,'兴和县','d',437),(444,'凉城县','d',437),(445,'察哈尔右翼前旗','d',437),(446,'察哈尔右翼中旗','d',437),(447,'察哈尔右翼后旗','d',437),(448,'四子王旗','d',437),(449,'伊克昭盟','c',356),(450,'东胜市','d',449),(451,'达拉特旗','d',449),(452,'准格尔旗','d',449),(453,'鄂托克前旗','d',449),(454,'鄂托克旗','d',449),(455,'杭锦旗','d',449),(456,'乌审旗','d',449),(457,'伊金霍洛旗','d',449),(458,'巴彦淖尔盟','c',356),(459,'临河市','d',458),(460,'五原县','d',458),(461,'磴口县','d',458),(462,'乌拉特前旗','d',458),(463,'乌拉特中旗','d',458),(464,'乌拉特后旗','d',458),(465,'杭锦后旗','d',458),(466,'阿拉善盟','c',356),(467,'阿拉善左旗','d',466),(468,'阿拉善右旗','d',466),(469,'额济纳旗','d',466),(470,'辽宁','p',NULL),(471,'沈阳','c',470),(472,'沈河区','d',471),(473,'皇姑区','d',471),(474,'和平区','d',471),(475,'大东区','d',471),(476,'铁西区','d',471),(477,'苏家屯区','d',471),(478,'东陵区','d',471),(479,'于洪区','d',471),(480,'新民市','d',471),(481,'法库县','d',471),(482,'辽中县','d',471),(483,'康平县','d',471),(484,'新城子区','d',471),(485,'其他','d',471),(486,'大连','c',470),(487,'西岗区','d',486),(488,'中山区','d',486),(489,'沙河口区','d',486),(490,'甘井子区','d',486),(491,'旅顺口区','d',486),(492,'金州区','d',486),(493,'瓦房店市','d',486),(494,'普兰店市','d',486),(495,'庄河市','d',486),(496,'长海县','d',486),(497,'其他','d',486),(498,'鞍山','c',470),(499,'铁东区','d',498),(500,'铁西区','d',498),(501,'立山区','d',498),(502,'千山区','d',498),(503,'海城市','d',498),(504,'台安县','d',498),(505,'岫岩满族自治县','d',498),(506,'其他','d',498),(507,'抚顺','c',470),(508,'顺城区','d',507),(509,'新抚区','d',507),(510,'东洲区','d',507),(511,'望花区','d',507),(512,'抚顺县','d',507),(513,'清原满族自治县','d',507),(514,'新宾满族自治县','d',507),(515,'其他','d',507),(516,'本溪','c',470),(517,'平山区','d',516),(518,'明山区','d',516),(519,'溪湖区','d',516),(520,'南芬区','d',516),(521,'本溪满族自治县','d',516),(522,'桓仁满族自治县','d',516),(523,'其他','d',516),(524,'丹东','c',470),(525,'振兴区','d',524),(526,'元宝区','d',524),(527,'振安区','d',524),(528,'东港市','d',524),(529,'凤城市','d',524),(530,'宽甸满族自治县','d',524),(531,'其他','d',524),(532,'锦州','c',470),(533,'太和区','d',532),(534,'古塔区','d',532),(535,'凌河区','d',532),(536,'凌海市','d',532),(537,'黑山县','d',532),(538,'义县','d',532),(539,'北宁市','d',532),(540,'其他','d',532),(541,'营口','c',470),(542,'站前区','d',541),(543,'西市区','d',541),(544,'鲅鱼圈区','d',541),(545,'老边区','d',541),(546,'大石桥市','d',541),(547,'盖州市','d',541),(548,'其他','d',541),(549,'阜新','c',470),(550,'海州区','d',549),(551,'新邱区','d',549),(552,'太平区','d',549),(553,'清河门区','d',549),(554,'细河区','d',549),(555,'彰武县','d',549),(556,'阜新蒙古族自治县','d',549),(557,'其他','d',549),(558,'辽阳','c',470),(559,'白塔区','d',558),(560,'文圣区','d',558),(561,'宏伟区','d',558),(562,'太子河区','d',558),(563,'弓长岭区','d',558),(564,'灯塔市','d',558),(565,'辽阳县','d',558),(566,'其他','d',558),(567,'盘锦','c',470),(568,'双台子区','d',567),(569,'兴隆台区','d',567),(570,'盘山县','d',567),(571,'大洼县','d',567),(572,'其他','d',567),(573,'铁岭','c',470),(574,'银州区','d',573),(575,'清河区','d',573),(576,'调兵山市','d',573),(577,'开原市','d',573),(578,'铁岭县','d',573),(579,'昌图县','d',573),(580,'西丰县','d',573),(581,'其他','d',573),(582,'朝阳','c',470),(583,'双塔区','d',582),(584,'龙城区','d',582),(585,'凌源市','d',582),(586,'北票市','d',582),(587,'朝阳县','d',582),(588,'建平县','d',582),(589,'喀喇沁左翼蒙古族自治县','d',582),(590,'其他','d',582),(591,'葫芦岛','c',470),(592,'龙港区','d',591),(593,'南票区','d',591),(594,'连山区','d',591),(595,'兴城市','d',591),(596,'绥中县','d',591),(597,'建昌县','d',591),(598,'其他','d',591),(599,'其他','c',470),(600,'其他','d',599),(601,'吉林','p',NULL),(602,'长春','c',601),(603,'朝阳区','d',602),(604,'宽城区','d',602),(605,'二道区','d',602),(606,'南关区','d',602),(607,'绿园区','d',602),(608,'双阳区','d',602),(609,'九台市','d',602),(610,'榆树市','d',602),(611,'德惠市','d',602),(612,'农安县','d',602),(613,'其他','d',602),(614,'吉林','c',601),(615,'船营区','d',614),(616,'昌邑区','d',614),(617,'龙潭区','d',614),(618,'丰满区','d',614),(619,'舒兰市','d',614),(620,'桦甸市','d',614),(621,'蛟河市','d',614),(622,'磐石市','d',614),(623,'永吉县','d',614),(624,'其他','d',614),(625,'四平','c',601),(626,'铁西区','d',625),(627,'铁东区','d',625),(628,'公主岭市','d',625),(629,'双辽市','d',625),(630,'梨树县','d',625),(631,'伊通满族自治县','d',625),(632,'其他','d',625),(633,'辽源','c',601),(634,'龙山区','d',633),(635,'西安区','d',633),(636,'东辽县','d',633),(637,'东丰县','d',633),(638,'其他','d',633),(639,'通化','c',601),(640,'东昌区','d',639),(641,'二道江区','d',639),(642,'梅河口市','d',639),(643,'集安市','d',639),(644,'通化县','d',639),(645,'辉南县','d',639),(646,'柳河县','d',639),(647,'其他','d',639),(648,'白山','c',601),(649,'八道江区','d',648),(650,'江源区','d',648),(651,'临江市','d',648),(652,'靖宇县','d',648),(653,'抚松县','d',648),(654,'长白朝鲜族自治县','d',648),(655,'其他','d',648),(656,'松原','c',601),(657,'宁江区','d',656),(658,'乾安县','d',656),(659,'长岭县','d',656),(660,'扶余县','d',656),(661,'前郭尔罗斯蒙古族自治县','d',656),(662,'其他','d',656),(663,'白城','c',601),(664,'洮北区','d',663),(665,'大安市','d',663),(666,'洮南市','d',663),(667,'镇赉县','d',663),(668,'通榆县','d',663),(669,'其他','d',663),(670,'延边朝鲜族自治州','c',601),(671,'延吉市','d',670),(672,'图们市','d',670),(673,'敦化市','d',670),(674,'龙井市','d',670),(675,'珲春市','d',670),(676,'和龙市','d',670),(677,'安图县','d',670),(678,'汪清县','d',670),(679,'其他','d',670),(680,'其他','c',601),(681,'其他','d',680),(682,'黑龙江','p',NULL),(683,'哈尔滨','c',682),(684,'松北区','d',683),(685,'道里区','d',683),(686,'南岗区','d',683),(687,'平房区','d',683),(688,'香坊区','d',683),(689,'道外区','d',683),(690,'呼兰区','d',683),(691,'阿城区','d',683),(692,'双城市','d',683),(693,'尚志市','d',683),(694,'五常市','d',683),(695,'宾县','d',683),(696,'方正县','d',683),(697,'通河县','d',683),(698,'巴彦县','d',683),(699,'延寿县','d',683),(700,'木兰县','d',683),(701,'依兰县','d',683),(702,'其他','d',683),(703,'齐齐哈尔','c',682),(704,'龙沙区','d',703),(705,'昂昂溪区','d',703),(706,'铁锋区','d',703),(707,'建华区','d',703),(708,'富拉尔基区','d',703),(709,'碾子山区','d',703),(710,'梅里斯达斡尔族区','d',703),(711,'讷河市','d',703),(712,'富裕县','d',703),(713,'拜泉县','d',703),(714,'甘南县','d',703),(715,'依安县','d',703),(716,'克山县','d',703),(717,'泰来县','d',703),(718,'克东县','d',703),(719,'龙江县','d',703),(720,'其他','d',703),(721,'鹤岗','c',682),(722,'兴山区','d',721),(723,'工农区','d',721),(724,'南山区','d',721),(725,'兴安区','d',721),(726,'向阳区','d',721),(727,'东山区','d',721),(728,'萝北县','d',721),(729,'绥滨县','d',721),(730,'其他','d',721),(731,'双鸭山','c',682),(732,'尖山区','d',731),(733,'岭东区','d',731),(734,'四方台区','d',731),(735,'宝山区','d',731),(736,'集贤县','d',731),(737,'宝清县','d',731),(738,'友谊县','d',731),(739,'饶河县','d',731),(740,'其他','d',731),(741,'鸡西','c',682),(742,'鸡冠区','d',741),(743,'恒山区','d',741),(744,'城子河区','d',741),(745,'滴道区','d',741),(746,'梨树区','d',741),(747,'麻山区','d',741),(748,'密山市','d',741),(749,'虎林市','d',741),(750,'鸡东县','d',741),(751,'其他','d',741),(752,'大庆','c',682),(753,'萨尔图区','d',752),(754,'红岗区','d',752),(755,'龙凤区','d',752),(756,'让胡路区','d',752),(757,'大同区','d',752),(758,'林甸县','d',752),(759,'肇州县','d',752),(760,'肇源县','d',752),(761,'杜尔伯特蒙古族自治县','d',752),(762,'其他','d',752),(763,'伊春','c',682),(764,'伊春区','d',763),(765,'带岭区','d',763),(766,'南岔区','d',763),(767,'金山屯区','d',763),(768,'西林区','d',763),(769,'美溪区','d',763),(770,'乌马河区','d',763),(771,'翠峦区','d',763),(772,'友好区','d',763),(773,'上甘岭区','d',763),(774,'五营区','d',763),(775,'红星区','d',763),(776,'新青区','d',763),(777,'汤旺河区','d',763),(778,'乌伊岭区','d',763),(779,'铁力市','d',763),(780,'嘉荫县','d',763),(781,'其他','d',763),(782,'牡丹江','c',682),(783,'爱民区','d',782),(784,'东安区','d',782),(785,'阳明区','d',782),(786,'西安区','d',782),(787,'绥芬河市','d',782),(788,'宁安市','d',782),(789,'海林市','d',782),(790,'穆棱市','d',782),(791,'林口县','d',782),(792,'东宁县','d',782),(793,'其他','d',782),(794,'佳木斯','c',682),(795,'向阳区','d',794),(796,'前进区','d',794),(797,'东风区','d',794),(798,'郊区','d',794),(799,'同江市','d',794),(800,'富锦市','d',794),(801,'桦川县','d',794),(802,'抚远县','d',794),(803,'桦南县','d',794),(804,'汤原县','d',794),(805,'其他','d',794),(806,'七台河','c',682),(807,'桃山区','d',806),(808,'新兴区','d',806),(809,'茄子河区','d',806),(810,'勃利县','d',806),(811,'其他','d',806),(812,'黑河','c',682),(813,'爱辉区','d',812),(814,'北安市','d',812),(815,'五大连池市','d',812),(816,'逊克县','d',812),(817,'嫩江县','d',812),(818,'孙吴县','d',812),(819,'其他','d',812),(820,'绥化','c',682),(821,'北林区','d',820),(822,'安达市','d',820),(823,'肇东市','d',820),(824,'海伦市','d',820),(825,'绥棱县','d',820),(826,'兰西县','d',820),(827,'明水县','d',820),(828,'青冈县','d',820),(829,'庆安县','d',820),(830,'望奎县','d',820),(831,'其他','d',820),(832,'大兴安岭地区','c',682),(833,'呼玛县','d',832),(834,'塔河县','d',832),(835,'漠河县','d',832),(836,'大兴安岭辖区','d',832),(837,'其他','d',832),(838,'其他','c',682),(839,'其他','d',838),(840,'上海','p',NULL),(841,'上海','c',840),(842,'黄浦区','d',841),(843,'卢湾区','d',841),(844,'徐汇区','d',841),(845,'长宁区','d',841),(846,'静安区','d',841),(847,'普陀区','d',841),(848,'闸北区','d',841),(849,'虹口区','d',841),(850,'杨浦区','d',841),(851,'宝山区','d',841),(852,'闵行区','d',841),(853,'嘉定区','d',841),(854,'松江区','d',841),(855,'金山区','d',841),(856,'青浦区','d',841),(857,'南汇区','d',841),(858,'奉贤区','d',841),(859,'浦东新区','d',841),(860,'崇明县','d',841),(861,'其他','d',841),(862,'江苏','p',NULL),(863,'南京','c',862),(864,'玄武区','d',863),(865,'白下区','d',863),(866,'秦淮区','d',863),(867,'建邺区','d',863),(868,'鼓楼区','d',863),(869,'下关区','d',863),(870,'栖霞区','d',863),(871,'雨花台区','d',863),(872,'浦口区','d',863),(873,'江宁区','d',863),(874,'六合区','d',863),(875,'溧水县','d',863),(876,'高淳县','d',863),(877,'其他','d',863),(878,'苏州','c',862),(879,'金阊区','d',878),(880,'平江区','d',878),(881,'沧浪区','d',878),(882,'虎丘区','d',878),(883,'吴中区','d',878),(884,'相城区','d',878),(885,'常熟市','d',878),(886,'张家港市','d',878),(887,'昆山市','d',878),(888,'吴江市','d',878),(889,'太仓市','d',878),(890,'其他','d',878),(891,'无锡','c',862),(892,'崇安区','d',891),(893,'南长区','d',891),(894,'北塘区','d',891),(895,'滨湖区','d',891),(896,'锡山区','d',891),(897,'惠山区','d',891),(898,'江阴市','d',891),(899,'宜兴市','d',891),(900,'其他','d',891),(901,'常州','c',862),(902,'钟楼区','d',901),(903,'天宁区','d',901),(904,'戚墅堰区','d',901),(905,'新北区','d',901),(906,'武进区','d',901),(907,'金坛市','d',901),(908,'溧阳市','d',901),(909,'其他','d',901),(910,'镇江','c',862),(911,'京口区','d',910),(912,'润州区','d',910),(913,'丹徒区','d',910),(914,'丹阳市','d',910),(915,'扬中市','d',910),(916,'句容市','d',910),(917,'其他','d',910),(918,'南通','c',862),(919,'崇川区','d',918),(920,'港闸区','d',918),(921,'通州市','d',918),(922,'如皋市','d',918),(923,'海门市','d',918),(924,'启东市','d',918),(925,'海安县','d',918),(926,'如东县','d',918),(927,'其他','d',918),(928,'泰州','c',862),(929,'海陵区','d',928),(930,'高港区','d',928),(931,'姜堰市','d',928),(932,'泰兴市','d',928),(933,'靖江市','d',928),(934,'兴化市','d',928),(935,'其他','d',928),(936,'扬州','c',862),(937,'广陵区','d',936),(938,'维扬区','d',936),(939,'邗江区','d',936),(940,'江都市','d',936),(941,'仪征市','d',936),(942,'高邮市','d',936),(943,'宝应县','d',936),(944,'其他','d',936),(945,'盐城','c',862),(946,'亭湖区','d',945),(947,'盐都区','d',945),(948,'大丰市','d',945),(949,'东台市','d',945),(950,'建湖县','d',945),(951,'射阳县','d',945),(952,'阜宁县','d',945),(953,'滨海县','d',945),(954,'响水县','d',945),(955,'其他','d',945),(956,'连云港','c',862),(957,'新浦区','d',956),(958,'海州区','d',956),(959,'连云区','d',956),(960,'东海县','d',956),(961,'灌云县','d',956),(962,'赣榆县','d',956),(963,'灌南县','d',956),(964,'其他','d',956),(965,'徐州','c',862),(966,'云龙区','d',965),(967,'鼓楼区','d',965),(968,'九里区','d',965),(969,'泉山区','d',965),(970,'贾汪区','d',965),(971,'邳州市','d',965),(972,'新沂市','d',965),(973,'铜山县','d',965),(974,'睢宁县','d',965),(975,'沛县','d',965),(976,'丰县','d',965),(977,'其他','d',965),(978,'淮安','c',862),(979,'清河区','d',978),(980,'清浦区','d',978),(981,'楚州区','d',978),(982,'淮阴区','d',978),(983,'涟水县','d',978),(984,'洪泽县','d',978),(985,'金湖县','d',978),(986,'盱眙县','d',978),(987,'其他','d',978),(988,'宿迁','c',862),(989,'宿城区','d',988),(990,'宿豫区','d',988),(991,'沭阳县','d',988),(992,'泗阳县','d',988),(993,'泗洪县','d',988),(994,'其他','d',988),(995,'其他','c',862),(996,'其他','d',995),(997,'浙江','p',NULL),(998,'杭州','c',997),(999,'拱墅区','d',998),(1000,'西湖区','d',998),(1001,'上城区','d',998),(1002,'下城区','d',998),(1003,'江干区','d',998),(1004,'滨江区','d',998),(1005,'余杭区','d',998),(1006,'萧山区','d',998),(1007,'建德市','d',998),(1008,'富阳市','d',998),(1009,'临安市','d',998),(1010,'桐庐县','d',998),(1011,'淳安县','d',998),(1012,'其他','d',998),(1013,'宁波','c',997),(1014,'海曙区','d',1013),(1015,'江东区','d',1013),(1016,'江北区','d',1013),(1017,'镇海区','d',1013),(1018,'北仑区','d',1013),(1019,'鄞州区','d',1013),(1020,'余姚市','d',1013),(1021,'慈溪市','d',1013),(1022,'奉化市','d',1013),(1023,'宁海县','d',1013),(1024,'象山县','d',1013),(1025,'其他','d',1013),(1026,'温州','c',997),(1027,'鹿城区','d',1026),(1028,'龙湾区','d',1026),(1029,'瓯海区','d',1026),(1030,'瑞安市','d',1026),(1031,'乐清市','d',1026),(1032,'永嘉县','d',1026),(1033,'洞头县','d',1026),(1034,'平阳县','d',1026),(1035,'苍南县','d',1026),(1036,'文成县','d',1026),(1037,'泰顺县','d',1026),(1038,'其他','d',1026),(1039,'嘉兴','c',997),(1040,'秀城区','d',1039),(1041,'秀洲区','d',1039),(1042,'海宁市','d',1039),(1043,'平湖市','d',1039),(1044,'桐乡市','d',1039),(1045,'嘉善县','d',1039),(1046,'海盐县','d',1039),(1047,'其他','d',1039),(1048,'湖州','c',997),(1049,'吴兴区','d',1048),(1050,'南浔区','d',1048),(1051,'长兴县','d',1048),(1052,'德清县','d',1048),(1053,'安吉县','d',1048),(1054,'其他','d',1048),(1055,'绍兴','c',997),(1056,'越城区','d',1055),(1057,'诸暨市','d',1055),(1058,'上虞市','d',1055),(1059,'嵊州市','d',1055),(1060,'绍兴县','d',1055),(1061,'新昌县','d',1055),(1062,'其他','d',1055),(1063,'金华','c',997),(1064,'婺城区','d',1063),(1065,'金东区','d',1063),(1066,'兰溪市','d',1063),(1067,'义乌市','d',1063),(1068,'东阳市','d',1063),(1069,'永康市','d',1063),(1070,'武义县','d',1063),(1071,'浦江县','d',1063),(1072,'磐安县','d',1063),(1073,'其他','d',1063),(1074,'衢州','c',997),(1075,'柯城区','d',1074),(1076,'衢江区','d',1074),(1077,'江山市','d',1074),(1078,'龙游县','d',1074),(1079,'常山县','d',1074),(1080,'开化县','d',1074),(1081,'其他','d',1074),(1082,'舟山','c',997),(1083,'定海区','d',1082),(1084,'普陀区','d',1082),(1085,'岱山县','d',1082),(1086,'嵊泗县','d',1082),(1087,'其他','d',1082),(1088,'台州','c',997),(1089,'椒江区','d',1088),(1090,'黄岩区','d',1088),(1091,'路桥区','d',1088),(1092,'临海市','d',1088),(1093,'温岭市','d',1088),(1094,'玉环县','d',1088),(1095,'天台县','d',1088),(1096,'仙居县','d',1088),(1097,'三门县','d',1088),(1098,'其他','d',1088),(1099,'丽水','c',997),(1100,'莲都区','d',1099),(1101,'龙泉市','d',1099),(1102,'缙云县','d',1099),(1103,'青田县','d',1099),(1104,'云和县','d',1099),(1105,'遂昌县','d',1099),(1106,'松阳县','d',1099),(1107,'庆元县','d',1099),(1108,'景宁畲族自治县','d',1099),(1109,'其他','d',1099),(1110,'其他','c',997),(1111,'其他','d',1110),(1112,'安徽','p',NULL),(1113,'合肥','c',1112),(1114,'庐阳区','d',1113),(1115,'瑶海区','d',1113),(1116,'蜀山区','d',1113),(1117,'包河区','d',1113),(1118,'长丰县','d',1113),(1119,'肥东县','d',1113),(1120,'肥西县','d',1113),(1121,'其他','d',1113),(1122,'芜湖','c',1112),(1123,'镜湖区','d',1122),(1124,'弋江区','d',1122),(1125,'鸠江区','d',1122),(1126,'三山区','d',1122),(1127,'芜湖县','d',1122),(1128,'南陵县','d',1122),(1129,'繁昌县','d',1122),(1130,'其他','d',1122),(1131,'蚌埠','c',1112),(1132,'蚌山区','d',1131),(1133,'龙子湖区','d',1131),(1134,'禹会区','d',1131),(1135,'淮上区','d',1131),(1136,'怀远县','d',1131),(1137,'固镇县','d',1131),(1138,'五河县','d',1131),(1139,'其他','d',1131),(1140,'淮南','c',1112),(1141,'田家庵区','d',1140),(1142,'大通区','d',1140),(1143,'谢家集区','d',1140),(1144,'八公山区','d',1140),(1145,'潘集区','d',1140),(1146,'凤台县','d',1140),(1147,'其他','d',1140),(1148,'马鞍山','c',1112),(1149,'雨山区','d',1148),(1150,'花山区','d',1148),(1151,'金家庄区','d',1148),(1152,'当涂县','d',1148),(1153,'其他','d',1148),(1154,'淮北','c',1112),(1155,'相山区','d',1154),(1156,'杜集区','d',1154),(1157,'烈山区','d',1154),(1158,'濉溪县','d',1154),(1159,'其他','d',1154),(1160,'铜陵','c',1112),(1161,'铜官山区','d',1160),(1162,'狮子山区','d',1160),(1163,'郊区','d',1160),(1164,'铜陵县','d',1160),(1165,'其他','d',1160),(1166,'安庆','c',1112),(1167,'迎江区','d',1166),(1168,'大观区','d',1166),(1169,'宜秀区','d',1166),(1170,'桐城市','d',1166),(1171,'宿松县','d',1166),(1172,'枞阳县','d',1166),(1173,'太湖县','d',1166),(1174,'怀宁县','d',1166),(1175,'岳西县','d',1166),(1176,'望江县','d',1166),(1177,'潜山县','d',1166),(1178,'其他','d',1166),(1179,'黄山','c',1112),(1180,'屯溪区','d',1179),(1181,'黄山区','d',1179),(1182,'徽州区','d',1179),(1183,'休宁县','d',1179),(1184,'歙县','d',1179),(1185,'祁门县','d',1179),(1186,'黟县','d',1179),(1187,'其他','d',1179),(1188,'滁州','c',1112),(1189,'琅琊区','d',1188),(1190,'南谯区','d',1188),(1191,'天长市','d',1188),(1192,'明光市','d',1188),(1193,'全椒县','d',1188),(1194,'来安县','d',1188),(1195,'定远县','d',1188),(1196,'凤阳县','d',1188),(1197,'其他','d',1188),(1198,'阜阳','c',1112),(1199,'颍州区','d',1198),(1200,'颍东区','d',1198),(1201,'颍泉区','d',1198),(1202,'界首市','d',1198),(1203,'临泉县','d',1198),(1204,'颍上县','d',1198),(1205,'阜南县','d',1198),(1206,'太和县','d',1198),(1207,'其他','d',1198),(1208,'宿州','c',1112),(1209,'埇桥区','d',1208),(1210,'萧县','d',1208),(1211,'泗县','d',1208),(1212,'砀山县','d',1208),(1213,'灵璧县','d',1208),(1214,'其他','d',1208),(1215,'巢湖','c',1112),(1216,'居巢区','d',1215),(1217,'含山县','d',1215),(1218,'无为县','d',1215),(1219,'庐江县','d',1215),(1220,'和县','d',1215),(1221,'其他','d',1215),(1222,'六安','c',1112),(1223,'金安区','d',1222),(1224,'裕安区','d',1222),(1225,'寿县','d',1222),(1226,'霍山县','d',1222),(1227,'霍邱县','d',1222),(1228,'舒城县','d',1222),(1229,'金寨县','d',1222),(1230,'其他','d',1222),(1231,'亳州','c',1112),(1232,'谯城区','d',1231),(1233,'利辛县','d',1231),(1234,'涡阳县','d',1231),(1235,'蒙城县','d',1231),(1236,'其他','d',1231),(1237,'池州','c',1112),(1238,'贵池区','d',1237),(1239,'东至县','d',1237),(1240,'石台县','d',1237),(1241,'青阳县','d',1237),(1242,'其他','d',1237),(1243,'宣城','c',1112),(1244,'宣州区','d',1243),(1245,'宁国市','d',1243),(1246,'广德县','d',1243),(1247,'郎溪县','d',1243),(1248,'泾县','d',1243),(1249,'旌德县','d',1243),(1250,'绩溪县','d',1243),(1251,'其他','d',1243),(1252,'其他','c',1112),(1253,'其他','d',1252),(1254,'福建','p',NULL),(1255,'福州','c',1254),(1256,'鼓楼区','d',1255),(1257,'台江区','d',1255),(1258,'仓山区','d',1255),(1259,'马尾区','d',1255),(1260,'晋安区','d',1255),(1261,'福清市','d',1255),(1262,'长乐市','d',1255),(1263,'闽侯县','d',1255),(1264,'闽清县','d',1255),(1265,'永泰县','d',1255),(1266,'连江县','d',1255),(1267,'罗源县','d',1255),(1268,'平潭县','d',1255),(1269,'其他','d',1255),(1270,'厦门','c',1254),(1271,'思明区','d',1270),(1272,'海沧区','d',1270),(1273,'湖里区','d',1270),(1274,'集美区','d',1270),(1275,'同安区','d',1270),(1276,'翔安区','d',1270),(1277,'其他','d',1270),(1278,'莆田','c',1254),(1279,'城厢区','d',1278),(1280,'涵江区','d',1278),(1281,'荔城区','d',1278),(1282,'秀屿区','d',1278),(1283,'仙游县','d',1278),(1284,'其他','d',1278),(1285,'三明','c',1254),(1286,'梅列区','d',1285),(1287,'三元区','d',1285),(1288,'永安市','d',1285),(1289,'明溪县','d',1285),(1290,'将乐县','d',1285),(1291,'大田县','d',1285),(1292,'宁化县','d',1285),(1293,'建宁县','d',1285),(1294,'沙县','d',1285),(1295,'尤溪县','d',1285),(1296,'清流县','d',1285),(1297,'泰宁县','d',1285),(1298,'其他','d',1285),(1299,'泉州','c',1254),(1300,'鲤城区','d',1299),(1301,'丰泽区','d',1299),(1302,'洛江区','d',1299),(1303,'泉港区','d',1299),(1304,'石狮市','d',1299),(1305,'晋江市','d',1299),(1306,'南安市','d',1299),(1307,'惠安县','d',1299),(1308,'永春县','d',1299),(1309,'安溪县','d',1299),(1310,'德化县','d',1299),(1311,'金门县','d',1299),(1312,'其他','d',1299),(1313,'漳州','c',1254),(1314,'芗城区','d',1313),(1315,'龙文区','d',1313),(1316,'龙海市','d',1313),(1317,'平和县','d',1313),(1318,'南靖县','d',1313),(1319,'诏安县','d',1313),(1320,'漳浦县','d',1313),(1321,'华安县','d',1313),(1322,'东山县','d',1313),(1323,'长泰县','d',1313),(1324,'云霄县','d',1313),(1325,'其他','d',1313),(1326,'南平','c',1254),(1327,'延平区','d',1326),(1328,'建瓯市','d',1326),(1329,'邵武市','d',1326),(1330,'武夷山市','d',1326),(1331,'建阳市','d',1326),(1332,'松溪县','d',1326),(1333,'光泽县','d',1326),(1334,'顺昌县','d',1326),(1335,'浦城县','d',1326),(1336,'政和县','d',1326),(1337,'其他','d',1326),(1338,'龙岩','c',1254),(1339,'新罗区','d',1338),(1340,'漳平市','d',1338),(1341,'长汀县','d',1338),(1342,'武平县','d',1338),(1343,'上杭县','d',1338),(1344,'永定县','d',1338),(1345,'连城县','d',1338),(1346,'其他','d',1338),(1347,'宁德','c',1254),(1348,'蕉城区','d',1347),(1349,'福安市','d',1347),(1350,'福鼎市','d',1347),(1351,'寿宁县','d',1347),(1352,'霞浦县','d',1347),(1353,'柘荣县','d',1347),(1354,'屏南县','d',1347),(1355,'古田县','d',1347),(1356,'周宁县','d',1347),(1357,'其他','d',1347),(1358,'其他','c',1254),(1359,'其他','d',1358),(1360,'江西','p',NULL),(1361,'南昌','c',1360),(1362,'东湖区','d',1361),(1363,'西湖区','d',1361),(1364,'青云谱区','d',1361),(1365,'湾里区','d',1361),(1366,'青山湖区','d',1361),(1367,'新建县','d',1361),(1368,'南昌县','d',1361),(1369,'进贤县','d',1361),(1370,'安义县','d',1361),(1371,'其他','d',1361),(1372,'景德镇','c',1360),(1373,'珠山区','d',1372),(1374,'昌江区','d',1372),(1375,'乐平市','d',1372),(1376,'浮梁县','d',1372),(1377,'其他','d',1372),(1378,'萍乡','c',1360),(1379,'安源区','d',1378),(1380,'湘东区','d',1378),(1381,'莲花县','d',1378),(1382,'上栗县','d',1378),(1383,'芦溪县','d',1378),(1384,'其他','d',1378),(1385,'九江','c',1360),(1386,'浔阳区','d',1385),(1387,'庐山区','d',1385),(1388,'瑞昌市','d',1385),(1389,'九江县','d',1385),(1390,'星子县','d',1385),(1391,'武宁县','d',1385),(1392,'彭泽县','d',1385),(1393,'永修县','d',1385),(1394,'修水县','d',1385),(1395,'湖口县','d',1385),(1396,'德安县','d',1385),(1397,'都昌县','d',1385),(1398,'其他','d',1385),(1399,'新余','c',1360),(1400,'渝水区','d',1399),(1401,'分宜县','d',1399),(1402,'其他','d',1399),(1403,'鹰潭','c',1360),(1404,'月湖区','d',1403),(1405,'贵溪市','d',1403),(1406,'余江县','d',1403),(1407,'其他','d',1403),(1408,'赣州','c',1360),(1409,'章贡区','d',1408),(1410,'瑞金市','d',1408),(1411,'南康市','d',1408),(1412,'石城县','d',1408),(1413,'安远县','d',1408),(1414,'赣县','d',1408),(1415,'宁都县','d',1408),(1416,'寻乌县','d',1408),(1417,'兴国县','d',1408),(1418,'定南县','d',1408),(1419,'上犹县','d',1408),(1420,'于都县','d',1408),(1421,'龙南县','d',1408),(1422,'崇义县','d',1408),(1423,'信丰县','d',1408),(1424,'全南县','d',1408),(1425,'大余县','d',1408),(1426,'会昌县','d',1408),(1427,'其他','d',1408),(1428,'吉安','c',1360),(1429,'吉州区','d',1428),(1430,'青原区','d',1428),(1431,'井冈山市','d',1428),(1432,'吉安县','d',1428),(1433,'永丰县','d',1428),(1434,'永新县','d',1428),(1435,'新干县','d',1428),(1436,'泰和县','d',1428),(1437,'峡江县','d',1428),(1438,'遂川县','d',1428),(1439,'安福县','d',1428),(1440,'吉水县','d',1428),(1441,'万安县','d',1428),(1442,'其他','d',1428),(1443,'宜春','c',1360),(1444,'袁州区','d',1443),(1445,'丰城市','d',1443),(1446,'樟树市','d',1443),(1447,'高安市','d',1443),(1448,'铜鼓县','d',1443),(1449,'靖安县','d',1443),(1450,'宜丰县','d',1443),(1451,'奉新县','d',1443),(1452,'万载县','d',1443),(1453,'上高县','d',1443),(1454,'其他','d',1443),(1455,'抚州','c',1360),(1456,'临川区','d',1455),(1457,'南丰县','d',1455),(1458,'乐安县','d',1455),(1459,'金溪县','d',1455),(1460,'南城县','d',1455),(1461,'东乡县','d',1455),(1462,'资溪县','d',1455),(1463,'宜黄县','d',1455),(1464,'广昌县','d',1455),(1465,'黎川县','d',1455),(1466,'崇仁县','d',1455),(1467,'其他','d',1455),(1468,'上饶','c',1360),(1469,'信州区','d',1468),(1470,'德兴市','d',1468),(1471,'上饶县','d',1468),(1472,'广丰县','d',1468),(1473,'鄱阳县','d',1468),(1474,'婺源县','d',1468),(1475,'铅山县','d',1468),(1476,'余干县','d',1468),(1477,'横峰县','d',1468),(1478,'弋阳县','d',1468),(1479,'玉山县','d',1468),(1480,'万年县','d',1468),(1481,'其他','d',1468),(1482,'其他','c',1360),(1483,'其他','d',1482),(1484,'山东','p',NULL),(1485,'济南','c',1484),(1486,'市中区','d',1485),(1487,'历下区','d',1485),(1488,'天桥区','d',1485),(1489,'槐荫区','d',1485),(1490,'历城区','d',1485),(1491,'长清区','d',1485),(1492,'章丘市','d',1485),(1493,'平阴县','d',1485),(1494,'济阳县','d',1485),(1495,'商河县','d',1485),(1496,'其他','d',1485),(1497,'青岛','c',1484),(1498,'市南区','d',1497),(1499,'市北区','d',1497),(1500,'城阳区','d',1497),(1501,'四方区','d',1497),(1502,'李沧区','d',1497),(1503,'黄岛区','d',1497),(1504,'崂山区','d',1497),(1505,'胶南市','d',1497),(1506,'胶州市','d',1497),(1507,'平度市','d',1497),(1508,'莱西市','d',1497),(1509,'即墨市','d',1497),(1510,'其他','d',1497),(1511,'淄博','c',1484),(1512,'张店区','d',1511),(1513,'临淄区','d',1511),(1514,'淄川区','d',1511),(1515,'博山区','d',1511),(1516,'周村区','d',1511),(1517,'桓台县','d',1511),(1518,'高青县','d',1511),(1519,'沂源县','d',1511),(1520,'其他','d',1511),(1521,'枣庄','c',1484),(1522,'市中区','d',1521),(1523,'山亭区','d',1521),(1524,'峄城区','d',1521),(1525,'台儿庄区','d',1521),(1526,'薛城区','d',1521),(1527,'滕州市','d',1521),(1528,'其他','d',1521),(1529,'东营','c',1484),(1530,'东营区','d',1529),(1531,'河口区','d',1529),(1532,'垦利县','d',1529),(1533,'广饶县','d',1529),(1534,'利津县','d',1529),(1535,'其他','d',1529),(1536,'烟台','c',1484),(1537,'芝罘区','d',1536),(1538,'福山区','d',1536),(1539,'牟平区','d',1536),(1540,'莱山区','d',1536),(1541,'龙口市','d',1536),(1542,'莱阳市','d',1536),(1543,'莱州市','d',1536),(1544,'招远市','d',1536),(1545,'蓬莱市','d',1536),(1546,'栖霞市','d',1536),(1547,'海阳市','d',1536),(1548,'长岛县','d',1536),(1549,'其他','d',1536),(1550,'潍坊','c',1484),(1551,'潍城区','d',1550),(1552,'寒亭区','d',1550),(1553,'坊子区','d',1550),(1554,'奎文区','d',1550),(1555,'青州市','d',1550),(1556,'诸城市','d',1550),(1557,'寿光市','d',1550),(1558,'安丘市','d',1550),(1559,'高密市','d',1550),(1560,'昌邑市','d',1550),(1561,'昌乐县','d',1550),(1562,'临朐县','d',1550),(1563,'其他','d',1550),(1564,'济宁','c',1484),(1565,'市中区','d',1564),(1566,'任城区','d',1564),(1567,'曲阜市','d',1564),(1568,'兖州市','d',1564),(1569,'邹城市','d',1564),(1570,'鱼台县','d',1564),(1571,'金乡县','d',1564),(1572,'嘉祥县','d',1564),(1573,'微山县','d',1564),(1574,'汶上县','d',1564),(1575,'泗水县','d',1564),(1576,'梁山县','d',1564),(1577,'其他','d',1564),(1578,'泰安','c',1484),(1579,'泰山区','d',1578),(1580,'岱岳区','d',1578),(1581,'新泰市','d',1578),(1582,'肥城市','d',1578),(1583,'宁阳县','d',1578),(1584,'东平县','d',1578),(1585,'其他','d',1578),(1586,'威海','c',1484),(1587,'环翠区','d',1586),(1588,'乳山市','d',1586),(1589,'文登市','d',1586),(1590,'荣成市','d',1586),(1591,'其他','d',1586),(1592,'日照','c',1484),(1593,'东港区','d',1592),(1594,'岚山区','d',1592),(1595,'五莲县','d',1592),(1596,'莒县','d',1592),(1597,'其他','d',1592),(1598,'莱芜','c',1484),(1599,'莱城区','d',1598),(1600,'钢城区','d',1598),(1601,'其他','d',1598),(1602,'临沂','c',1484),(1603,'兰山区','d',1602),(1604,'罗庄区','d',1602),(1605,'河东区','d',1602),(1606,'沂南县','d',1602),(1607,'郯城县','d',1602),(1608,'沂水县','d',1602),(1609,'苍山县','d',1602),(1610,'费县','d',1602),(1611,'平邑县','d',1602),(1612,'莒南县','d',1602),(1613,'蒙阴县','d',1602),(1614,'临沭县','d',1602),(1615,'其他','d',1602),(1616,'德州','c',1484),(1617,'德城区','d',1616),(1618,'乐陵市','d',1616),(1619,'禹城市','d',1616),(1620,'陵县','d',1616),(1621,'宁津县','d',1616),(1622,'齐河县','d',1616),(1623,'武城县','d',1616),(1624,'庆云县','d',1616),(1625,'平原县','d',1616),(1626,'夏津县','d',1616),(1627,'临邑县','d',1616),(1628,'其他','d',1616),(1629,'聊城','c',1484),(1630,'东昌府区','d',1629),(1631,'临清市','d',1629),(1632,'高唐县','d',1629),(1633,'阳谷县','d',1629),(1634,'茌平县','d',1629),(1635,'莘县','d',1629),(1636,'东阿县','d',1629),(1637,'冠县','d',1629),(1638,'其他','d',1629),(1639,'滨州','c',1484),(1640,'滨城区','d',1639),(1641,'邹平县','d',1639),(1642,'沾化县','d',1639),(1643,'惠民县','d',1639),(1644,'博兴县','d',1639),(1645,'阳信县','d',1639),(1646,'无棣县','d',1639),(1647,'其他','d',1639),(1648,'菏泽','c',1484),(1649,'牡丹区','d',1648),(1650,'鄄城县','d',1648),(1651,'单县','d',1648),(1652,'郓城县','d',1648),(1653,'曹县','d',1648),(1654,'定陶县','d',1648),(1655,'巨野县','d',1648),(1656,'东明县','d',1648),(1657,'成武县','d',1648),(1658,'其他','d',1648),(1659,'其他','c',1484),(1660,'其他','d',1659),(1661,'河南','p',NULL),(1662,'郑州','c',1661),(1663,'中原区','d',1662),(1664,'金水区','d',1662),(1665,'二七区','d',1662),(1666,'管城回族区','d',1662),(1667,'上街区','d',1662),(1668,'惠济区','d',1662),(1669,'巩义市','d',1662),(1670,'新郑市','d',1662),(1671,'新密市','d',1662),(1672,'登封市','d',1662),(1673,'荥阳市','d',1662),(1674,'中牟县','d',1662),(1675,'其他','d',1662),(1676,'开封','c',1661),(1677,'鼓楼区','d',1676),(1678,'龙亭区','d',1676),(1679,'顺河回族区','d',1676),(1680,'禹王台区','d',1676),(1681,'金明区','d',1676),(1682,'开封县','d',1676),(1683,'尉氏县','d',1676),(1684,'兰考县','d',1676),(1685,'杞县','d',1676),(1686,'通许县','d',1676),(1687,'其他','d',1676),(1688,'洛阳','c',1661),(1689,'西工区','d',1688),(1690,'老城区','d',1688),(1691,'涧西区','d',1688),(1692,'瀍河回族区','d',1688),(1693,'洛龙区','d',1688),(1694,'吉利区','d',1688),(1695,'偃师市','d',1688),(1696,'孟津县','d',1688),(1697,'汝阳县','d',1688),(1698,'伊川县','d',1688),(1699,'洛宁县','d',1688),(1700,'嵩县','d',1688),(1701,'宜阳县','d',1688),(1702,'新安县','d',1688),(1703,'栾川县','d',1688),(1704,'其他','d',1688),(1705,'平顶山','c',1661),(1706,'新华区','d',1705),(1707,'卫东区','d',1705),(1708,'湛河区','d',1705),(1709,'石龙区','d',1705),(1710,'汝州市','d',1705),(1711,'舞钢市','d',1705),(1712,'宝丰县','d',1705),(1713,'叶县','d',1705),(1714,'郏县','d',1705),(1715,'鲁山县','d',1705),(1716,'其他','d',1705),(1717,'安阳','c',1661),(1718,'北关区','d',1717),(1719,'文峰区','d',1717),(1720,'殷都区','d',1717),(1721,'龙安区','d',1717),(1722,'林州市','d',1717),(1723,'安阳县','d',1717),(1724,'滑县','d',1717),(1725,'内黄县','d',1717),(1726,'汤阴县','d',1717),(1727,'其他','d',1717),(1728,'鹤壁','c',1661),(1729,'淇滨区','d',1728),(1730,'山城区','d',1728),(1731,'鹤山区','d',1728),(1732,'浚县','d',1728),(1733,'淇县','d',1728),(1734,'其他','d',1728),(1735,'新乡','c',1661),(1736,'卫滨区','d',1735),(1737,'红旗区','d',1735),(1738,'凤泉区','d',1735),(1739,'牧野区','d',1735),(1740,'卫辉市','d',1735),(1741,'辉县市','d',1735),(1742,'新乡县','d',1735),(1743,'获嘉县','d',1735),(1744,'原阳县','d',1735),(1745,'长垣县','d',1735),(1746,'封丘县','d',1735),(1747,'延津县','d',1735),(1748,'其他','d',1735),(1749,'焦作','c',1661),(1750,'解放区','d',1749),(1751,'中站区','d',1749),(1752,'马村区','d',1749),(1753,'山阳区','d',1749),(1754,'沁阳市','d',1749),(1755,'孟州市','d',1749),(1756,'修武县','d',1749),(1757,'温县','d',1749),(1758,'武陟县','d',1749),(1759,'博爱县','d',1749),(1760,'其他','d',1749),(1761,'濮阳','c',1661),(1762,'华龙区','d',1761),(1763,'濮阳县','d',1761),(1764,'南乐县','d',1761),(1765,'台前县','d',1761),(1766,'清丰县','d',1761),(1767,'范县','d',1761),(1768,'其他','d',1761),(1769,'许昌','c',1661),(1770,'魏都区','d',1769),(1771,'禹州市','d',1769),(1772,'长葛市','d',1769),(1773,'许昌县','d',1769),(1774,'鄢陵县','d',1769),(1775,'襄城县','d',1769),(1776,'其他','d',1769),(1777,'漯河','c',1661),(1778,'源汇区','d',1777),(1779,'郾城区','d',1777),(1780,'召陵区','d',1777),(1781,'临颍县','d',1777),(1782,'舞阳县','d',1777),(1783,'其他','d',1777),(1784,'三门峡','c',1661),(1785,'湖滨区','d',1784),(1786,'义马市','d',1784),(1787,'灵宝市','d',1784),(1788,'渑池县','d',1784),(1789,'卢氏县','d',1784),(1790,'陕县','d',1784),(1791,'其他','d',1784),(1792,'南阳','c',1661),(1793,'卧龙区','d',1792),(1794,'宛城区','d',1792),(1795,'邓州市','d',1792),(1796,'桐柏县','d',1792),(1797,'方城县','d',1792),(1798,'淅川县','d',1792),(1799,'镇平县','d',1792),(1800,'唐河县','d',1792),(1801,'南召县','d',1792),(1802,'内乡县','d',1792),(1803,'新野县','d',1792),(1804,'社旗县','d',1792),(1805,'西峡县','d',1792),(1806,'其他','d',1792),(1807,'商丘','c',1661),(1808,'梁园区','d',1807),(1809,'睢阳区','d',1807),(1810,'永城市','d',1807),(1811,'宁陵县','d',1807),(1812,'虞城县','d',1807),(1813,'民权县','d',1807),(1814,'夏邑县','d',1807),(1815,'柘城县','d',1807),(1816,'睢县','d',1807),(1817,'其他','d',1807),(1818,'信阳','c',1661),(1819,'浉河区','d',1818),(1820,'平桥区','d',1818),(1821,'潢川县','d',1818),(1822,'淮滨县','d',1818),(1823,'息县','d',1818),(1824,'新县','d',1818),(1825,'商城县','d',1818),(1826,'固始县','d',1818),(1827,'罗山县','d',1818),(1828,'光山县','d',1818),(1829,'其他','d',1818),(1830,'周口','c',1661),(1831,'川汇区','d',1830),(1832,'项城市','d',1830),(1833,'商水县','d',1830),(1834,'淮阳县','d',1830),(1835,'太康县','d',1830),(1836,'鹿邑县','d',1830),(1837,'西华县','d',1830),(1838,'扶沟县','d',1830),(1839,'沈丘县','d',1830),(1840,'郸城县','d',1830),(1841,'其他','d',1830),(1842,'驻马店','c',1661),(1843,'驿城区','d',1842),(1844,'确山县','d',1842),(1845,'新蔡县','d',1842),(1846,'上蔡县','d',1842),(1847,'西平县','d',1842),(1848,'泌阳县','d',1842),(1849,'平舆县','d',1842),(1850,'汝南县','d',1842),(1851,'遂平县','d',1842),(1852,'正阳县','d',1842),(1853,'其他','d',1842),(1854,'焦作','c',1661),(1855,'济源市','d',1854),(1856,'其他','d',1854),(1857,'其他','c',1661),(1858,'其他','d',1857),(1859,'湖北','p',NULL),(1860,'武汉','c',1859),(1861,'江岸区','d',1860),(1862,'武昌区','d',1860),(1863,'江汉区','d',1860),(1864,'硚口区','d',1860),(1865,'汉阳区','d',1860),(1866,'青山区','d',1860),(1867,'洪山区','d',1860),(1868,'东西湖区','d',1860),(1869,'汉南区','d',1860),(1870,'蔡甸区','d',1860),(1871,'江夏区','d',1860),(1872,'黄陂区','d',1860),(1873,'新洲区','d',1860),(1874,'其他','d',1860),(1875,'黄石','c',1859),(1876,'黄石港区','d',1875),(1877,'西塞山区','d',1875),(1878,'下陆区','d',1875),(1879,'铁山区','d',1875),(1880,'大冶市','d',1875),(1881,'阳新县','d',1875),(1882,'其他','d',1875),(1883,'十堰','c',1859),(1884,'张湾区','d',1883),(1885,'茅箭区','d',1883),(1886,'丹江口市','d',1883),(1887,'郧县','d',1883),(1888,'竹山县','d',1883),(1889,'房县','d',1883),(1890,'郧西县','d',1883),(1891,'竹溪县','d',1883),(1892,'其他','d',1883),(1893,'荆州','c',1859),(1894,'沙市区','d',1893),(1895,'荆州区','d',1893),(1896,'洪湖市','d',1893),(1897,'石首市','d',1893),(1898,'松滋市','d',1893),(1899,'监利县','d',1893),(1900,'公安县','d',1893),(1901,'江陵县','d',1893),(1902,'其他','d',1893),(1903,'宜昌','c',1859),(1904,'西陵区','d',1903),(1905,'伍家岗区','d',1903),(1906,'点军区','d',1903),(1907,'猇亭区','d',1903),(1908,'夷陵区','d',1903),(1909,'宜都市','d',1903),(1910,'当阳市','d',1903),(1911,'枝江市','d',1903),(1912,'秭归县','d',1903),(1913,'远安县','d',1903),(1914,'兴山县','d',1903),(1915,'五峰土家族自治县','d',1903),(1916,'长阳土家族自治县','d',1903),(1917,'其他','d',1903),(1918,'襄樊','c',1859),(1919,'襄城区','d',1918),(1920,'樊城区','d',1918),(1921,'襄阳区','d',1918),(1922,'老河口市','d',1918),(1923,'枣阳市','d',1918),(1924,'宜城市','d',1918),(1925,'南漳县','d',1918),(1926,'谷城县','d',1918),(1927,'保康县','d',1918),(1928,'其他','d',1918),(1929,'鄂州','c',1859),(1930,'鄂城区','d',1929),(1931,'华容区','d',1929),(1932,'梁子湖区','d',1929),(1933,'其他','d',1929),(1934,'荆门','c',1859),(1935,'东宝区','d',1934),(1936,'掇刀区','d',1934),(1937,'钟祥市','d',1934),(1938,'京山县','d',1934),(1939,'沙洋县','d',1934),(1940,'其他','d',1934),(1941,'孝感','c',1859),(1942,'孝南区','d',1941),(1943,'应城市','d',1941),(1944,'安陆市','d',1941),(1945,'汉川市','d',1941),(1946,'云梦县','d',1941),(1947,'大悟县','d',1941),(1948,'孝昌县','d',1941),(1949,'其他','d',1941),(1950,'黄冈','c',1859),(1951,'黄州区','d',1950),(1952,'麻城市','d',1950),(1953,'武穴市','d',1950),(1954,'红安县','d',1950),(1955,'罗田县','d',1950),(1956,'浠水县','d',1950),(1957,'蕲春县','d',1950),(1958,'黄梅县','d',1950),(1959,'英山县','d',1950),(1960,'团风县','d',1950),(1961,'其他','d',1950),(1962,'咸宁','c',1859),(1963,'咸安区','d',1962),(1964,'赤壁市','d',1962),(1965,'嘉鱼县','d',1962),(1966,'通山县','d',1962),(1967,'崇阳县','d',1962),(1968,'通城县','d',1962),(1969,'其他','d',1962),(1970,'随州','c',1859),(1971,'曾都区','d',1970),(1972,'广水市','d',1970),(1973,'其他','d',1970),(1974,'恩施土家族苗族自治州','c',1859),(1975,'恩施市','d',1974),(1976,'利川市','d',1974),(1977,'建始县','d',1974),(1978,'来凤县','d',1974),(1979,'巴东县','d',1974),(1980,'鹤峰县','d',1974),(1981,'宣恩县','d',1974),(1982,'咸丰县','d',1974),(1983,'其他','d',1974),(1984,'仙桃','c',1859),(1985,'仙桃','d',1984),(1986,'天门','c',1859),(1987,'天门','d',1986),(1988,'潜江','c',1859),(1989,'潜江','d',1988),(1990,'神农架林区','c',1859),(1991,'神农架林区','d',1990),(1992,'其他','c',1859),(1993,'其他','d',1992),(1994,'湖南','p',NULL),(1995,'长沙','c',1994),(1996,'岳麓区','d',1995),(1997,'芙蓉区','d',1995),(1998,'天心区','d',1995),(1999,'开福区','d',1995),(2000,'雨花区','d',1995),(2001,'浏阳市','d',1995),(2002,'长沙县','d',1995),(2003,'望城县','d',1995),(2004,'宁乡县','d',1995),(2005,'其他','d',1995),(2006,'株洲','c',1994),(2007,'天元区','d',2006),(2008,'荷塘区','d',2006),(2009,'芦淞区','d',2006),(2010,'石峰区','d',2006),(2011,'醴陵市','d',2006),(2012,'株洲县','d',2006),(2013,'炎陵县','d',2006),(2014,'茶陵县','d',2006),(2015,'攸县','d',2006),(2016,'其他','d',2006),(2017,'湘潭','c',1994),(2018,'岳塘区','d',2017),(2019,'雨湖区','d',2017),(2020,'湘乡市','d',2017),(2021,'韶山市','d',2017),(2022,'湘潭县','d',2017),(2023,'其他','d',2017),(2024,'衡阳','c',1994),(2025,'雁峰区','d',2024),(2026,'珠晖区','d',2024),(2027,'石鼓区','d',2024),(2028,'蒸湘区','d',2024),(2029,'南岳区','d',2024),(2030,'耒阳市','d',2024),(2031,'常宁市','d',2024),(2032,'衡阳县','d',2024),(2033,'衡东县','d',2024),(2034,'衡山县','d',2024),(2035,'衡南县','d',2024),(2036,'祁东县','d',2024),(2037,'其他','d',2024),(2038,'邵阳','c',1994),(2039,'双清区','d',2038),(2040,'大祥区','d',2038),(2041,'北塔区','d',2038),(2042,'武冈市','d',2038),(2043,'邵东县','d',2038),(2044,'洞口县','d',2038),(2045,'新邵县','d',2038),(2046,'绥宁县','d',2038),(2047,'新宁县','d',2038),(2048,'邵阳县','d',2038),(2049,'隆回县','d',2038),(2050,'城步苗族自治县','d',2038),(2051,'其他','d',2038),(2052,'岳阳','c',1994),(2053,'岳阳楼区','d',2052),(2054,'云溪区','d',2052),(2055,'君山区','d',2052),(2056,'临湘市','d',2052),(2057,'汨罗市','d',2052),(2058,'岳阳县','d',2052),(2059,'湘阴县','d',2052),(2060,'平江县','d',2052),(2061,'华容县','d',2052),(2062,'其他','d',2052),(2063,'常德','c',1994),(2064,'武陵区','d',2063),(2065,'鼎城区','d',2063),(2066,'津市市','d',2063),(2067,'澧县','d',2063),(2068,'临澧县','d',2063),(2069,'桃源县','d',2063),(2070,'汉寿县','d',2063),(2071,'安乡县','d',2063),(2072,'石门县','d',2063),(2073,'其他','d',2063),(2074,'张家界','c',1994),(2075,'永定区','d',2074),(2076,'武陵源区','d',2074),(2077,'慈利县','d',2074),(2078,'桑植县','d',2074),(2079,'其他','d',2074),(2080,'益阳','c',1994),(2081,'赫山区','d',2080),(2082,'资阳区','d',2080),(2083,'沅江市','d',2080),(2084,'桃江县','d',2080),(2085,'南县','d',2080),(2086,'安化县','d',2080),(2087,'其他','d',2080),(2088,'郴州','c',1994),(2089,'北湖区','d',2088),(2090,'苏仙区','d',2088),(2091,'资兴市','d',2088),(2092,'宜章县','d',2088),(2093,'汝城县','d',2088),(2094,'安仁县','d',2088),(2095,'嘉禾县','d',2088),(2096,'临武县','d',2088),(2097,'桂东县','d',2088),(2098,'永兴县','d',2088),(2099,'桂阳县','d',2088),(2100,'其他','d',2088),(2101,'永州','c',1994),(2102,'冷水滩区','d',2101),(2103,'零陵区','d',2101),(2104,'祁阳县','d',2101),(2105,'蓝山县','d',2101),(2106,'宁远县','d',2101),(2107,'新田县','d',2101),(2108,'东安县','d',2101),(2109,'江永县','d',2101),(2110,'道县','d',2101),(2111,'双牌县','d',2101),(2112,'江华瑶族自治县','d',2101),(2113,'其他','d',2101),(2114,'怀化','c',1994),(2115,'鹤城区','d',2114),(2116,'洪江市','d',2114),(2117,'会同县','d',2114),(2118,'沅陵县','d',2114),(2119,'辰溪县','d',2114),(2120,'溆浦县','d',2114),(2121,'中方县','d',2114),(2122,'新晃侗族自治县','d',2114),(2123,'芷江侗族自治县','d',2114),(2124,'通道侗族自治县','d',2114),(2125,'靖州苗族侗族自治县','d',2114),(2126,'麻阳苗族自治县','d',2114),(2127,'其他','d',2114),(2128,'娄底','c',1994),(2129,'娄星区','d',2128),(2130,'冷水江市','d',2128),(2131,'涟源市','d',2128),(2132,'新化县','d',2128),(2133,'双峰县','d',2128),(2134,'其他','d',2128),(2135,'湘西土家族苗族自治州','c',1994),(2136,'吉首市','d',2135),(2137,'古丈县','d',2135),(2138,'龙山县','d',2135),(2139,'永顺县','d',2135),(2140,'凤凰县','d',2135),(2141,'泸溪县','d',2135),(2142,'保靖县','d',2135),(2143,'花垣县','d',2135),(2144,'其他','d',2135),(2145,'其他','c',1994),(2146,'其他','d',2145),(2147,'广东','p',NULL),(2148,'广州','c',2147),(2149,'越秀区','d',2148),(2150,'荔湾区','d',2148),(2151,'海珠区','d',2148),(2152,'天河区','d',2148),(2153,'白云区','d',2148),(2154,'黄埔区','d',2148),(2155,'番禺区','d',2148),(2156,'花都区','d',2148),(2157,'南沙区','d',2148),(2158,'萝岗区','d',2148),(2159,'增城市','d',2148),(2160,'从化市','d',2148),(2161,'其他','d',2148),(2162,'深圳','c',2147),(2163,'福田区','d',2162),(2164,'罗湖区','d',2162),(2165,'南山区','d',2162),(2166,'宝安区','d',2162),(2167,'龙岗区','d',2162),(2168,'盐田区','d',2162),(2169,'其他','d',2162),(2170,'东莞','c',2147),(2171,'莞城','d',2170),(2172,'常平','d',2170),(2173,'塘厦','d',2170),(2174,'万江','d',2170),(2175,'虎门','d',2170),(2176,'其他','d',2170),(2177,'中山','c',2147),(2178,'中山','d',2177),(2179,'潮州','c',2147),(2180,'湘桥区','d',2179),(2181,'潮安县','d',2179),(2182,'饶平县','d',2179),(2183,'其他','d',2179),(2184,'揭阳','c',2147),(2185,'榕城区','d',2184),(2186,'揭东县','d',2184),(2187,'揭西县','d',2184),(2188,'惠来县','d',2184),(2189,'普宁市','d',2184),(2190,'其他','d',2184),(2191,'云浮','c',2147),(2192,'云城区','d',2191),(2193,'新兴县','d',2191),(2194,'郁南县','d',2191),(2195,'云安县','d',2191),(2196,'罗定市','d',2191),(2197,'其他','d',2191),(2198,'珠海','c',2147),(2199,'香洲区','d',2198),(2200,'斗门区','d',2198),(2201,'金湾区','d',2198),(2202,'其他','d',2198),(2203,'汕头','c',2147),(2204,'金平区','d',2203),(2205,'濠江区','d',2203),(2206,'龙湖区','d',2203),(2207,'潮阳区','d',2203),(2208,'潮南区','d',2203),(2209,'澄海区','d',2203),(2210,'南澳县','d',2203),(2211,'其他','d',2203),(2212,'韶关','c',2147),(2213,'浈江区','d',2212),(2214,'武江区','d',2212),(2215,'曲江区','d',2212),(2216,'乐昌市','d',2212),(2217,'南雄市','d',2212),(2218,'始兴县','d',2212),(2219,'仁化县','d',2212),(2220,'翁源县','d',2212),(2221,'新丰县','d',2212),(2222,'乳源瑶族自治县','d',2212),(2223,'其他','d',2212),(2224,'佛山','c',2147),(2225,'禅城区','d',2224),(2226,'南海区','d',2224),(2227,'顺德区','d',2224),(2228,'三水区','d',2224),(2229,'高明区','d',2224),(2230,'其他','d',2224),(2231,'江门','c',2147),(2232,'蓬江区','d',2231),(2233,'江海区','d',2231),(2234,'新会区','d',2231),(2235,'恩平市','d',2231),(2236,'台山市','d',2231),(2237,'开平市','d',2231),(2238,'鹤山市','d',2231),(2239,'其他','d',2231),(2240,'湛江','c',2147),(2241,'赤坎区','d',2240),(2242,'霞山区','d',2240),(2243,'坡头区','d',2240),(2244,'麻章区','d',2240),(2245,'吴川市','d',2240),(2246,'廉江市','d',2240),(2247,'雷州市','d',2240),(2248,'遂溪县','d',2240),(2249,'徐闻县','d',2240),(2250,'其他','d',2240),(2251,'茂名','c',2147),(2252,'茂南区','d',2251),(2253,'茂港区','d',2251),(2254,'化州市','d',2251),(2255,'信宜市','d',2251),(2256,'高州市','d',2251),(2257,'电白县','d',2251),(2258,'其他','d',2251),(2259,'肇庆','c',2147),(2260,'端州区','d',2259),(2261,'鼎湖区','d',2259),(2262,'高要市','d',2259),(2263,'四会市','d',2259),(2264,'广宁县','d',2259),(2265,'怀集县','d',2259),(2266,'封开县','d',2259),(2267,'德庆县','d',2259),(2268,'其他','d',2259),(2269,'惠州','c',2147),(2270,'惠城区','d',2269),(2271,'惠阳区','d',2269),(2272,'博罗县','d',2269),(2273,'惠东县','d',2269),(2274,'龙门县','d',2269),(2275,'其他','d',2269),(2276,'梅州','c',2147),(2277,'梅江区','d',2276),(2278,'兴宁市','d',2276),(2279,'梅县','d',2276),(2280,'大埔县','d',2276),(2281,'丰顺县','d',2276),(2282,'五华县','d',2276),(2283,'平远县','d',2276),(2284,'蕉岭县','d',2276),(2285,'其他','d',2276),(2286,'汕尾','c',2147),(2287,'城区','d',2286),(2288,'陆丰市','d',2286),(2289,'海丰县','d',2286),(2290,'陆河县','d',2286),(2291,'其他','d',2286),(2292,'河源','c',2147),(2293,'源城区','d',2292),(2294,'紫金县','d',2292),(2295,'龙川县','d',2292),(2296,'连平县','d',2292),(2297,'和平县','d',2292),(2298,'东源县','d',2292),(2299,'其他','d',2292),(2300,'阳江','c',2147),(2301,'江城区','d',2300),(2302,'阳春市','d',2300),(2303,'阳西县','d',2300),(2304,'阳东县','d',2300),(2305,'其他','d',2300),(2306,'清远','c',2147),(2307,'清城区','d',2306),(2308,'英德市','d',2306),(2309,'连州市','d',2306),(2310,'佛冈县','d',2306),(2311,'阳山县','d',2306),(2312,'清新县','d',2306),(2313,'连山壮族瑶族自治县','d',2306),(2314,'连南瑶族自治县','d',2306),(2315,'其他','d',2306),(2316,'广西','p',NULL),(2317,'南宁','c',2316),(2318,'青秀区','d',2317),(2319,'兴宁区','d',2317),(2320,'西乡塘区','d',2317),(2321,'良庆区','d',2317),(2322,'江南区','d',2317),(2323,'邕宁区','d',2317),(2324,'武鸣县','d',2317),(2325,'隆安县','d',2317),(2326,'马山县','d',2317),(2327,'上林县','d',2317),(2328,'宾阳县','d',2317),(2329,'横县','d',2317),(2330,'其他','d',2317),(2331,'柳州','c',2316),(2332,'城中区','d',2331),(2333,'鱼峰区','d',2331),(2334,'柳北区','d',2331),(2335,'柳南区','d',2331),(2336,'柳江县','d',2331),(2337,'柳城县','d',2331),(2338,'鹿寨县','d',2331),(2339,'融安县','d',2331),(2340,'融水苗族自治县','d',2331),(2341,'三江侗族自治县','d',2331),(2342,'其他','d',2331),(2343,'桂林','c',2316),(2344,'象山区','d',2343),(2345,'秀峰区','d',2343),(2346,'叠彩区','d',2343),(2347,'七星区','d',2343),(2348,'雁山区','d',2343),(2349,'阳朔县','d',2343),(2350,'临桂县','d',2343),(2351,'灵川县','d',2343),(2352,'全州县','d',2343),(2353,'平乐县','d',2343),(2354,'兴安县','d',2343),(2355,'灌阳县','d',2343),(2356,'荔浦县','d',2343),(2357,'资源县','d',2343),(2358,'永福县','d',2343),(2359,'龙胜各族自治县','d',2343),(2360,'恭城瑶族自治县','d',2343),(2361,'其他','d',2343),(2362,'梧州','c',2316),(2363,'万秀区','d',2362),(2364,'蝶山区','d',2362),(2365,'长洲区','d',2362),(2366,'岑溪市','d',2362),(2367,'苍梧县','d',2362),(2368,'藤县','d',2362),(2369,'蒙山县','d',2362),(2370,'其他','d',2362),(2371,'北海','c',2316),(2372,'海城区','d',2371),(2373,'银海区','d',2371),(2374,'铁山港区','d',2371),(2375,'合浦县','d',2371),(2376,'其他','d',2371),(2377,'防城港','c',2316),(2378,'港口区','d',2377),(2379,'防城区','d',2377),(2380,'东兴市','d',2377),(2381,'上思县','d',2377),(2382,'其他','d',2377),(2383,'钦州','c',2316),(2384,'钦南区','d',2383),(2385,'钦北区','d',2383),(2386,'灵山县','d',2383),(2387,'浦北县','d',2383),(2388,'其他','d',2383),(2389,'贵港','c',2316),(2390,'港北区','d',2389),(2391,'港南区','d',2389),(2392,'覃塘区','d',2389),(2393,'桂平市','d',2389),(2394,'平南县','d',2389),(2395,'其他','d',2389),(2396,'玉林','c',2316),(2397,'玉州区','d',2396),(2398,'北流市','d',2396),(2399,'容县','d',2396),(2400,'陆川县','d',2396),(2401,'博白县','d',2396),(2402,'兴业县','d',2396),(2403,'其他','d',2396),(2404,'百色','c',2316),(2405,'右江区','d',2404),(2406,'凌云县','d',2404),(2407,'平果县','d',2404),(2408,'西林县','d',2404),(2409,'乐业县','d',2404),(2410,'德保县','d',2404),(2411,'田林县','d',2404),(2412,'田阳县','d',2404),(2413,'靖西县','d',2404),(2414,'田东县','d',2404),(2415,'那坡县','d',2404),(2416,'隆林各族自治县','d',2404),(2417,'其他','d',2404),(2418,'贺州','c',2316),(2419,'八步区','d',2418),(2420,'钟山县','d',2418),(2421,'昭平县','d',2418),(2422,'富川瑶族自治县','d',2418),(2423,'其他','d',2418),(2424,'河池','c',2316),(2425,'金城江区','d',2424),(2426,'宜州市','d',2424),(2427,'天峨县','d',2424),(2428,'凤山县','d',2424),(2429,'南丹县','d',2424),(2430,'东兰县','d',2424),(2431,'都安瑶族自治县','d',2424),(2432,'罗城仫佬族自治县','d',2424),(2433,'巴马瑶族自治县','d',2424),(2434,'环江毛南族自治县','d',2424),(2435,'大化瑶族自治县','d',2424),(2436,'其他','d',2424),(2437,'来宾','c',2316),(2438,'兴宾区','d',2437),(2439,'合山市','d',2437),(2440,'象州县','d',2437),(2441,'武宣县','d',2437),(2442,'忻城县','d',2437),(2443,'金秀瑶族自治县','d',2437),(2444,'其他','d',2437),(2445,'崇左','c',2316),(2446,'江州区','d',2445),(2447,'凭祥市','d',2445),(2448,'宁明县','d',2445),(2449,'扶绥县','d',2445),(2450,'龙州县','d',2445),(2451,'大新县','d',2445),(2452,'天等县','d',2445),(2453,'其他','d',2445),(2454,'其他','c',2316),(2455,'其他','d',2454),(2456,'海南','p',NULL),(2457,'海口','c',2456),(2458,'龙华区','d',2457),(2459,'秀英区','d',2457),(2460,'琼山区','d',2457),(2461,'美兰区','d',2457),(2462,'其他','d',2457),(2463,'三亚','c',2456),(2464,'三亚市','d',2463),(2465,'其他','d',2463),(2466,'五指山','c',2456),(2467,'五指山','d',2466),(2468,'琼海','c',2456),(2469,'琼海','d',2468),(2470,'儋州','c',2456),(2471,'儋州','d',2470),(2472,'文昌','c',2456),(2473,'文昌','d',2472),(2474,'万宁','c',2456),(2475,'万宁','d',2474),(2476,'东方','c',2456),(2477,'东方','d',2476),(2478,'澄迈县','c',2456),(2479,'澄迈县','d',2478),(2480,'定安县','c',2456),(2481,'定安县','d',2480),(2482,'屯昌县','c',2456),(2483,'屯昌县','d',2482),(2484,'临高县','c',2456),(2485,'临高县','d',2484),(2486,'白沙黎族自治县','c',2456),(2487,'白沙黎族自治县','d',2486),(2488,'昌江黎族自治县','c',2456),(2489,'昌江黎族自治县','d',2488),(2490,'乐东黎族自治县','c',2456),(2491,'乐东黎族自治县','d',2490),(2492,'陵水黎族自治县','c',2456),(2493,'陵水黎族自治县','d',2492),(2494,'保亭黎族苗族自治县','c',2456),(2495,'保亭黎族苗族自治县','d',2494),(2496,'琼中黎族苗族自治县','c',2456),(2497,'琼中黎族苗族自治县','d',2496),(2498,'其他','c',2456),(2499,'其他','d',2498),(2500,'重庆','p',NULL),(2501,'重庆','c',2500),(2502,'渝中区','d',2501),(2503,'大渡口区','d',2501),(2504,'江北区','d',2501),(2505,'南岸区','d',2501),(2506,'北碚区','d',2501),(2507,'渝北区','d',2501),(2508,'巴南区','d',2501),(2509,'长寿区','d',2501),(2510,'双桥区','d',2501),(2511,'沙坪坝区','d',2501),(2512,'万盛区','d',2501),(2513,'万州区','d',2501),(2514,'涪陵区','d',2501),(2515,'黔江区','d',2501),(2516,'永川区','d',2501),(2517,'合川区','d',2501),(2518,'江津区','d',2501),(2519,'九龙坡区','d',2501),(2520,'南川区','d',2501),(2521,'綦江县','d',2501),(2522,'潼南县','d',2501),(2523,'荣昌县','d',2501),(2524,'璧山县','d',2501),(2525,'大足县','d',2501),(2526,'铜梁县','d',2501),(2527,'梁平县','d',2501),(2528,'开县','d',2501),(2529,'忠县','d',2501),(2530,'城口县','d',2501),(2531,'垫江县','d',2501),(2532,'武隆县','d',2501),(2533,'丰都县','d',2501),(2534,'奉节县','d',2501),(2535,'云阳县','d',2501),(2536,'巫溪县','d',2501),(2537,'巫山县','d',2501),(2538,'石柱土家族自治县','d',2501),(2539,'秀山土家族苗族自治县','d',2501),(2540,'酉阳土家族苗族自治县','d',2501),(2541,'彭水苗族土家族自治县','d',2501),(2542,'其他','d',2501),(2543,'四川','p',NULL),(2544,'成都','c',2543),(2545,'青羊区','d',2544),(2546,'锦江区','d',2544),(2547,'金牛区','d',2544),(2548,'武侯区','d',2544),(2549,'成华区','d',2544),(2550,'龙泉驿区','d',2544),(2551,'青白江区','d',2544),(2552,'新都区','d',2544),(2553,'温江区','d',2544),(2554,'都江堰市','d',2544),(2555,'彭州市','d',2544),(2556,'邛崃市','d',2544),(2557,'崇州市','d',2544),(2558,'金堂县','d',2544),(2559,'郫县','d',2544),(2560,'新津县','d',2544),(2561,'双流县','d',2544),(2562,'蒲江县','d',2544),(2563,'大邑县','d',2544),(2564,'其他','d',2544),(2565,'自贡','c',2543),(2566,'大安区','d',2565),(2567,'自流井区','d',2565),(2568,'贡井区','d',2565),(2569,'沿滩区','d',2565),(2570,'荣县','d',2565),(2571,'富顺县','d',2565),(2572,'其他','d',2565),(2573,'攀枝花','c',2543),(2574,'仁和区','d',2573),(2575,'米易县','d',2573),(2576,'盐边县','d',2573),(2577,'东区','d',2573),(2578,'西区','d',2573),(2579,'其他','d',2573),(2580,'泸州','c',2543),(2581,'江阳区','d',2580),(2582,'纳溪区','d',2580),(2583,'龙马潭区','d',2580),(2584,'泸县','d',2580),(2585,'合江县','d',2580),(2586,'叙永县','d',2580),(2587,'古蔺县','d',2580),(2588,'其他','d',2580),(2589,'德阳','c',2543),(2590,'旌阳区','d',2589),(2591,'广汉市','d',2589),(2592,'什邡市','d',2589),(2593,'绵竹市','d',2589),(2594,'罗江县','d',2589),(2595,'中江县','d',2589),(2596,'其他','d',2589),(2597,'绵阳','c',2543),(2598,'涪城区','d',2597),(2599,'游仙区','d',2597),(2600,'江油市','d',2597),(2601,'盐亭县','d',2597),(2602,'三台县','d',2597),(2603,'平武县','d',2597),(2604,'安县','d',2597),(2605,'梓潼县','d',2597),(2606,'北川羌族自治县','d',2597),(2607,'其他','d',2597),(2608,'广元','c',2543),(2609,'元坝区','d',2608),(2610,'朝天区','d',2608),(2611,'青川县','d',2608),(2612,'旺苍县','d',2608),(2613,'剑阁县','d',2608),(2614,'苍溪县','d',2608),(2615,'市中区','d',2608),(2616,'其他','d',2608),(2617,'遂宁','c',2543),(2618,'船山区','d',2617),(2619,'安居区','d',2617),(2620,'射洪县','d',2617),(2621,'蓬溪县','d',2617),(2622,'大英县','d',2617),(2623,'其他','d',2617),(2624,'内江','c',2543),(2625,'市中区','d',2624),(2626,'东兴区','d',2624),(2627,'资中县','d',2624),(2628,'隆昌县','d',2624),(2629,'威远县','d',2624),(2630,'其他','d',2624),(2631,'乐山','c',2543),(2632,'市中区','d',2631),(2633,'五通桥区','d',2631),(2634,'沙湾区','d',2631),(2635,'金口河区','d',2631),(2636,'峨眉山市','d',2631),(2637,'夹江县','d',2631),(2638,'井研县','d',2631),(2639,'犍为县','d',2631),(2640,'沐川县','d',2631),(2641,'马边彝族自治县','d',2631),(2642,'峨边彝族自治县','d',2631),(2643,'其他','d',2631),(2644,'南充','c',2543),(2645,'顺庆区','d',2644),(2646,'高坪区','d',2644),(2647,'嘉陵区','d',2644),(2648,'阆中市','d',2644),(2649,'营山县','d',2644),(2650,'蓬安县','d',2644),(2651,'仪陇县','d',2644),(2652,'南部县','d',2644),(2653,'西充县','d',2644),(2654,'其他','d',2644),(2655,'眉山','c',2543),(2656,'东坡区','d',2655),(2657,'仁寿县','d',2655),(2658,'彭山县','d',2655),(2659,'洪雅县','d',2655),(2660,'丹棱县','d',2655),(2661,'青神县','d',2655),(2662,'其他','d',2655),(2663,'宜宾','c',2543),(2664,'翠屏区','d',2663),(2665,'宜宾县','d',2663),(2666,'兴文县','d',2663),(2667,'南溪县','d',2663),(2668,'珙县','d',2663),(2669,'长宁县','d',2663),(2670,'高县','d',2663),(2671,'江安县','d',2663),(2672,'筠连县','d',2663),(2673,'屏山县','d',2663),(2674,'其他','d',2663),(2675,'广安','c',2543),(2676,'广安区','d',2675),(2677,'华蓥市','d',2675),(2678,'岳池县','d',2675),(2679,'邻水县','d',2675),(2680,'武胜县','d',2675),(2681,'其他','d',2675),(2682,'达州','c',2543),(2683,'通川区','d',2682),(2684,'万源市','d',2682),(2685,'达县','d',2682),(2686,'渠县','d',2682),(2687,'宣汉县','d',2682),(2688,'开江县','d',2682),(2689,'大竹县','d',2682),(2690,'其他','d',2682),(2691,'雅安','c',2543),(2692,'雨城区','d',2691),(2693,'芦山县','d',2691),(2694,'石棉县','d',2691),(2695,'名山县','d',2691),(2696,'天全县','d',2691),(2697,'荥经县','d',2691),(2698,'宝兴县','d',2691),(2699,'汉源县','d',2691),(2700,'其他','d',2691),(2701,'巴中','c',2543),(2702,'巴州区','d',2701),(2703,'南江县','d',2701),(2704,'平昌县','d',2701),(2705,'通江县','d',2701),(2706,'其他','d',2701),(2707,'资阳','c',2543),(2708,'雁江区','d',2707),(2709,'简阳市','d',2707),(2710,'安岳县','d',2707),(2711,'乐至县','d',2707),(2712,'其他','d',2707),(2713,'阿坝藏族羌族自治州','c',2543),(2714,'马尔康县','d',2713),(2715,'九寨沟县','d',2713),(2716,'红原县','d',2713),(2717,'汶川县','d',2713),(2718,'阿坝县','d',2713),(2719,'理县','d',2713),(2720,'若尔盖县','d',2713),(2721,'小金县','d',2713),(2722,'黑水县','d',2713),(2723,'金川县','d',2713),(2724,'松潘县','d',2713),(2725,'壤塘县','d',2713),(2726,'茂县','d',2713),(2727,'其他','d',2713),(2728,'甘孜藏族自治州','c',2543),(2729,'康定县','d',2728),(2730,'丹巴县','d',2728),(2731,'炉霍县','d',2728),(2732,'九龙县','d',2728),(2733,'甘孜县','d',2728),(2734,'雅江县','d',2728),(2735,'新龙县','d',2728),(2736,'道孚县','d',2728),(2737,'白玉县','d',2728),(2738,'理塘县','d',2728),(2739,'德格县','d',2728),(2740,'乡城县','d',2728),(2741,'石渠县','d',2728),(2742,'稻城县','d',2728),(2743,'色达县','d',2728),(2744,'巴塘县','d',2728),(2745,'泸定县','d',2728),(2746,'得荣县','d',2728),(2747,'其他','d',2728),(2748,'凉山彝族自治州','c',2543),(2749,'西昌市','d',2748),(2750,'美姑县','d',2748),(2751,'昭觉县','d',2748),(2752,'金阳县','d',2748),(2753,'甘洛县','d',2748),(2754,'布拖县','d',2748),(2755,'雷波县','d',2748),(2756,'普格县','d',2748),(2757,'宁南县','d',2748),(2758,'喜德县','d',2748),(2759,'会东县','d',2748),(2760,'越西县','d',2748),(2761,'会理县','d',2748),(2762,'盐源县','d',2748),(2763,'德昌县','d',2748),(2764,'冕宁县','d',2748),(2765,'木里藏族自治县','d',2748),(2766,'其他','d',2748),(2767,'其他','c',2543),(2768,'其他','d',2767),(2769,'贵州','p',NULL),(2770,'贵阳','c',2769),(2771,'南明区','d',2770),(2772,'云岩区','d',2770),(2773,'花溪区','d',2770),(2774,'乌当区','d',2770),(2775,'白云区','d',2770),(2776,'小河区','d',2770),(2777,'清镇市','d',2770),(2778,'开阳县','d',2770),(2779,'修文县','d',2770),(2780,'息烽县','d',2770),(2781,'其他','d',2770),(2782,'六盘水','c',2769),(2783,'钟山区','d',2782),(2784,'水城县','d',2782),(2785,'盘县','d',2782),(2786,'六枝特区','d',2782),(2787,'其他','d',2782),(2788,'遵义','c',2769),(2789,'红花岗区','d',2788),(2790,'汇川区','d',2788),(2791,'赤水市','d',2788),(2792,'仁怀市','d',2788),(2793,'遵义县','d',2788),(2794,'绥阳县','d',2788),(2795,'桐梓县','d',2788),(2796,'习水县','d',2788),(2797,'凤冈县','d',2788),(2798,'正安县','d',2788),(2799,'余庆县','d',2788),(2800,'湄潭县','d',2788),(2801,'道真仡佬族苗族自治县','d',2788),(2802,'务川仡佬族苗族自治县','d',2788),(2803,'其他','d',2788),(2804,'安顺','c',2769),(2805,'西秀区','d',2804),(2806,'普定县','d',2804),(2807,'平坝县','d',2804),(2808,'镇宁布依族苗族自治县','d',2804),(2809,'紫云苗族布依族自治县','d',2804),(2810,'关岭布依族苗族自治县','d',2804),(2811,'其他','d',2804),(2812,'铜仁地区','c',2769),(2813,'铜仁市','d',2812),(2814,'德江县','d',2812),(2815,'江口县','d',2812),(2816,'思南县','d',2812),(2817,'石阡县','d',2812),(2818,'玉屏侗族自治县','d',2812),(2819,'松桃苗族自治县','d',2812),(2820,'印江土家族苗族自治县','d',2812),(2821,'沿河土家族自治县','d',2812),(2822,'万山特区','d',2812),(2823,'其他','d',2812),(2824,'毕节地区','c',2769),(2825,'毕节市','d',2824),(2826,'黔西县','d',2824),(2827,'大方县','d',2824),(2828,'织金县','d',2824),(2829,'金沙县','d',2824),(2830,'赫章县','d',2824),(2831,'纳雍县','d',2824),(2832,'威宁彝族回族苗族自治县','d',2824),(2833,'其他','d',2824),(2834,'黔西南布依族苗族自治州','c',2769),(2835,'兴义市','d',2834),(2836,'望谟县','d',2834),(2837,'兴仁县','d',2834),(2838,'普安县','d',2834),(2839,'册亨县','d',2834),(2840,'晴隆县','d',2834),(2841,'贞丰县','d',2834),(2842,'安龙县','d',2834),(2843,'其他','d',2834),(2844,'黔东南苗族侗族自治州','c',2769),(2845,'凯里市','d',2844),(2846,'施秉县','d',2844),(2847,'从江县','d',2844),(2848,'锦屏县','d',2844),(2849,'镇远县','d',2844),(2850,'麻江县','d',2844),(2851,'台江县','d',2844),(2852,'天柱县','d',2844),(2853,'黄平县','d',2844),(2854,'榕江县','d',2844),(2855,'剑河县','d',2844),(2856,'三穗县','d',2844),(2857,'雷山县','d',2844),(2858,'黎平县','d',2844),(2859,'岑巩县','d',2844),(2860,'丹寨县','d',2844),(2861,'其他','d',2844),(2862,'黔南布依族苗族自治州','c',2769),(2863,'都匀市','d',2862),(2864,'福泉市','d',2862),(2865,'贵定县','d',2862),(2866,'惠水县','d',2862),(2867,'罗甸县','d',2862),(2868,'瓮安县','d',2862),(2869,'荔波县','d',2862),(2870,'龙里县','d',2862),(2871,'平塘县','d',2862),(2872,'长顺县','d',2862),(2873,'独山县','d',2862),(2874,'三都水族自治县','d',2862),(2875,'其他','d',2862),(2876,'其他','c',2769),(2877,'其他','d',2876),(2878,'云南','p',NULL),(2879,'昆明','c',2878),(2880,'盘龙区','d',2879),(2881,'五华区','d',2879),(2882,'官渡区','d',2879),(2883,'西山区','d',2879),(2884,'东川区','d',2879),(2885,'安宁市','d',2879),(2886,'呈贡县','d',2879),(2887,'晋宁县','d',2879),(2888,'富民县','d',2879),(2889,'宜良县','d',2879),(2890,'嵩明县','d',2879),(2891,'石林彝族自治县','d',2879),(2892,'禄劝彝族苗族自治县','d',2879),(2893,'寻甸回族彝族自治县','d',2879),(2894,'其他','d',2879),(2895,'曲靖','c',2878),(2896,'麒麟区','d',2895),(2897,'宣威市','d',2895),(2898,'马龙县','d',2895),(2899,'沾益县','d',2895),(2900,'富源县','d',2895),(2901,'罗平县','d',2895),(2902,'师宗县','d',2895),(2903,'陆良县','d',2895),(2904,'会泽县','d',2895),(2905,'其他','d',2895),(2906,'玉溪','c',2878),(2907,'红塔区','d',2906),(2908,'江川县','d',2906),(2909,'澄江县','d',2906),(2910,'通海县','d',2906),(2911,'华宁县','d',2906),(2912,'易门县','d',2906),(2913,'峨山彝族自治县','d',2906),(2914,'新平彝族傣族自治县','d',2906),(2915,'元江哈尼族彝族傣族自治县','d',2906),(2916,'其他','d',2906),(2917,'保山','c',2878),(2918,'隆阳区','d',2917),(2919,'施甸县','d',2917),(2920,'腾冲县','d',2917),(2921,'龙陵县','d',2917),(2922,'昌宁县','d',2917),(2923,'其他','d',2917),(2924,'昭通','c',2878),(2925,'昭阳区','d',2924),(2926,'鲁甸县','d',2924),(2927,'巧家县','d',2924),(2928,'盐津县','d',2924),(2929,'大关县','d',2924),(2930,'永善县','d',2924),(2931,'绥江县','d',2924),(2932,'镇雄县','d',2924),(2933,'彝良县','d',2924),(2934,'威信县','d',2924),(2935,'水富县','d',2924),(2936,'其他','d',2924),(2937,'丽江','c',2878),(2938,'古城区','d',2937),(2939,'永胜县','d',2937),(2940,'华坪县','d',2937),(2941,'玉龙纳西族自治县','d',2937),(2942,'宁蒗彝族自治县','d',2937),(2943,'其他','d',2937),(2944,'普洱','c',2878),(2945,'思茅区','d',2944),(2946,'普洱哈尼族彝族自治县','d',2944),(2947,'墨江哈尼族自治县','d',2944),(2948,'景东彝族自治县','d',2944),(2949,'景谷傣族彝族自治县','d',2944),(2950,'镇沅彝族哈尼族拉祜族自治县','d',2944),(2951,'江城哈尼族彝族自治县','d',2944),(2952,'孟连傣族拉祜族佤族自治县','d',2944),(2953,'澜沧拉祜族自治县','d',2944),(2954,'西盟佤族自治县','d',2944),(2955,'其他','d',2944),(2956,'临沧','c',2878),(2957,'临翔区','d',2956),(2958,'凤庆县','d',2956),(2959,'云县','d',2956),(2960,'永德县','d',2956),(2961,'镇康县','d',2956),(2962,'双江拉祜族佤族布朗族傣族自治县','d',2956),(2963,'耿马傣族佤族自治县','d',2956),(2964,'沧源佤族自治县','d',2956),(2965,'其他','d',2956),(2966,'德宏傣族景颇族自治州','c',2878),(2967,'潞西市','d',2966),(2968,'瑞丽市','d',2966),(2969,'梁河县','d',2966),(2970,'盈江县','d',2966),(2971,'陇川县','d',2966),(2972,'其他','d',2966),(2973,'怒江傈僳族自治州','c',2878),(2974,'泸水县','d',2973),(2975,'福贡县','d',2973),(2976,'贡山独龙族怒族自治县','d',2973),(2977,'兰坪白族普米族自治县','d',2973),(2978,'其他','d',2973),(2979,'迪庆藏族自治州','c',2878),(2980,'香格里拉县','d',2979),(2981,'德钦县','d',2979),(2982,'维西傈僳族自治县','d',2979),(2983,'其他','d',2979),(2984,'大理白族自治州','c',2878),(2985,'大理市','d',2984),(2986,'祥云县','d',2984),(2987,'宾川县','d',2984),(2988,'弥渡县','d',2984),(2989,'永平县','d',2984),(2990,'云龙县','d',2984),(2991,'洱源县','d',2984),(2992,'剑川县','d',2984),(2993,'鹤庆县','d',2984),(2994,'漾濞彝族自治县','d',2984),(2995,'南涧彝族自治县','d',2984),(2996,'巍山彝族回族自治县','d',2984),(2997,'其他','d',2984),(2998,'楚雄彝族自治州','c',2878),(2999,'楚雄市','d',2998),(3000,'双柏县','d',2998),(3001,'牟定县','d',2998),(3002,'南华县','d',2998),(3003,'姚安县','d',2998),(3004,'大姚县','d',2998),(3005,'永仁县','d',2998),(3006,'元谋县','d',2998),(3007,'武定县','d',2998),(3008,'禄丰县','d',2998),(3009,'其他','d',2998),(3010,'红河哈尼族彝族自治州','c',2878),(3011,'蒙自县','d',3010),(3012,'个旧市','d',3010),(3013,'开远市','d',3010),(3014,'绿春县','d',3010),(3015,'建水县','d',3010),(3016,'石屏县','d',3010),(3017,'弥勒县','d',3010),(3018,'泸西县','d',3010),(3019,'元阳县','d',3010),(3020,'红河县','d',3010),(3021,'金平苗族瑶族傣族自治县','d',3010),(3022,'河口瑶族自治县','d',3010),(3023,'屏边苗族自治县','d',3010),(3024,'其他','d',3010),(3025,'文山壮族苗族自治州','c',2878),(3026,'文山县','d',3025),(3027,'砚山县','d',3025),(3028,'西畴县','d',3025),(3029,'麻栗坡县','d',3025),(3030,'马关县','d',3025),(3031,'丘北县','d',3025),(3032,'广南县','d',3025),(3033,'富宁县','d',3025),(3034,'其他','d',3025),(3035,'西双版纳傣族自治州','c',2878),(3036,'景洪市','d',3035),(3037,'勐海县','d',3035),(3038,'勐腊县','d',3035),(3039,'其他','d',3035),(3040,'其他','c',2878),(3041,'其他','d',3040),(3042,'西藏','p',NULL),(3043,'拉萨','c',3042),(3044,'城关区','d',3043),(3045,'林周县','d',3043),(3046,'当雄县','d',3043),(3047,'尼木县','d',3043),(3048,'曲水县','d',3043),(3049,'堆龙德庆县','d',3043),(3050,'达孜县','d',3043),(3051,'墨竹工卡县','d',3043),(3052,'其他','d',3043),(3053,'那曲地区','c',3042),(3054,'那曲县','d',3053),(3055,'嘉黎县','d',3053),(3056,'比如县','d',3053),(3057,'聂荣县','d',3053),(3058,'安多县','d',3053),(3059,'申扎县','d',3053),(3060,'索县','d',3053),(3061,'班戈县','d',3053),(3062,'巴青县','d',3053),(3063,'尼玛县','d',3053),(3064,'其他','d',3053),(3065,'昌都地区','c',3042),(3066,'昌都县','d',3065),(3067,'江达县','d',3065),(3068,'贡觉县','d',3065),(3069,'类乌齐县','d',3065),(3070,'丁青县','d',3065),(3071,'察雅县','d',3065),(3072,'八宿县','d',3065),(3073,'左贡县','d',3065),(3074,'芒康县','d',3065),(3075,'洛隆县','d',3065),(3076,'边坝县','d',3065),(3077,'其他','d',3065),(3078,'林芝地区','c',3042),(3079,'林芝县','d',3078),(3080,'工布江达县','d',3078),(3081,'米林县','d',3078),(3082,'墨脱县','d',3078),(3083,'波密县','d',3078),(3084,'察隅县','d',3078),(3085,'朗县','d',3078),(3086,'其他','d',3078),(3087,'山南地区','c',3042),(3088,'乃东县','d',3087),(3089,'扎囊县','d',3087),(3090,'贡嘎县','d',3087),(3091,'桑日县','d',3087),(3092,'琼结县','d',3087),(3093,'曲松县','d',3087),(3094,'措美县','d',3087),(3095,'洛扎县','d',3087),(3096,'加查县','d',3087),(3097,'隆子县','d',3087),(3098,'错那县','d',3087),(3099,'浪卡子县','d',3087),(3100,'其他','d',3087),(3101,'日喀则地区','c',3042),(3102,'日喀则市','d',3101),(3103,'南木林县','d',3101),(3104,'江孜县','d',3101),(3105,'定日县','d',3101),(3106,'萨迦县','d',3101),(3107,'拉孜县','d',3101),(3108,'昂仁县','d',3101),(3109,'谢通门县','d',3101),(3110,'白朗县','d',3101),(3111,'仁布县','d',3101),(3112,'康马县','d',3101),(3113,'定结县','d',3101),(3114,'仲巴县','d',3101),(3115,'亚东县','d',3101),(3116,'吉隆县','d',3101),(3117,'聂拉木县','d',3101),(3118,'萨嘎县','d',3101),(3119,'岗巴县','d',3101),(3120,'其他','d',3101),(3121,'阿里地区','c',3042),(3122,'噶尔县','d',3121),(3123,'普兰县','d',3121),(3124,'札达县','d',3121),(3125,'日土县','d',3121),(3126,'革吉县','d',3121),(3127,'改则县','d',3121),(3128,'措勤县','d',3121),(3129,'其他','d',3121),(3130,'其他','c',3042),(3131,'其他','d',3130),(3132,'陕西','p',NULL),(3133,'西安','c',3132),(3134,'莲湖区','d',3133),(3135,'新城区','d',3133),(3136,'碑林区','d',3133),(3137,'雁塔区','d',3133),(3138,'灞桥区','d',3133),(3139,'未央区','d',3133),(3140,'阎良区','d',3133),(3141,'临潼区','d',3133),(3142,'长安区','d',3133),(3143,'高陵县','d',3133),(3144,'蓝田县','d',3133),(3145,'户县','d',3133),(3146,'周至县','d',3133),(3147,'其他','d',3133),(3148,'铜川','c',3132),(3149,'耀州区','d',3148),(3150,'王益区','d',3148),(3151,'印台区','d',3148),(3152,'宜君县','d',3148),(3153,'其他','d',3148),(3154,'宝鸡','c',3132),(3155,'渭滨区','d',3154),(3156,'金台区','d',3154),(3157,'陈仓区','d',3154),(3158,'岐山县','d',3154),(3159,'凤翔县','d',3154),(3160,'陇县','d',3154),(3161,'太白县','d',3154),(3162,'麟游县','d',3154),(3163,'扶风县','d',3154),(3164,'千阳县','d',3154),(3165,'眉县','d',3154),(3166,'凤县','d',3154),(3167,'其他','d',3154),(3168,'咸阳','c',3132),(3169,'秦都区','d',3168),(3170,'渭城区','d',3168),(3171,'杨陵区','d',3168),(3172,'兴平市','d',3168),(3173,'礼泉县','d',3168),(3174,'泾阳县','d',3168),(3175,'永寿县','d',3168),(3176,'三原县','d',3168),(3177,'彬县','d',3168),(3178,'旬邑县','d',3168),(3179,'长武县','d',3168),(3180,'乾县','d',3168),(3181,'武功县','d',3168),(3182,'淳化县','d',3168),(3183,'其他','d',3168),(3184,'渭南','c',3132),(3185,'临渭区','d',3184),(3186,'韩城市','d',3184),(3187,'华阴市','d',3184),(3188,'蒲城县','d',3184),(3189,'潼关县','d',3184),(3190,'白水县','d',3184),(3191,'澄城县','d',3184),(3192,'华县','d',3184),(3193,'合阳县','d',3184),(3194,'富平县','d',3184),(3195,'大荔县','d',3184),(3196,'其他','d',3184),(3197,'延安','c',3132),(3198,'宝塔区','d',3197),(3199,'安塞县','d',3197),(3200,'洛川县','d',3197),(3201,'子长县','d',3197),(3202,'黄陵县','d',3197),(3203,'延川县','d',3197),(3204,'富县','d',3197),(3205,'延长县','d',3197),(3206,'甘泉县','d',3197),(3207,'宜川县','d',3197),(3208,'志丹县','d',3197),(3209,'黄龙县','d',3197),(3210,'吴起县','d',3197),(3211,'其他','d',3197),(3212,'汉中','c',3132),(3213,'汉台区','d',3212),(3214,'留坝县','d',3212),(3215,'镇巴县','d',3212),(3216,'城固县','d',3212),(3217,'南郑县','d',3212),(3218,'洋县','d',3212),(3219,'宁强县','d',3212),(3220,'佛坪县','d',3212),(3221,'勉县','d',3212),(3222,'西乡县','d',3212),(3223,'略阳县','d',3212),(3224,'其他','d',3212),(3225,'榆林','c',3132),(3226,'榆阳区','d',3225),(3227,'清涧县','d',3225),(3228,'绥德县','d',3225),(3229,'神木县','d',3225),(3230,'佳县','d',3225),(3231,'府谷县','d',3225),(3232,'子洲县','d',3225),(3233,'靖边县','d',3225),(3234,'横山县','d',3225),(3235,'米脂县','d',3225),(3236,'吴堡县','d',3225),(3237,'定边县','d',3225),(3238,'其他','d',3225),(3239,'安康','c',3132),(3240,'汉滨区','d',3239),(3241,'紫阳县','d',3239),(3242,'岚皋县','d',3239),(3243,'旬阳县','d',3239),(3244,'镇坪县','d',3239),(3245,'平利县','d',3239),(3246,'石泉县','d',3239),(3247,'宁陕县','d',3239),(3248,'白河县','d',3239),(3249,'汉阴县','d',3239),(3250,'其他','d',3239),(3251,'商洛','c',3132),(3252,'商州区','d',3251),(3253,'镇安县','d',3251),(3254,'山阳县','d',3251),(3255,'洛南县','d',3251),(3256,'商南县','d',3251),(3257,'丹凤县','d',3251),(3258,'柞水县','d',3251),(3259,'其他','d',3251),(3260,'其他','c',3132),(3261,'其他','d',3260),(3262,'甘肃','p',NULL),(3263,'兰州','c',3262),(3264,'城关区','d',3263),(3265,'七里河区','d',3263),(3266,'西固区','d',3263),(3267,'安宁区','d',3263),(3268,'红古区','d',3263),(3269,'永登县','d',3263),(3270,'皋兰县','d',3263),(3271,'榆中县','d',3263),(3272,'其他','d',3263),(3273,'嘉峪关','c',3262),(3274,'嘉峪关市','d',3273),(3275,'其他','d',3273),(3276,'金昌','c',3262),(3277,'金川区','d',3276),(3278,'永昌县','d',3276),(3279,'其他','d',3276),(3280,'白银','c',3262),(3281,'白银区','d',3280),(3282,'平川区','d',3280),(3283,'靖远县','d',3280),(3284,'会宁县','d',3280),(3285,'景泰县','d',3280),(3286,'其他','d',3280),(3287,'天水','c',3262),(3288,'清水县','d',3287),(3289,'秦安县','d',3287),(3290,'甘谷县','d',3287),(3291,'武山县','d',3287),(3292,'张家川回族自治县','d',3287),(3293,'北道区','d',3287),(3294,'秦城区','d',3287),(3295,'其他','d',3287),(3296,'武威','c',3262),(3297,'凉州区','d',3296),(3298,'民勤县','d',3296),(3299,'古浪县','d',3296),(3300,'天祝藏族自治县','d',3296),(3301,'其他','d',3296),(3302,'酒泉','c',3262),(3303,'肃州区','d',3302),(3304,'玉门市','d',3302),(3305,'敦煌市','d',3302),(3306,'金塔县','d',3302),(3307,'肃北蒙古族自治县','d',3302),(3308,'阿克塞哈萨克族自治县','d',3302),(3309,'安西县','d',3302),(3310,'其他','d',3302),(3311,'张掖','c',3262),(3312,'甘州区','d',3311),(3313,'民乐县','d',3311),(3314,'临泽县','d',3311),(3315,'高台县','d',3311),(3316,'山丹县','d',3311),(3317,'肃南裕固族自治县','d',3311),(3318,'其他','d',3311),(3319,'庆阳','c',3262),(3320,'西峰区','d',3319),(3321,'庆城县','d',3319),(3322,'环县','d',3319),(3323,'华池县','d',3319),(3324,'合水县','d',3319),(3325,'正宁县','d',3319),(3326,'宁县','d',3319),(3327,'镇原县','d',3319),(3328,'其他','d',3319),(3329,'平凉','c',3262),(3330,'崆峒区','d',3329),(3331,'泾川县','d',3329),(3332,'灵台县','d',3329),(3333,'崇信县','d',3329),(3334,'华亭县','d',3329),(3335,'庄浪县','d',3329),(3336,'静宁县','d',3329),(3337,'其他','d',3329),(3338,'定西','c',3262),(3339,'安定区','d',3338),(3340,'通渭县','d',3338),(3341,'临洮县','d',3338),(3342,'漳县','d',3338),(3343,'岷县','d',3338),(3344,'渭源县','d',3338),(3345,'陇西县','d',3338),(3346,'其他','d',3338),(3347,'陇南','c',3262),(3348,'武都区','d',3347),(3349,'成县','d',3347),(3350,'宕昌县','d',3347),(3351,'康县','d',3347),(3352,'文县','d',3347),(3353,'西和县','d',3347),(3354,'礼县','d',3347),(3355,'两当县','d',3347),(3356,'徽县','d',3347),(3357,'其他','d',3347),(3358,'临夏回族自治州','c',3262),(3359,'临夏市','d',3358),(3360,'临夏县','d',3358),(3361,'康乐县','d',3358),(3362,'永靖县','d',3358),(3363,'广河县','d',3358),(3364,'和政县','d',3358),(3365,'东乡族自治县','d',3358),(3366,'积石山保安族东乡族撒拉族自治县','d',3358),(3367,'其他','d',3358),(3368,'甘南藏族自治州','c',3262),(3369,'合作市','d',3368),(3370,'临潭县','d',3368),(3371,'卓尼县','d',3368),(3372,'舟曲县','d',3368),(3373,'迭部县','d',3368),(3374,'玛曲县','d',3368),(3375,'碌曲县','d',3368),(3376,'夏河县','d',3368),(3377,'其他','d',3368),(3378,'其他','c',3262),(3379,'其他','d',3378),(3380,'青海','p',NULL),(3381,'西宁','c',3380),(3382,'城中区','d',3381),(3383,'城东区','d',3381),(3384,'城西区','d',3381),(3385,'城北区','d',3381),(3386,'湟源县','d',3381),(3387,'湟中县','d',3381),(3388,'大通回族土族自治县','d',3381),(3389,'其他','d',3381),(3390,'海东地区','c',3380),(3391,'平安县','d',3390),(3392,'乐都县','d',3390),(3393,'民和回族土族自治县','d',3390),(3394,'互助土族自治县','d',3390),(3395,'化隆回族自治县','d',3390),(3396,'循化撒拉族自治县','d',3390),(3397,'其他','d',3390),(3398,'海北藏族自治州','c',3380),(3399,'海晏县','d',3398),(3400,'祁连县','d',3398),(3401,'刚察县','d',3398),(3402,'门源回族自治县','d',3398),(3403,'其他','d',3398),(3404,'海南藏族自治州','c',3380),(3405,'共和县','d',3404),(3406,'同德县','d',3404),(3407,'贵德县','d',3404),(3408,'兴海县','d',3404),(3409,'贵南县','d',3404),(3410,'其他','d',3404),(3411,'黄南藏族自治州','c',3380),(3412,'同仁县','d',3411),(3413,'尖扎县','d',3411),(3414,'泽库县','d',3411),(3415,'河南蒙古族自治县','d',3411),(3416,'其他','d',3411),(3417,'果洛藏族自治州','c',3380),(3418,'玛沁县','d',3417),(3419,'班玛县','d',3417),(3420,'甘德县','d',3417),(3421,'达日县','d',3417),(3422,'久治县','d',3417),(3423,'玛多县','d',3417),(3424,'其他','d',3417),(3425,'玉树藏族自治州','c',3380),(3426,'玉树县','d',3425),(3427,'杂多县','d',3425),(3428,'称多县','d',3425),(3429,'治多县','d',3425),(3430,'囊谦县','d',3425),(3431,'曲麻莱县','d',3425),(3432,'其他','d',3425),(3433,'海西蒙古族藏族自治州','c',3380),(3434,'德令哈市','d',3433),(3435,'格尔木市','d',3433),(3436,'乌兰县','d',3433),(3437,'都兰县','d',3433),(3438,'天峻县','d',3433),(3439,'其他','d',3433),(3440,'其他','c',3380),(3441,'其他','d',3440),(3442,'宁夏','p',NULL),(3443,'银川','c',3442),(3444,'兴庆区','d',3443),(3445,'西夏区','d',3443),(3446,'金凤区','d',3443),(3447,'灵武市','d',3443),(3448,'永宁县','d',3443),(3449,'贺兰县','d',3443),(3450,'其他','d',3443),(3451,'石嘴山','c',3442),(3452,'大武口区','d',3451),(3453,'惠农区','d',3451),(3454,'平罗县','d',3451),(3455,'其他','d',3451),(3456,'吴忠','c',3442),(3457,'利通区','d',3456),(3458,'青铜峡市','d',3456),(3459,'盐池县','d',3456),(3460,'同心县','d',3456),(3461,'其他','d',3456),(3462,'固原','c',3442),(3463,'原州区','d',3462),(3464,'西吉县','d',3462),(3465,'隆德县','d',3462),(3466,'泾源县','d',3462),(3467,'彭阳县','d',3462),(3468,'其他','d',3462),(3469,'中卫','c',3442),(3470,'沙坡头区','d',3469),(3471,'中宁县','d',3469),(3472,'海原县','d',3469),(3473,'其他','d',3469),(3474,'其他','c',3442),(3475,'其他','d',3474),(3476,'新疆','p',NULL),(3477,'乌鲁木齐','c',3476),(3478,'天山区','d',3477),(3479,'沙依巴克区','d',3477),(3480,'新市区','d',3477),(3481,'水磨沟区','d',3477),(3482,'头屯河区','d',3477),(3483,'达坂城区','d',3477),(3484,'东山区','d',3477),(3485,'乌鲁木齐县','d',3477),(3486,'其他','d',3477),(3487,'克拉玛依','c',3476),(3488,'克拉玛依区','d',3487),(3489,'独山子区','d',3487),(3490,'白碱滩区','d',3487),(3491,'乌尔禾区','d',3487),(3492,'其他','d',3487),(3493,'吐鲁番地区','c',3476),(3494,'吐鲁番市','d',3493),(3495,'托克逊县','d',3493),(3496,'鄯善县','d',3493),(3497,'其他','d',3493),(3498,'哈密地区','c',3476),(3499,'哈密市','d',3498),(3500,'伊吾县','d',3498),(3501,'巴里坤哈萨克自治县','d',3498),(3502,'其他','d',3498),(3503,'和田地区','c',3476),(3504,'和田市','d',3503),(3505,'和田县','d',3503),(3506,'洛浦县','d',3503),(3507,'民丰县','d',3503),(3508,'皮山县','d',3503),(3509,'策勒县','d',3503),(3510,'于田县','d',3503),(3511,'墨玉县','d',3503),(3512,'其他','d',3503),(3513,'阿克苏地区','c',3476),(3514,'阿克苏市','d',3513),(3515,'温宿县','d',3513),(3516,'沙雅县','d',3513),(3517,'拜城县','d',3513),(3518,'阿瓦提县','d',3513),(3519,'库车县','d',3513),(3520,'柯坪县','d',3513),(3521,'新和县','d',3513),(3522,'乌什县','d',3513),(3523,'其他','d',3513),(3524,'喀什地区','c',3476),(3525,'喀什市','d',3524),(3526,'巴楚县','d',3524),(3527,'泽普县','d',3524),(3528,'伽师县','d',3524),(3529,'叶城县','d',3524),(3530,'岳普湖县','d',3524),(3531,'疏勒县','d',3524),(3532,'麦盖提县','d',3524),(3533,'英吉沙县','d',3524),(3534,'莎车县','d',3524),(3535,'疏附县','d',3524),(3536,'塔什库尔干塔吉克自治县','d',3524),(3537,'其他','d',3524),(3538,'克孜勒苏柯尔克孜自治州','c',3476),(3539,'阿图什市','d',3538),(3540,'阿合奇县','d',3538),(3541,'乌恰县','d',3538),(3542,'阿克陶县','d',3538),(3543,'其他','d',3538),(3544,'巴音郭楞蒙古自治州','c',3476),(3545,'库尔勒市','d',3544),(3546,'和静县','d',3544),(3547,'尉犁县','d',3544),(3548,'和硕县','d',3544),(3549,'且末县','d',3544),(3550,'博湖县','d',3544),(3551,'轮台县','d',3544),(3552,'若羌县','d',3544),(3553,'焉耆回族自治县','d',3544),(3554,'其他','d',3544),(3555,'昌吉回族自治州','c',3476),(3556,'昌吉市','d',3555),(3557,'阜康市','d',3555),(3558,'奇台县','d',3555),(3559,'玛纳斯县','d',3555),(3560,'吉木萨尔县','d',3555),(3561,'呼图壁县','d',3555),(3562,'木垒哈萨克自治县','d',3555),(3563,'米泉市','d',3555),(3564,'其他','d',3555),(3565,'博尔塔拉蒙古自治州','c',3476),(3566,'博乐市','d',3565),(3567,'精河县','d',3565),(3568,'温泉县','d',3565),(3569,'其他','d',3565),(3570,'石河子','c',3476),(3571,'石河子','d',3570),(3572,'阿拉尔','c',3476),(3573,'阿拉尔','d',3572),(3574,'图木舒克','c',3476),(3575,'图木舒克','d',3574),(3576,'五家渠','c',3476),(3577,'五家渠','d',3576),(3578,'伊犁哈萨克自治州','c',3476),(3579,'伊宁市','d',3578),(3580,'奎屯市','d',3578),(3581,'伊宁县','d',3578),(3582,'特克斯县','d',3578),(3583,'尼勒克县','d',3578),(3584,'昭苏县','d',3578),(3585,'新源县','d',3578),(3586,'霍城县','d',3578),(3587,'巩留县','d',3578),(3588,'察布查尔锡伯自治县','d',3578),(3589,'塔城地区','d',3578),(3590,'阿勒泰地区','d',3578),(3591,'其他','d',3578),(3592,'其他','c',3476),(3593,'其他','d',3592),(3594,'台湾','p',NULL),(3595,'台湾','c',3594),(3596,'台北市','d',3595),(3597,'高雄市','d',3595),(3598,'台北县','d',3595),(3599,'桃园县','d',3595),(3600,'新竹县','d',3595),(3601,'苗栗县','d',3595),(3602,'台中县','d',3595),(3603,'彰化县','d',3595),(3604,'南投县','d',3595),(3605,'云林县','d',3595),(3606,'嘉义县','d',3595),(3607,'台南县','d',3595),(3608,'高雄县','d',3595),(3609,'屏东县','d',3595),(3610,'宜兰县','d',3595),(3611,'花莲县','d',3595),(3612,'台东县','d',3595),(3613,'澎湖县','d',3595),(3614,'基隆市','d',3595),(3615,'新竹市','d',3595),(3616,'台中市','d',3595),(3617,'嘉义市','d',3595),(3618,'台南市','d',3595),(3619,'其他','d',3595),(3620,'其他','c',3594),(3621,'其他','d',3620),(3622,'澳门','p',NULL),(3623,'澳门','c',3622),(3624,'花地玛堂区','d',3623),(3625,'圣安多尼堂区','d',3623),(3626,'大堂区','d',3623),(3627,'望德堂区','d',3623),(3628,'风顺堂区','d',3623),(3629,'嘉模堂区','d',3623),(3630,'圣方济各堂区','d',3623),(3631,'路凼','d',3623),(3632,'其他','d',3623),(3633,'香港','p',NULL),(3634,'香港','c',3633),(3635,'中西区','d',3634),(3636,'湾仔区','d',3634),(3637,'东区','d',3634),(3638,'南区','d',3634),(3639,'深水埗区','d',3634),(3640,'油尖旺区','d',3634),(3641,'九龙城区','d',3634),(3642,'黄大仙区','d',3634),(3643,'观塘区','d',3634),(3644,'北区','d',3634),(3645,'大埔区','d',3634),(3646,'沙田区','d',3634),(3647,'西贡区','d',3634),(3648,'元朗区','d',3634),(3649,'屯门区','d',3634),(3650,'荃湾区','d',3634),(3651,'葵青区','d',3634),(3652,'离岛区','d',3634),(3653,'其他','d',3634),(3654,'钓鱼岛','p',NULL),(3655,'钓鱼岛','c',3654),(3656,'钓鱼岛','d',3655);
/*!40000 ALTER TABLE `t_pcd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pcd_qualify`
--

DROP TABLE IF EXISTS `t_pcd_qualify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pcd_qualify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pcd_id` int(11) NOT NULL,
  `turnover_quota` int(11) DEFAULT NULL,
  `cash_deposit` int(11) DEFAULT NULL,
  `allow_inferior` smallint(6) DEFAULT '1',
  `physical_settlement_percentage` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pcd_id` (`pcd_id`),
  CONSTRAINT `t_pcd_qualify_ibfk_1` FOREIGN KEY (`pcd_id`) REFERENCES `t_pcd` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4096 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pcd_qualify`
--

LOCK TABLES `t_pcd_qualify` WRITE;
/*!40000 ALTER TABLE `t_pcd_qualify` DISABLE KEYS */;
INSERT INTO `t_pcd_qualify` VALUES (1,1,NULL,NULL,1,NULL),(2,21,NULL,NULL,1,NULL),(3,41,NULL,NULL,1,NULL),(4,225,NULL,NULL,1,NULL),(5,356,NULL,NULL,1,NULL),(6,470,NULL,NULL,1,NULL),(7,601,NULL,NULL,1,NULL),(8,682,NULL,NULL,1,NULL),(9,840,NULL,NULL,1,NULL),(10,862,NULL,NULL,1,NULL),(11,997,NULL,NULL,1,NULL),(12,1112,NULL,NULL,1,NULL),(13,1254,NULL,NULL,1,NULL),(14,1360,NULL,NULL,1,NULL),(15,1484,NULL,NULL,1,NULL),(16,1661,NULL,NULL,1,NULL),(17,1859,NULL,NULL,1,NULL),(18,1994,NULL,NULL,1,NULL),(19,2147,NULL,NULL,1,NULL),(20,2316,NULL,NULL,1,NULL),(21,2456,NULL,NULL,1,NULL),(22,2500,NULL,NULL,1,NULL),(23,2543,NULL,NULL,1,NULL),(24,2769,NULL,NULL,1,NULL),(25,2878,NULL,NULL,1,NULL),(26,3042,NULL,NULL,1,NULL),(27,3132,NULL,NULL,1,NULL),(28,3262,NULL,NULL,1,NULL),(29,3380,NULL,NULL,1,NULL),(30,3442,NULL,NULL,1,NULL),(31,3476,NULL,NULL,1,NULL),(32,3594,NULL,NULL,1,NULL),(33,3622,NULL,NULL,1,NULL),(34,3633,NULL,NULL,1,NULL),(35,3654,NULL,NULL,1,NULL),(36,2,NULL,NULL,1,NULL),(37,3,NULL,NULL,1,NULL),(38,4,NULL,NULL,1,NULL),(39,5,NULL,NULL,1,NULL),(40,6,NULL,NULL,1,NULL),(41,7,NULL,NULL,1,NULL),(42,8,NULL,NULL,1,NULL),(43,9,NULL,NULL,1,NULL),(44,10,NULL,NULL,1,NULL),(45,11,NULL,NULL,1,NULL),(46,12,NULL,NULL,1,NULL),(47,13,NULL,NULL,1,NULL),(48,14,NULL,NULL,1,NULL),(49,15,NULL,NULL,1,NULL),(50,16,NULL,NULL,1,NULL),(51,17,NULL,NULL,1,NULL),(52,18,NULL,NULL,1,NULL),(53,19,NULL,NULL,1,NULL),(54,20,NULL,NULL,1,NULL),(55,22,NULL,NULL,1,NULL),(56,23,NULL,NULL,1,NULL),(57,24,NULL,NULL,1,NULL),(58,25,NULL,NULL,1,NULL),(59,26,NULL,NULL,1,NULL),(60,27,NULL,NULL,1,NULL),(61,28,NULL,NULL,1,NULL),(62,29,NULL,NULL,1,NULL),(63,30,NULL,NULL,1,NULL),(64,31,NULL,NULL,1,NULL),(65,32,NULL,NULL,1,NULL),(66,33,NULL,NULL,1,NULL),(67,34,NULL,NULL,1,NULL),(68,35,NULL,NULL,1,NULL),(69,36,NULL,NULL,1,NULL),(70,37,NULL,NULL,1,NULL),(71,38,NULL,NULL,1,NULL),(72,39,NULL,NULL,1,NULL),(73,40,NULL,NULL,1,NULL),(74,42,NULL,NULL,1,NULL),(75,66,NULL,NULL,1,NULL),(76,82,NULL,NULL,1,NULL),(77,90,NULL,NULL,1,NULL),(78,110,NULL,NULL,1,NULL),(79,130,NULL,NULL,1,NULL),(80,156,NULL,NULL,1,NULL),(81,174,NULL,NULL,1,NULL),(82,186,NULL,NULL,1,NULL),(83,203,NULL,NULL,1,NULL),(84,213,NULL,NULL,1,NULL),(85,43,NULL,NULL,1,NULL),(86,44,NULL,NULL,1,NULL),(87,45,NULL,NULL,1,NULL),(88,46,NULL,NULL,1,NULL),(89,47,NULL,NULL,1,NULL),(90,48,NULL,NULL,1,NULL),(91,49,NULL,NULL,1,NULL),(92,50,NULL,NULL,1,NULL),(93,51,NULL,NULL,1,NULL),(94,52,NULL,NULL,1,NULL),(95,53,NULL,NULL,1,NULL),(96,54,NULL,NULL,1,NULL),(97,55,NULL,NULL,1,NULL),(98,56,NULL,NULL,1,NULL),(99,57,NULL,NULL,1,NULL),(100,58,NULL,NULL,1,NULL),(101,59,NULL,NULL,1,NULL),(102,60,NULL,NULL,1,NULL),(103,61,NULL,NULL,1,NULL),(104,62,NULL,NULL,1,NULL),(105,63,NULL,NULL,1,NULL),(106,64,NULL,NULL,1,NULL),(107,65,NULL,NULL,1,NULL),(108,67,NULL,NULL,1,NULL),(109,68,NULL,NULL,1,NULL),(110,69,NULL,NULL,1,NULL),(111,70,NULL,NULL,1,NULL),(112,71,NULL,NULL,1,NULL),(113,72,NULL,NULL,1,NULL),(114,73,NULL,NULL,1,NULL),(115,74,NULL,NULL,1,NULL),(116,75,NULL,NULL,1,NULL),(117,76,NULL,NULL,1,NULL),(118,77,NULL,NULL,1,NULL),(119,78,NULL,NULL,1,NULL),(120,79,NULL,NULL,1,NULL),(121,80,NULL,NULL,1,NULL),(122,81,NULL,NULL,1,NULL),(123,83,NULL,NULL,1,NULL),(124,84,NULL,NULL,1,NULL),(125,85,NULL,NULL,1,NULL),(126,86,NULL,NULL,1,NULL),(127,87,NULL,NULL,1,NULL),(128,88,NULL,NULL,1,NULL),(129,89,NULL,NULL,1,NULL),(130,91,NULL,NULL,1,NULL),(131,92,NULL,NULL,1,NULL),(132,93,NULL,NULL,1,NULL),(133,94,NULL,NULL,1,NULL),(134,95,NULL,NULL,1,NULL),(135,96,NULL,NULL,1,NULL),(136,97,NULL,NULL,1,NULL),(137,98,NULL,NULL,1,NULL),(138,99,NULL,NULL,1,NULL),(139,100,NULL,NULL,1,NULL),(140,101,NULL,NULL,1,NULL),(141,102,NULL,NULL,1,NULL),(142,103,NULL,NULL,1,NULL),(143,104,NULL,NULL,1,NULL),(144,105,NULL,NULL,1,NULL),(145,106,NULL,NULL,1,NULL),(146,107,NULL,NULL,1,NULL),(147,108,NULL,NULL,1,NULL),(148,109,NULL,NULL,1,NULL),(149,111,NULL,NULL,1,NULL),(150,112,NULL,NULL,1,NULL),(151,113,NULL,NULL,1,NULL),(152,114,NULL,NULL,1,NULL),(153,115,NULL,NULL,1,NULL),(154,116,NULL,NULL,1,NULL),(155,117,NULL,NULL,1,NULL),(156,118,NULL,NULL,1,NULL),(157,119,NULL,NULL,1,NULL),(158,120,NULL,NULL,1,NULL),(159,121,NULL,NULL,1,NULL),(160,122,NULL,NULL,1,NULL),(161,123,NULL,NULL,1,NULL),(162,124,NULL,NULL,1,NULL),(163,125,NULL,NULL,1,NULL),(164,126,NULL,NULL,1,NULL),(165,127,NULL,NULL,1,NULL),(166,128,NULL,NULL,1,NULL),(167,129,NULL,NULL,1,NULL),(168,131,NULL,NULL,1,NULL),(169,132,NULL,NULL,1,NULL),(170,133,NULL,NULL,1,NULL),(171,134,NULL,NULL,1,NULL),(172,135,NULL,NULL,1,NULL),(173,136,NULL,NULL,1,NULL),(174,137,NULL,NULL,1,NULL),(175,138,NULL,NULL,1,NULL),(176,139,NULL,NULL,1,NULL),(177,140,NULL,NULL,1,NULL),(178,141,NULL,NULL,1,NULL),(179,142,NULL,NULL,1,NULL),(180,143,NULL,NULL,1,NULL),(181,144,NULL,NULL,1,NULL),(182,145,NULL,NULL,1,NULL),(183,146,NULL,NULL,1,NULL),(184,147,NULL,NULL,1,NULL),(185,148,NULL,NULL,1,NULL),(186,149,NULL,NULL,1,NULL),(187,150,NULL,NULL,1,NULL),(188,151,NULL,NULL,1,NULL),(189,152,NULL,NULL,1,NULL),(190,153,NULL,NULL,1,NULL),(191,154,NULL,NULL,1,NULL),(192,155,NULL,NULL,1,NULL),(193,157,NULL,NULL,1,NULL),(194,158,NULL,NULL,1,NULL),(195,159,NULL,NULL,1,NULL),(196,160,NULL,NULL,1,NULL),(197,161,NULL,NULL,1,NULL),(198,162,NULL,NULL,1,NULL),(199,163,NULL,NULL,1,NULL),(200,164,NULL,NULL,1,NULL),(201,165,NULL,NULL,1,NULL),(202,166,NULL,NULL,1,NULL),(203,167,NULL,NULL,1,NULL),(204,168,NULL,NULL,1,NULL),(205,169,NULL,NULL,1,NULL),(206,170,NULL,NULL,1,NULL),(207,171,NULL,NULL,1,NULL),(208,172,NULL,NULL,1,NULL),(209,173,NULL,NULL,1,NULL),(210,175,NULL,NULL,1,NULL),(211,176,NULL,NULL,1,NULL),(212,177,NULL,NULL,1,NULL),(213,178,NULL,NULL,1,NULL),(214,179,NULL,NULL,1,NULL),(215,180,NULL,NULL,1,NULL),(216,181,NULL,NULL,1,NULL),(217,182,NULL,NULL,1,NULL),(218,183,NULL,NULL,1,NULL),(219,184,NULL,NULL,1,NULL),(220,185,NULL,NULL,1,NULL),(221,187,NULL,NULL,1,NULL),(222,188,NULL,NULL,1,NULL),(223,189,NULL,NULL,1,NULL),(224,190,NULL,NULL,1,NULL),(225,191,NULL,NULL,1,NULL),(226,192,NULL,NULL,1,NULL),(227,193,NULL,NULL,1,NULL),(228,194,NULL,NULL,1,NULL),(229,195,NULL,NULL,1,NULL),(230,196,NULL,NULL,1,NULL),(231,197,NULL,NULL,1,NULL),(232,198,NULL,NULL,1,NULL),(233,199,NULL,NULL,1,NULL),(234,200,NULL,NULL,1,NULL),(235,201,NULL,NULL,1,NULL),(236,202,NULL,NULL,1,NULL),(237,204,NULL,NULL,1,NULL),(238,205,NULL,NULL,1,NULL),(239,206,NULL,NULL,1,NULL),(240,207,NULL,NULL,1,NULL),(241,208,NULL,NULL,1,NULL),(242,209,NULL,NULL,1,NULL),(243,210,NULL,NULL,1,NULL),(244,211,NULL,NULL,1,NULL),(245,212,NULL,NULL,1,NULL),(246,214,NULL,NULL,1,NULL),(247,215,NULL,NULL,1,NULL),(248,216,NULL,NULL,1,NULL),(249,217,NULL,NULL,1,NULL),(250,218,NULL,NULL,1,NULL),(251,219,NULL,NULL,1,NULL),(252,220,NULL,NULL,1,NULL),(253,221,NULL,NULL,1,NULL),(254,222,NULL,NULL,1,NULL),(255,223,NULL,NULL,1,NULL),(256,224,NULL,NULL,1,NULL),(257,226,NULL,NULL,1,NULL),(258,237,NULL,NULL,1,NULL),(259,249,NULL,NULL,1,NULL),(260,255,NULL,NULL,1,NULL),(261,269,NULL,NULL,1,NULL),(262,276,NULL,NULL,1,NULL),(263,283,NULL,NULL,1,NULL),(264,298,NULL,NULL,1,NULL),(265,312,NULL,NULL,1,NULL),(266,324,NULL,NULL,1,NULL),(267,342,NULL,NULL,1,NULL),(268,227,NULL,NULL,1,NULL),(269,228,NULL,NULL,1,NULL),(270,229,NULL,NULL,1,NULL),(271,230,NULL,NULL,1,NULL),(272,231,NULL,NULL,1,NULL),(273,232,NULL,NULL,1,NULL),(274,233,NULL,NULL,1,NULL),(275,234,NULL,NULL,1,NULL),(276,235,NULL,NULL,1,NULL),(277,236,NULL,NULL,1,NULL),(278,238,NULL,NULL,1,NULL),(279,239,NULL,NULL,1,NULL),(280,240,NULL,NULL,1,NULL),(281,241,NULL,NULL,1,NULL),(282,242,NULL,NULL,1,NULL),(283,243,NULL,NULL,1,NULL),(284,244,NULL,NULL,1,NULL),(285,245,NULL,NULL,1,NULL),(286,246,NULL,NULL,1,NULL),(287,247,NULL,NULL,1,NULL),(288,248,NULL,NULL,1,NULL),(289,250,NULL,NULL,1,NULL),(290,251,NULL,NULL,1,NULL),(291,252,NULL,NULL,1,NULL),(292,253,NULL,NULL,1,NULL),(293,254,NULL,NULL,1,NULL),(294,256,NULL,NULL,1,NULL),(295,257,NULL,NULL,1,NULL),(296,258,NULL,NULL,1,NULL),(297,259,NULL,NULL,1,NULL),(298,260,NULL,NULL,1,NULL),(299,261,NULL,NULL,1,NULL),(300,262,NULL,NULL,1,NULL),(301,263,NULL,NULL,1,NULL),(302,264,NULL,NULL,1,NULL),(303,265,NULL,NULL,1,NULL),(304,266,NULL,NULL,1,NULL),(305,267,NULL,NULL,1,NULL),(306,268,NULL,NULL,1,NULL),(307,270,NULL,NULL,1,NULL),(308,271,NULL,NULL,1,NULL),(309,272,NULL,NULL,1,NULL),(310,273,NULL,NULL,1,NULL),(311,274,NULL,NULL,1,NULL),(312,275,NULL,NULL,1,NULL),(313,277,NULL,NULL,1,NULL),(314,278,NULL,NULL,1,NULL),(315,279,NULL,NULL,1,NULL),(316,280,NULL,NULL,1,NULL),(317,281,NULL,NULL,1,NULL),(318,282,NULL,NULL,1,NULL),(319,284,NULL,NULL,1,NULL),(320,285,NULL,NULL,1,NULL),(321,286,NULL,NULL,1,NULL),(322,287,NULL,NULL,1,NULL),(323,288,NULL,NULL,1,NULL),(324,289,NULL,NULL,1,NULL),(325,290,NULL,NULL,1,NULL),(326,291,NULL,NULL,1,NULL),(327,292,NULL,NULL,1,NULL),(328,293,NULL,NULL,1,NULL),(329,294,NULL,NULL,1,NULL),(330,295,NULL,NULL,1,NULL),(331,296,NULL,NULL,1,NULL),(332,297,NULL,NULL,1,NULL),(333,299,NULL,NULL,1,NULL),(334,300,NULL,NULL,1,NULL),(335,301,NULL,NULL,1,NULL),(336,302,NULL,NULL,1,NULL),(337,303,NULL,NULL,1,NULL),(338,304,NULL,NULL,1,NULL),(339,305,NULL,NULL,1,NULL),(340,306,NULL,NULL,1,NULL),(341,307,NULL,NULL,1,NULL),(342,308,NULL,NULL,1,NULL),(343,309,NULL,NULL,1,NULL),(344,310,NULL,NULL,1,NULL),(345,311,NULL,NULL,1,NULL),(346,313,NULL,NULL,1,NULL),(347,314,NULL,NULL,1,NULL),(348,315,NULL,NULL,1,NULL),(349,316,NULL,NULL,1,NULL),(350,317,NULL,NULL,1,NULL),(351,318,NULL,NULL,1,NULL),(352,319,NULL,NULL,1,NULL),(353,320,NULL,NULL,1,NULL),(354,321,NULL,NULL,1,NULL),(355,322,NULL,NULL,1,NULL),(356,323,NULL,NULL,1,NULL),(357,325,NULL,NULL,1,NULL),(358,326,NULL,NULL,1,NULL),(359,327,NULL,NULL,1,NULL),(360,328,NULL,NULL,1,NULL),(361,329,NULL,NULL,1,NULL),(362,330,NULL,NULL,1,NULL),(363,331,NULL,NULL,1,NULL),(364,332,NULL,NULL,1,NULL),(365,333,NULL,NULL,1,NULL),(366,334,NULL,NULL,1,NULL),(367,335,NULL,NULL,1,NULL),(368,336,NULL,NULL,1,NULL),(369,337,NULL,NULL,1,NULL),(370,338,NULL,NULL,1,NULL),(371,339,NULL,NULL,1,NULL),(372,340,NULL,NULL,1,NULL),(373,341,NULL,NULL,1,NULL),(374,343,NULL,NULL,1,NULL),(375,344,NULL,NULL,1,NULL),(376,345,NULL,NULL,1,NULL),(377,346,NULL,NULL,1,NULL),(378,347,NULL,NULL,1,NULL),(379,348,NULL,NULL,1,NULL),(380,349,NULL,NULL,1,NULL),(381,350,NULL,NULL,1,NULL),(382,351,NULL,NULL,1,NULL),(383,352,NULL,NULL,1,NULL),(384,353,NULL,NULL,1,NULL),(385,354,NULL,NULL,1,NULL),(386,355,NULL,NULL,1,NULL),(387,357,NULL,NULL,1,NULL),(388,367,NULL,NULL,1,NULL),(389,377,NULL,NULL,1,NULL),(390,381,NULL,NULL,1,NULL),(391,394,NULL,NULL,1,NULL),(392,408,NULL,NULL,1,NULL),(393,415,NULL,NULL,1,NULL),(394,424,NULL,NULL,1,NULL),(395,437,NULL,NULL,1,NULL),(396,449,NULL,NULL,1,NULL),(397,458,NULL,NULL,1,NULL),(398,466,NULL,NULL,1,NULL),(399,358,NULL,NULL,1,NULL),(400,359,NULL,NULL,1,NULL),(401,360,NULL,NULL,1,NULL),(402,361,NULL,NULL,1,NULL),(403,362,NULL,NULL,1,NULL),(404,363,NULL,NULL,1,NULL),(405,364,NULL,NULL,1,NULL),(406,365,NULL,NULL,1,NULL),(407,366,NULL,NULL,1,NULL),(408,368,NULL,NULL,1,NULL),(409,369,NULL,NULL,1,NULL),(410,370,NULL,NULL,1,NULL),(411,371,NULL,NULL,1,NULL),(412,372,NULL,NULL,1,NULL),(413,373,NULL,NULL,1,NULL),(414,374,NULL,NULL,1,NULL),(415,375,NULL,NULL,1,NULL),(416,376,NULL,NULL,1,NULL),(417,378,NULL,NULL,1,NULL),(418,379,NULL,NULL,1,NULL),(419,380,NULL,NULL,1,NULL),(420,382,NULL,NULL,1,NULL),(421,383,NULL,NULL,1,NULL),(422,384,NULL,NULL,1,NULL),(423,385,NULL,NULL,1,NULL),(424,386,NULL,NULL,1,NULL),(425,387,NULL,NULL,1,NULL),(426,388,NULL,NULL,1,NULL),(427,389,NULL,NULL,1,NULL),(428,390,NULL,NULL,1,NULL),(429,391,NULL,NULL,1,NULL),(430,392,NULL,NULL,1,NULL),(431,393,NULL,NULL,1,NULL),(432,395,NULL,NULL,1,NULL),(433,396,NULL,NULL,1,NULL),(434,397,NULL,NULL,1,NULL),(435,398,NULL,NULL,1,NULL),(436,399,NULL,NULL,1,NULL),(437,400,NULL,NULL,1,NULL),(438,401,NULL,NULL,1,NULL),(439,402,NULL,NULL,1,NULL),(440,403,NULL,NULL,1,NULL),(441,404,NULL,NULL,1,NULL),(442,405,NULL,NULL,1,NULL),(443,406,NULL,NULL,1,NULL),(444,407,NULL,NULL,1,NULL),(445,409,NULL,NULL,1,NULL),(446,410,NULL,NULL,1,NULL),(447,411,NULL,NULL,1,NULL),(448,412,NULL,NULL,1,NULL),(449,413,NULL,NULL,1,NULL),(450,414,NULL,NULL,1,NULL),(451,416,NULL,NULL,1,NULL),(452,417,NULL,NULL,1,NULL),(453,418,NULL,NULL,1,NULL),(454,419,NULL,NULL,1,NULL),(455,420,NULL,NULL,1,NULL),(456,421,NULL,NULL,1,NULL),(457,422,NULL,NULL,1,NULL),(458,423,NULL,NULL,1,NULL),(459,425,NULL,NULL,1,NULL),(460,426,NULL,NULL,1,NULL),(461,427,NULL,NULL,1,NULL),(462,428,NULL,NULL,1,NULL),(463,429,NULL,NULL,1,NULL),(464,430,NULL,NULL,1,NULL),(465,431,NULL,NULL,1,NULL),(466,432,NULL,NULL,1,NULL),(467,433,NULL,NULL,1,NULL),(468,434,NULL,NULL,1,NULL),(469,435,NULL,NULL,1,NULL),(470,436,NULL,NULL,1,NULL),(471,438,NULL,NULL,1,NULL),(472,439,NULL,NULL,1,NULL),(473,440,NULL,NULL,1,NULL),(474,441,NULL,NULL,1,NULL),(475,442,NULL,NULL,1,NULL),(476,443,NULL,NULL,1,NULL),(477,444,NULL,NULL,1,NULL),(478,445,NULL,NULL,1,NULL),(479,446,NULL,NULL,1,NULL),(480,447,NULL,NULL,1,NULL),(481,448,NULL,NULL,1,NULL),(482,450,NULL,NULL,1,NULL),(483,451,NULL,NULL,1,NULL),(484,452,NULL,NULL,1,NULL),(485,453,NULL,NULL,1,NULL),(486,454,NULL,NULL,1,NULL),(487,455,NULL,NULL,1,NULL),(488,456,NULL,NULL,1,NULL),(489,457,NULL,NULL,1,NULL),(490,459,NULL,NULL,1,NULL),(491,460,NULL,NULL,1,NULL),(492,461,NULL,NULL,1,NULL),(493,462,NULL,NULL,1,NULL),(494,463,NULL,NULL,1,NULL),(495,464,NULL,NULL,1,NULL),(496,465,NULL,NULL,1,NULL),(497,467,NULL,NULL,1,NULL),(498,468,NULL,NULL,1,NULL),(499,469,NULL,NULL,1,NULL),(500,471,NULL,NULL,1,NULL),(501,486,NULL,NULL,1,NULL),(502,498,NULL,NULL,1,NULL),(503,507,NULL,NULL,1,NULL),(504,516,NULL,NULL,1,NULL),(505,524,NULL,NULL,1,NULL),(506,532,NULL,NULL,1,NULL),(507,541,NULL,NULL,1,NULL),(508,549,NULL,NULL,1,NULL),(509,558,NULL,NULL,1,NULL),(510,567,NULL,NULL,1,NULL),(511,573,NULL,NULL,1,NULL),(512,582,NULL,NULL,1,NULL),(513,591,NULL,NULL,1,NULL),(514,599,NULL,NULL,1,NULL),(515,472,NULL,NULL,1,NULL),(516,473,NULL,NULL,1,NULL),(517,474,NULL,NULL,1,NULL),(518,475,NULL,NULL,1,NULL),(519,476,NULL,NULL,1,NULL),(520,477,NULL,NULL,1,NULL),(521,478,NULL,NULL,1,NULL),(522,479,NULL,NULL,1,NULL),(523,480,NULL,NULL,1,NULL),(524,481,NULL,NULL,1,NULL),(525,482,NULL,NULL,1,NULL),(526,483,NULL,NULL,1,NULL),(527,484,NULL,NULL,1,NULL),(528,485,NULL,NULL,1,NULL),(529,487,NULL,NULL,1,NULL),(530,488,NULL,NULL,1,NULL),(531,489,NULL,NULL,1,NULL),(532,490,NULL,NULL,1,NULL),(533,491,NULL,NULL,1,NULL),(534,492,NULL,NULL,1,NULL),(535,493,NULL,NULL,1,NULL),(536,494,NULL,NULL,1,NULL),(537,495,NULL,NULL,1,NULL),(538,496,NULL,NULL,1,NULL),(539,497,NULL,NULL,1,NULL),(540,499,NULL,NULL,1,NULL),(541,500,NULL,NULL,1,NULL),(542,501,NULL,NULL,1,NULL),(543,502,NULL,NULL,1,NULL),(544,503,NULL,NULL,1,NULL),(545,504,NULL,NULL,1,NULL),(546,505,NULL,NULL,1,NULL),(547,506,NULL,NULL,1,NULL),(548,508,NULL,NULL,1,NULL),(549,509,NULL,NULL,1,NULL),(550,510,NULL,NULL,1,NULL),(551,511,NULL,NULL,1,NULL),(552,512,NULL,NULL,1,NULL),(553,513,NULL,NULL,1,NULL),(554,514,NULL,NULL,1,NULL),(555,515,NULL,NULL,1,NULL),(556,517,NULL,NULL,1,NULL),(557,518,NULL,NULL,1,NULL),(558,519,NULL,NULL,1,NULL),(559,520,NULL,NULL,1,NULL),(560,521,NULL,NULL,1,NULL),(561,522,NULL,NULL,1,NULL),(562,523,NULL,NULL,1,NULL),(563,525,NULL,NULL,1,NULL),(564,526,NULL,NULL,1,NULL),(565,527,NULL,NULL,1,NULL),(566,528,NULL,NULL,1,NULL),(567,529,NULL,NULL,1,NULL),(568,530,NULL,NULL,1,NULL),(569,531,NULL,NULL,1,NULL),(570,533,NULL,NULL,1,NULL),(571,534,NULL,NULL,1,NULL),(572,535,NULL,NULL,1,NULL),(573,536,NULL,NULL,1,NULL),(574,537,NULL,NULL,1,NULL),(575,538,NULL,NULL,1,NULL),(576,539,NULL,NULL,1,NULL),(577,540,NULL,NULL,1,NULL),(578,542,NULL,NULL,1,NULL),(579,543,NULL,NULL,1,NULL),(580,544,NULL,NULL,1,NULL),(581,545,NULL,NULL,1,NULL),(582,546,NULL,NULL,1,NULL),(583,547,NULL,NULL,1,NULL),(584,548,NULL,NULL,1,NULL),(585,550,NULL,NULL,1,NULL),(586,551,NULL,NULL,1,NULL),(587,552,NULL,NULL,1,NULL),(588,553,NULL,NULL,1,NULL),(589,554,NULL,NULL,1,NULL),(590,555,NULL,NULL,1,NULL),(591,556,NULL,NULL,1,NULL),(592,557,NULL,NULL,1,NULL),(593,559,NULL,NULL,1,NULL),(594,560,NULL,NULL,1,NULL),(595,561,NULL,NULL,1,NULL),(596,562,NULL,NULL,1,NULL),(597,563,NULL,NULL,1,NULL),(598,564,NULL,NULL,1,NULL),(599,565,NULL,NULL,1,NULL),(600,566,NULL,NULL,1,NULL),(601,568,NULL,NULL,1,NULL),(602,569,NULL,NULL,1,NULL),(603,570,NULL,NULL,1,NULL),(604,571,NULL,NULL,1,NULL),(605,572,NULL,NULL,1,NULL),(606,574,NULL,NULL,1,NULL),(607,575,NULL,NULL,1,NULL),(608,576,NULL,NULL,1,NULL),(609,577,NULL,NULL,1,NULL),(610,578,NULL,NULL,1,NULL),(611,579,NULL,NULL,1,NULL),(612,580,NULL,NULL,1,NULL),(613,581,NULL,NULL,1,NULL),(614,583,NULL,NULL,1,NULL),(615,584,NULL,NULL,1,NULL),(616,585,NULL,NULL,1,NULL),(617,586,NULL,NULL,1,NULL),(618,587,NULL,NULL,1,NULL),(619,588,NULL,NULL,1,NULL),(620,589,NULL,NULL,1,NULL),(621,590,NULL,NULL,1,NULL),(622,592,NULL,NULL,1,NULL),(623,593,NULL,NULL,1,NULL),(624,594,NULL,NULL,1,NULL),(625,595,NULL,NULL,1,NULL),(626,596,NULL,NULL,1,NULL),(627,597,NULL,NULL,1,NULL),(628,598,NULL,NULL,1,NULL),(629,600,NULL,NULL,1,NULL),(630,602,NULL,NULL,1,NULL),(631,614,NULL,NULL,1,NULL),(632,625,NULL,NULL,1,NULL),(633,633,NULL,NULL,1,NULL),(634,639,NULL,NULL,1,NULL),(635,648,NULL,NULL,1,NULL),(636,656,NULL,NULL,1,NULL),(637,663,NULL,NULL,1,NULL),(638,670,NULL,NULL,1,NULL),(639,680,NULL,NULL,1,NULL),(640,603,NULL,NULL,1,NULL),(641,604,NULL,NULL,1,NULL),(642,605,NULL,NULL,1,NULL),(643,606,NULL,NULL,1,NULL),(644,607,NULL,NULL,1,NULL),(645,608,NULL,NULL,1,NULL),(646,609,NULL,NULL,1,NULL),(647,610,NULL,NULL,1,NULL),(648,611,NULL,NULL,1,NULL),(649,612,NULL,NULL,1,NULL),(650,613,NULL,NULL,1,NULL),(651,615,NULL,NULL,1,NULL),(652,616,NULL,NULL,1,NULL),(653,617,NULL,NULL,1,NULL),(654,618,NULL,NULL,1,NULL),(655,619,NULL,NULL,1,NULL),(656,620,NULL,NULL,1,NULL),(657,621,NULL,NULL,1,NULL),(658,622,NULL,NULL,1,NULL),(659,623,NULL,NULL,1,NULL),(660,624,NULL,NULL,1,NULL),(661,626,NULL,NULL,1,NULL),(662,627,NULL,NULL,1,NULL),(663,628,NULL,NULL,1,NULL),(664,629,NULL,NULL,1,NULL),(665,630,NULL,NULL,1,NULL),(666,631,NULL,NULL,1,NULL),(667,632,NULL,NULL,1,NULL),(668,634,NULL,NULL,1,NULL),(669,635,NULL,NULL,1,NULL),(670,636,NULL,NULL,1,NULL),(671,637,NULL,NULL,1,NULL),(672,638,NULL,NULL,1,NULL),(673,640,NULL,NULL,1,NULL),(674,641,NULL,NULL,1,NULL),(675,642,NULL,NULL,1,NULL),(676,643,NULL,NULL,1,NULL),(677,644,NULL,NULL,1,NULL),(678,645,NULL,NULL,1,NULL),(679,646,NULL,NULL,1,NULL),(680,647,NULL,NULL,1,NULL),(681,649,NULL,NULL,1,NULL),(682,650,NULL,NULL,1,NULL),(683,651,NULL,NULL,1,NULL),(684,652,NULL,NULL,1,NULL),(685,653,NULL,NULL,1,NULL),(686,654,NULL,NULL,1,NULL),(687,655,NULL,NULL,1,NULL),(688,657,NULL,NULL,1,NULL),(689,658,NULL,NULL,1,NULL),(690,659,NULL,NULL,1,NULL),(691,660,NULL,NULL,1,NULL),(692,661,NULL,NULL,1,NULL),(693,662,NULL,NULL,1,NULL),(694,664,NULL,NULL,1,NULL),(695,665,NULL,NULL,1,NULL),(696,666,NULL,NULL,1,NULL),(697,667,NULL,NULL,1,NULL),(698,668,NULL,NULL,1,NULL),(699,669,NULL,NULL,1,NULL),(700,671,NULL,NULL,1,NULL),(701,672,NULL,NULL,1,NULL),(702,673,NULL,NULL,1,NULL),(703,674,NULL,NULL,1,NULL),(704,675,NULL,NULL,1,NULL),(705,676,NULL,NULL,1,NULL),(706,677,NULL,NULL,1,NULL),(707,678,NULL,NULL,1,NULL),(708,679,NULL,NULL,1,NULL),(709,681,NULL,NULL,1,NULL),(710,683,NULL,NULL,1,NULL),(711,703,NULL,NULL,1,NULL),(712,721,NULL,NULL,1,NULL),(713,731,NULL,NULL,1,NULL),(714,741,NULL,NULL,1,NULL),(715,752,NULL,NULL,1,NULL),(716,763,NULL,NULL,1,NULL),(717,782,NULL,NULL,1,NULL),(718,794,NULL,NULL,1,NULL),(719,806,NULL,NULL,1,NULL),(720,812,NULL,NULL,1,NULL),(721,820,NULL,NULL,1,NULL),(722,832,NULL,NULL,1,NULL),(723,838,NULL,NULL,1,NULL),(724,684,NULL,NULL,1,NULL),(725,685,NULL,NULL,1,NULL),(726,686,NULL,NULL,1,NULL),(727,687,NULL,NULL,1,NULL),(728,688,NULL,NULL,1,NULL),(729,689,NULL,NULL,1,NULL),(730,690,NULL,NULL,1,NULL),(731,691,NULL,NULL,1,NULL),(732,692,NULL,NULL,1,NULL),(733,693,NULL,NULL,1,NULL),(734,694,NULL,NULL,1,NULL),(735,695,NULL,NULL,1,NULL),(736,696,NULL,NULL,1,NULL),(737,697,NULL,NULL,1,NULL),(738,698,NULL,NULL,1,NULL),(739,699,NULL,NULL,1,NULL),(740,700,NULL,NULL,1,NULL),(741,701,NULL,NULL,1,NULL),(742,702,NULL,NULL,1,NULL),(743,704,NULL,NULL,1,NULL),(744,705,NULL,NULL,1,NULL),(745,706,NULL,NULL,1,NULL),(746,707,NULL,NULL,1,NULL),(747,708,NULL,NULL,1,NULL),(748,709,NULL,NULL,1,NULL),(749,710,NULL,NULL,1,NULL),(750,711,NULL,NULL,1,NULL),(751,712,NULL,NULL,1,NULL),(752,713,NULL,NULL,1,NULL),(753,714,NULL,NULL,1,NULL),(754,715,NULL,NULL,1,NULL),(755,716,NULL,NULL,1,NULL),(756,717,NULL,NULL,1,NULL),(757,718,NULL,NULL,1,NULL),(758,719,NULL,NULL,1,NULL),(759,720,NULL,NULL,1,NULL),(760,722,NULL,NULL,1,NULL),(761,723,NULL,NULL,1,NULL),(762,724,NULL,NULL,1,NULL),(763,725,NULL,NULL,1,NULL),(764,726,NULL,NULL,1,NULL),(765,727,NULL,NULL,1,NULL),(766,728,NULL,NULL,1,NULL),(767,729,NULL,NULL,1,NULL),(768,730,NULL,NULL,1,NULL),(769,732,NULL,NULL,1,NULL),(770,733,NULL,NULL,1,NULL),(771,734,NULL,NULL,1,NULL),(772,735,NULL,NULL,1,NULL),(773,736,NULL,NULL,1,NULL),(774,737,NULL,NULL,1,NULL),(775,738,NULL,NULL,1,NULL),(776,739,NULL,NULL,1,NULL),(777,740,NULL,NULL,1,NULL),(778,742,NULL,NULL,1,NULL),(779,743,NULL,NULL,1,NULL),(780,744,NULL,NULL,1,NULL),(781,745,NULL,NULL,1,NULL),(782,746,NULL,NULL,1,NULL),(783,747,NULL,NULL,1,NULL),(784,748,NULL,NULL,1,NULL),(785,749,NULL,NULL,1,NULL),(786,750,NULL,NULL,1,NULL),(787,751,NULL,NULL,1,NULL),(788,753,NULL,NULL,1,NULL),(789,754,NULL,NULL,1,NULL),(790,755,NULL,NULL,1,NULL),(791,756,NULL,NULL,1,NULL),(792,757,NULL,NULL,1,NULL),(793,758,NULL,NULL,1,NULL),(794,759,NULL,NULL,1,NULL),(795,760,NULL,NULL,1,NULL),(796,761,NULL,NULL,1,NULL),(797,762,NULL,NULL,1,NULL),(798,764,NULL,NULL,1,NULL),(799,765,NULL,NULL,1,NULL),(800,766,NULL,NULL,1,NULL),(801,767,NULL,NULL,1,NULL),(802,768,NULL,NULL,1,NULL),(803,769,NULL,NULL,1,NULL),(804,770,NULL,NULL,1,NULL),(805,771,NULL,NULL,1,NULL),(806,772,NULL,NULL,1,NULL),(807,773,NULL,NULL,1,NULL),(808,774,NULL,NULL,1,NULL),(809,775,NULL,NULL,1,NULL),(810,776,NULL,NULL,1,NULL),(811,777,NULL,NULL,1,NULL),(812,778,NULL,NULL,1,NULL),(813,779,NULL,NULL,1,NULL),(814,780,NULL,NULL,1,NULL),(815,781,NULL,NULL,1,NULL),(816,783,NULL,NULL,1,NULL),(817,784,NULL,NULL,1,NULL),(818,785,NULL,NULL,1,NULL),(819,786,NULL,NULL,1,NULL),(820,787,NULL,NULL,1,NULL),(821,788,NULL,NULL,1,NULL),(822,789,NULL,NULL,1,NULL),(823,790,NULL,NULL,1,NULL),(824,791,NULL,NULL,1,NULL),(825,792,NULL,NULL,1,NULL),(826,793,NULL,NULL,1,NULL),(827,795,NULL,NULL,1,NULL),(828,796,NULL,NULL,1,NULL),(829,797,NULL,NULL,1,NULL),(830,798,NULL,NULL,1,NULL),(831,799,NULL,NULL,1,NULL),(832,800,NULL,NULL,1,NULL),(833,801,NULL,NULL,1,NULL),(834,802,NULL,NULL,1,NULL),(835,803,NULL,NULL,1,NULL),(836,804,NULL,NULL,1,NULL),(837,805,NULL,NULL,1,NULL),(838,807,NULL,NULL,1,NULL),(839,808,NULL,NULL,1,NULL),(840,809,NULL,NULL,1,NULL),(841,810,NULL,NULL,1,NULL),(842,811,NULL,NULL,1,NULL),(843,813,NULL,NULL,1,NULL),(844,814,NULL,NULL,1,NULL),(845,815,NULL,NULL,1,NULL),(846,816,NULL,NULL,1,NULL),(847,817,NULL,NULL,1,NULL),(848,818,NULL,NULL,1,NULL),(849,819,NULL,NULL,1,NULL),(850,821,NULL,NULL,1,NULL),(851,822,NULL,NULL,1,NULL),(852,823,NULL,NULL,1,NULL),(853,824,NULL,NULL,1,NULL),(854,825,NULL,NULL,1,NULL),(855,826,NULL,NULL,1,NULL),(856,827,NULL,NULL,1,NULL),(857,828,NULL,NULL,1,NULL),(858,829,NULL,NULL,1,NULL),(859,830,NULL,NULL,1,NULL),(860,831,NULL,NULL,1,NULL),(861,833,NULL,NULL,1,NULL),(862,834,NULL,NULL,1,NULL),(863,835,NULL,NULL,1,NULL),(864,836,NULL,NULL,1,NULL),(865,837,NULL,NULL,1,NULL),(866,839,NULL,NULL,1,NULL),(867,841,NULL,NULL,1,NULL),(868,842,NULL,NULL,1,NULL),(869,843,NULL,NULL,1,NULL),(870,844,NULL,NULL,1,NULL),(871,845,NULL,NULL,1,NULL),(872,846,NULL,NULL,1,NULL),(873,847,NULL,NULL,1,NULL),(874,848,NULL,NULL,1,NULL),(875,849,NULL,NULL,1,NULL),(876,850,NULL,NULL,1,NULL),(877,851,NULL,NULL,1,NULL),(878,852,NULL,NULL,1,NULL),(879,853,NULL,NULL,1,NULL),(880,854,NULL,NULL,1,NULL),(881,855,NULL,NULL,1,NULL),(882,856,NULL,NULL,1,NULL),(883,857,NULL,NULL,1,NULL),(884,858,NULL,NULL,1,NULL),(885,859,NULL,NULL,1,NULL),(886,860,NULL,NULL,1,NULL),(887,861,NULL,NULL,1,NULL),(888,863,NULL,NULL,1,NULL),(889,878,NULL,NULL,1,NULL),(890,891,NULL,NULL,1,NULL),(891,901,NULL,NULL,1,NULL),(892,910,NULL,NULL,1,NULL),(893,918,NULL,NULL,1,NULL),(894,928,NULL,NULL,1,NULL),(895,936,NULL,NULL,1,NULL),(896,945,NULL,NULL,1,NULL),(897,956,NULL,NULL,1,NULL),(898,965,NULL,NULL,1,NULL),(899,978,NULL,NULL,1,NULL),(900,988,NULL,NULL,1,NULL),(901,995,NULL,NULL,1,NULL),(902,864,NULL,NULL,1,NULL),(903,865,NULL,NULL,1,NULL),(904,866,NULL,NULL,1,NULL),(905,867,NULL,NULL,1,NULL),(906,868,NULL,NULL,1,NULL),(907,869,NULL,NULL,1,NULL),(908,870,NULL,NULL,1,NULL),(909,871,NULL,NULL,1,NULL),(910,872,NULL,NULL,1,NULL),(911,873,NULL,NULL,1,NULL),(912,874,NULL,NULL,1,NULL),(913,875,NULL,NULL,1,NULL),(914,876,NULL,NULL,1,NULL),(915,877,NULL,NULL,1,NULL),(916,879,NULL,NULL,1,NULL),(917,880,NULL,NULL,1,NULL),(918,881,NULL,NULL,1,NULL),(919,882,NULL,NULL,1,NULL),(920,883,NULL,NULL,1,NULL),(921,884,NULL,NULL,1,NULL),(922,885,NULL,NULL,1,NULL),(923,886,NULL,NULL,1,NULL),(924,887,NULL,NULL,1,NULL),(925,888,NULL,NULL,1,NULL),(926,889,NULL,NULL,1,NULL),(927,890,NULL,NULL,1,NULL),(928,892,NULL,NULL,1,NULL),(929,893,NULL,NULL,1,NULL),(930,894,NULL,NULL,1,NULL),(931,895,NULL,NULL,1,NULL),(932,896,NULL,NULL,1,NULL),(933,897,NULL,NULL,1,NULL),(934,898,NULL,NULL,1,NULL),(935,899,NULL,NULL,1,NULL),(936,900,NULL,NULL,1,NULL),(937,902,NULL,NULL,1,NULL),(938,903,NULL,NULL,1,NULL),(939,904,NULL,NULL,1,NULL),(940,905,NULL,NULL,1,NULL),(941,906,NULL,NULL,1,NULL),(942,907,NULL,NULL,1,NULL),(943,908,NULL,NULL,1,NULL),(944,909,NULL,NULL,1,NULL),(945,911,NULL,NULL,1,NULL),(946,912,NULL,NULL,1,NULL),(947,913,NULL,NULL,1,NULL),(948,914,NULL,NULL,1,NULL),(949,915,NULL,NULL,1,NULL),(950,916,NULL,NULL,1,NULL),(951,917,NULL,NULL,1,NULL),(952,919,NULL,NULL,1,NULL),(953,920,NULL,NULL,1,NULL),(954,921,NULL,NULL,1,NULL),(955,922,NULL,NULL,1,NULL),(956,923,NULL,NULL,1,NULL),(957,924,NULL,NULL,1,NULL),(958,925,NULL,NULL,1,NULL),(959,926,NULL,NULL,1,NULL),(960,927,NULL,NULL,1,NULL),(961,929,NULL,NULL,1,NULL),(962,930,NULL,NULL,1,NULL),(963,931,NULL,NULL,1,NULL),(964,932,NULL,NULL,1,NULL),(965,933,NULL,NULL,1,NULL),(966,934,NULL,NULL,1,NULL),(967,935,NULL,NULL,1,NULL),(968,937,NULL,NULL,1,NULL),(969,938,NULL,NULL,1,NULL),(970,939,NULL,NULL,1,NULL),(971,940,NULL,NULL,1,NULL),(972,941,NULL,NULL,1,NULL),(973,942,NULL,NULL,1,NULL),(974,943,NULL,NULL,1,NULL),(975,944,NULL,NULL,1,NULL),(976,946,NULL,NULL,1,NULL),(977,947,NULL,NULL,1,NULL),(978,948,NULL,NULL,1,NULL),(979,949,NULL,NULL,1,NULL),(980,950,NULL,NULL,1,NULL),(981,951,NULL,NULL,1,NULL),(982,952,NULL,NULL,1,NULL),(983,953,NULL,NULL,1,NULL),(984,954,NULL,NULL,1,NULL),(985,955,NULL,NULL,1,NULL),(986,957,NULL,NULL,1,NULL),(987,958,NULL,NULL,1,NULL),(988,959,NULL,NULL,1,NULL),(989,960,NULL,NULL,1,NULL),(990,961,NULL,NULL,1,NULL),(991,962,NULL,NULL,1,NULL),(992,963,NULL,NULL,1,NULL),(993,964,NULL,NULL,1,NULL),(994,966,NULL,NULL,1,NULL),(995,967,NULL,NULL,1,NULL),(996,968,NULL,NULL,1,NULL),(997,969,NULL,NULL,1,NULL),(998,970,NULL,NULL,1,NULL),(999,971,NULL,NULL,1,NULL),(1000,972,NULL,NULL,1,NULL),(1001,973,NULL,NULL,1,NULL),(1002,974,NULL,NULL,1,NULL),(1003,975,NULL,NULL,1,NULL),(1004,976,NULL,NULL,1,NULL),(1005,977,NULL,NULL,1,NULL),(1006,979,NULL,NULL,1,NULL),(1007,980,NULL,NULL,1,NULL),(1008,981,NULL,NULL,1,NULL),(1009,982,NULL,NULL,1,NULL),(1010,983,NULL,NULL,1,NULL),(1011,984,NULL,NULL,1,NULL),(1012,985,NULL,NULL,1,NULL),(1013,986,NULL,NULL,1,NULL),(1014,987,NULL,NULL,1,NULL),(1015,989,NULL,NULL,1,NULL),(1016,990,NULL,NULL,1,NULL),(1017,991,NULL,NULL,1,NULL),(1018,992,NULL,NULL,1,NULL),(1019,993,NULL,NULL,1,NULL),(1020,994,NULL,NULL,1,NULL),(1021,996,NULL,NULL,1,NULL),(1022,998,NULL,NULL,1,NULL),(1023,1013,NULL,NULL,1,NULL),(1024,1026,NULL,NULL,1,NULL),(1025,1039,NULL,NULL,1,NULL),(1026,1048,NULL,NULL,1,NULL),(1027,1055,NULL,NULL,1,NULL),(1028,1063,NULL,NULL,1,NULL),(1029,1074,NULL,NULL,1,NULL),(1030,1082,NULL,NULL,1,NULL),(1031,1088,NULL,NULL,1,NULL),(1032,1099,NULL,NULL,1,NULL),(1033,1110,NULL,NULL,1,NULL),(1034,999,NULL,NULL,1,NULL),(1035,1000,NULL,NULL,1,NULL),(1036,1001,NULL,NULL,1,NULL),(1037,1002,NULL,NULL,1,NULL),(1038,1003,NULL,NULL,1,NULL),(1039,1004,NULL,NULL,1,NULL),(1040,1005,NULL,NULL,1,NULL),(1041,1006,NULL,NULL,1,NULL),(1042,1007,NULL,NULL,1,NULL),(1043,1008,NULL,NULL,1,NULL),(1044,1009,NULL,NULL,1,NULL),(1045,1010,NULL,NULL,1,NULL),(1046,1011,NULL,NULL,1,NULL),(1047,1012,NULL,NULL,1,NULL),(1048,1014,NULL,NULL,1,NULL),(1049,1015,NULL,NULL,1,NULL),(1050,1016,NULL,NULL,1,NULL),(1051,1017,NULL,NULL,1,NULL),(1052,1018,NULL,NULL,1,NULL),(1053,1019,NULL,NULL,1,NULL),(1054,1020,NULL,NULL,1,NULL),(1055,1021,NULL,NULL,1,NULL),(1056,1022,NULL,NULL,1,NULL),(1057,1023,NULL,NULL,1,NULL),(1058,1024,NULL,NULL,1,NULL),(1059,1025,NULL,NULL,1,NULL),(1060,1027,NULL,NULL,1,NULL),(1061,1028,NULL,NULL,1,NULL),(1062,1029,NULL,NULL,1,NULL),(1063,1030,NULL,NULL,1,NULL),(1064,1031,NULL,NULL,1,NULL),(1065,1032,NULL,NULL,1,NULL),(1066,1033,NULL,NULL,1,NULL),(1067,1034,NULL,NULL,1,NULL),(1068,1035,NULL,NULL,1,NULL),(1069,1036,NULL,NULL,1,NULL),(1070,1037,NULL,NULL,1,NULL),(1071,1038,NULL,NULL,1,NULL),(1072,1040,NULL,NULL,1,NULL),(1073,1041,NULL,NULL,1,NULL),(1074,1042,NULL,NULL,1,NULL),(1075,1043,NULL,NULL,1,NULL),(1076,1044,NULL,NULL,1,NULL),(1077,1045,NULL,NULL,1,NULL),(1078,1046,NULL,NULL,1,NULL),(1079,1047,NULL,NULL,1,NULL),(1080,1049,NULL,NULL,1,NULL),(1081,1050,NULL,NULL,1,NULL),(1082,1051,NULL,NULL,1,NULL),(1083,1052,NULL,NULL,1,NULL),(1084,1053,NULL,NULL,1,NULL),(1085,1054,NULL,NULL,1,NULL),(1086,1056,NULL,NULL,1,NULL),(1087,1057,NULL,NULL,1,NULL),(1088,1058,NULL,NULL,1,NULL),(1089,1059,NULL,NULL,1,NULL),(1090,1060,NULL,NULL,1,NULL),(1091,1061,NULL,NULL,1,NULL),(1092,1062,NULL,NULL,1,NULL),(1093,1064,NULL,NULL,1,NULL),(1094,1065,NULL,NULL,1,NULL),(1095,1066,NULL,NULL,1,NULL),(1096,1067,NULL,NULL,1,NULL),(1097,1068,NULL,NULL,1,NULL),(1098,1069,NULL,NULL,1,NULL),(1099,1070,NULL,NULL,1,NULL),(1100,1071,NULL,NULL,1,NULL),(1101,1072,NULL,NULL,1,NULL),(1102,1073,NULL,NULL,1,NULL),(1103,1075,NULL,NULL,1,NULL),(1104,1076,NULL,NULL,1,NULL),(1105,1077,NULL,NULL,1,NULL),(1106,1078,NULL,NULL,1,NULL),(1107,1079,NULL,NULL,1,NULL),(1108,1080,NULL,NULL,1,NULL),(1109,1081,NULL,NULL,1,NULL),(1110,1083,NULL,NULL,1,NULL),(1111,1084,NULL,NULL,1,NULL),(1112,1085,NULL,NULL,1,NULL),(1113,1086,NULL,NULL,1,NULL),(1114,1087,NULL,NULL,1,NULL),(1115,1089,NULL,NULL,1,NULL),(1116,1090,NULL,NULL,1,NULL),(1117,1091,NULL,NULL,1,NULL),(1118,1092,NULL,NULL,1,NULL),(1119,1093,NULL,NULL,1,NULL),(1120,1094,NULL,NULL,1,NULL),(1121,1095,NULL,NULL,1,NULL),(1122,1096,NULL,NULL,1,NULL),(1123,1097,NULL,NULL,1,NULL),(1124,1098,NULL,NULL,1,NULL),(1125,1100,NULL,NULL,1,NULL),(1126,1101,NULL,NULL,1,NULL),(1127,1102,NULL,NULL,1,NULL),(1128,1103,NULL,NULL,1,NULL),(1129,1104,NULL,NULL,1,NULL),(1130,1105,NULL,NULL,1,NULL),(1131,1106,NULL,NULL,1,NULL),(1132,1107,NULL,NULL,1,NULL),(1133,1108,NULL,NULL,1,NULL),(1134,1109,NULL,NULL,1,NULL),(1135,1111,NULL,NULL,1,NULL),(1136,1113,NULL,NULL,1,NULL),(1137,1122,NULL,NULL,1,NULL),(1138,1131,NULL,NULL,1,NULL),(1139,1140,NULL,NULL,1,NULL),(1140,1148,NULL,NULL,1,NULL),(1141,1154,NULL,NULL,1,NULL),(1142,1160,NULL,NULL,1,NULL),(1143,1166,NULL,NULL,1,NULL),(1144,1179,NULL,NULL,1,NULL),(1145,1188,NULL,NULL,1,NULL),(1146,1198,NULL,NULL,1,NULL),(1147,1208,NULL,NULL,1,NULL),(1148,1215,NULL,NULL,1,NULL),(1149,1222,NULL,NULL,1,NULL),(1150,1231,NULL,NULL,1,NULL),(1151,1237,NULL,NULL,1,NULL),(1152,1243,NULL,NULL,1,NULL),(1153,1252,NULL,NULL,1,NULL),(1154,1114,NULL,NULL,1,NULL),(1155,1115,NULL,NULL,1,NULL),(1156,1116,NULL,NULL,1,NULL),(1157,1117,NULL,NULL,1,NULL),(1158,1118,NULL,NULL,1,NULL),(1159,1119,NULL,NULL,1,NULL),(1160,1120,NULL,NULL,1,NULL),(1161,1121,NULL,NULL,1,NULL),(1162,1123,NULL,NULL,1,NULL),(1163,1124,NULL,NULL,1,NULL),(1164,1125,NULL,NULL,1,NULL),(1165,1126,NULL,NULL,1,NULL),(1166,1127,NULL,NULL,1,NULL),(1167,1128,NULL,NULL,1,NULL),(1168,1129,NULL,NULL,1,NULL),(1169,1130,NULL,NULL,1,NULL),(1170,1132,NULL,NULL,1,NULL),(1171,1133,NULL,NULL,1,NULL),(1172,1134,NULL,NULL,1,NULL),(1173,1135,NULL,NULL,1,NULL),(1174,1136,NULL,NULL,1,NULL),(1175,1137,NULL,NULL,1,NULL),(1176,1138,NULL,NULL,1,NULL),(1177,1139,NULL,NULL,1,NULL),(1178,1141,NULL,NULL,1,NULL),(1179,1142,NULL,NULL,1,NULL),(1180,1143,NULL,NULL,1,NULL),(1181,1144,NULL,NULL,1,NULL),(1182,1145,NULL,NULL,1,NULL),(1183,1146,NULL,NULL,1,NULL),(1184,1147,NULL,NULL,1,NULL),(1185,1149,NULL,NULL,1,NULL),(1186,1150,NULL,NULL,1,NULL),(1187,1151,NULL,NULL,1,NULL),(1188,1152,NULL,NULL,1,NULL),(1189,1153,NULL,NULL,1,NULL),(1190,1155,NULL,NULL,1,NULL),(1191,1156,NULL,NULL,1,NULL),(1192,1157,NULL,NULL,1,NULL),(1193,1158,NULL,NULL,1,NULL),(1194,1159,NULL,NULL,1,NULL),(1195,1161,NULL,NULL,1,NULL),(1196,1162,NULL,NULL,1,NULL),(1197,1163,NULL,NULL,1,NULL),(1198,1164,NULL,NULL,1,NULL),(1199,1165,NULL,NULL,1,NULL),(1200,1167,NULL,NULL,1,NULL),(1201,1168,NULL,NULL,1,NULL),(1202,1169,NULL,NULL,1,NULL),(1203,1170,NULL,NULL,1,NULL),(1204,1171,NULL,NULL,1,NULL),(1205,1172,NULL,NULL,1,NULL),(1206,1173,NULL,NULL,1,NULL),(1207,1174,NULL,NULL,1,NULL),(1208,1175,NULL,NULL,1,NULL),(1209,1176,NULL,NULL,1,NULL),(1210,1177,NULL,NULL,1,NULL),(1211,1178,NULL,NULL,1,NULL),(1212,1180,NULL,NULL,1,NULL),(1213,1181,NULL,NULL,1,NULL),(1214,1182,NULL,NULL,1,NULL),(1215,1183,NULL,NULL,1,NULL),(1216,1184,NULL,NULL,1,NULL),(1217,1185,NULL,NULL,1,NULL),(1218,1186,NULL,NULL,1,NULL),(1219,1187,NULL,NULL,1,NULL),(1220,1189,NULL,NULL,1,NULL),(1221,1190,NULL,NULL,1,NULL),(1222,1191,NULL,NULL,1,NULL),(1223,1192,NULL,NULL,1,NULL),(1224,1193,NULL,NULL,1,NULL),(1225,1194,NULL,NULL,1,NULL),(1226,1195,NULL,NULL,1,NULL),(1227,1196,NULL,NULL,1,NULL),(1228,1197,NULL,NULL,1,NULL),(1229,1199,NULL,NULL,1,NULL),(1230,1200,NULL,NULL,1,NULL),(1231,1201,NULL,NULL,1,NULL),(1232,1202,NULL,NULL,1,NULL),(1233,1203,NULL,NULL,1,NULL),(1234,1204,NULL,NULL,1,NULL),(1235,1205,NULL,NULL,1,NULL),(1236,1206,NULL,NULL,1,NULL),(1237,1207,NULL,NULL,1,NULL),(1238,1209,NULL,NULL,1,NULL),(1239,1210,NULL,NULL,1,NULL),(1240,1211,NULL,NULL,1,NULL),(1241,1212,NULL,NULL,1,NULL),(1242,1213,NULL,NULL,1,NULL),(1243,1214,NULL,NULL,1,NULL),(1244,1216,NULL,NULL,1,NULL),(1245,1217,NULL,NULL,1,NULL),(1246,1218,NULL,NULL,1,NULL),(1247,1219,NULL,NULL,1,NULL),(1248,1220,NULL,NULL,1,NULL),(1249,1221,NULL,NULL,1,NULL),(1250,1223,NULL,NULL,1,NULL),(1251,1224,NULL,NULL,1,NULL),(1252,1225,NULL,NULL,1,NULL),(1253,1226,NULL,NULL,1,NULL),(1254,1227,NULL,NULL,1,NULL),(1255,1228,NULL,NULL,1,NULL),(1256,1229,NULL,NULL,1,NULL),(1257,1230,NULL,NULL,1,NULL),(1258,1232,NULL,NULL,1,NULL),(1259,1233,NULL,NULL,1,NULL),(1260,1234,NULL,NULL,1,NULL),(1261,1235,NULL,NULL,1,NULL),(1262,1236,NULL,NULL,1,NULL),(1263,1238,NULL,NULL,1,NULL),(1264,1239,NULL,NULL,1,NULL),(1265,1240,NULL,NULL,1,NULL),(1266,1241,NULL,NULL,1,NULL),(1267,1242,NULL,NULL,1,NULL),(1268,1244,NULL,NULL,1,NULL),(1269,1245,NULL,NULL,1,NULL),(1270,1246,NULL,NULL,1,NULL),(1271,1247,NULL,NULL,1,NULL),(1272,1248,NULL,NULL,1,NULL),(1273,1249,NULL,NULL,1,NULL),(1274,1250,NULL,NULL,1,NULL),(1275,1251,NULL,NULL,1,NULL),(1276,1253,NULL,NULL,1,NULL),(1277,1255,NULL,NULL,1,NULL),(1278,1270,NULL,NULL,1,NULL),(1279,1278,NULL,NULL,1,NULL),(1280,1285,NULL,NULL,1,NULL),(1281,1299,NULL,NULL,1,NULL),(1282,1313,NULL,NULL,1,NULL),(1283,1326,NULL,NULL,1,NULL),(1284,1338,NULL,NULL,1,NULL),(1285,1347,NULL,NULL,1,NULL),(1286,1358,NULL,NULL,1,NULL),(1287,1256,NULL,NULL,1,NULL),(1288,1257,NULL,NULL,1,NULL),(1289,1258,NULL,NULL,1,NULL),(1290,1259,NULL,NULL,1,NULL),(1291,1260,NULL,NULL,1,NULL),(1292,1261,NULL,NULL,1,NULL),(1293,1262,NULL,NULL,1,NULL),(1294,1263,NULL,NULL,1,NULL),(1295,1264,NULL,NULL,1,NULL),(1296,1265,NULL,NULL,1,NULL),(1297,1266,NULL,NULL,1,NULL),(1298,1267,NULL,NULL,1,NULL),(1299,1268,NULL,NULL,1,NULL),(1300,1269,NULL,NULL,1,NULL),(1301,1271,NULL,NULL,1,NULL),(1302,1272,NULL,NULL,1,NULL),(1303,1273,NULL,NULL,1,NULL),(1304,1274,NULL,NULL,1,NULL),(1305,1275,NULL,NULL,1,NULL),(1306,1276,NULL,NULL,1,NULL),(1307,1277,NULL,NULL,1,NULL),(1308,1279,NULL,NULL,1,NULL),(1309,1280,NULL,NULL,1,NULL),(1310,1281,NULL,NULL,1,NULL),(1311,1282,NULL,NULL,1,NULL),(1312,1283,NULL,NULL,1,NULL),(1313,1284,NULL,NULL,1,NULL),(1314,1286,NULL,NULL,1,NULL),(1315,1287,NULL,NULL,1,NULL),(1316,1288,NULL,NULL,1,NULL),(1317,1289,NULL,NULL,1,NULL),(1318,1290,NULL,NULL,1,NULL),(1319,1291,NULL,NULL,1,NULL),(1320,1292,NULL,NULL,1,NULL),(1321,1293,NULL,NULL,1,NULL),(1322,1294,NULL,NULL,1,NULL),(1323,1295,NULL,NULL,1,NULL),(1324,1296,NULL,NULL,1,NULL),(1325,1297,NULL,NULL,1,NULL),(1326,1298,NULL,NULL,1,NULL),(1327,1300,NULL,NULL,1,NULL),(1328,1301,NULL,NULL,1,NULL),(1329,1302,NULL,NULL,1,NULL),(1330,1303,NULL,NULL,1,NULL),(1331,1304,NULL,NULL,1,NULL),(1332,1305,NULL,NULL,1,NULL),(1333,1306,NULL,NULL,1,NULL),(1334,1307,NULL,NULL,1,NULL),(1335,1308,NULL,NULL,1,NULL),(1336,1309,NULL,NULL,1,NULL),(1337,1310,NULL,NULL,1,NULL),(1338,1311,NULL,NULL,1,NULL),(1339,1312,NULL,NULL,1,NULL),(1340,1314,NULL,NULL,1,NULL),(1341,1315,NULL,NULL,1,NULL),(1342,1316,NULL,NULL,1,NULL),(1343,1317,NULL,NULL,1,NULL),(1344,1318,NULL,NULL,1,NULL),(1345,1319,NULL,NULL,1,NULL),(1346,1320,NULL,NULL,1,NULL),(1347,1321,NULL,NULL,1,NULL),(1348,1322,NULL,NULL,1,NULL),(1349,1323,NULL,NULL,1,NULL),(1350,1324,NULL,NULL,1,NULL),(1351,1325,NULL,NULL,1,NULL),(1352,1327,NULL,NULL,1,NULL),(1353,1328,NULL,NULL,1,NULL),(1354,1329,NULL,NULL,1,NULL),(1355,1330,NULL,NULL,1,NULL),(1356,1331,NULL,NULL,1,NULL),(1357,1332,NULL,NULL,1,NULL),(1358,1333,NULL,NULL,1,NULL),(1359,1334,NULL,NULL,1,NULL),(1360,1335,NULL,NULL,1,NULL),(1361,1336,NULL,NULL,1,NULL),(1362,1337,NULL,NULL,1,NULL),(1363,1339,NULL,NULL,1,NULL),(1364,1340,NULL,NULL,1,NULL),(1365,1341,NULL,NULL,1,NULL),(1366,1342,NULL,NULL,1,NULL),(1367,1343,NULL,NULL,1,NULL),(1368,1344,NULL,NULL,1,NULL),(1369,1345,NULL,NULL,1,NULL),(1370,1346,NULL,NULL,1,NULL),(1371,1348,NULL,NULL,1,NULL),(1372,1349,NULL,NULL,1,NULL),(1373,1350,NULL,NULL,1,NULL),(1374,1351,NULL,NULL,1,NULL),(1375,1352,NULL,NULL,1,NULL),(1376,1353,NULL,NULL,1,NULL),(1377,1354,NULL,NULL,1,NULL),(1378,1355,NULL,NULL,1,NULL),(1379,1356,NULL,NULL,1,NULL),(1380,1357,NULL,NULL,1,NULL),(1381,1359,NULL,NULL,1,NULL),(1382,1361,NULL,NULL,1,NULL),(1383,1372,NULL,NULL,1,NULL),(1384,1378,NULL,NULL,1,NULL),(1385,1385,NULL,NULL,1,NULL),(1386,1399,NULL,NULL,1,NULL),(1387,1403,NULL,NULL,1,NULL),(1388,1408,NULL,NULL,1,NULL),(1389,1428,NULL,NULL,1,NULL),(1390,1443,NULL,NULL,1,NULL),(1391,1455,NULL,NULL,1,NULL),(1392,1468,NULL,NULL,1,NULL),(1393,1482,NULL,NULL,1,NULL),(1394,1362,NULL,NULL,1,NULL),(1395,1363,NULL,NULL,1,NULL),(1396,1364,NULL,NULL,1,NULL),(1397,1365,NULL,NULL,1,NULL),(1398,1366,NULL,NULL,1,NULL),(1399,1367,NULL,NULL,1,NULL),(1400,1368,NULL,NULL,1,NULL),(1401,1369,NULL,NULL,1,NULL),(1402,1370,NULL,NULL,1,NULL),(1403,1371,NULL,NULL,1,NULL),(1404,1373,NULL,NULL,1,NULL),(1405,1374,NULL,NULL,1,NULL),(1406,1375,NULL,NULL,1,NULL),(1407,1376,NULL,NULL,1,NULL),(1408,1377,NULL,NULL,1,NULL),(1409,1379,NULL,NULL,1,NULL),(1410,1380,NULL,NULL,1,NULL),(1411,1381,NULL,NULL,1,NULL),(1412,1382,NULL,NULL,1,NULL),(1413,1383,NULL,NULL,1,NULL),(1414,1384,NULL,NULL,1,NULL),(1415,1386,NULL,NULL,1,NULL),(1416,1387,NULL,NULL,1,NULL),(1417,1388,NULL,NULL,1,NULL),(1418,1389,NULL,NULL,1,NULL),(1419,1390,NULL,NULL,1,NULL),(1420,1391,NULL,NULL,1,NULL),(1421,1392,NULL,NULL,1,NULL),(1422,1393,NULL,NULL,1,NULL),(1423,1394,NULL,NULL,1,NULL),(1424,1395,NULL,NULL,1,NULL),(1425,1396,NULL,NULL,1,NULL),(1426,1397,NULL,NULL,1,NULL),(1427,1398,NULL,NULL,1,NULL),(1428,1400,NULL,NULL,1,NULL),(1429,1401,NULL,NULL,1,NULL),(1430,1402,NULL,NULL,1,NULL),(1431,1404,NULL,NULL,1,NULL),(1432,1405,NULL,NULL,1,NULL),(1433,1406,NULL,NULL,1,NULL),(1434,1407,NULL,NULL,1,NULL),(1435,1409,NULL,NULL,1,NULL),(1436,1410,NULL,NULL,1,NULL),(1437,1411,NULL,NULL,1,NULL),(1438,1412,NULL,NULL,1,NULL),(1439,1413,NULL,NULL,1,NULL),(1440,1414,NULL,NULL,1,NULL),(1441,1415,NULL,NULL,1,NULL),(1442,1416,NULL,NULL,1,NULL),(1443,1417,NULL,NULL,1,NULL),(1444,1418,NULL,NULL,1,NULL),(1445,1419,NULL,NULL,1,NULL),(1446,1420,NULL,NULL,1,NULL),(1447,1421,NULL,NULL,1,NULL),(1448,1422,NULL,NULL,1,NULL),(1449,1423,NULL,NULL,1,NULL),(1450,1424,NULL,NULL,1,NULL),(1451,1425,NULL,NULL,1,NULL),(1452,1426,NULL,NULL,1,NULL),(1453,1427,NULL,NULL,1,NULL),(1454,1429,NULL,NULL,1,NULL),(1455,1430,NULL,NULL,1,NULL),(1456,1431,NULL,NULL,1,NULL),(1457,1432,NULL,NULL,1,NULL),(1458,1433,NULL,NULL,1,NULL),(1459,1434,NULL,NULL,1,NULL),(1460,1435,NULL,NULL,1,NULL),(1461,1436,NULL,NULL,1,NULL),(1462,1437,NULL,NULL,1,NULL),(1463,1438,NULL,NULL,1,NULL),(1464,1439,NULL,NULL,1,NULL),(1465,1440,NULL,NULL,1,NULL),(1466,1441,NULL,NULL,1,NULL),(1467,1442,NULL,NULL,1,NULL),(1468,1444,NULL,NULL,1,NULL),(1469,1445,NULL,NULL,1,NULL),(1470,1446,NULL,NULL,1,NULL),(1471,1447,NULL,NULL,1,NULL),(1472,1448,NULL,NULL,1,NULL),(1473,1449,NULL,NULL,1,NULL),(1474,1450,NULL,NULL,1,NULL),(1475,1451,NULL,NULL,1,NULL),(1476,1452,NULL,NULL,1,NULL),(1477,1453,NULL,NULL,1,NULL),(1478,1454,NULL,NULL,1,NULL),(1479,1456,NULL,NULL,1,NULL),(1480,1457,NULL,NULL,1,NULL),(1481,1458,NULL,NULL,1,NULL),(1482,1459,NULL,NULL,1,NULL),(1483,1460,NULL,NULL,1,NULL),(1484,1461,NULL,NULL,1,NULL),(1485,1462,NULL,NULL,1,NULL),(1486,1463,NULL,NULL,1,NULL),(1487,1464,NULL,NULL,1,NULL),(1488,1465,NULL,NULL,1,NULL),(1489,1466,NULL,NULL,1,NULL),(1490,1467,NULL,NULL,1,NULL),(1491,1469,NULL,NULL,1,NULL),(1492,1470,NULL,NULL,1,NULL),(1493,1471,NULL,NULL,1,NULL),(1494,1472,NULL,NULL,1,NULL),(1495,1473,NULL,NULL,1,NULL),(1496,1474,NULL,NULL,1,NULL),(1497,1475,NULL,NULL,1,NULL),(1498,1476,NULL,NULL,1,NULL),(1499,1477,NULL,NULL,1,NULL),(1500,1478,NULL,NULL,1,NULL),(1501,1479,NULL,NULL,1,NULL),(1502,1480,NULL,NULL,1,NULL),(1503,1481,NULL,NULL,1,NULL),(1504,1483,NULL,NULL,1,NULL),(1505,1485,NULL,NULL,1,NULL),(1506,1497,NULL,NULL,1,NULL),(1507,1511,NULL,NULL,1,NULL),(1508,1521,NULL,NULL,1,NULL),(1509,1529,NULL,NULL,1,NULL),(1510,1536,NULL,NULL,1,NULL),(1511,1550,NULL,NULL,1,NULL),(1512,1564,NULL,NULL,1,NULL),(1513,1578,NULL,NULL,1,NULL),(1514,1586,NULL,NULL,1,NULL),(1515,1592,NULL,NULL,1,NULL),(1516,1598,NULL,NULL,1,NULL),(1517,1602,NULL,NULL,1,NULL),(1518,1616,NULL,NULL,1,NULL),(1519,1629,NULL,NULL,1,NULL),(1520,1639,NULL,NULL,1,NULL),(1521,1648,NULL,NULL,1,NULL),(1522,1659,NULL,NULL,1,NULL),(1523,1486,NULL,NULL,1,NULL),(1524,1487,NULL,NULL,1,NULL),(1525,1488,NULL,NULL,1,NULL),(1526,1489,NULL,NULL,1,NULL),(1527,1490,NULL,NULL,1,NULL),(1528,1491,NULL,NULL,1,NULL),(1529,1492,NULL,NULL,1,NULL),(1530,1493,NULL,NULL,1,NULL),(1531,1494,NULL,NULL,1,NULL),(1532,1495,NULL,NULL,1,NULL),(1533,1496,NULL,NULL,1,NULL),(1534,1498,NULL,NULL,1,NULL),(1535,1499,NULL,NULL,1,NULL),(1536,1500,NULL,NULL,1,NULL),(1537,1501,NULL,NULL,1,NULL),(1538,1502,NULL,NULL,1,NULL),(1539,1503,NULL,NULL,1,NULL),(1540,1504,NULL,NULL,1,NULL),(1541,1505,NULL,NULL,1,NULL),(1542,1506,NULL,NULL,1,NULL),(1543,1507,NULL,NULL,1,NULL),(1544,1508,NULL,NULL,1,NULL),(1545,1509,NULL,NULL,1,NULL),(1546,1510,NULL,NULL,1,NULL),(1547,1512,NULL,NULL,1,NULL),(1548,1513,NULL,NULL,1,NULL),(1549,1514,NULL,NULL,1,NULL),(1550,1515,NULL,NULL,1,NULL),(1551,1516,NULL,NULL,1,NULL),(1552,1517,NULL,NULL,1,NULL),(1553,1518,NULL,NULL,1,NULL),(1554,1519,NULL,NULL,1,NULL),(1555,1520,NULL,NULL,1,NULL),(1556,1522,NULL,NULL,1,NULL),(1557,1523,NULL,NULL,1,NULL),(1558,1524,NULL,NULL,1,NULL),(1559,1525,NULL,NULL,1,NULL),(1560,1526,NULL,NULL,1,NULL),(1561,1527,NULL,NULL,1,NULL),(1562,1528,NULL,NULL,1,NULL),(1563,1530,NULL,NULL,1,NULL),(1564,1531,NULL,NULL,1,NULL),(1565,1532,NULL,NULL,1,NULL),(1566,1533,NULL,NULL,1,NULL),(1567,1534,NULL,NULL,1,NULL),(1568,1535,NULL,NULL,1,NULL),(1569,1537,NULL,NULL,1,NULL),(1570,1538,NULL,NULL,1,NULL),(1571,1539,NULL,NULL,1,NULL),(1572,1540,NULL,NULL,1,NULL),(1573,1541,NULL,NULL,1,NULL),(1574,1542,NULL,NULL,1,NULL),(1575,1543,NULL,NULL,1,NULL),(1576,1544,NULL,NULL,1,NULL),(1577,1545,NULL,NULL,1,NULL),(1578,1546,NULL,NULL,1,NULL),(1579,1547,NULL,NULL,1,NULL),(1580,1548,NULL,NULL,1,NULL),(1581,1549,NULL,NULL,1,NULL),(1582,1551,NULL,NULL,1,NULL),(1583,1552,NULL,NULL,1,NULL),(1584,1553,NULL,NULL,1,NULL),(1585,1554,NULL,NULL,1,NULL),(1586,1555,NULL,NULL,1,NULL),(1587,1556,NULL,NULL,1,NULL),(1588,1557,NULL,NULL,1,NULL),(1589,1558,NULL,NULL,1,NULL),(1590,1559,NULL,NULL,1,NULL),(1591,1560,NULL,NULL,1,NULL),(1592,1561,NULL,NULL,1,NULL),(1593,1562,NULL,NULL,1,NULL),(1594,1563,NULL,NULL,1,NULL),(1595,1565,NULL,NULL,1,NULL),(1596,1566,NULL,NULL,1,NULL),(1597,1567,NULL,NULL,1,NULL),(1598,1568,NULL,NULL,1,NULL),(1599,1569,NULL,NULL,1,NULL),(1600,1570,NULL,NULL,1,NULL),(1601,1571,NULL,NULL,1,NULL),(1602,1572,NULL,NULL,1,NULL),(1603,1573,NULL,NULL,1,NULL),(1604,1574,NULL,NULL,1,NULL),(1605,1575,NULL,NULL,1,NULL),(1606,1576,NULL,NULL,1,NULL),(1607,1577,NULL,NULL,1,NULL),(1608,1579,NULL,NULL,1,NULL),(1609,1580,NULL,NULL,1,NULL),(1610,1581,NULL,NULL,1,NULL),(1611,1582,NULL,NULL,1,NULL),(1612,1583,NULL,NULL,1,NULL),(1613,1584,NULL,NULL,1,NULL),(1614,1585,NULL,NULL,1,NULL),(1615,1587,NULL,NULL,1,NULL),(1616,1588,NULL,NULL,1,NULL),(1617,1589,NULL,NULL,1,NULL),(1618,1590,NULL,NULL,1,NULL),(1619,1591,NULL,NULL,1,NULL),(1620,1593,NULL,NULL,1,NULL),(1621,1594,NULL,NULL,1,NULL),(1622,1595,NULL,NULL,1,NULL),(1623,1596,NULL,NULL,1,NULL),(1624,1597,NULL,NULL,1,NULL),(1625,1599,NULL,NULL,1,NULL),(1626,1600,NULL,NULL,1,NULL),(1627,1601,NULL,NULL,1,NULL),(1628,1603,NULL,NULL,1,NULL),(1629,1604,NULL,NULL,1,NULL),(1630,1605,NULL,NULL,1,NULL),(1631,1606,NULL,NULL,1,NULL),(1632,1607,NULL,NULL,1,NULL),(1633,1608,NULL,NULL,1,NULL),(1634,1609,NULL,NULL,1,NULL),(1635,1610,NULL,NULL,1,NULL),(1636,1611,NULL,NULL,1,NULL),(1637,1612,NULL,NULL,1,NULL),(1638,1613,NULL,NULL,1,NULL),(1639,1614,NULL,NULL,1,NULL),(1640,1615,NULL,NULL,1,NULL),(1641,1617,NULL,NULL,1,NULL),(1642,1618,NULL,NULL,1,NULL),(1643,1619,NULL,NULL,1,NULL),(1644,1620,NULL,NULL,1,NULL),(1645,1621,NULL,NULL,1,NULL),(1646,1622,NULL,NULL,1,NULL),(1647,1623,NULL,NULL,1,NULL),(1648,1624,NULL,NULL,1,NULL),(1649,1625,NULL,NULL,1,NULL),(1650,1626,NULL,NULL,1,NULL),(1651,1627,NULL,NULL,1,NULL),(1652,1628,NULL,NULL,1,NULL),(1653,1630,NULL,NULL,1,NULL),(1654,1631,NULL,NULL,1,NULL),(1655,1632,NULL,NULL,1,NULL),(1656,1633,NULL,NULL,1,NULL),(1657,1634,NULL,NULL,1,NULL),(1658,1635,NULL,NULL,1,NULL),(1659,1636,NULL,NULL,1,NULL),(1660,1637,NULL,NULL,1,NULL),(1661,1638,NULL,NULL,1,NULL),(1662,1640,NULL,NULL,1,NULL),(1663,1641,NULL,NULL,1,NULL),(1664,1642,NULL,NULL,1,NULL),(1665,1643,NULL,NULL,1,NULL),(1666,1644,NULL,NULL,1,NULL),(1667,1645,NULL,NULL,1,NULL),(1668,1646,NULL,NULL,1,NULL),(1669,1647,NULL,NULL,1,NULL),(1670,1649,NULL,NULL,1,NULL),(1671,1650,NULL,NULL,1,NULL),(1672,1651,NULL,NULL,1,NULL),(1673,1652,NULL,NULL,1,NULL),(1674,1653,NULL,NULL,1,NULL),(1675,1654,NULL,NULL,1,NULL),(1676,1655,NULL,NULL,1,NULL),(1677,1656,NULL,NULL,1,NULL),(1678,1657,NULL,NULL,1,NULL),(1679,1658,NULL,NULL,1,NULL),(1680,1660,NULL,NULL,1,NULL),(1681,1662,NULL,NULL,1,NULL),(1682,1676,NULL,NULL,1,NULL),(1683,1688,NULL,NULL,1,NULL),(1684,1705,NULL,NULL,1,NULL),(1685,1717,NULL,NULL,1,NULL),(1686,1728,NULL,NULL,1,NULL),(1687,1735,NULL,NULL,1,NULL),(1688,1749,NULL,NULL,1,NULL),(1689,1761,NULL,NULL,1,NULL),(1690,1769,NULL,NULL,1,NULL),(1691,1777,NULL,NULL,1,NULL),(1692,1784,NULL,NULL,1,NULL),(1693,1792,NULL,NULL,1,NULL),(1694,1807,NULL,NULL,1,NULL),(1695,1818,NULL,NULL,1,NULL),(1696,1830,NULL,NULL,1,NULL),(1697,1842,NULL,NULL,1,NULL),(1698,1854,NULL,NULL,1,NULL),(1699,1857,NULL,NULL,1,NULL),(1700,1663,NULL,NULL,1,NULL),(1701,1664,NULL,NULL,1,NULL),(1702,1665,NULL,NULL,1,NULL),(1703,1666,NULL,NULL,1,NULL),(1704,1667,NULL,NULL,1,NULL),(1705,1668,NULL,NULL,1,NULL),(1706,1669,NULL,NULL,1,NULL),(1707,1670,NULL,NULL,1,NULL),(1708,1671,NULL,NULL,1,NULL),(1709,1672,NULL,NULL,1,NULL),(1710,1673,NULL,NULL,1,NULL),(1711,1674,NULL,NULL,1,NULL),(1712,1675,NULL,NULL,1,NULL),(1713,1677,NULL,NULL,1,NULL),(1714,1678,NULL,NULL,1,NULL),(1715,1679,NULL,NULL,1,NULL),(1716,1680,NULL,NULL,1,NULL),(1717,1681,NULL,NULL,1,NULL),(1718,1682,NULL,NULL,1,NULL),(1719,1683,NULL,NULL,1,NULL),(1720,1684,NULL,NULL,1,NULL),(1721,1685,NULL,NULL,1,NULL),(1722,1686,NULL,NULL,1,NULL),(1723,1687,NULL,NULL,1,NULL),(1724,1689,NULL,NULL,1,NULL),(1725,1690,NULL,NULL,1,NULL),(1726,1691,NULL,NULL,1,NULL),(1727,1692,NULL,NULL,1,NULL),(1728,1693,NULL,NULL,1,NULL),(1729,1694,NULL,NULL,1,NULL),(1730,1695,NULL,NULL,1,NULL),(1731,1696,NULL,NULL,1,NULL),(1732,1697,NULL,NULL,1,NULL),(1733,1698,NULL,NULL,1,NULL),(1734,1699,NULL,NULL,1,NULL),(1735,1700,NULL,NULL,1,NULL),(1736,1701,NULL,NULL,1,NULL),(1737,1702,NULL,NULL,1,NULL),(1738,1703,NULL,NULL,1,NULL),(1739,1704,NULL,NULL,1,NULL),(1740,1706,NULL,NULL,1,NULL),(1741,1707,NULL,NULL,1,NULL),(1742,1708,NULL,NULL,1,NULL),(1743,1709,NULL,NULL,1,NULL),(1744,1710,NULL,NULL,1,NULL),(1745,1711,NULL,NULL,1,NULL),(1746,1712,NULL,NULL,1,NULL),(1747,1713,NULL,NULL,1,NULL),(1748,1714,NULL,NULL,1,NULL),(1749,1715,NULL,NULL,1,NULL),(1750,1716,NULL,NULL,1,NULL),(1751,1718,NULL,NULL,1,NULL),(1752,1719,NULL,NULL,1,NULL),(1753,1720,NULL,NULL,1,NULL),(1754,1721,NULL,NULL,1,NULL),(1755,1722,NULL,NULL,1,NULL),(1756,1723,NULL,NULL,1,NULL),(1757,1724,NULL,NULL,1,NULL),(1758,1725,NULL,NULL,1,NULL),(1759,1726,NULL,NULL,1,NULL),(1760,1727,NULL,NULL,1,NULL),(1761,1729,NULL,NULL,1,NULL),(1762,1730,NULL,NULL,1,NULL),(1763,1731,NULL,NULL,1,NULL),(1764,1732,NULL,NULL,1,NULL),(1765,1733,NULL,NULL,1,NULL),(1766,1734,NULL,NULL,1,NULL),(1767,1736,NULL,NULL,1,NULL),(1768,1737,NULL,NULL,1,NULL),(1769,1738,NULL,NULL,1,NULL),(1770,1739,NULL,NULL,1,NULL),(1771,1740,NULL,NULL,1,NULL),(1772,1741,NULL,NULL,1,NULL),(1773,1742,NULL,NULL,1,NULL),(1774,1743,NULL,NULL,1,NULL),(1775,1744,NULL,NULL,1,NULL),(1776,1745,NULL,NULL,1,NULL),(1777,1746,NULL,NULL,1,NULL),(1778,1747,NULL,NULL,1,NULL),(1779,1748,NULL,NULL,1,NULL),(1780,1750,NULL,NULL,1,NULL),(1781,1751,NULL,NULL,1,NULL),(1782,1752,NULL,NULL,1,NULL),(1783,1753,NULL,NULL,1,NULL),(1784,1754,NULL,NULL,1,NULL),(1785,1755,NULL,NULL,1,NULL),(1786,1756,NULL,NULL,1,NULL),(1787,1757,NULL,NULL,1,NULL),(1788,1758,NULL,NULL,1,NULL),(1789,1759,NULL,NULL,1,NULL),(1790,1760,NULL,NULL,1,NULL),(1791,1762,NULL,NULL,1,NULL),(1792,1763,NULL,NULL,1,NULL),(1793,1764,NULL,NULL,1,NULL),(1794,1765,NULL,NULL,1,NULL),(1795,1766,NULL,NULL,1,NULL),(1796,1767,NULL,NULL,1,NULL),(1797,1768,NULL,NULL,1,NULL),(1798,1770,NULL,NULL,1,NULL),(1799,1771,NULL,NULL,1,NULL),(1800,1772,NULL,NULL,1,NULL),(1801,1773,NULL,NULL,1,NULL),(1802,1774,NULL,NULL,1,NULL),(1803,1775,NULL,NULL,1,NULL),(1804,1776,NULL,NULL,1,NULL),(1805,1778,NULL,NULL,1,NULL),(1806,1779,NULL,NULL,1,NULL),(1807,1780,NULL,NULL,1,NULL),(1808,1781,NULL,NULL,1,NULL),(1809,1782,NULL,NULL,1,NULL),(1810,1783,NULL,NULL,1,NULL),(1811,1785,NULL,NULL,1,NULL),(1812,1786,NULL,NULL,1,NULL),(1813,1787,NULL,NULL,1,NULL),(1814,1788,NULL,NULL,1,NULL),(1815,1789,NULL,NULL,1,NULL),(1816,1790,NULL,NULL,1,NULL),(1817,1791,NULL,NULL,1,NULL),(1818,1793,NULL,NULL,1,NULL),(1819,1794,NULL,NULL,1,NULL),(1820,1795,NULL,NULL,1,NULL),(1821,1796,NULL,NULL,1,NULL),(1822,1797,NULL,NULL,1,NULL),(1823,1798,NULL,NULL,1,NULL),(1824,1799,NULL,NULL,1,NULL),(1825,1800,NULL,NULL,1,NULL),(1826,1801,NULL,NULL,1,NULL),(1827,1802,NULL,NULL,1,NULL),(1828,1803,NULL,NULL,1,NULL),(1829,1804,NULL,NULL,1,NULL),(1830,1805,NULL,NULL,1,NULL),(1831,1806,NULL,NULL,1,NULL),(1832,1808,NULL,NULL,1,NULL),(1833,1809,NULL,NULL,1,NULL),(1834,1810,NULL,NULL,1,NULL),(1835,1811,NULL,NULL,1,NULL),(1836,1812,NULL,NULL,1,NULL),(1837,1813,NULL,NULL,1,NULL),(1838,1814,NULL,NULL,1,NULL),(1839,1815,NULL,NULL,1,NULL),(1840,1816,NULL,NULL,1,NULL),(1841,1817,NULL,NULL,1,NULL),(1842,1819,NULL,NULL,1,NULL),(1843,1820,NULL,NULL,1,NULL),(1844,1821,NULL,NULL,1,NULL),(1845,1822,NULL,NULL,1,NULL),(1846,1823,NULL,NULL,1,NULL),(1847,1824,NULL,NULL,1,NULL),(1848,1825,NULL,NULL,1,NULL),(1849,1826,NULL,NULL,1,NULL),(1850,1827,NULL,NULL,1,NULL),(1851,1828,NULL,NULL,1,NULL),(1852,1829,NULL,NULL,1,NULL),(1853,1831,NULL,NULL,1,NULL),(1854,1832,NULL,NULL,1,NULL),(1855,1833,NULL,NULL,1,NULL),(1856,1834,NULL,NULL,1,NULL),(1857,1835,NULL,NULL,1,NULL),(1858,1836,NULL,NULL,1,NULL),(1859,1837,NULL,NULL,1,NULL),(1860,1838,NULL,NULL,1,NULL),(1861,1839,NULL,NULL,1,NULL),(1862,1840,NULL,NULL,1,NULL),(1863,1841,NULL,NULL,1,NULL),(1864,1843,NULL,NULL,1,NULL),(1865,1844,NULL,NULL,1,NULL),(1866,1845,NULL,NULL,1,NULL),(1867,1846,NULL,NULL,1,NULL),(1868,1847,NULL,NULL,1,NULL),(1869,1848,NULL,NULL,1,NULL),(1870,1849,NULL,NULL,1,NULL),(1871,1850,NULL,NULL,1,NULL),(1872,1851,NULL,NULL,1,NULL),(1873,1852,NULL,NULL,1,NULL),(1874,1853,NULL,NULL,1,NULL),(1875,1855,NULL,NULL,1,NULL),(1876,1856,NULL,NULL,1,NULL),(1877,1858,NULL,NULL,1,NULL),(1878,1860,NULL,NULL,1,NULL),(1879,1875,NULL,NULL,1,NULL),(1880,1883,NULL,NULL,1,NULL),(1881,1893,NULL,NULL,1,NULL),(1882,1903,NULL,NULL,1,NULL),(1883,1918,NULL,NULL,1,NULL),(1884,1929,NULL,NULL,1,NULL),(1885,1934,NULL,NULL,1,NULL),(1886,1941,NULL,NULL,1,NULL),(1887,1950,NULL,NULL,1,NULL),(1888,1962,NULL,NULL,1,NULL),(1889,1970,NULL,NULL,1,NULL),(1890,1974,NULL,NULL,1,NULL),(1891,1984,NULL,NULL,1,NULL),(1892,1986,NULL,NULL,1,NULL),(1893,1988,NULL,NULL,1,NULL),(1894,1990,NULL,NULL,1,NULL),(1895,1992,NULL,NULL,1,NULL),(1896,1861,NULL,NULL,1,NULL),(1897,1862,NULL,NULL,1,NULL),(1898,1863,NULL,NULL,1,NULL),(1899,1864,NULL,NULL,1,NULL),(1900,1865,NULL,NULL,1,NULL),(1901,1866,NULL,NULL,1,NULL),(1902,1867,NULL,NULL,1,NULL),(1903,1868,NULL,NULL,1,NULL),(1904,1869,NULL,NULL,1,NULL),(1905,1870,NULL,NULL,1,NULL),(1906,1871,NULL,NULL,1,NULL),(1907,1872,NULL,NULL,1,NULL),(1908,1873,NULL,NULL,1,NULL),(1909,1874,NULL,NULL,1,NULL),(1910,1876,NULL,NULL,1,NULL),(1911,1877,NULL,NULL,1,NULL),(1912,1878,NULL,NULL,1,NULL),(1913,1879,NULL,NULL,1,NULL),(1914,1880,NULL,NULL,1,NULL),(1915,1881,NULL,NULL,1,NULL),(1916,1882,NULL,NULL,1,NULL),(1917,1884,NULL,NULL,1,NULL),(1918,1885,NULL,NULL,1,NULL),(1919,1886,NULL,NULL,1,NULL),(1920,1887,NULL,NULL,1,NULL),(1921,1888,NULL,NULL,1,NULL),(1922,1889,NULL,NULL,1,NULL),(1923,1890,NULL,NULL,1,NULL),(1924,1891,NULL,NULL,1,NULL),(1925,1892,NULL,NULL,1,NULL),(1926,1894,NULL,NULL,1,NULL),(1927,1895,NULL,NULL,1,NULL),(1928,1896,NULL,NULL,1,NULL),(1929,1897,NULL,NULL,1,NULL),(1930,1898,NULL,NULL,1,NULL),(1931,1899,NULL,NULL,1,NULL),(1932,1900,NULL,NULL,1,NULL),(1933,1901,NULL,NULL,1,NULL),(1934,1902,NULL,NULL,1,NULL),(1935,1904,NULL,NULL,1,NULL),(1936,1905,NULL,NULL,1,NULL),(1937,1906,NULL,NULL,1,NULL),(1938,1907,NULL,NULL,1,NULL),(1939,1908,NULL,NULL,1,NULL),(1940,1909,NULL,NULL,1,NULL),(1941,1910,NULL,NULL,1,NULL),(1942,1911,NULL,NULL,1,NULL),(1943,1912,NULL,NULL,1,NULL),(1944,1913,NULL,NULL,1,NULL),(1945,1914,NULL,NULL,1,NULL),(1946,1915,NULL,NULL,1,NULL),(1947,1916,NULL,NULL,1,NULL),(1948,1917,NULL,NULL,1,NULL),(1949,1919,NULL,NULL,1,NULL),(1950,1920,NULL,NULL,1,NULL),(1951,1921,NULL,NULL,1,NULL),(1952,1922,NULL,NULL,1,NULL),(1953,1923,NULL,NULL,1,NULL),(1954,1924,NULL,NULL,1,NULL),(1955,1925,NULL,NULL,1,NULL),(1956,1926,NULL,NULL,1,NULL),(1957,1927,NULL,NULL,1,NULL),(1958,1928,NULL,NULL,1,NULL),(1959,1930,NULL,NULL,1,NULL),(1960,1931,NULL,NULL,1,NULL),(1961,1932,NULL,NULL,1,NULL),(1962,1933,NULL,NULL,1,NULL),(1963,1935,NULL,NULL,1,NULL),(1964,1936,NULL,NULL,1,NULL),(1965,1937,NULL,NULL,1,NULL),(1966,1938,NULL,NULL,1,NULL),(1967,1939,NULL,NULL,1,NULL),(1968,1940,NULL,NULL,1,NULL),(1969,1942,NULL,NULL,1,NULL),(1970,1943,NULL,NULL,1,NULL),(1971,1944,NULL,NULL,1,NULL),(1972,1945,NULL,NULL,1,NULL),(1973,1946,NULL,NULL,1,NULL),(1974,1947,NULL,NULL,1,NULL),(1975,1948,NULL,NULL,1,NULL),(1976,1949,NULL,NULL,1,NULL),(1977,1951,NULL,NULL,1,NULL),(1978,1952,NULL,NULL,1,NULL),(1979,1953,NULL,NULL,1,NULL),(1980,1954,NULL,NULL,1,NULL),(1981,1955,NULL,NULL,1,NULL),(1982,1956,NULL,NULL,1,NULL),(1983,1957,NULL,NULL,1,NULL),(1984,1958,NULL,NULL,1,NULL),(1985,1959,NULL,NULL,1,NULL),(1986,1960,NULL,NULL,1,NULL),(1987,1961,NULL,NULL,1,NULL),(1988,1963,NULL,NULL,1,NULL),(1989,1964,NULL,NULL,1,NULL),(1990,1965,NULL,NULL,1,NULL),(1991,1966,NULL,NULL,1,NULL),(1992,1967,NULL,NULL,1,NULL),(1993,1968,NULL,NULL,1,NULL),(1994,1969,NULL,NULL,1,NULL),(1995,1971,NULL,NULL,1,NULL),(1996,1972,NULL,NULL,1,NULL),(1997,1973,NULL,NULL,1,NULL),(1998,1975,NULL,NULL,1,NULL),(1999,1976,NULL,NULL,1,NULL),(2000,1977,NULL,NULL,1,NULL),(2001,1978,NULL,NULL,1,NULL),(2002,1979,NULL,NULL,1,NULL),(2003,1980,NULL,NULL,1,NULL),(2004,1981,NULL,NULL,1,NULL),(2005,1982,NULL,NULL,1,NULL),(2006,1983,NULL,NULL,1,NULL),(2007,1985,NULL,NULL,1,NULL),(2008,1987,NULL,NULL,1,NULL),(2009,1989,NULL,NULL,1,NULL),(2010,1991,NULL,NULL,1,NULL),(2011,1993,NULL,NULL,1,NULL),(2012,1995,NULL,NULL,1,NULL),(2013,2006,NULL,NULL,1,NULL),(2014,2017,NULL,NULL,1,NULL),(2015,2024,NULL,NULL,1,NULL),(2016,2038,NULL,NULL,1,NULL),(2017,2052,NULL,NULL,1,NULL),(2018,2063,NULL,NULL,1,NULL),(2019,2074,NULL,NULL,1,NULL),(2020,2080,NULL,NULL,1,NULL),(2021,2088,NULL,NULL,1,NULL),(2022,2101,NULL,NULL,1,NULL),(2023,2114,NULL,NULL,1,NULL),(2024,2128,NULL,NULL,1,NULL),(2025,2135,NULL,NULL,1,NULL),(2026,2145,NULL,NULL,1,NULL),(2027,1996,NULL,NULL,1,NULL),(2028,1997,NULL,NULL,1,NULL),(2029,1998,NULL,NULL,1,NULL),(2030,1999,NULL,NULL,1,NULL),(2031,2000,NULL,NULL,1,NULL),(2032,2001,NULL,NULL,1,NULL),(2033,2002,NULL,NULL,1,NULL),(2034,2003,NULL,NULL,1,NULL),(2035,2004,NULL,NULL,1,NULL),(2036,2005,NULL,NULL,1,NULL),(2037,2007,NULL,NULL,1,NULL),(2038,2008,NULL,NULL,1,NULL),(2039,2009,NULL,NULL,1,NULL),(2040,2010,NULL,NULL,1,NULL),(2041,2011,NULL,NULL,1,NULL),(2042,2012,NULL,NULL,1,NULL),(2043,2013,NULL,NULL,1,NULL),(2044,2014,NULL,NULL,1,NULL),(2045,2015,NULL,NULL,1,NULL),(2046,2016,NULL,NULL,1,NULL),(2047,2018,NULL,NULL,1,NULL),(2048,2019,NULL,NULL,1,NULL),(2049,2020,NULL,NULL,1,NULL),(2050,2021,NULL,NULL,1,NULL),(2051,2022,NULL,NULL,1,NULL),(2052,2023,NULL,NULL,1,NULL),(2053,2025,NULL,NULL,1,NULL),(2054,2026,NULL,NULL,1,NULL),(2055,2027,NULL,NULL,1,NULL),(2056,2028,NULL,NULL,1,NULL),(2057,2029,NULL,NULL,1,NULL),(2058,2030,NULL,NULL,1,NULL),(2059,2031,NULL,NULL,1,NULL),(2060,2032,NULL,NULL,1,NULL),(2061,2033,NULL,NULL,1,NULL),(2062,2034,NULL,NULL,1,NULL),(2063,2035,NULL,NULL,1,NULL),(2064,2036,NULL,NULL,1,NULL),(2065,2037,NULL,NULL,1,NULL),(2066,2039,NULL,NULL,1,NULL),(2067,2040,NULL,NULL,1,NULL),(2068,2041,NULL,NULL,1,NULL),(2069,2042,NULL,NULL,1,NULL),(2070,2043,NULL,NULL,1,NULL),(2071,2044,NULL,NULL,1,NULL),(2072,2045,NULL,NULL,1,NULL),(2073,2046,NULL,NULL,1,NULL),(2074,2047,NULL,NULL,1,NULL),(2075,2048,NULL,NULL,1,NULL),(2076,2049,NULL,NULL,1,NULL),(2077,2050,NULL,NULL,1,NULL),(2078,2051,NULL,NULL,1,NULL),(2079,2053,NULL,NULL,1,NULL),(2080,2054,NULL,NULL,1,NULL),(2081,2055,NULL,NULL,1,NULL),(2082,2056,NULL,NULL,1,NULL),(2083,2057,NULL,NULL,1,NULL),(2084,2058,NULL,NULL,1,NULL),(2085,2059,NULL,NULL,1,NULL),(2086,2060,NULL,NULL,1,NULL),(2087,2061,NULL,NULL,1,NULL),(2088,2062,NULL,NULL,1,NULL),(2089,2064,NULL,NULL,1,NULL),(2090,2065,NULL,NULL,1,NULL),(2091,2066,NULL,NULL,1,NULL),(2092,2067,NULL,NULL,1,NULL),(2093,2068,NULL,NULL,1,NULL),(2094,2069,NULL,NULL,1,NULL),(2095,2070,NULL,NULL,1,NULL),(2096,2071,NULL,NULL,1,NULL),(2097,2072,NULL,NULL,1,NULL),(2098,2073,NULL,NULL,1,NULL),(2099,2075,NULL,NULL,1,NULL),(2100,2076,NULL,NULL,1,NULL),(2101,2077,NULL,NULL,1,NULL),(2102,2078,NULL,NULL,1,NULL),(2103,2079,NULL,NULL,1,NULL),(2104,2081,NULL,NULL,1,NULL),(2105,2082,NULL,NULL,1,NULL),(2106,2083,NULL,NULL,1,NULL),(2107,2084,NULL,NULL,1,NULL),(2108,2085,NULL,NULL,1,NULL),(2109,2086,NULL,NULL,1,NULL),(2110,2087,NULL,NULL,1,NULL),(2111,2089,NULL,NULL,1,NULL),(2112,2090,NULL,NULL,1,NULL),(2113,2091,NULL,NULL,1,NULL),(2114,2092,NULL,NULL,1,NULL),(2115,2093,NULL,NULL,1,NULL),(2116,2094,NULL,NULL,1,NULL),(2117,2095,NULL,NULL,1,NULL),(2118,2096,NULL,NULL,1,NULL),(2119,2097,NULL,NULL,1,NULL),(2120,2098,NULL,NULL,1,NULL),(2121,2099,NULL,NULL,1,NULL),(2122,2100,NULL,NULL,1,NULL),(2123,2102,NULL,NULL,1,NULL),(2124,2103,NULL,NULL,1,NULL),(2125,2104,NULL,NULL,1,NULL),(2126,2105,NULL,NULL,1,NULL),(2127,2106,NULL,NULL,1,NULL),(2128,2107,NULL,NULL,1,NULL),(2129,2108,NULL,NULL,1,NULL),(2130,2109,NULL,NULL,1,NULL),(2131,2110,NULL,NULL,1,NULL),(2132,2111,NULL,NULL,1,NULL),(2133,2112,NULL,NULL,1,NULL),(2134,2113,NULL,NULL,1,NULL),(2135,2115,NULL,NULL,1,NULL),(2136,2116,NULL,NULL,1,NULL),(2137,2117,NULL,NULL,1,NULL),(2138,2118,NULL,NULL,1,NULL),(2139,2119,NULL,NULL,1,NULL),(2140,2120,NULL,NULL,1,NULL),(2141,2121,NULL,NULL,1,NULL),(2142,2122,NULL,NULL,1,NULL),(2143,2123,NULL,NULL,1,NULL),(2144,2124,NULL,NULL,1,NULL),(2145,2125,NULL,NULL,1,NULL),(2146,2126,NULL,NULL,1,NULL),(2147,2127,NULL,NULL,1,NULL),(2148,2129,NULL,NULL,1,NULL),(2149,2130,NULL,NULL,1,NULL),(2150,2131,NULL,NULL,1,NULL),(2151,2132,NULL,NULL,1,NULL),(2152,2133,NULL,NULL,1,NULL),(2153,2134,NULL,NULL,1,NULL),(2154,2136,NULL,NULL,1,NULL),(2155,2137,NULL,NULL,1,NULL),(2156,2138,NULL,NULL,1,NULL),(2157,2139,NULL,NULL,1,NULL),(2158,2140,NULL,NULL,1,NULL),(2159,2141,NULL,NULL,1,NULL),(2160,2142,NULL,NULL,1,NULL),(2161,2143,NULL,NULL,1,NULL),(2162,2144,NULL,NULL,1,NULL),(2163,2146,NULL,NULL,1,NULL),(2164,2148,NULL,NULL,1,NULL),(2165,2162,NULL,NULL,1,NULL),(2166,2170,NULL,NULL,1,NULL),(2167,2177,NULL,NULL,1,NULL),(2168,2179,NULL,NULL,1,NULL),(2169,2184,NULL,NULL,1,NULL),(2170,2191,NULL,NULL,1,NULL),(2171,2198,NULL,NULL,1,NULL),(2172,2203,NULL,NULL,1,NULL),(2173,2212,NULL,NULL,1,NULL),(2174,2224,NULL,NULL,1,NULL),(2175,2231,NULL,NULL,1,NULL),(2176,2240,NULL,NULL,1,NULL),(2177,2251,NULL,NULL,1,NULL),(2178,2259,NULL,NULL,1,NULL),(2179,2269,NULL,NULL,1,NULL),(2180,2276,NULL,NULL,1,NULL),(2181,2286,NULL,NULL,1,NULL),(2182,2292,NULL,NULL,1,NULL),(2183,2300,NULL,NULL,1,NULL),(2184,2306,NULL,NULL,1,NULL),(2185,2149,NULL,NULL,1,NULL),(2186,2150,NULL,NULL,1,NULL),(2187,2151,NULL,NULL,1,NULL),(2188,2152,NULL,NULL,1,NULL),(2189,2153,NULL,NULL,1,NULL),(2190,2154,NULL,NULL,1,NULL),(2191,2155,NULL,NULL,1,NULL),(2192,2156,NULL,NULL,1,NULL),(2193,2157,NULL,NULL,1,NULL),(2194,2158,NULL,NULL,1,NULL),(2195,2159,NULL,NULL,1,NULL),(2196,2160,NULL,NULL,1,NULL),(2197,2161,NULL,NULL,1,NULL),(2198,2163,NULL,NULL,1,NULL),(2199,2164,NULL,NULL,1,NULL),(2200,2165,NULL,NULL,1,NULL),(2201,2166,NULL,NULL,1,NULL),(2202,2167,NULL,NULL,1,NULL),(2203,2168,NULL,NULL,1,NULL),(2204,2169,NULL,NULL,1,NULL),(2205,2171,NULL,NULL,1,NULL),(2206,2172,NULL,NULL,1,NULL),(2207,2173,NULL,NULL,1,NULL),(2208,2174,NULL,NULL,1,NULL),(2209,2175,NULL,NULL,1,NULL),(2210,2176,NULL,NULL,1,NULL),(2211,2178,NULL,NULL,1,NULL),(2212,2180,NULL,NULL,1,NULL),(2213,2181,NULL,NULL,1,NULL),(2214,2182,NULL,NULL,1,NULL),(2215,2183,NULL,NULL,1,NULL),(2216,2185,NULL,NULL,1,NULL),(2217,2186,NULL,NULL,1,NULL),(2218,2187,NULL,NULL,1,NULL),(2219,2188,NULL,NULL,1,NULL),(2220,2189,NULL,NULL,1,NULL),(2221,2190,NULL,NULL,1,NULL),(2222,2192,NULL,NULL,1,NULL),(2223,2193,NULL,NULL,1,NULL),(2224,2194,NULL,NULL,1,NULL),(2225,2195,NULL,NULL,1,NULL),(2226,2196,NULL,NULL,1,NULL),(2227,2197,NULL,NULL,1,NULL),(2228,2199,NULL,NULL,1,NULL),(2229,2200,NULL,NULL,1,NULL),(2230,2201,NULL,NULL,1,NULL),(2231,2202,NULL,NULL,1,NULL),(2232,2204,NULL,NULL,1,NULL),(2233,2205,NULL,NULL,1,NULL),(2234,2206,NULL,NULL,1,NULL),(2235,2207,NULL,NULL,1,NULL),(2236,2208,NULL,NULL,1,NULL),(2237,2209,NULL,NULL,1,NULL),(2238,2210,NULL,NULL,1,NULL),(2239,2211,NULL,NULL,1,NULL),(2240,2213,NULL,NULL,1,NULL),(2241,2214,NULL,NULL,1,NULL),(2242,2215,NULL,NULL,1,NULL),(2243,2216,NULL,NULL,1,NULL),(2244,2217,NULL,NULL,1,NULL),(2245,2218,NULL,NULL,1,NULL),(2246,2219,NULL,NULL,1,NULL),(2247,2220,NULL,NULL,1,NULL),(2248,2221,NULL,NULL,1,NULL),(2249,2222,NULL,NULL,1,NULL),(2250,2223,NULL,NULL,1,NULL),(2251,2225,NULL,NULL,1,NULL),(2252,2226,NULL,NULL,1,NULL),(2253,2227,NULL,NULL,1,NULL),(2254,2228,NULL,NULL,1,NULL),(2255,2229,NULL,NULL,1,NULL),(2256,2230,NULL,NULL,1,NULL),(2257,2232,NULL,NULL,1,NULL),(2258,2233,NULL,NULL,1,NULL),(2259,2234,NULL,NULL,1,NULL),(2260,2235,NULL,NULL,1,NULL),(2261,2236,NULL,NULL,1,NULL),(2262,2237,NULL,NULL,1,NULL),(2263,2238,NULL,NULL,1,NULL),(2264,2239,NULL,NULL,1,NULL),(2265,2241,NULL,NULL,1,NULL),(2266,2242,NULL,NULL,1,NULL),(2267,2243,NULL,NULL,1,NULL),(2268,2244,NULL,NULL,1,NULL),(2269,2245,NULL,NULL,1,NULL),(2270,2246,NULL,NULL,1,NULL),(2271,2247,NULL,NULL,1,NULL),(2272,2248,NULL,NULL,1,NULL),(2273,2249,NULL,NULL,1,NULL),(2274,2250,NULL,NULL,1,NULL),(2275,2252,NULL,NULL,1,NULL),(2276,2253,NULL,NULL,1,NULL),(2277,2254,NULL,NULL,1,NULL),(2278,2255,NULL,NULL,1,NULL),(2279,2256,NULL,NULL,1,NULL),(2280,2257,NULL,NULL,1,NULL),(2281,2258,NULL,NULL,1,NULL),(2282,2260,NULL,NULL,1,NULL),(2283,2261,NULL,NULL,1,NULL),(2284,2262,NULL,NULL,1,NULL),(2285,2263,NULL,NULL,1,NULL),(2286,2264,NULL,NULL,1,NULL),(2287,2265,NULL,NULL,1,NULL),(2288,2266,NULL,NULL,1,NULL),(2289,2267,NULL,NULL,1,NULL),(2290,2268,NULL,NULL,1,NULL),(2291,2270,NULL,NULL,1,NULL),(2292,2271,NULL,NULL,1,NULL),(2293,2272,NULL,NULL,1,NULL),(2294,2273,NULL,NULL,1,NULL),(2295,2274,NULL,NULL,1,NULL),(2296,2275,NULL,NULL,1,NULL),(2297,2277,NULL,NULL,1,NULL),(2298,2278,NULL,NULL,1,NULL),(2299,2279,NULL,NULL,1,NULL),(2300,2280,NULL,NULL,1,NULL),(2301,2281,NULL,NULL,1,NULL),(2302,2282,NULL,NULL,1,NULL),(2303,2283,NULL,NULL,1,NULL),(2304,2284,NULL,NULL,1,NULL),(2305,2285,NULL,NULL,1,NULL),(2306,2287,NULL,NULL,1,NULL),(2307,2288,NULL,NULL,1,NULL),(2308,2289,NULL,NULL,1,NULL),(2309,2290,NULL,NULL,1,NULL),(2310,2291,NULL,NULL,1,NULL),(2311,2293,NULL,NULL,1,NULL),(2312,2294,NULL,NULL,1,NULL),(2313,2295,NULL,NULL,1,NULL),(2314,2296,NULL,NULL,1,NULL),(2315,2297,NULL,NULL,1,NULL),(2316,2298,NULL,NULL,1,NULL),(2317,2299,NULL,NULL,1,NULL),(2318,2301,NULL,NULL,1,NULL),(2319,2302,NULL,NULL,1,NULL),(2320,2303,NULL,NULL,1,NULL),(2321,2304,NULL,NULL,1,NULL),(2322,2305,NULL,NULL,1,NULL),(2323,2307,NULL,NULL,1,NULL),(2324,2308,NULL,NULL,1,NULL),(2325,2309,NULL,NULL,1,NULL),(2326,2310,NULL,NULL,1,NULL),(2327,2311,NULL,NULL,1,NULL),(2328,2312,NULL,NULL,1,NULL),(2329,2313,NULL,NULL,1,NULL),(2330,2314,NULL,NULL,1,NULL),(2331,2315,NULL,NULL,1,NULL),(2332,2317,NULL,NULL,1,NULL),(2333,2331,NULL,NULL,1,NULL),(2334,2343,NULL,NULL,1,NULL),(2335,2362,NULL,NULL,1,NULL),(2336,2371,NULL,NULL,1,NULL),(2337,2377,NULL,NULL,1,NULL),(2338,2383,NULL,NULL,1,NULL),(2339,2389,NULL,NULL,1,NULL),(2340,2396,NULL,NULL,1,NULL),(2341,2404,NULL,NULL,1,NULL),(2342,2418,NULL,NULL,1,NULL),(2343,2424,NULL,NULL,1,NULL),(2344,2437,NULL,NULL,1,NULL),(2345,2445,NULL,NULL,1,NULL),(2346,2454,NULL,NULL,1,NULL),(2347,2318,NULL,NULL,1,NULL),(2348,2319,NULL,NULL,1,NULL),(2349,2320,NULL,NULL,1,NULL),(2350,2321,NULL,NULL,1,NULL),(2351,2322,NULL,NULL,1,NULL),(2352,2323,NULL,NULL,1,NULL),(2353,2324,NULL,NULL,1,NULL),(2354,2325,NULL,NULL,1,NULL),(2355,2326,NULL,NULL,1,NULL),(2356,2327,NULL,NULL,1,NULL),(2357,2328,NULL,NULL,1,NULL),(2358,2329,NULL,NULL,1,NULL),(2359,2330,NULL,NULL,1,NULL),(2360,2332,NULL,NULL,1,NULL),(2361,2333,NULL,NULL,1,NULL),(2362,2334,NULL,NULL,1,NULL),(2363,2335,NULL,NULL,1,NULL),(2364,2336,NULL,NULL,1,NULL),(2365,2337,NULL,NULL,1,NULL),(2366,2338,NULL,NULL,1,NULL),(2367,2339,NULL,NULL,1,NULL),(2368,2340,NULL,NULL,1,NULL),(2369,2341,NULL,NULL,1,NULL),(2370,2342,NULL,NULL,1,NULL),(2371,2344,NULL,NULL,1,NULL),(2372,2345,NULL,NULL,1,NULL),(2373,2346,NULL,NULL,1,NULL),(2374,2347,NULL,NULL,1,NULL),(2375,2348,NULL,NULL,1,NULL),(2376,2349,NULL,NULL,1,NULL),(2377,2350,NULL,NULL,1,NULL),(2378,2351,NULL,NULL,1,NULL),(2379,2352,NULL,NULL,1,NULL),(2380,2353,NULL,NULL,1,NULL),(2381,2354,NULL,NULL,1,NULL),(2382,2355,NULL,NULL,1,NULL),(2383,2356,NULL,NULL,1,NULL),(2384,2357,NULL,NULL,1,NULL),(2385,2358,NULL,NULL,1,NULL),(2386,2359,NULL,NULL,1,NULL),(2387,2360,NULL,NULL,1,NULL),(2388,2361,NULL,NULL,1,NULL),(2389,2363,NULL,NULL,1,NULL),(2390,2364,NULL,NULL,1,NULL),(2391,2365,NULL,NULL,1,NULL),(2392,2366,NULL,NULL,1,NULL),(2393,2367,NULL,NULL,1,NULL),(2394,2368,NULL,NULL,1,NULL),(2395,2369,NULL,NULL,1,NULL),(2396,2370,NULL,NULL,1,NULL),(2397,2372,NULL,NULL,1,NULL),(2398,2373,NULL,NULL,1,NULL),(2399,2374,NULL,NULL,1,NULL),(2400,2375,NULL,NULL,1,NULL),(2401,2376,NULL,NULL,1,NULL),(2402,2378,NULL,NULL,1,NULL),(2403,2379,NULL,NULL,1,NULL),(2404,2380,NULL,NULL,1,NULL),(2405,2381,NULL,NULL,1,NULL),(2406,2382,NULL,NULL,1,NULL),(2407,2384,NULL,NULL,1,NULL),(2408,2385,NULL,NULL,1,NULL),(2409,2386,NULL,NULL,1,NULL),(2410,2387,NULL,NULL,1,NULL),(2411,2388,NULL,NULL,1,NULL),(2412,2390,NULL,NULL,1,NULL),(2413,2391,NULL,NULL,1,NULL),(2414,2392,NULL,NULL,1,NULL),(2415,2393,NULL,NULL,1,NULL),(2416,2394,NULL,NULL,1,NULL),(2417,2395,NULL,NULL,1,NULL),(2418,2397,NULL,NULL,1,NULL),(2419,2398,NULL,NULL,1,NULL),(2420,2399,NULL,NULL,1,NULL),(2421,2400,NULL,NULL,1,NULL),(2422,2401,NULL,NULL,1,NULL),(2423,2402,NULL,NULL,1,NULL),(2424,2403,NULL,NULL,1,NULL),(2425,2405,NULL,NULL,1,NULL),(2426,2406,NULL,NULL,1,NULL),(2427,2407,NULL,NULL,1,NULL),(2428,2408,NULL,NULL,1,NULL),(2429,2409,NULL,NULL,1,NULL),(2430,2410,NULL,NULL,1,NULL),(2431,2411,NULL,NULL,1,NULL),(2432,2412,NULL,NULL,1,NULL),(2433,2413,NULL,NULL,1,NULL),(2434,2414,NULL,NULL,1,NULL),(2435,2415,NULL,NULL,1,NULL),(2436,2416,NULL,NULL,1,NULL),(2437,2417,NULL,NULL,1,NULL),(2438,2419,NULL,NULL,1,NULL),(2439,2420,NULL,NULL,1,NULL),(2440,2421,NULL,NULL,1,NULL),(2441,2422,NULL,NULL,1,NULL),(2442,2423,NULL,NULL,1,NULL),(2443,2425,NULL,NULL,1,NULL),(2444,2426,NULL,NULL,1,NULL),(2445,2427,NULL,NULL,1,NULL),(2446,2428,NULL,NULL,1,NULL),(2447,2429,NULL,NULL,1,NULL),(2448,2430,NULL,NULL,1,NULL),(2449,2431,NULL,NULL,1,NULL),(2450,2432,NULL,NULL,1,NULL),(2451,2433,NULL,NULL,1,NULL),(2452,2434,NULL,NULL,1,NULL),(2453,2435,NULL,NULL,1,NULL),(2454,2436,NULL,NULL,1,NULL),(2455,2438,NULL,NULL,1,NULL),(2456,2439,NULL,NULL,1,NULL),(2457,2440,NULL,NULL,1,NULL),(2458,2441,NULL,NULL,1,NULL),(2459,2442,NULL,NULL,1,NULL),(2460,2443,NULL,NULL,1,NULL),(2461,2444,NULL,NULL,1,NULL),(2462,2446,NULL,NULL,1,NULL),(2463,2447,NULL,NULL,1,NULL),(2464,2448,NULL,NULL,1,NULL),(2465,2449,NULL,NULL,1,NULL),(2466,2450,NULL,NULL,1,NULL),(2467,2451,NULL,NULL,1,NULL),(2468,2452,NULL,NULL,1,NULL),(2469,2453,NULL,NULL,1,NULL),(2470,2455,NULL,NULL,1,NULL),(2471,2457,NULL,NULL,1,NULL),(2472,2463,NULL,NULL,1,NULL),(2473,2466,NULL,NULL,1,NULL),(2474,2468,NULL,NULL,1,NULL),(2475,2470,NULL,NULL,1,NULL),(2476,2472,NULL,NULL,1,NULL),(2477,2474,NULL,NULL,1,NULL),(2478,2476,NULL,NULL,1,NULL),(2479,2478,NULL,NULL,1,NULL),(2480,2480,NULL,NULL,1,NULL),(2481,2482,NULL,NULL,1,NULL),(2482,2484,NULL,NULL,1,NULL),(2483,2486,NULL,NULL,1,NULL),(2484,2488,NULL,NULL,1,NULL),(2485,2490,NULL,NULL,1,NULL),(2486,2492,NULL,NULL,1,NULL),(2487,2494,NULL,NULL,1,NULL),(2488,2496,NULL,NULL,1,NULL),(2489,2498,NULL,NULL,1,NULL),(2490,2458,NULL,NULL,1,NULL),(2491,2459,NULL,NULL,1,NULL),(2492,2460,NULL,NULL,1,NULL),(2493,2461,NULL,NULL,1,NULL),(2494,2462,NULL,NULL,1,NULL),(2495,2464,NULL,NULL,1,NULL),(2496,2465,NULL,NULL,1,NULL),(2497,2467,NULL,NULL,1,NULL),(2498,2469,NULL,NULL,1,NULL),(2499,2471,NULL,NULL,1,NULL),(2500,2473,NULL,NULL,1,NULL),(2501,2475,NULL,NULL,1,NULL),(2502,2477,NULL,NULL,1,NULL),(2503,2479,NULL,NULL,1,NULL),(2504,2481,NULL,NULL,1,NULL),(2505,2483,NULL,NULL,1,NULL),(2506,2485,NULL,NULL,1,NULL),(2507,2487,NULL,NULL,1,NULL),(2508,2489,NULL,NULL,1,NULL),(2509,2491,NULL,NULL,1,NULL),(2510,2493,NULL,NULL,1,NULL),(2511,2495,NULL,NULL,1,NULL),(2512,2497,NULL,NULL,1,NULL),(2513,2499,NULL,NULL,1,NULL),(2514,2501,NULL,NULL,1,NULL),(2515,2502,NULL,NULL,1,NULL),(2516,2503,NULL,NULL,1,NULL),(2517,2504,NULL,NULL,1,NULL),(2518,2505,NULL,NULL,1,NULL),(2519,2506,NULL,NULL,1,NULL),(2520,2507,NULL,NULL,1,NULL),(2521,2508,NULL,NULL,1,NULL),(2522,2509,NULL,NULL,1,NULL),(2523,2510,NULL,NULL,1,NULL),(2524,2511,NULL,NULL,1,NULL),(2525,2512,NULL,NULL,1,NULL),(2526,2513,NULL,NULL,1,NULL),(2527,2514,NULL,NULL,1,NULL),(2528,2515,NULL,NULL,1,NULL),(2529,2516,NULL,NULL,1,NULL),(2530,2517,NULL,NULL,1,NULL),(2531,2518,NULL,NULL,1,NULL),(2532,2519,NULL,NULL,1,NULL),(2533,2520,NULL,NULL,1,NULL),(2534,2521,NULL,NULL,1,NULL),(2535,2522,NULL,NULL,1,NULL),(2536,2523,NULL,NULL,1,NULL),(2537,2524,NULL,NULL,1,NULL),(2538,2525,NULL,NULL,1,NULL),(2539,2526,NULL,NULL,1,NULL),(2540,2527,NULL,NULL,1,NULL),(2541,2528,NULL,NULL,1,NULL),(2542,2529,NULL,NULL,1,NULL),(2543,2530,NULL,NULL,1,NULL),(2544,2531,NULL,NULL,1,NULL),(2545,2532,NULL,NULL,1,NULL),(2546,2533,NULL,NULL,1,NULL),(2547,2534,NULL,NULL,1,NULL),(2548,2535,NULL,NULL,1,NULL),(2549,2536,NULL,NULL,1,NULL),(2550,2537,NULL,NULL,1,NULL),(2551,2538,NULL,NULL,1,NULL),(2552,2539,NULL,NULL,1,NULL),(2553,2540,NULL,NULL,1,NULL),(2554,2541,NULL,NULL,1,NULL),(2555,2542,NULL,NULL,1,NULL),(2556,2544,NULL,NULL,1,NULL),(2557,2565,NULL,NULL,1,NULL),(2558,2573,NULL,NULL,1,NULL),(2559,2580,NULL,NULL,1,NULL),(2560,2589,NULL,NULL,1,NULL),(2561,2597,NULL,NULL,1,NULL),(2562,2608,NULL,NULL,1,NULL),(2563,2617,NULL,NULL,1,NULL),(2564,2624,NULL,NULL,1,NULL),(2565,2631,NULL,NULL,1,NULL),(2566,2644,NULL,NULL,1,NULL),(2567,2655,NULL,NULL,1,NULL),(2568,2663,NULL,NULL,1,NULL),(2569,2675,NULL,NULL,1,NULL),(2570,2682,NULL,NULL,1,NULL),(2571,2691,NULL,NULL,1,NULL),(2572,2701,NULL,NULL,1,NULL),(2573,2707,NULL,NULL,1,NULL),(2574,2713,NULL,NULL,1,NULL),(2575,2728,NULL,NULL,1,NULL),(2576,2748,NULL,NULL,1,NULL),(2577,2767,NULL,NULL,1,NULL),(2578,2545,NULL,NULL,1,NULL),(2579,2546,NULL,NULL,1,NULL),(2580,2547,NULL,NULL,1,NULL),(2581,2548,NULL,NULL,1,NULL),(2582,2549,NULL,NULL,1,NULL),(2583,2550,NULL,NULL,1,NULL),(2584,2551,NULL,NULL,1,NULL),(2585,2552,NULL,NULL,1,NULL),(2586,2553,NULL,NULL,1,NULL),(2587,2554,NULL,NULL,1,NULL),(2588,2555,NULL,NULL,1,NULL),(2589,2556,NULL,NULL,1,NULL),(2590,2557,NULL,NULL,1,NULL),(2591,2558,NULL,NULL,1,NULL),(2592,2559,NULL,NULL,1,NULL),(2593,2560,NULL,NULL,1,NULL),(2594,2561,NULL,NULL,1,NULL),(2595,2562,NULL,NULL,1,NULL),(2596,2563,NULL,NULL,1,NULL),(2597,2564,NULL,NULL,1,NULL),(2598,2566,NULL,NULL,1,NULL),(2599,2567,NULL,NULL,1,NULL),(2600,2568,NULL,NULL,1,NULL),(2601,2569,NULL,NULL,1,NULL),(2602,2570,NULL,NULL,1,NULL),(2603,2571,NULL,NULL,1,NULL),(2604,2572,NULL,NULL,1,NULL),(2605,2574,NULL,NULL,1,NULL),(2606,2575,NULL,NULL,1,NULL),(2607,2576,NULL,NULL,1,NULL),(2608,2577,NULL,NULL,1,NULL),(2609,2578,NULL,NULL,1,NULL),(2610,2579,NULL,NULL,1,NULL),(2611,2581,NULL,NULL,1,NULL),(2612,2582,NULL,NULL,1,NULL),(2613,2583,NULL,NULL,1,NULL),(2614,2584,NULL,NULL,1,NULL),(2615,2585,NULL,NULL,1,NULL),(2616,2586,NULL,NULL,1,NULL),(2617,2587,NULL,NULL,1,NULL),(2618,2588,NULL,NULL,1,NULL),(2619,2590,NULL,NULL,1,NULL),(2620,2591,NULL,NULL,1,NULL),(2621,2592,NULL,NULL,1,NULL),(2622,2593,NULL,NULL,1,NULL),(2623,2594,NULL,NULL,1,NULL),(2624,2595,NULL,NULL,1,NULL),(2625,2596,NULL,NULL,1,NULL),(2626,2598,NULL,NULL,1,NULL),(2627,2599,NULL,NULL,1,NULL),(2628,2600,NULL,NULL,1,NULL),(2629,2601,NULL,NULL,1,NULL),(2630,2602,NULL,NULL,1,NULL),(2631,2603,NULL,NULL,1,NULL),(2632,2604,NULL,NULL,1,NULL),(2633,2605,NULL,NULL,1,NULL),(2634,2606,NULL,NULL,1,NULL),(2635,2607,NULL,NULL,1,NULL),(2636,2609,NULL,NULL,1,NULL),(2637,2610,NULL,NULL,1,NULL),(2638,2611,NULL,NULL,1,NULL),(2639,2612,NULL,NULL,1,NULL),(2640,2613,NULL,NULL,1,NULL),(2641,2614,NULL,NULL,1,NULL),(2642,2615,NULL,NULL,1,NULL),(2643,2616,NULL,NULL,1,NULL),(2644,2618,NULL,NULL,1,NULL),(2645,2619,NULL,NULL,1,NULL),(2646,2620,NULL,NULL,1,NULL),(2647,2621,NULL,NULL,1,NULL),(2648,2622,NULL,NULL,1,NULL),(2649,2623,NULL,NULL,1,NULL),(2650,2625,NULL,NULL,1,NULL),(2651,2626,NULL,NULL,1,NULL),(2652,2627,NULL,NULL,1,NULL),(2653,2628,NULL,NULL,1,NULL),(2654,2629,NULL,NULL,1,NULL),(2655,2630,NULL,NULL,1,NULL),(2656,2632,NULL,NULL,1,NULL),(2657,2633,NULL,NULL,1,NULL),(2658,2634,NULL,NULL,1,NULL),(2659,2635,NULL,NULL,1,NULL),(2660,2636,NULL,NULL,1,NULL),(2661,2637,NULL,NULL,1,NULL),(2662,2638,NULL,NULL,1,NULL),(2663,2639,NULL,NULL,1,NULL),(2664,2640,NULL,NULL,1,NULL),(2665,2641,NULL,NULL,1,NULL),(2666,2642,NULL,NULL,1,NULL),(2667,2643,NULL,NULL,1,NULL),(2668,2645,NULL,NULL,1,NULL),(2669,2646,NULL,NULL,1,NULL),(2670,2647,NULL,NULL,1,NULL),(2671,2648,NULL,NULL,1,NULL),(2672,2649,NULL,NULL,1,NULL),(2673,2650,NULL,NULL,1,NULL),(2674,2651,NULL,NULL,1,NULL),(2675,2652,NULL,NULL,1,NULL),(2676,2653,NULL,NULL,1,NULL),(2677,2654,NULL,NULL,1,NULL),(2678,2656,NULL,NULL,1,NULL),(2679,2657,NULL,NULL,1,NULL),(2680,2658,NULL,NULL,1,NULL),(2681,2659,NULL,NULL,1,NULL),(2682,2660,NULL,NULL,1,NULL),(2683,2661,NULL,NULL,1,NULL),(2684,2662,NULL,NULL,1,NULL),(2685,2664,NULL,NULL,1,NULL),(2686,2665,NULL,NULL,1,NULL),(2687,2666,NULL,NULL,1,NULL),(2688,2667,NULL,NULL,1,NULL),(2689,2668,NULL,NULL,1,NULL),(2690,2669,NULL,NULL,1,NULL),(2691,2670,NULL,NULL,1,NULL),(2692,2671,NULL,NULL,1,NULL),(2693,2672,NULL,NULL,1,NULL),(2694,2673,NULL,NULL,1,NULL),(2695,2674,NULL,NULL,1,NULL),(2696,2676,NULL,NULL,1,NULL),(2697,2677,NULL,NULL,1,NULL),(2698,2678,NULL,NULL,1,NULL),(2699,2679,NULL,NULL,1,NULL),(2700,2680,NULL,NULL,1,NULL),(2701,2681,NULL,NULL,1,NULL),(2702,2683,NULL,NULL,1,NULL),(2703,2684,NULL,NULL,1,NULL),(2704,2685,NULL,NULL,1,NULL),(2705,2686,NULL,NULL,1,NULL),(2706,2687,NULL,NULL,1,NULL),(2707,2688,NULL,NULL,1,NULL),(2708,2689,NULL,NULL,1,NULL),(2709,2690,NULL,NULL,1,NULL),(2710,2692,NULL,NULL,1,NULL),(2711,2693,NULL,NULL,1,NULL),(2712,2694,NULL,NULL,1,NULL),(2713,2695,NULL,NULL,1,NULL),(2714,2696,NULL,NULL,1,NULL),(2715,2697,NULL,NULL,1,NULL),(2716,2698,NULL,NULL,1,NULL),(2717,2699,NULL,NULL,1,NULL),(2718,2700,NULL,NULL,1,NULL),(2719,2702,NULL,NULL,1,NULL),(2720,2703,NULL,NULL,1,NULL),(2721,2704,NULL,NULL,1,NULL),(2722,2705,NULL,NULL,1,NULL),(2723,2706,NULL,NULL,1,NULL),(2724,2708,NULL,NULL,1,NULL),(2725,2709,NULL,NULL,1,NULL),(2726,2710,NULL,NULL,1,NULL),(2727,2711,NULL,NULL,1,NULL),(2728,2712,NULL,NULL,1,NULL),(2729,2714,NULL,NULL,1,NULL),(2730,2715,NULL,NULL,1,NULL),(2731,2716,NULL,NULL,1,NULL),(2732,2717,NULL,NULL,1,NULL),(2733,2718,NULL,NULL,1,NULL),(2734,2719,NULL,NULL,1,NULL),(2735,2720,NULL,NULL,1,NULL),(2736,2721,NULL,NULL,1,NULL),(2737,2722,NULL,NULL,1,NULL),(2738,2723,NULL,NULL,1,NULL),(2739,2724,NULL,NULL,1,NULL),(2740,2725,NULL,NULL,1,NULL),(2741,2726,NULL,NULL,1,NULL),(2742,2727,NULL,NULL,1,NULL),(2743,2729,NULL,NULL,1,NULL),(2744,2730,NULL,NULL,1,NULL),(2745,2731,NULL,NULL,1,NULL),(2746,2732,NULL,NULL,1,NULL),(2747,2733,NULL,NULL,1,NULL),(2748,2734,NULL,NULL,1,NULL),(2749,2735,NULL,NULL,1,NULL),(2750,2736,NULL,NULL,1,NULL),(2751,2737,NULL,NULL,1,NULL),(2752,2738,NULL,NULL,1,NULL),(2753,2739,NULL,NULL,1,NULL),(2754,2740,NULL,NULL,1,NULL),(2755,2741,NULL,NULL,1,NULL),(2756,2742,NULL,NULL,1,NULL),(2757,2743,NULL,NULL,1,NULL),(2758,2744,NULL,NULL,1,NULL),(2759,2745,NULL,NULL,1,NULL),(2760,2746,NULL,NULL,1,NULL),(2761,2747,NULL,NULL,1,NULL),(2762,2749,NULL,NULL,1,NULL),(2763,2750,NULL,NULL,1,NULL),(2764,2751,NULL,NULL,1,NULL),(2765,2752,NULL,NULL,1,NULL),(2766,2753,NULL,NULL,1,NULL),(2767,2754,NULL,NULL,1,NULL),(2768,2755,NULL,NULL,1,NULL),(2769,2756,NULL,NULL,1,NULL),(2770,2757,NULL,NULL,1,NULL),(2771,2758,NULL,NULL,1,NULL),(2772,2759,NULL,NULL,1,NULL),(2773,2760,NULL,NULL,1,NULL),(2774,2761,NULL,NULL,1,NULL),(2775,2762,NULL,NULL,1,NULL),(2776,2763,NULL,NULL,1,NULL),(2777,2764,NULL,NULL,1,NULL),(2778,2765,NULL,NULL,1,NULL),(2779,2766,NULL,NULL,1,NULL),(2780,2768,NULL,NULL,1,NULL),(2781,2770,NULL,NULL,1,NULL),(2782,2782,NULL,NULL,1,NULL),(2783,2788,NULL,NULL,1,NULL),(2784,2804,NULL,NULL,1,NULL),(2785,2812,NULL,NULL,1,NULL),(2786,2824,NULL,NULL,1,NULL),(2787,2834,NULL,NULL,1,NULL),(2788,2844,NULL,NULL,1,NULL),(2789,2862,NULL,NULL,1,NULL),(2790,2876,NULL,NULL,1,NULL),(2791,2771,NULL,NULL,1,NULL),(2792,2772,NULL,NULL,1,NULL),(2793,2773,NULL,NULL,1,NULL),(2794,2774,NULL,NULL,1,NULL),(2795,2775,NULL,NULL,1,NULL),(2796,2776,NULL,NULL,1,NULL),(2797,2777,NULL,NULL,1,NULL),(2798,2778,NULL,NULL,1,NULL),(2799,2779,NULL,NULL,1,NULL),(2800,2780,NULL,NULL,1,NULL),(2801,2781,NULL,NULL,1,NULL),(2802,2783,NULL,NULL,1,NULL),(2803,2784,NULL,NULL,1,NULL),(2804,2785,NULL,NULL,1,NULL),(2805,2786,NULL,NULL,1,NULL),(2806,2787,NULL,NULL,1,NULL),(2807,2789,NULL,NULL,1,NULL),(2808,2790,NULL,NULL,1,NULL),(2809,2791,NULL,NULL,1,NULL),(2810,2792,NULL,NULL,1,NULL),(2811,2793,NULL,NULL,1,NULL),(2812,2794,NULL,NULL,1,NULL),(2813,2795,NULL,NULL,1,NULL),(2814,2796,NULL,NULL,1,NULL),(2815,2797,NULL,NULL,1,NULL),(2816,2798,NULL,NULL,1,NULL),(2817,2799,NULL,NULL,1,NULL),(2818,2800,NULL,NULL,1,NULL),(2819,2801,NULL,NULL,1,NULL),(2820,2802,NULL,NULL,1,NULL),(2821,2803,NULL,NULL,1,NULL),(2822,2805,NULL,NULL,1,NULL),(2823,2806,NULL,NULL,1,NULL),(2824,2807,NULL,NULL,1,NULL),(2825,2808,NULL,NULL,1,NULL),(2826,2809,NULL,NULL,1,NULL),(2827,2810,NULL,NULL,1,NULL),(2828,2811,NULL,NULL,1,NULL),(2829,2813,NULL,NULL,1,NULL),(2830,2814,NULL,NULL,1,NULL),(2831,2815,NULL,NULL,1,NULL),(2832,2816,NULL,NULL,1,NULL),(2833,2817,NULL,NULL,1,NULL),(2834,2818,NULL,NULL,1,NULL),(2835,2819,NULL,NULL,1,NULL),(2836,2820,NULL,NULL,1,NULL),(2837,2821,NULL,NULL,1,NULL),(2838,2822,NULL,NULL,1,NULL),(2839,2823,NULL,NULL,1,NULL),(2840,2825,NULL,NULL,1,NULL),(2841,2826,NULL,NULL,1,NULL),(2842,2827,NULL,NULL,1,NULL),(2843,2828,NULL,NULL,1,NULL),(2844,2829,NULL,NULL,1,NULL),(2845,2830,NULL,NULL,1,NULL),(2846,2831,NULL,NULL,1,NULL),(2847,2832,NULL,NULL,1,NULL),(2848,2833,NULL,NULL,1,NULL),(2849,2835,NULL,NULL,1,NULL),(2850,2836,NULL,NULL,1,NULL),(2851,2837,NULL,NULL,1,NULL),(2852,2838,NULL,NULL,1,NULL),(2853,2839,NULL,NULL,1,NULL),(2854,2840,NULL,NULL,1,NULL),(2855,2841,NULL,NULL,1,NULL),(2856,2842,NULL,NULL,1,NULL),(2857,2843,NULL,NULL,1,NULL),(2858,2845,NULL,NULL,1,NULL),(2859,2846,NULL,NULL,1,NULL),(2860,2847,NULL,NULL,1,NULL),(2861,2848,NULL,NULL,1,NULL),(2862,2849,NULL,NULL,1,NULL),(2863,2850,NULL,NULL,1,NULL),(2864,2851,NULL,NULL,1,NULL),(2865,2852,NULL,NULL,1,NULL),(2866,2853,NULL,NULL,1,NULL),(2867,2854,NULL,NULL,1,NULL),(2868,2855,NULL,NULL,1,NULL),(2869,2856,NULL,NULL,1,NULL),(2870,2857,NULL,NULL,1,NULL),(2871,2858,NULL,NULL,1,NULL),(2872,2859,NULL,NULL,1,NULL),(2873,2860,NULL,NULL,1,NULL),(2874,2861,NULL,NULL,1,NULL),(2875,2863,NULL,NULL,1,NULL),(2876,2864,NULL,NULL,1,NULL),(2877,2865,NULL,NULL,1,NULL),(2878,2866,NULL,NULL,1,NULL),(2879,2867,NULL,NULL,1,NULL),(2880,2868,NULL,NULL,1,NULL),(2881,2869,NULL,NULL,1,NULL),(2882,2870,NULL,NULL,1,NULL),(2883,2871,NULL,NULL,1,NULL),(2884,2872,NULL,NULL,1,NULL),(2885,2873,NULL,NULL,1,NULL),(2886,2874,NULL,NULL,1,NULL),(2887,2875,NULL,NULL,1,NULL),(2888,2877,NULL,NULL,1,NULL),(2889,2879,NULL,NULL,1,NULL),(2890,2895,NULL,NULL,1,NULL),(2891,2906,NULL,NULL,1,NULL),(2892,2917,NULL,NULL,1,NULL),(2893,2924,NULL,NULL,1,NULL),(2894,2937,NULL,NULL,1,NULL),(2895,2944,NULL,NULL,1,NULL),(2896,2956,NULL,NULL,1,NULL),(2897,2966,NULL,NULL,1,NULL),(2898,2973,NULL,NULL,1,NULL),(2899,2979,NULL,NULL,1,NULL),(2900,2984,NULL,NULL,1,NULL),(2901,2998,NULL,NULL,1,NULL),(2902,3010,NULL,NULL,1,NULL),(2903,3025,NULL,NULL,1,NULL),(2904,3035,NULL,NULL,1,NULL),(2905,3040,NULL,NULL,1,NULL),(2906,2880,NULL,NULL,1,NULL),(2907,2881,NULL,NULL,1,NULL),(2908,2882,NULL,NULL,1,NULL),(2909,2883,NULL,NULL,1,NULL),(2910,2884,NULL,NULL,1,NULL),(2911,2885,NULL,NULL,1,NULL),(2912,2886,NULL,NULL,1,NULL),(2913,2887,NULL,NULL,1,NULL),(2914,2888,NULL,NULL,1,NULL),(2915,2889,NULL,NULL,1,NULL),(2916,2890,NULL,NULL,1,NULL),(2917,2891,NULL,NULL,1,NULL),(2918,2892,NULL,NULL,1,NULL),(2919,2893,NULL,NULL,1,NULL),(2920,2894,NULL,NULL,1,NULL),(2921,2896,NULL,NULL,1,NULL),(2922,2897,NULL,NULL,1,NULL),(2923,2898,NULL,NULL,1,NULL),(2924,2899,NULL,NULL,1,NULL),(2925,2900,NULL,NULL,1,NULL),(2926,2901,NULL,NULL,1,NULL),(2927,2902,NULL,NULL,1,NULL),(2928,2903,NULL,NULL,1,NULL),(2929,2904,NULL,NULL,1,NULL),(2930,2905,NULL,NULL,1,NULL),(2931,2907,NULL,NULL,1,NULL),(2932,2908,NULL,NULL,1,NULL),(2933,2909,NULL,NULL,1,NULL),(2934,2910,NULL,NULL,1,NULL),(2935,2911,NULL,NULL,1,NULL),(2936,2912,NULL,NULL,1,NULL),(2937,2913,NULL,NULL,1,NULL),(2938,2914,NULL,NULL,1,NULL),(2939,2915,NULL,NULL,1,NULL),(2940,2916,NULL,NULL,1,NULL),(2941,2918,NULL,NULL,1,NULL),(2942,2919,NULL,NULL,1,NULL),(2943,2920,NULL,NULL,1,NULL),(2944,2921,NULL,NULL,1,NULL),(2945,2922,NULL,NULL,1,NULL),(2946,2923,NULL,NULL,1,NULL),(2947,2925,NULL,NULL,1,NULL),(2948,2926,NULL,NULL,1,NULL),(2949,2927,NULL,NULL,1,NULL),(2950,2928,NULL,NULL,1,NULL),(2951,2929,NULL,NULL,1,NULL),(2952,2930,NULL,NULL,1,NULL),(2953,2931,NULL,NULL,1,NULL),(2954,2932,NULL,NULL,1,NULL),(2955,2933,NULL,NULL,1,NULL),(2956,2934,NULL,NULL,1,NULL),(2957,2935,NULL,NULL,1,NULL),(2958,2936,NULL,NULL,1,NULL),(2959,2938,NULL,NULL,1,NULL),(2960,2939,NULL,NULL,1,NULL),(2961,2940,NULL,NULL,1,NULL),(2962,2941,NULL,NULL,1,NULL),(2963,2942,NULL,NULL,1,NULL),(2964,2943,NULL,NULL,1,NULL),(2965,2945,NULL,NULL,1,NULL),(2966,2946,NULL,NULL,1,NULL),(2967,2947,NULL,NULL,1,NULL),(2968,2948,NULL,NULL,1,NULL),(2969,2949,NULL,NULL,1,NULL),(2970,2950,NULL,NULL,1,NULL),(2971,2951,NULL,NULL,1,NULL),(2972,2952,NULL,NULL,1,NULL),(2973,2953,NULL,NULL,1,NULL),(2974,2954,NULL,NULL,1,NULL),(2975,2955,NULL,NULL,1,NULL),(2976,2957,NULL,NULL,1,NULL),(2977,2958,NULL,NULL,1,NULL),(2978,2959,NULL,NULL,1,NULL),(2979,2960,NULL,NULL,1,NULL),(2980,2961,NULL,NULL,1,NULL),(2981,2962,NULL,NULL,1,NULL),(2982,2963,NULL,NULL,1,NULL),(2983,2964,NULL,NULL,1,NULL),(2984,2965,NULL,NULL,1,NULL),(2985,2967,NULL,NULL,1,NULL),(2986,2968,NULL,NULL,1,NULL),(2987,2969,NULL,NULL,1,NULL),(2988,2970,NULL,NULL,1,NULL),(2989,2971,NULL,NULL,1,NULL),(2990,2972,NULL,NULL,1,NULL),(2991,2974,NULL,NULL,1,NULL),(2992,2975,NULL,NULL,1,NULL),(2993,2976,NULL,NULL,1,NULL),(2994,2977,NULL,NULL,1,NULL),(2995,2978,NULL,NULL,1,NULL),(2996,2980,NULL,NULL,1,NULL),(2997,2981,NULL,NULL,1,NULL),(2998,2982,NULL,NULL,1,NULL),(2999,2983,NULL,NULL,1,NULL),(3000,2985,NULL,NULL,1,NULL),(3001,2986,NULL,NULL,1,NULL),(3002,2987,NULL,NULL,1,NULL),(3003,2988,NULL,NULL,1,NULL),(3004,2989,NULL,NULL,1,NULL),(3005,2990,NULL,NULL,1,NULL),(3006,2991,NULL,NULL,1,NULL),(3007,2992,NULL,NULL,1,NULL),(3008,2993,NULL,NULL,1,NULL),(3009,2994,NULL,NULL,1,NULL),(3010,2995,NULL,NULL,1,NULL),(3011,2996,NULL,NULL,1,NULL),(3012,2997,NULL,NULL,1,NULL),(3013,2999,NULL,NULL,1,NULL),(3014,3000,NULL,NULL,1,NULL),(3015,3001,NULL,NULL,1,NULL),(3016,3002,NULL,NULL,1,NULL),(3017,3003,NULL,NULL,1,NULL),(3018,3004,NULL,NULL,1,NULL),(3019,3005,NULL,NULL,1,NULL),(3020,3006,NULL,NULL,1,NULL),(3021,3007,NULL,NULL,1,NULL),(3022,3008,NULL,NULL,1,NULL),(3023,3009,NULL,NULL,1,NULL),(3024,3011,NULL,NULL,1,NULL),(3025,3012,NULL,NULL,1,NULL),(3026,3013,NULL,NULL,1,NULL),(3027,3014,NULL,NULL,1,NULL),(3028,3015,NULL,NULL,1,NULL),(3029,3016,NULL,NULL,1,NULL),(3030,3017,NULL,NULL,1,NULL),(3031,3018,NULL,NULL,1,NULL),(3032,3019,NULL,NULL,1,NULL),(3033,3020,NULL,NULL,1,NULL),(3034,3021,NULL,NULL,1,NULL),(3035,3022,NULL,NULL,1,NULL),(3036,3023,NULL,NULL,1,NULL),(3037,3024,NULL,NULL,1,NULL),(3038,3026,NULL,NULL,1,NULL),(3039,3027,NULL,NULL,1,NULL),(3040,3028,NULL,NULL,1,NULL),(3041,3029,NULL,NULL,1,NULL),(3042,3030,NULL,NULL,1,NULL),(3043,3031,NULL,NULL,1,NULL),(3044,3032,NULL,NULL,1,NULL),(3045,3033,NULL,NULL,1,NULL),(3046,3034,NULL,NULL,1,NULL),(3047,3036,NULL,NULL,1,NULL),(3048,3037,NULL,NULL,1,NULL),(3049,3038,NULL,NULL,1,NULL),(3050,3039,NULL,NULL,1,NULL),(3051,3041,NULL,NULL,1,NULL),(3052,3043,NULL,NULL,1,NULL),(3053,3053,NULL,NULL,1,NULL),(3054,3065,NULL,NULL,1,NULL),(3055,3078,NULL,NULL,1,NULL),(3056,3087,NULL,NULL,1,NULL),(3057,3101,NULL,NULL,1,NULL),(3058,3121,NULL,NULL,1,NULL),(3059,3130,NULL,NULL,1,NULL),(3060,3044,NULL,NULL,1,NULL),(3061,3045,NULL,NULL,1,NULL),(3062,3046,NULL,NULL,1,NULL),(3063,3047,NULL,NULL,1,NULL),(3064,3048,NULL,NULL,1,NULL),(3065,3049,NULL,NULL,1,NULL),(3066,3050,NULL,NULL,1,NULL),(3067,3051,NULL,NULL,1,NULL),(3068,3052,NULL,NULL,1,NULL),(3069,3054,NULL,NULL,1,NULL),(3070,3055,NULL,NULL,1,NULL),(3071,3056,NULL,NULL,1,NULL),(3072,3057,NULL,NULL,1,NULL),(3073,3058,NULL,NULL,1,NULL),(3074,3059,NULL,NULL,1,NULL),(3075,3060,NULL,NULL,1,NULL),(3076,3061,NULL,NULL,1,NULL),(3077,3062,NULL,NULL,1,NULL),(3078,3063,NULL,NULL,1,NULL),(3079,3064,NULL,NULL,1,NULL),(3080,3066,NULL,NULL,1,NULL),(3081,3067,NULL,NULL,1,NULL),(3082,3068,NULL,NULL,1,NULL),(3083,3069,NULL,NULL,1,NULL),(3084,3070,NULL,NULL,1,NULL),(3085,3071,NULL,NULL,1,NULL),(3086,3072,NULL,NULL,1,NULL),(3087,3073,NULL,NULL,1,NULL),(3088,3074,NULL,NULL,1,NULL),(3089,3075,NULL,NULL,1,NULL),(3090,3076,NULL,NULL,1,NULL),(3091,3077,NULL,NULL,1,NULL),(3092,3079,NULL,NULL,1,NULL),(3093,3080,NULL,NULL,1,NULL),(3094,3081,NULL,NULL,1,NULL),(3095,3082,NULL,NULL,1,NULL),(3096,3083,NULL,NULL,1,NULL),(3097,3084,NULL,NULL,1,NULL),(3098,3085,NULL,NULL,1,NULL),(3099,3086,NULL,NULL,1,NULL),(3100,3088,NULL,NULL,1,NULL),(3101,3089,NULL,NULL,1,NULL),(3102,3090,NULL,NULL,1,NULL),(3103,3091,NULL,NULL,1,NULL),(3104,3092,NULL,NULL,1,NULL),(3105,3093,NULL,NULL,1,NULL),(3106,3094,NULL,NULL,1,NULL),(3107,3095,NULL,NULL,1,NULL),(3108,3096,NULL,NULL,1,NULL),(3109,3097,NULL,NULL,1,NULL),(3110,3098,NULL,NULL,1,NULL),(3111,3099,NULL,NULL,1,NULL),(3112,3100,NULL,NULL,1,NULL),(3113,3102,NULL,NULL,1,NULL),(3114,3103,NULL,NULL,1,NULL),(3115,3104,NULL,NULL,1,NULL),(3116,3105,NULL,NULL,1,NULL),(3117,3106,NULL,NULL,1,NULL),(3118,3107,NULL,NULL,1,NULL),(3119,3108,NULL,NULL,1,NULL),(3120,3109,NULL,NULL,1,NULL),(3121,3110,NULL,NULL,1,NULL),(3122,3111,NULL,NULL,1,NULL),(3123,3112,NULL,NULL,1,NULL),(3124,3113,NULL,NULL,1,NULL),(3125,3114,NULL,NULL,1,NULL),(3126,3115,NULL,NULL,1,NULL),(3127,3116,NULL,NULL,1,NULL),(3128,3117,NULL,NULL,1,NULL),(3129,3118,NULL,NULL,1,NULL),(3130,3119,NULL,NULL,1,NULL),(3131,3120,NULL,NULL,1,NULL),(3132,3122,NULL,NULL,1,NULL),(3133,3123,NULL,NULL,1,NULL),(3134,3124,NULL,NULL,1,NULL),(3135,3125,NULL,NULL,1,NULL),(3136,3126,NULL,NULL,1,NULL),(3137,3127,NULL,NULL,1,NULL),(3138,3128,NULL,NULL,1,NULL),(3139,3129,NULL,NULL,1,NULL),(3140,3131,NULL,NULL,1,NULL),(3141,3133,NULL,NULL,1,NULL),(3142,3148,NULL,NULL,1,NULL),(3143,3154,NULL,NULL,1,NULL),(3144,3168,NULL,NULL,1,NULL),(3145,3184,NULL,NULL,1,NULL),(3146,3197,NULL,NULL,1,NULL),(3147,3212,NULL,NULL,1,NULL),(3148,3225,NULL,NULL,1,NULL),(3149,3239,NULL,NULL,1,NULL),(3150,3251,NULL,NULL,1,NULL),(3151,3260,NULL,NULL,1,NULL),(3152,3134,NULL,NULL,1,NULL),(3153,3135,NULL,NULL,1,NULL),(3154,3136,NULL,NULL,1,NULL),(3155,3137,NULL,NULL,1,NULL),(3156,3138,NULL,NULL,1,NULL),(3157,3139,NULL,NULL,1,NULL),(3158,3140,NULL,NULL,1,NULL),(3159,3141,NULL,NULL,1,NULL),(3160,3142,NULL,NULL,1,NULL),(3161,3143,NULL,NULL,1,NULL),(3162,3144,NULL,NULL,1,NULL),(3163,3145,NULL,NULL,1,NULL),(3164,3146,NULL,NULL,1,NULL),(3165,3147,NULL,NULL,1,NULL),(3166,3149,NULL,NULL,1,NULL),(3167,3150,NULL,NULL,1,NULL),(3168,3151,NULL,NULL,1,NULL),(3169,3152,NULL,NULL,1,NULL),(3170,3153,NULL,NULL,1,NULL),(3171,3155,NULL,NULL,1,NULL),(3172,3156,NULL,NULL,1,NULL),(3173,3157,NULL,NULL,1,NULL),(3174,3158,NULL,NULL,1,NULL),(3175,3159,NULL,NULL,1,NULL),(3176,3160,NULL,NULL,1,NULL),(3177,3161,NULL,NULL,1,NULL),(3178,3162,NULL,NULL,1,NULL),(3179,3163,NULL,NULL,1,NULL),(3180,3164,NULL,NULL,1,NULL),(3181,3165,NULL,NULL,1,NULL),(3182,3166,NULL,NULL,1,NULL),(3183,3167,NULL,NULL,1,NULL),(3184,3169,NULL,NULL,1,NULL),(3185,3170,NULL,NULL,1,NULL),(3186,3171,NULL,NULL,1,NULL),(3187,3172,NULL,NULL,1,NULL),(3188,3173,NULL,NULL,1,NULL),(3189,3174,NULL,NULL,1,NULL),(3190,3175,NULL,NULL,1,NULL),(3191,3176,NULL,NULL,1,NULL),(3192,3177,NULL,NULL,1,NULL),(3193,3178,NULL,NULL,1,NULL),(3194,3179,NULL,NULL,1,NULL),(3195,3180,NULL,NULL,1,NULL),(3196,3181,NULL,NULL,1,NULL),(3197,3182,NULL,NULL,1,NULL),(3198,3183,NULL,NULL,1,NULL),(3199,3185,NULL,NULL,1,NULL),(3200,3186,NULL,NULL,1,NULL),(3201,3187,NULL,NULL,1,NULL),(3202,3188,NULL,NULL,1,NULL),(3203,3189,NULL,NULL,1,NULL),(3204,3190,NULL,NULL,1,NULL),(3205,3191,NULL,NULL,1,NULL),(3206,3192,NULL,NULL,1,NULL),(3207,3193,NULL,NULL,1,NULL),(3208,3194,NULL,NULL,1,NULL),(3209,3195,NULL,NULL,1,NULL),(3210,3196,NULL,NULL,1,NULL),(3211,3198,NULL,NULL,1,NULL),(3212,3199,NULL,NULL,1,NULL),(3213,3200,NULL,NULL,1,NULL),(3214,3201,NULL,NULL,1,NULL),(3215,3202,NULL,NULL,1,NULL),(3216,3203,NULL,NULL,1,NULL),(3217,3204,NULL,NULL,1,NULL),(3218,3205,NULL,NULL,1,NULL),(3219,3206,NULL,NULL,1,NULL),(3220,3207,NULL,NULL,1,NULL),(3221,3208,NULL,NULL,1,NULL),(3222,3209,NULL,NULL,1,NULL),(3223,3210,NULL,NULL,1,NULL),(3224,3211,NULL,NULL,1,NULL),(3225,3213,NULL,NULL,1,NULL),(3226,3214,NULL,NULL,1,NULL),(3227,3215,NULL,NULL,1,NULL),(3228,3216,NULL,NULL,1,NULL),(3229,3217,NULL,NULL,1,NULL),(3230,3218,NULL,NULL,1,NULL),(3231,3219,NULL,NULL,1,NULL),(3232,3220,NULL,NULL,1,NULL),(3233,3221,NULL,NULL,1,NULL),(3234,3222,NULL,NULL,1,NULL),(3235,3223,NULL,NULL,1,NULL),(3236,3224,NULL,NULL,1,NULL),(3237,3226,NULL,NULL,1,NULL),(3238,3227,NULL,NULL,1,NULL),(3239,3228,NULL,NULL,1,NULL),(3240,3229,NULL,NULL,1,NULL),(3241,3230,NULL,NULL,1,NULL),(3242,3231,NULL,NULL,1,NULL),(3243,3232,NULL,NULL,1,NULL),(3244,3233,NULL,NULL,1,NULL),(3245,3234,NULL,NULL,1,NULL),(3246,3235,NULL,NULL,1,NULL),(3247,3236,NULL,NULL,1,NULL),(3248,3237,NULL,NULL,1,NULL),(3249,3238,NULL,NULL,1,NULL),(3250,3240,NULL,NULL,1,NULL),(3251,3241,NULL,NULL,1,NULL),(3252,3242,NULL,NULL,1,NULL),(3253,3243,NULL,NULL,1,NULL),(3254,3244,NULL,NULL,1,NULL),(3255,3245,NULL,NULL,1,NULL),(3256,3246,NULL,NULL,1,NULL),(3257,3247,NULL,NULL,1,NULL),(3258,3248,NULL,NULL,1,NULL),(3259,3249,NULL,NULL,1,NULL),(3260,3250,NULL,NULL,1,NULL),(3261,3252,NULL,NULL,1,NULL),(3262,3253,NULL,NULL,1,NULL),(3263,3254,NULL,NULL,1,NULL),(3264,3255,NULL,NULL,1,NULL),(3265,3256,NULL,NULL,1,NULL),(3266,3257,NULL,NULL,1,NULL),(3267,3258,NULL,NULL,1,NULL),(3268,3259,NULL,NULL,1,NULL),(3269,3261,NULL,NULL,1,NULL),(3270,3263,NULL,NULL,1,NULL),(3271,3273,NULL,NULL,1,NULL),(3272,3276,NULL,NULL,1,NULL),(3273,3280,NULL,NULL,1,NULL),(3274,3287,NULL,NULL,1,NULL),(3275,3296,NULL,NULL,1,NULL),(3276,3302,NULL,NULL,1,NULL),(3277,3311,NULL,NULL,1,NULL),(3278,3319,NULL,NULL,1,NULL),(3279,3329,NULL,NULL,1,NULL),(3280,3338,NULL,NULL,1,NULL),(3281,3347,NULL,NULL,1,NULL),(3282,3358,NULL,NULL,1,NULL),(3283,3368,NULL,NULL,1,NULL),(3284,3378,NULL,NULL,1,NULL),(3285,3264,NULL,NULL,1,NULL),(3286,3265,NULL,NULL,1,NULL),(3287,3266,NULL,NULL,1,NULL),(3288,3267,NULL,NULL,1,NULL),(3289,3268,NULL,NULL,1,NULL),(3290,3269,NULL,NULL,1,NULL),(3291,3270,NULL,NULL,1,NULL),(3292,3271,NULL,NULL,1,NULL),(3293,3272,NULL,NULL,1,NULL),(3294,3274,NULL,NULL,1,NULL),(3295,3275,NULL,NULL,1,NULL),(3296,3277,NULL,NULL,1,NULL),(3297,3278,NULL,NULL,1,NULL),(3298,3279,NULL,NULL,1,NULL),(3299,3281,NULL,NULL,1,NULL),(3300,3282,NULL,NULL,1,NULL),(3301,3283,NULL,NULL,1,NULL),(3302,3284,NULL,NULL,1,NULL),(3303,3285,NULL,NULL,1,NULL),(3304,3286,NULL,NULL,1,NULL),(3305,3288,NULL,NULL,1,NULL),(3306,3289,NULL,NULL,1,NULL),(3307,3290,NULL,NULL,1,NULL),(3308,3291,NULL,NULL,1,NULL),(3309,3292,NULL,NULL,1,NULL),(3310,3293,NULL,NULL,1,NULL),(3311,3294,NULL,NULL,1,NULL),(3312,3295,NULL,NULL,1,NULL),(3313,3297,NULL,NULL,1,NULL),(3314,3298,NULL,NULL,1,NULL),(3315,3299,NULL,NULL,1,NULL),(3316,3300,NULL,NULL,1,NULL),(3317,3301,NULL,NULL,1,NULL),(3318,3303,NULL,NULL,1,NULL),(3319,3304,NULL,NULL,1,NULL),(3320,3305,NULL,NULL,1,NULL),(3321,3306,NULL,NULL,1,NULL),(3322,3307,NULL,NULL,1,NULL),(3323,3308,NULL,NULL,1,NULL),(3324,3309,NULL,NULL,1,NULL),(3325,3310,NULL,NULL,1,NULL),(3326,3312,NULL,NULL,1,NULL),(3327,3313,NULL,NULL,1,NULL),(3328,3314,NULL,NULL,1,NULL),(3329,3315,NULL,NULL,1,NULL),(3330,3316,NULL,NULL,1,NULL),(3331,3317,NULL,NULL,1,NULL),(3332,3318,NULL,NULL,1,NULL),(3333,3320,NULL,NULL,1,NULL),(3334,3321,NULL,NULL,1,NULL),(3335,3322,NULL,NULL,1,NULL),(3336,3323,NULL,NULL,1,NULL),(3337,3324,NULL,NULL,1,NULL),(3338,3325,NULL,NULL,1,NULL),(3339,3326,NULL,NULL,1,NULL),(3340,3327,NULL,NULL,1,NULL),(3341,3328,NULL,NULL,1,NULL),(3342,3330,NULL,NULL,1,NULL),(3343,3331,NULL,NULL,1,NULL),(3344,3332,NULL,NULL,1,NULL),(3345,3333,NULL,NULL,1,NULL),(3346,3334,NULL,NULL,1,NULL),(3347,3335,NULL,NULL,1,NULL),(3348,3336,NULL,NULL,1,NULL),(3349,3337,NULL,NULL,1,NULL),(3350,3339,NULL,NULL,1,NULL),(3351,3340,NULL,NULL,1,NULL),(3352,3341,NULL,NULL,1,NULL),(3353,3342,NULL,NULL,1,NULL),(3354,3343,NULL,NULL,1,NULL),(3355,3344,NULL,NULL,1,NULL),(3356,3345,NULL,NULL,1,NULL),(3357,3346,NULL,NULL,1,NULL),(3358,3348,NULL,NULL,1,NULL),(3359,3349,NULL,NULL,1,NULL),(3360,3350,NULL,NULL,1,NULL),(3361,3351,NULL,NULL,1,NULL),(3362,3352,NULL,NULL,1,NULL),(3363,3353,NULL,NULL,1,NULL),(3364,3354,NULL,NULL,1,NULL),(3365,3355,NULL,NULL,1,NULL),(3366,3356,NULL,NULL,1,NULL),(3367,3357,NULL,NULL,1,NULL),(3368,3359,NULL,NULL,1,NULL),(3369,3360,NULL,NULL,1,NULL),(3370,3361,NULL,NULL,1,NULL),(3371,3362,NULL,NULL,1,NULL),(3372,3363,NULL,NULL,1,NULL),(3373,3364,NULL,NULL,1,NULL),(3374,3365,NULL,NULL,1,NULL),(3375,3366,NULL,NULL,1,NULL),(3376,3367,NULL,NULL,1,NULL),(3377,3369,NULL,NULL,1,NULL),(3378,3370,NULL,NULL,1,NULL),(3379,3371,NULL,NULL,1,NULL),(3380,3372,NULL,NULL,1,NULL),(3381,3373,NULL,NULL,1,NULL),(3382,3374,NULL,NULL,1,NULL),(3383,3375,NULL,NULL,1,NULL),(3384,3376,NULL,NULL,1,NULL),(3385,3377,NULL,NULL,1,NULL),(3386,3379,NULL,NULL,1,NULL),(3387,3381,NULL,NULL,1,NULL),(3388,3390,NULL,NULL,1,NULL),(3389,3398,NULL,NULL,1,NULL),(3390,3404,NULL,NULL,1,NULL),(3391,3411,NULL,NULL,1,NULL),(3392,3417,NULL,NULL,1,NULL),(3393,3425,NULL,NULL,1,NULL),(3394,3433,NULL,NULL,1,NULL),(3395,3440,NULL,NULL,1,NULL),(3396,3382,NULL,NULL,1,NULL),(3397,3383,NULL,NULL,1,NULL),(3398,3384,NULL,NULL,1,NULL),(3399,3385,NULL,NULL,1,NULL),(3400,3386,NULL,NULL,1,NULL),(3401,3387,NULL,NULL,1,NULL),(3402,3388,NULL,NULL,1,NULL),(3403,3389,NULL,NULL,1,NULL),(3404,3391,NULL,NULL,1,NULL),(3405,3392,NULL,NULL,1,NULL),(3406,3393,NULL,NULL,1,NULL),(3407,3394,NULL,NULL,1,NULL),(3408,3395,NULL,NULL,1,NULL),(3409,3396,NULL,NULL,1,NULL),(3410,3397,NULL,NULL,1,NULL),(3411,3399,NULL,NULL,1,NULL),(3412,3400,NULL,NULL,1,NULL),(3413,3401,NULL,NULL,1,NULL),(3414,3402,NULL,NULL,1,NULL),(3415,3403,NULL,NULL,1,NULL),(3416,3405,NULL,NULL,1,NULL),(3417,3406,NULL,NULL,1,NULL),(3418,3407,NULL,NULL,1,NULL),(3419,3408,NULL,NULL,1,NULL),(3420,3409,NULL,NULL,1,NULL),(3421,3410,NULL,NULL,1,NULL),(3422,3412,NULL,NULL,1,NULL),(3423,3413,NULL,NULL,1,NULL),(3424,3414,NULL,NULL,1,NULL),(3425,3415,NULL,NULL,1,NULL),(3426,3416,NULL,NULL,1,NULL),(3427,3418,NULL,NULL,1,NULL),(3428,3419,NULL,NULL,1,NULL),(3429,3420,NULL,NULL,1,NULL),(3430,3421,NULL,NULL,1,NULL),(3431,3422,NULL,NULL,1,NULL),(3432,3423,NULL,NULL,1,NULL),(3433,3424,NULL,NULL,1,NULL),(3434,3426,NULL,NULL,1,NULL),(3435,3427,NULL,NULL,1,NULL),(3436,3428,NULL,NULL,1,NULL),(3437,3429,NULL,NULL,1,NULL),(3438,3430,NULL,NULL,1,NULL),(3439,3431,NULL,NULL,1,NULL),(3440,3432,NULL,NULL,1,NULL),(3441,3434,NULL,NULL,1,NULL),(3442,3435,NULL,NULL,1,NULL),(3443,3436,NULL,NULL,1,NULL),(3444,3437,NULL,NULL,1,NULL),(3445,3438,NULL,NULL,1,NULL),(3446,3439,NULL,NULL,1,NULL),(3447,3441,NULL,NULL,1,NULL),(3448,3443,NULL,NULL,1,NULL),(3449,3451,NULL,NULL,1,NULL),(3450,3456,NULL,NULL,1,NULL),(3451,3462,NULL,NULL,1,NULL),(3452,3469,NULL,NULL,1,NULL),(3453,3474,NULL,NULL,1,NULL),(3454,3444,NULL,NULL,1,NULL),(3455,3445,NULL,NULL,1,NULL),(3456,3446,NULL,NULL,1,NULL),(3457,3447,NULL,NULL,1,NULL),(3458,3448,NULL,NULL,1,NULL),(3459,3449,NULL,NULL,1,NULL),(3460,3450,NULL,NULL,1,NULL),(3461,3452,NULL,NULL,1,NULL),(3462,3453,NULL,NULL,1,NULL),(3463,3454,NULL,NULL,1,NULL),(3464,3455,NULL,NULL,1,NULL),(3465,3457,NULL,NULL,1,NULL),(3466,3458,NULL,NULL,1,NULL),(3467,3459,NULL,NULL,1,NULL),(3468,3460,NULL,NULL,1,NULL),(3469,3461,NULL,NULL,1,NULL),(3470,3463,NULL,NULL,1,NULL),(3471,3464,NULL,NULL,1,NULL),(3472,3465,NULL,NULL,1,NULL),(3473,3466,NULL,NULL,1,NULL),(3474,3467,NULL,NULL,1,NULL),(3475,3468,NULL,NULL,1,NULL),(3476,3470,NULL,NULL,1,NULL),(3477,3471,NULL,NULL,1,NULL),(3478,3472,NULL,NULL,1,NULL),(3479,3473,NULL,NULL,1,NULL),(3480,3475,NULL,NULL,1,NULL),(3481,3477,NULL,NULL,1,NULL),(3482,3487,NULL,NULL,1,NULL),(3483,3493,NULL,NULL,1,NULL),(3484,3498,NULL,NULL,1,NULL),(3485,3503,NULL,NULL,1,NULL),(3486,3513,NULL,NULL,1,NULL),(3487,3524,NULL,NULL,1,NULL),(3488,3538,NULL,NULL,1,NULL),(3489,3544,NULL,NULL,1,NULL),(3490,3555,NULL,NULL,1,NULL),(3491,3565,NULL,NULL,1,NULL),(3492,3570,NULL,NULL,1,NULL),(3493,3572,NULL,NULL,1,NULL),(3494,3574,NULL,NULL,1,NULL),(3495,3576,NULL,NULL,1,NULL),(3496,3578,NULL,NULL,1,NULL),(3497,3592,NULL,NULL,1,NULL),(3498,3478,NULL,NULL,1,NULL),(3499,3479,NULL,NULL,1,NULL),(3500,3480,NULL,NULL,1,NULL),(3501,3481,NULL,NULL,1,NULL),(3502,3482,NULL,NULL,1,NULL),(3503,3483,NULL,NULL,1,NULL),(3504,3484,NULL,NULL,1,NULL),(3505,3485,NULL,NULL,1,NULL),(3506,3486,NULL,NULL,1,NULL),(3507,3488,NULL,NULL,1,NULL),(3508,3489,NULL,NULL,1,NULL),(3509,3490,NULL,NULL,1,NULL),(3510,3491,NULL,NULL,1,NULL),(3511,3492,NULL,NULL,1,NULL),(3512,3494,NULL,NULL,1,NULL),(3513,3495,NULL,NULL,1,NULL),(3514,3496,NULL,NULL,1,NULL),(3515,3497,NULL,NULL,1,NULL),(3516,3499,NULL,NULL,1,NULL),(3517,3500,NULL,NULL,1,NULL),(3518,3501,NULL,NULL,1,NULL),(3519,3502,NULL,NULL,1,NULL),(3520,3504,NULL,NULL,1,NULL),(3521,3505,NULL,NULL,1,NULL),(3522,3506,NULL,NULL,1,NULL),(3523,3507,NULL,NULL,1,NULL),(3524,3508,NULL,NULL,1,NULL),(3525,3509,NULL,NULL,1,NULL),(3526,3510,NULL,NULL,1,NULL),(3527,3511,NULL,NULL,1,NULL),(3528,3512,NULL,NULL,1,NULL),(3529,3514,NULL,NULL,1,NULL),(3530,3515,NULL,NULL,1,NULL),(3531,3516,NULL,NULL,1,NULL),(3532,3517,NULL,NULL,1,NULL),(3533,3518,NULL,NULL,1,NULL),(3534,3519,NULL,NULL,1,NULL),(3535,3520,NULL,NULL,1,NULL),(3536,3521,NULL,NULL,1,NULL),(3537,3522,NULL,NULL,1,NULL),(3538,3523,NULL,NULL,1,NULL),(3539,3525,NULL,NULL,1,NULL),(3540,3526,NULL,NULL,1,NULL),(3541,3527,NULL,NULL,1,NULL),(3542,3528,NULL,NULL,1,NULL),(3543,3529,NULL,NULL,1,NULL),(3544,3530,NULL,NULL,1,NULL),(3545,3531,NULL,NULL,1,NULL),(3546,3532,NULL,NULL,1,NULL),(3547,3533,NULL,NULL,1,NULL),(3548,3534,NULL,NULL,1,NULL),(3549,3535,NULL,NULL,1,NULL),(3550,3536,NULL,NULL,1,NULL),(3551,3537,NULL,NULL,1,NULL),(3552,3539,NULL,NULL,1,NULL),(3553,3540,NULL,NULL,1,NULL),(3554,3541,NULL,NULL,1,NULL),(3555,3542,NULL,NULL,1,NULL),(3556,3543,NULL,NULL,1,NULL),(3557,3545,NULL,NULL,1,NULL),(3558,3546,NULL,NULL,1,NULL),(3559,3547,NULL,NULL,1,NULL),(3560,3548,NULL,NULL,1,NULL),(3561,3549,NULL,NULL,1,NULL),(3562,3550,NULL,NULL,1,NULL),(3563,3551,NULL,NULL,1,NULL),(3564,3552,NULL,NULL,1,NULL),(3565,3553,NULL,NULL,1,NULL),(3566,3554,NULL,NULL,1,NULL),(3567,3556,NULL,NULL,1,NULL),(3568,3557,NULL,NULL,1,NULL),(3569,3558,NULL,NULL,1,NULL),(3570,3559,NULL,NULL,1,NULL),(3571,3560,NULL,NULL,1,NULL),(3572,3561,NULL,NULL,1,NULL),(3573,3562,NULL,NULL,1,NULL),(3574,3563,NULL,NULL,1,NULL),(3575,3564,NULL,NULL,1,NULL),(3576,3566,NULL,NULL,1,NULL),(3577,3567,NULL,NULL,1,NULL),(3578,3568,NULL,NULL,1,NULL),(3579,3569,NULL,NULL,1,NULL),(3580,3571,NULL,NULL,1,NULL),(3581,3573,NULL,NULL,1,NULL),(3582,3575,NULL,NULL,1,NULL),(3583,3577,NULL,NULL,1,NULL),(3584,3579,NULL,NULL,1,NULL),(3585,3580,NULL,NULL,1,NULL),(3586,3581,NULL,NULL,1,NULL),(3587,3582,NULL,NULL,1,NULL),(3588,3583,NULL,NULL,1,NULL),(3589,3584,NULL,NULL,1,NULL),(3590,3585,NULL,NULL,1,NULL),(3591,3586,NULL,NULL,1,NULL),(3592,3587,NULL,NULL,1,NULL),(3593,3588,NULL,NULL,1,NULL),(3594,3589,NULL,NULL,1,NULL),(3595,3590,NULL,NULL,1,NULL),(3596,3591,NULL,NULL,1,NULL),(3597,3593,NULL,NULL,1,NULL),(3598,3595,NULL,NULL,1,NULL),(3599,3620,NULL,NULL,1,NULL),(3600,3596,NULL,NULL,1,NULL),(3601,3597,NULL,NULL,1,NULL),(3602,3598,NULL,NULL,1,NULL),(3603,3599,NULL,NULL,1,NULL),(3604,3600,NULL,NULL,1,NULL),(3605,3601,NULL,NULL,1,NULL),(3606,3602,NULL,NULL,1,NULL),(3607,3603,NULL,NULL,1,NULL),(3608,3604,NULL,NULL,1,NULL),(3609,3605,NULL,NULL,1,NULL),(3610,3606,NULL,NULL,1,NULL),(3611,3607,NULL,NULL,1,NULL),(3612,3608,NULL,NULL,1,NULL),(3613,3609,NULL,NULL,1,NULL),(3614,3610,NULL,NULL,1,NULL),(3615,3611,NULL,NULL,1,NULL),(3616,3612,NULL,NULL,1,NULL),(3617,3613,NULL,NULL,1,NULL),(3618,3614,NULL,NULL,1,NULL),(3619,3615,NULL,NULL,1,NULL),(3620,3616,NULL,NULL,1,NULL),(3621,3617,NULL,NULL,1,NULL),(3622,3618,NULL,NULL,1,NULL),(3623,3619,NULL,NULL,1,NULL),(3624,3621,NULL,NULL,1,NULL),(3625,3623,NULL,NULL,1,NULL),(3626,3624,NULL,NULL,1,NULL),(3627,3625,NULL,NULL,1,NULL),(3628,3626,NULL,NULL,1,NULL),(3629,3627,NULL,NULL,1,NULL),(3630,3628,NULL,NULL,1,NULL),(3631,3629,NULL,NULL,1,NULL),(3632,3630,NULL,NULL,1,NULL),(3633,3631,NULL,NULL,1,NULL),(3634,3632,NULL,NULL,1,NULL),(3635,3634,NULL,NULL,1,NULL),(3636,3635,NULL,NULL,1,NULL),(3637,3636,NULL,NULL,1,NULL),(3638,3637,NULL,NULL,1,NULL),(3639,3638,NULL,NULL,1,NULL),(3640,3639,NULL,NULL,1,NULL),(3641,3640,NULL,NULL,1,NULL),(3642,3641,NULL,NULL,1,NULL),(3643,3642,NULL,NULL,1,NULL),(3644,3643,NULL,NULL,1,NULL),(3645,3644,NULL,NULL,1,NULL),(3646,3645,NULL,NULL,1,NULL),(3647,3646,NULL,NULL,1,NULL),(3648,3647,NULL,NULL,1,NULL),(3649,3648,NULL,NULL,1,NULL),(3650,3649,NULL,NULL,1,NULL),(3651,3650,NULL,NULL,1,NULL),(3652,3651,NULL,NULL,1,NULL),(3653,3652,NULL,NULL,1,NULL),(3654,3653,NULL,NULL,1,NULL),(3655,3655,NULL,NULL,1,NULL),(3656,3656,NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `t_pcd_qualify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_permission`
--

DROP TABLE IF EXISTS `t_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifier` varchar(255) DEFAULT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `t_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission`
--

LOCK TABLES `t_permission` WRITE;
/*!40000 ALTER TABLE `t_permission` DISABLE KEYS */;
INSERT INTO `t_permission` VALUES (1,'identity.view',1),(2,'identity.edit',1),(3,'identity.delete',1),(4,'product.category.edit',1),(5,'product.add',1),(6,'product.edit',1),(7,'product.approve',1),(8,'product.delete',1),(9,'product.direct_publish',1),(10,'fare_template.edit',1),(11,'purchase_strategy.edit',1),(12,'product_hit_word.edit',1),(13,'product_brand.edit',1),(14,'order.view',1),(15,'order.edit',1),(16,'order.delete',1),(17,'CooperativePartnerApplication.view',1),(18,'CooperativePartnerApplication.edit',1),(19,'CooperativePartnerApplication.delete',1),(20,'physical.seller.view',1),(21,'physical.seller.edit',1),(22,'physical.seller.delete',1),(23,'SettlementApplication.view',1),(24,'SettlementApplication.edit',1),(25,'SettlementApplication.delete',1),(26,'member.edit',1),(27,'coupon.edit',1),(28,'config.view',1),(29,'config.edit',1),(30,'EventLogApplication.view',1),(31,'MiscApplication.view',1),(32,'MiscApplication.edit',1),(33,'MiscApplication.delete',1),(34,'wechat.view',1),(35,'wechat.edit',1),(36,'wechat.delete',1),(37,'marketing.piece.view',1),(38,'marketing.piece.edit',1),(39,'marketing.piece.delete',1),(40,'marketing.wholesale.view',1),(41,'marketing.wholesale.edit',1),(42,'marketing.wholesale.delete',1),(43,'merchant.manage',1),(44,'marketing.trial.view',1),(45,'marketing.trial.edit',1),(46,'marketing.trial.delete',1),(47,'marketing.trial_application.view',1),(48,'marketing.trial_application.edit',1),(49,'marketing.trial_application.delete',1);
/*!40000 ALTER TABLE `t_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_permission_definition`
--

DROP TABLE IF EXISTS `t_permission_definition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permission_definition` (
  `identifier` varchar(150) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `group_identifier` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`identifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission_definition`
--

LOCK TABLES `t_permission_definition` WRITE;
/*!40000 ALTER TABLE `t_permission_definition` DISABLE KEYS */;
INSERT INTO `t_permission_definition` VALUES ('config.edit','编辑配置','Edit Config.',NULL),('config.view','查看配置','View Config.',NULL),('CooperativePartnerApplication.delete','删除合作伙伴','Delete CooperativePartnerApplication.',NULL),('CooperativePartnerApplication.edit','编辑合作伙伴','Edit the CooperativePartnerApplication information.',NULL),('CooperativePartnerApplication.view','查看合作伙伴','View the CooperativePartnerApplication information.',NULL),('coupon.edit','编辑优惠券','Edit coupon.',NULL),('EventLogApplication.view','查看日志','View the EventLogApplication information.',NULL),('fare_template.edit','编辑运费模版','fare_template.edit',NULL),('identity.delete','删除账号','Delete IdentityApplication.',NULL),('identity.edit','编辑账号','Edit the IdentityApplication information.',NULL),('identity.view','查看账号','View the IdentityApplication information.',NULL),('marketing.piece.delete','删除拼团','Delete marketing piece.',NULL),('marketing.piece.edit','编辑拼团','Edit marketing piece.',NULL),('marketing.piece.view','查看拼团','View marketing piece.',NULL),('marketing.trial.delete','删除试用装','Delete marketing trial.',NULL),('marketing.trial.edit','编辑试用装','Edit marketing trial.',NULL),('marketing.trial.view','查看试用装','View marketing trial.',NULL),('marketing.trial_application.delete','删除试用装申请','Delete marketing trial application.',NULL),('marketing.trial_application.edit','编辑试用装申请','Edit marketing trial application.',NULL),('marketing.trial_application.view','查看试用装申请','View marketing trial application.',NULL),('marketing.wholesale.delete','删除团购','Delete marketing wholesale',NULL),('marketing.wholesale.edit','编辑团购','Edit marketing wholesale',NULL),('marketing.wholesale.view','查看团购','View marketing wholesale',NULL),('member.edit','编辑会员','Edit member.',NULL),('merchant.handle','处理商家申请','Handle the merchant information',NULL),('merchant.manage','管理商家','Manage the merchant information',NULL),('MiscApplication.delete','删除杂项配置','Delete MiscApplication information.',NULL),('MiscApplication.edit','编辑杂项配置','Edit the MiscApplication information.',NULL),('MiscApplication.view','查看杂项配置','View the MiscApplication information.',NULL),('order.delete','删除订单','Delete order.',NULL),('order.edit','编辑订单','Edit the order information.',NULL),('order.view','查看订单','View the order information.',NULL),('physical.seller.delete','删除线下经销商','Delete physical.seller.',NULL),('physical.seller.edit','编辑线下经销商','Edit the physical.seller information.',NULL),('physical.seller.view','查看线下经销商','View the physical.seller information.',NULL),('product.add','添加产品','product.add',NULL),('product.approve','审核产品','product.approve',NULL),('product.category.edit','编辑产品类别','product.category.edit',NULL),('product.delete','删除产品','product.delete',NULL),('product.direct_publish','直接发布产品','product.direct_publish',NULL),('product.edit','编辑产品','product.edit',NULL),('product_brand.edit','编辑产品品牌','product_brand.edit',NULL),('product_hit_word.edit','编辑产品搜索关键字','product_hit_word.edit',NULL),('purchase_strategy.edit','编辑产品购买策略','purchase_strategy.edit',NULL),('SettlementApplication.delete','删除分成结算','Delete SettlementApplication.',NULL),('SettlementApplication.edit','编辑分成结算','Edit the SettlementApplication information.',NULL),('SettlementApplication.view','查看分成结算','View the SettlementApplication information.',NULL),('wechat.delete','删除微信配置','Delete the Wechat Config information.',NULL),('wechat.edit','编辑微信配置','Edit the Wechat Config information.',NULL),('wechat.view','查看微信配置','View the Wechat Config information.',NULL);
/*!40000 ALTER TABLE `t_permission_definition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_permission_group_definition`
--

DROP TABLE IF EXISTS `t_permission_group_definition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permission_group_definition` (
  `identifier` varchar(150) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `permissions` text,
  `visible` int(11) DEFAULT '1',
  PRIMARY KEY (`identifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission_group_definition`
--

LOCK TABLES `t_permission_group_definition` WRITE;
/*!40000 ALTER TABLE `t_permission_group_definition` DISABLE KEYS */;
INSERT INTO `t_permission_group_definition` VALUES ('config.mgmt','配置管理','Manage the config.','config.edit',1),('CooperativePartnerApplication.mgmt','合作伙伴管理','Manage the CooperativePartnerApplication.','CooperativePartnerApplication.view|CooperativePartnerApplication.edit|CooperativePartnerApplication.delete',1),('EventLogApplication.mgmt','日志管理','Manage the EventLogApplication.','EventLogApplication.view',1),('identity.mgmt','系统管理','Manage the IdentityApplication.','identity.view|identity.edit|identity.delete',1),('marketing.piece.mgmt','拼团管理','Manage the marketing piece.','marketing.piece.view|marketing.piece.edit|marketing.piece.delete',1),('marketing.trial.mgmt','试用装管理','Manage the marketing trial.','marketing.trial.view|marketing.trial.edit|marketing.trial.delete|marketing.trial_application.view|marketing.trial_application.edit|marketing.trial_application.delete',1),('marketing.wholesale.mgmt','批发管理','Manage the marketing wholesale.','marketing.wholesale.view|marketing.wholesale.edit|marketing.wholesale.delete',1),('member.mgmt','会员管理','Manage the member.','member.edit|coupon.edit',1),('merchant.mgmt','商家管理','Manage the merchant','merchant.manage|merchant.handle',1),('MiscApplication.mgmt','其他管理','Manage the MiscApplication.','MiscApplication.view|MiscApplication.edit|MiscApplication.delete',1),('order.mgmt','订单管理','Manage the order.','order.view|order.edit|order.delete',1),('physical.seller.mgmt','线下经销商管理','Manage the physical.seller.','physical.seller.view|physical.seller.edit|physical.seller.delete',1),('product.mgmt','产品管理','Manage Products.','product.category.edit|product.add|product.edit|product.approve|product.delete|product.direct_publish|fare_template.edit|purchase_strategy.edit|product_hit_word.edit|product_brand.edit',1),('SettlementApplication.mgmt','结算管理','Manage the SettlementApplication.','SettlementApplication.view|SettlementApplication.edit|SettlementApplication.delete',1),('wechat.mgmt','微信配置管理','Manage the Wechat Config information.','wechat.view|wechat.edit|wechat.delete',1);
/*!40000 ALTER TABLE `t_permission_group_definition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_physical_agent_bonus`
--

DROP TABLE IF EXISTS `t_physical_agent_bonus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_physical_agent_bonus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pcd_id` int(11) NOT NULL,
  `min_amount` decimal(15,2) DEFAULT NULL,
  `max_amount` decimal(15,2) DEFAULT NULL,
  `percentage` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pcd_id` (`pcd_id`),
  CONSTRAINT `t_physical_agent_bonus_ibfk_1` FOREIGN KEY (`pcd_id`) REFERENCES `t_pcd` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_physical_agent_bonus`
--

LOCK TABLES `t_physical_agent_bonus` WRITE;
/*!40000 ALTER TABLE `t_physical_agent_bonus` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_physical_agent_bonus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_physical_apply_tips`
--

DROP TABLE IF EXISTS `t_physical_apply_tips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_physical_apply_tips` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `content` text,
  `created_date` timestamp NULL DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  `enabled` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_physical_apply_tips`
--

LOCK TABLES `t_physical_apply_tips` WRITE;
/*!40000 ALTER TABLE `t_physical_apply_tips` DISABLE KEYS */;
INSERT INTO `t_physical_apply_tips` VALUES (1,'皇冠经销商申请需知','CROWN',NULL,NULL,NULL,1),(2,'星级经销商申请需知','STAR',NULL,NULL,NULL,1),(3,'系统公告','ANNOUNCE',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `t_physical_apply_tips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_physical_purchase_journal`
--

DROP TABLE IF EXISTS `t_physical_purchase_journal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_physical_purchase_journal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` int(11) NOT NULL,
  `amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `note` text,
  `created_date` timestamp NULL DEFAULT NULL,
  `order_number` varchar(50) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `order_item_id` int(11) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_settlement_proportion` decimal(10,2) NOT NULL DEFAULT '0.00',
  `expected_reward` decimal(10,2) DEFAULT NULL,
  `expected_reward_lv1` decimal(10,2) NOT NULL DEFAULT '0.00',
  `expected_reward_lv2` decimal(10,2) NOT NULL DEFAULT '0.00',
  `settlement_proportion_lv1` decimal(10,2) NOT NULL DEFAULT '0.00',
  `settlement_proportion_lv2` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`),
  KEY `seller_id` (`seller_id`),
  CONSTRAINT `t_physical_purchase_journal_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `t_seller` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_physical_purchase_journal`
--

LOCK TABLES `t_physical_purchase_journal` WRITE;
/*!40000 ALTER TABLE `t_physical_purchase_journal` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_physical_purchase_journal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_physical_purchase_summary`
--

DROP TABLE IF EXISTS `t_physical_purchase_summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_physical_purchase_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` int(11) NOT NULL,
  `monthly_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `monthly_settled_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `monthly_expected_settled_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `statistic_month` date DEFAULT NULL,
  `settlement_proportion` decimal(5,2) NOT NULL DEFAULT '0.00',
  `transferred` int(11) NOT NULL DEFAULT '0',
  `transferred_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `monthly_expected_settled_amount_lv2` decimal(15,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`),
  KEY `seller_id` (`seller_id`),
  CONSTRAINT `t_physical_purchase_summary_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `t_seller` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_physical_purchase_summary`
--

LOCK TABLES `t_physical_purchase_summary` WRITE;
/*!40000 ALTER TABLE `t_physical_purchase_summary` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_physical_purchase_summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_physical_seller`
--

DROP TABLE IF EXISTS `t_physical_seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_physical_seller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` int(11) NOT NULL,
  `parent_seller_id` int(11) DEFAULT NULL,
  `total_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `total_settled_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `created_date` timestamp NULL DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `latest_bonus_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `seller_id` (`seller_id`),
  KEY `parent_seller_id` (`parent_seller_id`),
  CONSTRAINT `t_physical_seller_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `t_seller` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_physical_seller_ibfk_2` FOREIGN KEY (`parent_seller_id`) REFERENCES `t_seller` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_physical_seller`
--

LOCK TABLES `t_physical_seller` WRITE;
/*!40000 ALTER TABLE `t_physical_seller` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_physical_seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_physical_settlement_definition`
--

DROP TABLE IF EXISTS `t_physical_settlement_definition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_physical_settlement_definition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_physical_settlement_definition`
--

LOCK TABLES `t_physical_settlement_definition` WRITE;
/*!40000 ALTER TABLE `t_physical_settlement_definition` DISABLE KEYS */;
INSERT INTO `t_physical_settlement_definition` VALUES (1,1000.00);
/*!40000 ALTER TABLE `t_physical_settlement_definition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_physical_settlement_proportion`
--

DROP TABLE IF EXISTS `t_physical_settlement_proportion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_physical_settlement_proportion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `min_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `max_amount` decimal(15,2) NOT NULL DEFAULT '0.00',
  `percentage` decimal(5,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_physical_settlement_proportion`
--

LOCK TABLES `t_physical_settlement_proportion` WRITE;
/*!40000 ALTER TABLE `t_physical_settlement_proportion` DISABLE KEYS */;
INSERT INTO `t_physical_settlement_proportion` VALUES (1,1000.00,5000.00,2.00),(2,5001.00,10000.00,5.00),(3,10001.00,50000.00,6.00),(4,50001.00,-1.00,8.00);
/*!40000 ALTER TABLE `t_physical_settlement_proportion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_piece_group_purchase`
--

DROP TABLE IF EXISTS `t_piece_group_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_piece_group_purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `marketing_name` varchar(200) NOT NULL,
  `marketing_short_name` varchar(50) DEFAULT NULL,
  `min_participator_count` int(11) DEFAULT '2',
  `duration` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `suggested_price` decimal(10,2) NOT NULL,
  `sale` int(11) DEFAULT '0',
  `description` text,
  `cover` varchar(255) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `master_free` int(11) DEFAULT '0',
  `free_shipping` int(11) DEFAULT '0',
  `coupon_usage` int(11) DEFAULT '0',
  `payment_type` varchar(50) NOT NULL,
  `coupon_strategy_service_name` varchar(50) DEFAULT NULL,
  `sort_order` int(11) DEFAULT '100',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `t_piece_group_purchase_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_piece_group_purchase`
--

LOCK TABLES `t_piece_group_purchase` WRITE;
/*!40000 ALTER TABLE `t_piece_group_purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_piece_group_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_piece_group_purchase_master`
--

DROP TABLE IF EXISTS `t_piece_group_purchase_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_piece_group_purchase_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `piece_group_purchase_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `promoted` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `piece_group_purchase_id` (`piece_group_purchase_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_piece_group_purchase_master_ibfk_1` FOREIGN KEY (`piece_group_purchase_id`) REFERENCES `t_piece_group_purchase` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_piece_group_purchase_master_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_piece_group_purchase_master`
--

LOCK TABLES `t_piece_group_purchase_master` WRITE;
/*!40000 ALTER TABLE `t_piece_group_purchase_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_piece_group_purchase_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_piece_group_purchase_member`
--

DROP TABLE IF EXISTS `t_piece_group_purchase_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_piece_group_purchase_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `master_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `created_time` timestamp NULL DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `order_number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `master_id` (`master_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_piece_group_purchase_member_ibfk_1` FOREIGN KEY (`master_id`) REFERENCES `t_piece_group_purchase_master` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_piece_group_purchase_member_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_piece_group_purchase_member`
--

LOCK TABLES `t_piece_group_purchase_member` WRITE;
/*!40000 ALTER TABLE `t_piece_group_purchase_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_piece_group_purchase_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_piece_group_purchase_pricing`
--

DROP TABLE IF EXISTS `t_piece_group_purchase_pricing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_piece_group_purchase_pricing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `piece_group_purchase_id` int(11) NOT NULL,
  `participator_count` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `piece_group_purchase_id` (`piece_group_purchase_id`,`participator_count`),
  CONSTRAINT `t_piece_group_purchase_pricing_ibfk_1` FOREIGN KEY (`piece_group_purchase_id`) REFERENCES `t_piece_group_purchase` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_piece_group_purchase_pricing`
--

LOCK TABLES `t_piece_group_purchase_pricing` WRITE;
/*!40000 ALTER TABLE `t_piece_group_purchase_pricing` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_piece_group_purchase_pricing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_platform_seller`
--

DROP TABLE IF EXISTS `t_platform_seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_platform_seller` (
  `seller_id` int(11) NOT NULL,
  KEY `seller_id` (`seller_id`),
  CONSTRAINT `t_platform_seller_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `t_seller` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_platform_seller`
--

LOCK TABLES `t_platform_seller` WRITE;
/*!40000 ALTER TABLE `t_platform_seller` DISABLE KEYS */;
INSERT INTO `t_platform_seller` VALUES (1);
/*!40000 ALTER TABLE `t_platform_seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product`
--

DROP TABLE IF EXISTS `t_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `short_name` varchar(100) NOT NULL,
  `cover` varchar(200) DEFAULT NULL,
  `stock_balance` int(11) DEFAULT '0',
  `sales` int(11) NOT NULL DEFAULT '0',
  `status` varchar(50) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `cost_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `suggested_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `promoted` int(11) NOT NULL DEFAULT '0',
  `freight` decimal(10,2) NOT NULL DEFAULT '0.00',
  `free_shipping` int(11) NOT NULL DEFAULT '0',
  `sort_order` int(11) DEFAULT '100',
  `partner_level_zone` int(11) DEFAULT NULL,
  `view_count` bigint(20) DEFAULT '0',
  `fare_id` int(11) DEFAULT NULL,
  `barcode` varchar(100) DEFAULT NULL,
  `store_location` varchar(200) DEFAULT NULL,
  `weight` int(11) DEFAULT '0',
  `bulk` int(11) DEFAULT '0',
  `sku_id` varchar(50) DEFAULT NULL,
  `sku_name` varchar(50) DEFAULT NULL,
  `sku_code` varchar(50) DEFAULT NULL,
  `bar_code` varchar(255) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL COMMENT '商家id',
  `allow_coupon` int(11) DEFAULT '0' COMMENT '优惠活动-优惠券',
  `credit` int(11) DEFAULT '0' COMMENT '优惠活动-可用积分',
  `is_virtual` int(11) DEFAULT '0' COMMENT '是否虚拟产品',
  `required_participate_exam` int(11) DEFAULT '0' COMMENT '是否需要做了检测才可以购买',
  `distribution_price` decimal(10,2) DEFAULT '0.00' COMMENT '分销价',
  `presale` int(11) NOT NULL DEFAULT '0' COMMENT '预售数量，如果大于0则为预售产品',
  `banner` varchar(250) DEFAULT NULL COMMENT '产品banner图',
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `fare_id` (`fare_id`),
  KEY `brand_id` (`brand_id`),
  CONSTRAINT `t_product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `t_product_category` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_product_ibfk_2` FOREIGN KEY (`fare_id`) REFERENCES `t_fare_template` (`id`) ON DELETE SET NULL,
  CONSTRAINT `t_product_ibfk_3` FOREIGN KEY (`brand_id`) REFERENCES `t_product_brand` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_brand`
--

DROP TABLE IF EXISTS `t_product_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text,
  `logo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_brand`
--

LOCK TABLES `t_product_brand` WRITE;
/*!40000 ALTER TABLE `t_product_brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_category`
--

DROP TABLE IF EXISTS `t_product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `description` text,
  `cover` varchar(200) DEFAULT NULL,
  `sort_order` int(11) DEFAULT '100',
  `promoted` int(11) DEFAULT '1',
  `visible` int(11) DEFAULT '1',
  `promoted_product_count` int(11) DEFAULT '3',
  `wholesale` int(11) DEFAULT '0',
  `is_show_products` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  CONSTRAINT `t_product_category_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `t_product_category` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_category`
--

LOCK TABLES `t_product_category` WRITE;
/*!40000 ALTER TABLE `t_product_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_category_property`
--

DROP TABLE IF EXISTS `t_product_category_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_category_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `display_name` varchar(100) NOT NULL,
  `value_type` varchar(50) DEFAULT NULL,
  `input_type` varchar(50) DEFAULT NULL,
  `candidate_values` text,
  `default_value` text,
  `is_required` int(11) DEFAULT '0',
  `sort_order` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `t_product_category_property_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `t_product_category` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_category_property`
--

LOCK TABLES `t_product_category_property` WRITE;
/*!40000 ALTER TABLE `t_product_category_property` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_category_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_description`
--

DROP TABLE IF EXISTS `t_product_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_description` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `t_product_description_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_description`
--

LOCK TABLES `t_product_description` WRITE;
/*!40000 ALTER TABLE `t_product_description` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_favorite`
--

DROP TABLE IF EXISTS `t_product_favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_favorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `collect_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `t_product_favorite_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_product_favorite_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_favorite`
--

LOCK TABLES `t_product_favorite` WRITE;
/*!40000 ALTER TABLE `t_product_favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_hit_word`
--

DROP TABLE IF EXISTS `t_product_hit_word`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_hit_word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `hit` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_hit_word`
--

LOCK TABLES `t_product_hit_word` WRITE;
/*!40000 ALTER TABLE `t_product_hit_word` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_hit_word` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_image`
--

DROP TABLE IF EXISTS `t_product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `type` int(11) NOT NULL DEFAULT '0',
  `url` varchar(200) NOT NULL,
  `sort_order` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `t_product_image_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_image`
--

LOCK TABLES `t_product_image` WRITE;
/*!40000 ALTER TABLE `t_product_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_property`
--

DROP TABLE IF EXISTS `t_product_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `property_id` int(11) NOT NULL,
  `property_value` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `property_id` (`property_id`),
  CONSTRAINT `t_product_property_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_product_property_ibfk_2` FOREIGN KEY (`property_id`) REFERENCES `t_product_category_property` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_property`
--

LOCK TABLES `t_product_property` WRITE;
/*!40000 ALTER TABLE `t_product_property` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_purchase_strategy`
--

DROP TABLE IF EXISTS `t_product_purchase_strategy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_purchase_strategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_purchase_strategy`
--

LOCK TABLES `t_product_purchase_strategy` WRITE;
/*!40000 ALTER TABLE `t_product_purchase_strategy` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_purchase_strategy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_purchase_strategy_item`
--

DROP TABLE IF EXISTS `t_product_purchase_strategy_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_purchase_strategy_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `strategy_id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `operator` varchar(10) NOT NULL,
  `sort_order` int(11) DEFAULT NULL,
  `param` text,
  PRIMARY KEY (`id`),
  KEY `strategy_id` (`strategy_id`),
  CONSTRAINT `t_product_purchase_strategy_item_ibfk_1` FOREIGN KEY (`strategy_id`) REFERENCES `t_product_purchase_strategy` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_purchase_strategy_item`
--

LOCK TABLES `t_product_purchase_strategy_item` WRITE;
/*!40000 ALTER TABLE `t_product_purchase_strategy_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_purchase_strategy_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_purchase_strategy_relation`
--

DROP TABLE IF EXISTS `t_product_purchase_strategy_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_purchase_strategy_relation` (
  `product_id` int(11) NOT NULL,
  `strategy_id` int(11) NOT NULL,
  PRIMARY KEY (`product_id`,`strategy_id`),
  KEY `strategy_id` (`strategy_id`),
  CONSTRAINT `t_product_purchase_strategy_relation_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_product_purchase_strategy_relation_ibfk_2` FOREIGN KEY (`strategy_id`) REFERENCES `t_product_purchase_strategy` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_purchase_strategy_relation`
--

LOCK TABLES `t_product_purchase_strategy_relation` WRITE;
/*!40000 ALTER TABLE `t_product_purchase_strategy_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_purchase_strategy_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_settlement_proportion`
--

DROP TABLE IF EXISTS `t_product_settlement_proportion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_settlement_proportion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `proportion` text,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `t_product_settlement_proportion_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_settlement_proportion`
--

LOCK TABLES `t_product_settlement_proportion` WRITE;
/*!40000 ALTER TABLE `t_product_settlement_proportion` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_settlement_proportion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_specification`
--

DROP TABLE IF EXISTS `t_product_specification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_specification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `stock_balance` int(11) DEFAULT '0',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `cost_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `suggested_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `weight` int(11) DEFAULT '0',
  `bulk` int(11) DEFAULT '0',
  `sku_id` varchar(50) DEFAULT NULL,
  `sku_name` varchar(50) DEFAULT NULL,
  `sku_code` varchar(50) DEFAULT NULL,
  `bar_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `t_product_specification_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_specification`
--

LOCK TABLES `t_product_specification` WRITE;
/*!40000 ALTER TABLE `t_product_specification` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_specification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_tag`
--

DROP TABLE IF EXISTS `t_product_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifier` varchar(50) NOT NULL COMMENT '标签标识',
  `name` varchar(50) NOT NULL COMMENT '标签名称',
  `sort_order` int(11) DEFAULT '1' COMMENT '排序号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `identifier` (`identifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_tag`
--

LOCK TABLES `t_product_tag` WRITE;
/*!40000 ALTER TABLE `t_product_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_tag_relation`
--

DROP TABLE IF EXISTS `t_product_tag_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_tag_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tag_id` (`tag_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `t_product_tag_relation_ibfk_1` FOREIGN KEY (`tag_id`) REFERENCES `t_product_tag` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_product_tag_relation_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_tag_relation`
--

LOCK TABLES `t_product_tag_relation` WRITE;
/*!40000 ALTER TABLE `t_product_tag_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_tag_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_reward_cash`
--

DROP TABLE IF EXISTS `t_reward_cash`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_reward_cash` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `owner_id` int(11) NOT NULL,
  `cash` decimal(10,2) NOT NULL DEFAULT '0.00',
  `apply_time` datetime DEFAULT NULL,
  `reject_time` datetime DEFAULT NULL,
  `complete_time` datetime DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `account_type` varchar(50) DEFAULT NULL,
  `account_number` varchar(50) DEFAULT NULL,
  `account_name` varchar(50) DEFAULT NULL,
  `bank_name` varchar(50) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `owner_id` (`owner_id`),
  CONSTRAINT `t_reward_cash_ibfk_1` FOREIGN KEY (`owner_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_reward_cash`
--

LOCK TABLES `t_reward_cash` WRITE;
/*!40000 ALTER TABLE `t_reward_cash` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_reward_cash` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `system` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'管理员','admin',1),(2,'代理商','agent',1),(3,'分销商','seller',1),(4,'消费者','customer',1);
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_seller`
--

DROP TABLE IF EXISTS `t_seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_seller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `partner_ship` int(11) NOT NULL DEFAULT '0',
  `partner_id` int(11) DEFAULT NULL,
  `seller_ship` int(11) NOT NULL DEFAULT '0',
  `level` int(11) DEFAULT '1',
  `partner_ship_time` timestamp NULL DEFAULT NULL,
  `seller_ship_time` timestamp NULL DEFAULT NULL,
  `partner_level_id` int(11) DEFAULT NULL,
  `crown_ship` int(11) NOT NULL DEFAULT '0',
  `crown_ship_temp` int(11) DEFAULT '0',
  `crown_ship_time` timestamp NULL DEFAULT NULL,
  `crown_id` int(11) DEFAULT NULL,
  `crown_apply_failure_times` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_seller_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_seller`
--

LOCK TABLES `t_seller` WRITE;
/*!40000 ALTER TABLE `t_seller` DISABLE KEYS */;
INSERT INTO `t_seller` VALUES (1,1,NULL,0,NULL,1,1,NULL,NULL,NULL,0,0,NULL,NULL,0),(2,2,NULL,0,NULL,1,1,NULL,'2019-12-16 03:03:45',NULL,0,0,NULL,NULL,0);
/*!40000 ALTER TABLE `t_seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_seller_ancestor`
--

DROP TABLE IF EXISTS `t_seller_ancestor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_seller_ancestor` (
  `seller_id` int(11) NOT NULL,
  `ancestor_id` int(11) NOT NULL,
  `level` int(11) DEFAULT NULL,
  KEY `seller_id` (`seller_id`),
  KEY `ancestor_id` (`ancestor_id`),
  CONSTRAINT `t_seller_ancestor_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `t_seller` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_seller_ancestor_ibfk_2` FOREIGN KEY (`ancestor_id`) REFERENCES `t_seller` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_seller_ancestor`
--

LOCK TABLES `t_seller_ancestor` WRITE;
/*!40000 ALTER TABLE `t_seller_ancestor` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_seller_ancestor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_settled_merchant`
--

DROP TABLE IF EXISTS `t_settled_merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_settled_merchant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL,
  `name` varchar(200) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(50) NOT NULL,
  `contact_user` varchar(50) NOT NULL,
  `contact_phone` varchar(50) NOT NULL,
  `contact_email` varchar(50) DEFAULT NULL,
  `id_number` varchar(50) DEFAULT NULL,
  `id_front` varchar(255) DEFAULT NULL,
  `id_back` varchar(255) DEFAULT NULL,
  `business_license_number` varchar(200) DEFAULT NULL,
  `business_license_image` varchar(200) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `approved_date` timestamp NULL DEFAULT NULL,
  `quality_ranking` int(11) DEFAULT NULL,
  `attitude_ranking` int(11) DEFAULT NULL,
  `express_ranking` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_settled_merchant_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_settled_merchant_type` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_settled_merchant`
--

LOCK TABLES `t_settled_merchant` WRITE;
/*!40000 ALTER TABLE `t_settled_merchant` DISABLE KEYS */;
INSERT INTO `t_settled_merchant` VALUES (1,1,'自营',NULL,NULL,NULL,'','','',NULL,NULL,NULL,NULL,NULL,NULL,'APPROVED',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `t_settled_merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_settled_merchant_approve_log`
--

DROP TABLE IF EXISTS `t_settled_merchant_approve_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_settled_merchant_approve_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_id` int(11) NOT NULL,
  `handled_date` timestamp NULL DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `administrator` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `merchant_id` (`merchant_id`),
  CONSTRAINT `t_settled_merchant_approve_log_ibfk_1` FOREIGN KEY (`merchant_id`) REFERENCES `t_settled_merchant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_settled_merchant_approve_log`
--

LOCK TABLES `t_settled_merchant_approve_log` WRITE;
/*!40000 ALTER TABLE `t_settled_merchant_approve_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_settled_merchant_approve_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_settled_merchant_introduction`
--

DROP TABLE IF EXISTS `t_settled_merchant_introduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_settled_merchant_introduction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_id` int(11) NOT NULL,
  `introduction` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `merchant_id` (`merchant_id`),
  CONSTRAINT `t_settled_merchant_introduction_ibfk_1` FOREIGN KEY (`merchant_id`) REFERENCES `t_settled_merchant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_settled_merchant_introduction`
--

LOCK TABLES `t_settled_merchant_introduction` WRITE;
/*!40000 ALTER TABLE `t_settled_merchant_introduction` DISABLE KEYS */;
INSERT INTO `t_settled_merchant_introduction` VALUES (1,1,'');
/*!40000 ALTER TABLE `t_settled_merchant_introduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_settled_merchant_settlement_proportion`
--

DROP TABLE IF EXISTS `t_settled_merchant_settlement_proportion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_settled_merchant_settlement_proportion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `percentage` decimal(5,2) NOT NULL DEFAULT '100.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_settled_merchant_settlement_proportion`
--

LOCK TABLES `t_settled_merchant_settlement_proportion` WRITE;
/*!40000 ALTER TABLE `t_settled_merchant_settlement_proportion` DISABLE KEYS */;
INSERT INTO `t_settled_merchant_settlement_proportion` VALUES (1,100.00);
/*!40000 ALTER TABLE `t_settled_merchant_settlement_proportion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_settled_merchant_type`
--

DROP TABLE IF EXISTS `t_settled_merchant_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_settled_merchant_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `product_count` int(11) DEFAULT NULL,
  `deposit` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_settled_merchant_type`
--

LOCK TABLES `t_settled_merchant_type` WRITE;
/*!40000 ALTER TABLE `t_settled_merchant_type` DISABLE KEYS */;
INSERT INTO `t_settled_merchant_type` VALUES (1,'默认',99999,0.00);
/*!40000 ALTER TABLE `t_settled_merchant_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_settled_term`
--

DROP TABLE IF EXISTS `t_settled_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_settled_term` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_settled_term`
--

LOCK TABLES `t_settled_term` WRITE;
/*!40000 ALTER TABLE `t_settled_term` DISABLE KEYS */;
INSERT INTO `t_settled_term` VALUES (1,'商家入驻协议',NULL);
/*!40000 ALTER TABLE `t_settled_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_settlement_proportion`
--

DROP TABLE IF EXISTS `t_settlement_proportion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_settlement_proportion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `proportion` text,
  `turnover_quota` int(11) NOT NULL DEFAULT '0',
  `level` int(11) DEFAULT NULL,
  `visible` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_settlement_proportion`
--

LOCK TABLES `t_settlement_proportion` WRITE;
/*!40000 ALTER TABLE `t_settlement_proportion` DISABLE KEYS */;
INSERT INTO `t_settlement_proportion` VALUES (1,'平台','PLATFORM','{\"percentage\": true, \"value\": 2.0}',0,0,1),(2,'一星经销商','PARTNER','{\"fixedvalue\": true, \"1\": 0.1, \"2\": 0.2, \"3\":0.3}',0,1,1),(3,'二星经销商','PARTNER','{\"fixedvalue\": true, \"1\": 0.15, \"2\": 0.25, \"3\":0.35}',0,2,1),(4,'三星经销商','PARTNER','{\"fixedvalue\": true, \"1\": 0.2, \"2\": 0.3, \"3\":0.4}',0,3,1),(5,'四星经销商','PARTNER','{\"fixedvalue\": true, \"1\": 0.25, \"2\": 0.35, \"3\":0.45}',0,4,1),(6,'五星经销商','PARTNER','{\"fixedvalue\": true, \"1\": 0.3, \"2\": 0.4, \"3\":0.5}',0,5,1),(7,'六星经销商','PARTNER','{\"fixedvalue\": true, \"1\": 0.5, \"2\": 0.5, \"3\":0.5}',0,6,1),(8,'一级销售商','SELLER','{\"percentage\": true, \"value\": 10.0}',0,1,1),(9,'二级销售商','SELLER','{\"percentage\": true, \"value\": 20.0}',0,2,1),(10,'三级销售商','SELLER','{\"percentage\": true, \"value\": 30.0}',0,3,1),(11,'省级代理商','AGENT','{\"percentage\": true, \"value\": 0.0}',0,1,1),(12,'市级代理商','AGENT','{\"percentage\": true, \"value\": 0.0}',0,2,1),(13,'区级代理商','AGENT','{\"percentage\": true, \"value\": 0.0}',0,3,1),(14,'代理商自己购买','SELF','{\"percentage\": true, \"value\": 10.0}',0,0,1),(15,'皇冠','CROWN','{\"fixedvalue\": true, \"1\": 0.5, \"2\": 0.5, \"3\":0.5}',0,0,1),(16,'省级代理商','PHYSICAL_AGENT','{\"percentage\": true, \"value\": 1.0}',0,1,1),(17,'市级代理商','PHYSICAL_AGENT','{\"percentage\": true, \"value\": 2.0}',0,2,1),(18,'区级代理商','PHYSICAL_AGENT','{\"percentage\": true, \"value\": 3.0}',0,3,1),(19,'从下级线下皇冠商得到的分成比例','PHYSICAL_CROWN','{\"percentage\": true, \"value\": 80.0}',0,1,1),(20,'从下下级线下皇冠商得到的分成比例','PHYSICAL_CROWN','{\"percentage\": true, \"value\": 20.0}',0,2,1),(21,'合伙人','COPARTNER','{\"percentage\": true, \"value\": 2.0}',0,0,1);
/*!40000 ALTER TABLE `t_settlement_proportion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_shopping_cart`
--

DROP TABLE IF EXISTS `t_shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_shopping_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `cover` varchar(200) DEFAULT NULL,
  `quantity` int(11) NOT NULL DEFAULT '1',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `weight` int(11) DEFAULT '0',
  `bulk` int(11) DEFAULT '0',
  `created_date` datetime DEFAULT NULL,
  `product_specification_id` int(11) DEFAULT NULL,
  `product_specification_name` varchar(200) DEFAULT NULL,
  `fare_id` int(11) DEFAULT NULL,
  `marketing` varchar(50) DEFAULT NULL,
  `marketing_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fare_id` (`fare_id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  KEY `product_specification_id` (`product_specification_id`),
  CONSTRAINT `t_shopping_cart_ibfk_1` FOREIGN KEY (`fare_id`) REFERENCES `t_fare_template` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_shopping_cart_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_shopping_cart_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_shopping_cart_ibfk_4` FOREIGN KEY (`product_specification_id`) REFERENCES `t_product_specification` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_shopping_cart`
--

LOCK TABLES `t_shopping_cart` WRITE;
/*!40000 ALTER TABLE `t_shopping_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_system_announcement`
--

DROP TABLE IF EXISTS `t_system_announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_system_announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `content` text,
  `created_date` timestamp NULL DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  `enabled` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_system_announcement`
--

LOCK TABLES `t_system_announcement` WRITE;
/*!40000 ALTER TABLE `t_system_announcement` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_system_announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_trial`
--

DROP TABLE IF EXISTS `t_trial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_trial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '产品id',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  `name` varchar(100) DEFAULT NULL COMMENT '试用装名称',
  `short_note` varchar(50) DEFAULT NULL COMMENT '简短描述',
  `enabled` int(11) DEFAULT '0' COMMENT '是否启用',
  `start_time` datetime DEFAULT NULL COMMENT '有效申请时间',
  `end_time` datetime DEFAULT NULL COMMENT '过期时间',
  `cover` varchar(255) DEFAULT NULL COMMENT '试用装封面',
  `note` text COMMENT '描述',
  `index` int(11) DEFAULT '100' COMMENT '排序号',
  `shipping_type` int(11) DEFAULT '0' COMMENT '运费支付 0 商家 1 顾客',
  `payment_type` varchar(50) DEFAULT NULL COMMENT '支付方式',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_trial`
--

LOCK TABLES `t_trial` WRITE;
/*!40000 ALTER TABLE `t_trial` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_trial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_trial_application`
--

DROP TABLE IF EXISTS `t_trial_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_trial_application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trial_id` int(11) NOT NULL COMMENT '试用活动id',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `order_number` varchar(50) DEFAULT NULL COMMENT '订单号',
  `user_id` int(11) NOT NULL COMMENT '申请人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `shipping_type` int(11) DEFAULT '0' COMMENT '0 包邮 1 根据产品计算',
  `note` text COMMENT '描述',
  `version` int(11) DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_trial_application`
--

LOCK TABLES `t_trial_application` WRITE;
/*!40000 ALTER TABLE `t_trial_application` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_trial_application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_trial_image`
--

DROP TABLE IF EXISTS `t_trial_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_trial_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trial_id` int(11) NOT NULL,
  `url` varchar(200) NOT NULL,
  `sort_order` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `trial_id` (`trial_id`),
  CONSTRAINT `t_trial_image_ibfk_1` FOREIGN KEY (`trial_id`) REFERENCES `t_trial` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_trial_image`
--

LOCK TABLES `t_trial_image` WRITE;
/*!40000 ALTER TABLE `t_trial_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_trial_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(150) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `weixin` varchar(50) DEFAULT NULL,
  `register_date` datetime DEFAULT NULL,
  `last_login_date` datetime DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `token_salt` varchar(255) DEFAULT NULL,
  `token_expired_date` datetime DEFAULT NULL,
  `invitation_code` varchar(50) DEFAULT NULL,
  `inviter_id` int(11) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT '0',
  `birthday` date DEFAULT NULL,
  `details` text,
  `uid` varchar(20) DEFAULT NULL,
  `followed` int(11) DEFAULT '1',
  `follow_time` datetime DEFAULT NULL,
  `invitation_qrcode_url` varchar(200) DEFAULT NULL,
  `invitation_qrcode` varchar(200) DEFAULT NULL,
  `wx_unionid` varchar(50) DEFAULT NULL,
  `wxa_openid` varchar(50) DEFAULT NULL,
  `wxapp_openid` varchar(50) DEFAULT NULL,
  `app_user` int(11) DEFAULT '0',
  `wechat_name` varchar(50) DEFAULT NULL,
  `grade` varchar(50) DEFAULT NULL,
  `contact_phone` varchar(50) DEFAULT NULL COMMENT '员工联系电话',
  `contact_wx_number` varchar(50) DEFAULT NULL COMMENT '员工联系微信号',
  `cabin_code` varchar(50) DEFAULT NULL COMMENT '关注小屋',
  `store_code` varchar(50) DEFAULT NULL COMMENT '关注门店',
  `assistant_code` varchar(50) DEFAULT NULL COMMENT '导购员',
  `wxa_invitation_qrcode_url` varchar(250) DEFAULT NULL COMMENT '小程序邀请二维码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `weixin` (`weixin`),
  UNIQUE KEY `invitation_code` (`invitation_code`),
  UNIQUE KEY `uid` (`uid`),
  UNIQUE KEY `wx_unionid` (`wx_unionid`),
  UNIQUE KEY `wxa_openid` (`wxa_openid`),
  UNIQUE KEY `wxapp_openid` (`wxapp_openid`),
  KEY `inviter_id` (`inviter_id`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`inviter_id`) REFERENCES `t_user` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','Administrator',NULL,'6609484d39036b4eaf76c22769677e3260b6b34f','','admin',NULL,NULL,'2019-12-16 10:44:38','1c7213c60d7f4463','NORMAL','1c7213c60d7f4463',NULL,'a1b2c3',NULL,NULL,0,NULL,NULL,'U00000001',1,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'oww44t5B-bEd9Ui64_GWctDGgIww','Derek',NULL,'5dfa9edd348c94e98db897c9f21323436ec4d75f',NULL,NULL,'oww44t5B-bEd9Ui64_GWctDGgIww','2019-12-16 11:03:45','2019-12-16 11:25:46','becebb444089cf6b','NORMAL','becebb444089cf6b','2020-01-15 11:25:46','c65684616bd6cf6fd2ade3f31ca0584a',NULL,'http://thirdwx.qlogo.cn/mmopen/vi_32/FzOUdibliawPRR0YAqk0L1cYwW8ib8YEUNSibAj3cJgDKW6ET6cBibI0NMy3WPxwt6VX2WiaoY6pj73mPENNPPCWeXbQ/132',1,NULL,NULL,'U011912161103450001',1,NULL,NULL,'http://mall.smallsaas.cn/app/app?invite_code=',NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_coupon_notify`
--

DROP TABLE IF EXISTS `t_user_coupon_notify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_coupon_notify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `is_notified` int(11) NOT NULL DEFAULT '0',
  `coupon_value` int(11) DEFAULT '0',
  `coupon_count` int(11) DEFAULT '0',
  `notify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`),
  CONSTRAINT `t_user_coupon_notify_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_coupon_notify`
--

LOCK TABLES `t_user_coupon_notify` WRITE;
/*!40000 ALTER TABLE `t_user_coupon_notify` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_coupon_notify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_join_notify`
--

DROP TABLE IF EXISTS `t_user_join_notify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_join_notify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `join_time` datetime DEFAULT NULL,
  `is_read` smallint(6) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_user_join_notify_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_join_notify`
--

LOCK TABLES `t_user_join_notify` WRITE;
/*!40000 ALTER TABLE `t_user_join_notify` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_join_notify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_role`
--

DROP TABLE IF EXISTS `t_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `t_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_role`
--

LOCK TABLES `t_user_role` WRITE;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` VALUES (1,1),(2,4);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_settled_merchant`
--

DROP TABLE IF EXISTS `t_user_settled_merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_settled_merchant` (
  `user_id` int(11) NOT NULL,
  `merchant_id` int(11) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `merchant_id` (`merchant_id`),
  CONSTRAINT `t_user_settled_merchant_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_user_settled_merchant_ibfk_2` FOREIGN KEY (`merchant_id`) REFERENCES `t_settled_merchant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_settled_merchant`
--

LOCK TABLES `t_user_settled_merchant` WRITE;
/*!40000 ALTER TABLE `t_user_settled_merchant` DISABLE KEYS */;
INSERT INTO `t_user_settled_merchant` VALUES (1,1);
/*!40000 ALTER TABLE `t_user_settled_merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wallet`
--

DROP TABLE IF EXISTS `t_wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wallet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `accumulative_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '实际累计储值',
  `accumulative_gift_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '赠送累计储值',
  `balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '实际余额',
  `gift_balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '赠送余额',
  `password` varchar(250) DEFAULT NULL COMMENT '支付密码',
  `salt` varchar(250) DEFAULT NULL COMMENT '密码盐',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_wallet_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wallet`
--

LOCK TABLES `t_wallet` WRITE;
/*!40000 ALTER TABLE `t_wallet` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wallet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wallet_charge`
--

DROP TABLE IF EXISTS `t_wallet_charge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wallet_charge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wallet_id` int(11) NOT NULL,
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '充值金额',
  `gift_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '赠送金额',
  `status` varchar(50) DEFAULT NULL COMMENT '待支付/已支付/关闭',
  `created_time` datetime DEFAULT NULL,
  `paid_time` datetime DEFAULT NULL,
  `out_trade_no` varchar(50) DEFAULT NULL,
  `pay_type` varchar(50) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `wallet_id` (`wallet_id`),
  CONSTRAINT `t_wallet_charge_ibfk_1` FOREIGN KEY (`wallet_id`) REFERENCES `t_wallet` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wallet_charge`
--

LOCK TABLES `t_wallet_charge` WRITE;
/*!40000 ALTER TABLE `t_wallet_charge` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wallet_charge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wallet_history`
--

DROP TABLE IF EXISTS `t_wallet_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wallet_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wallet_id` int(11) NOT NULL,
  `created_time` datetime DEFAULT NULL,
  `type` varchar(50) NOT NULL COMMENT '类型：支付/充值/提现',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '发生金额',
  `gift_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '赠送储值，充值时用',
  `balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '实际余额',
  `gift_balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '赠送余额',
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `wallet_id` (`wallet_id`),
  CONSTRAINT `t_wallet_history_ibfk_1` FOREIGN KEY (`wallet_id`) REFERENCES `t_wallet` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wallet_history`
--

LOCK TABLES `t_wallet_history` WRITE;
/*!40000 ALTER TABLE `t_wallet_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wallet_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wechat_field`
--

DROP TABLE IF EXISTS `t_wechat_field`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wechat_field` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prop_id` int(11) NOT NULL,
  `template_message_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `prop_id` (`prop_id`),
  KEY `template_message_id` (`template_message_id`),
  CONSTRAINT `t_wechat_field_ibfk_1` FOREIGN KEY (`prop_id`) REFERENCES `t_wechat_message_type_prop` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_wechat_field_ibfk_2` FOREIGN KEY (`template_message_id`) REFERENCES `t_wechat_template_message` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wechat_field`
--

LOCK TABLES `t_wechat_field` WRITE;
/*!40000 ALTER TABLE `t_wechat_field` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wechat_field` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wechat_keyword_autoreply`
--

DROP TABLE IF EXISTS `t_wechat_keyword_autoreply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wechat_keyword_autoreply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `keyword` varchar(50) DEFAULT NULL,
  `enabled` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wechat_keyword_autoreply`
--

LOCK TABLES `t_wechat_keyword_autoreply` WRITE;
/*!40000 ALTER TABLE `t_wechat_keyword_autoreply` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wechat_keyword_autoreply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wechat_keyword_autoreply_item`
--

DROP TABLE IF EXISTS `t_wechat_keyword_autoreply_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wechat_keyword_autoreply_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyword_id` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `digest` varchar(200) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `content` text,
  `url` varchar(255) DEFAULT NULL,
  `thumb_url` varchar(255) DEFAULT NULL,
  `enabled` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `keyword_id` (`keyword_id`),
  CONSTRAINT `t_wechat_keyword_autoreply_item_ibfk_1` FOREIGN KEY (`keyword_id`) REFERENCES `t_wechat_keyword_autoreply` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wechat_keyword_autoreply_item`
--

LOCK TABLES `t_wechat_keyword_autoreply_item` WRITE;
/*!40000 ALTER TABLE `t_wechat_keyword_autoreply_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wechat_keyword_autoreply_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wechat_message_autoreply`
--

DROP TABLE IF EXISTS `t_wechat_message_autoreply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wechat_message_autoreply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `digest` varchar(200) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `content` text,
  `url` varchar(255) DEFAULT NULL,
  `thumb_url` varchar(255) DEFAULT NULL,
  `enabled` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wechat_message_autoreply`
--

LOCK TABLES `t_wechat_message_autoreply` WRITE;
/*!40000 ALTER TABLE `t_wechat_message_autoreply` DISABLE KEYS */;
INSERT INTO `t_wechat_message_autoreply` VALUES (1,'TEXT',NULL,NULL,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `t_wechat_message_autoreply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wechat_message_type`
--

DROP TABLE IF EXISTS `t_wechat_message_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wechat_message_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `display_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=303 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wechat_message_type`
--

LOCK TABLES `t_wechat_message_type` WRITE;
/*!40000 ALTER TABLE `t_wechat_message_type` DISABLE KEYS */;
INSERT INTO `t_wechat_message_type` VALUES (1,'order-created','成功下单通知'),(2,'order-refunded','订单退款通知'),(3,'order-canceled','取消订单通知'),(4,'order-pay-timeout','订单支付超时通知'),(5,'order-delivering','订单发货通知'),(6,'order-service-created','订单退款申请通知'),(100,'reward-cash-applying','提现申请提交成功通知'),(101,'reward-cash-handling','提现申请处理中通知'),(102,'reward-cash-rejected','提现申请被拒绝通知'),(103,'reward-cash-completed','成功提现通知'),(200,'coupon-dispatched','优惠券发送通知'),(201,'coupon-overdue','优惠券即将到期通知'),(300,'temp-crown-approved','成为临时皇冠商通知'),(301,'physical-seller-approved','成为星级经销商通知'),(302,'temp-crown-resetted','临时皇冠商撤销通知');
/*!40000 ALTER TABLE `t_wechat_message_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wechat_message_type_prop`
--

DROP TABLE IF EXISTS `t_wechat_message_type_prop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wechat_message_type_prop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `display_name` varchar(50) DEFAULT NULL,
  `display_value` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_wechat_message_type_prop_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_wechat_message_type` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wechat_message_type_prop`
--

LOCK TABLES `t_wechat_message_type_prop` WRITE;
/*!40000 ALTER TABLE `t_wechat_message_type_prop` DISABLE KEYS */;
INSERT INTO `t_wechat_message_type_prop` VALUES (1,1,'title','标题',NULL),(2,1,'order-number','订单号',NULL),(3,1,'order-price','订单金额',NULL),(4,1,'contact-user','收货人',NULL),(5,1,'contact-address','收货地址',NULL),(6,1,'contact-phone','联系电话',NULL),(7,1,'remark','备注',NULL),(8,2,'title','标题',NULL),(9,2,'order-number','订单号',NULL),(10,2,'order-price','订单金额',NULL),(11,2,'refunded-time','退款时间',NULL),(12,2,'remark','备注',NULL),(13,3,'title','标题',NULL),(14,3,'order-number','订单号',NULL),(15,3,'order-price','订单金额',NULL),(16,3,'canceled-time','取消时间',NULL),(17,3,'remark','备注',NULL),(18,4,'title','标题',NULL),(19,4,'order-number','订单号',NULL),(20,4,'remark','备注',NULL),(21,5,'title','标题',NULL),(22,5,'order-number','订单号',NULL),(23,5,'express-company','快递公司',NULL),(24,5,'express-number','快递单号',NULL),(25,5,'contact-user','收件人',NULL),(26,5,'remark','备注',NULL),(27,6,'title','标题',NULL),(28,6,'order-number','订单号',NULL),(29,6,'order-price','退款金额',NULL),(30,6,'remark','备注',NULL),(31,100,'title','标题',NULL),(32,100,'amount','金额',NULL),(33,100,'apply-time','申请时间',NULL),(34,100,'remark','备注',NULL),(35,101,'title','标题',NULL),(36,101,'remark','备注',NULL),(37,102,'title','标题',NULL),(38,102,'rejected-time','拒绝时间',NULL),(39,102,'reason','拒绝原因',NULL),(40,102,'remark','备注',NULL),(41,103,'title','标题',NULL),(42,103,'amount','金额',NULL),(43,103,'completed-time','提现成功时间',NULL),(44,103,'remark','备注',NULL),(45,200,'title','标题',NULL),(46,200,'message','消息',NULL),(47,200,'valid-date','到期日',NULL),(48,200,'remark','备注',NULL),(49,201,'title','标题',NULL),(50,201,'message','消息',NULL),(51,201,'overdue-date','到期日',NULL),(52,201,'remark','备注',NULL),(53,300,'title','标题',NULL),(54,300,'assignor','授权人',NULL),(55,300,'assignee','被授权人',NULL),(56,300,'status','授权状态',NULL),(57,300,'remark','备注',NULL),(58,301,'title','标题',NULL),(59,301,'assignor','授权人',NULL),(60,301,'assignee','被授权人',NULL),(61,301,'status','授权状态',NULL),(62,301,'remark','备注',NULL),(63,302,'title','标题',NULL),(64,302,'resetted-time','时间',NULL),(65,302,'reason','原因',NULL),(66,302,'remark','备注',NULL);
/*!40000 ALTER TABLE `t_wechat_message_type_prop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wechat_subscribe_autoreply`
--

DROP TABLE IF EXISTS `t_wechat_subscribe_autoreply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wechat_subscribe_autoreply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `digest` varchar(200) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `content` text,
  `url` varchar(255) DEFAULT NULL,
  `thumb_url` varchar(255) DEFAULT NULL,
  `enabled` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wechat_subscribe_autoreply`
--

LOCK TABLES `t_wechat_subscribe_autoreply` WRITE;
/*!40000 ALTER TABLE `t_wechat_subscribe_autoreply` DISABLE KEYS */;
INSERT INTO `t_wechat_subscribe_autoreply` VALUES (1,'TEXT',NULL,NULL,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `t_wechat_subscribe_autoreply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wechat_template_message`
--

DROP TABLE IF EXISTS `t_wechat_template_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wechat_template_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `template_id` varchar(200) NOT NULL,
  `type_id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `enabled` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_wechat_template_message_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_wechat_message_type` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wechat_template_message`
--

LOCK TABLES `t_wechat_template_message` WRITE;
/*!40000 ALTER TABLE `t_wechat_template_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wechat_template_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wholesale`
--

DROP TABLE IF EXISTS `t_wholesale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wholesale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `marketing_name` varchar(200) NOT NULL,
  `marketing_short_name` varchar(50) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `sale` int(11) DEFAULT '0',
  `cover` varchar(255) DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `description` text,
  `settlement_proportion` int(11) DEFAULT NULL,
  `agent_proportion` decimal(10,2) DEFAULT NULL,
  `sort_order` int(11) DEFAULT '100',
  `unit` varchar(50) DEFAULT NULL,
  `suggested_retail_unit` varchar(50) DEFAULT NULL,
  `suggested_wholesale_unit` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `t_wholesale_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `t_wholesale_category` (`id`) ON DELETE SET NULL,
  CONSTRAINT `t_wholesale_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wholesale`
--

LOCK TABLES `t_wholesale` WRITE;
/*!40000 ALTER TABLE `t_wholesale` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wholesale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wholesale_category`
--

DROP TABLE IF EXISTS `t_wholesale_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wholesale_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `sort_order` int(11) DEFAULT '100',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wholesale_category`
--

LOCK TABLES `t_wholesale_category` WRITE;
/*!40000 ALTER TABLE `t_wholesale_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wholesale_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wholesale_member`
--

DROP TABLE IF EXISTS `t_wholesale_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wholesale_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wholesale_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_time` timestamp NULL DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_real_name` varchar(50) DEFAULT NULL,
  `user_phone` varchar(50) DEFAULT NULL,
  `order_number` varchar(50) NOT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_wholesale_member_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wholesale_member`
--

LOCK TABLES `t_wholesale_member` WRITE;
/*!40000 ALTER TABLE `t_wholesale_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wholesale_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_wholesale_pricing`
--

DROP TABLE IF EXISTS `t_wholesale_pricing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_wholesale_pricing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wholesale_id` int(11) NOT NULL,
  `region` text,
  `price` decimal(10,2) NOT NULL,
  `suggested_retail_price` decimal(10,2) DEFAULT NULL,
  `suggested_wholesale_price` decimal(10,2) DEFAULT NULL,
  `is_default` int(11) DEFAULT '0',
  `enabled` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `wholesale_id` (`wholesale_id`),
  CONSTRAINT `t_wholesale_pricing_ibfk_1` FOREIGN KEY (`wholesale_id`) REFERENCES `t_wholesale` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_wholesale_pricing`
--

LOCK TABLES `t_wholesale_pricing` WRITE;
/*!40000 ALTER TABLE `t_wholesale_pricing` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wholesale_pricing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_widget`
--

DROP TABLE IF EXISTS `t_widget`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_widget` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `width` int(11) NOT NULL DEFAULT '12',
  `sort_order` int(11) NOT NULL DEFAULT '1',
  `visible` int(11) DEFAULT '1',
  `display_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_widget`
--

LOCK TABLES `t_widget` WRITE;
/*!40000 ALTER TABLE `t_widget` DISABLE KEYS */;
INSERT INTO `t_widget` VALUES (1,'product.overview','/product/widget',4,1,1,'产品概况'),(2,'partner.overview','/seller/widget',8,2,1,'合作伙伴统计'),(3,'order.overview','/order/widget',12,3,1,'订单信息'),(4,'merchant_apply.overview','/merchant_apply/widget',12,4,1,'商家申请');
/*!40000 ALTER TABLE `t_widget` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_withdraw_account`
--

DROP TABLE IF EXISTS `t_withdraw_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_withdraw_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `bank_name` varchar(50) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  `owner_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_withdraw_account_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_withdraw_account`
--

LOCK TABLES `t_withdraw_account` WRITE;
/*!40000 ALTER TABLE `t_withdraw_account` DISABLE KEYS */;
INSERT INTO `t_withdraw_account` VALUES (1,1,'WECHAT',NULL,NULL,'Administrator'),(2,2,'WECHAT',NULL,'oww44t5B-bEd9Ui64_GWctDGgIww','Derek'),(3,2,'WALLET',NULL,'2','Derek');
/*!40000 ALTER TABLE `t_withdraw_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-16 11:47:54
