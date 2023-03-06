package spc;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {

    public static void main(String[] args) {
        HttpServer server = startServer();
    }

    public static HttpServer startServer() {
        URI url = URI.create("http://0.0.0.0:8080");

        ResourceConfig rc = new ResourceConfig();
        rc.packages(Main.class.getPackageName());

        return GrizzlyHttpServerFactory.createHttpServer(url, rc);
    }

}
