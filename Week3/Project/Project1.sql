SAVEPOINT this_is_safe;

CREATE TABLE ers_user_roles
(
      ur_id NUMBER(6) PRIMARY KEY NOT NULL,
      ur_role VARCHAR2(40 BYTE)
);
INSERT INTO ers_user_roles VALUES(1, 'User');
INSERT INTO ers_user_roles VALUES(2, 'Manager');

CREATE TABLE ers_reinburse_status
(
    rs_id NUMBER(6) PRIMARY KEY NOT NULL,
    rs_status VARCHAR2(30 BYTE) NOT NULL
);
INSERT INTO ers_reinburse_status VALUES(1, 'Pending');
INSERT INTO ers_reinburse_status VALUES(2, 'Resolved');



CREATE TABLE ers_reinburse_type
(
    rt_id NUMBER(6) PRIMARY KEY NOT NULL,
    rt_type VARCHAR2(30 BYTE) NOT NULL
);
INSERT INTO ers_reinburse_type VALUES(0, 'Pickle Rick');
INSERT INTO ers_reinburse_type VALUES(1, 'Portalgun');
INSERT INTO ers_reinburse_type VALUES(2, 'Plumbus');
INSERT INTO ers_reinburse_type VALUES(3, 'Meeseeks Box');
INSERT INTO ers_reinburse_type VALUES(4, 'Mega Seed');


CREATE TABLE ers_users
(
    u_id NUMBER(10,0) PRIMARY KEY NOT NULL,
    u_username VARCHAR2(40 BYTE) UNIQUE NOT NULL,
    u_password VARCHAR2(40 BYTE) NOT NULL,
    u_firstname VARCHAR2(30 BYTE),
    u_lastname VARCHAR2(30 BYTE),
    u_email VARCHAR2(1000 BYTE) UNIQUE,
    uR_id NUMBER(10,0) NOT NULL,
    CONSTRAINT u_id2ur_id FOREIGN KEY (uR_id) REFERENCES ers_user_roles(ur_id)
);

CREATE SEQUENCE ers_users_seq
  start with 1
  increment by 1;

CREATE OR REPLACE TRIGGER ers_users_seq_trigger
BEFORE INSERT ON ers_users
FOR EACH ROW
BEGIN 
  IF :new.u_id IS NULL THEN 
    select ers_users_seq.nextval into :new.u_id from dual;
  END IF;
END;  

CREATE OR REPLACE PROCEDURE insert_ers_users_procedure(some_user_name IN VARCHAR2, some_pass IN VARCHAR2, some_ur_id IN NUMBER)
IS
BEGIN
  INSERT INTO ers_users(u_username, u_password, uR_id) VALUES(some_user_name, some_pass, some_ur_id);
  COMMIT;
END;

BEGIN
    insert_ers_users_procedure('valfirpo', '1234', 1);
END;


CREATE TABLE ers_reinburse
(
    r_id NUMBER(10,0) PRIMARY KEY NOT NULL,
    r_ammount NUMBER(22,2) NOT NULL,
    r_description VARCHAR2(100 BYTE),
    r_receipt VARCHAR2(100 BYTE),
    r_submitted TIMESTAMP NOT NULL, --YYYY-MM-DD HH:MI:SS
    r_resolved TIMESTAMP,
    u_id_author NUMBER(10,0) NOT NULL,
    u_id_resolver NUMBER(10,0),
    rt_type NUMBER(10,0) NOT NULL,
    rs_status NUMBER(10,0) NOT NULL,
    CONSTRAINT u_id_author2u_id FOREIGN KEY (u_id_author)     REFERENCES ers_users(u_id),
    CONSTRAINT u_id_resolver2u_id FOREIGN KEY (u_id_resolver) REFERENCES ers_users(u_id),
    CONSTRAINT rt_type2rt_id FOREIGN KEY (rt_type)            REFERENCES ers_reinburse_type(rt_id),
    CONSTRAINT rs_status2rs_id FOREIGN KEY (rs_status)        REFERENCES ers_reinburse_status(rs_id)
);

