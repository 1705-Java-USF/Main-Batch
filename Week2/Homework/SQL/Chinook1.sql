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

--2.4 Update
UPDATE CUSTOMER
Set FirstName = 'Robert', 
    LastName= 'Walter' 
WHERE lower(FirstName) = 'aaron' and lower(LastName) = 'mitchell';

UPDATE Artist
Set Name = 'CRC'
WHERE Name = 'Creedence Clearwater Revival';

commit;



SELECT * FROM Customer;








