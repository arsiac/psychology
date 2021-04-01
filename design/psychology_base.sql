/*
 Navicat Premium Data Transfer

 Source Server         : Aliyun(47.110.247.139)
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 47.110.247.139:3306
 Source Schema         : psychology_base

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 30/03/2021 12:02:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for achievement_type
-- ----------------------------
DROP TABLE IF EXISTS `achievement_type`;
CREATE TABLE `achievement_type`  (
  `id` bigint(20) NOT NULL COMMENT '成果形式id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '成果形式name',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '成果形式' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` bigint(20) NOT NULL COMMENT '系别id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '系别名称',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系别' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `id` bigint(20) NOT NULL COMMENT '专业id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '专业名称',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '专业' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for paper_level
-- ----------------------------
DROP TABLE IF EXISTS `paper_level`;
CREATE TABLE `paper_level`  (
  `id` bigint(20) NOT NULL COMMENT '论文级别id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '论文级别名称',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '论文级别' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for project_source
-- ----------------------------
DROP TABLE IF EXISTS `project_source`;
CREATE TABLE `project_source`  (
  `id` bigint(20) NOT NULL COMMENT '项目来源id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '项目来源名称',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '课题来源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reword_level
-- ----------------------------
DROP TABLE IF EXISTS `reword_level`;
CREATE TABLE `reword_level`  (
  `id` bigint(20) NOT NULL COMMENT '获奖等级id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '获奖等级',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '获奖等级' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for school_department
-- ----------------------------
DROP TABLE IF EXISTS `school_department`;
CREATE TABLE `school_department`  (
  `id` bigint(20) NOT NULL COMMENT '学院id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '学院名称',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '学院' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for subject_type
-- ----------------------------
DROP TABLE IF EXISTS `subject_type`;
CREATE TABLE `subject_type`  (
  `id` bigint(20) NOT NULL COMMENT '课题类别id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '课题类别',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '课题类别' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` bigint(20) NOT NULL COMMENT '教师id',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '教师编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '姓名',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `department_id` bigint(20) NULL DEFAULT NULL COMMENT '系别',
  `title_id` bigint(20) NULL DEFAULT NULL COMMENT '职称',
  `oversea` int(11) NULL DEFAULT NULL COMMENT '海外经历',
  `relation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '学缘关系 (1本校, 2外校(国内), 3外校(国外))',
  `politic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '政治面貌(1党员, 2共青团员, 3群众)',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '导师类型(1博导, 2硕导)',
  `education` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '学历(1本科, 2硕士研究生, 3博士研究生)',
  `degree` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '最高学位(1.学士, 2硕士, 3博士)',
  `degree_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '最高学位获取单位',
  `research_direction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '研究方向',
  `job_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '工作类别',
  `position` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '任职情况',
  `account` bigint(20) NULL DEFAULT NULL COMMENT '账号',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_department_id`(`department_id`) USING BTREE,
  INDEX `t_title_id`(`title_id`) USING BTREE,
  INDEX `t_user_id`(`account`) USING BTREE,
  CONSTRAINT `t_department_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_title_id` FOREIGN KEY (`title_id`) REFERENCES `title` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_user_id` FOREIGN KEY (`account`) REFERENCES `psychology_user_centre`.`user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '教师' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title`  (
  `id` bigint(20) NOT NULL COMMENT '职称id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '职称名称',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '职称' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
