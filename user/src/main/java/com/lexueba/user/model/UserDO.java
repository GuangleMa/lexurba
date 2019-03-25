package com.lexueba.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserDO {
    private int userId;
    private String userName;
    private String lastIp;
    private long lastVisit;
    private int credits;
    private String password;
}
