package individual.jersey_jdbc_grizzly;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/models")
public class ModelController {
	
	@Inject
	private ModelRepository repository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Model> selectAllModels() {
		return repository.selectAllModels();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Model selectModel(@PathParam("id") String id) {
		return repository.selectModel(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public int insertModel(Model model) {
		return repository.insertModel(model);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public int updateModel(@PathParam("id") String id, Model model) {
		return repository.updateModel(id, model);
	}
	
	@DELETE
	@Path("/{id}")
	public int deleteModel(@PathParam("id") String id) {
		return repository.deleteModel(id);
	}

}
