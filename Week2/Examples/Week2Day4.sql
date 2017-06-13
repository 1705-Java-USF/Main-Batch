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

--Stored procedure
/*
  A named transaction that can be invoked when called.
  
  CREATE [OR REPLACE] Proc_name
  IS
      This section is where you can DECLARE variables
  BEGIN
      This section is what you can write the execution
  EXCEPTION
      This is where you can write the exception handler
  END;
  
  invoke your procedures via:
  BEGIN
    proc_name();
  END;
  
  OR
  
  call proc_name();
*/
CREATE OR REPLACE PROCEDURE hello_world_procedure
IS
BEGIN
  DBMS_OUTPUT.PUT_LINE('Hello world!');
END;

/*
  To view the sql developer console navigate to:
  View>dbms output> click the '+' symbol and add the database whose console you want to view
*/
BEGIN
  hello_world_procedure();
END;
/*
  Procedures can allow us to define executions that can change the data
  of a table. Most actions can be taken against a table using these procedures.
*/

/*
  Things of note:
    With parameters, you have the following:
    IN parameters, which store whatever is passed as input during the procedure call.
    OUT parameters, which serve to only hold the result of execution in a procedure.
    IN OUT parameters, can serve both purposes.
    Parameter syntax is as follows: paramname IN/OUT/IN OUT datatype
*/
CREATE OR REPLACE PROCEDURE insert_fc_procedure(some_q IN VARCHAR2, some_a IN flash_cards.fc_answer%TYPE)
IS
BEGIN
  INSERT INTO flash_cards(fc_question, fc_answer) VALUES(some_q, some_a);
  commit;
END;

BEGIN
  insert_fc_procedure('Question from a procedure?','You betcha!');
END;

select * from flash_cards;

CREATE OR REPLACE PROCEDURE get_answer_procedure(some_q IN VARCHAR2, some_a OUT VARCHAR2)
IS
BEGIN
  select fc_answer into some_a from flash_cards where fc_question = some_q;
END;

--Things to note: Use DECLARE to set up a block where variables can be declared then
--used within the BEGIN block.
DECLARE
  inputs varchar2(4000);
  
  answer varchar2(4000);
BEGIN
  inputs := 'question';
  get_answer_procedure('Are we human?', answer);
  DBMS_OUTPUT.PUT_LINE('Answer is: ' || answer);
END;

/*
  CURSORS!
  -A cursor is essentially like a pointer to a table or view.
  -We can use them to iterate through entire queries from the database.
  -When we want to pass entire tables or queries, we need to use cursors.
  
  NOTE: PL/SQL offers a CURSOR and a SYS_REFCURSOR
  The SYS_REFCURSOR is a stronger cursor (therefore more costly) that is allowed
  to be passed outside the scope of a procedure. A normal CURSOR must be created
  and die within the scope of the procedure it is created in.
*/
CREATE OR REPLACE PROCEDURE get_all_fc_procedure(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  open cursorParam FOR
  select * from flash_cards;
END;

DECLARE
  fc_cursor SYS_REFCURSOR;
  someId flash_cards.fc_id%type;
  someQuestion flash_cards.fc_question%type;
  someAnswer flash_cards.fc_answer%type;
BEGIN
  GET_ALL_FC_PROCEDURE(fc_cursor);
  
  LOOP
    FETCH fc_cursor INTO someId, someQuestion, someAnswer;
    EXIT WHEN fc_cursor%NOTFOUND; --%NOTFOUND does not exist until there is no records to be fetched.
    DBMS_OUTPUT.PUT_LINE(someId || ' ' || someQuestion || ' ' || someAnswer);
  END LOOP;
END;

/*
  FUNCTIONS!
  -a function differs from a stored procedure in the following ways.
  A stored procedure does not have to return anything.
  A stored procedure can have as many IN/OUT parameters as it wants.
  A stored procedure can alter the database such as insert, delete, etc.
  A stored procedure can NOT be called mid query.
  
  A function MUST return ONE thing
  A function CAN use OUT parameters, though it is recommended not to do so.
  A function can NOT perform database operations.
  A function CAN be called mid query.
*/


CREATE OR REPLACE FUNCTION get_max_id
RETURN NUMBER
IS
  max_id NUMBER;
BEGIN
  SELECT max(fc_ID) into max_id from flash_cards;
  RETURN max_id;
END;

DECLARE
  maxid number;
BEGIN
  maxid := get_max_id();
  DBMS_OUTPUT.PUT_LINE('Max id is: ' || maxid);
END;


DECLARE

  firstNum number;
  secondNum number;
  maxNum number;
  
  FUNCTION findMAX(x IN NUMBER, y IN NUMBER)
  RETURN NUMBER
  IS
    z NUMBER;
  BEGIN
  
    IF x > y THEN
      z := x;
    ELSE
      z := y;
    END IF;
    
    RETURN Z;
  END;
  
BEGIN
  firstNum := 25;
  secondNum := 42;
  maxNum := findMax(firstNum, secondNum);
  
  DBMS_OUTPUT.PUT_LINE(maxNUM);
END;

--EXCEPTION HANDLING EXAMPLE
CREATE OR REPLACE PROCEDURE exception_example
IS
  CURSOR badCurse IS 
    select * from flash_cards;
  fid flash_cards.fc_id%TYPE;
  fquestion flash_cards.fc_question%TYPE;
  fanswer flash_cards.fc_answer%TYPE;
BEGIN
  --OPEN badCurse;
  LOOP
    FETCH badCurse into fid, fquestion, fanswer;
    EXIT WHEN badCurse%NOTFOUND;
  
  END LOOP;
  CLOSE badCurse;
  
  EXCEPTION --Block triggers when an exception occurs
    WHEN INVALID_CURSOR THEN --Checks if the exception exists, which it only will when it occurs
        dbms_output.put_line('The cursor is bad...');
    WHEN ZERO_DIVIDE THEN
        dbms_output.put_line('You divided by zero!');  
END;

BEGIN
  EXCEPTION_EXAMPLE();
END;

--VIEWS
/*
  We can use views to store query results from our select statements.
  One can then perform queries on the views themselves.
  -This aids in preventing someone from rewriting old queries
      -Useful for queries one runs often
  -This also provides a means of security, since when one references the view,
    they don't know the names of the tables being accessed.
*/

delete from (select * from flash_Cards)
where fc_id = 5;

CREATE VIEW flash_card_subset
AS
select fc_question, fc_answer from flash_cards
where fc_id between 2 and 4;

select * from flash_card_subset
where fc_question like '%human%';