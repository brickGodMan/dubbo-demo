package com.qiancy.dubbo.demo.account.aop;

import com.qiancy.dubbo.demo.account.context.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import com.qiancy.dubbo.demo.account.annotation.DS;

import java.util.Objects;

/**
 * 功能简述：动态数据源切面
 *
 * @author qiancy
 * @create 2021/1/10
 * @since 1.0.0
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("@annotation(com.qiancy.dubbo.demo.account.annotation.DS))")
    public void pointDataSourceCut() {

    }


    @Around("pointDataSourceCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //1.获取DsKey
        String dsKey = getDsAnnotation(joinPoint).value();
        //2.切换DataSource
        DynamicDataSourceContextHolder.setContextKey(dsKey);
        try {
            //3.执行方法
            return joinPoint.proceed();
        } finally {
            //4.重置数据源
            DynamicDataSourceContextHolder.removeContextKey();
        }


    }

    /**
     * 获取注解
     * @param joinPoint
     * @return
     */
    private DS getDsAnnotation(ProceedingJoinPoint joinPoint) {
        Class<?> targetClass = joinPoint.getTarget().getClass();
        DS dsAnnotation = targetClass.getAnnotation(DS.class);
        //判断类的注解 ，在判断方法的注解
        if (Objects.nonNull(dsAnnotation)) {
            return dsAnnotation;
        } else {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            return methodSignature.getMethod().getAnnotation(DS.class);
        }
    }
}
