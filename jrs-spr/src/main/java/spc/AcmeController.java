package spc;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Path("/")
public class AcmeController {

    private final AcmeService acmeService = Main.applicationContext.getBean(AcmeService.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Map<String, String> result = new HashMap<>();

        acmeService.serviceMethod(result);

        result.put(AcmeController.class.getName(), LocalTime.now().withNano(0).toString());

        return Response.status(Response.Status.OK).entity(result).build();
    }

}
