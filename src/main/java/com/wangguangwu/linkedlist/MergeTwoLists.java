package com.wangguangwu.linkedlist;

/**
 * leetcode: <a href="https://leetcode.cn/problems/merge-two-sorted-lists/"/>
 * <p>
 * 虚拟头节点
 *
 * @author wangguangwu
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
            // p 节点不断前进
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

    public static void main(String[] args) {
        MergeTwoLists solution = new MergeTwoLists();

        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode result = solution.mergeTwoLists(list1, list2);
        System.out.println(result);
    }
}
