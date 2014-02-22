package my.gov.kpn.quiz.web.server;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.core.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author rafizan.baharum
 * @since 1/15/14
 */
public class QuestionServlet extends HttpServlet {

    public static final String BR = "<br/>";
    @Autowired
    private CompetitionManager competitionManager;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(config.getServletContext());
        AutowireCapableBeanFactory beanFactory = ctx.getAutowireCapableBeanFactory();
        beanFactory.autowireBean(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QaQuiz quiz = GlobalRegistry.getQuiz();
        String idStr = req.getParameter("id");
        QaQuestion question = competitionManager.findQuestionById(Long.valueOf(idStr));
        PrintWriter writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<body>");
        writer.write("<p>");
        writer.write("Q:" + question.getStatement());
        writer.write("</p>");
        switch (question.getQuestionType()) {
            case MULTIPLE_CHOICE:
                QaMultipleChoiceQuestion mcq = (QaMultipleChoiceQuestion) question;
                writer.write("<ol>");
                writer.write("<li>" + mcq.getChoice1() + "</li>");
                writer.write("<li>" + mcq.getChoice2() + "</li>");
                writer.write("<li>" + mcq.getChoice3() + "</li>");
                writer.write("<li>" + mcq.getChoice4() + "</li>");
                writer.write("</ol>");
                break;
            case BOOLEAN:
                QaBooleanQuestion bq = (QaBooleanQuestion) question;
                writer.write("<ol>");
                writer.write("<li>" + "TRUE" + "</li>");
                writer.write("<li>" + "FALSE" + "</li>");
                writer.write("</ol>");
                break;
            case SUBJECTIVE:
                QaSubjectiveQuestion sq = (QaSubjectiveQuestion) question;
                writer.write("limit: " + sq.getWordLimit());
                break;
        }
        writer.write("</body>");
        writer.write("</html>");
        writer.close();
        writer.flush();
    }
}