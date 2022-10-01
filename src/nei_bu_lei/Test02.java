package nei_bu_lei;

// 匿名内部类

/**
 * 匿名内部类缺点：
 *  1、太复杂，太乱，可读性差
 *  2、匿名类没有类名，不能重复使用。
 */

public class Test02 {
    public static void main(String[] args) {
        MyMath mm = new MyMath();
        // mm.mySum(new Compute01(),1,"-",9);     // 不使用匿名内部类实现接口时调用。
        // 将new Compute01()替换为匿名内部类实现
        /*
        new Compute() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        };
        */
        Compute c = new Compute() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        };


        // 匿名内部类new Compute() {}
        mm.mySum(new Compute() {
            @Override
            public int sum(int a, int b) {
                return a * b;
            }
        }, 1,"*", 2);

        /**
         * <匿名内部类></> new Compute() {} ；
         * 在mysum()方法内作为变量。此时Compute接口被new为一个变量<存放着对象内存地址></>。
         * 注：实际上是直接在方法内做了接口的实现。
         */

    }
}

// Compute接口
interface Compute{
    int sum(int a, int b);
}
/**
 * 注：接口实现了才可以使用
 */


// 实现接口Compute
//class Compute01 implements Compute{
//    public int sum(int a,int b){
//        return a - b;
//    }
//}
    // 当直接在调用时使用匿名内部类的方法进行实现接口时，不需要专门写一个实现接口的类。

// 数学计算类
class MyMath{
    public void mySum(Compute c,int x,String k,int y){
        int value = c.sum(x,y);
        System.out.println(x + k + y + "=" + value);
    }
}
