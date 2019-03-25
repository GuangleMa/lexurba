package com.lexueba.user.web.vo.request;

import lombok.Data;

@Data
public class LoginCommand {
    private String userName;
    private String password;
}
