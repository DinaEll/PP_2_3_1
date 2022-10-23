package all.dao;

import all.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    //@Override
    public List<User> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from User p", User.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    //@Override
    public User show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Transactional
    //@Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Transactional
    //@Override
    public void update(int id, User updatedUser) {
        Session session = sessionFactory.getCurrentSession();
        User userToBeUpdated = session.get(User.class, id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Transactional
    //@Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(User.class, id));
    }
}
