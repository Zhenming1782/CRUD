package org.proyecto.Controller;

import io.quarkus.qute.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("login")
public class Login {
    @Inject
    Template login;


    @GET
    public TemplateInstance login() {
        return login.instance();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response GetLogin(@FormParam("username") String username,@FormParam("password") String password) throws IOException {

        System.out.println(username+'\n'+password);
        return null;
    }
}
