package io_flow;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * *************** FileOutputStream ***************
 * 1、构造方法
 *  -> new FileOutputStream("aaaa.txt");
 *      // 这种方式会将源文件的内容清空，然后再重新写入
 *
 *  -> new FileOutputStream("aaaa.txt",true);
 *      // 这种方式会在文档末尾处写入，不会清空原内容
 *
 */
public class Flow02_Test01 {
    public static void main(String[] args) {
        FileOutputStream file_out = null;
        try {
            // 创建输出流对象
            file_out = new FileOutputStream("aaaa.txt",true);
            // 写
            byte[] myByte = {100,101,102,103,104};      // 代表ASCII码，写入后转换为对应字符
            file_out.write(myByte);

            // 写入字符串
            String s = "我喜欢学习Java!";
            // 将字符串转换为byte[]数组
            byte[] s_byte = s.getBytes();
            file_out.write(s_byte);

            // 写完后必须刷新
            file_out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
