package all.dao;

import all.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    public List<User> index() {
        return entityManager.createQuery("select p from User p", User.class).getResultList();
    }

    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    public void delete(int id) {
       User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

}
