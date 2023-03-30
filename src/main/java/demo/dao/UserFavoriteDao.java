package demo.dao;

import java.sql.*;
import demo.model.*;

public class UserFavoriteDao {
	protected ConnectionManager connectionManager;
	
	private static UserFavoriteDao instance = null;
	protected UserFavoriteDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static UserFavoriteDao getInstance() {
		if (instance == null) {
			instance = new UserFavoriteDao();
		}
		return instance;
	}

	private UserFavorite buildFromResults(ResultSet results) throws SQLException {
		try {
			int resultfavoriteId = results.getInt("FavoriteId");
			String usrname = results.getString("userName");
			int resultModelId = results.getInt("ModelId");
			Boolean resultFavorite = results.getBoolean("Favorite");

			UserFavorite userFavorite = new UserFavorite(resultfavoriteId, usrname, resultModelId, resultFavorite);

			return userFavorite;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	public UserFavorite getFavoriteByUserName(String userName) throws SQLException {
		String selectUser = "SELECT * FROM UserFavorite WHERE Username=?;";
		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement selectStmt = connection.prepareStatement(selectUser, Statement.RETURN_GENERATED_KEYS);) {

			selectStmt.setString(1, userName);
			try(ResultSet results = selectStmt.executeQuery();){
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
		
		
	public UserFavorite create(UserFavorite userFavorite)throws SQLException {

		String insertUser = "INSERT INTO UserFavorite(favoriteId, userName, modelId, favorite) VALUES(?,?,?,?);";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement insertStmt = connection.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);) {

			insertStmt.setInt(1, userFavorite.getFavoriteId());
			insertStmt.setString(2, userFavorite.getUserName());
			insertStmt.setInt(3, userFavorite.getModelId());
			insertStmt.setBoolean(4, userFavorite.isFavorite());
			insertStmt.executeUpdate();
			return userFavorite;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public UserFavorite delete(UserFavorite userFavorite) throws SQLException {
		String deleteUser = "DELETE FROM UserFavorite WHERE favoriteId=?;";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement deleteStmt = connection.prepareStatement(deleteUser, Statement.RETURN_GENERATED_KEYS);) {

			deleteStmt.setInt(1, userFavorite.getFavoriteId());
			deleteStmt.executeUpdate();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}