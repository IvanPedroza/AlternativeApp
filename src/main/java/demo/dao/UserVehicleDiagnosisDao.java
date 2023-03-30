package demo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import demo.model.*;


public class UserVehicleDiagnosisDao {
	protected ConnectionManager connectionManager;
	
	private static UserVehicleDiagnosisDao  instance = null;
	protected UserVehicleDiagnosisDao() {
		connectionManager = new ConnectionManager();
	}
	
	public static UserVehicleDiagnosisDao  getInstance() {
		if (instance == null) {
			instance = new UserVehicleDiagnosisDao ();
		}
		return instance;
	}

	private CarDiagnosis buildFromResults(ResultSet results) throws SQLException {
		try {
			int DiagnosisId = results.getInt("DiagnosisId");
			String obdCode = results.getString("ObdCode");
			String description = results.getString("Description");
			int makeId = results.getInt("MakeId");
			return new CarDiagnosis(DiagnosisId,obdCode,description,makeId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public UserVehicleDiagnosis create(UserVehicleDiagnosis userVehicleDiagnosis)throws SQLException {
		String sql = "INSERT INTO UserVehicleDiagnosis (vehicleDiagnosisId, userVehicleId, diagnosisId, reportedOn) VALUES(?,?,?,?);";

		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement insertStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			insertStmt.setInt(1, userVehicleDiagnosis.getVehicleDiagnosisId());
			insertStmt.setInt(2, userVehicleDiagnosis.getUserVehicleId());
			insertStmt.setInt(3, userVehicleDiagnosis.getDiagnosisId());
			insertStmt.setTimestamp(4, new Timestamp(userVehicleDiagnosis.getReportedOn().getTime()));
			insertStmt.executeUpdate();

			return userVehicleDiagnosis;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public List<CarDiagnosis> getUserVehicleIssuesByModelId(int modelId) throws SQLException {
        List<CarDiagnosis> carDiagnosisList = new ArrayList<CarDiagnosis>();
        String sql = "SELECT * FROM CarDiagnosis INNER JOIN UserVehicleDiagnosis uvd ON cd.diagnosisId = uvd.diagnosisId INNER JOIN UserVehicle uv ON uvd.userVehicleId = uv.userVehicleId WHERE uv.modelId = ?;";
		try (Connection connection = connectionManager.getConnection();
			 PreparedStatement selectStmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			selectStmt.setInt(1, modelId);
			try(ResultSet results = selectStmt.executeQuery();){
				carDiagnosisList.add(buildFromResults(results));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return carDiagnosisList;
	}
}