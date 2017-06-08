--SQL comments are done via '--'

/*
--DDL: Data Defenition Language
    CREATE, ALTAR, DROP, TRUNCATE 
--DML: Data Manipulation Language
    SELECT, UPDATE, INSERT, DELETE
--DQL: Data Query Language
    SELECT
--DCL: Data Control Language
    GRANT, REVOKE
--TCL: Transaction Control Language
    COMMIT, ROLLBACK, SAVEPOINT

--Create syntax

CREATE TABLE tablename 
(
  columnname datatype null/not null,
  another col,
  another col,
  etc,
  
)

*/

/*
DATATYPES:
  char(size), max size is 2000 bytes  
  varchar2, Use for strings, max size is 4000 bytes
  nchar(),
  nvarchar2, Both n version stand for NLS, Same as above, but includes all UTF-8 characters
  
  number(amount of digits)
  
  date: Mon d, yyyy
  timestamp: year,month,day,hour,minute,second
  
  blob, binary large object     max size: 4 gb -1
  clob, character large object  max size: 4 gb -1
*/


CREATE TABLE DOGS(
  FIRST_NAME varchar2(100) not null, --null means null values accepted, not null is the opposite
  LAST_NAME varchar2(100) not null,
  speak varchar2(100) null,
  human varchar2(100) null
);

select * from DOGS;

/*
ALTER TABLE tablename
  [ADD, MODIFY, DROP, RENAME] [column columnname, constraint constraintname]  
*/
ALTER TABLE DOGS
  RENAME Column human to human_OWNER;
  
select * from dogs;

--Deletes table entirely
DROP TABLE DOGS;


CREATE TABLE DOGS(
  FIRST_NAME varchar2(100) not null, --null means null values accepted, not null is the opposite
  LAST_NAME varchar2(100) not null,
  speak varchar2(100) null,
  human varchar2(100) null
);

--Insert example
--NOTE: use apostrophes for insert strings.
INSERT INTO DOGS 
  (FIRST_NAME, LAST_NAME, speak, human)
  VALUES
  ('Fido', 'Odif', 'Barks', 'Bobbert');
  
--Shorthanded insert
--If you omit the explicit columns, SQL assumes that you will provide values for every
--column available in teh table, from left to right.
INSERT INTO DOGS VALUES
  ('McGruff', 'CrimeDog', 'Barks', null);

select * from DOGS;

TRUNCATE TABLE DOGS; --Delete all entries in a table. DANGEROUS, you can NOT rollback from this.
select * from DOGS;


INSERT INTO DOGS 
  (FIRST_NAME, LAST_NAME, speak, human)
  VALUES
  ('Fido', 'Odif', 'Barks', 'Bobbert');
INSERT INTO DOGS VALUES
  ('McGruff', 'CrimeDog', 'Barks', null);
INSERT INTO DOGS 
  (FIRST_NAME, LAST_NAME)
  VALUES
  ('Rex', 'Xus');

select * from DOGS;

--UPDATES
UPDATE DOGS
  set FIRST_NAME = 'T',
  LAST_NAME = 'Rex'
  WHERE lower(FIRST_NAME) = lower('t-rex');

delete from Dogs
Where human is null;


select * from dogs;

/*
In oracle there are 5 main constraints
-null/not null
-Check - A condition to be applied to inserts, eg, number must be greater than 500
-Unique - All values in the column must be unique
-Primary Key - The main identifying column, it is unique, not null, 
-Foreign Key - A Key that points to an existing column of another table, forms
  a relationship between the two tables. MUST point to a unique column.
  (More commonly used to point at primary keys)
*/

CREATE TABLE numbers
(
  ID number(6) not null,
  letter varchar2(2) not null,
  num number(6) not null,
  constraint numbers_pk Primary Key(ID)
)

select * from numbers;
insert into numbers VALUES (1,'A', 2);
insert into numbers VALUES (2,'B', 7);
insert into numbers VALUES (3,'C', 9);
insert into numbers VALUES (4,'C', 12);
insert into numbers VALUES (6,'B', 1);
insert into numbers VALUES (5,'C', 16);

select * from numbers 
  where num BETWEEN 5 AND 8;

--ORDER BY, order the results by a certain column(s)
select * from numbers 
  order by Letter, num; --By default, orders by ascending

--ORDER BY, order the results by a certain column(s)
select * from numbers 
  order by Letter desc, num desc;
  
--Aggragates
/*
AVE()
SUM()
MAX()
MIN()
STDDEV()
VARIANCE()
LAST()
FIRST()
COUNT()

SCALER FUNCTIONS
-AIM to alter the data of each cell in a column depending on the function
lower() --convert to lowercase
upper() --convert to uppercase
ABS()   
Cos,sin,tan
ROUND()
TRUNC()
Concat()
Length()
LTRIM()
RTRIM()

*/
--ALIASES
--You can us 'AS' to provide temporary names for columns or tables. For the sake of readability
--are easy access. 
select ID AS "NEW_ID_NAME",concat(letter, num) AS "concanated_cols" from numbers;

/*
Having and group by
-Group by will group all duplicate elements in a column together.
    -Group bys work alongside aggragate functions for other columns.
-Having provides a way to perfom conditional on the grouped columns.
    -Having works exclusively with group bys, and also allows us to do
    checks on aggragated values;
*/

