package com.dream.security.core.validate.code.sms;

/**
 * Created by huzejun
 * on 2019/4/19 13:42
 */
public interface SmsCodeSender {

    void send(String mobile, String code);
}
