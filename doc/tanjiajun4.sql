/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : tanjiajun

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-04-12 16:57:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_acter`
-- ----------------------------
DROP TABLE IF EXISTS `t_acter`;
CREATE TABLE `t_acter` (
  `acterid` int(11) NOT NULL AUTO_INCREMENT,
  `actername` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`acterid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_acter
-- ----------------------------
INSERT INTO `t_acter` VALUES ('1', '管理员');

-- ----------------------------
-- Table structure for `t_allorder`
-- ----------------------------
DROP TABLE IF EXISTS `t_allorder`;
CREATE TABLE `t_allorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordercode` varchar(100) DEFAULT NULL,
  `sum` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  `ordertype` int(11) DEFAULT NULL,
  `orderreason` varchar(255) DEFAULT NULL,
  `paytype` varchar(255) DEFAULT NULL,
  `hospitalid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_14` (`userid`),
  KEY `FK_Reference_13` (`hospitalid`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`hospitalid`) REFERENCES `t_hospital` (`id`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_allorder
-- ----------------------------
INSERT INTO `t_allorder` VALUES ('1', 'No00001', '66', '未审核', '1', '2018-03-06 12:21:00', '1', '正常入库', '现金', null);
INSERT INTO `t_allorder` VALUES ('2', 'No00002', '44', '未审核', '1', '2018-03-06 14:41:00', '3', '正常出库', '银行卡', '1');
INSERT INTO `t_allorder` VALUES ('3', 'No00003', '10', '审核通过', '1', '2018-03-06 12:21:00', '3', '正常出库', '银行卡', '1');

-- ----------------------------
-- Table structure for `t_allorderdetail`
-- ----------------------------
DROP TABLE IF EXISTS `t_allorderdetail`;
CREATE TABLE `t_allorderdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medicineid` int(11) DEFAULT NULL,
  `producterid` int(11) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `num` varchar(50) DEFAULT NULL,
  `sum` varchar(50) DEFAULT NULL,
  `allorderid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_10` (`allorderid`),
  KEY `FK_Reference_11` (`medicineid`),
  KEY `FK_Reference_12` (`producterid`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`allorderid`) REFERENCES `t_allorder` (`id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`medicineid`) REFERENCES `t_medicine` (`id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`producterid`) REFERENCES `t_producter` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_allorderdetail
-- ----------------------------
INSERT INTO `t_allorderdetail` VALUES ('1', '1', '1', '14', '4', '56', '1');
INSERT INTO `t_allorderdetail` VALUES ('2', '2', '1', '10', '1', '10', '1');
INSERT INTO `t_allorderdetail` VALUES ('3', '1', '1', '16', '2', '32', '2');
INSERT INTO `t_allorderdetail` VALUES ('4', '1', '1', '16', '1', '16', '3');
INSERT INTO `t_allorderdetail` VALUES ('5', '2', '1', '12', '1', '12', '2');

-- ----------------------------
-- Table structure for `t_hospital`
-- ----------------------------
DROP TABLE IF EXISTS `t_hospital`;
CREATE TABLE `t_hospital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  `manager` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hospital
-- ----------------------------
INSERT INTO `t_hospital` VALUES ('1', '医院中医药房', '中国', '12345678975', '2018-02-27', '大明22');
INSERT INTO `t_hospital` VALUES ('2', '东莞中医院', '啊实打实大', '13456789091', '2018-03-22', '大志');

-- ----------------------------
-- Table structure for `t_limit`
-- ----------------------------
DROP TABLE IF EXISTS `t_limit`;
CREATE TABLE `t_limit` (
  `limitid` int(11) NOT NULL AUTO_INCREMENT,
  `limitname` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`limitid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_limit
-- ----------------------------
INSERT INTO `t_limit` VALUES ('1', '供应商管理', 'ProducterList', '1');
INSERT INTO `t_limit` VALUES ('2', '医院药房管理', 'HospitalList', '1');
INSERT INTO `t_limit` VALUES ('3', '药品管理', 'MedicineList', '1');
INSERT INTO `t_limit` VALUES ('4', '品种管理', 'MedicinetypeList', '2');
INSERT INTO `t_limit` VALUES ('5', '价格管理', 'MedicinePriceList?type=price', '1');
INSERT INTO `t_limit` VALUES ('6', '库存管理', 'MedicineFatoryList?type=fatory', '2');
INSERT INTO `t_limit` VALUES ('7', '单据管理', 'AllorderList?type=all', '2');
INSERT INTO `t_limit` VALUES ('8', '入库管理', 'AllorderList?type=in', '3');
INSERT INTO `t_limit` VALUES ('9', '出库管理', 'AllorderList?type=out', '3');
INSERT INTO `t_limit` VALUES ('10', '查询统计', 'TongJiList', '4');
INSERT INTO `t_limit` VALUES ('11', '售价管理', 'MedicineFatoryList?type=price', '2');
INSERT INTO `t_limit` VALUES ('12', '有效期管理', 'MedicinePriceList?type=date', '1');

-- ----------------------------
-- Table structure for `t_medicine`
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine`;
CREATE TABLE `t_medicine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `guige` varchar(50) DEFAULT NULL,
  `danwei` varchar(50) DEFAULT NULL,
  `othername` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_9` (`typeid`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`typeid`) REFERENCES `t_medicinetype` (`protypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicine
-- ----------------------------
INSERT INTO `t_medicine` VALUES ('1', 'HP123456', '复方氢氧化铝片', '2', '1盒/12片', '盒', '胃舒平', '2018-04-12 13:39:50');
INSERT INTO `t_medicine` VALUES ('2', 'HP000001', '复方醋酸地塞米松乳膏', '1', '1袋/500cc', '袋', '皮炎平', '2018-03-04 10:58:28');

-- ----------------------------
-- Table structure for `t_medicinefatory`
-- ----------------------------
DROP TABLE IF EXISTS `t_medicinefatory`;
CREATE TABLE `t_medicinefatory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medname` varchar(255) DEFAULT NULL,
  `comeprice` varchar(50) DEFAULT NULL,
  `sellpricenow` varchar(50) DEFAULT NULL,
  `sellpricebef` varchar(50) DEFAULT NULL,
  `updatetime` varchar(100) DEFAULT NULL,
  `producttime` varchar(100) DEFAULT NULL,
  `valuetime` varchar(100) DEFAULT NULL,
  `shengyuliang` varchar(50) DEFAULT NULL,
  `jinhuoliang` varchar(50) DEFAULT NULL,
  `productid` int(11) DEFAULT NULL,
  `medicineid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_1` (`productid`),
  KEY `FK_Reference_2` (`medicineid`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`productid`) REFERENCES `t_producter` (`id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`medicineid`) REFERENCES `t_medicine` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicinefatory
-- ----------------------------
INSERT INTO `t_medicinefatory` VALUES ('1', '胃舒平2', '14', '17', '17', '2018-04-12 13:35:35', '2018-2-28', '2016-2-28', '50', '50', '1', '1');

-- ----------------------------
-- Table structure for `t_medicinetype`
-- ----------------------------
DROP TABLE IF EXISTS `t_medicinetype`;
CREATE TABLE `t_medicinetype` (
  `protypeid` int(11) NOT NULL AUTO_INCREMENT,
  `protypename` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`protypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicinetype
-- ----------------------------
INSERT INTO `t_medicinetype` VALUES ('1', '输液', '2018-03-03 11:27:20', '');
INSERT INTO `t_medicinetype` VALUES ('2', '口服', '2018-03-03 11:27:23', '');

-- ----------------------------
-- Table structure for `t_medpromiddle`
-- ----------------------------
DROP TABLE IF EXISTS `t_medpromiddle`;
CREATE TABLE `t_medpromiddle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `medid` int(11) DEFAULT NULL,
  `proid` int(11) DEFAULT NULL,
  `prodate` varchar(100) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_7` (`proid`),
  KEY `FK_Reference_8` (`medid`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`proid`) REFERENCES `t_producter` (`id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`medid`) REFERENCES `t_medicine` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_medpromiddle
-- ----------------------------
INSERT INTO `t_medpromiddle` VALUES ('1', '17', '1', '3', '2018-04-01', '12');
INSERT INTO `t_medpromiddle` VALUES ('3', '10', '2', '3', '20180412', '3');
INSERT INTO `t_medpromiddle` VALUES ('4', '14', '1', '1', '20180412', '3');

-- ----------------------------
-- Table structure for `t_middle`
-- ----------------------------
DROP TABLE IF EXISTS `t_middle`;
CREATE TABLE `t_middle` (
  `middleid` int(11) NOT NULL AUTO_INCREMENT,
  `acterid` int(11) DEFAULT NULL,
  `limitid` int(11) DEFAULT NULL,
  PRIMARY KEY (`middleid`),
  KEY `FK_Reference_4` (`acterid`),
  KEY `FK_Reference_5` (`limitid`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`acterid`) REFERENCES `t_acter` (`acterid`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`limitid`) REFERENCES `t_limit` (`limitid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_middle
-- ----------------------------
INSERT INTO `t_middle` VALUES ('1', '1', '1');
INSERT INTO `t_middle` VALUES ('2', '1', '2');
INSERT INTO `t_middle` VALUES ('3', '1', '3');
INSERT INTO `t_middle` VALUES ('4', '1', '4');
INSERT INTO `t_middle` VALUES ('5', '1', '5');
INSERT INTO `t_middle` VALUES ('6', '1', '6');
INSERT INTO `t_middle` VALUES ('7', '1', '7');
INSERT INTO `t_middle` VALUES ('8', '1', '8');
INSERT INTO `t_middle` VALUES ('9', '1', '9');
INSERT INTO `t_middle` VALUES ('10', '1', '10');
INSERT INTO `t_middle` VALUES ('11', '1', '11');
INSERT INTO `t_middle` VALUES ('12', '1', '12');

-- ----------------------------
-- Table structure for `t_producter`
-- ----------------------------
DROP TABLE IF EXISTS `t_producter`;
CREATE TABLE `t_producter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_producter
-- ----------------------------
INSERT INTO `t_producter` VALUES ('1', '吱吱药业', 'bbbc', '324324', '12355465712', null);
INSERT INTO `t_producter` VALUES ('3', 'CC药业', 'aaa', '21321312', '12345678998', '2018-02-25');
INSERT INTO `t_producter` VALUES ('5', 'EE药业', 'ccc', '12321312', '1231231231232', '2018-02-25');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acterid` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `QQ` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_3` (`acterid`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`acterid`) REFERENCES `t_acter` (`acterid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1', 'admin', '傻强', '123456', '12345678901', '菲律宾', '4578621', '4578621@qq.com', null);
