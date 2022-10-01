package io_flow;

import java.io.File;

public class Test01_Eg02 {
    public static void main(String[] args) {
        // 拷贝源
        File in = new File("F:\\abcd");
        // 拷贝目标
        File out = new File("G:\\xxx");
        // 调用拷贝方法
        copyFile(in,out);


    }
    public static void copyFile(File in, File out){
        if(in.isFile()){

            return;
        }

        // 获取目标子目录
        File[] sonFile = in.listFiles();
        for (int file = 0; file < sonFile.length; file++) {
            // 输出子文件名
            String s = sonFile[file].getAbsolutePath();
            System.out.println(s);
            // 递归
            copyFile(sonFile[file],out);

        }

    }
}
