package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.model.QaUser;
import org.hibernate.Session;

import java.util.List;

public interface DaoSupport<K, I, E> {

    public I findById(K k);

    public List<I> find();

    public List<I> find(Integer offset, Integer limit);

    public void save(I entity, QaUser user);

    public void saveOrUpdate(I entity, QaUser user);

    public void save(Session session, I i, QaUser user);

    public void update(I entity, QaUser user);

    public void deactivate(I entity, QaUser user);

    public void remove(I entity, QaUser user);
}
