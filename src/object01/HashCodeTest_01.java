package object01;

/**
 * 源码：
 *  public native int hashCode();
 *
 * // 这个方法不是抽象方法。底层调用c++程序
 *
 * hashCode()方法返回的是哈希码：
 *      实际上就是一个java对象的内存地址，经过哈希算法，得到的一个值。<等同于一个对象的地址></>
 *
 */
public class HashCodeTest_01 {
    public static void main(String[] args) {
        // 对象1
        Object o1 = new Object();
        int hashCodeValue1 = o1.hashCode();
        // 经过哈希算法转换的一个数字，等同地址
        System.out.println(hashCodeValue1);   // 460141958

        // 对象2
        Object o2 = new Object();
        int hashCodeValue2 = o2.hashCode();
        System.out.println(hashCodeValue2); // 1163157884
    }
}
