/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : aaa

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2018-11-27 16:51:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `news_detail`
-- ----------------------------
DROP TABLE IF EXISTS `news_detail`;
CREATE TABLE `news_detail` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 NOT NULL,
  `publish_date` datetime NOT NULL,
  `clickCount` int(11) NOT NULL,
  `next_article` varchar(255) DEFAULT NULL,
  `before_article` varchar(255) DEFAULT NULL,
  `content` longtext CHARACTER SET utf8 NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `remark1` varchar(255) DEFAULT '',
  `uploadDate` datetime NOT NULL,
  `article_type` varchar(255) NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of news_detail
-- ----------------------------
INSERT INTO `news_detail` VALUES ('1', '123', '2018-11-06 09:38:08', '6', '5', null, 'ert', 'wert', '', '2018-12-05 09:38:32', '1', '/');
INSERT INTO `news_detail` VALUES ('2', '1234', '2018-10-19 00:00:00', '0', '15', '1', '12341234??', null, null, '2018-11-20 11:49:28', '0', '/');
INSERT INTO `news_detail` VALUES ('3', '123', '2018-11-06 09:38:08', '0', '5', null, 'ert', 'wert', '', '2018-12-05 09:38:32', '1', '/');
INSERT INTO `news_detail` VALUES ('4', '???', '2018-10-10 00:00:00', '0', '', '1', '?????', null, null, '2018-11-20 11:59:51', '0', '/');
INSERT INTO `news_detail` VALUES ('5', '14123', '2018-10-10 00:00:00', '1', '', '1', '????', null, null, '2018-11-20 12:02:18', '0', '/');
INSERT INTO `news_detail` VALUES ('6', '1234', '2018-10-19 00:00:00', '0', '', '1', '12341234??', null, null, '2018-11-20 11:49:28', '0', '/');
INSERT INTO `news_detail` VALUES ('11', '???', '2018-10-10 00:00:00', '0', '', '1', '?????', null, null, '2018-11-20 11:59:51', '0', '/');
INSERT INTO `news_detail` VALUES ('12', '14123', '2018-10-10 00:00:00', '0', '', '1', '????', null, null, '2018-11-20 12:02:18', '0', '/');
INSERT INTO `news_detail` VALUES ('13', '33333', '2019-10-04 00:00:00', '0', '', '2', '3333333333333', null, null, '2018-11-21 14:43:03', '0', '/');
INSERT INTO `news_detail` VALUES ('14', '????????????', '2018-11-23 09:23:34', '2', '', '2', '<p style=\"text-align:center;\">\r\n	<img src=\"/pic/????_20180507141450.jpg\" alt=\"\" width=\"144\" height=\"108\" title=\"\" align=\"\" />\r\n</p>\r\n<p style=\"text-align:center;\">\r\n	????\r\n</p>\r\n<p style=\"text-align:left;\">\r\n	&nbsp;&nbsp;&nbsp;&nbsp;????????????????????????????????????????????????????????????????????????\r\n</p>\r\n<p style=\"text-align:left;\">\r\n	?????;i\r\n</p>\r\n<p style=\"text-align:left;\">\r\n	<br />\r\n</p>', null, null, '2018-11-23 09:26:25', '1', '/');
INSERT INTO `news_detail` VALUES ('15', '话说是谁，比我更厉害', '2018-11-23 09:36:24', '2', '', '2', '<p>\r\n	&nbsp; &nbsp; 今天晚上不回家吃饭了，你知道为什么吗因为我每天都不吃饭，如果今天吃了我就是破解了，你说我怎么可以破戒，我这么帅，这么美，怎么能够破戒呢，老天给饭吃啊。\r\n</p>\r\n<p style=\"text-align:center;\">\r\n	<img src=\"/pic/新3.jpg\" alt=\"\" width=\"108\" height=\"144\" title=\"\" align=\"\" />\r\n</p>\r\n<p style=\"text-align:center;\">\r\n	企业这公户\r\n</p>\r\n<p style=\"text-align:left;\">\r\n	&nbsp; &nbsp; 哈哈哈啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊，没有关系啊，如果有也没有关系啊，反正我这么帅\r\n</p>\r\n<p style=\"text-align:left;\">\r\n	我没有拍过\r\n</p>', null, null, '2018-11-23 09:39:32', '1', '/');
