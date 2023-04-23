/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 80032
Source Host           : localhost:3306
Source Database       : db_uchat

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2023-04-23 23:53:35
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of uchat_add_friend_list
-- ----------------------------
INSERT INTO `uchat_add_friend_list` VALUES ('14', '8', '10', '你好啊', '2023-04-18 04:17:30', '1');
INSERT INTO `uchat_add_friend_list` VALUES ('15', '8', '13', '你好啊', '2023-04-18 04:18:03', '1');
INSERT INTO `uchat_add_friend_list` VALUES ('16', '13', '10', '你好啊', '2023-04-18 07:08:00', '2');
INSERT INTO `uchat_add_friend_list` VALUES ('17', '13', '8', '你好啊', '2023-04-18 07:11:36', '1');
INSERT INTO `uchat_add_friend_list` VALUES ('18', '13', '11', '你好啊', '2023-04-18 07:11:41', '1');
INSERT INTO `uchat_add_friend_list` VALUES ('19', '13', '12', '你好啊', '2023-04-18 07:11:43', '2');
INSERT INTO `uchat_add_friend_list` VALUES ('20', '10', '11', '你好啊', '2023-04-18 08:48:22', '1');
INSERT INTO `uchat_add_friend_list` VALUES ('21', '8', '11', '你好啊', '2023-04-18 10:06:20', '2');
INSERT INTO `uchat_add_friend_list` VALUES ('22', '11', '8', '你好啊', '2023-04-18 10:10:47', '2');
INSERT INTO `uchat_add_friend_list` VALUES ('23', '11', '8', '你好啊', '2023-04-18 10:14:48', '2');
INSERT INTO `uchat_add_friend_list` VALUES ('24', '8', '12', 'Hi', '2023-04-22 15:53:39', '2');
INSERT INTO `uchat_add_friend_list` VALUES ('25', '12', '13', 'Hi', '2023-04-22 15:54:51', '2');
INSERT INTO `uchat_add_friend_list` VALUES ('26', '12', '10', 'Hi', '2023-04-22 17:00:12', '2');
INSERT INTO `uchat_add_friend_list` VALUES ('27', '12', '10', 'Hi', '2023-04-22 17:00:29', '1');
INSERT INTO `uchat_add_friend_list` VALUES ('28', '14', '13', 'Hi', '2023-04-23 06:10:40', '0');
INSERT INTO `uchat_add_friend_list` VALUES ('29', '8', '14', 'Hi', '2023-04-23 06:11:01', '1');
INSERT INTO `uchat_add_friend_list` VALUES ('30', '13', '14', 'Hi', '2023-04-23 11:17:17', '1');
INSERT INTO `uchat_add_friend_list` VALUES ('31', '8', '12', 'Hi', '2023-04-23 11:35:26', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of uchat_friend_list
-- ----------------------------
INSERT INTO `uchat_friend_list` VALUES ('17', '8', '13', 'admin');
INSERT INTO `uchat_friend_list` VALUES ('18', '13', '8', 'stu1');
INSERT INTO `uchat_friend_list` VALUES ('21', '13', '10', 'stu2');
INSERT INTO `uchat_friend_list` VALUES ('24', '10', '13', 'admin');
INSERT INTO `uchat_friend_list` VALUES ('25', '8', '10', 'stu2');
INSERT INTO `uchat_friend_list` VALUES ('26', '10', '8', 'stu1');
INSERT INTO `uchat_friend_list` VALUES ('27', '10', '11', 'stu3');
INSERT INTO `uchat_friend_list` VALUES ('28', '11', '10', 'stu2');
INSERT INTO `uchat_friend_list` VALUES ('29', '13', '11', 'stu3');
INSERT INTO `uchat_friend_list` VALUES ('30', '11', '13', 'admin');
INSERT INTO `uchat_friend_list` VALUES ('33', '12', '10', 'stu2');
INSERT INTO `uchat_friend_list` VALUES ('34', '10', '12', 'stu4');
INSERT INTO `uchat_friend_list` VALUES ('35', '8', '14', 'user1');
INSERT INTO `uchat_friend_list` VALUES ('36', '14', '8', 'stu1');
INSERT INTO `uchat_friend_list` VALUES ('37', '13', '14', 'user1');
INSERT INTO `uchat_friend_list` VALUES ('38', '14', '13', 'admin');

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
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of uchat_message_list
-- ----------------------------
INSERT INTO `uchat_message_list` VALUES ('44', '8', '13', 'hi', '2023-04-18 10:50:20.868000');
INSERT INTO `uchat_message_list` VALUES ('45', '8', '13', 'how are you', '2023-04-18 10:52:50.685000');
INSERT INTO `uchat_message_list` VALUES ('46', '8', '13', 'hello', '2023-04-18 10:56:37.151000');
INSERT INTO `uchat_message_list` VALUES ('47', '8', '13', 'hello', '2023-04-18 11:00:03.261000');
INSERT INTO `uchat_message_list` VALUES ('48', '8', '13', 'hello', '2023-04-18 11:00:17.739000');
INSERT INTO `uchat_message_list` VALUES ('49', '13', '8', 'hi', '2023-04-18 11:00:29.084000');
INSERT INTO `uchat_message_list` VALUES ('50', '8', '13', 'i am stu1', '2023-04-18 11:00:37.832000');
INSERT INTO `uchat_message_list` VALUES ('51', '13', '8', 'i am admin', '2023-04-18 11:00:46.017000');
INSERT INTO `uchat_message_list` VALUES ('52', '8', '13', 'ok', '2023-04-18 11:10:39.884000');
INSERT INTO `uchat_message_list` VALUES ('53', '8', '13', '1', '2023-04-18 11:19:05.532000');
INSERT INTO `uchat_message_list` VALUES ('54', '13', '8', '2', '2023-04-18 14:58:15.621000');
INSERT INTO `uchat_message_list` VALUES ('55', '8', '13', '3', '2023-04-18 15:19:00.122000');
INSERT INTO `uchat_message_list` VALUES ('56', '8', '13', '4', '2023-04-18 15:23:39.695000');
INSERT INTO `uchat_message_list` VALUES ('57', '8', '13', '1', '2023-04-18 15:26:14.839000');
INSERT INTO `uchat_message_list` VALUES ('58', '10', '13', '1', '2023-04-18 16:48:03.907000');
INSERT INTO `uchat_message_list` VALUES ('59', '13', '8', 'hello', '2023-04-18 16:48:10.509000');
INSERT INTO `uchat_message_list` VALUES ('60', '10', '13', '12', '2023-04-18 16:56:25.113000');
INSERT INTO `uchat_message_list` VALUES ('61', '10', '13', '2', '2023-04-18 16:58:46.098000');
INSERT INTO `uchat_message_list` VALUES ('62', '8', '13', 'test', '2023-04-18 17:16:35.977000');
INSERT INTO `uchat_message_list` VALUES ('63', '13', '8', 'test', '2023-04-18 17:21:58.117000');
INSERT INTO `uchat_message_list` VALUES ('64', '13', '10', 'test', '2023-04-18 17:22:10.334000');
INSERT INTO `uchat_message_list` VALUES ('65', '8', '13', 'test', '2023-04-18 17:26:14.470000');
INSERT INTO `uchat_message_list` VALUES ('66', '8', '10', 'test', '2023-04-18 17:26:14.486000');
INSERT INTO `uchat_message_list` VALUES ('67', '8', '13', 'test2', '2023-04-18 17:27:09.308000');
INSERT INTO `uchat_message_list` VALUES ('68', '8', '10', 'test2', '2023-04-18 17:27:09.315000');
INSERT INTO `uchat_message_list` VALUES ('69', '8', '13', 'what about the weather', '2023-04-18 17:27:53.757000');
INSERT INTO `uchat_message_list` VALUES ('70', '8', '10', 'what about the weather', '2023-04-18 17:27:53.763000');
INSERT INTO `uchat_message_list` VALUES ('71', '10', '13', 'it\'s good', '2023-04-18 17:28:44.665000');
INSERT INTO `uchat_message_list` VALUES ('72', '10', '8', 'it\'s good', '2023-04-18 17:28:44.671000');
INSERT INTO `uchat_message_list` VALUES ('73', '13', '8', 'test', '2023-04-18 17:32:38.778000');
INSERT INTO `uchat_message_list` VALUES ('74', '13', '8', 'hi', '2023-04-18 17:40:53.708000');
INSERT INTO `uchat_message_list` VALUES ('75', '13', '8', '1', '2023-04-18 17:45:15.507000');
INSERT INTO `uchat_message_list` VALUES ('76', '8', '13', '2', '2023-04-18 17:47:27.255000');
INSERT INTO `uchat_message_list` VALUES ('77', '13', '8', '：2', '2023-04-19 18:15:47.015000');
INSERT INTO `uchat_message_list` VALUES ('78', '13', '8', '：s', '2023-04-19 18:16:25.634000');
INSERT INTO `uchat_message_list` VALUES ('79', '13', '10', '：s', '2023-04-19 18:16:25.641000');
INSERT INTO `uchat_message_list` VALUES ('80', '13', '8', 'undefined：testing', '2023-04-19 18:22:04.760000');
INSERT INTO `uchat_message_list` VALUES ('81', '13', '10', 'undefined：testing', '2023-04-19 18:22:04.776000');
INSERT INTO `uchat_message_list` VALUES ('82', '10', '13', 'hello', '2023-04-19 18:24:30.879000');
INSERT INTO `uchat_message_list` VALUES ('83', '10', '13', 'testing', '2023-04-19 18:25:20.353000');
INSERT INTO `uchat_message_list` VALUES ('84', '10', '13', 'group set', '2023-04-19 18:26:33.584000');
INSERT INTO `uchat_message_list` VALUES ('85', '13', '8', 'group testing', '2023-04-19 18:29:17.527000');
INSERT INTO `uchat_message_list` VALUES ('86', '13', '10', 'group testing', '2023-04-19 18:29:17.543000');
INSERT INTO `uchat_message_list` VALUES ('87', '10', '13', 'hello', '2023-04-19 18:29:30.486000');
INSERT INTO `uchat_message_list` VALUES ('88', '10', '8', 'hello', '2023-04-19 18:29:30.492000');
INSERT INTO `uchat_message_list` VALUES ('89', '8', '13', 'i am stu1', '2023-04-19 18:30:18.628000');
INSERT INTO `uchat_message_list` VALUES ('90', '8', '10', 'i am stu1', '2023-04-19 18:30:18.633000');
INSERT INTO `uchat_message_list` VALUES ('91', '10', '13', 'i am stu2', '2023-04-19 18:30:35.537000');
INSERT INTO `uchat_message_list` VALUES ('92', '10', '8', 'i am stu2', '2023-04-19 18:30:35.543000');
INSERT INTO `uchat_message_list` VALUES ('93', '13', '8', 'i am admin', '2023-04-19 18:30:50.877000');
INSERT INTO `uchat_message_list` VALUES ('94', '13', '10', 'i am admin', '2023-04-19 18:30:50.883000');
INSERT INTO `uchat_message_list` VALUES ('95', '8', '10', 'hello', '2023-04-19 18:36:40.313000');
INSERT INTO `uchat_message_list` VALUES ('96', '10', '8', 'how are you', '2023-04-19 18:37:02.615000');
INSERT INTO `uchat_message_list` VALUES ('97', '8', '10', '2', '2023-04-19 18:37:36.656000');
INSERT INTO `uchat_message_list` VALUES ('98', '8', '10', '2', '2023-04-19 18:37:59.645000');
INSERT INTO `uchat_message_list` VALUES ('99', '8', '13', '3', '2023-04-19 18:38:32.085000');
INSERT INTO `uchat_message_list` VALUES ('100', '8', '10', '3', '2023-04-19 18:38:32.093000');
INSERT INTO `uchat_message_list` VALUES ('101', '10', '13', '6', '2023-04-19 18:38:40.017000');
INSERT INTO `uchat_message_list` VALUES ('102', '10', '8', '6', '2023-04-19 18:38:40.025000');
INSERT INTO `uchat_message_list` VALUES ('103', '8', '13', 'Group Chat 8: hello everyone', '2023-04-19 18:40:29.774000');
INSERT INTO `uchat_message_list` VALUES ('104', '8', '10', 'Group Chat 8: hello everyone', '2023-04-19 18:40:29.791000');
INSERT INTO `uchat_message_list` VALUES ('105', '10', '13', 'Group Chat 10: what\'s your name', '2023-04-19 18:40:44.887000');
INSERT INTO `uchat_message_list` VALUES ('106', '10', '8', 'Group Chat 10: what\'s your name', '2023-04-19 18:40:44.896000');
INSERT INTO `uchat_message_list` VALUES ('107', '8', '13', 'Group Chat 8: my name is stu1', '2023-04-19 18:41:15.719000');
INSERT INTO `uchat_message_list` VALUES ('108', '8', '10', 'Group Chat 8: my name is stu1', '2023-04-19 18:41:15.726000');
INSERT INTO `uchat_message_list` VALUES ('109', '10', '13', 'Group Chat 10: ok i need to go', '2023-04-19 18:41:45.269000');
INSERT INTO `uchat_message_list` VALUES ('110', '10', '8', 'Group Chat 10: ok i need to go', '2023-04-19 18:41:45.274000');
INSERT INTO `uchat_message_list` VALUES ('111', '13', '8', 'Group Chat 13: i know good bye', '2023-04-19 18:42:11.239000');
INSERT INTO `uchat_message_list` VALUES ('112', '13', '10', 'Group Chat 13: i know good bye', '2023-04-19 18:42:11.247000');
INSERT INTO `uchat_message_list` VALUES ('113', '10', '13', 'Group Chat 10: hi', '2023-04-22 15:42:26.977000');
INSERT INTO `uchat_message_list` VALUES ('114', '10', '8', 'Group Chat 10: hi', '2023-04-22 15:42:27.006000');
INSERT INTO `uchat_message_list` VALUES ('115', '13', '8', 'Group Chat 13: how are you', '2023-04-22 15:42:35.966000');
INSERT INTO `uchat_message_list` VALUES ('116', '13', '10', 'Group Chat 13: how are you', '2023-04-22 15:42:35.972000');
INSERT INTO `uchat_message_list` VALUES ('117', '13', '8', 'Group Chat 13: what\'s your name', '2023-04-22 15:42:52.786000');
INSERT INTO `uchat_message_list` VALUES ('118', '13', '10', 'Group Chat 13: what\'s your name', '2023-04-22 15:42:52.793000');
INSERT INTO `uchat_message_list` VALUES ('119', '8', '13', 'Group Chat 8: my name is stu1', '2023-04-22 15:43:15.127000');
INSERT INTO `uchat_message_list` VALUES ('120', '8', '10', 'Group Chat 8: my name is stu1', '2023-04-22 15:43:15.134000');
INSERT INTO `uchat_message_list` VALUES ('121', '12', '13', 'Group Chat 12: hi', '2023-04-22 15:43:35.287000');
INSERT INTO `uchat_message_list` VALUES ('122', '12', '8', 'Group Chat 12: hi', '2023-04-22 15:43:35.294000');
INSERT INTO `uchat_message_list` VALUES ('123', '12', '10', 'Group Chat 12: hi', '2023-04-22 15:43:35.298000');
INSERT INTO `uchat_message_list` VALUES ('124', '12', '10', 'hi', '2023-04-22 17:12:48.787000');
INSERT INTO `uchat_message_list` VALUES ('125', '13', '8', 'hello', '2023-04-23 03:44:00.020000');
INSERT INTO `uchat_message_list` VALUES ('126', '8', '13', 'hi', '2023-04-23 03:44:12.205000');
INSERT INTO `uchat_message_list` VALUES ('127', '13', '8', 'ok', '2023-04-23 03:44:26.035000');
INSERT INTO `uchat_message_list` VALUES ('128', '8', '13', 'ok', '2023-04-23 03:44:29.925000');
INSERT INTO `uchat_message_list` VALUES ('129', '13', '8', 'Group Chat Id = 13: hi', '2023-04-23 03:45:10.949000');
INSERT INTO `uchat_message_list` VALUES ('130', '13', '8', 'hi', '2023-04-23 03:46:46.897000');
INSERT INTO `uchat_message_list` VALUES ('131', '8', '13', 'hi', '2023-04-23 03:48:41.163000');
INSERT INTO `uchat_message_list` VALUES ('132', '8', '13', 'hi', '2023-04-23 05:39:27.622000');
INSERT INTO `uchat_message_list` VALUES ('133', '14', '8', 'hi', '2023-04-23 06:11:09.431000');
INSERT INTO `uchat_message_list` VALUES ('134', '8', '14', 'hello', '2023-04-23 06:11:17.756000');
INSERT INTO `uchat_message_list` VALUES ('135', '14', '8', 'how are you', '2023-04-23 06:11:23.604000');
INSERT INTO `uchat_message_list` VALUES ('136', '8', '14', 'i am fine', '2023-04-23 06:11:28.016000');
INSERT INTO `uchat_message_list` VALUES ('137', '8', '14', 'Group Chat Id = 8: hello', '2023-04-23 06:11:48.858000');
INSERT INTO `uchat_message_list` VALUES ('138', '14', '8', 'Group Chat Id = 14: hi', '2023-04-23 06:12:00.298000');
INSERT INTO `uchat_message_list` VALUES ('139', '8', '14', 'Group Chat Id = 8: how are you', '2023-04-23 06:12:25.478000');
INSERT INTO `uchat_message_list` VALUES ('140', '8', '13', 'hi', '2023-04-23 06:14:00.264000');
INSERT INTO `uchat_message_list` VALUES ('141', '12', '8', 'wow', '2023-04-23 06:14:28.661000');
INSERT INTO `uchat_message_list` VALUES ('142', '13', '12', 'wow', '2023-04-23 06:14:44.219000');
INSERT INTO `uchat_message_list` VALUES ('143', '13', '8', 'wow', '2023-04-23 06:14:44.227000');
INSERT INTO `uchat_message_list` VALUES ('144', '8', '12', 'hello', '2023-04-23 06:14:51.048000');
INSERT INTO `uchat_message_list` VALUES ('145', '13', '12', 'hi', '2023-04-23 06:16:12.499000');
INSERT INTO `uchat_message_list` VALUES ('146', '13', '8', 'hi', '2023-04-23 06:16:12.505000');
INSERT INTO `uchat_message_list` VALUES ('147', '8', '12', 'hi', '2023-04-23 06:16:21.369000');
INSERT INTO `uchat_message_list` VALUES ('148', '12', '8', 'heelo', '2023-04-23 06:17:42.061000');
INSERT INTO `uchat_message_list` VALUES ('149', '14', '13', 'hello everyone', '2023-04-23 06:19:39.627000');
INSERT INTO `uchat_message_list` VALUES ('150', '14', '8', 'hello everyone', '2023-04-23 06:19:39.642000');
INSERT INTO `uchat_message_list` VALUES ('151', '13', '14', 'hi my name is admin', '2023-04-23 06:19:49.062000');
INSERT INTO `uchat_message_list` VALUES ('152', '13', '8', 'hi my name is admin', '2023-04-23 06:19:49.069000');
INSERT INTO `uchat_message_list` VALUES ('153', '8', '13', 'my name is stu1', '2023-04-23 06:20:13.133000');
INSERT INTO `uchat_message_list` VALUES ('154', '8', '14', 'my name is stu1', '2023-04-23 06:20:13.138000');
INSERT INTO `uchat_message_list` VALUES ('155', '14', '13', 'my name is user1', '2023-04-23 06:20:26.243000');
INSERT INTO `uchat_message_list` VALUES ('156', '14', '8', 'my name is user1', '2023-04-23 06:20:26.247000');
INSERT INTO `uchat_message_list` VALUES ('157', '14', '13', 'hello', '2023-04-23 11:17:26.490000');
INSERT INTO `uchat_message_list` VALUES ('158', '13', '14', 'hi', '2023-04-23 11:17:48.687000');
INSERT INTO `uchat_message_list` VALUES ('159', '14', '13', 'testing', '2023-04-23 11:17:56.374000');
INSERT INTO `uchat_message_list` VALUES ('160', '14', '13', 'hello everyone', '2023-04-23 11:34:23.093000');
INSERT INTO `uchat_message_list` VALUES ('161', '14', '8', 'hello everyone', '2023-04-23 11:34:23.115000');
INSERT INTO `uchat_message_list` VALUES ('162', '8', '13', 'hi', '2023-04-23 11:34:28.368000');
INSERT INTO `uchat_message_list` VALUES ('163', '8', '14', 'hi', '2023-04-23 11:34:28.375000');
INSERT INTO `uchat_message_list` VALUES ('164', '13', '14', 'i can receive your message', '2023-04-23 11:34:42.659000');
INSERT INTO `uchat_message_list` VALUES ('165', '13', '8', 'i can receive your message', '2023-04-23 11:34:42.667000');
INSERT INTO `uchat_message_list` VALUES ('166', '13', '8', 'hello', '2023-04-23 11:34:50.560000');
INSERT INTO `uchat_message_list` VALUES ('167', '8', '13', 'i can only see your message', '2023-04-23 11:35:09.858000');
INSERT INTO `uchat_message_list` VALUES ('168', '13', '8', 'me 2', '2023-04-23 11:35:15.016000');

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of uchat_user
-- ----------------------------
INSERT INTO `uchat_user` VALUES ('8', 'stu1', '123456', null, '1');
INSERT INTO `uchat_user` VALUES ('10', 'stu2', '123456', null, '1');
INSERT INTO `uchat_user` VALUES ('11', 'stu3', '123456', null, '1');
INSERT INTO `uchat_user` VALUES ('12', 'stu4', '123456', null, '1');
INSERT INTO `uchat_user` VALUES ('13', 'admin', 'admin', null, '1');
INSERT INTO `uchat_user` VALUES ('14', 'user1', '123456', null, '1');
