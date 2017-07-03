CREATE TABLE ERS_USERS
(   user_id number(5) not null primary key,
    user_role_id number(5) not null,
    user_username varchar2(2000) not null unique,
    user_password varchar2(2000) not null,
    user_first_name varchar2(1000),
    user_last_name varchar2(1000),
    user_email varchar2(3000) unique
)
ALTER TABLE ERS_USERS
    ADD CONSTRAINT userroleid_to_userroleid_fk FOREIGN KEY (user_role_id)
            REFERENCES ERS_USERS_ROLES(user_role_id);
    
ALTER TABLE ERS_USERS
    rename column status to user_status;

CREATE TABLE ERS_USERS_ROLES
(   user_role_id number(5) not null primary key,
    user_role varchar(2000)
)
INSERT INTO ERS_USERS_ROLES
    VALUES (3, 'inactive');
DELETE FROM ERS_USERS_ROLES
    WHERE USER_ROLE_ID = 3;

CREATE TABLE ERS_REIMBURSEMENTS
(   rebs_id number(5) not null primary key,
    user_id_author number(5) not null,
    user_id_resolver number(5),
    rebs_type number(5) not null,
    rebs_status number(5) not null,
    rebs_amount number(22,2) not null,
    rebs_description varchar2(3000),
    rebs_receipt blob,
    rebs_submitted timestamp not null,
    rebs_resolved timestamp,
    
    CONSTRAINT author_to_id_fk FOREIGN KEY (user_id_author) -- adding a constraint from within the table maker
            REFERENCES ERS_USERS(user_id),
    CONSTRAINT rebstype_to_typeid_fk FOREIGN KEY (rebs_type)
            REFERENCES ERS_REIMBURSEMENT_TYPE(rebs_type_id),
    CONSTRAINT rebsstatus_to_rebsid_fk FOREIGN KEY (rebs_status)
            REFERENCES ERS_REIMBURSEMENT_STATUS(rebs_status_id)
)
ALTER TABLE ERS_REIMBURSEMENTS  -- adding constratings from outside
    ADD CONSTRAINT resolver_to_id_fk FOREIGN KEY (user_id_resolver)
            REFERENCES ERS_USERS(user_id);

CREATE TABLE ERS_REIMBURSEMENT_STATUS
(   rebs_status_id number(5) not null primary key,
    rebs_status varchar2(1000) not null
)

CREATE TABLE ERS_REIMBURSEMENT_TYPE
(   rebs_type_id number(5) not null primary key,
    rebs_type varchar2(1000) not null
)


INSERT INTO ERS_REIMBURSEMENTS(rebs_id, user_id_author, user_id_resolver, rebs_type, rebs_status, rebs_amount, rebs_description, rebs_receipt, rebs_submitted, rebs_resolved)
    VALUES (1, 1, null, 1, 1, '10', 'testing', null, '12-SEP-12 10:31:19', null);
    

select * from ERS_USERS;
SELECT * FROM ERS_USERS WHERE USER_USERNAME = 'lucas' AND USER_PASSWORD = 'p4ssw0rd';

CREATE SEQUENCE USERS_SEQ  -- creating a sequence for my trigger
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER USERS_SEQ_TRIGGER  -- trigger to auto increment user_id
BEFORE INSERT ON ERS_USERS
FOR EACH ROW
BEGIN
    IF :NEW.USER_ID IS NULL THEN
      SELECT USERS_SEQ.nextval INTO :NEW.USER_ID FROM dual;
    END IF;
END;

CREATE SEQUENCE REBS_SEQ  -- creating a sequence for my reimbursement trigger
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER REBS_SEQ_TRIGGER  -- trigger to auto increment user_id
BEFORE INSERT ON ERS_REIMBURSEMENTS
FOR EACH ROW
BEGIN
    IF :NEW.REBS_ID IS NULL THEN
      SELECT REBS_SEQ.nextval INTO :NEW.REBS_ID FROM dual;
    END IF;
END;

update ers_users set user_role_id = 1, USER_USERNAME = 'test', USER_PASSWORD = 'test', USER_FIRST_NAME = 'Test', USER_LAST_NAME = 'Tester2', USER_EMAIL = 'test@gmail.com', USER_STATUS = 2 WHERE user_id = 10;
commit;
