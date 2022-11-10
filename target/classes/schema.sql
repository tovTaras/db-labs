CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`seller`
-- -----------------------------------------------------
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `mydb`.`seller` ;
DROP TABLE IF EXISTS `mydb`.`car` ;
DROP TABLE IF EXISTS `mydb`.`customer` ;
DROP TABLE IF EXISTS `mydb`.`dealership` ;
DROP TABLE IF EXISTS `mydb`.`characteristics` ;
DROP TABLE IF EXISTS `mydb`.`order` ;
DROP TABLE IF EXISTS `mydb`.`car_has_dealership` ;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE IF NOT EXISTS `mydb`.`seller` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `cell_phone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `adress` VARCHAR(45) NOT NULL,
  CONSTRAINT seller_pk PRIMARY KEY (`id`)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`car`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `mydb`.`car` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `seller_id` INT NOT NULL,
  `class_of_car` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `is_sold` TINYINT NULL,
  CONSTRAINT car_pk PRIMARY KEY (`id`)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`customer`
-- -----------------------------------------------------


CREATE TABLE IF NOT EXISTS `mydb`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `cell_phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  CONSTRAINT customer_pk PRIMARY KEY (`id`)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`dealership`
-- -----------------------------------------------------


CREATE TABLE IF NOT EXISTS `mydb`.`dealership` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `adress` VARCHAR(45) NOT NULL,
  CONSTRAINT dealership_pk PRIMARY KEY (`id`)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`characteristics`
-- -----------------------------------------------------


CREATE TABLE IF NOT EXISTS `mydb`.`characteristics` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `car_id` INT NOT NULL,
  `serial_number` VARCHAR(45) NOT NULL,
  `is_new` TINYINT NULL,
  `engine` VARCHAR(45) NOT NULL,
  `milage` INT NOT NULL,
  `tank_volume` INT NOT NULL,
  `color` VARCHAR(45) NULL,
  `maintenance` VARCHAR(45) NULL,
  CONSTRAINT characteristics_pk PRIMARY KEY (`id`)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`order`
-- -----------------------------------------------------


