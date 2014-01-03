package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.ReportHelper;
import my.gov.kpn.quiz.core.dao.ReportDao;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.RegistrationModel;
import my.gov.kpn.quiz.web.model.report.InstructorModel;
import my.gov.kpn.quiz.web.model.report.StudentModel;
import my.gov.kpn.quiz.web.model.report.StudentStatModel;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller("SecureReportController")
@RequestMapping("/secure/report")
public class ReportController extends AbstractController {

    private static final Logger log = Logger.getLogger(ReportController.class);

    @Autowired
    private ReportDao reportDao;

    @Autowired
    private ReportHelper reportHelper;

    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(ModelMap model) {
        return "secure/report/list";
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String reportList(ModelMap model) {
        return "secure/report/report_list";
    }


    @RequestMapping(value = "/instructor/view", method = RequestMethod.GET)
    public String instructorView(@ModelAttribute("instructorModel") InstructorModel instructorModel,
            ModelAndView modelAndView, ModelMap map) {

        return "secure/report/report_instructor_list_form";

    }

    @RequestMapping(value = "/instructor/list", method = RequestMethod.GET)
    public Object instructorList(@ModelAttribute("instructorModel") InstructorModel instructorModel,
            ModelAndView modelAndView, ModelMap map) {


        JRBeanCollectionDataSource engine = new JRBeanCollectionDataSource(reportDao.getInstructorList(instructorModel.getState()));

        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("datasource", engine);
        parameterMap.put("pmt_state", reportHelper.findStateNameById(instructorModel.getState()));
        modelAndView = new ModelAndView("instructorList", parameterMap);

        return modelAndView;

    }

    @RequestMapping(value = "/student/view", method = RequestMethod.GET)
    public String studentView(@ModelAttribute("studentModel") StudentModel studentModel,
            ModelAndView modelAndView, ModelMap map) {

        return "secure/report/report_student_list_form";

    }

    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    public Object studentList(@ModelAttribute("studentModel") StudentModel studentModel,
            ModelAndView modelAndView, ModelMap map) {


        JRBeanCollectionDataSource engine = new JRBeanCollectionDataSource(reportDao.getStudentList(studentModel.getState(),studentModel.getSchoolType(),studentModel.getSchoolType()));

        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("datasource", engine);
        parameterMap.put("pmt_state", reportHelper.findStateNameById(studentModel.getState()));
        parameterMap.put("pmt_school", "ALL");
        modelAndView = new ModelAndView("studentList", parameterMap);

        return modelAndView;

    }

    @RequestMapping(value = "/studentStat/view", method = RequestMethod.GET)
    public String studentStatView(@ModelAttribute("studentStatModel") StudentStatModel studentStatModel,
            ModelAndView modelAndView, ModelMap map) {

        return "secure/report/report_student_stat_form";

    }

    @RequestMapping(value = "/studentStat/list", method = RequestMethod.GET)
    public Object studentStatList(@ModelAttribute("studentStatModel") StudentStatModel studentStatModel,
            ModelAndView modelAndView, ModelMap map) {


//        JRBeanCollectionDataSource engine = new JRBeanCollectionDataSource(reportDao.getStudentList(studentModel.getState(),studentModel.getSchoolType(),studentModel.getSchoolType()));

        Map<String, Object> parameterMap = new HashMap<String, Object>();
//        parameterMap.put("datasource", engine);
//        parameterMap.put("pmt_state", reportHelper.findStateNameById(studentModel.getState()));
//        parameterMap.put("pmt_school", "ALL");
        modelAndView = new ModelAndView("studentStatList", parameterMap);

        return modelAndView;

    }
}