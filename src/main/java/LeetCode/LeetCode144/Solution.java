package LeetCode.LeetCode144;


public class Solution {

    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast == null) return false;
            fast = fast.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
