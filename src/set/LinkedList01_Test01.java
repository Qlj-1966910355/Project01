package set;

// LinkedList(双向链表)

import java.util.LinkedList;
import java.util.List;

public class LinkedList01_Test01 {
    public static void main(String[] args) {

        /**
         * 单向链表数据结构：
         *      结点：分为数据域与指针域（数据域存放当前节点数据，指针域存放后继结点的地址指向其指针）
         *      头结点：链表第一个结点默认是null,可存储链表其他信息
         *      首元结点：首元结点是除去头结点外的第一个结点，存有实际数据。
         *      头指针：永远指向链表第一个结点的位置，用于指明链表的位置（若链表存在头结点，头指针指向头结点，否则指向首元结点）
         *
         *      存储：链表在存储时，是随机在内存中存储的，只是通过指针进行连接所有结点。
         *      优点：随机增删改元素效率较高（增删元素不涉及大量元素作位移）
         *      缺点：查询效率较低，每次查找元素都必须从头结点开始遍历。
         *
         * 数组与链表的区别：
         *      数组检索数据效率较高；
         *      链表增删改数据效率较高；
         *      一般添加元素都是在末尾添加，数组结构在末尾添加时，不需要位移元素，因此ArrayList使用较多。
         *
         * 双向链表：
         *      双链表的结点由三部分组成。（前驱指针域、数据域、后继指针域）
         *      前驱指针域：指向当前结点前驱结点的后继指针域
         *      后继指针域：指向当前结点后继结点的前驱指针域
         *
         */

        /**
         *  LinkedList不进行初始化容量
         *
         */

        List myList01 = new LinkedList();
        // 在链表后面添加元素<linkLast()>
        myList01.add("aaa");
        myList01.add("bbb");
        myList01.add("ccc");
        myList01.add("ddd");
        // 在链表内添加元素<linkBefore()>
        myList01.add(1,"zzz");
        // 遍历
        for (int i = 0; i < myList01.size(); i++) {
            System.out.println(myList01.get(i));
        }

    }
}
