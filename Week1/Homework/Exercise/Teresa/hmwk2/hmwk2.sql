-- 2.1 SELECT
-- Task – Select all records from the Employee table
SELECT * FROM EMPLOYEE;
-- Task – Select all records from the Employee table where last name is King
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO is null;
-- 2.2 ORDER BY
-- Task – Select all albums in Album table and sort result set in descending order by title
SELECT * FROM ALBUM
ORDER BY TITLE DESC;
-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY;
-- 2.3 INSERT INTO
-- Task – Insert two new records into Genre table
INSERT INTO GENRE VALUES(26, 'Turbo Folk');
INSERT INTO GENRE VALUES(27, 'Trans');
-- Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE VALUES(9, 'Clement', 'Caitlin', 'Sales Manager Assitant', 2, TO_DATE('18-FEB-95'),
TO_DATE('18-FEB-15'), '123 Street', 'Seatle', 'WA', 'USA', '78952', '+1 (256) 789-4862', NULL, 'c.c@mail.com');
INSERT INTO EMPLOYEE VALUES(10, 'Westcoast', 'Bey', 'IT Manager Assistant', 6, TO_DATE('18-AUG-98'),
TO_DATE('18-FEB-16'), '456 Avenue', 'Livermore', 'CA', 'USA', '15974', '+1 (258) 314-7895', NULL, 'w.b@mail.com');
-- Task – Insert two new records into Customer table
INSERT INTO CUSTOMER VALUES(60, 'Tuck', 'Gerth', 'Camelbak', '123 Street', 'Seatle', 'WA', 'USA', '78952',
'+1 (258) 314-7895', NULL, 'g.t@mail.com', 3);
INSERT INTO CUSTOMER VALUES(61, 'John', 'Henry', 'Top Flight', '456 Avenue', 'Livermore', 'CA', 'USA', '15974',
'+1 (258) 314-7895', NULL, 'h.j@mail.com', 5);
-- 2.4 UPDATE
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert'
WHERE FIRSTNAME = 'Aaron'
AND LASTNAME = 'Mitchell';
UPDATE CUSTOMER SET LASTNAME = 'Walter'
WHERE LASTNAME = 'Mitchell';
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
-- 2.5 LIKE
-- Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;
-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE('01-JUNE-03') AND TO_DATE('01-MAR-04');
-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter
-- (There may be constraints that rely on this, find out how to resolve them)
-- FOR CONSTRAINT ONE
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID)
ON DELETE CASCADE;
-- FOR CONSTRAINT TWO
ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (INVOICEID) REFERENCES INVOICE(INVOICEID)
ON DELETE CASCADE;
-- DELETE Robert Walter
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert'
AND LASTNAME = 'Walter';
-- 3.1 System Defined Functions
-- Task – Create a function that returns the current time
CREATE OR REPLACE FUNCTION get_current_time
RETURN DATE
IS
    curr_time TIMESTAMP;
BEGIN
    SELECT SYSTIMESTAMP INTO curr_time FROM dual;
    RETURN curr_time;
END;
-- Task – create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION get_media_length(media_id IN NUMBER)
RETURN NUMBER
IS
    media_length NUMBER;
    media VARCHAR2(4000);
BEGIN
    SELECT NAME INTO media FROM MEDIATYPE
    WHERE MEDIATYPEID = media_id;
    media_length := length(media);
    RETURN media_length;
END;
-- 3.2 System Defined Aggregate Functions
-- Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_average
RETURN NUMBER
IS
    average NUMBER;
BEGIN
    SELECT AVG(total) INTO average FROM INVOICE;
    RETURN average;
END;
-- Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_max_track
RETURN NUMBER
IS
    title VARCHAR2(200);
BEGIN
    SELECT NAME INTO title FROM TRACK
    WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
    RETURN title;
END;
-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_avg_price
RETURN NUMBER
IS
    average NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO average FROM INVOICELINE;
    RETURN average;
END;
-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968
CREATE OR REPLACE TYPE new_table AS OBJECT (
    f_name VARCHAR2(20),
    l_name VARCHAR2(20),
    birth DATE
);
CREATE OR REPLACE TYPE t_nested_table AS TABLE OF new_table;
CREATE OR REPLACE FUNCTION get_employees
RETURN t_nested_table AS new_table t_nested_table;
BEGIN
  SELECT CAST( MULTISET(
    SELECT FIRSTNAME, LASTNAME, BIRTHDATE FROM EMPLOYEE
    WHERE BIRTHDATE > TO_DATE('31-DEC-68')) AS t_nested_table)
    INTO new_table FROM dual;
  RETURN new_table;
