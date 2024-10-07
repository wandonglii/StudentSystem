/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50722
Source Host           : 10.40.5.1:3306
Source Database       : jd1021

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-12-27 15:45:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `sage` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `sgender` char(1) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', 'tom', '25', 'F', '2019-10-06');
INSERT INTO `t_student` VALUES ('2', '小梅', '20', 'F', '2009-11-01');
INSERT INTO `t_student` VALUES ('4', '小刘', '20', 'M', '2019-12-26');
INSERT INTO `t_student` VALUES ('5', '王明', '25', 'M', '2019-12-05');
INSERT INTO `t_student` VALUES ('6', 'XXYY', '20', 'F', '2013-12-30');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'jack', '123456');
