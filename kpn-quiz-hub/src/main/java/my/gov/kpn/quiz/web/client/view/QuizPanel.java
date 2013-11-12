package my.gov.kpn.quiz.web.client.view;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoader;
import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.event.LoadListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.CardPanel;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.Element;
import my.gov.kpn.quiz.web.client.QuizConstants;
import my.gov.kpn.quiz.web.client.QuizDelegateAsync;
import my.gov.kpn.quiz.web.client.model.MultipleChoiceQuestionModel;
import my.gov.kpn.quiz.web.client.model.QuestionModel;
import my.gov.kpn.quiz.web.client.rpc.QuestionRpcProxy;

import java.util.List;
import java.util.logging.Logger;

import static com.extjs.gxt.ui.client.Style.HorizontalAlignment.CENTER;
import static com.extjs.gxt.ui.client.Style.LayoutRegion.SOUTH;

/**
 * @author rafizan.baharum
 * @since 11/11/13
 */
public class QuizPanel extends ContentPanel {

    private static final Logger log = Logger.getLogger(QuizPanel.class.getName());

    private CardPanel cardPanel;
    private QuizDelegateAsync delegate;
    private QuestionRpcProxy proxy;
    private ListLoader<ListLoadResult<QuestionModel>> loader;

    public QuizPanel() {
        super();
        setLayout(new BorderLayout());
    }

    protected void onRender(Element parent, int pos) {
        setupLoader();
        createCardPanel();
        createButtonBar();
        setupListener();
        super.onRender(parent, pos);
    }

    private void setupListener() {
        // TODO
    }

    private void createButtonBar() {
        Button next = new Button("Next");
        ButtonBar buttonBar = new ButtonBar();
        buttonBar.add(next);
        buttonBar.setAlignment(CENTER);

        BorderLayoutData southData = new BorderLayoutData(SOUTH, .05f);
        southData.setMargins(new Margins(5, 0, 10, 0));
        add(buttonBar, southData);
    }

    private void createCardPanel() {
        cardPanel = new CardPanel();
        loader.addLoadListener(new LoadListener() {
            @Override
            public void loaderLoad(LoadEvent le) {
                ListLoadResult<QuestionModel> data = le.<ListLoadResult<QuestionModel>>getData();
                List<QuestionModel> models = data.getData();
                for (QuestionModel model : models) {
                    createQuestionPanel(model);
                }
            }
        });
    }

    private void createQuestionPanel(QuestionModel model) {
        switch (model.getQuestionType()) {
            case MULTIPLE_CHOICE:
                createMultipleChoiceQuestionPanel(model);
                break;
            case BOOLEAN:
                createBooleanQuestionPanel(model);
                break;
            case SUBJECTIVE:
                createSubjectiveQuestionPanel(model);
                break;
        }
    }

    private void createMultipleChoiceQuestionPanel(QuestionModel model) {
        LayoutContainer panel = new LayoutContainer(new BorderLayout());
        TextField statementField = new TextField<String>();
        statementField.setId("statement");
        statementField.setName(QuestionModel.STATEMENT);
        statementField.setFieldLabel("");
        statementField.setLabelSeparator("");

        TextField choice1Field = new TextField<String>();
        choice1Field.setId("choice2");
        choice1Field.setName(MultipleChoiceQuestionModel.CHOICE_1);
        choice1Field.setFieldLabel("");
        choice1Field.setLabelSeparator("");

        TextField choice2Field = new TextField<String>();
        choice2Field.setId("choice2");
        choice2Field.setName(MultipleChoiceQuestionModel.CHOICE_2);
        choice2Field.setFieldLabel("");
        choice2Field.setLabelSeparator("");

        TextField choice3Field = new TextField<String>();
        choice3Field.setId("choice3");
        choice3Field.setName(MultipleChoiceQuestionModel.CHOICE_3);
        choice3Field.setFieldLabel("");
        choice3Field.setLabelSeparator("");

        TextField choice4Field = new TextField<String>();
        choice4Field.setId("choice4");
        choice4Field.setName(MultipleChoiceQuestionModel.CHOICE_4);
        choice4Field.setFieldLabel("");
        choice4Field.setLabelSeparator("");

        panel.add(statementField);
        panel.add(choice1Field);
        panel.add(choice2Field);
        panel.add(choice3Field);
        panel.add(choice4Field);
        cardPanel.add(panel);
    }

    private void createBooleanQuestionPanel(QuestionModel model) {
        LayoutContainer panel = new LayoutContainer(new BorderLayout());
        TextField statementField = new TextField<String>();
        statementField.setId("statement");
        statementField.setName(QuestionModel.STATEMENT);
        statementField.setFieldLabel("");
        statementField.setLabelSeparator("");

        TextField choiceTrueField = new TextField<String>();
        choiceTrueField.setId("choiceTrue");
        choiceTrueField.setName("choiceTrue");
        choiceTrueField.setFieldLabel("");
        choiceTrueField.setLabelSeparator("");
        choiceTrueField.setValue("TRUE");

        TextField choiceFalseField = new TextField<String>();
        choiceFalseField.setId("choiceFalse");
        choiceFalseField.setName("choiceFalse");
        choiceFalseField.setFieldLabel("");
        choiceFalseField.setLabelSeparator("");
        choiceFalseField.setValue("FALSE");

        panel.add(statementField);
        panel.add(choiceTrueField);
        panel.add(choiceFalseField);
        cardPanel.add(panel);
    }

    private void createSubjectiveQuestionPanel(QuestionModel model) {
        LayoutContainer panel = new LayoutContainer(new BorderLayout());
        TextField statementField = new TextField<String>();
        statementField.setId("statement");
        statementField.setName(QuestionModel.STATEMENT);
        statementField.setFieldLabel("");
        statementField.setLabelSeparator("");

        TextArea area = new TextArea();
        area.setId("answer");
        area.setName("answer");
        area.setFieldLabel("");
        area.setLabelSeparator("");

        panel.add(statementField);
        cardPanel.add(panel);
    }

    private void setupLoader() {
        delegate = Registry.get(QuizConstants.DELEGATE_QUIZ);
        proxy = new QuestionRpcProxy(delegate);
        loader = new BaseListLoader<ListLoadResult<QuestionModel>>(proxy);
    }
}
