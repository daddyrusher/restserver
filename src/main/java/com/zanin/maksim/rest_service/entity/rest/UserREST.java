package com.zanin.maksim.rest_service.entity.rest;

import com.zanin.maksim.rest_service.entity.entity.User;
import com.zanin.maksim.rest_service.entity.registrator.UserRegistrator;
import com.zanin.maksim.rest_service.entity.repository.MessageRepository;
import com.zanin.maksim.rest_service.entity.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@RequestScoped
@Path("/user")
public class UserREST {

    @Inject
    private Logger logger;

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserRegistrator userRegistrator;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUSers(){
        return userRepository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") long id){
        return  userRepository.getById(id);
    }
}