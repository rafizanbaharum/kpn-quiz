package my.gov.kpn.quiz.web.common;

import my.gov.kpn.quiz.biz.manager.InstructorManager;
import my.gov.kpn.quiz.core.model.*;
import my.gov.kpn.quiz.web.model.*;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component("transformer")
public class
        Transformer {

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

    public List<CompetitionModel> transformCompetitions(List<QaCompetition> competitions) {
        List<CompetitionModel> models = new ArrayList<CompetitionModel>();
        if (null != competitions) {
            for (QaCompetition competition : competitions) {
                models.add(transform(competition));
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

    public List<ParticipantModel> transformParticipants(List<QaParticipant> participants) {
        List<ParticipantModel> models = new ArrayList<ParticipantModel>();
        if (null != participants) {
            for (QaParticipant participant : participants) {
                models.add(transform(participant));
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

    public List<StudentModel> transformStudents(List<QaStudent> students) {
        List<StudentModel> models = new ArrayList<StudentModel>();
        if (null != students) {
            for (QaStudent student : students) {
                models.add(transform(student));
            }
        }
        return models;
    }

    public List<InstructorModel> transformInstructors(List<QaInstructor> instructors) {
        List<InstructorModel> models = new ArrayList<InstructorModel>();
        if (null != instructors) {
            for (QaInstructor instructor : instructors) {
                models.add(transform(instructor));
            }
        }
        return models;
    }

    public UserModel transform(QaUser user) {
        UserModel model = new UserModel();
        model.setId(user.getId());
        model.setName(user.getName());
        model.setUsername(user.getUsername());
        model.setPassword(user.getPassword());
        model.setPasswordAgain(user.getPassword());
        return model;
    }


    public CompetitionModel transform(QaCompetition competition) {
        LocalDateTime startDate = new LocalDateTime(competition.getStartDate());
        LocalDateTime endDate = new LocalDateTime(competition.getEndDate());
        CompetitionModel model = new CompetitionModel();
        model.setId(competition.getId());
        model.setYear(competition.getYear());
        // restriction
        model.setYearConstraint(competition.getYearConstraint());
        model.setStartConstraint(competition.getStartConstraint());
        model.setEndConstraint(competition.getEndConstraint());

        model.setStartDate(competition.getStartDate());
        model.setEndDate(competition.getEndDate());
        model.setStartDate_dd(String.valueOf(startDate.getDayOfMonth()));
        model.setStartDate_MM(String.valueOf(startDate.getMonthOfYear()));
        model.setStartDate_yyyy(String.valueOf(startDate.getYear()));
        model.setEndDate_dd(String.valueOf(endDate.getDayOfMonth()));
        model.setEndDate_MM(String.valueOf(endDate.getMonthOfYear()));
        model.setEndDate_yyyy(String.valueOf(endDate.getYear()));
        model.setLocked(competition.isLocked());
        return model;
    }

    public QuizModel transform(QaQuiz quiz) {
        LocalDateTime startDate = new LocalDateTime(quiz.getStartDate());
        LocalDateTime endDate = new LocalDateTime(quiz.getEndDate());
        QuizModel model = new QuizModel();
        model.setId(quiz.getId());
        model.setTitle(quiz.getTitle());
        model.setRound(quiz.getRound().toString());
        model.setStartDate(quiz.getStartDate());
        model.setEndDate(quiz.getEndDate());
        model.setCurrent(quiz.isCurrent());
        model.setProcessed(quiz.isProcessed());
        model.setLocked(quiz.isLocked());
        model.setStartDate_hh(String.valueOf(startDate.getHourOfDay()));
        model.setStartDate_mm(String.valueOf(startDate.getMinuteOfHour()));
        model.setStartDate_dd(String.valueOf(startDate.getDayOfMonth()));
        model.setStartDate_MM(String.valueOf(startDate.getMonthOfYear()));
        model.setStartDate_yyyy(String.valueOf(startDate.getYear()));
        model.setEndDate_hh(String.valueOf(endDate.getHourOfDay()));
        model.setEndDate_mm(String.valueOf(endDate.getMinuteOfHour()));
        model.setEndDate_dd(String.valueOf(endDate.getDayOfMonth()));
        model.setEndDate_MM(String.valueOf(endDate.getMonthOfYear()));
        model.setEndDate_yyyy(String.valueOf(endDate.getYear()));

        return model;
    }

    public QuestionModel transform(QaQuestion question) {
        QuestionModel model = null;
        switch (question.getQuestionType()) {
            case MULTIPLE_CHOICE:
                model = new MultipleChoiceQuestionModel();
                ((MultipleChoiceQuestionModel) model).setChoice1(((QaMultipleChoiceQuestion) question).getChoice1());
                ((MultipleChoiceQuestionModel) model).setChoice2(((QaMultipleChoiceQuestion) question).getChoice2());
                ((MultipleChoiceQuestionModel) model).setChoice3(((QaMultipleChoiceQuestion) question).getChoice3());
                ((MultipleChoiceQuestionModel) model).setChoice4(((QaMultipleChoiceQuestion) question).getChoice4());
                break;
            case BOOLEAN:
                model = new BooleanQuestionModel();
                break;
            case SUBJECTIVE:
                model = new SubjectiveQuestionModel();
                ((SubjectiveQuestionModel) model).setAnswerGuide(((QaSubjectiveQuestion) question).getAnswerGuide());
                ((SubjectiveQuestionModel) model).setWordLimit(((QaSubjectiveQuestion) question).getWordLimit());
                break;
        }
        model.setId(question.getId());
        model.setStatement(question.getStatement());
        model.setAnswerIndex(question.getAnswerIndex());
        model.setQuestionType(question.getQuestionType().ordinal());
        model.setQuestionTypeString(question.getQuestionType().getDesc());
        model.setDifficulty(question.getDifficulty().ordinal());
        return model;
    }

    public ParticipantModel transform(QaParticipant participant) {
        ParticipantModel model = new ParticipantModel();
        QaStudent student = (QaStudent) participant.getUser().getActor();
        model.setId(participant.getId());
        model.setResult(participant.getResult());
        model.setSelected(participant.isSelected());
        model.setAnswerResponse(participant.getAnswerResponse());
        if (null != student) {
            model.setName(student.getName());
            model.setAddress1(student.getAddress1());
            model.setAddress2(student.getAddress2());
            model.setAddress3(student.getAddress3());
            model.setSchool(student.getSchoolName());
            model.setDistrict(student.getDistrictName());
            model.setState(student.getState().getName());
        }
        return model;
    }

    public ActorModel transform(QaActor actor) {
        ActorModel model = null;
        switch (actor.getActorType()) {
            case INSTRUCTOR:
                model = transform((QaInstructor) actor);
                break;
            case STUDENT:
                model = transform((QaStudent) actor);
                break;
            case SUPPORT:
                model = transform((QaSupport) actor);
                break;
        }
        return model;
    }

    public StudentModel transform(QaStudent student) {
        LocalDate dob = new LocalDate(student.getDob());
        StudentModel model = new StudentModel();
        QaUser user = instructorManager.findUserByActor(student);
        model.setId(student.getId());
        model.setName(student.getName());
        model.setNricNo(student.getNricNo());
        model.setUsername(user.getUsername());
        model.setPassword(user.getPassword());
        model.setPasswordAgain(user.getPassword());
        model.setDob(student.getDob());
        model.setDob_dd(String.valueOf(dob.getDayOfMonth()));
        model.setDob_mm(String.valueOf(dob.getMonthOfYear()));
        model.setDob_yyyy(String.valueOf(dob.getYear()));
        model.setSchoolName(student.getSchoolName());
        if (null != student.getGenderType()){
            model.setGenderType(String.valueOf(student.getGenderType().ordinal()));
            model.setGenderTypeName(student.getGenderType().getDescription());
        }
        if (null != student.getRaceType()){
            model.setRaceType(String.valueOf(student.getRaceType().ordinal()));
            model.setRaceTypeName(student.getRaceType().getDescription());
        }
        if (null != student.getState())
            model.setStateName(student.getState().getName());
        return model;
    }

    public InstructorModel transform(QaInstructor instructor) {
        InstructorModel model = new InstructorModel();
        QaUser user = instructorManager.findUserByActor(instructor);
        model.setId(instructor.getId());
        model.setUsername(user.getUsername());
        model.setName(instructor.getName());
        model.setNricNo(instructor.getNricNo());
        model.setAddress1(instructor.getAddress1());
        model.setAddress2(instructor.getAddress2());
        model.setAddress3(instructor.getAddress3());
        model.setSchoolName(instructor.getSchoolName());
        model.setSchoolPhone(instructor.getSchoolPhone());
        model.setSchoolType(instructor.getSchoolType().name());
        if (null != instructor.getState())
            model.setStateName(instructor.getState().getName());
        return model;
    }

    public SupportModel transform(QaSupport support) {
        SupportModel model = new SupportModel();
        QaUser user = instructorManager.findUserByActor(support);
        model.setId(support.getId());
        model.setUsername(user.getUsername());
        model.setName(support.getName());
        model.setNricNo(support.getNricNo());
        model.setAddress1(support.getAddress1());
        model.setAddress2(support.getAddress2());
        model.setAddress3(support.getAddress3());
        return model;
    }
}
