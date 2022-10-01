package xiancheng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器实现(java.util.Timer)
 *      // 指定定时任务
 *      // time.schedule(定时任务,第一次执行时间,步长间隔多久执行一次);
 *
 */

/**
 * 这个程序实现从2022-04-19 21:58:00开始每5s执行一次备份操作。
 */
public class Thread10_Test01 {
    public static void main(String[] args) throws ParseException {
        // 创建定时器对象
        Timer time = new Timer();
        // 创建守护线程定时器对象
        // Timer tttt = new Timer(true);
        // 获取时间
        // 设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 字符串转换为日期格式
        Date fristTime = null;
        fristTime = sdf.parse("2022-04-19 21:58:00");

        // 创建定时任务
        /**
         * abstract class TimerTask implements Runnable{}
         * 注意:TimerTask是一个抽象类，并且继承了Runnable接口，所以必须实现抽象类。（实际就是一个线程）
         */
        // 匿名内部类实现线程类
        TimerTask timertask = new TimerTask() {
            @Override
            public void run() {
                // 编写需要执行的任务
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                // 获取系统时间并转化为字符串
                String strTime = sdf.format(new Date());
                System.out.println(strTime + "：成功执行一次数据备份");
            }
        };
        // 指定定时任务
        time.schedule(timertask,fristTime,1000*5);
    }
}
