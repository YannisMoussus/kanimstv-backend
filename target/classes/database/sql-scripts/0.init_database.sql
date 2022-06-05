CREATE SCHEMA piloti;

CREATE TABLE piloti.role_permission (
    id			SMALLSERIAL,
    name		VARCHAR(50) NOT NULL,
    PRIMARY KEY ( id )
);

CREATE TABLE piloti.member_incubator (
    id					SMALLSERIAL,
    pseudonyme			VARCHAR(50),
    email		        VARCHAR(50),
    phone_number	    VARCHAR(255),
    is_old_member       BOOLEAN,
    password            VARCHAR(255),
    PRIMARY KEY ( id )
);

CREATE TABLE piloti.members_role_permission (
	member_incubator_id		SMALLINT	NOT NULL,
	role_permission_id		SMALLINT	NOT NULL,
	PRIMARY KEY (member_incubator_id	, role_permission_id),
	CONSTRAINT members_role_permission_member_fkey FOREIGN KEY (member_incubator_id) REFERENCES piloti.member_incubator (id) MATCH SIMPLE,    	
    CONSTRAINT roles_permission_member_fkey FOREIGN KEY (role_permission_id) REFERENCES piloti.role_permission (id) MATCH SIMPLE
);

CREATE TABLE piloti.movies (
    id                  SMALLSERIAL,
    name                VARCHAR(50),
    description         VARCHAR(50),
    duration            VARCHAR(50),
    released_date       VARCHAR(50),
    bill                bytea,
    age_limit           VARCHAR(50),
    mark                VARCHAR(50),
);

INSERT INTO piloti.role_permission (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO piloti.role_permission (id, name) VALUES (2, 'ROLE_RH');
INSERT INTO piloti.role_permission (id, name) VALUES (3, 'ROLE_VISU');
ALTER SEQUENCE piloti.member_incubator_id_seq RESTART WITH 4;


INSERT INTO piloti.member_incubator (id, pseudonyme, email, phone_number, is_old_member) VALUES (1, 'LANCELEUR', 'jeremie.lanceleur@pole-emploi.fr', '06.46.60.90.74', FALSE);
INSERT INTO piloti.member_incubator (id, pseudonyme, email, phone_number, is_old_member) VALUES (2, 'DETRES', 'lucas.detre@gmail.com', null, FALSE);
INSERT INTO piloti.member_incubator (id, pseudonyme, email, phone_number, is_old_member) VALUES (3, 'PUERTOLAS', 'anais.puetolas@pole-emploi.fr', null, FALSE);
ALTER SEQUENCE piloti.member_incubator_id_seq RESTART WITH 4;





