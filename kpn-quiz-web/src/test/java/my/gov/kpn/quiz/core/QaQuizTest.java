package my.gov.kpn.quiz.core;

import my.gov.kpn.quiz.config.Config;
import my.gov.kpn.quiz.core.dao.*;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.*;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/8/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
public class QaQuizTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(QaQuizTest.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private QaUserDao userDao;

    @Autowired
    private QaInstitutionDao institutionDao;

    @Autowired
    private QaCompetitionDao competitionDao;

    @Autowired
    private QaRoundDao roundDao;

    @Autowired
    private QaQuizDao quizDao;

    @Autowired
    private QaQuestionDao questionDao;

    private QaUser root;
    private QaInstitution institution;


    @Before
    public void setUp() {

        root = userDao.findByUsername("root");
        institution = institutionDao.findByCode("0");
    }


    @Test
    @Rollback(value = false)
    public void test() {
        QaCompetition competition = new QaCompetitionImpl();
        competition.setLocked(false);
        competition.setYear(2013);
        competitionDao.save(competition, root);

        QaRound round1 = new QaRoundImpl();
        round1.setLocked(false);
        round1.setProcessed(false);
        round1.setCompetition(competition);
        competitionDao.addRound(competition, round1, root);

        QaQuiz quiz = new QaQuizImpl();
        quiz.setTitle("PRELIMINARY ROUND ASEAN QUIZ 2012 MALAYSIA");
        quiz.setRound(round1);
        quiz.setStartDate(new Date("09:00:00 22/01/2012")); // TODO???
        quiz.setEndDate(new Date("10:00:00 22/01/2012"));
        roundDao.addQuiz(round1, quiz, root);

    }

    @Test
    @Rollback(value = false)
    public void testCreateQuestions() {
        QaCompetition competition = competitionDao.findByYear(2013);
        List<QaRound> rounds = competition.getRounds();
        for (QaRound round : rounds) {
            List<QaQuiz> quizzes = round.getQuizzes();
            for (QaQuiz quiz : quizzes) {
                log.debug("quiz: " + quiz.getTitle());
                QaMultipleChoiceQuestion question1 = new QaMultipleChoiceQuestionImpl();
                question1.setDifficulty(QaDifficulty.EASY);
                question1.setWeight(1D);
                question1.setStatement("Which of the following is NOT a member of ASEAN? ");
                question1.setChoice1("Indonesia");
                question1.setChoice2("Vietnam");
                question1.setChoice3("Myanmar");
                question1.setChoice4("Timor-Leste");
                question1.setAnswerKey("D");
                question1.setAnswerIndex(4);
                log.debug("adding question to quiz");
                quizDao.addQuestion(quiz, question1, root);

                QaMultipleChoiceQuestion question2 = new QaMultipleChoiceQuestionImpl();
                question2.setDifficulty(QaDifficulty.EASY);
                question2.setWeight(1D);
                question2.setStatement("Which of the following is the currency of Lao PDR?");
                question2.setChoice1("Kip");
                question2.setChoice2("Kyat");
                question2.setChoice3("Peso");
                question2.setChoice4("Dong");
                question2.setAnswerKey("A");
                question2.setAnswerIndex(1);
                quizDao.addQuestion(quiz, question2, root);

                QaBooleanQuestion question3 = new QaBooleanQuestionImpl();
                question3.setDifficulty(QaDifficulty.INTERMEDIATE);
                question3.setWeight(1D);
                question3.setStatement("1. Australia is one of ASEAN’s Dialogue Partners.");
                question3.setAnswerIndex(1);
                question3.setAnswerKey("TRUE");
                quizDao.addQuestion(quiz, question3, root);

                QaSubjectiveQuestion question4 = new QaSubjectiveQuestionImpl();
                question4.setDifficulty(QaDifficulty.DIFFICULT);
                question4.setWeight(1D);
                question4.setStatement("1. Describe the security and foreign policies of the Federation of Malaya under Prime Minister Tunku Abdul Rahman");
                question4.setAnswerIndex(0);
                question4.setAnswerKey("N/A");
                question4.setAnswerGuide("Answer guideline here");
                quizDao.addQuestion(quiz, question4, root);

            }
        }

    }

}
