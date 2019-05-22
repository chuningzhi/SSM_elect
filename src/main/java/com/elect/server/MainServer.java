package com.elect.server;

import com.elect.entity.Book;
import com.elect.entity.Category;
import com.elect.entity.Product;

import java.util.List;

public interface MainServer {
    List<Product> findRecommend();

    List<Product> findHot();

    Category findCategory();

    Category analyzeCategory(int id, int parent_id);

    List<Product> findProducts(int id, int page);

    int totalPage(Category category1, Category category);


    Product findProductById(int book_id);
}
