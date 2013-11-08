package my.gov.kpn.quiz.core;

import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.core.model.impl.*;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 11/8/13
 */
public class QaQuizTest {


    public void test() {

        QaInstitution institution = new QaInstitutionImpl();
        institution.setCode("ABC");
        institution.setName("Sekolah Kebangsaan Jalan Gurney");

        QaUser admin = new QaUserImpl();
        QaUser instructor = new QaUserImpl();
        QaUser student1 = new QaUserImpl();
        QaUser student2 = new QaUserImpl();
        QaUser student3 = new QaUserImpl();


        QaCompetition competition = new QaCompetitionImpl();
        competition.setLocked(false);
        competition.setYear(2013);

        QaRound round1 = new QaRoundImpl();
        round1.setLocked(false);
        round1.setProcessed(false);
        round1.setCompetition(competition);

        QaQuiz quiz = new QaQuizImpl();
        quiz.setTitle("PRELIMINARY ROUND ASEAN QUIZ 2012 MALAYSIA");
        quiz.setRound(round1);
        quiz.setStartDate(new Date("09:00:00 22/01/2012")); // TODO???
        quiz.setEndDate(new Date("10:00:00 22/01/2012"));

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

        QaBooleanQuestion question3 = new QaBooleanQuestionImpl();
        question3.setDifficulty(QaDifficulty.INTERMEDIATE);
        question3.setWeight(1D);
        question3.setStatement("1. Australia is one of ASEAN’s Dialogue Partners.");
        question3.setAnswerIndex(1);
        question3.setAnswerKey("TRUE");

        QaSubjectiveQuestion question4 = new QaSubjectiveQuestionImpl();
        question4.setDifficulty(QaDifficulty.DIFFICULT);
        question4.setWeight(1D);
        question4.setStatement("1. Describe the security and foreign policies of the Federation of Malaya under Prime Minister Tunku Abdul Rahman");
        question3.setAnswerIndex(1);
        question3.setAnswerKey("TRUE");



    }
}
