package com.honor.liuxinquan.day1031.gongchanmosi;

/**
 * 工厂模式（3种）
 */
public class SenderFactory {
    /**
     * 简单工厂模式
     *
     * @param type
     * @return
     */
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            return null;
        }
    }

    /**
     * 多个工厂模式：测试调用为new SenderFactory（）对象调用方法
     *
     * @return
     */
    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }

    /**
     * 静态工厂模式：测试只需SenderFactory.方法调用即可
     *
     * @return
     */
    public static Sender produceMail1() {
        return new MailSender();
    }

    public static Sender produceSms2() {
        return new SmsSender();
    }

}
