CREATE SCHEMA IF NOT EXISTS `syvak_lab_7`;
USE `syvak_lab_7`;

DROP TABLE IF EXISTS `syvak_lab_7`.`user_has_book`;
DROP TABLE IF EXISTS `syvak_lab_7`.`tree_catalog`;
DROP TABLE IF EXISTS `syvak_lab_7`.`password`;
DROP TABLE IF EXISTS `syvak_lab_7`.`user`;
DROP TABLE IF EXISTS `syvak_lab_7`.`link`;
DROP TABLE IF EXISTS `syvak_lab_7`.`book`;

CREATE TABLE IF NOT EXISTS `syvak_lab_7`.`book`
(
    `id` INT PRIMARY KEY  NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) ,
    `author` VARCHAR(45),
    `UDC` INT ,
    `rating` INT ,
    `link_id` INT
);
    
CREATE TABLE IF NOT EXISTS `syvak_lab_7`.`link`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `email_book_address` VARCHAR(45) NOT NULL,
    `book_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
);

CREATE TABLE IF NOT EXISTS `syvak_lab_7`.`user`
(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `login` VARCHAR(45) NOT NULL,
    `surname` VARCHAR(45) NOT NULL,
    `name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `birth_date` INT NOT NULL,
    `birth_place` VARCHAR(45) NOT NULL,
    `residence_place` VARCHAR(45) NOT NULL,
    `note` VARCHAR(45) NOT NULL,
    `rating` FLOAT NOT NULL,
	`password_id` INT NOT NULL
);
    
    CREATE TABLE `syvak_lab_7`.`tree_catalog`
    (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`heading` VARCHAR(45) NOT NULL,
    `book_id` INT,
    `tree_catalog_id` INT
);    

    CREATE TABLE IF NOT EXISTS `syvak_lab_7`.`password`
(
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `password` VARCHAR(45) 
);
    
	CREATE TABLE IF NOT EXISTS `syvak_lab_7`.`user_has_book`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `book_id` INT NOT NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE `user_has_book`
    ADD UNIQUE (book_id, user_id);    