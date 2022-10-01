package xiancheng;

/**
 ** 怎样解决线程安全问题?
 *      线程同步机制语法：
 *          synchronized(对象){
 *              // 线程代码块
 *          }
 ** java怎样实现同步(排队)机制?
 *      在java中，每一个对象都有一个"锁"，这个锁其实是一个标记。
 *
 *      排队执行原理：
 *          -> 假设t1与t2线程并发，开始执行代码时，抢夺时间片，会有先后顺序；
 *          -> 假设t1线程执行到synchronized代码块时，先到的自动找到‘共享对象’的对象锁，然后占有对象锁(标记被占用)，
 *             当t2线程抢到时间片也执行到synchronized代码块时，发现共享对象被占有，此时t2只能等待。
 *          -> t1执行完代码块中的程序后，归还对象锁。此时t2得到共享对象锁再执行synchronized代码块中的程序。
 *          -> 这样就达到了排队执行的效果。
 *
 *          重点：小括号内的对象必须是需要排队的线程所共享的对象。<内存中不仅仅只有账户对象是共享对象，还有其他一些对象也会被共享>
 *
 ** 深入理解synchronized。
 *      1、在账户类中分别创建一个实例变量和一个局部变量，synchronized小括号中分别写两个对象
 *          -> 实例变量可以实现线程同步
 *              原因：创建的obj是一个在账户类中的实例变量，实例变量存储在堆内存中，堆内存只有一个，
 *                   所以对象唯一且是两个线程都使用的共享对象，即可以实现线程同步。
 *          -> 局部变量不可以实现线程同步
 *              原因：局部变量存储在栈内存中，每个栈中都会有一个相对应的局部变量，是不同的对象，而一个线程就是一个栈。
 *                   所以这儿局部变量不共享
 *      2、在账户类中创建一个储存在常量池中的字符串局部变量，将对象传入synchronized小括号中。
 *          可以实现线程同步。
 *          原因：虽然该字符串是局部变量，但确定的字符串被存储在字符串常量池中，并不是在栈中存储，
 *               所以不同的栈执行程序中用到的字符串对象并没有区别，即实现线程同步。
 *      3、空指针不可以实现线程同步
 *
 *      注意：
 *          以上三点在本例中可以使用的原因是：
 *                  由于t1与t2两个线程都需要线程排队执行，所以可以在账户类中写实例变量和常量池变量作为共享对象。
 *
 *                  若重新创建一个账户对象
 *                              Acct act02 = new Acct("act-002",10000);
 *                                      增加一个t3线程。
 *                  t3线程并没有处理t1与t2共享的对象，而是对act02对象进行账户操作了。所以t3线程不需要进行线程同步。
 *                  此时如果使用实例变量与常量池常量作为共享对象，那么t3线程就会进行线程同步，所以这两个作为共享对象就不合理了。
 *                  即，synchronized中一般是填入this。本例中this指act对象。若添加t3线程，则this指act02对象，t3线程不和t1、t2
 *                      进行排队，它会单独拿到自己处理的act02对象的锁执行代码块。(this不是通用的，需要注意synchronized代码块
 *                                                                           所在的位置，位置变了this不一定就是共享对象了)
 *      故：小括号内共享对象需要看线程的具体共享对象是谁，它是变化的。
 *
 *
 ** java三大变量
 *      实例变量：在堆内存存储
 *      静态变量：在方法区内存存储
 *      局部变量：在栈内存存储
 *
 *      局部变量永远都不存在线程安全问题<局部变量不共享，一个栈一个线程>
 *
 ** synchronized代码块包括的代码越多，程序执行效率就会越低。<需要排队执行代码>
 *
 ** synchronized还可以直接在定义方法上作为关键字写<在实例方法上使用></>；
 *      例：
 *          public synchronized void take(double money){
 *              // 代码块
 *          }
 *      注：
 *          缺点：此时的共享对象就是this，这种方法不灵活。
 *          优点：代码量少。
 *      当共享对象就是this，并且需要同步的代码块是整个方法体，推荐使用这种方式线程同步
 *
 ** StringBuffer与StringBuilder使用：
 *      作用：字符串拼接
 *          -> StringBuffer是线程安全的
 *          -> StringBuilder是非线程安全的
 *      注：当字符串变量是局部变量时，直接使用StringBuilder，因为局部变量不会出现线程安全问题，执行效率高。
 *
 ** 开发中怎样避免和使用线程安全问题？
 *      1、尽量使用局部变量代替"实例变量"与"静态变量"；
 *      2、如果必须使用实例变量，则考虑创建多个对象，这样实例变量内存就不会共享。
 *      3、如果不能使用局部变量代替，对象也不能创建多个，这时再使用synchronized，线程同步机制。
 *
 * 总结：
 *      synchronized三种方法：
 *      -> 同步代码块<灵活>
 *          语法：
 *              synchronized(){
 *                  // 同步代码块
 *              }
 *      -> 在实例方法上当做关键字使用
 *          语法：
 *              public synchronized void take(double money){
 *              // 代码块
 *          }
 *          // 共享对象一定是this。并且同步代码块是整个方法
 *      -> 在静态方法上使用<保证静态变量安全></>
 *          表示类锁，不是对象锁了
 *          类锁只有一个
 *          就算创建100个对象，只会有1个类锁。
 *
 *
 */

/**
 * 模拟银行取钱案例
 * (使用线程同步机制<排队执行>)
 */
public class Thread07_Test02 {
    public static void main(String[] args) {
        // 创建账户对象
        Acct act = new Acct("act-001",10000);

        // 创建线程对象
        // 两个线程共享一个act对象(同时都要处理一个对象)
        Thread myThread01 = new Thread(new ActThread(act));
        Thread myThread02 = new Thread(new ActThread(act));

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
class Acct{
    // 账号
    private String acot;
    // 余额
    private double balance;

    // 测试对象
    Object obj = new Object();

    public Acct() {
    }

    public Acct(String acot, double balance) {
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
        // 测试对象
        Object o = new Object();

        // 这个方法必须是线程排队执行的，不能并发执行(一个线程全部执行结束，下一个才可以执行)
        /**
         * 线程同步机制语法：
         *      synchronized(对象){
         *          // 线程代码块
         *      }
         *
         * **** 重点：
         *          小括号内参数：哪些线程需要线程同步就将线程共享的对象写进去。<本例程序中共享的对象是账户对象this>
         *          eg:
         *              假设存在t1、t2、t3、t4、t5这5个线程，只希望t1、t2、t3进行同步排队，另外两个不需要同步。
         *              在小括号内写t1、t2、t3共享的对象。
         *
         */
        // 同步代码块
        synchronized (this){
            double before = this.getBalance();
            double after = before - money;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
        }
    }
}


// 模拟两个线程
class ActThread implements Runnable{
    // 两个线程共享一个账户对象
    private Acct act;
    // 使用构造方法传递账户对象
    public ActThread(Acct act) {
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
