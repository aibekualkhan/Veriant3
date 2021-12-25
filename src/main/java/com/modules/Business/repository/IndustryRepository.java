package com.modules.Business.repository;

import com.modules.Administration.Domain.User;
import com.modules.Business.Industry;
import org.hibernate.Session;

import javax.ejb.Stateful;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Stateful
public class IndustryRepository {

    public List<Industry> getAll(Session session){
        return session.createQuery("SELECT a FROM Industry a", Industry.class).getResultList();
    }

    public void addIndustry(Industry industry, Session session){
        session.save(industry);
    }

}
