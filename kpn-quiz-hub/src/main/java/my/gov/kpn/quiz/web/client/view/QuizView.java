package my.gov.kpn.quiz.web.client.view;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.data.*;
import com.extjs.gxt.ui.client.event.*;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.CardPanel;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.*;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import my.gov.kpn.quiz.web.client.QuizConstants;
import my.gov.kpn.quiz.web.client.QuizDelegateAsync;
import my.gov.kpn.quiz.web.client.QuizEvents;
import my.gov.kpn.quiz.web.client.event.QuizNavigateEvent;
import my.gov.kpn.quiz.web.client.event.TimerEvent;
import my.gov.kpn.quiz.web.client.model.BooleanQuestionModel;
import my.gov.kpn.quiz.web.client.model.MultipleChoiceQuestionModel;
import my.gov.kpn.quiz.web.client.model.QuestionModel;
import my.gov.kpn.quiz.web.client.model.SubjectiveQuestionModel;
import my.gov.kpn.quiz.web.client.rpc.QuestionRpcProxy;

import java.util.List;
import java.util.logging.Logger;

import static com.extjs.gxt.ui.client.Style.HorizontalAlignment.CENTER;

/**
 * Event sequence:
 * <p/>
 * AppInit
 * QuizInit
 * QuizInited
 *
 * @author : alif haikal razak
 */
public class QuizView extends View {

    private static final Logger log = Logger.getLogger(QuizView.class.getName());
    private static final int ONE_HOUR = 60 * 60 * 1000;
    private static final int ONE_SECOND = 1000;
    private static NumberFormat formatter = NumberFormat.getFormat("00");

    private QuizDelegateAsync delegate;
    private QuestionRpcProxy proxy;
    private ListLoader<ListLoadResult<QuestionModel>> loader;
    private List<QuestionModel> models;

    private LayoutContainer main;
    private LayoutContainer header;
    private LayoutContainer footer;
    private CardPanel cardPanel;
    private Html timer;
    private Html counter;
    private Html level;
    private Html status;

    private Timer t;
    private int now = 60 * 60 * 1000;
    private int currentStep = 0;
    private int questionIndex = 0; // zero-based index!

    public QuizView(Controller controller) {
        super(controller);
    }

    protected void initialize() {
        delegate = Registry.get(QuizConstants.DELEGATE_QUIZ);
        proxy = new QuestionRpcProxy(delegate);
        loader = new BaseListLoader<ListLoadResult<QuestionModel>>(proxy);
    }

    @Override
    protected void handleEvent(AppEvent appEvent) {
        if (appEvent.getType() == QuizEvents.AppInit) {
            log.info("application init");
            onInitApplication();
        } else if (appEvent.getType() == QuizEvents.QuizInit) {
            log.info("quiz init");
            onInitQuiz();
        } else if (appEvent.getType() == QuizEvents.QuizInited) {
            log.info("quiz inited");
        }
    }

    private void onInitApplication() {
        final Dispatcher dispatcher = Dispatcher.get();
        Viewport viewport = new Viewport();
        viewport.setId("quiz-app-viewport");
        viewport.setLayout(new BorderLayout());
        createHeader(viewport);
        createMain(viewport);
        createFooter(viewport);
        RootPanel.get().add(viewport);
        dispatcher.dispatch(QuizEvents.QuizInit);
    }


    private void onInitQuiz() {
        final Dispatcher dispatcher = Dispatcher.get();
        initListener();
        initTimer();
        loader.load(new BaseListLoadConfig());
    }

