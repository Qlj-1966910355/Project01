package number_format;

import java.math.BigDecimal;

/**
 * ***************** BigDecimal ******************
 *  bigDecimal属于大数据，高精度。不属于基本数据类型，数据java对象（引用数据类型）
 *  一般用于财务相关数据处理中。
 *
 *
 *
 */

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal d1 = new BigDecimal(100);
        BigDecimal d2 = new BigDecimal(200);

        // 不能使用运算符计算（不是基本数据类型）

        BigDecimal d3 = d1.add(d2);     // 求和
        System.out.println("高精度数据求和：d1+d2 = " + d3);

        BigDecimal d4 = d1.divide(d2);
        System.out.println("高精度数据除法：d1/d2 = " + d4);


    }
}
