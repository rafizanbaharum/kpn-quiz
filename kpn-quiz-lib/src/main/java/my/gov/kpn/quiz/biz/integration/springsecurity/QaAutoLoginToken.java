package my.gov.kpn.quiz.biz.integration.springsecurity;

import my.gov.kpn.quiz.core.model.QaPrincipal;
import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * @author rafizan.baharum
 * @since 10/3/13
 */
public class QaAutoLoginToken extends AbstractAuthenticationToken {

    private final QaPrincipal principal;
    private Object credentials;

    public QaAutoLoginToken(QaPrincipal principal) {
        super(null);
        this.principal = principal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal.getName();
    }
}
