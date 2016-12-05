# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: game611.cmidwbhaqwzg.us-east-1.rds.amazonaws.com (MySQL 5.6.27-log)
# Database: Game611
# Generation Time: 2016-12-01 20:18:24 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table card
# ------------------------------------------------------------

DROP TABLE IF EXISTS `card`;

CREATE TABLE `card` (
  `card_id` int(4) NOT NULL,
  `card_flavor` varchar(255) NOT NULL,
  `card_name` varchar(255) NOT NULL,
  `img_back` varchar(255) NOT NULL,
  `img_border` varchar(255) NOT NULL,
  `img_front` varchar(255) NOT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table creature
# ------------------------------------------------------------

DROP TABLE IF EXISTS `creature`;

CREATE TABLE `creature` (
  `card_id` int(4) NOT NULL,
  `vit` int(2) NOT NULL,
  `pow` int(2) NOT NULL,
  `def` int(2) NOT NULL,
  `spd` int(2) NOT NULL,
  `itl` int(2) NOT NULL,
  `favored_stat` int(2) NOT NULL,
  `dump_stat` int(2) NOT NULL,
  `temperment` int(2) NOT NULL,
  `aggr_rating` int(2) NOT NULL,
  PRIMARY KEY (`card_id`),
  CONSTRAINT `fk_creature_card` FOREIGN KEY (`card_id`) REFERENCES `card` (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table sorcerer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `sorcerer`;

CREATE TABLE `sorcerer` (
  `card_id` int(4) NOT NULL,
  `vit` int(2) NOT NULL,
  `pow` int(2) NOT NULL,
  `def` int(2) NOT NULL,
  `spd` int(2) NOT NULL,
  `itl` int(2) NOT NULL,
  PRIMARY KEY (`card_id`),
  CONSTRAINT `fk_sorcerer_card` FOREIGN KEY (`card_id`) REFERENCES `card` (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table spell
# ------------------------------------------------------------

DROP TABLE IF EXISTS `spell`;

CREATE TABLE `spell` (
  `card_id` int(4) NOT NULL,
  `casting_cost` int(2) DEFAULT NULL,
  `casting_spd` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`card_id`),
  CONSTRAINT `fk_spell_card` FOREIGN KEY (`card_id`) REFERENCES `card` (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table user_login
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_login`;

CREATE TABLE `user_login` (
  `username` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
