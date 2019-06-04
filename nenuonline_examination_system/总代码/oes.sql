/*
 Navicat Premium Data Transfer

 Source Server         : foreverkw
 Source Server Type    : MySQL
 Source Server Version : 50637
 Source Host           : 47.102.194.223:3306
 Source Schema         : oes

 Target Server Type    : MySQL
 Target Server Version : 50637
 File Encoding         : 65001

 Date: 04/06/2019 08:49:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `Aid` int(11) NOT NULL AUTO_INCREMENT,
  `Owner` int(11) NOT NULL,
  `Score` int(11) NOT NULL,
  `Exam` int(11) NOT NULL,
  PRIMARY KEY (`Aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES (12, 1, 10, 23);
INSERT INTO `answer` VALUES (13, 1, 0, 27);
INSERT INTO `answer` VALUES (14, 3, 5, 24);
INSERT INTO `answer` VALUES (15, 1, 5, 24);

-- ----------------------------
-- Table structure for answersinglechoiceproblem
-- ----------------------------
DROP TABLE IF EXISTS `answersinglechoiceproblem`;
CREATE TABLE `answersinglechoiceproblem`  (
  `SPid` int(11) NOT NULL,
  `Uid` int(11) NOT NULL,
  `Eid` int(11) NOT NULL,
  `Choice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Score` int(11) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of answersinglechoiceproblem
-- ----------------------------
INSERT INTO `answersinglechoiceproblem` VALUES (17, 1, 23, 'A', 5);
INSERT INTO `answersinglechoiceproblem` VALUES (18, 1, 23, 'B', 5);
INSERT INTO `answersinglechoiceproblem` VALUES (19, 1, 23, 'D', 0);
INSERT INTO `answersinglechoiceproblem` VALUES (20, 1, 23, 'C', 0);
INSERT INTO `answersinglechoiceproblem` VALUES (18, 1, 27, 'A', 0);
INSERT INTO `answersinglechoiceproblem` VALUES (22, 3, 24, 'A', 0);
INSERT INTO `answersinglechoiceproblem` VALUES (23, 3, 24, 'B', 5);
INSERT INTO `answersinglechoiceproblem` VALUES (24, 3, 24, 'C', 0);
INSERT INTO `answersinglechoiceproblem` VALUES (22, 1, 24, 'A', 0);
INSERT INTO `answersinglechoiceproblem` VALUES (23, 1, 24, 'B', 5);
INSERT INTO `answersinglechoiceproblem` VALUES (24, 1, 24, 'C', 0);

-- ----------------------------
-- Table structure for examsinglechoiceproblem
-- ----------------------------
DROP TABLE IF EXISTS `examsinglechoiceproblem`;
CREATE TABLE `examsinglechoiceproblem`  (
  `SPid` int(11) NOT NULL,
  `Eid` int(11) NOT NULL,
  `EPid` int(11) NOT NULL,
  `Score` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of examsinglechoiceproblem
-- ----------------------------
INSERT INTO `examsinglechoiceproblem` VALUES (17, 23, 1, 5);
INSERT INTO `examsinglechoiceproblem` VALUES (18, 23, 2, 5);
INSERT INTO `examsinglechoiceproblem` VALUES (19, 23, 3, 5);
INSERT INTO `examsinglechoiceproblem` VALUES (20, 23, 4, 5);
INSERT INTO `examsinglechoiceproblem` VALUES (22, 24, 1, 5);
INSERT INTO `examsinglechoiceproblem` VALUES (23, 24, 2, 5);
INSERT INTO `examsinglechoiceproblem` VALUES (24, 24, 3, 5);
INSERT INTO `examsinglechoiceproblem` VALUES (20, 25, 1, 5);
INSERT INTO `examsinglechoiceproblem` VALUES (19, 26, 1, 5);
INSERT INTO `examsinglechoiceproblem` VALUES (18, 27, 1, 5);

-- ----------------------------
-- Table structure for examwithouttest
-- ----------------------------
DROP TABLE IF EXISTS `examwithouttest`;
CREATE TABLE `examwithouttest`  (
  `Eid` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `StartTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `EndTime` timestamp(0) NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Owner` int(11) NOT NULL,
  PRIMARY KEY (`Eid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of examwithouttest
-- ----------------------------
INSERT INTO `examwithouttest` VALUES (23, '数据库基础知识练习题', '123', '2019-05-15 15:55:00', '2019-06-15 15:55:00', 1);
INSERT INTO `examwithouttest` VALUES (24, '数据结构期末考试', 'nenu', '2019-05-15 15:55:00', '2019-07-15 15:55:00', 1);
INSERT INTO `examwithouttest` VALUES (25, 'NENU第三次挂科考试', '123', '2019-05-15 15:55:00', '2019-05-29 15:55:00', 1);
INSERT INTO `examwithouttest` VALUES (26, 'NENU第四次挂科考试', '123', '2019-06-15 15:55:00', '2019-07-15 15:55:00', 1);
INSERT INTO `examwithouttest` VALUES (27, 'NENU第五次挂科考试', '123', '2019-05-15 15:55:00', '2019-08-15 15:55:00', 1);

-- ----------------------------
-- Table structure for singlechoiceproblem
-- ----------------------------
DROP TABLE IF EXISTS `singlechoiceproblem`;
CREATE TABLE `singlechoiceproblem`  (
  `SPid` int(11) NOT NULL AUTO_INCREMENT,
  `Content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Owner` int(11) NOT NULL,
  `ProvideTime` date NOT NULL,
  `OptionA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `OptionB` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `OptionC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `OptionD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SPid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of singlechoiceproblem
-- ----------------------------
INSERT INTO `singlechoiceproblem` VALUES (17, '要保证数据库的逻辑数据独立性，需要修改的是', 1, '2019-05-29', '模式与外模式之间的映射', '模式与内模式之间的映射', '模式', '三级模式', 'A');
INSERT INTO `singlechoiceproblem` VALUES (18, '关系数据模型是目前最重要的一种数据模型，它的三个要素分别是', 1, '2019-05-29', '实体完整性、参照完整性、用户自定义完整性', '数据结构、关系操作、完整性约束', '数据增加、数据修改、数据查询', '外模式、模式、内模式', 'B');
INSERT INTO `singlechoiceproblem` VALUES (19, '1 + 1 = ？', 1, '2019-05-29', '2', '3', '4', '5', 'A');
INSERT INTO `singlechoiceproblem` VALUES (20, '数据库（DB）、数据库系统（DBS）和数据库管理系统（DBMS）三者之间的关系是', 1, '2019-05-29', 'DBS包括DB和DBMS', 'DBMS包括DB和DBS', 'DB包括DBS和DBMS', 'DBS包括DB，也就是DBMS', 'A');
INSERT INTO `singlechoiceproblem` VALUES (21, '数据库三级模式之间存在的映象关系正确的是', 1, '2019-05-29', '外模式/内模式', '外模式/模式', '外模式/外模式', '模式/模式', 'B');
INSERT INTO `singlechoiceproblem` VALUES (22, '采用邻接表存储的图的广度优先遍历算法类似于二叉树的', 1, '2019-05-29', '先序遍历', '中序遍历', '后序遍历', '按层遍历', 'D');
INSERT INTO `singlechoiceproblem` VALUES (23, '要连通具有n个顶点的有向图,至少需要___条边 ', 1, '2019-05-29', 'n - 1', 'n', 'n + 1', '2n', 'B');
INSERT INTO `singlechoiceproblem` VALUES (24, '一棵124个叶结点的完全二叉树,最多有____个结点', 1, '2019-05-29', '247', '248', '249', '250', 'B');
INSERT INTO `singlechoiceproblem` VALUES (25, '23 + 5', 1, '2019-05-29', '28', '38', '48', '13', 'A');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Uid` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `UserPwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `UserPower` int(11) DEFAULT NULL,
  `UserSchool` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `UserGrade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `UserClass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `UserSex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `UserTel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `UserAdr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'linxi', 'linxi', 1, 'NENU', '2016', 'SE2', 'Male', '18233429899', '长春', '哒哒哒');
INSERT INTO `user` VALUES (2, 'zhangs', 'zhangs', 2, 'NENU', '2016', 'CS2', 'Male', '1173101159', '东北师范大学', NULL);
INSERT INTO `user` VALUES (3, 'lisi', 'lisi', 3, 'NENU', '2015', 'CS3', 'Emale', '18170140658', '信息科学与技术学院', NULL);
INSERT INTO `user` VALUES (4, 'wangw', 'wangw', 4, 'NENU', '2016', 'SE1', 'Male', '3467835812', '净月校区', NULL);

-- ----------------------------
-- Table structure for userpower
-- ----------------------------
DROP TABLE IF EXISTS `userpower`;
CREATE TABLE `userpower`  (
  `PowerID` int(11) NOT NULL AUTO_INCREMENT,
  `PowerDegree` int(255) NOT NULL,
  `PowerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`PowerID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userpower
-- ----------------------------
INSERT INTO `userpower` VALUES (1, 1, 'Admin');
INSERT INTO `userpower` VALUES (2, 2, 'Affairs');
INSERT INTO `userpower` VALUES (3, 3, 'Teacher');
INSERT INTO `userpower` VALUES (4, 4, 'Studen');

SET FOREIGN_KEY_CHECKS = 1;
