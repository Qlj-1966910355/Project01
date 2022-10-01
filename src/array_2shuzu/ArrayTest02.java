package array_2shuzu;

public class ArrayTest02 {
    public static void main(String[] args) {
        // 动态初始化
        int[][] aris_1 = new int[4][5];
        String[][] str_1 = new String[2][3];
        boolean[][] bool_1 = new boolean[1][2];
        int[][] aris_2 = {{1,0,0},{0,1,0},{0,0,1}};

        // 遍历二维数组(调用遍历方法)
        bl(aris_1);
        System.out.println("--------------------------");
        bl(str_1);
        System.out.println("--------------------------");
        bl(bool_1);
        System.out.println("--------------------------");
        bl(aris_2);
        System.out.println("--------------------------");
        bl(new int[][]{{1,0,0},{1,1,0},{1,1,1}});


    }
    public static void bl(int[][] aris){
        for (int i = 0; i < aris.length; i++) {
            for (int j = 0; j < aris[i].length; j++) {
                System.out.print(aris[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void bl(String[][] aris){
        for (int i = 0; i < aris.length; i++) {
            for (int j = 0; j < aris[i].length; j++) {
                System.out.print(aris[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void bl(double[][] aris){
        for (int i = 0; i < aris.length; i++) {
            for (int j = 0; j < aris[i].length; j++) {
                System.out.print(aris[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void bl(boolean[][] aris){
        for (int i = 0; i < aris.length; i++) {
            for (int j = 0; j < aris[i].length; j++) {
                System.out.print(aris[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
