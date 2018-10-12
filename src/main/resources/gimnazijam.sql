-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 12, 2018 at 11:03 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gimnazijam`
--

-- --------------------------------------------------------

--
-- Table structure for table `angazovanje`
--

CREATE TABLE `angazovanje` (
  `angazovanje_id` int(11) NOT NULL,
  `kraj` datetime DEFAULT NULL,
  `pocetak` datetime NOT NULL,
  `nastavni_plan_predmet_id` int(11) NOT NULL,
  `nastavnik_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `angazovanje_odeljenje`
--

CREATE TABLE `angazovanje_odeljenje` (
  `angazovanje_id` int(11) NOT NULL,
  `odeljenje_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cas`
--

CREATE TABLE `cas` (
  `cas_id` int(11) NOT NULL,
  `datum_unosa` datetime NOT NULL,
  `napomena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opis_casa` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `redni_broj_casa` int(11) NOT NULL,
  `ukupan_broj_casova` int(11) NOT NULL,
  `nastavni_plan_predmet_id` int(11) NOT NULL,
  `nastavnik_id` int(11) NOT NULL,
  `odeljenje_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cenovnik`
--

CREATE TABLE `cenovnik` (
  `cenovnik_id` int(11) NOT NULL,
  `cena_stavke` int(11) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `date_modified` datetime DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `naziv_stavke` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sifra_stavke` int(11) NOT NULL,
  `valuta` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `modeli_placanja_i_stipendije_id` int(11) NOT NULL,
  `skolska_godina_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `godisnji_plan`
--

CREATE TABLE `godisnji_plan` (
  `godisnji_plan_id` int(11) NOT NULL,
  `datum_usvajanja` datetime NOT NULL,
  `naziv_skole` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usvojen` int(11) NOT NULL,
  `vazi_do` datetime NOT NULL,
  `skolska_godina_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `modeli_placanja_i_stipendije`
--

CREATE TABLE `modeli_placanja_i_stipendije` (
  `model_placanja_id` int(11) NOT NULL,
  `kamata` double DEFAULT NULL,
  `naziv_modela` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `opis` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `popust` double DEFAULT NULL,
  `zatezna_kamata` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nastavnik`
--

CREATE TABLE `nastavnik` (
  `nastavnik_id` int(11) NOT NULL,
  `fakultet` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `razredni` int(11) NOT NULL,
  `zaposleni_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nastavni_plan_predmet`
--

CREATE TABLE `nastavni_plan_predmet` (
  `nastavni_plan_predmet_id` int(11) NOT NULL,
  `ime_plana` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nedeljno_nastave` int(11) NOT NULL,
  `nedeljno_vezbi` int(11) NOT NULL,
  `razred` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ukupno_nedelja` int(11) NOT NULL,
  `godisnji_plan_id` int(11) NOT NULL,
  `predmet_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `odeljenje`
--

CREATE TABLE `odeljenje` (
  `odeljenje_id` int(11) NOT NULL,
  `oznaka` int(11) NOT NULL,
  `razred` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nastavnik_id` int(11) NOT NULL,
  `skolska_godina_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `predmet`
--

CREATE TABLE `predmet` (
  `predmet_id` int(11) NOT NULL,
  `pun_naziv` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sifra` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `prisustvo`
--

CREATE TABLE `prisustvo` (
  `prisustvo_id` int(11) NOT NULL,
  `opravdano_odsustvo` int(11) NOT NULL,
  `cas_id` int(11) NOT NULL,
  `ucenik_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `roditelj`
--

CREATE TABLE `roditelj` (
  `roditelj_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `roditeljski_sastanak`
--

CREATE TABLE `roditeljski_sastanak` (
  `roditeljski_sastanak_id` int(11) NOT NULL,
  `datum` tinyblob NOT NULL,
  `napomena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `roditelj_id` int(11) NOT NULL,
  `zaposleni_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `naziv_role` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `naziv_role`) VALUES
(1, 'Admin'),
(2, 'Korisnik');

-- --------------------------------------------------------

--
-- Table structure for table `skolska_godina`
--

CREATE TABLE `skolska_godina` (
  `skolska_godina_id` int(11) NOT NULL,
  `datum_kraja` datetime NOT NULL,
  `datum_pocetka` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ucenik`
--

CREATE TABLE `ucenik` (
  `ucenik_id` int(11) NOT NULL,
  `broj_knjizice` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ime_roditelja` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `osnovna_skola` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ucenik_predmet`
--

CREATE TABLE `ucenik_predmet` (
  `ucenik_predmet_id` int(11) NOT NULL,
  `datum_unosa` datetime NOT NULL,
  `napomena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ocena` int(11) NOT NULL,
  `polugodiste` int(11) NOT NULL,
  `tip_ocene` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nastavni_plan_predmet_id` int(11) NOT NULL,
  `nastavnik_id` int(11) NOT NULL,
  `ucenik_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ucenik_roditelj`
--

CREATE TABLE `ucenik_roditelj` (
  `ucenik_id` int(11) NOT NULL,
  `roditelj_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `upis`
--

CREATE TABLE `upis` (
  `upis_id` int(11) NOT NULL,
  `datum_upisa` datetime NOT NULL,
  `odeljenje_id` int(11) NOT NULL,
  `ucenik_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `uplate`
--

CREATE TABLE `uplate` (
  `uplate_id` int(11) NOT NULL,
  `datum_placanja` datetime NOT NULL,
  `iznos_uplate_din` double DEFAULT NULL,
  `iznos_uplate_eur` double DEFAULT NULL,
  `napomena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `srednji_kurs` double DEFAULT NULL,
  `zaduzenja_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `adresa` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datum_rodjenja` date NOT NULL,
  `display_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `grad` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `jmbg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ldapon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `telefon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `adresa`, `datum_rodjenja`, `display_name`, `email`, `grad`, `ime`, `jmbg`, `ldapon`, `password`, `prezime`, `telefon`, `username`) VALUES
(1, '', '1975-01-01', 'mmarkovic', 'mmarkovic@gmail.com', 'Nis', 'Marko', '0101975123456', 'ldapon', 'marko1', 'Markovic', '0656665556', 'mmarkovic'),
(2, '', '1988-08-08', 'ddimitrijevic', 'ddimitrijevic@gmail.com', 'Nis', 'Dimitrije', '0808988765432', 'ldapon', 'dimitrije2', 'Dimitrijevic', '0663336663', 'ddimitrijevic'),
(3, '', '1986-06-06', 'nnikolic', 'nnikolic@gmail.com', 'Nis', 'Nikolija', '0606986987654', 'ldapon', 'nikolija3', 'Nikolic', '0665556665', 'nnikolic'),
(4, '', '1991-10-10', 'jjovanovic', 'jjovanovic@gmail.com', 'Nis', 'Jovan', '1010991123123', 'ldapon', 'jovan1', 'Jovanovic', '0696669996', 'jjovanovic'),
(5, '', '1991-09-09', 'kkatic', 'kkatic@gmail.com', 'Nis', 'Katarina', '0909991234567', 'ldapon', 'katarina2', 'Katic', '0639993339', 'kkatic'),
(6, '', '1986-06-06', 'aaleksic', 'aaleksic@gmail.com', 'Nis', 'Aleksandar', '0606986989898', 'ldapon', 'aleksandar3', 'Aleksic', '0665556665', 'aaleksic');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(5, 2),
(6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `zaduzenja`
--

CREATE TABLE `zaduzenja` (
  `zaduzenja_id` int(11) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `iznos_zaduzenja` double DEFAULT NULL,
  `modified_by` int(11) DEFAULT NULL,
  `napomena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `popust_iznos` double DEFAULT NULL,
  `rok_za_placanje` datetime NOT NULL,
  `cenovnik_id` int(11) NOT NULL,
  `upis_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `zaposleni`
--

CREATE TABLE `zaposleni` (
  `zaposleni_id` int(11) NOT NULL,
  `banka` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `broj_racuna` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pozicija` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sss` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `zvanje` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `zaposleni`
--

INSERT INTO `zaposleni` (`zaposleni_id`, `banka`, `broj_racuna`, `pozicija`, `sss`, `zvanje`, `user_id`) VALUES
(1, 'Komercijalna banka', '333-666-999', 'Profesor', '', 'Profesor matematike i informatike', 1),
(2, 'Procredit Bank', '999-888-777', 'Saradnik u nastavi', '', 'Master softverskog inzenjerstva', 5),
(3, 'Banca Intesa', '222-444-666', 'Saradnik u nastavi', '', 'Master softverskog inzenjerstva', 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `angazovanje`
--
ALTER TABLE `angazovanje`
  ADD PRIMARY KEY (`angazovanje_id`),
  ADD KEY `FKjoc3q9wsqtg0su4y0rwdoo2e5` (`nastavni_plan_predmet_id`),
  ADD KEY `FK89oi2ih6nr00ydg4x82vkdu3s` (`nastavnik_id`);

--
-- Indexes for table `angazovanje_odeljenje`
--
ALTER TABLE `angazovanje_odeljenje`
  ADD KEY `FKrchneq3wo5m2snhgcoww3yy2d` (`odeljenje_id`),
  ADD KEY `FKpp2dfpw5p76wytd1lc01sfh9i` (`angazovanje_id`);

--
-- Indexes for table `cas`
--
ALTER TABLE `cas`
  ADD PRIMARY KEY (`cas_id`),
  ADD KEY `FKppwrqmsdcw3orqd8rlwqli5b1` (`nastavni_plan_predmet_id`),
  ADD KEY `FKkog0bmuq8avixtiplhrdwnu6e` (`nastavnik_id`),
  ADD KEY `FK41kmmqws74e6ge3rm0rvugnme` (`odeljenje_id`);

--
-- Indexes for table `cenovnik`
--
ALTER TABLE `cenovnik`
  ADD PRIMARY KEY (`cenovnik_id`),
  ADD KEY `FKia0amtr3svmajpu387hl50ble` (`modeli_placanja_i_stipendije_id`),
  ADD KEY `FK4rju2amp2tce0aemvqbbjdy6g` (`skolska_godina_id`);

--
-- Indexes for table `godisnji_plan`
--
ALTER TABLE `godisnji_plan`
  ADD PRIMARY KEY (`godisnji_plan_id`),
  ADD KEY `FKd9hk9prxkwnbctwasownvxnwa` (`skolska_godina_id`);

--
-- Indexes for table `modeli_placanja_i_stipendije`
--
ALTER TABLE `modeli_placanja_i_stipendije`
  ADD PRIMARY KEY (`model_placanja_id`);

--
-- Indexes for table `nastavnik`
--
ALTER TABLE `nastavnik`
  ADD PRIMARY KEY (`nastavnik_id`),
  ADD KEY `FKtexdksvi6tfa6dbeymiipn2cp` (`zaposleni_id`);

--
-- Indexes for table `nastavni_plan_predmet`
--
ALTER TABLE `nastavni_plan_predmet`
  ADD PRIMARY KEY (`nastavni_plan_predmet_id`),
  ADD KEY `FK19pc8ynuge0ichx2oiih4415m` (`godisnji_plan_id`),
  ADD KEY `FKnph681fxsfs11jvkyosp7lbms` (`predmet_id`);

--
-- Indexes for table `odeljenje`
--
ALTER TABLE `odeljenje`
  ADD PRIMARY KEY (`odeljenje_id`),
  ADD KEY `FKg91yw1a366tcriqx88m0ggbur` (`nastavnik_id`),
  ADD KEY `FKnbb1ni0dewr60l2piq5ce64fq` (`skolska_godina_id`);

--
-- Indexes for table `predmet`
--
ALTER TABLE `predmet`
  ADD PRIMARY KEY (`predmet_id`);

--
-- Indexes for table `prisustvo`
--
ALTER TABLE `prisustvo`
  ADD PRIMARY KEY (`prisustvo_id`),
  ADD KEY `FKa65yshvn1l3djwdgrhwbc0iuy` (`cas_id`),
  ADD KEY `FKhjm5danln355efeashui09q24` (`ucenik_id`);

--
-- Indexes for table `roditelj`
--
ALTER TABLE `roditelj`
  ADD PRIMARY KEY (`roditelj_id`),
  ADD KEY `FKd9nk3ma07b4p7jyj8p3i655bw` (`user_id`);

--
-- Indexes for table `roditeljski_sastanak`
--
ALTER TABLE `roditeljski_sastanak`
  ADD PRIMARY KEY (`roditeljski_sastanak_id`),
  ADD KEY `FK1fw2ea1s84fauu8sgmdu7fkt3` (`roditelj_id`),
  ADD KEY `FKld7fmol9i2tsc4ffpr9fh8edj` (`zaposleni_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `skolska_godina`
--
ALTER TABLE `skolska_godina`
  ADD PRIMARY KEY (`skolska_godina_id`);

--
-- Indexes for table `ucenik`
--
ALTER TABLE `ucenik`
  ADD PRIMARY KEY (`ucenik_id`),
  ADD KEY `FKlnq36u5o7v78vvke2al6by4tg` (`user_id`);

--
-- Indexes for table `ucenik_predmet`
--
ALTER TABLE `ucenik_predmet`
  ADD PRIMARY KEY (`ucenik_predmet_id`),
  ADD KEY `FKdq1lioiakfmduxo6do09gt9u1` (`nastavni_plan_predmet_id`),
  ADD KEY `FKkg9ryxf5nknlns964rxh41uwt` (`nastavnik_id`),
  ADD KEY `FK6e9jtymx1q4c8kn3mk7k1l4hp` (`ucenik_id`);

--
-- Indexes for table `ucenik_roditelj`
--
ALTER TABLE `ucenik_roditelj`
  ADD KEY `FKltiglhswstocbnj1qqxtf82of` (`roditelj_id`),
  ADD KEY `FKpgqhnga7w71n5hfla7ku2a3bl` (`ucenik_id`);

--
-- Indexes for table `upis`
--
ALTER TABLE `upis`
  ADD PRIMARY KEY (`upis_id`),
  ADD KEY `FKikxdpyeen096w9ow7fl5t9kq8` (`odeljenje_id`),
  ADD KEY `FKlla640ivy28cpgpvvgnu8ebha` (`ucenik_id`);

--
-- Indexes for table `uplate`
--
ALTER TABLE `uplate`
  ADD PRIMARY KEY (`uplate_id`),
  ADD KEY `FKrdq878e3k1c16o9d68n93nkjy` (`zaduzenja_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- Indexes for table `zaduzenja`
--
ALTER TABLE `zaduzenja`
  ADD PRIMARY KEY (`zaduzenja_id`),
  ADD KEY `FKlscd7hjq8mt183fehcq5sjty4` (`cenovnik_id`),
  ADD KEY `FKtlfyjecs7r8lj3p6j88mfixco` (`upis_id`);

--
-- Indexes for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD PRIMARY KEY (`zaposleni_id`),
  ADD KEY `FK62tqfx6l9i2y14hus1qmwbc4x` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `angazovanje`
--
ALTER TABLE `angazovanje`
  MODIFY `angazovanje_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cas`
--
ALTER TABLE `cas`
  MODIFY `cas_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `cenovnik`
--
ALTER TABLE `cenovnik`
  MODIFY `cenovnik_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `godisnji_plan`
--
ALTER TABLE `godisnji_plan`
  MODIFY `godisnji_plan_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `modeli_placanja_i_stipendije`
--
ALTER TABLE `modeli_placanja_i_stipendije`
  MODIFY `model_placanja_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nastavnik`
--
ALTER TABLE `nastavnik`
  MODIFY `nastavnik_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nastavni_plan_predmet`
--
ALTER TABLE `nastavni_plan_predmet`
  MODIFY `nastavni_plan_predmet_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `odeljenje`
--
ALTER TABLE `odeljenje`
  MODIFY `odeljenje_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `predmet`
--
ALTER TABLE `predmet`
  MODIFY `predmet_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `prisustvo`
--
ALTER TABLE `prisustvo`
  MODIFY `prisustvo_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roditelj`
--
ALTER TABLE `roditelj`
  MODIFY `roditelj_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roditeljski_sastanak`
--
ALTER TABLE `roditeljski_sastanak`
  MODIFY `roditeljski_sastanak_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `skolska_godina`
--
ALTER TABLE `skolska_godina`
  MODIFY `skolska_godina_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ucenik`
--
ALTER TABLE `ucenik`
  MODIFY `ucenik_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ucenik_predmet`
--
ALTER TABLE `ucenik_predmet`
  MODIFY `ucenik_predmet_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `upis`
--
ALTER TABLE `upis`
  MODIFY `upis_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `uplate`
--
ALTER TABLE `uplate`
  MODIFY `uplate_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user_role`
--
ALTER TABLE `user_role`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `zaduzenja`
--
ALTER TABLE `zaduzenja`
  MODIFY `zaduzenja_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `zaposleni`
--
ALTER TABLE `zaposleni`
  MODIFY `zaposleni_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
