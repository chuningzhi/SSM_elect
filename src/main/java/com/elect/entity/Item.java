package com.elect.entity;

import org.springframework.stereotype.Component;

/**
 * id INT(12) NOT NULL AUTO_INCREMENT,
 *   order_id INT(10) NOT NULL,
 *   product_id INT(10) NOT NULL,
 *   product_name VARCHAR(100) NOT NULL,
 *   dang_price DOUBLE NOT NULL,
 *   product_num INT(10) NOT NULL,
 *   amount DOUBLE NOT NULL,
 */
@Component("item")
public class Item {
    private int id;         //ID
    private int order_id;       //订单ID；
    private int product_id;     //商品ID
    private String product_name;    //商品名称
    private double dang_price;   //当当价格
    private int product_num;    //数量
    private double amount; //总价

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", dang_price=" + dang_price +
                ", product_num=" + product_num +
                ", amount=" + amount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getDang_price() {
        return dang_price;
    }

    public void setDang_price(double dang_price) {
        this.dang_price = dang_price;
    }

    public int getProduct_num() {
        return product_num;
    }

    public void setProduct_num(int product_num) {
        this.product_num = product_num;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
