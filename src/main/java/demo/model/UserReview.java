package demo.model;

public class UserReview {

	private int reviewId;
	private int modelId;
	private String userName;
	private float rating;
	private String reviewTitle;
	private String reviewComment;
	
	public UserReview(int reviewId, int modelId, String userName, float rating, String reviewTitle,
			String reviewComment) {
		super();
		this.reviewId = reviewId;
		this.modelId = modelId;
		this.userName = userName;
		this.rating = rating;
		this.reviewTitle = reviewTitle;
		this.reviewComment = reviewComment;
	}

	public UserReview(int modelId, String userName, float rating, String reviewTitle, String reviewComment) {
		super();
		this.modelId = modelId;
		this.userName = userName;
		this.rating = rating;
		this.reviewTitle = reviewTitle;
		this.reviewComment = reviewComment;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	
}
