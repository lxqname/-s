package com.honor.liuxinquan.day1101.abstractfactorymoshi.factory;

import com.honor.liuxinquan.day1101.abstractfactorymoshi.sender.Sender;
import com.honor.liuxinquan.day1101.abstractfactorymoshi.sender.SmsSender;

/**
 * 抽象工厂模式，创建多个工厂类，
 * 这样一旦需要增加新的功能，
 * 直接增加新的工厂类就可以了，
 * 不需要修改之前的代码
 */
public class SmsSenderFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
