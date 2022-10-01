package set;

import java.util.*;
import java.util.Map.Entry;

// TreeSet与TreeMap
public class TreeMap_Set01 {
    public static void main(String[] args) {
        /**
         * **************** TreeMap ****************
         * 1、TreeSet集合底层实际是一个TreeMap
         * 2、TreeMap集合底层是一个二叉树(左小右大)
         *      二叉树遍历方式
         *          -> 前序遍历（根左右）
         *          -> 中序遍历（左根右）
         *          -> 后序遍历（左右根）
         *      注：前、中、后说的是根的位置
         *      -> Iterator迭代器遍历TreeSet采用的是中序遍历
         * 3、放在TreeSet集合中的元素，等同于放到TreeMap集合key部分了
         * 4、TreeSet集合中的元素：无序不可重复，但是可以按照元素的大小顺序自动排序
         * 5、TreeSet对自定义类型的数据不能排序。（需要自己写排序器comparator）
         *
         *
         *
         *
         */
        // 创建TreeSet对象
        TreeSet<String> mytree01 = new TreeSet<>();
        mytree01.add("1");
        mytree01.add("2");
        mytree01.add("11");
        mytree01.add("3");
        mytree01.add("aa");
        mytree01.add("ab");
        mytree01.add("ba");
        mytree01.add("bc");

        // 遍历TreeSet    (自动排序)
        Iterator<String> it01 = mytree01.iterator();
        while (it01.hasNext()){
            System.out.println(it01.next());
        }



        // 创建TreeMap对象
        Map<Integer,String> mymap01 = new TreeMap<>();
        mymap01.put(1,"111");
        mymap01.put(2,"aaa");
        mymap01.put(3,"aab");
        mymap01.put(4,"222");
        mymap01.put(5,"112");
        try {
            mymap01.put(null,null);
        }catch (NullPointerException e){
            // e.printStackTrace();
            System.out.println("出现错误！");
        }


        // 将Map集合转换为Set集合
        Set<Entry<Integer,String>> myset = mymap01.entrySet();
        // 迭代器遍历
        Iterator<Entry<Integer, String>> it02 = myset.iterator();
        while (it02.hasNext()){
            Entry<Integer,String> myit02 = it02.next();
            // Entry内部接口内部方法：
            Integer mykey = myit02.getKey();
            String myvalue = myit02.getValue();
            System.out.println(mykey + ":" + myvalue);
        }

    }

}
