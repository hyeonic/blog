package me.hyeonic.springinterceptorjwt.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebMvcConfig implements WebMvcConfigurer {

    private final HandlerInterceptor bearerAuthInterceptor;

    public WebMvcConfig(HandlerInterceptor handlerInterceptor) {
        this.bearerAuthInterceptor = handlerInterceptor;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bearerAuthInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns();
    }
}