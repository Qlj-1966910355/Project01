package string_GongJu;

// StringBuilder 字符串拼接

public class StringBuilder_Test {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        s.append(100);
        s.append(true);
        s.append("qlj");
        s.append("love");
        System.out.println(s);
    }
}

/**
 * StringBuffer与StringBuilder的区别？
 *      -> StringBuffer类中的方法有synchronized关键字修饰。表示StringBuffer在多线程环境下运行是安全的。
 *      -> StringBuilder类中没有synchronized关键字修饰。表示StringBuilder在多线程环境下运行是不安全的。
 *      即：
 *          -> StringBuffer是线程安全的
 *          -> StringBuilder是非线程安全的
 */
