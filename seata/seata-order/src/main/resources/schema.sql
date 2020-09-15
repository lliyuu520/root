/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : hmily-hmilyOrder

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 15/09/2020 10:58:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hmilyOrder
-- ----------------------------
DROP TABLE IF EXISTS `seata-order`;
CREATE TABLE `seata-order`  (
  `id` bigint NOT NULL COMMENT '主键',
  `order_num` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单编号',
  `pay_status` int NULL DEFAULT NULL COMMENT '支付状态',
  `product_id` bigint NULL DEFAULT NULL COMMENT '产品ID',
  `total_money` decimal(18, 2) NULL DEFAULT NULL COMMENT '总金额',
  `product_price` decimal(18, 2) NULL DEFAULT NULL COMMENT '单价',
  `buy_num` int NULL DEFAULT NULL COMMENT '购买数量',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
