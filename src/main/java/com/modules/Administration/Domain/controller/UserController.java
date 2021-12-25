package com.modules.Administration.Domain.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.modules.Administration.Domain.User;
import com.modules.Administration.Domain.service.UserService;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

@Path("/user")
public class UserController {
    @EJB
    UserService service;

    @GET
    @Path("/{id}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClient(@PathParam("id") Long id) {
        try {
            return  Response
                    .status(Response.Status.OK)
                    .entity(jsonParserFromObject(service.getUserById(id)))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            String message = "User not found";
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(message)
                    .build();
        }
    }

    @GET
    @Path("/getAll")
    @RolesAllowed("ADMIN")
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

    @POST
    @RolesAllowed("USER")
    @Path("/login")
    public Response addUser(@FormParam("username") String username,
                            @FormParam("password") String password,
                            @FormParam("usertype") String usertype){
        try {
            User user = new User(username, password, usertype );
            service.addUser(user);
            return Response.ok("SUCCESS").build();
        }catch (Exception e ){
            return  Response.serverError().build();
        }
    }

    @PUT
    @Path("/update/{id}")
    @DenyAll
    public Response updateClient(@FormParam("firstName") String name, @PathParam("id") Long id) {
        try {
            service.updateUsername(id, name);
            return Response.ok("SUCCESS").build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @RolesAllowed({"ADMIN"})
    public Response deleteById(@PathParam("id") Long id) {
        try {
            service.deleteUser(id);
            return Response.ok("SUCCESS").build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

//    public Response authenticateUser(User user) throws SQLException {
//        User user = null;
//        String data = null;
//        try{
//            user.setId(1);
//            user.setUsername(login);
//            user.setPassword(password);
//            data = new ObjectMapper().writeValueAsString(user);
//            service.addUser(user);
//        }catch(Exception e){
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                    .entity("Error"+e.getMessage()).build();
//        }
//        service.addUser(user);
//        return Response.ok().entity("success").build();
//    }

    public String jsonParserFromObject(User user) throws JsonProcessingException {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", user.getId());
        map.put("username", user.getUsername());
        map.put("lastName", user.getPassword());
        map.put("usertype", user.getUsertype());
        ObjectMapper objectMapper =
                new ObjectMapper();
        //objectMapper.findAndRegisterModules().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper.writeValueAsString(map);
    }
}
