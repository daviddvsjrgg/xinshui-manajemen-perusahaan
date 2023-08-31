-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2022 at 10:23 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `xinshui_db`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `laporanAdmin` ()   BEGIN 
SELECT IDADMIN, NAMAADMIN, gaji.GAJIPOKOK, HAKAKSESADMIN from admin INNER JOIN gaji ON admin.IDGAJI = gaji.IDGAJI ORDER BY HAKAKSESADMIN DESC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `laporanBar` ()   BEGIN 
SELECT IDBARANG, namaperusahaan.NAMAPERUSAHAAN, detailmerek.NAMAMEREK, NAMABARANG, HARGABARANG, JUMLAHBARANG FROM barang INNER JOIN detailmerek ON barang.IDMEREK = detailmerek.IDMEREK INNER JOIN namaperusahaan ON detailmerek.IDPERUSAHAAN = namaperusahaan.IDPERUSAHAAN ORDER BY barang.IDBARANG;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `laporanKar` ()   BEGIN 
SELECT IDKARYAWAN, NAMAKARYAWAN, jabatan.NAMAJABATAN, UMURKARYAWAN, ALAMATKARYAWAN, TGLMASUK FROM karyawan INNER JOIN jabatan on karyawan.IDJABATAN = jabatan.IDJABATAN ORDER BY IDKARYAWAN ASC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `laporanKaryawanAkhir` ()   BEGIN 
SELECT karyawan.IDKARYAWAN, NAMAKARYAWAN, jabatan.NAMAJABATAN, gaji.GAJIPOKOK, jabatan.TUNJANGANJABATAN, (gaji.GAJIPOKOK+jabatan.TUNJANGANJABATAN) as GAJI FROM karyawan INNER JOIN jabatan on karyawan.IDJABATAN = jabatan.IDJABATAN INNER JOIN gaji on karyawan.IDGAJI = gaji.IDGAJI ORDER BY IDKARYAWAN ASC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `laporanPenjualanAkhir` ()   BEGIN 
SELECT  NAMAPELANGGAN, NAMABARANGPELANGGAN, HARGABARANGPELANGGAN, JUMLAHBARANGPELANGGAN, (HARGABARANGPELANGGAN*JUMLAHBARANGPELANGGAN) as Total FROM pelanggan;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `perusahaanComboBox` ()   BEGIN 
SELECT * FROM namaperusahaan WHERE NAMAPERUSAHAAN NOT REGEXP '^.*Tidak Ada.*$';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tampilAdmin` ()   BEGIN 
SELECT IDADMIN, NAMAADMIN, gaji.GAJIPOKOK, HAKAKSESADMIN from admin INNER JOIN gaji ON admin.IDGAJI = gaji.IDGAJI ORDER BY HAKAKSESADMIN DESC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tampilBarang` ()   BEGIN 
SELECT IDBARANG, namaperusahaan.NAMAPERUSAHAAN, detailmerek.NAMAMEREK, NAMABARANG, HARGABARANG, JUMLAHBARANG FROM barang INNER JOIN detailmerek ON barang.IDMEREK = detailmerek.IDMEREK INNER JOIN namaperusahaan ON detailmerek.IDPERUSAHAAN = namaperusahaan.IDPERUSAHAAN ORDER BY barang.IDBARANG;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tampilDetailMerek` ()   BEGIN 
SELECT * FROM detailmerek;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tampilGaji` ()   BEGIN 
SELECT * FROM gaji;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tampilJabatan` ()   BEGIN 
select * FROM jabatan;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tampilKaryawan` ()   BEGIN 
SELECT NAMAKARYAWAN, jabatan.NAMAJABATAN, UMURKARYAWAN, ALAMATKARYAWAN, TGLMASUK, IDKARYAWAN FROM karyawan INNER JOIN jabatan on karyawan.IDJABATAN = jabatan.IDJABATAN ORDER BY IDKARYAWAN ASC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tampilPembayaran` ()   BEGIN 
SELECT * FROM tipepembayaran;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tampilPerusahaan` ()   BEGIN 
SELECT * FROM namaperusahaan WHERE NAMAPERUSAHAAN NOT REGEXP '^.*Tidak Ada.*$';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tampilTim` ()   BEGIN 
SELECT IDTIM, namaperusahaan.NAMAPERUSAHAAN, NAMATIM, TUGASTIM FROM namatim INNER JOIN namaperusahaan ON namatim.IDPERUSAHAAN= namaperusahaan.IDPERUSAHAAN WHERE NAMAPERUSAHAAN NOT REGEXP '^.*Tidak Ada.*$';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tampilTipePembayaran` ()   BEGIN 
select * from tipepembayaran;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `IDADMIN` varchar(30) NOT NULL,
  `IDGAJI` int(11) NOT NULL,
  `NAMAADMIN` varchar(40) DEFAULT NULL,
  `PASSWORDADMIN` varchar(255) DEFAULT NULL,
  `HAKAKSESADMIN` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`IDADMIN`, `IDGAJI`, `NAMAADMIN`, `PASSWORDADMIN`, `HAKAKSESADMIN`) VALUES
