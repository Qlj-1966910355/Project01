package a01_jichu;

public class BianLiang {
    static int i = 10;      //成员变量（静态变量）

    public static void main(String[] args)      // 主方法入口
    {
        //int x = 5;         // 局部变量（只能在方法内使用）
        int y;
        y = i + x;         // 若去掉int x = 5,则输出30.
        System.out.println(y);
    }

    static int x = 20;         //成员变量

    public static void Some()                  //Some方法（不能进入）
    {
        int y;
        y = i + x;
        System.out.println(y);
    }
}