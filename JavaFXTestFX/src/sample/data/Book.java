package sample.data;

public class Book {

	private int isbnBook;
	private String bookName;
	private String yearBook;


	public Book() {
		super();
	}


	public Book(int isbnBook, String bookName, String yearBook) {
		super();
		this.isbnBook = isbnBook;
		this.bookName = bookName;
		this.yearBook = yearBook;
	}


	public int getIsbnBook() {
		return isbnBook;
	}


	public void setIsbnBook(int isbnBook) {
		this.isbnBook = isbnBook;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getYearBook() {
		return yearBook;
	}


	public void setYearBook(String yearBook) {
		this.yearBook = yearBook;
	}
}
