package my.gov.kpn.quiz.web.client.model;

import java.util.Date;

public class QuizModel extends MetaModel {

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String LOCKED = "locked";
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";
    public static final String COMPETITION_MODEL = "roundModel";

    public Long getId() {
        return get(ID);
    }

    public void setId(Long id) {
        set(ID, id);
    }

    public String getTitle() {
        return get(TITLE);
    }

    public void setTitle(String title) {
        set(TITLE, title);
    }

    public Boolean isLocked() {
        return get(LOCKED);
    }

    public void setLocked(Boolean locked) {
        set(LOCKED, locked);
    }

    public Date getStartDate() {
        return get(START_DATE);
    }

    public void setStartDate(Date startDate) {
        set(START_DATE, startDate);
    }

    public Date getEndDate() {
        return get(END_DATE);
    }

    public void setEndDate(Date endDate) {
        set(END_DATE, endDate);
    }

    public CompetitionModel getCompetition() {
        return get(COMPETITION_MODEL);
    }

    public void setCompetition(CompetitionModel competitionModel) {
        set(COMPETITION_MODEL, competitionModel);
    }

    public String toString() {
        return getTitle();
    }
}

