package demo.dao;

import java.sql.*;
import demo.model.*;

public class UserReviewDao {
	protected ConnectionManager connectionManager;
	
	private static UserReviewDao instance = null;
	protected UserReviewDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static UserReviewDao getInstance() {
		if (instance == null) {
			instance = new UserReviewDao();
		}
		return instance;
	}
	
	public UserReview create(UserReview userReview)throws SQLException {
		String sql = "INSERT INTO UserReview (reviewId, modelId, userName,rating,reviewTitle,reviewComment) VALUES(?,?,?,?,?,?);";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement insertStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			
			insertStmt.setInt(1, userReview.getReviewId());
			insertStmt.setInt(2, userReview.getModelId());
			insertStmt.setString(3, userReview.getUserName());
			insertStmt.setFloat(4, userReview.getRating());
			insertStmt.setString(5, userReview.getReviewTitle());
			insertStmt.setString(6, userReview.getReviewComment());
			insertStmt.executeUpdate();
			ResultSet resultKey = insertStmt.getGeneratedKeys();
			if(resultKey.next()) {
				userReview.setReviewId(resultKey.getInt(1));
			}
			return userReview;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}