-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 09 mai 2023 à 18:51
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_patient_follow_up`
--

-- --------------------------------------------------------

--
-- Structure de la table `doctor`
--

CREATE TABLE `doctor` (
  `iddoctor` int(11) NOT NULL,
  `idpatient` int(255) NOT NULL,
  `idperson` int(11) NOT NULL,
  `inami` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `drug`
--

CREATE TABLE `drug` (
  `iddrug` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `posology` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `idpatient` int(11) NOT NULL,
  `iddoctor` int(255) NOT NULL,
  `idperson` int(11) NOT NULL,
  `idtreatment` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `patient_treatment`
--

CREATE TABLE `patient_treatment` (
  `Patient_Idpatient` int(11) NOT NULL,
  `treatmentList_idtreatment` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `person`
--

CREATE TABLE `person` (
  `idperson` int(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `dateofbirth` date NOT NULL,
  `emailadress` varchar(255) NOT NULL,
  `password` int(255) NOT NULL,
  `registernumber` int(11) DEFAULT NULL,
  `role` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `person`
--

INSERT INTO `person` (`idperson`, `firstname`, `lastname`, `dateofbirth`, `emailadress`, `password`, `registernumber`, `role`) VALUES
(1, 'Dariouch', 'Darimont', '2000-10-11', 'dar@hotmail.com', 1234, 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `treatment`
--

CREATE TABLE `treatment` (
  `idtreatment` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `iddrug` int(255) NOT NULL,
  `sideeffect` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `treatment_drug`
--

CREATE TABLE `treatment_drug` (
  `Treatment_idtreatment` int(11) NOT NULL,
  `drugList_iddrug` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`iddoctor`),
  ADD KEY `doctor_fk0` (`idpatient`),
  ADD KEY `doctor_fk1` (`idperson`);

--
-- Index pour la table `drug`
--
ALTER TABLE `drug`
  ADD PRIMARY KEY (`iddrug`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`idpatient`),
  ADD KEY `patient_fk0` (`iddoctor`),
  ADD KEY `patient_fk1` (`idperson`),
  ADD KEY `patient_fk2` (`idtreatment`);

--
-- Index pour la table `patient_treatment`
--
ALTER TABLE `patient_treatment`
  ADD PRIMARY KEY (`Patient_Idpatient`,`treatmentList_idtreatment`),
  ADD KEY `FK_Patient_treatment_treatmentList_idtreatment` (`treatmentList_idtreatment`);

--
-- Index pour la table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`idperson`);

--
-- Index pour la table `treatment`
--
ALTER TABLE `treatment`
  ADD PRIMARY KEY (`idtreatment`),
  ADD KEY `treatment_fk0` (`iddrug`);

--
-- Index pour la table `treatment_drug`
--
ALTER TABLE `treatment_drug`
  ADD PRIMARY KEY (`Treatment_idtreatment`,`drugList_iddrug`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `iddoctor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `drug`
--
ALTER TABLE `drug`
  MODIFY `iddrug` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `idpatient` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `person`
--
ALTER TABLE `person`
  MODIFY `idperson` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `treatment`
--
ALTER TABLE `treatment`
  MODIFY `idtreatment` int(255) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `doctor_fk0` FOREIGN KEY (`idpatient`) REFERENCES `patient` (`idpatient`),
  ADD CONSTRAINT `doctor_fk1` FOREIGN KEY (`idperson`) REFERENCES `person` (`idperson`);

--
-- Contraintes pour la table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `patient_fk0` FOREIGN KEY (`iddoctor`) REFERENCES `doctor` (`iddoctor`),
  ADD CONSTRAINT `patient_fk1` FOREIGN KEY (`idperson`) REFERENCES `person` (`idperson`),
  ADD CONSTRAINT `patient_fk2` FOREIGN KEY (`idtreatment`) REFERENCES `treatment` (`idtreatment`);

--
-- Contraintes pour la table `patient_treatment`
--
ALTER TABLE `patient_treatment`
  ADD CONSTRAINT `FK_Patient_treatment_Patient_Idpatient` FOREIGN KEY (`Patient_Idpatient`) REFERENCES `patient` (`idpatient`),
  ADD CONSTRAINT `FK_Patient_treatment_treatmentList_idtreatment` FOREIGN KEY (`treatmentList_idtreatment`) REFERENCES `treatment` (`idtreatment`);

--
-- Contraintes pour la table `treatment`
--
ALTER TABLE `treatment`
  ADD CONSTRAINT `treatment_fk0` FOREIGN KEY (`iddrug`) REFERENCES `drug` (`iddrug`);

--
-- Contraintes pour la table `treatment_drug`
--
ALTER TABLE `treatment_drug`
  ADD CONSTRAINT `FK_treatment_drug_Treatment_idtreatment` FOREIGN KEY (`Treatment_idtreatment`) REFERENCES `treatment` (`idtreatment`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
