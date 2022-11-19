package com.dream.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by huzejun
 * on 2019/4/11 13:31
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -1812876356679606313L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
