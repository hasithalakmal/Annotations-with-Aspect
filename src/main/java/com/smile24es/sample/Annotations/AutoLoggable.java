package com.smile24es.sample.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoLoggable {

    /**
     * If this attribute is true, then logger will log the method parameter values
     *
     * @return
     */
    boolean isLogArgs() default true;

    /**
     * If this attribute is true, then logger will log the method method execution time
     *
     * @return
     */
    boolean isLogExecutionTime() default false;

}
