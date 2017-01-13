# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: localhost (MySQL 5.6.33)
# Database: aes
# Generation Time: 2017-01-13 18:53:26 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Agency
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Agency`;

CREATE TABLE `Agency` (
  `agency_id` int(11) NOT NULL,
  `agency_name` varchar(30) NOT NULL DEFAULT '',
  `agency_location` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`agency_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Agency` WRITE;
/*!40000 ALTER TABLE `Agency` DISABLE KEYS */;

INSERT INTO `Agency` (`agency_id`, `agency_name`, `agency_location`)
VALUES
	(10,'American Family Insurance','St. Louis, MO'),
	(20,'Farmer\'s Insurance','Des Moines, IA');

/*!40000 ALTER TABLE `Agency` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Employee
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Employee`;

CREATE TABLE `Employee` (
  `emp_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(30) NOT NULL,
  `agency_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `FK_Agency` (`agency_id`),
  CONSTRAINT `FK_Agency` FOREIGN KEY (`agency_id`) REFERENCES `Agency` (`agency_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;

INSERT INTO `Employee` (`emp_id`, `emp_name`, `agency_id`)
VALUES
	(101,'Bob White',10),
	(102,'Martha White',20),
	(103,'Barry White',10),
	(104,'Perry White',20),
	(105,'Mel Torme',10),
	(106,'Jack Jones',10),
	(107,'Lena Horne',20),
	(111,'James Thurber',20);

/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
