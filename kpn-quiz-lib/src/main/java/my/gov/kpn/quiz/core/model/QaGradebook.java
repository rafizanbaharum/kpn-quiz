package my.gov.kpn.quiz.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/8/13
 */
public interface QaGradebook extends QaMetaObject {

    /**
     * @return
     */
    QaQuiz getQuiz();

    void setQuiz(QaQuiz quiz);

    /**
     * @return
     */
    QaRound getRound();

    void setRound(QaRound round);

    /**
     * @return
     */
    QaParticipant getParticipant();

    void setParticipant(QaParticipant participant);

    /**
     * @return
     */
    List<QaGradebookItem> getItems();

    void setItems(List<QaGradebookItem> items);

}
