package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaGradebookDao {

    QaGradebook findById(Long id);

    List<QaGradebook> find(QaQuiz quiz);

    Integer count(QaQuiz quiz);

    void save(QaGradebook Gradebook, QaUser user);

    void update(QaGradebook Gradebook, QaUser user);

    void deactivate(QaGradebook Gradebook, QaUser user);

    void addItem(QaGradebook Gradebook, QaGradebookItem item, QaUser user);

    void removeItem(QaGradebook Gradebook, QaGradebookItem item, QaUser user);

    void deleteItem(QaGradebook Gradebook, QaGradebookItem item, QaUser user);
}
