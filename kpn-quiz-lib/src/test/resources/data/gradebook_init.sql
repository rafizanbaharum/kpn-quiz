-- reset table
TRUNCATE qa_prct cascade ;
drop sequence seq_qa_prct;
create sequence seq_qa_prct start with 1 increment by 1 no maxvalue no minvalue cache 20 no cycle;
drop sequence seq_qa_grbk;
create sequence seq_qa_grbk start with 1 increment by 1 no maxvalue no minvalue cache 20 no cycle;
drop sequence seq_qa_grbi;
create sequence seq_qa_grbi start with 1 increment by 1 no maxvalue no minvalue cache 20 no cycle;
INSERT INTO public.qa_prct(id,c_ts,c_id,m_st,quiz_id,user_id)
  (SELECT
     nextval('seq_qa_prct'),
     localtimestamp,
     0,
     1,
     14,
     u.id
   FROM qa_actr a
     INNER join qa_stdn s on a.id = s.id
inner join qa_user u on u.actor_id = a.id);
INSERT INTO public.qa_grbk(id,c_ts,c_id,m_st,participant_id,quiz_id)
  (SELECT
     nextval('seq_qa_grbk'),
     localtimestamp,
     0,
     1,
     id,
     14
   FROM qa_prct);
INSERT INTO public.qa_grbi(id,c_ts,c_id,m_st,gradebook_id,question_id)
    (select nextval('seq_qa_grbi'),localtimestamp,0,1,
        g.id,
        q.id
		from qa_qstn q, qa_grbk g
    WHERE q.quiz_id = 14 AND q.m_st = 1);

-- update status
UPDATE qa_tmp_ans
SET student_id = (SELECT
                    student_id
                  FROM student_info
                  WHERE student_nric = nric);
UPDATE qa_tmp_ans
SET participant_id = (SELECT
                        id
                      FROM qa_prct p, student_info s
                      WHERE p.user_id = s.user_id AND nric = student_nric);

-- update answer
UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer01)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 204;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer02)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 205;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer03)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 206;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer04)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 207;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer05)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 208;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer06)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 209;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer07)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 210;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer08)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 211;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer09)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 212;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer10)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 213;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer11)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 214;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer12)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 215;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer13)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 216;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer14)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 217;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer15)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 218;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer16)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 219;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer17)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 220;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer18)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 221;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer19)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 222;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer20)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 223;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer21)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 224;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer22)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 225;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer23)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 226;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer24)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 227;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer25)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 228;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer26)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 229;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer27)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 230;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer28)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 231;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer29)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 232;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer30)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 233;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer31)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 234;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer32)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 235;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer33)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 236;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer34)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 237;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer35)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 238;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer36)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 239;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer37)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 240;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer38)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 241;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer39)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 242;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer40)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 243;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer41)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 244;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer42)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 245;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer43)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 246;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer44)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 246;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer45)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 248;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer46)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 249;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer47)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 250;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer48)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 251;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer49)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 252;

UPDATE qa_grbi i
SET answer_index = (
  SELECT DISTINCT
    getAnswerIndex(answer50)
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 253;


UPDATE qa_grbi i
SET answer_response = (
  SELECT DISTINCT
    answer51
  FROM qa_tmp_ans t, qa_grbk b
  WHERE i.gradebook_id = b.id AND b.participant_id = t.participant_id
)
WHERE question_id = 254;

-- report
SELECT
  student_name,
  student_nric,
  state_name,
  school_name,
  result,
  answer_response
FROM qa_prct p
  INNER JOIN student_info s ON p.user_id = s.principal_id
ORDER BY state_name, result DESC;

--
DELETE FROM qa_grbk
WHERE id NOT IN (SELECT
                   gradebook_id
                 FROM qa_grbi);
DELETE FROM qa_prct
WHERE id NOT IN (SELECT
                   participant_id
                 FROM qa_grbk);
