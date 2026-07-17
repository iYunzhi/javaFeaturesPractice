package Adventure.Stack.Q2;


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {

    }


    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.length() == 1){
                switch (token){
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        continue;
                    case "-":
                        Integer toSub = stack.pop();
                        stack.push(stack.pop() - toSub);
                        continue;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        continue;
                    case "/":
                        Integer toDiv = stack.pop();
                        stack.push(stack.pop() / toDiv);
                        continue;
                    default:
                        break;
                }
            }

            stack.push(Integer.parseInt(token));
        }

        return stack.pop();
    }
}
