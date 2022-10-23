-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: tpizza
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_client` int DEFAULT NULL,
  `id_staff` int DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `total_price` int NOT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `name_order` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `id_discount` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_client_idx` (`id_client`),
  KEY `fk_staff_idx` (`id_staff`),
  KEY `fk_discount_idx` (`id_discount`),
  CONSTRAINT `fk_client` FOREIGN KEY (`id_client`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_discount` FOREIGN KEY (`id_discount`) REFERENCES `discount` (`id`),
  CONSTRAINT `fk_staff` FOREIGN KEY (`id_staff`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (7,2,NULL,'2022-10-11 13:05:26',300,'PENDING',NULL,NULL,NULL,NULL,NULL),(9,4,NULL,'2022-10-14 15:26:02',300,'PENDING',NULL,NULL,NULL,NULL,NULL),(10,4,NULL,'2022-10-13 16:24:05',300,'PENDING','ádsad','1231','312321','3123',NULL),(11,4,NULL,'2022-10-11 16:38:25',300,'SHIPPING','ẻwer','12312312','53453','56765',NULL),(12,4,NULL,'2022-10-10 16:40:43',300,'PENDING','eqweqw','123243','2423','12312',NULL),(14,1,3,'2022-10-11 16:50:20',300,'DELIVERED','ểtrtre','12313','123123','213',NULL),(15,4,NULL,'2022-10-14 17:21:25',300,'PENDING','qưewqe','123123','21321','234',NULL),(16,4,NULL,'2022-10-12 17:27:31',300,'PENDING','sf','123213','12321','1231',NULL),(17,4,NULL,'2022-10-11 17:30:15',300,'PENDING','sfđsfds','12312321','132121','423432',NULL),(18,1,NULL,'2022-10-16 17:32:40',300,'PENDING','qewqeq','213123','12321','12',NULL),(20,1,NULL,'2022-10-13 19:52:46',300,'PENDING','sdfsdfa','12312321','312321','321321',NULL),(22,1,NULL,'2022-09-11 20:19:51',300,'PENDING','sdfgsdf','123213','12321','12',NULL),(23,4,NULL,'2022-10-11 20:24:20',300,'PENDING','','','','',NULL),(24,5,NULL,'2022-09-11 22:17:05',407000,'DELIVERED','fdsfs','12321321','234324','23432',NULL),(25,1,NULL,'2022-10-12 16:59:26',498000,'PENDING','sfđsfds','123213','21321','234324',NULL),(26,1,NULL,'2022-10-13 19:23:43',169000,'PENDING','Nguyễn Quốc Hưng','+84522956799','12321sdfs fsdf ','quochung9920@gmail.com',NULL),(27,1,NULL,'2022-10-20 18:04:50',886000,'PENDING','Nguyễn Văn A','+84522956799','123 abc','quochung9920123123@gmail.com',NULL),(28,1,NULL,'2022-10-20 18:11:49',277000,'PENDING','Nguyễn Quốc Phát','+84522956799','32432 ss đá ','quochung9920213123@gmail.com',NULL),(29,1,NULL,'2022-10-20 19:36:50',498000,'PENDING','Nguyễn Quốc Hưng','+84918951429','123211','quochung9920@gmail.com',NULL),(30,1,NULL,'2022-10-20 19:56:28',0,'PENDING','Nguyễn Quốc Hưng','+84918951429','123213 12312','quochung9920@gmail.com',NULL),(31,1,NULL,'2022-10-20 20:00:33',0,'PENDING','adsf','+84918951429','ádf ấd fdsa fds ','quochung9920@gmail.com',NULL),(32,1,NULL,'2022-10-20 20:03:56',123,'PENDING','Nguyễn Quốc Hưng','+84918951429','12131 ``213','quochung9920@gmail.com',NULL),(33,1,NULL,'2022-10-20 20:06:16',123,'PENDING','ads','+84522956799','ádf adsf sda','quochung9920@gmail.com',NULL),(34,1,NULL,'2022-10-20 20:07:48',123,'PENDING','adsf fa','+84522956799','adf ádf ád','quochung9920@gmail.com',NULL),(35,1,NULL,'2022-11-20 20:09:55',249000,'PENDING','ádf sadf','245345245','123213 12312','quochung9920@gmail.com',1),(36,1,NULL,'2022-10-20 20:24:26',249000,'PENDING','Nguyễn Quốc Hưng','+84918951429','ádf ádf sadf','quochung9920@gmail.com',1);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_details`
--

DROP TABLE IF EXISTS `bill_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_bill` int NOT NULL,
  `id_product` int NOT NULL,
  `amount` int NOT NULL,
  `price` int NOT NULL,
  `total_price` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bill_details_bill_idx` (`id_bill`),
  KEY `fk_bill_product_idx` (`id_product`),
  CONSTRAINT `fk_bill_details_bill` FOREIGN KEY (`id_bill`) REFERENCES `bill` (`id`),
  CONSTRAINT `fk_bill_product` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_details`
--

LOCK TABLES `bill_details` WRITE;
/*!40000 ALTER TABLE `bill_details` DISABLE KEYS */;
INSERT INTO `bill_details` VALUES (1,7,43,1,79000,79000),(2,7,44,3,249000,747000),(3,7,45,1,249000,249000),(6,9,52,1,109000,109000),(7,10,44,1,249000,249000),(8,11,44,1,249000,249000),(9,12,44,1,249000,249000),(10,14,55,2,30000,60000),(11,14,56,1,30000,30000),(12,15,43,1,79000,79000),(13,15,44,1,249000,249000),(14,16,44,1,249000,249000),(15,17,45,1,249000,249000),(16,18,44,1,249000,249000),(18,20,45,1,249000,249000),(20,22,44,1,249000,249000),(21,23,44,1,249000,249000),(22,23,45,1,249000,249000),(23,24,51,1,79000,79000),(24,24,43,1,79000,79000),(25,24,45,1,249000,249000),(26,25,44,1,249000,249000),(27,25,45,1,249000,249000),(28,26,48,1,49000,49000),(29,26,49,1,120000,120000),(30,27,52,1,109000,109000),(31,27,54,1,30000,30000),(32,27,44,2,249000,498000),(33,27,45,1,249000,249000),(34,28,48,1,49000,49000),(35,28,51,1,79000,79000),(36,28,42,1,149000,149000),(37,29,44,1,249000,249000),(38,29,45,1,249000,249000),(39,30,42,1,149000,149000),(40,30,44,1,249000,249000),(41,31,44,1,249000,249000),(42,31,45,1,249000,249000),(43,32,44,1,249000,249000),(44,32,45,1,249000,249000),(45,33,42,1,149000,149000),(46,34,44,1,249000,249000),(47,35,44,1,249000,249000),(48,35,45,1,249000,249000),(49,36,44,1,249000,249000),(50,36,45,1,249000,249000);
/*!40000 ALTER TABLE `bill_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `short_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'PIZZA','pizza'),(2,'MÌ Ý VÀ CƠM','rice'),(3,'MÓN KHAI VỊ','starter'),(4,'THỨC UỐNG','drink');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `content` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci,
  `rating` int DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `id_product` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_product_idx` (`id_product`),
  KEY `fk_comment_user_idx` (`id_user`),
  CONSTRAINT `fk_comment_product` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_comment_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `percentage_reduction` int NOT NULL,
  `amount` int NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `status` varchar(45) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (1,'Giảm giá 50%',50,123,'2022-10-20','2022-10-25','Enable'),(2,'Giảm giá 20%',20,12,'2022-10-20','2022-10-29','Enable'),(3,'Giảm giá 10%',10,123,'2022-10-20','2022-10-22','Disable');
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci,
  `price` int NOT NULL,
  `id_category` int NOT NULL,
  `amount` int NOT NULL DEFAULT '0',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_category_idx` (`id_category`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (42,'Pizza Bánh Xèo Tôm Nhảy','Thổi bùng vị giác cùng sự kết hợp mới lạ đến từ hương vị bánh xèo truyền thống trên nền bánh pizza, hòa quyện xốt Mayonnaise, phô mai Mozzarella và nguyên liệu Tôm Nhảy cho khẩu vị cũng phải nhún nhảy từ lát bánh đầu tiên!',149000,1,13,'/images/products/Pizza_Banh_Xeo_Tom_Nhay_400x275.jpg'),(43,'Pizza Rau Củ (Xốt Bơ Tỏi)','Thanh Nhẹ Với Ô Liu Đen Tuyệt Hảo, Cà Chua Bi Tươi Ngon, Nấm, Thơm, Bắp, Hành Tây Và Phô Mai Mozzarella Cho Bạn Bữa Tiệc Rau Củ Tròn Vị',79000,1,0,'/images/products/Pizza_Rau_Cu_400x275.jpg'),(44,'Pizza Gấp Đôi Nhân Phủ Hải Snar Xốt Pesto','Pizza Hải Sản Xốt Pesto Với Hải Sản (Tôm, Mực) Nhân Đôi Cùng Với Nấm Trên Nền Xốt Pesto Đặc Trưng, Phủ Phô Mai Mozzarella Từ New Zealand Và Quế Tây.',249000,1,15,'/images/products/Pizza_Gap_Doi_Nhan_Phu_Hai_San_Xot_Pesto_400x275.jpg'),(45,'Pizza Gấp Đôi Nhân Phủ Cơn Lốc Hải Sản','Pizza Cơn Lốc Hải Sản Với Hải Sản (MựC, Thanh Cua) Nhân Đôi Cùng Với Thơm, Ớt Chuông Xanh, HàNh Tây, Phủ Phô Mai Mozzarella Từ New Zealand Trên Nền XốT Cheesy Mayo.',249000,1,43,'/images/products/Pizza_Gap_Doi_Nhan_Phu_Con_Loc_Hai_San_400x275.jpg'),(46,'Pizza Gấp Đôi Nhân Phủ Hải Sản Xốt Tiêu Đen','Pizza Hải Sản Xốt Tiêu Đen Với Hải Sản (Tôm, Mực, Thanh Cua) Nhân Đôi Cùng Với Hành Tây, Thơm Phủ Xốt Tiêu Đen Thơm Nóng Và Phô Mai Mozzarella Từ New Zealand.',249000,1,26,'/images/products/Pizza_Gap_Doi_Nhan_Phu_Hai_San_Xot_Tieu_Den_400x275.jpg'),(47,'Mì Ý Thanh Cua','Mì Spaghetti, Xốt Phô Mai Cay, Thanh Cua, Cà Rốt, Đậu Pháp',49000,2,14,'/images/products/Mi_Y_Thanh_Cua_400x275.jpg'),(48,'Mì Ý Xông Khói Xốt Tiêu Đen','Mì Spaghetti, Xốt Tiêu Đen, Xốt Kem Nấm, Thịt Heo Xông Khói, Xúc Xích Gà, Bí Ngòi',49000,2,14,'/images/products/Mi_Y_Thit_Xong_Khoi_400x275.jpg'),(49,'Mì Ý Bò Bằm Xốt Cà Chua','Mì Ý Xốt Cà Chua Với Thịt Bò',120000,2,24,'/images/products/Mi_Y_Thit_Bam_Xot_Ca_Chua_400x275.jpg'),(50,'Khoai Tây Chiên','Khoai Tây Chiên Với Xốt Cà Chua',59000,3,12,'/images/products/Khoai_Tay_Chien_400x275.jpg'),(51,'Phô Mai Chiên Giòn','Phô Mai Chiên Giòn',79000,3,21,'/images/products/Pho_Mai_Chien_Gion_400x275.jpg'),(52,'Cánh Gà Nướng BBQ (4 Miếng)','Cánh Gà Nướng Thơm Lừng Ngon Tuyệt Với Hương Vị BBQ',109000,3,12,'/images/products/Canh_Ga_Nuong_BBQ_400x275.jpg'),(53,'Aquafina 500ml','Aquafina 500ml',20000,4,0,'/images/products/Aquafina_400x275.jpg'),(54,'Pepsi Lon 320ml','Pepsi Lon 320ml',30000,4,123,'/images/products/Pepsi_Can_400x275.jpg'),(55,'7Up Can 320ml','7Up Can 320ml',30000,4,23,'/images/products/7Up_Can_400x275.jpg'),(56,'Mirinda Orange Lon 320ml','Mirinda Orange Lon 320ml',30000,4,25,'/images/products/Mirinda_Orange_Can_400x275.jpg'),(57,'Mirinda 1.5L','Mirinda Chai 1.5L',42000,4,14,'/images/products/Mirinda_1lit5_400x275.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `address` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci,
  `role` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'','','','','','ROLE_CUSTOMER',NULL),(2,'quochung99201','$2a$10$tHnFAzZTpVL9/Dyf/87hQesAuDQ8aE6P7Abum4ijOdW178VjzIO3u','quochung99201@gmail.com','0123456788','Thôn 5, Tâm Thắng, Cư Jút, Đăk Nông','ROLE_USER',NULL),(3,'quochung9920','$2a$10$Tpdj4Bz7.xv7W.ATddLwfOZbExts.dq/ArA18crtAfxHb1WY.1/BK','quochung9920@gmail.com','+84522956799','129/23/12 Hoàng Văn Thụ, Phường 8','ROLE_ADMIN',NULL),(4,'quochung99202','$2a$10$7fvpnZpXAFhkv4JXbhzw0.oBl8z3c.fxTeeJsV1Pk6WZvoZPSeidW','quochung99202@gmail.com',NULL,NULL,'ROLE_USER',NULL),(5,'quochung99203','$2a$10$h2aFjBKXF6LO00JA2qy1ZuC2mDJAvtWWm0FFu60ZNUj2sTSyKFuBy','quochung99203@gmail.com',NULL,NULL,'ROLE_USER',NULL),(6,'quochung99204','$2a$10$zdHi8S6xvTEk7YNUragPYeHL6W70uJ3tcRABBrWDOs0qmRXuk6QVO','quochung99204@gmail.com','123456','','ROLE_USER',NULL),(7,'quochung99205','$2a$10$nmT1/1TmG9ruQmIYpYsbFuM0HPPM9hy2xUZ4Xiunvoi8KBke1.avS','quochung99205@gmail.com',NULL,NULL,'ROLE_STAFF',NULL),(8,'quochung99202123123','$2a$10$sfwa4M7izFLrigAJPFMxj.LSLOV08q.cZMaI.DwgKk0k.1vEnjs4G','quochung99202123123@gmail.com',NULL,NULL,'ROLE_USER',NULL),(9,'quochung992021234','$2a$10$pNAHpfTGTFpSpq7DwPnk6.Vd7c8XciWWboUFai6h0RGez0lY9nOsq','quochung992021234@gmail.com',NULL,NULL,'ROLE_USER',NULL),(10,'quochung99205123','$2a$10$gyHqjLNHN1p4GZpTRLN4lOKlPCKA1M/UXAnrKiY7Bq8fejLBLHLR6','quochung99205123@gmail.com','','','ROLE_STAFF',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-21 17:21:02
