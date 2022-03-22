package org.proyecto.Controller;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.proyecto.Entity.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("create")
public class Create {
    @Inject
    Template create;

    @GET
    public TemplateInstance create() {
        return create.instance();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response GetLogin(@FormParam("username") String username, @FormParam("password") String password, @FormParam("confirm") String confirm) throws IOException {

        //TODO fix finding the username
        if(User.find("username", username).firstResult().isPersistent()){
            return null;
        }else
        {
            if (password.equals(confirm)) {
                System.out.println("Valido");
            } else {
                System.out.println("Invalido");
            }
        }
        return null;
    }
}
