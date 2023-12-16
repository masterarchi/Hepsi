package Library;

public class Rent {

	
	private String rentID;
	private Customer customer;
	private Book book;
	private boolean active;

	public Rent(String rentID, Customer customer, Book book) {
		this.rentID = rentID;
		this.customer = customer;
		this.book = book;
		this.active = true;
	}

	

	public String getRentID() {
		return rentID;
	}

	public void setRentID(String rentID) {
		this.rentID = rentID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
