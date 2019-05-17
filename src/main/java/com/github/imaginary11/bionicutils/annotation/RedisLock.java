package com.github.imaginary11.bionicutils.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author : Imaginary
 * @version : V1.0
 * @date : 2019/4/24 12:23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
@Documented
public @interface RedisLock {
    String lockKey();

    /**
     * 锁释放时间 默认五秒
     *
     * @return
     */
    long timeout() default 5 * 1000;

    /**
     * 时间格式 默认：毫秒
     *
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
