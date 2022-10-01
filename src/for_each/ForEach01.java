package for_each;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * for_each（增强for循环）
 *  语法：
 *      for(元素类型 变量名 : 数组名/ 集合名 ){
 *
 *      }
 *  1、foreach直接将数组或集合中的元素取出来，括号内定义的变量就是实际元素。
 *  2、foreach不能使用数组或集合下标
 *
 */
public class ForEach01 {
    public static void main(String[] args) {
        int[] myint = new int[5];
        // 对数组插入元素
        for (int i = 0; i < myint.length; i++) {
            myint[i] = i;
        }
        // 遍历
        for (int i = 0; i < myint.length; i++) {
            System.out.println(myint[i]);
        }

        // foreach对数组遍历
        for (int data : myint
             ) {
            System.out.println("-> " + data);
        }



        // 创建集合
        List<String> myStringList = new ArrayList<>();
        // 添加元素
        myStringList.add("aaa");
        myStringList.add("bbb");
        myStringList.add("ccc");
        myStringList.add("ddd");


        System.out.println("--------------- 迭代器遍历 ---------------");
        // 迭代器遍历集合
        Iterator<String> it01 = myStringList.iterator();
        while (it01.hasNext()){
            System.out.println(it01.next());
        }


        System.out.println("--------------- for循环遍历 ---------------");

        for (int i = 0; i < myStringList.size(); i++) {
            System.out.println(myStringList.get(i));
        }


        System.out.println("--------------- foreach遍历 ---------------");

        for (String value : myStringList            // 此处只能用String类型
            ) {
            System.out.println(value);
        }
    }
}
