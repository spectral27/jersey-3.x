package spc;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class JerseyController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        ResponseObject ro = new ResponseObject();
        ro.setMessage("Hello from Jersey");

        return Response.status(Response.Status.OK).entity(ro).build();
    }

}
