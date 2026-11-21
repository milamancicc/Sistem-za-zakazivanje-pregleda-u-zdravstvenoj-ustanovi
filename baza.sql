/*
SQLyog Community v13.3.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - ps_projekat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ps_projekat` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `ps_projekat`;

/*Table structure for table `doktor` */

DROP TABLE IF EXISTS `doktor`;

CREATE TABLE `doktor` (
  `idDoktora` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `zvanje` varchar(255) NOT NULL,
  `kontakt` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `korisnickoIme` varchar(255) NOT NULL,
  `lozinka` varchar(255) NOT NULL,
  PRIMARY KEY (`idDoktora`),
  UNIQUE KEY `korisnickoIme` (`korisnickoIme`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `doktor` */

insert  into `doktor`(`idDoktora`,`ime`,`prezime`,`zvanje`,`kontakt`,`email`,`korisnickoIme`,`lozinka`) values 
(1,'Mila','Mancic','doktor stomatologije','+381616101027','mm20230006@gmail.com','mm1','lozinka');

/*Table structure for table `grad` */

DROP TABLE IF EXISTS `grad`;

CREATE TABLE `grad` (
  `zipkod` bigint(20) NOT NULL,
  `naziv` varchar(255) NOT NULL,
  PRIMARY KEY (`zipkod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `grad` */

/*Table structure for table `pacijent` */

DROP TABLE IF EXISTS `pacijent`;

CREATE TABLE `pacijent` (
  `idPacijenta` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `datumRodjenja` date NOT NULL,
  `pol` enum('MUSKI','ZENSKI') NOT NULL,
  `godine` int(10) unsigned NOT NULL,
  `kontakt` varchar(255) NOT NULL,
  PRIMARY KEY (`idPacijenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `pacijent` */

/*Table structure for table `pregled` */

DROP TABLE IF EXISTS `pregled`;

CREATE TABLE `pregled` (
  `idPregleda` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `datumIVreme` datetime NOT NULL,
  `oznakaOrdinacije` varchar(255) NOT NULL,
  `brojUsluga` int(10) unsigned NOT NULL,
  `ukupnoTrajanje` int(11) NOT NULL,
  `napomena` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPregleda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `pregled` */

/*Table structure for table `specijalistickipodaci` */

DROP TABLE IF EXISTS `specijalistickipodaci`;

CREATE TABLE `specijalistickipodaci` (
  `idDoktora` bigint(20) unsigned NOT NULL,
  `idSpecijalizacije` bigint(20) unsigned NOT NULL,
  `godinaPostizanja` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idDoktora`,`idSpecijalizacije`),
  KEY `idSpecijalizacije` (`idSpecijalizacije`),
  CONSTRAINT `specijalistickipodaci_ibfk_1` FOREIGN KEY (`idDoktora`) REFERENCES `doktor` (`idDoktora`),
  CONSTRAINT `specijalistickipodaci_ibfk_2` FOREIGN KEY (`idSpecijalizacije`) REFERENCES `specijalizacija` (`idSpecijalizacije`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `specijalistickipodaci` */

/*Table structure for table `specijalizacija` */

DROP TABLE IF EXISTS `specijalizacija`;

CREATE TABLE `specijalizacija` (
  `idSpecijalizacije` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  `opis` varchar(255) NOT NULL,
  PRIMARY KEY (`idSpecijalizacije`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `specijalizacija` */

/*Table structure for table `stavkapregleda` */

DROP TABLE IF EXISTS `stavkapregleda`;

CREATE TABLE `stavkapregleda` (
  `idPregleda` bigint(20) unsigned NOT NULL,
  `idUsluge` bigint(20) unsigned NOT NULL,
  `simptomi` varchar(255) NOT NULL,
  `napomena` varchar(255) DEFAULT NULL,
  `hitnost` tinyint(1) NOT NULL,
  PRIMARY KEY (`idPregleda`,`idUsluge`),
  KEY `rb` (`idUsluge`),
  CONSTRAINT `stavkapregleda_ibfk_1` FOREIGN KEY (`idPregleda`) REFERENCES `pregled` (`idPregleda`),
  CONSTRAINT `stavkapregleda_ibfk_2` FOREIGN KEY (`idUsluge`) REFERENCES `usluga` (`idUsluge`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavkapregleda` */

/*Table structure for table `usluga` */

DROP TABLE IF EXISTS `usluga`;

CREATE TABLE `usluga` (
  `idUsluge` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) NOT NULL,
  `opis` varchar(255) NOT NULL,
  `procenjenoTrajanje` int(10) unsigned NOT NULL,
  `napomenaZaPacijenta` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idUsluge`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `usluga` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
