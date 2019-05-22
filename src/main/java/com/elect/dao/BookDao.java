package com.elect.dao;

import com.elect.entity.Book;
import com.elect.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookDao")
public interface BookDao {

    Book findBookById(int ranInt) throws Exception;

    List<Book> findAllBook();

    void updateBook(Book book);

    void deleteBook(int pid);

    void addBook(Book book);
}
