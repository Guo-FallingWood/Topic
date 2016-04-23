/*
Navicat MySQL Data Transfer

Source Server         : MYSQL连接
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : topic

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-04-23 22:45:27
*/

-- DROP DATABASE IF EXISTS topic;
-- CREATE DATABASE topic;
-- USE topic;


SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for topic_comments
-- ----------------------------
DROP TABLE IF EXISTS `topic_comments`;
CREATE TABLE `topic_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `com_post_fk` (`post_id`),
  KEY `com_user_fk` (`user_id`),
  CONSTRAINT `com_post_fk` FOREIGN KEY (`post_id`) REFERENCES `topic_post` (`id`),
  CONSTRAINT `com_user_fk` FOREIGN KEY (`user_id`) REFERENCES `topic_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_comments
-- ----------------------------

-- ----------------------------
-- Table structure for topic_post
-- ----------------------------
DROP TABLE IF EXISTS `topic_post`;
CREATE TABLE `topic_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(2555) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `topic_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `post_topic_fk` (`topic_id`),
  KEY `post_user_fk` (`user_id`),
  CONSTRAINT `post_topic_fk` FOREIGN KEY (`topic_id`) REFERENCES `topic_topic` (`id`),
  CONSTRAINT `post_user_fk` FOREIGN KEY (`user_id`) REFERENCES `topic_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_role
-- ----------------------------
INSERT INTO `topic_role` VALUES ('1', '超级管理员');
INSERT INTO `topic_role` VALUES ('2', '管理员');
INSERT INTO `topic_role` VALUES ('3', '会员');
INSERT INTO `topic_role` VALUES ('4', '游客');

-- ----------------------------
-- Table structure for topic_role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `topic_role_permissions`;
CREATE TABLE `topic_role_permissions` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_role_permissions
-- ----------------------------

-- ----------------------------
-- Table structure for topic_role_permissions_link
-- ----------------------------
DROP TABLE IF EXISTS `topic_role_permissions_link`;
CREATE TABLE `topic_role_permissions_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permissions_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk1` (`role_id`),
  KEY `fk2` (`permissions_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`role_id`) REFERENCES `topic_role` (`id`),
  CONSTRAINT `fk2` FOREIGN KEY (`permissions_id`) REFERENCES `topic_role_permissions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_role_permissions_link
-- ----------------------------

-- ----------------------------
-- Table structure for topic_topic
-- ----------------------------
DROP TABLE IF EXISTS `topic_topic`;
CREATE TABLE `topic_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_topic
-- ----------------------------
INSERT INTO `topic_topic` VALUES ('1', 'Admin');
INSERT INTO `topic_topic` VALUES ('2', 'Topic');

-- ----------------------------
-- Table structure for topic_user
-- ----------------------------
DROP TABLE IF EXISTS `topic_user`;
CREATE TABLE `topic_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_user
-- ----------------------------
INSERT INTO `topic_user` VALUES ('1', 'admin', 'admin1', null, null);
INSERT INTO `topic_user` VALUES ('22', '1', '1', null, null);
INSERT INTO `topic_user` VALUES ('24', '3', '3', null, null);
INSERT INTO `topic_user` VALUES ('25', '3', '333333', null, null);
INSERT INTO `topic_user` VALUES ('26', '333', '333', null, null);
INSERT INTO `topic_user` VALUES ('27', '333', '33333333', null, null);
INSERT INTO `topic_user` VALUES ('28', '333', '11111111', null, null);
INSERT INTO `topic_user` VALUES ('29', '1', '11', null, null);
INSERT INTO `topic_user` VALUES ('30', 'aaaaa', '1111111', null, null);
INSERT INTO `topic_user` VALUES ('31', 'aaa', 'aaa', null, null);

-- ----------------------------
-- Table structure for topic_user_role_topic_link
-- ----------------------------
DROP TABLE IF EXISTS `topic_user_role_topic_link`;
CREATE TABLE `topic_user_role_topic_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `topic_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `f1` (`user_id`),
  KEY `f2` (`role_id`),
  KEY `f3` (`topic_id`),
  CONSTRAINT `f1` FOREIGN KEY (`user_id`) REFERENCES `topic_user` (`id`),
  CONSTRAINT `f2` FOREIGN KEY (`role_id`) REFERENCES `topic_role` (`id`),
  CONSTRAINT `f3` FOREIGN KEY (`topic_id`) REFERENCES `topic_topic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_user_role_topic_link
-- ----------------------------
