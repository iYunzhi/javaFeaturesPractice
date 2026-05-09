package LeetCode.LeetCode946;

import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
       int[] pushed = {1,2,3,4,5}, popped = {4,3,5,1,2};
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for (int k : pushed) {
            stack.push(k);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        System.out.println(stack);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
