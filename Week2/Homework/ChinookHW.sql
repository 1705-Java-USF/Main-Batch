/*

SQL Homework
Carlos Rubiano

*/

--2.1 SELECT

select * from employee;

select * from employee
where  LASTNAME = 'King';

select * from employee
where FIRSTNAME = 'Andrew'
AND REPORTSTO is null;

--2.2 ORDER BY

select * from album
order by TITLE desc;

select FIRSTNAME from customer
order by CITY;

--2.3 INSERT INTO

insert into genre values(26, 'Trap');
insert into genre values(27, 'Dubstep');

insert into employee (EMPLOYEEID, LASTNAME, FIRSTNAME) 
values(9,'Lass','Firs');
insert into employee (EMPLOYEEID, LASTNAME, FIRSTNAME) 
values(10,'Lasser','Firser');

insert into customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
values(60, 'Bob', 'Bobo', 'bobo@gmail.com');
insert into customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
values(61, 'Rob', 'Robo', 'robo@hotmail.com');

--2.4 UPDATE

UPDATE customer 
    SET firstname = 'Robert',
    lastname = 'Walter'
    WHERE lower(firstname) = lower('aaron')
    AND lower(lastname) = lower('mitchell');

UPDATE artist
    SET name = 'CCR'
    WHERE lower(name) = lower('Creedence Clearwater Revival');
    
--2.5 LIKE

SELECT * FROM invoice
    WHERE BILLINGADDRESS LIKE 'T%';
    
--2.6 BETWEEN

SELECT * FROM invoice
    WHERE total BETWEEN 15 AND 20;
    
SELECT * FROM employee
    WHERE hiredate 
    BETWEEN TO_DATE('2003-06-01','YYYY-MM-DD') 
    AND TO_DATE('2004-03-01','YYYY-MM-DD');
    
--2.7 DELETE 

ALTER TABLE Invoice
DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE Invoice
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID)
ON DELETE CASCADE;

ALTER TABLE Invoiceline
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE Invoiceline
ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (INVOICEID) REFERENCES INVOICE(INVOICEID)
ON DELETE CASCADE;

DELETE FROM CUSTOMER
    WHERE lower(FIRSTNAME) = lower('ROBERT')
    AND lower(LASTNAME) = lower('WALTER');

--3.1 System Defined Functions
CREATE OR REPLACE FUNCTION get_current_time
RETURN TIMESTAMP
IS
 ts TIMESTAMP;
BEGIN
 select CURRENT_TIMESTAMP into ts from dual;
 RETURN ts;
END;

DECLARE
 time TIMESTAMP;
BEGIN
 time := get_current_time();
 DBMS_OUTPUT.PUT_LINE('Current time is: ' || time);
END;

--
CREATE OR REPLACE FUNCTION get_mediatype_length(id IN NUMBER)
RETURN NUMBER
IS
 length NUMBER;
BEGIN
 select LENGTH(MEDIATYPE.NAME) into length from MEDIATYPE
 where MEDIATYPE.MEDIATYPEID = id; 
 RETURN length;
END;

DECLARE
BEGIN
 for idx in 1..5 LOOP
  DBMS_OUTPUT.PUT_LINE( get_mediatype_length(idx) );
 END LOOP;
END;

--3.2 System Defined Aggregate Functions


CREATE OR REPLACE FUNCTION get_total_avg_invoice
RETURN NUMBER
IS
 total NUMBER;
BEGIN
 SELECT SUM(INVOICE.TOTAL)/COUNT(INVOICE.TOTAL) INTO total FROM INVOICE;
 RETURN total;
END;


DECLARE
 total NUMBER;
BEGIN
 total := get_total_avg_invoice();
 DBMS_OUTPUT.PUT_LINE('Average total of invoice: ' || TRUNC(total,2));
END;

--   
CREATE OR REPLACE FUNCTION most_expensive_track
 RETURN SYS_REFCURSOR
IS
 curs SYS_REFCURSOR;
