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
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert`
--

LOCK TABLES `alert` WRITE;
/*!40000 ALTER TABLE `alert` DISABLE KEYS */;
INSERT INTO `alert` VALUES (72,1039,'New job alert. Job code: ACN54 Account Number: ACC0001 Deadline : 2018-07-13','Shift Manager','ACC0001',1,262,4),(73,1039,'New job alert. Job code: ACN54 Account Number: ACC0001 Deadline : 2018-07-13','Shift Manager','ACC0001',1,263,3),(74,1039,'New job alert. Job code: ACN54 Account Number: ACC0001 Deadline : 2018-07-13','Shift Manager','ACC0001',1,261,2),(75,1040,'New job alert. Job code: ACT35 Account Number: ACC0001 Deadline : 2018-06-13','Shift Manager','ACC0001',1,266,14),(76,1040,'New job alert. Job code: ACT35 Account Number: ACC0001 Deadline : 2018-06-13','Shift Manager','ACC0001',1,264,13),(77,1040,'New job alert. Job code: ACT35 Account Number: ACC0001 Deadline : 2018-06-13','Shift Manager','ACC0001',1,265,12),(78,1040,'New job alert. Job code: ACT35 Account Number: ACC0001 Deadline : 2018-06-13','Shift Manager','ACC0001',1,267,11),(79,1041,'New job alert. Job code: ACT108 Account Number: ACC0001 Deadline : 2018-06-06','Shift Manager','ACC0001',1,272,10),(80,1041,'New job alert. Job code: ACT108 Account Number: ACC0001 Deadline : 2018-06-06','Shift Manager','ACC0001',1,273,9),(81,1041,'New job alert. Job code: ACT108 Account Number: ACC0001 Deadline : 2018-06-06','Shift Manager','ACC0001',1,270,8),(82,1041,'New job alert. Job code: ACT108 Account Number: ACC0001 Deadline : 2018-06-06','Shift Manager','ACC0001',1,271,7),(83,1041,'New job alert. Job code: ACT108 Account Number: ACC0001 Deadline : 2018-06-06','Shift Manager','ACC0001',1,269,6),(84,1041,'New job alert. Job code: ACT108 Account Number: ACC0001 Deadline : 2018-06-06','Shift Manager','ACC0001',1,268,5),(85,1042,'New job alert. Job code: B108 Account Number: ACC0001 Deadline : 2018-04-21','Shift Manager','ACC0001',1,274,4),(86,1043,'New job alert. Job code: ABN54 Account Number: ACC0001 Deadline : 2018-04-20','Shift Manager','ACC0001',1,275,3),(87,1043,'Job: ABN54 for Account Number: ACC0001 is within 24 hours of its deadline : Fri Apr 20 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,275,2),(88,1043,'Job: ABN54 for Account Number: ACC0001 is within 24 hours of its deadline : Fri Apr 20 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,275,2),(89,1043,'Job: ABN54 for Account Number: ACC0001 is within 24 hours of its deadline : Fri Apr 20 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,275,2),(90,1043,'Job: ABN54 for Account Number: ACC0001 is within 24 hours of its deadline : Fri Apr 20 00:00:00 BST 2018','Office Manager and Shift Manager','ACC0001',1,275,2);
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
  `flexible_rate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`discount_planID`),
  KEY `account_noidx_idx` (`account_no`),
  KEY `taskIDidx_idx` (`taskID`),
  CONSTRAINT `account_noidx` FOREIGN KEY (`account_no`) REFERENCES `customer` (`account_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `taskIDidx` FOREIGN KEY (`taskID`) REFERENCES `task` (`taskID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount_plan`
--

LOCK TABLES `discount_plan` WRITE;
/*!40000 ALTER TABLE `discount_plan` DISABLE KEYS */;
INSERT INTO `discount_plan` VALUES (1,NULL,NULL,'ACC0001','[0,2000 - 0.94]');
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
INSERT INTO `job` VALUES ('ABN54','5 x 4 B& W copy negatives',19,0),('ACN54','5 x 4 Colour copy negatives',19,0),('ACT108','10 x 8 Colour copy transparency',96,0),('ACT35','35 mm Colour copy transparency',20,0),('B108','10 x 8 processing ',8.3,0),('C108','10 x 8 C41 processing',8.3,0);
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
  `job_deadline` datetime DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=276 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_line`
--

LOCK TABLES `job_line` WRITE;
/*!40000 ALTER TABLE `job_line` DISABLE KEYS */;
INSERT INTO `job_line` VALUES (261,'ACN54','2018-07-13 00:00:00','Special Instructions',NULL,0,1039,NULL),(262,'ACN54','2018-07-13 00:00:00','Special Instructions',NULL,0,1039,NULL),(263,'ACN54','2018-07-13 00:00:00','Special Instructions',NULL,0,1039,NULL),(264,'ACT35','2018-06-13 00:00:00','Special Instructions',NULL,1,1040,NULL),(265,'ACT35','2018-06-13 00:00:00','Special Instructions',NULL,1,1040,NULL),(266,'ACT35','2018-06-13 00:00:00','Special Instructions',NULL,1,1040,NULL),(267,'ACT35','2018-06-13 00:00:00','Special Instructions',NULL,1,1040,NULL),(268,'ACT108','2018-06-06 00:00:00','Special Instructions',NULL,1,1041,NULL),(269,'ACT108','2018-06-06 00:00:00','Special Instructions',NULL,1,1041,NULL),(270,'ACT108','2018-06-06 00:00:00','Special Instructions',NULL,1,1041,NULL),(271,'ACT108','2018-06-06 00:00:00','Special Instructions',NULL,1,1041,NULL),(272,'ACT108','2018-06-06 00:00:00','Special Instructions',NULL,1,1041,NULL),(273,'ACT108','2018-06-06 00:00:00','Special Instructions',NULL,1,1041,NULL),(274,'B108','2018-04-21 00:00:00','Special Instructions',NULL,1,1042,NULL),(275,'ABN54','2018-04-20 00:00:00','Special Instructions',NULL,1,1043,NULL);
/*!40000 ALTER TABLE `job_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_task_bridge`
--

DROP TABLE IF EXISTS `job_task_bridge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_task_bridge` (
  `bridgeID` bigint(20) NOT NULL AUTO_INCREMENT,
  `jobCode` varchar(45) NOT NULL,
  `taskID` int(11) NOT NULL,
  `version` bigint(5) NOT NULL DEFAULT '0',
  `taskSequence` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bridgeID`),
  KEY `taskidx_idx` (`taskID`),
  KEY `cdx_idx` (`jobCode`),
  CONSTRAINT `cdx` FOREIGN KEY (`jobCode`) REFERENCES `job` (`code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `taskidx` FOREIGN KEY (`taskID`) REFERENCES `task` (`taskID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_task_bridge`
--

LOCK TABLES `job_task_bridge` WRITE;
/*!40000 ALTER TABLE `job_task_bridge` DISABLE KEYS */;
INSERT INTO `job_task_bridge` VALUES (1,'ABN54',1,0,1),(2,'ABN54',2,0,2),(3,'ABN54',3,0,3),(4,'ACN54',1,0,1),(5,'ACN54',4,0,2),(6,'ACN54',3,0,3),(7,'ACT108',1,0,1),(8,'ACT108',5,0,2),(9,'ACT108',3,0,3),(10,'ACT35',6,0,1),(11,'ACT35',5,0,2),(12,'ACT35',7,0,3),(13,'B108',2,0,1),(14,'B108',3,0,2),(15,'C108',4,0,1),(16,'C108',3,0,2);
/*!40000 ALTER TABLE `job_task_bridge` ENABLE KEYS */;
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
  `date_submitted` datetime DEFAULT NULL,
  `version` bigint(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`orderID`),
  KEY `fk_Order_Customer1_idx` (`account_no`),
  CONSTRAINT `fk_Order_Customer1` FOREIGN KEY (`account_no`) REFERENCES `customer` (`account_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1044 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_table`
--

LOCK TABLES `order_table` WRITE;
/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
INSERT INTO `order_table` VALUES (1039,'ACC0001',57,NULL,'2018-04-17 00:00:00',0),(1040,'ACC0001',80,NULL,'2018-04-18 00:00:00',0),(1041,'ACC0001',576,NULL,'2018-04-19 00:00:00',0),(1042,'ACC0001',8.3,NULL,'2018-04-19 00:00:00',0),(1043,'ACC0001',19,NULL,'2018-04-19 00:00:00',0);
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
  `role` longtext NOT NULL,
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
INSERT INTO `staff` VALUES ('Accountant','jPasswordField1','Clark','Kent','Technician',1,0),('Clerk','Paperwork','Julie','Abbot','Shift Manager',0,0),('Copy','password','John','Hash','Technician -Copy',15,1),('dannyboy123','password','Dan','Peters','Receptionist',1,0),('DavidB','jPasswordField1','David','Beckman','Shift Manager',2,0),('Development','Lot_smell','Lee','Hong','Technician -Development',0,0),('Finish','password','Bruce','Wayne','Technician -Finish',1,1),('Hannah','password','Hannah','Hannah','Technician',2,NULL),('Hello','Hello_there','Tony','Stank','Receptionist',0,0),('juan22','password','juan','juan','Technician - Packing',0,0),('Manager','Get_it_done','Stewart','Pask','Office Manager',0,0),('Packer','Pack_it','Marina','Scott','Technician -Packing',0,0),('smbagwu','password','Sylvie','Mbagwu','Office Manager',50,1);
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
  `comments` longtext,
  PRIMARY KEY (`task_lineID`),
  KEY `fk_Job_line_Task1_idx` (`taskID`),
  KEY `fk_Job_line_Staff1_idx` (`completed_by`),
  KEY `job_lineID_idx` (`job_lineID`),
  CONSTRAINT `fk_Job_line_Staff1` FOREIGN KEY (`completed_by`) REFERENCES `staff` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Job_line_Task1` FOREIGN KEY (`taskID`) REFERENCES `task` (`taskID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `job_lineID` FOREIGN KEY (`job_lineID`) REFERENCES `job_line` (`job_lineID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=703 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_line`
--

LOCK TABLES `task_line` WRITE;
/*!40000 ALTER TABLE `task_line` DISABLE KEYS */;
INSERT INTO `task_line` VALUES (660,1,'2018-04-18 04:54:30','2018-04-18 22:47:35',NULL,NULL,1,261,NULL,'ss'),(661,3,'2018-04-18 00:14:43','2018-04-18 22:47:35','Copy',NULL,1,263,NULL,NULL),(662,3,NULL,NULL,NULL,NULL,0,262,NULL,NULL),(663,3,'2018-04-18 22:47:35',NULL,'Copy',NULL,1,261,NULL,''),(664,4,NULL,NULL,NULL,NULL,0,263,NULL,NULL),(665,4,NULL,NULL,NULL,NULL,0,262,NULL,NULL),(666,1,NULL,NULL,NULL,NULL,0,262,NULL,NULL),(667,1,NULL,NULL,NULL,NULL,0,263,NULL,NULL),(668,7,NULL,NULL,NULL,NULL,1,264,55.5,NULL),(669,5,NULL,NULL,NULL,NULL,1,265,110.3,NULL),(670,6,NULL,NULL,NULL,NULL,1,267,8.3,NULL),(671,7,NULL,NULL,NULL,NULL,1,267,55.5,NULL),(672,6,NULL,NULL,NULL,NULL,1,265,8.3,NULL),(673,5,NULL,NULL,NULL,NULL,1,267,110.3,NULL),(674,5,NULL,NULL,NULL,NULL,1,266,110.3,NULL),(675,6,NULL,NULL,NULL,NULL,1,266,8.3,NULL),(676,6,NULL,NULL,NULL,NULL,1,264,8.3,NULL),(677,7,NULL,NULL,NULL,NULL,1,266,55.5,NULL),(678,7,NULL,NULL,NULL,NULL,1,265,55.5,NULL),(679,5,NULL,NULL,NULL,NULL,1,264,110.3,NULL),(680,1,NULL,NULL,NULL,NULL,1,271,19,NULL),(681,3,NULL,NULL,NULL,NULL,1,273,6,NULL),(682,5,NULL,NULL,NULL,NULL,1,268,110.3,NULL),(683,5,NULL,NULL,NULL,NULL,1,269,110.3,NULL),(684,5,NULL,NULL,NULL,NULL,1,272,110.3,NULL),(685,5,NULL,NULL,NULL,NULL,1,270,110.3,NULL),(686,1,NULL,NULL,NULL,NULL,1,273,19,NULL),(687,1,NULL,NULL,NULL,NULL,1,268,19,NULL),(688,5,NULL,NULL,NULL,NULL,1,273,110.3,NULL),(689,1,NULL,NULL,NULL,NULL,1,272,19,NULL),(690,5,NULL,NULL,NULL,NULL,1,271,110.3,NULL),(691,3,NULL,NULL,NULL,NULL,1,269,6,NULL),(692,3,NULL,NULL,NULL,NULL,1,270,6,NULL),(693,3,NULL,NULL,NULL,NULL,1,271,6,NULL),(694,3,NULL,NULL,NULL,NULL,1,268,6,NULL),(695,1,NULL,NULL,NULL,NULL,1,269,19,NULL),(696,1,NULL,NULL,NULL,NULL,1,270,19,NULL),(697,3,NULL,NULL,NULL,NULL,1,272,6,NULL),(698,2,NULL,NULL,NULL,NULL,1,274,49.5,NULL),(699,3,NULL,NULL,NULL,NULL,1,274,6,NULL),(700,3,NULL,NULL,NULL,NULL,1,275,6,NULL),(701,2,NULL,NULL,NULL,NULL,1,275,49.5,NULL),(702,1,'2018-04-19 13:53:22',NULL,'Copy',NULL,2,275,19,'');
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

-- Dump completed on 2018-04-19 14:15:18
