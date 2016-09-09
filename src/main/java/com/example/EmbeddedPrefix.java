package com.example;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author ymolodkov on 09.09.16.
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface EmbeddedPrefix {
    String value() default "";
}
