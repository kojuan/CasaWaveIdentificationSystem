-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2020 at 06:31 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `casawave_identification_system_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminspecialcode`
--

CREATE TABLE `adminspecialcode` (
  `id` int(100) DEFAULT NULL,
  `adminPassCodeNumber` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminspecialcode`
--

INSERT INTO `adminspecialcode` (`id`, `adminPassCodeNumber`) VALUES
(1, 41620),
(2, 51699),
(3, 91299),
(4, 60499);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `employeeId` int(255) NOT NULL,
  `firstName` varchar(200) NOT NULL,
  `middleInitial` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `employeeAddress` varchar(500) DEFAULT NULL,
  `employeeGender` varchar(50) NOT NULL,
  `DateOfBirth` date DEFAULT NULL,
  `employeeBloodType` varchar(20) DEFAULT NULL,
  `cellphoneNumber` varchar(15) DEFAULT NULL,
  `civilStatus` varchar(20) NOT NULL,
  `employeeReligion` varchar(30) NOT NULL,
  `employeeNationality` varchar(30) NOT NULL,
  `fatherEmailAddress` varchar(200) NOT NULL,
  `motherEmailAddress` varchar(200) NOT NULL,
  `dateAndTimeRegistered` varchar(200) DEFAULT NULL,
  `picture` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `id` int(255) NOT NULL,
  `FirstName` varchar(200) NOT NULL,
  `MiddleName` varchar(200) NOT NULL,
  `LastName` varchar(200) NOT NULL,
  `Gender` varchar(1020) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `BloodType` varchar(100) NOT NULL,
  `CivilStatus` varchar(100) NOT NULL,
  `Religion` varchar(100) NOT NULL,
  `Nationality` varchar(100) DEFAULT NULL,
  `CellphoneNumber` varchar(20) NOT NULL,
  `ImagePath` longblob DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(255) NOT NULL,
  `full_name` varchar(500) DEFAULT NULL,
  `usernameString` varchar(200) DEFAULT NULL,
  `passwordString` varchar(200) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  `gender` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employeeId`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `employeeId` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `patients`
--
ALTER TABLE `patients`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
