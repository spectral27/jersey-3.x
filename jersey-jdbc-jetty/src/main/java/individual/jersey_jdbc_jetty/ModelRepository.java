package individual.jersey_jdbc_jetty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

}
