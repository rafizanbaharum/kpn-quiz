package my.gov.kpn.quiz.biz.manager;

import my.gov.kpn.quiz.biz.util.Utils;
import my.gov.kpn.quiz.core.dao.*;
import my.gov.kpn.quiz.core.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/10/13
 */
@Component("quizManager")
@Transactional
public class QuizManagerImpl implements QuizManager {

    @Autowired
    private QaCompetitionDao competitionDao;

    @Autowired
    private QaQuizDao quizDao;

    @Autowired
    private QaRoundDao roundDao;

    @Autowired
    private QaQuestionDao questionDao;

    @Autowired
    private QaParticipantDao participantDao;

    @Autowired
    private QaGradebookDao gradebookDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void setCurrentQuiz(QaQuiz quiz) {
        // reset all others
        List<QaQuiz> all = quizDao.findAll();
        for (QaQuiz q : all) {
            q.setCurrent(false);
        }
        sessionFactory.getCurrentSession().flush();

        // reset the one we want
        quiz.setCurrent(true);
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public QaQuiz getCurrentQuiz() {
        return quizDao.findCurrent();
    }

    @Override
    public QaParticipant findParticipant(QaQuiz quiz, QaUser user) {
        return participantDao.find(quiz.getRound(), user);
    }

    @Override
    public QaQuiz findQuizById(Long id) {
        return quizDao.findById(id);
    }

    @Override
    public QaCompetition findCompetitionById(Long id) {
        return competitionDao.findById(id);
    }

    @Override
    public QaCompetition findCompetitionByYear(int year) {
        return competitionDao.findByYear(year);
    }

    @Override
    public QaRound findRoundById(Long id) {
        return roundDao.findById(id);
    }

    @Override
    public QaQuestion findQuestionById(Long id) {
        return questionDao.findById(id);
    }

    @Override
    public List<QaRound> findRounds() {
        return roundDao.findAll();
    }

    @Override
    public List<QaQuestion> findQuestions(QaQuiz quiz) {
        return quizDao.findQuestions(quiz);
    }

    @Override
    public void updateAnswer(QaParticipant participant, QaQuestion question) {
    }

    @Override
    public void addRound(QaRound round) {
        roundDao.save(round, Utils.getCurrentUser());
    }
}
