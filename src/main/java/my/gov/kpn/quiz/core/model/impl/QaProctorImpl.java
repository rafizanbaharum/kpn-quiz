package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaActorType;
import my.gov.kpn.quiz.core.model.QaStudent;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "CM_STDN")
@Entity(name = "CmStudent")
public class QaProctorImpl extends QaActorImpl implements QaStudent {

    public QaProctorImpl() {
        setActorType(QaActorType.STUDENT);
    }
}
