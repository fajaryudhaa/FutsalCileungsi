/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : futsal

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-07-13 05:42:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `alat`
-- ----------------------------
DROP TABLE IF EXISTS `alat`;
CREATE TABLE `alat` (
  `kode` varchar(20) NOT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `harga` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of alat
-- ----------------------------
INSERT INTO `alat` VALUES ('AL-0001', 'Bola', '10000');

-- ----------------------------
-- Table structure for `booking`
-- ----------------------------
DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `nbooking` varchar(20) NOT NULL,
  `tgl` varchar(50) DEFAULT NULL,
  `namateam` varchar(20) DEFAULT NULL,
  `namasewa` varchar(50) DEFAULT NULL,
  `namalpg` varchar(20) DEFAULT NULL,
  `harga` varchar(20) DEFAULT NULL,
  `dp` varchar(20) DEFAULT NULL,
  `jammsk` varchar(100) NOT NULL,
  `jamkluar` varchar(100) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nbooking`,`jammsk`,`jamkluar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of booking
-- ----------------------------

-- ----------------------------
-- Table structure for `lapangan`
-- ----------------------------
DROP TABLE IF EXISTS `lapangan`;
CREATE TABLE `lapangan` (
  `kode` varchar(15) NOT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `harga` varchar(20) DEFAULT NULL,
  `hargambr` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of lapangan
-- ----------------------------
INSERT INTO `lapangan` VALUES ('KD-0001', 'Lapangan 1', '200000', 'Mendapat Diskon');
INSERT INTO `lapangan` VALUES ('KD-0002', 'Lapangan 2', '200000', 'Mendapat Diskon');

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(10) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('user', 'pass');

-- ----------------------------
-- Table structure for `pembayaran`
-- ----------------------------
DROP TABLE IF EXISTS `pembayaran`;
CREATE TABLE `pembayaran` (
  `nobayar` varchar(20) NOT NULL,
  `tglbayar` varchar(100) DEFAULT NULL,
  `nmteam` varchar(20) DEFAULT NULL,
  `lpg` varchar(20) DEFAULT NULL,
  `hargalpg` varchar(20) DEFAULT NULL,
  `hargaalat` varchar(20) DEFAULT NULL,
  `jammsk` varchar(20) DEFAULT NULL,
  `jamklr` varchar(20) DEFAULT NULL,
  `totaljam` varchar(20) DEFAULT NULL,
  `bayar` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nobayar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pembayaran
-- ----------------------------

-- ----------------------------
-- Table structure for `petugas`
-- ----------------------------
DROP TABLE IF EXISTS `petugas`;
CREATE TABLE `petugas` (
  `nama` varchar(20) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `notlp` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of petugas
-- ----------------------------
INSERT INTO `petugas` VALUES ('Eko Saputra', 'Cileungsi', '081298761234');

-- ----------------------------
-- Table structure for `pimpinan`
-- ----------------------------
DROP TABLE IF EXISTS `pimpinan`;
CREATE TABLE `pimpinan` (
  `nama` varchar(20) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `notlp` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pimpinan
-- ----------------------------
INSERT INTO `pimpinan` VALUES ('Gatot Vayana', 'Bogor', '0897665544');

-- ----------------------------
-- Table structure for `team`
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `kode` varchar(30) NOT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `notlp` varchar(15) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`kode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('MB-0001', 'j', 'a	2', '2', 'Member');