    private void initListener() {
        log.info("init listener");
        loader.addListener(Loader.Load, new Listener<LoadEvent>() {
            @Override
            public void handleEvent(LoadEvent be) {
                log.info("handleEvent.Loaded");
                ListLoadResult<QuestionModel> data = be.getData();
                models = data.getData();
                for (QuestionModel model : models) {
                    ++questionIndex;
                    createQuestionPanel(questionIndex, model);
                }
                cardPanel.layout();
                cardPanel.fireEvent(QuizEvents.QuizNavigate, new QuizNavigateEvent(this, 0, -1));
            }
        });

        timer.addListener(QuizEvents.TimerUpdate, new Listener<TimerEvent>() {
            @Override
            public void handleEvent(TimerEvent be) {
                now -= ONE_SECOND;
                updateTimer();
            }
        });

        cardPanel.addListener(QuizEvents.QuizNavigate, new Listener<QuizNavigateEvent>() {
            @Override
            public void handleEvent(QuizNavigateEvent be) {
                if (be.getPreviousQuestionIndex() == -1) { // first time load
                    updateCounter(1);
                    QuestionModel nextQuestion = getQuestion(be.getNextQuestionIndex());
                    if (null != nextQuestion) loadAnswerIndex(nextQuestion);
                } else { // subsequent load
                    updateCounter(be.getNextQuestionIndex());
                    QuestionModel prevQuestion = getQuestion(be.getPreviousQuestionIndex());
                    QuestionModel nextQuestion = getQuestion(be.getNextQuestionIndex());
                    switch (prevQuestion.getQuestionType()) {
                        case MULTIPLE_CHOICE:
                            updateAnswer(prevQuestion, 0); // TODO
                            loadAnswerIndex(nextQuestion);
                            break;
                        case BOOLEAN:
                            updateAnswer(prevQuestion, 0); // TODO
                            loadAnswerIndex(nextQuestion);
                            break;
                        case SUBJECTIVE:
                            updateAnswer(prevQuestion, "TODO"); // TODO
                            loadAnswerResponse(nextQuestion);
                            break;
                    }
                }
            }
        });
    }

    private void initTimer() {
        log.info("init timer");
        t = new Timer() {
            public void run() {
                t.schedule(ONE_SECOND);
                timer.fireEvent(QuizEvents.TimerUpdate, new TimerEvent(this, now - ONE_SECOND));
            }
        };
        t.schedule(ONE_SECOND);
    }

    private void updateCounter(int nextQuestionIndex) {
        counter.setHtml(nextQuestionIndex + "/" + cardPanel.getItemCount());
    }

    private void updateStatus(String stat) {
        status.setHtml(stat);
    }

    private void updateTimer() {
        timer.setHtml(formattedNow());
    }

