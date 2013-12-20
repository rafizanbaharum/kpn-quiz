package my.gov.kpn.quiz.web.controller.secure;

import my.gov.kpn.quiz.biz.manager.CompetitionManager;
import my.gov.kpn.quiz.core.model.QaCompetition;
import my.gov.kpn.quiz.core.model.impl.QaCompetitionImpl;
import my.gov.kpn.quiz.web.controller.AbstractController;
import my.gov.kpn.quiz.web.model.CompetitionModel;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Controller("SecureCompetitionController")
@RequestMapping("/secure/competition")
public class CompetitionController extends AbstractController {

    private static final Logger log = Logger.getLogger(CompetitionController.class);

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public String competitionList(@ModelAttribute("competitionModel") CompetitionModel competitionModel, ModelMap model) {
        List<QaCompetition> competitions = competitionManager.findAll();
        model.addAttribute("competitionModels", transformer.transformCompetitions(competitions));
        return "secure/competition/competition_list";
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String competitionView(@PathVariable Long id, ModelMap model) {
        QaCompetition competition = competitionManager.findCompetitionById(id);
        CompetitionModel competitionModel = transformer.transform(competition);

        model.addAttribute("competitionModel", competitionModel);
        return "secure/competition/competition_view";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET})
    public String competitionAdd(@ModelAttribute("competitionModel") CompetitionModel competitionModel, ModelMap
            model) {
        return "secure/competition/competition_add";
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public String competitionSave(@ModelAttribute("competitionModel") CompetitionModel competitionModel, BindingResult bindingResult,
                                  ModelMap model) {

        QaCompetition competition = new QaCompetitionImpl();
        competition.setStartDate(combineStartDate(competitionModel));
        competition.setEndDate(combineEndDate(competitionModel));
        competition.setYear(competitionModel.getYear());
        competition.setLocked(competitionModel.isLocked());

        if (competition.getStartDate().compareTo(competition.getEndDate()) > 0) {
            FieldError fieldError = new FieldError("competitionModel", "startDate_dd",
                    messageSource.getMessage("Date.competitionModel.dateRange", new Object[]{"End date", "Start date"}, null));
            bindingResult.addError(fieldError);
        }

        if (bindingResult.hasErrors()) {
            model.put(MSG_ERROR, "Error! Please check your data.");
            return competitionAdd(competitionModel, model);
        }

        competitionManager.saveCompetition(competition);
        return "redirect:/secure/competition/list";
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    public String competitionEdit(@PathVariable Long id, ModelMap model) {
        QaCompetition competition = competitionManager.findCompetitionById(id);
        CompetitionModel competitionModel = transformer.transform(competition);

        model.addAttribute("competitionModel", competitionModel);
        return "secure/competition/competition_edit";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String competitionUpdate(@ModelAttribute("competitionModel") CompetitionModel competitionModel,
                                    ModelMap model) {
        QaCompetition competition = competitionManager.findCompetitionById(competitionModel.getId());
        Date startDate = combineStartDate(competitionModel);
        Date endDate = combineEndDate(competitionModel);

        competition.setStartDate(startDate);
        competition.setEndDate(endDate);
        competition.setYear(competitionModel.getYear());
        competition.setLocked(competitionModel.isLocked());

        competitionManager.updateCompetition(competition);

        model.addAttribute(MSG_SUCCESS, "Competition successfully updated");
        return "redirect:/secure/competition/view/" + competition.getId();
    }

    @RequestMapping(value = "/remove/{id}", method = {RequestMethod.GET})
    public String competitionRemove(@PathVariable Long id, ModelMap model) {
        QaCompetition competition = competitionManager.findCompetitionById(id);

        model.addAttribute("competitionModel", transformer.transform(competition));
        return "secure/competition/competition_remove";
    }

    @RequestMapping(value = "/remove/confirm/{id}", method = {RequestMethod.POST})
    public String competitionConfirmRemove(@PathVariable Long id, ModelMap model) {
        QaCompetition competition = competitionManager.findCompetitionById(id);

        model.addAttribute("competitionModel", transformer.transform(competition));
        model.put(MSG_SUCCESS, "Competition Removed");
        return competitionList(new CompetitionModel(), model);
    }

    /**
     * @param competitionModel
     * @return
     */
    private static Date combineStartDate(CompetitionModel competitionModel) {
        return new LocalDate(Integer.parseInt(competitionModel.getStartDate_yyyy()),
                Integer.parseInt(competitionModel.getStartDate_MM()),
                Integer.parseInt(competitionModel.getStartDate_dd())).toDate();
    }

    /**
     * @param competitionModel
     * @return
     */
    private static Date combineEndDate(CompetitionModel competitionModel) {
        return new LocalDate(Integer.parseInt(competitionModel.getEndDate_yyyy()),
                Integer.parseInt(competitionModel.getEndDate_MM()),
                Integer.parseInt(competitionModel.getEndDate_dd())).toDate();
    }
}
