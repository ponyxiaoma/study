package com.mjq.account.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoSaveOperator {

    boolean value() default false;
}
