package spc;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@Path("/versions")
public class VersionController {

    private final VersionService versionService = SpringContext.beanOf(VersionService.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectAllVersions() {
        try {
            List<Version> versions = versionService.read();

            return Response.status(Response.Status.OK).entity(versions).build();
        } catch (IOException e) {
            return errorResponse(e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertVersion(Version version) {
        try {
            versionService.insertVersion(version);

            return Response.status(Response.Status.OK).build();
        } catch (IOException e) {
            return errorResponse(e);
        }
    }

    @GET
    @Path("/latest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response latest() {
        try {
            List<Version> versions = versionService.latest();

            return Response.status(Response.Status.OK).entity(versions).build();
        } catch (IOException e) {
            return errorResponse(e);
        }
    }

    public Response errorResponse(Exception e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String stackTraceString = stringWriter.toString();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(stackTraceString).build();
    }

}
