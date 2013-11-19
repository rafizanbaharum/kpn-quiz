package my.gov.kpn.quiz.web.client.view;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.data.*;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.*;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.*;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
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

                    LayoutContainer container = (LayoutContainer) cardPanel.getItem(currentStep);
                    LayoutContainer box = (LayoutContainer) container.getItemByItemId("quiz-question-box");
                    switch (prevQuestion.getQuestionType()) {
                        case MULTIPLE_CHOICE:
                            Radio mcRadio0 = (Radio) box.getItemByItemId("0");
                            Radio mcRadio1 = (Radio) box.getItemByItemId("1");
                            Radio mcRadio2 = (Radio) box.getItemByItemId("2");
                            Radio mcRadio3 = (Radio) box.getItemByItemId("3");

                            // TODO: simplify
                            Integer mcAnswer = -1;
                            if (mcRadio0.getValue()) mcAnswer = 0;
                            if (mcRadio1.getValue()) mcAnswer = 1;
                            if (mcRadio2.getValue()) mcAnswer = 2;
                            if (mcRadio3.getValue()) mcAnswer = 3;
                            if (mcAnswer != -1) updateAnswer(prevQuestion, mcAnswer);
                            loadAnswerIndex(nextQuestion);
                            break;
                        case BOOLEAN:
                            Radio blRadio0 = (Radio) box.getItemByItemId("0");
                            Radio blRadio1 = (Radio) box.getItemByItemId("1");

                            // TODO: simplify
                            Integer blAnswer = -1;
                            if (blRadio0.getValue()) blAnswer = 0;
                            if (blRadio1.getValue()) blAnswer = 1;

                            if (blAnswer != -1) updateAnswer(prevQuestion, blAnswer);
                            loadAnswerIndex(nextQuestion);
                            break;
                        case SUBJECTIVE:
                            TextArea textArea = (TextArea) box.getItemByItemId("quiz-question-response");
                            updateAnswer(prevQuestion, textArea.getValue());
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
    private void updateAnswer(QuestionModel questionModel, String answerResponse) {
        log.info("updating answer: " + answerResponse);
        delegate.updateAnswer(questionModel, answerResponse, new AsyncCallback<Void>() {
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
    private void updateAnswer(QuestionModel questionModel, Integer answerIndex) {
        log.info("updating answer: " + answerIndex);
        delegate.updateAnswer(questionModel, answerIndex, new AsyncCallback<Void>() {
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

    private void loadAnswerIndex(final QuestionModel questionModel) {
        delegate.loadAnswerIndex(questionModel, new AsyncCallback<Integer>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(Integer result) {
                if (null != result) {
                    updateStatus("Answered");
                    LayoutContainer container = (LayoutContainer) cardPanel.getItem(currentStep);
                    LayoutContainer box = (LayoutContainer) container.getItemByItemId("quiz-question-box");
                    switch (questionModel.getQuestionType()) {
                        case MULTIPLE_CHOICE:
                            log.info("result: " + result);
                            Radio radioMulti = (Radio) box.getItemByItemId(result.toString()); // 0-A, 1-B, 2-C, 3-D
                            radioMulti.setValue(Boolean.TRUE);
                            break;
                        case BOOLEAN:
                            Radio radioBoolean = (Radio) box.getItemByItemId(result.toString()); // 0-FALSE, 1-TRUE
                            radioBoolean.setValue(Boolean.TRUE);
                            break;
                        case SUBJECTIVE:
                            // N/A
                            break;
                    }
                } else {
                    updateStatus("Unanswered");
                }
            }
        });
    }

    private void loadAnswerResponse(final QuestionModel questionModel) {
        delegate.loadAnswerResponse(questionModel, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(String result) {
                if (null != result) {
                    updateStatus("Answered");
                    LayoutContainer container = (LayoutContainer) cardPanel.getItem(currentStep);
                    LayoutContainer box = (LayoutContainer) container.getItemByItemId("quiz-question-box");
                    switch (questionModel.getQuestionType()) {
                        case MULTIPLE_CHOICE:
                            // N/A
                            break;
                        case BOOLEAN:
                            // N/A
                            break;
                        case SUBJECTIVE:
                            TextArea textArea = (TextArea) box.getItemByItemId("quiz-question-response");
                            textArea.setValue(result);
                            break;
                    }
                } else {
                    updateStatus("Unanswered");
                }
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
        panel.setId("quiz-question-panel");
        panel.setStyleName("quiz-question");

        LayoutContainer box = new LayoutContainer();
        box.setItemId("quiz-question-box");
        box.setLayout(new VBoxLayout());

        Html statement = new Html();
        statement.setId("quiz-question-statement");
        statement.setHtml(Integer.toString(questionIndex) + ". " + model.getStatement());

        RadioGroup group = new RadioGroup();
        Radio button1 = new Radio();
        button1.setItemId("0");
        button1.setStyleName("quiz-question-choice");
        button1.setBoxLabel(model.getChoice1());
        Radio button2 = new Radio();
        button2.setItemId("1");
        button2.setItemId("1");
        button2.setStyleName("quiz-question-choice");
        button2.setBoxLabel(model.getChoice2());
        Radio button3 = new Radio();
        button3.setItemId("2");
        button3.setStyleName("quiz-question-choice");
        button3.setBoxLabel(model.getChoice3());
        Radio button4 = new Radio();
        button4.setItemId("3");
        button4.setStyleName("quiz-question-choice");
        button4.setBoxLabel(model.getChoice4());
        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);

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
        panel.setItemId("quiz-question-panel");
        panel.setStyleName("quiz-question");

        LayoutContainer box = new LayoutContainer();
        box.setItemId("quiz-question-box");
        box.setLayout(new VBoxLayout());

        Html statement = new Html();
        statement.setId("quiz-question-statement");
        statement.setHtml(Integer.toString(questionIndex) + ". " + model.getStatement());

        RadioGroup group = new RadioGroup();
        Radio button1 = new Radio();
        button1.setItemId("0");
        button1.setStyleName("quiz-question-choice");
        button1.setBoxLabel("TRUE");
        Radio button2 = new Radio();
        button2.setItemId("1");
        button2.setStyleName("quiz-question-choice");
        button2.setBoxLabel("FALSE");
        group.add(button1);
        group.add(button2);

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
        area.setItemId("quiz-question-response");
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


