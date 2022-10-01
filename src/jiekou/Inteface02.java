package jiekou;

// extends(继承)与implements(实现)都存在时

public class Inteface02 {
    public static void main(String[] args) {
        // 创建对象
        Flyable m1 = new Cat();          // 父类为什么不是动物类？  因为fly()在接口中。
        m1.fly();
    }
}

// 动物类（父类）
class DongWu{

}

// 可飞翔的接口（翅膀）
interface Flyable{
    void fly();             // 抽象方法
}


/**
 * 1、先继承后实现
 * 2、目的/需求：将翅膀接口插到猫身上，让猫可以飞行。
 *
 */
// 猫类（子类）
class Cat extends DongWu implements Flyable{
    public void fly(){                  // 抽象方法必须重写
        System.out.println("猫可以飞行！");
    }

}

// 狗类（子类）
// 没有插翅膀，所以狗类不能飞
class Dog extends DongWu{

}

