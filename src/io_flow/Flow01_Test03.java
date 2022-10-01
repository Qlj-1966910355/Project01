package io_flow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputStream字节输入流最终版
 */
public class Flow01_Test03 {
    public static void main(String[] args) {
        // 定义一个空FileInputStream类型的全局变量
        FileInputStream file01 = null;

        try {
            // 创建对象
            file01 = new FileInputStream("aaaa.txt");       // 相对路径

            // 读数据
            // 先创建一个储存数据的byte[]数组,每次读取4个字节
            byte[] myByte = new byte[4];
            // 循环读取
//            while (true){
//                // 按byte[]数组大小读取文件
//                int count = file01.read(myByte);
//                if (count == -1){
//                    break;
//                }
//                // 字节转换为字符串
//                System.out.print(new String(myByte,0,count));
//            }
            // 最简洁的循环
            int count = 0;
            while ((count = file01.read(myByte)) != -1){
                System.out.print(new String(myByte,0,count));
            }
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
