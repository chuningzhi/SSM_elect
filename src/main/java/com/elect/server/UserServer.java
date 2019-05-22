package com.elect.server;

import com.elect.entity.User;

public interface UserServer {
    User findUserByEmail(String email);

    User regist(User user);

    void updateIsEmailVerify(int userId);

    User login(User user);
}
