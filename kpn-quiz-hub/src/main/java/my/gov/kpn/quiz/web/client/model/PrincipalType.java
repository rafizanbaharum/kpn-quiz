package my.gov.kpn.quiz.web.client.model;

public enum PrincipalType {

    USER,
    GROUP;

    public static PrincipalType get(int index) {
        return values()[index];
    }

}