    // subjective
    private void updateAnswer(QuestionModel questionModel, String answerKey) {
        delegate.updateAnswer(questionModel, answerKey, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                // TODO:
            }

            @Override
            public void onSuccess(Void result) {
                // TODO:
            }
        });
    }

    // multiplechoice + boolean
    private void updateAnswer(QuestionModel questionModel, Integer answerKey) {
        delegate.updateAnswer(questionModel, answerKey, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                // TODO:
            }

            @Override
            public void onSuccess(Void result) {
                // TODO:
            }
        });
    }

    private void loadAnswerIndex(QuestionModel questionModel) {
        delegate.loadAnswerIndex(questionModel, new AsyncCallback<Integer>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(Integer result) {
                if (null != result)
                    updateStatus("Answered");
                else
                    updateStatus("Unanswered");
            }
        });
    }

    private void loadAnswerResponse(QuestionModel questionModel) {
        delegate.loadAnswerIndex(questionModel, new AsyncCallback<Integer>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(Integer result) {
                if (null != result)
                    updateStatus("Answered");
                else
                    updateStatus("Unanswered");
            }
        });
    }


    // header
    private void createHeader(Viewport view) {
        header = new LayoutContainer();
        header.setId("quiz-app-header");
        header.setLayout(new FlowLayout());
        BorderLayoutData northData = new BorderLayoutData(Style.LayoutRegion.NORTH, 0.16f);
        northData.setMargins(new Margins(0, 0, 0, 0));
        view.add(header, northData);
        createToolBar();
    }

    // main
    private void createMain(Viewport view) {
        main = new LayoutContainer();
        main.setId("quiz-app-main");
        main.setLayout(new FitLayout());
        BorderLayoutData centerData = new BorderLayoutData(Style.LayoutRegion.CENTER, 0.70f);
        centerData.setMargins(new Margins(0, 0, 0, 0));
        view.add(main, centerData);
        createCardPanel();
    }

    // footer
    private void createFooter(Viewport view) {
        footer = new LayoutContainer();
        footer.setId("quiz-app-footer");
        footer.setLayout(new FitLayout());
        BorderLayoutData westData = new BorderLayoutData(Style.LayoutRegion.SOUTH, 0.14f);
        westData.setMargins(new Margins(0, 0, 0, 0));
        view.add(footer, westData);
        createButtonBar();
    }


    private void createToolBar() {
        timer = new Html();
        timer.setId("quiz-clock");
        timer.setHtml("Initializing...");
        counter = new Html();
        counter.setId("quiz-counter");
        counter.setHtml("Initializing...");
        level = new Html();
        level.setId("quiz-level");
        level.setHtml("Initializing...");
        status = new Html();
        status.setId("quiz-status");
        status.setHtml("Initializing...");
        LayoutContainer panel = new LayoutContainer();
        panel.setLayout(new HBoxLayout());
        panel.add(timer, new HBoxLayoutData(0, 0, 0, 20));
        panel.add(counter, new HBoxLayoutData(0, 0, 0, 20));
        panel.add(status, new HBoxLayoutData(0, 0, 0, 20));
        header.add(panel, new MarginData(30, 0, 0, 0));
    }

    private void createButtonBar() {
        Button next = new Button("Next");
        next.addStyleName("quiz-nav-button");
        next.setScale(Style.ButtonScale.LARGE);
        next.setMinWidth(100);
        next.addSelectionListener(new NextSelectionListener());
        Button prev = new Button("Prev");
        prev.addStyleName("quiz-nav-button");
        prev.setScale(Style.ButtonScale.LARGE);
        prev.setMinWidth(100);
        prev.addSelectionListener(new PreviousSelectionListener());

        ButtonBar buttonBar = new ButtonBar();
        buttonBar.add(prev);
        buttonBar.add(next);
        buttonBar.setAlignment(CENTER);
        footer.add(buttonBar, new MarginData(20, 0, 0, 0));
    }


    private void createCardPanel() {
        cardPanel = new CardPanel();
        main.add(cardPanel);
    }

    private void createQuestionPanel(int questionIndex, QuestionModel model) {
        switch (model.getQuestionType()) {
            case MULTIPLE_CHOICE:
                createMultipleChoiceQuestionPanel(questionIndex, (MultipleChoiceQuestionModel) model);
                break;
            case BOOLEAN:
                createBooleanQuestionPanel(questionIndex, (BooleanQuestionModel) model);
                break;
            case SUBJECTIVE:
                createSubjectiveQuestionPanel(questionIndex, (SubjectiveQuestionModel) model);
                break;
        }
    }

    private void createMultipleChoiceQuestionPanel(int questionIndex, MultipleChoiceQuestionModel model) {
        LayoutContainer panel = new LayoutContainer(new FitLayout());
        panel.setStyleName("quiz-question");

        LayoutContainer box = new LayoutContainer();
        box.setLayout(new VBoxLayout());
        Html statement = new Html();
        statement.setId("quiz-question-statement");
        statement.setHtml(Integer.toString(questionIndex) + ". " + model.getStatement());
        RadioButton button1 = new RadioButton("A");
        button1.setStyleName("quiz-question-choice");
        button1.setText(model.getChoice1());
        RadioButton button2 = new RadioButton("B");
        button2.setStyleName("quiz-question-choice");
        button2.setText(model.getChoice2());
        RadioButton button3 = new RadioButton("C");
        button3.setStyleName("quiz-question-choice");
        button3.setText(model.getChoice3());
        RadioButton button4 = new RadioButton("D");
        button4.setStyleName("quiz-question-choice");
        button4.setText(model.getChoice4());

        box.add(statement, new VBoxLayoutData(0, 0, 20, 0));
        box.add(button1, new VBoxLayoutData(0, 0, 10, 0));
        box.add(button2, new VBoxLayoutData(0, 0, 5, 0));
        box.add(button3, new VBoxLayoutData(0, 0, 5, 0));
        box.add(button4, new VBoxLayoutData(0, 0, 5, 0));
        panel.add(box, new MarginData(50, 0, 0, 80));
        cardPanel.add(panel, new MarginData(0, 60, 0, 60));
    }

    private void createBooleanQuestionPanel(int questionIndex, BooleanQuestionModel model) {
        LayoutContainer panel = new LayoutContainer(new FitLayout());
        panel.setStyleName("quiz-question");
        LayoutContainer box = new LayoutContainer();
        box.setLayout(new VBoxLayout());
        Html statement = new Html();
        statement.setId("quiz-question-statement");
        statement.setHtml(Integer.toString(questionIndex) + ". " + model.getStatement());
        RadioButton button1 = new RadioButton("TRUE");
        button1.setStyleName("quiz-question-choice");
        button1.setText("TRUE");
        RadioButton button2 = new RadioButton("FALSE");
        button2.setStyleName("quiz-question-choice");
        button2.setText("FALSE");

        box.add(statement, new VBoxLayoutData(0, 0, 20, 0));
        box.add(button1, new VBoxLayoutData(0, 0, 10, 0));
        box.add(button2, new VBoxLayoutData(0, 0, 5, 0));
        panel.add(box, new MarginData(50, 0, 0, 80));
        cardPanel.add(panel, new MarginData(0, 60, 0, 60));
    }

    private void createSubjectiveQuestionPanel(int questionIndex, SubjectiveQuestionModel model) {
        LayoutContainer panel = new LayoutContainer(new FitLayout());
        panel.setStyleName("quiz-question");

        LayoutContainer box = new LayoutContainer();
        box.setLayout(new VBoxLayout());
        Html statement = new Html();
        statement.setId("quiz-question-statement");
        statement.setHtml(Integer.toString(questionIndex) + ". " + model.getStatement());
        TextArea area = new TextArea();
        area.setId("answer");
        area.setName("answer");
        area.setFieldLabel("");
        area.setHeight(250);
        area.setWidth(1000);

        box.add(statement, new VBoxLayoutData(0, 0, 20, 0));
        box.add(area, new VBoxLayoutData(0, 0, 10, 0));
        panel.add(box, new MarginData(50, 0, 0, 80));
        cardPanel.add(panel, new MarginData(0, 60, 0, 60));
    }

    class NextSelectionListener extends SelectionListener<ButtonEvent> {
        @Override
        public void componentSelected(ButtonEvent buttonEvent) {
            int previousStep = currentStep;
            if ((currentStep + 1) < cardPanel.getItemCount()) {
                currentStep += 1;
                cardPanel.setActiveItem(cardPanel.getItem(currentStep));
                cardPanel.fireEvent(
                        QuizEvents.QuizNavigate,
                        new QuizNavigateEvent(this, currentStep, previousStep)
                );
            }
        }
    }

    class PreviousSelectionListener extends SelectionListener<ButtonEvent> {
        @Override
        public void componentSelected(ButtonEvent buttonEvent) {
            int previousStep = currentStep;
            if ((currentStep - 1) > 0) {
                currentStep -= 1;
                cardPanel.setActiveItem(cardPanel.getItem(currentStep));
                cardPanel.fireEvent(
                        QuizEvents.QuizNavigate,
                        new QuizNavigateEvent(this, currentStep, previousStep)
                );
            }
        }
    }

    private String formattedNow() {
        int minutes = now / (60 * 1000);
        int seconds = (now / 1000) % 60;
        return formatter.format(minutes) + ":" + formatter.format(seconds);
    }

    private QuestionModel getQuestion(int questionIndex) {
        return models.get(questionIndex);
    }
}


