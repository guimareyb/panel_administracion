create table contents(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL UNIQUE,
  description VARCHAR(500),
  flag TINYINT NOT NULL,

  PRIMARY KEY (id)
);