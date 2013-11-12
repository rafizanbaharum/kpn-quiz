package my.gov.kpn.quiz.web.client.model;

public class StateModel extends MetaModel {

    public static final String ID = "id";
    public static final String NAME = "name";

    public Long getId() {
        return get(ID);
    }

    public void setId(Long id) {
        set(ID, id);
    }

    public String getName(){
        return get(NAME);
    }

    public void setName(String name){
        set(NAME,name);
    }
}
