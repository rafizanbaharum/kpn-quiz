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
insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (1, 'root', 0, true, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID)
values (1, 'System Root', 'abc123', 'rafizan.baharum@gmail.com', null);

insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(1, 0, 1, 1, 1, CURRENT_TIMESTAMP );
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(2, 1, 1, 1, 1, CURRENT_TIMESTAMP );

insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (2, 'GROUP_USER', 1, true, false, 1, 0, CURRENT_TIMESTAMP );
insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (3, 'GROUP_ADMIN', 1, true, false, 1, 0, CURRENT_TIMESTAMP );
insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (4, 'GROUP_INSTRUCTOR', 1, true, false, 1, 0, CURRENT_TIMESTAMP );
insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (5, 'GROUP_STUDENT', 1, true, false, 1, 0, CURRENT_TIMESTAMP );
insert into QA_GROP(ID) values (2);
insert into QA_GROP(ID) values (3);
insert into QA_GROP(ID) values (4);
insert into QA_GROP(ID) values (5);

insert into QA_GROP_MMBR (ID, GROUP_ID, MEMBER_ID, M_ST, C_ID, C_TS) values (1, 2, 1, 1, 1, CURRENT_TIMESTAMP);
insert into QA_GROP_MMBR (ID, GROUP_ID, MEMBER_ID, M_ST, C_ID, C_TS) values (2, 3, 1, 1, 1, CURRENT_TIMESTAMP);
insert into QA_GROP_MMBR (ID, GROUP_ID, MEMBER_ID, M_ST, C_ID, C_TS) values (3, 4, 1, 1, 1, CURRENT_TIMESTAMP);
insert into QA_GROP_MMBR (ID, GROUP_ID, MEMBER_ID, M_ST, C_ID, C_TS) values (4, 5, 1, 1, 1, CURRENT_TIMESTAMP);



-- INSTRUCTOR & STUDENT
insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (10, 'instructor1', 0, true, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID)
values (10, 'Cikgu Ahmad', 'abc123', 'rafizan.baharum@gmail.com', null);
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(10, 1, 1, 1, 1, CURRENT_TIMESTAMP );
insert into QA_ACTR (ID, ACTOR_TYPE, ADDRESS1, ADDRESS2, ADDRESS3, AGE, EMAIL, FAX, M_ST, C_ID, C_TS)
values (1, 0, 'Lorong 1 ', 'Taman Midah', 'Cheras', 22, 'rafizan.baharum@gmail.com', 'fax', 1, 1, CURRENT_TIMESTAMP );
insert into QA_INTR(ID, SCHOOL_NAME, DISTRICT_NAME, STATE_ID)
values (1, 'Sekolah Bandar Tun Razak', 'Cheras', 1);
update QA_USER set ACTOR_ID = 1 where ID = 10;

insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (11, 'student1', 0, true, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID)
values (11, 'Ahmad', 'abc123', 'rafizan.baharum@gmail.com', null);
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(11, 1, 1, 1, 1, CURRENT_TIMESTAMP );
insert into QA_ACTR (ID, ACTOR_TYPE, ADDRESS1, ADDRESS2, ADDRESS3, AGE, EMAIL, FAX, M_ST, C_ID, C_TS)
values (2, 1, 'Lorong 1 ', 'Taman Midah', 'Cheras', 22, 'rafizan.baharum@gmail.com', 'fax', 1, 1, CURRENT_TIMESTAMP );
insert into QA_STDN (ID, INSTRUCTOR_ID)
values (2, 10);
update QA_USER set ACTOR_ID = 2 where ID = 11;

insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (12, 'student2', 0, true, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID)
values (12, 'Ah Wong', 'abc123' , 'rafizan.baharum@gmail.com', null);
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(12, 1, 1, 1, 1, CURRENT_TIMESTAMP );
insert into QA_ACTR (ID, ACTOR_TYPE, ADDRESS1, ADDRESS2, ADDRESS3, AGE, EMAIL, FAX, M_ST, C_ID, C_TS)
values (3, 1, 'Lorong 1 ', 'Taman Midah', 'Cheras', 22, 'rafizan.baharum@gmail.com', 'fax', 1, 1, CURRENT_TIMESTAMP );
insert into QA_STDN (ID, INSTRUCTOR_ID)
values (3, 10);
update QA_USER set ACTOR_ID = 3 where ID = 12;

insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, ENABLED, LOCKED, M_ST, C_ID, C_TS) values (13, 'student3', 0, true, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID)
values (13, 'Muthu', 'abc123', 'rafizan.baharum@gmail.com', null);
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(13, 1, 1, 1, 1, CURRENT_TIMESTAMP );
insert into QA_ACTR (ID, ACTOR_TYPE, ADDRESS1, ADDRESS2, ADDRESS3, AGE, EMAIL, FAX, M_ST, C_ID, C_TS)
values (4, 1, 'Lorong 1 ', 'Taman Midah', 'Cheras', 22, 'rafizan.baharum@gmail.com', 'fax', 1, 1, CURRENT_TIMESTAMP );
insert into QA_STDN (ID, INSTRUCTOR_ID)
values (4, 10);
update QA_USER set ACTOR_ID = 4 where ID = 13;






