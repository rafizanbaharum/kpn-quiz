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
    private QaCompetitionDao competitionDao;

    @Autowired
    private QaQuizDao quizDao;

    @Autowired
    private QaQuestionDao questionDao;

    private QaUser root;


    @Before
    public void setUp() {
        root = userDao.findByUsername("administrator");
    }


    @Test
    @Rollback(value = false)
    public void createCompetitionAndQuiz() {
        QaCompetition competition = new QaCompetitionImpl();
        competition.setLocked(false);
        competition.setYear(2013);
        competition.setStartDate(new Date()); // TODO Scenario?
        competition.setEndDate(new Date());
        competitionDao.save(competition, root);

        QaQuiz quiz1 = new QaQuizImpl();
        quiz1.setTitle("PRELIMINARY ROUND ASEAN QUIZ 2012 MALAYSIA");
        quiz1.setRound(1);
        quiz1.setCompetition(competition);
        quiz1.setStartDate(new Date("09:00:00 22/01/2012"));
        quiz1.setEndDate(new Date("10:00:00 22/01/2012"));
        quiz1.setCurrent(true);
        quiz1.setProcessed(false);
        quiz1.setLocked(false);
        competitionDao.addQuiz(competition, quiz1, root);

        QaQuiz quiz2 = new QaQuizImpl();
        quiz2.setTitle("SECOND ROUND ASEAN QUIZ 2012 MALAYSIA");
        quiz2.setRound(2);
        quiz2.setCompetition(competition);
        quiz2.setStartDate(new Date("09:00:00 22/01/2012"));
        quiz2.setEndDate(new Date("10:00:00 22/01/2012"));
        quiz2.setCurrent(false);
        quiz2.setProcessed(false);
        quiz2.setLocked(false);
        competitionDao.addQuiz(competition, quiz2, root);
    }

    @Test
    @Rollback(value = false)
    public void testCreateQuestions() {
        QaQuiz quiz = quizDao.findCurrent();
        multipleChoiceQuestion(quiz);
        booleanQuestion(quiz);
        subjectiveQuestion(quiz);
    }

    private void multipleChoiceQuestion(QaQuiz quiz) {
        // easy
        QaMultipleChoiceQuestion question1 = new QaMultipleChoiceQuestionImpl();
        question1.setDifficulty(QaDifficulty.EASY);
        question1.setStatement("Which of the following is NOT a member of ASEAN? ");
        question1.setChoice1("Indonesia");
        question1.setChoice2("Vietnam");
        question1.setChoice3("Myanmar");
        question1.setChoice4("Timor-Leste");
        question1.setAnswerIndex(4);
        log.debug("adding question to quiz");
        quizDao.addQuestion(quiz, question1, root);

        QaMultipleChoiceQuestion question2 = new QaMultipleChoiceQuestionImpl();
        question2.setDifficulty(QaDifficulty.EASY);
        question2.setStatement("Which of the following is the currency of Lao PDR?");
        question2.setChoice1("Kip");
        question2.setChoice2("Kyat");
        question2.setChoice3("Peso");
        question2.setChoice4("Dong");
        question2.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question2, root);

        QaMultipleChoiceQuestion question3 = new QaMultipleChoiceQuestionImpl();
        question3.setDifficulty(QaDifficulty.EASY);
        question3.setStatement("Which of the following countries is ASEAN’s biggest passenger automotive market?");
        question3.setChoice1("Indonesia");
        question3.setChoice2("Malaysia");
        question3.setChoice3("Vietnam");
        question3.setChoice4("Cambodia");
        question3.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question3, root);


        QaMultipleChoiceQuestion question4 = new QaMultipleChoiceQuestionImpl();
        question4.setDifficulty(QaDifficulty.EASY);
        question4.setStatement("What does ZOPFAN stand for?");
        question4.setChoice1("Zone of Prosperity, Freedom and Naturality ");
        question4.setChoice2("Zone of Punctuality, Freedom and Nobility");
        question4.setChoice3("Zone of Peace, Freedom and Neutrality");
        question4.setChoice4("Zone of Prosperity, Free trade and Navigation");
        question4.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question4, root);

        QaMultipleChoiceQuestion question5 = new QaMultipleChoiceQuestionImpl();
        question5.setDifficulty(QaDifficulty.EASY);
        question5.setStatement("What does the acronym for AMMSWD stand for?");
        question5.setChoice1("ASEAN Ministerial Meeting on Social, Welfare and Development");
        question5.setChoice2("ASEAN Ministerial Meeting on Social, Women and Development.");
        question5.setChoice3("ASEAN Ministerial Meeting on Society, Welfare and Development");
        question5.setChoice4("ASEAN Ministerial Meeting on Society, Women and Developmen");
        question5.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question5, root);

        QaMultipleChoiceQuestion question6 = new QaMultipleChoiceQuestionImpl();
        question6.setDifficulty(QaDifficulty.EASY);
        question6.setStatement("The Lepa-Lepa (boat) competition is one of the festivals held in ____");
        question6.setChoice1("Malaysia");
        question6.setChoice2("Myanmar");
        question6.setChoice3("Laos");
        question6.setChoice4("Brunei");
        question6.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question6, root);


        QaMultipleChoiceQuestion question7 = new QaMultipleChoiceQuestionImpl();
        question7.setDifficulty(QaDifficulty.EASY);
        question7.setStatement("Name the current President of the Philippines.");
        question7.setChoice1("Benigno Aquino II");
        question7.setChoice2("Gloria Macapagal Arroyo");
        question7.setChoice3("Corazon Aquino");
        question7.setChoice4("Joseph Estrada");
        question7.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question7, root);


        QaMultipleChoiceQuestion question8 = new QaMultipleChoiceQuestionImpl();
        question8.setDifficulty(QaDifficulty.EASY);
        question8.setStatement("The type of political system practised by Lao PDR is ______");
        question8.setChoice1("Parliamentary Democracy");
        question8.setChoice2("Presidential");
        question8.setChoice3("Socialist");
        question8.setChoice4("Monarchy");
        question8.setAnswerIndex(3);
        quizDao.addQuestion(quiz, question8, root);


        QaMultipleChoiceQuestion question9 = new QaMultipleChoiceQuestionImpl();
        question9.setDifficulty(QaDifficulty.EASY);
        question9.setStatement("Which of the following was NO longer part of the Federation of Malaysia after August 1965?");
        question9.setChoice1("Sarawak");
        question9.setChoice2("Sabah");
        question9.setChoice3("Singapore");
        question9.setChoice4("Perlis");
        question9.setAnswerIndex(3);
        quizDao.addQuestion(quiz, question9, root);


        QaMultipleChoiceQuestion question10 = new QaMultipleChoiceQuestionImpl();
        question10.setDifficulty(QaDifficulty.EASY);
        question10.setStatement("What is the significance of the year 1984 to Brunei?");
        question10.setChoice1("Brunei discovered petroleum");
        question10.setChoice2("Brunei hosted its first SEA Games");
        question10.setChoice3("Brunei gained its independence");
        question10.setChoice4("Brunei introduced its first constitution");
        question10.setAnswerIndex(3);
        quizDao.addQuestion(quiz, question10, root);

        QaMultipleChoiceQuestion question11 = new QaMultipleChoiceQuestionImpl();
        question11.setDifficulty(QaDifficulty.EASY);
        question11.setStatement("The following are the basic building blocks to achieve a quality living environment based on the thematic areas used for ASEAN Environmentally Sustainable City EXCEPT _______");
        question11.setChoice1("Air");
        question11.setChoice2("Water");
        question11.setChoice3("Land");
        question11.setChoice4("Sound");
        question11.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question11, root);

        QaMultipleChoiceQuestion question12 = new QaMultipleChoiceQuestionImpl();
        question12.setDifficulty(QaDifficulty.EASY);
        question12.setStatement("Name the ASEAN centre established to provide better services to ASEAN publics and government agencies in the field of seismology");
        question12.setChoice1("ASEAN Earthquake Information Centre");
        question12.setChoice2("ASEAN Specialised Meteorology Centre");
        question12.setChoice3("ASEAN Coordinating Centre for Humanitarian Assistance in Disaster Management.");
        question12.setChoice4("ASEAN Centre for Biodiversity");
        question12.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question12, root);

        QaMultipleChoiceQuestion question13 = new QaMultipleChoiceQuestionImpl();
        question13.setDifficulty(QaDifficulty.EASY);
        question13.setStatement(" Which one of these festivals is NOT celebrated in any ASEAN Member State?");
        question13.setChoice1("Songkran");
        question13.setChoice2("Dragon Boat Races");
        question13.setChoice3("That Luang Festival");
        question13.setChoice4("La Tomatina");
        question13.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question13, root);


        QaMultipleChoiceQuestion question14 = new QaMultipleChoiceQuestionImpl();
        question14.setDifficulty(QaDifficulty.EASY);
        question14.setStatement("All the following greetings mean “Welcome” in the different languages of ASEAN EXCEPT _____");
        question14.setChoice1("Mabuhay");
        question14.setChoice2("Mingalaba");
        question14.setChoice3("Kwahaup");
        question14.setChoice4("Sawaddee");
        question14.setAnswerIndex(3);
        quizDao.addQuestion(quiz, question14, root);


        QaMultipleChoiceQuestion question15 = new QaMultipleChoiceQuestionImpl();
        question15.setDifficulty(QaDifficulty.EASY);
        question15.setStatement("Which country is the Lion Air budget airline based in");
        question15.setChoice1("Thailand");
        question15.setChoice2("Singapore");
        question15.setChoice3("Myanmar");
        question15.setChoice4("Indonesia");
        question15.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question15, root);


        QaMultipleChoiceQuestion question16 = new QaMultipleChoiceQuestionImpl();
        question16.setDifficulty(QaDifficulty.EASY);
        question16.setStatement("Which country has the largest economy in ASEAN?");
        question16.setChoice1("Indonesia");
        question16.setChoice2("Singapore");
        question16.setChoice3("Thailand");
        question16.setChoice4("Brunei");
        question16.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question16, root);

        QaMultipleChoiceQuestion question17 = new QaMultipleChoiceQuestionImpl();
        question17.setDifficulty(QaDifficulty.EASY);
        question17.setStatement("Which of the following is ASEAN’s biggest trade partner?");
        question17.setChoice1("India");
        question17.setChoice2("Japan");
        question17.setChoice3("United States");
        question17.setChoice4("China");
        question17.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question17, root);

        QaMultipleChoiceQuestion question18 = new QaMultipleChoiceQuestionImpl();
        question18.setDifficulty(QaDifficulty.EASY);
        question18.setStatement("The Southeast Asian Nuclear Weapon Free Zone Treaty (SEANWFZ) is also known as the");
        question18.setChoice1("Bangkok Declaration");
        question18.setChoice2("Bangkok Treaty");
        question18.setChoice3("Peace Treaty");
        question18.setChoice4("Bali Concord");
        question18.setAnswerIndex(2);
        quizDao.addQuestion(quiz, question18, root);

        QaMultipleChoiceQuestion question19 = new QaMultipleChoiceQuestionImpl();
        question19.setDifficulty(QaDifficulty.EASY);
        question19.setStatement("Which category is Malaysia ranked in the Human Development Index (HDI) 2011?");
        question19.setChoice1("Very High Human Development");
        question19.setChoice2("High Human Development");
        question19.setChoice3("Medium Human Development");
        question19.setChoice4("Low Human Development");
        question19.setAnswerIndex(2);
        quizDao.addQuestion(quiz, question19, root);

        QaMultipleChoiceQuestion question20 = new QaMultipleChoiceQuestionImpl();
        question20.setDifficulty(QaDifficulty.EASY);
        question20.setStatement("The total population of Brunei is approximately ______");
        question20.setChoice1("200,000");
        question20.setChoice2("400,000");
        question20.setChoice3("700,000");
        question20.setChoice4("1 Million");
        question20.setAnswerIndex(2);
        quizDao.addQuestion(quiz, question20, root);

        QaMultipleChoiceQuestion question21 = new QaMultipleChoiceQuestionImpl();
        question21.setDifficulty(QaDifficulty.EASY);
        question21.setStatement("The second largest city in Indonesia is ______");
        question21.setChoice1("Bandung");
        question21.setChoice2("Medan");
        question21.setChoice3("Surabaya");
        question21.setChoice4("Jogjakarta");
        question21.setAnswerIndex(3);
        quizDao.addQuestion(quiz, question21, root);

        QaMultipleChoiceQuestion question22 = new QaMultipleChoiceQuestionImpl();
        question22.setDifficulty(QaDifficulty.EASY);
        question22.setStatement(" Burma was renamed as Myanmar in the year _____");
        question22.setChoice1("1979");
        question22.setChoice2("1989");
        question22.setChoice3("1999");
        question22.setChoice4("2009");
        question22.setAnswerIndex(2);
        quizDao.addQuestion(quiz, question22, root);

        QaMultipleChoiceQuestion question23 = new QaMultipleChoiceQuestionImpl();
        question23.setDifficulty(QaDifficulty.EASY);
        question23.setStatement("The following were Presidents of Indonesia EXCEPT  _____");
        question23.setChoice1("Sukarno");
        question23.setChoice2("BJ Habibie");
        question23.setChoice3("Abdul Rahman Wahid");
        question23.setChoice4("Amien Rais");
        question23.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question23, root);

        QaMultipleChoiceQuestion question24 = new QaMultipleChoiceQuestionImpl();
        question24.setDifficulty(QaDifficulty.EASY);
        question24.setStatement("U Thant, once Secretary-General of the United Nations, was a citizen of");
        question24.setChoice1("Thailand");
        question24.setChoice2("Cambodia");
        question24.setChoice3("Malaysia");
        question24.setChoice4("Myanmar");
        question24.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question24, root);


        // intermediate
        QaMultipleChoiceQuestion question25 = new QaMultipleChoiceQuestionImpl();
        question25.setDifficulty(QaDifficulty.INTERMEDIATE);
        question25.setStatement("The treaty that defined the boundaries between British Malaya and Dutch East Indies in 1824 was known a");
        question25.setChoice1("Thailand");
        question25.setChoice2("Cambodia");
        question25.setChoice3("Malaysia");
        question25.setChoice4("Myanmar");
        question25.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question25, root);

        QaMultipleChoiceQuestion question26 = new QaMultipleChoiceQuestionImpl();
        question26.setDifficulty(QaDifficulty.INTERMEDIATE);
        question26.setStatement("The Majapahit Kingdom in 13th century expanded to become an empire under the premiership of");
        question26.setChoice1("Thailand");
        question26.setChoice2("Cambodia");
        question26.setChoice3("Malaysia");
        question26.setChoice4("Myanmar");
        question26.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question26, root);

        QaMultipleChoiceQuestion question27 = new QaMultipleChoiceQuestionImpl();
        question27.setDifficulty(QaDifficulty.INTERMEDIATE);
        question27.setStatement("Which political party won a landslide victory in Singapore in 1959?");
        question27.setChoice1("Thailand");
        question27.setChoice2("Cambodia");
        question27.setChoice3("Malaysia");
        question27.setChoice4("Myanmar");
        question27.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question27, root);

        QaMultipleChoiceQuestion question28 = new QaMultipleChoiceQuestionImpl();
        question28.setDifficulty(QaDifficulty.INTERMEDIATE);
        question28.setStatement("In 1998, the ASEAN Heads of Government adopted an action plan to implement ASEAN Vision 2020. What was the name of the plan?");
        question28.setChoice1("Thailand");
        question28.setChoice2("Cambodia");
        question28.setChoice3("Malaysia");
        question28.setChoice4("Myanmar");
        question28.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question28, root);

        QaMultipleChoiceQuestion question29 = new QaMultipleChoiceQuestionImpl();
        question29.setDifficulty(QaDifficulty.INTERMEDIATE);
        question29.setStatement("The treaty that defined the boundaries between British Malaya and Dutch East Indies in 1824 was known a");
        question29.setChoice1("Thailand");
        question29.setChoice2("Cambodia");
        question29.setChoice3("Malaysia");
        question29.setChoice4("Myanmar");
        question29.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question29, root);

        QaMultipleChoiceQuestion question30 = new QaMultipleChoiceQuestionImpl();
        question30.setDifficulty(QaDifficulty.INTERMEDIATE);
        question30.setStatement("The following are national heritage sites and reserves as stated in the ASEAN Heritage Parks and Reserves Declaration 1984 EXCEPT ____");
        question30.setChoice1("Thailand");
        question30.setChoice2("Cambodia");
        question30.setChoice3("Malaysia");
        question30.setChoice4("Myanmar");
        question30.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question30, root);

        QaMultipleChoiceQuestion question31 = new QaMultipleChoiceQuestionImpl();
        question31.setDifficulty(QaDifficulty.INTERMEDIATE);
        question31.setStatement("The most recognisable feature of this mosque is the dome covered in pure gold.  What is the name of the mosque?");
        question31.setChoice1("Thailand");
        question31.setChoice2("Cambodia");
        question31.setChoice3("Malaysia");
        question31.setChoice4("Myanmar");
        question31.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question31, root);

        // difficult
        QaMultipleChoiceQuestion question32 = new QaMultipleChoiceQuestionImpl();
        question32.setDifficulty(QaDifficulty.DIFFICULT);
        question32.setStatement("Which one of these islands is not a part of Southeast Asia?");
        question32.setChoice1("Thailand");
        question32.setChoice2("Cambodia");
        question32.setChoice3("Malaysia");
        question32.setChoice4("Myanmar");
        question32.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question32, root);

        QaMultipleChoiceQuestion question33 = new QaMultipleChoiceQuestionImpl();
        question33.setDifficulty(QaDifficulty.DIFFICULT);
        question33.setStatement("Who scored at the final football match between Malaysia and Indonesia during the 26th Southeast Asian (SEA) Games in Jakarta?");
        question33.setChoice1("Thailand");
        question33.setChoice2("Cambodia");
        question33.setChoice3("Malaysia");
        question33.setChoice4("Myanmar");
        question33.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question33, root);

        QaMultipleChoiceQuestion question34 = new QaMultipleChoiceQuestionImpl();
        question34.setDifficulty(QaDifficulty.DIFFICULT);
        question34.setStatement("Which of the following is NOT a signatory of the Five Power Defence Arrangements (FPDA)?");
        question34.setChoice1("Thailand");
        question34.setChoice2("Cambodia");
        question34.setChoice3("Malaysia");
        question34.setChoice4("Myanmar");
        question34.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question34, root);

        QaMultipleChoiceQuestion question35 = new QaMultipleChoiceQuestionImpl();
        question35.setDifficulty(QaDifficulty.DIFFICULT);
        question35.setStatement("Which of the following is the longest-reigning monarch in Southeast Asia?");
        question35.setChoice1("Thailand");
        question35.setChoice2("Cambodia");
        question35.setChoice3("Malaysia");
        question35.setChoice4("Myanmar");
        question35.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question35, root);

        QaMultipleChoiceQuestion question36 = new QaMultipleChoiceQuestionImpl();
        question36.setDifficulty(QaDifficulty.DIFFICULT);
        question36.setStatement("Which ASEAN country was ranked as having the highest Human Development Index (HDI) in 2011? ");
        question36.setChoice1("Thailand");
        question36.setChoice2("Cambodia");
        question36.setChoice3("Malaysia");
        question36.setChoice4("Myanmar");
        question36.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question36, root);

        QaMultipleChoiceQuestion question37 = new QaMultipleChoiceQuestionImpl();
        question37.setDifficulty(QaDifficulty.DIFFICULT);
        question37.setStatement("Which one of these islands is not a part of Southeast Asia?");
        question37.setChoice1("Thailand");
        question37.setChoice2("Cambodia");
        question37.setChoice3("Malaysia");
        question37.setChoice4("Myanmar");
        question37.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question37, root);

        QaMultipleChoiceQuestion question38 = new QaMultipleChoiceQuestionImpl();
        question38.setDifficulty(QaDifficulty.DIFFICULT);
        question38.setStatement("The ASEAN Environmentally Sustainable City Award was first presented in 2008 to 10 cities/ townships/ districts as a motivation to share best practices and achieve high standards of environmental sustainability. Listed below are the winners of the award for 2011 EXCEPT ____");
        question38.setChoice1("Thailand");
        question38.setChoice2("Cambodia");
        question38.setChoice3("Malaysia");
        question38.setChoice4("Myanmar");
        question38.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question38, root);

        QaMultipleChoiceQuestion question39 = new QaMultipleChoiceQuestionImpl();
        question39.setDifficulty(QaDifficulty.DIFFICULT);
        question39.setStatement("Symphony Orchestra of Young Musicians is one of the cultural events to celebrate the 15th Anniversary of the Dialogue Partnership in 2011.  Name the Dialogue Partner.");
        question39.setChoice1("Thailand");
        question39.setChoice2("Cambodia");
        question39.setChoice3("Malaysia");
        question39.setChoice4("Myanmar");
        question39.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question39, root);

        QaMultipleChoiceQuestion question40 = new QaMultipleChoiceQuestionImpl();
        question40.setDifficulty(QaDifficulty.DIFFICULT);
        question40.setStatement("The Immediate Action Plans (IAPs) for Prevention and Control of Land and Forest Fires and Haze are designed to help local government units and the communities in developing comprehensive action plans for forest fire management. The first phase of the IAPs has been developed with funding support from the UNEP and the Government of Indonesia. Name the two areas involved in this programme.");
        question40.setChoice1("Thailand");
        question40.setChoice2("Cambodia");
        question40.setChoice3("Malaysia");
        question40.setChoice4("Myanmar");
        question40.setAnswerIndex(4);
        quizDao.addQuestion(quiz, question40, root);

    }

    private void booleanQuestion(QaQuiz quiz) {
        QaBooleanQuestion question41 = new QaBooleanQuestionImpl();
        question41.setDifficulty(QaDifficulty.INTERMEDIATE);
        question41.setStatement("Australia is one of ASEAN’s Dialogue Partners.");
        question41.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question41, root);

        QaBooleanQuestion question42 = new QaBooleanQuestionImpl();
        question42.setDifficulty(QaDifficulty.DIFFICULT);
        question42.setStatement("Chinese Muslims in Myanmar are called ‘Pantay’");
        question42.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question42, root);

        QaBooleanQuestion question43 = new QaBooleanQuestionImpl();
        question43.setDifficulty(QaDifficulty.DIFFICULT);
        question43.setStatement("India is ASEAN’s largest export market.");
        question43.setAnswerIndex(0);
        quizDao.addQuestion(quiz, question43, root);

        QaBooleanQuestion question44 = new QaBooleanQuestionImpl();
        question44.setDifficulty(QaDifficulty.EASY);
        question44.setStatement("The Mulu National Park is located in the Philippines.");
        question44.setAnswerIndex(0);
        quizDao.addQuestion(quiz, question44, root);

        QaBooleanQuestion question45 = new QaBooleanQuestionImpl();
        question45.setDifficulty(QaDifficulty.EASY);
        question45.setStatement("One of the principles of ASEAN Charter is upholding international law with respect to human rights & social justice.");
        question45.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question45, root);

        QaBooleanQuestion question46 = new QaBooleanQuestionImpl();
        question46.setDifficulty(QaDifficulty.EASY);
        question46.setStatement("Lorentz National Park is one of the ASEAN heritage parks located in Myanmar.");
        question46.setAnswerIndex(0);
        quizDao.addQuestion(quiz, question46, root);

        QaBooleanQuestion question47 = new QaBooleanQuestionImpl();
        question47.setDifficulty(QaDifficulty.EASY);
        question47.setStatement("There are only three aspects under the ASEAN Socio-Cultural Community pillar.");
        question47.setAnswerIndex(0);
        quizDao.addQuestion(quiz, question47, root);

        QaBooleanQuestion question48 = new QaBooleanQuestionImpl();
        question48.setDifficulty(QaDifficulty.EASY);
        question48.setStatement("The Presidential Democracy political system is practiced in Thailand.");
        question48.setAnswerIndex(0);
        quizDao.addQuestion(quiz, question48, root);

        QaBooleanQuestion question49 = new QaBooleanQuestionImpl();
        question49.setDifficulty(QaDifficulty.DIFFICULT);
        question49.setStatement("The official tourism slogan for Laos is “Simply Beautiful”");
        question49.setAnswerIndex(1);
        quizDao.addQuestion(quiz, question49, root);
    }

    private void subjectiveQuestion(QaQuiz quiz) {
        QaSubjectiveQuestion question4 = new QaSubjectiveQuestionImpl();
        question4.setDifficulty(QaDifficulty.DIFFICULT);
        question4.setStatement("Describe the security and foreign policies of the Federation of Malaya under Prime Minister Tunku Abdul Rahman");
        question4.setAnswerIndex(0);
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
