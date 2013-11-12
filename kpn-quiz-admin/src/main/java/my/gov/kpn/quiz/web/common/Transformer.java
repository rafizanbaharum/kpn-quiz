package my.gov.kpn.quiz.web.common;

import my.gov.kpn.quiz.core.model.QaState;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("transformer")
public class Transformer {

    public Map<String,String> transformToDropDown(List<QaState> states){
        Map<String,String> maps = new LinkedHashMap<String, String>();

        for (QaState state : states) {
            maps.put(state.getId().toString(),state.getName());
        }
       return maps;
    }
}
