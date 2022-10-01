package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Test01 {
    public static void main(String[] args) throws Exception{
        // 创建日期对象，默认获取系统时间
        Date date01 = new Date();
        System.out.println("1、获取系统时间：" + date01);       // Date中重写了toString()方法

        // 格式化日期输出
        // SimpleDateFormat类，专门用于日期格式化的类

        /**
         * yyyy     年
         * MM       月
         * dd       日
         * HH       时
         * mm       分
         * ss       秒
         * SSS      毫秒
         */

        // 格式化输出日期（返回一个String类型日期）
        // Date --> String
        SimpleDateFormat format01 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");  // 指定格式对象
        String s_date = format01.format(date01);      // 将日期修改为创建的日期格式，返回String类型日期
        System.out.println("2、格式化输出日期：" + s_date);

        // String --> Date
        String s_date02 = "2022-03-04 23:23:23 212";
        SimpleDateFormat format02 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");// 必须与字符串的日期类型一致
        Date date02 = format02.parse(s_date02);
        System.out.println("3、String --> Date：" + date02);


    }



}
