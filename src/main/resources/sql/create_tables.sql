CREATE TABLE IF NOT EXISTS users(
    ID int NOT NULL AUTO_INCREMENT,
    login varchar(255) NOT NULL,
    pass varchar(255) NOT NULL,
    mail varchar(255) NOT NULL,
    photo mediumblob,
    PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS contacts(
    ID int NOT NULL AUTO_INCREMENT,
    nom varchar(255) NOT NULL,
    prenom varchar(255),
    mail varchar(255),
    telephone varchar(20),
    photo mediumblob,
    PRIMARY KEY(ID)
);
