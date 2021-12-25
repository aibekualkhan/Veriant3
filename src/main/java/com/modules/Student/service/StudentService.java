package com.modules.Student.service;

import com.modules.Administration.Domain.User;
import com.modules.Student.EducationalCenter;
import com.modules.Student.repository.StudentRepository;
import com.modules.database.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.SQLException;

@Stateless
public class StudentService {
    @EJB
    StudentRepository studentRepository;

    public void addECenter(EducationalCenter educationalCenter){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        studentRepository.addStudent(educationalCenter, session);
        transaction.commit();
        session.close();
    }
//    public void addECenter(EducationalCenter eCenter) throws SQLException {
//        studentRepository.addStudent(eCenter);
//    }
}
