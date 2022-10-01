package fanshe;

/**
 * forName获取字节码文件内存到底发生了什么？
 *  重点：
 *      如果只是希望一个类的静态代码块执行，其他代码不执行，则可以使用forName()。
 *      因为forName()获取了对应的类文件，实际是将其加载到方法区内存中。
 *      而静态代码块就是在类加载时运行的，所以才会出现只有静态代码块执行，其他不执行的状态。
 *
 */

public class FS04_Test01 {
    public static void main(String[] args) {
        // 获取MyUser类的字节码文件
        try {
            Class.forName("fanshe.MyUser");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class MyUser{
    static {
        System.out.println("MyUser类的静态代码块执行了！");
    }
    public void mySome(){
        System.out.println("mySome()执行了！");
    }
}
