package demo.model;

public class CarDiagnosis {

	private int diagnosisId;
    private String obdCode;
    private String description ;
    private int makeId;
	public CarDiagnosis(int diagnosisId, String obdCode, String description, int makeId) {
		super();
		this.diagnosisId = diagnosisId;
		this.obdCode = obdCode;
		this.description = description;
		this.makeId = makeId;
	}
	public int getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public String getObdCode() {
		return obdCode;
	}
	public void setObdCode(String obdCode) {
		this.obdCode = obdCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMakeId() {
		return makeId;
	}
	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}
    
    
    
    
    
}