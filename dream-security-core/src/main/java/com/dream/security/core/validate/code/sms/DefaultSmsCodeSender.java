package com.dream.security.core.validate.code.sms;

/**
 * Created by huzejun
 * on 2019/4/19 14:00
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile + "发送短信验证码！" + code);
    }
}
