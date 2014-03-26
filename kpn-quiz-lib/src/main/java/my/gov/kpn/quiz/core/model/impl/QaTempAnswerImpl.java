package my.gov.kpn.quiz.core.model.impl;

import my.gov.kpn.quiz.core.model.QaParticipant;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.core.model.QaTempAnswer;

import javax.persistence.*;
import java.util.Date;

@Table(name = "QA_TMP_ANS")
@Entity(name = "QaTempAnswer")
public class QaTempAnswerImpl implements QaTempAnswer {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_TMP_ANSWR")
    @SequenceGenerator(name = "SEQ_TMP_ANSWR", sequenceName = "SEQ_TMP_ANSWR", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NRIC")
    private String nric;

    @Column(name = "SCHOOL")
    private String school;

    @Column(name = "FILENAME")
    private String filename;

    @OneToOne(targetEntity = QaStudentImpl.class)
    @JoinColumn(name = "STUDENT_ID")
    private QaStudent studentId;

    @OneToOne(targetEntity = QaParticipantImpl.class)
    @JoinColumn(name = "PARTICIPANT_ID")
    private QaParticipant participantId;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "ERROR")
    private String error;

    @Column(name = "M_TS")
    private Date timestamp;

    @Column(name = "ANSWER01")
    private String answer01;

    @Column(name = "ANSWER02")
    private String answer02;

    @Column(name = "ANSWER03")
    private String answer03;

    @Column(name = "ANSWER04")
    private String answer04;

    @Column(name = "ANSWER05")
    private String answer05;

    @Column(name = "ANSWER06")
    private String answer06;

    @Column(name = "ANSWER07")
    private String answer07;

    @Column(name = "ANSWER08")
    private String answer08;

    @Column(name = "ANSWER09")
    private String answer09;

    @Column(name = "ANSWER10")
    private String answer10;

    @Column(name = "ANSWER11")
    private String answer11;

    @Column(name = "ANSWER12")
    private String answer12;

    @Column(name = "ANSWER13")
    private String answer13;

    @Column(name = "ANSWER14")
    private String answer14;

    @Column(name = "ANSWER15")
    private String answer15;

    @Column(name = "ANSWER16")
    private String answer16;

    @Column(name = "ANSWER17")
    private String answer17;

    @Column(name = "ANSWER18")
    private String answer18;

    @Column(name = "ANSWER19")
    private String answer19;

    @Column(name = "ANSWER20")
    private String answer20;

     @Column(name = "ANSWER21")
    private String answer21;

    @Column(name = "ANSWER22")
    private String answer22;

    @Column(name = "ANSWER23")
    private String answer23;

    @Column(name = "ANSWER24")
    private String answer24;

    @Column(name = "ANSWER25")
    private String answer25;

    @Column(name = "ANSWER26")
    private String answer26;

    @Column(name = "ANSWER27")
    private String answer27;

    @Column(name = "ANSWER28")
    private String answer28;

    @Column(name = "ANSWER29")
    private String answer29;

    @Column(name = "ANSWER30")
    private String answer30;

     @Column(name = "ANSWER31")
    private String answer31;

    @Column(name = "ANSWER32")
    private String answer32;

    @Column(name = "ANSWER33")
    private String answer33;

    @Column(name = "ANSWER34")
    private String answer34;

    @Column(name = "ANSWER35")
    private String answer35;

    @Column(name = "ANSWER36")
    private String answer36;

    @Column(name = "ANSWER37")
    private String answer37;

    @Column(name = "ANSWER38")
    private String answer38;

    @Column(name = "ANSWER39")
    private String answer39;

    @Column(name = "ANSWER40")
    private String answer40;

    @Column(name = "ANSWER41", length = 1)
    private String answer41;

    @Column(name = "ANSWER42", length = 1)
    private String answer42;

    @Column(name = "ANSWER43", length = 1)
    private String answer43;

    @Column(name = "ANSWER44", length = 1)
    private String answer44;

