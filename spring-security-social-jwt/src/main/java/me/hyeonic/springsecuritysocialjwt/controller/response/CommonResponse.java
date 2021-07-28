package me.hyeonic.springsecuritysocialjwt.controller.response;

public class CommonResponse<T> extends BasicResponse {

    T data;

    public CommonResponse(T data) {
        this.data = data;
    }
}