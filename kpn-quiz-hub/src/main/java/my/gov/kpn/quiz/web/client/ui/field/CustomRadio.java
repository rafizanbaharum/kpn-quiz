package my.gov.kpn.quiz.web.client.ui.field;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.form.Radio;

import java.util.logging.Logger;

/**
 * @author : alif haikal razak
 */
public class CustomRadio extends Radio {
    private Logger log = Logger.getLogger(CustomRadio.class.getName());

    public CustomRadio() {
        super();
        addListener(Events.Render, new Listener<BaseEvent>() {
            @Override
            public void handleEvent(BaseEvent be) {
                boxLabelEl.addStyleName("x-form-cb-label-custom");
            }
        });
    }
}
