package demo.model;

public class CarModel {
    protected int modelId;
    protected String modelName;
    protected int year;
    protected double basePrice;
    protected int electricRange;
    protected String description;
    protected int makeId;
    protected ElectricVehicleType electricVehicleType;
    protected CleanFuelEligibility cleanFuelEligibility;

    public enum ElectricVehicleType {
    	BEV("Battery Electric Vehicle (BEV)"),
        PHEV("Plug-in Hybrid Electric Vehicle (PHEV)");
    	
    	private String displayName;
    	
    	ElectricVehicleType(String displayName){
    		this.displayName = displayName;
    	}
    	
    	public String getDisplayName() {
    		return displayName;
    	}
    	
    	@Override 
    	public String toString(){
    		return this.displayName;
        }
    	
    	public static ElectricVehicleType getValFromDescription(String displayName) {
		    for (ElectricVehicleType vehicleType : values()) {
		        if (vehicleType.displayName.equals(displayName)) {
		            return vehicleType;
		        }
		    }
    	    return null;
    	}
    	
    }

    public enum CleanFuelEligibility {
        ELIGIBLE("Clean Alternative Fuel Vehicle Eligible"), 
        NOT_ELIGIBLE("Not eligible due to low battery range"), 
        UNKNOWN("Eligibility unknown as battery range has not been researched");
    	
    	private String displayName;
    	
    	CleanFuelEligibility(String displayName){
    		this.displayName = displayName;
    	}
    	
    	public String getDisplayName() {
    		return displayName;
    	}
    	
    	@Override 
    	public String toString(){
    		return this.displayName;
        }
    	
    	public static CleanFuelEligibility getValFromDescription(String displayName) {
		    for (CleanFuelEligibility cleanFuel : values()) {
		        if (cleanFuel.displayName.equals(displayName)) {
		            return cleanFuel;
		        }
		    }
    	    return null;
    	}
    }
    

    public CarModel(int modelId) {
        this.modelId = modelId;
    }

    public CarModel(String modelName, int year, double basePrice, int electricRange, String description, int makeId, ElectricVehicleType electricVehicleType, CleanFuelEligibility cleanFuelEligibility) {
        this.modelName = modelName;
        this.year = year;
        this.basePrice = basePrice;
        this.electricRange = electricRange;
        this.description = description;
        this.makeId = makeId;
        this.electricVehicleType = electricVehicleType;
        this.cleanFuelEligibility = cleanFuelEligibility;
    }

    public CarModel(int modelId, String modelName, int year, double basePrice, int electricRange, String description, int makeId, ElectricVehicleType electricVehicleType, CleanFuelEligibility cleanFuelEligibility) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.year = year;
        this.basePrice = basePrice;
        this.electricRange = electricRange;
        this.description = description;
        this.makeId = makeId;
        this.electricVehicleType = electricVehicleType;
        this.cleanFuelEligibility = cleanFuelEligibility;
    }

    public int getModelId() {
        return this.modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getElectricRange() {
        return this.electricRange;
    }

    public void setElectricRange(int electricRange) {
        this.electricRange = electricRange;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMakeId() {
        return this.makeId;
    }

    public void setMakeId(int makeId) {
        this.makeId = makeId;
    }

    public ElectricVehicleType getElectricVehicleType() {
        return this.electricVehicleType;
    }

    public void setElectricVehicleType(ElectricVehicleType electricVehicleType) {
        this.electricVehicleType = electricVehicleType;
    }

    public CleanFuelEligibility getCleanFuelEligibility() {
        return this.cleanFuelEligibility;
    }

    public void setCleanFuelEligibility(CleanFuelEligibility cleanFuelEligibility) {
        this.cleanFuelEligibility = cleanFuelEligibility;
    }

}
