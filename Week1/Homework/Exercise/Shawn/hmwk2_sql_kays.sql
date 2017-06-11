/*
    Shawn Kays

    2.1 SELECT
    Select all records from the Employee table.
    Select all records from the Employee table where last name is King.
    Select all records form the Employee table where first name is Andrew and REPORTSTO is NULL.
*/

SELECT * FROM Employee;
SELECT * FROM Employee WHERE lastname = 'King';
SELECT * FROM Employee WHERE firstname = 'Andrew' AND reportsto IS NULL;


/*
    2.2 ORDER BY
    Select all albums in Album table and sort result set in descending order by title.
    Select first name from Customer and sort result set in ascending order by city.
*/

SELECT * FROM Album ORDER BY title DESC;
SELECT firstname FROM Customer ORDER BY city ASC;


/*
    2.3 INSERT INTO
    Insert two new records into Genre table.
    Insert two new records into Employee table.
    Insert two new records into Customer table.
*/

INSERT INTO Genre VALUES(26, 'Electro Swing');
INSERT INTO Genre VALUES(27, 'Viking Metal');
INSERT INTO Employee VALUES(9, 'James', 'Hound', 'Sales Support Agent', 2, TO_DATE('26-JUN-87'), TO_DATE('22-OCT-06'), '3838 Yes Street', 'Hynio', 'IN', 'U.S.', '46062', '+1 (801) 323-9697', '+1 (232) 283-8074', 'hound@chinookcorp.com');
INSERT INTO Employee VALUES(10, 'Jones', 'Dog', 'IT Staff', 6, TO_DATE('26-JUN-87'), TO_DATE('22-OCT-06'), '3838 Yes Street', 'Hynio', 'IN', 'U.S.', '46062', '+1 (801) 323-9697', '+1 (232) 283-8074', 'hound@chinookcorp.com');
INSERT INTO Customer VALUES(60, 'Shawn', 'Staiz', 'Mainstay', '3297 Inner State', 'Oslow', 'ET', 'Space', '39748', '+1 (801) 323-9697', '+1 (891) 323-2308', 'arkjonesdalon@gmail.com', 4);
INSERT INTO Customer VALUES(61, 'Sean', 'Jackz', 'Mainstay', '3297 Inner State', 'Oslow', 'ET', 'Space', '39748', '+1 (801) 323-9697', '+1 (891) 323-2308', 'arkjonesdalon@gmail.com', 5);


/*
    2.4 UPDATE
    Update Aaron Mitchell in Customer table to Robert Walter.
    Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
*/

UPDATE Customer SET firstname = 'Robert', lastname = 'Walter'
    WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
UPDATE Artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';


/*
    2.5 LIKE
    Select all invoices with a billing address like "T%".
*/

SELECT * FROM Invoice WHERE billingaddress LIKE 'T%';


/*
    2.6 BETWEEN
    Select all invoices that have a total between 15 and 50.
    Select all employees hired between 1st of June 2003 and 1st of March 2004.
*/

SELECT * FROM Invoice WHERE total BETWEEN 15 AND 50;
SELECT * FROM Employee WHERE hiredate BETWEEN TO_DATE('01-JUN-03') AND TO_DATE('01-MAR-04');


/*
    2.7 DELETE
    Delete a record in Customer table where the name is Robert Walter (There may
    be constraints that rely on this, find out how to resolve them).
*/

ALTER TABLE Invoice
DROP CONSTRAINT fk_invoiceCustomerId;

ALTER TABLE Invoice
ADD CONSTRAINT fk_invoiceCustomerIdCascade
FOREIGN KEY (customerid) REFERENCES Customer(customerid)
ON DELETE CASCADE;

ALTER TABLE InvoiceLine
DROP CONSTRAINT fk_invoiceLineInvoiceId;

ALTER TABLE InvoiceLine
ADD CONSTRAINT fk_invoiceLineInvoiceIdCascade
FOREIGN KEY (invoiceid) REFERENCES Invoice(invoiceid)
ON DELETE CASCADE;

DELETE FROM Customer WHERE firstname = 'Robert' AND lastname = 'Walter';




/*
    3.1 System Defined Functions
    Create a function that returns the current time.
    Create a function that returns the length of a mediatype from the mediatype table.
*/

CREATE OR REPLACE FUNCTION cur_time
RETURN VARCHAR2
IS
    ct VARCHAR2(4000);
BEGIN
    ct := TO_CHAR(SYSDATE, 'hh:mi:ss AM');
    RETURN ct;
END;

BEGIN
    DBMS_OUTPUT.PUT_LINE(cur_time());
