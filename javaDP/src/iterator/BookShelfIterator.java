package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> {

	private BookShelf bookShelf;
	private int index;
	
	// 생성자
	public BookShelfIterator(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
		this.index = 0;
	}
	
	// 다음 책 있나요
	@Override
	public boolean hasNext() {

		if (index < bookShelf.getLength()) {
			return true;
		}else {
			return false;			
		}
		
	}

	@Override
	public Book next() {

		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
		
	}

}
