-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 17 Jul 2024 pada 14.42
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kamus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kamus`
--

CREATE TABLE `kamus` (
  `id` int(4) NOT NULL,
  `name` varchar(250) NOT NULL,
  `price` text NOT NULL,
  `date` date NOT NULL,
  `image` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kamus`
--

INSERT INTO `kamus` (`id`, `name`, `price`, `date`, `image`) VALUES
(36, 'Es Kristal Up', '7000', '2024-06-19', '6672c173120c3.jpg'),
(41, 'Ulla', '100000', '2024-07-08', '668aea0d6ee9b.jpg');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `kamus`
--
ALTER TABLE `kamus`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `kamus`
--
ALTER TABLE `kamus`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
