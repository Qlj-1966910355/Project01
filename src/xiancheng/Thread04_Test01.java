package xiancheng;

/**
 * 关于线程的sleep()方法
 *  1、静态方法，可以直接使用Thread.sleep()调用
 *      注：静态方法可以通过对象去调用，但是并不会受到对象的影响，依然只遵循sleep()的位置决定休眠的线程
 *  2、参数是毫秒
 *  3、作用：
 *      让当前线程进入休眠状态，进入“阻塞状态”，放弃占有的CPU时间片，让给其他线程使用
 *      注：
 *          这个方法在A线程中，A线程就进入休眠
 *                 在B线程中，B线程就进入休眠
 *
 *  4、效果：这个方法可以放在程序特定的位置，让程序间隔一段时间执行再执行。
 *
 */
public class Thread04_Test01 {
    public static void main(String[] args) {
        // 创建可运行的线程对象
        Thread1 trd = new Thread1();
        // 封装可运行线程对象
        Thread myThread = new Thread(trd);

        // 开辟分支线程
        myThread.start();

        // 休眠5000ms
        try {
            Thread.sleep(1000*5);             // sleep()在主方法内，则主线程休眠5000ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 循环
        for (int j = 0; j < 10; j++) {
            System.out.println("主线程->" + j);
        }


    }
}

class Thread1 implements Runnable{

    @Override
    public void run() {
        // 休眠
        try {
            Thread.sleep(1000*2);           // 分支线程休眠2s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 10; i++) {
            System.out.println("分支线程->" + i);
            
        }
    }
}
