package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.dao.QaMetaObjectDao;
import my.gov.kpn.quiz.core.model.QaMetaObject;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
@SuppressWarnings({"unchecked"})
@Repository("objectDao")
public class QaMetaObjectDaoImpl implements QaMetaObjectDao {

        private static final Logger log = Logger.getLogger(QaMetaObjectDaoImpl.class);

        @Autowired(required = true)
        protected SessionFactory sessionFactory;

        @Override
        public QaMetaObject findObjectById(String entityName, Long id) {
            Session session = sessionFactory.getCurrentSession();
            return (QaMetaObject) session.get(entityName, id);
        }
    }
