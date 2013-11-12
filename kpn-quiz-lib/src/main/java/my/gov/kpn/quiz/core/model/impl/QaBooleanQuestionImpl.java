package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaBooleanQuestion;
import my.gov.kpn.quiz.core.model.QaQuestionType;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
@Table(name = "QA_BLQN")
@Entity(name = "QaBooleanQuestion")
public class QaBooleanQuestionImpl extends QaQuestionImpl implements QaBooleanQuestion {

    public QaBooleanQuestionImpl() {
        setQuestionType(QaQuestionType.BOOLEAN);
    }
}
