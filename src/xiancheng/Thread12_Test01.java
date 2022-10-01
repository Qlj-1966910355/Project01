package xiancheng;

/**
 * ***************** 使用wait与notify方法实现《生产者与消费者模式》 *****************
 * ********************************* 绝世典中典 *********************************
 * 1、生产者与消费者模式
 *      生产线程负责生产，消费线程负责消费
 *      最终生产与消费线程要求达到均衡
 *      这是一种特殊需求
 *
 * 2、wait()与notify()不是线程对象的方法，是普通的继承Object类所有对象都有的方法。
 *
 * 3、wait()与notify()方法是建立在synchronized线程同步基础上的。因为生产与消费两个线程共享一个操作仓库对象。
 *
 * 4、wait()作用：o.wait()方法让正在o对象上活动的当前线程进入等待状态，并且释放当前占有的对象锁。
 *
 * 5、notify()作用：o.notify()方法唤醒当前进入等待状态的线程，不会释放对象锁。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 需求：
 *      仓库使用List集合；
 *      List集合中假设只存一个元素；
 *      List中有1个元素就表示仓库已满；
 *      List中有0个元素就表示仓库已空；
 *      最终效果：生产一个消费一个
 */
public class Thread12_Test01 {
    public static void main(String[] args) {
        // 创建仓库对象
        List myList = new ArrayList();

        // 创建线程对象
        // 生产
        Thread t1 = new Thread(new Producer(myList));
        // 消费
        Thread t2 = new Thread(new Consumer(myList));

        // 修改线程名
        t1.setName("生产者线程");
        t2.setName("消费者线程");

        // 启动线程
        t1.start();
        // 保证生产者线程线执行。(其实是画蛇添足之举)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

// 生产线程
class Producer implements Runnable{
    // 仓库 (为了让两个线程共享list对象)
    private List warehouse;

    public Producer(List warehouse) {
        this.warehouse = warehouse;
    }
    @Override
    public void run() {
        // 一直生产(死循环模拟)
        while (true){
            // 处理线程安全问题
            synchronized (warehouse){
                if(warehouse.size() > 0){
                    // 如果仓库存在产品，则不需要生产
                    try {
                        // 线程等待，并释放对象锁
                        warehouse.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 程序能走到这里说明仓库没有产品，此时可以生产
                // 制造一个产品对象
                Object products = new Object();
                // 添加到仓库
                warehouse.add(products);
                // 记录生产
                System.out.println(Thread.currentThread().getName() + "--->" + products);
                // 生产结束，此时唤醒消费者进行消费
                warehouse.notifyAll();
                /**
                 *  注意：
                 *      1、notifyAll()会唤醒两个线程，但是notifyAll()不会释放对象锁，依然继续执行本线程，本线程执行结束，释放对象锁，
                 *      此时两个线程都会去抢warehouse的对象锁；
                 *      2、如果生产者抢到对象锁，那么进入生产者线程的synchronized代码块中。由于生产了产品，所以进行if判断大于0，
                 *      执行wait()方法，此时生产线程进入等待状态，并且释放对象锁。此时只剩消费者线程在获取对象锁，消费者线程
                 *      得到对象锁后执行synchronized代码块进行消费。
                 *         如果在步骤后是消费者线程抢到了对象锁，则直接执行synchronized代码块进行消费。
                */
            }
        }
    }
}

// 消费线程
class Consumer implements Runnable{
    // 仓库
    private List warehouse;

    public Consumer(List warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        // 一直消费
        while (true){
            // 处理线程安全问题
            synchronized (warehouse){
                if (warehouse.size() == 0){
                    // 如果仓库没有产品，则不能消费
                    try {
                        // 线程等待，并释放对象锁
                        warehouse.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 程序能走到这里说明仓库内有产品，此时进行消费
                // 使用集合remove()方法，将索引位置为0的产品删除(相当于消费)
                Object products = warehouse.remove(0);
                // 记录消费
                System.out.println(Thread.currentThread().getName() + "--->" + products);
                // 消费结束，此时需要唤醒生产者线程进行生产
                warehouse.notifyAll();
            }
        }
    }
}
