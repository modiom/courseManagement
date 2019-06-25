-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema COURSE
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema COURSE
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `COURSE` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema course
-- -----------------------------------------------------
USE `COURSE` ;

-- -----------------------------------------------------
-- Table `COURSE`.`course`
-- -----------------------------------------------------course
CREATE TABLE IF NOT EXISTS `COURSE`.`course` (
  `course_id` INT NOT NULL,
  `course_name` VARCHAR(45) NULL,
  PRIMARY KEY (`course_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `COURSE`.`trainer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `COURSE`.`trainer` (
  `trainer_id` INT NOT NULL,
  `trainer_name` VARCHAR(45) NULL,
  PRIMARY KEY (`trainer_id`))
ENGINE = InnoDB;

ALTER TABLE `course`.`course` 
CHANGE COLUMN `course_id` `course_id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `course`.`trainer` 
CHANGE COLUMN `trainer_id` `trainer_id` INT(11) NOT NULL AUTO_INCREMENT ;
-- -----------------------------------------------------
-- Table `COURSE`.`course_trainer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `COURSE`.`course_trainer` (
  `course_id` INT NOT NULL,
  `trainer_id` INT NOT NULL,
  `course_trainer_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`course_trainer_id`),
  INDEX `fk_course_trainer_trainer1_idx` (`trainer_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_trainer_course`
    FOREIGN KEY (`course_id`)
    REFERENCES `COURSE`.`course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_trainer_trainer1`
    FOREIGN KEY (`trainer_id`)
    REFERENCES `COURSE`.`trainer` (`trainer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `COURSE`.`trainer_allocation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `COURSE`.`trainer_allocation` (
  `start_time` DATETIME NULL,
  `end_time` DATETIME NULL,
  `course_id` INT NOT NULL,
  `trainer_id` INT NOT NULL,
  `trainer_allocation_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`trainer_allocation_id`),
  INDEX `fk_trainer_allocation_trainer1_idx` (`trainer_id` ASC) VISIBLE,
  CONSTRAINT `fk_train_allocation_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `COURSE`.`course` (`course_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_trainer_allocation_trainer1`
    FOREIGN KEY (`trainer_id`)
    REFERENCES `COURSE`.`trainer` (`trainer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
