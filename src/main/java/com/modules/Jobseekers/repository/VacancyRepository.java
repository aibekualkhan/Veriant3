package com.modules.Jobseekers.repository;

import com.modules.Administration.Domain.User;
import com.modules.Jobseekers.Vacancy;
import org.hibernate.Session;

import javax.ejb.Stateful;
import java.util.List;

@Stateful
public class VacancyRepository {
    public void addVacancy(Vacancy vacancy, Session session){
        session.save(vacancy);
    }
    public List<Vacancy> getAll(Session session){
        return session.createQuery("SELECT a FROM Vacancy a", Vacancy.class).getResultList();
    }
}
