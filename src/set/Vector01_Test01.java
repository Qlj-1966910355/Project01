package set;

import java.util.*;

// Vector(底层：数组)
public class Vector01_Test01 {
    public static void main(String[] args) {
        /**
         * ********************* Vector集合 *********************
         * 1、Vector集合底层是数组结构
         * 2、初始化容量：10
         * 3、扩容：
         *      源码：在grow()方法中：newCapacity = oldCapacity + ((capacityIncrement > 0) ?capacityIncrement : oldCapacity)
         *      capacityIncrement：创建对象时Vector构造函数内输入一个实际参数，表示扩容的增量。
         *      oldCapacity：表示原Vector集合容量大小。
         *      解释源码：如果在创建Vector对象时，指定了扩容增量，则每次自动扩容就按照增量进行扩容；否则就将原容量加一倍。
         * 4、Vector集合是线程安全的。
         *
         */
        List myVector = new Vector();
        myVector.size();        // 0
        myVector.add("111");
        myVector.add("222");
        myVector.add("333");
        myVector.add("444");
        myVector.add("555");
        myVector.add("666");
        myVector.add("777");
        myVector.add("888");
        myVector.add("999");
        myVector.add("000");
        // 此时集合容量已满，再add元素就会自动扩容。
        myVector.add("111");

        // 构造函数
        /**
         * 1、public Vector()
         * 2、public Vector(int initialCapacity) // 指定初始容量
         * 3、public Vector(int initialCapacity, int capacityIncrement)      // 指定初始容量、扩容增量
         */


        // ArrayLst集合是非线程安全的
        List myArray = new ArrayList();         // 非线程安全

        // 线程安全化
        Collections.synchronizedList(myArray);      // 此时再使用myArray对象就是线程安全的




    }
}
