package com.modules.database;

import com.modules.Administration.Domain.User;
import com.modules.Business.Industry;
import com.modules.Contact;
import com.modules.Jobseekers.Vacancy;
import com.modules.Student.EducationalCenter;
import com.modules.Tourism.TourPlace;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(TourPlace.class);
                configuration.addAnnotatedClass(EducationalCenter.class);
                configuration.addAnnotatedClass(Contact.class);
                configuration.addAnnotatedClass(Vacancy.class);
                configuration.addAnnotatedClass(Industry.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}
