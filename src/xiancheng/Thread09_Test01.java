package xiancheng;

/**
 * ************************** 线程知识补充 **************************
 * 1、守护线程
 *  java语言中线程分两类：
 *      -> 用户线程
 *      -> 守护线程(后台线程)
 *      其中最有代表性的是：垃圾回收线程(守护线程)
 *
 *  守护线程特点：
 *      一般守护线程是一个死循环，所有用户线程只要结束了，守护线程就会自动结束。
 *
 *  注：主线程main方法是一个用户线程
 *
 *  守护线程用在什么地方？
 *      例：系统在每天00:00进行数据自动备份。
 *          此时需要一个定时器，可以将定时器设置为一个守护线程。
 *
 *
 * 2、定时器
 *  作用：间隔一定的时间执行特定的程序。
 *  实现方式：
 *      -> 最原始方式：使用sleep()方法，设置睡眠时间，每到特定时间点执行任务。
 *      -> 在java类库中有一个定时器：java.util.Timer。可以直接使用，但在开发中不常用这种方式。
 *      -> 实际开发中，使用较多的是Spring框架中的SpringTask框架。只需要简单配置就可以完成定时任务。
 *  具体实现方式参见Thread10_Test01文件
 *
 *
 * 3、实现线程的第三种方式
 *      实现Callable接口。(jdk8新特性)
 *      作用：线程可以返回一个返回值。为了得到线程执行后的返回值。
 *      注：之前两种方式run()方法被void修饰，不能获取县城返回值。
 *  具体实现方式参见Thread11_Test01文件
 *
 *
 * 4、关于Object类中的wait和notify方法
 *      <生产者与消费者模式>
 *      -> wait和notify方法不是线程类中的方法，它是Object类中的方法，每个对象都有的方法。
 *          不是通过线程对象调用的。
 *      -> wait()方法作用
 *          Object o = new Object();
 *          o.wait();
 *          // 表示让正在o对象上活动的线程进入等待状态（无期限等待），直到被唤醒为止。
 *
 *      -> notify()方法作用
 *          Object o = new Object();
 *          o.notify();
 *          // 表示唤醒正在o对象上等待的线程
 *
 *      -> notifyAll()
 *          // 唤醒o对象上所有等待的线程
 *
 *      注：wait()与notify()方法是建立在synchronized线程同步基础上的。
 *
 */



/**
 * 守护线程实现
 *      注：将线程设置为守护线程的方法
 *          -> final void setDaemon(boolean on)     // 实例方法
 *          参数为true时，表示设置为守护线程。
 */
public class Thread09_Test01 {
    public static void main(String[] args) {
        // 创建线程对象
        Thread t = new BFDataThread();
        // 修改线程名称
        t.setName("备份数据线程");

        // 在启动线程前，设置线程为守护线程
        // 设置之后，t线程就变为了守护线程，主线程结束守护线程也会跟着结束
        t.setDaemon(true);
        // 开辟并启动线程
        t.start();

        // 主线程是用户线程
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class BFDataThread extends Thread{
    @Override
    public void run() {
        int i = 0;
        // 死循环
        // 当用户线程结束，死循环守护线程也要结束
        while (true){
            System.out.println(Thread.currentThread().getName() + "-->" + (++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}