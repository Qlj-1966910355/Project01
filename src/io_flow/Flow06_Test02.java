package io_flow;

import java.io.*;

/**
 * 解决：当创建一个字节流(FileInputStream)作为节点流时，则传入给包装流时报错，字节流没有继承Reader抽象类。
 *  使用转换流将字节流转换为字符流。
 * 怎样使用转换流？
 *
 */
public class Flow06_Test02 {
    public static void main(String[] args) {
        BufferedReader read = null;
        try {
            // 创建FileInputStream字节流
            FileInputStream in = new FileInputStream("src/io_flow/Flow01_Test01.java");
            // 使用InputStreamReader转换流（字节流转换为字符流）
            // 此时in为节点流，zh为包装流
            InputStreamReader zh = new InputStreamReader(in);
            // 创建缓冲字符流
            // 此时zh为节点流，read为包装流
            read = new BufferedReader(zh);

            // 究极套娃
//            read = new BufferedReader(new InputStreamReader(new FileInputStream("src/io_flow/Flow01_Test01.java")));

            // 遍历读取文本文档
            String s = null;
            while((s = read.readLine()) != null){
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(read != null){
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
