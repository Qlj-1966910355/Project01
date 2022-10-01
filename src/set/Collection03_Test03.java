package set;

import java.util.*;

public class Collection03_Test03 {
    public static void main(String[] args) {
        /**
         * 测试各种Collection集合的特点
         * List（ArrayList、LinkedList、Vector）  // 有序可重复，存在元素下标。
         * Set（HashSet、TreeSet）                // 无序不可重复。
         */

        // ArrayList
        // ArrayList集合底层采用了数组数据结构；它是非线程安全的。
        Collection array_List = new ArrayList();
        array_List.add(1);
        array_List.add(1);
        array_List.add(1);
        array_List.add("aa");
        array_List.add("bb");

        // 遍历
        Iterator<Object> it1 = array_List.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next());
        }

        System.out.println("-----------------------------------------------------");

        // LinkedList
        // LinkedList集合底层采用了双向链表数据结构；
        Collection linked_List = new LinkedList();
        linked_List.add("aa");
        linked_List.add("bb");
        linked_List.add("aa");
        linked_List.add(1);
        linked_List.add(11);

        // 遍历
        Iterator<Object> it2 = linked_List.iterator();
        while (it2.hasNext()){
            System.out.println(it2.next());
        }

        System.out.println("-----------------------------------------------------");

        // Vector
        // Vector集合底层采用了数组数据结构；它是线程安全的。
        //所有方法都有synchronized关键字修饰，所以线程安全，但效率较低，一般不用。
        Collection vector = new Vector();
        vector.add("aa");
        vector.add(11);
        vector.add("bb");
        vector.add(22);
        vector.add("aa");

        // 遍历
        Iterator<Object> it3 = vector.iterator();
        while (it3.hasNext()){
            System.out.println(it3.next());
        }

        System.out.println("-----------------------------------------------------");

        // HashSet
        // HashSet集合底层new了一个HashMap集合，向HashSet集合中存储元素，实际上是存储在HashMap集合key部分中了。
        // HashMap集合是一个哈希表数据结构
        Collection hash_Set = new HashSet();
        hash_Set.add(1);
        hash_Set.add(11);
        hash_Set.add(111);
        hash_Set.add(1111);
        hash_Set.add("aaaaa");
        hash_Set.add(1111);
        hash_Set.add(111);
        hash_Set.add(11);
        hash_Set.add(1);

        // 遍历
        Iterator<Object> it4 = hash_Set.iterator();
        while (it4.hasNext()){
            System.out.println(it4.next());
        }

        System.out.println("-----------------------------------------------------");

        // TreeSet
        // TreeSet集合底层实际上是TreeMap集合。往TreeSet集合存放数据时实际是往TreeMap存放。TreeMap集合采用了二叉树数据结构
        Collection tree_Set = new TreeSet();
        tree_Set.add(10);
        tree_Set.add(100);
        tree_Set.add(10);
        tree_Set.add(50);
        tree_Set.add(60);
        tree_Set.add(30);
        tree_Set.add(Integer.parseInt("11"));       // 需要将字符串转换为int类型才能比较排序

        // 遍历
        Iterator<Object> it5 = tree_Set.iterator();
        while (it5.hasNext()){
            System.out.println(it5.next());
        }


    }
}
