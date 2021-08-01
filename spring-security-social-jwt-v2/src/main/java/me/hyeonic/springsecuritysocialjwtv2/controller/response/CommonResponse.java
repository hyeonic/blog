package me.hyeonic.springsecuritysocialjwtv2.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> extends BasicResponse {

    T data;
}