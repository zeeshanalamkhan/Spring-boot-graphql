package com.zeeshan.sb.graphql.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zeeshan.sb.graphql.model.Author;
import com.zeeshan.sb.graphql.model.Book;
import com.zeeshan.sb.graphql.model.BookInput;

@Component
public class BookRepository {

	private static List<Book> books;

	static {
		Book book1 = new Book(1, "Graphql Overview", 100, new Author("Zeeshan"));
		Book book2 = new Book(2, "Spring Overview", 100, new Author("Satinder"));
		books = List.of(book1, book2);
	}

	public List<Book> allBooks() {
		return books;
	}

	public Book bookById(Integer id) {
		for (Book book : books) {
			System.out.println("id ---> " + id);
			if (id == book.getId()) {
				return book;
			}
		}
		return null;
	}

	public Book addNewBook(BookInput book) {
		books.add(new Book(book.getId(), book.getTitle(), book.getPages(), book.getAuthor()));
		if (book != null) {
			return bookById(book.getId());
		}
		return null;
	}

	public Book updateBook(Integer id, String title) {
		Book book = bookById(id);
		if (book != null) {
			book.setTitle(title);
		}
		return book;
	}
}
