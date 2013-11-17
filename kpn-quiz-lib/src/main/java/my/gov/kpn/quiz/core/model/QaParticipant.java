package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaParticipant extends QaMetaObject {

    /**
     * @return
     */
    QaQuiz getQuiz();

    void setQuiz(QaQuiz quiz);

    /**
     * @return
     */
    QaUser getUser();

    void setUser(QaUser user);

    /**
     * @return
     */
    Integer getResult();

    void setResult(Integer result);

}
