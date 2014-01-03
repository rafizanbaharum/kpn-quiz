package my.gov.kpn.quiz.web.client.event;

import com.extjs.gxt.ui.client.event.BaseEvent;
import my.gov.kpn.quiz.web.client.model.QuestionModel;

/**
 * @author rafizan.baharum
 * @since 11/14/13
 */
public class QuizLoadEvent extends BaseEvent {

    public QuizLoadEvent(Object source) {
        super(source);
    }
}
