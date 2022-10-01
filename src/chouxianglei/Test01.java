package chouxianglei;

public class Test01 {
    public static void main(String[] args) {
        // 测试抽象类是否可以创建对象
        // Account var_01 = new Account();         编译报错，Account类是抽象类，不能进行实例化创建对象

    }
}

// 银行账户抽象类
abstract class Account {
    public Account() {
    }

    public Account(String i) {

    }

}

// 信用卡类(子类)     <也可抽象>
class XinYongKa extends Account {
    /**
     * 当子类中没有定义新的构造方法时，系统默认提供给子类无参构造方法，且方法体内存在super() <使用父类的无参构造方法>
     * but 当父类重新定义了有参方法，父类中系统不提供无参构造方法，则子类在使用或继承时，super()调用失败，编译报错
     * 因此，父类需要定义无参构造方法，或不进行任何定义构造方法操作。
     */


    // 只有当父类存在无参构造方法，super()才可以使用。
    public XinYongKa() {
        super();
    }

}

// 测试final与abstract一起使用
// 编译报错，不能一起使用
/**
 * final abstract class Account1{
 * <p>
 * }
 */


