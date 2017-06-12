/*
    Question 2.1: SELECT
*/
select * from Employee;
select * from Employee where lastname = 'King';
select * from Employee where firstname = 'Andrew'
union
select * from Employee where reportsto = null;

/*
    Question 2.2: ORDER BY
*/

Select * from Album order by title desc;
Select firstname from Customer order by city;

/*
    Question 2.3: INSERT INTO
*/

Insert into genre values (26, 'Ska');
Insert into genre (genreid, name) values (27, 'Ragtime');

Insert into employee (employeeid, lastname, firstname, title, reportsto)
values (9, 'Witch', 'White', 'Queen of Narnia', null);
Insert into employee (employeeid, lastname, firstname, title, reportsto)
values (10, 'Tumnus', 'Mister', 'Kidnapper', 9);

Insert into customer values (60, 'Steven', 'Universe', null, 'Beach City temple', 'Beach City', 'Unknown', 'USA', null, null, null, 'unknown', 4);
Insert into customer values (61, 'Greg', 'Universe', null, 'Beach City Car Wash', 'Beach City', 'Unknown', 'USA', null, null, null, 'unknown', 4);

/*
    Question 2.4: UPDATE
*/

Update customer set firstname = 'Robert' where customerid = 32;
Update customer set lastname = 'Walter' where customerid = 32;

Update artist set name = 'CCR' where name = 'Creedence Clearwater Revival';

/*
    Question 2.5: LIKE
*/

Select * from Invoice where BILLINGADDRESS like 'T%';

/*
    Question 2.6: BETWEEN
*/

Select * from Invoice where total between 15 and 50;
Select * from employee where hiredate between '1-JUN-03' and '1-MAR-04';

/*
    Question 2.7: DELETE
*/

delete invoiceline where invoiceid in (50, 61, 116, 245, 268, 290, 342);
delete invoice where customerid = 32;
delete customer where firstname = 'Robert' and lastname = 'Walter';

/*
    Question 3.1: System defined functions
*/
create or replace function get_time
return timestamp
is
    output timestamp;
begin
    select current_timestamp into output from dual;
    return output;
end;
/

create or replace function get_mediatype_length (type_id in int)
return int
is
    type_name varchar2(4000);
    output int;
begin
    select name into type_name from MediaType where mediatypeid = type_id;
    output := length(type_name);
    return output;
end;
/

--Question 3.2: System-Defined Aggregate Functions
create or replace function average_invoice
return number
is
    total number;
    num_invoices number;
    average number;
begin
    select sum(total) into total from invoice;
    select count(total) into num_invoices from invoice;
    average := total/num_invoices;
    return average;
end;
/

create or replace function most_expensive_track
return number
is
    price number;
    output number;
begin
    select max(unitprice) into price from track;
    select trackid into output from track where unitprice = price;
    return output;
end;
/

--Question 3.3: User-defined scalar functions

create or replace function average_invoice_line
return number
is
    total number;
    num_invoices number;
    average number;
begin
    select sum(unitprice) into total from invoiceline;
    select count(unitprice) into num_invoices from invoiceline;
    average := total/num_invoices;
    return average;
end;
/

--Question 3.4: User-Defined Tabled value functions

create or replace function after_1968
return number
is
    output number;
begin
    select employeeid into output from employee where birthdate > '31-DEC-68';
    return output;
end;
/

/*
    Question 4.1: Basic Stored Procedure
*/

create or replace procedure emp_names(firstnames out varchar2, lastnames out varchar2)
is
begin
    select firstname into firstnames from employee;
    select lastname into lastnames from employee;
end;
/

--Question 4.2: Stored Procedure Input Parameters

create or replace procedure updateEmployee(e_id in number, addr in varchar2, cty in varchar2, stt in varchar2, cntry in varchar2, pstcd in varchar2, phn in varchar2, fx in varchar2, eml in varchar2)
is
begin
    update employee set address=addr, city=cty, state=stt, country=cntry, postalcode=pstcd, phone=phn, fax=fx, email=eml where employeeid=e_id;
end;
/

create or replace procedure getManager(e_id in number, output out number)
is
begin
    select reportsto into output from employee where employeeid=e_id;
end;
/

--Question 4.3: Stored Procedure Output Parameters

create or replace procedure getNameAndCompany(c_id in number, fullname out varchar2, company out varchar2)
is
    f_name varchar2 (40 BYTE);
    l_name varchar2 (20 BYTE);
begin
    select company into company  from customer where customerid=c_id;
    select firstname into f_name from customer where customerid=c_id;
    select lastname  into l_name from customer where customerid=c_id;
    fullname:= f_name || ' ' || l_name;
end;
/

/*
    Question 5.0: Transactions
*/

create or replace procedure transactiveDeletion(invoice_ID in number)
is
begin
    begin
        delete from invoice cascade where invoiceid=invoice_ID;
        commit;
    end;
end;
/

create or replace procedure newCustomer(cusID in number, fname in varchar2, lname in varchar2, cmp in varchar2, addr in varchar2, cty in varchar2, stt in varchar2, cntry in varchar2, pstcd in varchar2, phn in varchar2, fx in varchar2, eml in varchar2, repid in number)
is
begin
    begin
        insert into customer values (cusID, fname, lname, cmp, addr, cty, stt, cntry, pstcd, phn, fx, eml, repid);
        commit;
    end;
end;
/

/*
    6.1: After/For
*/

create or replace trigger onEmployeeHired
    after
        insert
    on employee
begin
    DBMS_OUTPUT.PUT_LINE('Yo dawg, I herd yo and yo dog like yo-yos');
end;
/

create or replace trigger onAlbumReleased
    after
        insert
    on album
begin
    DBMS_OUTPUT.PUT_LINE('So I put yo dog with a yo-yo on a yo-yo');
end;
/

create or replace trigger onCustomerLost
    after
        delete
    on customer
begin
    DBMS_OUTPUT.PUT_LINE('So yo can yo-yo yo yo-yo dog while yo yo-yo dog yo-yos, dawg.');
end;
/

/*
    Question 7.1: Inner
*/

select firstname, lastname, invoiceid from customer inner join invoice on customer.customerid = invoice.customerid;

/*
    Question 7.2: Outer
*/

select customer.customerid, firstname, lastname, invoiceid, total from customer full outer join invoice on customer.customerid = invoice.customerid;

/*
    Question 7.3: Right
*/

select artist.name, title from ALBUM right join artist on artist.artistid = album.artistid;

/*
    Question 7.4: Cross
*/

select albumid, title, artist.artistid, name from ALBUM cross join artist where album.artistid = artist.artistid order by artist.NAME;

/*
    Question 7.5: Self
*/

select * from employee e, employee m where e.reportsto = m.employeeid;

/*
    Question 9.0: Administration
*/