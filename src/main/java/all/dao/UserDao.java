package all.dao;

import all.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDao() {
    }

    @Transactional(readOnly = true)
    public List<User> index() {
        return entityManager.createQuery("select p from User p", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Transactional
    public void delete(int id) {
       User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

}
