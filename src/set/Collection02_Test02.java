package set;

// 集合的遍历/迭代 Iterator

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Collection02_Test02 {
    public static void main(String[] args) {
        // 注意Iterator只能在所有的collection中通用，不能再Map中使用
        /**
         *  1、iterator是为了实现对Java容器(collection)进行遍历功能的接口
         *  2、Iterator<Object> it2 = c.iterator();
         *      -> 在使用iterator()时，实际是具体的容器对象(例：ArrayList)调用了iterator()方法。
         *      （原因：ArrayList集合实现了collection，ArrayList类中也有iterator()方法）
         *      -> iterator()方法内部new了一个Itr对象，该对象实现Iterator接口
         *      -> 所以c.iterator()实际就是创建了一个Iterator迭代器对象。
         *      -> 实现了Iterator接口后，Collection容器中的所有元素相当于一个线性表(List)，
         *         而iterator中存在指针，开始时指针指向第一个元素之前。
         *  < Collection接口中定义了返回类型为Iterator的iterator()方法 >< 源码：Iterator<E> iterator();/>
         *
         *
         */

        // 创建集合对象
        Collection c = new ArrayList();
        // 添加元素
        c.add(1);
        c.add(2);
        c.add(3);
        c.add("a");
        c.add("b");
        c.add("c");
        c.add(new Object());

        // 对集合进行遍历
        /**
         * 步骤：
         *  1、获取集合对象的迭代器对象Iterator
         *  2、通过获取的迭代器对象开始遍历集合
         *
         */

        /**
         *  创建迭代器对象
         *  原理:iterator()方法是Iterable接口的一个抽象方法，而Collection继承Iterable接口，所以Collection接口对象也可以调用
         *  iterator()方法，此时获取到了迭代器对象。
         */
        Iterator it1 = c.iterator();
        // 注意：当集合对象的结构发生改变时，迭代器必须重新创建获取，否则会发生异常。

        /**
         * Iterator接口中的方法
         *  -> hasNext()        作用：判断iterator是否还存在下一个元素，存在返回true，不存在返回false
         *  -> next()           作用：返回迭代器的下一个元素，并更新迭代器的状态(向后移动一位)
         *  -> remove()         作用：删除迭代器返回的元素（一般不用，可以使用集合的remove方法）
         */
        Object c1 = it1.next();      // 返回迭代器所指的下一个元素
        // 注：返回元素是一个元素对象的地址，将其赋给Object的变量，返回具体的对象值。
        System.out.println(c1);

        // while遍历集合元素
        Iterator<Object> it2 = c.iterator();            // 创建迭代器对象
        while (it2.hasNext()){
            System.out.println(it2.next());
        }

    }
}
