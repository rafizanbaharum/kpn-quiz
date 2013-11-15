package my.gov.kpn.quiz.web.common;

import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component("transformer")
public class Transformer {

    @Autowired
    private InstructorManager instructorManager;

    public Map<String, String> transformStatesToDropDown(List<QaState> states) {
        Map<String, String> maps = new LinkedHashMap<String, String>();
        for (QaState state : states) {
            maps.put(state.getId().toString(), state.getName());
        }
        return maps;
    }

    public Map<String, String> transformQuizToDropDown(List<QaQuiz> quizzes) {
        Map<String, String> maps = new LinkedHashMap<String, String>();
        for (QaQuiz quiz : quizzes) {
            maps.put(quiz.getId().toString(), quiz.getTitle());
        }
        return maps;
    }

    public List<StudentModel> transformStudents(List<QaStudent> students) {
        List<StudentModel> models = new ArrayList<StudentModel>();
        if (null != students) {
            for (QaStudent student : students) {
                models.add(transform(student));
            }
        }
        return models;
    }

    public List<CompetitionModel> transformCompetitions(List<QaCompetition> competitions) {
        List<CompetitionModel> models = new ArrayList<CompetitionModel>();
        if (null != competitions) {
            for (QaCompetition competition : competitions) {
                models.add(transform(competition));
            }
        }
        return models;
    }

    public List<RoundModel> transformRounds(List<QaRound> rounds) {
        List<RoundModel> models = new ArrayList<RoundModel>();
        if (null != rounds) {
            for (QaRound student : rounds) {
                models.add(transform(student));
            }
        }
        return models;
    }


    public List<QuestionModel> transformQuestions(List<QaQuestion> questions) {
        List<QuestionModel> models = new ArrayList<QuestionModel>();
        if (null != questions) {
            for (QaQuestion question : questions) {
                models.add(transform(question));
            }
        }
        return models;
    }

    public List<QuizModel> transformQuizzes(List<QaQuiz> quizzes) {
        List<QuizModel> models = new ArrayList<QuizModel>();
        if (null != quizzes) {
            for (QaQuiz quiz : quizzes) {
                models.add(transform(quiz));
            }
        }
        return models;
    }

    public StudentModel transform(QaStudent student) {
        StudentModel model = new StudentModel();
        QaUser user = instructorManager.findUserByActor(student);
        model.setName(student.getName());
        model.setNric(student.getNricNo());
        model.setUsername(user.getUsername());
        return model;
    }

    public CompetitionModel transform(QaCompetition competition) {
        CompetitionModel model = new CompetitionModel();
        model.setId(competition.getId());
        model.setYear(competition.getYear());
        return model;
    }

    public RoundModel transform(QaRound round) {
        RoundModel model = new RoundModel();
        model.setId(round.getId());
        model.setName(round.getName());
        model.setProcessed(round.isProcessed());
        model.setLocked(round.isLocked());
        return model;
    }

    public QuizModel transform(QaQuiz quiz) {
        QuizModel model = new QuizModel();
        model.setId(quiz.getId());
        model.setTitle(quiz.getTitle());
        model.setStartDate(quiz.getStartDate());
        model.setEndDate(quiz.getEndDate());
        return model;
    }

    public QuestionModel transform(QaQuestion question) {
        QuestionModel model = new QuestionModel();
        model.setId(question.getId());
        model.setStatement(question.getStatement());
        return model;
    }
}
