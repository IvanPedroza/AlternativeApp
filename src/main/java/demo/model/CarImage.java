package demo.model;

import java.sql.Blob;

public class CarImage {

	private int imageId;
	private int modelId;
	private String title;
	private String description;
	private Blob image;
	
	public CarImage(int imageId, int modelId, String title, String description, Blob image) {
		super();
		this.imageId = imageId;
		this.modelId = modelId;
		this.title = title;
		this.description = description;
		this.image = image;
	}

	public CarImage(int modelId, String title, String description, Blob image) {
		super();
		this.modelId = modelId;
		this.title = title;
		this.description = description;
		this.image = image;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
	
}
