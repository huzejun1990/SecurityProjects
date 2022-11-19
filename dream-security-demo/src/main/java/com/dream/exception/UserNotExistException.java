package com.dream.exception;

/**
 * Created by huzejun
 * on 2019/4/2 16:35
 */
public class UserNotExistException extends RuntimeException {

    private static final long serialVersionUID = -3076504017960358848L;

    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
