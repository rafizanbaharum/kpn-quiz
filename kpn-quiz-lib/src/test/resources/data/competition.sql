DELETE FROM QA_GRBI;
DELETE FROM QA_GRBK;
DELETE FROM QA_PRCT;
DELETE FROM QA_MCQN;
DELETE FROM QA_SVQN;
DELETE FROM QA_BLQN;
DELETE FROM QA_QSTN;
DELETE FROM QA_QUIZ;

DROP TABLE tableQA_GRBI;
DROP TABLE tableQA_GRBK;
DROP TABLE tableQA_PRCT;
DROP TABLE tableQA_MCQN;
DROP TABLE tableQA_SVQN;
DROP TABLE tableQA_BLQN;
DROP TABLE tableQA_QSTN;
DROP TABLE tableQA_QUIZ;
DROP TABLE tableQA_ROND;
DROP TABLE tableQA_CMPN;


INSERT INTO QA_CMPN (ID, YEAR, START_DATE, END_DATE, LOCKED, M_ST, C_ID, C_TS)
VALUES (1, 2013, '1-JAN-2013', '31-DEC-2013', FALSE, 1, 1, CURRENT_TIMESTAMP);

