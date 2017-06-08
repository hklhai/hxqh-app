-- MySQL dump 10.13  Distrib 5.6.12, for Win64 (x86_64)
--
-- Host: localhost    Database: hk
-- ------------------------------------------------------
-- Server version	5.6.12

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
-- Table structure for table `lab_model`
--

DROP TABLE IF EXISTS `lab_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lab_model` (
  `modelid` int(6) NOT NULL AUTO_INCREMENT,
  `modelname` varchar(50) DEFAULT NULL,
  `modeldesc` varchar(200) DEFAULT NULL,
  `parentid` int(6) DEFAULT NULL,
  `modelstatus` int(1) DEFAULT NULL,
  `sortnum` int(10) DEFAULT NULL,
  PRIMARY KEY (`modelid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_model`
--

LOCK TABLES `lab_model` WRITE;
/*!40000 ALTER TABLE `lab_model` DISABLE KEYS */;
INSERT INTO `lab_model` VALUES (1,'系统管理','系统管理',NULL,1,0),(2,'用户管理','用户管理',1,1,0),(3,'角色管理','角色管理',1,1,0),(4,'网站管理','网站管理',NULL,1,0),(5,'主页','主页',4,1,0),(6,'最新动态','最新动态',4,1,0),(7,'关于我们','关于我们',4,1,0);
/*!40000 ALTER TABLE `lab_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_role`
--

DROP TABLE IF EXISTS `lab_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lab_role` (
  `roleid` int(16) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(200) DEFAULT NULL,
  `roledesc` varchar(1000) DEFAULT NULL,
  `rolestatus` int(1) DEFAULT NULL,
  `sortnum` int(6) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_role`
--

LOCK TABLES `lab_role` WRITE;
/*!40000 ALTER TABLE `lab_role` DISABLE KEYS */;
INSERT INTO `lab_role` VALUES (1,'网站管理','网站管理',1,1),(2,'系统管理','系统管理',1,2);
/*!40000 ALTER TABLE `lab_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_rolemodel`
--

DROP TABLE IF EXISTS `lab_rolemodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lab_rolemodel` (
  `rolemodelid` int(6) NOT NULL AUTO_INCREMENT,
  `roleid` int(6) NOT NULL,
  `modelid` int(6) DEFAULT NULL,
  PRIMARY KEY (`rolemodelid`),
  KEY `FK_ROLE` (`roleid`),
  KEY `FK_MODEL` (`modelid`),
  CONSTRAINT `FK_MODEL` FOREIGN KEY (`modelid`) REFERENCES `lab_model` (`modelid`),
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`roleid`) REFERENCES `lab_role` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_rolemodel`
--

LOCK TABLES `lab_rolemodel` WRITE;
/*!40000 ALTER TABLE `lab_rolemodel` DISABLE KEYS */;
INSERT INTO `lab_rolemodel` VALUES (1,1,1),(2,1,4);
/*!40000 ALTER TABLE `lab_rolemodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pub_map`
--

DROP TABLE IF EXISTS `pub_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pub_map` (
  `pubid` int(6) NOT NULL AUTO_INCREMENT,
  `pubname` varchar(200) DEFAULT NULL,
  `Location` varchar(25) DEFAULT NULL,
  `pubtype` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pubid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pub_map`
--

LOCK TABLES `pub_map` WRITE;
/*!40000 ALTER TABLE `pub_map` DISABLE KEYS */;
INSERT INTO `pub_map` VALUES (1,'中国化学工业出版社','北京','出版社-示范'),(2,'上海新华传媒连锁有限公司','上海','发行-示范');
/*!40000 ALTER TABLE `pub_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'admin','admin','F'),(2,'zs','123','M'),(3,'ls','456','F');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_map`
--

DROP TABLE IF EXISTS `v_map`;
/*!50001 DROP VIEW IF EXISTS `v_map`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_map` (
  `Location` tinyint NOT NULL,
  `pubtype` tinyint NOT NULL,
  `counter` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_map`
--

/*!50001 DROP TABLE IF EXISTS `v_map`*/;
/*!50001 DROP VIEW IF EXISTS `v_map`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_map` AS select `m`.`Location` AS `Location`,`m`.`pubtype` AS `pubtype`,count(1) AS `counter` from `pub_map` `m` group by `m`.`Location`,`m`.`pubtype` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-08 17:22:45
