package xiancheng;

/**
 * 线程的相关方法
 * 1、获取当前线程对象
 *  Thread t = Thread.currentThread();
 *  // 返回值t就是当前线程
 *  // 注：Thread.currentThread()出现在哪获取的就是哪个线程对象。要想获取分支线程的对象，将方法写在Thread类run()方法中即可。
 *
 * 2、获取线程的名字
 *  String name = 线程对象.getName();
 *
 * 3、修改线程对象的名字
 *  线程对象.setName("new_name");
 *
 * 4、获取当前对象的名字
 *  Thread.currentThread().getName();
 *
 * 5、当线程没有设置名字时，默认名字：
 *      Thread-0
 *      Thread-1
 *      Thread-2
 *      ……
 *
 */
public class Thread03_Test01 {
    public static void main(String[] args) {
        // 创建线程对象
        ThreadClass myThread = new ThreadClass();

        // 获取main()方法当前线程对象
        Thread t1 = Thread.currentThread();
        System.out.println("当前线程对象：" + t1);     // 返回：Thread[main,5,main]

        // 开辟分支线程
        myThread.start();
        // 获取当前线程对象
        System.out.println("当前线程对象：" + Thread.currentThread());     // 当前线程为main主线程


        // 获取线程名字
        System.out.println(myThread.getName());         // 输出：Thread-0

        // 修改分支线程对象名字
        myThread.setName("MyTread");

        // 获取分支线程名字
        System.out.println(myThread.getName());

        // 获取当前线程的名字
        System.out.println(Thread.currentThread().getName());


    }
}

class ThreadClass extends Thread{

    @Override
    public void run() {
        // 获取当前线程对象（在main方法中创建不同的线程对象，当前线程输出不同）
        System.out.println(Thread.currentThread());
        for (int i = 0; i < 10; i++) {
            System.out.println("分支线程->" + i);
        }
    }
}