package baoZhuang_Test;

/**
 * ************* String,int,Integer互相转换 *************
 */

public class Integer_Test03 {
    public static void main(String[] args) {

        // int --> String
        String str01 = String.valueOf(134);
        System.out.println("int --> String：" + str01);

        // String --> int
        int int01 = Integer.parseInt("123");
        System.out.println("String --> int：" + int01);

        // String --> Integer
        Integer num01 = Integer.valueOf("123");
        System.out.println("String --> Integer：" + num01);

        // Integer --> String
        String str02 = String.valueOf(num01);
        System.out.println("Integer --> String：" + str02);

        // int --> Integer
        Integer num02 = 123;        // 自动装箱
        System.out.println("自动装箱int --> Integer：" + num02);
        Integer num03 = Integer.valueOf(123);
        System.out.println("手动装箱int --> Integer：" + num03);

        // Integer --> int
        int int02 = num01;      // 自动拆箱
        System.out.println("自动拆箱Integer --> int：" + int02);
        int int03 = num01.intValue();       // 手动拆箱
        System.out.println("手动拆箱Integer --> int：" + int03);


    }

}
