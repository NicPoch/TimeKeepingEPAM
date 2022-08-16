-- Table: public.Category

-- DROP TABLE IF EXISTS public."Category";

CREATE TABLE IF NOT EXISTS public."Category"
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Category_pkey" PRIMARY KEY (id),
    CONSTRAINT "UniqueCategory" UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Category"
    OWNER to postgres;
-- Table: public.Activity

-- DROP TABLE IF EXISTS public."Activity";

CREATE TABLE IF NOT EXISTS public."Activity"
(
    id bigint NOT NULL,
    "Category_id" bigint NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Activity_pkey" PRIMARY KEY (id),
    CONSTRAINT "FK_Category" FOREIGN KEY ("Category_id")
        REFERENCES public."Category" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Activity"
    OWNER to postgres;
-- Table: public.Role

-- DROP TABLE IF EXISTS public."Role";

CREATE TABLE IF NOT EXISTS public."Role"
(
    id bigint NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Role_pkey" PRIMARY KEY (id),
    CONSTRAINT "RoleName" UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Role"
    OWNER to postgres;
-- Table: public.User

-- DROP TABLE IF EXISTS public."User";

CREATE TABLE IF NOT EXISTS public."User"
(
    id bigint NOT NULL,
    "Role_id" bigint,
    name text COLLATE pg_catalog."default" NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    username text COLLATE pg_catalog."default",
    CONSTRAINT "USER_pkey" PRIMARY KEY (id),
    CONSTRAINT "UniqueUsername" UNIQUE (username),
    CONSTRAINT "FK_Role" FOREIGN KEY ("Role_id")
        REFERENCES public."Role" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."User"
    OWNER to postgres;
-- Table: public.UserActivity

-- DROP TABLE IF EXISTS public."UserActivity";

CREATE TABLE IF NOT EXISTS public."UserActivity"
(
    user_id bigint NOT NULL,
    activity_id bigint NOT NULL,
    CONSTRAINT "UserActivity_pkey" PRIMARY KEY (user_id, activity_id),
    CONSTRAINT "FK_Activity" FOREIGN KEY (activity_id)
        REFERENCES public."Activity" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_User" FOREIGN KEY (user_id)
        REFERENCES public."User" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."UserActivity"
    OWNER to postgres;
-- Table: public.Fix

-- DROP TABLE IF EXISTS public."Fix";

CREATE TABLE IF NOT EXISTS public."Fix"
(
    id bigint NOT NULL,
    "User_id" bigint NOT NULL,
    "Activity_id" bigint NOT NULL,
    "Administrator_id" bigint,
    confirmed boolean NOT NULL DEFAULT false,
    comment text COLLATE pg_catalog."default" NOT NULL,
    "timestamp" timestamp with time zone NOT NULL,
    CONSTRAINT "Fix_pkey" PRIMARY KEY (id),
    CONSTRAINT "FK_Activity" FOREIGN KEY ("Activity_id")
        REFERENCES public."Activity" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_Administrator" FOREIGN KEY ("Administrator_id")
        REFERENCES public."User" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "FK_User" FOREIGN KEY ("User_id")
        REFERENCES public."User" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Fix"
    OWNER to postgres;