/*
ALTER TABLE ers_reinburse
DROP CONSTRAINT u_id_author2u_id;

ALTER TABLE ers_reinburse
ADD CONSTRAINT u_id_author2u_id 
FOREIGN KEY (u_id_author) REFERENCES ers_users(u_id);

ALTER TABLE ers_reinburse
DROP CONSTRAINT u_id_resolver2u_id;

ALTER TABLE ers_reinburse
ADD CONSTRAINT u_id_resolver2u_id 
FOREIGN KEY (u_id_resolver) REFERENCES ers_users(u_id);


ALTER TABLE ers_reinburse
DROP COLUMN r_receipt;

ALTER TABLE ers_reinburse
ADD r_receipt VARCHAR2(100 BYTE);
*/

--Reinburstment seq
CREATE SEQUENCE ers_reinburse_seq
  start with 1
  increment by 1;
  
--Reinburstment trigger
CREATE OR REPLACE TRIGGER ers_reinburs_seq_trigger
BEFORE INSERT ON ers_reinburse
FOR EACH ROW
BEGIN 
  IF :new.r_id IS NULL THEN 
    select ers_reinburse_seq.nextval into :new.r_id from dual;
  END IF;
END; 

CREATE OR REPLACE PROCEDURE insert_ers_reinburse_procedure(s_ammount IN NUMBER, s_description IN VARCHAR2, s_receipt IN VARCHAR,
                                                                 r_resolved IN TIMESTAMP, s_id_author IN NUMBER, 
                                                                s_id_resolver IN NUMBER, s_rt_type IN NUMBER, s_rs_status IN NUMBER)

IS s_submitted TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO s_submitted FROM dual;
    INSERT INTO ers_reinburse(r_ammount, r_description, r_receipt, r_submitted, r_resolved, u_id_author, u_id_resolver, rt_type, rs_status) 
    VALUES                   (s_ammount, s_description, s_receipt, s_submitted, r_resolved, s_id_author, s_id_resolver, s_rt_type, s_rs_status);
    COMMIT;
END;

BEGIN 
    insert_ers_reinburse_procedure(14.77, null, null, NULL, 2, 2, 1,1);
END;

INSERT INTO ers_users VALUES (3,'rick','sanch', null, null, null, 2);

CREATE OR REPLACE PROCEDURE update_ers_reinburse_procedure(s_r_id IN NUMBER, s_resolver IN NUMBER)
IS s_resolved TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO s_resolved FROM dual;
    UPDATE ers_reinburse SET u_id_resolver = s_resolver, r_resolved = s_resolved, rs_status = 2 WHERE r_id = s_r_id;
    COMMIT;
END;

BEGIN
    update_ers_reinburse_procedure(70, 3);
END;

SELECT * FROM ers_user_roles;
SELECT * FROM ers_reinburse_status;
SELECT * FROM ers_reinburse_type;
SELECT * FROM ers_users ORDER BY U_ID ASC;
SELECT * FROM ERS_REINBURSE ORDER BY r_ID ASC;


TRUNCATE TABLE ers_users;

TRUNCATE TABLE ERS_REINBURSE;

COMMIT;

drop table ers_reinburse;
DROP TABLE ers_users;
DROP TABLE ers_user_roles;
DROP TABLE ers_reinburse_status;
DROP TABLE ers_reinburse_type;



--Stop Drop and Roll
BEGIN
   FOR cur_rec IN (SELECT object_name, object_type
                     FROM user_objects
                    WHERE object_type IN
                             ('TABLE',
                              'VIEW',
                              'PACKAGE',
                              'PROCEDURE',
                              'FUNCTION',
                              'SEQUENCE'
                             ))
   LOOP
      BEGIN
         IF cur_rec.object_type = 'TABLE'
         THEN
            EXECUTE IMMEDIATE    'DROP '
                              || cur_rec.object_type
                              || ' "'
                              || cur_rec.object_name
                              || '" CASCADE CONSTRAINTS';
         ELSE
            EXECUTE IMMEDIATE    'DROP '
                              || cur_rec.object_type
                              || ' "'
                              || cur_rec.object_name
                              || '"';
         END IF;
      EXCEPTION
         WHEN OTHERS
         THEN
            DBMS_OUTPUT.put_line (   'FAILED: DROP '
                                  || cur_rec.object_type
                                  || ' "'
                                  || cur_rec.object_name
                                  || '"'
                                 );
      END;
   END LOOP;
END;








ROLLBACK this_is_safe;


