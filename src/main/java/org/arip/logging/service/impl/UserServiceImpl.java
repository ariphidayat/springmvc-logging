package org.arip.logging.service.impl;

import org.arip.logging.model.User;
import org.arip.logging.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Arip Hidayat on 12/9/2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    @Transactional
    public User update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        return user;
    }

    @Transactional
    public User delete(String id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        return user;
    }

    @Transactional(readOnly = true)
    public User getUser(String id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);

        return user;
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createCriteria(User.class).list();

        return users;
    }
}
