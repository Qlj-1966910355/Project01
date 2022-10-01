package array_shuzu;

// 动态初始化数组并遍历
public class ArrayTest02 {
    public static void main(String[] args) {
        // 声明一个静态初始化数组
        int[] array0 = {1, 2, 3, 4, 5, 6};
        int[] a= new int[]{1,2};
        printArray(array0);
        printArray(new int[]{1,2});

        // 声明一个动态初始化数组
        int[] array1 = new int[10];
        String[] array2 = new String[10];

        // 调用遍历函数输出
        printArray(array2);            // String类型默认赋值为null
        printArray(new float[2]);
        printArray(new boolean[2]);

    }

    // String[]类型数组遍历函数
    public static void printArray(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("遍历数组输出：" + a[i]);
        }

    }
    // int[]类型数组遍历函数
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("遍历数组输出：" + a[i]);
        }

    }
    // boolean[]类型数组遍历函数
    public static void printArray(boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("遍历数组输出：" + a[i]);
        }

    }
    // float[]类型数组遍历函数
    public static void printArray(float[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("遍历数组输出：" + a[i]);
        }

    }

}
