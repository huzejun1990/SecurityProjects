package com.dream.security.core.properties;

/**
 * Created by huzejun
 * on 2019/4/4 17:39
 */
public class BrowserProperties {

    private String loginPage = "/dream-signIn.html";

    private LoginType loginType = LoginType.JSON;

    private int rememberMeSecondes = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public int getRememberMeSecondes() {
        return rememberMeSecondes;
    }

    public void setRememberMeSecondes(int rememberMeSecondes) {
        this.rememberMeSecondes = rememberMeSecondes;
    }
}
