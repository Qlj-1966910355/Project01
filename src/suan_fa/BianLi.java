package suan_fa;

public class BianLi {
    // 遍历方法
    public static void bianLi(int[] array) {

        System.out.print("[");
        for (int j = 0; j < array.length; j++) {
            if (j == array.length - 1) {
                System.out.print(array[j]);
            } else System.out.print(array[j] + ",");
        }
        System.out.print("]\n");
    }
}
