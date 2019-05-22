package com.elect.dao;

import com.elect.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {

    User findUserByEmail(String email);

    int addUser(User user);

    void verify(User user);

    User login(User user);

    void updateIsEmailVerify(int userId);
}
