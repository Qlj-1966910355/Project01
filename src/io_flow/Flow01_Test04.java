package io_flow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputStream其他方法
 *  -> long skip(long n)    // 跳过几个字节不读
 *  -> int available()      // 返回流中剩余的没有读到的字节数量
 */
public class Flow01_Test04 {
    public static void main(String[] args) {
        // 定义全局变量
        FileInputStream file01 = null;

        try {
            // 创建对象
            file01 = new FileInputStream("aaaa.txt");
            System.out.println(file01.available());     // 总字节数为7
            // available()      // 剩余多少字节不读
            System.out.println(file01.read());      // 读取一个字节
            System.out.println(file01.available());     // 剩余6个字节未读取
            // available()方法的使用
            byte[] myByte = new byte[file01.available()];   // 直接创建一个总字节数长的byte数组
                // 注意：若file中字符较多，则不建议使用上述方法创建byte[]数组



            // skip()       // 跳过几个字节不读
            file01.skip(2);
            System.out.println(file01.read());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (file01 != null){
                try {
                    file01.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