    @Column(name = "ANSWER45", length = 1)
    private String answer45;

    @Column(name = "ANSWER46", length = 1)
    private String answer46;

    @Column(name = "ANSWER47", length = 1)
    private String answer47;

    @Column(name = "ANSWER48", length = 1)
    private String answer48;

    @Column(name = "ANSWER49", length = 3000)
    private String answer49;

    @Column(name = "ANSWER50", length = 3000)
    private String answer50;

    @Column(name = "ANSWER51", length = 3000)
    private String answer51;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getAnswer01() {
        return answer01;
    }

    public void setAnswer01(String answer01) {
        this.answer01 = answer01;
    }

    public String getAnswer02() {
        return answer02;
    }

    public void setAnswer02(String answer02) {
        this.answer02 = answer02;
    }

    public String getAnswer03() {
        return answer03;
    }

    public void setAnswer03(String answer03) {
        this.answer03 = answer03;
    }

    public String getAnswer04() {
        return answer04;
    }

    public void setAnswer04(String answer04) {
        this.answer04 = answer04;
    }

    public String getAnswer05() {
        return answer05;
    }

    public void setAnswer05(String answer05) {
        this.answer05 = answer05;
    }

    public String getAnswer06() {
        return answer06;
    }

    public void setAnswer06(String answer06) {
        this.answer06 = answer06;
    }

    public String getAnswer07() {
        return answer07;
    }

    public void setAnswer07(String answer07) {
        this.answer07 = answer07;
    }

    public String getAnswer08() {
        return answer08;
    }

    public void setAnswer08(String answer08) {
        this.answer08 = answer08;
    }

    public String getAnswer09() {
        return answer09;
    }

    public void setAnswer09(String answer09) {
        this.answer09 = answer09;
    }

    public String getAnswer10() {
        return answer10;
    }

    public void setAnswer10(String answer10) {
        this.answer10 = answer10;
    }

    public String getAnswer11() {
        return answer11;
    }

    public void setAnswer11(String answer11) {
        this.answer11 = answer11;
    }

    public String getAnswer12() {
        return answer12;
    }

    public void setAnswer12(String answer12) {
        this.answer12 = answer12;
    }

    public String getAnswer13() {
        return answer13;
    }

    public void setAnswer13(String answer13) {
        this.answer13 = answer13;
    }

    public String getAnswer14() {
        return answer14;
    }

    public void setAnswer14(String answer14) {
        this.answer14 = answer14;
    }

    public String getAnswer15() {
        return answer15;
    }

    public void setAnswer15(String answer15) {
        this.answer15 = answer15;
    }

    public String getAnswer16() {
        return answer16;
    }

    public void setAnswer16(String answer16) {
        this.answer16 = answer16;
    }

    public String getAnswer17() {
        return answer17;
    }

    public void setAnswer17(String answer17) {
        this.answer17 = answer17;
    }

    public String getAnswer18() {
        return answer18;
    }

    public void setAnswer18(String answer18) {
        this.answer18 = answer18;
    }

    public String getAnswer19() {
        return answer19;
    }

    public void setAnswer19(String answer19) {
        this.answer19 = answer19;
    }

    public String getAnswer20() {
        return answer20;
    }

    public void setAnswer20(String answer20) {
        this.answer20 = answer20;
    }

    public String getAnswer21() {
        return answer21;
    }

    public void setAnswer21(String answer21) {
        this.answer21 = answer21;
    }

    public String getAnswer22() {
        return answer22;
    }

    public void setAnswer22(String answer22) {
        this.answer22 = answer22;
    }

    public String getAnswer23() {
        return answer23;
    }

    public void setAnswer23(String answer23) {
        this.answer23 = answer23;
    }

    public String getAnswer24() {
        return answer24;
    }

    public void setAnswer24(String answer24) {
        this.answer24 = answer24;
    }

    public String getAnswer25() {
        return answer25;
    }

