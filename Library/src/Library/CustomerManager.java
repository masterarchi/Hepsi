package Library;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

	private List<Customer> customers;
	private int nextCustomerId = 1;

	public int getNextCustomerId() {
		return nextCustomerId;
	}

	public void setNextCustomerId(int nextCustomerId) {
		this.nextCustomerId = nextCustomerId;
	}

	public CustomerManager() {
		this.customers = new ArrayList<>(); 
	}

	public void register() {

		String username = Util.getStringValue("Kullanıcı Adı Girin:");
		String password = Util.getStringValue("Şifre Girin:");
		String tc = Util.getStringValue("Tc Girin:");
		double balance = Util.getDoubleValue("Bakiye Yükleyin");

		Customer customer = new Customer(username, password, tc, balance);
		Main.library.getCustomerList().add(customer);

		System.out.println("Kayıt Başarılı Sisteme Hoşgeldiniz " + username);
	}

	public Customer login() {
		String username = Util.getStringValue("Kullanıcı Adı Girin:");
		Customer customer = findByUsername(username);
		if (customer != null) {
			for (int i = 3; i > 0; i--) {
				String password = Util.getStringValue("Şifre Girin:");
				if (customer.getPassword().equals(password)) {
					System.out.println("Giriş başarılı");
					return customer;
				} else {
					System.out.println("Şifre yanlış" + (i - 1) + " Kadar hakkınız kaldı");
				}
			}

			System.out.println("Hesabınız askıya alındı");
			return customer;
		} else {
			System.out.println("Kullanıcı Bulanamadıı");
			return customer;
		}

	}

	private Customer findByUsername(String username) {
		for (Customer customer : Main.library.getCustomerList()) {
			if (customer.getUsername().equals(username)) {
				return customer;
			}
		}
		return null;
	}

	public void musteriEkle(Customer customer) {
		customer.setMusteriId(nextCustomerId); 
        nextCustomerId++; 
        customers.add(customer);
        System.out.println("Müşteri eklendi: " + customer.getAd());
        }

	public void musteriSil(int musteriId) {
		Customer customer = musteriAra(musteriId);
		if (customer != null) {
			customers.remove(customer);
			System.out.println("Müşteri silindi: " + customer.getAd());
		} else {
			System.out.println("Müşteri bulunamadı.");
		}
	}

	public Customer musteriAra(int musteriId) {
		for (Customer customer : customers) {
			if (customer.getMusteriId() == musteriId) {
				return customer;
			}
		}
		return null;
	}

	public void musterileriListele() {
		System.out.println("Müşteri Listesi:");
		for (Customer customer : customers) {
			System.out.println("ID: " + customer.getMusteriId() + ", Ad: " + customer.getAd());
		}
	}

}
