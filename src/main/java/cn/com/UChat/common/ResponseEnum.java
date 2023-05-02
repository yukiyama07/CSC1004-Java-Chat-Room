package cn.com.UChat.common;

// Response code and message
public enum ResponseEnum {
    INNER_ERROR(2001, "Inner Error"),
    LOGIN_SUCCESS(20000, "Login Success"),
    LOGIN_FAILED(3000, "Login failed, account or password is incorrect"),
    INVALID_PARAM(40001, "Invalid parameter"),
    USERNAME_EXSIT(3002, "Username already exists"),
    REGISTE_SUCCESS(20000, "Register Success"),
    GET_SUCCESS(20000, "Get Success"),
    ADD_SUCCESS(20000, "Add Success"),
    ADD_SUCCESS_NO(20000, "Reject the request"),;
    // Response code
    Integer code;
    // Response message
    String message;
    // Constructor
    ResponseEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
