package j2eeapp.model;

public class User {

	private int userId;
	private String userName;
	private String userCity;
	
	public User() {
		
	}

	public User(int id, String user, String city) {
		this.userId = id;
		this.userName = user;
		this.userCity = city;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userCity=" + userCity + "]";
	}

}
