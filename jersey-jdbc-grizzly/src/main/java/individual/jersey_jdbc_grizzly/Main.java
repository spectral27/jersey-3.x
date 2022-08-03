package individual.jersey_jdbc_grizzly;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {
	
    public static final String url = "http://localhost:8080";

    public static HttpServer startServer() {
        final ResourceConfig config = new ResourceConfig().packages("individual.jersey_jdbc_grizzly");
        
        config.register(new AbstractBinder() {
			@Override
			protected void configure() {
				bindAsContract(ModelRepository.class);
			}
		});

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(url), config);
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = startServer();
        
        System.out.println("Jersey app started with endpoints available at: " + url);
        System.out.println("Hit Ctrl-C to stop it.");
        
        System.in.read();
        
        server.shutdownNow();
    }
    
}
