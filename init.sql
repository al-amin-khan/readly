-- Database: readly

-- DROP DATABASE IF EXISTS readly;

CREATE DATABASE readly
    WITH
--     OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.UTF-8'
    LC_CTYPE = 'en_US.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;



-- Table: public.books

-- DROP TABLE IF EXISTS public.books;

CREATE TABLE IF NOT EXISTS public.books
(
    id bigint NOT NULL,
    author character varying(255) COLLATE pg_catalog."default",
    cover bytea,
    description text COLLATE pg_catalog."default",
    genre character varying(255) COLLATE pg_catalog."default",
    isbn bigint,
    language character varying(255) COLLATE pg_catalog."default",
    pages bigint,
    published_date timestamp without time zone,
    rating character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT books_pkey PRIMARY KEY (id)
    )




-- Table: public.bookshelves

-- DROP TABLE IF EXISTS public.bookshelves;

CREATE TABLE IF NOT EXISTS public.bookshelves
(
    id bigint NOT NULL,
    added_date timestamp without time zone,
    finished_date timestamp without time zone,
    reading_status bigint,
    remarks text COLLATE pg_catalog."default",
    start_date timestamp without time zone,
    book_id bigint,
    CONSTRAINT bookshelves_pkey PRIMARY KEY (id),
    CONSTRAINT fkdqvpl9080fdywbo5moourtrlt FOREIGN KEY (book_id)
    REFERENCES public.books (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )




