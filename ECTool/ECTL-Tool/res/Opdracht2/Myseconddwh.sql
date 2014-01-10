-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Machine: localhost
-- Genereertijd: 13 Dec 2010 om 13:06
-- Serverversie: 5.1.41
-- PHP-Versie: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `mythirddwh`
--

CREATE DATABASE IF NOT EXISTS `myseconddwh` ;
USE `myseconddwh` ;

--
-- Tabelstructuur voor tabel `klant`
--

CREATE TABLE IF NOT EXISTS `klant` (
  `KlantNummer` int(8) NOT NULL COMMENT 'Klantnummer is een maximaal 8 cijfers lang nummer.',
  `KlantNaam` varchar(32) NOT NULL,
  `Telefoon` varchar(16) NOT NULL,
  `Mobiel` varchar(16) DEFAULT NULL,
  `Plaats` varchar(16) NOT NULL,
  `Land` enum('België','Deutschland','France','Nederland','Polska','United Kingdom') NOT NULL DEFAULT 'Nederland',
  `Percentage` int(2) NOT NULL DEFAULT '5' COMMENT 'Percentage is een korting tussen 0 en 99.',
  `SnapShotDatum` date NOT NULL COMMENT 'Datum van extractie',
  `SnapShotTijd` time NOT NULL DEFAULT '23:00:00' COMMENT 'Tijd van extractie',
  PRIMARY KEY (`KlantNummer`,`SnapShotDatum`,`SnapShotTijd`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Gegevens worden uitgevoerd voor tabel `klant`
--