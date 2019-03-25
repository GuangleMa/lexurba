package com.lexueba.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginLogDO {
    private int userId;
    private int loginLogId;
    private String ip;
    private long loginDatetime;
}
