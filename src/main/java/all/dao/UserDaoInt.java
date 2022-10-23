package all.dao;

import all.models.User;

import java.util.List;

public interface UserDaoInt {

    List<User> index();
    User show(int id);
    void save(User user);
    void update(User updatedUser);
    void delete(int id);

}