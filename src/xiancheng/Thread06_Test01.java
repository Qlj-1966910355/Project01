package xiancheng;

/**
 * 线程调度
 * 1、常见线程调度
 *      -> 抢占式调度模型
 *          哪个线程优先级高，抢占到的CPU时间片概率就高一些。<java采用这种方式></>
 *
 *      ->  均分式调度模型
 *          平均分配CPU时间片。每个线程占有的CPU时间片时间长度一样。
 *
 * 2、与线程调度相关方法
 *      -> final void setPriority(int newPriority)      // 设置线程的优先级
 *      -> final int getPriority()                      // 获取线程的优先级
 *          线程优先级：
 *              最低优先级：1
 *              默认优先级：5
 *              最高优先级：10
 *              优先级较高，获取到的CPU时间片就可能多一些。
 *
 *      -> static native void yield()                   // 让位方法
 *          静态方法：使用Thread.yield()调用
 *          注意：yield()方法不是阻塞。让当前线程让位，给其他线程使用；
 *               底层是从'运行状态'回到'就绪状态'，但回到就绪状态后会再次参与到CPU时间片的抢夺
 *
 *
 *
 */
public class Thread06_Test01 {
    public static void main(String[] args) {
        // 获取当前线程对象
        Thread xc = Thread.currentThread();
        // 获取优先级
        System.out.println(xc.getName() + "线程的优先级是：" + xc.getPriority());

        // 创建可运行线程对象
        Setting s = new Setting();
        // 封装可运行线程对象
        Thread tt = new Thread(s);
        // 设置分支线程名字
        tt.setName("SettingThread");
        // 开辟分支线程
        tt.start();

        // main()方法所在主栈中的循环
        for (int i = 0; i < 500; i++) {
            System.out.println(xc.getName() + "-->" + i);
        }


    }
}

class Setting implements Runnable{

    @Override
    public void run() {
        // 设置线程优先级
        Thread.currentThread().setPriority(10);
        // 获取当前线程优先级
        System.out.println(Thread.currentThread().getName() + "线程优先级是：" + Thread.currentThread().getPriority());

        // 分支栈中的循环
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }


    }
}
