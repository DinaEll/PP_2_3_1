package all.service;

import all.dao.UserDaoImpl;
import all.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDaoImplInt;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDaoImplInt) {
        this.userDaoImplInt = userDaoImplInt;
    }

    @Transactional
    @Override
    public List<User> index() {
        return this.userDaoImplInt.index();
    }

    @Transactional(readOnly = true)
    @Override
    public User show(int id) {
        return this.userDaoImplInt.show(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDaoImplInt.save(user);
    }

    @Transactional
    @Override
    public void update(User updatedUser) {
        userDaoImplInt.update(updatedUser);
    }

    @Transactional
    @Override
    public void delete(int id) {
        this.userDaoImplInt.delete(id);
    }

}
