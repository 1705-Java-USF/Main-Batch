--2.1 SELECT
SELECT * FROM Employee;

SELECT * 
FROM employee
WHERE lastname = 'King';

SELECT * 
FROM Employee
WHERE firstname = 'Andrew'
AND reportsto IS NULL;
----------------------------------------------
--2.2 ORDER BY
SELECT * 
FROM Album
ORDER BY Title DESC;

SELECT  firstname
FROM Customer
ORDER BY City ASC;

select * from employee;
------------------------------------------
-- 2.3 INSERT INTO
INSERT INTO GENRE
(GENREID, NAME)
VALUES
(26, 'Neo-Soul');

INSERT INTO GENRE
(GENREID, NAME)
VALUES
(27, 'Trap');
select * from customer;
INSERT INTO EMPLOYEE
(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, 
HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES
(9, 'Ward', 'Andre', 'IT Manager',6, '23-FEB-84', '21-JUN-06', '5150 Trouble Ln',
'Oakland', 'California', 'United States', '94615', '+1 (414) 532-2300', 
'+1 (414) 422-2399', 'andreward@chinookcorp.com');

INSERT INTO EMPLOYEE
(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, 
HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES
(10, 'Durant', 'Kevin', 'IT Staff',1, '29-FEB-88', '30-MAR-09', '1 Servant Dr',
'Washington', 'DC', 'United States', '20023', '+1 (666) 586-6633', 
'+1 (529)961-8543', 'durant@chinookcorp.com');

select * from customer;
INSERT INTO CUSTOMER
(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, 
POSTALCODE, PHONE, FAX,EMAIL, SUPPORTREPID)
VALUES
(64, 'Great', 'Ness', 'Great Corp', '100 Great Ln', 'Atlanta', 'GA', 'United States', '30303',
'+1 678 999 1212', '+1 588 877 2056', 'great@greatcorp.com', 3);

INSERT INTO CUSTOMER
(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, 
POSTALCODE, PHONE, FAX,EMAIL, SUPPORTREPID)
VALUES
(61, 'LeBron', 'James', 'NBA', '3 Rings Dr', 'Akron', 'OH', 'United States', 
'31406','+1 470 411 3333', '+1 874 870 8151', 'bron@3rings.org', 3);

---------------------------------------------------------------------------
-- 2.4 UPDATE
UPDATE Customer
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron'AND LASTNAME = 'Mitchell';

select * from invoice;
where name='Creedence Clearwater Revival';

UPDATE Artist
Set NAME = 'CCR'
WHERE NAME='Creedence Clearwater Revival';

--2.5 LIKE
SELECT BILLINGADDRESS 
FROM invoice
WHERE BILLINGADDRESS LIKE 'T%';

------------------------------------------------------------------------------

-- 2.6 BETWEEN
SELECT *
FROM invoice
WHERE TOTAL BETWEEN 15 AND 50;

SELECT *
FROM Employee
WHERE HIREDATE BETWEEN TO_DATE('2003/04/01','yyyy/mm/dd')
AND TO_DATE('2004/03/01', 'yyyy/mm/dd');

SAVEPOINT S;

select * from customer;
select * from invoice;

-----------------------------------------------------------------------------

--2.7 DELETE
select * from invoiceline;

DELETE FROM INVOICELINE
WHERE INVOICELINE.INVOICEID=32;

DELETE FROM CUSTOMER
WHERE CUSTOMER.CUSTOMERID=32;
DROP constraint FK_INVOICECUSTOMERID;

WHERE EXISTS
(
    SELECT CUSTOMER.CUSTOMERID
    FROM CUSTOMER
    WHERE CUSTOMER.CUSTOMERID = CUSTOMER.FK_INVOICECUSTOMERID
    AND CUSTOMER.CUSTOMERID = 
);
    
    select * from invoice;
 
 ----------------------------------------------------------------------------
 --3.0 SQL FUNCTIONS
 
 
 --3.1 System Defined Functions
 
    CREATE OR REPLACE FUNCTION get_time
    RETURN DATE
    IS
    right_now TIMESTAMP;
    BEGIN
       SELECT CURRENT_TIMESTAMP INTO right_now 
        FROM dual;
        RETURN right_now;
    END;
    
    DECLARE
        rightnow TIMESTAMP;
    BEGIN
        rightnow := get_time();
        DBMS_OUTPUT.PUT_LINE('Current time: ' || rightnow);
    END;

    Select * from track;
    UPDATE track
    SET unitprice = 9.99
    WHERE trackid = 438;
    
CREATE OR REPLACE FUNCTION get_string_len
RETURN NUMBER
IS
  string_len NUMBER;
BEGIN
  SELECT length('AAC audio file') INTO string_len 
  FROM mediatype
  WHERE mediatypeid=5;
  RETURN string_len;
END;

DECLARE
  len NUMBER;
BEGIN
  len := get_string_len();
  DBMS_OUTPUT.PUT_LINE('Length is: ' || len);
END;

-------------------------------------------------------------------------

--3.2 System Defined Aggregate Functions


CREATE OR REPLACE FUNCTION get_average
RETURN NUMBER
IS
  avg_inv NUMBER;
BEGIN
  SELECT avg(total) into avg_inv from invoice;
  RETURN avg_inv;
END;

DECLARE
    avginv NUMBER;
BEGIN
    avginv := get_average();
    DBMS_OUTPUT.PUT_LINE('Average invoice: ' || avginv);
END;  

CREATE OR REPLACE FUNCTION get_max
RETURN NUMBER
IS
  max_price NUMBER;
BEGIN
  SELECT MAX(unitprice) into max_price from track;
  RETURN max_price;
END;


DECLARE
    maxprice NUMBER;
BEGIN
    maxprice := get_max();
    DBMS_OUTPUT.PUT_LINE('Max unit price: ' || maxprice);
END; 

----------------------------------------------------------------------------

--3.3 User Defined Scalar Functions
select * from invoiceline;

CREATE OR REPLACE FUNCTION get_average_invline
RETURN NUMBER
IS
  avg_invline NUMBER;
BEGIN
  SELECT avg(unitprice) into avg_invline from invoiceline;
  RETURN avg_invline;
END;

DECLARE
    avginvline NUMBER;
BEGIN
    avginvline := get_average_invline();
    DBMS_OUTPUT.PUT_LINE('Average invoice line: ' || avginvline);
END;

--3.4 User Defined Table Valued Functions

----------------------------------------------------------------------------
-- 4.0 Stored Procedures


-- 4.1 Basic Stored Procedure

CREATE OR REPLACE PROCEDURE view_emp(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
    open cursorParam FOR
    select employeeid, lastname, firstname 
    from Employee;
END;

DECLARE
    fc_cursor SYS_REFCURSOR; 
    someId EMPLOYEE.EMPLOYEEID%type;
    l_name EMPLOYEE.LASTNAME%type;
    f_name EMPLOYEE.FIRSTNAME%type;    
BEGIN
    view_emp(fc_cursor);
    LOOP
        FETCH fc_cursor INTO someId, l_name, f_name;
        EXIT WHEN fc_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(someId || ' ' || f_name || ' '  || l_name);
    END LOOP;
END;

----------------------------------------------------------------------------

--4.2 Stored Procedure Input Parameters

CREATE OR REPLACE PROCEDURE update_emp(emp_id IN NUMBER, f_name IN VARCHAR2  )
IS
BEGIN
   UPDATE Employee
   SET firstname=f_name
   WHERE employeeid=emp_id;
END;

BEGIN
    update_emp(10,'Coward');
END;

select lastname,firstname from employee
where title = 'Sales Manager';

CREATE OR REPLACE PROCEDURE get_manager(l_name IN OUT EMPLOYEE.LASTNAME%TYPE, f_name IN OUT EMPLOYEE.FIRSTNAME%TYPE)
IS
BEGIN
    select lastname, firstname
    into l_name, f_name
    from employee
    WHERE employeeid=emp_id
    AND reportsto=rep_to
    AND firstname=f_name
    AND lastname=l_name;
    
    SELECT a.firstname "Employee", a.lastname " ", b.firstname "Manager", b.lastname " "
    FROM Employee a, Employee b
    WHERE a.reportsto = b.reportsto;
END;

DECLARE
l_name EMPLOYEE.LASTNAME%TYPE;
f_name EMPLOYEE.FIRSTNAME%TYPE;
BEGIN
    get_manager(10, 1, 'Durant', 'Coward');
END;

SELECT E.FIRSTNAME "Employee First Name", E.LASTNAME "Employee Last Name",
M.FIRSTNAME "Manager First Name", M.LASTNAME "Manager Last Name"
FROM Employee E 
JOIN Employee M
ON (E.REPORTSTO = M.EMPLOYEEID);

-----------------------------------------------------------------------------

--4.3 Stored Procedure Output Parameters
CREATE OR REPLACE PROCEDURE view_cust(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
    open cursorParam FOR
    select firstname, lastname, company
    from Customer;
END;

DECLARE
    fc_cursor SYS_REFCURSOR; 
    f_name CUSTOMER.FIRSTNAME%type;
    l_name CUSTOMER.LASTNAME%type;
    comp_with CUSTOMER.COMPANY%type;    
BEGIN
    view_cust(fc_cursor);
    LOOP
        FETCH fc_cursor INTO f_name, l_name, comp_with;
        EXIT WHEN fc_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(f_name || ' ' || l_name || ' | '  || comp_with);
    END LOOP;
END;

---------------------------------------------------------------------------

--5.0 Transactions

CREATE OR REPLACE PROCEDURE insert_cust(cust_id IN NUMBER, f_name IN VARCHAR2, l_name IN VARCHAR2, company_name IN VARCHAR2, address_name IN VARCHAR2, city_name IN VARCHAR2, state_name IN VARCHAR2, country_name IN VARCHAR2, postalcode_name IN VARCHAR2, phone_num IN VARCHAR2, fax_num IN VARCHAR2, email_add IN VARCHAR2, rep_id IN NUMBER)
IS
BEGIN
 INSERT INTO Customer(customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
    VALUES
    (cust_id, f_name, l_name, company_name, address_name, city_name, state_name, country_name, postalcode_name, phone_num, fax_num, email_add, rep_id);
    COMMIT;
END;

BEGIN
insert_cust(65, 'Deme', 'Trus', 'Dee', '821 D St', 'Deeopolis', 'DE', 'United States', '01234', '+1 555 444 3333', '+1 555 666 777', 'd@d.com', 4);
END;

-----------------------------------------------------------------------------

-- 6.0 Triggers

--6.1 AFTER/FOR

CREATE OR REPLACE TRIGGER employee_after_insert
AFTER INSERT ON Employee
FOR EACH ROW
BEGIN 
    IF :new.address IS NULL THEN 
        DBMS_OUTPUT.PUT_LINE('Please Set a value for address');
    END IF;
END;

CREATE OR REPLACE TRIGGER employee_after_delete
AFTER DELETE ON Employee
FOR EACH ROW
BEGIN 
    DBMS_OUTPUT.PUT_LINE('Row deleted');
END;

CREATE OR REPLACE TRIGGER employee_after_update
AFTER UPDATE ON Employee
FOR EACH ROW
BEGIN 
  DBMS_OUTPUT.PUT_LINE('Row updated');
END;

select * from employee
insert into Employee values(14, 'why', 'zee', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,  NULL, NULL, NULL, NULL);
delete from employee where lastname='why';

update Employee 
set title = 'Janitor'
where lastname='ex';

----------------------------------------------------------------------------

--7.0 Joins

-- 7.1 INNER
select * from invoice
select * from customer

SELECT invoice.invoiceid,customer.firstname, customer.lastname
FROM Customer
INNER JOIN Invoice
ON customer.customerid= invoice.customerid;

--7.2 OUTER
SELECT customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
FROM Customer
LEFT JOIN Invoice
ON customer.customerid= invoice.customerid;

--7.3 RIGHT
SELECT artist.name, album.title
FROM Artist
RIGHT JOIN Album
ON artist.artistid= album.artistid;

--7.4 CROSS
SELECT artist.name, album.title
FROM Artist
CROSS JOIN Album
ORDER BY artist.name ASC;

-- 7.5 SELF
SELECT a.firstname "Employee", a.lastname " ", b.firstname "Manager", b.lastname " "
FROM Employee a, Employee b
WHERE a.reportsto = b.reportsto;

----------------------------------------------------------------------------

--9.0 Administration



