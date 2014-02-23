truncate qa_prct cascade ;
drop sequence seq_qa_prct;
create sequence seq_qa_prct start with 1 increment by 1 no maxvalue no minvalue cache 20 no cycle;
drop sequence seq_qa_grbk;
create sequence seq_qa_grbk start with 1 increment by 1 no maxvalue no minvalue cache 20 no cycle;
drop sequence seq_qa_grbi;
create sequence seq_qa_grbi start with 1 increment by 1 no maxvalue no minvalue cache 20 no cycle;
INSERT INTO public.qa_prct(id,c_ts,c_id,m_st,quiz_id,user_id)
    (select nextval('seq_qa_prct'),localtimestamp,0,1,u.id from qa_actr a
inner join qa_stdn s on a.id = s.id
inner join qa_user u on u.actor_id = a.id);
INSERT INTO public.qa_grbk(id,c_ts,c_id,m_st,participant_id,quiz_id)
    (select nextval('seq_qa_grbk'),localtimestamp,0,1,id,1 from qa_prct);
INSERT INTO public.qa_grbi(id,c_ts,c_id,m_st,gradebook_id,question_id)
    (select nextval('seq_qa_grbi'),localtimestamp,0,1,
        g.id,
        q.id
		from qa_qstn q, qa_grbk g
		where q.quiz_id = 1 and q.m_st = 1);