package set;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ******************* 集合 *******************
 * 1、集合是java中提供的一种容器，可以用来存储多个数据。实际上是一个java类库，其中提供了已经实现的数据结构。
 * 2、集合不能直接存储基本数据类型，集合也不能直接存储对象，集合中只能存储java对象的内存地址（引用数据类型）。
 * 3、基本数据类型数据存储时，会自动装箱，转换成一个引用数据类型的数据。
 * 4、在Java中，每一个不同的集合，底层对应不同的数据结构，往集合中存储元素，等于将数据放到不同的数据结构中。
 *      常见数据结构：数组、链表、二叉树、哈希表等
 *      例：new ArrayList()          创建一个数组集合
 *         new LinkedList()         创建一个链表集合
 *         new TreeSet()            创建一个二叉树集合
 * 5、集合包位置：java.util.*
 *      所有的集合类和集合接口都在java.util.*内
 * 6、集合的继承结构图
 * 7、java的集合分为两类
 *      -> 单值方式存储元素
 *          这一类集合的超级父接口：java.util.Collection
 *      -> 以键值对方式存储
 *          这一类集合的超级父接口：java.util.Map
 * 8、Collection常用方法
 *     -> boolean add(Object e)             向集合中添加元素
 *     -> int size()                        获取集合中的元素个数
 *     -> void clear()                      清空集合
 *     -> boolean contains(Object o)        判断当前集合是否包含元素o
 *     // 注：集合的底层存储的是对象的内存地址，在判断时，底层使用indexOf()中的equals()进行比较。
 *          若储存在集合中的元素是String类型，而String类型java内部已经重写了equals()方法，所以直接判断内容是否相等。
 *          若集合中储存元素是自定义的引用类型，则必须重写equals()方法，contains()方法才可以比较对象内容，否则只能比较对象的内存地址
 *
 *     -> boolean remove()                  删除集合中指定元素
 *     // 注：remove()方法与contains()方法底层都调用了equals方法，所以集合中存储的是自定义的引用类型，则需要重写equals()方法，才能正常删除元素
 *     -> boolean isEmpty()                 判断集合是否为空
 *     -> Object[] toArray()                集合转换为数组（Object[] 类型）
 *
 */
public class Collection01_Test01 {
    public static void main(String[] args) {
        // 创建集合对象
        // Collection c = new Collection();         // 接口不能直接实例化
        // 多态创建对象
        Collection c = new ArrayList();

        // Collection常用方法

        // 添加元素
        c.add(100);                 // 自动装箱     int -> Integer  (储存对象的内存地址)
        c.add(1.23);
        c.add("abc");
        c.add(true);
        c.add(new Object());


        // 获取元素个数
        int c_size = c.size();      // 集合元素个数
        System.out.println(c_size); // 5


        // 清空集合
        // c.clear();


        // 判断当前集合是否包含元素（包含返回true,不包含返回false）
        boolean pd1 = c.contains(100);      // 判断集合中包含100
        System.out.println(pd1);            // true
        boolean pd2 = c.contains("abc");
        System.out.println(pd2);            // true
        boolean pd3 = c.contains(false);
        System.out.println(pd3);            // false
        // 创建集合对象
        Collection d = new ArrayList();
        // 创建User对象
        User u1 = new User("qlj");
        User u2 = new User("zmq");      // 两个User内容相同，地址不同
        User u3 = new User("qlj");
        // 添加到d集合内
        d.add(u1);
        d.add(u2);
        // 判断自定义的对象在集合中是否包含元素u3
        System.out.println("----");
        boolean pd4 = d.contains(u3);
        System.out.println(pd4);                // false
        // 原因：保存在集合中的引用地址是User类型，比较时必须重写equals()方法
        System.out.println("---");


        // 删除指定元素
        c.remove(true);             // 删除成功
        c.remove("aaaa");           // 集合中没有字符串"aaaa"，删除失败
        System.out.println(c.size());   // 4


        // 判断集合是否为空
        System.out.println(c.isEmpty());        // false
        c.clear();
        System.out.println(c.isEmpty());        // true


        // 集合转换为数组（Object[] 类型）
        c.add(123);
        c.add("qlj");
        c.add(false);
        c.add(new Object());
        Object[] array_c = c.toArray();     // 可遍历数组查看
    }

}

class User{
    String name;
    public User(){

    }
    public User(String name){

    }

}
