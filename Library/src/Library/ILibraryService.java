package Library;

public interface ILibraryService {

	void createBook();

	void getAllBooks();

	void getAllBooksByActive();

	void getAuthorByName();

	void deleteBookById();

	void changeStatusToDeleted(String id);

	void applyDiscount(String id, double discountPrice);

}
