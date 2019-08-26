package vn.dvg.autoportal.restapi.controllers;


import lombok.val;
import vn.dvg.autoportal.data.dao.ApplicationDao;
import vn.dvg.autoportal.data.dao.UserDao;
import vn.dvg.autoportal.restapi.models.application.ApplicationResponse;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dvg-autoportal/api/v1/applications")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationController {
//    @Inject
    private ApplicationDao applicationDao;
//    @Inject
    private UserDao userDao;

    @Inject
    public ApplicationController(
        ApplicationDao applicationDao,
        UserDao userDao
    ){
        this.applicationDao = applicationDao;
        this.userDao = userDao;
    }

    @GET
    @Path("getById")
    public ApplicationResponse getById(){
        val dto = applicationDao.getById(1);
        val responseModel = new ApplicationResponse();
        responseModel.setId(dto.getId());
        responseModel.setName(dto.getName());
        responseModel.setCreatedAt(dto.getCreatedAt());
        responseModel.setModifiedAt(dto.getModifiedAt());
        return responseModel;
    }

    @GET
    @Path("test")
    public String test(){
        val result = userDao.test();
        return result;
    }
}
