package org.example.day0319;

import org.example.day0319.ListNode;

/**
 *
 * 检查链表是否有环
 * @author zhouchengliang
 */
public class SolutionHasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            head = head.next;
            if(fast == head){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SolutionHasCycle solution = new SolutionHasCycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;

        System.out.println(solution.hasCycle(head));
    }

}
