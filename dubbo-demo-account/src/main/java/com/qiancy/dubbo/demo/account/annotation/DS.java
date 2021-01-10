package com.qiancy.dubbo.demo.account.annotation;

import com.qiancy.dubbo.demo.account.constants.DataSourceConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author qcyki
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DS {
    String value() default DataSourceConstants.DS_KEY_MASTER;
}
