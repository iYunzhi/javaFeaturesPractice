package LeetCode.LeetCode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));

        Solution solution = new Solution();
        System.out.println(solution.addTwoNumbers(l1, l2).toString());
    }






    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        List<Integer> res = new ArrayList<>();
        int carry = 0;
        while (cur1 != null && cur2 != null){
            int curVal = cur1.val + cur2.val;
            if (carry > 0){
                carry--;
                curVal++;
            }

            if (curVal >= 10){
                carry++;
                curVal = curVal % 10;
            }
            res.add(curVal);
            cur1 = cur1.next;
            cur2 =cur2.next;
        }

        while (cur1 != null){
            int curVal = cur1.val;
            if (carry > 0){
                carry--;
                curVal++;
            }

            if (curVal >= 10){
                carry++;
                curVal = curVal % 10;
            }

            res.add(curVal);
            cur1 = cur1.next;
        }

        while (cur2 != null){
            int curVal = cur2.val;
            if (carry > 0){
                carry--;
                curVal++;
            }

            if (curVal >= 10){
                carry++;
                curVal = curVal % 10;
            }
            res.add(curVal);
            cur2 = cur2.next;
        }

        Collections.reverse(res);
        ListNode dummy = new ListNode(-1);
        res.forEach((integer -> {
            ListNode curNode = new ListNode(integer);
            curNode.next = dummy.next;
            dummy.next = curNode;
        }));

        if (carry != 0){
            ListNode cur = dummy;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new ListNode(carry);
        }


        return dummy.next;
    }
}
