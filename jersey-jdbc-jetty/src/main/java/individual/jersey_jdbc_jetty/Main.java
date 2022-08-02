package individual.jersey_jdbc_jetty;

import java.net.URI;

import org.eclipse.jetty.server.Server;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {
	
	public static void main(String[] args) {
		startServer();
	}
	
	private static Server startServer() {
		ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.register(ModelController.class);
		
		resourceConfig.register(new AbstractBinder() {
			@Override
			protected void configure() {
				bindAsContract(ModelRepository.class);
			}
		});
		
		return JettyHttpContainerFactory.createServer(URI.create("http://localhost:8080"), resourceConfig);
	}
	
}
