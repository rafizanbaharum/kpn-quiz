package my.gov.kpn.quiz.web.controller;

import my.gov.kpn.quiz.biz.integration.springsecurity.QaUserDetails;
import my.gov.kpn.quiz.core.model.QaActor;
import my.gov.kpn.quiz.core.model.QaInstructor;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.web.common.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

public class AbstractController {

    protected final String MSG_SUCCESS = "msgSuccess";
    protected final String MSG_ERROR = "msgError";

    @Autowired
    protected Transformer transformer;


    private enum SchoolType {
        SMK("SMK"),
        PRIVATE("PRIVATE"),
        SBP("SBP"),
        SMK_TEKNIK("SMK TEKNIK"),
        SMKJ_C("SMKJ(C)"),
        SMKJ_T("SMKJ(T)"),
        SMA("SMA"),
        MRSM("MRSM");

        private String description;

        private SchoolType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


    private enum RaceType {
        MALAY("MELAYU"),
        CHINESE("CINA"),
        INDIAN("INDIA"),
        NATIVE_SABAH("BUMIPUTERA SABAH"),
        NATIVE_SARAWAK("BUMIPUTERA SARAWAK"),
        OTHERS("LAIN LAIN");

        private String description;

        private RaceType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    private enum GenderType {
        MALE("LELAKI"),
        FEMALE("PEREMPUAN");

        private String description;

        private GenderType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    @ModelAttribute("schoolTypeMap")
    public Map<String, String> schoolTypeMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (SchoolType type : SchoolType.values()) {
            map.put(String.valueOf(type.ordinal()), type.getDescription());
        }
        return map;
    }

    @ModelAttribute("genderTypeMap")
    public Map<String, String> genderTypeMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (GenderType type : GenderType.values()) {
            map.put(String.valueOf(type.ordinal()), type.getDescription());
        }
        return map;
    }

    @ModelAttribute("raceTypeMap")
    public Map<String, String> raceTypeMap() {
        Map<String, String> map = new HashMap<String, String>();
        for (RaceType type : RaceType.values()) {
            map.put(String.valueOf(type.ordinal()), type.getDescription());
        }
        return map;
    }

    @ModelAttribute(value = "currentUser")
    protected QaUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            return ((QaUserDetails) auth.getPrincipal()).getUser();
        } else {
            return null;
        }
    }


    protected QaInstructor getCurrentInstructor() {
        QaUser user = getCurrentUser();
        if (null != user) {
            QaActor actor = user.getActor();
            if (null != actor && actor instanceof QaInstructor)
                return (QaInstructor) actor;
        }
        return null;
    }

}
