package com.lexueba.user.dao;

import com.lexueba.user.model.UserDO;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@ContextConfiguration("classpath*:/smart-context.xml")
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private UserDao userDao;

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testFindUserByUserName() {
        UserDO user = userDao.findUserByUserName("admin");
        Assert.assertEquals(user.getUserName(), "admin");
    }

    @Test
    public void testUpdateLoginInfo() {
    }
}