BEGIN
 OPEN curs
  FOR SELECT NAME FROM TRACK 
  WHERE TRACK.UNITPRICE = 
  (SELECT max(TRACK.UNITPRICE) FROM TRACK);
 RETURN curs;
END;

DECLARE
 iterc SYS_REFCURSOR;
 tname track.name%TYPE;
BEGIN
 iterc := most_expensive_track();
  LOOP
   FETCH iterc INTO tname;
   EXIT WHEN iterc%NOTFOUND;
   DBMS_OUTPUT.PUT_LINE(tname);
  END LOOP;
END;

--3.3 User Defined Scalar Functions
select * from invoiceline;

--Not sure if supposed to use aggregate avg function here?
CREATE OR REPLACE FUNCTION get_avg_price_invoiceline
 RETURN NUMBER
IS
 avgP INVOICELINE.UNITPRICE%TYPE;
BEGIN
 select AVG(unitprice) INTO avgP from Invoiceline;
 RETURN avgP;
END;

BEGIN
 DBMS_OUTPUT.PUT_LINE(get_avg_price_invoiceline());
END;

--3.4 User Defined Table Valued Functions

CREATE OR REPLACE FUNCTION get_employees_born_after_68
 RETURN SYS_REFCURSOR
IS
 curs SYS_REFCURSOR;
BEGIN

 OPEN CURS FOR
 SELECT EMPLOYEE.FIRSTNAME FROM EMPLOYEE
 WHERE TO_DATE(BIRTHDATE) > TO_DATE('01-JAN-68');
 RETURN CURS;

END;

DECLARE
 iterc SYS_REFCURSOR;
 tname employee.firstname%TYPE;
BEGIN
 iterc := get_employees_born_after_68();
  LOOP
   FETCH iterc INTO tname;
   EXIT WHEN iterc%NOTFOUND;
   DBMS_OUTPUT.PUT_LINE(tname);
  END LOOP;
END;

--4.1 Basic Stored Procedure

CREATE OR REPLACE PROCEDURE select_all_names_employee
IS
 CURSOR c1 IS SELECT firstname, lastname FROM employee;
 TYPE name_typ IS TABLE OF c1%ROWTYPE INDEX BY PLS_INTEGER;
 all_names name_typ;
BEGIN
 SELECT FIRSTNAME,LASTNAME BULK COLLECT INTO all_names FROM EMPLOYEE;
--EXCEPTION
 FOR indx IN 1 .. all_names.COUNT
 LOOP
  DBMS_OUTPUT.put_line (all_names (indx).firstname || ' ' || all_names (indx).lastname);
 END LOOP;
END;

call select_all_names_employee();

--4.2 Stored Procedure Input Parameters

CREATE OR REPLACE PROCEDURE 
update_employee_info(idToChange IN employee.employeeid%TYPE, 
                    newLName IN employee.lastname%TYPE, 
                    newFName IN employee.firstname%TYPE,
                    newTitle IN employee.title%TYPE default null,
                    newReport IN employee.reportsto%TYPE default null,
                    newBDate IN employee.birthdate%TYPE default null,
                    newHDate IN employee.hiredate%TYPE default null,
                    newAdd IN employee.address%TYPE default null,
                    newCity IN employee.city%TYPE default null,
                    newState IN employee.state%TYPE default null,
                    newCoun IN employee.country%TYPE default null,
                    newPCode IN employee.postalcode%TYPE default null,
                    newPhone IN employee.phone%TYPE default null,
                    newFax IN employee.fax%TYPE default null,
                    newEmail IN employee.email%TYPE default null)
IS
BEGIN
    UPDATE employee 
    SET lastname = newLName,
    firstname = newFName,
    title = newTitle,
    employee.reportsto = newReport,
    employee.birthdate = newBDate,
    employee.hiredate = newHDate,
    employee.address = newAdd,
    employee.city = newCity,
    employee.state = newState,
    employee.country = newCoun,
    employee.postalcode = newPCode,
    employee.phone = newPhone,
    employee.fax = newFax,
    employee.email = newEmail
    WHERE employeeid = idToChange;
