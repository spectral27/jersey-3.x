package individual.jersey_jdbc_grizzly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ModelRepository {

	private ObjectMapper objectMapper = new ObjectMapper();

	public List<Model> selectAllModels() {
		try (Connection connection = JdbcConnection.get()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from models");

			List<Model> models = new ArrayList<>();

			while (resultSet.next()) {
				Model model = new Model();
				model.setId(resultSet.getString("id"));
				model.setYear(resultSet.getInt("year"));
				model.setModel(resultSet.getString("model"));
				model.setNumber(resultSet.getInt("number"));
				model.setFinalPos(resultSet.getString("finalpos"));
				model.setEvent(resultSet.getString("event"));
				model.setCarClass(resultSet.getString("class"));

				String driversJson = resultSet.getString("drivers");
				List<String> drivers = new ArrayList<>();

				try {
					drivers = objectMapper.readValue(driversJson, new TypeReference<List<String>>() {});
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}

				model.setDrivers(drivers);
				
				models.add(model);
			}

			return models;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Model selectModel(String id) {
		try (Connection connection = JdbcConnection.get()) {
			String query = "select * from models where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, id);

			ResultSet resultSet = ps.executeQuery();
			Model model = new Model();

			while (resultSet.next()) {
				model.setId(resultSet.getString("id"));
				model.setYear(resultSet.getInt("year"));
				model.setModel(resultSet.getString("model"));
				model.setNumber(resultSet.getInt("number"));
				model.setFinalPos(resultSet.getString("finalpos"));
				model.setEvent(resultSet.getString("event"));
				model.setCarClass(resultSet.getString("class"));

				String driversJson = resultSet.getString("drivers");
				List<String> drivers = new ArrayList<>();

				try {
					drivers = objectMapper.readValue(driversJson, new TypeReference<List<String>>() {
					});
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}

				model.setDrivers(drivers);
			}
			
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int insertModel(Model model) {
		try (Connection connection = JdbcConnection.get()) {
			String query = "insert into models values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, UUID.randomUUID().toString().substring(0, 8));
			ps.setInt(2, model.getYear());
			ps.setString(3, model.getModel());
			ps.setInt(4, model.getNumber());
			ps.setString(5, model.getFinalPos());
			ps.setString(6, model.getEvent());
			ps.setString(7, model.getCarClass());
			
			String driversJson = "";
			
			try {
				driversJson = objectMapper.writeValueAsString(model.getDrivers());
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			ps.setString(8, driversJson);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int updateModel(String id, Model model) {
		try (Connection connection = JdbcConnection.get()) {
			String query = "update models set " +
					"year = ?, model = ?, number = ?, finalpos = ?, " +
					"event = ?, class = ?, drivers = ? where id = ?";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, model.getYear());
			ps.setString(2, model.getModel());
			ps.setInt(3, model.getNumber());
			ps.setString(4, model.getFinalPos());
			ps.setString(5, model.getEvent());
			ps.setString(6, model.getCarClass());
			
			String driversJson = "";
			
			try {
				driversJson = objectMapper.writeValueAsString(model.getDrivers());
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			ps.setString(7, driversJson);
			ps.setString(8, id);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int deleteModel(String id) {
		try (Connection connection = JdbcConnection.get()) {
			String query = "delete from models where id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, id);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
