package com.lexueba.user.dao;

import com.lexueba.user.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserDao {

    private static final String MATCH_COUNT_SQL = " SELECT count(1) FROM t_user WHERE user_name = ? and password = ? ";
    private  final static String UPDATE_LOGIN_INFO_SQL = " UPDATE t_user SET last_visit=?,last_ip=?,credits=?  WHERE user_id =?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName, String password) {
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }

    public UserDO findUserByUserName(final String userName) {
        String sqlStr = " SELECT user_id, user_name, credits FROM t_user WHERE user_name = ? ";
        final UserDO user = new UserDO();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setCredits(resultSet.getInt("credits"));
                user.setUserName(userName);
            }
        });
        return user;
    }

    public void updateLoginInfo(UserDO user) {
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, user.getLastVisit(),
                user.getLastIp(),user.getCredits(),user.getUserId());
    }

}
