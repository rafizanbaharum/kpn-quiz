package my.gov.kpn.quiz.web.client.ui.util;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.form.Field;

/**
 * @author : alif haikal razak
 */
public class Util {

    /* Sets a style attribute for the  text-field control.
    * Workaround for lazy-rendered component */
    public static void setFieldAttr(final Field<?> field, final String cssAttrNm, final String attrVal) {
        safeFunctionCallOn(field, new Function() {
            @Override
            public void execute() {
                field.el().firstChild().setStyleAttribute(cssAttrNm, attrVal);
            }
        });
    }

    /**
     * Safe function call on a component, which was rendered or not.
     *
     * @param c Component object that must be not null.
     * @param f Function object with the function that must be called.
     */
    private static void safeFunctionCallOn(final Component c, final Function f) {
        c.enableEvents(true);
        if (c.isRendered()) {
            f.execute();
        } else {
            final Listener l = new Listener() {
                @Override
                public void handleEvent(BaseEvent be) {
                    f.execute();
                }
            };
            c.addListener(Events.Render, l);
        }
    }

}
