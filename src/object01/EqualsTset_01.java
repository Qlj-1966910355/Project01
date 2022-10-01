package object01;

/**
 * Object类中的toString方法：
 * 源码：
 *      public boolean equals(Object obj){
 *          return (this == obj);
 *      }
 * <p>
 * equals()方法创建目的：
 * *** 重写后判断两个对象是否相等（实际比较的是两个对象的地址是否相等）***
 * <p>
 * 为什么不用" == "进行判断？
 * 原因："=="是判断两个基本数据类型是否相等的，不能判断同时使用new出来的对象是否相等，因为new出来的对象地址不同。
 *
 * 注：系统提供的类，如String类（引用类型），已经对toString()与equals()方法进行了重写。
 *
 * java规范：引用类型使用equals()方法，基本数据类型使用"=="。
 */

public class EqualsTset_01 {
    public static void main(String[] args) {
        Time02 a1 = new Time02(2022, 1, 1);
        Time02 a2 = new Time02(2022, 1, 1);

        // 使用"=="判断两个引用对象是否相等
        if (a1 == a2) {
            System.out.println("a1与a2对象相等！");
        } else {
            System.out.println("\"==\"不能判断a1与a2对象相等！！");      // 返回false
        }
        // 使用equals()方法判断两个引用对象是否相等
        if (a1.equals(a2)) {                      // 注意：equals()方法的使用
            System.out.println("a1与a2对象相等！");
        } else {
            System.out.println("equals()方法不能判断a1与a2对象相等！！");  // 返回false
        }
        /**
         * 为什么此处的equals()方法不能判断两对象相等？
         *      原因：从Object类中的equals()方法源码可以看出，底层返回依旧是通过"=="进行比较的。
         *
         * 怎样比较两个对象是否相等呢？
         *      equals()方法重写。
         *
         */

    }

}

class Time02 {
    int year;
    int month;
    int day;

    public Time02() {

    }

    public Time02(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // 重写equals方法
    /**
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time02 time02 = (Time02) o;
        return year == time02.year &&
                month == time02.month &&
                day == time02.day;
    }
    */
    // 重写后的equals()方法可以判断两个对象是否相等。

}