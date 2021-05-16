-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2021 at 03:15 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlythuvien`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`username`, `password`) VALUES
('admin', 'admin'),
('nhanvien', 'nhanvien');

-- --------------------------------------------------------

--
-- Table structure for table `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `MaNXB` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenNXB` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`MaNXB`, `TenNXB`) VALUES
('NXB-1', 'Nhà xuất bản Tổng hợp'),
('NXB-2', 'Nhà xuất bản Trẻ'),
('NXB-3', 'Nhà xuất bản văn hoá - nghệ thuật');

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `MaSach` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenSach` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MaTL` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaTG` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `MaNXB` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `NamXuatBan` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MaSach`, `TenSach`, `MaTL`, `MaTG`, `MaNXB`, `NamXuatBan`, `SoLuong`, `DonGia`) VALUES
('1', '1', 'TL-3', 'TG-2', 'NXB-1', 1, 1, 1),
('2', '2', 'TL-1', 'TG-1', 'NXB-1', 2, 2, 2),
('3', '3', 'TL-1', 'TG-1', 'NXB-1', 3, 3, 3),
('MS-2', 'Số Đỏ', 'TL-2', 'TG-2', 'NXB-3', 1999, 4, 80000),
('MS-3', 'Hoàng Tử Bé', 'TL-1', 'TG-1', 'NXB-2', 1998, 5, 45000);

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE `tacgia` (
  `MaTG` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenTG` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`MaTG`, `TenTG`) VALUES
('TG-1', 'Antoine'),
('TG-2', 'Vũ Trọng Phụng'),
('TG-3', 'Hồng Nương Tử');

-- --------------------------------------------------------

--
-- Table structure for table `theloai`
--

CREATE TABLE `theloai` (
  `MaTL` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TenTL` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`MaTL`, `TenTL`) VALUES
('TL-1', 'Thiếu nhi'),
('TL-2', 'Văn học nghệ thuật'),
('TL-3', 'Tiểu thuyết');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`MaNXB`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`MaSach`),
  ADD KEY `MaTL` (`MaTL`),
  ADD KEY `MaTG` (`MaTG`),
  ADD KEY `MaNXB` (`MaNXB`);

--
-- Indexes for table `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`MaTG`);

--
-- Indexes for table `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`MaTL`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `sach_ibfk_1` FOREIGN KEY (`MaTG`) REFERENCES `tacgia` (`MaTG`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sach_ibfk_2` FOREIGN KEY (`MaTL`) REFERENCES `theloai` (`MaTL`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sach_ibfk_3` FOREIGN KEY (`MaNXB`) REFERENCES `nhaxuatban` (`MaNXB`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
