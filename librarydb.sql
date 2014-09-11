-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 11, 2014 at 08:40 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `librarydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE IF NOT EXISTS `author` (
  `aut_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `aut_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aut_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `bok_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bok_title` varchar(255) DEFAULT NULL,
  `bok_subtitle` varchar(255) DEFAULT NULL,
  `bok_isbn` varchar(255) DEFAULT NULL,
  `bok_publisher` varchar(255) DEFAULT NULL,
  `bok_publisherdate` datetime DEFAULT NULL,
  `bok_nbpages` int(11) NOT NULL DEFAULT '0',
  `bookCategory_id` bigint(20) NOT NULL DEFAULT '0',
  `bookLanguage_id` bigint(20) NOT NULL DEFAULT '0',
  `BookAuthor_id` bigint(20) NOT NULL DEFAULT '0',
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  `bookstatus_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bok_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bookauthors`
--

CREATE TABLE IF NOT EXISTS `bookauthors` (
  `bka_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bka_code` varchar(255) DEFAULT NULL,
  `author_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bka_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bookcategory`
--

CREATE TABLE IF NOT EXISTS `bookcategory` (
  `bkc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bkc_code` varchar(255) DEFAULT NULL,
  `bkc_description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`bkc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `booklanguage`
--

CREATE TABLE IF NOT EXISTS `booklanguage` (
  `lan_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lan_code` varchar(255) DEFAULT NULL,
  `lan_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `bookstatus`
--

