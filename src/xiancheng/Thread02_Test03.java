package xiancheng;

/**
 * 两种方式创建分支栈哪个方式常用？
 *  一般采用方式二进行实现线程
 *      原因：面向接口编程
 *      因为实现接口后
 *
 */

/**
 * 匿名内部类实现方式二
 */
public class Thread02_Test03 {
    public static void main(String[] args) {
        // 匿名内部类创建Thread对象
        Thread trd = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    System.out.println("分支线程->" + i);
                }

            }
        });

        // 开辟一个分支线程
        trd.start();
        // 主线程循环
        for (int j = 0; j < 100; j++) {
            System.out.println("主线程->" + j);
        }
    }
}

