/*
Navicat MySQL Data Transfer

Source Server         : mysql-local
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : cnaps

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2017-01-20 12:06:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `id` varchar(32) NOT NULL,
  `code` varchar(4) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bankcode` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for branchbank
-- ----------------------------
DROP TABLE IF EXISTS `branchbank`;
CREATE TABLE `branchbank` (
  `id` varchar(32) NOT NULL,
  `cnaps` varchar(12) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `bankcode` varchar(4) DEFAULT NULL,
  `citycode` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cnaps` (`cnaps`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` varchar(32) NOT NULL,
  `code` varchar(4) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `procode` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `citycode` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `id` varchar(32) NOT NULL,
  `code` varchar(3) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `provincecode` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
