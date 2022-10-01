package xiancheng;

/**
 * 进程与线程
 *      进程：是一个应用程序（相当于一个软件）
 *      线程：是一个进程中执行场景/执行单元
 *
 * java中的进程与线程
 *      在dos命令窗口中输入一个.class文件时，计算机会先启动JVM，而JVM就是一个进程。
 *  JVM再启动一个主线程调用main方法。同时再启动一个垃圾回收线程负责看护，回收垃圾。
 *  现在最起码，java程序至少有了两个线程并发执行。
 *
 * 进程与线程的关系
 *      进程A与进程B的内存独立不共享。（例如：阿里与京东资源不共享）
 *
 *      线程A与线程B：
 *          *** 在java中 ***
 *              线程A与线程B，堆内存与方法区内存共享，只有一块。
 *                          栈内存独立，一个线程一个栈（多线程）
 *  区别：
 *      进程是操作系统资源分配的基本单位，线程是处理器任务调度和执行的基本单位
 *
 * 多线程的目的是为了提高程序的执行效率。
 *
 * 注意：main()方法结束，程序不一定就之行结束了，只是main()方法所在的主线程执行完毕，其他线程未执行完依然会压栈弹栈。
 *
 * 多线程并发
 *      真正的多线程并发是线程A与线程B同时在执行。
 *
 *  单核CPU怎样做到多线程并发执行的？
 *      单核CPU就相当于只有一个人在处理事情(线程任务)，而由于计算机的执行速度足够快，
 *  因此，在不断地切换多个线程执行，给人的感觉就像是在同时并发执行多个线程。
 *
 *
 *
 *
 */

/**
 * 分析下面程序有几个线程?
 *      下面程序只有1个线程
 *      原因：程序只有1个栈。在调用其他方法时，执行顺序自上而下顺序执行，一个栈中经过压栈弹栈直至main()执行结束
 *
 */
public class Thread01_Test01 {
    public static void main(String[] args) {
        System.out.println("开始执行main()：");
        a1();
        System.out.println("main()执行结束！");


    }

    private static void a1() {
        System.out.println("我是方法a1()！");
        a2();
    }

    private static void a2() {
        System.out.println("我是方法a2()！");
        a3();
    }

    private static void a3() {
        System.out.println("我是方法a3()！");
        a4();
    }

    private static void a4() {
        System.out.println("我是方法a4()！");
    }
}
