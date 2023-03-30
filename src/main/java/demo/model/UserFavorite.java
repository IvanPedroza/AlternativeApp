package demo.model;

public class UserFavorite {
	
  private int favoriteId;
  private String userName;
  private int modelId;
  private boolean favorite;

  public UserFavorite(int favoriteId, String userName, int modelId, boolean favorite) {
    this.favoriteId = favoriteId;
    this.userName = userName;
    this.modelId = modelId;
    this.favorite = favorite;
  }

  public UserFavorite(String userName, int modelId, boolean favorite) {
    this.userName = userName;
    this.modelId = modelId;
    this.favorite = favorite;
  }

  public int getFavoriteId() {
    return favoriteId;
  }

  public void setFavoriteId(int favoriteId) {
    this.favoriteId = favoriteId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public int getModelId() {
    return modelId;
  }

  public void setModelId(int modelId) {
    this.modelId = modelId;
  }

  public boolean isFavorite() {
    return favorite;
  }

  public void setFavorite(boolean favorite) {
    this.favorite = favorite;
  }
}
