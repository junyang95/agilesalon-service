package com.miniprogram.agilesalonservice.interceptor;

import com.miniprogram.agilesalonservice.aop.RequireLogin;
import com.miniprogram.agilesalonservice.entity.User;
import com.miniprogram.agilesalonservice.exception.UnauthorizedException;
import com.miniprogram.agilesalonservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Optional;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            LOGGER.info("[Authentication]不为HandlerMethod直接放行");
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method controllerMethod = handlerMethod.getMethod();
        Class<?> controllerClass = controllerMethod.getDeclaringClass();

        if (!controllerClass.isAnnotationPresent(RequireLogin.class) && !controllerMethod.isAnnotationPresent(RequireLogin.class)) {
            LOGGER.info("[Authentication]此API没有被标注直接放行");
            return true;
        }

        String openId = request.getHeader("openId");
        Optional<User> userOpt = this.userService.getUserByOpenId(openId);

        if (userOpt.isPresent()){
            LOGGER.info("[Authentication]用户存在放行");
            return true;
        } else {
            LOGGER.error("[Authentication]用户不存在");
            throw new UnauthorizedException("用户未登陆");
        }
    }
}
