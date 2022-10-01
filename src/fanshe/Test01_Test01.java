package fanshe;

/**
 * 扩展知识：可变长参数
 *  语法：
 *      方法(数据类型... 变量名){
 *
 *      }
 *  1、形参为可变长参数，在调用时可以传入任意多个实参。
 *  2、可变长参数在形参列表中只能定义一个，且必须是最后一个形参。
 *  3、可变长参数可以当做数组看待，可像数组一样遍历输出，也可直接传入数组。
 *
 */
public class Test01_Test01 {
    public static void main(String[] args) {
        // 调用m1方法
        m1(1,2,3,4,5,6);

        // 调用m2方法
        m2(1,"aa","bb","cc");

        // 调用m3方法
        m3(1,new String[]{"aa","bb","cc"});
        String[] str = {"aaa","bbb"};
        m3(2,str);
    }


    public static void m1(int... arg){
        System.out.println("m1方法执行!");

    }

    public static void m2(int num, String... str){
        System.out.println("m2方法执行!");
    }

    public static void m3(double db, String... str){
        // 遍历数组
        for (String var:str
             ) {
            System.out.println(var);
        }
        System.out.println("m3方法执行");

    }

}
