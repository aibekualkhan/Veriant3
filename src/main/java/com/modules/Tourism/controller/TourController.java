package com.modules.Tourism.controller;

import com.modules.Contact;
import com.modules.Student.EducationalCenter;
import com.modules.Student.service.StudentService;
import com.modules.Tourism.TourPlace;
import com.modules.Tourism.service.TourService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/tourist")
public class TourController {
    @EJB
    TourService service;

    @POST
    @Path("/addTourPlace")
    public Response addTourPlace(@FormParam("placeName") String placeName,
                               @FormParam("address") String address,
                               @FormParam("phone") String phone,
                               @FormParam("email") String email,
                               @FormParam("placeType") String placeType) {
        try {
            Contact contact = new Contact(address, phone, email);
            TourPlace tourPlace = new TourPlace(placeName , placeType, contact);
            service.addTourPlace(tourPlace);
            return Response.ok().entity("success").build();
        } catch (Exception e) {
            e.printStackTrace();
            return  Response.serverError().build();
        }
    }
//    public Response addTourPlace(TourPlace tourPlace) {
//        try {
//            service.addECenter(tourPlace);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return  Response.ok().entity(e.getErrorCode()+ "/"+ e.getSQLState()+ "/"+ e.getMessage()).build();
//        }
//        return Response.ok().entity("success").build();
//    }
}
