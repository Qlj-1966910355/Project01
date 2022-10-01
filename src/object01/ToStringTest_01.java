package object01;

/**
 * Object类中的toString方法：
 *  源码：
 *      public String toString(){
 *          return this.getClass().getName() + "@" + Integer.toHexString(hashCode());
 *      }
 * <p>
 *  设计toString()方法的作用：
 *  返回对象的字符串表示形式。（返回一个字符串）
 * <p>
 *  默认返回值：类名@对象的内存地址
 * <p>
 * ** 调用toString()方法时，返回了内存地址，实际上就是打印输出引用变量 **
 * ** 建议所有子类修改（重写）toString()方法 ** <原因：不能输出想要输出的字符串(值)>
 */

public class ToStringTest_01 {
    public static void main(String[] args) {
        Time01 var_01 = new Time01(2022,2,9);

        // toString()方法可以默认调用，直接打印引用var_01
        System.out.println("调用重写的toString()方法输出：" + var_01);
        System.out.println("调用重写的toString()方法输出：" + var_01.toString());
        /**
         * 注：注释掉重写的toString方法时，直接继承Object类中的toString()方法。
         * 输出：object01.Time01@1b6d3586
         */
    }

}

class Time01 {
    int year;
    int month;
    int day;

    public Time01() {

    }

    public Time01(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;

    }

    // 重写toString方法
    public String toString() {
        return year + "年" + month + "月" + day + "日";
    }
}

