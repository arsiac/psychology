package com.github.arsiac.psychology.utils.annotation;

import com.github.arsiac.psychology.utils.common.QueryCacheNameSpace;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface ClearQueryCache {
    QueryCacheNameSpace value() default QueryCacheNameSpace.NAME_SPACE_DEFAULT;
}
