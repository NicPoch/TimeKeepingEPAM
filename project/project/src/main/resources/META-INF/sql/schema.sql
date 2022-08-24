CREATE TABLE States
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) UNIQUE NOT NULL,
    description varchar(500)
);

CREATE TABLE Categories
(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(200) UNIQUE NOT NULL,
    description varchar(500),
    PRIMARY KEY (id)
);


CREATE TABLE Users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    username varchar(50) UNIQUE NOT NULL,
    password varchar(65) NOT NULL,
    mail varchar(50) UNIQUE NOT NULL
);

CREATE TABLE Administrators(
    id INT AUTO_INCREMENT PRIMARY KEY,
    role varchar(50) NOT NULL,
    FOREIGN KEY (id) REFERENCES Users(id)
);
CREATE TABLE Clients(
    id INT AUTO_INCREMENT PRIMARY KEY,
    company varchar(50) NOT NULL,
    FOREIGN KEY (id) REFERENCES Users(id)
);