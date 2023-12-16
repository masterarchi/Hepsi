package Library;

public class Main {
	static Library library = new Library("Milli Kütüphane");

	static CustomerManager customerManager = new CustomerManager();

	static LibraryServiceImpl serviceImpl = new LibraryServiceImpl();

	public static void main(String[] args) {

		Main.library.getBookList().add(new Book("A Kitabı", "Taha", "A Yayın", 150, new Category("Hukuk")));
		Main.library.getBookList().add(new Book("B Kitabı", "Enes", "B Yayın", 200, new Category("Mimarlık")));
		Main.library.getBookList().add(new Book("C Kitabı", "Cinli", "C Yayın", 300, new Category("Tıp")));
		Main.library.getBookList().add(new Book("D Kitabı", "Muharrem", "D Yayın", 350, new Category("Bilişim")));

		// Customer(String username, String password, String tc, double balance) {
		// Customer customer = new Customer("Taha","123456","154562",12345);
		// (String name, String authorName, String publisher, double price, Category
		// category) {
		// Book book = new Book();
		// Rent rent = new Rent("1", customer, book);
		librarySystemMenu();
	}

	public static void systemMenu() {

		while (true) {
			System.out.println("1- Sisteme Kitap Ekle");
			System.out.println("2- Bütün Kitapları listele");
			System.out.println("3- Aktif Olan Kitapları listele");
			System.out.println("4- Yazara Göre Arama Yap");
			System.out.println("5- Id'ye Göre Kitap Sil");
			System.out.println("6- Statusunu Değiştir");
			System.out.println("7- İndirim Uygula");
			System.out.println("8- Kitap Kirala");
			System.out.println("9- Müşteri Ekle");
			System.out.println("10- Müşteri Sil");
			System.out.println("11- Müşteri Ara");
			System.out.println("12- Müşteri Listele");

			System.out.println("0- Log out");
			int secim = Util.getIntegerValue("Seçiminizi girin");
			String id = "";

			switch (secim) {
			case 1:
				serviceImpl.createBook();
				break;
			case 2:
				serviceImpl.getAllBooks();
				break;
			case 3:
				serviceImpl.getAllBooksByActive();
				break;
			case 4:
				serviceImpl.getAuthorByName();
				break;
			case 5:
				serviceImpl.deleteBookById();
				break;
			case 6:
				serviceImpl.getAllBooks();
				id = Util.getStringValue("Silmek istediğin kitabın ID sini gönder");
				serviceImpl.changeStatusToDeleted(id);
				break;
			case 7:
				serviceImpl.getAllBooks();
				id = Util.getStringValue("İndirim Yapmak istediğin kitabın ID sini gönder");
				double discountPrice = Util.getDoubleValue("Ne kadar inidim yapmak istiyorsunuz");
				serviceImpl.applyDiscount(id, discountPrice);
				break;
			case 8:
				serviceImpl.getAllBooks(); //kiralama sonrası status inrent'e çekildi
				id = Util.getStringValue("Kiralama Yapmak istediğin kitabın ID sini gönder");
				serviceImpl.kiralamaYap(id);
				break;
			case 9:
				String ad = Util.getStringValue("Müşteri Adı: ");
				String soyad = Util.getStringValue("Müşteri Soyadı: ");
				String telefon = Util.getStringValue("Telefon Numarası: ");
				double bakiye = Util.getDoubleValue("Bakiye: ");

				Customer yeniMüşteri = new Customer(ad, soyad, telefon, bakiye);
				customerManager.musteriEkle(yeniMüşteri);
				break;
			case 10:
				customerManager.musterileriListele();
				int silinecekMüşteriId = Util.getIntegerValue("Silmek istediğiniz müşterinin ID'sini girin: ");
				customerManager.musteriSil(silinecekMüşteriId);
				break;
			case 11:
				System.out.println("Müşteri Listesi:");
				customerManager.musterileriListele();
				System.out.println("Aramak istediğiniz ID'yi yazınız:");
				int arananMusteriID = Util.getIntegerValue("Aramak istediğiniz müşteri ID'sini girin: ");
				Customer arananMusteri = customerManager.musteriAra(arananMusteriID);

				if (arananMusteri != null) {
					System.out.println("Aranan Müşteri Bilgileri:");
					System.out.println("ID: " + arananMusteri.getMusteriId());
					System.out.println("Ad: " + arananMusteri.getAd());
				} else {
					System.out.println("Müşteri bulunamadı.");
				}
				break;
			case 12:
				customerManager.musterileriListele();
			    break;
			case 0:
				librarySystemMenu();
				break;

			default:
				break;
			}
		}
	}

	public static void librarySystemMenu() {
		System.out.println("1- Admin Girişi");
		System.out.println("2- User İşlemleri");
		System.out.println("0- Sistemi Kapat");

		while (true) {
			int secim = Util.getIntegerValue("Seçiminizi girin");

			switch (secim) {
			case 1:
				systemMenu();
				break;
			case 2:
				userPage();
				break;
			case 0:
				System.out.println("Sistem kapandı");
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}

	public static void userPage() {
		while (true) {
			System.out.println("1- Register");
			System.out.println("2- Login");
			System.out.println("0- Sistemi Kapat");
			int secim = Util.getIntegerValue("Seçiminizi girin");
			switch (secim) {
			case 1:
				customerManager.register();
				break;
			case 2:
				Customer customer = customerManager.login();
				if (customer != null) {
					userApplication(customer);
				}
				break;
			case 0:
				System.out.println("Sistem kapandı");
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}

	public static void userApplication(Customer customer) {
		while (true) {
			System.out.println("Hoşgeldiniz " + customer.getUsername());
			int secim = Util.getIntegerValue("Seçiminizi girin");
			switch (secim) {
			case 1:

				break;
			case 0:
				System.out.println("Sistem kapandı");
				System.exit(0);
				break;

			default:
				break;
			}
		}

	}

}
