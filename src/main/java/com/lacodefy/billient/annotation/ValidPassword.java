/**
 *
 */
package com.lacodefy.billient.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Payload;

/**
 * @author Tharanaga Dinesh
 *
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
public @interface ValidPassword {
	String message() default "Ivalid Password";
	Class<?>[] groups() default {};
	Class<? extends Payload> [] payload() default {};
}
