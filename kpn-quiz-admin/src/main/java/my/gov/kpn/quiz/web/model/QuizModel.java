package my.gov.kpn.quiz.web.model;


import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 11/15/13
 */
public class QuizModel extends MetaModel {

    private String title;
    private String titleAbbreviated;
    private String round;
    private boolean current;
    private boolean processed;
    private boolean locked;
    private Date startDate;
    private String startDateFormatted;
    private String startDate_hh = "9";// default
    private String startDate_mm = "0";// default
    private String startDate_dd;
    private String startDate_MM;
    private String startDate_yyyy;
    private Date endDate;
    private String endDateFormatted;
    private String endDate_hh = "10";// default
    private String endDate_mm = "0"; // default
    private String endDate_dd;
    private String endDate_MM;
    private String endDate_yyyy;

    private static SimpleDateFormat format = new SimpleDateFormat("hh:mm dd/MM/yyyy");

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.titleAbbreviated = StringUtils.abbreviate(title, 40);
    }

    public String getTitleAbbreviated() {
        return titleAbbreviated;
    }

    public void setTitleAbbreviated(String titleAbbreviated) {
        this.titleAbbreviated = titleAbbreviated;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }


    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
        this.startDateFormatted = format.format(startDate);
    }

    public String getStartDateFormatted() {
        return startDateFormatted;
    }

    public void setStartDateFormatted(String startDateFormatted) {
        this.startDateFormatted = startDateFormatted;
    }

    public String getEndDateFormatted() {
        return endDateFormatted;
    }

    public void setEndDateFormatted(String endDateFormatted) {
        this.endDateFormatted = endDateFormatted;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
        this.endDateFormatted = format.format(endDate);
    }

    public String getStartDate_hh() {
        return startDate_hh;
    }

    public void setStartDate_hh(String startDate_hh) {
        this.startDate_hh = startDate_hh;
    }

    public String getStartDate_dd() {
        return startDate_dd;
    }

    public void setStartDate_dd(String startDate_dd) {
        this.startDate_dd = startDate_dd;
    }

    public String getStartDate_mm() {
        return startDate_mm;
    }

    public void setStartDate_mm(String startDate_mm) {
        this.startDate_mm = startDate_mm;
    }

    public String getStartDate_yyyy() {
        return startDate_yyyy;
    }

    public void setStartDate_yyyy(String startDate_yyyy) {
        this.startDate_yyyy = startDate_yyyy;
    }

    public String getEndDate_hh() {
        return endDate_hh;
    }

    public void setEndDate_hh(String endDate_hh) {
        this.endDate_hh = endDate_hh;
    }

    public String getEndDate_dd() {
        return endDate_dd;
    }

    public void setEndDate_dd(String endDate_dd) {
        this.endDate_dd = endDate_dd;
    }

    public String getEndDate_mm() {
        return endDate_mm;
    }

    public void setEndDate_mm(String endDate_mm) {
        this.endDate_mm = endDate_mm;
    }

    public String getEndDate_yyyy() {
        return endDate_yyyy;
    }

    public void setEndDate_yyyy(String endDate_yyyy) {
        this.endDate_yyyy = endDate_yyyy;
    }

    public String getStartDate_MM() {
        return startDate_MM;
    }

    public void setStartDate_MM(String startDate_MM) {
        this.startDate_MM = startDate_MM;
    }

    public String getEndDate_MM() {
        return endDate_MM;
    }

    public void setEndDate_MM(String endDate_MM) {
        this.endDate_MM = endDate_MM;
    }

    @Override
    public String toString() {
        return "QuizModel{" +
                "id='" + getId() + '\'' +
                '}';
    }
}
