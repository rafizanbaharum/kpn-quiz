package my.gov.kpn.quiz.web.client.model;

/**
 * @author : alif haikal razak
 */
public class CompetitionModel extends MetaModel {

    public static final String ID = "id";
    public static final String YEAR = "year";
    public static final String LOCKED = "locked";


    public Long getId() {
        return get(ID);
    }

    public void setId(Long id) {
        set(ID, id);
    }

    public Boolean isProcessed() {
        return get(YEAR);
    }

    public void setProcessed(Boolean processed) {
        set(YEAR, processed);
    }

    public Boolean isLocked() {
        return get(LOCKED);
    }

    public void setLocked(Boolean locked) {
        set(LOCKED, locked);
    }

    public String toString() {
        return isProcessed() + " " + isLocked();
    }

}
