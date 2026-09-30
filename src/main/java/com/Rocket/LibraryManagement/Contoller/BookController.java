package com.Rocket.LibraryManagement.Contoller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Rocket.LibraryManagement.Service.BookService;
import java.util.Optional;
import java.util.List;

import com.Rocket.LibraryManagement.Entity.Book;

@RestController 
@RequestMapping("/book")
public class BookController {
    private final BookService bookservice;
    public BookController(BookService bookService){
        this.bookservice=bookService;

    }
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        return bookservice.addBook(book);

    }
    @GetMapping("/get")
    public Optional<Book> getBook(@RequestParam long bookId){
        return bookservice.getBookById(bookId);
    }
    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookservice.getBooks();
    }

    
}
