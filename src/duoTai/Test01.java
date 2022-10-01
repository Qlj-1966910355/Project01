package duoTai;

// 多态的作用：降低程序的耦合度，提高程序的扩展力（面向对象编程）
public class Test01 {

    public static void main(String[] args) {
        // 创建对象
        // Cat mao = new Dog();       // 编译出错（Cat类与Dog类没有继承关系）
        DongWu mao = new Cat();      // 注：语法格式。父类引用变量，对象类型为Cat类型。
        mao.move();                  // 输出：猫在走猫步！
        /**
         * 1、在编译阶段时，编译器检查mao这个引用类型为DongWu类型，由于DongWu类中有move()方法，所以编译会通过。
         *    这个过程为静态绑定，编译阶段绑定。
         * 2、在运行阶段时，JVM堆内存中真实创建的对象是Cat()对象，则在执行mao.move()时，一定会调用Cat类中的move()
         *    方法。此时发生了程序的动态绑定，运行阶段绑定。
         */

        mao.sleep();                // 输出：动物在睡觉！
        /**
         * 问：Cat类中并没有sleep()方法，sleep()怎样调用的？
         *     答：mao引用所指对象依然是Cat类，并且Cat类中并没有sleep()方法，但是，Cat类继承了DongWu类，所以Cat类
         *         其实是存在sleep()方法的，只是被隐藏了。
         * 注：无论子类中有没有重写父类的方法，只要父类中存在可继承的方法，子类就也存在这些方法。且运行期间调用的都是
         *     子类的方法。因为底层真实对象是子类对象。
         */

        // mao.eat();         // 编译错误
        ((Cat) mao).eat();            // 输出：猫在吃猫粮！
        /**
         * 编译错误原因：在编译阶段，检测mao变量类型是DongWu类型，而从DongWu类中并没有找到调用的eat()方法，导致静态
         *              绑定失败，所以编译就会失败。
         * 将变量强制转换为Cat类型，则编译阶段就会在Cat类中寻找eat()方法。（向下转型：强制类型转换）
         *
         * 向下转型什么时候使用？
         *     当被调用的方法是子类中特有的方法，而父类中不存在这种方法时，使用强制类型转换调用子类中特有的方法。
         */

        // 创建对象
        DongWu gou = new Dog();
        // Cat gou = (Cat) gou;    // 运行报错（Cat类与Dog类没有继承关系，出现强制类型转换异常<java.lang.ClassCastException>）
        gou.move();       // 输出：狗在狂奔！


        // 如何避免这种强制类型转换错误发生？
        /**
         * instanceof 运算符使用！！！！
         *     语法：
         *          (引用 instanceof 数据类型名)           // 返回类型：boolean类型（true或者false）
         *
         *     eg:(gou instanceof Dog)      // 判断gou 引用指向对象类型是否为Dog类型
         */
        if (gou instanceof Dog) {              // gou指向Dog类型对象
            Dog gou1 = (Dog) gou;
            gou1.eat();                   // 实际执行此语句
        } else if (gou instanceof Cat) {       // gou指向Cat类型对象
            Cat gou1 = (Cat) gou;
            gou1.eat();
        }


    }


}
