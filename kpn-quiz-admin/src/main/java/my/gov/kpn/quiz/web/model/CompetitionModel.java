package my.gov.kpn.quiz.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 11/15/13
 */
public class CompetitionModel extends MetaModel {

    private int year;
    private int yearConstraint;
    private int startConstraint;
    private int endConstraint;

    private Date startDate;
    private String startDateFormatted;
    private String startDate_dd;
    private String startDate_MM;
    private String startDate_yyyy;
    private Date endDate;
    private String endDateFormatted;
    private String endDate_dd;
    private String endDate_MM;
    private String endDate_yyyy;
    private boolean locked;

    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public CompetitionModel() {
        locked = false;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYearConstraint() {
        return yearConstraint;
    }

    public void setYearConstraint(int yearConstraint) {
        this.yearConstraint = yearConstraint;
    }

    public int getStartConstraint() {
        return startConstraint;
    }

    public void setStartConstraint(int startConstraint) {
        this.startConstraint = startConstraint;
    }

    public int getEndConstraint() {
        return endConstraint;
    }

    public void setEndConstraint(int endConstraint) {
        this.endConstraint = endConstraint;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
        if (null != startDate) this.startDateFormatted = format.format(startDate);
    }

    public String getStartDateFormatted() {
        return startDateFormatted;
    }

    public void setStartDateFormatted(String startDateFormatted) {
        this.startDateFormatted = startDateFormatted;
    }

    public String getStartDate_dd() {
        return startDate_dd;
    }

    public void setStartDate_dd(String startDate_dd) {
        this.startDate_dd = startDate_dd;
    }

    public String getStartDate_MM() {
        return startDate_MM;
    }

    public void setStartDate_MM(String startDate_MM) {
        this.startDate_MM = startDate_MM;
    }

    public String getStartDate_yyyy() {
        return startDate_yyyy;
    }

    public void setStartDate_yyyy(String startDate_yyyy) {
        this.startDate_yyyy = startDate_yyyy;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
        if (null != endDate) this.endDateFormatted = format.format(endDate);
    }

    public String getEndDateFormatted() {
        return endDateFormatted;
    }

    public void setEndDateFormatted(String endDateFormatted) {
        this.endDateFormatted = endDateFormatted;
    }

    public String getEndDate_dd() {
        return endDate_dd;
    }

    public void setEndDate_dd(String endDate_dd) {
        this.endDate_dd = endDate_dd;
    }

    public String getEndDate_MM() {
        return endDate_MM;
    }

    public void setEndDate_MM(String endDate_MM) {
        this.endDate_MM = endDate_MM;
    }

    public String getEndDate_yyyy() {
        return endDate_yyyy;
    }

    public void setEndDate_yyyy(String endDate_yyyy) {
        this.endDate_yyyy = endDate_yyyy;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
