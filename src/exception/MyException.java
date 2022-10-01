package exception;

/**
 * 自定义异常
 * 步骤：1、编写一个类并继承Exception或者RuntimeException
 *      2、提供两个构造方法，一个无参，一个带有String参数的构造方法
 * 自定义异常在实际开发中的应用（重点）
 *  1、创建异常类
 *  2、在编程时，出现异常状况，使用throw new 异常名(“异常信息”) 语法进行手动上抛异常
 *  3、在调用具体方法时，处理异常，直接使用try……catch及exception.getMessage()方法打印简单异常信息。
 */
public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String e) {
        super(e);
    }

}