END;
SELECT * FROM table(get_employees);
-- 4.1 Basic Stored Procedure
-- Task – Create a stored procedure that selects the first and last names of all the employees
CREATE OR REPLACE PROCEDURE get_names_procedure(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  open cursorParam FOR
  select FIRSTNAME, LASTNAME from EMPLOYEE;
END;
DECLARE
  employee_cursor SYS_REFCURSOR;
  f_name VARCHAR2(20);
  l_name VARCHAR2(20);
BEGIN
  get_names_procedure(employee_cursor);
  LOOP
    FETCH employee_cursor INTO f_name, l_name;
    EXIT WHEN employee_cursor%NOTFOUND; --%NOTFOUND does not exist until there is no records to be fetched.
    DBMS_OUTPUT.PUT_LINE(f_name || ' ' || l_name);
  END LOOP;
END;
-- 4.2 Stored Procedure Input Parameters
-- Task – Create a stored procedure that updates the personal information of an employee
CREATE OR REPLACE PROCEDURE update_procedure(employeeID IN NUMBER, Lname IN VARCHAR2, Fname IN VARCHAR2, title IN VARCHAR2, report IN NUMBER,
birth IN DATE, hire IN DATE, address IN VARCHAR2, city IN VARCHAR2, st IN VARCHAR2, country IN VARCHAR2, post IN VARCHAR2,
phone IN VARCHAR2, fax IN VARCHAR2, email IN VARCHAR2)
IS
BEGIN
    UPDATE EMPLOYEE
        set FIRSTNAME = Fname, LASTNAME = Lname, TITLE = title, REPORTSTO = report,
        BIRTHDATE = birth, HIREDATE = hire, ADDRESS = address, CITY = city, STATE = st,
        COUNTRY = country, POSTALCODE = post, PHONE = phone, FAX = fax, EMAIL = email
        WHERE EMPLOYEEID = employeeID;
    commit;
END;
-- Task – Create a stored procedure that returns the managers of an employee
CREATE OR REPLACE PROCEDURE get_manager_procedure(employID IN NUMBER, manag OUT VARCHAR2)
IS
    report NUMBER;
BEGIN
    SELECT REPORTSTO INTO report FROM EMPLOYEE
    WHERE EMPLOYEEID = employID;
    SELECT FIRSTNAME INTO manag FROM EMPLOYEE
    WHERE EMPLOYEEID = report;
    commit;
END;
-- 4.3 Stored Procedure Output Parameters
-- Task – Create a stored procedure that returns the name and company of a customer
CREATE OR REPLACE PROCEDURE get_company_procedure(customID IN NUMBER, customerName OUT VARCHAR2, companyInfo OUT VARCHAR2)
IS
BEGIN
    SELECT FIRSTNAME, COMPANY INTO customerName, companyInfo FROM CUSTOMER
    WHERE CUSTOMERID = customID;
    commit;
END;
-- 5.0 Transactions
-- Task – Create a transaction that given a invoiceId will delete that invoice
CREATE OR REPLACE PROCEDURE delete_invoice_proedure(invID IN NUMBER)
IS
BEGIN
    DELETE FROM INVOICE
    WHERE INVOICEID = invID;
END;
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_customer_procedure(customID IN NUMBER, Lname IN VARCHAR2, Fname IN VARCHAR2, company IN VARCHAR2,
address IN VARCHAR2, city IN VARCHAR2, st IN VARCHAR2, country IN VARCHAR2, post IN VARCHAR2, phone IN VARCHAR2, fax IN VARCHAR2,
email IN VARCHAR2, support IN NUMBER)
IS
BEGIN
    INSERT INTO CUSTOMER VALUES(customID, Fname, Lname, company, address, city, st, country, post, phone, fax, email, support);
END;
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER employee_trigger
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE(:new.EMPLOYEEID || ' WAS INSERTED');
END;
-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_trigger
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE(:new.ALBUMID || ' WAS INSERTED');
END;
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE OR REPLACE TRIGGER custom_trigger
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
  DBMS_OUTPUT.PUT_LINE(:old.CUSTOMERID || ' WAS DELETED');
END;
-- 7.1 INNER
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
SELECT a.FIRSTNAME, a.LASTNAME, b.INVOICEID FROM CUSTOMER a
INNER JOIN INVOICE b
ON a.CUSTOMERID = b.CUSTOMERID;
-- 7.2 OUTER
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total
SELECT a.CUSTOMERID, a.FIRSTNAME, a.LASTNAME, b.INVOICEID, b.TOTAL FROM CUSTOMER a
FULL OUTER JOIN INVOICE b
ON a.CUSTOMERID = b.CUSTOMERID;
-- 7.3 RIGHT
-- Task – Create a right join that joins album and artist specifying artist name and title
SELECT b.NAME, a.TITLE FROM ALBUM a
RIGHT JOIN ARTIST b
ON a.ARTISTID = b.ARTISTID;
-- 7.4 CROSS
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order
SELECT * FROM ALBUM
CROSS JOIN ARTIST
ORDER BY NAME;
-- 7.5 SELF
-- Task – Perform a self-join on the employee table, joining on the reportsto column
SELECT A.EMPLOYEEID, A.FIRSTNAME, B.FIRSTNAME AS REPORTSTO
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.EMPLOYEEID;
-- 9.0 Administration
-- Task – Create a .bak file for the Chinook database
ALTER DATABASE BACKUP CONTROLFILE TO 'chinook.bak';
