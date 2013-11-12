package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
public interface QaActor extends QaMetaObject {

    /**
     * @return
     */
    String getNricNo();

    void setNricNo(String nricNo);

    /**
     * @return
     */
    Integer getAge();

    void setAge(Integer age);

    /**
     * @return
     */
    String getName();

    void setName(String name);

    /**
     * @return
     */
    String getEmail();

    void setEmail(String email);

    /**
     * @return
     */
    String getAddress1();

    void setAddress1(String address1);

    /**
     * @return
     */
    String getAddress2();

    void setAddress2(String address2);

    /**
     * @return
     */
    String getAddress3();

    void setAddress3(String address3);

    /**
     * @return
     */
    String getPhone();

    void setPhone(String phone);

    /**
     * @return
     */
    String getFax();

    void setFax(String fax);

    /**
     * @return
     */
    QaActorType getActorType();

    void setActorType(QaActorType actorType);
}
