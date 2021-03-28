package 牛客删除链表中重复的结点;

//import base.ListNode;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {

        ListNode prev = new ListNode(-1);
        ListNode newHead =prev;
        prev.next = pHead;

        ListNode p1 = pHead;
        ListNode p2 = pHead.next;


        while (p2 != null) {
            if (p1.val != p2.val) {
                prev = prev.next;
                p1 = p1.next;
                p2 = p2.next;
            } else {
                // 让 p2 往后找，直到 null || p1.val != p2.val 停下
                while (p2 != null && p1.val == p2.val) {
                    p2 = p2.next;
                }

                prev.next = p2;

                p1 = p2;
                if (p2 != null) {
                    p2 = p2.next;
                }
            }
        }

        return newHead.next;
    }
}
