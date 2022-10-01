package suan_fa;

public class ChaZhao_Test {
    public static void main(String[] args) {
        int[] array01 = {2, 1, 46, 100, 5, 9, 23, 46, 33, 22, 8, 3, 7, 232, 4, 6};
//        Scanner s = new Scanner(System.in);
//        System.out.println("请输入想要查找的数字：");
//        int num = s.nextInt();
//
//        // 调用查找方法
//        int i = ChaZhao.chaZ(num, array01);
//        if(i == -1){
//            System.out.println("数组内不存在该数字！");
//        }else System.out.println("数字" + num + "是数组的第" + (i + 1) + "个元素");

        int num = ChaZhao.chaZ(22,array01);
        System.out.println(num);



    }

}
