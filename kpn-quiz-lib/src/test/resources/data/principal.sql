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
insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (1, 'administrator', 0, true, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID)
values (1, 'System Root', 'abc123', 'rafizan.baharum@gmail.com', null);
insert into QA_ACTR (ID, ACTOR_TYPE, ADDRESS1, ADDRESS2, ADDRESS3, AGE, EMAIL, FAX, M_ST, C_ID, C_TS)
values (0, 2, 'Lorong 1 ', 'Taman Midah', 'Cheras', 22, 'rafizan.baharum@gmail.com', 'fax', 1, 1, CURRENT_TIMESTAMP );
insert into QA_SPPT(ID) values(0);
update QA_USER set ACTOR_ID = 0 where id = 1;

insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(1, 0, 1, 1, 1, CURRENT_TIMESTAMP );
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(2, 1, 1, 1, 1, CURRENT_TIMESTAMP );




