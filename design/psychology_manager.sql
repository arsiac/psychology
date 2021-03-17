/*
 Navicat Premium Data Transfer

 Source Server         : Aliyun(47.110.247.139)
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 47.110.247.139:3306
 Source Schema         : psychology_manager

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 18/03/2021 04:27:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for achievement
-- ----------------------------
DROP TABLE IF EXISTS `achievement`;
CREATE TABLE `achievement`  (
  `id` bigint(20) NOT NULL COMMENT '成果id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '成果名称',
  `achievement_type_id` bigint(20) NULL DEFAULT NULL COMMENT '成果类型id',
  `award_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '奖励名称',
  `reword_level_id` bigint(20) NULL DEFAULT NULL COMMENT '获奖等级id',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '颁奖单位',
  `date` date NULL DEFAULT NULL COMMENT '获奖时间',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '证书编号',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  `return_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '退回修改建议',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `a_achoevement_type_id`(`achievement_type_id`) USING BTREE,
  INDEX `a_reword_level_id`(`reword_level_id`) USING BTREE,
  CONSTRAINT `a_achoevement_type_id` FOREIGN KEY (`achievement_type_id`) REFERENCES `psychology_base`.`achievement_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `a_reword_level_id` FOREIGN KEY (`reword_level_id`) REFERENCES `psychology_base`.`reword_level` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '成果' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for opus
-- ----------------------------
DROP TABLE IF EXISTS `opus`;
CREATE TABLE `opus`  (
  `id` bigint(20) NOT NULL COMMENT '著作id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '著作名称',
  `author_id` bigint(20) NULL DEFAULT NULL COMMENT '作者',
  `achievement_type_id` bigint(20) NULL DEFAULT NULL COMMENT '成果类型',
  `publishing_house` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '出版社',
  `publish_date` date NULL DEFAULT NULL COMMENT '出版时间',
  `isbn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'ISBN',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  `return_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '退回修改建议',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `id` bigint(20) NOT NULL COMMENT '论文id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '论文名称',
  `first_author_id` bigint(20) NULL DEFAULT NULL COMMENT '第一作者',
  `corresponding_author_id` bigint(20) NULL DEFAULT NULL COMMENT '通讯作者',
  `publication` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '刊物',
  `publish_date` date NULL DEFAULT NULL COMMENT '发表时间',
  `publication_version` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '发表年份\r\n\r\n及卷（期）数',
  `paper_level_id` bigint(20) NULL DEFAULT NULL COMMENT '论文级别',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  `return_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '退回修改建议',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `p_paper_level_id`(`paper_level_id`) USING BTREE,
  INDEX `p_first_author_id`(`first_author_id`) USING BTREE,
  INDEX `p_c_author_id`(`corresponding_author_id`) USING BTREE,
  CONSTRAINT `p_c_author_id` FOREIGN KEY (`corresponding_author_id`) REFERENCES `psychology_base`.`teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `p_first_author_id` FOREIGN KEY (`first_author_id`) REFERENCES `psychology_base`.`teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `p_paper_level_id` FOREIGN KEY (`paper_level_id`) REFERENCES `psychology_base`.`paper_level` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` bigint(20) NOT NULL COMMENT '项目id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '项目名称',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '项目编码',
  `school_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '校内编码',
  `project_source_id` bigint(20) NULL DEFAULT NULL COMMENT '项目来源id',
  `subject_type_id` bigint(20) NULL DEFAULT NULL COMMENT '课题类型id',
  `project_start_date` date NULL DEFAULT NULL COMMENT '立项时间',
  `project_end_date` date NULL DEFAULT NULL COMMENT '结束时间',
  `money` decimal(20, 2) NULL DEFAULT NULL COMMENT '经费(万元)',
  `manager_id` bigint(20) NULL DEFAULT NULL COMMENT '项目负责人',
  `project_is_end` int(11) NULL DEFAULT NULL COMMENT '是否结题(0未结题, 1已结题)',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态(0未提交, 1已提交, 2审核通过, 3退回修改)',
  `return_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '退回修改建议',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `p_project_source_id`(`project_source_id`) USING BTREE,
  INDEX `p_subject_type_id`(`subject_type_id`) USING BTREE,
  INDEX `p_user_id`(`manager_id`) USING BTREE,
  CONSTRAINT `p_project_source_id` FOREIGN KEY (`project_source_id`) REFERENCES `psychology_base`.`project_source` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `p_subject_type_id` FOREIGN KEY (`subject_type_id`) REFERENCES `psychology_base`.`subject_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `p_user_id` FOREIGN KEY (`manager_id`) REFERENCES `psychology_base`.`teacher` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '科研立项' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for table_base
-- ----------------------------
DROP TABLE IF EXISTS `table_base`;
CREATE TABLE `table_base`  (
  `status` int(11) NULL DEFAULT NULL COMMENT '状态',
  `return_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '退回修改建议',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '表基础字段' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
