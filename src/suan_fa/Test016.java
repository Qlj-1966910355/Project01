package suan_fa;

import java.util.Arrays;

public class Test016 {
    /**
     * *************** 合并两个数组 ***************
     *  给定两个非递减的整数数组nums1、nums2，另有两个
     * 整数m、n，分别表示数组的元素个数。
     *  请将nums2合并到nums1中，合并后的数组依然是非递
     * 减的整数数组。
     * <注意：合并后的数组不应由函数返回，而是存储在nums1中。
     * 所以，nums1的数组长度应该为m+n，前m个元素是待合并
     * 的元素，后n个元素为0。
     * ></>
     */

    public static int[] mergeArray(int m, int n, int[] nums1, int[] nums2) {
        // 替换值
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        // 排序
        Arrays.sort(nums1);

        return nums1;
    }

    // 从后往前填充后面的0
    public static int[] mergeArray1(int m, int n, int[] nums1, int[] nums2) {

        int i = nums1.length;

        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[--i] = nums1[--m];
            } else {
                nums1[--i] = nums2[--n];
            }
        }
        return nums1;
    }


    public static void main(String[] args) {
        int m = 6;
        int[] nums1 = {1, 3, 4, 5, 7, 8, 0, 0, 0, 0};
        int n = 4;
        int[] nums2 = {0, 2, 6, 9};

        int[] ints1 = mergeArray(m, n, nums1, nums2);
        int[] ints2 = mergeArray1(m, n, nums1, nums2);

        for (int anInt : ints2) {
            System.out.println(anInt);
        }


    }
}
