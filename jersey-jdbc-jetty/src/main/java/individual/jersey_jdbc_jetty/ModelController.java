package individual.jersey_jdbc_jetty;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/models")
public class ModelController {
	
	@Inject
	private ModelRepository modelRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Model> hello() {
		return modelRepository.selectAllModels();
	}

}
