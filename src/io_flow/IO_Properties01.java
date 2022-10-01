package io_flow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *  * IO + Properties联合使用
 *  IO流：文件的读和写
 *  Properties：Map集合，key和value都是String类型
 *  作用：
 *      项目中配置文件使用。
 *  将配置文件中的数据使用io流加载到Properties集合对象内。
 *
 *  java规范：
 *      属性配置文件：key=value形式
 *      建议以.properties为后缀存储。(非必须)
 *
 *      // 配置文件中#为注释符，key与value尽可能不出现空格。
 */
public class IO_Properties01 {
    public static void main(String[] args) {
        // 创建Properties对象
        Properties prpts = new Properties();
        // 创建输入流
        FileReader fis = null;
        try {
            fis = new FileReader("peizhi");

            // 调用Properties对象的load方法，将文件数据加载到集合中
            // 等号左边为key；等号右边为value
            prpts.load(fis);

            // 获取集合中的value
            String s01 = prpts.getProperty("name");
            System.out.println("name -> " + s01);

            String s02 = prpts.getProperty("password");
            System.out.println("password -> " + s02);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
