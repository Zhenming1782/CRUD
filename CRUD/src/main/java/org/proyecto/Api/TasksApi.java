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
@Path("/api/Tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Tasks" ,description = "Here is all the information about Tasks. ")
public class TasksApi {

    @Inject
    EntityManager entityManager;


    @POST
    @Transactional
    public void add(Tasks tasks) {
        Tasks.persist(tasks);
    }

    @GET
    public List<Tasks> getTasks(){
        return Tasks.listAll();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Tasks update(@PathParam("id") long id, Tasks tasks){
        if (tasks.findById(id) == null) {
            throw new WebApplicationException("Id no fue enviado en la peticion.", 422);
        }

        Tasks entity = entityManager.find(Tasks.class,id);

        if (entity == null) {
            throw new WebApplicationException(" Tasks con el id: " + id + " no existe.", 404);
        }



        entity.setUserid(tasks.getUserid());
        entity.setDescription(tasks.getDescription());
        return entity;
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public void deleteTasks(@PathParam("id") long id){
        Tasks.deleteById(id);
    }
}