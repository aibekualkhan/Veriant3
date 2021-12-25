package com.modules.Jobseekers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.modules.Contact;
import com.modules.Jobseekers.Vacancy;
import com.modules.Jobseekers.service.VacancyService;
import com.modules.Student.EducationalCenter;
import com.modules.Student.service.StudentService;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vacancies")
public class VacancyContoller {
    @EJB
    VacancyService service;

    @POST
    @Path("/addVacancy")
    public Response addVacancy(@FormParam("jobName") String jobName,
                               @FormParam("specialization") String spc,
                               @FormParam("salary") double salary,
                               @FormParam("address") String address,
                               @FormParam("phone") String phone,
                               @FormParam("email") String email) {
        try {
            Contact contact = new Contact(address, phone, email);
            Vacancy vacancy = new Vacancy(jobName , spc, salary, contact);
            service.addVacancy(vacancy);
            return Response.ok().entity("success").build();
        } catch (Exception e) {
            e.printStackTrace();
            return  Response.serverError().build();
        }
    }
    @GET
    @Path("/getAll")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUser() {
        try {
            return  Response
                    .status(Response.Status.OK)
                    .entity(new ObjectMapper().writeValueAsString(service.getAll()))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }


}
