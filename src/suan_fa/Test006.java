package suan_fa;

public class Test006 {
    /**
     * ************** 删除有序数组中的重复项 **************
     *  给定一个升序的数组nums，请<必须原地删除></>删除重复出现的
     * 元素，使每个元素只出现一次，返回删除后数组的新长度。元素的
     * 相对顺序应该保持一致。
     *  java中数组指定长度后，不能改变数组长度，将结果去重的数据放在
     * nums的前面。
     */

    // 双指针实现
    public static int deleteArray(int[] nums){

        // 指针
        int a = 0;      // 标记重复(最终数组非重复数据量)

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) {
                // 交换
                a++;
                nums[a] = nums[i];
            }
        }
        return a+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,4,4,5,6};

        int count = deleteArray(nums);

    }


}
