package array_2shuzu;
// 二维数组
    // 一维数组的每个元素也是一维数组

/**
 * 初始化
 *  1、静态初始化
 *      语法：
 *              数据类型[][] 数组名 = {{},{},……};
 *      eg：int[][] array01 = {{1,2,3},{4,5},{6,7,8},{0,9}};
 *  2、动态初始化
 *      语法：
 *              数据类型[][] 数组名 = new 数据类型[][];
 *      eg：int[][] array02 = new int[2][3];
 *
 *
 *
 */
public class ArrayTest01 {
    public static void main(String[] args) {
        // 静态初始化
        int[][] array01 = {{1,2,3},{4,5},{6,7,8},{0,9}};

        System.out.println(array01.length);           // 二维数组中有4个一维数组
        System.out.println(array01[0].length);        // 二维数组中第一个元素（一维数组）的元素个数为3
        System.out.println(array01[1].length);
        System.out.println(array01[2].length);
        System.out.println(array01[3].length);


        // 元素访问
        int[] array_1 = array01[0];
        int a0 = array_1[0];
        // 合并
        int a1 = array01[0][0];      // 第一个0表示二维数组第一个元素。第二个0表示二维数组第一个元素的第一个元素位置

        int a2 = array01[0][array01[0].length-1];

        // 修改数组元素
        array01[3][0] = 9;
        array01[3][1] = 0;


        System.out.println("-----------------------------------------------");
        // 遍历
        for (int i = 0; i < array01.length; i++) {
            System.out.println("\n第" + (i+1) + "个一维数组遍历");
            for (int j = 0; j < array01[i].length; j++) {
                System.out.print(" " + array01[i][j]);
            }
        }

    }

}
