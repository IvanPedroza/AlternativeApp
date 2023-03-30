package demo.model;

import java.util.Date;


public class UserVehicleDiagnosis{

	private int	vehicleDiagnosisId;
	private int	userVehicleId;
	private int	diagnosisId;
	private Date reportedOn;
	
	
	public UserVehicleDiagnosis(int vehicleDiagnosisId, int userVehicleId, int diagnosisId, Date reportedOn) {
		super();
		this.vehicleDiagnosisId = vehicleDiagnosisId;
		this.userVehicleId = userVehicleId;
		this.diagnosisId = diagnosisId;
		this.reportedOn = reportedOn;
	}


	public int getVehicleDiagnosisId() {
		return vehicleDiagnosisId;
	}


	public void setVehicleDiagnosisId(int vehicleDiagnosisId) {
		this.vehicleDiagnosisId = vehicleDiagnosisId;
	}


	public int getUserVehicleId() {
		return userVehicleId;
	}


	public void setUserVehicleId(int userVehicleId) {
		this.userVehicleId = userVehicleId;
	}


	public int getDiagnosisId() {
		return diagnosisId;
	}


	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}


	public Date getReportedOn() {
		return reportedOn;
	}


	public void setReportedOn(Date reportedOn) {
		this.reportedOn = reportedOn;
	}
	
	
	
	
	
}
	
	
	
	