create table permissions(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL UNIQUE,
  content_id  BIGINT NOT NULL,
  flag TINYINT NOT NULL,

  PRIMARY KEY (id),
  CONSTRAINT fk_permissions_contents_id FOREIGN KEY (content_id) REFERENCES contents(id)
);