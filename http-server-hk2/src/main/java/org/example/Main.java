package org.example;

import jakarta.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {

    public static void main(String[] args) {
        URI url = UriBuilder.fromUri("http://127.0.0.1/").port(8080).build();

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages(Main.class.getPackageName());
        resourceConfig.register(new JerseyBinder());

        JdkHttpServerFactory.createHttpServer(url, resourceConfig);
    }

}
