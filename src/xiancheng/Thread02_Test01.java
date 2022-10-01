package xiancheng;

/**
 * java中，实现线程的方式，主要方式有两种：
 *  java支持多线程机制，并且java已经将多线程实现了，我们只需要继承就可以。
 *  方式一：
 *      编写一个类，直接继承java.lang.Thread，重写run()方法
 *      // 定义线程类
 *      public class MyThread extends Thread{
 *          public void run() {
 *              // run()方法体
 *          }
 *      }
 *
 *      // 在主方法内
 *      // 创建线程类对象
 *      MyThread mt = new MyThread();
 *      // 启动线程
 *      mt.start();
 *
 */

/**
 * 使用方式一实现多线程
 */
public class Thread02_Test01 {
    // main()方法在主线程(主栈)中执行
    public static void main(String[] args) {
        // 创建线程对象
        MyThread mt = new MyThread();

        // 直接调用run()方法
        // mt.run();
        /**
         * 这种直接调用的方式使用run()只有一个主栈，没有开辟新的分支栈。会先将run方法执行完成后才会执行下面的for循环。
         *
         */

        // 启动线程对象
        mt.start();
        /**
         * start()方法的作用：
         *      启动一个分支线程，在jvm中开辟一个新的栈空间，这段代码任务完成之后瞬间就结束了。
         *      开辟出新的栈空间后，start()方法就结束了。此时线程启动成功。
         *      启动成功线程之后会自动调用run()方法，并且run()方法在分支栈的底部(压栈)。
         *      run()方法在分支栈的底部，main()方法在主栈的底部。两个方法同级。
         * 注意：start()方法不结束，下面的方法是不会执行的。
         *      原因:java中必须自上而下执行代码。只是因为start()方法仅仅是开辟了一个分支栈，而分支栈开辟结束，
         *          start()方法就结束了。执行run()方法时间是start()执行结束后开始执行的。并且与start()方法
         *          下面的for循环一起并发执行。
         *
         * 直接调用run()方法与start()方法区别在哪？
         *      直接调用run()方法不会启动新的线程，run()方法依然在主栈中，只有当run()方法执行完成后，main()方法才能结束执行。
         *      start()直接启动了新的分支线程，新的分支栈与主栈一起运行。
         *
         */


        // 下面循环运行在主线程中
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程->" + i);
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        // 编写循环， 此循环会运行在分支线程中
       for (int i = 0; i < 1000; i++) {
            System.out.println("分支线程->" + i);
            
        }
    }
}
