package jiekou;

public class Inteface01 {
    public static void main(String[] args) {
        // 创建对象(多态)<C为多实现>
        A var_1 = new C();             // 多态（父类型引用指向子类型对象）
        B var_2 = new C();
        // 不能从var_1中直接访问B接口内的方法
        int m = var_1.a1();                    // 调用对象C中的a1方法
        int n = var_2.b1();                    // 调用对象C中的b1方法
        System.out.println("m = " + m + "\nn = " + n);

        int k = ((B) var_1).b1();              // (多实现)向下转型（强制类型转换）
        System.out.println("k = " + k);

        // E类为单实现
        A var_3 = new E();                     // 向上转型
        int l1 = var_3.a1();
        System.out.println("l1 = " + l1);

        /**
         * int l2 = ((B)var_3).b1();                       // 向下转型（编译没有报错）<但A与B没有继承关系>
         * System.out.println("l2 = " + l2);
         * // 运行报错
         * */
    }

}

// 接口A
interface A {
    int a = 1;          // 接口中的变量一定是常量，忽略修饰符与final关键字

    int a1();           // 抽象方法，忽略修饰符与abstract(抽象)关键字，并且该方法无方法体。
}

// 接口B
interface B {
    int b = 2;      // 常量

    int b1();       // 抽象方法
}

// 非抽象类实现A与B（多实现）
class C implements A, B {              // 非抽象类实现接口
    // 多实现弥补了类与类之间的单继承缺陷。
    public int a1() {                  // 实现（重写）抽象方法a1（非抽象类中不能存在抽象方法）
        return 1;
    }

    public int b1() {                  // 实现抽象方法b1（注意补充public，父类省略了修饰符，子类访问权限不能更低）
        return 2;
    }
}

// 接口D多继承接口A与B
interface D extends A,B{               // 多继承（注意：由一个接口继承父类接口）

}

// 非抽象类E单实现接口A
class E implements A{
    public int a1() {                  // 实现（重写）抽象方法a1（非抽象类中不能存在抽象方法）
        return 1;
    }
}