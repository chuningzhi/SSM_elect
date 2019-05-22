package com.elect.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * id INT(12) NOT NULL AUTO_INCREMENT,
 *   email VARCHAR(50) NOT NULL,
 *   nickname VARCHAR(50) DEFAULT NULL,
 *   PASSWORD VARCHAR(50) NOT NULL,
 *   user_integral INT(12) NOT NULL DEFAULT '0',
 *   is_email_verify CHAR(3),
 *   email_verify_code VARCHAR(50) DEFAULT NULL,
 *   last_login_time BIGINT DEFAULT NULL,
 *   last_login_ip VARCHAR(15) DEFAULT NULL,
 */
@Component("user")
public class User {
    private int id;
    private String email;
    private String nickname;
    private String password;
    private int user_integral;
    private String is_email_verify;
    private String email_verify_code;
    private long last_login_time;
    private String last_login_ip;

    public User() {
    }

    public User(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public User(int id, String email, String nickname, String password, int user_integral, String is_email_verify, String email_verify_code, long last_login_time, String last_login_ip) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.user_integral = user_integral;
        this.is_email_verify = is_email_verify;
        this.email_verify_code = email_verify_code;
        this.last_login_time = last_login_time;
        this.last_login_ip = last_login_ip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_integral() {
        return user_integral;
    }

    public void setUser_integral(int user_integral) {
        this.user_integral = user_integral;
    }

    public String getIs_email_verify() {
        return is_email_verify;
    }

    public void setIs_email_verify(String is_email_verify) {
        this.is_email_verify = is_email_verify;
    }

    public String getEmail_verify_code() {
        return email_verify_code;
    }

    public void setEmail_verify_code(String email_verify_code) {
        this.email_verify_code = email_verify_code;
    }

    public long getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(long last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", user_integral=" + user_integral +
                ", is_email_verify='" + is_email_verify + '\'' +
                ", email_verify_code='" + email_verify_code + '\'' +
                ", last_login_time=" + last_login_time +
                ", last_login_ip='" + last_login_ip + '\'' +
                '}';
    }
}
