package my.gov.kpn.quiz.web.client.view;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * @author : alif haikal razak
 */
public class QuizView extends View {

    public QuizView(Controller controller) {
        super(controller);
    }

    @Override
    protected void handleEvent(AppEvent appEvent) {
        onInitApplicationView();
    }


    private void onInitApplicationView() {
        final Dispatcher dispatcher = Dispatcher.get();
        Viewport viewport = new Viewport();
        viewport.setId("app-viewport");
        viewport.setLayout(new BorderLayout());
        createHeader(viewport);
        createMain(viewport);
        createFooter(viewport);
        RootPanel.get().add(viewport);
//        dispatcher.dispatch(FinanceEvents.InitApplicationModule);
    }


    // header
    private void createHeader(Viewport view) {
//        final Timer timer = new Timer() {
//            public void run() {
//                timer.schedule(1000);
//            }
//        };
//        timer.schedule(1000);

        LayoutContainer breadcrumb = new LayoutContainer();
        breadcrumb.setId("quiz-app-header");
        breadcrumb.setLayout(new FitLayout());
        BorderLayoutData northData = new BorderLayoutData(Style.LayoutRegion.NORTH, 0.08f);
        northData.setMargins(new Margins(0, 0, 0, 0));
        view.add(breadcrumb, northData);
    }

    // main
    private void createMain(Viewport view) {
        LayoutContainer canvas = new LayoutContainer();
        canvas.setId("quiz-app-main");
        canvas.setLayout(new FitLayout());
        BorderLayoutData eastData = new BorderLayoutData(Style.LayoutRegion.CENTER, 0.72f);
        eastData.setMargins(new Margins(0, 0, 0, 0));
        view.add(canvas, eastData);
        canvas.add(new QuizPanel());
    }

    // footer
    private void createFooter(Viewport view) {
        LayoutContainer menu = new LayoutContainer();
        menu.setId("quiz-app-footer");
        menu.setLayout(new FitLayout());
        BorderLayoutData westData = new BorderLayoutData(Style.LayoutRegion.SOUTH, 0.20f);
        westData.setMargins(new Margins(0, 0, 0, 0));
        view.add(menu, westData);
    }
}