END;

select * from Employee;

INSERT INTO EMPLOYEE(EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (9,'Bobb','Bobbers');

call update_employee_info(9, 'Bobby', 'Bear');
--

CREATE OR REPLACE PROCEDURE get_manager_of_employee
(eid IN employee.employeeid%TYPE, mfname OUT employee.firstname%TYPE, mlname OUT employee.lastname%TYPE )
IS
BEGIN
 select firstname,lastname into mfname, mlname from employee
 where employeeId = 
 (select reportsto from employee
 where eid = Employeeid);
END;


DECLARE
 ln employee.lastname%TYPE;
 fn employee.firstname%TYPE;
BEGIN
 get_manager_of_employee(3, fn, ln);
 DBMS_OUTPUT.PUT_LINE(fn || ' ' || ln);
END;

--4.3 Stored Procedure Output Parameters

CREATE OR REPLACE PROCEDURE get_customer_name_and_company
(eid IN customer.customerid%TYPE, fname OUT customer.firstname%TYPE, lname OUT customer.lastname%TYPE, co OUT customer.company%TYPE)
IS
BEGIN
 select firstname,lastname,company into fname, lname, co from customer
 where customerid = eid; 
END;

DECLARE
 ln customer.lastname%TYPE;
 fn customer.firstname%TYPE;
 co customer.company%TYPE;
BEGIN
 get_customer_name_and_company(1, fn, ln,co);
 DBMS_OUTPUT.PUT_LINE(fn || ' ' || ln || ', ' || co);
END;

--5.1 Transactions

--INVOICE HAS BEEN SET TO CASCADE ALREADY FROM BEFORE

CREATE OR REPLACE PROCEDURE delete_invoice_by_id(iid IN invoice.invoiceid%TYPE)
IS
BEGIN
 delete from invoice
 where invoiceid = iid;
END;

call delete_invoice_by_id(1);

--

--Takes minimum parameters required
CREATE OR REPLACE PROCEDURE insert_record_to_customer
(cid IN CUSTOMER.CUSTOMERID%TYPE, fn IN CUSTOMER.FIRSTNAME%TYPE, ln IN CUSTOMER.LASTNAME%TYPE, ema IN CUSTOMER.EMAIL%TYPE)
IS
BEGIN
 INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
 VALUES(cid, fn, ln, ema);
END;

call insert_record_to_customer(60, 'Newb', 'Saibot', 'newb@gmail.com');

--6.1 AFTER/FOR

CREATE OR REPLACE TRIGGER trig1
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN --Begin signifies a block for a transaction. We are able to write PL/SQL code here.
 DBMS_OUTPUT.PUT_LINE('AFTER INSERT ON EMPLOYEE: FIRED!!!');
END; 

CREATE OR REPLACE TRIGGER trig2
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN --Begin signifies a block for a transaction. We are able to write PL/SQL code here.
 DBMS_OUTPUT.PUT_LINE('AFTER UPDATE ON ALBUM: FIRED!!!');
END; 

CREATE OR REPLACE TRIGGER trig3
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN --Begin signifies a block for a transaction. We are able to write PL/SQL code here.
 DBMS_OUTPUT.PUT_LINE('AFTER DELETE ON CUSTOMER: FIRED!!!');
END; 

INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES(70, 'test', 'trigger');

--7.1 INNER

select customer.firstname as fname, customer.lastname as LNAME, invoice.invoiceid as InvoiceId from CUSTOMER
inner join INVOICE
on customer.customerid = invoice.invoiceid
order by fname, InvoiceId;

--7.2 OUTER

select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total from CUSTOMER 
full outer join INVOICE
on customer.customerid = invoice.invoiceid;

--7.3 RIGHT
select artist.NAME, album.title from album
right join
artist on artist.artistid = album.artistid; 

--7.4 CROSS

select * from album
cross join
artist
order by artist.name;

--7.5 SELF

select * from employee a
inner join
employee b on a.reportsto = b.reportsto;

--9.1 Administration


