create table users(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  lastname VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  birthdate DATE NOT NULL,
  identification_document VARCHAR(50) NOT NULL UNIQUE,
  nationality VARCHAR(100) NOT NULL,
  registration_date DATE NOT NULL,
  flag TINYINT NOT NULL,

  PRIMARY KEY (id)
);