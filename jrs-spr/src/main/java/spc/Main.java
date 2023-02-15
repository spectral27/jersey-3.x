package spc;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URI;

public class Main {

    public static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBeans.class);

    public static void main(String[] args) {
        String origin = System.getProperty("origin");

        if (origin != null && origin.length() > 0) {
            System.out.println("Origin set to " + origin);
        } else {
            System.out.println("Origin not set");
            System.exit(0);
        }

        URI url = URI.create("http://0.0.0.0:8080");

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages(Main.class.getPackageName());

        GrizzlyHttpServerFactory.createHttpServer(url, resourceConfig);
    }

}
