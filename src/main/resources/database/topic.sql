/*
Navicat MySQL Data Transfer

Source Server         : MYSQL连接
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : topic

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-06-15 13:38:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for topic_comments
-- ----------------------------
DROP TABLE IF EXISTS `topic_comments`;
CREATE TABLE `topic_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `discard` int(11) NOT NULL DEFAULT '0',
  `user_username` varchar(255) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `floor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `com_post_fk` (`post_id`),
  KEY `com_user_fk` (`user_id`),
  CONSTRAINT `com_post_fk` FOREIGN KEY (`post_id`) REFERENCES `topic_post` (`id`),
  CONSTRAINT `com_user_fk` FOREIGN KEY (`user_id`) REFERENCES `topic_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_comments
-- ----------------------------

-- ----------------------------
-- Table structure for topic_post
-- ----------------------------
DROP TABLE IF EXISTS `topic_post`;
CREATE TABLE `topic_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` varchar(20000) NOT NULL,
  `user_id` int(11) NOT NULL,
  `topic_id` int(11) NOT NULL,
  `discard` int(11) NOT NULL DEFAULT '0',
  `user_username` varchar(255) NOT NULL,
  `comments_number` int(11) NOT NULL DEFAULT '0',
  `last_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `post_user_fk` (`user_id`),
  KEY `post_topic_fk` (`topic_id`),
  CONSTRAINT `post_topic_fk` FOREIGN KEY (`topic_id`) REFERENCES `topic_topic` (`id`),
  CONSTRAINT `post_user_fk` FOREIGN KEY (`user_id`) REFERENCES `topic_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_post
-- ----------------------------

-- ----------------------------
-- Table structure for topic_role
-- ----------------------------
DROP TABLE IF EXISTS `topic_role`;
CREATE TABLE `topic_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `discard` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_role
-- ----------------------------
INSERT INTO `topic_role` VALUES ('1', '超级管理员', '0');
INSERT INTO `topic_role` VALUES ('2', '管理员', '0');
INSERT INTO `topic_role` VALUES ('3', '会员', '0');

-- ----------------------------
-- Table structure for topic_topic
-- ----------------------------
DROP TABLE IF EXISTS `topic_topic`;
CREATE TABLE `topic_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `close` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_topic
-- ----------------------------
INSERT INTO `topic_topic` VALUES ('1', '话题', 'topic', '0');
INSERT INTO `topic_topic` VALUES ('2', '游戏', 'game', '0');
INSERT INTO `topic_topic` VALUES ('3', '技术', 'tech', '0');

-- ----------------------------
-- Table structure for topic_user
-- ----------------------------
DROP TABLE IF EXISTS `topic_user`;
CREATE TABLE `topic_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(128) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  `photo` varchar(255) NOT NULL DEFAULT 'default.png',
  `role_id` int(11) NOT NULL DEFAULT '3',
  `ban` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_role_fk` (`role_id`),
  CONSTRAINT `user_role_fk` FOREIGN KEY (`role_id`) REFERENCES `topic_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_user
-- ----------------------------
INSERT INTO `topic_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '123@qq.com', '123-', 'default.png', '1', '0');
