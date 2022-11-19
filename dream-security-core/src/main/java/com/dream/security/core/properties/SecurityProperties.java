package com.dream.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by huzejun
 * on 2019/4/4 17:39
 */
@ConfigurationProperties(prefix = "dream.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    /*   public BrowserProperties getBrowser() {
        return browser;
    }*/

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
