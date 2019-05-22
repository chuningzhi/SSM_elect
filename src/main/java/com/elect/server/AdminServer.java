package com.elect.server;

import com.elect.entity.Admin;
import com.elect.entity.Category;
import com.elect.entity.Product;

import java.util.List;
import java.util.Map;

public interface AdminServer {
    Admin login(Admin admin);

    List<Category> findCategorysById(int id);

    List<Product> findAllProduct();

    Product findProductByid(int pid);

    Map<String, Integer> judgeCate(List<Integer> cateIds, Category category);

    List<Integer> findCateIdByProductId(int pid);

    void addCategory(Category category);

    Category findCategoryById(int cid);

    void deleteCategory(int cid);

    void updateCategory(Category category);
}
