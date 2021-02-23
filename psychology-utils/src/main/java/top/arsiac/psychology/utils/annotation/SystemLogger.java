package top.arsiac.psychology.utils.annotation;

import java.lang.annotation.*;

/**
 * <p>系统日志注解</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/1/27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLogger {
    String value() default "UNKNOWN";
    boolean page() default false;
}
