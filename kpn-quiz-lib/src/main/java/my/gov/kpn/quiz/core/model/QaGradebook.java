package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/8/13
 */
public interface QaGradebook {

    /**
     * @return
     */
    QaQuiz getQuiz();

    void setQuiz(QaQuiz quiz);

    /**
     * @return
     */
    QaParticipant getParticipant();

    void setParticipant(QaParticipant participant);

}
