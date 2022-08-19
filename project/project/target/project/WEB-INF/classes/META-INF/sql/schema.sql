CREATE TABLE States
(
    id INT NOT NULL,
    name varchar(50) UNIQUE NOT NULL,
    description varchar(500),
    PRIMARY KEY (id)
);

CREATE TABLE Categories
(
    id INT NOT NULL,
    name varchar(200) UNIQUE NOT NULL,
    description varchar(500),
    PRIMARY KEY (id)
);