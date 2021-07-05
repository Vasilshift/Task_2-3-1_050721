package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImp() {
    }

    @Override
    public List<User> showAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

}
