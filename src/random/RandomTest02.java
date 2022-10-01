package random;

import java.util.Random;

/**
 * 编写程序，生成5个不重复的随机数，重复时重新生成
 * 保存在数组中。
 */

public class RandomTest02 {
    public static void main(String[] args) {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        Random r1 = new Random();
        int index = 0;
        while (true){
            int num = r1.nextInt(101);
            if(bl(array,num)){
                array[index] = num;
                index++;
            }else continue;
            if(index == 5){
                break;
            }

        }
        System.out.print("输出0-100长度为5的随机数组：" + "[");
        for (int k = 0; k < array.length; k++) {
            if( k == array.length-1){
                System.out.print(array[k] + "]");
            }else System.out.print(array[k] + ",");

        }
    }
    // 判断随机数字是否包含于数组内(不包含返回true)
    public static boolean bl(int[] array,int num){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == num) {
                return false;
            }
        }
        return true;
    }
}
