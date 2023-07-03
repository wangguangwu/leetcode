package com.wangguangwu.linkedlist;

/**
 * @author wangguangwu
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头节点
        ListNode dummy = new ListNode();

        dummy.next = head;
        // 删除倒数第 n 个节点，需要先找到第 (n + 1) 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删除倒数第 n 个姐弟哪
        x.next = x.next.next;
        return dummy.next;
    }

    public ListNode findFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode listNode = solution.removeNthFromEnd(head, 2);
        System.out.println(listNode);
    }
}
