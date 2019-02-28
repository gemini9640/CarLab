CREATE DATABASE  IF NOT EXISTS `carlab` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `carlab`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: carlab
-- ------------------------------------------------------
-- Server version	5.6.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking_item`
--

DROP TABLE IF EXISTS `booking_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `booking_no` bigint(20) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `category_id` varchar(100) DEFAULT NULL,
  `user_car_id` int(11) DEFAULT NULL,
  `merchant` varchar(50) DEFAULT NULL,
  `current_unit_price` decimal(20,2) DEFAULT NULL,
  `other_charge` decimal(20,2) DEFAULT NULL,
  `other_charge_info` varchar(500) DEFAULT NULL,
  `total_price` decimal(20,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(3) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `booking_time` datetime DEFAULT NULL,
  `finish_time` datetime DEFAULT NULL,
  `remark` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `booking_no_index` (`booking_no`) USING BTREE,
  KEY `booking_no_user_id_index` (`user_id`,`booking_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_item`
--

LOCK TABLES `booking_item` WRITE;
/*!40000 ALTER TABLE `booking_item` DISABLE KEYS */;
INSERT INTO `booking_item` VALUES (2,'CC_0',1537700231197,1,'100011',1,'CM_1',50.00,150.50,'shipping fee',200.50,'2018-09-21 02:12:44',1,'2018-10-03 01:01:29','2018-10-03 01:01:29',NULL,'c0 只提交服务'),(3,'CC_1',NULL,1,'100011',1,'CM_1',50.00,150.50,'shipping fee',200.50,'2018-09-21 02:27:34',1,'2018-09-23 17:45:06','2018-09-23 17:45:06',NULL,'CC_1 提交服务和车信息（第一次递交车信息）'),(4,'CC_1',NULL,NULL,'100011',4,NULL,NULL,NULL,NULL,NULL,'2018-09-21 03:08:30',0,NULL,NULL,NULL,'CC_1 提交服务和车信息（车图片已经存在）'),(5,'CC_0',1537700231197,1,'100011',1,'CM_1',50.00,150.50,'shipping fee',200.50,'2018-09-23 18:52:32',1,'2018-10-03 01:01:29','2018-10-03 01:01:29',NULL,'c0 （第一次递交车信息)'),(6,'CC_0',1537700231197,1,'100011',1,'CM_1',50.00,150.50,'shipping fee',200.50,'2018-09-23 18:52:48',1,'2018-10-03 01:01:29','2018-10-03 01:01:29',NULL,'c0 （第一次递交车信息)');
/*!40000 ALTER TABLE `booking_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-10  1:21:02
