-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 20, 2020 at 01:59 AM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
CREATE TABLE IF NOT EXISTS `application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `frais` int(11) NOT NULL,
  `type_payment` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nombre_mois_payer` int(11) NOT NULL,
  `etat` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `annee_scolaire` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `niveau_scolaire` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_rendezvous` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_A45BDDC165101B7F` (`id_rendezvous`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`id`, `nom`, `prenom`, `frais`, `type_payment`, `nombre_mois_payer`, `etat`, `annee_scolaire`, `niveau_scolaire`, `id_rendezvous`) VALUES
(5, 'habib', 'dridi', 3500, 'versement', 6, 'ACCEPTE', '2019/2020', '1er année', 2),
(13, 'dridi', 'hcini', 2000, 'versement', 3, 'ACCEPTE', '2019/2020', '2eme année', NULL),
(16, 'dridi', 'ali', 4890, 'versement', 3, 'ACCEPTE', '2019/2020', '3eme année', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` int(11) DEFAULT NULL,
  `Title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `author` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `imagebook` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `isbn` int(11) NOT NULL,
  `nbrbooks` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_CBE5A33164C19C1` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `category`, `Title`, `author`, `Description`, `imagebook`, `isbn`, `nbrbooks`) VALUES
(1, 1, 'book2', 'habib', 'bestbest', 'animewallpapercollection21920x1080-5e55bb7fdfd53.jpeg', 11111111, 4);

-- --------------------------------------------------------

--
-- Table structure for table `categorybook`
--

DROP TABLE IF EXISTS `categorybook`;
CREATE TABLE IF NOT EXISTS `categorybook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `categorybook`
--

INSERT INTO `categorybook` (`id`, `name`) VALUES
(1, 'heni');

-- --------------------------------------------------------

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
CREATE TABLE IF NOT EXISTS `classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `level` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idClassroom` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_2ED7EC5B5971BCB` (`idClassroom`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `classes`
--

INSERT INTO `classes` (`id`, `name`, `level`, `idClassroom`) VALUES
(1, '3a17', '2', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `classrooms`
--

DROP TABLE IF EXISTS `classrooms`;
CREATE TABLE IF NOT EXISTS `classrooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `capacity` int(11) NOT NULL,
  `bloc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `classrooms`
--

INSERT INTO `classrooms` (`id`, `name`, `capacity`, `bloc`) VALUES
(1, '24', 30, 'k');

-- --------------------------------------------------------

--
-- Table structure for table `club`
--

DROP TABLE IF EXISTS `club`;
CREATE TABLE IF NOT EXISTS `club` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `category` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `creationDate` datetime NOT NULL,
  `logo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `studentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_B8EE387298BF2F98` (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `club`
--

INSERT INTO `club` (`id`, `title`, `description`, `category`, `creationDate`, `logo`, `studentId`) VALUES
(1, 'tuniviboom', 'boom boom', 'Art', '2020-02-26 00:00:00', 'clubjardincollegelepesquier-5e55c0ec68a10.jpeg', NULL),
(2, 'club dance', 'dance and dance', 'Art', '2020-02-29 00:00:00', '95472full_cananyoneupscalethisto4kthankswallpapers-5e55bbe25e5f5.jpeg', NULL),
(3, 'basket', 'club sport', 'Art', '2020-02-28 00:00:00', 'istockphoto10636751041024x1024-5e55c0b4d4b5e.jpeg', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `complaints`
--

DROP TABLE IF EXISTS `complaints`;
CREATE TABLE IF NOT EXISTS `complaints` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime NOT NULL,
  `file` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `IdUser` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_A05AAF3AF9C28DE1` (`IdUser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `complaints`
--

INSERT INTO `complaints` (`id`, `title`, `content`, `date`, `file`, `email`, `IdUser`) VALUES
(1, 'note unix', 'note unix 7/20', '2020-02-25 13:09:59', NULL, 'mohamed@esprit.tn', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `equipement`
--

DROP TABLE IF EXISTS `equipement`;
CREATE TABLE IF NOT EXISTS `equipement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `category` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `qte` double NOT NULL,
  `qte_init` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `equipement`
--

INSERT INTO `equipement` (`id`, `label`, `category`, `qte`, `qte_init`) VALUES
(1, 'table', 'materiel', 24, 100);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
CREATE TABLE IF NOT EXISTS `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `startDate` datetime NOT NULL,
  `startHour` time NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `logo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idClub` int(11) DEFAULT NULL,
  `idClassroom` int(11) DEFAULT NULL,
  `searchkey` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_3BAE0AA7CB1366EC` (`idClub`),
  KEY `IDX_3BAE0AA7B5971BCB` (`idClassroom`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id`, `title`, `startDate`, `startHour`, `description`, `logo`, `idClub`, `idClassroom`, `searchkey`) VALUES
(1, 'espritbynight', '2020-03-11 00:00:00', '05:07:00', 'party all night', '84855773_621376781744662_8942232909406797824_n-5e45abfc3310f.png', NULL, 1, ''),
(2, 'nettoyage jardin', '2020-03-11 00:00:00', '08:00:00', 'party all day', '83162426_2730427777053771_78508136700313600_n-5e45ac31956d2.jpeg', 1, 1, 'jardin');

-- --------------------------------------------------------

--
-- Table structure for table `events_equipements`
--

DROP TABLE IF EXISTS `events_equipements`;
CREATE TABLE IF NOT EXISTS `events_equipements` (
  `event_id` int(11) NOT NULL,
  `equipement_id` int(11) NOT NULL,
  PRIMARY KEY (`event_id`,`equipement_id`),
  KEY `IDX_A568926871F7E88B` (`event_id`),
  KEY `IDX_A5689268806F0F5C` (`equipement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lessons`
--

DROP TABLE IF EXISTS `lessons`;
CREATE TABLE IF NOT EXISTS `lessons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_cours` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `admin` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_Module` int(11) DEFAULT NULL,
  `id_Teacher` int(11) DEFAULT NULL,
  `brochure_filename` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_3F4218D92DBF96F3` (`id_Module`),
  KEY `IDX_3F4218D9A1D63639` (`id_Teacher`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
CREATE TABLE IF NOT EXISTS `module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime DEFAULT NULL,
  `admin` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `coef_matiere` float NOT NULL,
  `niveau` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`id`, `title`, `description`, `date`, `admin`, `image_name`, `updated_at`, `coef_matiere`, `niveau`) VALUES
(1, 'math', 'mathematique de base', '2020-02-26 00:20:27', 'admin', '84701562_2677719339002843_4023865124870684672_n.jpg', '2020-02-26 00:20:27', 5, 3);

-- --------------------------------------------------------

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `id_eleve` int(11) NOT NULL,
  `id_matiere` int(11) NOT NULL,
  `note` float NOT NULL,
  `id_note` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_eleve`,`id_matiere`),
  UNIQUE KEY `note` (`id_note`),
  KEY `id_matiere` (`id_matiere`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `note`
--

INSERT INTO `note` (`id_eleve`, `id_matiere`, `note`, `id_note`) VALUES
(8, 1, 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
CREATE TABLE IF NOT EXISTS `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8_unicode_ci NOT NULL,
  `icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `route` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `route_parameters` longtext COLLATE utf8_unicode_ci COMMENT '(DC2Type:array)',
  `notification_date` datetime NOT NULL,
  `seen` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`id`, `title`, `description`, `icon`, `route`, `route_parameters`, `notification_date`, `seen`) VALUES
(1, 'Club Updated club dance', 'dance and dance', NULL, 'event_show', 'a:1:{s:2:\"id\";i:2;}', '2020-02-26 00:29:22', 0),
(2, 'Event kgku Created ', 'qdsdqsd', NULL, 'event_show', 'a:1:{s:2:\"id\";i:3;}', '2020-02-26 00:37:30', 0),
(3, 'Club Updated basket', 'club sport', NULL, 'event_show', 'a:1:{s:2:\"id\";i:3;}', '2020-02-26 00:49:56', 0),
(4, 'Event tuniviboom updated', 'boom boom', NULL, 'event_show', 'a:1:{s:2:\"id\";i:1;}', '2020-02-26 00:50:52', 0),
(5, 'Event  nettoyage jardin Updated ', 'party all day', NULL, 'event_show', 'a:1:{s:2:\"id\";i:2;}', '2020-02-26 00:51:51', 0);

-- --------------------------------------------------------

--
-- Table structure for table `rendezvous`
--

DROP TABLE IF EXISTS `rendezvous`;
CREATE TABLE IF NOT EXISTS `rendezvous` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cin` int(11) NOT NULL,
  `type` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `daterdv` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `heurerdv` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mail` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `etat` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17171774 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `rendezvous`
--

INSERT INTO `rendezvous` (`id`, `date`, `prenom`, `nom`, `cin`, `type`, `daterdv`, `heurerdv`, `mail`, `etat`) VALUES
(2, '2020-03-03 12:12:00', 'habib', 'dridi', 12243453, '', NULL, '', NULL, ''),
(17171738, '2020-03-23 00:00:00', 'm', 'm', 12, 'null', '2020-03-11', '', NULL, ''),
(17171739, '2020-03-23 00:00:00', 'm', 'm', 12, 'student', '2020-03-26', '', NULL, 'ACCEPTEE'),
(17171740, '2020-03-23 00:00:00', 'hbib', 'hbib', 12, 'student', '2020-03-24', '', NULL, 'REFUSEE'),
(17171741, '2020-03-23 00:00:00', 'bbbb', 'aaaa', 123, 'teacher', '2020-03-26', '', NULL, 'Non Traitee'),
(17171742, '2020-03-30 00:00:00', 'm', 'm', 2, 'student', '2020-04-01', 'heure', 'm', 'ACCEPTEE'),
(17171749, '2020-03-31 00:00:00', 'medhabib', 'dridi', 11410566, 'student', '2020-03-13', 'NULL', 'Mohamed@esprit.tn', 'REFUSEE'),
(17171750, '2020-03-31 00:00:00', 'medhabib', 'dridi', 11410566, 'student', '2020-03-13', 'NULL', 'Mohamed@esprit.tn', 'REFUSEE'),
(17171751, '2020-03-31 00:00:00', 'medhabib', 'dridif', 11410566, 'student', '2020-03-13', 'NULL', 'Mohamed@esprit.tn', 'REFUSEE'),
(17171752, '2020-03-31 00:00:00', 'medhabib', 'dridif', 11410566, 'student', '2020-03-13', 'NULL', 'Mohamed@esprit.tn', 'REFUSEE'),
(17171768, '2020-04-05 00:00:00', 'iam', 'test', 4444, 'student', '2020-04-03', '13:23', 'test11@gmail.com', 'REFUSEE'),
(17171769, '2020-04-05 00:00:00', 'iam', 'test', 4444, 'student', '2020-04-03', '13:23', 'test11@gmail.com', 'REFUSEE'),
(17171770, '2020-04-05 00:00:00', 'iam', 'test', 4444, 'student', '2020-04-03', '13:23', 'test11@gmail.com', 'REFUSEE'),
(17171771, '2020-04-05 00:00:00', 'iam', 'test', 4444, 'student', '2020-04-03', '13:23', 'test11@gmail.com', 'REFUSEE'),
(17171772, '2020-04-05 00:00:00', 'fg', 'gf', 543, 'teacher', '2020-04-01', '12:04', 'h@h.th', 'Non Traitee'),
(17171773, '2020-04-05 00:00:00', 'khaoula', 'khmiri', 8888, 'student', '2020-04-10', '22:27', 'khaoula3@gmail.com', 'ACCEPTEE');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `booktitle` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datereservation` date NOT NULL,
  `datereturn` date NOT NULL,
  `state` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `message` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `studentkey` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `schoolmeeting`
--

DROP TABLE IF EXISTS `schoolmeeting`;
CREATE TABLE IF NOT EXISTS `schoolmeeting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `startsDate` date NOT NULL,
  `subject` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `concerned` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `schoolmeeting`
--

INSERT INTO `schoolmeeting` (`id`, `date`, `startsDate`, `subject`, `concerned`, `type`) VALUES
(1, '2015-01-01 00:00:00', '2020-02-01', 'pi', 'dernier validation', 'validation');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci COMMENT '(DC2Type:array)',
  `type` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `idClass` int(11) DEFAULT NULL,
  `fistname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  `phoneNumber` int(11) DEFAULT NULL,
  `profilePicture` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `frais` int(11) DEFAULT NULL,
  `type_payement` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nbr_mois_payer` int(11) DEFAULT NULL,
  `annee_scolaire` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `niveau` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idrdv` int(250) DEFAULT '0',
  `etat` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birth` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adresse` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_8D93D64992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_8D93D649A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_8D93D649C05FB297` (`confirmation_token`),
  KEY `type_idx` (`type`),
  KEY `IDX_8D93D649FA8F5A82` (`idClass`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `type`, `idClass`, `fistname`, `lastname`, `birthDate`, `phoneNumber`, `profilePicture`, `frais`, `type_payement`, `nbr_mois_payer`, `annee_scolaire`, `niveau`, `idrdv`, `etat`, `birth`, `adresse`) VALUES
(4, 'admin', 'admin', 'mohamedhabib.dridi@esprit.tn', 'mohamedhabib.dridi@esprit.tn', 1, NULL, '$2y$13$ZVdC9hOFoXlZDsZ9ZwTIaODLTop7Rn5v/1ZiqIA86SyEDfihJWQy2', '2020-03-20 13:08:28', NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_ADMIN\";}', 'User', NULL, 'la', 'ra', '0000-00-00', 0, '', 0, '', NULL, NULL, NULL, NULL, NULL, '', NULL),
(5, 'habib', 'habib', 'm@g.tn', 'm@g.tn', 1, NULL, 'yes', '2020-02-10 22:17:06', NULL, NULL, 'a:0:{}', 'User', NULL, 'mi', 'mi', '0000-00-00', 0, '', 0, '', NULL, NULL, NULL, NULL, 'ACCEPTEE', '', NULL),
(7, 'ali', 'ali', 'heni1@esprit.tn', 'heni1@esprit.tn', 1, NULL, '$2y$13$y0dJ7yIuzunOESi0Y5EiQOzS6vzzW4QVNM2ysRtNVL2giAeDxkKem', '2020-02-13 19:47:44', NULL, NULL, 'a:1:{i:0;s:10:\"ROLE_TEACHER\";}', 'Teacher', NULL, 'do', 're', NULL, 2233, NULL, 0, '', NULL, NULL, NULL, NULL, NULL, '', 'ariana'),
(8, 'ali2', 'ali2', 'm2@g.tn', 'm2@g.tn', 1, NULL, 'yes', '2020-02-13 21:24:55', NULL, NULL, 'a:1:{i:0;s:12:\"ROLE_STUDENT\";}', 'Student', 1, 'Ali', 'Bekir', NULL, 11, NULL, 0, 'cheque', 3, '2019-2020', '2eme', NULL, 'ACCEPTEE', '', 'ghazela'),
(9, 'feres', 'feres', 'f@gmail.com', 'f@gmail.com', 1, NULL, 'hey', '2020-02-23 12:09:57', NULL, NULL, 'a:1:{i:0;s:12:\"ROLE_STUDENT\";}', 'Student', 1, 'habib', 'dridi', NULL, 123355, 'src/projetjava/images/f@gmail.com.jpg', 0, 'espece', 6, '2019-2020', '3eme', NULL, 'ACCEPTEE', '2020-04-10', 'bizerte'),
(10, 'teacher', 'teacher', 'teacher@gmail.com', 'teacher@gmail.com', 1, NULL, 'meriam', '2020-02-25 19:30:20', NULL, NULL, 'a:1:{i:0;s:12:\"ROLE_TEACHER\";}', 'Teacher', NULL, 'meriam', 'meriam', NULL, 22222222, 'src/projetjava/images/teacher@gmail.com.jpg', 0, '', NULL, NULL, NULL, NULL, 'ACCEPTEE', '16-08-1998', 'bizerte'),
(11, 'm_m', NULL, 'm', NULL, NULL, NULL, '2', NULL, NULL, NULL, NULL, 'Student', NULL, 'j', 'm', NULL, 2, 'src/projetjava/images/student.png', 2, 'Espece', 9, '1', '1ere', 2, 'ACCEPTEE', '2020-03-04', 'Monastir'),
(12, 'bekir_ali', NULL, 'ali@gmail.com', NULL, NULL, NULL, '234353', NULL, NULL, NULL, NULL, 'Student', NULL, 'ali', 'beki', NULL, 2585029, 'src/projetjava/images/student.png', 300, 'Cheque', 6, '2012', '4eme', 234353, 'ACCEPTEE', '2020-03-11', 'null'),
(13, 'moussa_issam', NULL, 'Issam@gmail.com', NULL, NULL, NULL, '1234567', NULL, NULL, NULL, NULL, 'Teacher', NULL, 'issam', 'moussa', NULL, 25850529, 'src/projetjava/images/teacher.png', NULL, NULL, NULL, NULL, NULL, 1234567, 'ACCEPTEE', '2020-03-12', 'Gafsa'),
(14, 'camille_george', NULL, 'camille@g.com', NULL, NULL, NULL, '12345678', NULL, NULL, NULL, NULL, 'Teacher', NULL, 'george', 'camille', NULL, 22222222, 'src/projetjava/images/teacher.png', NULL, NULL, NULL, NULL, NULL, 12345678, 'ACCEPTEE', '2020-03-18', 'Ariana'),
(15, 'lilia_aziza', NULL, 'lilia@g.com', NULL, NULL, NULL, '78945612', NULL, NULL, NULL, NULL, 'Student', NULL, 'aziza', 'lilia', NULL, 22222222, 'src/projetjava/images/student.png', 200, 'Cheque', 6, '2020', '3eme', 78945612, 'ACCEPTEE', '2020-03-18', 'Ariana'),
(16, 'dridi_medabib', NULL, 'mohamedhabib@esprit.tn', NULL, NULL, NULL, '1111', NULL, NULL, NULL, NULL, 'Student', NULL, 'medabib', 'dridi', NULL, 25850529, 'src/projetjava/images/mohamedhabib@esprit.tn.jpg', 450, 'Espece', 6, '3eme', '2020/21021', 1111, 'REFUSEE', '2020-04-17', 'Bizerte'),
(17, 'kafia_adem', NULL, 'adem@esprit.tn', NULL, NULL, NULL, '12345', NULL, NULL, NULL, NULL, 'Student', NULL, 'adem', 'kafia', NULL, 2588888, 'src/projetjava/images/student.png', 3000, 'Cheque', 3, '2012', '2eme', 0, 'REFUSEE', '2020-04-09', 'Zaghouan'),
(18, 'khmiri_khaoula', NULL, 'khaoula3@gmail.com', NULL, NULL, NULL, '8888', NULL, NULL, NULL, NULL, 'Student', NULL, 'khaoula', 'khmiri', NULL, 505050, 'src/projetjava/images/student.png', 6000, 'Espece', 3, '3EME', '2020', 8888, 'ACCEPTEE', '2020-04-24', 'Ariana');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `FK_A45BDDC165101B7F` FOREIGN KEY (`id_rendezvous`) REFERENCES `rendezvous` (`id`);

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FK_CBE5A33164C19C1` FOREIGN KEY (`category`) REFERENCES `categorybook` (`id`);

--
-- Constraints for table `classes`
--
ALTER TABLE `classes`
  ADD CONSTRAINT `FK_2ED7EC5B5971BCB` FOREIGN KEY (`idClassroom`) REFERENCES `classrooms` (`id`);

--
-- Constraints for table `club`
--
ALTER TABLE `club`
  ADD CONSTRAINT `FK_B8EE387298BF2F98` FOREIGN KEY (`studentId`) REFERENCES `user` (`id`);

--
-- Constraints for table `complaints`
--
ALTER TABLE `complaints`
  ADD CONSTRAINT `FK_A05AAF3AF9C28DE1` FOREIGN KEY (`IdUser`) REFERENCES `user` (`id`);

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `FK_3BAE0AA7B5971BCB` FOREIGN KEY (`idClassroom`) REFERENCES `classrooms` (`id`),
  ADD CONSTRAINT `FK_3BAE0AA7CB1366EC` FOREIGN KEY (`idClub`) REFERENCES `club` (`id`);

--
-- Constraints for table `events_equipements`
--
ALTER TABLE `events_equipements`
  ADD CONSTRAINT `FK_A568926871F7E88B` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_A5689268806F0F5C` FOREIGN KEY (`equipement_id`) REFERENCES `equipement` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `lessons`
--
ALTER TABLE `lessons`
  ADD CONSTRAINT `FK_3F4218D92DBF96F3` FOREIGN KEY (`id_Module`) REFERENCES `module` (`id`),
  ADD CONSTRAINT `FK_3F4218D9A1D63639` FOREIGN KEY (`id_Teacher`) REFERENCES `user` (`id`);

--
-- Constraints for table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `id_eleve` FOREIGN KEY (`id_eleve`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `id_matiere` FOREIGN KEY (`id_matiere`) REFERENCES `module` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_8D93D649FA8F5A82` FOREIGN KEY (`idClass`) REFERENCES `classes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
