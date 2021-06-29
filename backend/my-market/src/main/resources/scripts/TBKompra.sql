-- DROP SEQUENCE public.role_id_seq;

CREATE SEQUENCE public.role_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.role_permission_id_seq;

CREATE SEQUENCE public.role_permission_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.permission_id_seq;

CREATE SEQUENCE public.permission_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.stock_id_seq;

CREATE SEQUENCE public.stock_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.review_id_seq;

CREATE SEQUENCE public.review_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	product_id varchar NOT NULL,
	product_name varchar not NULL,
	price numeric not NULL,
	description varchar NULL,
	CONSTRAINT product_pk PRIMARY KEY (product_id)
);


-- public."role" definition

-- Drop table

-- DROP TABLE public."role";

CREATE TABLE public."role" (
	role_id numeric NOT NULL DEFAULT nextval('role_id_seq'::regclass),
	title varchar not NULL,
	description varchar NULL,
	CONSTRAINT role_pk PRIMARY KEY (role_id)
);


-- public."permission" definition

-- Drop table

-- DROP TABLE public."permission";

CREATE TABLE public."permission" (
	permission_id numeric NOT NULL DEFAULT nextval('permission_id_seq'::regclass),
	title varchar not NULL,
	description varchar not NULL,
	CONSTRAINT permission_pk PRIMARY KEY (permission_id)
);


-- public."user" definition

-- Drop table

-- DROP TABLE public."user";

CREATE TABLE public."user" (
	dni varchar NOT NULL DEFAULT 1,
	username varchar NOT NULL,
	"password" varchar not null,
	"name" varchar not NULL,
	lastname varchar not NULL,
	mail varchar NULL,
	address varchar NULL,
	phone numeric NULL,
	birth date NULL,
	id_role numeric NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (dni),
	CONSTRAINT user_fk FOREIGN KEY (id_role) REFERENCES public."role"(role_id)
);


-- public.review definition

-- Drop table

-- DROP TABLE public.review;

CREATE TABLE public.review (
	review_id numeric NOT NULL DEFAULT nextval('review_id_seq'::regclass),
	subject varchar NULL,
	description varchar NULL,
	"date" date NULL,
	score numeric NULL,
	product_id varchar NULL,
	user_dni varchar NULL,
	CONSTRAINT review_pk PRIMARY KEY (review_id),
	CONSTRAINT review_fk FOREIGN KEY (product_id) REFERENCES public.product(product_id),
	CONSTRAINT review_fk2 FOREIGN KEY (user_dni) REFERENCES public."user"(dni)
);


-- public.role_permission definition

-- Drop table

-- DROP TABLE public.role_permission;

CREATE TABLE public.role_permission (
	role_permission_id numeric NOT NULL DEFAULT nextval('role_permission_id_seq'::regclass),
	permission_id numeric not NULL,
	id_role numeric not NULL,
	CONSTRAINT role_permission_pk PRIMARY KEY (role_permission_id),
	CONSTRAINT role_permission_fk FOREIGN KEY (id_role) REFERENCES public."role"(role_id),
	CONSTRAINT role_permission_fk2 FOREIGN KEY (permission_id) REFERENCES public."permission"(permission_id)
);


-- public.stock definition

-- Drop table

-- DROP TABLE public.stock;

CREATE TABLE public.stock (
	stock_id numeric NOT NULL DEFAULT nextval('stock_id_seq'::regclass),
	quantity numeric not NULL,
	product_id varchar not NULL,
	CONSTRAINT stock_pk PRIMARY KEY (stock_id),
	CONSTRAINT stock_fk FOREIGN KEY (product_id) REFERENCES public.product(product_id)
);