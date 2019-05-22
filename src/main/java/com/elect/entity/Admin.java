package com.elect.entity;

import org.springframework.stereotype.Component;

@Component("admin")
public class Admin {
    private int id;
    private String name;
    private String password;
    private int admin_grade;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", admin_grade=" + admin_grade +
                '}';
    }

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin_grade() {
        return admin_grade;
    }

    public void setAdmin_grade(int admin_grade) {
        this.admin_grade = admin_grade;
    }
}
