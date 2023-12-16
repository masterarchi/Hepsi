package Library;

import java.util.List;

public class LibraryServiceImpl implements ILibraryService {



	@Override
	public void createBook() {
		String bookName = Util.getStringValue("Kitap İsmini Girin");
		String authorName = Util.getStringValue("Yazar İsmi");
		String publisher = Util.getStringValue("Yayın Evi");
		double price = Util.getDoubleValue("Kitap Ücreti");

		String categoryName = Util.getStringValue("Kitabın kategorsini girin");
		Category category = new Category(categoryName);

		Book book = new Book(bookName, authorName, publisher, price, category);
		Main.library.getBookList().add(book);

		System.out.println(bookName + " Sisteme eklendi");
	}

	@Override
	public void getAllBooks() {
		String list = "No\tName\t\tAuthorName\t\tCategory\t\tStatus\t\tPrice\t\tID\n";
		int index = 1;
		for (int i = 0; i < Main.library.getBookList().size(); i++) {
			list += index + ".\t" + Main.library.getBookList().get(i).getName() + "\t\t"
					+ Main.library.getBookList().get(i).getAuthorName() + "\t\t"
					+ Main.library.getBookList().get(i).getCategory().getName() + "\t\t"
					+ Main.library.getBookList().get(i).geteStatus() + "\t\t"
					+ Main.library.getBookList().get(i).getPrice() + "\t\t" + Main.library.getBookList().get(i).getId()
					+ "\n";
			index++;
		}
		System.out.print(list);
	}

	@Override
	public void getAllBooksByActive() {
		List<Book> bookList = Main.library.getBookList();
		bookList.forEach(product -> System.out.println(product.getId()));

		String list = "No\tName\t\tAuthorName\t\tPrice\n";
		int index = 1;
		for (int i = 0; i < Main.library.getBookList().size(); i++) {
			if (bookList.get(i).geteStatus().equals(EStatus.ACTIVE)) {

				list += index + ".\t" + Main.library.getBookList().get(i).getName() + "\t\t"
						+ Main.library.getBookList().get(i).getAuthorName() + "\t\t"
						+ Main.library.getBookList().get(i).getPrice() + "\n";
				index++;
			}
		}
		System.out.print(list);
	}

	@Override
	public void getAuthorByName() {
		String authorName = Util.getStringValue("Aramak istediğiniz yazar issmi");
		System.out.println(authorName + " Adlı yazarın Kitapları");
		int index = 1;
		for (int i = 0; i < Main.library.getBookList().size(); i++) {
			if (Main.library.getBookList().get(i).getAuthorName().equalsIgnoreCase(authorName)) {
				System.out.println(index + "-" + Main.library.getBookList().get(i).getName());
				index++;
			}
		}
		if (index == 1) {
			System.out.println("Aradığınız yazarın kitabı kütüphanemizde mevcut değildir");
		}
	}

	@Override
	public void deleteBookById() {
		List<Book> bookList = Main.library.getBookList();
		bookList.forEach(product -> System.out.println(product.getId()));

		String id = Util.getStringValue("Silmek istediğiniz kitabın Id si");
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getId().equals(id)) {
				bookList.remove(i);
				System.out.println(bookList.get(i).getName() + " Silindi");

				return;
			}
		}
		System.out.println("Bu id ile bir kitap yok");
	}

	@Override
	public void changeStatusToDeleted(String id) {
		Book book = findById(id);
		if (book != null) {
			book.seteStatus(EStatus.DELETED);
		} else {
			System.out.println("Silmek istediğiniz ID de kitap bulunamaıştır");
		}
	}

	private Book findById(String id) {
		for (Book book : Main.library.getBookList()) {
			if (book.getId().equals(id)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public void applyDiscount(String id, double discountPrice) {
		Book book = findById(id);
		if (book != null) {
			book.setPrice(book.getPrice() - discountPrice);
		} else {
			System.out.println("Kitap bulunamamıştır");
		}
	}
	
	public void kiralamaYap (String id) {
		Book book = findById(id);
		Rent rent = new Rent(null, null, null);
		if (book != null) {
			book.setAvailable(false);
			rent.setActive(true);
			book.seteStatus(EStatus.INRENT);
			System.out.println("Kitap kiralama işlemi başarılı.");
		}else if (book.geteStatus() == EStatus.INRENT) {
            System.out.println("Kitap kiralıktır.");
        }
		else {
			System.out.println("Kitap kiralanamadı. Kitap müsait değil veya mevcut değil.");
		}
	}

	

}
