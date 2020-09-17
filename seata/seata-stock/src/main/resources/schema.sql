/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : hmily-stock

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 15/09/2020 11:09:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for seataStock
-- ----------------------------
DROP TABLE IF EXISTS `seata_inventory`;
CREATE TABLE `seata_inventory`  (
  `id` bigint NOT NULL COMMENT '主键',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `lock_inventory` int NULL DEFAULT NULL COMMENT '锁定库存',
  `product_id` bigint NULL DEFAULT NULL COMMENT '产品ID',
  `product_price` decimal(19, 2) NULL DEFAULT NULL COMMENT '产品单价',
  `total_inventory` int NULL DEFAULT NULL COMMENT '总库存',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '产品库存' ROW_FORMAT = Fixed;

SET FOREIGN_KEY_CHECKS = 1;
