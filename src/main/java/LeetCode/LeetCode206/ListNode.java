package LeetCode.LeetCode206;

public class ListNode {
    int x;
    ListNode next;

    public ListNode(){

    }

    public ListNode(int x, ListNode next) {
        this.x = x;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "x=" + x +
                ", next=" + next +
                '}';
    }
}
