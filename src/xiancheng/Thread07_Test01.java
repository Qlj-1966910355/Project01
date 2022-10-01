package xiancheng;

/**
 * ***************** 线程安全 *****************
 * 前言：在开发中，项目一般都是运行在服务器中，服务器事先会定义好线程及线程对象的创建和线程的启动等，程序员需要关注的是：
 *      编写的程序需要在多线程环境运行；在多线程并发环境下数据是否安全。
 * 1、什么情况下在多线程并发下不安全？
 *  eg：银行取款案例
 *      用户A与用户B在同一时间分别在ATM及与柜台取用户C的钱，假若C账户只有10000元，用户A、B同时取钱每人可以取出10000元。
 *
 *      -> 多线程并发执行；
 *      -> 有共享数据；
 *      -> 共享数据有修改行为
 *      <出现线程安全问题前提>
 * 2、怎样避免线程安全问题出现？
 *      采用"线程同步机制"
 *      线程同步：就是线程排队的意思。牺牲多线程并发的高效率，保证线程执行的安全性。
 * 3、同步于异步
 *      异步编程模型：
 *          线程t1与线程t2，各自执行各自，谁也不需要等谁。<多线程并发></>
 *      同步编程模型：
 *          线程t1与线程t2，有顺序的执行两个线程，t1执行时必须等t2执行完成，或者t2执行时必须等t1执行完成.
 *          两个线程存在等待关系，效率较低。<线程排队执行></>
 *
 *
 *
 */

/**
 * 模拟银行取钱案例
 * (不使用线程同步机制<排队执行>，多个线程对同一用户取款，出现线程安全问题)
 */
public class Thread07_Test01 {
    public static void main(String[] args) {
        // 创建账户对象
        Account act = new Account("act-001",10000);

        // 创建线程对象
        Thread myThread01 = new Thread(new AccountThread(act));
        Thread myThread02 = new Thread(new AccountThread(act));

        // 设置线程name
        myThread01.setName("t1");
        myThread02.setName("t2");

        // 开辟线程(执行run)
        myThread01.start();
        myThread02.start();
        /**
         * 注：两个线程不做线程安全处理时，同时并发的执行run()取钱。
         *     并且两个栈同时操作堆内存中的同一个对象。
         *     最后修改堆内存对象中的属性数据
         */
        /**
         * 在网络延迟后更新，两次取钱后余额都是5000，但已经取走了10000.
         */

    }

}


// 银行账户类
class Account{
    // 账号
    private String acot;
    // 余额
    private double balance;

    public Account() {
    }

    public Account(String acot, double balance) {
        this.acot = acot;
        this.balance = balance;
    }

    public String getAcot() {
        return acot;
    }

    public void setAcot(String acot) {
        this.acot = acot;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // 取款方法
    public void take(double money){
        // 取走之前余额
        double before = this.getBalance();
        // 取走之后余额
        double after = before - money;

        // 模拟一个网络延迟更新数据
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 更新余额
        this.setBalance(after);
    }
}


// 模拟两个线程
class AccountThread implements Runnable{
    // 两个线程共享一个账户对象
    private Account act;

    // 使用构造方法传递账户对象
    public AccountThread(Account act) {
        this.act = act;
    }

    @Override
    public void run() {
        // run()方法执行表示取款操作
        // 假设取款5000
        double money = 5000;

        // 取款
        act.take(money);

        System.out.println(Thread.currentThread().getName()+ "对账户" + act.getAcot() + "取款成功，余额为：" + act.getBalance());
    }
}
