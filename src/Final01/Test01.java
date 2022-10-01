package Final01;

/**
 * final关键字。（表示不可变的，最终的）
 *
 * 1、final修饰的类无法被子类继承；
 *      eg：public final class A{} 无法被继承
 *
 * 2、final修饰的方法无法被覆盖（重写），可以继承但不能重写；
 *      eg：public final void m1(){} 父类存在m1()，子类可以继承但不能重写m1()
 *
 * 3、final修饰的变量无法第二次赋值；
 *      局部变量：可以进行一次赋值，不能二次赋值。（注：final int a;    此语句没有进行一次赋值，无初始默认值）
 *      实例变量：与局部变量不同处在于，实例变量存在默认值，因此在创建实例变量时必须进行赋值。
 *              （实例变量被final修饰后不能采用默认值，因此才需要必须手动赋值）。
 *              手动赋值
 *                  方法1：final int i = 1;
 *                  方法2：构造方法内进行赋值
 *                         final int i;
 *                         public 类名(){
 *                             this.i = 1;
 *                         }
 *                  注：其实底层中两种方法其实是一样的。
 *                      （原因：方法1实例变量的赋值运算符在构造方法执行时才会运算。构造方法默认对实例变量进行初始化）
 *
 * 4、final修饰的引用不能进行二次赋值。（引用实际存储在栈内存中，是一个局部变量）
 *      eg：User a = new User(1);
 *          a = new User(2);
 *          注：引用a存储的地址被替换，第一个对象无引用指向，被回收。
 *
 *          final User a = new User(1);  // 不能再被修改，不被回收。
 *          // a = new User(2);
 *       注：修改类中的实例变量值可以。
 *          final User a = new User(1);
 *          a.id = 2;
 * 5、final修饰的实例变量，一般和static联合使用，被称为常量。
 *      语法：public static final 数据类型 常量名 = 值;
 *          eg: public static final String GUO_JIA = "中国";
 *          // java规范中要求所有常量的名字全部大写，每个单词之间用下划线隔开。
 */


public class Test01 {
    public static void main(String[] args) {
        System.out.println("我是final!");
    }
}
