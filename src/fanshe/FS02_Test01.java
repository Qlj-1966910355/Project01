package fanshe;

/**
 * 通过反射机制获取Class，通过Class进行实例化对象(创建对象)
 *      通过Class的newInstance()方法进行实例化
 *      重点：只能调用类中的无参构造方法创建对象。必须保证无参构造方法存在。
 *
 */

public class FS02_Test01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> c = Class.forName("fanshe.User");
        // 创建对象 (注：这个方法只能通过无参构造方法进行创建对象，如果没有无参构造方法时程序报异常)
        // 返回值是泛型代替的，可以直接使用Object接收(只是编译时必须使用Object接收，实际等号右边对象是User)
        Object obj = c.newInstance();           // 高版本不用这种方式，过时。
        System.out.println("输出创建对象的内存地址:" + obj);       // fanshe.User@4554617c
    }
}

class User{
    public User() {
        System.out.println("我是User类的无参构造方法!");
    }
}
