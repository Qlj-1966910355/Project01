package suan_fa;

public class Test012 {
    /**
     * *************** x的平方根 ***************
     * 给定一个非负整数x，计算并返回x的算术平方根。
     * 返回类型是整数，结果只保留整数部分，小数舍去。
     * 注意：不允许使用pow()以及 x**0.5。
     */

    // 二分法
    public static int numQart1(int num) {

        int result = 0;
        int left = 0;
        int right = num;

        if(num == 1){
            return 1;
        }

        for (int i = 0; i < num; i++) {
            result = (left + right) / 2;
            int flag = num / result;
            if (result == flag || flag - result == 1) {
                break;
            } else if (flag < result) {
                right = result;
            } else if (flag > result) {
                left = result;
            }

        }
        return result;
    }


    // 牛顿迭代法
    public static int numQart2(int num) {
        double x0 = 1;      // 任意正数
        double flag = num;
        if(num == 1){
            return 1;
        }
        while (true){
            double xi = 0.5 * (x0+flag/x0);
            if(Math.abs(x0-xi)<0.001){
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }


    public static void main(String[] args) {
        int num = 6;        // 必须大于0
        System.out.println(numQart1(num));

        System.out.println(numQart2(num));


        // 使用程序检验算法
        for (int i = 1; i < 10000; i++) {
            int i1 = numQart2(i);
            int sqrt = (int)Math.sqrt(i);
            if (i1*i1 != sqrt*sqrt) {
                System.out.println(false);
            }
        }

    }

}
