package com.modules.Jobseekers.service;

import com.modules.Administration.Domain.User;
import com.modules.Jobseekers.Vacancy;
import com.modules.Jobseekers.repository.VacancyRepository;
import com.modules.Student.EducationalCenter;
import com.modules.Student.repository.StudentRepository;
import com.modules.database.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class VacancyService {
    @EJB
    VacancyRepository vacancyRepository;

    public void addVacancy(Vacancy vacancy){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        vacancyRepository.addVacancy(vacancy, session);
        transaction.commit();
        session.close();
    }

    public List<Vacancy> getAll() {
        return vacancyRepository.getAll(HibernateSessionFactoryUtil.getSessionFactory().openSession());
    }
}
