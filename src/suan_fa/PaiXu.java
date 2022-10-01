package suan_fa;

import static suan_fa.BianLi.bianLi;          // 遍历类导入

public class PaiXu {

    int temp;       // 临时空间

    /**
     * ********************** 冒泡法 **********************
     * 原理：依次比较两个相邻的数据，将值最大的向右/向上移动交换
     */
    public void mPao(int[] array) {
        System.out.print("排序前：");
        bianLi(array);               // 调用遍历方法

        // 冒泡循环
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换位置
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.print("排序后：");
        bianLi(array);              // 调用遍历方法
    }

    /**
     * ******************** 选择排序 ********************
     * 原理：在未排序序列中直接找到的最小值/最大值，直接与未排序序列首元素交换
     */
    public void xuanZe(int[] array){
        System.out.print("排序前：");
        bianLi(array);               // 调用遍历方法
        
        for (int i = 0; i < array.length; i++) {
            int minIndix = i;
            for (int j = i + 1; j < array.length; j++) {
                /**
                 * minIndix指最小值的索引号。
                 * 解释：
                 *   比较两个值大小，小值得索引号给minIndix，j循环完后minIndix就是第i趟的最小值索引号。
                 *   j循环完后直接将最小的值与第一个值（i对应值）进行交换。（找到最小值并放在前面）
                 */
                if(array[j] < array[minIndix]){
                    minIndix = j;
                }

            }
            temp = array[i];
            array[i] = array[minIndix];
            array[minIndix] = temp;
            
        }
        System.out.print("排序后：");
        bianLi(array);              // 调用遍历方法
    }

    public void chaRu(int[] array) {
        System.out.print("排序前：");
        bianLi(array);               // 调用遍历方法

        // 插入排序循环
        for (int i = 0; i < array.length - 1; i++) {

        }
        System.out.print("排序后：");
        bianLi(array);              // 调用遍历方法
    }

}
