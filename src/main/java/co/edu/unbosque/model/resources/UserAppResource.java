package co.edu.unbosque.model.resources;


import co.edu.unbosque.model.resources.pojos.UserAppPojo;
import co.edu.unbosque.model.services.OfficialService;
import co.edu.unbosque.model.services.OwnerService;
import co.edu.unbosque.model.services.UserAppService;
import co.edu.unbosque.model.services.VetService;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usersapp/{username}")
public class UserAppResource {

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username") String username, UserAppPojo userApp, String email, String name, String address, String neighborhood) {

        if (userApp.getOwnerPojo() != null) {
            new UserAppService().updateUserApp(username, userApp.getEmail());
            new OwnerService().updateOwner(username, userApp.getOwnerPojo().getName(), userApp.getOwnerPojo().getAdress(), userApp.getOwnerPojo().getNeighborhood());
        } else if (userApp.getOfficialPojo() != null) {
            new UserAppService().updateUserApp(username, userApp.getEmail());
            new OfficialService().updateOfficial(username, userApp.getOwnerPojo().getName());
        } else if (userApp.getVetPojo() != null) {
            new UserAppService().updateUserApp(username, userApp.getEmail());
            new VetService().updateVet(username, userApp.getOwnerPojo().getName(), userApp.getOwnerPojo().getAdress(), userApp.getOwnerPojo().getNeighborhood());
        }

        return Response.ok()
                .entity(userApp)
                .build();
    }


}