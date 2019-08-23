package vn.hoinx.experience.controllers;

import lombok.val;
import vn.hoinx.experience.models.user.UserResponse;
import vn.hoinx.experience.services.UserService;
import vn.hoinx.experience.services.impl.UserServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dvg-autoportal/api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    private UserService userService;

    @GET
    @Path("/{id}")
    public UserResponse GetUserById(@PathParam("id") String id){
        val user = new UserResponse();
        user.setName("Nguyễn Xuân Hồi");
        user.setPhoneNumber("01234343434");
        user.setAvatarUrl("http://google.com.vn");
        return user;
    }

    @GET
    public UserResponse GetUser(){
        val user = new UserResponse();
        user.setName("Nguyễn Xuân Hồi");
        user.setPhoneNumber("01234343434");
        user.setAvatarUrl("http://google.com.vn");
        return user;
    }

    @GET
    @Path("/test")
    public String test(){
        val result = userService.test();
        return result;
    }
}
