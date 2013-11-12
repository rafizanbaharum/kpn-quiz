package my.gov.kpn.quiz.web.client.model;

import com.google.common.base.Objects;

public class ParticipantModel extends MetaModel {

    public static final String ID = "id";
    public static final String STATE_ID = "stateId";
    public static final String ROUND_MODEL = "roundModel";
    public static final String USER_MODEL = "userModel";

    public Long getId() {
        return get(ID);
    }

    public void setId(Long id) {
        set(ID, id);
    }

    public RoundModel getRound() {
        return get(ROUND_MODEL);
    }

    public void setRound(RoundModel roundModel) {
        set(ROUND_MODEL, roundModel);
    }

    public UserModel getUser() {
        return get(USER_MODEL);
    }

    public void setUser(UserModel userModel) {
        set(USER_MODEL, userModel);
    }

    public String toString() {
        return Objects.toStringHelper(this)
                .toString();
    }
}

