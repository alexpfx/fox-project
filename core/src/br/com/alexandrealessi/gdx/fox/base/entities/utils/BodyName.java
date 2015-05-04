package br.com.alexandrealessi.gdx.fox.base.entities.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by alex on 02/05/2015.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.FIELD})
public @interface BodyName {
    String bodyNameReference();
    /* */
    boolean isClone() default false;
}
