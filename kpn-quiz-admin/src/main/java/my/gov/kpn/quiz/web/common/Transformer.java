package my.gov.kpn.quiz.web.common;

import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.core.model.QaState;
import my.gov.kpn.quiz.core.model.QaStudent;
import my.gov.kpn.quiz.core.model.QaUser;
import my.gov.kpn.quiz.web.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("transformer")
public class Transformer {

    @Autowired
    private InstructorManager instructorManager;

    public Map<String,String> transformToDropDown(List<QaState> states){
        Map<String,String> maps = new LinkedHashMap<String, String>();

        for (QaState state : states) {
            maps.put(state.getId().toString(),state.getName());
        }
       return maps;
    }


    public List<StudentModel> transform(List<QaStudent> students){
        List<StudentModel> models = new ArrayList<StudentModel>();
        if (null != students) {
            for (QaStudent student : students) {
                models.add(transform(student));
            }
        }

        return models;
    }

    public StudentModel transform(QaStudent student) {

        StudentModel model = new StudentModel();
        QaUser user = instructorManager.findUserByActor(student);
        model.setName(student.getName());
        model.setUsername(user.getUsername());
        return model;
    }
}
