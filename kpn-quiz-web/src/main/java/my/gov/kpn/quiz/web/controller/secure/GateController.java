package my.gov.kpn.quiz.web.controller.secure;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
@Controller
@RequestMapping("/gate")
public class GateController {

    @RequestMapping(value = "/in", method = {RequestMethod.GET})
    public String gatein(ModelMap model) {
        return "gatein";
    }

    @RequestMapping(value = "/out", method = {RequestMethod.GET})
    public String gateout(ModelMap model) {
        return "gateout";
    }

}
