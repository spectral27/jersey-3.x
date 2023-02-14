package spc;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {

    public static void main(String[] args) {
        URI url = URI.create("http://0.0.0.0:8080");

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages(Main.class.getPackageName());
        resourceConfig.register(new JerseyBinder());

        GrizzlyHttpServerFactory.createHttpServer(url, resourceConfig);
    }

}