CREATE TABLE IF NOT EXISTS `mydb`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `feedback` VARCHAR(45) NULL,
  `seller_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  CONSTRAINT order_pk PRIMARY KEY (`id`)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`car_has_dealership`
-- -----------------------------------------------------


CREATE TABLE IF NOT EXISTS `mydb`.`car_has_dealership` (
  `car_id` INT NOT NULL,
  `dealership_id` INT NOT NULL,
   CONSTRAINT car_has_dealership_pk PRIMARY KEY (`car_id`, `dealership_id`)
  )
ENGINE = InnoDB;

CREATE UNIQUE INDEX name_index ON characteristics (`serial_number`);
CREATE UNIQUE INDEX name_index ON customer (`last_name`);

ALTER TABLE car ADD CONSTRAINT car_seller_id FOREIGN KEY car_seller_id (seller_id)
    REFERENCES seller(id);

ALTER TABLE characteristics ADD CONSTRAINT characteristics_car_id FOREIGN KEY characteristics_car_id (car_id)
    REFERENCES car(id);

ALTER TABLE `order` ADD CONSTRAINT order_seller_id FOREIGN KEY order_seller_id (seller_id)
    REFERENCES seller(id);

ALTER TABLE `order` ADD CONSTRAINT order_customer_id FOREIGN KEY order_customer_id(customer_id)
    REFERENCES customer(id);

ALTER TABLE car_has_dealership ADD CONSTRAINT car_has_dealership_car_id FOREIGN KEY car_has_dealership_car_id(car_id)
    REFERENCES car(id);
    
ALTER TABLE car_has_dealership ADD CONSTRAINT car_has_dealership_dealership_id FOREIGN KEY car_has_dealership_dealership_id(dealership_id)
    REFERENCES dealership(id);

INSERT INTO seller (first_name, last_name, cell_phone, email, adress) VALUES
('vlad', 'tyshookeanskiy', '+380984443070', 'fernanddersten@gmail.com', 'sambir'),
('vlad', 'tyshookeanskiy', '+380984443070', 'fernanddersten@gmail.com', 'sambir'),
('vlad', 'tyshookeanskiy', '+380984443070', 'fernanddersten@gmail.com', 'sambir'),
('vlad', 'tyshookeanskiy', '+380984443070', 'fernanddersten@gmail.com', 'sambir'),
('vlad', 'tyshookeanskiy', '+380984443070', 'fernanddersten@gmail.com', 'sambir'),
('vlad', 'tyshookeanskiy', '+380984443070', 'fernanddersten@gmail.com', 'sambir'),
('vlad', 'tyshookeanskiy', '+380984443070', 'fernanddersten@gmail.com', 'sambir'),
('vlad', 'tyshookeanskiy', '+380984443070', 'fernanddersten@gmail.com', 'sambir'),
('vlad', 'tyshookeanskiy', '+380984443070', 'fernanddersten@gmail.com', 'sambir'),
('vlad', 'tyshookeanskiy', '+380984443070', 'fernanddersten@gmail.com', 'sambir'),
('vlad', 'tyshookeanskiy', '+380984443070', 'fernanddersten@gmail.com', 'sambir'),
('vlad', 'tyshookeanskiy', '+380984443070', 'fernanddersten@gmail.com', 'sambir');

INSERT INTO customer (first_name, last_name, cell_phone, email) VALUES
('anton', 'gavrilov', '+380967887378', 'anthonycoolaf@ukr.net'),
('maryan', 'petlyovaniy', '+380967887378', 'anthonycoolaf@ukr.net'),
('taras', 'fliorko', '+380967887378', 'anthonycoolaf@ukr.net'),
('sasha', 'minaev', '+380967887378', 'anthonycoolaf@ukr.net'),
('ivan', 'voloshansky', '+380967887378', 'anthonycoolaf@ukr.net'),
('pate', 'muda', '+380967887378', 'anthonycoolaf@ukr.net'),
('xdoct', 'yurich', '+380967887378', 'anthonycoolaf@ukr.net'),
('vilat', 'comentor', '+380967887378', 'anthonycoolaf@ukr.net'),
('anton', 'grapos', '+380967887378', 'anthonycoolaf@ukr.net'),
('anton', 'tabul', '+380967887378', 'anthonycoolaf@ukr.net'),
('anton', 'jointov', '+380967887378', 'anthonycoolaf@ukr.net');

INSERT INTO dealership (adress) VALUES
('lviv'),
('sambir'),
('drohobychs'),
('stryi'),
('luky'),
('poltava'),
('kyiv'),
('sambir'),
('lviv'),
('lviv');

INSERT INTO car (seller_id, class_of_car, brand, model, is_sold) VALUES
(3, 'opel', 'figaro', 'mx8', 1),
(2, 'bmw', 'racer', 'mark2', 1),
(11, 'toyota', 'supra', '1996', 1),
(4, 'mercedes', 'buffalo', 'ray3', 1),
(5, 'opel', 'figaro', 'mk5', 1),
(7, 'wolkswagen', 'caddy', 'hire', 1),
(3, 'kats', 'merde', 'gh-13', 1),
(4, 'manta', 'style', 'carry', 1),
(1, 'bkb', '7-seconds', 'musthave', 1),
(4, 'siya', 'trident', 'carry', 1);

INSERT INTO characteristics (car_id, serial_number, is_new, engine, milage, tank_volume, color, maintenance) VALUES
(4, 'vf-456', 1, 'yk', 0, 12, 'black', 'good'),
(4, 'va-456', 0, 'lk', 100000, 13, 'white', 'good'),
(4, 'vx-456', 0, 'gk', 234000, 10, 'red', 'good'),
(4, 'vr-456', 1, 'rk', 0, 10, 'blue', 'bad'),
(4, 'vg-456', 1, 'rk', 0, 9, 'gray', 'good'),
(4, 'hj-456', 0, 'rk', 300000, 15, 'black', 'good'),
(4, 'kj-456', 1, 'gk', 0, 12, 'black', 'good'),
(4, 'hl-456', 1, 'rk', 0, 13, 'black', 'average'),
(4, 'ui-456', 1, 'jk', 0, 11, 'azul', 'good'),
(4, 'ux-456', 1, 'rk', 0, 13, 'black', 'good');

INSERT INTO `order`(feedback, seller_id, customer_id) VALUES
('bad', 3, 5),
('good', 5, 5),
('avverage', 4, 2),
('good', 3, 5),
('good', 3, 5),
('good', 3, 5),
('good', 3, 5),
('good', 3, 5),
('good', 3, 5),
('good', 3, 5),
('good', 3, 5),
('good', 3, 5);


