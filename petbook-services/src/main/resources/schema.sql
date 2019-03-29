CREATE TABLE address (
  id INTEGER NOT NULL AUTO_INCREMENT,
  lookup_name VARCHAR(64),
  PRIMARY KEY (id)
);

CREATE TABLE account (
  id INTEGER NOT NULL AUTO_INCREMENT,
  lookup_name VARCHAR(64),
  email_address VARCHAR(64),
  password VARCHAR(64),
  first_name VARCHAR(64),
  last_name VARCHAR(64),
  phone_number VARCHAR(64),
  birthday_date VARCHAR(64),
  address_id VARCHAR(64),
  PRIMARY KEY (id),
  FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE CASCADE
);
