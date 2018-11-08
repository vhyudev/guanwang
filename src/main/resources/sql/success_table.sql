/*
Navicat MySQL Data Transfer

Source Server         : aaa
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : aaa

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2018-11-08 17:22:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for success_table
-- ----------------------------
DROP TABLE IF EXISTS `success_table`;
CREATE TABLE `success_table` (
  `id` int(10) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `remark1` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of success_table
-- ----------------------------
INSERT INTO `success_table` VALUES ('1', '孩子的康复与父母的陪伴，家庭的关爱密不可分。', '/Successfulcase/SuccessExample/success0001.html', '2018年9月15日', null, null);
INSERT INTO `success_table` VALUES ('2', '王丽花小朋友打开心扉，与老师交流。', '/Successfulcase/SuccessExample/success0002.html', '2018年9月15日', null, null);
INSERT INTO `success_table` VALUES ('3', '孩子的康复与父母的陪伴，家庭的关爱密不可分。', '/Successfulcase/SuccessExample/success0001.html', '2018年9月15日', null, null);
INSERT INTO `success_table` VALUES ('4', '王丽花小朋友打开心扉，与老师交流。', '/Successfulcase/SuccessExample/success0002.html', '2018年9月15日', null, null);
INSERT INTO `success_table` VALUES ('5', '孩子的康复与父母的陪伴，家庭的关爱密不可分。', '/Successfulcase/SuccessExample/success0001.html', '2018年9月15日', null, null);
INSERT INTO `success_table` VALUES ('6', '王丽花小朋友打开心扉，与老师交流。', '/Successfulcase/SuccessExample/success0002.html', '2018年9月15日', null, null);
INSERT INTO `success_table` VALUES ('7', '孩子的康复与父母的陪伴，家庭的关爱密不可分。', '/Successfulcase/SuccessExample/success0001.html', '2018年9月15日', null, null);
INSERT INTO `success_table` VALUES ('8', '王丽花小朋友打开心扉，与老师交流。', '/Successfulcase/SuccessExample/success0002.html', '2018年9月15日', null, null);
INSERT INTO `success_table` VALUES ('9', '孩子的康复与父母的陪伴，家庭的关爱密不可分。', '/Successfulcase/SuccessExample/success0001.html', '2018年9月15日', null, null);
