package nei_bu_lei;

/**
 * ************************** 内部类 ***************************
 * 定义：内部类就是在一个类的内部进行其他类结构的嵌套操作。
 *
 * 优点：1、内部类与外部类可以访问彼此的私有域（私有属性，私有方法）
 *      2、内部类是另外一种封装，对外部的其他类隐藏。
 *      3、内部类可以实现java的单继承局限。
 *
 * 内部类分类：
 *      <成员内部类></>：类似成员变量
 *      <静态内部类></>：类似静态变量
 *      <局部内部类></>：类似局部变量
 *      <匿名内部类></>：属于局部内部类一种
 *
 * ************************ 匿名内部类 ***************************
 * 定义：没有类名的局部内部类
 */

public class Test01 {

    // 静态变量
    static int i;
    // 静态内部类
    static class Inner1{
    }

    // 实例变量
    int j;
    // 实例内部类
    class Inner2{
    }

    // doSome()方法
    public void doSome(){
        // 局部变量（方法体内）
        int k;
        // 局部内部类（方法体内）
        class Inner3{
        }
    }

    public void doOther(){
        // 局部内部类Inner3不能在doOther()中使用
    }
}


