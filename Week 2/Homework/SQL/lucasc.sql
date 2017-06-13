create table flash_cards
(
    fc_id number(6),
    fc_question varchar2(4000) unique,
    fc_answer varchar2(4000),
    constraint pk_fc primary key(fc_id)
)

insert into flash_cards Values(1, 'What is life?', 'Whatever you make it... or 42');
insert into flash_cards Values(2, 'Are we human?', 'Nope... we''re dancers');

select * from flash_cards;

CREATE SEQUENCE fc_seq
    start with 3
    increment by 1;
    
CREATE OR REPLACE TRIGGER fc_seq_trigger
BEFORE INSERT ON flash_cards
FOR EACH ROW
BEGIN

    IF :new.fc_id IS NULL THEN