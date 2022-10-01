package fanshe;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 通过Class的newInstance()方法进行实例化的意义在哪里？
 *  通过反射机制灵活创建对象。
 *  eg：写一个properties类型的配置文件，将编译的字节码文件位置写入配置文件中，
 *      当修改配置文件中的字节码文件名，就可以灵活的创建不同类型的对象。
 *
 * 注：常规new进行创建对象是一个创建固定好的对象，不够灵活。
 *
 */
public class FS03_Test01 {
    public static void main(String[] args) {
        // 通过io流读取配置文件信息
        FileReader reader = null;
        try {
            reader = new FileReader("fanshe.properties");
            // 创建Map对象
            Properties p = new Properties();
            // 加载
            p.load(reader);
            // 通过key获取value
            String value = p.getProperty("className");

            // 获取配置文件中的类
            Class c = Class.forName(value);
            // 创建对象
            Object obj = c.newInstance();
            System.out.println("打印对象：" + obj); // 程序此处结束，修改配置文件的类，可以灵活创建不同类对象。
        } catch (ClassNotFoundException | IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
