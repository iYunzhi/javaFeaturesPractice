package LeetCode.LeetCode237;

public class Main {
    public static void main(String[] args) {
        ListNode Node1 = new ListNode(4);
        ListNode Node2 = new ListNode(5);
        ListNode Node3 = new ListNode(1);
        ListNode Node4 = new ListNode(9);
        Node1.next=Node2; Node2.next =Node3; Node3.next=Node4;

        deleteNode(Node2);

        System.out.println(Node1.next.val);
        System.out.println(Node1.next.next.val);

    }

    public static void deleteNode(ListNode node) {
        while (node.next != null){
            node.val = node.next.val;
            if (node.next.next == null){
                node.next=null;
                break;
            }
            //head = [4,5,1,9], node = 5
            // [4,1,1,9] -> [4,1,9,9]
            node=node.next;
        }
    }
}
