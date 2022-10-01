package baoZhuang_Test;

/**
 * **************************** 包装类 *****************************
 *
 * 包装类：Java是一个面向对象的编程语言，但是8种基本数据类型却不是面向对象的，为了弥补这一不足，设计了8种基本数据类型的包装类
 * 使用包装类原因：当类中的某一方法接收一个Object类型的形式参数，则在调用该方法时，实际参数也必须是Object类型的数据。
 *               但是8种基本数据类型并不是对象，不继承Object类。因此创建包装类这种引用数据类型
 * 作用：
 *      -> 编码过程中只接受对象的情况下，比如List中只存入对象，不能存基本数据类型；
 *
 *      -> 方便类型之间的转换，比如String和int之间的转换可以通过int包装类Integer来实现。
 *
 *
 *
 *
 * 1、包装类
 *   基本数据类型                     引用数据类型
 *  ----------------------------------------------------
 *      byte                    java.lang.Byte (父类Number)
 *      short                   java.lang.Short (父类Number)
 *      int                     java.lang.Integer (父类Number)
 *      long                    java.lang.Long (父类Number)
 *      float                   java.lang.Float (父类Number)
 *      double                  java.lang.Double (父类Number)
 *      boolean                 java.lang.Boolean (父类Object)
 *      char                    java.lang.Character (父类Object)
 *  ----------------------------------------------------
 *
 * 2、除了Boolean与Character类的父类是Object之外，其他6种包装类的父类都是Number类。
 *  <Number是一个抽象类不能实例化></>
 *
 * 3、Number抽象类中有6个方法，分别是intValue(),doubleValue(),floatValue(),byteValue(),shortValue(),longValue().
 *      方法作用：将引用数据类型的包装类（6种数字包装类）转换为基本数字类型。
 *
 * 4、装箱：将基本数据类型转换为包装类（通过创建包装类并初始化转换）
 *    拆箱：将引用数据类型转化为基本数据类型（通过Number内部方法进行转换）<注：对应的转换为基本数据类型></>
 *
 * 5、自动装箱：Integer int02 = 10;   // 直接将基本数据类型赋给包装类
 *    自动拆箱：int int03 = int02;   // 直接将包装类值赋给基本数据类型变量
 *
 * 6、关于Integer的构造方法
 *  例：
 *      Integer(int);
 *      Integer(String);
 * 7、注意：比较引用数据类型的数据是否相等使用equals()方法。
 */

public class Int_Test01 {
    public static void main(String[] args) {
        // 装箱
        Integer i = new Integer(123);

        // 将String类型的数字转换为包装类
        Integer j = new Integer("123");

        // 将引用数据类型转换为基本数据类型
        float f = i.floatValue();
        System.out.println(f);
        System.out.println(j);

        // 拆箱
        int i1 = i.intValue();
        System.out.println(i1);

        // 自动装箱
        Integer i2 = 10;
        // 自动拆箱
        int i03 = i2;

        // 比较包装类类型的数据大小
        Integer x= 127;
        Integer y = 127;
        System.out.println(x == y);     // true
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);     // false

        /**
         * 返回结果不同的原因？
         *  -> java为了提高执行效率，将[-128,127]之间所有的包装对象提前创建好，放到了
         *     一个方法区的“整数型常量池”中，目的是只要用这个区间的数据直接从整数型常量
         *     池中取。
         *
         *     原理：返回true是因为内存地址一样。
         */




    }
}
