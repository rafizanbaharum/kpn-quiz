package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaActorType;
import my.gov.kpn.quiz.core.model.QaSupport;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_SPPT")
@Entity(name = "QaSupport")
public class QaSupportImpl extends QaActorImpl implements QaSupport {

    public QaSupportImpl() {
        setActorType(QaActorType.SUPPORT);
    }
}
