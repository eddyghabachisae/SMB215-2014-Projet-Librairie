/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.17 : Database - librarydb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`librarydb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `librarydb`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `aut_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `aut_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aut_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `author` */

insert  into `author`(`aut_id`,`aut_name`) values (1,'Deitel'),(2,'Sams');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bok_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bok_title` varchar(255) DEFAULT NULL,
  `bok_subtitle` varchar(255) DEFAULT NULL,
  `bok_isbn` varchar(255) DEFAULT NULL,
  `bok_publisher` varchar(255) DEFAULT NULL,
  `bok_publisherdate` date DEFAULT NULL,
  `bok_nbpages` int(11) NOT NULL DEFAULT '0',
  `bookCategory_id` bigint(20) NOT NULL DEFAULT '0',
  `bookLanguage_id` bigint(20) NOT NULL DEFAULT '0',
  `BookAuthor_id` bigint(20) DEFAULT '0',
  `bookstatus_id` bigint(20) NOT NULL DEFAULT '0',
  `item_id` bigint(20) DEFAULT '0',
  PRIMARY KEY (`bok_id`),
  KEY `bookLanguage_id` (`bookLanguage_id`),
  KEY `BookAuthor_id` (`BookAuthor_id`),
  KEY `bookstatus_id` (`bookstatus_id`),
  KEY `bookCategory_id` (`bookCategory_id`),
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`bookLanguage_id`) REFERENCES `booklanguage` (`lan_id`),
  CONSTRAINT `book_ibfk_3` FOREIGN KEY (`BookAuthor_id`) REFERENCES `bookauthors` (`bka_id`),
  CONSTRAINT `book_ibfk_4` FOREIGN KEY (`bookstatus_id`) REFERENCES `bookstatus` (`bks_id`),
  CONSTRAINT `book_ibfk_5` FOREIGN KEY (`bookCategory_id`) REFERENCES `bookcategory` (`bkc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`bok_id`,`bok_title`,`bok_subtitle`,`bok_isbn`,`bok_publisher`,`bok_publisherdate`,`bok_nbpages`,`bookCategory_id`,`bookLanguage_id`,`BookAuthor_id`,`bookstatus_id`,`item_id`) values (9,'Java Programming','version 9','1234567890','Deitel','2013-10-10',1000,1,1,1,1,0),(14,'Language R','8 eme Edition','998877','Sams','2014-10-05',550,2,3,2,1,0);

/*Table structure for table `bookauthors` */

DROP TABLE IF EXISTS `bookauthors`;

CREATE TABLE `bookauthors` (
  `bka_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bka_code` varchar(255) DEFAULT NULL,
  `author_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bka_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `bookauthors_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `author` (`aut_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `bookauthors` */

insert  into `bookauthors`(`bka_id`,`bka_code`,`author_id`) values (1,NULL,1),(2,NULL,2);

/*Table structure for table `bookcategory` */

DROP TABLE IF EXISTS `bookcategory`;

CREATE TABLE `bookcategory` (
  `bkc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bkc_code` varchar(255) DEFAULT NULL,
  `bkc_description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`bkc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `bookcategory` */

insert  into `bookcategory`(`bkc_id`,`bkc_code`,`bkc_description`) values (1,'Comp','Computer'),(2,'Stat','Statistics');

/*Table structure for table `booklanguage` */

DROP TABLE IF EXISTS `booklanguage`;

CREATE TABLE `booklanguage` (
  `lan_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lan_code` varchar(255) DEFAULT NULL,
  `lan_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `booklanguage` */

insert  into `booklanguage`(`lan_id`,`lan_code`,`lan_name`) values (1,'ENG','English'),(2,'ARA','Arabic'),(3,'FRN','French');

/*Table structure for table `bookreservation` */

DROP TABLE IF EXISTS `bookreservation`;

CREATE TABLE `bookreservation` (
  `res_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `itm_id` bigint(20) DEFAULT NULL,
  `client_id` int(20) DEFAULT NULL,
  `reservation_date` date DEFAULT NULL,
  `returned` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`res_id`),
  KEY `client_id` (`client_id`),
  KEY `itm_id` (`itm_id`),
  CONSTRAINT `bookreservation_ibfk_3` FOREIGN KEY (`itm_id`) REFERENCES `item` (`itm_id`),
  CONSTRAINT `bookreservation_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `customer` (`cst_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `bookreservation` */

insert  into `bookreservation`(`res_id`,`itm_id`,`client_id`,`reservation_date`,`returned`) values (6,1,1,'2013-10-10',1),(7,1,1,'2013-10-10',0),(8,3,1,'2013-10-10',0),(9,4,1,'2013-10-10',0),(10,6,1,'2013-10-10',0),(11,4,1,'2013-10-10',0);

/*Table structure for table `bookstatus` */

DROP TABLE IF EXISTS `bookstatus`;

CREATE TABLE `bookstatus` (
  `bks_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bks_reservedcopies` int(11) NOT NULL DEFAULT '0',
  `bks_section` varchar(255) DEFAULT NULL,
  `bks_shelf` varchar(255) DEFAULT NULL,
  `branch_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bks_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `bookstatus` */

insert  into `bookstatus`(`bks_id`,`bks_reservedcopies`,`bks_section`,`bks_shelf`,`branch_id`) values (1,1,'3','14',1);

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `brh_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `brh_name` varchar(255) DEFAULT NULL,
  `brh_address` varchar(255) DEFAULT NULL,
  `brh_email` varchar(255) DEFAULT NULL,
  `brh_phone` varchar(255) DEFAULT NULL,
  `brh_fax` varchar(255) DEFAULT NULL,
  `brh_mobile` varchar(255) DEFAULT NULL,
  `brh_isactive` tinyint(1) NOT NULL DEFAULT '0',
  `brh_activesince` datetime DEFAULT NULL,
  `brh_deactivatedsince` datetime DEFAULT NULL,
  `city_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`brh_id`),
  KEY `city_id` (`city_id`),
  CONSTRAINT `branch_ibfk_1` FOREIGN KEY (`city_id`) REFERENCES `city` (`cty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `branch` */

insert  into `branch`(`brh_id`,`brh_name`,`brh_address`,`brh_email`,`brh_phone`,`brh_fax`,`brh_mobile`,`brh_isactive`,`brh_activesince`,`brh_deactivatedsince`,`city_id`) values (1,'Beirut Campus','Beirut Jnah','beirutcampus@ise.edu.lb','01988888','01988887','03988888',1,'0000-00-00 00:00:00',NULL,1),(2,'Tripoli Campus','Tripoli','tripolicampus@isae.edu.lb','07999999','07111111','03111111',1,NULL,NULL,2),(3,'Paris Campus','PAris','ParisCampus@isae.edu.lb','0033353588','0033338978','0033111111',1,NULL,NULL,3);

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `cty_id` bigint(20) NOT NULL DEFAULT '0',
  `cty_code` varchar(255) DEFAULT NULL,
  `cty_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cty_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`cty_id`,`cty_code`,`cty_name`) values (1,'Bey','Beirut'),(2,'Trip','Tripoli'),(3,'Par','Paris'),(4,'Bek','Bekfaya'),(5,'zah','Zahleh'),(6,'Tyr','Tyre');

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `cnt_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnt_code` varchar(255) DEFAULT NULL,
  `cnt_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cnt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `country` */

insert  into `country`(`cnt_id`,`cnt_code`,`cnt_name`) values (1,'Leb','Lebanon'),(2,'Fr','France'),(3,'--','-- Select --'),(4,'ITA','Italy');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `cst_id` int(20) NOT NULL AUTO_INCREMENT,
  `cst_username` varchar(255) DEFAULT NULL,
  `cst_password` varchar(255) DEFAULT NULL,
  `cst_firstname` varchar(255) DEFAULT NULL,
  `cst_lastname` varchar(255) DEFAULT NULL,
  `cst_gender_id` int(11) NOT NULL DEFAULT '0',
  `cst_maritalstatus` int(11) NOT NULL DEFAULT '0',
  `cst_dateofbirth` datetime DEFAULT NULL,
  `cst_address` varchar(255) DEFAULT NULL,
  `cst_phone` varchar(255) DEFAULT NULL,
  `cst_mobile` varchar(255) DEFAULT NULL,
  `cst_email` varchar(255) DEFAULT NULL,
  `cst_remarks` varchar(1024) DEFAULT NULL,
  `cst_isactive` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`cst_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`cst_id`,`cst_username`,`cst_password`,`cst_firstname`,`cst_lastname`,`cst_gender_id`,`cst_maritalstatus`,`cst_dateofbirth`,`cst_address`,`cst_phone`,`cst_mobile`,`cst_email`,`cst_remarks`,`cst_isactive`) values (1,'dany.wazen','welcome','Dany','Wazen',1,2,'1979-09-29 00:00:00','beirut                                      ','031663801','03166380','dany.wazen@gmail.com','none                                      ',1),(2,'mireille.haddad','welcome1','Mireille','Haddad',2,1,'1986-08-16 00:00:00','Paris','+33998877889','989898','mireille@gmail.com','nothing to note- thank for adding me',1);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `emp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_ssn` int(11) NOT NULL DEFAULT '0',
  `emp_username` varchar(255) DEFAULT NULL,
  `emp_password` varchar(255) DEFAULT NULL,
  `emp_firstname` varchar(255) DEFAULT NULL,
  `emp_lastname` varchar(255) DEFAULT NULL,
  `emp_gender_id` int(11) NOT NULL DEFAULT '0',
  `emp_maritalstatus_id` int(11) NOT NULL DEFAULT '0',
  `emp_dateofbirth` datetime DEFAULT NULL,
  `emp_address` varchar(255) DEFAULT NULL,
  `emp_homephone` varchar(255) DEFAULT NULL,
  `emp_mobile` varchar(255) DEFAULT NULL,
  `emp_personalemail` varchar(255) DEFAULT NULL,
  `emp_workphone` varchar(255) DEFAULT NULL,
  `emp_workext` varchar(255) DEFAULT NULL,
  `emp_workfax` varchar(255) DEFAULT NULL,
  `emp_workemail` varchar(255) DEFAULT NULL,
  `emp_remarks` varchar(255) DEFAULT NULL,
  `emp_isactive` tinyint(1) NOT NULL DEFAULT '0',
  `emp_activesince` datetime DEFAULT NULL,
  `emp_deactivatedsince` datetime DEFAULT NULL,
  `emp_deactivatedreason` varchar(255) DEFAULT NULL,
  `city_id` bigint(20) NOT NULL DEFAULT '0',
  `profession_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

/*Table structure for table `gender` */

DROP TABLE IF EXISTS `gender`;

CREATE TABLE `gender` (
  `id` int(11) NOT NULL,
  `gender_desc` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `gender` */

insert  into `gender`(`id`,`gender_desc`) values (1,'male'),(2,'female');

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `itm_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `itm_name` varchar(255) DEFAULT NULL,
  `itm_barcode` varchar(255) DEFAULT NULL,
  `itm_barcodeimgpath` varchar(255) DEFAULT NULL,
  `itm_imgpath` varchar(255) DEFAULT NULL,
  `itm_description` varchar(255) DEFAULT NULL,
  `itm_avgunitcost` double NOT NULL DEFAULT '0',
  `itm_salerentprice` double NOT NULL DEFAULT '0',
  `itm_minlimit` int(11) NOT NULL DEFAULT '0',
  `itm_maxlimit` int(11) NOT NULL DEFAULT '0',
  `itm_quantity` int(11) NOT NULL DEFAULT '0',
  `itm_isavailable` tinyint(1) NOT NULL DEFAULT '0',
  `itm_isactive` tinyint(1) NOT NULL DEFAULT '0',
  `itm_deactivationreason` varchar(255) DEFAULT NULL,
  `itemCategory_id` bigint(20) NOT NULL DEFAULT '0',
  `bok_id` bigint(20) DEFAULT NULL,
  `wrh_id` bigint(4) DEFAULT NULL,
  PRIMARY KEY (`itm_id`),
  KEY `bok_id` (`bok_id`),
  KEY `wrh_id` (`wrh_id`),
  CONSTRAINT `item_ibfk_2` FOREIGN KEY (`wrh_id`) REFERENCES `warehouse` (`wrh_id`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`bok_id`) REFERENCES `book` (`bok_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `item` */

insert  into `item`(`itm_id`,`itm_name`,`itm_barcode`,`itm_barcodeimgpath`,`itm_imgpath`,`itm_description`,`itm_avgunitcost`,`itm_salerentprice`,`itm_minlimit`,`itm_maxlimit`,`itm_quantity`,`itm_isavailable`,`itm_isactive`,`itm_deactivationreason`,`itemCategory_id`,`bok_id`,`wrh_id`) values (1,'Java Prog1','1234567',NULL,NULL,NULL,100,120,3,6,3,1,1,NULL,0,9,1),(2,'Java Prog2','1234567',NULL,NULL,NULL,100,120,3,6,3,1,1,NULL,0,9,5),(3,'Java1','1234567',NULL,NULL,NULL,100,120,3,6,3,1,1,NULL,0,9,2),(4,'JavaC1','1234567',NULL,NULL,NULL,100,120,3,6,6,1,1,NULL,0,9,3),(5,'JavaC2','1234567',NULL,NULL,NULL,100,120,5,10,5,1,1,NULL,0,9,5),(6,'R2','9897777',NULL,NULL,NULL,50,55,1,3,1,1,1,NULL,0,14,1);

/*Table structure for table `itemcategory` */

DROP TABLE IF EXISTS `itemcategory`;

CREATE TABLE `itemcategory` (
  `itc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `itc_code` varchar(255) DEFAULT NULL,
  `itc_description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`itc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `itemcategory` */

/*Table structure for table `library` */

DROP TABLE IF EXISTS `library`;

CREATE TABLE `library` (
  `lib_id` int(11) NOT NULL AUTO_INCREMENT,
  `lib_name` varchar(255) DEFAULT NULL,
  `lib_website` varchar(255) DEFAULT NULL,
  `lib_rentaldays` int(11) NOT NULL DEFAULT '0',
  `lib_reservationdays` int(11) NOT NULL DEFAULT '0',
  `lib_maxreserve` int(11) NOT NULL DEFAULT '0',
  `lib_rentalalert` int(11) NOT NULL DEFAULT '0',
  `lib_reservationalert` int(11) NOT NULL DEFAULT '0',
  `lib_maincurrency` varchar(255) DEFAULT NULL,
  `lib_secondarycurrency` varchar(255) DEFAULT NULL,
  `lib_secondarycurrencyrate` float DEFAULT NULL,
  `mainBranch_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`lib_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `library` */

/*Table structure for table `manage` */

DROP TABLE IF EXISTS `manage`;

CREATE TABLE `manage` (
  `mng_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mng_sincedate` datetime DEFAULT NULL,
  `mng_tilldate` datetime DEFAULT NULL,
  `mng_stopreason` varchar(255) DEFAULT NULL,
  `branch_id` bigint(20) NOT NULL DEFAULT '0',
  `employee_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`mng_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manage` */

/*Table structure for table `marital` */

DROP TABLE IF EXISTS `marital`;

CREATE TABLE `marital` (
  `id` int(11) NOT NULL,
  `marital_desc` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `marital` */

insert  into `marital`(`id`,`marital_desc`) values (1,'Single'),(2,'Married'),(3,'Divorced');

/*Table structure for table `profession` */

DROP TABLE IF EXISTS `profession`;

CREATE TABLE `profession` (
  `prf_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prf_code` varchar(255) DEFAULT NULL,
  `prf_description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`prf_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `profession` */

insert  into `profession`(`prf_id`,`prf_code`,`prf_description`) values (1,NULL,'Engineer');

/*Table structure for table `province` */

DROP TABLE IF EXISTS `province`;

CREATE TABLE `province` (
  `pvc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pvc_code` bigint(20) NOT NULL DEFAULT '0',
  `pvc_name` varchar(255) DEFAULT NULL,
  `country_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pvc_id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `province_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`cnt_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `province` */

insert  into `province`(`pvc_id`,`pvc_code`,`pvc_name`,`country_id`) values (1,212,'Metn',1),(4,213,'Mansourieh',1),(5,331,'18 eme arrondissement',2);

/*Table structure for table `purchasedetails` */

DROP TABLE IF EXISTS `purchasedetails`;

CREATE TABLE `purchasedetails` (
  `pod_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pod_quantity` int(11) NOT NULL DEFAULT '0',
  `pod_unitcost` double NOT NULL DEFAULT '0',
  `purshasedHeader_id` bigint(20) NOT NULL DEFAULT '0',
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `purchasedetails` */

/*Table structure for table `purchaseheader` */

DROP TABLE IF EXISTS `purchaseheader`;

CREATE TABLE `purchaseheader` (
  `poh_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `poh_orderdate` datetime DEFAULT NULL,
  `poh_shippingdate` datetime DEFAULT NULL,
  `poh_deliverydate` datetime DEFAULT NULL,
  `poh_total` double NOT NULL DEFAULT '0',
  `branch_id` bigint(20) NOT NULL DEFAULT '0',
  `employee_id` bigint(20) NOT NULL DEFAULT '0',
  `supplierBranch_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`poh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `purchaseheader` */

/*Table structure for table `rentdetails` */

DROP TABLE IF EXISTS `rentdetails`;

CREATE TABLE `rentdetails` (
  `rnd_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rnt_returneddate` datetime DEFAULT NULL,
  `rnt_price` double NOT NULL DEFAULT '0',
  `book_id` bigint(20) NOT NULL DEFAULT '0',
  `rentHeader_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rnd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rentdetails` */

/*Table structure for table `rentheader` */

DROP TABLE IF EXISTS `rentheader`;

CREATE TABLE `rentheader` (
  `rnt_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rnt_date` datetime DEFAULT NULL,
  `rnt_total` double NOT NULL DEFAULT '0',
  `cutomer_id` bigint(20) NOT NULL DEFAULT '0',
  `employee_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rnt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rentheader` */

/*Table structure for table `salesdetails` */

DROP TABLE IF EXISTS `salesdetails`;

CREATE TABLE `salesdetails` (
  `sod_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `soh_quantity` int(11) NOT NULL DEFAULT '0',
  `soh_unitprice` double NOT NULL DEFAULT '0',
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  `salesHeader_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salesdetails` */

/*Table structure for table `salesheader` */

DROP TABLE IF EXISTS `salesheader`;

CREATE TABLE `salesheader` (
  `soh_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `soh_date` datetime DEFAULT NULL,
  `soh_total` double NOT NULL DEFAULT '0',
  `cutomer_id` bigint(20) NOT NULL DEFAULT '0',
  `branch_id` bigint(20) NOT NULL DEFAULT '0',
  `employee_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`soh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `salesheader` */

/*Table structure for table `supitem` */

DROP TABLE IF EXISTS `supitem`;

CREATE TABLE `supitem` (
  `spi_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spi_price` double NOT NULL DEFAULT '0',
  `spi_shippingduration` int(11) NOT NULL DEFAULT '0',
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  `supplier_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`spi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supitem` */

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `sup_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sup_name` varchar(255) DEFAULT NULL,
  `sup_website` varchar(255) DEFAULT NULL,
  `sup_remarks` varchar(255) DEFAULT NULL,
  `sup_isactive` tinyint(1) NOT NULL DEFAULT '0',
  `sup_deactivationreason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `supplier` */

insert  into `supplier`(`sup_id`,`sup_name`,`sup_website`,`sup_remarks`,`sup_isactive`,`sup_deactivationreason`) values (1,'test','test.com','eee',1,'');

/*Table structure for table `supplierbranch` */

DROP TABLE IF EXISTS `supplierbranch`;

CREATE TABLE `supplierbranch` (
  `sbr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sbr_name` varchar(255) DEFAULT NULL,
  `sbr_contactname` varchar(255) DEFAULT NULL,
  `sbr_address` varchar(255) DEFAULT NULL,
  `sbr_phone` varchar(255) DEFAULT NULL,
  `sbr_fax` varchar(255) DEFAULT NULL,
  `sbr_mobile` varchar(255) DEFAULT NULL,
  `sbr_email` varchar(255) DEFAULT NULL,
  `sbr_remarks` varchar(1024) DEFAULT NULL,
  `sbr_isactive` tinyint(1) NOT NULL DEFAULT '0',
  `sbr_deactivationreason` varchar(255) DEFAULT NULL,
  `city_id` bigint(20) NOT NULL DEFAULT '0',
  `supplier_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sbr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `supplierbranch` */

/*Table structure for table `transferdetails` */

DROP TABLE IF EXISTS `transferdetails`;

CREATE TABLE `transferdetails` (
  `trd_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trd_quantity` int(11) NOT NULL DEFAULT '0',
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  `transferHeader_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`trd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `transferdetails` */

/*Table structure for table `transferheader` */

DROP TABLE IF EXISTS `transferheader`;

CREATE TABLE `transferheader` (
  `trf_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trf_frombranch` int(11) NOT NULL DEFAULT '0',
  `trf_tobranch` int(11) NOT NULL DEFAULT '0',
  `trf_orderdate` datetime DEFAULT NULL,
  `trf_shippingdate` datetime DEFAULT NULL,
  `trf_deliverydate` datetime DEFAULT NULL,
  `trf_employeesender` bigint(20) NOT NULL DEFAULT '0',
  `trf_employeereceiver` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`trf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `transferheader` */

/*Table structure for table `warehouse` */

DROP TABLE IF EXISTS `warehouse`;

CREATE TABLE `warehouse` (
  `wrh_id` bigint(4) NOT NULL AUTO_INCREMENT,
  `wrh_quantity` int(11) NOT NULL DEFAULT '0',
  `wrh_salerentprice` double NOT NULL DEFAULT '0',
  `wrh_minlimit` int(11) NOT NULL DEFAULT '0',
  `wrh_maxlimit` int(11) NOT NULL DEFAULT '0',
  `wrh_isavailable` tinyint(1) NOT NULL DEFAULT '0',
  `wrh_isactive` tinyint(1) NOT NULL DEFAULT '0',
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  `branch_id` tinyint(20) NOT NULL DEFAULT '0',
  `wrh_name` varchar(25) DEFAULT 'null',
  PRIMARY KEY (`wrh_id`),
  KEY `item_id` (`item_id`),
  KEY `branch_id` (`branch_id`),
  CONSTRAINT `warehouse_ibfk_1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`brh_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `warehouse` */

insert  into `warehouse`(`wrh_id`,`wrh_quantity`,`wrh_salerentprice`,`wrh_minlimit`,`wrh_maxlimit`,`wrh_isavailable`,`wrh_isactive`,`item_id`,`branch_id`,`wrh_name`) values (1,6,100,3,6,1,1,1,1,'Beirut01'),(2,3,100,3,6,1,1,1,1,'Beirut02'),(3,4,70,3,5,1,1,1,2,'Tripoli01'),(5,10,140,5,10,1,1,0,3,'Paris01'),(6,8,140,4,8,1,1,0,3,'Paris02');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
