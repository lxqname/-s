package com.security.sandbox.demo.domain.eo;

import javax.persistence.*;

/**
 * @author 86151
 */
@Entity
@Table(name = "user")
public class Usereo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String name;

    @Column(name = "english_name")
    private String englishName;

    private String sex;

    private Integer phone;

    /**
     * 是否被禁用（0为禁用，1为开启）
     */
    private Integer status;

    private String email;

    @Column(name = "user_number")
    private String userNumber;

    /**
     * 登录次数
     */
    @Column(name = "login_sign")
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
