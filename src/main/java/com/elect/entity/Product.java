package com.elect.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

/**
 * id INT(12) NOT NULL AUTO_INCREMENT,
 *   product_name VARCHAR(100) NOT NULL,
 *   description VARCHAR(100) DEFAULT NULL,
 *   add_time BIGINT(20) DEFAULT NULL,
 *   fixed_price DOUBLE NOT NULL,
 *   dang_price DOUBLE NOT NULL,
 *   keywords VARCHAR(200) DEFAULT NULL,
 *   has_deleted INT(1) NOT NULL DEFAULT '0',
 *   product_pic VARCHAR(200) DEFAULT NULL,
 */
@Component("product")
public class Product implements Serializable {
    private int id;
    private String product_name;
    private String description;
    private long add_time;
    private double fixed_price;
    private double dang_price;
    private String keywords;
    private int has_deleted;
    private String product_pic;
    private Book book;

    public Product() {
    }

    public Product(int id, String product_name,
                    String description, long add_time,
                    double fixed_price, double dang_price,
                    String keywords, int has_deleted, String product_pic) {
        this.id = id;
        this.product_name = product_name;
        this.description = description;
        this.add_time = add_time;
        this.fixed_price = fixed_price;
        this.dang_price = dang_price;
        this.keywords = keywords;
        this.has_deleted = has_deleted;
        this.product_pic = product_pic;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", add_time=" + add_time +
                ", fixed_price=" + fixed_price +
                ", dang_price=" + dang_price +
                ", keywords='" + keywords + '\'' +
                ", has_deleted=" + has_deleted +
                ", product_pic='" + product_pic + '\'' +
                ", book=" + book +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(long add_time) {
        this.add_time = add_time;
    }

    public double getFixed_price() {
        return fixed_price;
    }

    public void setFixed_price(double fixed_price) {
        this.fixed_price = fixed_price;
    }

    public double getDang_price() {
        return dang_price;
    }

    public void setDang_price(double dang_price) {
        this.dang_price = dang_price;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getHas_deleted() {
        return has_deleted;
    }

    public void setHas_deleted(int has_deleted) {
        this.has_deleted = has_deleted;
    }

    public String getProduct_pic() {
        return product_pic;
    }

    public void setProduct_pic(String product_pic) {
        this.product_pic = product_pic;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                add_time == product.add_time &&
                Double.compare(product.fixed_price, fixed_price) == 0 &&
                Double.compare(product.dang_price, dang_price) == 0 &&
                has_deleted == product.has_deleted &&
                Objects.equals(product_name, product.product_name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(keywords, product.keywords) &&
                Objects.equals(product_pic, product.product_pic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product_name, description, add_time, fixed_price, dang_price, keywords, has_deleted, product_pic);
    }
}
