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
    `dateEvent` VARCHAR(10) NOT NULL,
	`event`  VARCHAR(500) NOT NULL,
	PRIMARY KEY (`idEvent`));








DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur` 
(
	`identifiant`  VARCHAR(50) NOT NULL,
	`motDePasse`  VARCHAR(50) NOT NULL,
	`nom`  VARCHAR(50) NOT NULL,
	`prenom`  VARCHAR(50) NOT NULL,
    `mail`  VARCHAR(50) NOT NULL,
    `nbMessagesForum`  INT,
    `dateInscription`  VARCHAR(10) NOT NULL,
    `participant`  BOOLEAN,
    `photo`  varchar(100),
    `classe`  VARCHAR(10),
    `admin`  BOOLEAN,
	PRIMARY KEY (`identifiant`));


DROP TABLE IF EXISTS `equipages`;
CREATE TABLE `equipages` 
(
	`numeroEquipage`  INT NOT NULL AUTO_INCREMENT,
	`nomEquipage`  VARCHAR(50) NOT NULL,
	`identifParticipant1`  VARCHAR(50) NOT NULL,
    `identifParticipant2`  VARCHAR(50),
	`descriptionEquipage`  VARCHAR(255) ,
	`photoEquipage`  varchar(100),
	PRIMARY KEY (`numeroEquipage`));
