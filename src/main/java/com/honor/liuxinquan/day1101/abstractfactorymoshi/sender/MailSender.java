package com.honor.liuxinquan.day1101.abstractfactorymoshi.sender;

public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("mail");
    }
}
