package date;
// ************** 时间戳 **************
/**
 * 简单总结System类常用相关属性方法
 *  1、System.out                    // out是System类的静态变量
 *  2、System.out.println()          // println()方法不是System类中的方法，是PrintStream类的方法
 *  3、System.gc()                   // 建议启动垃圾回收器
 *  4、System.currentTimeMillis()    // 获取1970-1-1 00:00:00 000 到目前时间的总毫秒数
 *  5、System.exit(0)                // 退出JVM
 */

public class ShiJianChuo_Test02 {
    public static void main(String[] args) {
        // 时间戳
        long time01 = System.currentTimeMillis();
        System.out.println("1970-1-1 00:00:00 000 到目前时间的总毫秒数：" + time01);

        // 统计程序运行时长
        long start = System.currentTimeMillis();
        eg();
        long end = System.currentTimeMillis();
        System.out.println("方法eg()执行耗时：" + (end - start) + "毫秒");
            
        }
        public static void eg(){
            for (int i = 0; i < 1000000000; i++) {
                i = i + 2;
            }
        }
    }

