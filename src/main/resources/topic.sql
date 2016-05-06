/*
Navicat MySQL Data Transfer

Source Server         : MYSQL连接
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : topic

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-05-05 20:48:09
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
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `com_post_fk` (`post_id`),
  KEY `com_user_fk` (`user_id`),
  CONSTRAINT `com_post_fk` FOREIGN KEY (`post_id`) REFERENCES `topic_post` (`id`),
  CONSTRAINT `com_user_fk` FOREIGN KEY (`user_id`) REFERENCES `topic_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_comments
-- ----------------------------
INSERT INTO `topic_comments` VALUES ('25', '测试回复', '39', '1', '0', 'admin', '2016-05-05 19:34:04');
INSERT INTO `topic_comments` VALUES ('27', '测试回复', '39', '1', '0', 'admin', '2016-05-05 19:37:25');
INSERT INTO `topic_comments` VALUES ('28', '测试回复', '39', '1', '0', 'admin', '2016-05-05 19:50:47');

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
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `last_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `post_user_fk` (`user_id`),
  KEY `post_topic_fk` (`topic_id`),
  CONSTRAINT `post_topic_fk` FOREIGN KEY (`topic_id`) REFERENCES `topic_topic` (`id`),
  CONSTRAINT `post_user_fk` FOREIGN KEY (`user_id`) REFERENCES `topic_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_post
-- ----------------------------
INSERT INTO `topic_post` VALUES ('1', '第一条信息', '第一条内容', '39', '1', '0', 'admin', '4', '2016-05-05 19:50:47', '2016-05-05 19:50:47');
INSERT INTO `topic_post` VALUES ('2', 'lol', 'lol', '39', '2', '0', 'admin', '0', '2016-05-04 19:19:42', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('3', '测试标题', '测试文章', '39', '1', '0', 'admin', '0', '2016-05-05 19:37:39', '2016-05-05 19:37:39');
INSERT INTO `topic_post` VALUES ('21', '1', '2', '39', '2', '0', 'admin', '0', '2016-05-04 19:19:42', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('22', '外媒评史上最重要50大PC游戏', '开发商：暴雪娱乐\r\n　　为何魔兽世界如此重要：象征着MMO网游时代的游戏。虽然魔兽世界整体上是在前人游戏基础上制作打磨的，但是暴雪对单人任务系统的深刻理解在其中却发挥了重要的作用。在一份份资料片，一次次修改后，它毫无疑问地成为本世纪初最重要游戏中的一员，至今依然屹立不倒。\r\n　　玩家评述\r\n　　我玩魔兽世界已经10年多了，至今没有丧失对它的热情。我的老公和我从一开始就组起了队，一起升级，一起学操作，一起加公会，一起灭团躺尸。公会里很多人比现实里的朋友还要亲密。魔兽世界的社交元素让这款游戏经久不衰。\r\n　　有的人不喜欢魔兽世界，觉得这个游戏画风太卡通化。', '39', '2', '0', 'admin', '0', '2016-05-04 19:19:42', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('23', '测试', '                     标题\r\n测试\r\n测试\r\n测试', '39', '2', '0', 'admin', '0', '2016-05-04 19:19:42', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('24', 'XSS', 'xss:<script>alert(\'xss\');</script>', '39', '1', '0', 'admin', '0', '2016-05-04 19:19:42', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('26', '测试标题', '测试文章', '39', '1', '0', 'admin', '0', '2016-05-04 19:19:42', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('31', '测试标题0', '测试文章0', '39', '1', '0', 'admin', '0', '2016-05-04 20:00:03', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('32', '测试标题1', '测试文章1', '39', '1', '0', 'admin', '0', '2016-05-04 20:00:03', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('33', '测试标题2', '测试文章2', '39', '1', '0', 'admin', '0', '2016-05-04 20:00:04', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('34', '测试标题3', '测试文章3', '39', '1', '0', 'admin', '0', '2016-05-04 20:00:04', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('35', '测试标题4', '测试文章4', '39', '1', '0', 'admin', '0', '2016-05-04 20:00:04', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('36', '测试标题5', '测试文章5', '39', '1', '0', 'admin', '0', '2016-05-04 20:00:04', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('37', '测试标题6', '测试文章6', '39', '1', '0', 'admin', '0', '2016-05-04 20:00:04', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('38', '测试标题7', '测试文章7', '39', '1', '0', 'admin', '0', '2016-05-04 20:00:04', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('39', '测试标题8', '测试文章8', '39', '1', '0', 'admin', '0', '2016-05-04 20:00:04', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('40', '测试标题9', '测试文章9', '39', '1', '0', 'admin', '0', '2016-05-04 20:00:05', '2016-05-05 19:22:33');
INSERT INTO `topic_post` VALUES ('41', '测试标题', '测试文章', '39', '1', '0', 'admin', '0', '2016-05-05 19:30:39', '2016-05-05 19:30:39');
INSERT INTO `topic_post` VALUES ('42', '1111111111111111111111111111111111', '11111111111111111', '39', '1', '0', 'admin', '0', '2016-05-05 20:40:13', '2016-05-05 20:40:13');
INSERT INTO `topic_post` VALUES ('43', '3', '3', '80', '1', '0', 'aaa', '0', '2016-05-05 20:45:15', '2016-05-05 20:45:15');

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
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `close` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_topic
-- ----------------------------
INSERT INTO `topic_topic` VALUES ('1', '话题', 'topic', '0');
INSERT INTO `topic_topic` VALUES ('2', '游戏', 'game', '0');

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
  `role_id` int(11) NOT NULL DEFAULT '3',
  `ban` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_role_fk` (`role_id`),
  CONSTRAINT `user_role_fk` FOREIGN KEY (`role_id`) REFERENCES `topic_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic_user
-- ----------------------------
INSERT INTO `topic_user` VALUES ('39', 'admin', 'admin', null, null, '1', '0');
INSERT INTO `topic_user` VALUES ('80', 'aaa', '111', null, null, '3', '0');
