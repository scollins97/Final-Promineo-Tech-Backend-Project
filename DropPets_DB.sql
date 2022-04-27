DROP DATABASE IF EXISTS pets_db;
CREATE DATABASE pets_db;
USE pets_db;
DROP TABLE IF EXISTS ownership;
DROP TABLE IF EXISTS owner_pet;
DROP TABLE IF EXISTS pet;
DROP TABLE IF EXISTS contact_info;

CREATE TABLE ownership(
owner_id INT NOT NULL AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
gender ENUM('F','M'),
PRIMARY KEY(owner_id)
);

CREATE TABLE pet(
pet_id INT NOT NULL AUTO_INCREMENT,
pet_name VARCHAR(50) NOT NULL,
cat_or_dog ENUM('Cat','Dog') NOT NULL,
DOB DATE,
breed VARCHAR(50),
color VARCHAR(30),
gender ENUM('F','M') NOT NULL,
PRIMARY KEY(pet_id)
);

CREATE TABLE owner_pet(
pet_id INT,
owner_id INT,
PRIMARY KEY(owner_id, pet_id),
FOREIGN KEY(pet_id) REFERENCES pet(pet_id),
FOREIGN KEY(owner_id) REFERENCES ownership(owner_id)
);

CREATE TABLE contact_info(
contact_id INT NOT NULL AUTO_INCREMENT,
owner_id INT,
address VARCHAR(100) NOT NULL,
phone VARCHAR(11) NOT NULL,
email VARCHAR(320),
PRIMARY KEY(contact_id),
FOREIGN KEY(owner_id) REFERENCES ownership(owner_id)
);