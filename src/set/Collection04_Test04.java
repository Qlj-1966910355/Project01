package set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// remove()方法的使用
public class Collection04_Test04 {
    public static void main(String[] args) {
        //创建集合对象
        Collection set01 = new ArrayList();

        // 对集合添加数据
        set01.add(1);
        set01.add(2);
        set01.add(3);
        set01.add("a");
        set01.add("b");

        // 调用Collection中的iterator()方法
        Iterator<Object> bl = set01.iterator();

        // 遍历集合元素
        while(bl.hasNext()){
            System.out.println(bl.next());
        }

        // ---------------------------------------------------------------------
        /**
         * 怎么删除集合中的元素呢？
         * remove():
         *      1、集合对象的remove()方法；
         *      2、迭代器对象的remove()方法；
         * 使用集合对象的remove()方法删除所有元素时（将方法写在遍历循环中），运行会出现异常(java.util.ConcurrentModificationException)。
         *  原因：当集合对象的结构发生改变时，迭代器必须重新创建获取，否则会发生异常。
         *
         */

        // 创建新的迭代器
        Iterator<Object> c1 = set01.iterator();
        while(c1.hasNext()){
            Object obj = c1.next();
            // set01.remove(obj);       // 集合对象的remove()方法
            c1.remove();                // 迭代器对象的remove()方法
            // 此时删除的元素就是迭代器当前指定的元素；进而可以将集合所有元素删除

        }


        // 测试集合中是否还有元素
        Iterator<Object> c2 = set01.iterator();
        // 若集合中没有元素迭代器就没有指向的元素，不进入循环
        while (c2.hasNext()){
            System.out.println("删除后：\n" + c2.next());
        }

    }
}
