package com.dream.security.browser.support;

/**
 * Created by huzejun
 * on 2019/4/4 17:18
 */
public class SimpleResponse {

    public SimpleResponse(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
