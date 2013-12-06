package my.gov.kpn.quiz.biz.integration.springsecurity;

import javax.naming.AuthenticationException;

/**
 * @author rafizan.baharum
 * @since 12/6/13
 */
public class QaInvalidParticipantException extends AuthenticationException{
    public QaInvalidParticipantException(String explanation) {
        super(explanation);
    }
}
