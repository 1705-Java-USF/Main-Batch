--2.1 SELECT
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO is null;

--2.2 ORDER BY
SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;

--2.3 INSERT TO
INSERT INTO GENRE VALUES(26, 'Country');
INSERT INTO GENRE VALUES(27, 'Techno');
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES(9, 'Bobson', 'Bobbert');
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (10, 'Odif', 'Fido');
INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (60, 'John', 'Smith', 'SmithJohn@gmail.com');
INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (61, 'Bobbert', 'Bobson', 'BobTheBobbest@gmail.com');

--2.4 UPDATE
UPDATE CUSTOMER
  SET FIRSTNAME = 'Robert',
  LASTNAME = 'Walter'
  WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
UPDATE ARTIST
  SET NAME = 'CCR'
  WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM INVOICE
  WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
SELECT * FROM INVOICE
  WHERE TOTAL BETWEEN 15 and 50;
SELECT * FROM EMPLOYEE
  WHERE HIREDATE BETWEEN '01-JUN-03' and '01-MAR-04';

--2.7 DELETE
--Disabled constraint in table options
DELETE FROM CUSTOMER
  WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';


--3.1 System Defined Functions
CREATE OR REPLACE FUNCTION get_current_time
  RETURN VARCHAR2
  IS
  BEGIN
    RETURN (TO_CHAR(SYSTIMESTAMP, 'HH:MI:SS'));
  END;
  
CREATE OR REPLACE FUNCTION get_length_of_mediatype(mediatype_id IN NUMBER)
  RETURN NUMBER
  IS
    Len NUMBER;
  BEGIN
    SELECT LENGTH(NAME) INTO Len FROM MEDIATYPE WHERE MEDIATYPEID = mediatype_id;
    RETURN Len;
  END;

--3.2 System Defined Aggregate Functions
CREATE OR REPLACE FUNCTION average_total_of_invoices
  RETURN NUMBER
  IS
    average NUMBER;
  BEGIN
    SELECT AVG(TOTAL) INTO average FROM INVOICE;
    RETURN average;
  END;

CREATE OR REPLACE FUNCTION most_expensive_track
  RETURN NUMBER
  IS 
    max_price NUMBER;
  BEGIN
    SELECT MAX(UNITPRICE) INTO max_price FROM TRACK;
    RETURN max_price;
  END;

--3.3 User Defined Scalar Functions
CREATE OR REPLACE FUNCTION average_price_of_invoiceline
  RETURN NUMBER
  IS
    average NUMBER;
  BEGIN
    SELECT AVG(UNITPRICE) INTO average FROM INVOICELINE;
    RETURN average;
  END;

--3.4 User Defined Table Valued Functions
CREATE OR REPLACE TYPE ID_FIRST_LAST AS OBJECT (
Employee_Id number,
First_Name varchar2(100),
Last_Name varchar2(100)
);
CREATE OR REPLACE TYPE ID_FIRST_LAST_TABLE AS TABLE OF ID_FIRST_LAST;
CREATE OR REPLACE FUNCTION employees_born_after_1968
  RETURN ID_FIRST_LAST_TABLE AS
    result_table ID_FIRST_LAST_TABLE;
  BEGIN
    SELECT CAST(MULTISET(SELECT EMPLOYEEID, FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE TO_CHAR(BIRTHDATE,'YY') > 68)
    AS ID_FIRST_LAST_TABLE)
    INTO result_table
    FROM DUAL;
    RETURN result_table;
  END;
SELECT * FROM Table(employees_born_after_1968);

--4.1 Basic Stored Procedure
CREATE OR REPLACE PROCEDURE select_names_of_employees(cursorParam OUT SYS_REFCURSOR)
  IS
  BEGIN
    OPEN cursorParam FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
  END;

DECLARE
  fc_cursor SYS_REFCURSOR;
  first_name EMPLOYEE.FIRSTNAME%type;
  last_name EMPLOYEE.LASTNAME%type;
BEGIN
  select_names_of_employees(fc_cursor);
  LOOP
    FETCH fc_cursor INTO first_name, last_name;
    EXIT WHEN fc_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('Name: ' || first_name || ' ' || last_name);
  END LOOP;
END;

--4.2 Stored Procedure Input Parameters
CREATE OR REPLACE PROCEDURE update_employee_info(id IN NUMBER, new_first_name IN EMPLOYEE.FIRSTNAME%type, new_last_name IN EMPLOYEE.LASTNAME%type)
IS
BEGIN
  UPDATE EMPLOYEE
  SET FIRSTNAME = new_first_name, LASTNAME = new_last_name
  WHERE EMPLOYEEID = id;
END;

BEGIN
  update_employee_info(9,'Bobbert','Bobson');
END;

CREATE OR REPLACE PROCEDURE get_managers_of_employee(id IN NUMBER, specific_manager OUT NUMBER, general_manager OUT NUMBER)
IS
  employee_title varchar2(100);
