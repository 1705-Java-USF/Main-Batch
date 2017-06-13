--2.1
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE
WHERE lower(LASTNAME) = 'king';
SELECT * FROM EMPLOYEE
WHERE lower(FIRSTNAME) = 'andrew' 
AND lower(LASTNAME) = 'king';

--2.2
SELECT * FROM ALBUM
ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY;

--2.3
INSERT INTO GENRE VALUES (26, 'Hello');
INSERT INTO GENRE VALUES (27, 'This is a genre');

INSERT INTO EMPLOYEE VALUES(9, 'Lastname', 'Firstname', 'title', 1, '08-MAR-2', 
'1-APR-2017', 'This is an address', 'City', 'State', 'Country', 'Pos Cod', 
12224441234, 13335554321, 'email@email.gov');

INSERT INTO EMPLOYEE VALUES(10, 'Spy', 'Not a', 'IT Security', 1, '26-FEB-92', 
'1-JUN-2017', '1234 Spy Dr.', 'Spy City', 'Some State', 'Another Country', 'SNA STM', 
12224441234, 13335554321, 'bestspy223@spyinginc.net');

INSERT INTO CUSTOMER VALUES(60, 'FakeLastName', 'FakeFirstName', 'FakeCompany',
'1234 Fake St.','Fake City', 'Fake State', 'Fake country', '00000',
12224441234, 13335554321, 'phony@gmail.net',5);

INSERT INTO CUSTOMER VALUES(61, 'Troll', 'Not a', 'Troll Inc.', 'Under a bridge', 
'Detroit', 'MI', 'USA', '1337', 
12224441234, 13335554321, 'anonymous@yahoo.io',5);

--2.4 
UPDATE CUSTOMER 
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME ='Mitchell';

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5
SELECT * 
FROM INVOICE
WHERE BILLINGADDRESS like 'T%';

--2.6
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 30;

SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '1-JUN-03' AND '01-MAR-04';

--2.7
ALTER TABLE CUSTOMER
    DROP CONSTRAINT FK_CUSTOMERSUPPORTREPID;
ALTER TABLE CUSTOMER
ADD CONSTRAINT FK_CUSTOMERSUPPORTREPID
    FOREIGN KEY(SUPPORTREPID)
    REFERENCES EMPLOYEE(EMPLOYEEID)
    ON DELETE CASCADE;
ALTER TABLE INVOICE
    DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID
    FOREIGN KEY(CUSTOMERID)
    REFERENCES CUSTOMER(CUSTOMERID)
    ON DELETE CASCADE;
ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID
    FOREIGN KEY(INVOICEID)
    REFERENCES INVOICE(INVOICEID)
    ON DELETE CASCADE;

ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINETRACKID;
ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINETRACKID
    FOREIGN KEY (TRACKID)
    REFERENCES TRACK(TRACKID)
    ON DELETE CASCADE;
    
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3.1
CREATE OR REPLACE FUNCTION currentTime
RETURN TIMESTAMP
AS
BEGIN
    RETURN CURRENT_TIMESTAMP;
END;

CREATE OR REPLACE FUNCTION get_length(mediaType in varchar2)
RETURN NUMBER
AS
BEGIN
    RETURN length(mediaType);
END;

SELECT currentTime FROM dual;
SELECT get_length(NAME) FROM MEDIATYPE;

--3.2

CREATE OR REPLACE FUNCTION average_invoice_total
RETURN NUMBER
IS
    avg_total NUMBER;
BEGIN
    SELECT avg(total) into avg_total from invoice;
    RETURN avg_total;
END;
SELECT average_invoice_total FROM dual;

CREATE OR REPLACE FUNCTION max_cost_track
RETURN VARCHAR2
IS
     tname VARCHAR2(120);
BEGIN
    SELECT name INTO tname FROM track
    WHERE ROWNUM = 1
    ORDER BY UNITPRICE;
    RETURN tname;
END;
SELECT max_cost_track from dual;
--3.3

CREATE OR REPLACE FUNCTION avg_invoiceline_price
RETURN NUMBER
IS
    avg_price NUMBER;
BEGIN
    SELECT avg(unitprice) INTO avg_price FROM invoiceline;
    RETURN avg_price;
END;

SELECT avg_invoiceline_price FROM dual;

CREATE OR REPLACE TYPE employee_short_rec AS OBJECT(
    employeeid NUMBER,
    lastname VARCHAR(120),
    firstname VARCHAR(120),
    birthdate DATE
);
/
CREATE OR REPLACE TYPE employee_short_rec_tbl IS TABLE OF employee_short_rec;
/
CREATE OR REPLACE FUNCTION get_em_aft_68
    RETURN employee_short_rec_tbl
IS
    e_tab employee_short_rec_tbl := employee_short_rec_tbl();
    CURSOR cur IS
    SELECT employeeid, lastname, firstname, birthdate FROM EMPLOYEE
    WHERE birthdate > '31-DEC-68';
    eid NUMBER;
    ln VARCHAR2(120);
    fn VARCHAR2(120);
    bd VARCHAR2(120);
BEGIN
    OPEN cur;
    LOOP
        FETCH cur INTO eid, ln, fn, bd;
        EXIT WHEN cur%NOTFOUND;
        e_tab.extend;
        e_tab(e_tab.last) := employee_short_rec(eid,ln,fn,bd);
    END LOOP;
    CLOSE cur;
    RETURN e_tab;