END;


CREATE OR REPLACE FUNCTION media_length
RETURN NUMBER
IS
    len NUMBER;
BEGIN
    SELECT LENGTH(name) INTO len FROM mediatype WHERE mediatypeid = 1;
    RETURN len;
END;

BEGIN
    DBMS_OUTPUT.PUT_LINE(media_length());
END;



/*
    3.2 System Defined Aggregate Functions
    Create a function that returns the average total of all invoices
    Create a function that returns the most expensive track
*/

CREATE OR REPLACE FUNCTION get_avg_total
RETURN NUMBER
IS
    avg_total NUMBER;
BEGIN
    SELECT AVG(total) INTO avg_total FROM invoice;
    RETURN avg_total;
END;

BEGIN
    DBMS_OUTPUT.PUT_LINE(get_avg_total);
END;


UPDATE track SET unitprice = 3.99 WHERE trackid = 329;


CREATE OR REPLACE FUNCTION get_most_expensive_track
RETURN NUMBER
IS
    max_value NUMBER(10, 2);
BEGIN
    SELECT MAX(unitprice) INTO max_value FROM track;
    RETURN max_value;
END;

BEGIN
    DBMS_OUTPUT.PUT_LINE(get_most_expensive_track());
END;



/*
    3.3 User Defined Scalar Functions
    Create a function that returns the average price of invoiceline items in the invoiceline table.
*/

CREATE OR REPLACE FUNCTION get_avg_price_invoiceline
RETURN NUMBER
IS
    avg_price NUMBER(10, 2);
BEGIN
    SELECT AVG(unitprice) INTO avg_price FROM invoiceline;
    RETURN avg_price;
END;

BEGIN
    DBMS_OUTPUT.PUT_LINE(get_avg_price_invoiceline());
END;



/*
    3.4 User Defined Table Valued Functions
    Create a function that returns all employees who are born after 1968.
*/

CREATE OR REPLACE TYPE employee_t AS OBJECT (
    employeeid NUMBER,
    lastname VARCHAR2(20 BYTE),
    firstname VARCHAR2(20 BYTE),
    title VARCHAR2(30 BYTE),
    birthdate DATE
);

CREATE OR REPLACE TYPE employee_set_t AS TABLE OF employee_t;

CREATE OR REPLACE FUNCTION get_employees_after_1968
RETURN employee_set_t
AS
    ret employee_set_t;
BEGIN
    SELECT CAST(MULTISET(
        SELECT employeeid, lastname, firstname, title, birthdate
        FROM employee
        WHERE birthdate >= TO_DATE('01-JAN-68'))
        AS employee_set_t)
    INTO ret FROM dual;
    RETURN ret;
END;

SELECT * FROM TABLE(get_employees_after_1968);




/*
    4.0 Stored Procedures
    In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.

    4.1 Basic Stored Procedure
    Create a stored procedure that selects the first and last names of all the employees.
*/

