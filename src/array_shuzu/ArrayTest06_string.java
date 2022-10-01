package array_shuzu;
// sort数组排序
import java.util.Arrays;

public class ArrayTest06_string {
    public static void main(String[] args) {
        int[] ars = {2, 3, 4, 8, 5, 1, 9, 7};
        System.out.print("数组遍历：[");
        for (int i = 0; i < ars.length; i++) {
            if (i == ars.length - 1) {
                System.out.print(ars[i]);
            } else System.out.print(ars[i] + ",");
        }
        System.out.println("]");

        // 排序
        Arrays.sort(ars);
        System.out.print("排序数组遍历：[");
        for (int j = 0; j < ars.length; j++) {
            if (j == ars.length - 1) {
                System.out.print(ars[j]);
            } else System.out.print(ars[j] + ",");
        }
        System.out.print("]");
    }
}
