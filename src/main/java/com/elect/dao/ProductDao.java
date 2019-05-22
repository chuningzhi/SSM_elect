package com.elect.dao;

import com.elect.entity.Book;
import com.elect.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public interface ProductDao {
    Product findProductById(int product_id);

    List<Product> findProductsByIds(List<Integer> list);

    List<Product> findProducts(@Param("id") int id, @Param("page") int page,@Param("pageSize") int pageSize);

    List<Product> findAllProduct();

    void updateProduct(Product product);

    void deleteProduct(int pid);

    void addProduct(Product product);
}
