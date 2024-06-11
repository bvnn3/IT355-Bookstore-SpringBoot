package com.bookstore.IT355_Project.security;

import com.bookstore.IT355_Project.entity.User;
import com.bookstore.IT355_Project.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

import static com.bookstore.IT355_Project.tool.JwtDecoder.getSubject;
@Component
@Slf4j
@RequiredArgsConstructor
public class AuthInterceptor  implements  HandlerInterceptor{

    private final UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("REQUEST :: {}, METHOD :: {}", request.getRequestURI(), request.getMethod());
        if (request.getRequestURI().contains("/public")) {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            Optional<User> optionalUser = userRepository.findByEmail(getSubject(token));
            if (optionalUser.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }
            request.setAttribute("USER", optionalUser.get());
            return HandlerInterceptor.super.preHandle(request, response, handler);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
    }
}
