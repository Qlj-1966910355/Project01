package suan_fa;

public class Test002 {
    /**
     * ******************* 回文数 *******************
     *  给你一个整数x，如果x是一个回文整数，返回true，否则，
     * 返回false。
     *  回文数：正序(从左向右)和倒序读都是一样的整数。
     *      eg：121 就是回文数
     */

    public static boolean huiWen1(int x){
        // 边缘数
        if(x <= 0 || x%10 == 0){
            return false;
        }

        // 反转数
        int f = 0;
        // 反转
        while (x>f){
            f = f*10 + x%10;        // 取余并计算反转数
            x/=10;
        }

        return x == f || x == f/10;
    }

    public static boolean huiWen2(int x){
        String s = String.valueOf(x);
        StringBuilder str = new StringBuilder();
        int len = s.length() - 1;
        for (int i = len; i >= 0; i--) {
            str.append(s.charAt(i));
        }

        if (str.toString().equals(s)) {
            return true;
        }
        return false;

    }


    public static void main(String[] args) {
        System.out.println(huiWen2(1213121));

    }

}
