package com.elect.entity;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * id INT(10) NOT NULL AUTO_INCREMENT,
 *   user_id INT(10) NOT NULL,
 *   STATUS INT(10) NOT NULL,
 *   order_time BIGINT(20) NOT NULL,
 *   order_desc VARCHAR(100) DEFAULT NULL,
 *   total_price DOUBLE NOT NULL,
 *
 *   receive_name VARCHAR(100) DEFAULT NULL,
 *   full_address VARCHAR(200) DEFAULT NULL,
 *   postal_code VARCHAR(8) DEFAULT NULL,
 *   mobile VARCHAR(20) DEFAULT NULL,
 *   phone VARCHAR(20) DEFAULT NULL,
 */
@Component("order")
public class Order {
    private int id;   //ID
    private int user_id;      //用户ID
    private int status;     //状态
    private long order_time;    //订单创建时间
    private String order_desc;  //
    private double total_price; //总价格
    private String receive_name;    //收件人姓名
    private String full_address;    //收件人详细地址
    private String postal_code;     //邮编
    private String mobile;      //电话
    private String phone;       //手机
    private List<Item> items;

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", status=" + status +
                ", order_time=" + order_time +
                ", order_desc='" + order_desc + '\'' +
                ", total_price=" + total_price +
                ", receive_name='" + receive_name + '\'' +
                ", full_address='" + full_address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone='" + phone + '\'' +
                ", items=" + items +
                '}';
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getOrder_time() {
        return order_time;
    }

    public void setOrder_time(long order_time) {
        this.order_time = order_time;
    }

    public String getOrder_desc() {
        return order_desc;
    }

    public void setOrder_desc(String order_desc) {
        this.order_desc = order_desc;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getReceive_name() {
        return receive_name;
    }

    public void setReceive_name(String receive_name) {
        this.receive_name = receive_name;
    }

    public String getFull_address() {
        return full_address;
    }

    public void setFull_address(String full_address) {
        this.full_address = full_address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
