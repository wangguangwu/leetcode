package com.wangguangwu.linkedlist;

/**
 * @author wangguangwu
 */
public class FindFromEnd {

    public ListNode findFromEnd(ListNode head, int k) {
        // 倒数第 k 个节点就是正数第 (n - k + 1) 个节点
        // 双指针
        ListNode p1 = head;
        ListNode p2 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        // p2 再走 (n - k + 1) 步
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // p2 指向第 (n - k + 1) 步，即倒数第 k 个节点
        return p2;
    }
}
