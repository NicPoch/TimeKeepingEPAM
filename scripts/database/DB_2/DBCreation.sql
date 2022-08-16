-- Table: public.User

-- DROP TABLE IF EXISTS public."User";

CREATE TABLE IF NOT EXISTS public."User"
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    username text COLLATE pg_catalog."default" NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    mail text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "User_pkey" PRIMARY KEY (id),
    CONSTRAINT "UniqueMail" UNIQUE (mail),
    CONSTRAINT "UniqueUsername" UNIQUE (username)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."User"
    OWNER to postgres;
-- Table: public.Administrator

-- DROP TABLE IF EXISTS public."Administrator";

CREATE TABLE IF NOT EXISTS public."Administrator"
(
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT "PK_id" PRIMARY KEY (id),
    CONSTRAINT user_id UNIQUE (user_id),
    CONSTRAINT "FK_User" FOREIGN KEY (user_id)
        REFERENCES public."User" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Administrator"
    OWNER to postgres;
-- Table: public.Client

-- DROP TABLE IF EXISTS public."Client";

CREATE TABLE IF NOT EXISTS public."Client"
(
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT "Client_pkey" PRIMARY KEY (id),
    CONSTRAINT "UniqueUser" UNIQUE (user_id),
    CONSTRAINT "FK_User" FOREIGN KEY (user_id)
        REFERENCES public."User" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Client"
    OWNER to postgres;
-- Table: public.State

-- DROP TABLE IF EXISTS public."State";

CREATE TABLE IF NOT EXISTS public."State"
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    CONSTRAINT "State_pkey" PRIMARY KEY (id),
    CONSTRAINT "UniqueName" UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."State"
    OWNER to postgres;
-- Table: public.Category

-- DROP TABLE IF EXISTS public."Category";

CREATE TABLE IF NOT EXISTS public."Category"
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    CONSTRAINT "Category_pkey" PRIMARY KEY (id),
    CONSTRAINT "UniqueNameCategory" UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Category"
    OWNER to postgres;
-- Table: public.Activity

-- DROP TABLE IF EXISTS public."Activity";

CREATE TABLE IF NOT EXISTS public."Activity"
(
    id bigint NOT NULL,
    assignee_id bigint NOT NULL,
    category_id bigint NOT NULL,
    state_id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    start date NOT NULL,
    "end" date NOT NULL,
    "missingHours" double precision NOT NULL,
    description text COLLATE pg_catalog."default",
    "completedHours" double precision NOT NULL,
    CONSTRAINT "Activity_pkey" PRIMARY KEY (id),
    CONSTRAINT "FK_Assignee" FOREIGN KEY (assignee_id)
        REFERENCES public."Client" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_Category" FOREIGN KEY (category_id)
        REFERENCES public."Category" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_State" FOREIGN KEY (state_id)
        REFERENCES public."State" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Activity"
    OWNER to postgres;
-- Table: public.Timecard

-- DROP TABLE IF EXISTS public."Timecard";

CREATE TABLE IF NOT EXISTS public."Timecard"
(
    id bigint NOT NULL,
    client_id bigint NOT NULL,
    activity_id bigint NOT NULL,
    title text COLLATE pg_catalog."default" NOT NULL,
    comment text COLLATE pg_catalog."default",
    hours double precision NOT NULL,
    "timestamp" time with time zone NOT NULL,
    CONSTRAINT "Timecard_pkey" PRIMARY KEY (id),
    CONSTRAINT "FK_Activityid" FOREIGN KEY (activity_id)
        REFERENCES public."Activity" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_Clientid" FOREIGN KEY (client_id)
        REFERENCES public."Client" (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Timecard"
    OWNER to postgres;
-- Table: public.Request

-- DROP TABLE IF EXISTS public."Request";

CREATE TABLE IF NOT EXISTS public."Request"
(
    id bigint NOT NULL,
    client_id bigint NOT NULL,
    activity_id bigint NOT NULL,
    type text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Request_pkey" PRIMARY KEY (id),
    CONSTRAINT "FK_Clientid" FOREIGN KEY (client_id)
        REFERENCES public."Client" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_activityId" FOREIGN KEY (activity_id)
        REFERENCES public."Activity" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Request"
    OWNER to postgres;