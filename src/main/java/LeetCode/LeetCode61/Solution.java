package LeetCode.LeetCode61;

public class Solution {
    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        System.out.println(rotateRight(test, 1));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head.next == null || k == 0){
            return head;
        }
        ListNode cur = head;
        int n = 1;
        while (cur.next !=null){
            cur = cur.next;
            n++;
        }
        int realSteps = k % n;
        if (realSteps == 0){
            return head;
        }
        cur.next = head;

        for (int i = 0; i < n - realSteps; i++) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;

        return newHead;
    }
}
