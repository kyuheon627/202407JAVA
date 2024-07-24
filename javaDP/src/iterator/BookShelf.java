package iterator;

import java.util.Iterator;

public class BookShelf implements Iterable<Book>{

	private Book[] books;
	private int last = 0;
	
	// 반복자 책들을 모두 가져 올 수 있도록 준비
	@Override
	public Iterator<Book> iterator() {
		return new BookShelfIterator(this);
	}
	
	// 생성자
	public BookShelf(int maxsize) {
		this.books = new Book[maxsize];
	}
	
	// 해당 인덱스의 책을 리턴
	public Book getBookAt(int index) {
		return books[index];
	}
	
	// 책을 추가
	public void appendBook(Book book) {
		this.books[last] = book;
		last++;
	}
	
	// 책들의 총 개수
	public int getLength() {
		return last;
	}

}
