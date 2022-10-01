package set;

import java.util.*;

/**
 * 1、ArrayList集合变为线程安全
 *  Collections.synchronizedList(myList);
 * 2、List集合排序方法
 *  Collections.sort(myList);
 *  注：若myList是一个纯数值集合，则可以直接使用sort排序；
 *     若myList是一个自定义类对象组成的集合，则不能直接使用sort排序，和TreeMap一样需要写比较器
 *
 *
 */
public class Set02_Other {
    public static void main(String[] args) {
        // 对List集合排序（存储数值时）

        // 创建ArrayList对象（不是线程安全的）
        List<String> myList = new ArrayList<>();

        //  变成线程安全的
        Collections.synchronizedList(myList);
        // 插值
        myList.add("aaa");
        myList.add("abb");
        myList.add("abc");
        myList.add("aba");
        myList.add("aab");
        myList.add("aac");
        // 排序
        Collections.sort(myList);
        // 遍历
        Iterator<String> it01 = myList.iterator();
        while (it01.hasNext()){
            System.out.println(it01.next());
        }



        // 对List集合排序（存储自定义对象时）
        List<Pig> listPig = new ArrayList<>();
        listPig.add(new Pig(11));
        listPig.add(new Pig(9));
        listPig.add(new Pig(12));
        listPig.add(new Pig(6));
        listPig.add(new Pig(19));

        // 排序
        Collections.sort(listPig);
        for (Pig pig : listPig){
            System.out.println(pig);
        }
    }
}

// 定义猪类，并让其实现Comparable接口，重写compareTo()方法
class Pig implements Comparable<Pig>{
    int age;

    public Pig(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Pig o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "age=" + age +
                '}';
    }
}




