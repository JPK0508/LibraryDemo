package com.library_mangmt_sys.LibraryDemo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String Adress;
    private Long PhoneNumber;
    private List<Book> listOfBooks; //Entity relationship One member can have many books

    public boolean isBorrowed() {
        return Borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        Borrowed = borrowed;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public Long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public boolean isReturned() {
        return Returned;
    }

    public void setReturned(boolean returned) {
        Returned = returned;
    }

    private boolean Borrowed;
    private  boolean Returned;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<String> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    private List<String> borrowedBooks;

}

