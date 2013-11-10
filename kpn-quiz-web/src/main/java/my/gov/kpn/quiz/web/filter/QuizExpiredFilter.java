package my.gov.kpn.quiz.web.filter;

import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.web.server.QuizDelegateImpl;
import org.joda.time.DateTime;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuizExpiredFilter extends GenericFilterBean {

    static final String FILTER_APPLIED = "__quiz_expired_session_filter_applied";

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if (request.getAttribute(FILTER_APPLIED) != null) {
            chain.doFilter(request, response);
            return;
        }

        request.setAttribute(FILTER_APPLIED, Boolean.TRUE);
        // get in session
        QaQuiz quiz = (QaQuiz) request.getSession().getAttribute(QuizDelegateImpl.CURRENT_QUIZ);
        DateTime now = DateTime.now();
        DateTime end = new DateTime(quiz.getEndDate());

        if(null!= quiz && now.compareTo(end) > 1) // TODO: double check

        if (request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid()) {
            response.sendError(HttpServletResponse.SC_GONE, "QUIZ_TIMED_OUT");
            return;
        }

        chain.doFilter(request, response);
    }
}
