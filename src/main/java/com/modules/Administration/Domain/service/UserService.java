package com.modules.Administration.Domain.service;

import com.modules.Administration.Domain.User;
import com.modules.Administration.Domain.repository.UserRepository;
import com.modules.database.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class UserService {

    @EJB
    UserRepository userRepository;

    public void addUser(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction =session.beginTransaction();
        userRepository.addUser(user, session);
        transaction.commit();
        session.close();
    }
    public List<User> getAll() {
        return userRepository.getAll(HibernateSessionFactoryUtil.getSessionFactory().openSession());
    }
    public User getUserById(Long id) {
        return userRepository.getUserById(id, HibernateSessionFactoryUtil.getSessionFactory().openSession());
    }
    public void updateUsername(Long id, String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        User user = userRepository.getUserById(id, session);
        user.setUsername(name);
        userRepository.update(user,session);
        tx1.commit();
        session.close();
    }
    public void deleteUser(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        User user = userRepository.getUserById(id,session);
        userRepository.delete(user, session);
        tx1.commit();
        session.close();
    }
}
