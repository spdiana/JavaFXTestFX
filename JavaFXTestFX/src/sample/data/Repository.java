package sample.data;


import java.util.ArrayList;


public class Repository  {

	private static ArrayList<Book> bdBook = new ArrayList<>();

	public static void add(Book Book) {
		bdBook.add(Book);
	}

	public static void update(Book book) {
		int index = 0;
		for (int i = 0; i < bdBook.size(); i++) {
			if (book.getIsbnBook() == bdBook.get(i).getIsbnBook()){
				index = i;
				break;
			}
		}
		bdBook.set(index, book);
	}

	public static void remove(Book book) {
		bdBook.remove(book);
	}

	public static Book find(String bookName) {
		Book ret = null;
		for (int i = 0; i < bdBook.size(); i++) {
			if (bookName.equals(bdBook.get(i).getBookName())){
				ret = bdBook.get(i);
				break;
			}
		}
		return ret;
	}

	public static ArrayList<Book> listAll() {
		return bdBook;
	}

	public static ArrayList<String> listAllBookName() {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < bdBook.size(); i++) {
			list.add(bdBook.get(i).getBookName());
		}
		return list;
	}


	public static void loadRepository() {
		Book a1 = new Book(1, "C++ for Dumnies", "1994");
		Book a2 = new Book(2, "C++ how to program", "1992");
		Book a3 = new Book(3, "Kotlin in Action", "2016");
		bdBook.add(a1);
		bdBook.add(a2);
		bdBook.add(a3);
	}

}
