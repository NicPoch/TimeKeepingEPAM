--CREATE TABLE Users
--(
--    id INT ,
--    name varchar(50) NOT NULL,
--    username varchar(50) UNIQUE NOT NULL,
--    password varchar(50)  NOT NULL,
--    mail varchar(50) UNIQUE NOT NULL,
--    PRIMARY KEY (id)
--);

--CREATE TABLE Administrators
--(
--    id INT,
--    user_id INT UNIQUE NOT NULL,
--    PRIMARY KEY (id),
--    CONSTRAINT user_id UNIQUE (user_id),
--    CONSTRAINT FK_Administrator_User FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE
--);

--CREATE TABLE Clients
--(
--    id INT,
--    user_id INT UNIQUE NOT NULL,
--    PRIMARY KEY (id),
--    CONSTRAINT user_id UNIQUE (user_id),
--    CONSTRAINT FK_Clients_User FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE
--);

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

--CREATE TABLE Activities
--(
--    id INT NOT NULL,
--    assignee_id INT NOT NULL,
--    category_id INT NOT NULL,
--    state_id INT NOT NULL,
--    name varchar(50) NOT NULL,
--    start date NOT NULL,
--    end date NOT NULL,
--    missingHours double NOT NULL,
--    description varchar(50),
--   completedHours double NOT NULL,
--    PRIMARY KEY (id),
--    CONSTRAINT FK_Activity_User FOREIGN KEY (assignee_id) REFERENCES Users(id) ON DELETE CASCADE,
--    CONSTRAINT FK_Activity_Category FOREIGN KEY (category_id) REFERENCES Categories(id) ON DELETE CASCADE,
--    CONSTRAINT FK_Activity_State FOREIGN KEY (state_id) REFERENCES States(id) ON DELETE CASCADE
--);

--CREATE TABLE Timecard
--(
--    id INT NOT NULL,
--    client_id INT NOT NULL,
--    activity_id INT NOT NULL,
--    title varchar(50) COLLATE pg_catalog."default" NOT NULL,
--    comment varchar(50) COLLATE pg_catalog."default",
--    hours double precision NOT NULL,
--    "timestamp" time with time zone NOT NULL,
--    CONSTRAINT "Timecard_pkey" PRIMARY KEY (id),
--    CONSTRAINT "FK_Activityid" FOREIGN KEY (activity_id)
--        REFERENCES public."Activity" (id) MATCH SIMPLE
--        ON UPDATE NO ACTION
--        ON DELETE NO ACTION,
--    CONSTRAINT "FK_Clientid" FOREIGN KEY (client_id)
--        REFERENCES public."Client" (user_id) MATCH SIMPLE
--        ON UPDATE NO ACTION
--        ON DELETE NO ACTION
--);

--CREATE TABLE Request
--(
--    id INT NOT NULL,
--    client_id INT NOT NULL,
--    activity_id INT NOT NULL,
--    type varchar(50) COLLATE pg_catalog."default" NOT NULL,
--    CONSTRAINT "Request_pkey" PRIMARY KEY (id),
--    CONSTRAINT "FK_Clientid" FOREIGN KEY (client_id)
--        REFERENCES public."Client" (id) MATCH SIMPLE
--        ON UPDATE NO ACTION
--        ON DELETE NO ACTION,
--    CONSTRAINT "FK_activityId" FOREIGN KEY (activity_id)
--        REFERENCES public."Activity" (id) MATCH SIMPLE
--        ON UPDATE NO ACTION
--        ON DELETE NO ACTION
--);