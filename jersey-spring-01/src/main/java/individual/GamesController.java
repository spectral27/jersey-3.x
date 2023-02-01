package individual;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Comparator;
import java.util.List;

@Path("/games")
public class GamesController {

    private GamesService gamesService = Main.context.getBean("gamesService", GamesService.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectAllGames() {
        try {
            return Response.status(Response.Status.OK).entity(gamesService.selectAllGames()).build();
        } catch (IOException e) {
            return errorResponse(e);
        }
    }

    @GET
    @Path("/sort/year")
    @Produces(MediaType.APPLICATION_JSON)
    public Response selectAllGamesSortByYear() {
        try {
            List<Game> games = gamesService.selectAllGames();

            Comparator<Game> comparator = Comparator.comparingInt(Game::getYear);

            games.sort(comparator);
            //games.sort(Comparator.comparing(g -> g.getYear()));

            return Response.status(Response.Status.OK).entity(games).build();
        } catch (IOException e) {
            return errorResponse(e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertGame(Game game) {
        try {
            gamesService.insertGame(game);

            return Response.status(Response.Status.OK).entity("Game added").build();
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
