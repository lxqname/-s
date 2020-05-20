package com.honor.liuxinquan.day1104.jdk;

public class UserImpl implements IUser {
    @Override
    public void login() {
        System.out.println(1);
    }

    @Override
    public void loginOut() {
        System.out.println(2);
    }
}
