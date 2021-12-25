package com.modules.Business.service;


import com.modules.Administration.Domain.User;
import com.modules.Business.Industry;
import com.modules.Business.repository.IndustryRepository;
import com.modules.database.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.util.List;

@Stateful
public class IndustryService {
    @EJB
    IndustryRepository industryRepository;

    public void addIndustry(Industry industry){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction =session.beginTransaction();
        industryRepository.addIndustry(industry, session);
        transaction.commit();
        session.close();
    }
    public List<Industry> getAll() {
        return industryRepository.getAll(HibernateSessionFactoryUtil.getSessionFactory().openSession());
    }
}
