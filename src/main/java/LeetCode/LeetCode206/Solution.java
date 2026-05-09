package LeetCode.LeetCode206;

public class Solution {
    public static void main(String[] args) {
        ListNode x4 = new ListNode();
        ListNode x3 = new ListNode(8, x4);
        ListNode x2 = new ListNode(6, x3);
        ListNode x1 = new ListNode(4, x2);
        ListNode x = new ListNode(2,x1);
        System.out.println(x);
        System.out.println(reverse(x));
    }

    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
