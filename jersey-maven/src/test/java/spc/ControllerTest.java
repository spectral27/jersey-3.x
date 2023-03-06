package spc;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.jupiter.api.*;

import java.net.URI;

public class ControllerTest {

    private static HttpServer server;
    private static WebTarget target;

    @BeforeAll
    public static void setup() {
        server = Main.startServer();

        Client client = ClientBuilder.newClient();

        target = client.target(URI.create("http://0.0.0.0:8080"));
    }

    @AfterAll
    public static void close() throws Exception {
        server.shutdown();
    }

    @Test
    public void testGet() {
        String actual = target.request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(String.class);

        String expected = "{\"message\":\"Hello from Jersey\"}";

        Assertions.assertEquals(expected, actual);
    }

}
