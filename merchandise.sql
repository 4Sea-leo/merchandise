/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : merchandise

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-01-12 00:32:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `price` decimal(11,0) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `total` decimal(10,0) GENERATED ALWAYS AS ((`num` * `price`)) VIRTUAL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('2', '三星s6', '手机', '4799', '2', '2020-01-11', '新款三星', '9598');
INSERT INTO `goods` VALUES ('3', 'macbook', '笔记本', '10999', '4', '2020-01-11', '互联网笔记本', '43996');
INSERT INTO `goods` VALUES ('5', 'redmik20', '手机', '2799', '8', '2020-01-11', '红米旗舰机', '22392');
INSERT INTO `goods` VALUES ('10', '小米8', '手机', '2999', '100', '2020-01-11', '年轻人最爱', '299900');
INSERT INTO `goods` VALUES ('11', '小怀9', '手机', '199', '1', '2020-01-11', '没人买', '199');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `userpassword` varchar(255) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123');
INSERT INTO `user` VALUES ('2', 'admin1', '123');
