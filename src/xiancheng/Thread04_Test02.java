package xiancheng;

/**
 * 终止sleep()方法
 *      在线程睡眠未结束时打断睡眠，让线程执行程序。
 * 方法：
 *      线程对象.interrupt();
 *      // 原理：通过异常处理机制结束睡眠。执行interrupt()方法后，线程对象中的sleep出现异常，执行catch语句块内容，然后将run()结束
 */
public class Thread04_Test02 {
    public static void main(String[] args) {
        // 创建可运行的线程对象
        ThreadSleep trd = new ThreadSleep();
        // 封装可运行的线程对象
        Thread thrd = new Thread(trd);

        // 开辟分支线程
        thrd.start();

        // 主线程程序
        System.out.println(Thread.currentThread().getName() + " --> start");
        System.out.println(Thread.currentThread().getName() + " --> end");

        // 上面程序执行结束，main()主要程序执行完毕，希望5s后让分支线程的睡眠中断
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 5s后执行分支线程的程序，强制结束睡眠
        thrd.interrupt();

    }

}

class ThreadSleep implements Runnable{
    /**
     * 注意：
     *      run()中的异常不能throws，只能try……catch
     *      原因：
     *          在父类中没有抛出异常，子类不能比父类抛出更多的异常。
     *
     */

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " --> start");
        try {
            // 睡眠1年
            Thread.sleep(1000*60*60*24*365);
        } catch (InterruptedException e) {
            System.out.println("我的睡眠被中断了！");
        }
        System.out.println(Thread.currentThread().getName() + " --> end");
    }
}
