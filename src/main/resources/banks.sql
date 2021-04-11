CREATE DATABASE  IF NOT EXISTS `bank`;
USE `bank`;
DROP TABLE IF EXISTS `institutions`;
CREATE TABLE `institutions` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(40) NOT NULL COMMENT '机构名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
LOCK TABLES `institutions` WRITE;
/*!40000 ALTER TABLE `institutions` DISABLE KEYS */;
INSERT INTO `institutions` VALUES (10,'南小食有限公司'),(9,'南食'),(8,'野村证券公司');
/*!40000 ALTER TABLE `institutions` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int(40) not null AUTO_INCREMENT,
  `code` varchar(40) NOT NULL  COMMENT '客户号',
  `name` varchar(40) NOT NULL COMMENT '用户名',
  `id_number` varchar(20) NOT NULL COMMENT '证件号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (14,'demo001202104079','南小食客户一','465432134566789097'),(13,'demo001202104078','张三','432561200009087821');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `cards`;
CREATE TABLE `cards` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `balance` double(20,4) DEFAULT 0 ,
  `customer_code` varchar(40) DEFAULT NULL COMMENT '客户号',
  `account_num` varchar(20) DEFAULT NULL COMMENT '银行卡账号',
  `password` varchar(40) not null COMMENT '加密后的银行卡密码',
  PRIMARY KEY (`id`)
  -- foreign key(customer_code) references customers(code), 外键约束，银行卡客户号来自客户号或者机构号
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 创建属于南小食客户一的两张信用卡，属于南小食有限公司的一张信用卡 

LOCK TABLES `cards` WRITE;
/*!40000 ALTER TABLE `cards` DISABLE KEYS */;
-- todo 写密码加密算法的时候把这三个乱填的密码换成加密后的密码 
INSERT INTO `cards` VALUES 
(27,84911.6586,'demo001202104079','6161779470821245928','dsaddadaewradada'),
(30,0.0000,'demo001202104079','6161779470821216793','wrrewrsdfsfsfgdfgd'),
(28,4567.0000,'南小食有限公司','716177967387571','dadadafddagfdfgdd');
/*!40000 ALTER TABLE `cards` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `loans`;
CREATE TABLE `loans` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `iou_num` varchar(40) NOT NULL  COMMENT '借据号',
  `customer_code` varchar(40) DEFAULT NULL COMMENT '客户号',
  `account_num` varchar(20) not NULL COMMENT '银行卡账号',
  `yearly_rate` double(20,4) default 0.0 COMMENT '年利率',
  `repayment_count` int(10) not null comment '',
  `due_date` Date not null COMMENT '应还日期',
  `loan_date` Date not null COMMENT '贷款日期',
  `loan_cost` double(20,4) not null COMMENT '贷款相关费用',
  `loan_amount` double(20,4) not null COMMENT '贷款费用',
  `product_code` varchar(20) not null COMMENT '产品编号', 
  `institution_account_num` varchar(20) not NULL COMMENT '所贷款机构的银行卡',
  PRIMARY KEY (`id`)
  --  todo KEY `loans_ibfk_1` (`account_num`),
--   CONSTRAINT `loans_ibfk_1` FOREIGN KEY (`account_num`) REFERENCES `cards`(`account_num`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `loans` WRITE;
/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
-- 创建南小食客户一的两个贷款，一个未过期，一个过期
INSERT INTO `loans` VALUES 
(8,"L2104081553341","demo001202104079",'6161779470821245928',4.0000,2,'2021-06-07','2021-04-07',10.0000,9990.0000,"40001","716177967387571"),
(9,"L2104081553342","demo001202104079",'6161779470821245928',4.0000,3,'2021-04-07','2021-01-07',10.0000,19990.0000,"40001","716177967387571");
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `repay_plans`;
CREATE TABLE `repay_plans` (
  `id` int(40) not null AUTO_INCREMENT,
  `iou_num` varchar(40) NOT NULL COMMENT '' ,
  `create_time` datetime not null ,
  `plan_num` double(20,4) not null COMMENT '本次贷款的第几期',
  `plan_amount` double(20,4) not null,
  `plan_principal` double(20,4) default 0,
  `plan_interest` double(20,4) default 0,  
  `plan_date` date not null,
  `remain_amount` double(20,4) not null,
  `remain_principal` double(20,4) not null,
  `remain_interest` double(20,4) default 0,
  `fine` double(20,4) default 0 COMMENT '罚金',
  `status` int(2) default 0 COMMENT '0：默认，1：逾期，有罚金且未还罚金，2，逾期，已还罚金，3：正常还款',
  PRIMARY KEY (`id`)
  -- todo foreign key(iou_num) references loans(iou_num)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
LOCK TABLES `repay_plans` WRITE;
/*!40000 ALTER TABLE `repay_plans` DISABLE KEYS */;
INSERT INTO `repay_plans` VALUES 
(11,'L2104081553341','2021-04-07 20:53:27',1,5025.0114,4991.6814,33.3300,'2021-05-07',5025.0114,4991.6814,33.3300,0,0),
(12,'L2104081553341','2021-04-07 20:53:27',2,5025.0114,5008.3187,16.6927,'2021-06-07',5025.0114,5008.3187,16.6927,0,0),
(13,'L2104081553342','2021-01-07 20:53:27',1,6712.2785,6643.9385,68.3400,'2021-02-07',6712.2785,6643.9385,68.3400,335.6139,1),
(14,'L2104081553342','2021-01-07 20:53:27',2,6712.2785,6666.6408,45.6377,'2021-03-07',6712.2785,6666.6408,45.6377,0,0),
(15,'L2104081553342','2021-01-07 20:53:27',3,6712.2785,6689.4207,22.8578,'2021-04-07',6712.2785,6689.4207,22.8578,0,0);
/*!40000 ALTER TABLE `repay_plans` ENABLE KEYS */;
UNLOCK TABLES;
