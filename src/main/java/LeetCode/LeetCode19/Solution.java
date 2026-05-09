package LeetCode.LeetCode19;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null){
            return null;
        }

        int loc = getLen(head) - n;
        if (loc == 0){
            return head.next;
        }
        ListNode cur = head;
        for (int i = 0;i < loc - 1;i++){
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return head;
    }


    public static int getLen(ListNode head){
        if (head == null){
            return 0;
        }
        int len = 1;
        while (head.next != null){
            head = head.next;
            len++;
        }
        return len;
    }

    public ListNode removeNthFromEndPlus(ListNode head,int n){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0;i < n;i++){
            fast = fast.next;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
