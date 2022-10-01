package xiancheng;

/**
 * 实现线程的第二种方式
 * <方式二比方式一多了一个步骤></>
 * 两种方式不同点：
 *      方式一直接继承了Thread类，而方式二只是实现Runnable接口。
 *      原理：实际上，Thread底层实际是直接实现Runnable接口，所以方式一就可以直接创建Thread对象；
 *           而方式二是实现Runnable接口的，并没有直接继承Thread类，所以只能在创建可运行对象后，
 *           将对象传入Thread对象中，再通过start()方法开辟分支栈。
 *
 *  方式二：
 *      编写一个类，实现java.lang.Runnable接口，实现run方法
 *      // 编写实现Runnable接口的类（实现后必须重写run()方法）
 *      public class Thread02 implements Runnable{
 *          public void run() {
 *              // 方法体
 *          }
 *      }
 *
 *      // 在主方法中
 *      // 创建可运行类对象
 *      Thread02 myThread = new Thread02();
 *      // 将可运行对象传入Thread对象中
 *      Thread trd = new Thread(myThread);
 *      // 使用Thread类中的start()方法开辟分支栈
 *      trd.start();
 *
 *      
 *
 *
 */
public class Thread02_Test02 {
    public static void main(String[] args) {
        // 创建一个可运行对象
        Thread02 myThread = new Thread02();
        //  将可运行的对象封装成一个线程对象
        Thread trd = new Thread(myThread);
        // 开辟分支栈
        trd.start();

        // 循环
        for (int i = 0; i < 500; i++) {
            System.out.println("主栈->" + i);
        }
    }
}

class Thread02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) { System.out.println("分支栈->" + i); }
    }
}