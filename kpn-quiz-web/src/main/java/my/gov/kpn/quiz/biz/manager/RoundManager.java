package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.core.model.QaRound;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface RoundManager {

    void processRound(QaRound round);

    QaRound findRoundById(Long id);
}

