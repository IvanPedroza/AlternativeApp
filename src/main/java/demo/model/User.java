package demo.model;

public class User {
  private String userName;
  private String password;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String addressLine1;
  private String addressLine2;
  private Location location;

  public User(String userName, String password, String firstName, String lastName, String email,
              String phoneNumber, String addressLine1, String addressLine2, Location location) {
    this.userName = userName;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.location = location;
  }

  public User(String userName) {
    this.userName = userName;
  }

  public User(String password, String firstName, String lastName, String email, String phoneNumber,
              String addressLine1, String addressLine2, Location location) {
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.location = location;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
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

  public Location getLocation() {
    return location;
  }

  public void setLocationId(Location location) {
    this.location = location;
  }
}
