package zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})      // 可将该注解放在类、方法上
@Retention(RetentionPolicy.RUNTIME)                 // 表示该注解被保存在class文件中，并且可以被反射机制读取
public @interface Annotation00 {
    String value();
    int[] num();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation0 {
    String value() default "qlj";
}
