package all.service;

import all.dao.UserDao;
import all.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDaoInt;

    @Autowired
    public UserServiceImpl(UserDao userDaoInt) {
        this.userDaoInt = userDaoInt;
    }

    @Transactional
    @Override
    public List<User> index() {
        return this.userDaoInt.index();
    }

    @Transactional(readOnly = true)
    @Override
    public User show(int id) {
        return this.userDaoInt.show(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDaoInt.save(user);
    }

    @Transactional
    @Override
    public void update(User updatedUser) {
        userDaoInt.update(updatedUser);
    }

    @Transactional
    @Override
    public void delete(int id) {
        this.userDaoInt.delete(id);
    }

}
