package demo.dao;

import java.sql.*;
import demo.model.*;

public class UserDao {
	protected ConnectionManager connectionManager;
	
	private static UserDao instance = null;
	protected UserDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}

	private User buildFromResults(ResultSet results) throws SQLException {
		try{
			String resultUserName = results.getString("Username");
			String resultPassword = results.getString("Password");
			String resultFirstName = results.getString("FirstName");
			String resultLastName = results.getString("LastName");
			String resultEmail = results.getString("Email");
			String resultPhoneNumber = results.getString("PhoneNumber");
			String resultAddressLine1 = results.getString("AddressLine1");
			String resultAddressLine2 = results.getString("AddressLine2");
			int resultLocationId = results.getInt("LocationId");
			Location location = LocationDao.getInstance().getLocationById(resultLocationId);
			User user = new User(resultUserName, resultPassword, resultFirstName, resultLastName, resultEmail, resultPhoneNumber, resultAddressLine1, resultAddressLine2, location);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public User create(User user) throws SQLException {
		String insertUser = "INSERT INTO Users(Username, Password, FirstName, LastName, Email, PhoneNumber, AddressLine1, AddressLine2, LocationId) VALUES(?,?,?,?,?,?,?,?,?);";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement insertStmt = connection.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);) {

			insertStmt.setString(1, user.getUserName());
			insertStmt.setString(2, user.getPassword());
			insertStmt.setString(3, user.getFirstName());
			insertStmt.setString(4, user.getLastName());
			insertStmt.setString(5, user.getEmail());
			insertStmt.setString(6, user.getPhoneNumber());
			insertStmt.setString(6, user.getAddressLine1());
			insertStmt.setString(6, user.getAddressLine2());
			insertStmt.setInt(6, user.getLocation().getLocationId());
			insertStmt.executeUpdate();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public User getUserByUsername(String username)throws SQLException {
		String selectUser = "SELECT * FROM Users WHERE Username=?;";
		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement selectStmt = connection.prepareStatement(selectUser, Statement.RETURN_GENERATED_KEYS);) {

			selectStmt.setString(1, username);
			try(ResultSet results = selectStmt.executeQuery();){
				LocationDao locationDao = LocationDao.getInstance();
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
	
	public User updateEmail(User user, String newEmail) throws SQLException{
		String updateEmail = "UPDATE Users SET Email=? WHERE Username=?;";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement updateStmt = connection.prepareStatement(updateEmail, Statement.RETURN_GENERATED_KEYS);) {

			updateStmt.setString(1, newEmail);
			updateStmt.setString(2, user.getUserName());
			updateStmt.executeUpdate();
			user.setEmail(newEmail);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public User updatePassword(User user, String newPassword) throws SQLException{
		String updateEmail = "UPDATE Users SET Password=? WHERE Username=?;";
		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement updateStmt = connection.prepareStatement(updateEmail, Statement.RETURN_GENERATED_KEYS);) {

			updateStmt.setString(1, newPassword);
			updateStmt.setString(2, user.getUserName());
			updateStmt.executeUpdate();
			user.setPassword(newPassword);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public User delete(User user) throws SQLException {
		String deleteUser = "DELETE FROM Users WHERE Username=?;";
		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement deleteStmt = connection.prepareStatement(deleteUser, Statement.RETURN_GENERATED_KEYS);) {

			deleteStmt.setString(1, user.getUserName());
			deleteStmt.executeUpdate();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}