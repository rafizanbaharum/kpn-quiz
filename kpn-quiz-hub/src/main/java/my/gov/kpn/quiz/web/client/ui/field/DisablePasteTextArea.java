package my.gov.kpn.quiz.web.client.ui.field;

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.google.gwt.user.client.Event;

/**
 * @author : alif haikal razak
 */
// todo : rename if necessary
public class DisablePasteTextArea extends TextArea {

    public DisablePasteTextArea() {
        super();
        sinkEvents(Event.ONPASTE);
    }

    @Override
    public void onBrowserEvent(Event event) {
        super.onBrowserEvent(event);
        switch (event.getTypeInt()) {
            case Event.ONPASTE: {
                MessageBox.alert("", "Paste not allowed here", null);
                event.stopPropagation();
                event.preventDefault();
                break;
            }
        }
    }
}
