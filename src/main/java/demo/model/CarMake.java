package demo.model;

public class CarMake {
    protected int makeId;
    protected String makeName;
    protected String description;
    
    public CarMake(int makeId, String makeName, String description) {
        this.makeId = makeId;
        this.makeName = makeName;
        this.description = description;
    }

    public CarMake(int makeId) {
        this.makeId = makeId;
    }

    public CarMake(String makeName, String description) {
        this.makeName = makeName;
        this.description = description;
    }

    public int getMakeId() {
        return this.makeId;
    }

    public void setMakeId(int makeId) {
        this.makeId = makeId;
    }

    public String getMakeName() {
        return this.makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
