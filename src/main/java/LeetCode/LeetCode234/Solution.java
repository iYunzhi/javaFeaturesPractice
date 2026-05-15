package LeetCode.LeetCode234;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        ListNode reversed = reverse(head);
        int i = 0;
        while (reversed != null) {
            if (list.get(i) != reversed.val) {
                return false;
            }
            reversed = reversed.next;
            i++;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
