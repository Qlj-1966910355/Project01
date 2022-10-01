package suan_fa;

public class Test007 {

    /**
     * ****************** 移除元素 ******************
     *  给定一个数组nums和一个值val，移除数组中所有等于val
     * 的元素，并返回新的数组长度。
     *  不允许使用额外数组空间，必须在nums内进行操作。
     */

    public static int delElement(int[] nums, int val){

        int flag = nums.length-1;

        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] == val) {
                nums[i] = nums[flag];
                flag--;
            }

        }
        return nums.length - (nums.length - flag)+1;
    }


    public static void main(String[] args) {
        int[] nums = {1,5,3,3,2,1,4,7,2,3};
        int val = 3;
        System.out.println(delElement(nums, val));
//        for (int i : delElement(nums, val)) {
//            System.out.println(i);
//        }

    }


}
