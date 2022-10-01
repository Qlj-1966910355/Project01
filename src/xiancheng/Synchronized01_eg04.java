package xiancheng;

/**
 * 与Synchronized01_eg03.java不同点：
 *      将doSome()与doOther()方法由实例方法改为静态方法。
 *
 * 问：此时doOther方法执行时是否需要等待doSome方法之行结束？
 *      需要等待
 *      原因：
 *          将两个方法改为静态方法后，则执行synchronized修饰的方法时，需要获取的不是对象锁了，而是获取对象所属的类锁。
 *          每个类只有一把锁，不管创建多少个对象，类锁依然只有一个。所以t1线程调用doSome()方法后，占用了MyClass04类的类锁。
 *          当t2线程调用doOther()方法时，也想要获取MyClass04类的类锁，但已经被t1占用，所以需要等待执行。
 *
*/
public class Synchronized01_eg04 {

    public static void main(String[] args) {
        // 创建对象
        MyClass04 mc = new MyClass04();
        MyClass04 mc02 = new MyClass04();

        // 创建线程对象
        Thread t1 = new ThreadTest04(mc);
        Thread t2 = new ThreadTest04(mc02);

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

class ThreadTest04 extends Thread{
    private MyClass04 mc;

    public ThreadTest04(MyClass04 mc) {
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


class MyClass04{
    // synchronized在实例方法上，表示锁this <MyClass04类锁>
    public synchronized static void doSome(){
        System.out.println("doSome begin");
        try {
            // 为了延迟5s执行结束方法，看doOther()方法是否需要等待doSome()结束才执行。
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome over");
    }

    // 在doOther()方法上添加synchronized <this表示MyClass04类锁>
    public synchronized static void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther over");

    }
}

