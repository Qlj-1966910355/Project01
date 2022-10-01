package suan_fa;

import java.util.ArrayList;

public class Test001 {

    /**
     * *************** 两数之和 ***************
     *  给定一个整数数组nums和整数目标值target，在该数组中
     * 找出和为目标值target的那两个整数，并返回它们的数组下
     * 标。
     * <注意：数组中同一个元素在答案中不能重复出现></>
     */

    public static int[] twoSum(int[] nums, int target){

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (list.contains(a)) {
                int[] result = {i, list.indexOf(a)};
                System.out.println("对应值：" + nums[i] + "、" + a);
                return result;
            }

            list.add(nums[i]);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int target = 10;

        int[] s = twoSum(nums, target);

        StringBuilder str = new StringBuilder();
        str.append("索引值:[");
        for (int i = 0; i < s.length; i++) {
            str.append(s[i] + ",");
        }
        str.deleteCharAt(str.length()-1);
        str.append("]");
        System.out.println(str);

    }

}
