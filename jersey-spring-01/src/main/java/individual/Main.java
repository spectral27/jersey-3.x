package individual;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URI;

public class Main {

    public static String URL = "http://0.0.0.0:8080";
    public static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    public static void main(String[] args) throws IOException {
        String origin = System.getProperty("origin");

        if (origin == null || origin.length() == 0) {
            System.out.println("No origin set");
            System.exit(0);
        } else {
            GamesService.origin = System.getProperty("origin");
            System.out.println("Origin set to: " + System.getProperty("origin"));
        }

        ResourceConfig config = new ResourceConfig().packages("individual");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(URL), config);
    }

}
