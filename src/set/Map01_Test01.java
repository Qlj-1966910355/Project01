package set;

import java.util.*;

/**
 * ****************** Map ******************
 * 1、Map集合以key和value的方式存储（键值对）
 * 2、key与value都是引用数据类型，存储对象的内存地址
 * 3、Map接口的常用方法：
 *      -> V put(K key, V value);                   // 向Map集合中添加键值对
 *      -> V get(Object key);                       // 通过key获取value
 *      -> int size();                              // 获取集合键值对个数
 *      -> boolean isEmpty();                       // 判断Map集合中元素个数是否为0
 *      -> boolean containsKey(Object key);         // 判断集合是否包含指定key值
 *      -> boolean containsValue(Object value);     // 判断集合是否包含指定value值
 *      -> V remove(Object key);                    // 通过key值删除键值对
 *      -> void clear();                            // 清空Map集合
 *      -> Set<K> keySet();                         // 获取Map集合中所有key值（返回Set类型集合）
 *      -> Collection<V> values();                  // 获取Map集合中所有value值（返回Collection类型集合）
 *      -> Set<Map.Entry<K, V>> entrySet();         // 将Map转换为Set集合
 *          // entrySet是将key值与value值用“=”连接，作为一个Set集合元素
 *
 *
 */
public class Map01_Test01 {
    public static void main(String[] args) {
        Map<Integer,String> dict01 = new HashMap<>();
        // put()        添加键值对元素
        dict01.put(1,"qlj");            // key此时自动装箱
        dict01.put(2,"zmq");
        dict01.put(3,"xyq");
        dict01.put(4,"wzx");
        dict01.put(5,"xjq");
        dict01.put(6,"py");

        // get()        // 通过key获取value值
        dict01.get(3);      // 获取key = 3的value值

        // size()       // 获取集合键值对个数
        dict01.size();      // 6

        // isEmpty()        // 判断集合中元素个数是否为0
        dict01.isEmpty();       // false

        // containsKey()        // 判断是否包含指定key值
        dict01.containsKey(6);      // true

        // containsValue()      // 判断是否包含指定value值
        dict01.containsValue("py");     // true

        // remove()         // 通过key值删除键值对
        dict01.remove(2);       // 可以返回删除的value值

        // keySet()         // 获取Map集合中所有key值（返回Set类型集合）
        Set<Integer> mySet01 = dict01.keySet();         // 返回Set类型对象
        // 遍历
        Iterator<Integer> it01 = mySet01.iterator();
        while (it01.hasNext()){
            System.out.println(it01.next());
        }

        // valueSet()       // 获取Map集合中所有value值（返回Collection类型集合）
        Collection<String> myList = dict01.values();
        // 遍历
        Iterator<String> it02 = myList.iterator();
        while (it02.hasNext()){
            System.out.println(it02.next());
        }

        // Set<Map.Entry<K, V>> entrySet();         // 将Map转换为Set集合
        Set<Map.Entry<Integer,String>> mySet02 = dict01.entrySet();
        // 遍历
        Iterator<Map.Entry<Integer,String>> it03 = mySet02.iterator();
        while (it03.hasNext()){
            System.out.println(it03.next());
        }


    }
}
