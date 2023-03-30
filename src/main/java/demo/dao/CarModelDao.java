package demo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import demo.model.CarModel;
import demo.model.CarModel.CleanFuelEligibility;
import demo.model.CarModel.ElectricVehicleType;

public class CarModelDao {
	protected ConnectionManager connectionManager;

	private static CarModelDao instance = null;
	protected CarModelDao() {
		connectionManager = new ConnectionManager();
	}
	public static CarModelDao getInstance() {
		if(instance == null) {
			instance = new CarModelDao();
		}
		return instance;
	}

	private CarModel buildModelFromResults(ResultSet rs) throws SQLException {
		try {
			CarModel carModel = new CarModel(
					rs.getInt("modelId"),
					rs.getString("modelName"),
					rs.getInt("year"),
					rs.getDouble("basePrice"),
					rs.getInt("electricRange"),
					rs.getString("description"),
					rs.getInt("makeId"),
					ElectricVehicleType.getValFromDescription(rs.getString("electricVehicleType")),
					CleanFuelEligibility.getValFromDescription(rs.getString("cleanFuelEligibility")));
			return carModel;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<CarModel> getPopularModelsByCounty(String county) throws SQLException{
		List<CarModel> carModelList = new ArrayList<>();
		
		String selectCarModels = "SELECT CarModel.modelId as modelId,modelName,year,basePrice,electricRange,"
				+ "description,makeId,electricVehicleType,cleanFuelEligibility\n"
				+ "FROM CarModel,\n"
				+ "    (SELECT \n"
				+ "        UserVehicle.modelId AS modelId,\n"
				+ "            COUNT(UserVehicle.modelId) AS userCount\n"
				+ "    FROM\n"
				+ "        Users, Location, UserVehicle, CarModel\n"
				+ "    WHERE\n"
				+ "        Users.locationId = Location.locationId\n"
				+ "        AND Location.county = ?\n"
				+ "		AND Users.userName = UserVehicle.userName\n"
				+ "		AND UserVehicle.modelId = CarModel.modelId\n"
				+ "    GROUP BY UserVehicle.modelId\n"
				+ "    ORDER BY userCount DESC\n"
				+ "    LIMIT 5) ModelDetails\n"
				+ "WHERE CarModel.modelId = ModelDetails.modelId";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement selectStmt = connection.prepareStatement(selectCarModels, Statement.RETURN_GENERATED_KEYS);) {

			selectStmt.setString(1, county);
			try(ResultSet results = selectStmt.executeQuery();) {
				while (results.next()) {
					CarModel carModel = buildModelFromResults(results);
					carModelList.add(carModel);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return carModelList;
	}
	
	public List<CarModel> getPopularModelsByCity(String city) throws SQLException{
		List<CarModel> carModelList = new ArrayList<>();
		
		String selectCarModels = "SELECT CarModel.modelId as modelId,modelName,year,basePrice,electricRange,"
				+ "description,makeId,electricVehicleType,cleanFuelEligibility\n"
				+ "FROM CarModel,\n"
				+ "    (SELECT \n"
				+ "        UserVehicle.modelId AS modelId,\n"
				+ "            COUNT(UserVehicle.modelId) AS userCount\n"
				+ "    FROM\n"
				+ "        Users, Location, UserVehicle, CarModel\n"
				+ "    WHERE\n"
				+ "        Users.locationId = Location.locationId\n"
				+ "        AND Location.city = ?\n"
				+ "		AND Users.userName = UserVehicle.userName\n"
				+ "		AND UserVehicle.modelId = CarModel.modelId\n"
				+ "    GROUP BY UserVehicle.modelId\n"
				+ "    ORDER BY userCount DESC\n"
				+ "    LIMIT 5) ModelDetails\n"
				+ "WHERE CarModel.modelId = ModelDetails.modelId";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement selectStmt = connection.prepareStatement(selectCarModels, Statement.RETURN_GENERATED_KEYS);) {

			selectStmt.setString(1, city);
			try(ResultSet results = selectStmt.executeQuery();) {
				while (results.next()) {
					CarModel carModel = buildModelFromResults(results);
					carModelList.add(carModel);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return carModelList;
	}
	
	public List<CarModel> getCarModelsByMake(String makeName) throws SQLException{
		List<CarModel> carModelList = new ArrayList<>();
		
		String selectCarModels = "SELECT modelId,modelName,year,basePrice,electricRange,CarModel.description as description,"
				+ "CarModel.makeId as makeId,electricVehicleType,cleanFuelEligibility\n"
				+ "FROM CarModel,CarMake\n"
				+ "WHERE CarModel.makeId = CarMake.makeId\n"
				+ "AND CarMake.makeName = ?"
				+ "ORDER BY year DESC";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement selectStmt = connection.prepareStatement(selectCarModels, Statement.RETURN_GENERATED_KEYS);) {
			selectStmt.setString(1, makeName);
			try(ResultSet results = selectStmt.executeQuery();) {
				while (results.next()) {
					CarModel carModel = buildModelFromResults(results);
					carModelList.add(carModel);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return carModelList;
	}
	
	public List<CarModel> getModelsByPrice(int minPrice, int maxPrice) throws SQLException{
		List<CarModel> carModelList = new ArrayList<>();
		
		String selectCarModels = "SELECT modelId,modelName,year,basePrice,electricRange,description,"
				+ "makeId,electricVehicleType,cleanFuelEligibility\n"
				+ "FROM CarModel\n"
				+ "WHERE basePrice between ? and ?\n"
				+ "ORDER BY basePrice ASC";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement selectStmt = connection.prepareStatement(selectCarModels, Statement.RETURN_GENERATED_KEYS);) {

			selectStmt.setInt(1, minPrice);
			selectStmt.setInt(2, maxPrice);
			try(ResultSet results = selectStmt.executeQuery();){
				while (results.next()) {
					CarModel carModel = buildModelFromResults(results);
					carModelList.add(carModel);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return carModelList;
	}


	public List<CarModel> getModelsByElectricRange(int electricRange) {
		String query = "SELECT * FROM CarModel WHERE electricRange >= ?";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

			statement.setInt(1, electricRange);
			try(ResultSet rs = statement.executeQuery();) {
				List<CarModel> models = new ArrayList<>();

				while (rs.next()) {
					CarModel carModel = buildModelFromResults(rs);
					models.add(carModel);
				}
				return models;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CarModel getCarModelByName(String modelName) throws SQLException {
		String query = "SELECT * FROM CarModel WHERE modelName = ?";
		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

			statement.setString(1, modelName);
			try(ResultSet rs = statement.executeQuery();) {
				if (rs.next()) {
					return buildModelFromResults(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	public CarModel getCarModelById(int modelId) throws SQLException {
		String query = "SELECT * FROM CarModel WHERE modelId = ?";
		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

			statement.setInt(1, modelId);
			try(ResultSet rs = statement.executeQuery();) {
				if (rs.next()) {
					return buildModelFromResults(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}
}