CREATE TABLE IF NOT EXISTS `bookstatus` (
  `bks_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bks_reservedcopies` int(11) NOT NULL DEFAULT '0',
  `bks_section` varchar(255) DEFAULT NULL,
  `bks_shelf` varchar(255) DEFAULT NULL,
  `branch_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bks_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE IF NOT EXISTS `branch` (
  `brh_id` tinyint(1) NOT NULL AUTO_INCREMENT,
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
  PRIMARY KEY (`brh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `cty_id` bigint(20) NOT NULL DEFAULT '0',
  `cty_code` varchar(255) DEFAULT NULL,
  `cty_name` varchar(255) DEFAULT NULL,
  `province_id` bigint(20) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE IF NOT EXISTS `country` (
  `cnt_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnt_code` varchar(255) DEFAULT NULL,
  `cnt_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cnt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `cst_id` bigint(20) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
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
  PRIMARY KEY (`itm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `itemcategory`
--

CREATE TABLE IF NOT EXISTS `itemcategory` (
  `itc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `itc_code` varchar(255) DEFAULT NULL,
  `itc_description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`itc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `library`
--

CREATE TABLE IF NOT EXISTS `library` (
  `lib_id` int(11) NOT NULL AUTO_INCREMENT,
  `lib_name` varchar(255) DEFAULT NULL,
  `lib_logo` varchar(255) DEFAULT NULL,
  `lib_website` varchar(255) DEFAULT NULL,
  `lib_rentaldays` int(11) NOT NULL DEFAULT '0',
  `lib_reservationdays` int(11) NOT NULL DEFAULT '0',
  `lib_maxreserve` int(11) NOT NULL DEFAULT '0',
  `lib_rentalalert` int(11) NOT NULL DEFAULT '0',
  `lib_reservationalert` int(11) NOT NULL DEFAULT '0',
  `lib_maincurrency` varchar(255) DEFAULT NULL,
  `lib_secondarycurrency` varchar(255) DEFAULT NULL,
  `lib_secondarrycurrencyrate` varchar(255) DEFAULT NULL,
  `mainBranch_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`lib_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `manage`
--

CREATE TABLE IF NOT EXISTS `manage` (
  `mng_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mng_sincedate` datetime DEFAULT NULL,
  `mng_tilldate` datetime DEFAULT NULL,
  `mng_stopreason` varchar(255) DEFAULT NULL,
  `branch_id` bigint(20) NOT NULL DEFAULT '0',
  `employee_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`mng_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `profession`
--

CREATE TABLE IF NOT EXISTS `profession` (
  `prf_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prf_code` varchar(255) DEFAULT NULL,
  `prf_description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`prf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE IF NOT EXISTS `province` (
  `pvc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pvc_code` bigint(20) NOT NULL DEFAULT '0',
  `pvc_name` varchar(255) DEFAULT NULL,
  `country_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pvc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `purchasedetails`
--

CREATE TABLE IF NOT EXISTS `purchasedetails` (
  `pod_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pod_quantity` int(11) NOT NULL DEFAULT '0',
  `pod_unitcost` double NOT NULL DEFAULT '0',
  `purshasedHeader_id` bigint(20) NOT NULL DEFAULT '0',
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `purchaseheader`
--

CREATE TABLE IF NOT EXISTS `purchaseheader` (
  `poh_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `poh_orderdate` datetime DEFAULT NULL,
  `poh_shippingdate` datetime DEFAULT NULL,
  `poh_deliverydate` datetime DEFAULT NULL,
  `poh_total` double NOT NULL DEFAULT '0',
  `branch_id` bigint(20) NOT NULL DEFAULT '0',
  `employee_id` bigint(20) NOT NULL DEFAULT '0',
  `supplierBranch_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`poh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `rentdetails`
--

CREATE TABLE IF NOT EXISTS `rentdetails` (
  `rnd_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rnt_returneddate` datetime DEFAULT NULL,
  `rnt_price` double NOT NULL DEFAULT '0',
  `book_id` bigint(20) NOT NULL DEFAULT '0',
  `rentHeader_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rnd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `rentheader`
--

CREATE TABLE IF NOT EXISTS `rentheader` (
  `rnt_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rnt_date` datetime DEFAULT NULL,
  `rnt_total` double NOT NULL DEFAULT '0',
  `cutomer_id` bigint(20) NOT NULL DEFAULT '0',
  `employee_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rnt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `salesdetails`
--

CREATE TABLE IF NOT EXISTS `salesdetails` (
  `sod_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `soh_quantity` int(11) NOT NULL DEFAULT '0',
  `soh_unitprice` double NOT NULL DEFAULT '0',
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  `salesHeader_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sod_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `salesheader`
--

CREATE TABLE IF NOT EXISTS `salesheader` (
  `soh_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `soh_date` datetime DEFAULT NULL,
  `soh_total` double NOT NULL DEFAULT '0',
  `cutomer_id` bigint(20) NOT NULL DEFAULT '0',
  `branch_id` bigint(20) NOT NULL DEFAULT '0',
  `employee_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`soh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `supitem`
--

CREATE TABLE IF NOT EXISTS `supitem` (
  `spi_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spi_price` double NOT NULL DEFAULT '0',
  `spi_shippingduration` int(11) NOT NULL DEFAULT '0',
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  `supplier_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`spi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `sup_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sup_name` varchar(255) DEFAULT NULL,
  `sup_website` varchar(255) DEFAULT NULL,
  `sup_remarks` varchar(255) DEFAULT NULL,
  `sup_isactive` tinyint(1) NOT NULL DEFAULT '0',
  `sup_deactivationreason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sup_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `supplierbranch`
--

CREATE TABLE IF NOT EXISTS `supplierbranch` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `transferdetails`
--

CREATE TABLE IF NOT EXISTS `transferdetails` (
  `trd_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trd_quantity` int(11) NOT NULL DEFAULT '0',
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  `transferHeader_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`trd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `transferheader`
--

CREATE TABLE IF NOT EXISTS `transferheader` (
  `trf_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trf_frombranch` int(11) NOT NULL DEFAULT '0',
  `trf_tobranch` int(11) NOT NULL DEFAULT '0',
  `trf_orderdate` datetime DEFAULT NULL,
  `trf_shippingdate` datetime DEFAULT NULL,
  `trf_deliverydate` datetime DEFAULT NULL,
  `trf_employeesender` bigint(20) NOT NULL DEFAULT '0',
  `trf_employeereceiver` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`trf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `warehouse`
--

CREATE TABLE IF NOT EXISTS `warehouse` (
  `wrh_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `wrh_quantity` int(11) NOT NULL DEFAULT '0',
  `wrh_salerentprice` double NOT NULL DEFAULT '0',
  `wrh_minlimit` int(11) NOT NULL DEFAULT '0',
  `wrh_maxlimit` int(11) NOT NULL DEFAULT '0',
  `wrh_isavailable` tinyint(1) NOT NULL DEFAULT '0',
  `wrh_isactive` tinyint(1) NOT NULL DEFAULT '0',
  `item_id` bigint(20) NOT NULL DEFAULT '0',
  `branch_id` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`wrh_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
