package spc;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URI;

public class Main {

    public static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    public static void main(String[] args) {
        String origin = System.getProperty("origin");

        if (origin != null && origin.length() > 0) {
            System.out.println("Origin set to " + System.getProperty("origin"));
            GamesService.origin = System.getProperty("origin");
        } else {
            System.out.println("No origin set");
            System.exit(0);
        }

        String URL = "http://0.0.0.0:8080";

        ResourceConfig config = new ResourceConfig();
        config.packages("spc");

        GrizzlyHttpServerFactory.createHttpServer(URI.create(URL), config);
    }

}
