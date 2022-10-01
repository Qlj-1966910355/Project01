package baoZhuang_Test;

// Integer类中常用的方法

public class Integer_Test02 {
    public static void main(String[] args) {
        // 初始化
        Integer num01 = new Integer(123);
        String str = "1232";

    // intValue()           -> 拆箱
        int n01 = num01.intValue();             // 返回int类型数字

    // paserInt()           -> String类型数字转换int      (静态方法:类名.调用)
        // 注：只能转换String型数字，文字、字母、符号等都不支持转换
        int n02 = Integer.parseInt(str);
        System.out.println(n02);
        System.out.println(Double.parseDouble("123"));
        // System.out.println(Integer.parseInt("abc"));        // NumberFormatException异常

    // valueOf()            -> 将int/String类型转换为Integer
        // int --> Integer
        Integer num02 = Integer.valueOf(100);
        // String --> Integer
        Integer num03 = Integer.valueOf("100");








    }
}
