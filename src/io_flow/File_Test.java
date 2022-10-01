package io_flow;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File类
 *  1、File类不能完成文件的读和写
 *  2、File对象：
 *      -> 文件和目录路径名的抽象表示形式。
 *          eg：C\User   这是一个File对象
 *              C\User\aaa.txt  这也是一个File对象
 *      -> 一个File对象可能对应的是目录，也可能对象的是文件
 *      -> File只是一个路径名的抽象表示形式
 *      -> 可以指文件夹也可以指具体文件
 *  3、File类常用方法
 *
 */
public class File_Test {
    public static void main(String[] args) {
        File f = new File("G:\\aaa");
        // 判断file对象是否存在
        boolean b = f.exists();     // 不存在aaa文件夹返回false

//        // 创建文件
//        // 判断文件是否存在
//        if(!f.exists()){
//            // 如果不存在该文件
//            try {
//                // 创建文件
//                f.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        // 创建文件夹目录
        if(!f.exists()){
            // 创建目录
            f.mkdir();
        }

        // 创建多重目录
        File f2 = new File("G:\\xxx\\a\\b\\c\\d\\");
        if(!f2.exists()){
            // 多重目录
            f2.mkdirs();
        }

        // 获取当前对象的父路径
        File f3 = new File("F:\\java_script\\Project01");
        String var = f3.getParent();
        System.out.println(var);

        // 获取绝对路径
        File f4 = new File("log.txt");
        String sss = f4.getAbsolutePath();
        System.out.println("绝对路径：" + sss);

        // 判断是否为目录
        f4.isDirectory();       // false

        // 判断是否为文件
        f4.isFile();        // true

        // 获取文件最后一次修改时间
        long l = f4.lastModified();     // 时间戳
        // 将时间戳转换为时间
        Date date01 = new Date(l);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime = sdf.format(date01);
        System.out.println(strTime);

        // 获取文件大小
        f4.length();

        // 获取当前目录下的所有子文件
        File f5 = new File("F:\\java_script\\Project01\\src");
        // 定义一个File[]数组
        File[] fileArray = f5.listFiles();
        // 注意:若当前目录没有子目录，数组为null，会出现空指针异常
        // 遍历数组
        // 避免空指针异常（处理异常）
        try {
            for (File file : fileArray){
                // 输出子文件的绝对目录
                // System.out.println(file.getAbsolutePath());
                // 输出子文件名
                System.out.println(file.getName());
            }
        }catch (Exception e){
            System.out.println("当前文件下没有子文件！");
        }


   }

}
