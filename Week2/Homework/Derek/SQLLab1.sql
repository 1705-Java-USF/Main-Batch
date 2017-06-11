--Derek Sirp SQL LAB
--2.1
SELECT * FROM Employee;

SELECT * FROM Employee
WHERE LASTNAME = 'King';

SELECT * FROM Employee
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO is null;

--2.2
SELECT * FROM ALBUM
ORDER BY TITLE desc;

SELECT FIRSTNAME, CITY FROM CUSTOMER
ORDER BY CITY;

--2.3
INSERT ALL 
    INTO GENRE (GENREID, NAME) VALUES (26, 'Electro Swing')
    INTO GENRE (GENREID, NAME) VALUES (27, 'Drumstep')
SELECT * FROM DUAL;

INSERT ALL 
    INTO EMPLOYEE VALUES (9, 'Johnson', 'Bobbert', 'Sales Manager', 1, '17-MAR-82', '23-APR-07', '1212 21 ST E', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 267-2536', '+1 (780) 267-3867', 'bobbert@chinookcorp.com')
    INTO EMPLOYEE VALUES (10, 'Richards', 'Joshua', 'IT Staff', 6, '8-NOV-79', '28-FEB-05', '3142 14 ST W', 'Lethbridge', 'AB', 'Canada', 'T5K 2N1', '+1 (403) 267-2536', '+1 (403) 267-3867', 'joshua@chinookcorp.com')
SELECT * FROM DUAL;

INSERT ALL 
    INTO CUSTOMER VALUES (60, 'Junior', 'Bobby', 'JetBrains s.r.o.', '1212 21 ST E', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 623-9264', 'null', 'juniorb@gmail.com.com', 3)
    INTO CUSTOMER VALUES (61, 'Sirp', 'Derek', 'null', '3142 14 ST W', 'Lethbridge', 'AB', 'Canada', 'T5K 2N1', '+1 (403) 374-0589', 'null', 'sirpd@yahoo.com', 4)
SELECT * FROM DUAL;

--2.4
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5
select * from invoice
where BILLINGADDRESS like 'T%';

--2.6
SELECT * FROM INVOICE
WHERE TOTAL between 15 and 50;

SELECT * FROM EMPLOYEE
WHERE HIREDATE between '01-JUN-03' and '01-MAR-04';

--2.7
alter table invoice
drop constraint fk_invoicecustomerid;

alter table invoice
add constraint fk_customerid
foreign key (customerid) references customer(customerid)
ON DELETE CASCADE;

alter table invoiceline
drop constraint fk_invoicelineinvoiceid;

alter table invoiceline
add constraint fk_invoiceid
foreign key (invoiceid) references invoice(invoiceid)
ON DELETE CASCADE;

delete from customer
where firstname = 'Robert' AND lastname = 'Walter';

--3.1
CREATE OR REPLACE FUNCTION get_t
    RETURN VARCHAR2
    IS t VARCHAR2(4000);
    
    BEGIN
        t := to_char(sysdate, 'HH12:MI:SS');
        RETURN t;
    END;

BEGIN
    dbms_output.put_line(get_t());
END;

CREATE OR REPLACE FUNCTION get_len_media
    RETURN NUMBER
    IS len_media NUMBER;
    
    BEGIN
        SELECT length(NAME) INTO len_media FROM MEDIATYPE
        WHERE MEDIATYPEID = 1;
        RETURN len_media;
    END;

DECLARE
    len_media NUMBER;
BEGIN
    len_media := get_len_media();
    DBMS_OUTPUT.PUT_LINE('Length of mediatype is: ' || len_media);
END;

--3.2
CREATE OR REPLACE FUNCTION get_avg_inv
    RETURN NUMBER
    IS avg_inv NUMBER;
    
    BEGIN
        SELECT avg(TOTAL) into avg_inv from INVOICE;
        RETURN avg_inv;
    END;

DECLARE
    avg_inv NUMBER;
BEGIN
    avg_inv := get_avg_inv();
    DBMS_OUTPUT.PUT_LINE('Average total of all invoices is: ' || avg_inv);
END;

UPDATE TRACK
SET UNITPRICE = '2.00'
WHERE NAME = 'Basketball';

CREATE OR REPLACE FUNCTION get_expens_track
RETURN NUMBER
IS
    max_price NUMBER;
BEGIN
    SELECT max(UNITPRICE) into max_price from TRACK;
    RETURN max_price;
END;

DECLARE
    max_price NUMBER;
BEGIN
    max_price := get_expens_track();
    DBMS_OUTPUT.PUT_LINE('Most expensive track value is: ' || max_price);
END;

--3.3
CREATE OR REPLACE FUNCTION get_avg_inv
    RETURN NUMBER
    IS avg_inv NUMBER;
    
    BEGIN
        SELECT avg(UNITPRICE) into avg_inv from INVOICELINE;
        RETURN avg_inv;
    END;

DECLARE
    avg_inv NUMBER;
BEGIN
    avg_inv := get_avg_inv();
    DBMS_OUTPUT.PUT_LINE('Average price of invoiceline items is: ' || avg_inv);
END;

--3.4
CREATE OR REPLACE TYPE t_col as object (FIRSTNAME VARCHAR2(30), LASTNAME VARCHAR2(30), BIRTHDATE DATE);
CREATE OR REPLACE TYPE t_nested_table AS TABLE OF t_col;

CREATE OR REPLACE FUNCTION get_emp_1968
    RETURN t_nested_table AS
        v_ret t_nested_table;
    BEGIN
        SELECT CAST(MULTISET(
            SELECT FIRSTNAME, LASTNAME, BIRTHDATE
            FROM EMPLOYEE
            WHERE BIRTHDATE >= TO_DATE('01-JAN-68'))
            AS t_nested_table)
        INTO v_ret
        FROM DUAL;
        RETURN v_ret;
    END get_emp_1968;

SELECT * FROM TABLE(get_emp_1968);

--4.1
CREATE OR REPLACE PROCEDURE get_all_names(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursorParam FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;

DECLARE
    name_cursor SYS_REFCURSOR;
    first_name EMPLOYEE.FIRSTNAME%TYPE;
    last_name EMPLOYEE.LASTNAME%TYPE;
BEGIN
    get_all_names(name_cursor);
    
    LOOP
        FETCH name_cursor INTO first_name, last_name;
        EXIT WHEN name_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(first_name || ' ' || last_name);
    END LOOP;
END;

--4.2
CREATE OR REPLACE PROCEDURE update_info(id IN EMPLOYEE.EMPLOYEEID%TYPE)
IS
BEGIN
    UPDATE EMPLOYEE SET
        LASTNAME = 'Curry',
        FIRSTNAME = 'Stephen',
        TITLE = 'Ball Player',
        REPORTSTO = null,
        BIRTHDATE = '14-MAR-88',
        HIREDATE = '22-APR-07',
        ADDRESS = '1210 21 ST E',
        CITY = 'Edmonton',
        STATE = 'AB',
        COUNTRY = 'Canada',
        POSTALCODE = 'T5K 2N1',
        PHONE = '+1 (780) 834-2054',
        FAX = 'null',
        EMAIL = 'darealmvp@yahoo.com'
    WHERE EMPLOYEEID = id;
        
    commit;
END; 

BEGIN
    update_info(3);
END;

CREATE OR REPLACE PROCEDURE get_manag(id IN EMPLOYEE.EMPLOYEEID%TYPE)
IS
    m_first_name EMPLOYEE.FIRSTNAME%TYPE;
    m_last_name EMPLOYEE.LASTNAME%TYPE;
    report EMPLOYEE.REPORTSTO%TYPE;
BEGIN
    SELECT REPORTSTO INTO report FROM EMPLOYEE WHERE EMPLOYEEID = id;
    SELECT FIRSTNAME, LASTNAME INTO m_first_name, m_last_name FROM EMPLOYEE WHERE EMPLOYEEID = report;
    DBMS_OUTPUT.PUT_LINE('The manager for the requested employee is ' || m_first_name || ' ' || m_last_name);
END; 

BEGIN
    get_manag(5); 
END;

--4.3
CREATE OR REPLACE PROCEDURE get_namecomp(id IN CUSTOMER.CUSTOMERID%TYPE, c_first_name OUT CUSTOMER.FIRSTNAME%TYPE, c_last_name OUT CUSTOMER.FIRSTNAME%TYPE, comp OUT CUSTOMER.COMPANY%TYPE)
IS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY INTO c_first_name, c_last_name, comp FROM CUSTOMER WHERE CUSTOMERID = id;
END;

DECLARE
    c_first_name VARCHAR2(40 BYTE);
    c_last_name VARCHAR2(20 BYTE);
    comp VARCHAR2(80 BYTE);
BEGIN
    get_namecomp(1, c_first_name, c_last_name, comp);
    DBMS_OUTPUT.PUT_LINE('The name of the requested customer is ' || c_first_name || ' ' || c_last_name || ' and there company they work for is: ' || comp);
END;

--5.0
CREATE OR REPLACE PROCEDURE del_inv(id IN INVOICE.INVOICEID%TYPE)
IS
BEGIN
    DELETE FROM INVOICE WHERE INVOICEID = id;
    DBMS_OUTPUT.PUT_LINE('Invoice deleted');
    commit;
END; 

BEGIN
    del_inv(1); 
END;

CREATE OR REPLACE PROCEDURE ins_rec(id IN CUSTOMER.CUSTOMERID%TYPE)
IS
BEGIN
    INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
        VALUES(
        id,
        'Stephen',
        'Curry',
        'NBA',
        '7000 Coliseum Way',
        'Oakland',
        'CA',
        'United States',
        '94621',
        '+1 (780) 834-2054',
        null,
        'darealmvp@gmail.com',
        null);
    commit;
END;

BEGIN
    ins_rec(62);
END;

--6.0
CREATE OR REPLACE TRIGGER emp_rec_trigger
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:NEW.EMPLOYEEID);
END;

CREATE OR REPLACE TRIGGER alb_upd_trigger
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:NEW.ALBUMID);
END;

CREATE OR REPLACE TRIGGER del_cust_trigger
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.CUSTOMERID);
END;

--7.1
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
    FROM CUSTOMER
    INNER JOIN INVOICE ON
    CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.2
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
    FROM CUSTOMER
    FULL OUTER JOIN INVOICE ON
    CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3
SELECT ARTIST.NAME,ALBUM.TITLE FROM ALBUM
    RIGHT JOIN ARTIST ON
    ALBUM.ARTISTID = ARTIST.ARTISTID;

--7.4
SELECT * FROM ALBUM
    CROSS JOIN ARTIST
    ORDER BY NAME;

--7.5
SELECT * FROM EMPLOYEE T1, EMPLOYEE T2
    WHERE T1.REPORTSTO = T2.REPORTSTO;
    
--9.0
/*
    Ran into issues with user privileges for accessing rman, however worked
    and could login on my original user where I first tried installing things.
    Couldn't access into database there though for whatever reason and obv
    can't connect to chinook there, so I'm at an impass here with no privileges.
*/

