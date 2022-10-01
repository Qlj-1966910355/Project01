package suan_fa;

import suan_fa.structure.ListNode;

public class Test015 {

    /**
     * ************* 合并两个有序链表 *************
     *  将两个升序链表合并为一个新的升序链表并返回。
     *  新链表是通过拼接给定的两个链表的所有节点组成的。
     */

    public static ListNode mergeLinked(ListNode link01, ListNode link02){
        // 相当于只有头结点
        ListNode head = new ListNode(-1);
        ListNode link = head;

        while (link01 != null && link02 != null){

            if(link01.val <= link02.val){
                link.next = link01;
                link01 = link01.next;
            }else {
                link.next = link02;
                link02 = link02.next;
            }
            link = link.next;
        }
        // 有一个链表剩余部分不为空，直接将剩余插到link中即可
        link.next = link01==null ? link02 : link01;

        return head.next;
    }


    public static void main(String[] args) {
        // 头结点不进行创建,忽略
        ListNode link01 = new ListNode(1, new ListNode(4, new ListNode(7, null)));
        ListNode link02 = new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))));

        ListNode link = mergeLinked(link01, link02);

        while (link != null){
            System.out.println(link.val);
            link=link.next;

        }



    }

}
