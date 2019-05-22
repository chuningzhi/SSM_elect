package com.elect.entity;

import org.springframework.stereotype.Component;

import java.util.List;
@Component("cart")
public class Cart {
    private int id;
    private int product_id;
    private int product_num;
    private int user_id;
    private String isdele;
    private Product product;

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", product_num=" + product_num +
                ", user_id=" + user_id +
                ", isdele='" + isdele +
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

    public int getProduct_num() {
        return product_num;
    }

    public void setProduct_num(int product_num) {
        this.product_num = product_num;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getIsdele() {
        return isdele;
    }

    public void setIsdele(String isdele) {
        this.isdele = isdele;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
