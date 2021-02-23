/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.13-MariaDB : Database - fpis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fpis` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `fpis`;

/*Table structure for table `adresa` */

DROP TABLE IF EXISTS `adresa`;

CREATE TABLE `adresa` (
  `adresaID` int(11) NOT NULL AUTO_INCREMENT,
  `mestoID` int(11) DEFAULT NULL,
  `ulicaID` int(11) DEFAULT NULL,
  `broj` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`adresaID`),
  KEY `adresa_ibfk_1` (`mestoID`),
  KEY `adresa_ibfk_2` (`ulicaID`),
  CONSTRAINT `adresa_ibfk_1` FOREIGN KEY (`mestoID`) REFERENCES `mesto` (`mestoID`),
  CONSTRAINT `adresa_ibfk_2` FOREIGN KEY (`ulicaID`) REFERENCES `ulica` (`ulicaID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `adresa` */

insert  into `adresa`(`adresaID`,`mestoID`,`ulicaID`,`broj`) values 
(1,1,1,'44'),
(2,1,2,'33');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(1),
(1),
(1),
(1),
(1),
(1);

/*Table structure for table `jedinicamere` */

DROP TABLE IF EXISTS `jedinicamere`;

CREATE TABLE `jedinicamere` (
  `jmID` int(11) NOT NULL AUTO_INCREMENT,
  `oznaka` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `naziv` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`jmID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `jedinicamere` */

insert  into `jedinicamere`(`jmID`,`oznaka`,`naziv`) values 
(1,'kg','kilogram'),
(2,'l','litar'),
(3,'kom','komad');

/*Table structure for table `kupac` */

DROP TABLE IF EXISTS `kupac`;

CREATE TABLE `kupac` (
  `pib` int(11) NOT NULL,
  `naziv` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefon` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adresaID` int(11) DEFAULT NULL,
  PRIMARY KEY (`pib`),
  KEY `kupac_ibfk_1` (`adresaID`),
  CONSTRAINT `FKj6j1fi5f17359sponq7tj95wp` FOREIGN KEY (`adresaID`) REFERENCES `adresa` (`adresaID`),
  CONSTRAINT `kupac_ibfk_1` FOREIGN KEY (`adresaID`) REFERENCES `adresa` (`adresaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `kupac` */

insert  into `kupac`(`pib`,`naziv`,`telefon`,`email`,`adresaID`) values 
(123456789,'Stedjo elektro','011/2576-360','stedjoelektro@gmail.com',1),
(987654321,'Trade shop','011/2754-222','trade@shop.com',2);

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `mestoID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`mestoID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `mesto` */

insert  into `mesto`(`mestoID`,`naziv`) values 
(1,'Beograd'),
(2,'Novi Sad'),
(3,'Nis'),
(4,'Subotica'),
(5,'Leskovac'),
(6,'Cacak'),
(7,'Kragujevac');

/*Table structure for table `ponuda` */

DROP TABLE IF EXISTS `ponuda`;

CREATE TABLE `ponuda` (
  `ponudaID` int(11) NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `tipPlacanjaID` int(11) DEFAULT NULL,
  `pib` int(11) DEFAULT NULL,
  `zahtevID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ponudaID`),
  KEY `ponuda_ibfk_1` (`tipPlacanjaID`),
  KEY `ponuda_ibfk_2` (`pib`),
  KEY `ponuda_ibfk_3` (`zahtevID`),
  CONSTRAINT `ponuda_ibfk_1` FOREIGN KEY (`tipPlacanjaID`) REFERENCES `tipplacanja` (`tipPlacanjaID`),
  CONSTRAINT `ponuda_ibfk_2` FOREIGN KEY (`pib`) REFERENCES `kupac` (`pib`),
  CONSTRAINT `ponuda_ibfk_3` FOREIGN KEY (`zahtevID`) REFERENCES `zahtev` (`zahtevID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `ponuda` */

/*Table structure for table `proizvod` */

DROP TABLE IF EXISTS `proizvod`;

CREATE TABLE `proizvod` (
  `proizvodID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `jmID` int(11) DEFAULT NULL,
  PRIMARY KEY (`proizvodID`),
  KEY `proizvod_ibfk_1` (`jmID`),
  CONSTRAINT `proizvod_ibfk_1` FOREIGN KEY (`jmID`) REFERENCES `jedinicamere` (`jmID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `proizvod` */

insert  into `proizvod`(`proizvodID`,`naziv`,`jmID`) values 
(1,'Fishburger',1),
(2,'Pomfrit',1),
(3,'Zlatna mesavina',1),
(4,'Rizoto',1),
(5,'Lisnato test',1),
(6,'Podloga za picu',3),
(7,'Becka snicla',1),
(8,'King',3),
(9,'Macho',3),
(10,'Kapri',3),
(11,'Rumenko',3),
(12,'Kornet',3),
(13,'Quattro Plazma',3),
(14,'Quattro Pistaci',3),
(15,'Vulkano',3);

/*Table structure for table `stavkaponude` */

DROP TABLE IF EXISTS `stavkaponude`;

CREATE TABLE `stavkaponude` (
  `rbStavke` int(11) NOT NULL AUTO_INCREMENT,
  `proizvodID` int(11) DEFAULT NULL,
  `kolicina` double DEFAULT NULL,
  `ponudaID` int(11) DEFAULT NULL,
  PRIMARY KEY (`rbStavke`),
  KEY `stavkaponude_ibfk_1` (`proizvodID`),
  KEY `stavkaponude_ibfk_2` (`ponudaID`),
  CONSTRAINT `stavkaponude_ibfk_1` FOREIGN KEY (`proizvodID`) REFERENCES `proizvod` (`proizvodID`),
  CONSTRAINT `stavkaponude_ibfk_2` FOREIGN KEY (`ponudaID`) REFERENCES `ponuda` (`ponudaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stavkaponude` */

/*Table structure for table `tipplacanja` */

DROP TABLE IF EXISTS `tipplacanja`;

CREATE TABLE `tipplacanja` (
  `tipPlacanjaID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`tipPlacanjaID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tipplacanja` */

insert  into `tipplacanja`(`tipPlacanjaID`,`naziv`) values 
(1,'gotovinski'),
(2,'bezgotovinski');

/*Table structure for table `ulica` */

DROP TABLE IF EXISTS `ulica`;

CREATE TABLE `ulica` (
  `ulicaID` int(11) NOT NULL AUTO_INCREMENT,
  `mestoID` int(11) DEFAULT NULL,
  `naziv` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ulicaID`),
  KEY `ulica_ibfk_1` (`mestoID`),
  CONSTRAINT `FKo067y7fdyoqm23uq55rdawypy` FOREIGN KEY (`mestoID`) REFERENCES `mesto` (`mestoID`),
  CONSTRAINT `ulica_ibfk_1` FOREIGN KEY (`mestoID`) REFERENCES `mesto` (`mestoID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `ulica` */

insert  into `ulica`(`ulicaID`,`mestoID`,`naziv`) values 
(1,1,'Avalska'),
(2,1,'Jove Ilica'),
(3,1,'Vojvode Stepe'),
(4,1,'Krunska'),
(5,1,'Topolska'),
(6,1,'Maksima Gorkog');

/*Table structure for table `zahtev` */

DROP TABLE IF EXISTS `zahtev`;

CREATE TABLE `zahtev` (
  `zahtevID` int(11) NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  PRIMARY KEY (`zahtevID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zahtev` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
