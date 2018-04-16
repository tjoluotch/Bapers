-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: solsoft_DB
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Current Database: `solsoft_DB`
--

/*!40000 DROP DATABASE IF EXISTS `solsoft_DB`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `solsoft_DB` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `solsoft_DB`;

--
-- Table structure for table `alert`
--

DROP TABLE IF EXISTS `alert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alert` (
  `alertID` int(11) NOT NULL AUTO_INCREMENT,
  `orderID` int(11) NOT NULL,
  `description` longtext,
  `target` varchar(45) DEFAULT NULL,
  `account_no` varchar(45) NOT NULL,
  `been_seen` tinyint(1) DEFAULT '0',
  `joblineID` int(11) NOT NULL,
  `version` bigint(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`alertID`),
  KEY `orderIDidx_idx` (`orderID`),
  KEY `accountNoidx_idx` (`account_no`),
  KEY `joblineIDidx_idx` (`joblineID`),
  CONSTRAINT `accountNoidx` FOREIGN KEY (`account_no`) REFERENCES `customer` (`account_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `joblinidx` FOREIGN KEY (`joblineID`) REFERENCES `job_line` (`job_lineID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderIDidx` FOREIGN KEY (`orderID`) REFERENCES `order_table` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert`
--

LOCK TABLES `alert` WRITE;
/*!40000 ALTER TABLE `alert` DISABLE KEYS */;
INSERT INTO `alert` VALUES (31,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,250,2),(32,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,251,6),(33,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,252,5),(34,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,253,4),(35,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,254,3),(36,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,255,2),(37,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,250,7),(38,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,251,6),(39,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,252,5),(40,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,253,4),(41,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,254,3),(42,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,255,2),(43,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,250,7),(44,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,251,6),(45,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,252,5),(46,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,253,4),(47,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,254,3),(48,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,255,2),(49,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,250,7),(50,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,251,6),(51,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,252,5),(52,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,253,4),(53,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,254,3),(54,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,255,2),(55,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,250,7),(56,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,251,6),(57,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,252,5),(58,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,253,4),(59,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,254,3),(60,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,255,2),(61,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',0,250,1),(62,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',0,251,1),(63,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',0,252,1),(64,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',0,253,1),(65,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',0,254,1),(66,1037,'Job: ACN54 for Account Number: ACC0001 is within 24 hours of its deadline : Tue Apr 17 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',0,255,1);
/*!40000 ALTER TABLE `alert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `account_no` varchar(45) NOT NULL,
  `forename` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `account_holder_name` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `address1` varchar(20) DEFAULT NULL,
  `address2` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `region` varchar(20) DEFAULT NULL,
  `postcode` varchar(9) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `valued_customer` tinyint(1) DEFAULT NULL,
  `discount_type` varchar(45) DEFAULT NULL,
  `status` varchar(45) NOT NULL DEFAULT 'Active',
  `version` bigint(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`account_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('ACC0001','David','Rhind','City, University of London (City)',NULL,'Northampton Square','','London','','EC1V 0HB','0207 040 8000','David.Rhind@city.ac.uk',1,'Fixed','Active',0),('ACC0002','Alex','Wright','InfoPharma Ltd',NULL,'25 Bond Street','','London','','WC1V 8LS','0207 321 8001','Alex.Wright@infopharma.com',1,'Flexible','Active',0),('ACC0003','Sarah','Brocklehurst','Hello Magazine',NULL,'12 Bond Street','','London','','WC1V 8NS','0203 456 7809','Sarah.Brocklehurst@hello.com',1,'Flexible','Active',0),('ACC0004','Eva','Bauyer','Eva Bauyer',NULL,'1 Liverpool Street','','London','','EC2V 8NS','0208 555 8989','eva.bauyer@gmail.com',1,'Fixed','Active',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount_plan`
--

DROP TABLE IF EXISTS `discount_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discount_plan` (
  `discount_planID` int(11) NOT NULL AUTO_INCREMENT,
  `taskID` int(11) DEFAULT NULL,
  `rate` float DEFAULT '1',
  `account_no` varchar(45) NOT NULL,
  `is_flexible` tinyint(4) DEFAULT '0',
  `variable_rate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`discount_planID`),
  KEY `account_noidx_idx` (`account_no`),
  KEY `taskIDidx_idx` (`taskID`),
  CONSTRAINT `account_noidx` FOREIGN KEY (`account_no`) REFERENCES `customer` (`account_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `taskIDidx` FOREIGN KEY (`taskID`) REFERENCES `task` (`taskID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount_plan`
--

LOCK TABLES `discount_plan` WRITE;
/*!40000 ALTER TABLE `discount_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `discount_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `code` varchar(10) NOT NULL,
  `job_description` varchar(45) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `version` bigint(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES ('ABN54','5 x 4 B& W copy negatives',19,0),('ACN54','5 x 4 Colour copy negatives',19,0),('ACT108 ','10 x 8 Colour copy transparency',96,0),('ACT35','35 mm Colour copy transparency',20,0),('B108 ','10 x 8 processing ',8.3,0),('C108','10 x 8 C41 processing',8.3,0);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_line`
--

DROP TABLE IF EXISTS `job_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_line` (
  `job_lineID` int(11) NOT NULL AUTO_INCREMENT,
  `job_code` varchar(45) NOT NULL,
  `job_deadline` date DEFAULT NULL,
  `special_instructions` varchar(100) DEFAULT NULL,
  `reminder_status` varchar(20) DEFAULT NULL,
  `version` bigint(5) NOT NULL DEFAULT '0',
  `orderID` int(11) NOT NULL,
  `payment_detailID` int(11) DEFAULT NULL,
  PRIMARY KEY (`job_lineID`),
  KEY `fk_job_line_job1_idx` (`job_code`),
  KEY `orderID_idx` (`orderID`),
  KEY `paymentDetailIDidx_idx` (`payment_detailID`),
  CONSTRAINT `fk_job_line_job1` FOREIGN KEY (`job_code`) REFERENCES `job` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderID` FOREIGN KEY (`orderID`) REFERENCES `order_table` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `paymentDetailIDidx` FOREIGN KEY (`payment_detailID`) REFERENCES `payment_detail` (`payment_detailID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_line`
--

LOCK TABLES `job_line` WRITE;
/*!40000 ALTER TABLE `job_line` DISABLE KEYS */;
INSERT INTO `job_line` VALUES (188,'ACN54','2018-09-09','Special Instructions',NULL,0,1030,NULL),(189,'ACN54','2018-09-09','Special Instructions',NULL,0,1030,NULL),(190,'ACN54','2018-09-09','Special Instructions',NULL,0,1030,NULL),(191,'ACN54','2018-09-09','Special Instructions',NULL,0,1030,NULL),(192,'ACN54','2018-09-09','Special Instructions',NULL,0,1030,NULL),(193,'ACN54','2018-09-09','Special Instructions',NULL,0,1030,NULL),(194,'ABN54','2018-04-16','Special Instructions',NULL,0,1031,NULL),(195,'ACT108','2018-04-16','Special Instructions',NULL,0,1031,NULL),(196,'ACT108','2018-04-16','Special Instructions',NULL,0,1031,NULL),(197,'ABN54','2018-04-16','Special Instructions',NULL,0,1031,NULL),(198,'ABN54','2018-04-16','Special Instructions',NULL,0,1031,NULL),(199,'ACT108','2018-04-16','Special Instructions',NULL,0,1031,NULL),(200,'ACT108','2018-04-16','Special Instructions',NULL,0,1031,NULL),(201,'ACT108','2018-04-16','Special Instructions',NULL,0,1031,NULL),(202,'ACT108','2018-04-16','Special Instructions',NULL,0,1031,NULL),(203,'ACN54','2018-04-16','Special Instructions',NULL,0,1032,NULL),(204,'ACN54','2018-04-16','Special Instructions',NULL,0,1032,NULL),(205,'ACN54','2018-04-16','Special Instructions',NULL,0,1032,NULL),(206,'ACT108','2018-04-16','Special Instructions',NULL,0,1033,NULL),(207,'ACT108','2018-04-16','Special Instructions',NULL,0,1033,NULL),(208,'ACT108','2018-04-16','Special Instructions',NULL,0,1033,NULL),(209,'ACT108','2018-04-16','Special Instructions',NULL,0,1033,NULL),(210,'ACT108','2018-04-16','Special Instructions',NULL,0,1033,NULL),(211,'ACT108','2018-04-16','Special Instructions',NULL,0,1033,NULL),(212,'ACT108','2018-04-16','Special Instructions',NULL,0,1033,NULL),(213,'ACT108','2018-04-16','Special Instructions',NULL,0,1033,NULL),(214,'ACT108','2018-04-16','Special Instructions',NULL,0,1033,NULL),(215,'ACT108','2018-04-16','Special Instructions',NULL,0,1033,NULL),(216,'ACT35','2018-04-16','Special Instructions',NULL,0,1034,NULL),(217,'ABN54','2018-04-16','Special Instructions',NULL,0,1034,NULL),(218,'ACT35','2018-04-16','Special Instructions',NULL,0,1034,NULL),(219,'ABN54','2018-04-16','Special Instructions',NULL,0,1034,NULL),(220,'ACT35','2018-04-16','Special Instructions',NULL,0,1034,NULL),(221,'ABN54','2018-04-16','Special Instructions',NULL,0,1034,NULL),(222,'ACT35','2018-04-16','Special Instructions',NULL,0,1034,NULL),(223,'ACT35','2018-04-16','Special Instructions',NULL,0,1034,NULL),(224,'ABN54','2018-04-16','Special Instructions',NULL,0,1034,NULL),(225,'ACT108','2018-04-16','Special Instructions',NULL,0,1035,NULL),(226,'ACT108','2018-04-16','Special Instructions',NULL,0,1035,NULL),(227,'ACN54','2018-04-16','Special Instructions',NULL,0,1035,NULL),(228,'ACT108','2018-04-16','Special Instructions',NULL,0,1035,NULL),(229,'ACT108','2018-04-16','Special Instructions',NULL,0,1035,NULL),(230,'ACN54','2018-04-16','Special Instructions',NULL,0,1035,NULL),(231,'ACN54','2018-04-16','Special Instructions',NULL,0,1035,NULL),(232,'ACN54','2018-04-16','Special Instructions',NULL,0,1035,NULL),(233,'ACN54','2018-04-16','Special Instructions',NULL,0,1035,NULL),(234,'ACT108','2018-04-16','Just do it',NULL,0,1036,NULL),(235,'ACT35','2018-04-16','Just do it',NULL,0,1036,NULL),(236,'ACT35','2018-04-16','Just do it',NULL,0,1036,NULL),(237,'ACT35','2018-04-16','Just do it',NULL,0,1036,NULL),(238,'ACT108','2018-04-16','Just do it',NULL,0,1036,NULL),(239,'ACT108','2018-04-16','Just do it',NULL,0,1036,NULL),(240,'ACT108','2018-04-16','Just do it',NULL,0,1036,NULL),(241,'ACT108','2018-04-16','Just do it',NULL,0,1036,NULL),(242,'ACT35','2018-04-16','Just do it',NULL,0,1036,NULL),(243,'ACT108','2018-04-16','Just do it',NULL,0,1036,NULL),(244,'ACT108','2018-04-16','Just do it',NULL,0,1036,NULL),(245,'ACT35','2018-04-16','Just do it',NULL,0,1036,NULL),(246,'ACT35','2018-04-16','Just do it',NULL,0,1036,NULL),(247,'ACT108','2018-04-16','Just do it',NULL,0,1036,NULL),(248,'ACT108','2018-04-16','Just do it',NULL,0,1036,NULL),(249,'ACN54','2018-04-16','Special Instructions',NULL,0,1037,NULL),(250,'ACN54','2018-04-17','Special Instructions',NULL,0,1037,NULL),(251,'ACN54','2018-04-17','Special Instructions',NULL,0,1037,NULL),(252,'ACN54','2018-04-17','Special Instructions',NULL,0,1037,NULL),(253,'ACN54','2018-04-17','Special Instructions',NULL,0,1037,NULL),(254,'ACN54','2018-04-17','Special Instructions',NULL,0,1037,NULL),(255,'ACN54','2018-04-17','Special Instructions',NULL,0,1037,NULL);
/*!40000 ALTER TABLE `job_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_table`
--

DROP TABLE IF EXISTS `order_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_table` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `account_no` varchar(45) DEFAULT NULL,
  `total_price` float DEFAULT NULL,
  `payment_status` varchar(20) DEFAULT NULL,
  `date_submitted` date DEFAULT NULL,
  `version` bigint(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`orderID`),
  KEY `fk_Order_Customer1_idx` (`account_no`),
  CONSTRAINT `fk_Order_Customer1` FOREIGN KEY (`account_no`) REFERENCES `customer` (`account_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1038 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_table`
--

LOCK TABLES `order_table` WRITE;
/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
INSERT INTO `order_table` VALUES (1001,'ACC0001',NULL,NULL,'2018-01-14',0),(1002,'ACC0001',NULL,NULL,'2018-01-14',0),(1003,'ACC0001',NULL,NULL,'2018-01-14',0),(1015,'ACC0001',304,NULL,'2018-04-14',0),(1017,'ACC0001',304,NULL,'2018-04-14',0),(1018,'ACC0001',0,NULL,'2018-04-14',0),(1020,'ACC0001',0,NULL,'2018-04-14',0),(1021,'ACC0001',0,NULL,'2018-04-14',0),(1022,'ACC0001',0,NULL,'2018-04-14',0),(1030,'ACC0001',114,NULL,'2018-04-14',0),(1031,'ACC0001',633,NULL,'2018-04-15',0),(1032,'ACC0001',57,NULL,'2018-04-15',0),(1033,'ACC0001',960,NULL,'2018-04-15',0),(1034,'ACC0001',176,NULL,'2018-04-15',0),(1035,'ACC0001',479,NULL,'2018-04-15',0),(1036,'ACC0001',984,NULL,'2018-04-15',0),(1037,'ACC0001',133,NULL,'2018-04-15',0);
/*!40000 ALTER TABLE `order_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_detail`
--

DROP TABLE IF EXISTS `payment_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_detail` (
  `payment_detailID` int(11) NOT NULL AUTO_INCREMENT,
  `expiry_date` date DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `last4digits` varchar(4) DEFAULT NULL,
  `version` bigint(5) NOT NULL DEFAULT '0',
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`payment_detailID`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_detail`
--

LOCK TABLES `payment_detail` WRITE;
/*!40000 ALTER TABLE `payment_detail` DISABLE KEYS */;
INSERT INTO `payment_detail` VALUES (1001,'2018-01-14','cash','4444',0,NULL),(1002,'2018-01-14','cash','4444',0,NULL),(1003,'2018-01-14','cash','4444',0,NULL);
/*!40000 ALTER TABLE `payment_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `forename` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `version` bigint(5) NOT NULL DEFAULT '0',
  `logged_on` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES ('Accountant','jPasswordField1','Clark','Kent','Technician',1,0),('Clerk','Paperwork','Julie','Abbot','Shift Manager',0,0),('Copy','Too_dark','John','Hash','Technician',0,0),('dannyboy123','password','Dan','Peters','Receptionist',1,0),('DavidB','jPasswordField1','David','Beckman','Shift Manager',2,0),('Development','Lot_smell','Lee','Hong','Technician',0,0),('Finish','Fine_touch','Bruce','Wayne','Technician',0,0),('Hello','Hello_there','Tony','Stank','Receptionist',0,0),('juan22','password','juan','juan','Technician',1,0),('Manager','Get_it_done','Stewart','Pask','Office Manager',0,0),('Packer','Pack_it','Marina','Scott','Technician',0,0),('smbagwu','password','Sylvie','Mbagwu','Office Manager',39,0);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `taskID` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `expected_duration` int(11) DEFAULT NULL,
  `version` bigint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`taskID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'Use of large copy Camera','Copy Room',19,120,0),(2,'Black and white film processing','Development Area',49.5,60,0),(3,'Bag up','Packing Departments',6,30,0),(4,'Colour filme processing','Development Area',80,90,0),(5,'Colour Transparency processing','Development Area',110.3,180,0),(6,'Use of small copy camera','Copy Room',8.3,75,0),(7,'Mount Transparencies','Finishing Room',55.5,45,0);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_line`
--

DROP TABLE IF EXISTS `task_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_line` (
  `task_lineID` int(11) NOT NULL AUTO_INCREMENT,
  `taskID` int(11) NOT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `completed_by` varchar(45) DEFAULT NULL,
  `shelf` varchar(10) DEFAULT NULL,
  `version` bigint(5) NOT NULL DEFAULT '0',
  `job_lineID` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`task_lineID`),
  KEY `fk_Job_line_Task1_idx` (`taskID`),
  KEY `fk_Job_line_Staff1_idx` (`completed_by`),
  KEY `job_lineID_idx` (`job_lineID`),
  CONSTRAINT `fk_Job_line_Staff1` FOREIGN KEY (`completed_by`) REFERENCES `staff` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Job_line_Task1` FOREIGN KEY (`taskID`) REFERENCES `task` (`taskID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_lineID` FOREIGN KEY (`job_lineID`) REFERENCES `job_line` (`job_lineID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=644 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_line`
--

LOCK TABLES `task_line` WRITE;
/*!40000 ALTER TABLE `task_line` DISABLE KEYS */;
INSERT INTO `task_line` VALUES (440,3,NULL,NULL,NULL,NULL,0,190,NULL),(441,4,NULL,NULL,NULL,NULL,0,193,NULL),(442,4,NULL,NULL,NULL,NULL,0,188,NULL),(443,3,NULL,NULL,NULL,NULL,0,188,NULL),(444,1,NULL,NULL,NULL,NULL,0,192,NULL),(445,3,NULL,NULL,NULL,NULL,0,189,NULL),(446,1,NULL,NULL,NULL,NULL,0,190,NULL),(447,3,NULL,NULL,NULL,NULL,0,192,NULL),(448,3,NULL,NULL,NULL,NULL,0,191,NULL),(449,4,NULL,NULL,NULL,NULL,0,192,NULL),(450,1,NULL,NULL,NULL,NULL,0,193,NULL),(451,4,NULL,NULL,NULL,NULL,0,190,NULL),(452,1,NULL,NULL,NULL,NULL,0,188,NULL),(453,1,NULL,NULL,NULL,NULL,0,189,NULL),(454,1,NULL,NULL,NULL,NULL,0,191,NULL),(455,4,NULL,NULL,NULL,NULL,0,191,NULL),(456,4,NULL,NULL,NULL,NULL,0,189,NULL),(457,3,NULL,NULL,NULL,NULL,0,193,NULL),(458,1,NULL,NULL,NULL,NULL,0,198,NULL),(459,3,NULL,NULL,NULL,NULL,0,199,NULL),(460,1,NULL,NULL,NULL,NULL,0,199,NULL),(461,2,NULL,NULL,NULL,NULL,0,194,NULL),(462,1,NULL,NULL,NULL,NULL,0,196,NULL),(463,5,NULL,NULL,NULL,NULL,0,202,NULL),(464,1,NULL,NULL,NULL,NULL,0,200,NULL),(465,3,NULL,NULL,NULL,NULL,0,196,NULL),(466,3,NULL,NULL,NULL,NULL,0,195,NULL),(467,1,NULL,NULL,NULL,NULL,0,194,NULL),(468,3,NULL,NULL,NULL,NULL,0,198,NULL),(469,3,NULL,NULL,NULL,NULL,0,194,NULL),(470,3,NULL,NULL,NULL,NULL,0,202,NULL),(471,5,NULL,NULL,NULL,NULL,0,201,NULL),(472,5,NULL,NULL,NULL,NULL,0,195,NULL),(473,3,NULL,NULL,NULL,NULL,0,197,NULL),(474,1,NULL,NULL,NULL,NULL,0,201,NULL),(475,3,NULL,NULL,NULL,NULL,0,200,NULL),(476,5,NULL,NULL,NULL,NULL,0,200,NULL),(477,5,NULL,NULL,NULL,NULL,0,196,NULL),(478,1,NULL,NULL,NULL,NULL,0,195,NULL),(479,2,NULL,NULL,NULL,NULL,0,197,NULL),(480,3,NULL,NULL,NULL,NULL,0,201,NULL),(481,5,NULL,NULL,NULL,NULL,0,199,NULL),(482,1,NULL,NULL,NULL,NULL,0,202,NULL),(483,1,NULL,NULL,NULL,NULL,0,197,NULL),(484,2,NULL,NULL,NULL,NULL,0,198,NULL),(485,4,NULL,NULL,NULL,NULL,0,204,NULL),(486,1,NULL,NULL,NULL,NULL,0,205,NULL),(487,3,NULL,NULL,NULL,NULL,0,204,NULL),(488,4,NULL,NULL,NULL,NULL,0,203,NULL),(489,4,NULL,NULL,NULL,NULL,0,205,NULL),(490,3,NULL,NULL,NULL,NULL,0,205,NULL),(491,3,NULL,NULL,NULL,NULL,0,203,NULL),(492,1,NULL,NULL,NULL,NULL,0,203,NULL),(493,1,NULL,NULL,NULL,NULL,0,204,NULL),(494,1,NULL,NULL,NULL,NULL,0,214,NULL),(495,3,NULL,NULL,NULL,NULL,0,208,NULL),(496,3,NULL,NULL,NULL,NULL,0,215,NULL),(497,5,NULL,NULL,NULL,NULL,0,211,NULL),(498,5,NULL,NULL,NULL,NULL,0,208,NULL),(499,1,NULL,NULL,NULL,NULL,0,207,NULL),(500,5,NULL,NULL,NULL,NULL,0,206,NULL),(501,3,NULL,NULL,NULL,NULL,0,207,NULL),(502,5,NULL,NULL,NULL,NULL,0,209,NULL),(503,3,NULL,NULL,NULL,NULL,0,209,NULL),(504,1,NULL,NULL,NULL,NULL,0,210,NULL),(505,1,NULL,NULL,NULL,NULL,0,213,NULL),(506,3,NULL,NULL,NULL,NULL,0,210,NULL),(507,1,NULL,NULL,NULL,NULL,0,211,NULL),(508,1,NULL,NULL,NULL,NULL,0,212,NULL),(509,3,NULL,NULL,NULL,NULL,0,213,NULL),(510,3,NULL,NULL,NULL,NULL,0,214,NULL),(511,5,NULL,NULL,NULL,NULL,0,207,NULL),(512,1,NULL,NULL,NULL,NULL,0,208,NULL),(513,5,NULL,NULL,NULL,NULL,0,212,NULL),(514,5,NULL,NULL,NULL,NULL,0,213,NULL),(515,5,NULL,NULL,NULL,NULL,0,214,NULL),(516,1,NULL,NULL,NULL,NULL,0,209,NULL),(517,1,NULL,NULL,NULL,NULL,0,206,NULL),(518,3,NULL,NULL,NULL,NULL,0,206,NULL),(519,1,NULL,NULL,NULL,NULL,0,215,NULL),(520,5,NULL,NULL,NULL,NULL,0,215,NULL),(521,3,NULL,NULL,NULL,NULL,0,212,NULL),(522,3,NULL,NULL,NULL,NULL,0,211,NULL),(523,5,NULL,NULL,NULL,NULL,0,210,NULL),(524,1,NULL,NULL,NULL,NULL,0,224,NULL),(525,2,NULL,NULL,NULL,NULL,0,224,NULL),(526,5,NULL,NULL,NULL,NULL,0,220,NULL),(527,7,NULL,NULL,NULL,NULL,0,222,NULL),(528,5,NULL,NULL,NULL,NULL,0,222,NULL),(529,2,NULL,NULL,NULL,NULL,0,219,NULL),(530,5,NULL,NULL,NULL,NULL,0,223,NULL),(531,5,NULL,NULL,NULL,NULL,0,216,NULL),(532,6,NULL,NULL,NULL,NULL,0,223,NULL),(533,7,NULL,NULL,NULL,NULL,0,218,NULL),(534,3,NULL,NULL,NULL,NULL,0,219,NULL),(535,6,NULL,NULL,NULL,NULL,0,216,NULL),(536,6,NULL,NULL,NULL,NULL,0,218,NULL),(537,7,NULL,NULL,NULL,NULL,0,220,NULL),(538,7,NULL,NULL,NULL,NULL,0,223,NULL),(539,6,NULL,NULL,NULL,NULL,0,220,NULL),(540,1,NULL,NULL,NULL,NULL,0,217,NULL),(541,6,NULL,NULL,NULL,NULL,0,222,NULL),(542,1,NULL,NULL,NULL,NULL,0,221,NULL),(543,5,NULL,NULL,NULL,NULL,0,218,NULL),(544,3,NULL,NULL,NULL,NULL,0,221,NULL),(545,2,NULL,NULL,NULL,NULL,0,221,NULL),(546,7,NULL,NULL,NULL,NULL,0,216,NULL),(547,2,NULL,NULL,NULL,NULL,0,217,NULL),(548,3,NULL,NULL,NULL,NULL,0,217,NULL),(549,1,NULL,NULL,NULL,NULL,0,219,NULL),(550,3,NULL,NULL,NULL,NULL,0,224,NULL),(551,1,NULL,NULL,NULL,NULL,0,233,NULL),(552,3,NULL,NULL,NULL,NULL,0,226,NULL),(553,3,NULL,NULL,NULL,NULL,0,229,NULL),(554,5,NULL,NULL,NULL,NULL,0,228,NULL),(555,4,NULL,NULL,NULL,NULL,0,233,NULL),(556,1,NULL,NULL,NULL,NULL,0,225,NULL),(557,5,NULL,NULL,NULL,NULL,0,229,NULL),(558,4,NULL,NULL,NULL,NULL,0,231,NULL),(559,1,NULL,NULL,NULL,NULL,0,232,NULL),(560,4,NULL,NULL,NULL,NULL,0,230,NULL),(561,3,NULL,NULL,NULL,NULL,0,232,NULL),(562,3,NULL,NULL,NULL,NULL,0,225,NULL),(563,1,NULL,NULL,NULL,NULL,0,230,NULL),(564,3,NULL,NULL,NULL,NULL,0,233,NULL),(565,3,NULL,NULL,NULL,NULL,0,231,NULL),(566,3,NULL,NULL,NULL,NULL,0,230,NULL),(567,4,NULL,NULL,NULL,NULL,0,227,NULL),(568,1,NULL,NULL,NULL,NULL,0,227,NULL),(569,1,NULL,NULL,NULL,NULL,0,229,NULL),(570,5,NULL,NULL,NULL,NULL,0,226,NULL),(571,1,NULL,NULL,NULL,NULL,0,228,NULL),(572,3,NULL,NULL,NULL,NULL,0,228,NULL),(573,1,NULL,NULL,NULL,NULL,0,226,NULL),(574,5,NULL,NULL,NULL,NULL,0,225,NULL),(575,1,NULL,NULL,NULL,NULL,0,231,NULL),(576,3,NULL,NULL,NULL,NULL,0,227,NULL),(577,4,NULL,NULL,NULL,NULL,0,232,NULL),(578,5,NULL,NULL,NULL,NULL,0,244,NULL),(579,7,NULL,NULL,NULL,NULL,0,236,NULL),(580,3,NULL,NULL,NULL,NULL,0,241,NULL),(581,1,NULL,NULL,NULL,NULL,0,243,NULL),(582,5,NULL,NULL,NULL,NULL,0,245,NULL),(583,3,NULL,NULL,NULL,NULL,0,247,NULL),(584,1,NULL,NULL,NULL,NULL,0,234,NULL),(585,1,NULL,NULL,NULL,NULL,0,247,NULL),(586,5,NULL,NULL,NULL,NULL,0,243,NULL),(587,7,NULL,NULL,NULL,NULL,0,245,NULL),(588,5,NULL,NULL,NULL,NULL,0,237,NULL),(589,5,NULL,NULL,NULL,NULL,0,238,NULL),(590,6,NULL,NULL,NULL,NULL,0,242,NULL),(591,3,NULL,NULL,NULL,NULL,0,234,NULL),(592,1,NULL,NULL,NULL,NULL,0,248,NULL),(593,1,NULL,NULL,NULL,NULL,0,241,NULL),(594,5,NULL,NULL,NULL,NULL,0,248,NULL),(595,3,NULL,NULL,NULL,NULL,0,243,NULL),(596,1,NULL,NULL,NULL,NULL,0,239,NULL),(597,3,NULL,NULL,NULL,NULL,0,244,NULL),(598,6,NULL,NULL,NULL,NULL,0,235,NULL),(599,5,NULL,NULL,NULL,NULL,0,246,NULL),(600,3,NULL,NULL,NULL,NULL,0,239,NULL),(601,1,NULL,NULL,NULL,NULL,0,240,NULL),(602,3,NULL,NULL,NULL,NULL,0,240,NULL),(603,7,NULL,NULL,NULL,NULL,0,242,NULL),(604,7,NULL,NULL,NULL,NULL,0,235,NULL),(605,5,NULL,NULL,NULL,NULL,0,242,NULL),(606,5,NULL,NULL,NULL,NULL,0,235,NULL),(607,3,NULL,NULL,NULL,NULL,0,248,NULL),(608,1,NULL,NULL,NULL,NULL,0,238,NULL),(609,3,NULL,NULL,NULL,NULL,0,238,NULL),(610,5,NULL,NULL,NULL,NULL,0,247,NULL),(611,5,NULL,NULL,NULL,NULL,0,241,NULL),(612,6,NULL,NULL,NULL,NULL,0,246,NULL),(613,5,NULL,NULL,NULL,NULL,0,234,NULL),(614,5,NULL,NULL,NULL,NULL,0,239,NULL),(615,6,NULL,NULL,NULL,NULL,0,236,NULL),(616,6,NULL,NULL,NULL,NULL,0,237,NULL),(617,1,NULL,NULL,NULL,NULL,0,244,NULL),(618,5,NULL,NULL,NULL,NULL,0,236,NULL),(619,7,NULL,NULL,NULL,NULL,0,246,NULL),(620,7,NULL,NULL,NULL,NULL,0,237,NULL),(621,5,NULL,NULL,NULL,NULL,0,240,NULL),(622,6,NULL,NULL,NULL,NULL,0,245,NULL),(623,4,NULL,NULL,NULL,NULL,0,250,NULL),(624,1,NULL,NULL,NULL,NULL,0,253,NULL),(625,1,NULL,NULL,NULL,NULL,0,249,NULL),(626,3,NULL,NULL,NULL,NULL,0,255,NULL),(627,4,NULL,NULL,NULL,NULL,0,253,NULL),(628,3,NULL,NULL,NULL,NULL,0,249,NULL),(629,1,NULL,NULL,NULL,NULL,0,255,NULL),(630,4,NULL,NULL,NULL,NULL,0,251,NULL),(631,3,NULL,NULL,NULL,NULL,0,254,NULL),(632,1,NULL,NULL,NULL,NULL,0,251,NULL),(633,3,NULL,NULL,NULL,NULL,0,251,NULL),(634,3,NULL,NULL,NULL,NULL,0,252,NULL),(635,4,NULL,NULL,NULL,NULL,0,249,NULL),(636,4,NULL,NULL,NULL,NULL,0,252,NULL),(637,1,NULL,NULL,NULL,NULL,0,252,NULL),(638,4,NULL,NULL,NULL,NULL,0,255,NULL),(639,1,NULL,NULL,NULL,NULL,0,254,NULL),(640,3,NULL,NULL,NULL,NULL,0,253,NULL),(641,1,NULL,NULL,NULL,NULL,0,250,NULL),(642,4,NULL,NULL,NULL,NULL,0,254,NULL),(643,3,NULL,NULL,NULL,NULL,0,250,NULL);
/*!40000 ALTER TABLE `task_line` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-16 17:54:06
