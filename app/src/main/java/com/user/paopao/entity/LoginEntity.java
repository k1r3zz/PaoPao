package com.user.paopao.entity;

import java.io.Serializable;

/**
 * author :kira
 * date: 2018/1/30.
 * description:登录数据
 */

public class LoginEntity implements Serializable {

    private String login_token;
    private String nickname;
    private String paoid;

    public String getToken() {
        return login_token;
    }

    public void setToken(String token) {
        this.login_token = token;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUser() {
        return paoid;
    }

    public void setUser(String user) {
        this.paoid = user;
    }
}
