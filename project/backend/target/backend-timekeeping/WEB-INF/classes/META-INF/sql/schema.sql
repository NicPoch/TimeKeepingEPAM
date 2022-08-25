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
CREATE TABLE Activities(
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    missingHours FLOAT NOT NULL,
    completedHours FLOAT NOT NULL,
    description VARCHAR(200) NOT NULL,
    assignee_id int not null,
    category_id int not null,
    state_id int not null,
    FOREIGN KEY (assignee_id) REFERENCES Clients(id),
    FOREIGN KEY (category_id) REFERENCES Categories(id),
    FOREIGN KEY (state_id) REFERENCES States(id)
);