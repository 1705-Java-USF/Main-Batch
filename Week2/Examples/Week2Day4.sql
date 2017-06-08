create table flash_cards
(
  fc_id number(6),
  fc_question varchar2(4000) unique,
  fc_answer varchar2(4000),
  constraint pk_fc primary key(fc_id)
)

insert into flash_cards Values(1, 'What is life?', 'Whatever you make it.... or 42.... claims 1705 batch...');
insert into flash_cards Values(2, 'Are we human?', 'No, dammit, we are dancers.');

select * from flash_cards;

--PL/SQL is used with Oracle, and it provides tools that we can use with SQL.
--    Such as, functions, stored procedures, sequences, triggers
--    Also provides a means to write code inside our database (PL/SQL code)

--Sequence
/*
  A Sequence is an object that will maintain a counter for us. 
*/

CREATE SEQUENCE fc_seq
  start with 3
  increment by 1;
--This sequence will be used to handle the ID field for our PK in Flash cards
--We will accomplish with the use of triggers.

--TRIGGER
/*
  A trigger can be used to detect an action on a table.
  Looks for things like insert, delete, update, etc.
  Then you can set it up to react either before the action, or after the action.
  
  There also exist something called an 'instead of trigger' which is the same, 
  but, as the name implies, if the detected action occurs, do something else
  instead.
*/
CREATE OR REPLACE TRIGGER fc_seq_trigger
BEFORE INSERT ON flash_cards
FOR EACH ROW
BEGIN --Begin signifies a block for a transaction. We are able to write PL/SQL code here.

  IF :new.fc_id IS NULL THEN --:new this object holds the data that is currently waiting to be inserted.
                             --Essentially a staging platform that we can access.
    /*
      Select into statement:
          Query the database and use what is grabbed as input for an action.
          
      Grabbing our sequence value:
          -Use the sequenceName.nextval to grab the currently set value of our
            sequence, AND increment by one afterwards.
    */
    select fc_seq.nextval into :new.fc_id from dual;
  END IF;
END;  

insert into flash_cards values(null, 'Check it out?', 'neat!');
insert into flash_cards (FC_QUESTION, FC_ANSWER)
VALUES('Another question?', 'Yeah I guess...');

select * from flash_cards;