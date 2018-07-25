CREATE TABLE users (
  username VARCHAR(30),
  password VARCHAR(300),
  salt VARCHAR(100),
  PRIMARY KEY (username)
)engine=InnoDB;


CREATE TABLE roles_permissions (
  roleDes VARCHAR (30),
  permDes VARCHAR (30),
  PRIMARY KEY (roleDes, permDes)
)engine=InnoDB;

CREATE TABLE user_roles (
  username VARCHAR(30),
  roleDes VARCHAR (30),
  PRIMARY KEY (username, roleDes),
  FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (roleDes) REFERENCES roles_permissions(roleDes) ON DELETE CASCADE ON UPDATE CASCADE
)engine=InnoDB;
