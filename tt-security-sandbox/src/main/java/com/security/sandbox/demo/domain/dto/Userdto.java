package com.security.sandbox.demo.domain.dto;

import javax.persistence.*;

/**
 * @author 86151
 */
public class Userdto {

    private Integer id;

    private String username;

    private String password;

    private String name;

    private String englishName;

    private String sex;

    private Integer phone;

    /**
     * 是否被禁用（0为禁用，1为开启）
     */
    private Integer status;

    private String email;

    private String userNumber;

    /**
     * 登录次数
     */
    private Integer loginSign;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public Integer getLoginSign() {
        return loginSign;
    }

    public void setLoginSign(Integer loginSign) {
        this.loginSign = loginSign;
    }
}
