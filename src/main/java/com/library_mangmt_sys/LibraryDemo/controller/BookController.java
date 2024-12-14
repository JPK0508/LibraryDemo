package com.library_mangmt_sys.LibraryDemo.controller;

import com.library_mangmt_sys.LibraryDemo.entity.Book;
import com.library_mangmt_sys.LibraryDemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/library")

public class BookController {

    @Autowired
    public BookService bookService;


    @PostMapping(path = "/addbook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book addedBook = bookService.addBook(book);
        return ResponseEntity.status(200).body(addedBook);
    }

    @DeleteMapping(path = "/deletebook/{bookid}")
    public String deletebookbyid(@PathVariable Long bookid) {
        Long aLong = bookService.removeBook(bookid);
        System.out.println(aLong);
        return "Book Removed Succesfully" + bookid;
    }

    @GetMapping(path = "/getallbooks")
    public List<Book> getallbooks() {
        List<Book> allbooks = bookService.getallbooks();
        return allbooks;
    }

    @PostMapping(path = "/borrowbook")
    public String borrowbook( @RequestParam Long bookid) {
        return bookService.borrowbook(bookid);
    }

    @PostMapping(path = "/returnbook")
    public String returnbook(@RequestParam Long bookid) {
        return bookService.returnbook(bookid);
    }

    @PutMapping (path = "/updateBook")
    public Book updateBookById(@RequestBody Book book,@RequestParam Long id){
       Book b= bookService.updateBookById(id,book);
       return b;
    }


}
