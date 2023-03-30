package demo.dao;

import java.sql.*;
import demo.model.*;

public class LocationDao {
	protected ConnectionManager connectionManager;
	
	private static LocationDao instance = null;
	protected LocationDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static LocationDao getInstance() {
		if (instance == null) {
			instance = new LocationDao();
		}
		return instance;
	}

	private Location buildFromResults(ResultSet results) throws SQLException {
		try{
			int resultLocationId = results.getInt("LocationId");
			String resultCounty = results.getString("County");
			String resultCity = results.getString("City");
			String resultState = results.getString("State");
			String resultCountry = results.getString("Country");
			String resultZipcode = results.getString("Zipcode");

			Location location = new Location(resultLocationId, resultCounty, resultCity, resultState, resultCountry, resultZipcode);
			return location;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Location create(Location location) throws SQLException {
		String insertLocation = "INSERT INTO Location(County, City, State, Country, Zipcode) VALUES(?,?,?,?,?);";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement insertStmt = connection.prepareStatement(insertLocation, Statement.RETURN_GENERATED_KEYS);) {

			insertStmt.setString(1, location.getCounty());
			insertStmt.setString(2, location.getCity());
			insertStmt.setString(3, location.getState());
			insertStmt.setString(4, location.getCountry());
			insertStmt.setString(5, location.getZipCode());
			insertStmt.executeUpdate();
			
			try (ResultSet resultKey = insertStmt.getGeneratedKeys();){
				int locationId = -1;
				if (resultKey.next()) {
					locationId = resultKey.getInt(1);
				} else {
					throw new SQLException("Unable to retrieve auto-generated key");
				}
				location.setLocationId(locationId);
				return location;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Location getLocationById(int locationId) throws SQLException{
		String selectLocation = 
				"SELECT LocationId, County, City, State, Country, Zipcode " +
				"FROM Location " +
				"WHERE LocationId=?;";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement selectStmt = connection.prepareStatement(selectLocation, Statement.RETURN_GENERATED_KEYS);) {

			selectStmt.setInt(1, locationId);
			try (ResultSet results = selectStmt.executeQuery();){
				if (results.next()) {
					return buildFromResults(results);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}	
}
