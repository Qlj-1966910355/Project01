package xiancheng;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现线程的第三种方式
 *      实现Callable接口。(jdk8新特性)
 *  Callable介绍：
 *      1、interface Callable<V>{}       // 是一个接口
 *      2、V call() throws Exception     // 接口内只有一个抽象方法call()方法
 *      3、Callable接口与Runnable一样，只不过run()没有返回值，而call()方法可以返回Object类型的返回值。
 *
 *  获取返回值方法：
 *      未来任务类调用get()方法
 *          V get()     // FutureTask类中的方法
 *
 *  注意：
 *      这种方式获取分支线程返回值时，分支线程必须执行结束才可以获取到返回值。
 *      所以主线程执行获取分支线程返回值程序时，主线程阻塞，等分支线程执行结束才可以继续执行主线程剩余代码。
 *
 * 优点：可以获取分支线程返回值
 * 缺点：执行效率低。(执行过程主线程阻塞)
 */
public class Thread11_Test01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建未来任务类对象(需要传入一个Callable类对象)
        FutureTask task = new FutureTask(() -> {     // call()方法相当于run()方法
            // 执行任务
            System.out.println("call begin!");
            Thread.sleep(1000*5);
            System.out.println("call over!");
            int a = 100;
            int b = 200;
            return a + b;   // 自动装箱为Integer
        });

        // 创建线程对象
        Thread trd = new Thread(task);
        // 开辟并启动线程
        trd.start();

        // 注：获取线程返回值，必须等待分支线程结束执行才能获取到返回值。所以主线程执行到task.get()时，主线程阻塞。
        // 主线程中获取线程执行结果
        Object obj = task.get();
        System.out.println("分支线程返回值：" + obj);

        // 主线程输出
        System.out.println("main执行结束！");
    }
}