('1', 4, 'Ujang', 'ed84089fcb1b864597cf6dc504859d1d', 'Super Admin'),
('121232', 1, 'oki', '362ff22369995c27f7d6b7d9fb61e48f', 'Admin'),
('2', 3, 'Chelsy', 'ba6f9a496067e779635f913c3f2fed61', 'Admin'),
('3', 2, 'David', '55fc5b709962876903785fd64a6961e5', 'Admin'),
('4', 4, 'Albert', '73503e6f479c632ebfebc6e58a3cd335', 'Super Admin'),
('5', 1, 'Virla', '667af1dd49959c680c8c61a02a3f5943', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `IDBARANG` varchar(30) NOT NULL,
  `IDMEREK` varchar(30) NOT NULL,
  `NAMABARANG` varchar(40) DEFAULT NULL,
  `HARGABARANG` decimal(15,0) DEFAULT NULL,
  `JUMLAHBARANG` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`IDBARANG`, `IDMEREK`, `NAMABARANG`, `HARGABARANG`, `JUMLAHBARANG`) VALUES
('1', '1', 'Iphone 14 Pro', '14000000', 22),
('10', '1', 'Iphone 11', '12000000', 55),
('11', '1', 'Iphone SE', '10000000', 20),
('12', '3', 'Samsung Galaxy', '4500000', 18),
('13', '4', 'Honda Brio', '190000000', 10),
('14', '9', 'Es Teh Jumbo', '7500', 150),
('2', '2', 'Macbook M2 Pro', '4250000', 28),
('3', '3', 'Samsung Galaxy Z Flip4', '1520000', 25),
('4', '4', 'Honda Civic', '580000000', 8),
('5', '5', 'Honda Vario 125', '22500000', 15),
('6', '6', 'Indomie Goreng Aceh', '3500', 265),
('7', '7', 'Sarimi Soto', '3000', 250),
('8', '8', 'Chitato Lite BBQ', '13500', 500),
('9', '9', 'Nasi Goreng Bangla', '12500', 100);

-- --------------------------------------------------------

--
-- Table structure for table `daftarhadir`
--

