package com.Rocket.LibraryManagement.Service;

import java.util.List;
import java.util.Optional;

import com.Rocket.LibraryManagement.Entity.Book;
import com.Rocket.LibraryManagement.Repository.BookRepo;

public class BookService {
    private final BookRepo bookRepo;
    public BookService(BookRepo bookRepo){
        this.bookRepo=bookRepo;
    }
    public Book addBook(Book book){
        return bookRepo.save(book);
    }
    public Optional<Book> getBookById(long bookId){
        return bookRepo.findById(bookId);
    }
    public List<Book> getBooks(){
        return bookRepo.findAll();
    }
}
