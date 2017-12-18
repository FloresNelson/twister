-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2017 at 09:49 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `twister`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `POST_ID` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `content`, `date`, `POST_ID`, `USER_ID`) VALUES
(401, 'hola perri', '2017-11-27 11:45:50', 251, 351),
(651, 'wachoooo', '2017-11-27 17:52:20', 251, 351),
(851, 'alto bebem, se re parece a mauro', '2017-11-27 21:14:25', 801, 351),
(951, 'se lo hice yo, ah re', '2017-11-27 22:07:35', 801, 901),
(1001, 'mensaje en el ultimo post', '2017-12-03 19:58:32', 251, 351),
(1051, 'gdfgdfgdf', '2017-12-04 01:16:51', 602, 351),
(1052, 'fwefwef', '2017-12-04 01:16:55', 602, 351),
(1053, '7457u65u', '2017-12-04 01:17:01', 602, 351),
(1151, 'un comentario', '2017-12-04 20:25:55', 1101, 351),
(1651, 'muy buena foto!', '2017-12-17 17:32:27', 801, 1551),
(1652, 'que lindo bebe!', '2017-12-17 17:33:02', 1601, 101),
(2101, 'comenting', '2017-12-18 16:52:26', 1601, 351);

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `image`
--

INSERT INTO `image` (`id`, `path`, `size`, `type`) VALUES
(301, 'lh84j6cw2o', 16284, 'image/png'),
(451, '9gz7fm3jmr', 16284, 'image/png'),
(551, 'ltdzx4p1xh', 16284, 'image/png'),
(552, '9b0jlnj4nw', 24875, 'image/jpeg'),
(751, '5sbrtwbgs7', 38622, 'image/jpeg'),
(1201, 'gw0hl1844f', 63711, 'image/png'),
(1251, '0l5jcgo9tx', 63711, 'image/png'),
(1301, 'qmpqwq55ss', 63711, 'image/png'),
(1351, '45m62ibrta', 63711, 'image/png'),
(1451, 'k6dh6iydgr', 38622, 'image/jpeg'),
(1501, '1ryz60hcbs', 38622, 'image/jpeg'),
(1701, '4y3azj3cxj', 187016, 'image/png'),
(1751, 'pbrs2np0bf', 104150, 'image/jpeg'),
(1801, 'cfc31tm91q', 65070, 'image/jpeg'),
(1802, 'ywhzkwn1d5', 73888, 'image/jpeg'),
(1803, 'ctstjq55dw', 5746, 'image/jpeg'),
(1804, 'zfcwctbbrk', 14970, 'image/jpeg'),
(1851, '03z5bayqtd', 14970, 'image/jpeg'),
(1901, 'wram7njhm4', 14970, 'image/jpeg'),
(1902, '04qowj9wzz', 14970, 'image/jpeg'),
(1951, 'fgytw9prij', 14970, 'image/jpeg'),
(2001, 'kf2zfk3kzq', 73888, 'image/jpeg'),
(2051, 'p7667sk5d6', 85168, 'image/jpeg'),
(2052, 'ngg1e0b3gx', 14970, 'image/jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `openjpa_sequence_table`
--

CREATE TABLE `openjpa_sequence_table` (
  `ID` tinyint(4) NOT NULL,
  `SEQUENCE_VALUE` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `openjpa_sequence_table`
--

INSERT INTO `openjpa_sequence_table` (`ID`, `SEQUENCE_VALUE`) VALUES
(0, 2151);

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `IMAGE_ID` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`id`, `user_id`, `content`, `username`, `date`, `IMAGE_ID`) VALUES
(251, 101, 'mi primer post', NULL, '2017-11-27 11:43:19', NULL),
(252, 351, 'el post de flores', NULL, '2017-11-27 11:45:39', NULL),
(501, 351, 'sale ese post con imagen?', NULL, '2017-11-27 12:18:49', 451),
(601, 101, 'post de nelson con imagenes', NULL, '2017-11-27 12:32:00', 551),
(602, 101, 'un post de river', NULL, '2017-11-27 12:41:54', 552),
(801, 351, 'Un bebe en navidad <3', NULL, '2017-11-27 21:13:37', 751),
(1101, 351, 'post del 4 de diciembre', NULL, '2017-12-04 20:25:46', NULL),
(1102, 351, 'post con imagen del 4 de diciembre', NULL, '2017-12-04 20:26:09', 1201),
(1601, 1551, 'el primer post de ruben, sin imagen pero con mucha actitud (?)', NULL, '2017-12-17 16:53:59', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `post_likes`
--

CREATE TABLE `post_likes` (
  `post_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `IMAGE_ID` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`, `IMAGE_ID`) VALUES
(101, 'nelson', 'mail@nelsonflores.com.ar', '123456', 1351),
(351, 'Flores', 'flores@nelson.com', '654321', 2052),
(901, 'Nestor', 'nestor@enbloque.com', 'enbloque', NULL),
(1551, 'ruben', 'ruben@gmail.com', 'flores', 1501);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `I_COMMENT_POST` (`POST_ID`),
  ADD KEY `I_COMMENT_USER` (`USER_ID`);

--
-- Indexes for table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `openjpa_sequence_table`
--
ALTER TABLE `openjpa_sequence_table`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `post_likes`
--
ALTER TABLE `post_likes`
  ADD KEY `I_PST_LKS_ELEMENT` (`user_id`),
  ADD KEY `I_PST_LKS_POST_ID` (`post_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1602;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1552;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
