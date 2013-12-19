package my.gov.kpn.quiz.web.client.ui.field;

import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import my.gov.kpn.quiz.web.client.model.QuestionModel;

import static com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction.ALL;

public class QuestionListComboBox extends ComboBox<QuestionModel> {

    private ListStore<QuestionModel> questionStore;

    public QuestionListComboBox() {

        questionStore = new ListStore<QuestionModel>();
        setStore(questionStore);
        setTemplate(getComboBoxTemplate());
        setDisplayField(QuestionModel.STR_INDEX);
        setTriggerAction(ALL);
        setSelectOnFocus(true);

    }

    public ListStore<QuestionModel> getQuestionStore() {
        return questionStore;
    }

    public void setQuestionStore(ListStore<QuestionModel> questionStore) {
        this.questionStore = questionStore;
    }

    private native String getComboBoxTemplate() /*-{
        return  [
        '<tpl for=".">',
        '<div class="x-combo-list-item"  style="color: {values.color};">{[values.index]}</div>',
        '</tpl>'
        ].join("");
        }-*/;

}
