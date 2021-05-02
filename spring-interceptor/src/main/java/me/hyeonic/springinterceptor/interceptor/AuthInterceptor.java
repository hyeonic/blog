package me.hyeonic.springinterceptor.interceptor;

import lombok.extern.slf4j.Slf4j;
import me.hyeonic.springinterceptor.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // handler 종류 확인 => HandlerMethod 타입인지 체크
        // HandlerMethod가 아니면 그대로 진행
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // 형 변환 하기
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // @MySequred 받아오기
        MySecured mySecured = handlerMethod.getMethodAnnotation(MySecured.class);

        // method에 @MySequred가 없는 경우, 즉 인증이 필요 없는 요청
        if (mySecured == null) {
            return true;
        }

        // @MySequred가 있는 경우이므로, 세션이 있는지 체크
        HttpSession session = request.getSession();
        if (session == null) {
            response.sendRedirect("/my-error");
            return false;
        }

        // 세션이 존재하면 유효한 유저인지 확인
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/my-error");
            return false;
        }

        // admin일 경우
        String role = mySecured.role().toString();
        if(role != null) {
            if ("ADMIN".equals(role)) {
                if (user.getRole() != Role.ADMIN) {
                    response.sendRedirect("/my-error");
                    return false;
                }
            }
        }

        // 접근허가
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}