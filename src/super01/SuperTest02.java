package super01;

public class SuperTest02 {
    public static void main(String[] args) {
        Vip var_01 = new Vip("屈刘杰");
        var_01.shopping();
    }
}

// 顾客类<父类>
class Customer {
    String name;

    // 无参构造方法
    public Customer() {
        super();
    }

    // 有参构造方法
    public Customer(String name) {
        super();
        this.name = name;
    }
}

// vip类<子类>
class Vip extends Customer {

     // String name;                    // 实例变量
    /**
     * 假设子类有一个同名属性name
     * 程序编译后执行输出：
     *                  null ; 屈刘杰 ; null
     * 原因：this表示的是当前对象，当子类创建name实例变量后，当前对象不再使用父类中的name变量。
     *       因此输出值是未初始化的默认name值null。
     */

    // 无参构造方法
    public Vip() {
        super();
    }

    // 有参构造方法
    public Vip(String name) {
        super(name);
    }

    // 实例方法
    public void shopping() {
        // this表示当前对象，name属性继承于父类
        System.out.println("1、" + this.name);        // 屈刘杰
        // super表示当前对象的父类型特征
        System.out.println("2、" + super.name);       // 屈刘杰
        // name前省略当前对象指向，实际：this.name
        System.out.println("3、" + name);             // 屈刘杰
    }
}
