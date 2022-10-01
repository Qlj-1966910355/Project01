package io_flow;

import java.io.*;

/**
 * *************** 拷贝目录 ***************
 *  将某个文件夹拷贝到另一个文件
 *  eg:
 *      F:\abcd ----> G:\xxx
 */
public class Test01_Eg {
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
            // 文件拷贝
            CopyFile.copyFile(in,out);
            return;
        }

        // 获取目标子目录
        File[] sonFile = in.listFiles();
        // 查看子目录数
        // System.out.println(sonFile.length);
        for (int file = 0; file < sonFile.length; file++) {
            // sonFile[file]文件绝对路径
            String s = sonFile[file].getAbsolutePath();
            // System.out.println(s);
            // 如果是目录，在目标目录下创建目录
            if(sonFile[file].isDirectory()){
                // 目标地址绝对路径 + \ + 截取sonFile[file]路径
                String path = out.getAbsolutePath() + "\\" + sonFile[file].getAbsolutePath().substring(3);
//                System.out.println(path);
                File newFile = new File(path);
                if(!newFile.exists()){
                    newFile.mkdirs();
                }
            }

            // 递归
            copyFile(sonFile[file],out);
        }
    }
}

/**
 *  拷贝文件
 */
class CopyFile{
    public static void copyFile(File in, File out){
        FileInputStream inFile = null;
        FileOutputStream outFile = null;
        try {
            // 创建FileInputStream输入流对象
            inFile = new FileInputStream(in);
            // 创建
            String path = out.getAbsolutePath() + "\\" + in.getAbsolutePath().substring(3);
            outFile = new FileOutputStream(path);
            // 一边读一边写
            byte[] myByte = new byte[1024 * 500];
            int count = 0;
            while ((count = inFile.read(myByte)) != -1){
                outFile.write(myByte,0,count);

            }
            // 刷新
            outFile.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inFile != null){
                try {
                    inFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outFile != null){
                try {
                    outFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

