package com.lexueba.user.service;

import com.lexueba.user.dao.LoginLogDao;
import com.lexueba.user.dao.UserDao;
import com.lexueba.user.model.LoginLogDO;
import com.lexueba.user.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName, String password) {
        return userDao.getMatchCount(userName, password) > 0;
    }

    public UserDO findUserByName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Transactional
    public void loginSuccess(UserDO user) {
        user.setCredits(5 + user.getCredits());

        userDao.updateLoginInfo(user);
        LoginLogDO loginLogDO = new LoginLogDO();
        loginLogDO.setUserId(user.getUserId());
        loginLogDO.setIp(user.getLastIp());
        loginLogDO.setLoginDatetime(user.getLastVisit());
        loginLogDao.insertLoginLog(loginLogDO);
    }
}
