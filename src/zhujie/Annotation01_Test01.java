package zhujie;

/**
 * ********************** 注解 **********************
 *  1、注解：也叫标注，英文：Annotation
 *
 *  2、注解Annotation是一种引用数据类型.编译后生成.class文件
 *
 *  3、语法：
 *      [修饰符列表] @interface 注解类型名{
 *
 *      }
 *
 *  4、注解作用：
 *
 *
 *  5、注解怎么用？
 *      -> 注解使用时的语法格式：
 *          @注解类型名
 *      -> 注解可以出现在类、属性、方法、变量等位置上
 *          注解也可以出现在注解类型上。（默认情况下注解可以出现在任何位置上）
 *
 *  6、java内常用注解
 *      -> Deprecated:
 *          用来标注"被标注的注解"最终保存的位置。
 *      -> Override：
 *          表示一个方法声明打算重写超类中的另一个方法。
 *          源码：public @interface Override {}
 *          标识性注解，给编译器作参考的。
 *          这个注解只能在方法上使用，编译器自动检查该方法是否重写了父类的方法，与运行期没有关系。
 *          其他位置上使用会报错。(原因：Override注解源码前还有注解，这部分注解称为元注解。)
 *      -> Deprecated:
 *          被标注的元素/方法等已过时，使用时用删除线表示。
 *  7、元注解
 *      eg:
 *          @Target(ElementType.METHOD)             // 表示被标注的注解只能出现在方法上
 *          @Retention(RetentionPolicy.SOURCE)      // 表示该注解只被保留在java源文件中
 *          @Retention(RetentionPolicy.CLASS)       // 表示该注解只被保存在class文件中
 *          @Retention(RetentionPolicy.RUNTIME)     // 表示该注解被保存在class文件中，并且可以被反射机制读取。
 *
 *      用来标注"注解类型"的注解。
 *      常见元注解：
 *          Target:
 *              这个注解用来标注的注解可以出现的位置。
 *          Retention:
 *              用来标注"被标注的注解"最终保存的位置。
 *
 */
@Annotation01
public class Annotation01_Test01 {
    public int num;
    @Annotation01
    public static void main(String[] args) throws Exception {
        @Annotation01
        int i1 = 1;
        System.out.println(i1);

        // 过时注解Deprecated
        m1();

        Class<?> aClass = Class.forName("java.lang.String");
        aClass.newInstance();           // @Deprecated(since="9")

    }
    @Deprecated
    public static void m1(){
        System.out.println("已过时！");
    }

    @Override
    public String toString() {
        return "Annotation01_Test01{" +
                "num=" + num +
                '}';
    }
}
