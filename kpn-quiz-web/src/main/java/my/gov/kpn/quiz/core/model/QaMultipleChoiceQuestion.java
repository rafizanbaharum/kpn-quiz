package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 11/7/13
 */
public interface QaMultipleChoiceQuestion extends QaQuestion {

    /**
     * @return
     */
    String getChoice1();

    void setChoice1(String choice1);

    /**
     * @return
     */
    String getChoice2();

    void setChoice2(String choice2);

    /**
     * @return
     */
    String getChoice3();

    void setChoice3(String choice3);

    /**
     * @return
     */
    String getChoice4();

    void setChoice4(String choice4);
}
