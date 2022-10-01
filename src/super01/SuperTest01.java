package super01;

// super()作用：初始化当前对象的父类型特征

// super与this执行测试
public class SuperTest01 {
    public static void main(String[] args) {
        new C();                               // 输出顺序：1,3,6,5,4
    }
}

// A类
class A {

    // 无参构造方法
    public A() {
        System.out.println("1");        // 首行默认有super()，使用Object类中的无参构造方法
    }

}

// B类
class B extends A {

    // 无参构造方法
    public B() {
        System.out.println("2");
    }

    // 有参构造方法
    public B(String name) {            // 首行默认有super();<表示：使用父类无参构造方法>
        System.out.println("3");
    }


}

// C类
class C extends B {

    // 无参构造方法
    public C() {
        this("qlj");           // 使用当前对象有一个参数的构造方法
        System.out.println("4");
    }

    // 有参构造方法
    public C(String name) {
        this(name, 24);         // 使用当前对象有两个参数的构造方法
        System.out.println("5");
    }

    // 有参构造方法
    public C(String name, int age) {
        super(name);                 // 使用父类对应类型的构造方法<一个参数>
        System.out.println("6");
    }

}



