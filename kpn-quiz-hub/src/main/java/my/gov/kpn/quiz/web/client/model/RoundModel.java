package my.gov.kpn.quiz.web.client.model;


import java.util.List;

public class RoundModel extends MetaModel {

    public static final String ID = "id";
    public static final String PROCESSED = "processed";
    public static final String LOCKED = "locked";
    public static final String COMPETITION_MODEL = "competitionModel";
    public static final String PARTICIPANT_MODEL = "participantModel";

    public Long getId() {
        return get(ID);
    }

    public void setId(Long id) {
        set(ID, id);
    }

    public Boolean isProcessed() {
        return get(PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROCESSED, processed);
    }

    public Boolean isLocked() {
        return get(LOCKED);
    }

    public void setLocked(Boolean locked) {
        set(LOCKED, locked);
    }

    public CompetitionModel getCompetition() {
        return get(COMPETITION_MODEL);
    }

    public void setCompetition(CompetitionModel competitionModel) {
        set(COMPETITION_MODEL, competitionModel);
    }

    public List<ParticipantModel> getParticipants() {
        return get(PARTICIPANT_MODEL);
    }

    public void setParticipants(List<ParticipantModel> participantModels) {
        set(PARTICIPANT_MODEL, participantModels);
    }

    public String toString() {
        return getId().toString();
    }
}

