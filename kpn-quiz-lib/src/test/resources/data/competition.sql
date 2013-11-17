
delete from QA_GRBI;
delete from QA_GRBK;
delete from QA_PRCT;
delete from QA_MCQN;
delete from QA_SVQN;
delete from QA_BLQN;
delete from QA_QSTN;
delete from QA_QUIZ;
delete from QA_ROND;

drop tableQA_GRBI;
drop tableQA_GRBK;
drop tableQA_PRCT;
drop tableQA_MCQN;
drop tableQA_SVQN;
drop tableQA_BLQN;
drop tableQA_QSTN;
drop tableQA_QUIZ;
drop tableQA_ROND;
drop tableQA_CMPN;


INSERT INTO QA_CMPN (ID, YEAR, LOCKED, M_ST, C_ID, C_TS) VALUES (1, 2013, FALSE, 1, 1, '2013-11-09 19:17:35');
