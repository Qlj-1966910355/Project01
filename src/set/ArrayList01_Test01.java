package set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


public class ArrayList01_Test01 {
    public static void main(String[] args) {
        /**
         * ****************** ArrayList集合 ******************
         * 1、ArrayList集合底层是一个Object[]数组类型
         * 2、默认初始容量为10;（高版本在此处优化：初始化对象时，为一个空数组。当插入第一个元素时，初始化容量就变为了10）
         * 3、集合扩容：若添加元素超出容量大小，集合会进行自动扩容，扩容大小为原容量的1.5倍
         * 4、ArrayList集合的构造方法：
         *      -> new ArrayList();       // 默认容量为10
         *      -> new ArrayList(20);     // 指定容量大小
         *      -> new ArrayList(Collection<? extends E> c)     // 将其他类型的集合转化为ArrayList集合
         */
        // 无参构造方法创建对象，默认容量为10
        List list01 = new ArrayList();

        // 指定容量为20
        List list02 = new ArrayList(20);

        // 对list01添加10个元素
        list01.add(1);
        list01.add(2);
        list01.add(3);
        list01.add(4);
        list01.add(5);
        list01.add(6);
        list01.add(7);
        list01.add(8);
        list01.add(9);
        list01.add(10);

        // 查看集合元素个数
        System.out.println(list01.size());          // 10

        // 集合自动扩容（尽量在创建集合对象进行初始化容量大小，减少扩容次数）
        // 对list01再添加一个元素（集合底层进行自动扩容）
        /**
         * 源码：int newCapacity = oldCapacity + (oldCapacity >> 1);
         *  oldCapacity：表示扩容前集合容量
         *  newCapacity：表示扩容后的新容量
         *  所以进行一次扩容，相当于对原有的集合容量扩充了1.5倍。
         *
         */
        list01.add(11);

        /**
         * 最常用的集合就是ArrayList集合。
         * 原因：底层是数组，具备数组的优点
         *      检索效率高（连续地址存放元素）
         * 缺点：大数据的集合一般不采用ArrayList集合。（找不到较大连续地址的内存）
         *
         */


        // 构造方法：ArrayList(Collection<? extends E> c)
        // 创建一个HashSet集合
        Collection myHashSet = new HashSet();
        // 添加元素
        myHashSet.add("aaa");
        myHashSet.add("bbb");

        // 创建ArrayList(Collection<? extends E> c)对象
        List myList = new ArrayList(myHashSet);
        // 遍历
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }


    }
}
