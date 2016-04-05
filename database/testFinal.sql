-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2015 at 08:32 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `testFinal`
--
CREATE DATABASE `testFinal` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `testFinal`;


CREATE TABLE IF NOT EXISTS `authors` (
  `AuthorId` bigint(20) NOT NULL AUTO_INCREMENT,
  `emailAddress` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `AuthorName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`AuthorId`),
  KEY `Authors_Names` (`AuthorName`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=38 ;

--
-- Dumping data for table `authors`
--

INSERT INTO `authors` (`AuthorId`, `emailAddress`, `AuthorName`) VALUES
(1, 'test1@example.com', 'Ana'),
(3, 'test2@example.com', 'Nicolas'),
(5, 'test3@example.com', 'Juan'),
(6, 'test4@example.com', 'Pedro'),
(7, 'test5@example.com', 'María'),
(8, 'test6@example.com', 'Carlos'),
(9, 'test7@example.com', 'Juan');
