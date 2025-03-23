package org.example.day0319;

import org.example.ListNode;

/**
 * 相交链表
 * @author zhouchengliang
 */
public class SolutionIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = (pA != null) ? pA.next : headB;
            pB = (pB != null) ? pB.next : headA;
        }
        return pA;
    }
}
