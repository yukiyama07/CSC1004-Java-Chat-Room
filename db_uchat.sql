/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80032
Source Host           : localhost:3306
Source Database       : db_uchat

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2023-05-02 23:31:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for uchat_add_friend_list
-- ----------------------------
DROP TABLE IF EXISTS `uchat_add_friend_list`;
CREATE TABLE `uchat_add_friend_list` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `send_user_id` bigint DEFAULT NULL,
  `receive_user_id` bigint DEFAULT NULL,
  `message` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  `is_receive` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for uchat_friend_list
-- ----------------------------
DROP TABLE IF EXISTS `uchat_friend_list`;
CREATE TABLE `uchat_friend_list` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `friend_user_id` bigint DEFAULT NULL,
  `friend_nick_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for uchat_message_list
-- ----------------------------
DROP TABLE IF EXISTS `uchat_message_list`;
CREATE TABLE `uchat_message_list` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `send_user_id` bigint DEFAULT NULL,
  `receive_user_id` bigint DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `send_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for uchat_user
-- ----------------------------
DROP TABLE IF EXISTS `uchat_user`;
CREATE TABLE `uchat_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `is_online` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;
