package com.wangguangwu.linkedlist;


/**
 * 删除排序链表中的重复元素
 *
 * @author wangguangwu
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));
        DeleteDuplicates solution = new DeleteDuplicates();
        ListNode result = solution.deleteDuplicates(head);
        System.out.println(result);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 断去后面的连接
        slow.next = null;
        return head;
    }
}
