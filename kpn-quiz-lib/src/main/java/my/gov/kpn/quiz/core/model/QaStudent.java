package my.gov.kpn.quiz.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaStudent extends QaActor {

    /**
     * @return
     */
//    QaInstitution getInstitution();

//    void setInstitution(QaInstitution institution);


    void setInstructor(QaInstructor instructor);

    QaInstructor getInstructor();

    Date getDob();

    void setDob(Date dob);
}
