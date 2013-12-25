package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.core.dao.ReportDao;
import my.gov.kpn.quiz.web.controller.AbstractController;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller("SecureReportController")
@RequestMapping("/secure/report")
public class ReportController extends AbstractController {

    private static final Logger log = Logger.getLogger(ReportController.class);

    @Autowired
    private ReportDao reportDao;

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(ModelMap model) {
        return "secure/report/index";
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String reportList(ModelMap model) {
        return "secure/report/report_list";
    }


    @RequestMapping(value = "/instructor/list", method = RequestMethod.GET)
    public Object projectStatusView(
            ModelAndView modelAndView, ModelMap map) {


        JRBeanCollectionDataSource engine = new JRBeanCollectionDataSource(reportDao.getInstructorList());

        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("datasource", engine);
        parameterMap.put("pmt_state", "all");
        modelAndView = new ModelAndView("instructorList", parameterMap);

        return modelAndView;

    }
}