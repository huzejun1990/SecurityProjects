package com.dream.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by huzejun
 * on 2019/4/11 18:51
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);
}
