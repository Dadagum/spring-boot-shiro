CREATE TABLE users (
  username VARCHAR(30),
  password VARCHAR(300),
  salt VARCHAR(100),
  uid INT(11) AUTO_INCREMENT,
  PRIMARY KEY (uid)
)engine=InnoDB;


CREATE TABLE roles (
  rid INT (11) AUTO_INCREMENT,
  description VARCHAR (30),
  PRIMARY KEY (rid)
)engine=InnoDB;

CREATE TABLE permissions(
  pid INT (11) AUTO_INCREMENT,
  description VARCHAR (30),
  PRIMARY KEY (pid)
)engine=InnoDB;

CREATE TABLE user_roles (
  uid INT (11),
  rid INT (11),
  PRIMARY KEY (rid, uid),
  FOREIGN KEY (rid) REFERENCES roles(rid),
  FOREIGN KEY (uid) REFERENCES users(uid)
)engine=InnoDB;


CREATE TABLE roles_permissions (
  pid INT (11),
  rid INT (11),
  PRIMARY KEY (pid, rid),
  FOREIGN KEY (rid) REFERENCES roles(rid),
  FOREIGN KEY (pid) REFERENCES permissions(pid)
)engine=InnoDB;