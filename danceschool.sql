-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 17 May 2024, 19:18:54
-- Sunucu sürümü: 10.4.32-MariaDB
-- PHP Sürümü: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `danceschool`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `admins`
--

CREATE TABLE `admins` (
  `ID` int(11) NOT NULL,
  `adminName` varchar(20) NOT NULL,
  `sifre` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `admins`
--

INSERT INTO `admins` (`ID`, `adminName`, `sifre`) VALUES
(1, 'Hilal', 123),
(2, 'Ali', 123);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `dancetypes`
--

CREATE TABLE `dancetypes` (
  `ID` int(11) NOT NULL,
  `danceName` varchar(20) NOT NULL,
  `danceTeacher` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `dancetypes`
--

INSERT INTO `dancetypes` (`ID`, `danceName`, `danceTeacher`) VALUES
(1, 'Tango', 'Tomina'),
(2, 'Salsa', 'Alex'),
(3, 'bale', 'Natalia'),
(4, 'modern dance', 'Isadora');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `teachers`
--

CREATE TABLE `teachers` (
  `ID` int(11) NOT NULL,
  `teacherName` varchar(20) NOT NULL,
  `password` int(50) DEFAULT NULL,
  `teacherExpert` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `teachers`
--

INSERT INTO `teachers` (`ID`, `teacherName`, `password`, `teacherExpert`) VALUES
(1, 'Tomina', 135, 'salsa'),
(2, 'Alex', 135, 'tango'),
(5, 'yasmin', 135, 'flemenko'),
(7, 'Isadora', 135, 'bale');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` int(50) DEFAULT NULL,
  `danceType` varchar(20) NOT NULL,
  `courseDate` date DEFAULT NULL,
  `courseTeacher` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `users`
--

INSERT INTO `users` (`ID`, `userName`, `password`, `danceType`, `courseDate`, `courseTeacher`) VALUES
(1, 'Emel', 1234, 'tango', '2024-05-14', 'Alex'),
(2, 'Esra', 1234, 'salsa', '2024-06-12', 'Tomina'),
(3, 'Ahmet', 1234, 'flemenko', '2024-05-24', 'yasmin'),
(5, 'derya', 1234, 'modern dance', '2024-07-01', 'ısadora'),
(10, 'elif', 1234, 'samba', NULL, 'tomino');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `dancetypes`
--
ALTER TABLE `dancetypes`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `admins`
--
ALTER TABLE `admins`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `dancetypes`
--
ALTER TABLE `dancetypes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `teachers`
--
ALTER TABLE `teachers`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Tablo için AUTO_INCREMENT değeri `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
