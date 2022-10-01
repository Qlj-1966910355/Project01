package xiancheng;

/**
 * 与Synchronized01_eg02.java不同点：
 *      再创建一个新对象mc02，让t1线程处理mc对象，t2线程处理mc02对象。
 *
 * 问：此时doOther方法执行时是否需要等待doSome方法执行结束？
 *      不需要等待
 *      原因：
 *          线程t1处理mc对象，线程t2处理mc02对象。两个线程的并没有共享对象，而是拥有各自的对象。
 *          当调用方法时，虽然都被synchronized修饰，但各自并没有第二个线程想要对应对象的锁，每个对象锁只有对应的线程获取。
 *          所以不需要等待。
 *
 */
public class Synchronized01_eg03 {
    public static void main(String[] args) {
        // 创建对象
        MyClass03 mc = new MyClass03();
        MyClass03 mc02 = new MyClass03();

        // 创建线程对象
        Thread t1 = new ThreadTest03(mc);
        Thread t2 = new ThreadTest03(mc02);

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

class ThreadTest03 extends Thread{
    private MyClass03 mc;

    public ThreadTest03(MyClass03 mc) {
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


class MyClass03{
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

    // 在doOther()方法上添加synchronized <this表示mc02>
    public synchronized void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther over");

    }
}

