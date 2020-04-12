-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 11 Jan 2019 pada 05.48
-- Versi Server: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbbank`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbinfo`
--

CREATE TABLE `tbinfo` (
  `id_nsb` int(4) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jml_saldo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbinfo`
--

INSERT INTO `tbinfo` (`id_nsb`, `nama`, `jml_saldo`) VALUES
(1234, 'Ganis', '50000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbnasabah`
--

CREATE TABLE `tbnasabah` (
  `id_nsb` int(4) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbnasabah`
--

INSERT INTO `tbnasabah` (`id_nsb`, `nama`, `username`, `password`) VALUES
(8967, 'irey', 'Sisil', 'sisil');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbinfo`
--
ALTER TABLE `tbinfo`
  ADD PRIMARY KEY (`id_nsb`);

--
-- Indexes for table `tbnasabah`
--
ALTER TABLE `tbnasabah`
  ADD PRIMARY KEY (`id_nsb`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
