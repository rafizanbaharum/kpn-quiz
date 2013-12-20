package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.web.controller.AbstractController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("SecureReportController")
@RequestMapping("/secure/report")
public class ReportController extends AbstractController {

    private static final Logger log = Logger.getLogger(ReportController.class);

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(ModelMap model) {
        return "secure/report/index";
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String reportList(ModelMap model) {
        return "secure/report/report_list";
    }
}