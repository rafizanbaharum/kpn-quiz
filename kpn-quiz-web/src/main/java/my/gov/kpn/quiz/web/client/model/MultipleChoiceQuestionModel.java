package my.gov.kpn.quiz.web.client.model;

/**
 * @author rafizan.baharum
 * @since 11/12/13
 */
public class MultipleChoiceQuestionModel extends QuestionModel {

    public static final String CHOICE_1 = "choice1";
    public static final String CHOICE_2 = "choice2";
    public static final String CHOICE_3 = "choice3";
    public static final String CHOICE_4 = "choice4";


    public String getChoice1() {
        return get(CHOICE_1);
    }

    public void setChoice1(String choice1) {
        set(CHOICE_1, choice1);
    }

    public String getChoice2() {
        return get(CHOICE_2);
    }

    public void setChoice2(String choice2) {
        set(CHOICE_2, choice2);
    }

    public String getChoice3() {
        return get(CHOICE_3);
    }

    public void setChoice3(String choice3) {
        set(CHOICE_3, choice3);
    }

    public String getChoice4() {
        return get(CHOICE_4);
    }

    public void setChoice4(String choice4) {
        set(CHOICE_4, choice4);
    }
}
