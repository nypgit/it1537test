DROP TABLE memberids;

DROP TABLE member;

CREATE TABLE memberids (
	member_id INT NOT NULL,
	PRIMARY KEY (member_id)
) ENGINE=InnoDB;

CREATE TABLE member (
	member_id VARCHAR(30) NOT NULL,
	name VARCHAR(45),
	tel VARCHAR(12),
	username VARCHAR(45) NOT NULL,
	password VARCHAR(45) NOT NULL,
	PRIMARY KEY (member_id)
) ENGINE=InnoDB;

