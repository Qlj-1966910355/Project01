package zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target(value = {ElementType.METHOD, ElementType.FIELD})
//@Target(ElementType.METHOD)
@Target(ElementType.FIELD)      // 表示该注解只能出现在属性上面
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation02 {
    String name();
}



