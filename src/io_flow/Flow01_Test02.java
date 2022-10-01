package io_flow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ********* 改进FileInputStream *********
 * 怎样减少内存与硬盘交互次数？
 *      使用read(byte b[n])读取文件。
 *      read(byte b[n])存储字节原理：
 *          实际读取时是将字节读到了数组内进行储存。
 *          进行读取文件时第一次将n个字节储存在byte[]内，之后每次读取都会覆盖byte[]中的元素，所以byte[]数组内元素在不断被替换。
 *          而对于最后不足byte[].lenght个字节时，读取到几个就覆盖几个，
 *          eg:
 *              文件内容：abcdef；
 *              byte[].lenght长度为4；
 *                  每次读取4个字节
 *                  第一次数组储存内容为：97,98,99,100
 *                  第二次数组储存内容为：101,102,99,100
 *      注意：
 *          1、实际读取时是将字节读到了数组内进行储存
 *          2、进行读取文件时第一次将n个字节储存在byte[]内，之后每次读取都会覆盖byte[]中的元素，所以byte[]数组内元素在不断被替换
 *          3、此时使用read返回的是读取个数；
 *          4、未读取到数据返回-1。
 * 怎样将字节转换为字符？
 *      String的构造方法：String(byte bytes[])
 *      原理：通过byte[]数组创建字符串
 *      作用：可以将byte[]内所有元素(字节)转化为字符并以字符串输出
 *      eg:
 *          byte[] myByte = {97,98,99,100};
 *          String myString = new String(myByte);
 *      注意：
 *          使用这种方式将获取到的文件字节码转换为对应字符是将数组内全部元素转换，
 *          而获取最后几个字符时，出现小于数组长度的情况，转换字符就会将未覆盖的
 *          元素也转化为字符。
 *      所以，应该必须读取多少个数据转换多少个数据。
 *
 *      String构造方法：String(byte bytes[], int offset, int length)构造方法
 *      作用：指定开始索引与结束索引，将byte[]数组内指定索引区间的元素返回为字符串。
 *      eg:
 *          byte[] myByte = {97,98,99,100};
 *          myByte = {101,102,99,100}
 *          String myString = new String(myByte,0,2);
 *          // 表示将myByte[]中索引0-2的字节转换为字符串。
 *      注意：
 *          read(byte b[])返回的恰好是读取字节数。
 *      故：
 *          String myString = new String(myByte,0,read(myByte));
 *
 *
 *
 */
public class Flow01_Test02 {
    public static void main(String[] args) {
        FileInputStream fils = null;
        try {
            // 创建FileInputStream对象
            fils =  new FileInputStream("aaaa.txt");        // 相对路径

            // 准备一个byte[]数组
            byte[] myByte = new byte[4];

            int count = fils.read(myByte);          // 读取到4个字节
            System.out.println(count);
            //将字节转换为字符串(使用String构造函数，String(byte bytes[]))
            System.out.println(new String(myByte,0,count));

            count = fils.read(myByte);              // 读取到3个字节
            System.out.println(count);
            System.out.println(new String(myByte,0,count));
            System.out.println(new String(myByte));

//            int fileRead = 0;
//            while ((fileRead = fils.read(myByte)) != -1){
//                System.out.println(fileRead);
//            }
            // 循环读取并输出展示
//            while (true){
//                int count01 = fils.read(myByte);
//                if (count01 == -1){
//                    break;
//                }
//                System.out.print(new String(myByte,0,count01));
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fils != null){
                try {
                    fils.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
