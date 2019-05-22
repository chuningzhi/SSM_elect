package com.elect.entity;

import org.springframework.stereotype.Component;

/**
 *  id INT(12) NOT NULL AUTO_INCREMENT,
 *   user_id INT(11) NOT NULL,
 *   receive_name VARCHAR(20) NOT NULL,
 *   full_address VARCHAR(200) NOT NULL,
 *   postal_code VARCHAR(8) NOT NULL,
 *   mobile VARCHAR(15) DEFAULT NULL,
 *   phone VARCHAR(20) DEFAULT NULL,
 */
@Component("address")
public class Address {
    private int id;
    private int user_id;
    private String receive_name;
    private String full_address;
    private String postal_code;
    private String mobile;
    private String phone;

    public Address() {
    }

    public Address(int id, int user_id, String receive_name, String full_address, String postal_code, String mobile, String phone) {
        this.id = id;
        this.user_id = user_id;
        this.receive_name = receive_name;
        this.full_address = full_address;
        this.postal_code = postal_code;
        this.mobile = mobile;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", receive_name='" + receive_name + '\'' +
                ", full_address='" + full_address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone='" + phone + '\'' +
                '}';
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
