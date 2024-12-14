package com.library_mangmt_sys.LibraryDemo.repository;

import com.library_mangmt_sys.LibraryDemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
