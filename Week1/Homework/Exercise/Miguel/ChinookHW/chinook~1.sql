SELECT * FROM Employee;

SELECT * FROM Employee
Where LASTNAME = 'King';

SELECT * FROM Employee
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO is null;

SELECT * FROM Album;

SELECT * FROM Album
ORDER BY TITLE desc;

SELECT FIRSTNAME FROM Customer
    ORDER BY City;
    
SELECT* FROM Genre;

INSERT INTO Genre values (26, 'Top 40 Rap');
INSERT INTO Genre values (27, 'The classics Opera');

INSERT INTO Employee values (9, 'Cruz', 'Miguel', 'Boss', 5, '23-AUG-93', '31-MAY-17', '11111 12th ave NW', 'Tampa', 'FL', 'USA', 'TSE 653', '+1 (863) 845 0423', '+1 (863) 845 0423', 'mikejones@chinookcorp.com');
INSERT INTO Employee values (11, 'High', 'Jones', 'Trainee', 4, '20-AUG-93', '31-MAY-17', '11111 14th ave NW', 'Tampa', 'FL', 'USA', 'TSE 667', '+1 (863) 845 0423', '+1 (863) 845 0423', 'mHighT@chinookcorp.com');
--To see the datatypes of an already existing table
desc Employee;

SELECT * FROM Customer;
DESC Customer;

INSERT INTO Customer VALUES(60, 'Kay', 'Jones', 'Amazon', '110 Prosp Ave', 'Winter Have', 'FL', 'USA', '33880', '(863) 561 5343', '(863) 561 5343', 'kayj54@yahoo.com', 6);
INSERT INTO Customer VALUES(61, 'Jim', 'Jones', null, '110 P Ave', 'Winter', 'FL', 'USA', '33880', '(863) 561 6545', '(863) 561 5343', 'jimmyboy66@yahoo.com', 3);

UPDATE Customer
    SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
    WHERE FIRSTNAME = 'Aaron';

SELECT * FROM Artist;
UPDATE Artist
    SET NAME = 'CCR'
    WHERE NAME = 'Creedence Clearwater Revival';
    
SELECT * FROM Invoice
    WHERE BILLINGADDRESS LIKE 'T%';
    
SELECT * FROM Invoice
    WHERE Total BETWEEN 15 AND 50;
    
SELECT * FROM Employee
    WHERE HIREDATE BETWEEN TO_DATE ('01/06/2003', 'dd/mm/yy') AND TO_DATE ('01/03/2004', 'dd/mm/yy');
--=======================================================================================================================================================    
SELECT * FROM Customer;

ALTER TABLE Invoice
    DROP CONSTRAINT FK_INVOICECUSTOMERID;
COMMIT;
DELETE FROM Customer
    WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';


ALTER TABLE INVOICE
    ADD CONSTRAINT FK_INVOICECUSTOMERIDCASCADE
    FOREIGN KEY (CUSTOMERID) 
    REFERENCES CUSTOMER(CUSTOMERID)
    ON DELETE CASCADE;
COMMIT;    

DELETE FROM Customer
    WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
    
ALTER TABLE Invoiceline
    DROP CONSTRAINT FK_INVOICELINEINVOICEID;
    
ALTER TABLE INVOICELINE
    ADD CONSTRAINT FK_INVOICELINEINVOICEIDCASCADE
    FOREIGN KEY (INVOICEID) 
    REFERENCES INVOICE(INVOICEID)
    ON DELETE CASCADE;
COMMIT;
DELETE FROM Customer
    WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
--==================================SQL Functions===============================
SELECT CURRENT_TIMESTAMP FROM Employee;

SELECT LENGTH(NAME) FROM Mediatype;

SELECT AVG(Total) FROM Invoice;

SELECT MAX(UNITPRICE) FROM TRACK;

UPDATE TRACK
    SET UNITPRICE = 2.99
    WHERE TRACKID = 1;
commit;

SELECT AVG(UNITPRICE) FROM INVOICELINE;

SELECT * FROM EMPLOYEE
    WHERE BIRTHDATE > TO_DATE ('1968', 'yyyy');

--======================Stored Procedures=================================================================
--====================================================================================   
--4.1Create a stored procedure that selects the first and last names of all the employees.

--======================================================================================
CREATE OR REPLACE PROCEDURE update_employee_info (id IN employee.employeeid%TYPE, lname IN employee.lastname%TYPE)
IS
BEGIN
    Update EMPLOYEE SET
    LASTNAME = lname
    WHERE EMPLOYEEID = id;
    Commit;
END;

BEGIN
    update_employee_info (3, 'Cruz'); 
END;


CREATE OR REPLACE PROCEDURE manager_lookup_proc(id IN EMPLOYEE.REPORTSTO%TYPE)
IS
    manager employee.reportsto%TYPE;
    m_first_name employee.firstname%TYPE;
    m_last_name employee.lastname%TYPE;
    m_title employee.title%TYPE;
BEGIN
    SELECT reportsto INTO manager FROM employee WHERE employeeid = id;
    SELECT firstname, lastname, title INTO m_first_name, m_last_name, m_title FROM employee WHERE employeeid = report;
    DBMS_OUTPUT.PUT_LINE('Manager ' || m_title || ' ' || m_first_name || ' ' || m_last_name);
END;

BEGIN
    manager_lookup_proc(4);
END;


CREATE OR REPLACE PROCEDURE manager_lookup_proc(id IN EMPLOYEE.REPORTSTO%TYPE)
IS
    manager employee.reportsto%TYPE;
    m_first_name employee.firstname%TYPE;
    m_last_name employee.lastname%TYPE;
    m_title employee.title%TYPE;
BEGIN
    SELECT reportsto INTO manager FROM employee WHERE employeeid = id;
    SELECT firstname, lastname, title INTO m_first_name, m_last_name, m_title FROM employee WHERE employeeid = report;
    DBMS_OUTPUT.PUT_LINE('Manager ' || m_title || ' ' || m_first_name || ' ' || m_last_name);
END;

BEGIN
    manager_lookup_proc(4);
END;

--========================Triggers================================================
--Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_insert_trigger
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee #' || :new.employeeid || ', ' || :new.firstname || ' was inserted.');
END;
INSERT INTO Employee values (11, 'High', 'Jones', 'Trainee', 4, '20-AUG-93', 
                            '31-MAY-17', '11111 14th ave NW', 'Tampa', 'FL', 'USA', 
                            'TSE 667', '+1 (863) 845 0423', '+1 (863) 845 0423', 
                            'mHighT@chinookcorp.com');
                            
DROP TRIGGER employee_update_trigger;

--Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_update_trigger
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Album #' || :new.albumid || ', ' || :new.title || ' was updated');
END;

UPDATE ALBUM
    SET TITLE = 'The Best Ever'
    WHERE ALBUMID = 1;

--Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_delete_trigger
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('CustomerID #' || :new.customerid || ', ' || :new.firstname || ' was deleted');
END;

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Patrick' AND LASTNAME = 'Gray';
--=========================JOIN=================================================

--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

SELECT CUSTOMER.FIRSTNAME, INVOICE.INVOICEID FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, AlBUM.TITLE FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME; 

--Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.REPORTSTO;

