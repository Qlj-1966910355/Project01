package fanshe;

import java.util.Date;

/**
 ******************** 反射机制 *******************
 * 1、反射机制有什么用？
 *      java语言通过反射机制可以操作字节码文件(class文件)。
 *
 * 2、位置：java.lang.reflect.*
 *
 * 3、反射机制相关重要的类
 *      -> java.lang.Class                      // 代表整个字节码，代表一个类型/一个类。eg:String.class
 *      -> java.lang.reflect.Method             // 代表字节码中的方法字节码。代表类中的方法
 *      -> java.lang.reflect.Constructor        // 代表字节码中的构造方法字节码。代表类中的构造方法
 *      -> java.lang.reflect.Field              // 代表字节码中的属性。代表类中的成员变量(静态变量+实例变量)
 *
 * 4、要操作一个类的字节码，首先需要获取字节码文件。
 *  获取字节码文件的三种方式：
 *      -> 方式一：Class c = Class.forName("java.lang.String"); // 完整类名
 *      -> 方式二：Class c = 对象.getClass();
 *      -> 方式三：Class c = 任何类型.class;
 *
 *
 *
 *
 */
public class FS01_Test01 {
    public static void main(String[] args) {
        Class c1 = null;
        try {
            /**
             * ----------- 方式一 -----------
             *   static Class<?> forName(String className)
             *      -> 静态方法
             *      -> 参数是一个字符串
             *      -> 字符串需要一个完整的类名(必须带有包名，不能省略)
             *
             *   java中class文件位置(高版本位置不同)：
             *                                  jdk1.7.0_17\jre\lib\rt.jar ---> 压缩包软件打开在java文件夹内查看
             *
             */
            c1 = Class.forName("java.lang.String");       // c1代表的是String.class文件
            // 注意：实际String.class文件在方法区内加载，所以局部变量变量c1指向方法区内加载的String.class文件。
            Class c2 = Class.forName("java.util.Date");
            Class c3 = Class.forName("java.lang.Integer");
            Class c4 = Class.forName("java.lang.System");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * ------------------- 方式二 -------------------
         * final native Class<?> getClass()方法
         *      作用：获取数据的所属类
         *      Class<?>:返回Class类型值
         *      注：Object类中的方法，所以每个对象都可以调用
         */
        String s = "abc";
        Class x = s.getClass();     // x代表String
        Date d = new Date();
        Class y = d.getClass();     // y代表Date文件

        // 判断方式一与方式二获取的String.class文件是不是一样的。
        System.out.println(c1 == x);        // 返回true。说明两种方式获取都指向同一个String.class文件

        /**
         * ------------------------ 方式三 ------------------------
         * java中任何一种类型，包括基本数据类型，都有.class属性。(eg:数组中的length属性，直接.length访问属性)
         *  直接访问类所对应的.class属性即可。
         *
         */
        Class z = String.class;     // z代表String类型
        Class k = int.class;
        Class date01 = Date.class;

    }
}
