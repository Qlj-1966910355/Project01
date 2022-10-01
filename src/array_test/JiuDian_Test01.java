package array_test;
// 酒店管理系统（模拟订房、退房、打印所有房间状态等功能）

import java.util.Scanner;

/**
 * 需求：
 * 1、该系统的用户是：酒店前台
 * 2、酒店使用一个二维数组来模拟
 * 3、酒店中每一个房间应该是一个对象
 * 4、每个房间应该有：房间编号、房间类型、房间是否空闲
 * 5、系统应该对外提供的功能：
 * 可以预定房间：用户输入房间编号，订房
 * 可以退房：用户输入房间编号，退房
 * 可以查看所有房间状态：用户输入指令可以查看所有房间状态
 */
public class JiuDian_Test01 {
    public static void main(String[] args) {
        // 欢迎界面
        System.out.println("欢迎使用酒店管理系统，请认真阅读使用说明！");
        System.out.println("======================================");
        System.out.println("功能编号：\n    [1] 表示查看房间列表。\n    [2] 表示订房。\n    [3] 表示退房。\n    [0] 退出系统。");
        System.out.println("======================================");
        JiuDian hotel = new JiuDian();
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("请输入对应功能编号：");
            int k = s.nextInt();
            if (k == 1) {
                hotel.print01();
            } else if (k == 2) {
                System.out.println("请输入房间编号：");
                int roomNo = s.nextInt();
                hotel.yuDing(roomNo);
            } else if (k == 3) {
                System.out.println("请输入房间编号：");
                int roomNo = s.nextInt();
                hotel.tuiFang(roomNo);
            } else if (k == 0) {
                System.out.println("再见！欢迎下次再来！！");
                return;
            } else {
                System.out.println("您输入有误！");
            }
        }
//        // 创建酒店对象<此时构造方法建造了酒店各个房间>
//
//        JiuDian hotel = new JiuDian();
//        hotel.print01();
    }
}





