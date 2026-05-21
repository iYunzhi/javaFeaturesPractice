package LeetCode.LeetCode21;

class dSolution {

    public static void main(String[] args) {
        ListNode list1_2 = new ListNode(4);
        ListNode list1_1 = new ListNode(2,list1_2);
        ListNode list1 = new ListNode(1,list1_1);

        ListNode list2_2 = new ListNode(4);
        ListNode list2_1 = new ListNode(3,list2_2);
        ListNode list2 = new ListNode(1,list2_1);

        ListNode merged = mergeTwoLists(list1, list2);

        while (merged != null){
            System.out.println(merged.val);
            merged = merged.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy =new ListNode(-1);

        ListNode cur = dummy;

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                cur.next = list1;
                list1=list1.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null){
            cur.next = list1;
        } else if (list2 != null){
            cur.next = list2;
        }

        return dummy.next;
    }
}