package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 异常处理
 *  概述：程序执行过程中的不正常情况
 *  作用：增强程序的健壮性
 * 异常在java中的存在形式
 *  异常是以类的方式存在的，每个异常类都可以创建异常对象。
 *  （在程序执行过程中，若程序某行出现异常，JVM会创建一个异常对象，并且JVM将new出来的对象抛出，打印到输出信息中）
 * 异常类继承结构
 *  Object --> Throwable --> Error(错误) --> 各种错误类
 *                           Exception（异常）--> ExceptionSubClass（Exception类的直接子类，编译时异常）--> 各种异常子类
 *                                           --> RuntimeException(运行异常)--> 各种异常子类
 *                                          编译时异常：表示必须在编写程序的时候预先堆这种异常进行处理，如果不处理，编译器报错
 *  所有的错误或者异常都可以抛出。错误只要发生，java就会终止程序执行。
 * 处理异常方法：
 *  1、在方法声明的位置上，使用throws关键字（抛给上一级<调用者></>）
 *      throws后面写异常的类名，也可写其异常的父类名，或多个异常类名。
 *    throw，手动抛出异常！语法：throw new 异常名(“异常信息”);（抛出异常对象）
 *     注：手动抛出异常后，该方法的方法名后也需要用throws抛出异常。
 *  2、使用try……catch进行异常捕捉（解决异常）
 *  注：1、只要异常没有捕捉，采用上报方式，此方法的后续代码不执行
 *      try语句块中某一行出现异常，该行后面的代码不执行；try……catch捕捉异常后，后续代码可以执行。
 *     2、catch可以写多个，但必须从小到大，前面的catch不能包括下面的catch异常内容。
 *     3、jdk8以上，catch可以写“|”，表示或。
 *
 * 一般只有希望调用者处理异常，才使用throws。
 *
 * 异常对象常用方法：
 *  1、获取异常简单的描述信息（实际是构造方法的参数信息，即，实参内容）
 *      String msg = exception对象.getMessage();
 *  2、打印异常追踪的堆栈信息（常用于catch内使用，查看异常追踪信息）
 *      exception对象.printStackTrace();
 *
 * 注意：
 *  在方法重写（覆盖）时
 *      子类重写的方法不能比父类重写前的方法抛出更多的异常，可以更少！
 *    例：父类抛出Exception异常，子类可以抛出Exception异常或Exception类的子类异常
 *       父类抛出ArithmeticException异常，子类就不可以抛出Exception异常，只能抛出ArithmeticException异常或ArithmeticException类的子类异常
 */

public class ExceptionTest01 {
    public static void main(String[] args) {

        try{
            System.out.println(100/0);          // ArithmeticException异常(运行时异常)
        }catch (Exception a){
            System.out.println("执行错误！");
        }

        // 调用m1()方法
        // m1();       // 报错原因：调用m1方法时方法将异常信息上抛，所以出现编译报错

        // 使用 try……catch
        try {
            m1();
        }
         catch (FileNotFoundException e) {          // catch后可以写FileNotFoundException的父类
            e.printStackTrace();                    // 打印异常追踪的堆栈信息
        }

    }
   private static void m1() throws FileNotFoundException{
        new FileInputStream("C:\\Users\\Administrator\\Desktop\\任务.txt");
        // // 编译报错原因（FileInputStream方法后面跟着一个throws关键字，上抛了FileNotFoundException异常）
        System.out.println(100/1);
    }
}
