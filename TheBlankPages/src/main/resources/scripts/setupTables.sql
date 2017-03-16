SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ca2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ca2` DEFAULT CHARACTER SET utf8 ;
USE `ca2` ;

-- -----------------------------------------------------
-- Table `ca2`.`cityinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ca2`.`cityinfo` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CITY` VARCHAR(255) NULL DEFAULT NULL,
  `ZIPCODE` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ca2`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ca2`.`address` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `ADDITIONALINFO` VARCHAR(255) NULL DEFAULT NULL,
  `STREET` VARCHAR(255) NULL DEFAULT NULL,
  `CITYINFO_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_ADDRESS_CITYINFO_ID` (`CITYINFO_ID` ASC),
  CONSTRAINT `FK_ADDRESS_CITYINFO_ID`
    FOREIGN KEY (`CITYINFO_ID`)
    REFERENCES `ca2`.`cityinfo` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ca2`.`infoentity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ca2`.`infoentity` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DTYPE` VARCHAR(31) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(255) NULL DEFAULT NULL,
  `ADDRESS_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_INFOENTITY_ADDRESS_ID` (`ADDRESS_ID` ASC),
  CONSTRAINT `FK_INFOENTITY_ADDRESS_ID`
    FOREIGN KEY (`ADDRESS_ID`)
    REFERENCES `ca2`.`address` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ca2`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ca2`.`company` (
  `ID` INT(11) NOT NULL,
  `NUMEMPLOYEES` INT(11) NULL DEFAULT NULL,
  `CVR` INT(11) NULL DEFAULT NULL,
  `DESCRIPTION` VARCHAR(255) NULL DEFAULT NULL,
  `MARKETVALUE` DOUBLE NULL DEFAULT NULL,
  `NAME` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_COMPANY_ID`
    FOREIGN KEY (`ID`)
    REFERENCES `ca2`.`infoentity` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ca2`.`hobby`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ca2`.`hobby` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` VARCHAR(255) NULL DEFAULT NULL,
  `NAME` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ca2`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ca2`.`person` (
  `ID` INT(11) NOT NULL,
  `FIRSTNAME` VARCHAR(255) NULL DEFAULT NULL,
  `LASTNAME` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_PERSON_ID`
    FOREIGN KEY (`ID`)
    REFERENCES `ca2`.`infoentity` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ca2`.`person_hobby`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ca2`.`person_hobby` (
  `Person_ID` INT(11) NOT NULL,
  `hobbies_ID` INT(11) NOT NULL,
  PRIMARY KEY (`Person_ID`, `hobbies_ID`),
  INDEX `FK_PERSON_HOBBY_hobbies_ID` (`hobbies_ID` ASC),
  CONSTRAINT `FK_PERSON_HOBBY_Person_ID`
    FOREIGN KEY (`Person_ID`)
    REFERENCES `ca2`.`infoentity` (`ID`),
  CONSTRAINT `FK_PERSON_HOBBY_hobbies_ID`
    FOREIGN KEY (`hobbies_ID`)
    REFERENCES `ca2`.`hobby` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ca2`.`personpojo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ca2`.`personpojo` (
  `ID` INT(11) NOT NULL,
  `FIRSTNAME` VARCHAR(255) NULL DEFAULT NULL,
  `LASTNAME` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_PERSONPOJO_ID`
    FOREIGN KEY (`ID`)
    REFERENCES `ca2`.`infoentity` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ca2`.`personpojo_hobby`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ca2`.`personpojo_hobby` (
  `PersonPOJO_ID` INT(11) NOT NULL,
  `hobbies_ID` INT(11) NOT NULL,
  PRIMARY KEY (`PersonPOJO_ID`, `hobbies_ID`),
  INDEX `FK_PERSONPOJO_HOBBY_hobbies_ID` (`hobbies_ID` ASC),
  CONSTRAINT `FK_PERSONPOJO_HOBBY_PersonPOJO_ID`
    FOREIGN KEY (`PersonPOJO_ID`)
    REFERENCES `ca2`.`infoentity` (`ID`),
  CONSTRAINT `FK_PERSONPOJO_HOBBY_hobbies_ID`
    FOREIGN KEY (`hobbies_ID`)
    REFERENCES `ca2`.`hobby` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ca2`.`phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ca2`.`phone` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` VARCHAR(255) NULL DEFAULT NULL,
  `NUMBER` INT(11) NULL DEFAULT NULL,
  `IE_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_PHONE_IE_ID` (`IE_ID` ASC),
  CONSTRAINT `FK_PHONE_IE_ID`
    FOREIGN KEY (`IE_ID`)
    REFERENCES `ca2`.`infoentity` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;