package com.wangguangwu.linkedlist;

/**
 * @author wangguangwu
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return lists[0];
        }

        ListNode begin = lists[0];

        for (int i = 1; i < length; i++) {
            begin = mergeLists(begin, lists[i]);
        }
        return begin;
    }

    public ListNode mergeLists(ListNode list1, ListNode list2) {
        // 虚拟头节点
        ListNode head = new ListNode();

        // 辅助节点
        ListNode p = head;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }

        if (l1 == null) {
            p.next = l2;
        }
        if (l2 == null) {
            p.next = l1;
        }

        return head.next;
    }
}
