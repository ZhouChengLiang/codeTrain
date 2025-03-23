package org.example;

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

}
