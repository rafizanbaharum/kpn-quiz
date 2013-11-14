package my.gov.kpn.quiz.web.client.event;

import com.extjs.gxt.ui.client.event.BaseEvent;

/**
 * @author rafizan.baharum
 * @since 11/14/13
 */
public class TimerEvent extends BaseEvent {

    private int timeNow;

    public TimerEvent(Object source, int timeNow) {
        super(source);
        this.timeNow = timeNow;
    }
}
