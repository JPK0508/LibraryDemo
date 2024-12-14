package com.library_mangmt_sys.LibraryDemo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name="Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String title;
    private boolean isAvailable;

    private double price;
    private String Author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public boolean isBorrowed() {
        return Borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        Borrowed = borrowed;
    }

    public boolean isReturned() {
        return Returned;
    }

    public void setReturned(boolean returned) {
        Returned = returned;
    }

    private boolean Borrowed;
    private  boolean Returned;

}
