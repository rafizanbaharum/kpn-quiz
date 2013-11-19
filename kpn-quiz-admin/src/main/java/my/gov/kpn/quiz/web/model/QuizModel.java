package my.gov.kpn.quiz.web.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 11/15/13
 */
public class QuizModel extends MetaModel {

    private String title;
    private Integer round;
    private boolean current;
    private boolean processed;
    private boolean locked;
    private Date startDate;
    private String startDate_ss;
    private String startDate_MM;
    private String startDate_dd;
    private String startDate_mm;
    private String startDate_yyyy;
    private Date endDate;
    private String endDate_ss;
    private String endDate_MM;
    private String endDate_dd;
    private String endDate_mm;
    private String endDate_yyyy;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
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
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getStartDate_ss() {
        return startDate_ss;
    }

    public void setStartDate_ss(String startDate_ss) {
        this.startDate_ss = startDate_ss;
    }

    public String getStartDate_MM() {
        return startDate_MM;
    }

    public void setStartDate_MM(String startDate_MM) {
        this.startDate_MM = startDate_MM;
    }

    public String getEndDate_ss() {
        return endDate_ss;
    }

    public void setEndDate_ss(String endDate_ss) {
        this.endDate_ss = endDate_ss;
    }

    public String getEndDate_MM() {
        return endDate_MM;
    }

    public void setEndDate_MM(String endDate_MM) {
        this.endDate_MM = endDate_MM;
    }
}
