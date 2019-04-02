-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema book_club
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema book_club
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `book_club` DEFAULT CHARACTER SET utf8 ;
USE `book_club` ;

-- -----------------------------------------------------
-- Table `book_club`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book_club`.`user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `user_image` BLOB NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_club`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book_club`.`book` (
  `id_book` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `author` VARCHAR(100) NOT NULL,
  `publisher` VARCHAR(100) NULL,
  `description` VARCHAR(250) NOT NULL,
  `book_image` BLOB NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id_book`),
  INDEX `fk_book_user_idx` (`id_user` ASC),
  CONSTRAINT `fk_book_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `book_club`.`user` (`id_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_club`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book_club`.`comment` (
  `id_comment` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(250) NOT NULL,
  `date_time` DATETIME NULL,
  `id_user` INT NOT NULL,
  `id_book` INT NOT NULL,
  PRIMARY KEY (`id_comment`),
  INDEX `fk_comment_user1_idx` (`id_user` ASC),
  INDEX `fk_comment_book1_idx` (`id_book` ASC),
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`id_user`)
    REFERENCES `book_club`.`user` (`id_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_book1`
    FOREIGN KEY (`id_book`)
    REFERENCES `book_club`.`book` (`id_book`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_club`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book_club`.`category` (
  `id_category` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `book_club`.`book_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book_club`.`book_category` (
  `id_book_category` INT NOT NULL AUTO_INCREMENT,
  `id_book` INT NOT NULL,
  `id_category` INT NOT NULL,
  PRIMARY KEY (`id_book_category`),
  INDEX `fk_book_has_category_category1_idx` (`id_category` ASC),
  INDEX `fk_book_has_category_book1_idx` (`id_book` ASC),
  CONSTRAINT `fk_book_has_category_book1`
    FOREIGN KEY (`id_book`)
    REFERENCES `book_club`.`book` (`id_book`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_book_has_category_category1`
    FOREIGN KEY (`id_category`)
    REFERENCES `book_club`.`category` (`id_category`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

