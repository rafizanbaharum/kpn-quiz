package my.gov.kpn.quiz.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaFlowdata {

    Long getDrafter();

    void setDrafter(Long registerer);

    Date getDraftedDate();

    void setDraftedDate(Date draftedDate);

    Long getRegisterer();

    void setRegisterer(Long registerer);

    Date getRegisteredDate();

    void setRegisteredDate(Date registeredDate);

    Long getVerifier();

    void setVerifier(Long verifier);

    Date getVerifiedDate();

    void setVerifiedDate(Date verifiedDate);

    Long getApprover();

    void setApprover(Long id);

    Date getApprovedDate();

    void setApprovedDate(Date approvedDate);

    QaFlowState getState();

    void setState(QaFlowState state);

}
