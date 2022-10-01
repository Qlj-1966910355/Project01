package set;

import java.util.Properties;

public class Map03_Properties01 {
    /**
     * ************* Properties **************
     * 1、Properties是一个Map集合，继承了HashTable，它的key与value都是String类型
     * 2、Properties被称为属性类对象
     * 3、Properties主要方法：
     *      -> setProperty():添加元素           // 底层调用HashTable中的put方法
     *      -> getProperty():获取元素           // 底层调用HashTable中的set方法
     *
     */
    public static void main(String[] args) {
        // 创建Properties对象
        Properties mypro = new Properties();
        mypro.setProperty("111","111");
        mypro.setProperty("222","222");
        mypro.setProperty("333","333");
        mypro.getProperty("111");

    }
}
