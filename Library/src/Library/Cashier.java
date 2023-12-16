package Library;

public class Cashier extends User {

	private String email;

	public Cashier(String username, String password, String email) {
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