CREATE TABLE `daftarhadir` (
  `IDDAFTARHADIR` int(11) NOT NULL,
  `IDKARYAWAN` varchar(30) DEFAULT NULL,
  `TGLHADIR` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `daftarhadir`
--

INSERT INTO `daftarhadir` (`IDDAFTARHADIR`, `IDKARYAWAN`, `TGLHADIR`) VALUES
(1, 'A1', '2022-12-17 21:13:04'),
(2, 'A2', '2022-12-17 21:13:56'),
(3, 'A1', '2022-12-16 21:15:13');

-- --------------------------------------------------------

--
-- Table structure for table `detailgaji`
--

CREATE TABLE `detailgaji` (
  `IDDETAILGAJI` int(11) NOT NULL,
  `IDKARYAWAN` varchar(30) DEFAULT NULL,
  `IDADMIN` varchar(30) NOT NULL,
  `LAMAKERJA` int(11) DEFAULT NULL,
  `HASILAKHIR` decimal(15,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `detailmerek`
--

CREATE TABLE `detailmerek` (
  `IDMEREK` varchar(30) NOT NULL,
  `IDPERUSAHAAN` varchar(30) NOT NULL,
  `NAMAMEREK` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detailmerek`
--

INSERT INTO `detailmerek` (`IDMEREK`, `IDPERUSAHAAN`, `NAMAMEREK`) VALUES
('1', '1', 'Iphone'),
('2', '1', 'MacBook'),
('3', '2', 'Samsung HP'),
('4', '3', 'Honda Mobil'),
('5', '3', 'Honda Motor'),
('6', '4', 'Indomie'),
('7', '4', 'Sarimi'),
('8', '4', 'Chitato Lite'),
('9', '5', 'Makanan');

-- --------------------------------------------------------

--
-- Table structure for table `detailpenjualan`
--

CREATE TABLE `detailpenjualan` (
  `IDPENJUALAN` varchar(30) NOT NULL,
  `IDPELANGGAN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `gaji`
--

CREATE TABLE `gaji` (
  `IDGAJI` int(11) NOT NULL,
  `GAJIPOKOK` decimal(15,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gaji`
--

INSERT INTO `gaji` (`IDGAJI`, `GAJIPOKOK`) VALUES
(1, '4500000'),
(2, '1650000'),
(3, '7000000'),
(4, '9500000');

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `IDJABATAN` int(11) NOT NULL,
  `NAMAJABATAN` varchar(30) DEFAULT NULL,
  `TUNJANGANJABATAN` decimal(15,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`IDJABATAN`, `NAMAJABATAN`, `TUNJANGANJABATAN`) VALUES
(1, 'CEO', '6000000'),
(2, 'HRD', '4000000'),
(3, 'Manajer Produk', '2500000'),
(4, 'Manajer Penjualan', '2400000'),
(5, 'Karyawan', '0'),
(6, 'Magang', '0'),
(7, 'Satpam', '150000');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `IDKARYAWAN` varchar(30) NOT NULL,
  `IDGAJI` int(11) NOT NULL,
  `IDJABATAN` int(11) NOT NULL,
  `IDTIM` varchar(30) DEFAULT NULL,
  `NAMAKARYAWAN` varchar(40) DEFAULT NULL,
  `UMURKARYAWAN` int(11) DEFAULT NULL,
  `ALAMATKARYAWAN` text DEFAULT NULL,
  `TELPKARYAWAN` varchar(30) DEFAULT NULL,
  `STATUSKARYAWAN` varchar(30) DEFAULT NULL,
  `USERKARYAWAN` varchar(40) DEFAULT NULL,
  `PASSWORDKARYAWAN` varchar(255) DEFAULT NULL,
  `HAKAKSESKARYAWAN` varchar(30) DEFAULT NULL,
  `TGLMASUK` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`IDKARYAWAN`, `IDGAJI`, `IDJABATAN`, `IDTIM`, `NAMAKARYAWAN`, `UMURKARYAWAN`, `ALAMATKARYAWAN`, `TELPKARYAWAN`, `STATUSKARYAWAN`, `USERKARYAWAN`, `PASSWORDKARYAWAN`, `HAKAKSESKARYAWAN`, `TGLMASUK`) VALUES
('A1', 1, 1, '0', 'Albert Evando Wangsajaya', 20, 'Tulungagung', '0812328312382', 'Aktif', 'albert123', '73503e6f479c632ebfebc6e58a3cd335', 'Karyawan Tetap', '2019-12-11'),
('A2', 1, 2, '0', 'David Dwiyanto', 20, 'Sidoarjo', '08999218382', 'Aktif', 'david123', '55fc5b709962876903785fd64a6961e5', 'Karyawan Tetap', '2021-12-15'),
('A3', 1, 3, '0', 'Zuhriah Virlani Putri', 24, 'Mojokerto', '0821237882341', 'Aktif', 'nala123', 'f777f88e42889bec7cc5f387df3924ea', 'Karyawan Tetap', '2022-06-09'),
('A4', 1, 4, '0', 'Aiman', 21, 'Madura', '08192381723', 'Aktif', 'aiman123', '130641d82f06e6780f477eac047dbd6a', 'Karyawan Tetap', '2022-06-07'),
('A5', 1, 5, '1', 'Zary Cecelya', 20, 'Surabaya', '0892381232', 'Aktif', 'zary123', '58a15b53e4e6fa60af26f8830715d757', 'Karyawan Tetap', '2022-10-19'),
('A6', 1, 5, '2', 'John Doe', 25, 'Surabaya', '0892137272', 'Aktif', 'john123', '6e0b7076126a29d5dfcbd54835387b7b', 'Karyawan Tetap', '2022-11-16'),
('A7', 1, 5, '3', 'Jenna', 18, 'Makassar', '08123718451', 'Aktif', 'jenna123', 'd6fccb22386f06d11d557f3a35ab3b27', 'Karyawan Tetap', '2022-10-13'),
('A8', 1, 5, '4', 'Ortega', 18, 'Jombang', '081237812832', 'Aktif', 'orte123', 'a53c0ef87b4bb55a3757c6a422144aa4', 'Karyawan Tetap', '2022-11-01'),
('A9', 2, 6, '3', 'Shinta', 17, 'Sidoarjo', '089212312', 'Aktif', 'shin123', 'e3a93ca5b9c8954839801fa8b8d1fc87', 'Magang', '2022-12-01'),
('B1', 2, 6, '4', 'Rosi', 21, 'Surabaya', '0891238123124', 'Aktif', 'rosi123', '4de3bb737dfb9522dce0f9e7b35d50b1', 'Magang', '2022-12-04');

-- --------------------------------------------------------

--
-- Table structure for table `laporankeuangan`
--

CREATE TABLE `laporankeuangan` (
  `IDLAPORAN` varchar(30) NOT NULL,
  `IDPENJUALAN` varchar(30) NOT NULL,
  `IDDETAILGAJI` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `namaperusahaan`
--

CREATE TABLE `namaperusahaan` (
  `IDPERUSAHAAN` varchar(30) NOT NULL,
  `NAMAPERUSAHAAN` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `namaperusahaan`
--

INSERT INTO `namaperusahaan` (`IDPERUSAHAAN`, `NAMAPERUSAHAAN`) VALUES
('0', 'Tidak Ada'),
('1', 'Apple'),
('2', 'Samsung'),
('3', 'Honda'),
('4', 'Indofood'),
('5', 'Super');

-- --------------------------------------------------------

--
-- Table structure for table `namatim`
--

CREATE TABLE `namatim` (
  `IDTIM` varchar(30) NOT NULL,
  `IDPERUSAHAAN` varchar(30) NOT NULL,
  `NAMATIM` varchar(30) DEFAULT NULL,
  `TUGASTIM` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `namatim`
--

INSERT INTO `namatim` (`IDTIM`, `IDPERUSAHAAN`, `NAMATIM`, `TUGASTIM`) VALUES
('0', '0', 'Tidak Ada', 'Tidak Ada'),
('1', '1', 'Tim AWS', 'Mendata Barang'),
('2', '2', 'Tim Cloud', 'Mendata Barang'),
('3', '3', 'Tim GAS', 'Mendata Pelanggan'),
('4', '4', 'Tim LOKI', 'Mendata Barang'),
('5', '5', 'Tim SUPER', 'Mendata Pelanggan');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `IDPELANGGAN` int(11) NOT NULL,
  `IDPEMBAYARAN` varchar(30) DEFAULT NULL,
  `IDBARANG` varchar(30) NOT NULL,
  `NAMAPELANGGAN` varchar(40) DEFAULT NULL,
  `NAMABARANGPELANGGAN` varchar(30) DEFAULT NULL,
  `HARGABARANGPELANGGAN` decimal(15,0) DEFAULT NULL,
  `JUMLAHBARANGPELANGGAN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`IDPELANGGAN`, `IDPEMBAYARAN`, `IDBARANG`, `NAMAPELANGGAN`, `NAMABARANGPELANGGAN`, `HARGABARANGPELANGGAN`, `JUMLAHBARANGPELANGGAN`) VALUES
(1, '1', '2', 'Pranama Adi', 'Macbook M2 Pro', '4250000', 1),
(2, '3', '4', 'Ali bin Kratos', 'Honda Civic', '58000000', 1),
(11, '1', '1', 'Perncis', 'Iphone 14 Pro', '14000000', 2),
(2254838, '2', '2', 'Mazda Rs', 'Macbook M2 Pro', '4250000', 2),
(4206367, '1', '7', 'Riskzi', 'Sarimi Soto', '3000', 15),
(4620509, '2', '7', 'Risk', 'Sarimi Soto', '3000', 55),
(7106175, '3', '1', 'Reza', 'Iphone 14 Pro', '14000000', 3),
(7640117, '3', '4', 'Ujang', 'Honda Brio', '190000000', 3);

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `IDPEMBAYARAN` varchar(30) NOT NULL,
  `IDSTATUS` int(11) NOT NULL,
  `NOKARTU` varchar(30) DEFAULT NULL,
  `NOPIN` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`IDPEMBAYARAN`, `IDSTATUS`, `NOKARTU`, `NOPIN`) VALUES
('1', 1, '11223344', '123456'),
('2', 2, '22113344', '098765'),
('3', 3, '0812381232', '102938');

-- --------------------------------------------------------

--
-- Table structure for table `tipepembayaran`
--

CREATE TABLE `tipepembayaran` (
  `IDSTATUS` int(11) NOT NULL,
  `NAMAPEMBAYARAN` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tipepembayaran`
--

INSERT INTO `tipepembayaran` (`IDSTATUS`, `NAMAPEMBAYARAN`) VALUES
(1, 'BCA'),
(2, 'BNI'),
(3, 'Dana');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`IDADMIN`),
  ADD KEY `FK_ADMIN_MEMPUNYAI_GAJI` (`IDGAJI`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`IDBARANG`),
  ADD KEY `FK_BARANG_MEMILIKI3_DETAILME` (`IDMEREK`);

--
-- Indexes for table `daftarhadir`
--
ALTER TABLE `daftarhadir`
  ADD PRIMARY KEY (`IDDAFTARHADIR`),
  ADD KEY `FK_DAFTARHA_MEMILIKI2_KARYAWAN` (`IDKARYAWAN`);

--
-- Indexes for table `detailgaji`
--
ALTER TABLE `detailgaji`
  ADD PRIMARY KEY (`IDDETAILGAJI`),
  ADD UNIQUE KEY `IDADMIN` (`IDADMIN`),
  ADD KEY `FK_DETAILGA_MENDAPAT1_KARYAWAN` (`IDKARYAWAN`);

--
-- Indexes for table `detailmerek`
--
ALTER TABLE `detailmerek`
  ADD PRIMARY KEY (`IDMEREK`),
  ADD KEY `FK_DETAILME_MEMEGANG_NAMAPERU` (`IDPERUSAHAAN`);

--
-- Indexes for table `detailpenjualan`
--
ALTER TABLE `detailpenjualan`
  ADD PRIMARY KEY (`IDPENJUALAN`),
  ADD KEY `FK_DETAILPE_MENDAPAT2_PELANGGA` (`IDPELANGGAN`);

--
-- Indexes for table `gaji`
--
ALTER TABLE `gaji`
  ADD PRIMARY KEY (`IDGAJI`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`IDJABATAN`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`IDKARYAWAN`),
  ADD KEY `FK_KARYAWAN_KERJASAMA_NAMATIM` (`IDTIM`),
  ADD KEY `FK_KARYAWAN_MEMILIKI1_JABATAN` (`IDJABATAN`),
  ADD KEY `FK_KARYAWAN_MEMPUNYAI_GAJI` (`IDGAJI`);

--
-- Indexes for table `laporankeuangan`
--
ALTER TABLE `laporankeuangan`
  ADD PRIMARY KEY (`IDLAPORAN`),
  ADD KEY `FK_LAPORANK_MENULIS1_DETAILPE` (`IDPENJUALAN`),
  ADD KEY `FK_LAPORANK_MENULIS2_DETAILGA` (`IDDETAILGAJI`);

--
-- Indexes for table `namaperusahaan`
--
ALTER TABLE `namaperusahaan`
  ADD PRIMARY KEY (`IDPERUSAHAAN`);

--
-- Indexes for table `namatim`
--
ALTER TABLE `namatim`
  ADD PRIMARY KEY (`IDTIM`),
  ADD KEY `FK_NAMATIM_MENGEPALA_NAMAPERU` (`IDPERUSAHAAN`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`IDPELANGGAN`),
  ADD KEY `FK_PELANGGA_MEMBELI1_BARANG` (`IDBARANG`),
  ADD KEY `FK_PELANGGA_MEMILIH1_PEMBAYAR` (`IDPEMBAYARAN`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`IDPEMBAYARAN`),
  ADD KEY `FK_PEMBAYAR_MEMILIKI4_TIPEPEMB` (`IDSTATUS`);

--
-- Indexes for table `tipepembayaran`
--
ALTER TABLE `tipepembayaran`
  ADD PRIMARY KEY (`IDSTATUS`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `daftarhadir`
--
ALTER TABLE `daftarhadir`
  MODIFY `IDDAFTARHADIR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `FK_ADMIN_MEMPUNYAI_GAJI` FOREIGN KEY (`IDGAJI`) REFERENCES `gaji` (`IDGAJI`);

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `FK_BARANG_MEMILIKI3_DETAILME` FOREIGN KEY (`IDMEREK`) REFERENCES `detailmerek` (`IDMEREK`);

--
-- Constraints for table `daftarhadir`
--
ALTER TABLE `daftarhadir`
  ADD CONSTRAINT `FK_DAFTARHA_MEMILIKI2_KARYAWAN` FOREIGN KEY (`IDKARYAWAN`) REFERENCES `karyawan` (`IDKARYAWAN`);

--
-- Constraints for table `detailgaji`
--
ALTER TABLE `detailgaji`
  ADD CONSTRAINT `FK_DETAILGA_MENDAPAT1_KARYAWAN` FOREIGN KEY (`IDKARYAWAN`) REFERENCES `karyawan` (`IDKARYAWAN`),
  ADD CONSTRAINT `detailgaji_ibfk_1` FOREIGN KEY (`IDADMIN`) REFERENCES `admin` (`IDADMIN`);

--
-- Constraints for table `detailmerek`
--
ALTER TABLE `detailmerek`
  ADD CONSTRAINT `FK_DETAILME_MEMEGANG_NAMAPERU` FOREIGN KEY (`IDPERUSAHAAN`) REFERENCES `namaperusahaan` (`IDPERUSAHAAN`);

--
-- Constraints for table `detailpenjualan`
--
ALTER TABLE `detailpenjualan`
  ADD CONSTRAINT `FK_DETAILPE_MENDAPAT2_PELANGGA` FOREIGN KEY (`IDPELANGGAN`) REFERENCES `pelanggan` (`IDPELANGGAN`);

--
-- Constraints for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD CONSTRAINT `FK_KARYAWAN_KERJASAMA_NAMATIM` FOREIGN KEY (`IDTIM`) REFERENCES `namatim` (`IDTIM`),
  ADD CONSTRAINT `FK_KARYAWAN_MEMILIKI1_JABATAN` FOREIGN KEY (`IDJABATAN`) REFERENCES `jabatan` (`IDJABATAN`),
  ADD CONSTRAINT `FK_KARYAWAN_MEMPUNYAI_GAJI` FOREIGN KEY (`IDGAJI`) REFERENCES `gaji` (`IDGAJI`);

--
-- Constraints for table `laporankeuangan`
--
ALTER TABLE `laporankeuangan`
  ADD CONSTRAINT `FK_LAPORANK_MENULIS1_DETAILPE` FOREIGN KEY (`IDPENJUALAN`) REFERENCES `detailpenjualan` (`IDPENJUALAN`),
  ADD CONSTRAINT `FK_LAPORANK_MENULIS2_DETAILGA` FOREIGN KEY (`IDDETAILGAJI`) REFERENCES `detailgaji` (`IDDETAILGAJI`);

--
-- Constraints for table `namatim`
--
ALTER TABLE `namatim`
  ADD CONSTRAINT `FK_NAMATIM_MENGEPALA_NAMAPERU` FOREIGN KEY (`IDPERUSAHAAN`) REFERENCES `namaperusahaan` (`IDPERUSAHAAN`);

--
-- Constraints for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD CONSTRAINT `FK_PELANGGA_MEMBELI1_BARANG` FOREIGN KEY (`IDBARANG`) REFERENCES `barang` (`IDBARANG`),
  ADD CONSTRAINT `FK_PELANGGA_MEMILIH1_PEMBAYAR` FOREIGN KEY (`IDPEMBAYARAN`) REFERENCES `pembayaran` (`IDPEMBAYARAN`);

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `FK_PEMBAYAR_MEMILIKI4_TIPEPEMB` FOREIGN KEY (`IDSTATUS`) REFERENCES `tipepembayaran` (`IDSTATUS`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
