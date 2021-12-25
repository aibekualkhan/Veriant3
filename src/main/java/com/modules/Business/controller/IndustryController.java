package com.modules.Business.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.modules.Administration.Domain.User;
import com.modules.Business.Industry;
import com.modules.Business.service.IndustryService;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Path("/Business")
public class IndustryController {

    @EJB
    IndustryService service;

    @POST
    @Path("/addIndustry")
    public Response addIndustry(@FormParam("industry_name") String iName,
                                @FormParam("newsTitle") String newsTitle,
                                @FormParam("news") String news){
        try {
            Industry industry = new Industry(iName, newsTitle, news);
            service.addIndustry(industry);
            return Response.ok().build();
        }catch (Exception e ){
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

    public String jsonParserFromObject(Industry industry) throws JsonProcessingException {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", industry.getId());
        map.put("iName", industry.getIndustry_name());
        map.put("News", industry.getNews());
        ObjectMapper objectMapper =
                new ObjectMapper();
        objectMapper.findAndRegisterModules().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper.writeValueAsString(map);
    }
}
