package my.gov.kpn.quiz.core;

import my.gov.kpn.quiz.config.Config;
import my.gov.kpn.quiz.core.dao.QaCompetitionDao;
import my.gov.kpn.quiz.core.dao.QaQuizDao;
import my.gov.kpn.quiz.core.dao.QaUserDao;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.QaBooleanQuestionImpl;
import my.gov.kpn.quiz.core.model.impl.QaMultipleChoiceQuestionImpl;
import my.gov.kpn.quiz.core.model.impl.QaQuizImpl;
import my.gov.kpn.quiz.core.model.impl.QaSubjectiveQuestionImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Faizal Abdul Manan on 3/26/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
public class QaSemiFinalLoader extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private QaUserDao userDao;

    @Autowired
    private QaCompetitionDao competitionDao;

    @Autowired
    private QaQuizDao quizDao;

    private QaUser root;

    private enum MultipleChoiceAnswerType {
        D,
        C,
        B,
        A
    }

    private enum BooleanChoiceAnswerType {
        FALSE,
        TRUE,
    }

    @Before
    public void setUp() {
        root = userDao.findById(0L);
    }

    @Test
    @Rollback(value = false)
    public void createSemiFinalQuiz() {

        QaCompetition competition = competitionDao.findById(1L);

        QaQuiz quiz1 = new QaQuizImpl();
        quiz1.setTitle("SEPARUH AKHIR 8 APRIL");
        quiz1.setRound(8);
        quiz1.setCompetition(competition);
        quiz1.setStartDate(new Date("09:00:00 08/04/2014"));
        quiz1.setEndDate(new Date("10:00:00 08/04/2014"));
        quiz1.setCurrent(true);
        quiz1.setProcessed(false);
        quiz1.setLocked(false);
        competitionDao.addQuiz(competition, quiz1, root);
    }


    @Test
    @Rollback(value = false)
    public void testCreateQuestions() {
        QaQuiz quiz = quizDao.findCurrent();
        multipleChoiceQuestion(quiz);
        booleanQuestion(quiz);
        subjectiveQuestion(quiz);
    }

    private void subjectiveQuestion(QaQuiz quiz) {
        QaSubjectiveQuestion question4 = new QaSubjectiveQuestionImpl();
        question4.setDifficulty(QaDifficulty.EASY);
        question4.setStatement("Propose a slogan for ASEAN ECONOMIC COMMUNITY 2015 and explain it in less than 30 words");
        question4.setAnswerIndex(0);
        question4.setWordLimit(30);
        question4.setAnswerGuide("Less than 30 words");
        quizDao.addQuestion(quiz, question4, root);
    }


    private void booleanQuestion(QaQuiz quiz) {
        String[] questions = getBoolQuestion();

        String q = "";
        String ans = "";
        int index = 1;
        for (String question : questions) {
            if (index == 1) q = question;
            if (index == 2) {
                ans = question;
                QaBooleanQuestion question41 = new QaBooleanQuestionImpl();
                question41.setDifficulty(QaDifficulty.EASY);
                question41.setStatement(q);
                question41.setAnswerIndex(ans.equals("F") ? 0 : 1);
                quizDao.addQuestion(quiz, question41, root);
                index = 0;
            }
            index = index + 1;
        }


    }

    private void multipleChoiceQuestion(QaQuiz quiz) {

        String[] questions = getMultiQuestion();

        String q = "";
        String ans1 = "";
        String ans2 = "";
        String ans3 = "";
        String ans4 = "";
        String ans = "";
        int index = 1;
        for (String question : questions) {
            if (index == 1) q = question;
            if (index == 2) ans1 = question;
            if (index == 3) ans2 = question;
            if (index == 4) ans3 = question;
            if (index == 5) ans4 = question;
            if (index == 6) {
                ans = question;

                QaMultipleChoiceQuestion question40 = new QaMultipleChoiceQuestionImpl();
                question40.setDifficulty(QaDifficulty.EASY);
                question40.setStatement(q);
                question40.setChoice1(ans1);
                question40.setChoice2(ans2);
                question40.setChoice3(ans3);
                question40.setChoice4(ans4);
                question40.setAnswerIndex(MultipleChoiceAnswerType.valueOf(ans).ordinal());
                quizDao.addQuestion(quiz, question40, root);
                index = 0;
            }
            index = index + 1;
        }

    }


    private String[] getBoolQuestion() {
        String[] questions = {"Malaysia does not export petroleum.",
                "F",
                "The legislative power in Malaysia is divided between federal and state legislatures.",
                "T",
                "Kolok or Golok is the name of a town in Thailand and a river in Malaysia.",
                "T",
                "Megawati Soekarnoputri was the President of Indonesia before B.J. Habibie.",
                "F",
                "It was during the presidency of Fidel Ramos that the Philippines joined ASEAN.",
                "F",
                "Yusuf Ishak was the first President of Singapore. ",
                "T",
                "The ASEAN Ministerial Meeting on Transnational Crime (AMMTC) adopted the ASEAN Plan of Action to Combat Transnational Crime during its second meeting in 1999 in Yangon.",
                "T",
                "The route for the Ship for Southeast Asian Youth Programme (SSEAYP) includes South Korea.",
                "F",
                "The Chairmanship of ASEAN rotates annually based on the alphabetical order of the English names of Member States.",
                "T",
                "The present Secretary-General of ASEAN is Surin Pitsuwan.",
                "F"};

        return questions;
    }

    private String[] getMultiQuestion() {
        String[] question = {"What does SEANWFZ stand for?",
                "Southeast Asian National Weapon Free Zone",
                "Southeast Asian Nations Weapon Free Zone",
                "Southeast Asian Nuclear Weapon Free Zone",
                "Southeast Asian Nuclear Weapon and Freedom Zone",
                "C",
                "What does ASEAN’s TAC stand for?",
                "Treaty of Amity and Cooperation ",
                "Treaty of Amity and Coordination ",
                "Totally Amity and Coordinated ",
                "Treaty of Action Campaign ",
                "A",
                "Which Document confers ASEAN as a legal personality? ",
                "Declaration of ASEAN Concord\t",
                "Declaration of ASEAN Concord II",
                "Vientiane Action Program ",
                "ASEAN Charter ",
                "D",
                "The ASEAN Political Security Community Blueprint emphasises that ASEAN upholds the following ASEAN political instruments EXCEPT:",
                "the Declaration on Zone of Peace, Freedom and Neutrality (ZOPFAN)",
                "the Declaration of ASEAN Concord II ",
                "the Treaty on the Southeast Asian Nuclear Weapon-Free Zone (SEANWFZ)",
                "the Collective Security Treaty in South East Asia (CST)",
                "D",
                "The ASEAN Charter requires the ASEAN Human Rights Body (AICHR) to operate in accordance with the terms of reference determined by __________.",
                "The ASEAN Foreign Ministers Meeting",
                "The ASEAN Summit",
                "The ASEAN Defence Ministers Meeting",
                "The ASEAN Human Rights Ministers Meeting",
                "A",
                "The color blue in the ASEAN Flag represents ____________.",
                "Prosperity",
                "Purity ",
                "Courage and dynamism",
                "Peace and stability",
                "D",
                "The ASEAN Troika comprises of:",
                "the Foreign Ministers of the present, past and future chairs of the ASEAN  Political-Security Community",
                "the Defence Ministers of the present, past and future chairs of the ASEAN Political-Security Community",
                "the Foreign, Defence and Law Ministers of the present, past and future chairs of the ASEAN Political-Security Community",
                "the Head of Governments of the present, past and future chairs of the ASEAN Political-Security Community",
                "A",
                "Which of the two ASEAN countries are members of the Five Power Defence     Agreement of 1971?",
                "Indonesia and the Philippines",
                "Vietnam and Lao PDR",
                "Thailand and Indonesia",
                "Malaysia and Singapore",
                "D",
                "As at January 2013, ASEAN has signed Free Trade Agreement (FTA) with the following countries EXCEPT _____________. ",
                "South Africa",
                "Japan",
                "India ",
                "China",
                "A",
                "Which country below is NOT a dialogue partner of ASEAN?",
                "Australia",
                "Korea",
                "New Zealand",
                "Pakistan",
                "D",
                "Which trading partner has yet to sign a Free Trade Agreement (FTA) with ASEAN?",
                "India",
                "Australia",
                "Korea ",
                "European Union",
                "D",
                "Which of the following is NOT an ASEAN Agreement under the economic pillar?",
                "ASEAN Framework Agreement in Services",
                "ASEAN Trade in Goods Agreement",
                "ASEAN Comprehensive Investment Agreement",
                "Agreement on the Establishment of the ASEAN Cultural Fund",
                "D",
                "ASEAN Framework Agreement on Services was signed in?",
                "1993",
                "1994",
                "1995 ",
                "1996",
                "C",
                "Which of the following pairs are mismatched? ",
                "Philippines - Riel",
                "Myanmar– Kyat ",
                "Thailand - Baht",
                "Viet Nam – Dong",
                "A",
                "In which ASEAN Summit was the Framework Agreement on Enhancing ASEAN Economic Cooperation signed?",
                "1992 Summit, Singapore",
                "2005 Summit, Kuala Lumpur",
                "1998 Summit, Ha Noi",
                "2011 Summit, Bali  ",
                "A",
                "Which of the following agreements replaces the ASEAN Trade in Goods Agreement (ATIGA) signed in 2009?",
                "ASEAN Framework Agreement in Services",
                "ASEAN Comprehensive Investment Agreement",
                "Agreement on The Common Effective Preferential Tariff Scheme for the ASEAN Free Trade Area",
                "ASEAN Agreement on Movement of Natural Persons",
                "C",
                "What is Rules of Origin under the ASEAN Trade in Goods Agreement?",
                "Preferential tariff concessions under ASEAN Free Trade Agreement (AFTA)",
                "Most Favored Nation rates",
                "Exemption from compliance to Standards",
                "National Treatment",
                "A",
                "ASEAN Heads of State or Government adopted the Vision 2020 ASEAN Plan of Action on Science and Technology which is also known as Ha Noi Plan of Action. When was it adopted? ",
                "1968",
                "1978",
                "1988",
                "1998",
                "D",
                "The current Science & Technology cooperation in ASEAN focuses on nine programme areas. Which of the following is not one of them?",
                "Food Science and Technology ",
                "Marine Science and Technology ",
                "Non-Conventional Energy Research ",
                "Nuclear Weapons and Non-Proliferation",
                "D",
                "The Mekong River passes through _________ countries of Southeast Asia.  ",
                "two",
                "three",
                "four ",
                "five",
                "D",
                "When was the ASEAN Centre for Biodiversity (ACB) launched?  ",
                "September 2003",
                "September 2004",
                "September 2005",
                "September 2006",
                "C",
                "It was during the ________ in 2010 that ASEAN Leaders’ signed a Statement on Joint Response to Climate Change.",
                "17th ASEAN Summit ",
                "16th ASEAN Summit ",
                "15th ASEAN Summit",
                "14th ASEAN Summit",
                "B",
                "The 5th ASEAN Tourism Investment Forum (ATIF) 2012 was held in  __________.",
                "Malaysia ",
                "Myanmar",
                "Indonesia ",
                "Thailand",
                "C",
                "The longest river in Southeast Asia is the Mekong. It runs at around ______ kilometers. ",
                "2000 ",
                "3000 ",
                "4000 ",
                "5000 ",
                "C",
                "The highest mountain in Southeast Asia is _____. ",
                "Mount Kinabalu (Malaysia)",
                "Mount Hkakabo Razi (Myanmar)",
                "Mount Puncak Jaya (Indonesia)",
                "Mount Fansipan (Vietnam)",
                "B",
                "The largest freshwater lake in Southeast Asia is the _____.",
                "Tonle Sap (Cambodia)",
                "Lake Toba (Indonesia)",
                "Songkhla Lake (Thailand)",
                "Laguna de Bay (Philippines)",
                "A",
                "Southeast Asia’s largest airport is the ________.  ",
                "Kuala Lumpur International Airport (KLIA) (Malaysia)",
                "Changi (Singapore)",
                "Suvarnabhumi (Thailand)",
                "Soekarno-Hatta (Indonesia)",
                "C",
                "Which Southeast Asian country has the largest army?",
                "Viet Nam",
                "The Philippines",
                "Myanmar",
                "Indonesia",
                "A",
                "The oldest university in Southeast Asia is ________.",
                "Chulalongkorn University (Thailand)",
                "University of Santo Tomas (the Philippines)",
                "Rangoon University (Myanmar)",
                "Vietnam National University",
                "B",
                "The Southeast Asia Writers Award or SEA Write Award has been presented annually to prominent poets and writers of the region since _____.",
                "1949",
                "1959",
                "1969",
                "1979",
                "D",
                "Myanmar is officially divided into _____ states and divisions. ",
                "14",
                "15",
                "16",
                "17",
                "A",
                "The first Spanish settlement in the Philippines was in ____. ",
                "Manila",
                "Cagayan de Oro",
                "Pasig",
                "Cebu ",
                "D",
                "The earliest metal work in Southeast Asia was reportedly found in ____. ",
                "Indonesia",
                "Thailand",
                "Malaysia",
                "Viet Nam",
                "D",
                "Southeast Asia’s largest bank in terms of assets and operations is _____. ",
                "Bank Rakyat Indonesia",
                "Maybank ",
                "Vietnam Bank for Rural and Agricultural Development",
                "Development Bank of Singapore (DBS)",
                "D",
                "What does FELDA stand for? ",
                "Federal Land Development Authority",
                "Federal Language Development Agency",
                "Federal Land Development Administration",
                "Federal Land Development Agency",
                "A",
                "Which are not agencies under the Malaysian Ministry of International Trade and Industry?",
                "MIDA",
                "LHDN",
                "SME Corp",
                "MATRADE",
                "B",
                "The 2013 ASEAN Defense Ministers Meeting was held in _______.",
                "Brunei Darussalam ",
                "Singapore",
                "Malaysia",
                "Indonesia",
                "A",
                "The tallest completed dam in Southeast Asia is the ________. ",
                "Bakun Dam (Malaysia)",
                "San Roque Dam (the Philippines)",
                "Bhumibol Dam (Thailand)",
                "Son Lo Dam (Vietnam)",
                "B",
                "What is the policy making body in ASEAN that formulates measures to combat transnational crime?",
                "The Annual Conference of ASEAN Chiefs of Police (ASEANAPOL)",
                "ASEAN Ministerial Meeting on Transnational Crime",
                "The ASEAN Secretariat",
                "ASEAN Directors-General of Customs ",
                "B",
                "Which country initiated the ASEAN Youth Volunteer Programme (AYVP)?",
                "Thailand",
                "Myanmar",
                "Singapore",
                "Malaysia",
                "D"};

        return question;
    }
}
