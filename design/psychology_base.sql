/*
 Navicat Premium Data Transfer

 Source Server         : docker(root[127.0.0.1])
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 127.0.0.1:3306
 Source Schema         : psychology_base

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 21/04/2021 15:19:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for achievement_type
-- ----------------------------
DROP TABLE IF EXISTS `achievement_type`;
CREATE TABLE `achievement_type` (
  `id` bigint(20) NOT NULL COMMENT '成果形式id',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '成果形式name',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='成果形式';

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` bigint(20) NOT NULL COMMENT '系别id',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '系别名称',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='系别';

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` bigint(20) NOT NULL COMMENT '字典id',
  `dictionary_type_id` bigint(20) NOT NULL COMMENT '字典类型id',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `value` int(11) DEFAULT NULL COMMENT '值',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`),
  KEY `d_dt_id` (`dictionary_type_id`),
  CONSTRAINT `d_dt_id` FOREIGN KEY (`dictionary_type_id`) REFERENCES `dictionary_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='字典';

-- ----------------------------
-- Table structure for dictionary_type
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_type`;
CREATE TABLE `dictionary_type` (
  `id` bigint(20) NOT NULL COMMENT '字典类型id',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '字典名称',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '字典描述',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='字典类型';

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` bigint(20) NOT NULL COMMENT '专业id',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '专业名称',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='专业';

-- ----------------------------
-- Table structure for paper_level
-- ----------------------------
DROP TABLE IF EXISTS `paper_level`;
CREATE TABLE `paper_level` (
  `id` bigint(20) NOT NULL COMMENT '论文级别id',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '论文级别名称',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='论文级别';

-- ----------------------------
-- Table structure for project_source
-- ----------------------------
DROP TABLE IF EXISTS `project_source`;
CREATE TABLE `project_source` (
  `id` bigint(20) NOT NULL COMMENT '项目来源id',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '项目来源名称',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='课题来源';

-- ----------------------------
-- Table structure for reword_level
-- ----------------------------
DROP TABLE IF EXISTS `reword_level`;
CREATE TABLE `reword_level` (
  `id` bigint(20) NOT NULL COMMENT '获奖等级id',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '获奖等级',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='获奖等级';

-- ----------------------------
-- Table structure for school_department
-- ----------------------------
DROP TABLE IF EXISTS `school_department`;
CREATE TABLE `school_department` (
  `id` bigint(20) NOT NULL COMMENT '学院id',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '学院名称',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='学院';

-- ----------------------------
-- Table structure for subject_type
-- ----------------------------
DROP TABLE IF EXISTS `subject_type`;
CREATE TABLE `subject_type` (
  `id` bigint(20) NOT NULL COMMENT '课题类别id',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '课题类别',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='课题类别';

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` bigint(20) NOT NULL COMMENT '教师id',
  `code` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '教师编号',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `department_id` bigint(20) DEFAULT NULL COMMENT '系别',
  `title_id` bigint(20) DEFAULT NULL COMMENT '职称',
  `oversea` int(11) DEFAULT NULL COMMENT '海外经历',
  `relation` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '学缘关系 (1本校, 2外校(国内), 3外校(国外))',
  `politic` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '政治面貌(1党员, 2共青团员, 3群众)',
  `type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '导师类型(1博导, 2硕导)',
  `education` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '学历(1本科, 2硕士研究生, 3博士研究生)',
  `degree` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '最高学位(1.学士, 2硕士, 3博士)',
  `degree_unit` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '最高学位获取单位',
  `research_direction` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '研究方向',
  `job_type` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '工作类别',
  `position` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '任职情况',
  `account` bigint(20) DEFAULT NULL COMMENT '账号',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `t_department_id` (`department_id`) USING BTREE,
  KEY `t_title_id` (`title_id`) USING BTREE,
  KEY `t_user_id` (`account`) USING BTREE,
  CONSTRAINT `t_department_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `t_title_id` FOREIGN KEY (`title_id`) REFERENCES `title` (`id`),
  CONSTRAINT `t_user_id` FOREIGN KEY (`account`) REFERENCES `psychology_user_centre`.`user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='教师';

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title` (
  `id` bigint(20) NOT NULL COMMENT '职称id',
  `name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '职称名称',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC COMMENT='职称';

SET FOREIGN_KEY_CHECKS = 1;
