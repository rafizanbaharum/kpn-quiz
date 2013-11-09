-- 6367c48dd193d56ea7b0baad25b19455e529f5ee
insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, LOCKED, M_ST, C_ID, C_TS) values (1, 'root', 0, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID)
values (1, 'System Root', 'abc123', 'rafizan.baharum@gmail.com', null);

insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(1, 0, 1, 1, 1, CURRENT_TIMESTAMP );
insert into QA_PCPL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(2, 1, 1, 1, 1, CURRENT_TIMESTAMP );

insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, LOCKED, M_ST, C_ID, C_TS) values (2, 'GROUP_USER', 1, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, LOCKED, M_ST, C_ID, C_TS) values (3, 'GROUP_ADMIN', 1, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, LOCKED, M_ST, C_ID, C_TS) values (4, 'GROUP_INSTRUCTOR', 1, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_PCPL (ID, NAME, PRINCIPAL_TYPE, LOCKED, M_ST, C_ID, C_TS) values (5, 'GROUP_STUDENT', 1, true, 1, 0, CURRENT_TIMESTAMP );
insert into QA_GROP(ID) values (2);
insert into QA_GROP(ID) values (3);
insert into QA_GROP(ID) values (4);
insert into QA_GROP(ID) values (5);

insert into QA_GROP_MMBR (ID, GROUP_ID, MEMBER_ID, M_ST, C_ID, C_TS) values (1, 2, 1, 1, 1, CURRENT_TIMESTAMP);
insert into QA_GROP_MMBR (ID, GROUP_ID, MEMBER_ID, M_ST, C_ID, C_TS) values (2, 3, 1, 1, 1, CURRENT_TIMESTAMP);
insert into QA_GROP_MMBR (ID, GROUP_ID, MEMBER_ID, M_ST, C_ID, C_TS) values (3, 4, 1, 1, 1, CURRENT_TIMESTAMP);
insert into QA_GROP_MMBR (ID, GROUP_ID, MEMBER_ID, M_ST, C_ID, C_TS) values (4, 5, 1, 1, 1, CURRENT_TIMESTAMP);




