package com.library_mangmt_sys.LibraryDemo.service;

import com.library_mangmt_sys.LibraryDemo.entity.Book;
import com.library_mangmt_sys.LibraryDemo.entity.Member;
import com.library_mangmt_sys.LibraryDemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    public BookRepository bookRepository;


    public Optional<Book> getBookById(Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        return byId;

    }


    public Book addBook(Book book) {
        Optional<Book> memberById = getBookById(book.getId());
        if (memberById.isPresent()) {
            throw new RuntimeException("Member Already Exist");
        } else {
            Book save = bookRepository.save(book);
            return save;
        }
    }

    public List<Book>getallbooks(){
        List<Book> all = bookRepository.findAll();
        return all;
    }

    public Long removeBook(Long id){
       Long bkId =0L;
        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Book Is Not Exist");
        }
        return bkId;
    }

    public String borrowbook(Long id){
        Optional<Book> book = bookRepository.findById(id);

        if (book.isEmpty()){
           throw new RuntimeException("Book Not Found");
        }
        if ((book.isPresent())){
            throw new RuntimeException("Book Is Availablee");
        }
        Book books = book.get();
        books.setBorrowed(true);
        bookRepository.save(books);
        return "Book is successfully borrowed by Member";
    }

    public String returnbook(Long id){
        Optional<Book> bookOptional = bookRepository.findById(id);

        if(bookOptional.isEmpty()){
            throw new RuntimeException("Book is Not Returned");
        }
        Book b = bookOptional.get();
         b.setReturned(true);
         bookRepository.save(b);
        return "Book Returned Successfully.";
    }

    public Book updateBookById(Long id,Book book){
        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isPresent()){
            Book existingBook = optional.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setId(book.getId());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());

            return bookRepository.save(existingBook);
        }
        else {
            throw new RuntimeException("Book with id" + id + "Not found");

        }

    }

}
