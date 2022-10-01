package exception;

/**
 * **************** finally使用 ****************
 * 1、finally中的代码块是一定会执行的，即使try语句块中代码存在异常，也可以执行。
 * 2、finally是必须与try一起使用的。(也可以不使用catch添加finally)
 * 3、使用场景
 *      通常在finally语句块中完成资源的释放/关闭
 *      （原因：finally中的代码一定执行，即使try语句块出现异常，finally也可以保证资源的释放/关闭）
 * 4、退出jvm后，finally就不会执行。（在try中编写System.exit(0);）
 */
public class ExceptionTest02 {
    public static void main(String[] args) {

        try {
            System.out.println("try……");
            return;
        } catch (Exception e) {
            System.out.println("程序报错！");
        } finally {
            System.out.println("一定会执行！");
        }


        try {
            System.out.println("start……");
        } finally {
            System.out.println("end!!!");
        }
    }
}
