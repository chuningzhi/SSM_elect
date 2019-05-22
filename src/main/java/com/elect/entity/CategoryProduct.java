package com.elect.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("categoryProduct")
public class CategoryProduct {
    private int id;
    private int product_id;
    private int cat_id;
    private List<Product> products;

    public CategoryProduct() {
    }

    public CategoryProduct(int id, int product_id, int cat_id) {
        this.id = id;
        this.product_id = product_id;
        this.cat_id = cat_id;
    }

    @Override
    public String toString() {
        return "CategoryProduct{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", cat_id=" + cat_id +
                ", products=" + products +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
