package fanshe;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  配置文件存储在类路径下后加载配置信息(相对类的根路径访问配置文件)
 *  // 使用流的方式加载配置信息
 *
 */
public class FS05_Test02 {
    public static void main(String[] args) {

        InputStream in = null;
        // 创建Map集合对象
        Properties pro = new Properties();

        try {
            // 采用流的方式获取配置文件信息
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream("fanshe\\fanshe3.properties");

            // 加载流
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 注意：使用流就要关闭流
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 通过key获取value
        String value = pro.getProperty("className");

        // 打印
        System.out.println(value);

    }
}
