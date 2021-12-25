package com.modules;

import com.modules.Administration.Domain.User;
import com.modules.JmsService;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/jms")
public class JmsController {
    @EJB
    private JmsService jmsService;

    @POST
    @PermitAll
    @Path("/addClient")
    public String addClient(@FormParam("username") String username,
                            @FormParam("password") String password,
                            @FormParam("usertype") String usertype) {
        User user = new User(username, password, usertype);
        return jmsService.sendJmsMessage(user);
    }

    @GET
    @Path("/getClient")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public User getClient() {
        return jmsService.getMessage();
    }

    @POST
    @PermitAll
    @Path("/client/secondJMS")
    public String addClientSecondJms(@FormParam("username") String username,
                                     @FormParam("password") String password,
                                     @FormParam("usertype") String usertype) {
        User user = new User(username, password, usertype);
        return jmsService.sendJmsMessageSecond(user);
    }

    @GET
    @PermitAll
    @Path("/client/secondJMS")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getStudentsFromSecondJMS() {
        User user;
        ArrayList<User> result = new ArrayList<>();
        do {
            user = jmsService.getMessageSecond();
            if (user != null) {
                result.add(user);
            }
        } while (user != null);
        return result;
    }
}
