package com.dream.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by huzejun
 * on 2019/4/19 15:08
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

}





