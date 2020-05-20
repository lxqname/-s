package com.honor.liuxinquan.day1101.zhuangshizhemoshi;

/**
 * 装饰者模式
 */
public class Decorator implements Source {
    private Source source;

    public Decorator(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        source.method();
    }
}
