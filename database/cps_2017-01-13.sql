# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: localhost (MySQL 5.6.33)
# Database: cps
# Generation Time: 2017-01-13 18:53:43 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table client
# ------------------------------------------------------------

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(30) NOT NULL,
  `client_phone` varchar(10) NOT NULL,
  `client_city` varchar(30) NOT NULL DEFAULT '',
  `client_state` varchar(2) NOT NULL DEFAULT '',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;

INSERT INTO `client` (`client_id`, `client_name`, `client_phone`, `client_city`, `client_state`)
VALUES
	(6,'AAR Corp','7327150737','WOODLAND','IL'),
	(7,'EMC','4084442789','CARY','NC'),
	(8,'WINDSTREAM','5107755027','COCKEYSVILLE','MD'),
	(9,'AMEX','5104568278','PHOENIX','AZ'),
	(10,'GDIT','5105986516','TOWSON','MD');

/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table policy
# ------------------------------------------------------------

DROP TABLE IF EXISTS `policy`;

CREATE TABLE `policy` (
  `policy_id` int(11) NOT NULL AUTO_INCREMENT,
  `policy_name` varchar(30) NOT NULL,
  `policy_type` varchar(50) NOT NULL,
  `policy_number` int(10) NOT NULL,
  `client_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `gross_premium` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`policy_id`),
  KEY `fk_client_id` (`client_id`),
  CONSTRAINT `fk_client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `policy` WRITE;
/*!40000 ALTER TABLE `policy` DISABLE KEYS */;

INSERT INTO `policy` (`policy_id`, `policy_name`, `policy_type`, `policy_number`, `client_id`, `emp_id`, `gross_premium`)
VALUES
	(105,'Home','LimitedCoveragePolicy',12345,6,101,10000),
	(106,'Auto','BasicPolicy',22321,10,104,20000),
	(107,'Home','OlderHome',12343,8,101,25867),
	(108,'Home','Renter',12897,7,106,12584),
	(109,'Auto','FullCoverage',22343,9,107,50003);

/*!40000 ALTER TABLE `policy` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
