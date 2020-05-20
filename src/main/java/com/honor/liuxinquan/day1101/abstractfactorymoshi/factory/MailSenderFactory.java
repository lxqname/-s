package com.honor.liuxinquan.day1101.abstractfactorymoshi.factory;

import com.honor.liuxinquan.day1101.abstractfactorymoshi.sender.MailSender;
import com.honor.liuxinquan.day1101.abstractfactorymoshi.sender.Sender;

public class MailSenderFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
