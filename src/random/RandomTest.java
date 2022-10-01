package random;

// 生成随机数

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        int num01 = random.nextInt();           // 随机产生int类型范围内的数字
        System.out.println("输出int类型的随机数：" + num01);

        int num02 = random.nextInt(101);    // 随机生成[0,101)的int类型数据
        System.out.println("" + num02);

    }
}
