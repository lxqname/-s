package com.honor.liuxinquan.day1101.abstractfactorymoshi.factory;

import com.honor.liuxinquan.day1101.abstractfactorymoshi.sender.Sender;

public interface Provider {
    public Sender produce();
}
