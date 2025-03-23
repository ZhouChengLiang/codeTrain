package org.example;

/**
 * K 个一组翻转链表
 * @author zhouchengliang
 */
public class SolutionReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode protect = new ListNode(0,head);
        ListNode last = protect;
        while (head != null) {
            // 1 分组(往后走k-1步 ，找到一组)
            //    一组的开头head 结尾end
            ListNode end = getEnd(head, k);
            if (end != null) {
                break;
            }
            ListNode nextGroupHead = end.next;
            // 2 一组内部(head到end之间)要反转(调用反转链表)
            reverseList(head, nextGroupHead);
            // 3 更新每组跟前一组、后一组之间的边
            last.next = end;
            head.next = nextGroupHead;

            last = head;
            head = nextGroupHead;
        }
        return protect.next;
    }

    // 返回走k-1步之后的结点
    // 返回null 表示不够K个
    ListNode getEnd(ListNode head,int k) {
        while (head != null ) {
            k--;
            if (k == 0) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    // 反转从head 到 end 之间内部的边
    // 反转链表 在结点stop停止
    void reverseList(ListNode head,ListNode stop) {
        ListNode last = head;
        head = head.next;
        while (head != stop) {
            ListNode nexHead = head.next;
            head.next = last;
            last = head;
            head = nexHead;
        }
    }
}
