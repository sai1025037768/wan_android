package com.zs.wanandroid.core.bean.login;

import java.util.List;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/25 18:55
 * @class 登录返回数据
 * {
    "collectIds": [
    3425
    ],
    "email": "1025037768@qq.com",
    "icon": "",
    "id": 6967,
    "password": "sai20090360331",
    "token": "",
    "type": 0,
    "username": "1025037768"
    }
 */
public class LoginData {


    private String username;

    private int type;

    private String token;

    private String password;

    private int id;

    private String icon;

    private String email;

    private List<Integer> collectIds;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<Integer> collectIds) {
        this.collectIds = collectIds;
    }
}
