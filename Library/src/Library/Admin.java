package Library;

public class Admin extends User {

	private String email;

	public Admin(String username, String password, String email) {
		super(username, password);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
