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