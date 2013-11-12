package my.gov.kpn.quiz.web.client.view;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.mvc.View;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.MarginData;
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

        LayoutContainer header = new LayoutContainer();
        header.setId("app-header");
        header.setLayout(new FitLayout());
        BorderLayoutData northData = new BorderLayoutData(Style.LayoutRegion.NORTH, 0.08f);
        northData.setMargins(new Margins(0, 0, 0, 0));
        viewport.add(header, northData);

        // main
        LayoutContainer main = new LayoutContainer();
        main.setId("app-main");
        main.setLayout(new FitLayout());
        BorderLayoutData centerData = new BorderLayoutData(Style.LayoutRegion.CENTER);
        centerData.setMargins(new Margins(0, 0, 0, 0));
        viewport.add(main, centerData);

        LayoutContainer view = new LayoutContainer();
        view.setId("app-main-view");
        view.setLayout(new BorderLayout());
        main.add(view);

        createNorth(view);
        createCenter(view);
        createSouth(view);

        viewport.add(main, centerData);
        RootPanel.get().add(viewport);
//        dispatcher.dispatch(FinanceEvents.InitApplicationModule);
    }


    private void createNorth(LayoutContainer view) {
        LayoutContainer breadcrumb = new LayoutContainer();
        breadcrumb.setId("app-main-header");
        breadcrumb.setLayout(new FitLayout());
        BorderLayoutData northData = new BorderLayoutData(Style.LayoutRegion.NORTH, 0.08f);
        northData.setMargins(new Margins(0, 0, 0, 0));
        view.add(breadcrumb, northData);
        breadcrumb.add(new Html("Home"), new MarginData(20, 0, 0, 365));
    }

    private void createCenter(LayoutContainer view) {
        // main > view > canvas
        LayoutContainer canvas = new LayoutContainer();
        canvas.setId("app-main-canvas");
        canvas.setLayout(new FitLayout());
        BorderLayoutData eastData = new BorderLayoutData(Style.LayoutRegion.EAST, 0.80f);
        eastData.setMargins(new Margins(0, 0, 0, 0));
        view.add(canvas, eastData);
        canvas.add(new QuizPanel(), new MarginData(10, 10, 10, 20));
    }

    private void createSouth(LayoutContainer view) {
        // main > view > menu
        LayoutContainer menu = new LayoutContainer();
        menu.setId("app-main-footer");
        menu.setLayout(new FitLayout());
        BorderLayoutData westData = new BorderLayoutData(Style.LayoutRegion.SOUTH, 0.20f);
        westData.setMargins(new Margins(0, 0, 0, 0));
        view.add(menu, westData);
    }
}
