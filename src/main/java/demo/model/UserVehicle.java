package demo.model;

import java.util.Date;


public class UserVehicle{
	protected int userVehicleId;
	protected int modelId;
	protected String userName;
	protected Date  purchaseDate;
	
	
	public UserVehicle(int userVehicleId, int modelId, String userName, Date purchaseDate) {
		super();
		this.userVehicleId = userVehicleId;
		this.modelId = modelId;
		this.userName = userName;
		this.purchaseDate = purchaseDate;
	}


	public int getUserVehicleId() {
		return userVehicleId;
	}


	public void setUserVehicleId(int userVehicleId) {
		this.userVehicleId = userVehicleId;
	}


	public int getModelId() {
		return modelId;
	}


	public void setModelId(int modelId) {
		this.modelId = modelId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}			
	
}