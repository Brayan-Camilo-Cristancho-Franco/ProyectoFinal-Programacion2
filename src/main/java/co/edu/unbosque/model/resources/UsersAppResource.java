package co.edu.unbosque.model.resources;


import co.edu.unbosque.model.resources.pojos.UserAppPojo;
import co.edu.unbosque.model.services.OfficialService;
import co.edu.unbosque.model.services.OwnerService;
import co.edu.unbosque.model.services.UserAppService;
import co.edu.unbosque.model.services.VetService;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/usersapp/{rol}/usersapp")

public class UsersAppResource {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(UserAppPojo userapp) {
        if (userapp.getOwnerPojo() != null) {
            new UserAppService().saveUserApp(userapp.getUsername(), userapp.getPassword(), userapp.getEmail(), userapp.getRole());
            new OwnerService().saveOwner(userapp.getUsername(), userapp.getOwnerPojo().getPerson_id(), userapp.getOwnerPojo().getName(), userapp.getOwnerPojo().getAdress(), userapp.getOwnerPojo().getNeighborhood());
        } else if (userapp.getOfficialPojo() != null) {
            new UserAppService().saveUserApp(userapp.getUsername(), userapp.getPassword(), userapp.getEmail(), userapp.getRole());
            new OfficialService().saveOfficial(userapp.getOfficialPojo().getUsername(), userapp.getOfficialPojo().getName());
        } else if (userapp.getVetPojo() != null) {
            new UserAppService().saveUserApp(userapp.getUsername(), userapp.getPassword(), userapp.getEmail(), userapp.getRole());
            new VetService().saveVet(userapp.getVetPojo().getName(), userapp.getVetPojo().getAdress(), userapp.getVetPojo().getNeighborhood(), userapp.getVetPojo().getUsername());
        }

        return Response.status(Response.Status.CREATED)
                .entity(userapp)
                .build();
    }
}
