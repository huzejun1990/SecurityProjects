package com.dream.security.core.validate.code.sms;

import com.dream.security.core.properties.SecurityConstants;
import com.dream.security.core.validate.code.ValidateCode;
import com.dream.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by huzejun
 * on 2019/4/19 15:27
 */
// @Component("smsValidateCodeProcessor")


@Component("smsCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor {

    @Autowired
    private SmsCodeSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String paramName = SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE;
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        smsCodeSender.send(mobile, validateCode.getCode());
    }
}
