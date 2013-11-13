package my.gov.kpn.quiz.web.common;

//import my.gov.kpn.quiz.core.model.QaQuiz;
import my.gov.kpn.quiz.core.model.QaQuiz;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author rafizan.baharum
 * @since 11/11/13
 */

@Component("commonRegistry")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class GlobalRegistry {

    private static GlobalRegistry INSTANCE = null;

    private QaQuiz quiz = null;

    private static synchronized GlobalRegistry getInstance() {
        if (INSTANCE == null)
            INSTANCE = new GlobalRegistry();

        return INSTANCE;
    }

    public static QaQuiz getQuiz() {
        return getInstance().quiz;
    }

    public static void setQuiz(QaQuiz quiz) {
        getInstance().quiz = quiz;
    }
}
