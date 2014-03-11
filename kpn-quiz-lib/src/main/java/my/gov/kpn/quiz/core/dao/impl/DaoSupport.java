package my.gov.kpn.quiz.core.dao.impl;

import my.gov.kpn.quiz.core.model.QaMetaObject;
import my.gov.kpn.quiz.core.model.QaMetaState;
import my.gov.kpn.quiz.core.model.QaMetadata;
import my.gov.kpn.quiz.core.model.QaUser;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public class DaoSupport<K, I, E> implements InitializingBean {

    private static final Logger log = Logger.getLogger(DaoSupport.class);

    public static final String WILDCARD = "%";

    @Autowired(required = true)
    protected SessionFactory sessionFactory;

    // entity
    private Class<I> interfaceClass;
    private Class<E> entityClass;


    @Override
    public void afterPropertiesSet() throws Exception {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        interfaceClass = (Class<I>) genericSuperclass.getActualTypeArguments()[1];
        entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[2];
    }

    public I refresh(I i) {
        sessionFactory.getCurrentSession().refresh(i);
        return i;
    }

    public I findById(K k) {
        Session session = sessionFactory.getCurrentSession();
        return (I) session.get(entityClass, (Serializable) k);
    }

    /**
     * @return
     * @throws org.springframework.dao.DataAccessException
     *
     */
    public List<I> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a "
                + " from " + interfaceClass.getName() + "  a");
        return (List<I>) query.list();
    }

    /**
     * @param offset
     * @param limit
     * @return
     * @throws org.springframework.dao.DataAccessException
     *
     */
    public List<I> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a "
                + " from " + entityClass.getName() + " a");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<I>) query.list();
    }

    protected void prepareMetadata(I i, QaUser user) {

        if (i instanceof QaMetaObject) {
            QaMetadata metadata = null;
            if (((QaMetaObject) i).getMetadata() != null)
                metadata = ((QaMetaObject) i).getMetadata();
            else
                metadata = new QaMetadata();
            metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            metadata.setCreator(user.getId());
            metadata.setState(QaMetaState.ACTIVE);
            ((QaMetaObject) i).setMetadata(metadata);
        }
    }

    /**
     * @param entity
     * @param user
     * @return
     * @throws org.springframework.dao.DataAccessException
     *
     */
    public void save(I entity, QaUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(entity, "Object cannot be null");

        try {
            // session
            Session session = sessionFactory.getCurrentSession();

            // prepare metadata
            prepareMetadata(entity, user);

            // save
            session.save(entity);
        } catch (HibernateException e) {
            log.debug("error occured", e);
        }
    }

    public void save(I entity) {
        Validate.notNull(entity, "User cannot be null");

        try {
            // session
            Session session = sessionFactory.getCurrentSession();

            // prepare metadata

            // save
            session.save(entity);
        } catch (HibernateException e) {
            log.debug("error occured", e);
        }
    }

    /**
     * @param entity
     * @param user
     * @return
     * @throws org.springframework.dao.DataAccessException
     *
     */
    public void saveOrUpdate(I entity, QaUser user) {

        // sanity check
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(entity, "Object cannot be null");

        try {
            // session
            Session session = sessionFactory.getCurrentSession();

            // prepare metadata
            prepareMetadata(entity, user);

            // save
            session.saveOrUpdate(entity);
        } catch (HibernateException e) {
            log.debug("error occured", e);
        }
    }

    public void save(Session session, I i, QaUser user) {

        // sanity check
        // sanity check
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(i, "Object cannot be null");

        // prepare metadata
        prepareMetadata(i, user);

        // save
        session.save(i);
    }

    /**
     * @param entity
     * @param user
     * @return
     * @throws org.springframework.dao.DataAccessException
     *
     */
    public void update(I entity, QaUser user) {

        // sanity check
        // sanity check
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(entity, "Object cannot be null");

        // session
        Session session = sessionFactory.getCurrentSession();

        // prepare metadata
        QaMetadata metadata = ((QaMetaObject) entity).getMetadata();
        if (null == metadata) {
            metadata = new QaMetadata();
            metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            metadata.setCreator(user.getId());
            metadata.setState(QaMetaState.ACTIVE);
        }
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        ((QaMetaObject) entity).setMetadata(metadata);

        // update
        session.update(entity);
    }

    /**
     * @param entity
     * @param user
     * @return
     * @throws org.springframework.dao.DataAccessException
     *
     */
    public void deactivate(I entity, QaUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(entity, "Object cannot be null");

        // session
        Session session = sessionFactory.getCurrentSession();

        // prepare metadata
        QaMetadata metadata = ((QaMetaObject) entity).getMetadata();
        if (null == metadata) {
            metadata = new QaMetadata();
            metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            metadata.setCreator(user.getId());
        }

        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(QaMetaState.INACTIVE);
        ((QaMetaObject) entity).setMetadata(metadata);

        // update
        session.update(entity);
    }

    /**
     * @param entity
     * @param user
     */
    public void remove(I entity, QaUser user) {

        // sanity check
        // sanity check
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(entity, "Object cannot be null");

        // session
        Session session = sessionFactory.getCurrentSession();

        // prepare metadata
        QaMetadata metadata = ((QaMetaObject) entity).getMetadata();
        metadata.setState(QaMetaState.INACTIVE);
        metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setDeleter(user.getId());
        ((QaMetaObject) entity).setMetadata(metadata);

        // update
        session.update(entity);
    }

    public void delete(I entity, QaUser user) {

        // sanity check
        // sanity check
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(entity, "Object cannot be null");

        // session
        Session session = sessionFactory.getCurrentSession();

        // update
        session.delete(entity);
    }
}