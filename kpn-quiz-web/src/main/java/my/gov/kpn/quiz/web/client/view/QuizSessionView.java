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
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.Element;
import my.gov.kpn.quiz.web.client.QuizConstants;
import my.gov.kpn.quiz.web.client.QuizDelegateAsync;
import my.gov.kpn.quiz.web.client.model.QuestionModel;
import my.gov.kpn.quiz.web.client.rpc.QuestionRpcProxy;

import java.util.List;

import static com.extjs.gxt.ui.client.Style.HorizontalAlignment.CENTER;
import static com.extjs.gxt.ui.client.Style.LayoutRegion.SOUTH;

/**
 * @author rafizan.baharum
 * @since 11/11/13
 */
public class QuizSessionView extends ContentPanel {

    private CardPanel cardPanel;
    private QuizDelegateAsync delegate;
    private QuestionRpcProxy proxy;
    private ListLoader<ListLoadResult<QuestionModel>> loader;

    public QuizSessionView() {
        super();
    }

    protected void onRender(Element parent, int pos) {
        setupLoader();
        createCardPanel();
        createButtonBar();
        setupListener();
        super.onRender(parent, pos);
    }

    private void setupListener() {
        //To change body of created methods use File | Settings | File Templates.
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
        LayoutContainer question = new LayoutContainer(new BorderLayout());
        TextField positionField = new TextField<String>();
        positionField.setId("statement");
        positionField.setName(QuestionModel.STATEMENT);
        positionField.setFieldLabel("");
    }

    private void setupLoader() {
        delegate = Registry.get(QuizConstants.DELEGATE_QUIZ);
        proxy = new QuestionRpcProxy(delegate);
        loader = new BaseListLoader<ListLoadResult<QuestionModel>>(proxy);
    }

}
