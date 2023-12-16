package Library;

import java.time.LocalDateTime;

public abstract class User {

	private String username;
	private String password;
	private LocalDateTime signDate;
	
	
	public User() {

	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.signDate = LocalDateTime.now();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getSignDate() {
		return signDate;
	}
	public void setSignDate(LocalDateTime signDate) {
		this.signDate = signDate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
