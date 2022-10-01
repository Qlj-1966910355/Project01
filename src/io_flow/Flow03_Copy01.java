package io_flow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用FileInputStream + FileOutputStream完成文件的拷贝
 * 拷贝时是一边读一边写的
 * 上述拷贝方式不管什么类型文件都可以拷贝
 *
 */
public class Flow03_Copy01 {
    public static void main(String[] args) {
        FileInputStream file_in = null;
        FileOutputStream file_out = null;
        try {
            // 创建输入流
            file_in = new FileInputStream("aaaa.txt");
            // 创建输出流
            file_out = new FileOutputStream("bbbb.txt",true);
            // 一边读，一边写
            byte[] myByte = new byte[4];
            // 重点
            // 读
            int count = 0;
            while ((count = file_in.read(myByte)) != -1){
                // 读多少写多少，count表示读取字节数
                // 写
                file_out.write(myByte,0,count);
            }

            // 刷新
            file_out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (file_in != null){
                try {
                    file_in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (file_out != null){
                try {
                    file_out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
