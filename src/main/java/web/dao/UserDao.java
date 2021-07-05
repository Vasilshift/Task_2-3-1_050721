package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> showAllUsers();

    //User show(int id);

    //void add(User user);
}