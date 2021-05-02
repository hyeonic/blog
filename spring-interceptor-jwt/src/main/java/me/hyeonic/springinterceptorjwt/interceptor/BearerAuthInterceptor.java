package me.hyeonic.springinterceptorjwt.interceptor;

import me.hyeonic.springinterceptorjwt.jwt.JwtTokenProvider;
import me.hyeonic.springinterceptorjwt.user.User;
import me.hyeonic.springinterceptorjwt.user.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BearerAuthInterceptor implements HandlerInterceptor {

    private final JwtTokenProvider tokenProvider;
    private final UserRepository userRepository;

    public BearerAuthInterceptor(JwtTokenProvider tokenProvider, UserRepository userRepository) {
        this.tokenProvider = tokenProvider;
        this.userRepository = userRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // handler 종류 확인 => HandlerMethod 타입인지 체크
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // 형 변환 하기
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // @MySecured 받아오기
        MySecured mySecured = handlerMethod.getMethodAnnotation(MySecured.class);

        // method에 @MySecured가 없는 경우, 즉 인증이 필요 없는 요청
        if (mySecured == null) {
            return true;
        }

        // @MySecured가 있는 경우, 인증이 필요하기 때문에 request header에서 token 값 추출
        String token = request.getHeader("Authorization");
        if (token == null) {
            response.sendRedirect("/api/my-error");
            return false;
        }

        // token이 존재하면 유효한 token인지 확인
        if (!tokenProvider.validateToken(token)) {
            response.sendRedirect("/api/my-error");
            return false;
        }

        // token을 활용하여 user email 추출
        String email = tokenProvider.getSubject(token);
        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {
            response.sendRedirect("/my-error");
            return false;
        }

        // @MySecured의 Role이 admin 권한인 경우
        String role = mySecured.role().toString();
        if(role != null) {
            if ("ADMIN".equals(role)) {
                if (user.getRole() != Role.ADMIN) {
                    response.sendRedirect("/my-error");
                    return false;
                }
            }
        }

        // 접근 허가
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}