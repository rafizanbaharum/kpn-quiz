update QA_USER set ACTOR_ID = null;
delete from QA_INTR;
delete from QA_STDN;
delete from QA_ACTR;

delete from QA_GROP_MMBR;
delete from QA_GROP;
delete from QA_USER;
delete from QA_PCPL_ROLE;
delete from QA_PCPL;

-- 6367c48dd193d56ea7b0baad25b19455e529f5ee
insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (0, '000000000000', 0, true, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID)
values (0, 'System Root', 'abc123', 'rafizan.baharum@gmail.com', null);
insert into QA_ACTR (ID, ACTOR_TYPE, NAME, NRIC_NO, ADDRESS1, ADDRESS2, ADDRESS3, AGE, EMAIL, FAX, M_ST, C_ID, C_TS)
values (0, 2, 'System Root', '000000000000', 'Kementerian Penerangan', 'Putrajaya', 'WPKL', 22, 'rafizan.baharum@gmail.com', 'fax', 1, 1, CURRENT_TIMESTAMP );
insert into QA_SPPT(ID) values(0);
update QA_USER set ACTOR_ID = 0 where id = 0;
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(1, 0, 0, 1, 1, CURRENT_TIMESTAMP );
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(2, 1, 0, 1, 1, CURRENT_TIMESTAMP );


insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (1, '1111111111', 0, true, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID)
values (1, 'Support', 'abc123', 'rafizan.baharum@gmail.com', null);
insert into QA_ACTR (ID, ACTOR_TYPE, NAME, NRIC_NO, ADDRESS1, ADDRESS2, ADDRESS3, AGE, EMAIL, FAX, M_ST, C_ID, C_TS)
values (1, 2, 'System Support I', '1111111111',  'Kementerian Penerangan', 'Putrajaya', 'WPKL', 22, 'rafizan.baharum@gmail.com', 'fax', 1, 1, CURRENT_TIMESTAMP );
insert into QA_SPPT(ID) values(1);
update QA_USER set ACTOR_ID = 1 where id = 1;
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(3, 1, 1, 1, 1, CURRENT_TIMESTAMP );
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(4, 1, 1, 1, 1, CURRENT_TIMESTAMP );


insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (2, '222222222222', 0, true, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID)
values (2, 'Support', 'abc123', 'rafizan.baharum@gmail.com', null);
insert into QA_ACTR (ID, ACTOR_TYPE, NAME, NRIC_NO, ADDRESS1, ADDRESS2, ADDRESS3, AGE, EMAIL, FAX, M_ST, C_ID, C_TS)
values (2, 2, 'System Support II', '222222222222',  'Kementerian Penerangan', 'Putrajaya', 'WPKL', 22, 'rafizan.baharum@gmail.com', 'fax', 1, 1, CURRENT_TIMESTAMP );
insert into QA_SPPT(ID) values(2);
update QA_USER set ACTOR_ID = 2 where id = 2;
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(5, 1, 1, 1, 1, CURRENT_TIMESTAMP );
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(6, 1, 1, 1, 1, CURRENT_TIMESTAMP );

ALTER SEQUENCE SEQ_QA_PCPL START WITH 3;
ALTER SEQUENCE SEQ_QA_ACTR START WITH 3;
ALTER SEQUENCE SEQ_QA_PCPL_ROLE START WITH 3;

SELECT c.relname FROM pg_class c WHERE c.relkind = 'S';

select 'select ''' || relname || ''' as sequence, last_value from ' || relname || ' union' FROM pg_catalog.pg_class c WHERE c.relkind IN ('S','');



