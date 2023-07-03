package com.wangguangwu.linkedlist;

/**
 * @author wangguangwu
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        // 虚拟头节点
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();

        // 辅助节点
        ListNode p = head;
        ListNode l1 = head1;
        ListNode l2 = head2;

        while (p != null) {
            if (p.val >= x) {
                l2.next = new ListNode(p.val);
                l2 = l2.next;
            } else {
                l1.next = new ListNode(p.val);
                l1 = l1.next;
            }
            p = p.next;
        }

        l1.next = head2.next;
        return head1.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(5, new ListNode(3)));
        PartitionList solution = new PartitionList();

        ListNode result = solution.partition(list, 4);
        System.out.println(result);
    }
}
