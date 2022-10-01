package suan_fa;

public class Test011 {
    /**
     * ***************** 二进制求和 *****************
     *  给定两个二进制字符串a、b，以二进制字符串的形式返回
     * 它们的和。
     *  a、b、返回值：仅由字符‘0’，‘1’组成
     */

    public static String sumBin(String a, String b){
        StringBuilder sb = new StringBuilder();
        int mid = a.length() - b.length();

        // 短字符串补0
        for (int i = 0; i < (mid>0 ? mid : mid*-1); i++) {
            if(mid>0){
                b = "0" + b;
            }else {
                a = "0" + a;
            }
        }
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        int sum = 0;
        int flag = 0;
        for (int i = a.length()-1; i >= 0; i--) {
            sum = flag;
            sum += ((a.charAt(i)-'0') + (b.charAt(i)-'0'));      // 必须将char类型转换为int型<并非隐式转换为ASCII>
            sb.append(sum%2);
            flag = sum/2;
        }

        sb.append(flag==1 ? '1':"");

        return sb.reverse().toString();
    }




    public static void main(String[] args) {

        String a = "1000101";
        String b = "1011";

        System.out.println("r="+sumBin(a, b));

    }

}
