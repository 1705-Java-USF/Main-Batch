-- Savepoint so I can just run the whole file a bunch
savepoint mySavepoint;

-- 2.1 SELECT
-- 2.1.1
select * from employee;
-- 2.1.2
select * from employee where lastname = 'King';
-- 2.1.3
select * from employee where firstname = 'Andrew' and reportsto is null;

-- 2.2 ORDER BY
-- 2.2.1
select * from album order by title desc;
-- 2.2.2
select firstname from customer order by city;

-- 2.3 INSERT INTO
-- 2.3.1
insert into genre values(26, 'Genre1');
insert into genre values(27, 'Genre2');
-- 2.3.2
insert into employee values(9, 'Fine', 'Nathanial', 'Software Developer', 6, null, null, '7363 Oaklandon Road', 'Indianapolis', 'Indiana', 'United States of America', '46236', '+1 (317)8286616', null, 'nathanial.fine@gmail.com');
insert into employee values(10, 'Fine', 'Nathanial', 'Software Developer', 6, null, null, '7363 Oaklandon Road', 'Indianapolis', 'Indiana', 'United States of America', '46236', '+1 (317)8286616', null, 'nathanial.fine@gmail.com');
-- 2.3.3
insert into customer values(60, 'Nathanial', 'Fine', 'Revature', '7363 Oaklandon Road', 'Indianapolis', 'IN', 'United States of America', '46236', '3178286616',null,'nathanial.fine@gmail.com', null);
insert into customer values(61, 'Nathanial', 'Fine', 'Revature', '7363 Oaklandon Road', 'Indianapolis', 'IN', 'United States of America', '46236', '3178286616',null,'nathanial.fine@gmail.com', null);

-- 2.4 UPDATE
-- 2.4.1
update customer set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';
-- 2.4.2
update artist set name='CCR' where name = 'Creedence Clearwater Revival';

-- 2.5 LIKE
select * from invoice where billingaddress like 'T%';

-- 2.6 BETWEEN
-- 2.6.1
select * from invoice where total between 15 and 50;
-- 2.6.2

-- 2.7 DELETE
delete from invoiceline where invoiceid in (select invoiceid from invoice where customerid = (select customerid from customer where firstname = 'Robert' and lastname = 'Walter'));
delete from invoice where customerid = (select customerid from customer where firstname = 'Robert' and lastname = 'Walter');
delete from customer where firstname = 'Robert' and lastname = 'Walter';

-- 3.0 SQL Functions
-- 3.1 System Defined Functions
-- 3.1.1
create or replace function get_current_time
return date 
is
    l_sysdate timestamp;
begin
    select CURRENT_timestamp into l_sysdate FROM DUAL;
    return l_sysdate;
end;
-- 3.1.2
create or replace function get_media_type_length
return number
is
    leng number;
begin
    select lengthb(name) into leng from mediatype;
    return leng;
end;

-- 3.2 System Defined Functions
-- 3.2.1
create or replace function get_avg_invoice
return number
is
    avgNum number;
begin
    select avg(total) into avgNum from invoice;
    return avgNum;
end;
-- 3.2.2
create or replace function get_most_expen_track
return sys_refcursor
is
    curses sys_refcursor;
begin
    open curses
        for select max(unitprice) from track;
    return curses;
end;

/*
declare
    cur sys_refcursor;
    pric TRACK.UNITPRICE%type;
begin
    cur := get_most_expen_track();
    loop
        fetch cur into pric;
        exit when cur%notfound;
        DBMS_OUTPUT.PUT_LINE('Price: ' || pric);
    end loop;
end;
*/

-- 3.3 User Defined Scaler Functions
-- 3.3.1
create or replace function get_avg_invoiceline_price
return number
is
    price number;
begin
    select avg(unitprice) into price from invoiceline;
    return price;
end;

-- 3.4 User Defined Table Value Functions
-- 3.4.1
create or replace function get_emp_1968
return sys_refcursor
is l_rc sys_refcursor;
begin
    open l_rc
        for select * from employee where birthdate > to_date("31-DEC-68");
    return l_rc;
