package suan_fa;

public class Test010 {

    /**
     * ************************ 加一 ************************
     * 给定一个整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位，数组中每个元素只存储单个数字。
     * 可以假设除了整数0之外，这个整数不会以零开头。
     */


    public static int[] addOne(int[] nums) {

        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] != 9) {
                nums[i] += 1;
                return nums;
            } else {
                nums[i] = 0;
            }
        }

        nums = new int[nums.length+1];
        nums[0] = 1;

        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {9,9,1,9};
        int[] ints = addOne(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
