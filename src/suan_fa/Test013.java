package suan_fa;

public class Test013 {

    /**
     * *************** 爬楼梯 ***************
     * 假设正在爬楼梯，需要n阶才能到达楼顶。
     * 每次可以爬1或2个台阶。有多少种不同的方法可
     * 以爬到楼顶
     */
    // f(x) = f(x-1) + f(x-2)   <滚动数组思想>
    public static int climbStairs(int n) {
        int p = 0, q = 0, sum = 1;

        for (int i = 1; i <= n; i++) {
            p = q;
            q = sum;
            sum = p + q;
        }

        return sum;
    }


    public static void main(String[] args) {
        int n = 10;

//        climbStairs(2);
        for (int i = 1; i < 40; i++) {
            System.out.println(climbStairs(i));
        }

    }


}
