package set;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTable01_Test01 {
    public static void main(String[] args) {
        /**
         * *********** HashTable ***********
         * 1、HashTable的key与value不可以为null，HashMap可以为空。
         * 2、HashTable与HashMap一样底层也是哈希表
         * 3、HashTable扩容是原容量的2倍再加1。
         * 4、HashTable方法线程安全的，但是一般不用
         */
        // 创建Hashtable对象
        Map<String,String> myTable = new Hashtable<>();
        myTable.put("1","1");
        myTable.put("2","1");
        myTable.put("3","1");
        // myTable.put(null,"1");      // java.lang.NullPointerException空指针异常
        // myTable.put("4",null);          // java.lang.NullPointerException空指针异常(底层抛出异常)
        // myTable.put(null,"null");       // java.lang.NullPointerException空指针异常

        // 将集合元素转换为Set集合
        Set<Map.Entry<String,String>> myset = myTable.entrySet();
        // 遍历
        Iterator<Map.Entry<String,String>> it01 = myset.iterator();
        while (it01.hasNext()){
            System.out.println(it01.next());
        }

    }
}
