package fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * java.lang.reflect.Field
 * // 字节码中的属性
 *
 *  1、Field[] getFields()       (先要获取指定类：forName获取)
 *      // 获取指定类中Field属性(存储在Field[]类型的数组内，注意数组内每个元素是Field类型)
 *      // 这个方法只能获取到被public修饰的属性，其他权限不能访问。
 *
 *  2、Field[] getDeclaredFields()           // 常用
 *      // 获取指定类中所有Field属性（不被权限修饰符限制，所有属性都可以访问）
 *
 *  3、String getName()
 *      // 获取属性名
 *
 *  4.1、Class<?> getType()
 *      // 获取完整属性数据类型
 *  4.2、String getSimpleName()
 *      // 获取简单属性数据类型
 *
 *  5、int getModifiers()
 *      // 获取属性的修饰符（fiers:s表示属性前的所有修饰符，不是只有权限修饰符）
 *      // 注：返回的是int类型的数据，int数据代表着修饰符。
 *  6、static String toString(int mod)
 *      // 将getModifiers()方法返回的int类型转换为String类型的修饰符字符串
 *      // Modifier类中的静态方法（Modifier.toString()）
 *      // 5与6一起使用，将5返回值传入6中。
 *
 */
public class Field01_Test01 {
    public static void main(String[] args) {
        // 获取整个类
        Class cat01 = null;
        try {
            cat01 = Class.forName("fanshe.MyCat");
            // 获取类名
            String className = cat01.getName();
            // 获取简类名
            String sName = cat01.getSimpleName();
            System.out.println("类名：" + className + "\n简类名：" + sName);
            System.out.println("\n------------------------------\n");



            // 获取类中Field(存储在Field[]类型的数组内，注意数组内每个元素是Field类型)
            Field[] fields = cat01.getFields();
            System.out.println("Field[]数组元素个数：" + fields.length);       // 1
            /**
             * Field[]数组只有一个元素，getFields()方法只能读取public修饰的属性
             */

            // 获取数组内元素对象的属性名
            String fieldName = fields[0].getName();
            System.out.println("获取到的属性名：" + fieldName);

            // 怎样获取所有属性？
            // 使用方法getDeclaredFields()
            Field[] fs = cat01.getDeclaredFields();
            System.out.println("fs数组元素个数：" + fs.length);        // 4
            /**
             * fs数组返回元素个数是4个，不受修饰权限影响，可以拿到对应类的所有属性
             */

            System.out.println("---------------------------");
            // 遍历数组
            for (Field field:
                 fs) {
                // 获取属性名
                System.out.println("属性名-->" + field.getName());

                // 获取属性数据类型
                System.out.println("完整数据类型-->" + field.getType());
                // 只获取SimpleName
                System.out.println("简单数据类型-->" + field.getType().getSimpleName());

                // 获取修饰关键字
                System.out.println("修饰关键字-->" + field.getModifiers());      // s表示属性前的所有修饰符，不是只有权限修饰符
                /**
                 * int getModifiers()
                 *  返回的是int类型的数据，int数据代表着修饰符。
                 */

                // 将getModifiers()方法返回的数字转换为字符串
                // static String toString(int mod)      // Modifier类中的静态方法
                System.out.println("修饰关键字-->" + Modifier.toString(field.getModifiers()));

                System.out.println("----");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}

class MyCat{
    public static String catName;
    int age;
    private boolean gender;
    protected String color;
    public static final double PI = 3.1415926;
}
