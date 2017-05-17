DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` 
(
	`idMessage`  INT NOT NULL AUTO_INCREMENT,
	`texteMessage`  VARCHAR(1000) NOT NULL,
	`datePost`  VARCHAR(10) NOT NULL,
	`idSujet`  INT,
	PRIMARY KEY (`idMessage`));

DROP TABLE IF EXISTS `sujet`;
CREATE TABLE `sujet` 
(
	`idSujet`  INT NOT NULL AUTO_INCREMENT,
	`nomSujet`  VARCHAR(50) NOT NULL,
	`identifiantCreateur`  VARCHAR(50) NOT NULL,
	`dateLastPost`  VARCHAR(10) NOT NULL,
	`nbMessage`  INT NOT NULL,
    `identifiantLastPost`  VARCHAR(50),
	PRIMARY KEY (`idSujet`));


DROP TABLE IF EXISTS `photos`;
CREATE TABLE `photos` 
(
	`idPhoto`  INT NOT NULL AUTO_INCREMENT,
	`photo`  VARCHAR(100),
    `idAlbum`  INT,
	PRIMARY KEY (`idPhoto`));
	
	
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` 
(
	`prenomContact` VARCHAR(50) NOT NULL ,
	`nomContact`  VARCHAR(50) NOT NULL,
    `mailContact` VARCHAR(50) NOT NULL,
    `messageContact`VARCHAR(500)NOT NULL,
	PRIMARY KEY (`mailContact`));




DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` 
(
	`idAlbum`  INT NOT NULL AUTO_INCREMENT,
	`nomAlbum`  VARCHAR(50) NOT NULL,
	PRIMARY KEY (`idAlbum`));

DROP TABLE IF EXISTS `actualites`;
CREATE TABLE `actualites` 
(
	`idActu`  INT NOT NULL AUTO_INCREMENT,
	`titreActu`  VARCHAR(100) NOT NULL,
	`actu`  VARCHAR(1000) NOT NULL,
	PRIMARY KEY (`idActu`));


DROP TABLE IF EXISTS `evenements`;
CREATE TABLE `evenements` 
(
	`idEvent`  INT NOT NULL AUTO_INCREMENT,
    `dateEvent` VARCHAR(50) NOT NULL,
	`event`  VARCHAR(500) NOT NULL,
	PRIMARY KEY (`idEvent`));



DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur` 
(
	`idUser`  INT NOT NULL AUTO_INCREMENT,
	`nom`  VARCHAR(50) NOT NULL,
	`prenom`  VARCHAR(50) NOT NULL,
    `mail`  VARCHAR(50) NOT NULL,
    `photo`  varchar(100),
    `classe`  VARCHAR(10),
    `identif` VARCHAR(100),
	PRIMARY KEY (`idUser`));


DROP TABLE IF EXISTS `equipages`;
CREATE TABLE `equipages` 
(
	`numeroEquipage`  INT NOT NULL AUTO_INCREMENT,
	`nomEquipage`  VARCHAR(50) NOT NULL,
    `descriptionEquipage`  VARCHAR(255),
	`nom1`  VARCHAR(50) NOT NULL,
    `nom2`  VARCHAR(50) NOT NULL,
	`prenom1`  VARCHAR(50) NOT NULL,
    `prenom2`  VARCHAR(50) NOT NULL,
    `mail1`  VARCHAR(50) NOT NULL,
    `mail2`  VARCHAR(50) NOT NULL,
    `classe1`  VARCHAR(10),
    `classe2`  VARCHAR(10),
    `photo1`  varchar(100),
    `photo2`  varchar(100),
    
	
	`photoEquipage`  varchar(100),
	PRIMARY KEY (`numeroEquipage`));
