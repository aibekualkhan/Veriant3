package com.modules.Tourism.service;

import com.modules.Student.EducationalCenter;
import com.modules.Student.repository.StudentRepository;
import com.modules.Tourism.TourPlace;
import com.modules.Tourism.repository.TourRepository;
import com.modules.database.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.SQLException;

@Stateless
public class TourService {
    @EJB
    TourRepository tourRepository;

    public void addTourPlace(TourPlace tourPlace) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        tourRepository.addTourPlace(tourPlace, session);
        transaction.commit();
        session.close();
    }
}
