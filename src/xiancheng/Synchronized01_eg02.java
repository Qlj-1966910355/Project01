package xiancheng;

/**
 * 与Synchronized01_eg01.java不同处：
 *      在doOther()方法上添加synchronized。
 *  问：此时doOther方法执行时是否需要等待doSome方法之行结束？
 *      需要等待doSome之行结束再执行doOther
 *      原因：
 *          当t1线程执行调用doSome()方法时，获取了共享对象this的锁。
 *          紧接着当t2执行调用doOther()方法时，发现doOther方法被synchronized修饰，此时需要获取共享对象this的锁，但是一个对象只有一个锁，
 *          此时this的锁被t1线程正占用中，所以t2线程执行doOther只能等待doSome之行结束才能执行。
 */
public class Synchronized01_eg02 {

    public static void main(String[] args) {
        // 创建对象
        MyClass02 mc = new MyClass02();

        // 创建线程对象
        Thread t1 = new ThreadTest02(mc);
        Thread t2 = new ThreadTest02(mc);

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

class ThreadTest02 extends Thread{
    private MyClass02 mc;

    public ThreadTest02(MyClass02 mc) {
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


class MyClass02{
    // synchronized在实例方法上，表示锁this <mc>
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

    // 在doOther()方法上添加synchronized
    public synchronized void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther over");

    }
}
