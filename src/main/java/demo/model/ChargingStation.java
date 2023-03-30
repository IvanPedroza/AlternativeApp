package demo.model;
public class ChargingStation {
	

	protected int chargingStationId;
	protected String name;
	protected String description;
	protected String addressLine1;
	protected String  addressLine2;
	protected int locationId;
	
	
	public ChargingStation(int chargingStationId, String name, String description, String addressLine1,
			String addressLine2, int locationId) {
		super();
		this.chargingStationId = chargingStationId;
		this.name = name;
		this.description = description;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.locationId = locationId;
	}


	public int getChargingStationId() {
		return chargingStationId;
	}


	public void setChargingStationId(int chargingStationId) {
		this.chargingStationId = chargingStationId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public int getLocationId() {
		return locationId;
	}


	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	
}