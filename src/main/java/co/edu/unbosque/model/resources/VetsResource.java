package co.edu.unbosque.model.resources;

import co.edu.unbosque.model.resources.pojos.VetPojo;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/vets")
public class VetsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {

        List<VetPojo> authors = new ArrayList<VetPojo>();
        authors.add(new VetPojo("Veterinaria1", "Nombre veterinaria 1", "Direccion1", "Vecindario1"));
        authors.add(new VetPojo("Veterinaria2", "Nombre veterinaria 2", "Direccion2", "Vecindario2"));

        return Response.ok()
                .entity(authors)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(VetPojo vet) {

        vet.setUsername("veterinaria3");

        return Response.status(Response.Status.CREATED)
                .entity(vet)
                .build();
    }

}
