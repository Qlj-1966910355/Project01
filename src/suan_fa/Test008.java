package suan_fa;

public class Test008 {

    /**
     * **************** 搜索插入位置 ****************
     * 给定一个排序数组和一个目标值，在数组中找到目标值，
     * 并返回其索引。如果目标值不存在于数组中，返回它将会
     * 被按顺序插入的位置。
     * 数组：nums 无重复、升序
     * 目标值：val
     * 时间复杂度：O(log n)
     */

    public static int insertInx(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == val) {
                return mid;
            } else if (val > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 7, 8};
        int val = 6;
        int index = insertInx(nums, val);
        System.out.println(index);

    }

}
