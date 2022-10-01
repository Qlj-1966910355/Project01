package xiancheng;

/**
 * ******************** 死锁 ********************
 * 死锁:指两个或两个以上的线程在执行过程中，由于竞争资源或者由于彼此通信而造成的一种阻塞的现象，若无外力作用，它们都将无法执行下去。
 * 现象:程序不会出现异常，也不会报错，而是一直僵持在控制台中，线程之间相互等待所导致。
 *
 */

/**
 * 实现死锁代码
 */
public class Thread08_Test01 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        // 创建线程对象
        Thread t1 = new MyThread01(o1,o2);
        Thread t2 = new MyThread02(o1,o2);

        // 开辟启动线程
        t1.start();
        t2.start();


    }
}

class MyThread01 extends Thread{
    Object o1;
    Object o2;

    public MyThread01(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    // 调换o1与o2的同步顺序
    @Override
    public void run() {
        synchronized (o2){
            System.out.println("1-->执行MyThread01中o1");
            // 让线程休眠2s(为了让死锁必然出现)
            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("2-->执行MyThread01中o2");
            }
        }
    }
}

class MyThread02 extends Thread{
    Object o1;
    Object o2;

    public MyThread02(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2){
            System.out.println("1-->执行MyThread02中o2");
            // 让线程休眠2s(为了让死锁必然出现)
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("2-->执行MyThread02中o1");
            }
        }
    }
}
