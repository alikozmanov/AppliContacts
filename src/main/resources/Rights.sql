
-- ------------------------------------------------------------------------------
-- - Gestion des droits d'accès                                     ---
-- ------------------------------------------------------------------------------
USE contacts;

-- -----------------------------------------------------------------------------
-- - Construction de la table des Users                               ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Users (
	username			varchar(25)		PRIMARY KEY,
	password			varchar(250),
	active				boolean
) ENGINE = InnoDB;

INSERT INTO T_Users (username, password, active) VALUES ( 'azerty',  '$2a$12$Bvgh4OmfFXC/kpysEBlVA.7JeEHnSLiaBaEMywN4TUp0dwcVCvhz2' , '1' );	-- pwd 12345
INSERT INTO T_Users (username, password, active) VALUES ( 'qwerty',  '$2a$12$Bvgh4OmfFXC/kpysEBlVA.7JeEHnSLiaBaEMywN4TUp0dwcVCvhz2' , '1' );

SELECT * FROM T_Users;

-- -----------------------------------------------------------------------------
-- - Construction de la table avec 2 Roles principaux                        ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Roles (
	role 		varchar(25)		PRIMARY KEY
) ENGINE = InnoDB;

INSERT INTO T_Roles (role) VALUES ('ADMIN');
INSERT INTO T_Roles (role) VALUES ('USER');

-- -----------------------------------------------------------------------------
-- - Construction de la table des rôles par utilisateur	                     ---
-- -----------------------------------------------------------------------------
CREATE TABLE T_Users_Roles (
	username 		varchar(25),
	role 			varchar(25),
	PRIMARY KEY(username,role)
) ENGINE = InnoDB;

INSERT INTO T_Users_Roles (username,role) VALUES ('azerty','ADMIN');
INSERT INTO T_Users_Roles (username,role) VALUES ('azerty','USER');
INSERT INTO T_Users_Roles (username,role) VALUES ('qwerty','USER');

