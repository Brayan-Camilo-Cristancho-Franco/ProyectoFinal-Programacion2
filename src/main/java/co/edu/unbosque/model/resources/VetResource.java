package co.edu.unbosque.model.resources;

import co.edu.unbosque.model.resources.pojos.VetPojo;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vets/{id}")
public class VetResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("id") Integer id, VetPojo vet) {

        return Response.ok()
                .entity(vet)
                .build();
    }


}