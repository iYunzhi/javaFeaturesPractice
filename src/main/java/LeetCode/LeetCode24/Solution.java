package LeetCode.LeetCode24;

import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){
            ListNode nextNode = cur.next;
            cur.next = cur.next.next;
            nextNode.next = cur.next.next;
            cur.next.next = nextNode;
            cur = nextNode;
        }

        return dummy.next;
    }
}
