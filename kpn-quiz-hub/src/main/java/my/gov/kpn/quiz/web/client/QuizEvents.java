package my.gov.kpn.quiz.web.client;

import com.extjs.gxt.ui.client.event.EventType;

public class QuizEvents {

    public static final EventType InitApp = new EventType();
    public static final EventType InitQuiz = new EventType();
    public static final EventType ApplicationLogout = new EventType();
    public static final EventType ApplicationTimeout = new EventType();
    public static final EventType QuestionNext = new EventType();
    public static final EventType QuestionPrev = new EventType();
    public static final EventType TimerStart = new EventType();
    public static final EventType TimerUpdate = new EventType();
    public static final EventType TimerEnd = new EventType();

}
