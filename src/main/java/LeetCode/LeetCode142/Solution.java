package LeetCode.LeetCode142;

import java.util.GregorianCalendar;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
//        if (head == null || head.next == null){return null;}
//        if (head == head.next){return head;}
//        ListNode fast = head;
//        ListNode slow = head;
//
//        do{
//            fast = fast.next;
//            fast = fast.next;
//            slow = slow.next;
//        }while (fast != slow && fast != null && fast.next != null);
//
//        if (fast == null){
//            return null;
//        }
//        ListNode cur = fast;
//        HashSet<ListNode> cycleE = new HashSet<>();
//        boolean flag = true;
//        while (flag){
//            boolean isDuplicated = cycleE.add(cur);
//            if (!isDuplicated){
//                flag = false;
//            }
//            cur = cur.next;
//        }
//
//        cur = head;
//
//        while (true){
//            boolean add = cycleE.add(cur);
//            if (!add){
//                return cur;
//            }
//        }
            HashSet<ListNode> visited = new HashSet<>();
            ListNode cur = head;
            while (cur != null) {
                // 如果集合里已经有这个节点了，说明它就是环的入口
                if (visited.contains(cur)) {
                    return cur;
                }
                visited.add(cur);
                cur = cur.next;
            }
            return null; // 走到 null 说明没环
    }

    public static ListNode detectCyclePlus(ListNode head){
        if (head == null || head.next == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        boolean hasCycle = false;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle){return null;}

        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
