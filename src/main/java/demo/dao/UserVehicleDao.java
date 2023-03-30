package demo.dao;

import java.sql.*;
import demo.model.*;

public class UserVehicleDao {
	protected ConnectionManager connectionManager;
	
	private static UserVehicleDao instance = null;
	protected UserVehicleDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static UserVehicleDao getInstance() {
		if (instance == null) {
			instance = new UserVehicleDao();
		}
		return instance;
	}
	
	
	
public UserVehicle create(UserVehicle userVehicle)throws SQLException {
	String sql = "INSERT INTO UserVehicle (userVehicleId, modelId, userName, purchaseDate) VALUES(?,?,?,?);";

	try (Connection connection = connectionManager.getConnection();
		 PreparedStatement insertStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

		insertStmt.setInt(1, userVehicle.getUserVehicleId());
		insertStmt.setInt(2, userVehicle.getModelId());
		insertStmt.setString(3, userVehicle.getUserName());
		insertStmt.setTimestamp(4, new Timestamp(userVehicle.getPurchaseDate().getTime()));
		insertStmt.executeUpdate();
		return userVehicle;
	} catch (SQLException e) {
		e.printStackTrace();
		throw e;
	}
}
	
}