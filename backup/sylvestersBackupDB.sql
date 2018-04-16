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
  `been_seen` tinyint(4) DEFAULT '0',
  `joblineID` int(11) NOT NULL,
  PRIMARY KEY (`alertID`),
  KEY `orderIDidx_idx` (`orderID`),
  KEY `accountNoidx_idx` (`account_no`),
  KEY `joblineIDidx_idx` (`joblineID`),
  CONSTRAINT `accountNoidx` FOREIGN KEY (`account_no`) REFERENCES `customer` (`account_no`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `joblinidx` FOREIGN KEY (`joblineID`) REFERENCES `job_line` (`job_lineID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderIDidx` FOREIGN KEY (`orderID`) REFERENCES `order_table` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert`
--

LOCK TABLES `alert` WRITE;
/*!40000 ALTER TABLE `alert` DISABLE KEYS */;
INSERT INTO `alert` VALUES (33,1030,'New job alert. Job code: ACN54 Account Number: ACC0001 Deadline : 2018-09-09','Office Manager and Shift Manager','ACC0001',0,190),(34,1030,'New job alert. Job code: ACN54 Account Number: ACC0001 Deadline : 2018-09-09','Office Manager and Shift Manager','ACC0001',0,192),(35,1030,'New job alert. Job code: ACN54 Account Number: ACC0001 Deadline : 2018-09-09','Office Manager and Shift Manager','ACC0001',0,188),(36,1030,'New job alert. Job code: ACN54 Account Number: ACC0001 Deadline : 2018-09-09','Office Manager and Shift Manager','ACC0001',0,191),(37,1030,'New job alert. Job code: ACN54 Account Number: ACC0001 Deadline : 2018-09-09','Office Manager and Shift Manager','ACC0001',0,193),(38,1030,'New job alert. Job code: ACN54 Account Number: ACC0001 Deadline : 2018-09-09','Office Manager and Shift Manager','ACC0001',0,189);
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
  `version` bigint(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`account_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('ACC0001','David','Rhind','City, University of London (City)',NULL,'Northampton Square','','London','','EC1V 0HB','0207 040 8000','David.Rhind@city.ac.uk',1,'Fixed',0),('ACC0002','Alex','Wright','InfoPharma Ltd',NULL,'25 Bond Street','','London','','WC1V 8LS','0207 321 8001','Alex.Wright@infopharma.com',1,'Flexible',0),('ACC0003','Sarah','Brocklehurst','Hello Magazine',NULL,'12 Bond Street','','London','','WC1V 8NS','0203 456 7809','Sarah.Brocklehurst@hello.com',1,'Flexible',0),('ACC0004','Eva','Bauyer','Eva Bauyer',NULL,'1 Liverpool Street','','London','','EC2V 8NS','0208 555 8989','eva.bauyer@gmail.com',1,'Fixed',0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dicount_plan`
--

DROP TABLE IF EXISTS `dicount_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dicount_plan` (
  `dicount_planID` int(11) NOT NULL AUTO_INCREMENT,
  `taskID` int(11) NOT NULL,
  `rate` float DEFAULT '1',
  `account_no` varchar(45) NOT NULL,
  `is_flexible` tinyint(4) DEFAULT '0',
  `variable_rate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dicount_planID`),
  KEY `account_noidx_idx` (`account_no`),
  KEY `taskIDidx_idx` (`taskID`),
  CONSTRAINT `account_noidx` FOREIGN KEY (`account_no`) REFERENCES `customer` (`account_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `taskIDidx` FOREIGN KEY (`taskID`) REFERENCES `task` (`taskID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dicount_plan`
--

LOCK TABLES `dicount_plan` WRITE;
/*!40000 ALTER TABLE `dicount_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `dicount_plan` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_line`
--

LOCK TABLES `job_line` WRITE;
/*!40000 ALTER TABLE `job_line` DISABLE KEYS */;
INSERT INTO `job_line` VALUES (188,'ACN54','2018-09-09','Special Instructions',NULL,0,1030,NULL),(189,'ACN54','2018-09-09','Special Instructions',NULL,0,1030,NULL),(190,'ACN54','2018-09-09','Special Instructions',NULL,0,1030,NULL),(191,'ACN54','2018-09-09','Special Instructions',NULL,0,1030,NULL),(192,'ACN54','2018-09-09','Special Instructions',NULL,0,1030,NULL),(193,'ACN54','2018-09-09','Special Instructions',NULL,0,1030,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=1031 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_table`
--

LOCK TABLES `order_table` WRITE;
/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
INSERT INTO `order_table` VALUES (1001,'ACC0001',NULL,NULL,'2018-01-14',0),(1002,'ACC0001',NULL,NULL,'2018-01-14',0),(1003,'ACC0001',NULL,NULL,'2018-01-14',0),(1015,'ACC0001',304,NULL,'2018-04-14',0),(1017,'ACC0001',304,NULL,'2018-04-14',0),(1018,'ACC0001',0,NULL,'2018-04-14',0),(1020,'ACC0001',0,NULL,'2018-04-14',0),(1021,'ACC0001',0,NULL,'2018-04-14',0),(1022,'ACC0001',0,NULL,'2018-04-14',0),(1030,'ACC0001',114,NULL,'2018-04-14',0);
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
  `orderID` int(11) NOT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`payment_detailID`),
  KEY `orderid_idx` (`orderID`),
  CONSTRAINT `orderID_idx` FOREIGN KEY (`orderID`) REFERENCES `order_table` (`orderID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_detail`
--

LOCK TABLES `payment_detail` WRITE;
/*!40000 ALTER TABLE `payment_detail` DISABLE KEYS */;
INSERT INTO `payment_detail` VALUES (1001,'2018-01-14','cash','4444',0,1001,NULL),(1002,'2018-01-14','cash','4444',0,1001,NULL),(1003,'2018-01-14','cash','4444',0,1001,NULL);
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
INSERT INTO `staff` VALUES ('Accountant','jPasswordField1','Clark','Kent','Technician',1,0),('Clerk','Paperwork','Julie','Abbot','Shift Manager',0,0),('Copy','Too_dark','John','Hash','Technician',0,0),('dannyboy123','password','Dan','Peters','Receptionist',1,NULL),('DavidB','jPasswordField1','David','Beckman','Shift Manager',2,NULL),('Development','Lot_smell','Lee','Hong','Technician',0,0),('Finish','Fine_touch','Bruce','Wayne','Technician',0,0),('Hello','Hello_there','Tony','Stank','Receptionist',0,0),('juan22','password','juan','juan','Technician',1,NULL),('Manager','Get_it_done','Stewart','Pask','Office Manager',0,0),('Packer','Pack_it','Marina','Scott','Technician',0,0),('smbagwu','password','Sylvie','Mbagwu','Office Manager',3,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=458 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_line`
--

LOCK TABLES `task_line` WRITE;
/*!40000 ALTER TABLE `task_line` DISABLE KEYS */;
INSERT INTO `task_line` VALUES (440,3,NULL,NULL,NULL,NULL,0,190,NULL),(441,4,NULL,NULL,NULL,NULL,0,193,NULL),(442,4,NULL,NULL,NULL,NULL,0,188,NULL),(443,3,NULL,NULL,NULL,NULL,0,188,NULL),(444,1,NULL,NULL,NULL,NULL,0,192,NULL),(445,3,NULL,NULL,NULL,NULL,0,189,NULL),(446,1,NULL,NULL,NULL,NULL,0,190,NULL),(447,3,NULL,NULL,NULL,NULL,0,192,NULL),(448,3,NULL,NULL,NULL,NULL,0,191,NULL),(449,4,NULL,NULL,NULL,NULL,0,192,NULL),(450,1,NULL,NULL,NULL,NULL,0,193,NULL),(451,4,NULL,NULL,NULL,NULL,0,190,NULL),(452,1,NULL,NULL,NULL,NULL,0,188,NULL),(453,1,NULL,NULL,NULL,NULL,0,189,NULL),(454,1,NULL,NULL,NULL,NULL,0,191,NULL),(455,4,NULL,NULL,NULL,NULL,0,191,NULL),(456,4,NULL,NULL,NULL,NULL,0,189,NULL),(457,3,NULL,NULL,NULL,NULL,0,193,NULL);
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

-- Dump completed on 2018-04-14 12:47:37
