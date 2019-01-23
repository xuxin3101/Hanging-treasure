/*
Navicat MySQL Data Transfer

Source Server         : 诚信科技
Source Server Version : 50641
Source Host           : 47.107.60.226:3306
Source Database       : Hanging-treasure

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2018-12-27 21:20:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `adminusers`
-- ----------------------------
DROP TABLE IF EXISTS `adminusers`;
CREATE TABLE `adminusers` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminusers
-- ----------------------------
INSERT INTO `adminusers` VALUES ('1', 'admin', 'admin');
INSERT INTO `adminusers` VALUES ('2', 'admin1', '021027');
INSERT INTO `adminusers` VALUES ('3', 'admin2', '021027');
INSERT INTO `adminusers` VALUES ('4', 'admin3', '021027');

-- ----------------------------
-- Table structure for `announcement`
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` int(3) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES ('1', '新增PP红包协议调用 试玩平台持续增加中 敬请期待');

-- ----------------------------
-- Table structure for `apps`
-- ----------------------------
DROP TABLE IF EXISTS `apps`;
CREATE TABLE `apps` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `company` varchar(50) DEFAULT NULL,
  `price` float(4,2) NOT NULL,
  `link` text NOT NULL,
  `readtime` int(2) DEFAULT '10',
  `time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apps
-- ----------------------------
INSERT INTO `apps` VALUES ('1', '小鱼赚钱', '1', '0.30', 'http://rr.xmys.org/shiwanbao/baitiaoshenghuo7.1.3.apk', '10', '2018-12-04 19:24:59');
INSERT INTO `apps` VALUES ('7', '钱咖', '2', '0.40', 'http://rr.xmys.org/shiwanbao/baitiao1.2.0.apk', '10', '2018-12-04 21:16:45');
INSERT INTO `apps` VALUES ('9', '钱咖', '3', '0.50', 'http://rr.xmys.org/shiwanbao/CCBjianrongjiayuan1.2.2.apk', '10', '2018-12-24 12:58:15');
INSERT INTO `apps` VALUES ('10', '钱咖', '4', '0.20', 'http://rr.xmys.org/shiwanbao/meiriyujia7.5.0.1.apk', '10', '2018-12-24 12:58:53');
INSERT INTO `apps` VALUES ('11', '111', '5', '0.40', 'http://rr.xmys.org/shiwanbao/pinganhaodai1.8.3.apk', '10', '2018-12-26 16:41:52');
INSERT INTO `apps` VALUES ('12', '爱盈利', '6', '0.20', 'http://rr.xmys.org/shiwanbao/baochichangliang.apk', '10', '2018-12-27 00:01:13');
INSERT INTO `apps` VALUES ('13', '麦子赚', '7', '0.30', 'http://rr.xmys.org/shiwanbao/baochichangliang.apk					', '10', '2018-12-27 12:52:50');
INSERT INTO `apps` VALUES ('14', '蜜蜂试玩', '8', '0.30', 'http://rr.xmys.org/shiwanbao/beidian.apk', '10', '2018-12-27 12:53:54');
INSERT INTO `apps` VALUES ('15', '火箭试玩', '9', '0.20', 'http://rr.xmys.org/shiwanbao/beiguadianhua.apk				', '10', '2018-12-27 12:55:55');
INSERT INTO `apps` VALUES ('16', '海豚试玩', '10', '0.20', 'http://rr.xmys.org/shiwanbao/cangbaoge.apk				', '10', '2018-12-27 12:57:22');
INSERT INTO `apps` VALUES ('17', '狐狸赚', '11', '0.60', 'http://rr.xmys.org/shiwanbao/chaonengjie.apk				', '10', '2018-12-27 13:00:32');
INSERT INTO `apps` VALUES ('18', '天天钱庄', '12', '0.30', 'http://rr.xmys.org/shiwanbao/dongfangyingjia.apk', '10', '2018-12-27 13:01:45');
INSERT INTO `apps` VALUES ('19', '掉钱眼儿', '12', '0.20', 'http://rr.xmys.org/shiwanbao/daidaixia.apk', '10', '2018-12-27 13:02:52');
INSERT INTO `apps` VALUES ('20', '熊猫赚钱', '14', '0.40', 'http://rr.xmys.org/shiwanbao/dongtai.apk', '10', '2018-12-27 13:03:53');
INSERT INTO `apps` VALUES ('21', '头号试玩', '15', '0.30', 'http://rr.xmys.org/shiwanbao/fendengdushu.apk', '10', '2018-12-27 13:05:11');
INSERT INTO `apps` VALUES ('22', '钱大师', '16', '0.20', 'http://rr.xmys.org/shiwanbao/fenpu.apk', '10', '2018-12-27 13:06:15');
INSERT INTO `apps` VALUES ('23', '钱大师', '17', '0.50', 'http://rr.xmys.org/shiwanbao/fenqizhuanjia.apk', '10', '2018-12-27 13:07:33');
INSERT INTO `apps` VALUES ('24', '钱大师', '17', '0.50', 'http://rr.xmys.org/shiwanbao/fenqizhuanjia.apk', '10', '2018-12-27 13:08:28');
INSERT INTO `apps` VALUES ('25', '应用试客', '18', '0.40', 'http://rr.xmys.org/shiwanbao/GirlsCam2.4.2.apk', '10', '2018-12-27 13:12:27');

-- ----------------------------
-- Table structure for `commission_record`
-- ----------------------------
DROP TABLE IF EXISTS `commission_record`;
CREATE TABLE `commission_record` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `appname` varchar(25) NOT NULL,
  `time` datetime NOT NULL,
  `price` float(4,2) NOT NULL,
  `username` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=564 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commission_record
-- ----------------------------
INSERT INTO `commission_record` VALUES ('1', '王者荣耀', '2018-12-13 23:05:18', '1.00', 'admin');
INSERT INTO `commission_record` VALUES ('2', '王者荣耀', '2018-12-22 21:27:53', '1.00', 'admin');
INSERT INTO `commission_record` VALUES ('3', '王者荣耀', '2018-12-22 21:28:07', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('4', '王者荣耀', '2018-12-22 21:29:19', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('5', '王者荣耀', '2018-12-22 21:29:49', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('6', '王者荣耀', '2018-12-22 21:33:13', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('7', '王者荣耀', '2018-12-22 21:34:18', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('8', '王者荣耀', '2018-12-22 21:36:00', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('9', '王者荣耀', '2018-12-22 21:51:51', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('10', '王者荣耀', '2018-12-22 22:00:43', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('11', '王者荣耀', '2018-12-22 22:03:14', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('12', '王者荣耀', '2018-12-22 22:07:45', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('13', '王者荣耀', '2018-12-22 22:25:48', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('14', '小鱼赚钱', '2018-12-24 13:30:30', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('15', '钱咖', '2018-12-24 13:41:35', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('16', '钱咖', '2018-12-24 13:43:33', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('17', '钱咖', '2018-12-24 13:43:43', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('18', '钱咖', '2018-12-24 13:45:17', '0.80', 'admin');
INSERT INTO `commission_record` VALUES ('19', '钱咖', '2018-12-24 13:46:00', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('20', '钱咖', '2018-12-24 13:46:13', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('21', '小鱼赚钱', '2018-12-24 13:47:49', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('22', '小鱼赚钱', '2018-12-24 13:48:34', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('23', '钱咖', '2018-12-24 13:48:54', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('24', '小鱼赚钱', '2018-12-24 13:52:05', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('25', '钱咖', '2018-12-24 13:52:27', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('26', '钱咖', '2018-12-24 13:52:46', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('27', '钱咖', '2018-12-24 13:53:08', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('28', '钱咖', '2018-12-24 13:54:59', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('29', '钱咖', '2018-12-24 13:56:01', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('30', '小鱼赚钱', '2018-12-24 13:57:01', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('31', '小鱼赚钱', '2018-12-24 13:58:29', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('32', '钱咖', '2018-12-24 13:58:47', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('33', '钱咖', '2018-12-24 14:01:00', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('34', '钱咖', '2018-12-24 14:02:42', '0.80', 'admin');
INSERT INTO `commission_record` VALUES ('35', '钱咖', '2018-12-24 14:02:46', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('36', '钱咖', '2018-12-24 14:07:31', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('37', '钱咖', '2018-12-24 14:13:19', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('38', '钱咖', '2018-12-24 14:16:58', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('39', '小鱼赚钱', '2018-12-24 14:19:03', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('40', '钱咖', '2018-12-24 14:21:58', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('41', '钱咖', '2018-12-24 14:22:40', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('42', '钱咖', '2018-12-24 14:27:32', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('43', '钱咖', '2018-12-24 14:27:44', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('44', '小鱼赚钱', '2018-12-24 14:33:04', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('45', '小鱼赚钱', '2018-12-24 14:33:46', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('46', '钱咖', '2018-12-24 14:36:50', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('47', '钱咖', '2018-12-24 14:37:39', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('48', '钱咖', '2018-12-24 15:00:45', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('49', '钱咖', '2018-12-24 15:07:04', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('50', '钱咖', '2018-12-24 15:10:30', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('51', '钱咖', '2018-12-24 15:14:51', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('52', '钱咖', '2018-12-24 15:20:50', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('53', '钱咖', '2018-12-24 15:27:03', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('54', '钱咖', '2018-12-24 15:30:46', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('55', '钱咖', '2018-12-24 15:35:36', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('56', '钱咖', '2018-12-24 15:39:54', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('57', '钱咖', '2018-12-24 15:48:46', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('58', '钱咖', '2018-12-24 15:51:20', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('59', '钱咖', '2018-12-24 15:55:01', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('60', '钱咖', '2018-12-24 15:59:50', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('61', '小鱼赚钱', '2018-12-24 16:06:20', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('62', '小鱼赚钱', '2018-12-24 16:11:57', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('63', '小鱼赚钱', '2018-12-24 16:16:14', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('64', '钱咖', '2018-12-24 16:20:03', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('65', '钱咖', '2018-12-24 16:25:27', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('66', '钱咖', '2018-12-24 16:29:52', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('67', '小鱼赚钱', '2018-12-24 16:36:09', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('68', '钱咖', '2018-12-24 16:40:54', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('69', '钱咖', '2018-12-24 16:45:12', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('70', '钱咖', '2018-12-24 16:51:05', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('71', '小鱼赚钱', '2018-12-24 16:54:50', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('72', '钱咖', '2018-12-24 16:56:33', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('73', '钱咖', '2018-12-24 16:57:47', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('74', '钱咖', '2018-12-24 16:59:52', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('75', '钱咖', '2018-12-24 17:06:37', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('76', '钱咖', '2018-12-24 17:10:50', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('77', '钱咖', '2018-12-24 17:15:43', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('78', '钱咖', '2018-12-24 17:24:51', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('79', '钱咖', '2018-12-24 17:30:01', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('80', '小鱼赚钱', '2018-12-24 23:07:24', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('81', '钱咖', '2018-12-24 23:14:39', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('82', '钱咖', '2018-12-24 23:15:58', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('83', '钱咖', '2018-12-24 23:22:09', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('84', '钱咖', '2018-12-24 23:24:59', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('85', '钱咖', '2018-12-24 23:30:23', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('86', '钱咖', '2018-12-24 23:32:11', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('87', '钱咖', '2018-12-24 23:38:19', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('88', '钱咖', '2018-12-24 23:40:16', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('89', '钱咖', '2018-12-24 23:46:36', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('90', '钱咖', '2018-12-24 23:49:04', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('91', '小鱼赚钱', '2018-12-24 23:55:30', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('92', '钱咖', '2018-12-24 23:56:59', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('93', '钱咖', '2018-12-25 00:02:28', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('94', '钱咖', '2018-12-25 00:04:25', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('95', '小鱼赚钱', '2018-12-25 00:11:35', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('96', '钱咖', '2018-12-25 00:12:10', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('97', '小鱼赚钱', '2018-12-25 00:19:54', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('98', '钱咖', '2018-12-25 00:20:57', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('99', '钱咖', '2018-12-25 00:27:00', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('100', '钱咖', '2018-12-25 00:28:17', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('101', '小鱼赚钱', '2018-12-25 00:35:26', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('102', '钱咖', '2018-12-25 00:36:56', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('103', '钱咖', '2018-12-25 00:42:22', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('104', '钱咖', '2018-12-25 00:44:08', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('105', '钱咖', '2018-12-25 00:50:34', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('106', '小鱼赚钱', '2018-12-25 00:53:21', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('107', '钱咖', '2018-12-25 00:58:22', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('108', '小鱼赚钱', '2018-12-25 01:01:22', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('109', '钱咖', '2018-12-25 01:06:10', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('110', '钱咖', '2018-12-25 01:09:15', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('111', '钱咖', '2018-12-25 01:14:22', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('112', '钱咖', '2018-12-25 01:16:09', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('113', '钱咖', '2018-12-25 01:23:03', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('114', '钱咖', '2018-12-25 01:24:16', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('115', '小鱼赚钱', '2018-12-25 01:31:27', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('116', '钱咖', '2018-12-25 01:32:10', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('117', '钱咖', '2018-12-25 01:38:10', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('118', '钱咖', '2018-12-25 01:40:19', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('119', '钱咖', '2018-12-25 01:47:05', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('120', '钱咖', '2018-12-25 01:48:31', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('121', '钱咖', '2018-12-25 01:54:26', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('122', '钱咖', '2018-12-25 01:57:08', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('123', '钱咖', '2018-12-25 02:04:56', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('124', '小鱼赚钱', '2018-12-25 02:11:37', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('125', '小鱼赚钱', '2018-12-25 02:13:35', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('126', '钱咖', '2018-12-25 02:18:23', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('127', '钱咖', '2018-12-25 02:20:17', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('128', '小鱼赚钱', '2018-12-25 02:27:30', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('129', '钱咖', '2018-12-25 02:28:18', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('130', '钱咖', '2018-12-25 02:34:13', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('131', '钱咖', '2018-12-25 02:36:16', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('132', '钱咖', '2018-12-25 02:43:21', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('133', '钱咖', '2018-12-25 02:44:09', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('134', '钱咖', '2018-12-25 02:50:09', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('135', '钱咖', '2018-12-25 02:52:09', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('136', '钱咖', '2018-12-25 02:58:21', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('137', '钱咖', '2018-12-25 03:00:55', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('138', '钱咖', '2018-12-25 03:06:39', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('139', '钱咖', '2018-12-25 03:09:14', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('140', '钱咖', '2018-12-25 03:15:23', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('141', '钱咖', '2018-12-25 03:16:54', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('142', '钱咖', '2018-12-25 03:23:00', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('143', '钱咖', '2018-12-25 03:24:17', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('144', '钱咖', '2018-12-25 03:30:21', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('145', '钱咖', '2018-12-25 03:32:59', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('146', '钱咖', '2018-12-25 03:38:10', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('147', '钱咖', '2018-12-25 03:40:19', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('148', '小鱼赚钱', '2018-12-25 03:47:38', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('149', '小鱼赚钱', '2018-12-25 03:49:20', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('150', '小鱼赚钱', '2018-12-25 03:55:42', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('151', '钱咖', '2018-12-25 03:56:09', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('152', '小鱼赚钱', '2018-12-25 04:03:26', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('153', '钱咖', '2018-12-25 04:04:57', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('154', '钱咖', '2018-12-25 04:10:25', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('155', '钱咖', '2018-12-25 04:12:18', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('156', '钱咖', '2018-12-25 04:18:25', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('157', '钱咖', '2018-12-25 04:20:18', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('158', '钱咖', '2018-12-25 04:27:01', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('159', '钱咖', '2018-12-25 04:28:24', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('160', '钱咖', '2018-12-25 04:35:01', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('161', '小鱼赚钱', '2018-12-25 04:37:25', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('162', '钱咖', '2018-12-25 04:42:47', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('163', '钱咖', '2018-12-25 04:44:55', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('164', '钱咖', '2018-12-25 04:50:13', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('165', '小鱼赚钱', '2018-12-25 04:53:20', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('166', '钱咖', '2018-12-25 04:58:21', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('167', '钱咖', '2018-12-25 05:00:10', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('168', '钱咖', '2018-12-25 05:06:27', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('169', '小鱼赚钱', '2018-12-25 05:09:23', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('170', '钱咖', '2018-12-25 05:15:06', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('171', '钱咖', '2018-12-25 05:16:17', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('172', '钱咖', '2018-12-25 05:22:10', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('173', '小鱼赚钱', '2018-12-25 05:25:24', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('174', '钱咖', '2018-12-25 05:30:41', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('175', '钱咖', '2018-12-25 05:32:09', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('176', '小鱼赚钱', '2018-12-25 05:39:23', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('177', '钱咖', '2018-12-25 05:40:57', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('178', '钱咖', '2018-12-25 05:46:25', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('179', '小鱼赚钱', '2018-12-25 05:49:24', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('180', '小鱼赚钱', '2018-12-25 05:55:38', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('181', '钱咖', '2018-12-25 05:56:10', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('182', '钱咖', '2018-12-25 06:10:22', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('183', '钱咖', '2018-12-25 06:12:09', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('184', '钱咖', '2018-12-25 06:20:10', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('185', '钱咖', '2018-12-25 06:26:09', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('186', '钱咖', '2018-12-25 06:28:09', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('187', '钱咖', '2018-12-25 06:34:23', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('188', '钱咖', '2018-12-25 06:36:17', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('189', '小鱼赚钱', '2018-12-25 06:43:39', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('190', '钱咖', '2018-12-25 06:44:57', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('191', '钱咖', '2018-12-25 06:50:21', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('192', '钱咖', '2018-12-25 06:53:09', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('193', '钱咖', '2018-12-25 06:59:15', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('194', '钱咖', '2018-12-25 07:00:18', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('195', '小鱼赚钱', '2018-12-25 07:07:23', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('196', '钱咖', '2018-12-25 07:08:17', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('197', '小鱼赚钱', '2018-12-25 07:15:57', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('198', '钱咖', '2018-12-25 07:17:29', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('199', '钱咖', '2018-12-25 07:23:13', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('200', '钱咖', '2018-12-25 07:25:08', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('201', '钱咖', '2018-12-25 07:30:26', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('202', '钱咖', '2018-12-25 07:33:03', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('203', '钱咖', '2018-12-25 07:38:22', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('204', '钱咖', '2018-12-25 07:40:31', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('205', '钱咖', '2018-12-25 07:47:15', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('206', '钱咖', '2018-12-25 07:48:17', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('207', '钱咖', '2018-12-25 07:55:28', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('208', '钱咖', '2018-12-25 07:56:58', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('209', '小鱼赚钱', '2018-12-25 08:04:11', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('210', '钱咖', '2018-12-25 08:04:18', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('211', '钱咖', '2018-12-25 08:10:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('212', '钱咖', '2018-12-25 08:13:19', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('213', '钱咖', '2018-12-25 08:18:25', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('214', '小鱼赚钱', '2018-12-25 08:21:28', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('215', '钱咖', '2018-12-25 08:26:14', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('216', '小鱼赚钱', '2018-12-25 08:29:37', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('217', '钱咖', '2018-12-25 08:35:04', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('218', '钱咖', '2018-12-25 08:36:10', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('219', '钱咖', '2018-12-25 08:42:22', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('220', '钱咖', '2018-12-25 08:44:20', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('221', '小鱼赚钱', '2018-12-25 08:51:47', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('222', '钱咖', '2018-12-25 08:52:30', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('223', '钱咖', '2018-12-25 08:58:24', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('224', '小鱼赚钱', '2018-12-25 09:03:25', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('225', '小鱼赚钱', '2018-12-25 09:07:28', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('226', '钱咖', '2018-12-25 09:09:10', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('227', '钱咖', '2018-12-25 09:14:21', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('228', '钱咖', '2018-12-25 09:16:56', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('229', '钱咖', '2018-12-25 09:23:21', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('230', '钱咖', '2018-12-25 09:24:54', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('231', '钱咖', '2018-12-25 09:31:35', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('232', '钱咖', '2018-12-25 09:32:18', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('233', '钱咖', '2018-12-25 09:38:22', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('234', '钱咖', '2018-12-25 09:40:32', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('235', '小鱼赚钱', '2018-12-25 09:47:25', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('236', '钱咖', '2018-12-25 09:48:17', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('237', '钱咖', '2018-12-25 09:55:35', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('238', '小鱼赚钱', '2018-12-25 09:57:26', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('239', '钱咖', '2018-12-25 10:02:27', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('240', '钱咖', '2018-12-25 10:05:11', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('241', '小鱼赚钱', '2018-12-25 10:11:34', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('242', '钱咖', '2018-12-25 10:12:10', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('243', '钱咖', '2018-12-25 10:19:00', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('244', '钱咖', '2018-12-25 10:20:09', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('245', '小鱼赚钱', '2018-12-25 10:27:23', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('246', '钱咖', '2018-12-25 10:29:02', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('247', '钱咖', '2018-12-25 10:34:13', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('248', '钱咖', '2018-12-25 10:36:09', '0.80', '18596386660');
INSERT INTO `commission_record` VALUES ('249', '钱咖', '2018-12-25 10:42:09', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('250', '钱咖', '2018-12-25 10:44:56', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('251', '钱咖', '2018-12-25 10:50:23', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('252', '钱咖', '2018-12-25 10:52:19', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('253', '钱咖', '2018-12-25 10:58:23', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('254', '小鱼赚钱', '2018-12-25 11:01:31', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('255', '钱咖', '2018-12-25 11:06:34', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('256', '钱咖', '2018-12-25 11:08:20', '0.50', '18596386660');
INSERT INTO `commission_record` VALUES ('257', '钱咖', '2018-12-25 11:15:05', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('258', '小鱼赚钱', '2018-12-25 11:17:23', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('259', '钱咖', '2018-12-25 11:24:56', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('260', '小鱼赚钱', '2018-12-25 11:33:28', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('261', '小鱼赚钱', '2018-12-25 11:41:52', '0.60', '18596386660');
INSERT INTO `commission_record` VALUES ('262', '钱咖', '2018-12-25 14:20:56', '0.80', 'admin');
INSERT INTO `commission_record` VALUES ('263', '钱咖', '2018-12-25 14:29:07', '0.80', 'admin');
INSERT INTO `commission_record` VALUES ('264', '钱咖', '2018-12-25 14:37:02', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('265', '钱咖', '2018-12-25 14:45:01', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('266', '钱咖', '2018-12-25 15:02:11', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('267', '钱咖', '2018-12-25 15:08:54', '0.80', 'admin');
INSERT INTO `commission_record` VALUES ('268', '钱咖', '2018-12-25 15:17:31', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('269', '小鱼赚钱', '2018-12-25 15:26:14', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('270', '钱咖', '2018-12-25 15:32:55', '0.80', 'admin');
INSERT INTO `commission_record` VALUES ('271', '小鱼赚钱', '2018-12-25 15:42:35', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('272', '钱咖', '2018-12-25 15:49:04', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('273', '钱咖', '2018-12-25 15:57:21', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('274', '钱咖', '2018-12-25 16:05:03', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('275', '钱咖', '2018-12-25 16:13:02', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('276', '钱咖', '2018-12-25 16:21:01', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('277', '钱咖', '2018-12-25 16:29:02', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('278', '钱咖', '2018-12-25 16:37:06', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('279', '钱咖', '2018-12-25 16:44:56', '0.80', 'admin');
INSERT INTO `commission_record` VALUES ('280', '小鱼赚钱', '2018-12-25 16:54:27', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('281', '小鱼赚钱', '2018-12-25 17:02:21', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('282', '钱咖', '2018-12-25 19:16:35', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('283', '钱咖', '2018-12-25 21:42:27', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('284', '小鱼赚钱', '2018-12-25 22:21:16', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('285', '钱咖', '2018-12-25 22:23:47', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('286', '小鱼赚钱', '2018-12-25 22:44:04', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('287', '钱咖', '2018-12-25 22:52:13', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('288', '钱咖', '2018-12-25 22:59:59', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('289', '小鱼赚钱', '2018-12-25 23:08:04', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('290', '钱咖', '2018-12-25 23:15:59', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('291', '钱咖', '2018-12-25 23:24:00', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('292', '钱咖', '2018-12-25 23:32:12', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('293', '钱咖', '2018-12-25 23:40:13', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('294', '小鱼赚钱', '2018-12-25 23:48:04', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('295', '小鱼赚钱', '2018-12-25 23:56:04', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('296', '钱咖', '2018-12-26 00:04:00', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('297', '钱咖', '2018-12-26 00:12:12', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('298', '小鱼赚钱', '2018-12-26 00:20:04', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('299', '钱咖', '2018-12-26 11:01:48', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('300', '钱咖', '2018-12-26 11:09:50', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('301', '钱咖', '2018-12-26 11:13:46', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('302', '钱咖', '2018-12-26 16:43:50', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('303', '钱咖', '2018-12-26 16:52:23', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('304', '钱咖', '2018-12-26 17:29:36', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('305', '111', '2018-12-26 17:32:42', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('306', '钱咖', '2018-12-26 17:34:29', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('307', '小鱼赚钱', '2018-12-26 17:38:38', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('308', '111', '2018-12-26 17:38:56', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('309', '钱咖', '2018-12-26 17:43:20', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('310', '小鱼赚钱', '2018-12-26 17:45:04', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('311', '钱咖', '2018-12-26 17:48:46', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('312', '小鱼赚钱', '2018-12-26 17:48:57', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('313', '小鱼赚钱', '2018-12-26 17:53:37', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('314', '钱咖', '2018-12-26 17:54:30', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('315', '小鱼赚钱', '2018-12-26 17:58:37', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('316', '111', '2018-12-26 17:58:56', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('317', '小鱼赚钱', '2018-12-26 18:03:41', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('318', '钱咖', '2018-12-26 18:04:33', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('319', '钱咖', '2018-12-26 18:07:29', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('320', '钱咖', '2018-12-26 18:08:42', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('321', '钱咖', '2018-12-26 18:13:46', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('322', '小鱼赚钱', '2018-12-26 18:13:58', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('323', '钱咖', '2018-12-26 18:17:30', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('324', '111', '2018-12-26 18:18:48', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('325', '111', '2018-12-26 18:22:37', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('326', '小鱼赚钱', '2018-12-26 18:24:58', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('327', '小鱼赚钱', '2018-12-26 18:28:36', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('328', '钱咖', '2018-12-26 18:29:29', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('329', '钱咖', '2018-12-26 18:33:44', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('330', '小鱼赚钱', '2018-12-26 18:33:55', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('331', '111', '2018-12-26 18:37:37', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('332', '钱咖', '2018-12-26 18:38:41', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('333', '钱咖', '2018-12-26 18:43:22', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('334', '111', '2018-12-26 18:43:50', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('335', '111', '2018-12-26 18:47:37', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('336', '111', '2018-12-26 18:48:50', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('337', '钱咖', '2018-12-26 18:53:18', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('338', '小鱼赚钱', '2018-12-26 18:55:08', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('339', '钱咖', '2018-12-26 19:00:19', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('340', '111', '2018-12-26 19:02:37', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('341', '小鱼赚钱', '2018-12-26 19:04:58', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('342', '小鱼赚钱', '2018-12-26 19:08:37', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('343', '111', '2018-12-26 20:11:39', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('344', '小鱼赚钱', '2018-12-26 20:16:44', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('345', '小鱼赚钱', '2018-12-26 20:18:31', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('346', '钱咖', '2018-12-26 20:19:03', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('347', '钱咖', '2018-12-26 20:19:34', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('348', '钱咖', '2018-12-26 20:24:13', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('349', '钱咖', '2018-12-26 20:26:16', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('350', '钱咖', '2018-12-26 20:26:28', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('351', '钱咖', '2018-12-26 20:28:24', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('352', '钱咖', '2018-12-26 20:32:13', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('353', '钱咖', '2018-12-26 20:34:15', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('354', '小鱼赚钱', '2018-12-26 20:34:41', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('355', '111', '2018-12-26 20:35:43', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('356', '钱咖', '2018-12-26 20:39:24', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('357', '钱咖', '2018-12-26 20:42:08', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('358', '小鱼赚钱', '2018-12-26 20:43:24', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('359', '钱咖', '2018-12-26 20:44:28', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('360', '钱咖', '2018-12-26 20:48:56', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('361', '小鱼赚钱', '2018-12-26 20:50:36', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('362', '小鱼赚钱', '2018-12-26 20:51:21', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('363', '钱咖', '2018-12-26 20:52:26', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('364', '钱咖', '2018-12-26 20:56:14', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('365', '钱咖', '2018-12-26 20:57:24', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('366', '钱咖', '2018-12-26 20:58:13', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('367', '小鱼赚钱', '2018-12-26 21:00:56', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('368', '钱咖', '2018-12-26 21:04:13', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('369', '111', '2018-12-26 21:05:33', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('370', '小鱼赚钱', '2018-12-26 21:07:22', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('371', '钱咖', '2018-12-26 21:08:29', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('372', '钱咖', '2018-12-26 21:12:13', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('373', '钱咖', '2018-12-26 21:13:23', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('374', '小鱼赚钱', '2018-12-26 21:15:18', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('375', '钱咖', '2018-12-26 21:16:27', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('376', '钱咖', '2018-12-26 21:20:29', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('377', '钱咖', '2018-12-26 21:22:17', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('378', '钱咖', '2018-12-26 21:22:28', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('379', '钱咖', '2018-12-26 21:24:26', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('380', '钱咖', '2018-12-26 21:28:12', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('381', '111', '2018-12-26 21:29:32', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('382', '钱咖', '2018-12-26 21:31:01', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('383', '钱咖', '2018-12-26 21:31:37', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('384', '钱咖', '2018-12-27 00:02:07', '0.50', 'admin');
INSERT INTO `commission_record` VALUES ('385', '小鱼赚钱', '2018-12-27 00:02:52', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('386', '钱咖', '2018-12-27 00:03:15', '0.80', 'admin');
INSERT INTO `commission_record` VALUES ('387', '钱咖', '2018-12-27 00:05:37', '0.60', 'admin');
INSERT INTO `commission_record` VALUES ('388', '爱盈利', '2018-12-27 00:15:02', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('389', '钱咖', '2018-12-27 00:17:45', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('390', '钱咖', '2018-12-27 00:23:04', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('391', '钱咖', '2018-12-27 00:26:11', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('392', '钱咖', '2018-12-27 00:31:56', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('393', '钱咖', '2018-12-27 00:33:43', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('394', '钱咖', '2018-12-27 00:39:35', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('395', '钱咖', '2018-12-27 00:41:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('396', '钱咖', '2018-12-27 00:47:34', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('397', '111', '2018-12-27 00:49:24', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('398', '钱咖', '2018-12-27 00:55:34', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('399', '钱咖', '2018-12-27 00:57:43', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('400', '111', '2018-12-27 01:03:23', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('401', '111', '2018-12-27 01:05:36', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('402', '钱咖', '2018-12-27 01:11:34', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('403', '钱咖', '2018-12-27 01:13:44', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('404', '钱咖', '2018-12-27 01:19:35', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('405', '爱盈利', '2018-12-27 01:21:11', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('406', '钱咖', '2018-12-27 01:27:02', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('407', '钱咖', '2018-12-27 01:29:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('408', '小鱼赚钱', '2018-12-27 01:36:22', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('409', '钱咖', '2018-12-27 01:38:06', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('410', '钱咖', '2018-12-27 01:43:02', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('411', '钱咖', '2018-12-27 01:45:43', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('412', '小鱼赚钱', '2018-12-27 01:52:23', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('413', '爱盈利', '2018-12-27 01:53:12', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('414', '钱咖', '2018-12-27 01:59:58', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('415', '小鱼赚钱', '2018-12-27 02:02:32', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('416', '111', '2018-12-27 02:07:16', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('417', '钱咖', '2018-12-27 02:09:43', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('418', '爱盈利', '2018-12-27 02:15:03', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('419', '111', '2018-12-27 02:17:24', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('420', '钱咖', '2018-12-27 02:23:02', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('421', '小鱼赚钱', '2018-12-27 02:26:30', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('422', '111', '2018-12-27 02:31:16', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('423', '111', '2018-12-27 02:33:24', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('424', '钱咖', '2018-12-27 02:39:58', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('425', '钱咖', '2018-12-27 02:41:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('426', '钱咖', '2018-12-27 02:47:35', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('427', '钱咖', '2018-12-27 02:50:06', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('428', '爱盈利', '2018-12-27 02:55:03', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('429', '爱盈利', '2018-12-27 02:57:11', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('430', '爱盈利', '2018-12-27 03:03:03', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('431', '钱咖', '2018-12-27 03:05:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('432', '钱咖', '2018-12-27 03:11:57', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('433', '钱咖', '2018-12-27 03:13:43', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('434', '钱咖', '2018-12-27 03:19:58', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('435', '钱咖', '2018-12-27 03:21:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('436', '钱咖', '2018-12-27 03:27:56', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('437', '钱咖', '2018-12-27 03:30:04', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('438', '钱咖', '2018-12-27 03:35:33', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('439', '111', '2018-12-27 03:37:23', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('440', '钱咖', '2018-12-27 03:43:34', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('441', '钱咖', '2018-12-27 03:45:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('442', '爱盈利', '2018-12-27 03:51:03', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('443', '钱咖', '2018-12-27 03:53:42', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('444', '爱盈利', '2018-12-27 03:59:03', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('445', '小鱼赚钱', '2018-12-27 04:02:28', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('446', '钱咖', '2018-12-27 04:07:03', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('447', '钱咖', '2018-12-27 04:10:03', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('448', '爱盈利', '2018-12-27 04:15:03', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('449', '钱咖', '2018-12-27 04:18:05', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('450', '钱咖', '2018-12-27 04:23:33', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('451', '小鱼赚钱', '2018-12-27 04:26:27', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('452', '111', '2018-12-27 04:31:15', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('453', '小鱼赚钱', '2018-12-27 04:34:28', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('454', '钱咖', '2018-12-27 04:39:34', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('455', '爱盈利', '2018-12-27 04:41:11', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('456', '111', '2018-12-27 04:47:15', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('457', '钱咖', '2018-12-27 04:50:08', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('458', '钱咖', '2018-12-27 04:55:57', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('459', '钱咖', '2018-12-27 04:57:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('460', '钱咖', '2018-12-27 05:03:57', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('461', '爱盈利', '2018-12-27 05:05:11', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('462', '小鱼赚钱', '2018-12-27 05:12:19', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('463', '小鱼赚钱', '2018-12-27 05:14:29', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('464', '钱咖', '2018-12-27 05:19:03', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('465', '钱咖', '2018-12-27 05:22:03', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('466', '钱咖', '2018-12-27 05:27:03', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('467', '爱盈利', '2018-12-27 05:29:14', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('468', '钱咖', '2018-12-27 05:35:34', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('469', '爱盈利', '2018-12-27 05:37:11', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('470', '钱咖', '2018-12-27 05:43:03', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('471', '钱咖', '2018-12-27 05:45:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('472', '小鱼赚钱', '2018-12-27 05:52:19', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('473', '钱咖', '2018-12-27 05:53:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('474', '小鱼赚钱', '2018-12-27 06:00:20', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('475', '钱咖', '2018-12-27 06:02:04', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('476', '钱咖', '2018-12-27 06:07:33', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('477', '小鱼赚钱', '2018-12-27 06:10:30', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('478', '111', '2018-12-27 06:15:15', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('479', '小鱼赚钱', '2018-12-27 06:18:29', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('480', '钱咖', '2018-12-27 06:23:02', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('481', '钱咖', '2018-12-27 06:26:04', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('482', '小鱼赚钱', '2018-12-27 06:32:21', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('483', '钱咖', '2018-12-27 06:33:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('484', '钱咖', '2018-12-27 06:39:34', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('485', '111', '2018-12-27 06:41:23', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('486', '111', '2018-12-27 06:47:16', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('487', '小鱼赚钱', '2018-12-27 06:50:29', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('488', '钱咖', '2018-12-27 06:55:56', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('489', '钱咖', '2018-12-27 06:57:41', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('490', '钱咖', '2018-12-27 07:03:56', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('491', '钱咖', '2018-12-27 07:06:05', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('492', '钱咖', '2018-12-27 07:11:34', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('493', '小鱼赚钱', '2018-12-27 07:14:30', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('494', '小鱼赚钱', '2018-12-27 07:20:20', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('495', '钱咖', '2018-12-27 07:21:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('496', '小鱼赚钱', '2018-12-27 07:28:21', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('497', '爱盈利', '2018-12-27 07:29:11', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('498', '小鱼赚钱', '2018-12-27 07:36:20', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('499', '爱盈利', '2018-12-27 07:37:11', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('500', '111', '2018-12-27 07:43:15', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('501', '钱咖', '2018-12-27 07:46:04', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('502', '小鱼赚钱', '2018-12-27 07:52:21', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('503', '爱盈利', '2018-12-27 07:53:11', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('504', '111', '2018-12-27 07:59:16', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('505', '钱咖', '2018-12-27 08:01:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('506', '钱咖', '2018-12-27 08:07:03', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('507', '钱咖', '2018-12-27 08:09:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('508', '爱盈利', '2018-12-27 08:15:03', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('509', '钱咖', '2018-12-27 08:17:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('510', '钱咖', '2018-12-27 08:23:03', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('511', '钱咖', '2018-12-27 08:26:03', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('512', '小鱼赚钱', '2018-12-27 08:32:18', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('513', '111', '2018-12-27 08:33:23', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('514', '钱咖', '2018-12-27 08:39:34', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('515', '小鱼赚钱', '2018-12-27 08:42:28', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('516', '钱咖', '2018-12-27 08:47:03', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('517', '钱咖', '2018-12-27 08:49:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('518', '爱盈利', '2018-12-27 08:55:03', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('519', '爱盈利', '2018-12-27 08:57:11', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('520', '小鱼赚钱', '2018-12-27 09:04:22', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('521', '111', '2018-12-27 09:05:23', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('522', '钱咖', '2018-12-27 09:11:35', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('523', '爱盈利', '2018-12-27 09:13:12', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('524', '钱咖', '2018-12-27 09:19:57', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('525', '111', '2018-12-27 09:21:23', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('526', '爱盈利', '2018-12-27 09:27:03', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('527', '钱咖', '2018-12-27 09:29:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('528', '钱咖', '2018-12-27 09:35:57', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('529', '钱咖', '2018-12-27 09:38:04', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('530', '爱盈利', '2018-12-27 09:43:03', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('531', '钱咖', '2018-12-27 09:46:04', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('532', '小鱼赚钱', '2018-12-27 09:52:21', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('533', '钱咖', '2018-12-27 09:54:04', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('534', '111', '2018-12-27 09:59:17', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('535', '小鱼赚钱', '2018-12-27 10:02:29', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('536', '钱咖', '2018-12-27 10:07:34', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('537', '钱咖', '2018-12-27 10:09:41', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('538', '111', '2018-12-27 10:15:15', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('539', '111', '2018-12-27 10:17:24', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('540', '小鱼赚钱', '2018-12-27 10:24:23', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('541', '钱咖', '2018-12-27 10:25:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('542', '爱盈利', '2018-12-27 10:31:03', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('543', '爱盈利', '2018-12-27 10:33:11', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('544', '111', '2018-12-27 10:39:15', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('545', '钱咖', '2018-12-27 10:41:42', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('546', '钱咖', '2018-12-27 10:47:03', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('547', '爱盈利', '2018-12-27 10:49:11', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('548', '小鱼赚钱', '2018-12-27 10:56:21', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('549', '小鱼赚钱', '2018-12-27 10:58:30', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('550', '小鱼赚钱', '2018-12-27 11:04:22', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('551', '钱咖', '2018-12-27 11:06:05', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('552', '爱盈利', '2018-12-27 11:11:03', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('553', '111', '2018-12-27 11:13:25', '0.40', '18596386668');
INSERT INTO `commission_record` VALUES ('554', '钱咖', '2018-12-27 11:19:57', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('555', '钱咖', '2018-12-27 11:22:07', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('556', '钱咖', '2018-12-27 11:27:57', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('557', '钱咖', '2018-12-27 11:29:11', '0.80', '18596386668');
INSERT INTO `commission_record` VALUES ('558', '爱盈利', '2018-12-27 12:30:42', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('559', '钱咖', '2018-12-27 12:34:17', '0.60', '18596386668');
INSERT INTO `commission_record` VALUES ('560', '钱咖', '2018-12-27 12:36:42', '0.50', '18596386668');
INSERT INTO `commission_record` VALUES ('561', '爱盈利', '2018-12-27 12:38:25', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('562', '爱盈利', '2018-12-27 12:40:54', '0.20', '18596386668');
INSERT INTO `commission_record` VALUES ('563', '钱咖', '2018-12-27 12:43:25', '0.80', '18596386668');

-- ----------------------------
-- Table structure for `cricletime`
-- ----------------------------
DROP TABLE IF EXISTS `cricletime`;
CREATE TABLE `cricletime` (
  `cricletime` int(3) NOT NULL,
  PRIMARY KEY (`cricletime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cricletime
-- ----------------------------
INSERT INTO `cricletime` VALUES ('8');

-- ----------------------------
-- Table structure for `minwithdraw`
-- ----------------------------
DROP TABLE IF EXISTS `minwithdraw`;
CREATE TABLE `minwithdraw` (
  `minwithwraw` double(5,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`minwithwraw`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of minwithdraw
-- ----------------------------
INSERT INTO `minwithdraw` VALUES ('100.00');

-- ----------------------------
-- Table structure for `noincometime`
-- ----------------------------
DROP TABLE IF EXISTS `noincometime`;
CREATE TABLE `noincometime` (
  `starttime` varchar(8) NOT NULL DEFAULT '',
  `endtime` varchar(8) NOT NULL DEFAULT '',
  PRIMARY KEY (`starttime`,`endtime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of noincometime
-- ----------------------------
INSERT INTO `noincometime` VALUES ('21:00:00', '09:00:00');

-- ----------------------------
-- Table structure for `qq`
-- ----------------------------
DROP TABLE IF EXISTS `qq`;
CREATE TABLE `qq` (
  `id` int(1) NOT NULL,
  `qq` varchar(13) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qq
-- ----------------------------
INSERT INTO `qq` VALUES ('1', '631170321  ');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(25) NOT NULL,
  `idcard` char(18) DEFAULT NULL,
  `alipayaccount` varchar(30) DEFAULT NULL,
  `alipayname` varchar(15) DEFAULT NULL,
  `bankaccount` char(19) DEFAULT NULL,
  `bankplace` varchar(25) DEFAULT NULL,
  `token` char(32) DEFAULT NULL,
  `state` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'admin', '123123123123', '123123', '徐鑫', '13123123', '农业银行', '938200ebfa798dca8c0031b849696313', '1');
INSERT INTO `users` VALUES ('5', '18596386668', '111111', '370983198701100558', '18260519070', '陈超', '6214258063951702', '招商银行', 'e965d19ad8a64c0b59794f4e115565b4', '1');
INSERT INTO `users` VALUES ('6', '18596386660', '111111', null, null, null, null, null, null, '1');
INSERT INTO `users` VALUES ('7', 'admin01', '021027', null, null, null, null, null, null, '1');
INSERT INTO `users` VALUES ('8', 'admin02', '021027', null, null, null, null, null, null, '1');
INSERT INTO `users` VALUES ('9', 'admin03', '021027', null, null, null, null, null, null, '1');
INSERT INTO `users` VALUES ('10', 'admin04', '021027', null, null, null, null, null, null, '1');
INSERT INTO `users` VALUES ('11', 'admin05', '021027', null, null, null, null, null, null, '1');
INSERT INTO `users` VALUES ('12', 'admin06', '021027', null, null, null, null, null, null, '1');
INSERT INTO `users` VALUES ('13', 'admin07', '021027', null, null, null, null, null, null, '1');
INSERT INTO `users` VALUES ('14', 'admin08', '021027', null, null, null, null, null, null, '1');
INSERT INTO `users` VALUES ('15', 'admin09', '021027', null, null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for `withdraw_record`
-- ----------------------------
DROP TABLE IF EXISTS `withdraw_record`;
CREATE TABLE `withdraw_record` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `amount` float(5,2) NOT NULL,
  `alipay` varchar(30) NOT NULL,
  `name` varchar(10) NOT NULL,
  `state` int(1) NOT NULL DEFAULT '0',
  `time` datetime NOT NULL,
  `bankplace` varchar(100) DEFAULT NULL,
  `bankaccount` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of withdraw_record
-- ----------------------------
INSERT INTO `withdraw_record` VALUES ('3', '18596386668', '30.00', '18260519070', '陈超', '0', '2018-12-24 17:33:27', null, null);
INSERT INTO `withdraw_record` VALUES ('9', 'admin', '10.00', '123123', '徐鑫', '0', '2018-12-26 09:40:07', '农业银行', '13123123');
INSERT INTO `withdraw_record` VALUES ('10', '18596386668', '33.00', '18260519070', '陈超', '0', '2018-12-26 19:11:34', '招商银行', '6214258063951702');
