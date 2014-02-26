package my.gov.kpn.quiz.web.filter;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.web.common.AutoInjectingFilterListener;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

@Component("quizCountdownFilter")
public class QuizCountdownFilter extends AutoInjectingFilterListener {

    @Autowired
    private CompetitionManager competitionManager;

    private static final Logger log = Logger.getLogger(QuizCountdownFilter.class);

    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;

            QaQuiz quiz = competitionManager.getCurrentQuiz();
            log.debug("Quiz start = " + DateFormat.getInstance().format(quiz.getStartDate()) +
                    " / Quiz end = " + DateFormat.getInstance().format(quiz.getEndDate()));
            if (new Date().before(quiz.getStartDate())) {
                request.getSession().setAttribute("startDate", quiz.getStartDate().getTime() / 1000);
                request.getSession().setAttribute("endDate", quiz.getEndDate().getTime() / 1000);
                request.getSession().setAttribute("now", new Date().getTime() / 1000);
                request.getRequestDispatcher("countdown.jsp").forward(request, response);
            } else if (new Date().after(quiz.getEndDate())) {
                log.debug("Quiz has ended!");
                request.getRequestDispatcher("close.jsp").forward(request, response);
            }

        } catch (Exception e) {
            log.error(e);
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}