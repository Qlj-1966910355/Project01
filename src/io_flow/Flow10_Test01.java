package io_flow;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 标准字节输出流
 *  PrintStream
 *      默认输出到控制台
 *
 *
 */
public class Flow10_Test01 {
    public static void main(String[] args) {
        // 联合起来写
        System.out.println("Hello World!");

        // 分开写
        // System.out返回的就是PrintStream类型的对象
        PrintStream out = System.out;
        out.println("Hello World!");
        out.println("Hello qlj!");
        out.println("Hello zmq!");
        // 标准输出流不需要关闭


        // 改变标准输出流的输出方向
        try {
            // 创建标准输出流，让其指向新建的log文件内
            PrintStream printl = new PrintStream(new FileOutputStream("log"));
            // 修改输出方向
            System.setOut(printl);
            // 输出
            System.out.println("Hello World!");
            System.out.println("Hello qlj!");
            System.out.println("Hello zmq!");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
