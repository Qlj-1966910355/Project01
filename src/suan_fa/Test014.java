package suan_fa;

import suan_fa.structure.ListNode;

public class Test014 {
    /**
     * ********* 删除排序链表中的重复元素 *********
     * 给定一个已排序的链表头head，删除所有重复的元素，
     * 使每个元素只出现一次。返回已排序的链表。
     */

    public static ListNode deleteNode(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        // 构建链表
        // 头结点<链长，首元节点>
        ListNode list = new ListNode(8,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(2,
                                        new ListNode(4,
                                                new ListNode(4,
                                                        new ListNode(6,
                                                                new ListNode(7,
                                                                        new ListNode(8, null)))))))));
        ListNode resultList = deleteNode(list);
        int val = resultList.next.val;
        int val1 = resultList.next.next.val;
        int val2 = resultList.next.next.next.val;
        int val3 = resultList.next.next.next.next.val;
        int val4 = resultList.next.next.next.next.next.val;
        int val5 = resultList.next.next.next.next.next.next.val;
        // 下面取不到
//        int val6 = resultList.next.next.next.next.next.next.next.val;
//        int val7 = resultList.next.next.next.next.next.next.next.next.val;

        System.out.println("链表：" +
                val + "-->" + val1 + "-->" + val2 + "-->" + val3 + "-->" + val4 + "-->" + val5// + "-->" + val6 + "-->" + val7
        );

    }

}
