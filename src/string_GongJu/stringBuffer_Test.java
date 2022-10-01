package string_GongJu;

// StringBuffer 字符串拼接

public class stringBuffer_Test {
    public static void main(String[] args) {
        // "+"字符串连接符在连接字符串时会在方法区常量池创建多个字符串对象，连接时还会创建新对象保存连接的新字符串

        // 创建一个初始容量为16的char[]数据。（字符串缓冲区）
        // 作用：保存追加的字符串  <容量满了后自动扩容>
        StringBuffer str01 = new StringBuffer();

        // append()         // 追加
        str01.append("a");
        str01.append("bc");
        str01.append(123);
        str01.append(true);
        System.out.println("打印对象str01：" + str01);   // 打印引用默认调用toString()方法

        /**
         * 1、如何优化StringBuffer的性能？
         *  -> 在声明StringBuffer对象时，尽可能给对象初始化一个容量
         *  -> 最好减少底层数组的扩容次数。尽可能预估容量使用的大小。
         *
         * 2、为什么String是不可变的？
         *      String类中有一个value[]数组，这个数组被final修饰，数组的长度创建后不可变。
         *  并且被final修饰的引用一旦指向某个对象后，不可在指向其他对象。所以String不可变。
         *
         * 3、为什么StringBuffer与StringBuilder是可变的？
         *      StringBuffer与StringBuilder底层实际是一个数组，这个数组没有被final修饰，
         *  并且初始化容量为16，当容量不够时，数组使用arraycopy()进行扩容，所以可以进行字符
         *  串拼接操作。
         *
          */
    }
}
