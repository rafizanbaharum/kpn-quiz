package my.gov.kpn.quiz.core.model;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
public enum QaRoleType {

    ROLE_ADMINISTRATOR("Administrator"), // 0
    ROLE_USER("User"),                   // 1
    ROLE_SUPPORT("Support Team"),        // 2
    ROLE_REPORT("Report Viewer"),        // 3
    ROLE_GUEST("Guest");                 // 4

    private String description;

    QaRoleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
