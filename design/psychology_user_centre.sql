/*
 Navicat Premium Data Transfer

 Source Server         : Aliyun(47.110.247.139)
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 47.110.247.139:3306
 Source Schema         : psychology_user_centre

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 30/03/2021 12:01:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `id` bigint(20) NOT NULL COMMENT '资源id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '资源名称',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `uri` varchar(511) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '' COMMENT '资源URI',
  `type` int(11) NOT NULL COMMENT '类型(1分组,2菜单,3按钮)',
  `parent` bigint(20) NULL DEFAULT NULL COMMENT '父资源',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL COMMENT '角色id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '角色名',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `resource_id` bigint(20) NOT NULL COMMENT '资源id',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rr_role_id`(`role_id`) USING BTREE,
  INDEX `rr_resource_id`(`resource_id`) USING BTREE,
  CONSTRAINT `rr_resource_id` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `rr_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL COMMENT '学生id',
  `account` bigint(20) NULL DEFAULT NULL COMMENT '账号',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '学生编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '姓名',
  `major_id` bigint(20) NULL DEFAULT NULL COMMENT '专业id',
  `school_department_id` bigint(20) NULL DEFAULT NULL COMMENT '学院id',
  `grade` int(11) NULL DEFAULT NULL COMMENT '年级',
  `identity` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '身份证',
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '邮箱',
  `source` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '来源地(省)',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '家庭住址',
  `politic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '政治面貌(1党员, 2共青团员, 3群众)',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `s_user_id`(`account`) USING BTREE,
  INDEX `s_major_id`(`major_id`) USING BTREE,
  INDEX `s_sd_id`(`school_department_id`) USING BTREE,
  CONSTRAINT `s_major_id` FOREIGN KEY (`major_id`) REFERENCES `psychology_base`.`major` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `s_sd_id` FOREIGN KEY (`school_department_id`) REFERENCES `psychology_base`.`school_department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `s_user_id` FOREIGN KEY (`account`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '学生' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` bigint(20) NOT NULL COMMENT '教师id',
  `account` bigint(20) NULL DEFAULT NULL COMMENT '账号',
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '教师编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '姓名',
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `department_id` bigint(20) NULL DEFAULT NULL COMMENT '系别',
  `title_id` bigint(20) NULL DEFAULT NULL COMMENT '职称',
  `oversea` int(11) NULL DEFAULT NULL COMMENT '海外经历',
  `relation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '学缘关系 (本校, 外校(国内), 外校(国外))',
  `politic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '政治面貌',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '导师类型(1博导, 2硕导)',
  `education` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '学历(1本科, 2硕士研究生, 3博士研究生)',
  `degree` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '最高学位(1.学士, 2硕士, 3博士)',
  `degree_unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '最高学位获取单位',
  `research_direction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '研究方向',
  `job_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '工作类别',
  `position` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '任职情况',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `t_department_id`(`department_id`) USING BTREE,
  INDEX `t_title_id`(`title_id`) USING BTREE,
  INDEX `t_user_id`(`account`) USING BTREE,
  CONSTRAINT `t_department_id` FOREIGN KEY (`department_id`) REFERENCES `psychology_base`.`department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_title_id` FOREIGN KEY (`title_id`) REFERENCES `psychology_base`.`title` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_user_id` FOREIGN KEY (`account`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '教师' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '盐',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint(20) NOT NULL COMMENT '用户角色id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `create_by` bigint(20) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  UNIQUE INDEX `id_UNIQUE`(`id`) USING BTREE,
  INDEX `ur_role_id`(`role_id`) USING BTREE,
  CONSTRAINT `ur_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ur_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户对应角色表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
