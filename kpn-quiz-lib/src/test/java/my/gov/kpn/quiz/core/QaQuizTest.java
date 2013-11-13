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


    @Before
    public void setUp() {
        root = userDao.findByUsername("root");
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
        quiz.setCurrent(true);
        roundDao.addQuiz(round1, quiz, root);
    }

    @Test
    @Rollback(value = false)
    public void testCreateQuestions() {
        QaQuiz quiz = quizDao.findCurrent();
        multipleChoiceQuestion(quiz);
        subjectiveQuestion(quiz);
    }

    private void multipleChoiceQuestion(QaQuiz quiz) {
        // easy
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

        QaMultipleChoiceQuestion question3 = new QaMultipleChoiceQuestionImpl();
        question3.setDifficulty(QaDifficulty.EASY);
        question3.setWeight(1D);
        question3.setStatement("Which of the following countries is ASEAN’s biggest passenger automotive market?");
        question3.setChoice1("Indonesia");
        question3.setChoice2("Malaysia");
        question3.setChoice3("Vietnam");
        question3.setChoice4("Cambodia");
        question3.setAnswerKey("A");
        question3.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question3, root);


        QaMultipleChoiceQuestion question4 = new QaMultipleChoiceQuestionImpl();
        question4.setDifficulty(QaDifficulty.EASY);
        question4.setWeight(1D);
        question4.setStatement("What does ZOPFAN stand for?");
        question4.setChoice1("Zone of Prosperity, Freedom and Naturality ");
        question4.setChoice2("Zone of Punctuality, Freedom and Nobility");
        question4.setChoice3("Zone of Peace, Freedom and Neutrality");
        question4.setChoice4("Zone of Prosperity, Free trade and Navigation");
        question4.setAnswerKey("D");
        question4.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question4, root);

        QaMultipleChoiceQuestion question5 = new QaMultipleChoiceQuestionImpl();
        question5.setDifficulty(QaDifficulty.EASY);
        question5.setWeight(1D);
        question5.setStatement("What does the acronym for AMMSWD stand for?");
        question5.setChoice1("ASEAN Ministerial Meeting on Social, Welfare and Development");
        question5.setChoice2("ASEAN Ministerial Meeting on Social, Women and Development.");
        question5.setChoice3("ASEAN Ministerial Meeting on Society, Welfare and Development");
        question5.setChoice4("ASEAN Ministerial Meeting on Society, Women and Developmen");
        question5.setAnswerKey("A");
        question5.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question5, root);

        QaMultipleChoiceQuestion question6 = new QaMultipleChoiceQuestionImpl();
        question6.setDifficulty(QaDifficulty.EASY);
        question6.setWeight(1D);
        question6.setStatement("The Lepa-Lepa (boat) competition is one of the festivals held in ____");
        question6.setChoice1("Malaysia");
        question6.setChoice2("Myanmar");
        question6.setChoice3("Laos");
        question6.setChoice4("Brunei");
        question6.setAnswerKey("A");
        question6.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question6, root);


        QaMultipleChoiceQuestion question7 = new QaMultipleChoiceQuestionImpl();
        question7.setDifficulty(QaDifficulty.EASY);
        question7.setWeight(1D);
        question7.setStatement("Name the current President of the Philippines.");
        question7.setChoice1("Benigno Aquino II");
        question7.setChoice2("Gloria Macapagal Arroyo");
        question7.setChoice3("Corazon Aquino");
        question7.setChoice4("Joseph Estrada");
        question7.setAnswerKey("A");
        question7.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question7, root);


        QaMultipleChoiceQuestion question8 = new QaMultipleChoiceQuestionImpl();
        question8.setDifficulty(QaDifficulty.EASY);
        question8.setWeight(1D);
        question8.setStatement("The type of political system practised by Lao PDR is ______");
        question8.setChoice1("Parliamentary Democracy");
        question8.setChoice2("Presidential");
        question8.setChoice3("Socialist");
        question8.setChoice4("Monarchy");
        question8.setAnswerKey("C");
        question8.setAnswerIndex(3);
        quizDao.addQuestion(quiz, question8, root);


        QaMultipleChoiceQuestion question9 = new QaMultipleChoiceQuestionImpl();
        question9.setDifficulty(QaDifficulty.EASY);
        question9.setWeight(1D);
        question9.setStatement("Which of the following was NO longer part of the Federation of Malaysia after August 1965?");
        question9.setChoice1("Sarawak");
        question9.setChoice2("Sabah");
        question9.setChoice3("Singapore");
        question9.setChoice4("Perlis");
        question9.setAnswerKey("C");
        question9.setAnswerIndex(3);
        quizDao.addQuestion(quiz, question9, root);


        QaMultipleChoiceQuestion question10 = new QaMultipleChoiceQuestionImpl();
        question10.setDifficulty(QaDifficulty.EASY);
        question10.setWeight(1D);
        question10.setStatement("What is the significance of the year 1984 to Brunei?");
        question10.setChoice1("Brunei discovered petroleum");
        question10.setChoice2("Brunei hosted its first SEA Games");
        question10.setChoice3("Brunei gained its independence");
        question10.setChoice4("Brunei introduced its first constitution");
        question10.setAnswerKey("C");
        question10.setAnswerIndex(3);
        quizDao.addQuestion(quiz, question10, root);

        QaMultipleChoiceQuestion question11 = new QaMultipleChoiceQuestionImpl();
        question11.setDifficulty(QaDifficulty.EASY);
        question11.setWeight(1D);
        question11.setStatement("The following are the basic building blocks to achieve a quality living environment based on the thematic areas used for ASEAN Environmentally Sustainable City EXCEPT _______");
        question11.setChoice1("Air");
        question11.setChoice2("Water");
        question11.setChoice3("Land");
        question11.setChoice4("Sound");
        question11.setAnswerKey("D");
        question11.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question11, root);

        QaMultipleChoiceQuestion question12 = new QaMultipleChoiceQuestionImpl();
        question12.setDifficulty(QaDifficulty.EASY);
        question12.setWeight(1D);
        question12.setStatement("Name the ASEAN centre established to provide better services to ASEAN publics and government agencies in the field of seismology");
        question12.setChoice1("ASEAN Earthquake Information Centre");
        question12.setChoice2("ASEAN Specialised Meteorology Centre");
        question12.setChoice3("ASEAN Coordinating Centre for Humanitarian Assistance in Disaster Management.");
        question12.setChoice4("ASEAN Centre for Biodiversity");
        question12.setAnswerKey("A");
        question12.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question12, root);

        QaMultipleChoiceQuestion question13 = new QaMultipleChoiceQuestionImpl();
        question13.setDifficulty(QaDifficulty.EASY);
        question13.setWeight(1D);
        question13.setStatement(" Which one of these festivals is NOT celebrated in any ASEAN Member State?");
        question13.setChoice1("Songkran");
        question13.setChoice2("Dragon Boat Races");
        question13.setChoice3("That Luang Festival");
        question13.setChoice4("La Tomatina");
        question13.setAnswerKey("D");
        question13.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question13, root);


        QaMultipleChoiceQuestion question14 = new QaMultipleChoiceQuestionImpl();
        question14.setDifficulty(QaDifficulty.EASY);
        question14.setWeight(1D);
        question14.setStatement("All the following greetings mean “Welcome” in the different languages of ASEAN EXCEPT _____");
        question14.setChoice1("Mabuhay");
        question14.setChoice2("Mingalaba");
        question14.setChoice3("Kwahaup");
        question14.setChoice4("Sawaddee");
        question14.setAnswerKey("C");
        question14.setAnswerIndex(3);
        quizDao.addQuestion(quiz, question14, root);


        QaMultipleChoiceQuestion question15 = new QaMultipleChoiceQuestionImpl();
        question15.setDifficulty(QaDifficulty.EASY);
        question15.setWeight(1D);
        question15.setStatement("Which country is the Lion Air budget airline based in");
        question15.setChoice1("Thailand");
        question15.setChoice2("Singapore");
        question15.setChoice3("Myanmar");
        question15.setChoice4("Indonesia");
        question15.setAnswerKey("D");
        question15.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question15, root);


        QaMultipleChoiceQuestion question16 = new QaMultipleChoiceQuestionImpl();
        question16.setDifficulty(QaDifficulty.EASY);
        question16.setWeight(1D);
        question16.setStatement("Which country has the largest economy in ASEAN?");
        question16.setChoice1("Indonesia");
        question16.setChoice2("Singapore");
        question16.setChoice3("Thailand");
        question16.setChoice4("Brunei");
        question16.setAnswerKey("D");
        question16.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question16, root);

        QaMultipleChoiceQuestion question17 = new QaMultipleChoiceQuestionImpl();
        question17.setDifficulty(QaDifficulty.EASY);
        question17.setWeight(1D);
        question17.setStatement("Which of the following is ASEAN’s biggest trade partner?");
        question17.setChoice1("India");
        question17.setChoice2("Japan");
        question17.setChoice3("United States");
        question17.setChoice4("China");
        question17.setAnswerKey("D");
        question17.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question17, root);

        QaMultipleChoiceQuestion question18 = new QaMultipleChoiceQuestionImpl();
        question18.setDifficulty(QaDifficulty.EASY);
        question18.setWeight(1D);
        question18.setStatement("The Southeast Asian Nuclear Weapon Free Zone Treaty (SEANWFZ) is also known as the");
        question18.setChoice1("Bangkok Declaration");
        question18.setChoice2("Bangkok Treaty");
        question18.setChoice3("Peace Treaty");
        question18.setChoice4("Bali Concord");
        question18.setAnswerKey("B");
        question18.setAnswerIndex(2);
        quizDao.addQuestion(quiz, question18, root);

        QaMultipleChoiceQuestion question19 = new QaMultipleChoiceQuestionImpl();
        question19.setDifficulty(QaDifficulty.EASY);
        question19.setWeight(1D);
        question19.setStatement("Which category is Malaysia ranked in the Human Development Index (HDI) 2011?");
        question19.setChoice1("Very High Human Development");
        question19.setChoice2("High Human Development");
        question19.setChoice3("Medium Human Development");
        question19.setChoice4("Low Human Development");
        question19.setAnswerKey("B");
        question19.setAnswerIndex(2);
        quizDao.addQuestion(quiz, question19, root);

        QaMultipleChoiceQuestion question20 = new QaMultipleChoiceQuestionImpl();
        question20.setDifficulty(QaDifficulty.EASY);
        question20.setWeight(1D);
        question20.setStatement("The total population of Brunei is approximately ______");
        question20.setChoice1("200,000");
        question20.setChoice2("400,000");
        question20.setChoice3("700,000");
        question20.setChoice4("1 Million");
        question20.setAnswerKey("B");
        question20.setAnswerIndex(2);
        quizDao.addQuestion(quiz, question20, root);

        QaMultipleChoiceQuestion question21 = new QaMultipleChoiceQuestionImpl();
        question21.setDifficulty(QaDifficulty.EASY);
        question21.setWeight(1D);
        question21.setStatement("The second largest city in Indonesia is ______");
        question21.setChoice1("Bandung");
        question21.setChoice2("Medan");
        question21.setChoice3("Surabaya");
        question21.setChoice4("Jogjakarta");
        question21.setAnswerKey("C");
        question21.setAnswerIndex(3);
        quizDao.addQuestion(quiz, question21, root);

        QaMultipleChoiceQuestion question22 = new QaMultipleChoiceQuestionImpl();
        question22.setDifficulty(QaDifficulty.EASY);
        question22.setWeight(1D);
        question22.setStatement(" Burma was renamed as Myanmar in the year _____");
        question22.setChoice1("1979");
        question22.setChoice2("1989");
        question22.setChoice3("1999");
        question22.setChoice4("2009");
        question22.setAnswerKey("B");
        question22.setAnswerIndex(2);
        quizDao.addQuestion(quiz, question22, root);

        QaMultipleChoiceQuestion question23 = new QaMultipleChoiceQuestionImpl();
        question23.setDifficulty(QaDifficulty.EASY);
        question23.setWeight(1D);
        question23.setStatement("The following were Presidents of Indonesia EXCEPT  _____");
        question23.setChoice1("Sukarno");
        question23.setChoice2("BJ Habibie");
        question23.setChoice3("Abdul Rahman Wahid");
        question23.setChoice4("Amien Rais");
        question23.setAnswerKey("D");
        question23.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question23, root);


        QaMultipleChoiceQuestion question24 = new QaMultipleChoiceQuestionImpl();
        question24.setDifficulty(QaDifficulty.EASY);
        question24.setWeight(1D);
        question24.setStatement("U Thant, once Secretary-General of the United Nations, was a citizen of");
        question24.setChoice1("Thailand");
        question24.setChoice2("Cambodia");
        question24.setChoice3("Malaysia");
        question24.setChoice4("Myanmar");
        question24.setAnswerKey("D");
        question24.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question24, root);


        // intermediate
        // difficult
    }

    private void subjectiveQuestion(QaQuiz quiz) {

        QaBooleanQuestion question3 = new QaBooleanQuestionImpl();
        question3.setDifficulty(QaDifficulty.INTERMEDIATE);
        question3.setWeight(1D);
        question3.setStatement("Australia is one of ASEAN’s Dialogue Partners.");
        question3.setAnswerIndex(1);
        question3.setAnswerKey("TRUE");
        quizDao.addQuestion(quiz, question3, root);


        QaSubjectiveQuestion question4 = new QaSubjectiveQuestionImpl();
        question4.setDifficulty(QaDifficulty.DIFFICULT);
        question4.setWeight(1D);
        question4.setStatement("Describe the security and foreign policies of the Federation of Malaya under Prime Minister Tunku Abdul Rahman");
        question4.setAnswerIndex(0);
        question4.setAnswerKey("N/A");
        question4.setAnswerGuide("Answer guideline here");
        quizDao.addQuestion(quiz, question4, root);

    }


    @Test
    @Rollback(value = false)
    public void testFindCurrent() {
        QaQuiz current = quizDao.findCurrent();
        log.debug("current: " + current.getTitle());
    }


}
