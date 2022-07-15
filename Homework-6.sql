-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema homework_6
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS homework_6 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE homework_6;

-- -----------------------------------------------------
-- Table `homework_6`.`account_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS homework_6.account_table (
  id BIGINT NOT NULL AUTO_INCREMENT,
  city VARCHAR(255) NULL DEFAULT NULL,
  country VARCHAR(255) NULL DEFAULT NULL,
  employee_count INT NOT NULL,
  industry VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `homework_6`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS homework_6.contact (
  id BIGINT NOT NULL AUTO_INCREMENT,
  account_id BIGINT NULL DEFAULT NULL,
  company_name VARCHAR(255) NULL DEFAULT NULL,
  email VARCHAR(255) NULL DEFAULT NULL,
  name VARCHAR(255) NULL DEFAULT NULL,
  phone_number INT NOT NULL,
  sales_rep_id BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `homework_6`.`lead_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS homework_6.lead_table (
  id BIGINT NOT NULL AUTO_INCREMENT,
  company_name VARCHAR(255) NULL DEFAULT NULL,
  email VARCHAR(255) NULL DEFAULT NULL,
  name VARCHAR(255) NULL DEFAULT NULL,
  phone_number INT NOT NULL,
  sales_rep_id BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `homework_6`.`opportunity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS homework_6.opportunity (
  id BIGINT NOT NULL AUTO_INCREMENT,
  account_id BIGINT NULL DEFAULT NULL,
  decision_maker BIGINT NULL DEFAULT NULL,
  product VARCHAR(255) NULL DEFAULT NULL,
  quantity INT NOT NULL,
  sales_rep_id BIGINT NULL DEFAULT NULL,
  status VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `homework_6`.`sales_rep`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS homework_6.sales_rep (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;