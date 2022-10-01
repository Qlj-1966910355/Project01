package io_flow;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志工具
 * 使用标准字节输出流PrintStream。
 */
public class Flow10_Logger {
    public static void log(String s){
        try {
            // 指定一个日志文件
            PrintStream out = new PrintStream(new FileOutputStream("log.txt",true));
            // 改变输出方向
            System.setOut(out);
            // 日期当前时间
            Date now = new Date();
            // 指定时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            // 指定格式对象
            String strtime = sdf.format(now);
            System.out.println(now + "：" + s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
