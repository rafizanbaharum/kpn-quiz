package my.gov.kpn.quiz.core.dao;

import my.gov.kpn.quiz.core.exception.LockedGroupException;
import my.gov.kpn.quiz.core.exception.RecursiveGroupException;
import my.gov.kpn.quiz.core.model.*;

import java.util.List;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 11/9/13
 */
public interface QaGroupDao {

    // finders

    QaGroup findById(Long id);

    QaGroup findByName(String name);

    List<QaGroup> findAll();

    List<String> findAllGroupName();

    List<QaPrincipal> findMembers(QaGroup group);

    List<QaPrincipal> findMembers(QaGroup group, QaPrincipalType type);

    List<QaGroup> findMemberships(QaPrincipal principal);

    List<QaPrincipal> findMembers(QaGroup group, Integer offset, Integer limit);

    List<QaGroup> find(Integer offset, Integer limit);

    List<QaGroup> find(String filter, Integer offset, Integer limit);

    List<QaGroup> findParentGroup(QaGroup group);

    Set<QaGroup> findHierarchicalGroupAsNative(QaPrincipal principal);

    QaGroupMember findGroupMember(QaGroup group, QaPrincipal principal);

    Integer count();

    Integer count(String filter);

    boolean isMemberOf(QaGroup group, QaPrincipal principal);

    void save(QaGroup group, QaUser user);

    void update(QaGroup group, QaUser user);

    void deactivate(QaGroup group, QaUser user);

    void remove(QaGroup group, QaUser user) throws LockedGroupException;

    void addMember(QaGroup group, QaPrincipal principal, QaUser user) throws RecursiveGroupException, LockedGroupException;

    void addMembers(QaGroup group, List<QaPrincipal> principals, QaUser user) throws RecursiveGroupException, LockedGroupException;

    void removeMember(QaGroup group, QaPrincipal principal) throws LockedGroupException;

}
