--2.0 SQL Queries

--2.1 SELECT 
SELECT * FROM employee;

SELECT * FROM employee
WHERE LASTNAME = 'King';

Select * FROM employee
WHERE FIRSTNAME = 'Andrew' and REPORTSTO is NULL;

-- 2.2 ORDER by
SELECT * FROM album
ORDER BY TITLE DESC;

SELECT FIRSTNAME FROM customer
ORDER BY CITY;

--2.3 INSERT INTO
INSERT INTO genre VALUES(26,'Boogie');
INSERT INTO genre VALUES(27,'Reggae');

INSERT INTO Employee VALUES(9,'Joseph', 'Jonathan', NULL, NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO Employee VALUES(10,'Cornel', 'Cornelius', NULL, NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

INSERT INTO Customer VALUES(60,'Clark', 'Jonathan', NULL, NULL,NULL,NULL,NULL,NULL,NULL,NULL,'cjon@gmail.com',NULL);
INSERT INTO Customer VALUES(61,'Eric', 'Cornelius', NULL, NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CthaMan@theboys.com',NULL);

--2.4 UPDATE
UPDATE CUSTOMER
Set FirstName = 'Robert', 
    LastName= 'Walter' 
WHERE lower(FirstName) = 'aaron' and lower(LastName) = 'mitchell';

UPDATE Artist
Set Name = 'CRC'
WHERE Name = 'Creedence Clearwater Revival';

--2.5 LIKE

SELECT * FROM invoice 
WHERE BILLINGADDRESS like 'T%';

--2.6 BETWEEN
SELECT * FROM invoice
WHERE total BETWEEN 15 and 20;

SELECT * FROM EMPLOYEE
WHERE hiredate BETWEEN TO_DATE('2003/06/01', 'yyyy/mm/dd') and TO_DATE('2004/06/01', 'yyyy/mm/dd');

--2.7 DELETE

DELETE FROM Invoiceline
WHERE invoiceID in (SELECT Invoiceid FROM Invoice
WHERE customerID = 32);

DELETE FROM Invoice
WHERE customerID = 32;

DELETE FROM Customer
WHERE lower(FirstName) = 'robert' and lower(LastName) = 'walter';


-------------------------------------------------------------------------------------------------------------------------------------

--3.0 SQL Functions

--3.1 SYSTEM DEFINED FUNCTIONS
CREATE OR REPLACE FUNCTION get_c_time
RETURN varchar2
IS
  
BEGIN
    RETURN to_char(SYSDATE(), 'HH24:MI:SS');
END;

-----

CREATE OR REPLACE FUNCTION get_m_length(med varchar2)
RETURN NUMBER
IS
  
BEGIN
    RETURN length(med);
END;

--3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS

CREATE OR REPLACE FUNCTION get_avg_total (TOTAL number)
RETURN NUMBER
IS
avgt NUMBER;

BEGIN
     SELECT avg(total) into avgt from Invoice;
  RETURN avgt;
END;

----------
CREATE OR REPLACE FUNCTION get_e_track (met varchar2)
RETURN varchar2
IS 
mext track.name%type;

BEGIN
     SELECT NAME into mext from TRACK
     WHERE UNITPRICE = (SELECT max(UNITPRICE) FROM TRACK);
  RETURN mext;
END;

--3.3 USER DEFINCED SCALAR FUNCTIONS

CREATE OR REPLACE FUNCTION get_avg_price (UNITPRICE number)
RETURN NUMBER
IS
avgt INVOICELINE.UNITPRICE%type;

BEGIN
     SELECT avg(UNITPRICE) into avgt from InvoiceLine;
  RETURN avgt;
END;

--3.4 USER DEFINED TABLE VALUE FUNCTIONS
CREATE OR REPLACE FUNCTION get_emp 
RETURN SYS_REFCURSOR

IS
cursorP SYS_REFCURSOR;

BEGIN
 OPEN cursorP FOR
     SELECT *
     FROM EMPLOYEE 
     WHERE BIRTHDATE > TO_DATE('1968-09-31','YYYY-MM-DD');
  RETURN cursorP;
END;


---------------------------------------------------------------------------------------------------------------

--4.0 BASIC STORED PROCEDURE

--4.1 BASIC STORED PROCEDURE
CREATE OR REPLACE PROCEDURE get_emp 

IS
cursorP SYS_REFCURSOR;

BEGIN
 OPEN cursorP FOR
     SELECT FIRSTNAME, LASTNAME
     FROM EMPLOYEE;
  
END;

--4.2 STORED PROCEDURE INPUT PARAMETERS
CREATE OR REPLACE PROCEDURE update_emp_city(Eemployeeid employee.employeeid%type, newcity employee.city%type)
IS

BEGIN
     UPDATE EMPLOYEE
     SET City = newcity
     WHERE employeeid = Eemployeeid; 
END;



--------------------
CREATE OR REPLACE PROCEDURE get_manager(Eemployeeid employee.employeeid%type)
IS
cursorP SYS_REFCURSOR;
BEGIN
     OPEN cursorP FOR
     SELECT FIRSTNAME, LASTNAME
     FROM EMPLOYEE e1
     WHERE e1.employeeID = (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = Eemployeeid) ;
END;

--4.3 STORED PROCEDURE OUTPUT PARAMETERS
CREATE OR REPLACE PROCEDURE get_name_Company(Ccustomerid customer.customerid%type, fname OUT varchar2, lname OUT varchar2, cmpny OUT varchar2)
IS

BEGIN
     SELECT FIRSTNAME into fname
     FROM CUSTOMER 
     WHERE customerID = ccustomerid;
     
     SELECT LASTNAME into lname
     FROM CUSTOMER 
     WHERE customerID = ccustomerid;
     
     SELECT COMPANY into cmpny
     FROM CUSTOMER 
     WHERE customerID = ccustomerid;   
END;
--------------------------------------------------------------------------------------------------------------------
--5.0

CREATE OR REPLACE PROCEDURE del_inv(id IN INVOICE.INVOICEID%TYPE)
IS
BEGIN
    DELETE FROM INVOICE WHERE INVOICEID = id;
    DBMS_OUTPUT.PUT_LINE('Invoice deleted');
    commit;
END; 

---------------------------

CREATE OR REPLACE PROCEDURE ins_rec(id IN CUSTOMER.CUSTOMERID%TYPE)
IS
BEGIN
    INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
        VALUES(
        id,
        'Lebron',
        'James',
        'NBA',
        '0000 Somewhere ',
        'Cleveland',
        'OH',
        'United States',
        '80000',
        '+1 (800) 411-9876',
        null,
        'darealmvp@gmail.com',
        null);
    commit;
END;






--6.0 TRIGGERS

--6.1 AFTER/FOR

CREATE OR REPLACE TRIGGER emp_trigger
AFTER INSERT ON EMPLOYEE
DECLARE
cursorP SYS_REFCURSOR;

BEGIN 
    OPEN cursorP FOR
  SELECT count(*) FROM EMPLOYEE;
     
END;  

-----------------

CREATE OR REPLACE TRIGGER alb_trigger
AFTER UPDATE ON ALBUM

BEGIN 
   DBMS_OUTPUT.PUT_LINE('Table ALBUM has been updated!');
END;

----------------------
CREATE OR REPLACE TRIGGER cus_trigger
AFTER DELETE ON CUSTOMER

BEGIN 
   DBMS_OUTPUT.PUT_LINE('Row in table CUSTOMER has been deleted!');
END;

---------------------------------------------------------------------------------------------------------------

--7.0 JOINS

--7.1 INNER JOINS
SELECT c.FIRSTNAME, c.LASTNAME,i.*
FROM CUSTOMER c inner join INVOICE i on c.customerid = i.customerid;

--7.2 OUTER JOINS
SELECT c.customerID, c.FIRSTNAME, c.LASTNAME,i.invoiceID, i.total
FROM CUSTOMER c full outer join INVOICE i on c.customerid = i.customerid;

--7.3 RIGHT JOINS
SELECT ar.Name, al.title
FROM ALBUM al right join ARTIST ar on al.artistid = ar.artistid;

--7.4 CROSS JOINS
SELECT * 
FROM Artist ar join Album al on ar.artistid = al.artistid;

--7.5 SELF JOIN
SELECT *
FROM EMPLOYEE e Full outer join Employee e1 on e.reportsto = e1.reportsto;



------------------------------------------------------------------------------------------------------------------------------
--9.0 ADMINISTRATION

commit;






