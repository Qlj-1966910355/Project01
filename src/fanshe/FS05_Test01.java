package fanshe;

import java.io.InputStream;

/**
 * 文件路径存储位置
 *  1、idea中，默认的相对路径的根路径是在Project项目路径内的。
 *  2、将配置文件存储在idea根路径下的缺点：移植性差。
 *      如果代码离开了idea，换到其他位置，可能当前路径就不是项目根路径了。
 *      eg:FileReader read = new FileReader("F:\\java_script\\Project01\\src\\fanshe2.properties")
 *  3、通用存放位置：配置文件存储在类路径下。
 *      类路径：src下的都是类路径(类的根路径下)。(与包同路径，或在包内，都叫src下)
 */
public class FS05_Test01 {
    public static void main(String[] args) {
        /**
         * 解释下列代码：
         *  Thread.currentThread()      // 当前线程对象
         *  getContextClassLoader()     // 线程对象的方法，可以获取当前线程的类加载器对象
         *  getResource()               // 【获取资源】类加载器对象到的方法，当前线程的类加载器默认从类的根路径下加载资源。
         *
         */

        // 获取文件的绝对路径（必须在类路径内）
        String path1 = Thread.currentThread().getContextClassLoader().getResource("fanshe2.properties").getPath();
        String path2 = Thread.currentThread().getContextClassLoader().getResource("fanshe/fanshe3.properties").getPath();

        // 升级
        InputStream path3 = Thread.currentThread().getContextClassLoader().getResourceAsStream("fanshe2.properties");

        // 打印绝对路径
        System.out.println("fanshe2文件路径：" + path1);
        // fanshe2文件路径：/D:/javascript/Project01/out/production/Project01/fanshe2.properties
        System.out.println("fanshe3文件路径：" + path2);
        // fanshe3文件路径：/D:/javascript/Project01/out/production/Project01/fanshe/fanshe3.properties
    }
}
