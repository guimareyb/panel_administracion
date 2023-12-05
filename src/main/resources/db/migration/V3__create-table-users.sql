create table users(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL UNIQUE,
  lastname VARCHAR(100) NOT NULL UNIQUE,
  email VARCHAR(100) NOT NULL UNIQUE,
  birthdate DATE NOT NULL,
  identificationDocument VARCHAR(50) NOT NULL UNIQUE,
  nationality VARCHAR(100) NOT NULL,
  registrationDate DATE NOT NULL,
  flag TINYINT NOT NULL,

  PRIMARY KEY (id)
);