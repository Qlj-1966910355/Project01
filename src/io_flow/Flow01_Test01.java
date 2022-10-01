package io_flow;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * **************** IO流 ****************
 * 1、什么是IO流
 *  I：Input;    O：Output
 *  通过IO完成硬盘文件的读和写
 * 2、IO流分类
 *  -> 按照流的方向分类
 *      输入流：往内存中去，叫做输入/读
 *      输出流：从内存中出，叫做输出/写
 *  -> 按照读取数据方式分类
 *      字节流：按照字节的方式读取数据，一次读取1个字节byte，等同于一次读取8个二进制，这种流不管什么类型的数据都可以读取。
 *      字符流：按照字符的方式读取数据，一次读取一个字符，这种流为了方便文本文件存在的，只能读取纯文本文件，连word文件都无法读取。
 * 3、java中的IO流（四大家族）
 *      java.io.InputStream     字节输入流
 *      java.io.OutputStream    字节输出流
 *
 *      java.io.Reader          字符输入流
 *      java.io.Writer          字符输出流
 *      注：
 *          -> Stream结尾是字节流，Reader与Write结尾是字符流。
 *          -> 上述IO流都是抽象类。
 *          -> 所有流都实现了java.io.Closeable接口，都是可以关闭的，都有close()方法。（每次需要关闭流通道）
 *          -> 所有的输出流都实现了java.io.Flushable接口，都是可刷新的，都有Flush()方法。（将通道内还未输出的数据强行输出，清空通道）
 *             如果没有flush,则可能会出现数据丢失。
 *  注:在java中只要“类名”以Stream结尾的都是字节流。以Reader/Writer结尾的都是字符流
 *
 * 4、java.io包下需要掌握的16个流：
 *      文件专属：
 *          java.io.FileInputStream         // 字节输入流，万能的，任何类型的文件都可以采用这种流来读
 *          java.io.FileOutputStream
 *          java.io.FileReader              // 只能读取普通文本
 *          java.io.FileWriter
 *
 *      转换流：（将字节流转换为字符流）
 *          java.io.InputStreamReader
 *          java.io.OutputStreamWriter
 *
 *      缓冲流专属：（不需要创建缓冲数组，自带缓冲）
 *          java.io.BufferedReader
 *          java.io.BufferedWriter
 *          java.io.BufferedInputStream
 *          java.io.BufferedOutputStream
 *
 *      数据流专属：（将数据连同数据类型一并写入文件）
 *          java.io.DateInputStream
 *          java.io.DateOutputStream
 *
 *      标准流专属：
 *          java.io.PrintWriter
 *          java.io.PrintStream
 *
 *      对象流专属：
 *          java.io.ObjectInputStream
 *          java.io.ObjectOutputStream
 *
 */
public class Flow01_Test01 {
    /**
     * *********** FileInputStream ***********
     *  1、字节输入流，万能的，任何类型的文件都可以采用这种流来读
     *  2、字节方式，完成输入的操作，完成读的操作（硬盘到内存）
     *  read()缺点：
     *      只能一次读取一个字节，内存与硬盘交互太频繁，时间与资源耗费较大。
     *  怎样减少内存与硬盘交互次数？
     *      使用read(byte b[])读取文件。   // 每次返回
     *
     */
    public static void main(String[] args) {
        // 定义储存流对象的全局变量（finally内close流时需要用到流对象）
        FileInputStream fils = null;

        try {
            // 创建文件字节输入流对象
            fils = new FileInputStream("F:\\file_qlj\\abcd.txt");

            // 读数据
            // read()               // 从此输入流读取一个数据字节，返回下一个数据字节，如果已经到达文件末尾，则返回-1。
            int readFile = fils.read();
            System.out.println(readFile);       // 49
            // 循环读取文件内所有数据
//            while (true){
//                int fileRead = fils.read();
//                if (fileRead == -1){
//                    break;
//                }
//                System.out.println(fileRead);
//            }

            // 改进循环
            int fileRead = 0;
            while ((fileRead = fils.read()) != -1){
                System.out.println(fileRead);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 确保流一定关闭（避免空指针异常）
            if (fils != null){
                try {
                    fils.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
