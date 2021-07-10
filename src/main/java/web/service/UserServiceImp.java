package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Override
    public User showOneUser(int id) {
        return userDao.showOneUser(id);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }
}
