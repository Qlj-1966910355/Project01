package suan_fa;

public class PaiXu_Test {
    public static void main(String[] args) {
        int[] array01 = {3, 8, 14, 1, 11, 2, 9, 6, 7};
        // 创建对象
        PaiXu k = new PaiXu();

        System.out.println("----------------- 冒泡排序 -----------------");
        k.mPao(array01);

        int[] array02 = {3, 8, 14, 1, 11, 2, 9, 6, 7};
        System.out.println("----------------- 选择排序 -----------------");
        k.xuanZe(array02);

    }
}
