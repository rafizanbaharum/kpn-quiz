package my.gov.kpn.quiz.web.filter;

import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.web.server.GlobalRegistry;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class QuizCountdownFilter implements Filter {

    private static final Logger log = Logger.getLogger(QuizCountdownFilter.class);

    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;

            QaQuiz quiz = GlobalRegistry.getQuiz();
            if (new Date().before(quiz.getStartDate())) {
                request.getSession().setAttribute("startDate", quiz.getStartDate().getTime() / 1000);
                request.getSession().setAttribute("endDate", quiz.getEndDate().getTime() / 1000);
                response.sendRedirect("/countdown.jsp");
            } else {
                response.sendRedirect("/index.jsp");
            }
        } catch (Exception e) {
            log.error(e);
        }
        chain.doFilter(req, res);
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}