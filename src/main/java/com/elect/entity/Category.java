package com.elect.entity;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * id INT(12) NOT NULL AUTO_INCREMENT,
 *   turn INT(10) NOT NULL,
 *   en_name VARCHAR(200) NOT NULL,
 *   NAME VARCHAR(200) NOT NULL,
 *   description VARCHAR(200),
 *   parent_id INT(10),
 */
@Component("category")
public class Category {
    private int id;
    private int turn;
    private String en_name;
    private String name;
    private String description;
    private int parent_id;
    private List<Category> categories;
    private List<CategoryProduct> categoryProducts;

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", turn=" + turn +
                ", en_name='" + en_name + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", parent_id=" + parent_id +
                ", categoryProducts=" + categoryProducts +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<CategoryProduct> getCategoryProducts() {
        return categoryProducts;
    }

    public void setCategoryProducts(List<CategoryProduct> categoryProducts) {
        this.categoryProducts = categoryProducts;
    }

}
