package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set集合接口
 * 特点：无序不可重复（无序：存放顺序与输出顺序不同）
 *
 */
public class Set01_Test01 {
    public static void main(String[] args) {
        System.out.println("---------------- HashSet集合 ----------------");
        // HashSet集合    <无序>
        // 实际存放位置是在HashMap类型集合的key部分
        Set<String> mySet01 = new HashSet<>();
        // 添加元素
        mySet01.add("aaa1");
        mySet01.add("bbb2");
        mySet01.add("ccc3");
        mySet01.add("ddd4");
        mySet01.add("ddd4");            // 未添加到集合中
        // 遍历
        Iterator<String> it01 = mySet01.iterator();
        while (it01.hasNext()){
            System.out.println(it01.next());
        }

        System.out.println("---------------- TreeSet集合 ----------------");

        // TreeSet集合()  <自动排序>
        Set<String> mySet02 = new TreeSet<>();
        // 添加元素
        mySet02.add("111a");
        mySet02.add("333c");
        mySet02.add("222b");
        mySet02.add("222b");        // 未添加到集合中
        mySet02.add("444d");
        // 遍历
        Iterator<String> it02 = mySet02.iterator();
        while (it02.hasNext()){
            System.out.println(it02.next());
        }


    }

}
