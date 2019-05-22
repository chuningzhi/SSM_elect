package com.elect.server.impl;

import com.elect.dao.UserDao;
import com.elect.entity.User;
import com.elect.server.UserServer;
import com.elect.utils.CodeUtil;
import com.elect.utils.SendMail;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userServer")
public class UserServerImpl implements UserServer {
    @Resource(name = "userDao")
    private UserDao userDao;
    @Resource(name = "codeUtil")
    private CodeUtil codeUtil;


    private Logger logger = Logger.getLogger(UserServerImpl.class);
    @Override
    public User findUserByEmail(String email) {
        User user = userDao.findUserByEmail(email);
        return user;
    }

    @Override
    public User regist(User user) {
        String emailvCode = codeUtil.emailVCode();
        logger.info("server中的emailvCode："+emailvCode);
        SendMail.sendMail(user.getEmail(),emailvCode);
        user.setEmail_verify_code(emailvCode);
        user.setLast_login_time(System.currentTimeMillis());
        userDao.addUser(user);
        return user;
    }

    @Override
    public void updateIsEmailVerify(int userId) {
        userDao.updateIsEmailVerify(userId);
    }

    @Override
    public User login(User user) {
        user = userDao.login(user);
        return user;
    }
}