BEGIN
  SELECT SUBSTR(TITLE,0,2)INTO employee_title  FROM EMPLOYEE WHERE EMPLOYEEID = id;
  SELECT EMPLOYEEID INTO specific_manager FROM EMPLOYEE WHERE TITLE LIKE employee_title||'%Manager';
  SELECT EMPLOYEEID INTO general_manager FROM EMPLOYEE WHERE TITLE LIKE 'General%Manager';
END;

DECLARE
  general_manager NUMBER;
  specific_manager NUMBER;
BEGIN
  get_managers_of_employee(8, specific_manager, general_manager);
  DBMS_OUTPUT.PUT_LINE('General Manager''s ID: ' || general_manager || ' - Specific Manager''s ID: ' || specific_manager);
END;

--4.3 Stored Procedure Output Parameters
CREATE OR REPLACE PROCEDURE get_customer_info(customer_id IN NUMBER, first_name OUT CUSTOMER.FIRSTNAME%type, last_name OUT CUSTOMER.LASTNAME%type, company_name OUT CUSTOMER.COMPANY%type)
IS
BEGIN
  SELECT FIRSTNAME INTO first_name FROM CUSTOMER WHERE CUSTOMERID = customer_id;
  SELECT LASTNAME INTO last_name FROM CUSTOMER WHERE CUSTOMERID = customer_id;
  SELECT COMPANY INTO company_name FROM CUSTOMER WHERE CUSTOMERID = customer_id;
END;

DECLARE
  first_name CUSTOMER.FIRSTNAME%type;
  last_name CUSTOMER.LASTNAME%type;
  company_name CUSTOMER.COMPANY%type;
BEGIN
  get_customer_info(5, first_name, last_name, company_name);
  DBMS_OUTPUT.PUT_LINE('Customer: ' || first_name || ' ' || last_name || ', Company: ' || company_name);
END;

--5.0 Transactions
DECLARE
  invoice_id NUMBER := 150;
BEGIN
  DELETE FROM INVOICE WHERE INVOICEID = invoice_id;
END;

CREATE OR REPLACE PROCEDURE new_customer(id IN NUMBER, first_name IN CUSTOMER.FIRSTNAME%type, last_name IN CUSTOMER.LASTNAME%type, new_email IN CUSTOMER.EMAIL%type)
IS
BEGIN
  INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (id, first_name, last_name, new_email);
END;

DECLARE
  id NUMBER := 200;
  first_name VARCHAR2(100) := 'Bobbert';
  last_name VARCHAR2(100) := 'Bobson';
  new_email VARCHAR2(100) := 'BobTheBob@gmail.com';
BEGIN
  new_customer(id, first_name, last_name, new_email);
END;
  
--6.1 AFTER/FOR
CREATE OR REPLACE TRIGGER new_employee_trigger
AFTER INSERT ON EMPLOYEE
for each row
BEGIN
  DBMS_OUTPUT.PUT_LINE('ID: ' || :new.EMPLOYEEID || ', Name: ' || :new.FIRSTNAME || ' ' || :new.LASTNAME);
END;

CREATE OR REPLACE TRIGGER update_album_trigger
AFTER UPDATE ON ALBUM
for each row
BEGIN
  DBMS_OUTPUT.PUT_LINE('Album ID: ' || :new.ALBUMID || ', TITLE: ' || :new.TITLE);
END;

CREATE OR REPLACE TRIGGER delete_customer_trigger
AFTER INSERT ON CUSTOMER
for each row
BEGIN
  DBMS_OUTPUT.PUT_LINE('ID: ' || :new.CUSTOMERID || ', Name: ' || :new.FIRSTNAME || ' ' || :new.LASTNAME);
END;

--7.1 INNER
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
order by LASTNAME;

--7.2 OUTER
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
ORDER BY CUSTOMER.CUSTOMERID, INVOICE.INVOICEID;

--7.3 RIGHT
SELECT ARTIST.NAME, ALBUM.TITLE FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID
ORDER BY ARTIST.ARTISTID, ALBUM.TITLE;

--7.4 CROSS
SELECT ARTIST.ARTISTID, ARTIST.NAME as ARTISTNAME, ALBUM.ALBUMID, ALBUM.TITLE FROM ALBUM
JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID
ORDER BY ARTIST.NAME;

--7.5 SELF
SELECT * FROM EMPLOYEE A
JOIN EMPLOYEE B
ON A.REPORTSTO = B.REPORTSTO;

--9.0 Administration
--BACKUP DATABASE Chinook TO DISK='C:\Users\David\Desktop\Revature\SQL\Chinook.bak';

--I can't seem to find a method of backing up the database that works. Online references point towards
--using the above commented command. The keywords highlight as if they're recognized, however it gives
--an error that the command isn't recognized.


