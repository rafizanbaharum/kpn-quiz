package my.gov.kpn.quiz.web.client.model;


public class ParticipantModel extends MetaModel {

    public static final String ID = "id";
    public static final String STATE_ID = "stateId";
    public static final String QUIZ_MODEL = "roundModel";
    public static final String USER_MODEL = "userModel";

    public Long getId() {
        return get(ID);
    }

    public void setId(Long id) {
        set(ID, id);
    }

    public QuizModel getQuiz() {
        return get(QUIZ_MODEL);
    }

    public void setQuiz(QuizModel quizModel) {
        set(QUIZ_MODEL, quizModel);
    }

    public UserModel getUser() {
        return get(USER_MODEL);
    }

    public void setUser(UserModel userModel) {
        set(USER_MODEL, userModel);
    }

    public String toString() {
        return getUser().getEmail();
    }
}