END;
SELECT *
FROM table(get_em_aft_68);

--4.1
CREATE OR REPLACE PROCEDURE get_all_emp_names
IS
    CURSOR cur IS
    SELECT firstname, lastname FROM EMPLOYEE;
    fname VARCHAR(120);
    lname VARCHAR(120);
BEGIN
    OPEN cur;
    LOOP
        FETCH cur INTO fname, lname;
        EXIT WHEN cur%NOTFOUND;
        dbms_output.put_line(fname || ' ' || lname);
    END LOOP;
    CLOSE cur;
END;

CALL get_all_emp_names();

--4.2

CREATE OR REPLACE PROCEDURE update_emp_lname(new_lname IN VARCHAR2, old_lname IN VARCHAR2)
IS
BEGIN
    UPDATE employee SET lastname = new_lname
    WHERE lastname = old_lname;
END;

CALL update_emp_lname('newLastname', 'Lastname');

CREATE OR REPLACE PROCEDURE get_manager(eid IN NUMBER, mid OUT NUMBER)
IS
BEGIN
    SELECT reportsto INTO mid FROM employee
    WHERE employeeid = eid;
END;

DECLARE
    eid NUMBER := 4;
    mid NUMBER;
BEGIN
    get_manager(eid, mid);
    dbms_output.put_line('Id of manager ' || mid);
END;

CREATE OR REPLACE PROCEDURE get_name_company_cust(cid IN NUMBER, n OUT VARCHAR2, com OUT VARCHAR2)
IS
BEGIN
    SELECT firstname || ' ' || lastname , company into n, com FROM customer
    WHERE customerid = cid;
END;

DECLARE
    cid NUMBER := 5;
    n VARCHAR2(120);
    com VARCHAR2(120);
BEGIN
    get_name_company_cust(cid, n, com);
    dbms_output.put_line('Name: ' || n || ' Company: ' || com);
END;

--5.0

CREATE OR REPLACE PROCEDURE delete_invoice(id IN NUMBER)
IS
BEGIN
    SAVEPOINT pre_delete_invoice;
    
    DELETE FROM invoice
    WHERE invoiceid = id;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK TO pre_delete_invoice;
        RAISE;
END;

DECLARE
    id NUMBER := 66; -- Delete Invoice, sixty-six.
BEGIN
    delete_invoice(66);
    commit;
END;

CREATE OR REPLACE PROCEDURE insert_customer(id IN NUMBER, fname IN VARCHAR2, 
lname IN VARCHAR2, company IN VARCHAR2, address IN VARCHAR2, 
city IN VARCHAR2, state IN VARCHAR2, country IN VARCHAR2, 
postalcode IN VARCHAR2, phone IN VARCHAR2, fax IN VARCHAR2, 
email IN VARCHAR2, support_rep IN NUMBER)
IS
BEGIN
    SAVEPOINT pre_insert;
    INSERT INTO CUSTOMER
    VALUES(id,fname,lname,company,address,city,state,country,postalcode,phone,
    fax,email,support_rep);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK TO pre_insert;
        RAISE;
END;

DECLARE
    id NUMBER := 62;
    fname VARCHAR2(120) := 'Bob';
    lname VARCHAR2(120) := 'Smith';
    company  VARCHAR2(120) := 'Smith industries';
    address  VARCHAR2(120) := '123 Smith street';
    city  VARCHAR2(120) := 'Smithville';
    state  VARCHAR2(120) := 'Minesota';
    country  VARCHAR2(120) := 'Duchy of Smithland';
    postalcode  VARCHAR2(120) := '1337';
    phone  VARCHAR2(120) := '10911111198';
    fax VARCHAR2(120) := '';
    email  VARCHAR2(120) := 'bob.smith@aol.com';
    support_rep VARCHAR2(120) := 3;
BEGIN
    insert_customer(id,fname,lname,company,address,city,state,country,
    postalcode,phone,fax,email,support_rep);
    commit;
END;

CREATE OR REPLACE TRIGGER after_insert
AFTER INSERT
    ON employee
BEGIN
    dbms_output.put_line('An insert just occured on the employee table');
    
END;

CREATE OR REPLACE TRIGGER after_update
AFTER UPDATE
    ON album
BEGIN
    dbms_output.put_line('An update has just occured on the album table');
END;

CREATE OR REPLACE TRIGGER after_delete
AFTER DELETE
    ON customer
BEGIN
    dbms_output.put_line('A delete has just occured on the customer table');
END;


--7.1 Inner Join
SELECT customer.firstname || ' ' || customer.lastname AS FULLNAME,
invoiceid FROM customer
INNER JOIN invoice 
ON customer.customerid = invoice.customerid;

--7.2 Full Outer Join
SELECT customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM customer
FULL OUTER JOIN invoice
ON customer.customerid = invoice.customerid;
--7.3 Right Outer Join
SELECT album.title, artist.name 
FROM album
RIGHT OUTER JOIN artist
ON album.artistid = artist.artistid;

--7.4 Cross join
SELECT artist.name AS name, album.title FROM album
CROSS JOIN artist
ORDER BY artist.name;

--7.5 Self Join
SELECT a.firstname || ' ' || a.lastname AS employee,
b.firstname || ' ' || b.lastname AS manager
FROM employee a, employee b
WHERE a.reportsto = b.employeeid;
commit;

/*
    Apparently the method for creating backups for Oracle databases involve
    RMAN which does not create .bak files when it creates a backup.
*/