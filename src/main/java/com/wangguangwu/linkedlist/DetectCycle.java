package com.wangguangwu.linkedlist;

/**
 * @author wangguangwu
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 说明有环
                fast = head;
                while (fast != null && slow != null) {
                    if (fast == slow) {
                        return slow;
                    }
                    fast = fast.next;
                    slow = slow.next;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(-4, null);
        ListNode node3 = new ListNode(0, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(3, node2);
        node4.next = node2;

        DetectCycle detectCycle = new DetectCycle();
        ListNode listNode = detectCycle.detectCycle(node1);
        System.out.println(listNode.val);
    }
}
