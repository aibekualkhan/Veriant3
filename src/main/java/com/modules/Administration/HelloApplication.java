package com.modules.Administration;

import com.modules.Administration.Domain.User;
import com.modules.database.Database;
import com.modules.database.HibernateSessionFactoryUtil;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationPath("/api")
public class HelloApplication extends Application {
    @GET
    @Path("/")
    public String hello(){
        HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return "Hello";
    }
}