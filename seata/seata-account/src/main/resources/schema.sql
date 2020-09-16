/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : hmily-account

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 15/09/2020 11:09:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS seata_account;
CREATE TABLE `seata-account`  (
  `id` bigint NOT NULL COMMENT '主键',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `freeze_money` decimal(19, 2) NULL DEFAULT NULL COMMENT '冻结金额',
  `total_money` decimal(19, 2) NULL DEFAULT NULL COMMENT '总金额',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '账户' ROW_FORMAT = Fixed;

SET FOREIGN_KEY_CHECKS = 1;
