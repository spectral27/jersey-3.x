package spc;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URI;

public class Main {

    public static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBeans.class);

    public static void main(String[] args) {
        URI url = URI.create("http://0.0.0.0:8080");

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages(Main.class.getPackageName());

        GrizzlyHttpServerFactory.createHttpServer(url, resourceConfig);
    }

}
