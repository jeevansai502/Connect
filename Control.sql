-- MySQL dump 10.13  Distrib 5.7.16, for Linux (x86_64)
--
-- Host: localhost    Database: Control
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.10.1

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
-- Table structure for table `mac_ip`
--

DROP TABLE IF EXISTS `mac_ip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mac_ip` (
  `mac` varchar(23) NOT NULL,
  `ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`mac`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mac_ip`
--

LOCK TABLES `mac_ip` WRITE;
/*!40000 ALTER TABLE `mac_ip` DISABLE KEYS */;
INSERT INTO `mac_ip` VALUES ('116:105:105:45:48:49','172.16.15.249');
/*!40000 ALTER TABLE `mac_ip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissions` (
  `email` varchar(320) NOT NULL,
  `privilege` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
INSERT INTO `permissions` VALUES ('a@a.aa','admin'),('admin@gmail.com','admin'),('user@gmail.com','student');
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_mac`
--

DROP TABLE IF EXISTS `room_mac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_mac` (
  `room` int(11) NOT NULL,
  `mac` varchar(23) DEFAULT NULL,
  PRIMARY KEY (`room`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_mac`
--

LOCK TABLES `room_mac` WRITE;
/*!40000 ALTER TABLE `room_mac` DISABLE KEYS */;
INSERT INTO `room_mac` VALUES (1,'116:105:105:45:48:49'),(1020,'116:105:105:45:48:49'),(1021,'116:105:105:45:48:49');
/*!40000 ALTER TABLE `room_mac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `session` (
  `email` varchar(255) DEFAULT NULL,
  `session_id` varchar(255) DEFAULT NULL,
  `time` decimal(50,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES ('a@a.aa','6A01EC4E22BE88379F7B79D9A41E09F3',1478968829949),('a@a.aa','6A01EC4E22BE88379F7B79D9A41E09F3',1478968829949),('a@a.aa','71756C3461B1D965C5E87EF84C2F3CC0',1479913705874),('a@a.aa','6DB5755AF6F77231A4A94FCD34E5D6C4',1479913824450),('a@a.aa','23CEC03773DEEBB45F8ED378AA38B5B9',1479913936620),('a@a.aa','F01271AEFA0511755DD95256FDFE594D',1480171389458),('a@a.aa','B4926F270C02D1A5DB240CED1E4E7889',1480174254876),('a@a.aa','B0024F32C070F89817D16839C0DCECCF',1480182468737),('a@a.aa','B0024F32C070F89817D16839C0DCECCF',1480182468737),('a@a.aa','B0024F32C070F89817D16839C0DCECCF',1480182468737),('a@a.aa','B0024F32C070F89817D16839C0DCECCF',1480182468737),('a@a.aa','B66FCD443240F7F84E43AC01EF7C308C',1480183006482),('a@a.aa','B17C153523FC6871C73F8AEA1DF382F9',1480183135251),('a@a.aa','D7E7B46E758D522DB112F541B18E4E13',1480270995285),('a@a.aa','B637582EC62AA236AD588AE4CC8B77BF',1480273627299),('a@a.aa','B637582EC62AA236AD588AE4CC8B77BF',1480273627299),('a@a.aa','E56CA2B2255FF0D06361C466E4A017BE',1480278743757),('a@a.aa','52FD4DB4203F7241BD4C3FDEAD8D29B7',1480314086866),('a@a.aa','FDDE74EF416C61D8AAD72D9573A45B81',1480318399183),('a@a.aa','2FA3A864924957178B848F714477CC27',1480324068305),('a@a.aa','2FA3A864924957178B848F714477CC27',1480324068305),('a@a.aa','D7D730FF47CD3E23BE000074BEB130A2',1480328730819),('a@a.aa','D7D730FF47CD3E23BE000074BEB130A2',1480328730819),('a@a.aa','995066B1C5BF6F0EB94757A8DFB511DA',1480336793854),('a@a.aa','850B3D22E1A0BCF1F826BA120B9BD9C1',1480336980874),('a@a.aa','37CFF8BFEB2A2F2C322B661D5F459BFA',1480362198272),('a@a.aa','F7432E5B1DC6F1F827C6CB5566ECEE7F',1480391752934),('a@a.aa','12AB47EA3A540FBF82B4F0793299606C',1480417070032),('a@a.aa','743772FB9EB00348535EAE950ED1AD9F',1480417136990),('a@a.aa','8E731BBEA2DDBF6DBD8B02AE96BD345E',1480422398130),('a@a.aa','8101CFB1CDEE98F61CB04769D30B4474',1480428047896),('ravitejarentapala007@gmail.com','CE525F872119BF398C84A6D3C97C7906',1480503675989),('a@a.aa','7DCA117487388B347C85370754F1E7F5',1480519215018),('a@a.aa','5C85A7C390639620DDC1D13D24FD9BB4',1480520491299),('a@a.aa','CF6E661EEC30D84FD81FA16CE7EED8CE',1480525302961),('a@a.aa','566ADF1AFB7CA03291AB20F7C7CEF845',1480533007836),('a@a.aa','DFFDE731B31F09355AEDD9291E0E12B0',1480533134289),('a@a.aa','DFFDE731B31F09355AEDD9291E0E12B0',1480533134289),('a@a.aa','DFFDE731B31F09355AEDD9291E0E12B0',1480533134289),('a@a.aa','DFFDE731B31F09355AEDD9291E0E12B0',1480533134289),('admin@gmail.com','C06C71C19FAD87D79FEB0BD8329F5C22',1480536979044),('admin@gmail.com','3451542C0F23786E306D7B977836CEC3',1480539905842),('admin@gmail.com','F98F7452F209F181398DC255A841B1D3',1480542387938),('admin@gmail.com','98D7CAB26BAF4965F083AD006F76213B',1480543002205),('admin@gmail.com','673A9B2D28743478FEBEC9318264D793',1480572682420),('admin@gmail.com','D0E0744CB1C3F784BDE85A97632CAC09',1480574464765),('user@gmail.com','B59AB6D1FF7B162FDD63713C2F8C8B3F',1480577507351),('user@gmail.com','B59AB6D1FF7B162FDD63713C2F8C8B3F',1480577507351);
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `mac` varchar(23) NOT NULL,
  `bulb` int(11) DEFAULT NULL,
  `fan` int(11) DEFAULT NULL,
  PRIMARY KEY (`mac`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES ('116:105:105:45:48:49',0,1);
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_details` (
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `room` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES ('admin','admin@gmail.com','9548721365','pass',1),('user','user@gmail.com','9467621195','pass',1);
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-01 19:01:37