package spc;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/")
public class AcmeController {

    private AcmeService acmeService = Main.applicationContext.getBean(AcmeService.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Map<String, String> result = acmeService.getAcme();
        result.put(String.valueOf(this), AcmeController.class.getSimpleName());

        return Response.status(Response.Status.OK).entity(result).build();
    }

}
