package com.re.aspect;

import com.re.exception.AccessDeniedException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {
    private String currentUserRole = "VIP";

    @Before("execution(* com.re.service.ProductService.add*(..))")
    public void verifyUser(JoinPoint joinPoint){
        if (!"ADMIN".equals(currentUserRole)){
            throw new AccessDeniedException("Bạn không có quyền truy cập!");
        }
    }
}
