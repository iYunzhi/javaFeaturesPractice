package LeetCode.LeetCode394;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
    }
    public String decodeString(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<StringBuilder> charStack = new LinkedList<>();
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            } else if (c == 91){
                numStack.push(num);
                charStack.push(sb);
                num = 0;
                sb = new StringBuilder();
            }else if (c == 93){
                StringBuilder temp = new StringBuilder();
                int times = numStack.pop();
                for (int j = 0; j < times; j++) {
                    temp.append(sb);
                }
                sb = charStack.pop().append(temp);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
