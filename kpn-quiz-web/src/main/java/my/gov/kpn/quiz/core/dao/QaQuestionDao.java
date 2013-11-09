package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaQuestion;
import my.gov.kpn.quiz.core.model.QaUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaQuestionDao {

    QaQuestion findById(Long id);

    List<QaQuestion> find(Integer offset, Integer limit);

    Integer count();

    void save(QaQuestion question, QaUser user);

    void update(QaQuestion question, QaUser user);

    void deactivate(QaQuestion question, QaUser user);
}
