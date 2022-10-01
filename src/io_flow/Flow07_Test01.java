package io_flow;

import java.io.*;

/**
 * BufferedWriter
 *  带有缓冲的字符输出流
 *
 */
public class Flow07_Test01 {
    public static void main(String[] args) {
        BufferedWriter write = null;
        try {

            FileOutputStream out = new FileOutputStream("aaaa.txt",true);
            OutputStreamWriter zh = new OutputStreamWriter(out);
            write = new BufferedWriter(zh);

            // 注意在输出流中给true参数，否则会替换掉所有文本
            write.write("java是世界上最好的语言，除了汉语！！！");
            write.write("\n");
            write.write(1111);

            // 刷新
            write.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(write != null){
                try {
                    write.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
