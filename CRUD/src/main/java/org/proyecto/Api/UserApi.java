package org.proyecto.Api;

import org.proyecto.Entity.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import javax.annotation.security.RolesAllowed;
@Path("/api/User")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "User" ,description = "Here is all the information about User. ")
public class UserApi {

    @Inject
    EntityManager entityManager;

    @POST
    @Transactional
    public void add(User user) {
        User.persist(user);
    }

    @GET
    @Path("/All")
    public List<User> getAllUser(){
        return User.listAll();
    }

    @GET
    public Boolean getUser(@QueryParam("Username") String username,@QueryParam("Password") String password){
        //TODO need fixing, if password duplicated it will fail on search
        if(User.find("username", username).firstResult().equals(User.find("password", password).firstResult())){
            //return User.find("username", username).firstResult();
            return true;
        }
        return false;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public User update(@PathParam("id") long id, User user){
        if (user.findById(id) == null) {
            throw new WebApplicationException("Id no fue enviado en la peticion.", 422);
        }

        User entity = entityManager.find(User.class,id);

        if (entity == null) {
            throw new WebApplicationException(" User con el id: " + id + " no existe.", 404);
        }

        entity.setUsername(user.getUsername());
        entity.setPassword(user.getPassword());
        return entity;
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void deleteUser(@PathParam("id") long id){
        User.deleteById(id);
    }
}