package com.honor.liuxinquan.day1101.abstractfactorymoshi.sender;

public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("sms");
    }
}