    public void setAnswer25(String answer25) {
        this.answer25 = answer25;
    }

    public String getAnswer26() {
        return answer26;
    }

    public void setAnswer26(String answer26) {
        this.answer26 = answer26;
    }

    public String getAnswer27() {
        return answer27;
    }

    public void setAnswer27(String answer27) {
        this.answer27 = answer27;
    }

    public String getAnswer28() {
        return answer28;
    }

    public void setAnswer28(String answer28) {
        this.answer28 = answer28;
    }

    public String getAnswer29() {
        return answer29;
    }

    public void setAnswer29(String answer29) {
        this.answer29 = answer29;
    }

    public String getAnswer30() {
        return answer30;
    }

    public void setAnswer30(String answer30) {
        this.answer30 = answer30;
    }

    public String getAnswer31() {
        return answer31;
    }

    public void setAnswer31(String answer31) {
        this.answer31 = answer31;
    }

    public String getAnswer32() {
        return answer32;
    }

    public void setAnswer32(String answer32) {
        this.answer32 = answer32;
    }

    public String getAnswer33() {
        return answer33;
    }

    public void setAnswer33(String answer33) {
        this.answer33 = answer33;
    }

    public String getAnswer34() {
        return answer34;
    }

    public void setAnswer34(String answer34) {
        this.answer34 = answer34;
    }

    public String getAnswer35() {
        return answer35;
    }

    public void setAnswer35(String answer35) {
        this.answer35 = answer35;
    }

    public String getAnswer36() {
        return answer36;
    }

    public void setAnswer36(String answer36) {
        this.answer36 = answer36;
    }

    public String getAnswer37() {
        return answer37;
    }

    public void setAnswer37(String answer37) {
        this.answer37 = answer37;
    }

    public String getAnswer38() {
        return answer38;
    }

    public void setAnswer38(String answer38) {
        this.answer38 = answer38;
    }

    public String getAnswer39() {
        return answer39;
    }

    public void setAnswer39(String answer39) {
        this.answer39 = answer39;
    }

    public String getAnswer40() {
        return answer40;
    }

    public void setAnswer40(String answer40) {
        this.answer40 = answer40;
    }

    public String getAnswer41() {
        return answer41;
    }

    public void setAnswer41(String answer41) {
        this.answer41 = answer41;
    }

    public String getAnswer42() {
        return answer42;
    }

    public void setAnswer42(String answer42) {
        this.answer42 = answer42;
    }

    public String getAnswer43() {
        return answer43;
    }

    public void setAnswer43(String answer43) {
        this.answer43 = answer43;
    }

    public String getAnswer44() {
        return answer44;
    }

    public void setAnswer44(String answer44) {
        this.answer44 = answer44;
    }

    public String getAnswer45() {
        return answer45;
    }

    public void setAnswer45(String answer45) {
        this.answer45 = answer45;
    }

    public String getAnswer46() {
        return answer46;
    }

    public void setAnswer46(String answer46) {
        this.answer46 = answer46;
    }

    public String getAnswer47() {
        return answer47;
    }

    public void setAnswer47(String answer47) {
        this.answer47 = answer47;
    }

    public String getAnswer48() {
        return answer48;
    }

    public void setAnswer48(String answer48) {
        this.answer48 = answer48;
    }

    public String getAnswer49() {
        return answer49;
    }

    public void setAnswer49(String answer49) {
        this.answer49 = answer49;
    }

    public String getAnswer50() {
        return answer50;
    }

    public void setAnswer50(String answer50) {
        this.answer50 = answer50;
    }

    public String getAnswer51() {
        return answer51;
    }

    public void setAnswer51(String answer51) {
        this.answer51 = answer51;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public QaParticipant getParticipantId() {
        return participantId;
    }

    public void setParticipantId(QaParticipant participantId) {
        this.participantId = participantId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public QaStudent getStudentId() {
        return studentId;
    }

    public void setStudentId(QaStudent studentId) {
        this.studentId = studentId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
