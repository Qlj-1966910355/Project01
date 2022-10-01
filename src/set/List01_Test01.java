package set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// List集合中的方法
public class List01_Test01 {
    public static void main(String[] args) {
        /**
         * ******************* List集合中的方法 ********************
         * 1、List接口下的集合特点：有序可重复，存在元素下标（存取有序）
         * 2、特有方法：
         *  -> void add(int index, Object element)
         *  -> Object get(int index)
         *  -> int indexOf(Object o)
         *  -> int lastIndexOf(Object o)
         *  -> Object remove(int index)
         *  -> Object set(int index, Object element)
         *
         */

        // 注：不能使用Collection作为引用变量，使用多态时，若用Collection父类进行引用，则不能访问子类特有的方法。

        //  创建List对象
        List myList = new ArrayList();
        // List myList = new LinkedList();
        // List myList = new Vector();


        // add()        // 向集合指定位置添加元素
        myList.add(0,"aaa");
        // 向集合末尾添加元素
        myList.add("bbb");
        myList.add("ccc");
        myList.add(111);
        myList.add(222);
        myList.add(333);
        myList.add(111);


        // get()        // 根据下标获取元素
        Object obj1 = myList.get(0);
        System.out.println(obj1);
        // 使用get()遍历数组
        System.out.println("使用get()遍历数组:\n--------------------------");
        for (int i = 0; i < myList.size(); i++) {
            Object value =  myList.get(i);
            System.out.println(value);
        }
        System.out.println("---------------------------");


        // indexOf()       // 获取指定元素第一次出现的索引位置
        int indexInt = myList.indexOf("bbb");
        System.out.println(indexInt);


        // lastIndexOf()    // 获取指定元素最后出现的索引位置
        int lastIndexInt = myList.lastIndexOf("bbb");
        System.out.println(lastIndexInt);


        // remove()         // 删除集合指定位置/指定元素的值（尽量不使用指定元素删除）
        myList.remove("111");           // 若指定元素是数值，则会将数值默认删除的是指定索引位置的元素
        // 此时删除元素是字符串111，集合中未检测到字符串111，删除失败
        // 遍历集合查看剩余元素
        Iterator it1 = myList.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next());
        }
        System.out.println("-------------------------");
        // 删除指定索引位置的元素
        myList.remove(3);
        Iterator it2 = myList.iterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
        }
        System.out.println("--------------------------");


        // set()            // 修改指定位置元素
        myList.set(3,111);
        myList.set(4,222);
        myList.set(5,333);
        Iterator it3 = myList.iterator();
        while (it3.hasNext()){
            System.out.println(it3.next());
        }


    }
}
