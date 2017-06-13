-- creating a savepoint
SAVEPOINT mySavePoint;
-- 1.0	Setting up Oracle Chinook
-- Open the Chinook_Oracle.sql file and execute the scripts within.


-- 2.1 SELECT
-- Select all records from the Employee table.
SELECT * FROM employee;

-- SELECT all records from the Employee table where last name is King.
SELECT * FROM employee
    WHERE LASTNAME = 'King';
    
-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee
    WHERE FIRSTNAME = 'Andrew'
    AND REPORTSTO is null;
    
-- 2.2 Order by
-- Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album
    ORDER BY TITLE DESC;
    
-- Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
    ORDER BY CITY DESC;

-- 2.3 INSERT INTO
-- Insert two new records into Genre table
SELECT * FROM GENRE;
INSERT INTO GENRE VALUES ('26', 'Lucas Tracks');
INSERT INTO GENRE VALUES ('27', 'Sashinha beats');

SELECT * FROM GENRE;

-- Insert two new records into Employee table
-- Insert two new records into Genre table
SELECT * FROM EMPLOYEE;
INSERT INTO EMPLOYEE VALUES (9, 'Costa', 'Lucas', 'Web Dev', 7, '12-DEC-93', '30-MAY-17', '400 Hayden Road', 'Tallahassee', 'FL', 'USA', '32308', '+1 (954) 297-7821', ' ', 'lucas@gmail.com');
INSERT INTO EMPLOYEE VALUES (10, 'Portela', 'Chris', 'Web Dev', 8, '01-DEC-93', '10-MAY-17', '400 Hayden Road', 'Tallahassee', 'FL', 'USA', '32308', '+1 (954) 297-7821', ' ', 'chris@gmail.com');

-- Insert two new records into Customer table
SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER VALUES (60, 'Matis', 'Galvas', null, '123 adress dr', 'Tampa', 'FL', 'USA', '32304', '+23 090-93 999', null, 'lucas@gmail.com', '4');
INSERT INTO CUSTOMER VALUES (61, 'Vicdney', 'Huepa', null, '123 adress dr', 'Tampa', 'FL', 'USA', '32304', '+23 090-93 999', null, 'lucas@gmail.com', '4'); 

-- 2.4 UPDATE
-- Update Aaron Mitchell in Customer table to Robert Walter
SELECT * FROM CUSTOMER;
UPDATE CUSTOMER
    SET FIRSTNAME = 'ROBERT', LASTNAME = 'Walter'
    WHERE FIRSTNAME = 'Aaron' and LASTNAME = 'Mitchell';
    
-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
SELECT * FROM ARTIST
UPDATE ARTIST
    SET NAME = 'CCR'
    WHERE NAME = 'Creedence Clearwater Revival';
    
--2.5 LIKE
-- Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE
    WHERE BILLINGADDRESS LIKE 'T%';
    
-- 2.6 BETWEEN
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
    WHERE TOTAL BETWEEN 15 AND 20;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
    WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';

-- 2.7 DELETE
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
SELECT * FROM CUSTOMER
    WHERE (lower(FIRSTNAME)) = 'robert' AND (lower(LASTNAME)) = 'walter';
SELECT * FROM INVOICE
    WHERE CUSTOMERID = 32;
SELECT * FROM INVOICELINE
    WHERE INVOICEID IN (50, 61, 116, 245, 268, 290, 342);
    
DELETE FROM INVOICELINE
    WHERE INVOICEID IN (50, 61, 116, 245, 268, 290, 342);
DELETE FROM INVOICE
    WHERE CUSTOMERID = 32;
DELETE FROM CUSTOMER
    WHERE (lower(FIRSTNAME)) = 'robert' AND (lower(LASTNAME)) = 'walter';
    
-- 3.0	SQL Functions
-- In this section you will be using the Oracle system functions, 
-- as well as your own functions, to perform various actions against the database

-- 3.1 System Defined Functions
-- Create a function that returns the current time.
create or replace function geSysdate
return date
is
    l_sysdate date;
begin
    select sysdate
    into l_sysdate
    from dual;
    
    return l_sysdate;
end;


-- create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION mediatypeLength(rec IN NUMBER)
RETURN NUMBER
IS
    media_length NUMBER;
BEGIN
    SELECT LENGTH(Name) INTO media_length FROM MediaType
        WHERE MediaTypeID = rec;
    RETURN media_length;
END;

-- 3.2 System Defined Aggregate Functions
-- Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION invoiceAvg
RETURN NUMBER
IS
    invAvg NUMBER;
BEGIN
    SELECT AVG(Total) INTO invAvg FROM Invoice;
    RETURN invAvg;
END;


-- Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOSTEXPENSIVETRACK
RETURN NUMBER
IS
    mostExpTrack NUMBER;
BEGIN
    select max(unitprice) into mostExpTrack from track;
    return mostExpTrack;
end;

 -- 3.3 User Defined Scalar Functions
-- Create a function that returns the average price of invoiceline
-- items in the invoiceline table
CREATE OR REPLACE FUNCTION averagePrice
RETURN NUMBER
IS
    avgprice = NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO avgprice FROM INVOICELINE;
    RETURN avgprice;
end;


ROLLBACK TO mySavePoint;