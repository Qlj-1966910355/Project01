package io_flow;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * BufferedReader
 *  带有缓冲区的字符输入流
 *  使用这个流不需要自定义char[]数组或byte[]数组。自带缓冲。
 * 构造方法：
 *      BufferedReader(Reader in)
 *      BufferedReader(Reader in, int sz)
 *      注意：两个构造方法都需要传入一个Reader类型形参，而Reader是一个抽象类，不能直接创建对象。
 *           所以，先要创建一个继承Reader抽象类的实际类。
 *
 *
 */
public class Flow06_Test01 {
    public static void main(String[] args) {
        BufferedReader bfdRt = null;
        try {
            // 创建一个实际字符输入流（继承了Reader抽象类)
            FileReader flr = new FileReader("src/io_flow/Flow01_Test01.java");
            // 将flr传入BufferedReader中
            bfdRt = new BufferedReader(flr);
            /*
                1、当一个流的构造方法需要传入一个流的时候，这个被传入的流被称为：节点流
                2、外部负责接收（包装）的这个流叫做：包装流/处理流。
             */

//            // 读取一行数据
//            String s1 = bfdRt.readLine();
//            System.out.println(s1);
//            // 读取一行数据
//            String s2 = bfdRt.readLine();
//            System.out.println(s2);
            // 注意readLine()不会读取换行，若输出使用print，则会打印在一行显示。
            // 怎样判断读取结束
                // 若读到最后一行没有字符，则返回null

            // System.out.println((char) bfdRt.read());
            // 遍历输出
            String s;
            while ((s = bfdRt.readLine()) != null){
                System.out.println(s);
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfdRt != null){
                try {
                    bfdRt.close();
                    /**
                     * 只需用关闭包装流。
                     * 为什么只关闭包装流？
                     *  调用BufferedReader流的close时，close()方法内对节点流进行了关闭处理。
                     *  源码：
                     *      if (in == null)
                     *      return;
                     *      in.close();
                     */
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