select Letter, sum(Num) from numbers
where num > 10
group by Letter
having sum(num)>10
order by sum(num);

/*
LIKE
-Like can be used instead of '=' on where conditions.
  -Serves to provide a sort of pseudo regex check for strings.
  -% means 0 to many characters
  -_ means 1 character
*/

select * from dogs
where (lower(First_NAME) like '%i%'
AND Last_Name like '%i%')
or first_name like '%u%';

--'_%t_%tt%'
--My word must have the following reqs:
    --At least one letter must be before a t,
    --There must be at least one letter separating t and tt
    --String must have both, a 't' and a 'tt'
    
--IN
  --One can think of IN as a convenient OR chain.
select * from dogs
WHERE FIRST_NAME = 'Fido'
or First_name = 'McGruff'
or First_name = 'Rex';

select * from dogs
where First_name IN ('Fido', 'McGruff', 'Rex');
  

create table DOGS
(
  DOG_ID number(6),
  F_NAME varchar2(100),
  L_NAME varchar2(100),
  Speak varchar2(100),
  human_id number(6),
  constraint dogs_pk primary key(DOG_ID)
);

create table CATS
(
  Cat_ID number(6),
  F_NAME varchar2(100),
  L_NAME varchar2(100),
  Speak varchar2(100),
  human_id number(6),
  constraint Cat_pk primary key(Cat_ID)
);

create table Humans
(
  Human_ID number(6),
  F_NAME varchar2(100),
  L_NAME varchar2(100),
  Speak varchar2(100),
  constraint human_pk primary key(Human_ID)
);

ALTER TABLE DOGS
ADD Constraint dog2human_FK Foreign Key (human_id) references Humans(Human_id);

ALTER TABLE CATS
ADD Constraint cat2human_FK Foreign Key (human_id) references Humans(Human_id);

insert into humans values(1, 'Bobbert', 'Bobson', 'Hello!');
insert into humans values(2, 'Tommy', 'Tompson', 'Hello, I am Tommy!');
insert into humans values(3, 'Billy', 'Billson', 'Hello! I Am Bill!');

insert into DOGS Values(1, 'Dogbert', 'Dogson', 'Bark',1);
insert into DOGS Values(2, 'Rex', 'Rexson', 'Bark',1);
insert into DOGS Values(3, 'Fido', 'Fidoson', 'Bark',1);
insert into DOGS Values(4, 'Cody', 'Codison', 'Bark',2);

insert into CATS VALUES(1, 'Cat', 'Catson', 'Meow', 2);
insert into CATS VALUES(2, 'Tiger', 'Tigerson', 'Meow', 3);

Alter Table CATS
Add constraint Cat_check check(length(f_name) < 20);

--Use check to place more specific rules to what is being inserted.
insert into CATS VALUES(3, 'Barthalemulerhiggensss', 'Tigerson', 'Meow', 3);

Create table speak_lookup(
  speak_id number(6) primary key,
  speak varchar2(100) unique not null
)

alter table humans
add (speak_id number(6));

alter table dogs
add (speak_id number(6));

alter table cats
add (speak_id number(6));

alter table humans
add constraint human2speak_fk foreign key (speak_id) references speak_lookup(speak_id);

alter table dogs
add constraint dog2speak_fk foreign key (speak_id) references speak_lookup(speak_id);

alter table cats
add constraint cat2speak_fk foreign key (speak_id) references speak_lookup(speak_id);

insert into speak_lookup values(1, 'bark');
insert into speak_lookup values(2, 'meow');
insert into speak_lookup values(3, 'hello');

commit;

update Humans
 set speak_id = 3
 where speak_id is null;
 
--Using select statement results as tables (views)
select * from (select a.F_NAME, a.L_NAME, b.SPEAK from humans a
 inner join speak_lookup b
 on a.speak_id = b.speak_id)
 cross join
 (select a.F_NAME, a.L_NAME, b.SPEAK from humans a
 inner join speak_lookup b
 on a.speak_id = b.speak_id);

create Table A
(
  id number(6) not null,
  let varchar2(6) not null
)

create Table B
(
  id number(6) not null,
  let varchar2(6) not null
)

insert into A values(1,'A');
insert into A values(2,'B');
insert into A values(3,'C');
insert into A values(4,'D');

insert into B values(3,'C');
insert into B values(4,'D');
insert into B values(5,'E');
insert into B values(6,'F');

select * from a 
full outer join b
on a.id = b.id;

select * from a
left join b
on a.id = b.id
order by a.id;

select a.id as AID, a.let as ALET, b.id as BID, b.let as BLET from a
full outer join b
on a.id = b.id
where a.id is null
or b.id is null
order by a.id;

select * from A
union
select * from B;

select * from A
union all
select * from B;

select * from A;
Select * from B;

select * from A
minus 
select * from B;

select * from A
intersect
select * from B;

select * from A
inner join b
on a.id = b.id;

select id, let, id as "ID_1", let as "LET_1" from a
intersect
select id, let, id as "ID_1", let as "LET_1" from b;

select id,id,id,id from a;

select * from a;
alter table a 
add constraint a_pk primary key(id, let);

select * from a;
commit;

