package com.itheima.anno;

import com.itheima.domain.Log;
import com.itheima.domain.User;
import com.itheima.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * 日志切面类
 */
@Component
@Aspect
public class LodInterceptor {

    @Autowired
    private LogService logService;
    @Autowired
    HttpServletRequest request;

    @Around("execution(* com.itheima.controller.*.*(..))")
    public Object around(ProceedingJoinPoint pj) throws Throwable {
        Date star = new Date();
        Object proceed = pj.proceed();
long cost = new Date().getTime() - star.getTime();

        String className = pj.getTarget().getClass().getName();
        String methodName = pj.getSignature().getName();

        User user = (User) request.getSession().getAttribute("user");
        String username = "";
        if (user!=null){
            username = user.getName();
        }else {
            username = request.getParameter("name")+"[登录失败!]";
        }

        Log log = new Log();
        log.setUrl("[类名]"+className+"[方法名]"+methodName);
        log.setName(username);
        log.setTime(new Date());
        log.setCost(cost);
        logService.insert(log);
        return proceed;
    }

}