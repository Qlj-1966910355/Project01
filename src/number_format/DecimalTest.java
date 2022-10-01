package number_format;

import java.text.DecimalFormat;

/**
 * 数字格式
 *  #       // 代表任意数字
 *  ,       // 代表千分位
 *  .       // 代表小数点
 *  0       // 代表不够时补0
 *
 *      eg：###,###.##        // 表示加入千分位且保留两位小数
 */

public class DecimalTest {
    public static void main(String[] args) {
        DecimalFormat format01 = new DecimalFormat("###,###.##");
        String s_num1 = format01.format(12345.8254);
        System.out.println("数字格式化：" + s_num1);

        DecimalFormat format02 = new DecimalFormat("###,###.000");
        String s_num2 = format02.format(12345.82);
        System.out.println("数字格式化：" + s_num2);
    }
}
