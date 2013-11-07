package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaActorType;
import my.gov.kpn.quiz.core.model.QaStudent;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_STDN")
@Entity(name = "QaStudent")
public class QaStudentImpl extends QaActorImpl implements QaStudent {

    public QaStudentImpl() {
        setActorType(QaActorType.STUDENT);
    }
}
