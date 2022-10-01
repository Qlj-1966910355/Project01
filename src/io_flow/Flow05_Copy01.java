package io_flow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 使用FileReader与FileWriter拷贝文本文件
 * 注：只能拷贝普通文本文件(能用记事本编辑的都是普通文本文件)
 *
 */
public class Flow05_Copy01 {
    public static void main(String[] args) {
        FileReader fir = null;
        FileWriter fiw = null;
        try {
            // 创建输入流
            fir = new FileReader("aaaa.txt");
            // 创建输出流
            fiw = new FileWriter("dddd.txt");

            char[] chr = new char[4];       // 最多1M(1024*1024)
            int count = 0;
            while ((count = fir.read(chr)) != -1){
                // 将储存在char[]中的字符写进dddd.txt文件中
                fiw.write(chr,0,count);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fir != null){
                try {
                    fir.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fiw != null){
                try {
                    fiw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