CREATE OR REPLACE PROCEDURE get_firstlastnames_procedure(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursorParam FOR
    SELECT lastname, firstname FROM employee;
END;

DECLARE
    emp_cursor SYS_REFCURSOR;
    fName employee.firstname%TYPE;
    lName employee.lastname%TYPE;
BEGIN
    get_firstlastnames_procedure(emp_cursor);
    
    LOOP
        FETCH emp_cursor INTO lName, fName;
        EXIT WHEN emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(lName || ', ' || fName);
    END LOOP;
END;



/*
    4.2 Stored Procedure Input Parameters
    Create a stored procedure that updates the personal information of an employee.
    Create a stored procedure that returns the managers of an employee.
*/

CREATE OR REPLACE PROCEDURE update_employee_info_proc(id IN employee.employeeid%TYPE)
IS
BEGIN
    UPDATE employee SET 
        lastname = 'Jorge',
        firstname = 'York',
        title = 'IT Staff',
        ReportsTo = 6,
        birthdate = TO_DATE('18-APR-78'),
        hiredate = TO_DATE('23-JAN-05'),
        address = '1189 Apple Cross East',
        city = 'Yethia',
        state = 'MS',
        country = 'U.S.',
        postalcode = '38923',
        phone = '+1 (567) 784-9874',
        fax = '+1 (768) 231-4978',
        email = 'itsalotoftofu@chinookcorp.com'
    WHERE employeeid = id;
    COMMIT;
END;

BEGIN
    update_employee_info_proc(2);
END;



CREATE OR REPLACE PROCEDURE get_manager_of_emp_proc(id IN employee.employeeid%TYPE, report OUT employee.reportsto%TYPE)
IS
BEGIN
    SELECT reportsto INTO report FROM employee WHERE employeeid = id;
END;

DECLARE
    report employee.reportsto%TYPE;
    manager_first_name employee.firstname%TYPE;
    manager_last_name employee.lastname%TYPE;
    manager_title employee.title%TYPE;
BEGIN
    get_manager_of_emp_proc(7, report);
    SELECT firstname, lastname, title INTO manager_first_name, manager_last_name, manager_title FROM employee WHERE employeeid = report;
    DBMS_OUTPUT.PUT_LINE('Your manager is the ' || manager_title || ' ' || manager_first_name || ' ' || manager_last_name);
END;



/*
    4.3 Stored Procedure Output Parameters
    Create a stored procedure that returns the name and company of a customer.
*/

CREATE OR REPLACE PROCEDURE get_NameCompany_Customer_proc(id IN customer.customerid%TYPE, first_name OUT customer.firstname%TYPE, last_name OUT customer.lastname%TYPE, company OUT customer.company%TYPE)
IS
BEGIN
    SELECT firstname, lastname, company INTO first_name, last_name, company FROM customer WHERE customerid = id;
END;

DECLARE
    first_name customer.firstname%TYPE;
    last_name customer.lastname%TYPE;
    company customer.company%TYPE;
BEGIN
    get_namecompany_customer_proc(1, first_name, last_name, company);
    IF company IS NULL THEN
        company := 'No company given';
    END IF;
    DBMS_OUTPUT.PUT_LINE(first_name || ' ' || last_name || ', ' || company);
END;



/*
    5.0 Transactions
    In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
    Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
    Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/

CREATE OR REPLACE PROCEDURE delete_invoice_by_id(id IN invoice.invoiceid%TYPE)
IS
BEGIN
    DELETE FROM invoice WHERE invoiceid = id;
    COMMIT;
END;

BEGIN
    delete_invoice_by_id(328);
END;



CREATE OR REPLACE PROCEDURE insert_new_customer
IS
BEGIN
    INSERT INTO Employee VALUES(
        12,
        'James',
        'Hound',
        'Sales Support Agent', 
        2, 
        TO_DATE('26-JUN-87'), 
        TO_DATE('22-OCT-06'),
        '3838 Yes Street', 
        'Hynio', 
        'IN', 
        'U.S.', 
        '46062', 
        '+1 (801) 323-9697', 
        '+1 (232) 283-8074', 
        'hound@chinookcorp.com');
    COMMIT;
END;

BEGIN
    insert_new_customer();
END;




/*
    6.0 Triggers
    In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.

    6.1 AFTER/FOR
    Create an after insert trigger on the employee table fired after a new record is inserted into the table.
    Create an after update trigger on the album table that fires after a row is updated in the table.
    Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/

CREATE OR REPLACE TRIGGER after_employee_insert_trigger
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee #' || :new.employeeid || ', ' || :new.firstname || ' ' || :new.lastname || ' was inserted.');
END;

BEGIN
    insert_new_customer();
END;


CREATE OR REPLACE TRIGGER after_album_update_trigger
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Album #' || :new.albumid || ': ' || :old.title || ' was changed to ' || :new.title || '.');
END;

UPDATE album SET title = 'This title used to start with F' WHERE title LIKE 'F%';


CREATE OR REPLACE TRIGGER after_customer_delete_trigger
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Customer #' || :old.customerid || ' was deleted.');
END;

DELETE FROM customer WHERE customerid = 8;



/*
    7.0 JOINS
    In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
    
    7.1 INNER
    Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/

SELECT firstname, lastname, invoiceid
FROM Customer INNER JOIN Invoice
ON Customer.customerid = Invoice.customerid;



/*
    7.2 OUTER
    Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
*/

SELECT customer.customerid, firstname, lastname, invoiceid, total 
FROM customer FULL OUTER JOIN invoice 
ON customer.customerid = invoice.customerid;



/*
    7.3 RIGHT
    Create a right join that joins album and artist specifying artist name and title.
*/

SELECT name, title 
FROM album RIGHT JOIN artist 
ON album.artistid = artist.artistid;



/*
    7.4 CROSS
    Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/

SELECT * 
FROM album CROSS JOIN artist 
ORDER BY name asc;



/*
    7.5 SELF
    Perform a self-join on the employee table, joining on the reportsto column.
*/

SELECT * 
FROM employee a, employee b 
WHERE a.reportsto = b.reportsto 
AND a.employeeid <> b.employeeid;













