package io_flow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ****************** FileReader（字符输入流） ******************
 * 1、只能读取普通文本
 * 2、读取文本内容时，比较方便、快捷
 * 3、read()方法重载：
 *      -> read()
 *      -> read(char[] cbuf)
 *      -> read(char[] cbuf, int off, int len)
 *
 * ****************** FileWriter（字符输入流） ******************
 * 1、文本字符输出流。写
 * 2、只能输出普通文本
 * 3、write()方法重载：
 *      -> write(int c)
 *      -> write(char cbuf[])
 *      -> write(String str)
 *      -> write(String str, int off, int len)
 *
 *
 *
 */
public class Flow04_Test01 {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {

            /**
             * 读取普通文本
             */
            // 创建字符输入流对象
            fileReader = new FileReader("aaaa.txt");
            // char[]类型数组储存字符集
            char[] str01 = new char[4];
            // 定义一个储存读取个数的变量
            int count = 0;
            // 循环读取
            while ((count = fileReader.read(str01)) != -1){
                System.out.print(new String(str01,0,count));
            }


            /**
             * 写入
             */
            fileWriter = new FileWriter("aaaa.txt",true);
            String s = "我爱学习Python!";
            fileWriter.write(s);

            // 新建文本并写入
            fileWriter =new FileWriter("ccc.txt",true);
            char[] chr = {'a','b','c','d','e'};
            fileWriter.write(chr);

            fileWriter.write(111);          // 111指的是ASCII值

            // 刷新
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
