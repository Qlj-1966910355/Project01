package set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// 遍历Map集合
public class Map02_Test02 {
    public static void main(String[] args) {
        Map<Integer,String> dict01 = new HashMap<>();
        // 添加元素
        dict01.put(1,"qlj");
        dict01.put(2,"zmq");
        dict01.put(3,"xyq");
        dict01.put(4,"wzx");
        dict01.put(5,"xjq");
        dict01.put(6,"py");

        /**
         * ****************** 遍历Map集合 ******************
         *  方式一：
         *      获取所有的key，通过所有key访问value值
         *  方式二：(一般使用这种方式)
         *      Set<Map.Entry<K, V>> entrySet(); // 直接将键值对连接，返回一个Set类型的集合（元素类型：Map.Entry）
         *      遍历返回的Set集合
         *      Map.Entry类型：
         *          Map.Entry：Entry是Map接口下的一个内部接口(内部类)
         *      Entry内部接口内部方法：
         *          -> K getKey();      // 获取Map.Entry类型的key值
         *          -> V getValue();    // 获取Map.Entry类型的value值
         *
         */

        // 方式一
        // 获取所有key，返回Set集合
        Set<Integer> myKey = dict01.keySet();
        // 迭代器遍历
        Iterator<Integer> it01 = myKey.iterator();
        while (it01.hasNext()){
            // 取出Set集合中的key值
            Integer key = it01.next();
            // 通过取出的key值访问Map集合中的value
            String value = dict01.get(key);
            // 打印输出
            System.out.println(key + ":" + value);
        }
        // foreach遍历
        for (Integer key : myKey
             ) {
            String value = dict01.get(key);
            System.out.println(key + ":" + value);
        }
        // 不能使用for循环遍历（Set集合没有索引下标）



        // 方式二
        // entrySet()
        Set<Map.Entry<Integer,String>> mySet = dict01.entrySet();
        // 迭代器遍历1
        Iterator<Map.Entry<Integer,String>> it02 = mySet.iterator();
        while (it02.hasNext()){
            System.out.println(it02.next());
        }
        // 怎样修改key=value这种输出方式？
        // 迭代器遍历2
        Iterator<Map.Entry<Integer,String>> it03 = mySet.iterator();
        while (it03.hasNext()){
            Map.Entry<Integer,String> myMapEntry = it03.next();
            Integer key = myMapEntry.getKey();
            String value = myMapEntry.getValue();
            System.out.println(key + ":" + value);
        }
        // foreach遍历
        for ( Map.Entry<Integer,String> mapEntry : mySet
             ) {
            Integer key = mapEntry.getKey();
            String value = mapEntry.getValue();
            System.out.println(key + "-->" + value);
        }


    }
}
