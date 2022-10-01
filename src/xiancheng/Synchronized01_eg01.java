package xiancheng;

/**
 * synchronized面试题
 * 解释下面程序：
 *      MyClass类：实现了doSome()与doOther()方法，并且doSome()方法被synchronized修饰，doSome()方法线程同步。
 *      ThreadTest类：继承Thread类，实现run()方法。run()通过if判断调用MyClass类中的两个方法。
 *      主方法：首先创建一个MyClass对象，然后创建并开辟两个线程t1、t2。t1与t2共享mc对象，让t1先一步执行
 *
 * 问：doOther方法执行时是否需要等待doSome方法之行结束？
 *      不需要。
 *      原因：synchronized修饰在doSome()方法上，当start()开辟线程后执行run()，t1线程调用doSome()；而t2线程调用的是doOther()方法,
 *           doOther()方法没有被synchronized修饰，执行时不需要获取对象的锁，会直接执行，所以不会影响doOther方法执行。
 *      执行结果：
 *          先输出：doSome begin；
 *          然后t2线程调用doOther()方法输出：doOther begin与 doOther over
 *          最后doSome中的休眠结束，输出：doSome over

 */
public class Synchronized01_eg01 {
    public static void main(String[] args) {
        // 创建对象
        MyClass01 mc = new MyClass01();

        // 创建线程对象
        Thread t1 = new ThreadTest01(mc);
        Thread t2 = new ThreadTest01(mc);

        // 修改线程名字
        t1.setName("t1");
        t2.setName("t2");

        // 开辟线程
        t1.start();
        // 睡眠1s(为了保证t1先执行)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}

class ThreadTest01 extends Thread{
    private MyClass01 mc;

    public ThreadTest01(MyClass01 mc) {
        this.mc = mc;
    }

    @Override
    public void run() {
        // 如果是线程t1则执行doSome();否则执行doOther()
        if (Thread.currentThread().getName().equals("t1")){
            mc.doSome();
        }
        if (Thread.currentThread().getName().equals("t2")){
            mc.doOther();
        }

    }
}


class MyClass01{
    // synchronized在实例方法上，表示锁this <mc对象>
    public synchronized void doSome(){
        System.out.println("doSome begin");
        try {
            // 为了延迟5s执行结束方法，看doOther()方法是否需要等待doSome()结束才执行。
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome over");
    }

    public void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther over");
    }
}
