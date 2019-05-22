package com.elect.server;

import com.elect.entity.Book;
import com.elect.entity.Product;

import java.util.List;

public interface AdminBookServer {
    void updateProduct(Product product, List<Integer> cids);

    void deleteBook(int pid);

    int addProduct(Product product);

    void insertBook(Book book);

    void addCategoryProduct(int pid, int cid);
}