end;

-- 4.0 Stored Procedures
-- 4.1 Basic Stored Procedures
create or replace procedure get_names(curse out sys_refcursor)
is
begin
    open curse for
        select firstname,lastname from employee;
end;

-- 4.2 Store Procedure Input Parameters
-- 4.2.1
create or replace procedure update_employee (empid in number, fname in varchar2, lname in varchar2, ttle in varchar2)
is
begin
    update employee set firstname=fname, lastname=lname, title=ttle where employeeid = empid;
end;
-- 4.2.2
create or replace procedure get_emp_managers(empid in number, eCurse out sys_refcursor)
is
begin
    open eCurse for select firstname,lastname,reportsto from employee where employeeid in 
    (select reportsto from employee where employeeid = empid);
end;
/*
declare
    cur sys_refcursor;
    fn employee.firstname%type;
    ln employee.lastname%type;
    rep employee.reportsto%type;
begin
    get_emp_managers(10,cur);
    loop
        fetch cur into fn,ln,rep;
        exit when cur%notfound;
        DBMS_OUTPUT.PUT_LINE('fn: ' || fn || '\tln: ' || ln || '\trep: ' || rep);
    end loop;
end;
*/

-- 4.3 Stored Procedure Output Parameters
create or replace procedure get_cust_info(custid in number, fname out varchar2, lname out varchar2, compny out varchar2)
is
begin
    select firstname,lastname,company into fname, lname, compny from customer where customerid = custid;
end;

-- 5.0 Transactions
-- 5.0.1
create or replace procedure delete_invoice(invid in number)
is
begin
    commit;
    set transaction name 'Invoice';
    delete from invoiceline where invoiceid = invid;
    delete from invoice where invoiceid = invid;
    commit;
end;
declare
    
begin
    delete_invoice(329);
end;
-- 5.0.2
create or replace procedure insert_customer(cid in number, fname in varchar2, lname in varchar2,
                                        cmpny in varchar2, addrss in varchar2, city in varchar2,
                                        state in varchar2, cntry in varchar2, zip in varchar2,
                                        phone in varchar2, fax in varchar2, email in varchar2,
                                        support in number)
is
begin
    commit;
    set transaction name 'new customer';
    insert into customer values(cid, fname, lname, cmpny, addrss, city, state, cntry, zip, phone, fax, email, support);
    commit;
end;
declare

begin
    insert_customer(60, 'Nathan', 'Fine', 'Revature', '555 someplace', 'Reston', 'VA', 'USA', '55555', '555-555-5555', '444-444-4444', 'n@revature.com', 1);
end;

-- 6.0 Triggers
-- 6.1 After/For
-- 6.1.1
create or replace trigger insert_emp_trigger
after insert on employee
for each row
begin
    DBMS_OUTPUT.PUT_LINE('Employee inserted');
end;
-- 6.1.2
create or replace trigger update_alb_trigger
after update on album
for each row
begin
    DBMS_OUTPUT.PUT_LINE('Album Updated');
end;
-- 6.1.3
create or replace trigger delete_cust_trigger
after delete on album
for each row
begin
    DBMS_OUTPUT.PUT_LINE('Customer Deleted');
end;

-- 7.0 Joins
-- 7.1 Inner
select c.firstname,c.lastname,i.invoiceid from customer c inner join invoice i using(customerid);
-- 7.2 Outer
select c.customerid,c.firstname,c.lastname,i.invoiceid,i.total from customer c full outer join invoice i on i.customerid = c.customerid;
-- 7.3 Right
select r.name, a.title from album a right join artist r on a.artistid = r.artistid;
-- 7.4 Cross
select * from album cross join artist order by artist.name;
-- 7.5 Self
select * from employee e inner join employee o on e.employeeid = o.reportsto;

-- 9.0 Administration

-- Rollback changes to the beginning
rollback to mySavepoint;