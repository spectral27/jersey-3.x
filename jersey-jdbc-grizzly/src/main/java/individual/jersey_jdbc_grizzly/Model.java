package individual.jersey_jdbc_grizzly;

import java.util.List;

public class Model {

	private String id;
	private int year;
	private String model;
	private int number;
	private String finalPos;
	private String event;
	private String carClass;
	private List<String> drivers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getFinalPos() {
		return finalPos;
	}

	public void setFinalPos(String finalPos) {
		this.finalPos = finalPos;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getCarClass() {
		return carClass;
	}

	public void setCarClass(String carClass) {
		this.carClass = carClass;
	}

	public List<String> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<String> drivers) {
		this.drivers = drivers;
	}

}
