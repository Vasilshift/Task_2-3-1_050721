package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> showAllUsers();

    void add(User user);
}