package com.zeeshan.sb.graphql.contoroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.zeeshan.sb.graphql.model.Book;
import com.zeeshan.sb.graphql.model.BookInput;
import com.zeeshan.sb.graphql.repository.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@SchemaMapping(typeName = "Query", value = "allBooks")
	public List<Book> getAllBooks() {
		return bookRepository.allBooks();
	}

//	@QueryMapping
	@SchemaMapping(typeName = "Query", value = "bookById")
	public Book getBookById(@Argument Integer id) {
		return bookRepository.bookById(id);
	}
	
	@MutationMapping
	public Book addBook(@Argument BookInput book) {
		System.out.println("BookInput ---> " + book);
		return bookRepository.addNewBook(book);
	}

	@MutationMapping
//	@SchemaMapping(typeName = "Mutation", value = "updateBook")
	public Book updateBook(@Argument Integer id, @Argument String title) {
		return bookRepository.updateBook(id, title);
	}
}
