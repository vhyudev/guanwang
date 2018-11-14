/*
Navicat MySQL Data Transfer

Source Server         : 特教官网
Source Server Version : 50536
Source Host           : 127.0.0.1:3306
Source Database       : aaa

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2018-11-14 17:22:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lunbotu_table
-- ----------------------------
DROP TABLE IF EXISTS `lunbotu_table`;
CREATE TABLE `lunbotu_table` (
  `id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `picdesc` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `picname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `src` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `bgcolor` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of lunbotu_table
-- ----------------------------
INSERT INTO `lunbotu_table` VALUES ('1', '三', '送死', 'url(images/Up_Images/201489222212.jpg)', '/About/index.html', '#FFFFFF');
INSERT INTO `lunbotu_table` VALUES ('2', '2', '2', 'url(images/Up_Images/201489205410.jpg)', '/About/index.html', '#FECF67');
INSERT INTO `lunbotu_table` VALUES ('3', '3', '3', 'url(images/Up_Images/2014811101939.jpg)', '/html/2735612243.html', '#A2DB7C');
INSERT INTO `lunbotu_table` VALUES ('4', '4', '49', 'url(images/Up_Images/201489222212.jpg)', '/About/index.html', '#FFFFFF');
