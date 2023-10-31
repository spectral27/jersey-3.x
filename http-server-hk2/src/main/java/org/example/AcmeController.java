package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/")
public class AcmeController {

    @Inject
    private AcmeService acmeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAcme() {
        Map<String, String> result = acmeService.getAcme();
        result.put("controller", AcmeController.class.getSimpleName());
        return Response.status(Response.Status.OK).entity(result).build();
    }

}
