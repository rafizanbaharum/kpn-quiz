package my.gov.kpn.quiz.core.report;

public class StudentStatisticModel {

    private String stateName;
    private Long stateId;
    private Long maleTotal;
    private Long femaleTotal;
    private Long malayTotal;
    private Long chineseTotal;
    private Long indianTotal;
    private Long nativeSabahTotal;
    private Long nativeSarawakTotal;
    private Long othersTotal;

    public StudentStatisticModel() {

        maleTotal = 0L;
        femaleTotal = 0L;

        malayTotal = 0L;
        chineseTotal = 0L;
        indianTotal = 0L;
        nativeSabahTotal = 0L;
        nativeSarawakTotal = 0L;
        othersTotal = 0L;

    }

    public Long getChineseTotal() {
        return chineseTotal;
    }

    public void setChineseTotal(Long chineseTotal) {
        this.chineseTotal = chineseTotal;
    }

    public Long getFemaleTotal() {
        return femaleTotal;
    }

    public void setFemaleTotal(Long femaleTotal) {
        this.femaleTotal = femaleTotal;
    }

    public Long getIndianTotal() {
        return indianTotal;
    }

    public void setIndianTotal(Long indianTotal) {
        this.indianTotal = indianTotal;
    }

    public Long getMalayTotal() {
        return malayTotal;
    }

    public void setMalayTotal(Long malayTotal) {
        this.malayTotal = malayTotal;
    }

    public Long getMaleTotal() {
        return maleTotal;
    }

    public void setMaleTotal(Long maleTotal) {
        this.maleTotal = maleTotal;
    }

    public Long getNativeSabahTotal() {
        return nativeSabahTotal;
    }

    public void setNativeSabahTotal(Long nativeSabahTotal) {
        this.nativeSabahTotal = nativeSabahTotal;
    }

    public Long getNativeSarawakTotal() {
        return nativeSarawakTotal;
    }

    public void setNativeSarawakTotal(Long nativeSarawakTotal) {
        this.nativeSarawakTotal = nativeSarawakTotal;
    }

    public Long getOthersTotal() {
        return othersTotal;
    }

    public void setOthersTotal(Long othersTotal) {
        this.othersTotal = othersTotal;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Long getTotal(){
        return maleTotal + femaleTotal;
    }
}
