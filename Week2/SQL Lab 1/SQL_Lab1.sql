SAVEPOINT thisIsSafe;
--2.1
SELECT * FROM employee;

SELECT * FROM employee
    WHERE lastname = 'King';

SELECT * FROM employee
    WHERE (firstname = 'Andrew') and (REPORTSTO is null);
    
--2.2
SELECT * FROM album
    ORDER BY title DESC;

SELECT firstname 
    FROM customer ORDER BY city ASC;
    
--2.3
--Insert two new records into Genre table
INSERT INTO genre values(26, 'Deep House');
INSERT INTO genre values(27, 'Dubstep');


--Insert two new records into Employee table
INSERT INTO employee VALUES(9, 'Val', 'Firp', 'Software dev', 7, '14-DEC-1990', '14-DEC-1990',
    '1234 Dat Street', 'Somewhere', 'FL', 'USA', '12344', '9544443333', '1232345555', 'VAL@this.com');

--Insert two new records into Customer table
INSERT INTO customer VALUES(60, 'Me', 'Yo', 'Amazon', '123 This Way', 'Orlando',
    'FL', 'USA', '1234', '1234568', '1233445', 'this@yahoo.com', 1);
    
--2.4Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
    SET firstname = 'Robert', lastname = 'Walker'
    WHERE customerid = 32;


--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist 
    SET name = 'CCR'
    WHERE name = 'Creedence Clearwater Revival';

--2.5 Select all invoices with a billing address like “T%”
SELECT * FROM invoice
    WHERE BILLINGADDRESS LIKE 'T%';

--2.6 Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
    WHERE TOTAL BETWEEN 15 AND 20;

--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
    WHERE HIREDATE BETWEEN TO_DATE('01-JUN-03','DD-MON-YY') AND TO_DATE('01-MAR-04','DD-MON-YY');

--2.7 Delete a record in Customer table where the name is Daan Peeters
--(There may be constraints that rely on this, find out how to resolve them).

DELETE FROM invoiceline
    WHERE invoiceid in (SELECT invoiceid FROM invoice
    WHERE customerid = (SELECT customerid FROM customer WHERE FIRSTNAME = 'Daan' AND LASTNAME = 'Peeters'));

DELETE FROM invoice
    WHERE customerid = (SELECT customerid FROM customer WHERE FIRSTNAME = 'Daan' AND LASTNAME = 'Peeters');

DELETE FROM customer
    WHERE FIRSTNAME = 'Daan' AND LASTNAME = 'Peeters';
    
--3.1 Create a function that returns the current time.
CREATE OR REPLACE FUNCTION getTime
    RETURN VARCHAR2
    IS
        todaysDate VARCHAR2 (100);
    BEGIN
        todaysDate := TO_CHAR(SYSDATE, 'MM-DD-YYYY HH24:MI:SS');
        RETURN todaysDate;
    END;

--3.1 Create a function that returns the length of a mediatype from the mediatype table
 CREATE OR REPLACE FUNCTION getLenOfMedia
    RETURN NUMBER
    IS
        lenOfMedia NUMBER;
    BEGIN
        SELECT lengthb(mediatypeid) into lenOfMedia from mediatype;
        RETURN lenOfMedia;
    END;

--3.2 Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION average_total
    RETURN NUMBER 
    IS 
        average_total_result NUMBER;
    BEGIN
        SELECT avg(total) into average_total_result FROM invoice;
        RETURN average_total_result;
    END;
    
    
--3.2Create a function that returns the most expensive track


--3.3 Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION average_invoice
    RETURN NUMBER 
    IS 
        average_total_result NUMBER;
    BEGIN
        SELECT avg(unitprice) into average_total_result FROM invoiceline;
        RETURN average_total_result;
    END;

--3.4 Create a function that returns all employees who are born after 1968.

--4.1 Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE first_and_last_names(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
    open cursorParam FOR
    select FIRSTNAME, LASTNAME from employee;
END;

DECLARE
    emp_cursor SYS_REFCURSOR;
    f_name employee.firstname%type;
    l_name employee.lastname%type;
BEGIN
  first_and_last_names(emp_cursor);
  
  LOOP
    FETCH emp_cursor INTO f_name, l_name;
    EXIT WHEN emp_cursor%NOTFOUND; 
    DBMS_OUTPUT.PUT_LINE(f_name || ' ' || l_name);
  END LOOP;
END;

BEGIN 
    first_and_last_names();
END;

--4.2 Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_emp(some_id NUMBER, some_f IN VARCHAR2, some_l IN VARCHAR2)
IS
BEGIN
  UPDATE employee
  SET firstname = some_f, lastname = some_l
  WHERE employeeid = some_id;
END;

BEGIN
  update_emp(1,'Eric','Doe');
END;

--4.2 Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE name_of_managers(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
    open cursorParam FOR
    select reportsto from employee;
END;

DECLARE
    emp_cursor SYS_REFCURSOR;
    emp_manager employee.reportsto%type;
    
BEGIN
  name_of_managers(emp_cursor);
  
  LOOP
    FETCH emp_cursor INTO emp_manager;
    EXIT WHEN emp_cursor%NOTFOUND; 
    --DBMS_OUTPUT.PUT_LINE(SELECT firstname FROM employee WHERE (employeeid = emp_manager));
    DBMS_OUTPUT.PUT_LINE(emp_manager);
  END LOOP;
END;

BEGIN 
    name_of_managers();
END;

--4.3 Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE find_company(some_id IN NUMBER, some_comp OUT VARCHAR2)
IS
BEGIN
  SELECT company INTO some_comp FROM customer WHERE customerid = some_id;
END;

DECLARE
    answer varchar2(4000);
BEGIN
    find_company(2, answer);
    DBMS_OUTPUT.PUT_LINE(answer);
END;


--7.1Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT invoiceid
FROM invoice
INNER JOIN customer on invoice.customerid = customer.customerid;

SELECT customerid
FROM customer
INNER JOIN invoice on customer.customerid = invoice.customerid;
--7.2Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
--7.3Create a right join that joins album and artist specifying artist name and title.
--7.4Create a cross join that joins album and artist and sorts by artist name in ascending order.
--7.5Perform a self-join on the employee table, joining on the reportsto column.




ROLLBACK thisIsSafe;