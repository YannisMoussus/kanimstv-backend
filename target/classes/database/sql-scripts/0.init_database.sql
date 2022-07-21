DROP TABLE IF EXISTS role_permission, member_incubator, members_role_permission, movie;


CREATE TABLE role_permission (
    id			SMALLSERIAL,
    name		VARCHAR(50) NOT NULL,
    PRIMARY KEY ( id )
);

CREATE TABLE member_incubator (
    id					SMALLSERIAL,
    pseudonyme			VARCHAR(50),
    email		        VARCHAR(50),
    phone_number	    VARCHAR(255),
    is_old_member       BOOLEAN,
    password            VARCHAR(255),
    PRIMARY KEY ( id )
);

CREATE TABLE members_role_permission (
	member_incubator_id		SMALLINT	NOT NULL,
	role_permission_id		SMALLINT	NOT NULL,
	PRIMARY KEY (member_incubator_id	, role_permission_id),
	CONSTRAINT members_role_permission_member_fkey FOREIGN KEY (member_incubator_id) REFERENCES member_incubator (id) MATCH SIMPLE,    	
    CONSTRAINT roles_permission_member_fkey FOREIGN KEY (role_permission_id) REFERENCES role_permission (id) MATCH SIMPLE
);

CREATE TABLE movie (
    id                  SMALLSERIAL,
    name                VARCHAR(50),
    description         VARCHAR(255),
    trailer             VARCHAR(255),
    duration            VARCHAR(50),
    released_date       VARCHAR(50),
    bill                bytea,
    age_limit           VARCHAR(50),
    mark                VARCHAR(50)
);

INSERT INTO role_permission (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role_permission (id, name) VALUES (2, 'ROLE_RH');
INSERT INTO role_permission (id, name) VALUES (3, 'ROLE_VISU');
ALTER SEQUENCE role_permission_id_seq RESTART WITH 4;


