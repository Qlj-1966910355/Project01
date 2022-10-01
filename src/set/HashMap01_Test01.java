package set;

// HashMap

import java.util.*;

public class HashMap01_Test01 {
    public static void main(String[] args) {
        /**
         * ************************ HashMap ************************
         *  场景：
         *      数组：查询数据效率较高（根据下标对应查询），增删数据效率较低（增删元素需要其他元素位移）
         *      链表：随机增删改元素效率较高（增删元素不涉及大量元素作位移）
         *      HashMap：查询数据且随机增删数据的效率都很高。
         *  1、HashMap实现了Map接口，用于存储key-value键值对集合，每个键值对也叫Entry;
         *  2、Map存储结构：数组+链表，结合数组与链表的优点。底层使用Entry[]键值对（jdk7使用Entry表示，jdk8使用Node）
         *      Entry[]源码：Entry(int h, K k, V v, Entry<K,V> n) {
         *                      value = v;      // value值
         *                      next = n;       // 指向下一个结点的指针
         *                      key = k;        // key值
         *                      hash = h;       // hash值
         *                  }
         *      每个结点中有4个参数：key、value、next、hash
         *  3、哈希表（散列表）：
         *      根据关键码值(key、value)直接进行访问的数据结构。
         *      也就是说：它通过把关键码值映射（哈希/散列函数）到表中的一个位置来访问记录，加快查询速度。
         *  4、哈希函数：
         *      将任意长度的输入值通过函数映射关系变成固定长度的值。这个固定长度的值就是散列值（哈希值）。
         *      哈希函数具有数学函数的映射特点。每个x只有唯一确定的y与之相对应。
         *  5、哈希值(哈希码)：
         *      通过哈希函数准换后的值。
         *      特点：哈希值的空间（区间）往往小于原集合数据空间。
         *           不同的key值通过哈希函数得到的哈希值可能相同
         *           相同的key值映射的哈希值一定相同
         *      注：HashMap中hash值通过hash()方法转换为数组下标。
         *         源码:<jdk8>
         *              static final int hash(Object key){
         *                  int h;
         *                  return (key == null) ? 0 : (h = key.hashcode()) ^ (h >>> 16);
         *              }
         *              解释：
         *                  h是hashcode计算得到的哈希码，然后使用hash()内算法得到数组下标。
         *                  h >>> 16：经哈希码进行无符号右移16位；（无符号右移：无论最高位是0还是1，左侧被移空的高位都填入0）
         *                  (h = key.hashcode()) ^ (h >>> 16)：按位异或运算
         *
         *  6、hashcode():
         *      hashcode()方法是Object类中的方法，这个方法其实是实现哈希算法得到的(未重写时，使用native修饰)。
         *                                          native：说明被修饰方法是使用C/C++实现的
         *      作用：用于返回任意key字符串/对象的哈希码值。
         *      未重写hashcode()：对象调用方法，返回一个定长的哈希码值。
         *      重写hashcode()：对象根据hashcode方法内部哈希算法进行计算得到哈希值。
         *          注：String、Integer、Boolean等类型底层已经重写hashcode()方法。
         *             其他自定义对象一般需要重写，不重写会调用Object中的hashcode
         *  7、** 重写hashcode():
         *      为什么要重写hashcode()？
         *          对象的equals()方法被重写时，相同内容的判断返回true;若没重写equals()方法，则底层使用"=="只能判断对象地址是否相等。
         *          若未重写hashcode()方法，则可能出现相同值（equals判断）不同hashcode值现象，显然是不合理的现象。
         *          key值相同时hashcode必须是相等的
         *        eg:
         *          Tem tem2 = new Tem(1,2);
         *          Tem tem3 = new Tem(1,2);
         *          tem3.hashCode();        // 30178960     重写hashcode:// 994
         *          tem2.hashCode();        // 411640028    重写hashcode:// 994
         *          tem2.equals(tem3);      // true
         *
         *  8、哈希冲突：
         *      产生原因：
         *          哈希算法将大范围的集合数据压缩到了小范围，必定会有最终的哈希值是相同的（作为数组下标的哈希值），
         *          但是真正的数组下标只对应一个value，此时出现相同的数组下标就是哈希冲突。
         *      怎样避免哈希冲突：
         *          -> 开放地址法：出现冲突后按照一定的算法查找一个空数组位存放冲突数据。
         *          -> 拉链法：将具有相同哈希地址的记录链成一个单链表。（java一般使用拉链方法）
         *          -> 公共溢出区法：将所有产生冲突的数据存放到一个溢出表内。
         *      jdk8后:HashMap冲突数据有8个以上就会使用红黑树结构存储冲突数据；当红黑树结点数小于6时，又会变成链表结构。
         *
         *  9、HashMap实现原理
         *      put():添加元素
         *          -> 将键值对封装到Node对象中（Node类实现了Map.Entry<K,V>接口）
         *          -> 底层调用key.hashcode()方法得到哈希码
         *          -> 将hash码通过hash()方法转换成数组的下标
         *          -> 当得到的索引下标处没有value，将封装的Node添加到当前下标位置；
         *             当索引位置处已经存在数据时（哈希冲突以链表解决），此时使用equals()方法与链表每个节点的key比较进行判断：
         *                      若比较key值相等时，说明当前添加的键值对key值重复，新结点覆盖之前的结点；
         *                      若比较key值不相等，说明集合中没有当前键值对，将新结点直接添加到链表尾部。
         *      get():获取元素
         *          get的原理与set基本类似
         *          如果key转化的数组下标位置没有任何数据，则返回null.
         *          如果key转化的数组下标位置存在链表，则依然使用equals进行比较key值，没有相等的key值就返回null，否则返回实际value值。
         *  10、key对象与重写后hashcode的关系（类比数学函数）
         *      -> 两个对象相等，hashcode一定相等：x值相等,y值一定相等
         *      -> 两个对象不等，hashcode不一定不等：x不等，y值可能相等
         *      -> hashcode相等，两个对象不一定相等：y值相等，x值不一定相等
         *      -> hashcode不等，两个对象一定不等：y值不等，x值一定不等
         *  11、hashcode已经将key对象转换为哈希数值，为什么还要使用hash()方法对应出下标？
         *      hashcode()返回的哈希值值域较大，使得put()添加数据后形成的哈希表空间较大，近似为一个一维数组结构，链表特性没有发挥出来。
         *      当然也不可以通过哈希算法转换后，形成了数据链较长、数组元素较少的哈希表。
         *      <散列分布不均匀>
         *
         *
         *  12、HashMap集合创建初始化容量为16，默认加载因子是0.75。
         *      官方推荐：HashMap集合初始化容量为2的幂次方（原因：为了达到散列均匀，提高集合存取效率）
         *      源码：static final int DEFAULT_INITIAL_CAPACITY = 16;
         *      加载因子：当底层集合容量填充至75%时，集合开始扩容
         *
         *  13、扩容：每次扩容以2的倍数进行扩容
         *
         *  14、重点：放在HashMap集合的key部分对象与HashSet对象必须重写hashcode()方法与equals()方法。
         *  15、HashMap集合中key与value都可以为null，但key只能有一个null。
         *      为什么为null，没有引起空指针异常？
         *          底层进行判断return (key == null) ? 0 : (h = key.hashcode()) ^ (h >>> 16);
         *          返回0，规避了空指针异常。
         *
         *
         *
         *
         *
         */
        Map<Integer,String> myMap = new HashMap<>();
        // 添加元素
        myMap.put(1,"aaa");
        myMap.put(2,"aaa");
        myMap.put(3,"ccc");
        myMap.put(4,"ddd");
        myMap.put(null,null);

        // 遍历
        Set<Map.Entry<Integer,String>> myEntry = myMap.entrySet();
        Iterator<Map.Entry<Integer,String>> it01 = myEntry.iterator();
        while (it01.hasNext()){
            Map.Entry<Integer,String> myNote = it01.next();
            System.out.print(myNote.getKey());
            System.out.println("-->" + myNote.getValue());
        }


        // 获取集合数据
        System.out.println(myMap.get(2));
        Collection myarray = new ArrayList();
        myarray.add(1);
        "sss".hashCode();

        char i = 'a';
        Object j = "a";
        int num = j.hashCode();
        System.out.println(1+i + "--" + num);


        Tem t1 = new Tem();
        // char c1 = new char['a'];
        Integer i1 = new Integer(1);
        Boolean b1 = new Boolean(false);
        System.out.println("" + t1.hashCode() + " - "+ i1.hashCode() + "-" + b1.hashCode());


        System.out.println("----------------------");
        Tem tem1 = new Tem();
        Tem tem2 = new Tem(1,2);
        Tem tem3 = new Tem(1,2);
        tem3.hashCode();
        tem2.hashCode();
        tem2.equals(tem3);

        System.out.println("tem1.hashCode():" + tem1.hashCode());
        System.out.println("tem2.hashCode():" + tem2.hashCode());
        System.out.println("tem1.equals(tem2):"+ tem1.equals(tem2));
        System.out.println("tem2.hashCode():" + tem2.hashCode());
        System.out.println("tem3.hashCode():" + tem3.hashCode());
        System.out.println("tem2.equals(tem3):"+ tem2.equals(tem3));
    }
}
class Tem{
    int a;
    int b;
    public Tem(){

    }
    public Tem(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tem tem = (Tem) o;
        return a == tem.a &&
                b == tem.b;
    }

    @Override
    public int hashCode() {

        return Objects.hash(a, b);
    }
}
