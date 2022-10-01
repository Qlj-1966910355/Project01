package xiancheng;

/**
 * 强行终止线程
 *  1、trd.stop();     // 已过时（这种方式容易丢失数据，因为这种方式是将线程直接杀死）
 *  2、<常用></>
 *      ->在run()方法外打一个boolean标记
 *          boolean sign = true;
 *      ->在run()方法内判断sign是否为true，如果为true，则执行run()方法内容，否则return；
 *      ->在main()方法内只需要在合适位置将标记改为false即可。
 *    注意：修改标记时，在具体的类对象下的属性访问标记。不是在封装后的线程对象。
 */
public class Thread05_Test01 {
    public static void main(String[] args) {
        // 创建可运行线程对象
        MyRunnable mrb = new MyRunnable();
        // 封装可运行线程对象
        Thread trd = new Thread(mrb);
        // 开辟分支线程
        trd.start();
        // main()方法睡眠5s，5s后分支线程执行中断
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 5s后终止trd线程
        // trd.stop();     // 已过时（这种方式容易丢失数据，因为这种方式是将线程直接杀死）
        mrb.sign = false;
    }
}

class MyRunnable implements Runnable{
    // 终止线程标记
    boolean sign = true;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(sign){
                System.out.println("--> " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                return;
            }
        }
    }
}