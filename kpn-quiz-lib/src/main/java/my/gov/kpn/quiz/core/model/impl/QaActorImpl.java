package my.gov.kpn.quiz.core.model.impl;

import com.google.common.base.Objects;
import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaActorType;
import my.gov.kpn.quiz.core.model.QaMetadata;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 7/10/13
 */
@Table(name = "QA_ACTR")
@Entity(name = "QaActor")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class QaActorImpl implements QaActor, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_QA_ACTR")
    @SequenceGenerator(name = "SEQ_QA_ACTR", sequenceName = "SEQ_QA_ACTR", allocationSize = 1)
    private Long id;

    @Column(name = "NRIC_NO", unique = true)
    private String nricNo;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS1")
    private String address1;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "ADDRESS3")
    private String address3;

    @Column(name = "ADDRESS4")
    private String phone;

    @Column(name = "FAX")
    private String fax;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ACTOR_TYPE")
    private QaActorType actorType;

    @Embedded
    private QaMetadata metadata = new QaMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNricNo() {
        return nricNo;
    }

    public void setNricNo(String nricNo) {
        this.nricNo = nricNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public QaActorType getActorType() {
        return actorType;
    }

    public void setActorType(QaActorType actorType) {
        this.actorType = actorType;
    }

    public QaMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(QaMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "QaActorImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nricNo='" + nricNo + '\'' +
                ", actorType=" + actorType +
                '}';
    }
}

