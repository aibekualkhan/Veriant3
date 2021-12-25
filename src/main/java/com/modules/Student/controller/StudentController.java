package com.modules.Student.controller;

import com.modules.Administration.Domain.User;
import com.modules.Contact;
import com.modules.Student.EducationalCenter;
import com.modules.Student.service.StudentService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;


@Path("/student")
public class StudentController {
    @EJB
    StudentService service;

    @POST
    @Path("/addECenter")
    public Response addECenter(@FormParam("ecName") String ecName,
                               @FormParam("address") String address,
                               @FormParam("phone") String phone,
                               @FormParam("email") String email,
                               @FormParam("type") String type) {
        try {
            Contact contact = new Contact(address, phone, email);
            EducationalCenter educationalCenter = new EducationalCenter(ecName , type, contact);
            service.addECenter(educationalCenter);
            return Response.ok().entity("success").build();
        } catch (Exception e) {
            e.printStackTrace();
            return  Response.serverError().build();
        }
    }
}
