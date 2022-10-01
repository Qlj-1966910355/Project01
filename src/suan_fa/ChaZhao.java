package suan_fa;

public class ChaZhao {
    static int j = -1;

    // 直接查找（逐个遍历直至找到）
    public static int chaZ(int num, int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                j = i;
            }
        }
        return j;
    }

    // 二分法
    public static int erFenFa(int num, int[] array) {
        int test = 0;
        // 选择排序
        for (int i = 0; i < array.length; i++) {
            int minIndix = 0;
            for (int k = i + 1; k < array.length; k++) {
                if (array[k] < array[minIndix]) {
                    minIndix = k;
                }
            }
            test = array[minIndix];
            array[minIndix] = array[i];
            array[i] = test;
        }
        // 查找
        int start = 0;
        int end = array.length -1;
        while (true){

            int mid = (start + end)/2;
            if(array[mid] == num){
                break;
            }
            else if(array[mid] > num){
                end = mid;
            }else start = mid;
            j = mid;
        }
        return j;
    }

}

